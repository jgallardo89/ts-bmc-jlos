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
 * Nombre de clase: MapEstatusObjeto.java
 * Nombre de paquete: mappers.estatusobjeto
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mappers.estatusobjeto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusClaveVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface MapEstatusObjeto.
 */
public abstract interface MapEstatusObjeto {
	
	/**
	 * Actualiza estatus objeto.
	 *
	 * @param estatusObjetoVO the estatus objeto vo
	 */
	public abstract void actualizaEstatusObjeto(EstatusObjetoVO estatusObjetoVO);
	
	/**
	 * Crear estatus objeto.
	 *
	 * @param estatusObjetoVO the estatus objeto vo
	 */
	public abstract void crearEstatusObjeto(EstatusObjetoVO estatusObjetoVO);
	
	/**
	 * Eliminar estatus objeto.
	 *
	 * @param estatusObjetoVO the estatus objeto vo
	 */
	public abstract void eliminarEstatusObjeto(EstatusObjetoVO estatusObjetoVO);
	
	/**
	 * Exist estatus objeto.
	 *
	 * @param estatusObjetoVO the estatus objeto vo
	 * @return the estatus objeto vo
	 */
	public abstract EstatusObjetoVO existEstatusObjeto(EstatusObjetoVO estatusObjetoVO);
	
	/**
	 * Obtener estatus clave.
	 *
	 * @param estatusClaveO the estatus clave o
	 * @return the list
	 */
	public abstract List<EstatusClaveVO> obtenerEstatusClave(EstatusClaveVO estatusClaveO);
	
	/**
	 * Obtener estatus objeto.
	 *
	 * @param estatusObjetoVO the estatus objeto vo
	 * @return the list
	 */
	public abstract List<EstatusObjetoVO> obtenerEstatusObjeto(EstatusObjetoVO estatusObjetoVO);
	
	/**
	 * Obtener nombre tabla.
	 *
	 * @return the list
	 */
	public abstract List<EstatusObjetoVO> obtenerNombreTabla();	
}
