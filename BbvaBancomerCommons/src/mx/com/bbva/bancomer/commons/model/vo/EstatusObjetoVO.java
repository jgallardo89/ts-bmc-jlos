package mx.com.bbva.bancomer.commons.model.vo;

import java.math.BigDecimal;

public class EstatusObjetoVO extends BbvaAbstractValueObject {
	private int idEstatusObjeto;
	private int idEstatusClave;
	private String nombreEstatusObjeto;
	private String descripcionEstatusObjeto;
	private String nombreStatusClave;
	/**
	 * @return the nombreStatusClave
	 */
	public String getNombreStatusClave() {
		return nombreStatusClave;
	}
	/**
	 * @param nombreStatusClave the nombreStatusClave to set
	 */
	public void setNombreStatusClave(String nombreStatusClave) {
		this.nombreStatusClave = nombreStatusClave;
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
	 * @return the idEstatusClave
	 */
	public int getIdEstatusClave() {
		return idEstatusClave;
	}
	/**
	 * @param idEstatusClave the idEstatusClave to set
	 */
	public void setIdEstatusClave(int idEstatusClave) {
		this.idEstatusClave = idEstatusClave;
	}
	/**
	 * @return the nombreEstatusOjeto
	 */
	public String getNombreEstatusObjeto() {
		return nombreEstatusObjeto;
	}
	/**
	 * @param nombreEstatusOjeto the nombreEstatusOjeto to set
	 */
	public void setNombreEstatusObjeto(String nombreEstatusObjeto) {
		this.nombreEstatusObjeto = nombreEstatusObjeto;
	}
	/**
	 * @return the descripcionEstatusObjeto
	 */
	public String getDescripcionEstatusObjeto() {
		return descripcionEstatusObjeto;
	}
	/**
	 * @param descripcionEstatusObjeto the descripcionEstatusObjeto to set
	 */
	public void setDescripcionEstatusObjeto(String descripcionEstatusObjeto) {
		this.descripcionEstatusObjeto = descripcionEstatusObjeto;
	}
	/**
	 * @return the nombreTabla
	 */
	public String getNombreTabla() {
		return nombreTabla;
	}
	/**
	 * @param nombreTabla the nombreTabla to set
	 */
	public void setNombreTabla(String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}
	private String nombreTabla;
}
