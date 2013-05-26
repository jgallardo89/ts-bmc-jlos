package mx.com.bbva.bancomer.contratacionmap.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ContratacionMapVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

public class ContratacionMapDTO extends BbvaAbstractDataTransferObject  {

	private static final long serialVersionUID = -5533474387290995097L;
	private List<ContratacionMapVO> contratacionMapVOs;
	private ContratacionMapVO contratacionMapVO;
	/**
	 * @return the contratacionMapVOs
	 */
	public List<ContratacionMapVO> getContratacionMapVOs() {
		return contratacionMapVOs;
	}
	/**
	 * @param contratacionMapVOs the contratacionMapVOs to set
	 */
	public void setContratacionMapVOs(List<ContratacionMapVO> contratacionMapVOs) {
		this.contratacionMapVOs = contratacionMapVOs;
	}
	/**
	 * @return the contratacionMapVO
	 */
	public ContratacionMapVO getContratacionMapVO() {
		return contratacionMapVO;
	}
	/**
	 * @param contratacionMapVO the contratacionMapVO to set
	 */
	public void setContratacionMapVO(ContratacionMapVO contratacionMapVO) {
		this.contratacionMapVO = contratacionMapVO;
	}
	
}
