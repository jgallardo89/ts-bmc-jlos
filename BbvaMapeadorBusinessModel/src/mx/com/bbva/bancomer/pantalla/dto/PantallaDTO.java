/**
 * 
 */
package mx.com.bbva.bancomer.pantalla.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PantallaVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

/**
 * @author 
 *
 */
public class PantallaDTO extends BbvaAbstractDataTransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7762626615675583942L;
	private PantallaVO pantallaVO;
	private PantallaVO pantallaPadreVO;
	private EstatusObjetoVO estatusObjetoVO;
	private List<PantallaVO> pantallaVOs;
	private List<PantallaVO> pantallaPadreVOs;
	private List<EstatusObjetoVO> estatusObjetoVOs;
	/**
	 * @return the pantallaVO
	 */
	public PantallaVO getPantallaVO() {
		return pantallaVO;
	}
	/**
	 * @param pantallaVO the pantallaVO to set
	 */
	public void setPantallaVO(PantallaVO pantallaVO) {
		this.pantallaVO = pantallaVO;
	}
	/**
	 * @return the pantallaPadreVO
	 */
	public PantallaVO getPantallaPadreVO() {
		return pantallaPadreVO;
	}
	/**
	 * @param pantallaPadreVO the pantallaPadreVO to set
	 */
	public void setPantallaPadreVO(PantallaVO pantallaPadreVO) {
		this.pantallaPadreVO = pantallaPadreVO;
	}
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
	/**
	 * @return the pantallaPadreVOs
	 */
	public List<PantallaVO> getPantallaPadreVOs() {
		return pantallaPadreVOs;
	}
	/**
	 * @param pantallaPadreVOs the pantallaPadreVOs to set
	 */
	public void setPantallaPadreVOs(List<PantallaVO> pantallaPadreVOs) {
		this.pantallaPadreVOs = pantallaPadreVOs;
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
	 * 
	 */
	public PantallaDTO() {
		super(); 
	}
	
	
}
