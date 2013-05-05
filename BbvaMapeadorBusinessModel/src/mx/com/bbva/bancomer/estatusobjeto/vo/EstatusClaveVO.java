package mx.com.bbva.bancomer.estatusobjeto.vo;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

public class EstatusClaveVO extends BbvaAbstractValueObject {

	private int idEstatusClave;
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
	 * @return the nombreEstatusClave
	 */
	public String getNombreEstatusClave() {
		return nombreEstatusClave;
	}
	/**
	 * @param nombreEstatusClave the nombreEstatusClave to set
	 */
	public void setNombreEstatusClave(String nombreEstatusClave) {
		this.nombreEstatusClave = nombreEstatusClave;
	}
	private String nombreEstatusClave;	
}
