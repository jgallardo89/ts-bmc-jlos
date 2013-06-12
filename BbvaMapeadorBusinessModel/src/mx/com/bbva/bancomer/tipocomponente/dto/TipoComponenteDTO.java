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
 * Nombre de clase: TipoComponenteDTO.java
 * Nombre de paquete: mx.com.bbva.bancomer.tipocomponente.dto
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.tipocomponente.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.TipoComponenteVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoComponenteDTO.
 */
public class TipoComponenteDTO extends BbvaAbstractDataTransferObject   {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5791792209628768160L;
	
	/** The tipo componente vo. */
	private TipoComponenteVO tipoComponenteVO;
	
	/** The tipo componente v os. */
	private List<TipoComponenteVO> tipoComponenteVOs;
	
	/**
	 * Gets the tipo componente vo.
	 *
	 * @return the tipoComponenteVO
	 */
	public final TipoComponenteVO getTipoComponenteVO() {
		return tipoComponenteVO;
	}
	
	/**
	 * Gets the tipo componente v os.
	 *
	 * @return the tipoComponenteVOs
	 */
	public final List<TipoComponenteVO> getTipoComponenteVOs() {
		return tipoComponenteVOs;
	}
	
	/**
	 * Sets the tipo componente vo.
	 *
	 * @param tipoComponenteVO the tipoComponenteVO to set
	 */
	public final void setTipoComponenteVO(TipoComponenteVO tipoComponenteVO) {
		this.tipoComponenteVO = tipoComponenteVO;
	}
	
	/**
	 * Sets the tipo componente v os.
	 *
	 * @param tipoComponenteVOs the tipoComponenteVOs to set
	 */
	public final void setTipoComponenteVOs(List<TipoComponenteVO> tipoComponenteVOs) {
		this.tipoComponenteVOs = tipoComponenteVOs;
	}
}
