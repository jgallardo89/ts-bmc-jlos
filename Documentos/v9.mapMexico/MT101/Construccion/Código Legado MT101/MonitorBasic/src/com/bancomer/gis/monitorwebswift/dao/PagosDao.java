package com.bancomer.gis.monitorwebswift.dao;

import static com.bancomer.gis.monitorwebswift.util.Constants.PAGOS;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.bancomer.gis.monitorwebswift.db.DataBase;
import com.bancomer.gis.monitorwebswift.util.Constants;
import com.bancomer.gis.monitorwebswift.vo.ClientVo;
import com.bancomer.gis.monitorwebswift.vo.ProductVo;

public class PagosDao extends GeneralDAO{
	
	public PagosDao(int switchConnection) throws Exception {
		super(switchConnection);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList getProducts(int idCountry) throws Exception{
		ArrayList products = new ArrayList();
		try {
			ps = con.prepareStatement(DataBase.getQuery("getPrdCont"));
			ps.setInt(1, idCountry);
			rs = ps.executeQuery();
			while(rs.next()){
				products.add(new ProductVo(
											rs.getInt(1),
											rs.getString(2),
											rs.getString(3)
											));
			}
		} catch (Exception e) {
			throw new Exception("Error al obtener productos contratados: "+e.getMessage(),e);
		}finally{
			closeAll(new Object[]{ps,rs,con});
		}
		return products;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList getPays() throws Exception{
		ArrayList recs = new ArrayList();
		try {
			ps = con.prepareStatement(DataBase.getQuery("getTableServicesPay"));
			ps.setInt(1, PAGOS);
			rs = ps.executeQuery();
			while(rs.next()){
				ClientVo client = new ClientVo();
				client.setNu_id_cliente(rs.getInt(1));
				client.setNb_cliente(rs.getString(2));
				client.setNu_pais(rs.getInt(3));
				client.setNb_pais(rs.getString(4));
				client.setCd_acr_cliente(rs.getString(5));
				client.setCd_num_referencia(rs.getString(6));
				client.setDecodeBic(rs.getString(7));
				client.setCd_cte_latam(rs.getString(8));
				client.setCd_bic_sw_cte_env(rs.getString(9));
				client.setNu_cod_bic_euro(rs.getInt(10));
				client.setNu_tipo_srv(rs.getInt(11));
				client.setCd_ofi_sw_cte(rs.getString(12));
				client.setNu_tipo_srv_swift(rs.getInt(13));
				client.setNu_cuenta(rs.getString(14));
				client.setNu_oficina(rs.getString(15));
				client.setCd_bic_cta_env(rs.getString(16));
				client.setCd_ofi_cta_env(rs.getString(17));
				client.setCoin(rs.getInt(18));
				client.setCd_contrato_swift(rs.getString(19));
				client.setNb_empresa(rs.getString(20));
				client.setPc_iva(rs.getString(21));
				client.setTipo_cliente_aaa(rs.getInt(22));
				client.setCd_contrato_sicoco(rs.getString(23));
				client.setTp_anualidad(rs.getString(24));
				client.setTp_mensualidad(rs.getString(25));
				client.setTp_sicoco_gen(rs.getString(26));
				client.setCd_activo(rs.getInt(27));
				client.setFh_alta(rs.getTimestamp(28));
				client.setCd_ofi_sw_cte_env(rs.getString(29));
				client.setNu_tipo_canal(rs.getInt(30));
				recs.add(client);
			}
		} catch (Exception e) {
			throw new Exception("Error al obtener recaudos: "+e.getMessage(),e);
		}finally{
			closeAll(new Object[]{ps,rs,con});
		}
		return recs;
	}
	
	public ClientVo searchClientPay(ClientVo clientRequest) throws Exception{
		ClientVo client = new ClientVo();
		try {
			
			ps = con.prepareStatement(DataBase.getQuery("getClient"));
			ps.setInt(1, clientRequest.getNu_tipo_srv());
			ps.setInt(2, clientRequest.getNu_id_cliente());
			rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getInt(3)!=6){
					client.setNu_id_cliente(rs.getInt(1));
					client.setCd_num_referencia(rs.getString(2));
					client.setNu_pais(rs.getInt(3));
					client.setBic(rs.getInt(4));
					client.setCd_cte_latam(rs.getString(5));
					client.setNu_cod_bic_euro(rs.getInt(6));
					client.setCd_bic_sw_cte_env(rs.getString(7));
					client.setCd_ofi_sw_cte_env(rs.getString(8));
					client.setNb_cliente(rs.getString(9));
					client.setCd_acr_cliente(rs.getString(10));
					client.setFh_alta(rs.getTimestamp(11));
					client.setFh_modificacion(rs.getTimestamp(12));
					client.setFh_baja(rs.getTimestamp(13));
					client.setCd_activo(rs.getInt(14));
					client.setNu_tipo_srv(rs.getInt(16));
					client.setBranch(rs.getInt(17));
					client.setNu_tipo_srv_swift(rs.getInt(19));
					client.setNu_tipo_canal(rs.getInt(21));
					client.setNu_cuenta(rs.getString(22));
				}
			}
			closeAll(new Object[]{ps,rs});
			//Si No encontro nada (client=null) buscamos sin cuenta asigana
			if(client.getNb_cliente()==null){
				ps = con.prepareStatement(DataBase.getQuery("getClientSC"));
				ps.setInt(1, clientRequest.getNu_tipo_srv());
				ps.setInt(2, clientRequest.getNu_id_cliente());
				rs = ps.executeQuery();
				while(rs.next()){
					if(rs.getInt(3)!=6){
						client.setNu_id_cliente(rs.getInt(1));
						client.setCd_num_referencia(rs.getString(2));
						client.setNu_pais(rs.getInt(3));
						client.setBic(rs.getInt(4));
						client.setCd_cte_latam(rs.getString(5));
						client.setNu_cod_bic_euro(rs.getInt(6));
						client.setCd_bic_sw_cte_env(rs.getString(7));
						client.setCd_ofi_sw_cte_env(rs.getString(8));
						client.setNb_cliente(rs.getString(9));
						client.setCd_acr_cliente(rs.getString(10));
						client.setFh_alta(rs.getTimestamp(11));
						client.setFh_modificacion(rs.getTimestamp(12));
						client.setFh_baja(rs.getTimestamp(13));
						client.setCd_activo(rs.getInt(14));
						client.setNu_tipo_srv(rs.getInt(16));
						client.setBranch(rs.getInt(17));
						client.setNu_tipo_srv_swift(rs.getInt(19));
						client.setNu_tipo_canal(rs.getInt(21));
					}
				}
			}
			closeAll(new Object[]{ps,rs});
			
			//Si cliente sigue nulo probamos con el query de mexico con cuenta
			ps = con.prepareStatement(DataBase.getQuery("getClientMX"));
			ps.setInt(1, clientRequest.getNu_tipo_srv());
			ps.setInt(2, clientRequest.getNu_id_cliente());
			rs = ps.executeQuery();
			while(rs.next()){
				client.setNu_id_cliente(rs.getInt(1));
				client.setCd_num_referencia(rs.getString(2));
				client.setNu_pais(rs.getInt(3));
				client.setBic(rs.getInt(4));
				client.setCd_cte_latam(rs.getString(5));
				client.setNu_cod_bic_euro(rs.getInt(6));
				client.setCd_bic_sw_cte_env(rs.getString(7));
				client.setCd_ofi_sw_cte_env(rs.getString(8));
				client.setNb_cliente(rs.getString(9));
				client.setCd_acr_cliente(rs.getString(10));
				client.setFh_alta(rs.getTimestamp(11));
				client.setFh_modificacion(rs.getTimestamp(12));
				client.setFh_baja(rs.getTimestamp(13));
				client.setCd_activo(rs.getInt(14));
				client.setNu_tipo_srv(rs.getInt(16));
				client.setBranch(rs.getInt(17));
				client.setNu_tipo_srv_swift(rs.getInt(19));
				client.setNu_tipo_canal(rs.getInt(21));
				client.setNu_cuenta(rs.getString(22));
				client.setCoin(rs.getInt(28));
				client.setTipo_cliente_aaa(rs.getInt(29));
			}
			
			closeAll(new Object[]{ps,rs});
			
			//Si cliente sigue nulo probamos con el query de mexico SIN cuenta
			if(client.getNb_cliente()==null){	
				ps = con.prepareStatement(DataBase.getQuery("getClientMXSC"));
				ps.setInt(1, clientRequest.getNu_tipo_srv());
				ps.setInt(2, clientRequest.getNu_id_cliente());
				rs = ps.executeQuery();
				while(rs.next()){
					client.setNu_id_cliente(rs.getInt(1));
					client.setCd_num_referencia(rs.getString(2));
					client.setNu_pais(rs.getInt(3));
					client.setBic(rs.getInt(4));
					client.setCd_cte_latam(rs.getString(5));
					client.setNu_cod_bic_euro(rs.getInt(6));
					client.setCd_bic_sw_cte_env(rs.getString(7));
					client.setCd_ofi_sw_cte_env(rs.getString(8));
					client.setNb_cliente(rs.getString(9));
					client.setCd_acr_cliente(rs.getString(10));
					client.setFh_alta(rs.getTimestamp(11));
					client.setFh_modificacion(rs.getTimestamp(12));
					client.setFh_baja(rs.getTimestamp(13));
					client.setCd_activo(rs.getInt(14));
					client.setNu_tipo_srv(rs.getInt(16));
					client.setBranch(rs.getInt(17));
					client.setNu_tipo_srv_swift(rs.getInt(19));
					client.setNu_tipo_canal(rs.getInt(21));
					client.setCoin(rs.getInt(23));
					client.setTipo_cliente_aaa(rs.getInt(24));
				}
			}
			
			//Obtenenos los productos contratados por cliente y formamos un arreglo de Strings
			ps = con.prepareStatement(DataBase.getQuery("getProductsC"));
			ps.setInt(1, clientRequest.getNu_id_cliente());
			rs = ps.executeQuery();
			String products[];
			String temp="";
			while(rs.next()){
				temp+=rs.getString(2)+"-";
			}
			products = temp.split("-");
			
			client.setAviableProducts(getProduct(products,client.getNu_pais()));
			
			//Cargamos los productos que no tiene contratados
			String [] noProducts = getUnaviableProducts(products);
			client.setUnaviableProducts(getProduct(noProducts,client.getNu_pais()));
			
			String [] bicBranch = decodeBicBranch(client);
			client.setCd_bic_sw_cte(bicBranch[0]);
			client.setCd_ofi_sw_cte(bicBranch[1]);
		} catch (Exception e) {
			throw new Exception("Error Al Buscar Pagos: "+e.getMessage(),e);
		}finally{
			closeAll(new Object[]{ps,rs,con});
		}
		return client;
	}
	
