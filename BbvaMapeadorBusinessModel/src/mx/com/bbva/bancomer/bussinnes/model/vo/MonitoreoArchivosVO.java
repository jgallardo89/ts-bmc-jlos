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
 * Nombre de clase: MonitoreoArchivosVO.java
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
 * The Class MonitoreoArchivosVO.
 */
public class MonitoreoArchivosVO extends BbvaAbstractValueObject {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8916029173495268613L;
	
	/** The fecha reg arch entra papa. */
	private Date fechaRegArchEntraPapa;
	
	/** The id estado archivo hijo. */
	private long idEstadoArchivoHijo;
	
	/** The id estado archivo papa. */
	private long idEstadoArchivoPapa;
	
	/** The id reg arch cir papa. */
	private long idRegArchCirPapa;
	
	/** The id reg arch entra hijo. */
	private long idRegArchEntraHijo;
	
	/** The id reg arch entra papa. */
	private long idRegArchEntraPapa;
	
	/** The nombre arch entra hijo. */
	private String nombreArchEntraHijo;
	
	/** The nombre arch entra papa. */
	private String nombreArchEntraPapa;
	
	/** The nombre estado archivo hijo. */
	private String nombreEstadoArchivoHijo;
	
	/** The nombre estado archivo papa. */
	private String nombreEstadoArchivoPapa;
	
	/** The numero lote papa. */
	private String numeroLotePapa;
	
	/** The url imagen reproceso. */
	private String urlImagenReproceso;
	
	/**
	 * Instantiates a new monitoreo archivos vo.
	 */
	public MonitoreoArchivosVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new monitoreo archivos vo.
	 *
	 * @param idRegArchEntraPapa the id reg arch entra papa
	 * @param idRegArchCirPapa the id reg arch cir papa
	 * @param nombreArchEntraPapa the nombre arch entra papa
	 * @param numeroLotePapa the numero lote papa
	 * @param fechaRegArchEntraPapa the fecha reg arch entra papa
	 * @param idEstadoArchivoPapa the id estado archivo papa
	 * @param nombreEstadoArchivoPapa the nombre estado archivo papa
	 * @param idRegArchEntraHijo the id reg arch entra hijo
	 * @param nombreArchEntraHijo the nombre arch entra hijo
	 * @param idEstadoArchivoHijo the id estado archivo hijo
	 * @param nombreEstadoArchivoHijo the nombre estado archivo hijo
	 */
	public MonitoreoArchivosVO(long idRegArchEntraPapa, long idRegArchCirPapa,
			String nombreArchEntraPapa, String numeroLotePapa,
			Date fechaRegArchEntraPapa, long idEstadoArchivoPapa,
			String nombreEstadoArchivoPapa, long idRegArchEntraHijo,
			String nombreArchEntraHijo, long idEstadoArchivoHijo,
			String nombreEstadoArchivoHijo) {
		super();
		this.idRegArchEntraPapa = idRegArchEntraPapa;
		this.idRegArchCirPapa = idRegArchCirPapa;
		this.nombreArchEntraPapa = nombreArchEntraPapa;
		this.numeroLotePapa = numeroLotePapa;
		this.fechaRegArchEntraPapa = fechaRegArchEntraPapa;
		this.idEstadoArchivoPapa = idEstadoArchivoPapa;
		this.nombreEstadoArchivoPapa = nombreEstadoArchivoPapa;
		this.idRegArchEntraHijo = idRegArchEntraHijo;
		this.nombreArchEntraHijo = nombreArchEntraHijo;
		this.idEstadoArchivoHijo = idEstadoArchivoHijo;
		this.nombreEstadoArchivoHijo = nombreEstadoArchivoHijo;
	}
	
	/**
	 * Gets the fecha reg arch entra papa.
	 *
	 * @return the fechaRegArchEntraPapa
	 */
	public Date getFechaRegArchEntraPapa() {
		return fechaRegArchEntraPapa;
	}
	
	/**
	 * Gets the id estado archivo hijo.
	 *
	 * @return the idEstadoArchivoHijo
	 */
	public long getIdEstadoArchivoHijo() {
		return idEstadoArchivoHijo;
	}
	
	/**
	 * Gets the id estado archivo papa.
	 *
	 * @return the idEstadoArchivoPapa
	 */
	public long getIdEstadoArchivoPapa() {
		return idEstadoArchivoPapa;
	}
	
	/**
	 * Gets the id reg arch cir papa.
	 *
	 * @return the idRegArchCirPapa
	 */
	public long getIdRegArchCirPapa() {
		return idRegArchCirPapa;
	}
	
	/**
	 * Gets the id reg arch entra hijo.
	 *
	 * @return the idRegArchEntraHijo
	 */
	public long getIdRegArchEntraHijo() {
		return idRegArchEntraHijo;
	}
	
	/**
	 * Gets the id reg arch entra papa.
	 *
	 * @return the idRegArchEntraPapa
	 */
	public long getIdRegArchEntraPapa() {
		return idRegArchEntraPapa;
	}
	
