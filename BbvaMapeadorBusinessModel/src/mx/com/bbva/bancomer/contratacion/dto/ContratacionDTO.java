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
 * Nombre de clase: ContratacionDTO.java
 * Nombre de paquete: mx.com.bbva.bancomer.contratacion.dto
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.contratacion.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.CanalVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ClienteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ContratacionMapVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ContratacionVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MapaGmmVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MensajeSalidaVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ProductoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioNotificacionVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

// TODO: Auto-generated Javadoc
/**
 * The Class ContratacionDTO.
 */
public class ContratacionDTO extends BbvaAbstractDataTransferObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8914018281669157608L;
	
	/** The canal v os. */
	private List<CanalVO> canalVOs;
	
	/** The cliente v os. */
	private List<ClienteVO> clienteVOs;
	
	/** The contratacion map vo. */
	private ContratacionMapVO contratacionMapVO;
	
	/** The contratacion vo. */
	private ContratacionVO contratacionVO;
	
	/** The contratacion v os. */
	private List<ContratacionVO> contratacionVOs;
	
	/** The estatus objeto v os. */
	private List<EstatusObjetoVO> estatusObjetoVOs;
	
	/** The mapa gmm vo. */
	private MapaGmmVO mapaGmmVO;
	
	/** The mapa gmm v os. */
	private List<MapaGmmVO> mapaGmmVOs;
	
	/** The mensaje salida v os. */
	private List<MensajeSalidaVO> mensajeSalidaVOs;
	
	/** The producto v os. */
	private List<ProductoVO> productoVOs;
	
	/** The usuario notificacion contrata map v os. */
	private List<UsuarioNotificacionVO> usuarioNotificacionContrataMapVOs;
	
	/** The usuario notificacion v os. */
	private List<UsuarioNotificacionVO> usuarioNotificacionVOs;
	
	/** The usuario v os. */
	private List<UsuarioVO> usuarioVOs;
	
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
	 * Gets the contratacion map vo.
	 *
	 * @return the contratacionMapVO
	 */
	public ContratacionMapVO getContratacionMapVO() {
		return contratacionMapVO;
	}
	
	/**
	 * Gets the contratacion vo.
	 *
	 * @return the contratacionVO
	 */
	public ContratacionVO getContratacionVO() {
		return contratacionVO;
	}
	
	/**
	 * Gets the contratacion v os.
	 *
	 * @return the contratacionVOs
	 */
	public List<ContratacionVO> getContratacionVOs() {
		return contratacionVOs;
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
	 * Gets the mapa gmm vo.
	 *
	 * @return the mapaGmmVO
	 */
	public MapaGmmVO getMapaGmmVO() {
		return mapaGmmVO;
	}
	
	/**
	 * Gets the mapa gmm v os.
	 *
	 * @return the mapaGmmVOs
	 */
	public List<MapaGmmVO> getMapaGmmVOs() {
		return mapaGmmVOs;
	}
	
	/**
	 * Gets the mensaje salida v os.
	 *
	 * @return the mensajeSalidaVOs
	 */
	public List<MensajeSalidaVO> getMensajeSalidaVOs() {
		return mensajeSalidaVOs;
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
	 * Gets the usuario notificacion contrata map v os.
	 *
	 * @return the usuarioNotificacionContrataMapVOs
	 */
	public List<UsuarioNotificacionVO> getUsuarioNotificacionContrataMapVOs() {
		return usuarioNotificacionContrataMapVOs;
	}
	
	/**
	 * Gets the usuario notificacion v os.
	 *
	 * @return the usuarioNotificacionVOs
	 */
	public List<UsuarioNotificacionVO> getUsuarioNotificacionVOs() {
		return usuarioNotificacionVOs;
	}
	
	/**
	 * Gets the usuario v os.
	 *
	 * @return the usuarioVOs
	 */
	public List<UsuarioVO> getUsuarioVOs() {
		return usuarioVOs;
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
	 * Sets the contratacion map vo.
	 *
	 * @param contratacionMapVO the contratacionMapVO to set
	 */
	public void setContratacionMapVO(ContratacionMapVO contratacionMapVO) {
		this.contratacionMapVO = contratacionMapVO;
	}
	
	/**
	 * Sets the contratacion vo.
	 *
	 * @param contratacionVO the contratacionVO to set
	 */
	public void setContratacionVO(ContratacionVO contratacionVO) {
		this.contratacionVO = contratacionVO;
	}
	
	/**
	 * Sets the contratacion v os.
	 *
	 * @param contratacionVOs the contratacionVOs to set
	 */
	public void setContratacionVOs(List<ContratacionVO> contratacionVOs) {
		this.contratacionVOs = contratacionVOs;
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
	 * Sets the mapa gmm vo.
	 *
	 * @param mapaGmmVO the mapaGmmVO to set
	 */
	public void setMapaGmmVO(MapaGmmVO mapaGmmVO) {
		this.mapaGmmVO = mapaGmmVO;
	}
	
	/**
	 * Sets the mapa gmm v os.
	 *
	 * @param mapaGmmVOs the mapaGmmVOs to set
	 */
	public void setMapaGmmVOs(List<MapaGmmVO> mapaGmmVOs) {
		this.mapaGmmVOs = mapaGmmVOs;
	}
	
	/**
	 * Sets the mensaje salida v os.
	 *
	 * @param mensajeSalidaVOs the mensajeSalidaVOs to set
	 */
	public void setMensajeSalidaVOs(List<MensajeSalidaVO> mensajeSalidaVOs) {
		this.mensajeSalidaVOs = mensajeSalidaVOs;
	}
	
	/**
	 * Sets the producto v os.
	 *
	 * @param productoVOs the productoVOs to set
	 */
	public void setProductoVOs(List<ProductoVO> productoVOs) {
		this.productoVOs = productoVOs;
	}
	
	/**
	 * Sets the usuario notificacion contrata map v os.
	 *
	 * @param usuarioNotificacionContrataMapVOs the usuarioNotificacionContrataMapVOs to set
	 */
	public void setUsuarioNotificacionContrataMapVOs(
			List<UsuarioNotificacionVO> usuarioNotificacionContrataMapVOs) {
		this.usuarioNotificacionContrataMapVOs = usuarioNotificacionContrataMapVOs;
	}
	
	/**
	 * Sets the usuario notificacion v os.
	 *
	 * @param usuarioNotificacionVOs the usuarioNotificacionVOs to set
	 */
	public void setUsuarioNotificacionVOs(
			List<UsuarioNotificacionVO> usuarioNotificacionVOs) {
		this.usuarioNotificacionVOs = usuarioNotificacionVOs;
	}
	
	/**
	 * Sets the usuario v os.
	 *
	 * @param usuarioVOs the usuarioVOs to set
	 */
	public void setUsuarioVOs(List<UsuarioVO> usuarioVOs) {
		this.usuarioVOs = usuarioVOs;
	}
	
}
