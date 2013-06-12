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
 * Nombre de clase: MapProducto.java
 * Nombre de paquete: mappers.producto
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mappers.producto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ProductoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface MapProducto.
 */
public abstract interface MapProducto {
	
	/**
	 * Actualizar producto.
	 *
	 * @param productoVO the producto vo
	 */
	public abstract void actualizarProducto(ProductoVO productoVO);
	
	/**
	 * Crear producto.
	 *
	 * @param productoVO the producto vo
	 */
	public abstract void crearProducto(ProductoVO productoVO);
	
	/**
	 * Obtener cmb productos.
	 *
	 * @param productoVO the producto vo
	 * @return the list
	 */
	public abstract List<ProductoVO> obtenerCmbProductos(ProductoVO productoVO);
	
	/**
	 * Obtener productos.
	 *
	 * @param productoVO the producto vo
	 * @return the list
	 */
	public abstract List<ProductoVO> obtenerProductos(ProductoVO productoVO);
}
