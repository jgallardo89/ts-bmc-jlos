package mx.com.bbva.bancomer.mensajesalida.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MensajeSalidaVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

/**
 * @author Julio Morales
 */
public class MensajeSalidaDTO extends BbvaAbstractDataTransferObject  {

	private static final long serialVersionUID = 8915259237329127401L;
	
	private List<MensajeSalidaVO> mensajeSalidaVOs;
	private MensajeSalidaVO mensajeSalidaVO;
	private List<EstatusObjetoVO> estatusObjetoVOs;
	/**
	 * @return the mensajeSalidaVOs
	 */
	public List<MensajeSalidaVO> getMensajeSalidaVOs() {
		return mensajeSalidaVOs;
	}
	/**
	 * @param mensajeSalidaVOs the mensajeSalidaVOs to set
	 */
	public void setMensajeSalidaVOs(List<MensajeSalidaVO> mensajeSalidaVOs) {
		this.mensajeSalidaVOs = mensajeSalidaVOs;
	}
	/**
	 * @return the mensajeSalidaVO
	 */
	public MensajeSalidaVO getMensajeSalidaVO() {
		return mensajeSalidaVO;
	}
	/**
	 * @param mensajeSalidaVO the mensajeSalidaVO to set
	 */
	public void setMensajeSalidaVO(MensajeSalidaVO mensajeSalidaVO) {
		this.mensajeSalidaVO = mensajeSalidaVO;
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
