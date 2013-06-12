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
 * Nombre de clase: MapBitacora.java
 * Nombre de paquete: mappers.bitacora
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mappers.bitacora;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.BitacoraVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface MapBitacora.
 */
public abstract interface MapBitacora {
	
	/**
	 * Crear bitacora.
	 *
	 * @param bitacoraVO the bitacora vo
	 */
	public abstract void crearBitacora(BitacoraVO bitacoraVO);
	
	/**
	 * Obtener bitacora.
	 *
	 * @param bitacoraVO the bitacora vo
	 * @return the list
	 */
	public abstract List<BitacoraVO> obtenerBitacora(BitacoraVO bitacoraVO);
	
	/**
	 * Obtener detalle bitacora.
	 *
	 * @param bitacoraVO the bitacora vo
	 * @return the bitacora vo
	 */
	public abstract BitacoraVO obtenerDetalleBitacora(BitacoraVO bitacoraVO);
}
