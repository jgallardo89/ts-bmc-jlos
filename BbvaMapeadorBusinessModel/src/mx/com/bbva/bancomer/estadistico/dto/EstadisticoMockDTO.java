package mx.com.bbva.bancomer.estadistico.dto;

import java.util.List;

import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

public class EstadisticoMockDTO extends BbvaAbstractDataTransferObject {

	private static final long serialVersionUID = -4261057208009889989L;
	private List<CanalMockDTO> canalMockDTOs;
	/**
	 * @return the canalMockDTOs
	 */
	public List<CanalMockDTO> getCanalMockDTOs() {
		return canalMockDTOs;
	}
	/**
	 * @param canalMockDTOs the canalMockDTOs to set
	 */
	public void setCanalMockDTOs(List<CanalMockDTO> canalMockDTOs) {
		this.canalMockDTOs = canalMockDTOs;
	}
	
	
}
