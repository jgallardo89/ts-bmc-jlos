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
 * Nombre de clase: EstatusObjetoVO.java
 * Nombre de paquete: mx.com.bbva.bancomer.bussinnes.model.vo
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.bussinnes.model.vo;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

// TODO: Auto-generated Javadoc
/**
 * The Class EstatusObjetoVO.
 */
public class EstatusObjetoVO extends BbvaAbstractValueObject {
	
	/** The descripcion estatus objeto. */
	private String descripcionEstatusObjeto;
	
	/** The id estatus clave. */
	private int idEstatusClave;
	
	/** The id estatus objeto. */
	private int idEstatusObjeto;
	
	/** The imagen estatus. */
	private String imagenEstatus;
	
	/** The nombre estatus objeto. */
	private String nombreEstatusObjeto;
	
	/** The nombre pantalla. */
	private String nombrePantalla;
	
	/** The nombre status clave. */
	private String nombreStatusClave;
	
	/** The nombre tabla. */
	private String nombreTabla;
	
	/**
	 * Gets the descripcion estatus objeto.
	 *
	 * @return the descripcionEstatusObjeto
	 */
	public String getDescripcionEstatusObjeto() {
		return descripcionEstatusObjeto;
	}
	
	/**
	 * Gets the id estatus clave.
	 *
	 * @return the idEstatusClave
	 */
	public int getIdEstatusClave() {
		return idEstatusClave;
	}
	
	/**
	 * Gets the id estatus objeto.
	 *
	 * @return the idEstatusObjeto
	 */
	public int getIdEstatusObjeto() {
		return idEstatusObjeto;
	}
	
	/**
	 * Gets the imagen estatus.
	 *
	 * @return the imagenEstatus
	 */
	public String getImagenEstatus() {
		return imagenEstatus;
	}
	
	/**
	 * Gets the nombre estatus objeto.
	 *
	 * @return the nombreEstatusOjeto
	 */
	public String getNombreEstatusObjeto() {
		return nombreEstatusObjeto;
	}
	
	/**
	 * Gets the nombre pantalla.
	 *
	 * @return the nombrePantalla
	 */
	public final String getNombrePantalla() {
		return nombrePantalla;
	}
	
	/**
	 * Gets the nombre status clave.
	 *
	 * @return the nombreStatusClave
	 */
	public String getNombreStatusClave() {
		return nombreStatusClave;
	}
	
	/**
	 * Gets the nombre tabla.
	 *
	 * @return the nombreTabla
	 */
	public String getNombreTabla() {
		return nombreTabla;
	}
	
	/**
	 * Sets the descripcion estatus objeto.
	 *
	 * @param descripcionEstatusObjeto the descripcionEstatusObjeto to set
	 */
	public void setDescripcionEstatusObjeto(String descripcionEstatusObjeto) {
		this.descripcionEstatusObjeto = descripcionEstatusObjeto;
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
	 * Sets the id estatus objeto.
	 *
	 * @param idEstatusObjeto the idEstatusObjeto to set
	 */
	public void setIdEstatusObjeto(int idEstatusObjeto) {
		this.idEstatusObjeto = idEstatusObjeto;
	}
	
	/**
	 * Sets the imagen estatus.
	 *
	 * @param imagenEstatus the imagenEstatus to set
	 */
	public void setImagenEstatus(String imagenEstatus) {
		this.imagenEstatus = imagenEstatus;
	}
	
	/**
	 * Sets the nombre estatus objeto.
	 *
	 * @param nombreEstatusObjeto the new nombre estatus objeto
	 */
	public void setNombreEstatusObjeto(String nombreEstatusObjeto) {
		this.nombreEstatusObjeto = nombreEstatusObjeto;
	}
	
	/**
	 * Sets the nombre pantalla.
	 *
	 * @param nombrePantalla the nombrePantalla to set
	 */
	public final void setNombrePantalla(String nombrePantalla) {
		this.nombrePantalla = nombrePantalla;
	}
	
	/**
	 * Sets the nombre status clave.
	 *
	 * @param nombreStatusClave the nombreStatusClave to set
	 */
	public void setNombreStatusClave(String nombreStatusClave) {
		this.nombreStatusClave = nombreStatusClave;
	}
	
	/**
	 * Sets the nombre tabla.
	 *
	 * @param nombreTabla the nombreTabla to set
	 */
	public void setNombreTabla(String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}
	
}
