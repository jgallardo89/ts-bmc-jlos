package mx.com.bbva.bancomer.estatusobjeto.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.PerfilVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

public class PerfilDTO extends BbvaAbstractDataTransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2735361100983128133L;
	
	private PerfilVO perfilVO;

	private List<PerfilVO> perfilVOs;
	/**
	 * @return the perfilVO
	 */
	public PerfilVO getPerfilVO() {
		return perfilVO;
	}

	/**
	 * @param perfilVO the perfilVO to set
	 */
	public void setPerfilVO(PerfilVO perfilVO) {
		this.perfilVO = perfilVO;
	}

	/**
	 * @return the perfilVOs
	 */
	public List<PerfilVO> getPerfilVOs() {
		return perfilVOs;
	}

	/**
	 * @param perfilVOs the perfilVOs to set
	 */
	public void setPerfilVOs(List<PerfilVO> perfilVOs) {
		this.perfilVOs = perfilVOs;
	}

}
