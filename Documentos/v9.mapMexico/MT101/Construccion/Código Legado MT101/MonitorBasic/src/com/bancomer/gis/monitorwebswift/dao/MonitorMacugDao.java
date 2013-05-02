package com.bancomer.gis.monitorwebswift.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import com.bancomer.gis.monitorwebswift.db.DataBase;
import com.bancomer.gis.monitorwebswift.vo.BlobRegistry;
import com.bancomer.gis.monitorwebswift.vo.ProcessFilesVo;
import com.bancomer.gis.monitorwebswift.vo.SwiftDetailVo;

public class MonitorMacugDao extends GeneralDAO {

	public MonitorMacugDao(int switchConnection) throws Exception {
		super(switchConnection);
	}
	
	public ArrayList getProcessFiles(String date, int country) throws Exception{
		ArrayList processFiles = new ArrayList();
		HashMap mapa = new HashMap();
		try {
			String query = DataBase.getQuery("monitorMacugIn");
			if(country>0) query += " and ctarch.CD_PAIS=?";
			
			query += " and  to_char(TM_proceso,'dd-mm-YYYY') = ? ";
			query += "  order by 5 desc";
			ps = con.prepareStatement(query);
			if(country>0){ 
				ps.setInt(1, 3);
				ps.setString(2, date);
			}
			else{
				ps.setString(1, date);
			}
			rs = ps.executeQuery();
			while(rs.next()){
				ProcessFilesVo file = new ProcessFilesVo();
				file.setNu_consecutivo(rs.getInt(1));
				file.setNu_id_tipo_arch(rs.getInt(2));
				file.setNu_estatus_archivo(rs.getInt(3));
				if(
				   rs.getString(5).substring(0, 4).equalsIgnoreCase("ACUS") ||
				   rs.getString(5).substring(0, 4).equalsIgnoreCase("APLI") ||
				   rs.getString(5).substring(0, 4).equalsIgnoreCase("APLP") ||
				   rs.getString(5).substring(0, 4).equalsIgnoreCase("VALI") ||
				   rs.getString(5).substring(0, 4).equalsIgnoreCase("SALI")  )
				{}
				else{
					String nameAux = null;
					if(rs.getString(5).length()>20)  nameAux = rs.getString(5).substring(0,20);
					else nameAux = rs.getString(5);
					file.setNb_arch_procesado(nameAux);
					file.setFullName(rs.getString(4));
					file.setFh_proceso(rs.getTimestamp(6));
					file.setCd_bic_origen(rs.getString(8));
					file.setNu_pais(rs.getInt(9));
					file.setNb_pais(rs.getString(10));
					/*file.setNb_estatus_archivo(rs.getString(8));
					file.setNb_masc_archivo(rs.getString(11));
					file.setNu_tipo_srvswift(rs.getInt(12));
					file.setNu_pais(rs.getInt(13));
					file.setNu_tipo_servicio(rs.getInt(14));
					file.setNb_pais(rs.getString(15));
					file.setNb_srvswift(rs.getString(16));
					file.setNb_tipo_servicio(rs.getString(17));*/
					processFiles.add(file);
					mapa.put(file.getFullName(), file);
				}
			}
			Collection values = mapa.values();
			ArrayList array = new ArrayList(values);
			processFiles = null;
			processFiles = array;
			Collections.sort(array);
		} catch (Exception e) {
			throw new Exception("Error al obtener archivos procesados macug: "+e.getMessage(),e);
		}finally{
			closeAll(new Object[]{ps,rs,con});
		}
		return processFiles;
	}
	
