package com.bancomer.gis.monitorwebswift.logic;

import static com.bancomer.gis.monitorwebswift.util.Constants.ORACLE;
import static com.bancomer.gis.monitorwebswift.util.Constants.SWIFT;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.bancomer.gis.monitorwebswift.dao.GisDao;
import com.bancomer.gis.monitorwebswift.dao.MonitorMacugDao;
import com.bancomer.gis.monitorwebswift.dao.PagosDao;
import com.bancomer.gis.monitorwebswift.util.AppLog;
import com.bancomer.gis.monitorwebswift.vo.ClientVo;
import com.bancomer.gis.monitorwebswift.vo.ServiceVo;

/**
 * @author Marcos
 */
public class ServicesLogic {
	
	private Logger log = null;
	

	public ArrayList<String> getMessage() {
		ArrayList<String> message= new ArrayList<String>();
		try {
			message= new GisDao(ORACLE).getMessage();
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return message;
	}
	public ServicesLogic(){
		log = AppLog.getLog("ServicesLogic");
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList getCountries(){
		GisDao dao;
		ArrayList countries =null;
		try {
			dao = new GisDao(SWIFT);
			countries=dao.getCountries();
			} catch (Exception e) {
			log.error(e.getMessage());
		}
		return countries;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList getCoins(){
		GisDao dao;
		ArrayList coins =null;
		try {
//			dao = new GisDao(SWIFT);
//			coins=dao.getCoins();
			} catch (Exception e) {
			log.error(e.getMessage());
		}
		return coins;
	}
	
	
		
	@SuppressWarnings("unchecked")
	public ArrayList getChannels(){
		GisDao dao;
		ArrayList channels =null;
		try {
			dao = new GisDao(ORACLE);
			channels=dao.getChannels();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return channels;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList getServices(){
		GisDao dao;
		ArrayList<ServiceVo> services =null;
		try {
			dao = new GisDao(ORACLE);
			services=dao.getServices();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return services;
	}
	@SuppressWarnings("unchecked")
	public ArrayList getProducts(int idCountry){
		PagosDao dao;
		ArrayList recs =null;
		try {
			dao = new PagosDao(ORACLE);
			recs=dao.getProducts(idCountry);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return recs;
	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayList getPays(){
		PagosDao dao;
		ArrayList recs =null;
		try {
			dao = new PagosDao(ORACLE);
			recs=dao.getPays();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return recs;
	}
	
	public ClientVo searchClientPay(ClientVo clientRequest){
		PagosDao dao;
		ClientVo client =null;
		try {
			dao = new PagosDao(ORACLE);
			client=dao.searchClientPay(clientRequest);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return client;
	}
	
	
	public ArrayList getAllFlows() throws Exception{
		ArrayList flows = null;
		try {
			MonitorMacugDao dao = new MonitorMacugDao(1);
			flows = dao.getAllFlows();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return flows;
	}
	public ArrayList getCountriesByLinks(int id_Usr) throws Exception{
		GisDao dao;
		ArrayList countries =null;
		try {
			dao = new GisDao(ORACLE);
			countries=dao.getCountriesByLinks(id_Usr);
			} catch (Exception e) {
			log.error(e.getMessage());
		}
		return countries;
	}
	
	public boolean existsCustomer(String name, String reference, int country){
		GisDao dao;
		boolean exists=true;
		try {
			dao = new GisDao(ORACLE);
			exists=dao.existsCustomer(name, reference, country);
		}catch (Exception e) {
			log.error(e.getMessage());
		}
		return exists;
	}
	
	public boolean existsCustomerUpdate(int idCustomer, String name, String reference, int country){
		GisDao dao;
		boolean exists=false;
		try {
			dao = new GisDao(ORACLE);
			exists=dao.existsCustomerUpdate(idCustomer, name, reference, country);
		}catch (Exception e) {
			log.error(e.getMessage());
		}
		return exists;
	}
	public String obtenerNbPais(int cdPaisMonitor) {
		GisDao dao = null;
		String nbPais = "";
		try {
			dao = new GisDao(ORACLE);
			nbPais=dao.getNbPais(cdPaisMonitor);
		}catch (Exception e) {
			log.error(e.getMessage());
		}
		return nbPais;
	}
}
