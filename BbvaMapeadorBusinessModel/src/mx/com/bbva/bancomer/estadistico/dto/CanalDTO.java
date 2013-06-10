package mx.com.bbva.bancomer.estadistico.dto;

import java.util.List;

import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

public class CanalDTO  extends BbvaAbstractDataTransferObject {

	private static final long serialVersionUID = 6366494082437553432L;
	private int idCanal;
	private String nombreCanal;
	private List<ClienteDTO> clienteMockDTOs;
	
	/**
	 * @return the nombreCanal
	 */
	public String getNombreCanal() {
		return nombreCanal;
	}
	/**
	 * @param nombreCanal the nombreCanal to set
	 */
	public void setNombreCanal(String nombreCanal) {
		this.nombreCanal = nombreCanal;
	}
	
	/**
	 * @return the clienteMockDTOs
	 */
	public List<ClienteDTO> getClienteMockDTOs() {
		return clienteMockDTOs;
	}
	/**
	 * @param clienteMockDTOs the clienteMockDTOs to set
	 */
	public void setClienteMockDTOs(List<ClienteDTO> clienteMockDTOs) {
		this.clienteMockDTOs = clienteMockDTOs;
	}
	/**
	 * @return the idCanal
	 */
	public int getIdCanal() {
		return idCanal;
	}
	/**
	 * @param idCanal the idCanal to set
	 */
	public void setIdCanal(int idCanal) {
		this.idCanal = idCanal;
	}
	
}
