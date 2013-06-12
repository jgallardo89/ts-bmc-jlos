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
 * Nombre de clase: MapMapaGmm.java
 * Nombre de paquete: mappers.mapagmm
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mappers.mapagmm;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.MapaGmmVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface MapMapaGmm.
 */
public interface MapMapaGmm {
	
	/**
	 * Actualizar mapa gmm.
	 *
	 * @param mapaGmmVO the mapa gmm vo
	 */
	public abstract void actualizarMapaGmm(MapaGmmVO mapaGmmVO);
	
	/**
	 * Crear mapa gmm.
	 *
	 * @param mapaGmmVO the mapa gmm vo
	 */
	public abstract void crearMapaGmm(MapaGmmVO mapaGmmVO);
	
	/**
	 * Obtener cmb mapa gmms.
	 *
	 * @return the list
	 */
	public abstract List<MapaGmmVO> obtenerCmbMapaGmms();
	
	/**
	 * Obtener mapa gmms.
	 *
	 * @param mapaGmmVO the mapa gmm vo
	 * @return the list
	 */
	public abstract List<MapaGmmVO> obtenerMapaGmms(MapaGmmVO mapaGmmVO);
}
