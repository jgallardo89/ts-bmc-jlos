package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.util.Date;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

/**
 * @author Julio Morales
 *
 */
public class TipoComponenteVO extends BbvaAbstractValueObject {
	private int idTipoComponente;
	private String nombreTipoComponente;
	private int existe;
	/**
	 * @return the existe
	 */
	public final int getExiste() {
		return existe;
	}
	/**
	 * @param existe the existe to set
	 */
	public final void setExiste(int existe) {
		this.existe = existe;
	}
	/**
	 * @return the idTipoComponente
	 */
	public final int getIdTipoComponente() {
		return idTipoComponente;
	}
	/**
	 * @param idTipoComponente the idTipoComponente to set
	 */
	public final void setIdTipoComponente(int idTipoComponente) {
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
