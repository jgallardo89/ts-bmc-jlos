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
 * Nombre de clase: MapMonitoreoProcesos.java
 * Nombre de paquete: mappers.monitoreoprocesos
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mappers.monitoreoprocesos;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EdoArchivoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MonitoreoProcesosVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.RegistroProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface MapMonitoreoProcesos.
 */
public interface MapMonitoreoProcesos {
	
	/**
	 * Actualizar estatus proceso.
	 *
	 * @param monitoreoProcesosVO the monitoreo procesos vo
	 */
	void actualizarEstatusProceso(MonitoreoProcesosVO monitoreoProcesosVO);
	
	/**
	 * Obtener edos archivo vo.
	 *
	 * @param edoArchivoVO the edo archivo vo
	 * @return the list
	 */
	List<EdoArchivoVO> obtenerEdosArchivoVO(EdoArchivoVO edoArchivoVO);
	
	/**
	 * Obtener monitoreo procesos vo.
	 *
	 * @param monitoreoProcesosVO the monitoreo procesos vo
	 * @return the list
	 */
	List<MonitoreoProcesosVO> obtenerMonitoreoProcesosVO(MonitoreoProcesosVO monitoreoProcesosVO);
	
	List<MonitoreoProcesosVO> obtieneCanalesProcesos(MonitoreoProcesosVO monitoreoProcesosVO);
	
	List<MonitoreoProcesosVO> obtieneEtapasArchivos(MonitoreoProcesosVO monitoreoProcesosVO);	
	/**
	 * Obtener registros proceso.
	 *
	 * @param registroPorcesoVO the registro porceso vo
	 * @return the list
	 */
	List<RegistroProcesoVO> obtenerRegistrosProceso(RegistroProcesoVO registroPorcesoVO);
	
}
