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
 * Nombre de proyecto: BbvaMapeadorBusinessModel
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
 * Nombre de clase: MonitoreoArchivosDTO.java
 * Nombre de paquete: mx.com.bbva.bancomer.monitoreoarchivos.dto
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.monitoreoarchivos.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstadoArchivoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MonitoreoArchivosVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

// TODO: Auto-generated Javadoc
/**
 * The Class MonitoreoArchivosDTO.
 */
public class MonitoreoArchivosDTO extends BbvaAbstractDataTransferObject {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1838624864417229783L;
	
	/** The estado archivo v os. */
	private List<EstadoArchivoVO> estadoArchivoVOs;
	
	/** The monitoreo archivos vo. */
	private MonitoreoArchivosVO monitoreoArchivosVO;
	
	/** The monitoreo archivos v os. */
	private List<MonitoreoArchivosVO> monitoreoArchivosVOs;
	
	/**
	 * Gets the estado archivo v os.
	 *
	 * @return the estadoArchivoVOs
	 */
	public List<EstadoArchivoVO> getEstadoArchivoVOs() {
		return estadoArchivoVOs;
	}
	
	/**
	 * Gets the monitoreo archivos vo.
	 *
	 * @return the monitoreoArchivosVO
	 */
	public MonitoreoArchivosVO getMonitoreoArchivosVO() {
		return monitoreoArchivosVO;
	}
	
	/**
	 * Gets the monitoreo archivos v os.
	 *
	 * @return the monitoreoArchivosVOs
	 */
	public List<MonitoreoArchivosVO> getMonitoreoArchivosVOs() {
		return monitoreoArchivosVOs;
	}
	
	/**
	 * Sets the estado archivo v os.
	 *
	 * @param estadoArchivoVOs the estadoArchivoVOs to set
	 */
	public void setEstadoArchivoVOs(List<EstadoArchivoVO> estadoArchivoVOs) {
		this.estadoArchivoVOs = estadoArchivoVOs;
	}
	
	/**
	 * Sets the monitoreo archivos vo.
	 *
	 * @param monitoreoArchivosVO the monitoreoArchivosVO to set
	 */
	public void setMonitoreoArchivosVO(MonitoreoArchivosVO monitoreoArchivosVO) {
		this.monitoreoArchivosVO = monitoreoArchivosVO;
	}
	
	/**
	 * Sets the monitoreo archivos v os.
	 *
	 * @param monitoreoArchivosVOs the monitoreoArchivosVOs to set
	 */
	public void setMonitoreoArchivosVOs(
			List<MonitoreoArchivosVO> monitoreoArchivosVOs) {
		this.monitoreoArchivosVOs = monitoreoArchivosVOs;
	}
	
}
