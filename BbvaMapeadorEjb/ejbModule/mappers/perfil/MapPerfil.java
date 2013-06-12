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
 * Nombre de clase: MapPerfil.java
 * Nombre de paquete: mappers.perfil
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mappers.perfil;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ControlPermisoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PerfilVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface MapPerfil.
 */
public interface MapPerfil {
	
	/**
	 * Actualizar perfil.
	 *
	 * @param perfilVO the perfil vo
	 */
	public abstract void actualizarPerfil(PerfilVO perfilVO);
	
	/**
	 * Eliminar permisos.
	 *
	 * @param controlPermisoVO the control permiso vo
	 */
	public abstract void eliminarPermisos(ControlPermisoVO controlPermisoVO);
	
	/**
	 * Insertar perfil.
	 *
	 * @param perfilVO the perfil vo
	 */
	public abstract void insertarPerfil(PerfilVO perfilVO);
	
	/**
	 * Insertar permiso.
	 *
	 * @param controlPermisoVO the control permiso vo
	 */
	public abstract void insertarPermiso(ControlPermisoVO controlPermisoVO);
	
	/**
	 * Obtener perfiles.
	 *
	 * @param perfilVO the perfil vo
	 * @return the list
	 */
	public abstract List<PerfilVO> obtenerPerfiles(PerfilVO perfilVO);
	
	/**
	 * Obtener permisos.
	 *
	 * @param controlPermisoVO the control permiso vo
	 * @return the list
	 */
	public abstract List<ControlPermisoVO> obtenerPermisos(ControlPermisoVO controlPermisoVO);	
}
