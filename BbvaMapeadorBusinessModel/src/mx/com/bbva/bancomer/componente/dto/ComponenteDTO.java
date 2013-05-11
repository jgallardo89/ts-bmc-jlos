package mx.com.bbva.bancomer.componente.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO; 
import mx.com.bbva.bancomer.bussinnes.model.vo.PantallaVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.bussinnes.model.vo.ComponenteVO;

public class ComponenteDTO extends BbvaAbstractDataTransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3144516741620752172L;
	private ComponenteVO ComponenteVO;  
	private List<ComponenteVO> ComponenteVOs; 
	private List<EstatusObjetoVO> estatusObjetoVOs;
	private List<PantallaVO> pantallaVOs;
	/**
	 * @return the componenteVO
	 */
	public ComponenteVO getComponenteVO() {
		return ComponenteVO;
	}
	/**
	 * @param componenteVO the componenteVO to set
	 */
	public void setComponenteVO(ComponenteVO componenteVO) {
		ComponenteVO = componenteVO;
	}
	/**
	 * @return the componenteVOs
	 */
	public List<ComponenteVO> getComponenteVOs() {
		return ComponenteVOs;
	}
	/**
	 * @param componenteVOs the componenteVOs to set
	 */
	public void setComponenteVOs(List<ComponenteVO> componenteVOs) {
		ComponenteVOs = componenteVOs;
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
	 * @return the pantallaVOs
	 */
	public List<PantallaVO> getPantallaVOs() {
		return pantallaVOs;
	}
	/**
	 * @param pantallaVOs the pantallaVOs to set
	 */
	public void setPantallaVOs(List<PantallaVO> pantallaVOs) {
		this.pantallaVOs = pantallaVOs;
	}
	
}
