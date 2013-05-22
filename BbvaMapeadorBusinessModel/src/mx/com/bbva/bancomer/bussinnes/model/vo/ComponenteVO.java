package mx.com.bbva.bancomer.bussinnes.model.vo;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

public class ComponenteVO extends BbvaAbstractValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5822068522237430017L;
	public long idPantalla;
	public long idComponente;
	public String nombreComponente;
	public int idTipoComponente;	
	public String idDefault;
	public long estatusComponen;
	public String nombrePantalla;
	public String nombreEstatus;
	public long idPerfil;
	public String nombreTipoComponente;
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
	 * @param idPantalla
	 * @param idComponente
	 * @param nombreComponente
	 * @param tipoComponente
	 * @param idDefault
	 * @param estatusComponen
	 * @param nombrePantalla
	 * @param nombreEstatus
	 */
	public ComponenteVO(long idPantalla, long idComponente,
			String nombreComponente, int idTipoComponente, String idDefault,
			long estatusComponen, String nombrePantalla, String nombreEstatus) {
		super();
		this.idPantalla = idPantalla;
		this.idComponente = idComponente;
		this.nombreComponente = nombreComponente;
		this.idTipoComponente = idTipoComponente;
		this.idDefault = idDefault;
		this.estatusComponen = estatusComponen;
		this.nombrePantalla = nombrePantalla;
		this.nombreEstatus = nombreEstatus;
	}
	/**
	 * 
	 */
	public ComponenteVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the idPantalla
	 */
	public long getIdPantalla() {
		return idPantalla;
	}
	/**
	 * @param idPantalla the idPantalla to set
	 */
	public void setIdPantalla(long idPantalla) {
		this.idPantalla = idPantalla;
	}
	/**
	 * @return the idComponente
	 */
	public long getIdComponente() {
		return idComponente;
	}
	/**
	 * @param idComponente the idComponente to set
	 */
	public void setIdComponente(long idComponente) {
		this.idComponente = idComponente;
	}
	/**
	 * @return the nombreComponente
	 */
	public String getNombreComponente() {
		return nombreComponente;
	}
	/**
	 * @param nombreComponente the nombreComponente to set
	 */
	public void setNombreComponente(String nombreComponente) {
		this.nombreComponente = nombreComponente;
	}
	/**
	 * @return the tipoComponente
	 */
	public int getIdTipoComponente() {
		return idTipoComponente;
	}
	/**
	 * @param tipoComponente the tipoComponente to set
	 */
	public void setIdTipoComponente(int idTipoComponente) {
		this.idTipoComponente = idTipoComponente;
	}
	/**
	 * @return the idDefault
	 */
	public String getIdDefault() {
		return idDefault;
	}
	/**
	 * @param idDefault the idDefault to set
	 */
	public void setIdDefault(String idDefault) {
		this.idDefault = idDefault;
	}
	/**
	 * @return the estatusComponen
	 */
	public long getEstatusComponen() {
		return estatusComponen;
	}
	/**
	 * @param estatusComponen the estatusComponen to set
	 */
	public void setEstatusComponen(long estatusComponen) {
		this.estatusComponen = estatusComponen;
	}
	/**
	 * @return the nombrePantalla
	 */
	public String getNombrePantalla() {
		return nombrePantalla;
	}
	/**
	 * @param nombrePantalla the nombrePantalla to set
	 */
	public void setNombrePantalla(String nombrePantalla) {
		this.nombrePantalla = nombrePantalla;
	}
	/**
	 * @return the nombreEstatus
	 */
	public String getNombreEstatus() {
		return nombreEstatus;
	}
	/**
	 * @param nombreEstatus the nombreEstatus to set
	 */
	public void setNombreEstatus(String nombreEstatus) {
		this.nombreEstatus = nombreEstatus;
	}
	
}
