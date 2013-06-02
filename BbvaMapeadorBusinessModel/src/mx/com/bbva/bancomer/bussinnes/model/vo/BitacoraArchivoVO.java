package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.util.Date;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

public class BitacoraArchivoVO extends BbvaAbstractValueObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7756929105459324889L;
	
	private String fechaArchivo;
	private String estadoArchivo;
	private String nombreArchivo;
	private Date fechaInici;
	private Date fechaFin;
	private int idEstatus;
	/**
	 * @return the idEstatus
	 */
	public final int getIdEstatus() {
		return idEstatus;
	}
	/**
	 * @param idEstatus the idEstatus to set
	 */
	public final void setIdEstatus(int idEstatus) {
		this.idEstatus = idEstatus;
	}
	/**
	 * @return the fechaInici
	 */
	public final Date getFechaInici() {
		return fechaInici;
	}
	/**
	 * @param fechaInici the fechaInici to set
	 */
	public final void setFechaInici(Date fechaInici) {
		this.fechaInici = fechaInici;
	}
	/**
	 * @return the fechaFin
	 */
	public final Date getFechaFin() {
		return fechaFin;
	}
	/**
	 * @param fechaFin the fechaFin to set
	 */
	public final void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}	
	/**
	 * @return the fechaArchivo
	 */
	public final String getFechaArchivo() {
		return fechaArchivo;
	}
	/**
	 * @param fechaArchivo the fechaArchivo to set
	 */
	public final void setFechaArchivo(String fechaArchivo) {
		this.fechaArchivo = fechaArchivo;
	}
	/**
	 * @return the estadoArchivo
	 */
	public final String getEstadoArchivo() {
		return estadoArchivo;
	}
	/**
	 * @param estadoArchivo the estadoArchivo to set
	 */
	public final void setEstadoArchivo(String estadoArchivo) {
		this.estadoArchivo = estadoArchivo;
	}
	/**
	 * @return the nombreArchivo
	 */
	public final String getNombreArchivo() {
		return nombreArchivo;
	}
	/**
	 * @param nombreArchivo the nombreArchivo to set
	 */
	public final void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	
}
