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
 * Nombre de clase: MapCanal.java
 * Nombre de paquete: mappers.canal
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mappers.canal;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.CanalVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface MapCanal.
 */
public abstract interface MapCanal {
	
	/**
	 * Actualizar canal.
	 *
	 * @param canalVO the canal vo
	 */
	public abstract void actualizarCanal(CanalVO canalVO);
	
	/**
	 * Crear canal.
	 *
	 * @param canalVO the canal vo
	 */
	public abstract void crearCanal(CanalVO canalVO);
	
	/**
	 * Obtener canales.
	 *
	 * @param canalVO the canal vo
	 * @return the list
	 */
	public abstract List<CanalVO> obtenerCanales(CanalVO canalVO);
	
	/**
	 * Obtener cmb canales.
	 *
	 * @param canalVO the canal vo
	 * @return the list
	 */
	public abstract List<CanalVO> obtenerCmbCanales(CanalVO canalVO);
}
