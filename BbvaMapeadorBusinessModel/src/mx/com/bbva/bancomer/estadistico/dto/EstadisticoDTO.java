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
 * Nombre de clase: EstadisticoDTO.java
 * Nombre de paquete: mx.com.bbva.bancomer.estadistico.dto
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.estadistico.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.CanalVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ClienteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstadisticoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ProductoVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticoDTO.
 */
public class EstadisticoDTO  extends BbvaAbstractDataTransferObject {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5614466808475865787L;
	
	/** The canal v os. */
	private List<CanalVO> canalVOs;
	
	/** The cliente v os. */
	private List<ClienteVO> clienteVOs;
	
	/** The estadistico vo. */
	private EstadisticoVO estadisticoVO;
	
	/** The estadistico v os. */
	private List<EstadisticoVO> estadisticoVOs;
	
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
	 * Gets the estadistico vo.
	 *
	 * @return the estadisticoVO
	 */
	public EstadisticoVO getEstadisticoVO() {
		return estadisticoVO;
	}
	
	/**
	 * Gets the estadistico v os.
	 *
	 * @return the estadisticoVOs
	 */
	public List<EstadisticoVO> getEstadisticoVOs() {
		return estadisticoVOs;
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
	 * Sets the estadistico vo.
	 *
	 * @param estadisticoVO the estadisticoVO to set
	 */
	public void setEstadisticoVO(EstadisticoVO estadisticoVO) {
		this.estadisticoVO = estadisticoVO;
	}
	
	/**
	 * Sets the estadistico v os.
	 *
	 * @param estadisticoVOs the estadisticoVOs to set
	 */
	public void setEstadisticoVOs(List<EstadisticoVO> estadisticoVOs) {
		this.estadisticoVOs = estadisticoVOs;
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
