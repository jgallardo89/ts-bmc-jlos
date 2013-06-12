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
 * Nombre de clase: MapUsuario.java
 * Nombre de paquete: mappers.usuario
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mappers.usuario;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface MapUsuario.
 */
public interface MapUsuario {
	
	/**
	 * Actualizar usuario.
	 *
	 * @param usuarioVO the usuario vo
	 */
	public abstract void actualizarUsuario(UsuarioVO usuarioVO);
	
	/**
	 * Crear usuario.
	 *
	 * @param usuarioVO the usuario vo
	 */
	public abstract void crearUsuario(UsuarioVO usuarioVO);
	
	/**
	 * Obtener usuarios.
	 *
	 * @param usuarioVO the usuario vo
	 * @return the list
	 */
	public abstract List<UsuarioVO> obtenerUsuarios(UsuarioVO usuarioVO);
	
	/**
	 * Obtener usuarios bitacora.
	 *
	 * @return the list
	 */
	public abstract List<UsuarioVO> obtenerUsuariosBitacora();
}
