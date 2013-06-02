package mx.com.bbva.bancomer.componente.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO; 
import mx.com.bbva.bancomer.bussinnes.model.vo.PantallaVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.TipoComponenteVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.bussinnes.model.vo.ComponenteVO;

public class ComponenteDTO extends BbvaAbstractDataTransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3144516741620752172L;
	private ComponenteVO ComponenteVO;  
	private List<ComponenteVO> ComponenteVOs;
	private List<ComponenteVO> componentePantallaVOs;
	private List<ComponenteVO> ComponentePantallaPerfilVOs;
	private List<ComponenteVO> componentePantallaPerfilAllVOs;
	/**
	 * @return the componentePantallaPerfilAllVOs
	 */
	public final List<ComponenteVO> getComponentePantallaPerfilAllVOs() {
		return componentePantallaPerfilAllVOs;
	}
	/**
	 * @param componentePantallaPerfilAllVOs the componentePantallaPerfilAllVOs to set
	 */
	public final void setComponentePantallaPerfilAllVOs(
			List<ComponenteVO> componentePantallaPerfilAllVOs) {
		this.componentePantallaPerfilAllVOs = componentePantallaPerfilAllVOs;
	}
	private List<TipoComponenteVO> tipoComponenteVOs;
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
	/**
	 * @return the componentePantallaVOs
	 */
	public final List<ComponenteVO> getComponentePantallaVOs() {
		return componentePantallaVOs;
	}
	/**
	 * @param componentePantallaVOs the componentePantallaVOs to set
	 */
	public final void setComponentePantallaVOs(
			List<ComponenteVO> componentePantallaVOs) {
		this.componentePantallaVOs = componentePantallaVOs;
	}
	/**
	 * @return the componentePantallaPerfilVOs
	 */
	public final List<ComponenteVO> getComponentePantallaPerfilVOs() {
		return ComponentePantallaPerfilVOs;
	}
	/**
	 * @param componentePantallaPerfilVOs the componentePantallaPerfilVOs to set
	 */
	public final void setComponentePantallaPerfilVOs(
			List<ComponenteVO> componentePantallaPerfilVOs) {
		ComponentePantallaPerfilVOs = componentePantallaPerfilVOs;
	}
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