	/**
	 * Gets the nombre arch entra hijo.
	 *
	 * @return the nombreArchEntraHijo
	 */
	public String getNombreArchEntraHijo() {
		return nombreArchEntraHijo;
	}
	
	/**
	 * Gets the nombre arch entra papa.
	 *
	 * @return the nombreArchEntraPapa
	 */
	public String getNombreArchEntraPapa() {
		return nombreArchEntraPapa;
	}
	
	/**
	 * Gets the nombre estado archivo hijo.
	 *
	 * @return the nombreEstadoArchivoHijo
	 */
	public String getNombreEstadoArchivoHijo() {
		return nombreEstadoArchivoHijo;
	}
	
	/**
	 * Gets the nombre estado archivo papa.
	 *
	 * @return the nombreEstadoArchivoPapa
	 */
	public String getNombreEstadoArchivoPapa() {
		return nombreEstadoArchivoPapa;
	}
	
	/**
	 * Gets the numero lote papa.
	 *
	 * @return the numeroLotePapa
	 */
	public String getNumeroLotePapa() {
		return numeroLotePapa;
	}
	
	/**
	 * Gets the url imagen reproceso.
	 *
	 * @return the urlImagenReproceso
	 */
	public final String getUrlImagenReproceso() {
		return urlImagenReproceso;
	}
	
	/**
	 * Sets the fecha reg arch entra papa.
	 *
	 * @param fechaRegArchEntraPapa the fechaRegArchEntraPapa to set
	 */
	public void setFechaRegArchEntraPapa(Date fechaRegArchEntraPapa) {
		this.fechaRegArchEntraPapa = fechaRegArchEntraPapa;
	}
	
	/**
	 * Sets the id estado archivo hijo.
	 *
	 * @param idEstadoArchivoHijo the idEstadoArchivoHijo to set
	 */
	public void setIdEstadoArchivoHijo(long idEstadoArchivoHijo) {
		this.idEstadoArchivoHijo = idEstadoArchivoHijo;
	}
	
	/**
	 * Sets the id estado archivo papa.
	 *
	 * @param idEstadoArchivoPapa the idEstadoArchivoPapa to set
	 */
	public void setIdEstadoArchivoPapa(long idEstadoArchivoPapa) {
		this.idEstadoArchivoPapa = idEstadoArchivoPapa;
	}
	
	/**
	 * Sets the id reg arch cir papa.
	 *
	 * @param idRegArchCirPapa the idRegArchCirPapa to set
	 */
	public void setIdRegArchCirPapa(long idRegArchCirPapa) {
		this.idRegArchCirPapa = idRegArchCirPapa;
	}
	
	/**
	 * Sets the id reg arch entra hijo.
	 *
	 * @param idRegArchEntraHijo the idRegArchEntraHijo to set
	 */
	public void setIdRegArchEntraHijo(long idRegArchEntraHijo) {
		this.idRegArchEntraHijo = idRegArchEntraHijo;
	}
	
	/**
	 * Sets the id reg arch entra papa.
	 *
	 * @param idRegArchEntraPapa the idRegArchEntraPapa to set
	 */
	public void setIdRegArchEntraPapa(long idRegArchEntraPapa) {
		this.idRegArchEntraPapa = idRegArchEntraPapa;
	}
	
	/**
	 * Sets the nombre arch entra hijo.
	 *
	 * @param nombreArchEntraHijo the nombreArchEntraHijo to set
	 */
	public void setNombreArchEntraHijo(String nombreArchEntraHijo) {
		this.nombreArchEntraHijo = nombreArchEntraHijo;
	}
	
	/**
	 * Sets the nombre arch entra papa.
	 *
	 * @param nombreArchEntraPapa the nombreArchEntraPapa to set
	 */
	public void setNombreArchEntraPapa(String nombreArchEntraPapa) {
		this.nombreArchEntraPapa = nombreArchEntraPapa;
	}
	
	/**
	 * Sets the nombre estado archivo hijo.
	 *
	 * @param nombreEstadoArchivoHijo the nombreEstadoArchivoHijo to set
	 */
	public void setNombreEstadoArchivoHijo(String nombreEstadoArchivoHijo) {
		this.nombreEstadoArchivoHijo = nombreEstadoArchivoHijo;
	}
	
	/**
	 * Sets the nombre estado archivo papa.
	 *
	 * @param nombreEstadoArchivoPapa the nombreEstadoArchivoPapa to set
	 */
	public void setNombreEstadoArchivoPapa(String nombreEstadoArchivoPapa) {
		this.nombreEstadoArchivoPapa = nombreEstadoArchivoPapa;
	}
	
	/**
	 * Sets the numero lote papa.
	 *
	 * @param numeroLotePapa the numeroLotePapa to set
	 */
	public void setNumeroLotePapa(String numeroLotePapa) {
		this.numeroLotePapa = numeroLotePapa;
	}
	
	/**
	 * Sets the url imagen reproceso.
	 *
	 * @param urlImagenReproceso the urlImagenReproceso to set
	 */
	public final void setUrlImagenReproceso(String urlImagenReproceso) {
		this.urlImagenReproceso = urlImagenReproceso;
	}
	
}
