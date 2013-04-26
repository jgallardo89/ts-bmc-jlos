package com.bancomer.gis.monitorwebswift.logic;

import com.bancomer.gis.monitorwebswift.vo.AltaDesbloqueoVo;

public interface AltaDesbloqueoService {
	void altaDesbloqueo(AltaDesbloqueoVo altaDesbloqueoVo);
	boolean existeUsuario(String usuario);
	void cambioPassword(int idUsuario, String nuevoPassword, String passwordViejo);
	boolean validarOldPassword(int idUsuario,String oldPassword);
}
