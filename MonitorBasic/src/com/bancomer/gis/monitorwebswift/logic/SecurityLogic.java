package com.bancomer.gis.monitorwebswift.logic;

import org.apache.log4j.Logger;

import com.bancomer.gis.monitorwebswift.dao.SecurityDao;
import com.bancomer.gis.monitorwebswift.util.AppLog;
import com.bancomer.gis.monitorwebswift.vo.Usuario;

import static com.bancomer.gis.monitorwebswift.util.Constants.*;

public class SecurityLogic {
	
	private Logger log = null;
	
	public SecurityLogic(){
		log = AppLog.getLog("GisLogic");
	}
	
	public int login(String user, String password){
		SecurityDao security = null;
		int login = -1;
		try{
			security = new SecurityDao(ORACLE);
			login = security.login(user, password);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return login;
	}
	
	public int loginExterno(String userName, String pais) {
		SecurityDao security = null;
		int login = -1;
		int cdPais = 0;		
		try{
			security = new SecurityDao(ORACLE);
			//Si el invitado es invitado se le debe concatenar el cd del pais al que pertence
			if (userName.equalsIgnoreCase("INVITADO")) {
				cdPais = obtenerCdPaisCCR(pais);
				login = security.loginExterno(userName + cdPais, pais);
			}
			else {
				login = security.loginExterno(userName, pais);
			}
			
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return login;
	}
	
	public void fillUserData(Usuario user) throws Exception{
		SecurityDao security = null;
		try{
			security = new SecurityDao(ORACLE);
			security.fillUserData(user);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		
	}
	
	public int obtenerCdPaisCCR(String pais){
		SecurityDao security = null;
		int cdPaisCCR = 0;
		try {
			security = new SecurityDao(ORACLE);
			cdPaisCCR = security.obtenerCdPaisCCR(pais);
		}catch(Exception e){
			log.error(e.getMessage());
		}		
		return cdPaisCCR;
	}
	
	public boolean tieneServicioDebloqueo(long idUser){
		SecurityDao security = null;
		boolean servicioDesbloqueo = false;
		try {
			security = new SecurityDao(ORACLE);
			servicioDesbloqueo = security.tieneServicioDesbloqueo(idUser);
		}catch(Exception e){
			log.error(e.getMessage());
		}		
		return servicioDesbloqueo;
	}
}
