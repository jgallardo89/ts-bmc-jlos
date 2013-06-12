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
 * Nombre de clase: MapPantalla.java
 * Nombre de paquete: mappers.pantalla
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mappers.pantalla;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.PantallaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface MapPantalla.
 */
public abstract interface MapPantalla {
	
	/**
	 * Actualizar pantalla.
	 *
	 * @param pantallaVO the pantalla vo
	 */
	public abstract void actualizarPantalla(PantallaVO pantallaVO);
	
	/**
	 * Crear pantalla.
	 *
	 * @param pantallaVO the pantalla vo
	 */
	public abstract void crearPantalla(PantallaVO pantallaVO);
	
	/**
	 * Obtener pantallas.
	 *
	 * @param pantallaVO the pantalla vo
	 * @return the list
	 */
	public abstract List<PantallaVO> obtenerPantallas(PantallaVO pantallaVO);
}
