package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.util.Date;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

public class MonitoreoArchivosVO extends BbvaAbstractValueObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8916029173495268613L;
	private long idRegArchEntraPapa;
	private long idRegArchCirPapa;
	private String nombreArchEntraPapa;
	private String numeroLotePapa;
	private Date fechaRegArchEntraPapa;
	private long idEstadoArchivoPapa;
	private String nombreEstadoArchivoPapa;
	private long idRegArchEntraHijo;
	private String nombreArchEntraHijo;
	private long idEstadoArchivoHijo;
	private String nombreEstadoArchivoHijo;
	/**
	 * 
	 */
	public MonitoreoArchivosVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param idRegArchEntraPapa
	 * @param idRegArchCirPapa
	 * @param nombreArchEntraPapa
	 * @param numeroLotePapa
	 * @param fechaRegArchEntraPapa
	 * @param idEstadoArchivoPapa
	 * @param nombreEstadoArchivoPapa
	 * @param idRegArchEntraHijo
	 * @param nombreArchEntraHijo
	 * @param idEstadoArchivoHijo
	 * @param nombreEstadoArchivoHijo
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
	 * @return the idRegArchEntraPapa
	 */
	public long getIdRegArchEntraPapa() {
		return idRegArchEntraPapa;
	}
	/**
	 * @param idRegArchEntraPapa the idRegArchEntraPapa to set
	 */
	public void setIdRegArchEntraPapa(long idRegArchEntraPapa) {
		this.idRegArchEntraPapa = idRegArchEntraPapa;
	}
	/**
	 * @return the idRegArchCirPapa
	 */
	public long getIdRegArchCirPapa() {
		return idRegArchCirPapa;
	}
	/**
	 * @param idRegArchCirPapa the idRegArchCirPapa to set
	 */
	public void setIdRegArchCirPapa(long idRegArchCirPapa) {
		this.idRegArchCirPapa = idRegArchCirPapa;
	}
	/**
	 * @return the nombreArchEntraPapa
	 */
	public String getNombreArchEntraPapa() {
		return nombreArchEntraPapa;
	}
	/**
	 * @param nombreArchEntraPapa the nombreArchEntraPapa to set
	 */
	public void setNombreArchEntraPapa(String nombreArchEntraPapa) {
		this.nombreArchEntraPapa = nombreArchEntraPapa;
	}
	/**
	 * @return the numeroLotePapa
	 */
	public String getNumeroLotePapa() {
		return numeroLotePapa;
	}
	/**
	 * @param numeroLotePapa the numeroLotePapa to set
	 */
	public void setNumeroLotePapa(String numeroLotePapa) {
		this.numeroLotePapa = numeroLotePapa;
	}
	/**
	 * @return the fechaRegArchEntraPapa
	 */
	public Date getFechaRegArchEntraPapa() {
		return fechaRegArchEntraPapa;
	}
	/**
	 * @param fechaRegArchEntraPapa the fechaRegArchEntraPapa to set
	 */
	public void setFechaRegArchEntraPapa(Date fechaRegArchEntraPapa) {
		this.fechaRegArchEntraPapa = fechaRegArchEntraPapa;
	}
	/**
	 * @return the idEstadoArchivoPapa
	 */
	public long getIdEstadoArchivoPapa() {
		return idEstadoArchivoPapa;
	}
	/**
	 * @param idEstadoArchivoPapa the idEstadoArchivoPapa to set
	 */
	public void setIdEstadoArchivoPapa(long idEstadoArchivoPapa) {
		this.idEstadoArchivoPapa = idEstadoArchivoPapa;
	}
	/**
	 * @return the nombreEstadoArchivoPapa
	 */
	public String getNombreEstadoArchivoPapa() {
		return nombreEstadoArchivoPapa;
	}
	/**
	 * @param nombreEstadoArchivoPapa the nombreEstadoArchivoPapa to set
	 */
	public void setNombreEstadoArchivoPapa(String nombreEstadoArchivoPapa) {
		this.nombreEstadoArchivoPapa = nombreEstadoArchivoPapa;
	}
	/**
	 * @return the idRegArchEntraHijo
	 */
	public long getIdRegArchEntraHijo() {
		return idRegArchEntraHijo;
	}
	/**
	 * @param idRegArchEntraHijo the idRegArchEntraHijo to set
	 */
	public void setIdRegArchEntraHijo(long idRegArchEntraHijo) {
		this.idRegArchEntraHijo = idRegArchEntraHijo;
	}
	/**
	 * @return the nombreArchEntraHijo
	 */
	public String getNombreArchEntraHijo() {
		return nombreArchEntraHijo;
	}
	/**
	 * @param nombreArchEntraHijo the nombreArchEntraHijo to set
	 */
	public void setNombreArchEntraHijo(String nombreArchEntraHijo) {
		this.nombreArchEntraHijo = nombreArchEntraHijo;
	}
	/**
	 * @return the idEstadoArchivoHijo
	 */
	public long getIdEstadoArchivoHijo() {
		return idEstadoArchivoHijo;
	}
	/**
	 * @param idEstadoArchivoHijo the idEstadoArchivoHijo to set
	 */
	public void setIdEstadoArchivoHijo(long idEstadoArchivoHijo) {
		this.idEstadoArchivoHijo = idEstadoArchivoHijo;
	}
	/**
	 * @return the nombreEstadoArchivoHijo
	 */
	public String getNombreEstadoArchivoHijo() {
		return nombreEstadoArchivoHijo;
	}
	/**
	 * @param nombreEstadoArchivoHijo the nombreEstadoArchivoHijo to set
	 */
	public void setNombreEstadoArchivoHijo(String nombreEstadoArchivoHijo) {
		this.nombreEstadoArchivoHijo = nombreEstadoArchivoHijo;
	}
	
}
