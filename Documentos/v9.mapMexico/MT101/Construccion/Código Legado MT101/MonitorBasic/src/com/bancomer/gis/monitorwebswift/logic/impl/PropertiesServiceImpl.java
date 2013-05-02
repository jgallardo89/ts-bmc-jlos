package com.bancomer.gis.monitorwebswift.logic.impl;

import com.bancomer.gis.monitorwebswift.dao.PropertiesDao;
import com.bancomer.gis.monitorwebswift.logic.PropertiesService;
import com.bancomer.gis.monitorwebswift.util.Constants;

public class PropertiesServiceImpl implements PropertiesService {
	private PropertiesDao propertiesDao;
	public PropertiesServiceImpl() {
		if(propertiesDao==null){
			propertiesDao=new PropertiesDao();
		}
	}
	public String getProperty(String strKey){
		propertiesDao.startProperies(Constants.FIXED_IPS_FILE);
		return propertiesDao.getProperty(strKey);
	}

	public void setPropertiesDao(PropertiesDao propertiesDao) {
		this.propertiesDao = propertiesDao;
	}

	public PropertiesDao getPropertiesDao() {
		return propertiesDao;
	}
}
