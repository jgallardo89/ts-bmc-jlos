package com.bancomer.gis.monitorwebswift.logic;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.bancomer.gis.monitorwebswift.util.AppLog;
import com.bancomer.gis.monitorwebswift.vo.CoinVo;
import com.bancomer.gis.monitorwebswift.dao.CatalogoAvisosDao;
import static com.bancomer.gis.monitorwebswift.util.Constants.*;

public class CatalogoAvisosLogic {
	
	private Logger log = null;
	
	public CatalogoAvisosLogic(){
		log = AppLog.getLog("CatalogoAvisosLogic");
	}
	
	public void save(Object o){
		CatalogoAvisosDao dao = null;
		try {
			dao = new CatalogoAvisosDao(ORACLE);
			dao.save(o);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	public void delete(Object o){
		CatalogoAvisosDao dao = null;
		try {
			dao = new CatalogoAvisosDao(ORACLE);
			dao.delete(o);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	public void update(Object o){
		CatalogoAvisosDao dao = null;
		try {
			dao = new CatalogoAvisosDao(ORACLE);
			dao.update(o);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	public ArrayList<CoinVo> list(){
		ArrayList <CoinVo> messages = new ArrayList<CoinVo>();
		CatalogoAvisosDao dao = null;
		try {
			dao = new CatalogoAvisosDao(ORACLE);
			messages = dao.list();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return messages;
	}
}
