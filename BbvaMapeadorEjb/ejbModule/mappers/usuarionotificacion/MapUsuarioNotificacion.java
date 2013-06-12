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
 * Nombre de clase: MapUsuarioNotificacion.java
 * Nombre de paquete: mappers.usuarionotificacion
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mappers.usuarionotificacion;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioNotificacionVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface MapUsuarioNotificacion.
 */
public interface MapUsuarioNotificacion {
	
	/**
	 * Actualizar usuario notificacion.
	 *
	 * @param usuarioNotificacionVO the usuario notificacion vo
	 */
	public abstract void actualizarUsuarioNotificacion(UsuarioNotificacionVO usuarioNotificacionVO);
	
	/**
	 * Crear usuario notificacion.
	 *
	 * @param usuarioNotificacionVO the usuario notificacion vo
	 */
	public abstract void crearUsuarioNotificacion(UsuarioNotificacionVO usuarioNotificacionVO);
	
	/**
	 * Elimina usuario mensaje.
	 *
	 * @param idMensajeNotificacion the id mensaje notificacion
	 */
	public abstract void eliminaUsuarioMensaje(int idMensajeNotificacion);
	
	/**
	 * Existe usuario.
	 *
	 * @param usuarioNotificacionVO the usuario notificacion vo
	 * @return the list
	 */
	public abstract List<UsuarioNotificacionVO> existeUsuario(UsuarioNotificacionVO usuarioNotificacionVO);
	
	/**
	 * Inserta usuario mensaje.
	 *
	 * @param usuarioNotificacionVO the usuario notificacion vo
	 */
	public abstract void insertaUsuarioMensaje(UsuarioNotificacionVO usuarioNotificacionVO);
	
	/**
	 * Obtener list usuarios.
	 *
	 * @param usuarioNotificacionVO the usuario notificacion vo
	 * @return the list
	 */
	public abstract List<UsuarioNotificacionVO> obtenerListUsuarios(UsuarioNotificacionVO usuarioNotificacionVO);
	
	/**
	 * Obtener usuarios notificacion.
	 *
	 * @param usuarioNotificacionVO the usuario notificacion vo
	 * @return the list
	 */
	public abstract List<UsuarioNotificacionVO> obtenerUsuariosNotificacion(UsuarioNotificacionVO usuarioNotificacionVO);
	
	/**
	 * Obtener usuarios notificacion sistema asignados.
	 *
	 * @param usuarioNotificacionVO the usuario notificacion vo
	 * @return the list
	 */
	public abstract List<UsuarioNotificacionVO> obtenerUsuariosNotificacionSistemaAsignados(UsuarioNotificacionVO usuarioNotificacionVO);
	
	/**
	 * Obtener usuarios notificacion sistema no asignados.
	 *
	 * @param usuarioNotificacionVO the usuario notificacion vo
	 * @return the list
	 */
	public abstract List<UsuarioNotificacionVO> obtenerUsuariosNotificacionSistemaNoAsignados(UsuarioNotificacionVO usuarioNotificacionVO);
	
	/**
	 * Valida existe usuario.
	 *
	 * @param usuarioNotificacionVO the usuario notificacion vo
	 * @return the list
	 */
	public abstract List<UsuarioNotificacionVO> validaExisteUsuario(UsuarioNotificacionVO usuarioNotificacionVO);
}
