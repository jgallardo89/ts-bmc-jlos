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
 * Nombre de clase: PalabraComodinDTO.java
 * Nombre de paquete: mx.com.bbva.bancomer.palabracomodin.dto
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.palabracomodin.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.PalabraComodinVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

// TODO: Auto-generated Javadoc
/**
 * The Class PalabraComodinDTO.
 *
 * @author Julio Morales
 */
public class PalabraComodinDTO extends BbvaAbstractDataTransferObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6354964122078395339L;

	/** The palabra comodin vo. */
	private PalabraComodinVO palabraComodinVO;
	
	/** The palabra comodin v os. */
	private List<PalabraComodinVO> palabraComodinVOs;

	/**
	 * Gets the palabra comodin vo.
	 *
	 * @return the palabraComodinVO
	 */
	public PalabraComodinVO getPalabraComodinVO() {
		return palabraComodinVO;
	}

	/**
	 * Gets the palabra comodin v os.
	 *
	 * @return the palabraComodinVOs
	 */
	public List<PalabraComodinVO> getPalabraComodinVOs() {
		return palabraComodinVOs;
	}

	/**
	 * Sets the palabra comodin vo.
	 *
	 * @param palabraComodinVO the palabraComodinVO to set
	 */
	public void setPalabraComodinVO(PalabraComodinVO palabraComodinVO) {
		this.palabraComodinVO = palabraComodinVO;
	}

	/**
	 * Sets the palabra comodin v os.
	 *
	 * @param palabraComodinVOs the palabraComodinVOs to set
	 */
	public void setPalabraComodinVOs(List<PalabraComodinVO> palabraComodinVOs) {
		this.palabraComodinVOs = palabraComodinVOs;
	}

}
