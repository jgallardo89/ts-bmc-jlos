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
 * Nombre de clase: MonitoreoProcesosDTO.java
 * Nombre de paquete: mx.com.bbva.bancomer.monitoreoprocesos.dto
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.monitoreoprocesos.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.CanalVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ClienteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MonitoreoProcesosVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ProductoVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

// TODO: Auto-generated Javadoc
/**
 * The Class MonitoreoProcesosDTO.
 */
public class MonitoreoProcesosDTO extends BbvaAbstractDataTransferObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6476770086264644016L;
	
	/** The canal v os. */
	private List<CanalVO> canalVOs;
	
	/** The cliente v os. */
	private List<ClienteVO> clienteVOs;
	
	/** The estatus objeto v os. */
	private List<EstatusObjetoVO> estatusObjetoVOs;
	
	/** The monitoreo procesos vo. */
	private MonitoreoProcesosVO monitoreoProcesosVO;
	
	/** The monitoreo procesos v os. */
	private List<MonitoreoProcesosVO> monitoreoProcesosVOs;
	
	/** The producto v os. */
	private List<ProductoVO> productoVOs;
	
	/**
	 * Gets the canal v os.
	 *
	 * @return the canalVOs
	 */
	public List<CanalVO> getCanalVOs() {
		return canalVOs;
	}
	
	/**
	 * Gets the cliente v os.
	 *
	 * @return the clienteVOs
	 */
	public List<ClienteVO> getClienteVOs() {
		return clienteVOs;
	}
	
	/**
	 * Gets the estatus objeto v os.
	 *
	 * @return the estatusObjetoVOs
	 */
	public List<EstatusObjetoVO> getEstatusObjetoVOs() {
		return estatusObjetoVOs;
	}
	
	/**
	 * Gets the monitoreo procesos vo.
	 *
	 * @return the monitoreoProcesosVO
	 */
	public MonitoreoProcesosVO getMonitoreoProcesosVO() {
		return monitoreoProcesosVO;
	}
	
	/**
	 * Gets the monitoreo procesos v os.
	 *
	 * @return the monitoreoProcesosVOs
	 */
	public List<MonitoreoProcesosVO> getMonitoreoProcesosVOs() {
		return monitoreoProcesosVOs;
	}
	
	/**
	 * Gets the producto v os.
	 *
	 * @return the productoVOs
	 */
	public List<ProductoVO> getProductoVOs() {
		return productoVOs;
	}
	
	/**
	 * Sets the canal v os.
	 *
	 * @param canalVOs the canalVOs to set
	 */
	public void setCanalVOs(List<CanalVO> canalVOs) {
		this.canalVOs = canalVOs;
	}
	
	/**
	 * Sets the cliente v os.
	 *
	 * @param clienteVOs the clienteVOs to set
	 */
	public void setClienteVOs(List<ClienteVO> clienteVOs) {
		this.clienteVOs = clienteVOs;
	}
	
	/**
	 * Sets the estatus objeto v os.
	 *
	 * @param estatusObjetoVOs the estatusObjetoVOs to set
	 */
	public void setEstatusObjetoVOs(List<EstatusObjetoVO> estatusObjetoVOs) {
		this.estatusObjetoVOs = estatusObjetoVOs;
	}
	
	/**
	 * Sets the monitoreo procesos vo.
	 *
	 * @param monitoreoProcesosVO the monitoreoProcesosVO to set
	 */
	public void setMonitoreoProcesosVO(MonitoreoProcesosVO monitoreoProcesosVO) {
		this.monitoreoProcesosVO = monitoreoProcesosVO;
	}
	
	/**
	 * Sets the monitoreo procesos v os.
	 *
	 * @param monitoreoProcesosVOs the monitoreoProcesosVOs to set
	 */
	public void setMonitoreoProcesosVOs(
			List<MonitoreoProcesosVO> monitoreoProcesosVOs) {
		this.monitoreoProcesosVOs = monitoreoProcesosVOs;
	}
	
	/**
	 * Sets the producto v os.
	 *
	 * @param productoVOs the productoVOs to set
	 */
	public void setProductoVOs(List<ProductoVO> productoVOs) {
		this.productoVOs = productoVOs;
	}	
	
}
