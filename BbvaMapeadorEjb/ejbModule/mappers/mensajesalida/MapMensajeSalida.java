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
 * Nombre de clase: MapMensajeSalida.java
 * Nombre de paquete: mappers.mensajesalida
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mappers.mensajesalida;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.MensajeSalidaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface MapMensajeSalida.
 */
public abstract interface MapMensajeSalida {
	
	/**
	 * Actualizar mensaje salida.
	 *
	 * @param mensajeSalidaVO the mensaje salida vo
	 */
	public abstract void actualizarMensajeSalida(MensajeSalidaVO mensajeSalidaVO);
	
	/**
	 * Crear mensaje salida.
	 *
	 * @param mensajeSalidaVO the mensaje salida vo
	 */
	public abstract void crearMensajeSalida(MensajeSalidaVO mensajeSalidaVO);
	
	/**
	 * Obtener mensajes cmb salida.
	 *
	 * @return the list
	 */
	public abstract List<MensajeSalidaVO> obtenerMensajesCmbSalida();
	
	/**
	 * Obtener mensajes salida.
	 *
	 * @param mensajeSalidaVO the mensaje salida vo
	 * @return the list
	 */
	public abstract List<MensajeSalidaVO> obtenerMensajesSalida(MensajeSalidaVO mensajeSalidaVO);
	
	/**
	 * Obtener mensajes salida usuario.
	 *
	 * @return the list
	 */
	public abstract List<MensajeSalidaVO> obtenerMensajesSalidaUsuario();
	
	/**
	 * Valida mensajes salida.
	 *
	 * @param mensajeSalidaVO the mensaje salida vo
	 * @return the mensaje salida vo
	 */
	public abstract MensajeSalidaVO validaMensajesSalida(MensajeSalidaVO mensajeSalidaVO);
}
