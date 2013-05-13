package mx.com.bbva.bancomer.producto.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ProductoVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

public class ProductoDTO extends BbvaAbstractDataTransferObject   {

	private static final long serialVersionUID = 5791792209628768160L;
	private List<ProductoVO> productoVOs;
	private List<EstatusObjetoVO> estatusObjetoVOs;
	private ProductoVO productoVO;
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
	 * @return the productoVO
	 */
	public ProductoVO getProductoVO() {
		return productoVO;
	}
	/**
	 * @param productoVO the productoVO to set
	 */
	public void setProductoVO(ProductoVO productoVO) {
		this.productoVO = productoVO;
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
