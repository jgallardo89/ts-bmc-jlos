package mx.com.bbva.bancomer.commons.model.vo;

import java.math.BigDecimal;

public class PantallaVO extends BbvaAbstractValueObject {
	private long idPantalla;	
	private String nombrePantalla;
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
	private BigDecimal numeroOrdenPantalla;
	private long idPantallaPadre;
	
}
