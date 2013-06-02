package mx.com.bbva.bancomer.perfil.dto;

import java.util.HashMap;
import java.util.List;

import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.bussinnes.model.vo.ControlPermisoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusClaveVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PantallaVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PerfilVO;

public class PerfilDTO extends BbvaAbstractDataTransferObject {

	private List<EstatusClaveVO> estatusClaveVOs;
	private PantallaVO pantallaVO;
	private List<PantallaVO> pantallaVOs;
	private EstatusObjetoVO estatusObjetoVO;
	private List<EstatusObjetoVO> estatusObjetoVOs;
	private PerfilVO perfilVO;
	private List<PerfilVO> perfilVOs;	
	private ControlPermisoVO controlPermisoVO;
	private HashMap<String, Boolean> controlPermisoVOs;
	private List<ControlPermisoVO> controlPermisoVOS;
	/**
	 * @return the controlPermisoVOS
	 */
	public final List<ControlPermisoVO> getControlPermisoVOS() {
		return controlPermisoVOS;
	}
	/**
	 * @param controlPermisoVOS the controlPermisoVOS to set
	 */
	public final void setControlPermisoVOS(List<ControlPermisoVO> controlPermisoVOS) {
		this.controlPermisoVOS = controlPermisoVOS;
	}
	/**
	 * @return the perfilVO
	 */
	public final PerfilVO getPerfilVO() {
		return perfilVO;
	}
	/**
	 * @param perfilVO the perfilVO to set
	 */
	public final void setPerfilVO(PerfilVO perfilVO) {
		this.perfilVO = perfilVO;
	}
	/**
	 * @return the perfilVOs
	 */
	public final List<PerfilVO> getPerfilVOs() {
		return perfilVOs;
	}
	/**
	 * @param perfilVOs the perfilVOs to set
	 */
	public final void setPerfilVOs(List<PerfilVO> perfilVOs) {
		this.perfilVOs = perfilVOs;
	}
	/**
	 * @return the controlPermisoVO
	 */
	public final ControlPermisoVO getControlPermisoVO() {
		return controlPermisoVO;
	}
	/**
	 * @param controlPermisoVO the controlPermisoVO to set
	 */
	public final void setControlPermisoVO(ControlPermisoVO controlPermisoVO) {
		this.controlPermisoVO = controlPermisoVO;
	}
	/**
	 * @return the controlPermisoVOs
	 */
	public final HashMap<String, Boolean> getControlPermisoVOs() {
		return controlPermisoVOs;
	}
	/**
	 * @param controlPermisoVOs the controlPermisoVOs to set
	 */
	public final void setControlPermisoVOs(
			HashMap<String, Boolean> controlPermisoVOs) {
		this.controlPermisoVOs = controlPermisoVOs;
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
	private String idPantalla;
	/**
	 * @return the idPantalla
	 */
	public String getIdPantalla() {
		return idPantalla;
	}
	/**
	 * @param idPantalla the idPantalla to set
	 */
	public void setIdPantalla(String idPantalla) {
		this.idPantalla = idPantalla;
	}
	/**
	 * @return the idEstatusClave
	 */
	public String getIdEstatusClave() {
		return idEstatusClave;
	}
	/**
	 * @param idEstatusClave the idEstatusClave to set
	 */
	public void setIdEstatusClave(String idEstatusClave) {
		this.idEstatusClave = idEstatusClave;
	}
	private String idEstatusClave;
	/**
	 * @return the estatusObjetoVO
	 */
	public EstatusObjetoVO getEstatusObjetoVO() {
		return estatusObjetoVO;
	}
	/**
	 * @param estatusObjetoVO the estatusObjetoVO to set
	 */
	public void setEstatusObjetoVO(EstatusObjetoVO estatusObjetoVO) {
		this.estatusObjetoVO = estatusObjetoVO;
	}
	/**
	 * @return the estatusClaveVOs
	 */
	public List<EstatusClaveVO> getEstatusClaveVOs() {
		return estatusClaveVOs;
	}
	/**
	 * @return the pantallaVO
	 */
	public PantallaVO getPantallaVO() {
		return pantallaVO;
	}
	/**
	 * @return the pantallaVOs
	 */
	public List<PantallaVO> getPantallaVOs() {
		return pantallaVOs;
	}
	/**
	 * @param estatusClaveVOs the estatusClaveVOs to set
	 */
	public void setEstatusClaveVOs(List<EstatusClaveVO> estatusClaveVOs) {
		this.estatusClaveVOs = estatusClaveVOs;
	}
	/**
	 * @param pantallaVO the pantallaVO to set
	 */
	public void setPantallaVO(PantallaVO pantallaVO) {
		this.pantallaVO = pantallaVO;
	}
	/**
	 * @param pantallaVOs the pantallaVOs to set
	 */
	public void setPantallaVOs(List<PantallaVO> pantallaVOs) {
		this.pantallaVOs = pantallaVOs;
	}

	
}
