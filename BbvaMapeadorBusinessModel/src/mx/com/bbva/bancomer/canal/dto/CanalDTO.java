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
 * Nombre de clase: CanalDTO.java
 * Nombre de paquete: mx.com.bbva.bancomer.canal.dto
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.canal.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.CanalVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
// TODO: Auto-generated Javadoc

/**
 * The Class CanalDTO.
 */
public class CanalDTO extends BbvaAbstractDataTransferObject  {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The canal vo. */
	private CanalVO canalVO;
	
	/** The canal v os. */
	private List<CanalVO> canalVOs;
	
	/** The estatus objeto v os. */
	private List<EstatusObjetoVO> estatusObjetoVOs;
	
	/**
	 * Gets the canal vo.
	 *
	 * @return the canalVO
	 */
	public CanalVO getCanalVO() {
		return canalVO;
	}
	
	/**
	 * Gets the canal v os.
	 *
	 * @return the canalVOs
	 */
	public List<CanalVO> getCanalVOs() {
		return canalVOs;
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
	 * Sets the canal vo.
	 *
	 * @param canalVO the canalVO to set
	 */
	public void setCanalVO(CanalVO canalVO) {
		this.canalVO = canalVO;
	}
	
	/**
	 * Sets the canal v os.
	 *
	 * @param canalVOs the canalVOs to set
	 */
	public void setCanalVOs(List<CanalVO> canalVOs) {
		this.canalVOs = canalVOs;
	}
	
	/**
	 * Sets the estatus objeto v os.
	 *
	 * @param estatusObjetoVOs the estatusObjetoVOs to set
	 */
	public void setEstatusObjetoVOs(List<EstatusObjetoVO> estatusObjetoVOs) {
		this.estatusObjetoVOs = estatusObjetoVOs;
	}

	
}
