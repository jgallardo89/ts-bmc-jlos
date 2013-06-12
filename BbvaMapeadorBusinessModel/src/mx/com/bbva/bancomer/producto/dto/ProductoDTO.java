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
 * Nombre de clase: ProductoDTO.java
 * Nombre de paquete: mx.com.bbva.bancomer.producto.dto
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.producto.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ProductoVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductoDTO.
 */
public class ProductoDTO extends BbvaAbstractDataTransferObject   {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5791792209628768160L;
	
	/** The estatus objeto v os. */
	private List<EstatusObjetoVO> estatusObjetoVOs;
	
	/** The producto vo. */
	private ProductoVO productoVO;
	
	/** The producto v os. */
	private List<ProductoVO> productoVOs;
	
	/**
	 * Gets the estatus objeto v os.
	 *
	 * @return the estatusObjetoVOs
	 */
	public List<EstatusObjetoVO> getEstatusObjetoVOs() {
		return estatusObjetoVOs;
	}
	
	/**
	 * Gets the producto vo.
	 *
	 * @return the productoVO
	 */
	public ProductoVO getProductoVO() {
		return productoVO;
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
	 * Sets the estatus objeto v os.
	 *
	 * @param estatusObjetoVOs the estatusObjetoVOs to set
	 */
	public void setEstatusObjetoVOs(List<EstatusObjetoVO> estatusObjetoVOs) {
		this.estatusObjetoVOs = estatusObjetoVOs;
	}
	
	/**
	 * Sets the producto vo.
	 *
	 * @param productoVO the productoVO to set
	 */
	public void setProductoVO(ProductoVO productoVO) {
		this.productoVO = productoVO;
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
