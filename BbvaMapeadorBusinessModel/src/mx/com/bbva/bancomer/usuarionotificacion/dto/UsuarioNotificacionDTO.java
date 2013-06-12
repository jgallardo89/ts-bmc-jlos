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
 * Nombre de clase: UsuarioNotificacionDTO.java
 * Nombre de paquete: mx.com.bbva.bancomer.usuarionotificacion.dto
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.usuarionotificacion.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioNotificacionVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioNotificacionDTO.
 */
public class UsuarioNotificacionDTO extends BbvaAbstractDataTransferObject   {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4015342575614605865L;
	
	/** The estatus objeto v os. */
	private List<EstatusObjetoVO> estatusObjetoVOs;
	
	/** The id mensaje notificacion. */
	private int idMensajeNotificacion;
	
	/** The usuario notificacion vo. */
	private UsuarioNotificacionVO usuarioNotificacionVO;
	
	/** The usuario notificacion v os. */
	private List<UsuarioNotificacionVO> usuarioNotificacionVOs;
	
	/**
	 * Gets the estatus objeto v os.
	 *
	 * @return the estatusObjetoVOs
	 */
	public List<EstatusObjetoVO> getEstatusObjetoVOs() {
		return estatusObjetoVOs;
	}
	
	/**
	 * Gets the id mensaje notificacion.
	 *
	 * @return the idMensajeNotificacion
	 */
	public final int getIdMensajeNotificacion() {
		return idMensajeNotificacion;
	}
	
	/**
	 * Gets the usuario notificacion vo.
	 *
	 * @return the usuarioNotificacionVO
	 */
	public UsuarioNotificacionVO getUsuarioNotificacionVO() {
		return usuarioNotificacionVO;
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
	 * Sets the estatus objeto v os.
	 *
	 * @param estatusObjetoVOs the estatusObjetoVOs to set
	 */
	public void setEstatusObjetoVOs(List<EstatusObjetoVO> estatusObjetoVOs) {
		this.estatusObjetoVOs = estatusObjetoVOs;
	}
	
	/**
	 * Sets the id mensaje notificacion.
	 *
	 * @param idMensajeNotificacion the idMensajeNotificacion to set
	 */
	public final void setIdMensajeNotificacion(int idMensajeNotificacion) {
		this.idMensajeNotificacion = idMensajeNotificacion;
	}
	
	/**
	 * Sets the usuario notificacion vo.
	 *
	 * @param usuarioNotificacionVO the usuarioNotificacionVO to set
	 */
	public void setUsuarioNotificacionVO(UsuarioNotificacionVO usuarioNotificacionVO) {
		this.usuarioNotificacionVO = usuarioNotificacionVO;
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
	
	
}
