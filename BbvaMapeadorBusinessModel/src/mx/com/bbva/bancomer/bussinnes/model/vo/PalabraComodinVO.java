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
 * Nombre de clase: PalabraComodinVO.java
 * Nombre de paquete: mx.com.bbva.bancomer.bussinnes.model.vo
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.bussinnes.model.vo;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

// TODO: Auto-generated Javadoc
/**
 * The Class PalabraComodinVO.
 *
 * @author Julio Morales
 */
public class PalabraComodinVO extends BbvaAbstractValueObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8401195388066841617L;
	
	/** The descripcion palabra comodin. */
	private String descripcionPalabraComodin;
	
	/** The id palabra comodin. */
	private int idPalabraComodin;
	
	/** The nombre palabra comodin. */
	private String nombrePalabraComodin;
	
	/**
	 * Gets the descripcion palabra comodin.
	 *
	 * @return the descripcionPalabraComodin
	 */
	public String getDescripcionPalabraComodin() {
		return descripcionPalabraComodin;
	}
	
	/**
	 * Gets the id palabra comodin.
	 *
	 * @return the idPalabraComodin
	 */
	public int getIdPalabraComodin() {
		return idPalabraComodin;
	}
	
	/**
	 * Gets the nombre palabra comodin.
	 *
	 * @return the nombrePalabraComodin
	 */
	public String getNombrePalabraComodin() {
		return nombrePalabraComodin;
	}
	
	/**
	 * Sets the descripcion palabra comodin.
	 *
	 * @param descripcionPalabraComodin the descripcionPalabraComodin to set
	 */
	public void setDescripcionPalabraComodin(String descripcionPalabraComodin) {
		this.descripcionPalabraComodin = descripcionPalabraComodin;
	}
	
	/**
	 * Sets the id palabra comodin.
	 *
	 * @param idPalabraComodin the idPalabraComodin to set
	 */
	public void setIdPalabraComodin(int idPalabraComodin) {
		this.idPalabraComodin = idPalabraComodin;
	}
	
	/**
	 * Sets the nombre palabra comodin.
	 *
	 * @param nombrePalabraComodin the nombrePalabraComodin to set
	 */
	public void setNombrePalabraComodin(String nombrePalabraComodin) {
		this.nombrePalabraComodin = nombrePalabraComodin;
	}
}
