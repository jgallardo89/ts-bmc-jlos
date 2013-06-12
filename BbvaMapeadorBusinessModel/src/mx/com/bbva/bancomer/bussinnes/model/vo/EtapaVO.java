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
 * Nombre de clase: EtapaVO.java
 * Nombre de paquete: mx.com.bbva.bancomer.bussinnes.model.vo
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.bussinnes.model.vo;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

// TODO: Auto-generated Javadoc
/**
 * The Class EtapaVO.
 */
public class EtapaVO extends BbvaAbstractValueObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6191925117960279672L;
	
	/** The descripcion etapa. */
	private String descripcionEtapa;
	
	/** The id estatus objeto. */
	private int idEstatusObjeto;
	
	/** The id etapa. */
	private int idEtapa;
	
	/** The nombre etapa. */
	private String nombreEtapa;
	
	/** The tipo etapa. */
	private String tipoEtapa;
	
	/**
	 * Gets the descripcion etapa.
	 *
	 * @return the descripcionEtapa
	 */
	public String getDescripcionEtapa() {
		return descripcionEtapa;
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
	 * Gets the id etapa.
	 *
	 * @return the idEtapa
	 */
	public int getIdEtapa() {
		return idEtapa;
	}
	
	/**
	 * Gets the nombre etapa.
	 *
	 * @return the nombreEtapa
	 */
	public String getNombreEtapa() {
		return nombreEtapa;
	}
	
	/**
	 * Gets the tipo etapa.
	 *
	 * @return the tipoEtapa
	 */
	public String getTipoEtapa() {
		return tipoEtapa;
	}
	
	/**
	 * Sets the descripcion etapa.
	 *
	 * @param descripcionEtapa the descripcionEtapa to set
	 */
	public void setDescripcionEtapa(String descripcionEtapa) {
		this.descripcionEtapa = descripcionEtapa;
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
	 * Sets the id etapa.
	 *
	 * @param idEtapa the idEtapa to set
	 */
	public void setIdEtapa(int idEtapa) {
		this.idEtapa = idEtapa;
	}
	
	/**
	 * Sets the nombre etapa.
	 *
	 * @param nombreEtapa the nombreEtapa to set
	 */
	public void setNombreEtapa(String nombreEtapa) {
		this.nombreEtapa = nombreEtapa;
	}
	
	/**
	 * Sets the tipo etapa.
	 *
	 * @param tipoEtapa the tipoEtapa to set
	 */
	public void setTipoEtapa(String tipoEtapa) {
		this.tipoEtapa = tipoEtapa;
	}
	
}
