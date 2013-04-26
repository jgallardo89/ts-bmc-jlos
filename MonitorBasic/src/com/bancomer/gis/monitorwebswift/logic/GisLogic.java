package com.bancomer.gis.monitorwebswift.logic;

import org.apache.log4j.Logger;

import com.bancomer.gis.monitorwebswift.dao.GisDao;
import com.bancomer.gis.monitorwebswift.util.AppLog;

import static com.bancomer.gis.monitorwebswift.util.Constants.*;

public class GisLogic {
	
	private Logger log=null;
	
	public GisLogic(){
		log = AppLog.getLog("GisLogic");
	}
	
	public int changePassword(int idUser, String password, String validatePass){
		GisDao dao = null;
		int result=-1;
		try{
			dao = new GisDao(ORACLE);
			result  = dao.changePassword(idUser, password, validatePass);
		}catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

}
