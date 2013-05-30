package mx.com.bbva.bancomer.bussinnes.model.vo;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

public class EstadoArchivoVO extends BbvaAbstractValueObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1378125264731591121L;
	public long idEstadoArchivo;
	public String nombreEstadoArchivo;
	/**
	 * 
	 */
	public EstadoArchivoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param idEstadoArchivo
	 * @param nombreEstadoArchivo
	 */
	public EstadoArchivoVO(long idEstadoArchivo, String nombreEstadoArchivo) {
		super();
		this.idEstadoArchivo = idEstadoArchivo;
		this.nombreEstadoArchivo = nombreEstadoArchivo;
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
