package mx.com.bbva.bancomer.canal.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.CanalVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
public class CanalDTO extends BbvaAbstractDataTransferObject  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CanalVO> canalVOs;
	private List<EstatusObjetoVO> estatusObjetoVOs;
	private CanalVO canalVO;
	/**
	 * @return the canalVOs
	 */
	public List<CanalVO> getCanalVOs() {
		return canalVOs;
	}
	/**
	 * @param canalVOs the canalVOs to set
	 */
	public void setCanalVOs(List<CanalVO> canalVOs) {
		this.canalVOs = canalVOs;
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
	/**
	 * @return the canalVO
	 */
	public CanalVO getCanalVO() {
		return canalVO;
	}
	/**
	 * @param canalVO the canalVO to set
	 */
	public void setCanalVO(CanalVO canalVO) {
		this.canalVO = canalVO;
	}

	
}
