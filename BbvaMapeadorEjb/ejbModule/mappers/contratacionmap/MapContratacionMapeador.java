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
 * Nombre de proyecto: BbvaMapeadorEjb
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
 * Nombre de clase: MapContratacionMapeador.java
 * Nombre de paquete: mappers.contratacionmap
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mappers.contratacionmap;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ContratacionMapVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface MapContratacionMapeador.
 */
public abstract interface MapContratacionMapeador {
	
	/**
	 * Actualizar contratacion map.
	 *
	 * @param contratacionMapVO the contratacion map vo
	 */
	public abstract void actualizarContratacionMap(ContratacionMapVO contratacionMapVO);
	
	/**
	 * Crear contratacion map.
	 *
	 * @param contratacionMapVO the contratacion map vo
	 */
	public abstract void crearContratacionMap(ContratacionMapVO contratacionMapVO);
	
	/**
	 * Obtener contrataciones etapas map.
	 *
	 * @param contratacionMapVO the contratacion map vo
	 * @return the list
	 */
	public abstract List<ContratacionMapVO> obtenerContratacionesEtapasMap(ContratacionMapVO contratacionMapVO);
	
	/**
	 * Obtener contrataciones map.
	 *
	 * @param contratacionMapVO the contratacion map vo
	 * @return the list
	 */
	public abstract List<ContratacionMapVO> obtenerContratacionesMap(ContratacionMapVO contratacionMapVO);
	
	/**
	 * Valida mensaje contratacion map.
	 *
	 * @param contratacionMapVO the contratacion map vo
	 * @return the contratacion map vo
	 */
	public abstract ContratacionMapVO validaMensajeContratacionMap(ContratacionMapVO contratacionMapVO);
}