	public ArrayList getSwiftDetails(int id) throws Exception{
		ArrayList processFiles = new ArrayList();
		try {
			ps = con.prepareStatement(DataBase.getQuery("getSwiftDetails"));
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				processFiles.add(new SwiftDetailVo(
					rs.getInt(1),
					rs.getInt(2),
					rs.getInt(3),
					rs.getInt(4),
					rs.getString(5),
					rs.getString(6),
					rs.getString(7),
					rs.getString(8),
					rs.getInt(9),
					rs.getTimestamp(10),
					rs.getTimestamp(11),
					rs.getTimestamp(12)
				 ));
			}
		}
		catch (Exception e) {
			throw new Exception("Error al obtener detalle swift: "+e.getMessage(),e);
		}finally{
			closeAll(new Object[]{ps,rs,con});
		}
		return processFiles;
	}
	
	public String getGeneratedFiles( int id, String fecha) throws Exception{
		try{
			ps = con.prepareStatement(DataBase.getQuery("getGeneratedFiles"));
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getString(2);
			}else return "";
		}catch (Exception e) {
			throw new Exception("Error al obtener los archivos procesados "+e.getMessage());
		}finally{
			closeAll(new Object[]{ps,rs,con});
		}
	}
	
	public ArrayList getMasterBlog(String cliente, String filterDateStart, String filterDateEnd, String flujo, String nombreArchivo , int ... filterInts ) throws Exception{
		ArrayList<ProcessFilesVo> registers = new ArrayList<ProcessFilesVo>();
		HashMap mapa = new HashMap();
		String query = DataBase.getQuery("getLogFiles");
		String nbPais = "";
		
		if(filterInts[0]==1) filterInts[0]=0;
		
		if(flujo.equals("0")) flujo = null;
		
		if(flujo != null) 
			query += " flujo.TP_ENT_SAL_BBVA = ? and";
		
		if(filterInts[0] != 0)
			query += " srv.CD_TP_CANAL = ? and ";
		
		if (filterInts[1]!=0) {
			ps = con.prepareStatement(DataBase.getQuery("getPaisXCDPais"));
			ps.setInt(1, filterInts[1]);
			rs = ps.executeQuery();
			while (rs.next()){
				nbPais = rs.getString(1);
			}
			query += " UPPER(btarch.CD_PAIS)   = UPPER(?) and ";
		}
		if (nombreArchivo != null && !nombreArchivo.equals("")){
			query += " UPPER(btarch.NB_ARCH_PROCESADO) like '%" + nombreArchivo + "%' and ";
		}
		
        
		if(filterDateStart != null && filterDateEnd !=null){
			if(filterDateStart.equals(filterDateEnd)){
				query += " TM_PROCESO between to_date(?,'dd-mm-YYYY') and to_date(?,'dd-mm-YYYY')+1 order by FECHA DESC, CD_ARCH_PROCESADO DESC";
			}
			else{
				query += " TM_PROCESO between to_date(?,'dd-mm-YYYY') and to_date(?,'dd-mm-YYYY')+1 order by FECHA DESC, CD_ARCH_PROCESADO DESC";

			}
		}
		else{
			query += " TM_proceso >= to_date(to_char(sysdate,'dd-mm-YYYY'),'dd-mm-YYYY') order by FECHA DESC, CD_ARCH_PROCESADO DESC";
		}					
		try{
			ps = con.prepareStatement(query);
			if(flujo != null && filterInts[0]>0 && filterInts[1]>0){
				ps.setString(1, flujo);
				ps.setInt(2, filterInts[0]);
				ps.setString(3, nbPais);
				if(filterDateStart != null && filterDateEnd !=null){
					ps.setString(4, filterDateStart);
					ps.setString(5, filterDateEnd);
					
				}
			}
			if(flujo != null && filterInts[0]>0 && filterInts[1]<=0){
				ps.setString(1, flujo);
				ps.setInt(2, filterInts[0]);
				if(filterDateStart != null && filterDateEnd !=null){
					
					ps.setString(3, filterDateStart);
					ps.setString(4, filterDateEnd);
					
				}
			}
			if(flujo != null && filterInts[0]<=0 && filterInts[1]>0){
				ps.setString(1, flujo);
				ps.setString(2, nbPais);
				if(filterDateStart != null && filterDateEnd !=null){
					
					ps.setString(3, filterDateStart);
					ps.setString(4, filterDateEnd);
					
				}
			}
			if(flujo!=null && filterInts[0]<=0 && filterInts[1]<=0){
				ps.setString(1, flujo);
				if(filterDateStart != null && filterDateEnd !=null){
				
					ps.setString(2, filterDateStart);
					ps.setString(3, filterDateEnd);
				
				}
			}
			if(flujo == null && filterInts[0]>0 && filterInts[1]>0){
				ps.setInt(1, filterInts[0]);
				ps.setString(2, nbPais);
				if(filterDateStart != null && filterDateEnd !=null){
				
					ps.setString(3, filterDateStart);
					ps.setString(4, filterDateEnd);
				
				}
			}
			if(flujo==null && filterInts[0]>0 && filterInts[1]<=0){
				ps.setInt(1, filterInts[0]);
				if(filterDateStart != null && filterDateEnd !=null){
			
					ps.setString(2, filterDateStart);
					ps.setString(3, filterDateEnd);
			
				}
			}
			if(flujo == null && filterInts[0]<=0 && filterInts[1]>0){
				ps.setString(1, nbPais);
				if(filterDateStart != null && filterDateEnd !=null){
			
					ps.setString(2, filterDateStart);
					ps.setString(3, filterDateEnd);
			
				}
			}
			if(flujo == null && filterInts[0]<=0 && filterInts[1]<=0){
				if(filterDateStart != null && filterDateEnd !=null){
			
						ps.setString(1, filterDateStart);
						ps.setString(2, filterDateEnd);
				}
			}
			
			rs = ps.executeQuery();
			int contador = 0;
			String archAnterior = "";
			int consecutivoAnterior = 0;
			while(rs.next()){
				ProcessFilesVo file = new ProcessFilesVo();
				file.setNu_consecutivo(rs.getInt(1));
				file.setNu_id_tipo_arch(rs.getInt(2));
				file.setNu_estatus_archivo(rs.getInt(3));
				file.setAux2(rs.getString(4));
				String nameAux = rs.getString(5).replaceAll("-", "\\.");
				if(nameAux.length()>=12) nameAux = nameAux.substring(0, 12);
				file.setNb_arch_procesado(nameAux);
				file.setFullName(rs.getString(5));
				file.setFh_proceso(rs.getTimestamp(6));
				file.setNb_estatus_archivo(rs.getString(7));
				file.setNb_masc_archivo(rs.getString(8));
				file.setNu_tipo_srvswift(rs.getInt(9));
				file.setNu_pais(rs.getInt(10));
				file.setNu_tipo_servicio(rs.getInt(11));
				file.setNb_pais((rs.getString(12) != null)?rs.getString(12):"");
				file.setNb_srvswift(rs.getString(13));
				file.setNb_tipo_servicio(rs.getString(14));
				file.setAux1(rs.getString(15));
				file.setAux3(rs.getString(16));
				file.setBic_origen(rs.getString(17));
				
   				//Arch Entrada/salida a GMM 
   				//(I) - 0xxxcccc.eee_crelay_aaaammddhhmmss 
   				//(O) - bic_destinoXX0xxxcccc.eee_aaaammddhhmmss
   				String nameFile="";
   				
   				
   				if(file.getAux2().trim().equalsIgnoreCase("I") && file.getNu_tipo_servicio()==2){
   					nameFile = file.getFullName();
   				}
   				if(file.getAux2().trim().equalsIgnoreCase("O")&& file.getNu_tipo_servicio()==2){ 					
   					nameFile = file.getBic_origen()+file.getAux3()+file.getFullName();
   				}
   				if(file.getAux2().trim().equalsIgnoreCase("I") && file.getNu_tipo_servicio()==1){
   					nameFile = file.getFullName();
   				}
   				if(file.getAux2().trim().equalsIgnoreCase("O")&& file.getNu_tipo_servicio()==1){ 					
   					nameFile = file.getBic_origen()+file.getAux3()+file.getFullName();
   					String auxName[] = nameFile.split("_");
   					nameFile = auxName[0];
   				}
   				if(file.getAux2().trim().equalsIgnoreCase("I") && file.getNu_tipo_servicio()==3){
   					nameFile = file.getFullName();
   				}
   				if(file.getAux2().trim().equalsIgnoreCase("O")&& file.getNu_tipo_servicio()==3){ 					
   					nameFile = file.getFullName();
   				}
   				
   				if(file.getNu_tipo_servicio() > 3 && file.getNu_tipo_servicio() < 15){
   					nameFile = file.getFullName();
   					String auxName[] = nameFile.split("_");
   					file.setFullName(auxName[0]);
   				}
   				
   				// Si el servicio es mayor o igual a 15, ya no se asume que tendrá como sufijo el ID del reg
   				if(file.getNu_tipo_servicio() >= 15){
   					nameFile = file.getFullName();
   				}
   				
				//file.setFullName(nameFile);
   				file.setNu_flujo_cte_swift(nameFile);
				file.setSize(fileSize(nameFile, rs.getInt(11)));
				registers.add(file);
				
				contador ++;
				if (contador >= 500) {
					break;
				}
			}
			for(ProcessFilesVo vo: registers){
				String bic_origen = vo.getBic_origen();
				String pais_origen = vo.getAux3();
				ps = con.prepareStatement(DataBase.getQuery("getClientSendFile"));
				ps.setString(2, bic_origen);
				ps.setString(1, pais_origen);
				rs = ps.executeQuery();
				if(rs.next()){
					vo.setNbCliente(rs.getString(1));
				}
				mapa.put(vo, vo);
				closeAll(new Object[]{ps,rs});
			}
			if (cliente != null && !cliente.equals("")) {
				ArrayList<ProcessFilesVo> archivos = new ArrayList<ProcessFilesVo>();
				mapa = null;
				mapa = new HashMap();
				for(int numVo=0; numVo < registers.size(); numVo++) {
					ProcessFilesVo f = registers.get(numVo);
					if ((f.getNbCliente()).contains(cliente)) {
						archivos.add(registers.get(numVo));
						mapa.put(f, f);
					}
				}
				registers = null;
				registers = archivos;
			}
			//Collection values = mapa.values();
			//ArrayList array = new ArrayList(values);
			//registers = null;
			//registers = array;
			//Collections.sort(array);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("Error al buscar en bitacora: "+e.getMessage());
		}finally{
			closeAll(new Object[]{ps,rs,con});
		}
		return registers;
	}
	
	public ArrayList getAllFlows() throws Exception{
		ArrayList flows = new ArrayList();
		try {
			ps = con.prepareStatement(DataBase.getQuery("getAllFlows"));
			rs = ps.executeQuery();
			while(rs.next()){
				BlobRegistry flow = new BlobRegistry();
				flow.setLiga(rs.getString(1));
				flow.setNombreDocto(rs.getString(2));
				flows.add(flow);
			}
		}
		catch (Exception e) {
			throw new Exception("Error al obtener catálogo de flujos: "+e.getMessage(),e);
		}finally{
			closeAll(new Object[]{ps,rs,con});
		}
		return flows;
	}
	
	public ArrayList getParameters() throws Exception{
		ArrayList parameters = new ArrayList();
		try {
			ps = con.prepareStatement(DataBase.getQuery("getParameters"));
			rs = ps.executeQuery();
			while(rs.next()){
				ProcessFilesVo processFile = new ProcessFilesVo();
				processFile.setNu_consecutivo(rs.getInt(1));
				processFile.setNu_pais(rs.getInt(2));
				processFile.setNb_pais(rs.getString(3));
				processFile.setNu_tipo_servicio(rs.getInt(4));
				processFile.setNb_tipo_servicio(rs.getString(5));
				processFile.setFullName(rs.getString(6));
				processFile.setNu_estatus_archivo(rs.getInt(7));
				parameters.add(processFile);
			}
		}
		catch (Exception e) {
			throw new Exception("Error al obtener parámetros: "+e.getMessage(),e);
		}finally{
			closeAll(new Object[]{ps,rs,con});
		}
		return parameters;
	}
	
	public void updateAcuses(int status, int acuse) throws Exception{
		
		try{
			con.setAutoCommit(false);
			ps = con.prepareStatement(DataBase.getQuery("getParam"));
			ps.setInt(1, acuse);
			rs = ps.executeQuery();
			if(rs.next()){
				ps = con.prepareStatement(DataBase.getQuery("updateParameterUno"));
				ps.setInt(1, status);
				ps.setInt(2, rs.getInt(2));
				ps.setInt(3, rs.getInt(3));
				ps.executeUpdate();
				ps.close();
				con.commit();
			}
		}catch (Exception e) {
			con.rollback();
			throw new Exception (e.getMessage());
		}finally{
			ps.close();
			ps = null;
			rs.close();
			rs = null;
			con.close();
			con = null;
		}
	}
	
	private long fileSize(String fs, int service){
		File file=null;
		long size=0l;
		switch(service){
			case 2:
				//file = new File("D:\\WEBGMM\\ARCHIVOS\\CRELAY\\"+fs);
				file = new File("/monitorgmm/webgmm/archivos/cliente-swift/latam/crelay/"+fs);
				break;
			case 1:
				//file = new File("D:\\WEBGMM\\ARCHIVOS\\RECAUDO\\"+fs);
				file = new File("/monitorgmm/webgmm/archivos/cliente-swift/latam/recaudo/"+fs);
				break;
			case 3:				
				//file = new File("D:\\WEBGMM\\ARCHIVOS\\PAGOSH2H\\"+fsAux);
				file = new File("/monitorgmm/webgmm/archivos/cliente-swift/mexico/pagosh2h/"+fs);
				break;
			default:
				//file = new File("D:\\WEBGMM\\ARCHIVOS\\PAGOSH2H\\"+fsAux);
				file = new File("/monitorgmm/webgmm/archivos/latam/"+fs);
				break;
		}
		if(file.exists()) size=file.length();
		
		return size;
	}
}
