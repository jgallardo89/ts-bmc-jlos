package com.bancomer.gis.monitorwebswift.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.bancomer.gis.monitorwebswift.util.Constants;

public class PropertiesDao {
	private static final Logger log=Logger.getLogger(PropertiesDao.class);
	private Properties prFile;
	public PropertiesDao(){}
	public boolean startProperies(String flProperty){
		if(prFile==null){
			prFile=new Properties();
			try{
				prFile.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(flProperty));
			}catch (Exception e) {
				log.error("Error en la ejecucion de la carga del archivo properties",e);
				prFile=null;
				return false;
			}
		}
		return true;
	}
	public String getProperty(String key){
		if(prFile!=null){
			if((!prFile.isEmpty())&&prFile.containsKey(key)){
				return prFile.getProperty(key, null);
			}
		}
		return null;
	}
	public boolean closeProperties(){
		prFile=null;
		return true;
	}
	public String getProperty(String flProperty,String key) throws FileNotFoundException, IOException {
		prFile=new Properties();
		prFile.load(new FileInputStream(flProperty));
		if((!prFile.isEmpty())&&prFile.containsKey(key)){
			return prFile.getProperty(key, null);
		}
		return null;
	}
}
