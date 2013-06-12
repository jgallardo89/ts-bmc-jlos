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
 * Nombre de clase: EventoMapeadorDTO.java
 * Nombre de paquete: mx.com.bbva.bancomer.evento.dto
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.evento.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstadoArchivoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EventoMapeadorVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

// TODO: Auto-generated Javadoc
/**
 * The Class EventoMapeadorDTO.
 */
public class EventoMapeadorDTO extends BbvaAbstractDataTransferObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1458602829713400053L;
	
	/** The estado archivo v os. */
	private List<EstadoArchivoVO> estadoArchivoVOs;
	
	/** The evento mapeador v os. */
	private List<EventoMapeadorVO> eventoMapeadorVOs;

	/**
	 * Gets the estado archivo v os.
	 *
	 * @return the estadoArchivoVOs
	 */
	public final List<EstadoArchivoVO> getEstadoArchivoVOs() {
		return estadoArchivoVOs;
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
	 * Sets the estado archivo v os.
	 *
	 * @param estadoArchivoVOs the estadoArchivoVOs to set
	 */
	public final void setEstadoArchivoVOs(List<EstadoArchivoVO> estadoArchivoVOs) {
		this.estadoArchivoVOs = estadoArchivoVOs;
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
