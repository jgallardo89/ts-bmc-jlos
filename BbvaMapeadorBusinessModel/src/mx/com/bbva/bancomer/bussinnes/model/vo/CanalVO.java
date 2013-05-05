package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.util.Date;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

public class CanalVO extends BbvaAbstractValueObject  {

	private int idCanal;
	private String nombreCanal;
	private String descripcionCanal;
	private Date fechaAlta;
	private String rutaCanalEntrada;
	private String rutaCanalSalida;
	private String nombreEstatusObjeto;
	
	/**
	 * @return the idCanal
	 */
	public int getIdCanal() {
		return idCanal;
	}
	/**
	 * @param idCanal the idCanal to set
	 */
	public void setIdCanal(int idCanal) {
		this.idCanal = idCanal;
	}
	/**
	 * @return the nombreCanal
	 */
	public String getNombreCanal() {
		return nombreCanal;
	}
	/**
	 * @param nombreCanal the nombreCanal to set
	 */
	public void setNombreCanal(String nombreCanal) {
		this.nombreCanal = nombreCanal;
	}
	/**
	 * @return the descripcionCanal
	 */
	public String getDescripcionCanal() {
		return descripcionCanal;
	}
	/**
	 * @param descripcionCanal the descripcionCanal to set
	 */
	public void setDescripcionCanal(String descripcionCanal) {
		this.descripcionCanal = descripcionCanal;
	}
	/**
	 * @return the fechaAlta
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}
	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	/**
	 * @return the rutaCanalEntrada
	 */
	public String getRutaCanalEntrada() {
		return rutaCanalEntrada;
	}
	/**
	 * @param rutaCanalEntrada the rutaCanalEntrada to set
	 */
	public void setRutaCanalEntrada(String rutaCanalEntrada) {
		this.rutaCanalEntrada = rutaCanalEntrada;
	}
	/**
	 * @return the rutaCanalSalida
	 */
	public String getRutaCanalSalida() {
		return rutaCanalSalida;
	}
	/**
	 * @param rutaCanalSalida the rutaCanalSalida to set
	 */
	public void setRutaCanalSalida(String rutaCanalSalida) {
		this.rutaCanalSalida = rutaCanalSalida;
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
	
	
}
