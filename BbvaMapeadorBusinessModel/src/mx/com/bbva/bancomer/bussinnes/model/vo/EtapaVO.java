package mx.com.bbva.bancomer.bussinnes.model.vo;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

public class EtapaVO extends BbvaAbstractValueObject {

	private static final long serialVersionUID = -6191925117960279672L;
	private int idEtapa;
	private String nombreEtapa;
	private String descripcionEtapa;
	private String tipoEtapa;
	private int idEstatusObjeto;
	/**
	 * @return the idEtapa
	 */
	public int getIdEtapa() {
		return idEtapa;
	}
	/**
	 * @param idEtapa the idEtapa to set
	 */
	public void setIdEtapa(int idEtapa) {
		this.idEtapa = idEtapa;
	}
	/**
	 * @return the nombreEtapa
	 */
	public String getNombreEtapa() {
		return nombreEtapa;
	}
	/**
	 * @param nombreEtapa the nombreEtapa to set
	 */
	public void setNombreEtapa(String nombreEtapa) {
		this.nombreEtapa = nombreEtapa;
	}
	/**
	 * @return the descripcionEtapa
	 */
	public String getDescripcionEtapa() {
		return descripcionEtapa;
	}
	/**
	 * @param descripcionEtapa the descripcionEtapa to set
	 */
	public void setDescripcionEtapa(String descripcionEtapa) {
		this.descripcionEtapa = descripcionEtapa;
	}
	/**
	 * @return the tipoEtapa
	 */
	public String getTipoEtapa() {
		return tipoEtapa;
	}
	/**
	 * @param tipoEtapa the tipoEtapa to set
	 */
	public void setTipoEtapa(String tipoEtapa) {
		this.tipoEtapa = tipoEtapa;
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
	
}
