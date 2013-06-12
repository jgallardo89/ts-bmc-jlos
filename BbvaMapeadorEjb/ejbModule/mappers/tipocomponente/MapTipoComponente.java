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
 * Nombre de clase: MapTipoComponente.java
 * Nombre de paquete: mappers.tipocomponente
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mappers.tipocomponente;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.TipoComponenteVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface MapTipoComponente.
 */
public abstract interface MapTipoComponente {
	
	/**
	 * Actualizar tipo componente.
	 *
	 * @param tipoComponenteVO the tipo componente vo
	 */
	public abstract void actualizarTipoComponente(TipoComponenteVO tipoComponenteVO);
	
	/**
	 * Crear tipo componente.
	 *
	 * @param tipoComponenteVO the tipo componente vo
	 */
	public abstract void crearTipoComponente(TipoComponenteVO tipoComponenteVO);
	
	/**
	 * Obtener tipos componentes.
	 *
	 * @return the list
	 */
	public abstract List<TipoComponenteVO> obtenerTiposComponentes();
	
	/**
	 * Valida existe tipos componentes.
	 *
	 * @param tipoComponenteVO the tipo componente vo
	 * @return the list
	 */
	public abstract List<TipoComponenteVO> validaExisteTiposComponentes(TipoComponenteVO tipoComponenteVO);
}
