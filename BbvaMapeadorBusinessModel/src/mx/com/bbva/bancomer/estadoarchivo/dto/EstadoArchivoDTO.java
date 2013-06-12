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
 * Nombre de clase: EstadoArchivoDTO.java
 * Nombre de paquete: mx.com.bbva.bancomer.estadoarchivo.dto
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.estadoarchivo.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstadoArchivoVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadoArchivoDTO.
 */
public class EstadoArchivoDTO extends BbvaAbstractDataTransferObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3752398274641215109L;
	
	/** The estado archivo vo. */
	private EstadoArchivoVO estadoArchivoVO;
	
	/** The estado archivo v os. */
	private List<EstadoArchivoVO> estadoArchivoVOs;
	
	/**
	 * Gets the estado archivo vo.
	 *
	 * @return the estadoArchivoVO
	 */
	public EstadoArchivoVO getEstadoArchivoVO() {
		return estadoArchivoVO;
	}
	
	/**
	 * Gets the estado archivo v os.
	 *
	 * @return the estadoArchivoVOs
	 */
	public List<EstadoArchivoVO> getEstadoArchivoVOs() {
		return estadoArchivoVOs;
	}
	
	/**
	 * Sets the estado archivo vo.
	 *
	 * @param estadoArchivoVO the estadoArchivoVO to set
	 */
	public void setEstadoArchivoVO(EstadoArchivoVO estadoArchivoVO) {
		this.estadoArchivoVO = estadoArchivoVO;
	}
	
	/**
	 * Sets the estado archivo v os.
	 *
	 * @param estadoArchivoVOs the estadoArchivoVOs to set
	 */
	public void setEstadoArchivoVOs(List<EstadoArchivoVO> estadoArchivoVOs) {
		this.estadoArchivoVOs = estadoArchivoVOs;
	}
	
}
