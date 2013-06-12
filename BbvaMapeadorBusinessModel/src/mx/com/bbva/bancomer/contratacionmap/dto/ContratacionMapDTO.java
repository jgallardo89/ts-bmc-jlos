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
 * Nombre de clase: ContratacionMapDTO.java
 * Nombre de paquete: mx.com.bbva.bancomer.contratacionmap.dto
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.contratacionmap.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ContratacionMapVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

// TODO: Auto-generated Javadoc
/**
 * The Class ContratacionMapDTO.
 */
public class ContratacionMapDTO extends BbvaAbstractDataTransferObject  {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5533474387290995097L;
	
	/** The contratacion map vo. */
	private ContratacionMapVO contratacionMapVO;
	
	/** The contratacion map v os. */
	private List<ContratacionMapVO> contratacionMapVOs;
	
	/**
	 * Gets the contratacion map vo.
	 *
	 * @return the contratacionMapVO
	 */
	public ContratacionMapVO getContratacionMapVO() {
		return contratacionMapVO;
	}
	
	/**
	 * Gets the contratacion map v os.
	 *
	 * @return the contratacionMapVOs
	 */
	public List<ContratacionMapVO> getContratacionMapVOs() {
		return contratacionMapVOs;
	}
	
	/**
	 * Sets the contratacion map vo.
	 *
	 * @param contratacionMapVO the contratacionMapVO to set
	 */
	public void setContratacionMapVO(ContratacionMapVO contratacionMapVO) {
		this.contratacionMapVO = contratacionMapVO;
	}
	
	/**
	 * Sets the contratacion map v os.
	 *
	 * @param contratacionMapVOs the contratacionMapVOs to set
	 */
	public void setContratacionMapVOs(List<ContratacionMapVO> contratacionMapVOs) {
		this.contratacionMapVOs = contratacionMapVOs;
	}
	
}
