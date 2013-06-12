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
 * Nombre de clase: TipoComponenteVO.java
 * Nombre de paquete: mx.com.bbva.bancomer.bussinnes.model.vo
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.bussinnes.model.vo;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoComponenteVO.
 *
 * @author Julio Morales
 */
public class TipoComponenteVO extends BbvaAbstractValueObject {
	
	/** The existe. */
	private int existe;
	
	/** The id tipo componente. */
	private int idTipoComponente;
	
	/** The nombre tipo componente. */
	private String nombreTipoComponente;
	
	/**
	 * Gets the existe.
	 *
	 * @return the existe
	 */
	public final int getExiste() {
		return existe;
	}
	
	/**
	 * Gets the id tipo componente.
	 *
	 * @return the idTipoComponente
	 */
	public final int getIdTipoComponente() {
		return idTipoComponente;
	}
	
	/**
	 * Gets the nombre tipo componente.
	 *
	 * @return the nombreTipoComponente
	 */
	public final String getNombreTipoComponente() {
		return nombreTipoComponente;
	}
	
	/**
	 * Sets the existe.
	 *
	 * @param existe the existe to set
	 */
	public final void setExiste(int existe) {
		this.existe = existe;
	}
	
	/**
	 * Sets the id tipo componente.
	 *
	 * @param idTipoComponente the idTipoComponente to set
	 */
	public final void setIdTipoComponente(int idTipoComponente) {
		this.idTipoComponente = idTipoComponente;
	}
	
	/**
	 * Sets the nombre tipo componente.
	 *
	 * @param nombreTipoComponente the nombreTipoComponente to set
	 */
	public final void setNombreTipoComponente(String nombreTipoComponente) {
		this.nombreTipoComponente = nombreTipoComponente;
	}		
}
