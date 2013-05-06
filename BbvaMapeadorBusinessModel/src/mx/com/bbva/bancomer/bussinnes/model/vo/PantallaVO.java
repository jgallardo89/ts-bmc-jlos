package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.math.BigDecimal;
import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

public class PantallaVO extends BbvaAbstractValueObject {
	
	private long idPantalla;	
	private String nombrePantalla;
	private BigDecimal numeroOrdenPantalla;
	private long idPantallaPadre;	
	private String descripcionPantalla;
	private String descripcionUrlIcon;
	/**
	 * @return the descripcionPantalla
	 */
	public final String getDescripcionPantalla() {
		return descripcionPantalla;
	}
	/**
	 * @param descripcionPantalla the descripcionPantalla to set
	 */
	public final void setDescripcionPantalla(String descripcionPantalla) {
		this.descripcionPantalla = descripcionPantalla;
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
	private long estatusPantalla;	
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
	public BigDecimal getNumeroOrdenPantalla() {
		return numeroOrdenPantalla;
	}
	/**
	 * @param numeroOrdenPantalla the numeroOrdenPantalla to set
	 */
	public void setNumeroOrdenPantalla(BigDecimal numeroOrdenPantalla) {
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
}
