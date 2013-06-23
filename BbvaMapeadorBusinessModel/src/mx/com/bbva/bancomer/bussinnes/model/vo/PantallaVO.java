/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Informacion Confidencial:
 * Este software contiene informacion totalmente confidencial propiedad de Grupo Financiero BBVA Bancomer. 
 * Queda totalmente prohibido su uso o divulgacion en forma parcial o total y solamente podra ser utilizada de acuerdo a los terminos y estatutos 
 * que determine el Grupo Financiero BBVA Bancomer.
 * 
 * Todos los derechos reservados, Mexico 2013.
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * DESCRIPCION DEL PROGRAMA
 * Nombre de aplicación: MAPEADOR
 * Nombre de proyecto: BbvaMapeadorBusinessModel
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * HISTORIAL DE CAMBIOS:
 * 
 * Fecha:									         	
 * 30-ABR-2013  
 * @Author:	Jose Luis Ortiz Salazar
 * @Email: jortizsalazar@gmail.com    	
 * Razon: Creacion        
 * Version: 1.0.0
 * Nombre de clase: PantallaVO.java
 * Nombre de paquete: mx.com.bbva.bancomer.bussinnes.model.vo
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.bussinnes.model.vo;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

// TODO: Auto-generated Javadoc
/**
 * The Class PantallaVO.
 */
public class PantallaVO extends BbvaAbstractValueObject {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5820561995974556157L;
	
	/** The descripcion url icon. */
	private String descripcionUrlIcon;	
	
	/** The descripcion url pantalla. */
	private String descripcionUrlPantalla;
	
	/** The estatus pantalla. */
	private long estatusPantalla;
	
	/** The id baja. */
	private long idBaja;	
	
	/** The id pantalla. */
	private long idPantalla;
	
	/** The id pantalla padre. */
	private long idPantallaPadre;
	
	/** The nombre estatus objeto. */
	private String nombreEstatusObjeto;
	
	/** The nombre pantalla. */
	private String nombrePantalla;
	
	/** The nombre pantalla padre. */
	private String nombrePantallaPadre;
	
	/** The numero orden pantalla. */
	private long numeroOrdenPantalla;
	
	private int desdePerfiles;
	
	/**
	 * @return the desdePerfiles
	 */
	public final int getDesdePerfiles() {
		return desdePerfiles;
	}

	/**
	 * @param desdePerfiles the desdePerfiles to set
	 */
	public final void setDesdePerfiles(int desdePerfiles) {
		this.desdePerfiles = desdePerfiles;
	}

	/**
	 * Gets the descripcion url icon.
	 *
	 * @return the descripcionUrlIcon
	 */
	public final String getDescripcionUrlIcon() {
		return descripcionUrlIcon;
	}
	
	/**
	 * Gets the descripcion url pantalla.
	 *
	 * @return the descripcionUrlPantalla
	 */
	public String getDescripcionUrlPantalla() {
		return descripcionUrlPantalla;
	}
	
	/**
	 * Gets the estatus pantalla.
	 *
	 * @return the estatusPantalla
	 */
	public final long getEstatusPantalla() {
		return estatusPantalla;
	}
	
	/**
	 * Gets the id baja.
	 *
	 * @return the idBaja
	 */
	public long getIdBaja() {
		return idBaja;
	}
	
	/**
	 * Gets the id pantalla.
	 *
	 * @return the idPantalla
	 */
	public long getIdPantalla() {
		return idPantalla;
	}
	
	/**
	 * Gets the id pantalla padre.
	 *
	 * @return the idPantallaPadre
	 */
	public long getIdPantallaPadre() {
		return idPantallaPadre;
	}	
	
	/**
	 * Gets the nombre estatus objeto.
	 *
	 * @return the nombreEstatusObjeto
	 */
	public String getNombreEstatusObjeto() {
		return nombreEstatusObjeto;
	}
	
	/**
	 * Gets the nombre pantalla.
	 *
	 * @return the nombrePantalla
	 */
	public String getNombrePantalla() {
		return nombrePantalla;
	}
	
	/**
	 * Gets the nombre pantalla padre.
	 *
	 * @return the descripcionPantallaPadre
	 */
	/**
	 * @return the nombrePantallaPadre
	 */
	public String getNombrePantallaPadre() {
		return nombrePantallaPadre;
	}
	
	/**
	 * Gets the numero orden pantalla.
	 *
	 * @return the numeroOrdenPantalla
	 */
	public long getNumeroOrdenPantalla() {
		return numeroOrdenPantalla;
	}
	
	/**
	 * Sets the descripcion url icon.
	 *
	 * @param descripcionUrlIcon the descripcionUrlIcon to set
	 */
	public final void setDescripcionUrlIcon(String descripcionUrlIcon) {
		this.descripcionUrlIcon = descripcionUrlIcon;
	}
	
	/**
	 * Sets the descripcion url pantalla.
	 *
	 * @param descripcionUrlPantalla the descripcionUrlPantalla to set
	 */
	public void setDescripcionUrlPantalla(String descripcionUrlPantalla) {
		this.descripcionUrlPantalla = descripcionUrlPantalla;
	}
	
	/**
	 * Sets the estatus pantalla.
	 *
	 * @param estatusPantalla the estatusPantalla to set
	 */
	public final void setEstatusPantalla(long estatusPantalla) {
		this.estatusPantalla = estatusPantalla;
	}
	
	/**
	 * Sets the id baja.
	 *
	 * @param idBaja the idBaja to set
	 */
	public void setIdBaja(long idBaja) {
		this.idBaja = idBaja;
	}
	
	/**
	 * Sets the id pantalla.
	 *
	 * @param idPantalla the idPantalla to set
	 */
	public void setIdPantalla(long idPantalla) {
		this.idPantalla = idPantalla;
	}
	
	/**
	 * Sets the id pantalla padre.
	 *
	 * @param idPantallaPadre the idPantallaPadre to set
	 */
	public void setIdPantallaPadre(long idPantallaPadre) {
		this.idPantallaPadre = idPantallaPadre;
	}
	
	/**
	 * Sets the nombre estatus objeto.
	 *
	 * @param nombreEstatusObjeto the nombreEstatusObjeto to set
	 */
	public void setNombreEstatusObjeto(String nombreEstatusObjeto) {
		this.nombreEstatusObjeto = nombreEstatusObjeto;
	}
	
	/**
	 * Sets the nombre pantalla.
	 *
	 * @param nombrePantalla the nombrePantalla to set
	 */
	public void setNombrePantalla(String nombrePantalla) {
		this.nombrePantalla = nombrePantalla;
	}
	
	/**
	 * Sets the nombre pantalla padre.
	 *
	 * @param nombrePantallaPadre the nombrePantallaPadre to set
	 */
	public void setNombrePantallaPadre(String nombrePantallaPadre) {
		this.nombrePantallaPadre = nombrePantallaPadre;
	}
	
	/**
	 * Sets the numero orden pantalla.
	 *
	 * @param numeroOrdenPantalla the numeroOrdenPantalla to set
	 */
	public void setNumeroOrdenPantalla(long numeroOrdenPantalla) {
		this.numeroOrdenPantalla = numeroOrdenPantalla;
	}

	
}
