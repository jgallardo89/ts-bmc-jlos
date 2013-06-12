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
 * Nombre de clase: CampoDTO.java
 * Nombre de paquete: mx.com.bbva.bancomer.bitacora.dto
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.bitacora.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class CampoDTO.
 */
public class CampoDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5345154030968378742L;
	
	/** The nombre_campo. */
	private String nombre_campo;
	
	/** The valor_anterior. */
	private String valor_anterior;
	
	/** The valor_nuevo. */
	private String valor_nuevo;
	
	/**
	 * Gets the nombre_campo.
	 *
	 * @return the nombre_campo
	 */
	public String getNombre_campo() {
		return nombre_campo;
	}
	
	/**
	 * Gets the valor_anterior.
	 *
	 * @return the valor_anterior
	 */
	public String getValor_anterior() {
		return valor_anterior;
	}
	
	/**
	 * Gets the valor_nuevo.
	 *
	 * @return the valor_nuevo
	 */
	public String getValor_nuevo() {
		return valor_nuevo;
	}
	
	/**
	 * Sets the nombre_campo.
	 *
	 * @param nombre_campo the nombre_campo to set
	 */
	public void setNombre_campo(String nombre_campo) {
		this.nombre_campo = nombre_campo;
	}
	
	/**
	 * Sets the valor_anterior.
	 *
	 * @param valor_anterior the valor_anterior to set
	 */
	public void setValor_anterior(String valor_anterior) {
		this.valor_anterior = valor_anterior;
	}
	
	/**
	 * Sets the valor_nuevo.
	 *
	 * @param valor_nuevo the valor_nuevo to set
	 */
	public void setValor_nuevo(String valor_nuevo) {
		this.valor_nuevo = valor_nuevo;
	}
	
}
