package mx.com.bbva.bancomer.estadistico.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstadisticoVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

public class EstadisticaDTO extends BbvaAbstractDataTransferObject {

	private static final long serialVersionUID = -4261057208009889989L;
	private List<EstadisticoVO> estadisticoVOs;
	private EstadisticoVO estadisticoVO;
	/**
	 * @return the estadisticoVOs
	 */
	public List<EstadisticoVO> getEstadisticoVOs() {
		return estadisticoVOs;
	}
	/**
	 * @param estadisticoVOs the estadisticoVOs to set
	 */
	public void setEstadisticoVOs(List<EstadisticoVO> estadisticoVOs) {
		this.estadisticoVOs = estadisticoVOs;
	}
	/**
	 * @return the estadisticoVO
	 */
	public EstadisticoVO getEstadisticoVO() {
		return estadisticoVO;
	}
	/**
	 * @param estadisticoVO the estadisticoVO to set
	 */
	public void setEstadisticoVO(EstadisticoVO estadisticoVO) {
		this.estadisticoVO = estadisticoVO;
	}
	
}
