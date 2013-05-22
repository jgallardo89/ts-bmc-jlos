package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.util.Date;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

/**
 * @author Julio Morales
 *
 */
public class TipoComponenteVO extends BbvaAbstractValueObject {
	private long idTipoComponente;
	private String nombreTipoComponente;
	/**
	 * @return the idTipoComponente
	 */
	public final long getIdTipoComponente() {
		return idTipoComponente;
	}
	/**
	 * @param idTipoComponente the idTipoComponente to set
	 */
	public final void setIdTipoComponente(long idTipoComponente) {
		this.idTipoComponente = idTipoComponente;
	}
	/**
	 * @return the nombreTipoComponente
	 */
	public final String getNombreTipoComponente() {
		return nombreTipoComponente;
	}
	/**
	 * @param nombreTipoComponente the nombreTipoComponente to set
	 */
	public final void setNombreTipoComponente(String nombreTipoComponente) {
		this.nombreTipoComponente = nombreTipoComponente;
	}		
}
