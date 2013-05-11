package mx.com.bbva.bancomer.bussinnes.model.vo;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

public class PantallaVO extends BbvaAbstractValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5820561995974556157L;
	private long idPantalla;	
	private String nombrePantalla;
	private long numeroOrdenPantalla;
	private long idPantallaPadre;	
	private String descripcionUrlPantalla;
	private String descripcionUrlIcon;
	private long estatusPantalla;
	private String nombreEstatusObjeto;
	private String nombrePantallaPadre;
	
	/**
	 * @return the descripcionUrlPantalla
	 */
	public String getDescripcionUrlPantalla() {
		return descripcionUrlPantalla;
	}
	/**
	 * @param descripcionUrlPantalla the descripcionUrlPantalla to set
	 */
	public void setDescripcionUrlPantalla(String descripcionUrlPantalla) {
		this.descripcionUrlPantalla = descripcionUrlPantalla;
	}
	/**
	 * @return the descripcionUrlIcon
	 */
	public final String getDescripcionUrlIcon() {
		return descripcionUrlIcon;
	}
	/**
	 * @param descripcionUrlIcon the descripcionUrlIcon to set
	 */
	public final void setDescripcionUrlIcon(String descripcionUrlIcon) {
		this.descripcionUrlIcon = descripcionUrlIcon;
	}
	/**
	 * @return the estatusPantalla
	 */
	public final long getEstatusPantalla() {
		return estatusPantalla;
	}
	/**
	 * @param estatusPantalla the estatusPantalla to set
	 */
	public final void setEstatusPantalla(long estatusPantalla) {
		this.estatusPantalla = estatusPantalla;
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
	 * @return the numeroOrdenPantalla
	 */
	public long getNumeroOrdenPantalla() {
		return numeroOrdenPantalla;
	}
	/**
	 * @param numeroOrdenPantalla the numeroOrdenPantalla to set
	 */
	public void setNumeroOrdenPantalla(long numeroOrdenPantalla) {
		this.numeroOrdenPantalla = numeroOrdenPantalla;
	}
	/**
	 * @return the idPantallaPadre
	 */
	public long getIdPantallaPadre() {
		return idPantallaPadre;
	}
	/**
	 * @param idPantallaPadre the idPantallaPadre to set
	 */
	public void setIdPantallaPadre(long idPantallaPadre) {
		this.idPantallaPadre = idPantallaPadre;
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
	 * @return the descripcionPantallaPadre
	 */
	/**
	 * @return the nombrePantallaPadre
	 */
	public String getNombrePantallaPadre() {
		return nombrePantallaPadre;
	}
	/**
	 * @param nombrePantallaPadre the nombrePantallaPadre to set
	 */
	public void setNombrePantallaPadre(String nombrePantallaPadre) {
		this.nombrePantallaPadre = nombrePantallaPadre;
	}

	
}
