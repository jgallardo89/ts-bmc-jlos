package mx.com.bbva.bancomer.bitacoraarchivo.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.BitacoraArchivoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EventoMapeadorVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

public class BitacoraArchivoDTO extends BbvaAbstractDataTransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1187577150179973432L;
	private BitacoraArchivoVO bitacoraArchivoVO;
	private List<BitacoraArchivoVO> bitacoraArchivoVOs;
	private List<EventoMapeadorVO> eventoMapeadorVOs;
	/**
	 * @return the bitacoraArchivoVO
	 */
	public BitacoraArchivoVO getBitacoraArchivoVO() {
		return bitacoraArchivoVO;
	}
	/**
	 * @param bitacoraArchivoVO the bitacoraArchivoVO to set
	 */
	public void setBitacoraArchivoVO(BitacoraArchivoVO bitacoraArchivoVO) {
		this.bitacoraArchivoVO = bitacoraArchivoVO;
	}
	/**
	 * @return the bitacoraArchivoVOs
	 */
	public List<BitacoraArchivoVO> getBitacoraArchivoVOs() {
		return bitacoraArchivoVOs;
	}
	/**
	 * @param bitacoraArchivoVOs the bitacoraArchivoVOs to set
	 */
	public void setBitacoraArchivoVOs(List<BitacoraArchivoVO> bitacoraArchivoVOs) {
		this.bitacoraArchivoVOs = bitacoraArchivoVOs;
	}
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