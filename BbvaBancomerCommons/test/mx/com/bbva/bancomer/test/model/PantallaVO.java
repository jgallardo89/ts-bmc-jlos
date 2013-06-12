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
 * Nombre de proyecto: BbvaBancomerCommons
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
 * Nombre de paquete: mx.com.bbva.bancomer.test.model
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.test.model;

import java.math.BigDecimal;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

// TODO: Auto-generated Javadoc
/**
 * The Class PantallaVO.
 */
public class PantallaVO extends BbvaAbstractValueObject {
	
	/** The id pantalla. */
	private long idPantalla;	
	
	/** The id pantalla padre. */
	private long idPantallaPadre;
	
	/** The nombre pantalla. */
	private String nombrePantalla;
	
	/** The numero orden pantalla. */
	private BigDecimal numeroOrdenPantalla;
	
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
	 * Gets the nombre pantalla.
	 *
	 * @return the nombrePantalla
	 */
	public String getNombrePantalla() {
		return nombrePantalla;
	}
	
	/**
	 * Gets the numero orden pantalla.
	 *
	 * @return the numeroOrdenPantalla
	 */
	public BigDecimal getNumeroOrdenPantalla() {
		return numeroOrdenPantalla;
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
	 * Sets the nombre pantalla.
	 *
	 * @param nombrePantalla the nombrePantalla to set
	 */
	public void setNombrePantalla(String nombrePantalla) {
		this.nombrePantalla = nombrePantalla;
	}
	
	/**
	 * Sets the numero orden pantalla.
	 *
	 * @param numeroOrdenPantalla the numeroOrdenPantalla to set
	 */
	public void setNumeroOrdenPantalla(BigDecimal numeroOrdenPantalla) {
		this.numeroOrdenPantalla = numeroOrdenPantalla;
	}
}
