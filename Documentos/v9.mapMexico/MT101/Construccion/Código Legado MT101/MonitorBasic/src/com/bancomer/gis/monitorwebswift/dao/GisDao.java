package com.bancomer.gis.monitorwebswift.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.bancomer.gis.monitorwebswift.db.DataBase;
import com.bancomer.gis.monitorwebswift.util.Cryptography;
import com.bancomer.gis.monitorwebswift.vo.ChannelVo;
import com.bancomer.gis.monitorwebswift.vo.CoinVo;
import com.bancomer.gis.monitorwebswift.vo.CountryVo;
import com.bancomer.gis.monitorwebswift.vo.ServiceVo;

/**
 * @author mfragoso
 */
public class GisDao extends GeneralDAO{

	public GisDao(int switchConnection) throws Exception {
		super(switchConnection);
	}
		
	public ArrayList<String> getMessage() throws Exception{
		ArrayList<String> message= new ArrayList<String>();
		try {
			ps = con.prepareStatement(DataBase.getQuery("getAvisos"));
			rs = ps.executeQuery();
			while(rs.next())message.add(rs.getString(2));
		} catch (Exception e) {
			throw new Exception("Error al obtener título de pantalla principal: "+e.getMessage(),e);
		}finally{
			closeAll(new Object[]{ps,rs,con});
		}
		return message;
	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayList getCountries() throws Exception{
		ArrayList countries = new ArrayList();
		try {
			ps = con.prepareStatement(DataBase.getQuery("getCountries"));
			rs = ps.executeQuery();
			while(rs.next()){
				countries.add(new CountryVo(
											rs.getInt(1),
											rs.getString(2),
											rs.getString(3)
											));
			}
		} catch (Exception e) {
			throw new Exception("Error al obtener paises: "+e.getMessage(),e);
		}finally{
			closeAll(new Object[]{ps,rs,con});
		}
		return countries;
	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayList getCoins() throws Exception{
		ArrayList coins = new ArrayList();
		try {
			ps = con.prepareStatement(DataBase.getQuery("getCoins"));
			rs = ps.executeQuery();
			while(rs.next()){
				coins.add(new CoinVo(
											rs.getInt(1),
											rs.getString(2)));
			}
		} catch (Exception e) {
			throw new Exception("Error al obtener monedas: "+e.getMessage(),e);
		}finally{
			closeAll(new Object[]{ps,rs,con});
		}
		return coins;
	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayList getChannels() throws Exception{
		ArrayList channels = new ArrayList();
		try {
			ps = con.prepareStatement(DataBase.getQuery("selectChannels"));
			rs = ps.executeQuery();
			while(rs.next()){
				channels.add(new ChannelVo(
											rs.getInt(1),
											rs.getString(2),
											rs.getString(3),
											rs.getDate(4)));
			}
		} catch (Exception e) {
			throw new Exception("Error al obtener canales: "+e.getMessage(),e);
		}finally{
			closeAll(new Object[]{ps,rs,con});
		}
		return channels;
	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayList<ServiceVo> getServices() throws Exception{
		ArrayList <ServiceVo> services = new ArrayList<ServiceVo>();
		try {
			ps = con.prepareStatement(DataBase.getQuery("selectServices"));
			rs = ps.executeQuery();
			while(rs.next()){
				services.add(new ServiceVo(
											rs.getInt(1),
											rs.getString(2)));
			}
		} catch (Exception e) {
			throw new Exception("Error al obtener servicios: "+e.getMessage(),e);
		}finally{
			closeAll(new Object[]{ps,rs,con});
		}
		return services;
	}
	
	@SuppressWarnings("unchecked")
	
	public ArrayList<CountryVo> getCountriesByLinks(int id_Usr) throws Exception{
		ArrayList<CountryVo> countries = new ArrayList<CountryVo>();
		try {
			
			ps =con.prepareStatement(DataBase.getQuery("obtenerComboSwift"));
			ps.setInt(1,id_Usr);
			ps.setInt(2,id_Usr);
			rs = ps.executeQuery();
			while(rs.next()){
				countries.add(new CountryVo(
					rs.getInt(1),
					rs.getString(3),
					rs.getString(2)
				));
			}
			
		} catch (Exception e) {
			throw new Exception("Error al obtener paises: "+e.getMessage(),e);
		}finally{
			closeAll(new Object[]{ps,rs,con});
		}
		return countries;
	}
	
	public String getGroupById(int id) throws Exception{
		String group="";
		try{
			ps = con.prepareStatement(DataBase.getQuery("getGroupById"));
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				group=rs.getString(1);
			}
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}finally{
			closeAll(new Object[]{ps,rs,con});
		}
		return group;
	}
	
	public boolean existsCustomer(String name, String reference, int country) throws Exception{
		boolean exists=true;
		try{
			ps = con.prepareStatement(DataBase.getQuery("verifyCustomer"));
			ps.setString(1, name);
			ps.setString(2, reference);
			ps.setInt(3, country);			
			rs = ps.executeQuery();
			if(rs.next()){
				exists=true;
			}else{
				exists = false;
			}
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}finally{
			closeAll(new Object[]{ps,rs,con});
		}
		return exists;
	}
	
	
	public boolean existsCustomerUpdate(int idCustomer, String name, String reference, int country) throws Exception{
		boolean exists=false;
		try{
			ps = con.prepareStatement(DataBase.getQuery("verifyCustomer"));
			ps.setString(1, name);
			ps.setString(2, reference);
			ps.setInt(3, country);
			rs = ps.executeQuery();
			if(rs.next()){
				if(rs.getInt(1)==idCustomer){
					exists=true;
				}
				else{
					exists = false;
				}
			}
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}finally{
			closeAll(new Object[]{ps,rs,con});
		}
		return exists;
	}
	
	public int changePassword(int idUser, String password, String validatePass) throws Exception{
		int success=-1;
		String clearText =password;
		if(clearText==null || clearText.length()<=0) clearText="";
		Cryptography encrypter = new Cryptography();
		String encrypted = encrypter.encrypt(clearText);
		
		try {
			
			//antes de actualizar primero validamos que este correcta la contraseña que escribio
			if(verifyPassword(idUser,validatePass)){
				cs = con.prepareCall("{call SP_GM023_UPD_USRPWD(?,?)}");
				cs.setInt(1, idUser);
				cs.setString(2, encrypted);
				cs.executeUpdate();
				success=0;
			}else{
				success=1;
			}
		}
		catch (SQLException e) {
			success=-2;
			throw new SQLException(e.getMessage()); 
		}finally{
			closeAll(new Object[]{cs,con});
		}
		return success;
	}
	
	public boolean verifyPassword(int idUser, String newPass) throws Exception{
		boolean equals = false;
		try {
			//Primero nos traemos la contraseña y la fecha actual que es la que sirve de llave
			String currentPass = "";
			ps = con.prepareStatement(DataBase.getQuery("getUserById"));
			ps.setInt(1, idUser);
			rs = ps.executeQuery();
			if(rs.next()){
				currentPass = rs.getString(2);
			}
			
			//Desencriptamos el password con la llave que trajimos
			Cryptography decrypter = new Cryptography();
	        String EncryptedNewPass = decrypter.encrypt(newPass);
	        
	        //Comparamos la contraseña desencriptada con el newPass{
	        if(EncryptedNewPass.trim().equals(currentPass.trim())){
	        	equals = true;
	        }else equals = false;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(new Object[]{rs,ps});
		}
		return equals;
	}
	public String getNbPais(int cdPaisMonitor){
		String nbPais = null;
		try {
			ps = con.prepareStatement(DataBase.getQuery("getPaisXCDPais"));
			ps.setInt(1, cdPaisMonitor);
			rs = ps.executeQuery();			
			while(rs.next()){
				nbPais = rs.getString(1);				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return nbPais;
	}

}