	public String[] getUnaviableProducts(String [] products) throws Exception{
		String [] noProducts;
		String query = "select * from TGM013_PROD_CONTRA where cd_activo=1 ";
		String temp="";
		if(products!=null && products[0].trim().length()>0){
			for(int i=0;i<products.length;i++){
				query += "  and CD_PRD_CONTRATADO<> "+products[i];
			}
		}
		
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				temp += rs.getString(1)+"-";
			}
			noProducts = temp.split("-");
		} catch (Exception e) {
			throw new Exception("Error al obtener productos no contratados: "+e.getMessage(),e);
		}finally{
			closeAll(new Object[]{ps,rs});
		}
		return noProducts;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList getProduct(String[] products, int country) throws Exception{
		ArrayList productsArray = new ArrayList();
		try {
			if(products!=null && products[0].trim().length()>0){
				for(int i=0;i<products.length;i++){
					ps = con.prepareStatement(DataBase.getQuery("getPrdCont")+" AND CD_PRD_CONTRATADO="+products[i]);
					ps.setInt(1, country);
					rs = ps.executeQuery();
					while(rs.next()){
						productsArray.add(new ProductVo(
													rs.getInt(1),
													rs.getString(2),
													rs.getString(3)
													));
					}
				}
			}
		} catch (Exception e) {
			throw new Exception("Error al obtener productos contratados: "+e.getMessage(),e);
		}finally{
			closeAll(new Object[]{ps,rs});
		}
		return productsArray;
	}
	
	@SuppressWarnings("unchecked")
	
	public String[] decodeBicBranch(ClientVo client) throws Exception{
		String[] bicBranch = new String[2];
		try {
			ps = con.prepareStatement(DataBase.getQuery("decodeBicBranch"));
			ps.setInt(1, client.getBic());
			ps.setInt(2, client.getNu_tipo_srv());
			ps.setInt(3, client.getNu_id_cliente());
			rs = ps.executeQuery();
			while(rs.next()){
				bicBranch[0]=rs.getString(2);
				bicBranch[1]=rs.getString(3);
			}
		} catch (Exception e) {
			throw new Exception("Error al obtener Bic/Branch: "+e.getMessage(),e);
		}finally{
			closeAll(new Object[]{ps,rs});
		}
		return bicBranch;
	}
	
	/**
	 * {@link Description} metodo para obtener los productos por cliente
	 */
	public StringBuffer getProductsByClient(int idClient, int country){
		StringBuffer XML = new StringBuffer();
		//Obtenenos los productos contratados por cliente y formamos un arreglo de Strings
		try {
			ps = con.prepareStatement(DataBase.getQuery("getProductsByUser"));
			ps.setInt(1, idClient);
			ps.setInt(2, country);
			rs = ps.executeQuery();
			XML.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n");
			XML.append("<products>\n");
			while(rs.next()){
				XML.append("\t<product>\n");
					XML.append("\t\t<id>"+rs.getInt(1)+"</id>\n");
					XML.append("\t\t<name>"+rs.getString(2)+"</name>\n");
				XML.append("\t</product>\n");
			}
			XML.append("</products>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return XML;
	}
	public StringBuffer getProductsByCountry(int country){
		StringBuffer XML = new StringBuffer();
		//Obtenenos los productos contratados por cliente y formamos un arreglo de Strings
		try {
			ps = con.prepareStatement(DataBase.getQuery("getPrdCont"));
			ps.setInt(1, country);
			rs = ps.executeQuery();
			XML.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n");
			XML.append("<products>\n");
			while(rs.next()){
				XML.append("\t<product>\n");
					XML.append("\t\t<id>"+rs.getInt(1)+"</id>\n");
					XML.append("\t\t<name>"+rs.getString(3)+"</name>\n");
				XML.append("\t</product>\n");
			}
			XML.append("</products>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return XML;
	}
	
	
	/**
	 * {@link Description} metodo para obtener los productos por cliente
	 */
	public StringBuffer getProductsTable(String country){
		StringBuffer XML = new StringBuffer();
		//Obtenenos los productos contratados por cliente y formamos un arreglo de Strings
		try {
			ps = con.prepareStatement(DataBase.getQuery("getProductsTable"));
			ps.setString(1, country);
			rs = ps.executeQuery();
			XML.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n");
			XML.append("<products>\n");
			while(rs.next()){
				XML.append("\t<product>\n");
					XML.append("\t\t<id>"+rs.getInt(1)+"</id>\n");
					XML.append("\t\t<name>"+rs.getString(2)+"</name>\n");
				XML.append("\t</product>\n");
			}
			XML.append("</products>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return XML;
	}
}
