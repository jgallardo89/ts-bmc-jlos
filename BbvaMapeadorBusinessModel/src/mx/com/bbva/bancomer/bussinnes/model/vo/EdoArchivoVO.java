package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.util.Date;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

public class EdoArchivoVO extends BbvaAbstractValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -509546938184201234L;
	private long idRegArchEntra;
	private long idEdoArchivo;
	private long idEstadoArchivo; 
	private Date horaEstadoArchivo;
	private Date fechaEstadoArchivo;
	private long idEstatusObjeto;
	private String nombreEstatusObjeto;
	private String nombreEstadoArchivo;
	/**
	 * 
	 */
	public EdoArchivoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param idRegArchEntra
	 * @param idEdoArchivo
	 * @param idEstadoArchivo
	 * @param horaEstadoArchivo
	 * @param fechaEstadoArchivo
	 * @param idEstatusObjeto
	 * @param nombreEstatusObjeto
	 * @param nombreEstadoArchivo
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
	 * @return the idRegArchEntra
	 */
	public long getIdRegArchEntra() {
		return idRegArchEntra;
	}
	/**
	 * @param idRegArchEntra the idRegArchEntra to set
	 */
	public void setIdRegArchEntra(long idRegArchEntra) {
		this.idRegArchEntra = idRegArchEntra;
	}
	/**
	 * @return the idEdoArchivo
	 */
	public long getIdEdoArchivo() {
		return idEdoArchivo;
	}
	/**
	 * @param idEdoArchivo the idEdoArchivo to set
	 */
	public void setIdEdoArchivo(long idEdoArchivo) {
		this.idEdoArchivo = idEdoArchivo;
	}
	/**
	 * @return the idEstadoArchivo
	 */
	public long getIdEstadoArchivo() {
		return idEstadoArchivo;
	}
	/**
	 * @param idEstadoArchivo the idEstadoArchivo to set
	 */
	public void setIdEstadoArchivo(long idEstadoArchivo) {
		this.idEstadoArchivo = idEstadoArchivo;
	}
	/**
	 * @return the horaEstadoArchivo
	 */
	public Date getHoraEstadoArchivo() {
		return horaEstadoArchivo;
	}
	/**
	 * @param horaEstadoArchivo the horaEstadoArchivo to set
	 */
	public void setHoraEstadoArchivo(Date horaEstadoArchivo) {
		this.horaEstadoArchivo = horaEstadoArchivo;
	}
	/**
	 * @return the fechaEstadoArchivo
	 */
	public Date getFechaEstadoArchivo() {
		return fechaEstadoArchivo;
	}
	/**
	 * @param fechaEstadoArchivo the fechaEstadoArchivo to set
	 */
	public void setFechaEstadoArchivo(Date fechaEstadoArchivo) {
		this.fechaEstadoArchivo = fechaEstadoArchivo;
	}
	/**
	 * @return the idEstatusObjeto
	 */
	public long getIdEstatusObjeto() {
		return idEstatusObjeto;
	}
	/**
	 * @param idEstatusObjeto the idEstatusObjeto to set
	 */
	public void setIdEstatusObjeto(long idEstatusObjeto) {
		this.idEstatusObjeto = idEstatusObjeto;
	}
	/**
	 * @return the nombreEstatusObjeto
	 */
	public String getNombreEstatusObjeto() {
		return nombreEstatusObjeto;
	}
	/**
	 * @param nombreEstatusObjeto the nombreEstatusObjeto to set
	 */
	public void setNombreEstatusObjeto(String nombreEstatusObjeto) {
		this.nombreEstatusObjeto = nombreEstatusObjeto;
	}
	/**
	 * @return the nombreEstadoArchivo
	 */
	public String getNombreEstadoArchivo() {
		return nombreEstadoArchivo;
	}
	/**
	 * @param nombreEstadoArchivo the nombreEstadoArchivo to set
	 */
	public void setNombreEstadoArchivo(String nombreEstadoArchivo) {
		this.nombreEstadoArchivo = nombreEstadoArchivo;
	}
	
}
