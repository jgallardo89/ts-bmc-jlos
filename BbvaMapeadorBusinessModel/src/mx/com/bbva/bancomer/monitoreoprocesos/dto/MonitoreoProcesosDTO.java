package mx.com.bbva.bancomer.monitoreoprocesos.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.CanalVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ClienteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MonitoreoProcesosVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ProductoVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

public class MonitoreoProcesosDTO extends BbvaAbstractDataTransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6476770086264644016L;
	private MonitoreoProcesosVO monitoreoProcesosVO;
	private List<MonitoreoProcesosVO> monitoreoProcesosVOs;
	private List<CanalVO> canalVOs;
	private List<ClienteVO> clienteVOs;
	private List<ProductoVO> productoVOs;
	private List<EstatusObjetoVO> estatusObjetoVOs;
	/**
	 * @return the monitoreoProcesosVO
	 */
	public MonitoreoProcesosVO getMonitoreoProcesosVO() {
		return monitoreoProcesosVO;
	}
	/**
	 * @param monitoreoProcesosVO the monitoreoProcesosVO to set
	 */
	public void setMonitoreoProcesosVO(MonitoreoProcesosVO monitoreoProcesosVO) {
		this.monitoreoProcesosVO = monitoreoProcesosVO;
	}
	/**
	 * @return the monitoreoProcesosVOs
	 */
	public List<MonitoreoProcesosVO> getMonitoreoProcesosVOs() {
		return monitoreoProcesosVOs;
	}
	/**
	 * @param monitoreoProcesosVOs the monitoreoProcesosVOs to set
	 */
	public void setMonitoreoProcesosVOs(
			List<MonitoreoProcesosVO> monitoreoProcesosVOs) {
		this.monitoreoProcesosVOs = monitoreoProcesosVOs;
	}
	/**
	 * @return the canalVOs
	 */
	public List<CanalVO> getCanalVOs() {
		return canalVOs;
	}
	/**
	 * @param canalVOs the canalVOs to set
	 */
	public void setCanalVOs(List<CanalVO> canalVOs) {
		this.canalVOs = canalVOs;
	}
	/**
	 * @return the clienteVOs
	 */
	public List<ClienteVO> getClienteVOs() {
		return clienteVOs;
	}
	/**
	 * @param clienteVOs the clienteVOs to set
	 */
	public void setClienteVOs(List<ClienteVO> clienteVOs) {
		this.clienteVOs = clienteVOs;
	}
	/**
	 * @return the productoVOs
	 */
	public List<ProductoVO> getProductoVOs() {
		return productoVOs;
	}
	/**
	 * @param productoVOs the productoVOs to set
	 */
	public void setProductoVOs(List<ProductoVO> productoVOs) {
		this.productoVOs = productoVOs;
	}
	/**
	 * @return the estatusObjetoVOs
	 */
	public List<EstatusObjetoVO> getEstatusObjetoVOs() {
		return estatusObjetoVOs;
	}
	/**
	 * @param estatusObjetoVOs the estatusObjetoVOs to set
	 */
	public void setEstatusObjetoVOs(List<EstatusObjetoVO> estatusObjetoVOs) {
		this.estatusObjetoVOs = estatusObjetoVOs;
	}	
	
}
