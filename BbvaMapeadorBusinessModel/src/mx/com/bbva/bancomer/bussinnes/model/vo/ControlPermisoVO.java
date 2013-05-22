package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.util.Date;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

/**
 * @author Julio Morales
 *
 */
public class ControlPermisoVO extends BbvaAbstractValueObject {
	private long idPerfil;
	private long idComponente;
	private long idControlPermiso;
	/**
	 * @return the idPerfil
	 */
	public final long getIdPerfil() {
		return idPerfil;
	}
	/**
	 * @param idPerfil the idPerfil to set
	 */
	public final void setIdPerfil(long idPerfil) {
		this.idPerfil = idPerfil;
	}
	/**
	 * @return the idComponente
	 */
	public final long getIdComponente() {
		return idComponente;
	}
	/**
	 * @param idComponente the idComponente to set
	 */
	public final void setIdComponente(long idComponente) {
		this.idComponente = idComponente;
	}
	/**
	 * @return the idControlPermiso
	 */
	public final long getIdControlPermiso() {
		return idControlPermiso;
	}
	/**
	 * @param idControlPermiso the idControlPermiso to set
	 */
	public final void setIdControlPermiso(long idControlPermiso) {
		this.idControlPermiso = idControlPermiso;
	}
}
