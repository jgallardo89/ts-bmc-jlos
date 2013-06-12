/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Informacion Confidencial:
 * Este software contiene informacion totalmente confidencial propiedad de Grupo Financiero BBVA Bancomer. 
 * Queda totalmente prohibido su uso o divulgacion en forma parcial o total y solamente podra ser utilizada de acuerdo a los terminos y estatutos 
 * que determine el Grupo Financiero BBVA Bancomer.
 * 
 * Todos los derechos reservados, Mexico 2013.
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * DESCRIPCION DEL PROGRAMA
 * Nombre de aplicación: MAPEADOR
 * Nombre de proyecto: BbvaMapeadorBusinessModel
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * HISTORIAL DE CAMBIOS:
 * 
 * Fecha:									         	
 * 30-ABR-2013  
 * @Author:	Jose Luis Ortiz Salazar
 * @Email: jortizsalazar@gmail.com    	
 * Razon: Creacion        
 * Version: 1.0.0
 * Nombre de clase: PantallaDTO.java
 * Nombre de paquete: mx.com.bbva.bancomer.pantalla.dto
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.pantalla.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PantallaVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

// TODO: Auto-generated Javadoc
/**
 * The Class PantallaDTO.
 *
 * @author
 */
public class PantallaDTO extends BbvaAbstractDataTransferObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7762626615675583942L;
	
	/** The estatus objeto vo. */
	private EstatusObjetoVO estatusObjetoVO;
	
	/** The estatus objeto v os. */
	private List<EstatusObjetoVO> estatusObjetoVOs;
	
	/** The pantalla padre vo. */
	private PantallaVO pantallaPadreVO;
	
	/** The pantalla padre v os. */
	private List<PantallaVO> pantallaPadreVOs;
	
	/** The pantalla vo. */
	private PantallaVO pantallaVO;
	
	/** The pantalla v os. */
	private List<PantallaVO> pantallaVOs;
	
	/**
	 * Instantiates a new pantalla dto.
	 */
	public PantallaDTO() {
		super(); 
	}
	
	/**
	 * Gets the estatus objeto vo.
	 *
	 * @return the estatusObjetoVO
	 */
	public EstatusObjetoVO getEstatusObjetoVO() {
		return estatusObjetoVO;
	}
	
	/**
	 * Gets the estatus objeto v os.
	 *
	 * @return the estatusObjetoVOs
	 */
	public List<EstatusObjetoVO> getEstatusObjetoVOs() {
		return estatusObjetoVOs;
	}
	
	/**
	 * Gets the pantalla padre vo.
	 *
	 * @return the pantallaPadreVO
	 */
	public PantallaVO getPantallaPadreVO() {
		return pantallaPadreVO;
	}
	
	/**
	 * Gets the pantalla padre v os.
	 *
	 * @return the pantallaPadreVOs
	 */
	public List<PantallaVO> getPantallaPadreVOs() {
		return pantallaPadreVOs;
	}
	
	/**
	 * Gets the pantalla vo.
	 *
	 * @return the pantallaVO
	 */
	public PantallaVO getPantallaVO() {
		return pantallaVO;
	}
	
	/**
	 * Gets the pantalla v os.
	 *
	 * @return the pantallaVOs
	 */
	public List<PantallaVO> getPantallaVOs() {
		return pantallaVOs;
	}
	
	/**
	 * Sets the estatus objeto vo.
	 *
	 * @param estatusObjetoVO the estatusObjetoVO to set
	 */
	public void setEstatusObjetoVO(EstatusObjetoVO estatusObjetoVO) {
		this.estatusObjetoVO = estatusObjetoVO;
	}
	
	/**
	 * Sets the estatus objeto v os.
	 *
	 * @param estatusObjetoVOs the estatusObjetoVOs to set
	 */
	public void setEstatusObjetoVOs(List<EstatusObjetoVO> estatusObjetoVOs) {
		this.estatusObjetoVOs = estatusObjetoVOs;
	}
	
	/**
	 * Sets the pantalla padre vo.
	 *
	 * @param pantallaPadreVO the pantallaPadreVO to set
	 */
	public void setPantallaPadreVO(PantallaVO pantallaPadreVO) {
		this.pantallaPadreVO = pantallaPadreVO;
	}
	
	/**
	 * Sets the pantalla padre v os.
	 *
	 * @param pantallaPadreVOs the pantallaPadreVOs to set
	 */
	public void setPantallaPadreVOs(List<PantallaVO> pantallaPadreVOs) {
		this.pantallaPadreVOs = pantallaPadreVOs;
	}
	
	/**
	 * Sets the pantalla vo.
	 *
	 * @param pantallaVO the pantallaVO to set
	 */
	public void setPantallaVO(PantallaVO pantallaVO) {
		this.pantallaVO = pantallaVO;
	}
	
	/**
	 * Sets the pantalla v os.
	 *
	 * @param pantallaVOs the pantallaVOs to set
	 */
	public void setPantallaVOs(List<PantallaVO> pantallaVOs) {
		this.pantallaVOs = pantallaVOs;
	}
	
	
}
