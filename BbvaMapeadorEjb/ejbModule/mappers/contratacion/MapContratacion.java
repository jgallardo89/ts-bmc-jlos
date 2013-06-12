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
 * Nombre de clase: MapContratacion.java
 * Nombre de paquete: mappers.contratacion
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mappers.contratacion;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ContratacionVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface MapContratacion.
 */
public abstract interface MapContratacion {
	
	/**
	 * Actualizar contratacion.
	 *
	 * @param contratacionVO the contratacion vo
	 */
	public abstract void actualizarContratacion(ContratacionVO contratacionVO);
	
	/**
	 * Crear contratacion.
	 *
	 * @param contratacionVO the contratacion vo
	 */
	public abstract void crearContratacion(ContratacionVO contratacionVO);
	
	/**
	 * Obtener contrataciones.
	 *
	 * @param contratacionVO the contratacion vo
	 * @return the list
	 */
	public abstract List<ContratacionVO> obtenerContrataciones(ContratacionVO contratacionVO);
	
	/**
	 * Obtener contratacion etapas.
	 *
	 * @param contratacionVO the contratacion vo
	 * @return the list
	 */
	public abstract List<ContratacionVO> obtenerContratacionEtapas(ContratacionVO contratacionVO);
	
	/**
	 * Validar estatus contratacion.
	 *
	 * @param contratacionVO the contratacion vo
	 * @return the list
	 */
	public abstract List<ContratacionVO> validarEstatusContratacion(ContratacionVO contratacionVO);
	
	/**
	 * Validar proceso contratacion.
	 *
	 * @param contratacionVO the contratacion vo
	 * @return the contratacion vo
	 */
	public abstract ContratacionVO validarProcesoContratacion(ContratacionVO contratacionVO);
}
