package mx.com.bbva.bancomer.usuarionotificacion.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioNotificacionVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

public class UsuarioNotificacionDTO extends BbvaAbstractDataTransferObject   {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4015342575614605865L;
	private UsuarioNotificacionVO usuarioNotificacionVO;
	private List<UsuarioNotificacionVO> usuarioNotificacionVOs;
	private List<EstatusObjetoVO> estatusObjetoVOs;
	private int idMensajeNotificacion;
	/**
	 * @return the idMensajeNotificacion
	 */
	public final int getIdMensajeNotificacion() {
		return idMensajeNotificacion;
	}
	/**
	 * @param idMensajeNotificacion the idMensajeNotificacion to set
	 */
	public final void setIdMensajeNotificacion(int idMensajeNotificacion) {
		this.idMensajeNotificacion = idMensajeNotificacion;
	}
	/**
	 * @return the usuarioNotificacionVO
	 */
	public UsuarioNotificacionVO getUsuarioNotificacionVO() {
		return usuarioNotificacionVO;
	}
	/**
	 * @param usuarioNotificacionVO the usuarioNotificacionVO to set
	 */
	public void setUsuarioNotificacionVO(UsuarioNotificacionVO usuarioNotificacionVO) {
		this.usuarioNotificacionVO = usuarioNotificacionVO;
	}
	/**
	 * @return the usuarioNotificacionVOs
	 */
	public List<UsuarioNotificacionVO> getUsuarioNotificacionVOs() {
		return usuarioNotificacionVOs;
	}
	/**
	 * @param usuarioNotificacionVOs the usuarioNotificacionVOs to set
	 */
	public void setUsuarioNotificacionVOs(
			List<UsuarioNotificacionVO> usuarioNotificacionVOs) {
		this.usuarioNotificacionVOs = usuarioNotificacionVOs;
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
