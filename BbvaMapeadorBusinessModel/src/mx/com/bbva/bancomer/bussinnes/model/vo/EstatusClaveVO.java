/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Informacion Confidencial:
 * Este software contiene informacion totalmente confidencial propiedad de Grupo Financiero BBVA Bancomer. 
 * Queda totalmente prohibido su uso o divulgacion en forma parcial o total y solamente podra ser utilizada de acuerdo a los terminos y estatutos 
 * que determine el Grupo Financiero BBVA Bancomer.
 * 
 * Todos los derechos reservados, Mexico 2013.
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * DESCRIPCION DEL PROGRAMA
 * Nombre de aplicación: MAPEADOR
 * Nombre de proyecto: BbvaMapeadorBusinessModel
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * HISTORIAL DE CAMBIOS:
 * 
 * Fecha:									         	
 * 30-ABR-2013  
 * @Author:	Jose Luis Ortiz Salazar
 * @Email: jortizsalazar@gmail.com    	
 * Razon: Creacion        
 * Version: 1.0.0
 * Nombre de clase: EstatusClaveVO.java
 * Nombre de paquete: mx.com.bbva.bancomer.bussinnes.model.vo
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.bussinnes.model.vo;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

// TODO: Auto-generated Javadoc
/**
 * The Class EstatusClaveVO.
 */
public class EstatusClaveVO extends BbvaAbstractValueObject {

	/** The id estatus clave. */
	private int idEstatusClave;
	
	/** The nombre estatus clave. */
	private String nombreEstatusClave;
	
	/**
	 * Gets the id estatus clave.
	 *
	 * @return the idEstatusClave
	 */
	public int getIdEstatusClave() {
		return idEstatusClave;
	}
	
	/**
	 * Gets the nombre estatus clave.
	 *
	 * @return the nombreEstatusClave
	 */
	public String getNombreEstatusClave() {
		return nombreEstatusClave;
	}
	
	/**
	 * Sets the id estatus clave.
	 *
	 * @param idEstatusClave the idEstatusClave to set
	 */
	public void setIdEstatusClave(int idEstatusClave) {
		this.idEstatusClave = idEstatusClave;
	}
	
	/**
	 * Sets the nombre estatus clave.
	 *
	 * @param nombreEstatusClave the nombreEstatusClave to set
	 */
	public void setNombreEstatusClave(String nombreEstatusClave) {
		this.nombreEstatusClave = nombreEstatusClave;
	}	
}
