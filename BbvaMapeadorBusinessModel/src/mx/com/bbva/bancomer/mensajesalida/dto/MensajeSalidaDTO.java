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
 * Nombre de clase: MensajeSalidaDTO.java
 * Nombre de paquete: mx.com.bbva.bancomer.mensajesalida.dto
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.mensajesalida.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MensajeSalidaVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

// TODO: Auto-generated Javadoc
/**
 * The Class MensajeSalidaDTO.
 *
 * @author Julio Morales
 */
public class MensajeSalidaDTO extends BbvaAbstractDataTransferObject  {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8915259237329127401L;
	
	/** The estatus objeto v os. */
	private List<EstatusObjetoVO> estatusObjetoVOs;
	
	/** The mensaje salida vo. */
	private MensajeSalidaVO mensajeSalidaVO;
	
	/** The mensaje salida v os. */
	private List<MensajeSalidaVO> mensajeSalidaVOs;
	
	/**
	 * Gets the estatus objeto v os.
	 *
	 * @return the estatusObjetoVOs
	 */
	public List<EstatusObjetoVO> getEstatusObjetoVOs() {
		return estatusObjetoVOs;
	}
	
	/**
	 * Gets the mensaje salida vo.
	 *
	 * @return the mensajeSalidaVO
	 */
	public MensajeSalidaVO getMensajeSalidaVO() {
		return mensajeSalidaVO;
	}
	
	/**
	 * Gets the mensaje salida v os.
	 *
	 * @return the mensajeSalidaVOs
	 */
	public List<MensajeSalidaVO> getMensajeSalidaVOs() {
		return mensajeSalidaVOs;
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
	 * Sets the mensaje salida vo.
	 *
	 * @param mensajeSalidaVO the mensajeSalidaVO to set
	 */
	public void setMensajeSalidaVO(MensajeSalidaVO mensajeSalidaVO) {
		this.mensajeSalidaVO = mensajeSalidaVO;
	}
	
	/**
	 * Sets the mensaje salida v os.
	 *
	 * @param mensajeSalidaVOs the mensajeSalidaVOs to set
	 */
	public void setMensajeSalidaVOs(List<MensajeSalidaVO> mensajeSalidaVOs) {
		this.mensajeSalidaVOs = mensajeSalidaVOs;
	}

}
