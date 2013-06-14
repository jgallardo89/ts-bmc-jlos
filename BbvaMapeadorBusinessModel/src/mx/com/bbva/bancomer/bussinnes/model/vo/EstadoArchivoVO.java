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
 * Nombre de clase: EstadoArchivoVO.java
 * Nombre de paquete: mx.com.bbva.bancomer.bussinnes.model.vo
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.bussinnes.model.vo;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadoArchivoVO.
 */
public class EstadoArchivoVO extends BbvaAbstractValueObject {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1378125264731591121L;
	
	/** The id estado archivo. */
	public long idEstadoArchivo;
	
	/** The nombre estado archivo. */
	public String nombreEstadoArchivo;
	
	public String descripcionEstadoArchivo;
	
	/**
	 * @return the descripcionEstadoArchivo
	 */
	public final String getDescripcionEstadoArchivo() {
		return descripcionEstadoArchivo;
	}

	/**
	 * @param descripcionEstadoArchivo the descripcionEstadoArchivo to set
	 */
	public final void setDescripcionEstadoArchivo(String descripcionEstadoArchivo) {
		this.descripcionEstadoArchivo = descripcionEstadoArchivo;
	}

	/**
	 * Instantiates a new estado archivo vo.
	 */
	public EstadoArchivoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new estado archivo vo.
	 *
	 * @param idEstadoArchivo the id estado archivo
	 * @param nombreEstadoArchivo the nombre estado archivo
	 */
	public EstadoArchivoVO(long idEstadoArchivo, String nombreEstadoArchivo) {
		super();
		this.idEstadoArchivo = idEstadoArchivo;
		this.nombreEstadoArchivo = nombreEstadoArchivo;
	}
	
	/**
	 * Gets the id estado archivo.
	 *
	 * @return the idEstadoArchivo
	 */
	public long getIdEstadoArchivo() {
		return idEstadoArchivo;
	}
	
	/**
	 * Gets the nombre estado archivo.
	 *
	 * @return the nombreEstadoArchivo
	 */
	public String getNombreEstadoArchivo() {
		return nombreEstadoArchivo;
	}
	
	/**
	 * Sets the id estado archivo.
	 *
	 * @param idEstadoArchivo the idEstadoArchivo to set
	 */
	public void setIdEstadoArchivo(long idEstadoArchivo) {
		this.idEstadoArchivo = idEstadoArchivo;
	}
	
	/**
	 * Sets the nombre estado archivo.
	 *
	 * @param nombreEstadoArchivo the nombreEstadoArchivo to set
	 */
	public void setNombreEstadoArchivo(String nombreEstadoArchivo) {
		this.nombreEstadoArchivo = nombreEstadoArchivo;
	}
	
}
