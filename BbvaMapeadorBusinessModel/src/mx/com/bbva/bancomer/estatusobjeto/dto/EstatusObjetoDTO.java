package mx.com.bbva.bancomer.estatusobjeto.dto;

import java.util.List;

import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusClaveVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PantallaVO;

public class EstatusObjetoDTO extends BbvaAbstractDataTransferObject {

	private List<EstatusClaveVO> estatusClaveVOs;
	private EstatusClaveVO estatusClaveVO;
	private List<EstatusObjetoVO> estatusObjetoPantallaVOs;
	/**
	 * @return the estatusObjetoPantallaVOs
	 */
	public final List<EstatusObjetoVO> getEstatusObjetoPantallaVOs() {
		return estatusObjetoPantallaVOs;
	}
	/**
	 * @param estatusObjetoPantallaVOs the estatusObjetoPantallaVOs to set
	 */
	public final void setEstatusObjetoPantallaVOs(
			List<EstatusObjetoVO> estatusObjetoPantallaVOs) {
		this.estatusObjetoPantallaVOs = estatusObjetoPantallaVOs;
	}
	/**
	 * @return the estatusClaveVO
	 */
	public final EstatusClaveVO getEstatusClaveVO() {
		return estatusClaveVO;
	}
	/**
	 * @param estatusClaveVO the estatusClaveVO to set
	 */
	public final void setEstatusClaveVO(EstatusClaveVO estatusClaveVO) {
		this.estatusClaveVO = estatusClaveVO;
	}
	private PantallaVO pantallaVO;
	private List<PantallaVO> pantallaVOs;
	private EstatusObjetoVO estatusObjetoVO;
	private List<EstatusObjetoVO> estatusObjetoVOs;
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
