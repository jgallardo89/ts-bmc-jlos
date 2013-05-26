package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.util.Date;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

/**
 * @author Julio Morales
 *
 */
public class MensajeSalidaVO extends BbvaAbstractValueObject {

	private static final long serialVersionUID = -5486816589925844320L;
	private int idMensajeSalida;
	private String nombreMensajeSalida;
	private String descripcionMensajeSalida;
	private int idEstatusObjeto;
	private String nombreEstatusObjeto;
	private Date fechaAlta;
	private Date fechaModificacion;
	private String tipoNotificacion;
	
	/**
	 * @return the idMensajeSalida
	 */
	public int getIdMensajeSalida() {
		return idMensajeSalida;
	}
	/**
	 * @param idMensajeSalida the idMensajeSalida to set
	 */
	public void setIdMensajeSalida(int idMensajeSalida) {
		this.idMensajeSalida = idMensajeSalida;
	}
	/**
	 * @return the nombreMensajeSalida
	 */
	public String getNombreMensajeSalida() {
		return nombreMensajeSalida;
	}
	/**
	 * @param nombreMensajeSalida the nombreMensajeSalida to set
	 */
	public void setNombreMensajeSalida(String nombreMensajeSalida) {
		this.nombreMensajeSalida = nombreMensajeSalida;
	}
	/**
	 * @return the descripcionMensajeSalida
	 */
	public String getDescripcionMensajeSalida() {
		return descripcionMensajeSalida;
	}
	/**
	 * @param descripcionMensajeSalida the descripcionMensajeSalida to set
	 */
	public void setDescripcionMensajeSalida(String descripcionMensajeSalida) {
		this.descripcionMensajeSalida = descripcionMensajeSalida;
	}
	/**
	 * @return the idEstatusObjeto
	 */
	public int getIdEstatusObjeto() {
		return idEstatusObjeto;
	}
	/**
	 * @param idEstatusObjeto the idEstatusObjeto to set
	 */
	public void setIdEstatusObjeto(int idEstatusObjeto) {
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
	 * @return the fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	/**
	 * @return the tipoNotificacion
	 */
	public String getTipoNotificacion() {
		return tipoNotificacion;
	}
	/**
	 * @param tipoNotificacion the tipoNotificacion to set
	 */
	public void setTipoNotificacion(String tipoNotificacion) {
		this.tipoNotificacion = tipoNotificacion;
	}
	
}
