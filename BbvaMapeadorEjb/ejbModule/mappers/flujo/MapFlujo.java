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
 * Nombre de clase: MapFlujo.java
 * Nombre de paquete: mappers.flujo
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mappers.flujo;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.FlujoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface MapFlujo.
 */
public abstract interface MapFlujo {
	
	/**
	 * Actualizar flujo.
	 *
	 * @param flujoVO the flujo vo
	 */
	public abstract void actualizarFlujo(FlujoVO flujoVO);
	
	/**
	 * Obtener cb flujos.
	 *
	 * @param flujoVO the flujo vo
	 * @return the list
	 */
	public abstract List<FlujoVO> obtenerCBFlujos(FlujoVO flujoVO);
	
	/**
	 * Obtener flujos.
	 *
	 * @param flujoVO the flujo vo
	 * @return the list
	 */
	public abstract List<FlujoVO> obtenerFlujos(FlujoVO flujoVO);
}
