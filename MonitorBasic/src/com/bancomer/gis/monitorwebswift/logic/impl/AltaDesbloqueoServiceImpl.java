package com.bancomer.gis.monitorwebswift.logic.impl;

import com.bancomer.gis.monitorwebswift.dao.AltaDesbloqueoDao;
import com.bancomer.gis.monitorwebswift.dao.GisDao;
import com.bancomer.gis.monitorwebswift.logic.AltaDesbloqueoService;
import com.bancomer.gis.monitorwebswift.util.Constants;
import com.bancomer.gis.monitorwebswift.vo.AltaDesbloqueoVo;

public class AltaDesbloqueoServiceImpl implements AltaDesbloqueoService {

	public void altaDesbloqueo(AltaDesbloqueoVo altaDesbloqueoVo) {
		AltaDesbloqueoDao altaDesbloqueoDao = null;
		try {
			altaDesbloqueoDao = new AltaDesbloqueoDao(Constants.ORACLE);
			//altaDesbloqueoDao.generarAlta(altaDesbloqueoVo);
		} catch (Exception e) {			
			e.printStackTrace();
		}		
	}
	
	public boolean existeUsuario(String usuario){
		AltaDesbloqueoDao altaDesbloqueoDao = null;
		boolean existeUsuario = false;
		try {
			altaDesbloqueoDao = new AltaDesbloqueoDao(Constants.ORACLE);
			existeUsuario = altaDesbloqueoDao.existeUsuario(usuario);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return existeUsuario;
	}

	public void cambioPassword(int idUsuario, String nuevoPassword,
			String passwordViejo) {
		GisDao gisDao = null;
		try {
			gisDao = new GisDao(Constants.ORACLE);
			gisDao.changePassword(idUsuario, nuevoPassword, passwordViejo);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

	public boolean validarOldPassword(int idUsuario, String oldPassword) {
		GisDao gisDao = null;
		boolean oldPasswordValido = false;
		try {
			gisDao = new GisDao(Constants.ORACLE);
			//true si el password viejo es identico al que se ingreso en la pantalla
			oldPasswordValido = gisDao.verifyPassword(idUsuario, oldPassword);			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return oldPasswordValido;
	}

}
