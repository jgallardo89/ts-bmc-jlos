package mx.com.bbva.bancomer.estadistico.dto;

import java.io.Serializable;
import java.util.List;

public class CanalMockDTO implements Serializable {

	private static final long serialVersionUID = 6366494082437553432L;
	private int idCanal;
	private String nombreCanal;
	private List<ClienteMockDTO> clienteMockDTOs;
	
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
	public List<ClienteMockDTO> getClienteMockDTOs() {
		return clienteMockDTOs;
	}
	/**
	 * @param clienteMockDTOs the clienteMockDTOs to set
	 */
	public void setClienteMockDTOs(List<ClienteMockDTO> clienteMockDTOs) {
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
