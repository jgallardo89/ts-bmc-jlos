package mx.com.bbva.bancomer.estadistico.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.CanalVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ClienteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstadisticoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ProductoVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

public class EstadisticoDTO  extends BbvaAbstractDataTransferObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5614466808475865787L;
	private EstadisticoVO estadisticoVO;
	private List<EstadisticoVO> estadisticoVOs;
	private List<CanalVO> canalVOs;
	private List<ClienteVO> clienteVOs;
	private List<ProductoVO> productoVOs;
	/**
	 * @return the estadisticoVO
	 */
	public EstadisticoVO getEstadisticoVO() {
		return estadisticoVO;
	}
	/**
	 * @param estadisticoVO the estadisticoVO to set
	 */
	public void setEstadisticoVO(EstadisticoVO estadisticoVO) {
		this.estadisticoVO = estadisticoVO;
	}
	/**
	 * @return the estadisticoVOs
	 */
	public List<EstadisticoVO> getEstadisticoVOs() {
		return estadisticoVOs;
	}
	/**
	 * @param estadisticoVOs the estadisticoVOs to set
	 */
	public void setEstadisticoVOs(List<EstadisticoVO> estadisticoVOs) {
		this.estadisticoVOs = estadisticoVOs;
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
	
    
}
