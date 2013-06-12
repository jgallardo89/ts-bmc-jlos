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
 * Nombre de clase: BitacoraArchivoDTO.java
 * Nombre de paquete: mx.com.bbva.bancomer.bitacoraarchivo.dto
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.bitacoraarchivo.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.BitacoraArchivoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstadoArchivoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EventoMapeadorVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

// TODO: Auto-generated Javadoc
/**
 * The Class BitacoraArchivoDTO.
 */
public class BitacoraArchivoDTO extends BbvaAbstractDataTransferObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1187577150179973432L;
	
	/** The bitacora archivo vo. */
	private BitacoraArchivoVO bitacoraArchivoVO;
	
	/** The bitacora archivo v os. */
	private List<BitacoraArchivoVO> bitacoraArchivoVOs;
	
	/** The estado archivo v os. */
	private List<EstadoArchivoVO> estadoArchivoVOs;
	
	/** The estatus objeto v os. */
	private List<EstatusObjetoVO> estatusObjetoVOs;
	
	/** The evento mapeador v os. */
	private List<EventoMapeadorVO> eventoMapeadorVOs;
	
	
	/**
	 * Gets the bitacora archivo vo.
	 *
	 * @return the bitacora archivo vo
	 */
	public BitacoraArchivoVO getBitacoraArchivoVO() {
		return bitacoraArchivoVO;
	}
	
	/**
	 * Gets the bitacora archivo v os.
	 *
	 * @return the bitacoraArchivoVOs
	 */
	public List<BitacoraArchivoVO> getBitacoraArchivoVOs() {
		return bitacoraArchivoVOs;
	}
	
	/**
	 * Gets the estado archivo v os.
	 *
	 * @return the estadoArchivoVOs
	 */
	public final List<EstadoArchivoVO> getEstadoArchivoVOs() {
		return estadoArchivoVOs;
	}
	
	/**
	 * Gets the estatus objeto v os.
	 *
	 * @return the estatusObjetoVOs
	 */
	public final List<EstatusObjetoVO> getEstatusObjetoVOs() {
		return estatusObjetoVOs;
	}
	
	/**
	 * Gets the evento mapeador v os.
	 *
	 * @return the eventoMapeadorVOs
	 */
	public List<EventoMapeadorVO> getEventoMapeadorVOs() {
		return eventoMapeadorVOs;
	}
	
	/**
	 * Sets the bitacora archivo vo.
	 *
	 * @param bitacoraArchivoVO the bitacoraArchivoVO to set
	 */
	public void setBitacoraArchivoVO(BitacoraArchivoVO bitacoraArchivoVO) {
		this.bitacoraArchivoVO = bitacoraArchivoVO;
	}
	
	/**
	 * Sets the bitacora archivo v os.
	 *
	 * @param bitacoraArchivoVOs the bitacoraArchivoVOs to set
	 */
	public void setBitacoraArchivoVOs(List<BitacoraArchivoVO> bitacoraArchivoVOs) {
		this.bitacoraArchivoVOs = bitacoraArchivoVOs;
	}
	
	/**
	 * Sets the estado archivo v os.
	 *
	 * @param estadoArchivoVOs the estadoArchivoVOs to set
	 */
	public final void setEstadoArchivoVOs(List<EstadoArchivoVO> estadoArchivoVOs) {
		this.estadoArchivoVOs = estadoArchivoVOs;
	}
	
	/**
	 * Sets the estatus objeto v os.
	 *
	 * @param estatusObjetoVOs the estatusObjetoVOs to set
	 */
	public final void setEstatusObjetoVOs(List<EstatusObjetoVO> estatusObjetoVOs) {
		this.estatusObjetoVOs = estatusObjetoVOs;
	}
	
	/**
	 * Sets the evento mapeador v os.
	 *
	 * @param eventoMapeadorVOs the eventoMapeadorVOs to set
	 */
	public void setEventoMapeadorVOs(List<EventoMapeadorVO> eventoMapeadorVOs) {
		this.eventoMapeadorVOs = eventoMapeadorVOs;
	}
	
}
