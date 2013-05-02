package com.bancomer.gis.monitorwebswift.logic;

import java.util.List;


public interface ComboService {

	
	/** Lista de items a mostrar en combo, requiere declaración de bean
	 * @param comboName nombre del combo
	 * @return Lista de SelectItem
	 */
	public List getDatosCombo(String comboName) throws Exception;
	
}
