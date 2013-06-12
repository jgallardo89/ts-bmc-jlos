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
 * Nombre de clase: MapCliente.java
 * Nombre de paquete: mappers.cliente
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mappers.cliente;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ClienteVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface MapCliente.
 */
public abstract interface MapCliente {
	
	/**
	 * Actualizar cliente.
	 *
	 * @param clienteVO the cliente vo
	 */
	public abstract void actualizarCliente(ClienteVO clienteVO);
	
	/**
	 * Crear cliente.
	 *
	 * @param clienteVO the cliente vo
	 */
	public abstract void crearCliente(ClienteVO clienteVO);
	
	/**
	 * Obtener clientes.
	 *
	 * @param clienteVO the cliente vo
	 * @return the list
	 */
	public abstract List<ClienteVO> obtenerClientes(ClienteVO clienteVO);
	
	/**
	 * Obtener cmb clientes.
	 *
	 * @param clienteVO the cliente vo
	 * @return the list
	 */
	public abstract List<ClienteVO> obtenerCmbClientes(ClienteVO clienteVO);
}
