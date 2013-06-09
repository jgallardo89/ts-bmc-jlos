package mx.com.bbva.bancomer.tipocomponente.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ProductoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.TipoComponenteVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

public class TipoComponenteDTO extends BbvaAbstractDataTransferObject   {

	private static final long serialVersionUID = 5791792209628768160L;
	private TipoComponenteVO tipoComponenteVO;
	private List<TipoComponenteVO> tipoComponenteVOs;
	/**
	 * @return the tipoComponenteVO
	 */
	public final TipoComponenteVO getTipoComponenteVO() {
		return tipoComponenteVO;
	}
	/**
	 * @param tipoComponenteVO the tipoComponenteVO to set
	 */
	public final void setTipoComponenteVO(TipoComponenteVO tipoComponenteVO) {
		this.tipoComponenteVO = tipoComponenteVO;
	}
	/**
	 * @return the tipoComponenteVOs
	 */
	public final List<TipoComponenteVO> getTipoComponenteVOs() {
		return tipoComponenteVOs;
	}
	/**
	 * @param tipoComponenteVOs the tipoComponenteVOs to set
	 */
	public final void setTipoComponenteVOs(List<TipoComponenteVO> tipoComponenteVOs) {
		this.tipoComponenteVOs = tipoComponenteVOs;
	}
}
