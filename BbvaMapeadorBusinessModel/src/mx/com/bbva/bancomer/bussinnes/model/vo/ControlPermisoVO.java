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
	private long idPantalla;
	private long idUsuario;
	private String nombreComponente;
	private String idDefault;
	private boolean permiso;
	/**
	 * @return the nombreComponente
	 */
	public final String getNombreComponente() {
		return nombreComponente;
	}
	/**
	 * @param nombreComponente the nombreComponente to set
	 */
	public final void setNombreComponente(String nombreComponente) {
		this.nombreComponente = nombreComponente;
	}
	/**
	 * @return the idDefault
	 */
	public final String getIdDefault() {
		return idDefault;
	}
	/**
	 * @param idDefault the idDefault to set
	 */
	public final void setIdDefault(String idDefault) {
		this.idDefault = idDefault;
	}
	/**
	 * @return the permiso
	 */
	public final boolean isPermiso() {
		return permiso;
	}
	/**
	 * @param permiso the permiso to set
	 */
	public final void setPermiso(boolean permiso) {
		this.permiso = permiso;
	}
	/**
	 * @return the idUsuario
	 */
	public final long getIdUsuario() {
		return idUsuario;
	}
	/**
	 * @param idUsuario the idUsuario to set
	 */
	public final void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * @return the idPantalla
	 */
	public final long getIdPantalla() {
		return idPantalla;
	}
	/**
	 * @param idPantalla the idPantalla to set
	 */
	public final void setIdPantalla(long idPantalla) {
		this.idPantalla = idPantalla;
	}
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
