package mx.com.bbva.bancomer.evento.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EventoMapeadorVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

public class EventoMapeadorDTO extends BbvaAbstractDataTransferObject {

	private static final long serialVersionUID = 1458602829713400053L;
	private List<EventoMapeadorVO> eventoMapeadorVOs;

	/**
	 * @return the eventoMapeadorVOs
	 */
	public List<EventoMapeadorVO> getEventoMapeadorVOs() {
		return eventoMapeadorVOs;
	}

	/**
	 * @param eventoMapeadorVOs the eventoMapeadorVOs to set
	 */
	public void setEventoMapeadorVOs(List<EventoMapeadorVO> eventoMapeadorVOs) {
		this.eventoMapeadorVOs = eventoMapeadorVOs;
	}
	
	
}
