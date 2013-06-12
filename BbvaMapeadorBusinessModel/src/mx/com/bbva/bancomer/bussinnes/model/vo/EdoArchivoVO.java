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
 * Nombre de clase: EdoArchivoVO.java
 * Nombre de paquete: mx.com.bbva.bancomer.bussinnes.model.vo
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.util.Date;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

// TODO: Auto-generated Javadoc
/**
 * The Class EdoArchivoVO.
 */
public class EdoArchivoVO extends BbvaAbstractValueObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -509546938184201234L;
	
	/** The fecha estado archivo. */
	private Date fechaEstadoArchivo;
	
	/** The hora estado archivo. */
	private Date horaEstadoArchivo;
	
	/** The id edo archivo. */
	private long idEdoArchivo; 
	
	/** The id estado archivo. */
	private long idEstadoArchivo;
	
	/** The id estatus objeto. */
	private long idEstatusObjeto;
	
	/** The id reg arch entra. */
	private long idRegArchEntra;
	
	/** The nombre estado archivo. */
	private String nombreEstadoArchivo;
	
	/** The nombre estatus objeto. */
	private String nombreEstatusObjeto;
	
	/**
	 * Instantiates a new edo archivo vo.
	 */
	public EdoArchivoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new edo archivo vo.
	 *
	 * @param idRegArchEntra the id reg arch entra
	 * @param idEdoArchivo the id edo archivo
	 * @param idEstadoArchivo the id estado archivo
	 * @param horaEstadoArchivo the hora estado archivo
	 * @param fechaEstadoArchivo the fecha estado archivo
	 * @param idEstatusObjeto the id estatus objeto
	 * @param nombreEstatusObjeto the nombre estatus objeto
	 * @param nombreEstadoArchivo the nombre estado archivo
	 */
	public EdoArchivoVO(long idRegArchEntra, long idEdoArchivo,
			long idEstadoArchivo, Date horaEstadoArchivo,
			Date fechaEstadoArchivo, long idEstatusObjeto,
			String nombreEstatusObjeto, String nombreEstadoArchivo) {
		super();
		this.idRegArchEntra = idRegArchEntra;
		this.idEdoArchivo = idEdoArchivo;
		this.idEstadoArchivo = idEstadoArchivo;
		this.horaEstadoArchivo = horaEstadoArchivo;
		this.fechaEstadoArchivo = fechaEstadoArchivo;
		this.idEstatusObjeto = idEstatusObjeto;
		this.nombreEstatusObjeto = nombreEstatusObjeto;
		this.nombreEstadoArchivo = nombreEstadoArchivo;
	}
	
	/**
	 * Gets the fecha estado archivo.
	 *
	 * @return the fechaEstadoArchivo
	 */
	public Date getFechaEstadoArchivo() {
		return fechaEstadoArchivo;
	}
	
	/**
	 * Gets the hora estado archivo.
	 *
	 * @return the horaEstadoArchivo
	 */
	public Date getHoraEstadoArchivo() {
		return horaEstadoArchivo;
	}
	
	/**
	 * Gets the id edo archivo.
	 *
	 * @return the idEdoArchivo
	 */
	public long getIdEdoArchivo() {
		return idEdoArchivo;
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
	 * Gets the id estatus objeto.
	 *
	 * @return the idEstatusObjeto
	 */
	public long getIdEstatusObjeto() {
		return idEstatusObjeto;
	}
	
	/**
	 * Gets the id reg arch entra.
	 *
	 * @return the idRegArchEntra
	 */
	public long getIdRegArchEntra() {
		return idRegArchEntra;
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
	 * Gets the nombre estatus objeto.
	 *
	 * @return the nombreEstatusObjeto
	 */
	public String getNombreEstatusObjeto() {
		return nombreEstatusObjeto;
	}
	
	/**
	 * Sets the fecha estado archivo.
	 *
	 * @param fechaEstadoArchivo the fechaEstadoArchivo to set
	 */
	public void setFechaEstadoArchivo(Date fechaEstadoArchivo) {
		this.fechaEstadoArchivo = fechaEstadoArchivo;
	}
	
	/**
	 * Sets the hora estado archivo.
	 *
	 * @param horaEstadoArchivo the horaEstadoArchivo to set
	 */
	public void setHoraEstadoArchivo(Date horaEstadoArchivo) {
		this.horaEstadoArchivo = horaEstadoArchivo;
	}
	
	/**
	 * Sets the id edo archivo.
	 *
	 * @param idEdoArchivo the idEdoArchivo to set
	 */
	public void setIdEdoArchivo(long idEdoArchivo) {
		this.idEdoArchivo = idEdoArchivo;
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
	 * Sets the id estatus objeto.
	 *
	 * @param idEstatusObjeto the idEstatusObjeto to set
	 */
	public void setIdEstatusObjeto(long idEstatusObjeto) {
		this.idEstatusObjeto = idEstatusObjeto;
	}
	
	/**
	 * Sets the id reg arch entra.
	 *
	 * @param idRegArchEntra the idRegArchEntra to set
	 */
	public void setIdRegArchEntra(long idRegArchEntra) {
		this.idRegArchEntra = idRegArchEntra;
	}
	
	/**
	 * Sets the nombre estado archivo.
	 *
	 * @param nombreEstadoArchivo the nombreEstadoArchivo to set
	 */
	public void setNombreEstadoArchivo(String nombreEstadoArchivo) {
		this.nombreEstadoArchivo = nombreEstadoArchivo;
	}
	
	/**
	 * Sets the nombre estatus objeto.
	 *
	 * @param nombreEstatusObjeto the nombreEstatusObjeto to set
	 */
	public void setNombreEstatusObjeto(String nombreEstatusObjeto) {
		this.nombreEstatusObjeto = nombreEstatusObjeto;
	}
	
}
