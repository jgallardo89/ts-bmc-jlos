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
 * Nombre de clase: MapComponente.java
 * Nombre de paquete: mappers.componente
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mappers.componente;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ComponenteVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface MapComponente.
 */
public abstract interface MapComponente {
	
	/**
	 * Actualizar componente.
	 *
	 * @param componenteVO the componente vo
	 */
	public abstract void actualizarComponente(ComponenteVO componenteVO);
	
	/**
	 * Crear componente.
	 *
	 * @param pantallaVO the pantalla vo
	 */
	public abstract void crearComponente(ComponenteVO pantallaVO);
	
	/**
	 * Eliminar componente.
	 *
	 * @param componenteVO the componente vo
	 */
	public abstract void eliminarComponente(ComponenteVO componenteVO);
	
	/**
	 * Obtener componentes.
	 *
	 * @param componenteVO the componente vo
	 * @return the list
	 */
	public abstract List<ComponenteVO> obtenerComponentes(ComponenteVO componenteVO);
	
	/**
	 * Obtener componentes detalle perfil.
	 *
	 * @param componenteVO the componente vo
	 * @return the list
	 */
	public abstract List<ComponenteVO> obtenerComponentesDetallePerfil(ComponenteVO componenteVO);
	
	/**
	 * Obtener componentes pantalla.
	 *
	 * @param componenteVO the componente vo
	 * @return the list
	 */
	public abstract List<ComponenteVO> obtenerComponentesPantalla(ComponenteVO componenteVO);
	
	/**
	 * Obtener componentes pantalla perfil.
	 *
	 * @param componenteVO the componente vo
	 * @return the list
	 */
	public abstract List<ComponenteVO> obtenerComponentesPantallaPerfil(ComponenteVO componenteVO);
	
	/**
	 * Obtener componentes pantalla perfil all.
	 *
	 * @param componenteVO the componente vo
	 * @return the list
	 */
	public abstract List<ComponenteVO> obtenerComponentesPantallaPerfilAll(ComponenteVO componenteVO);
	public abstract List<ComponenteVO> obtenerComponentesPantallaPerfilToDupply(ComponenteVO componenteVO);
	
	/**
	 * Obtener componentes para eliminar.
	 *
	 * @param componenteVO the componente vo
	 * @return the list
	 */
	public abstract List<ComponenteVO> obtenerComponentesParaEliminar(ComponenteVO componenteVO);
	
}
