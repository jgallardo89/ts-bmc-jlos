package mx.com.bbva.bancomer.mappers.mapagmm.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MapaGmmVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

public class MapaGmmDTO extends BbvaAbstractDataTransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4311829725335564334L;
	private MapaGmmVO mapaGmmVO;
	private List<MapaGmmVO> mapaGmmVOs;
	private List<EstatusObjetoVO> estatusObjetoVOs;
	/**
	 * @return the mapaGmmVO
	 */
	public MapaGmmVO getMapaGmmVO() {
		return mapaGmmVO;
	}
	/**
	 * @param mapaGmmVO the mapaGmmVO to set
	 */
	public void setMapaGmmVO(MapaGmmVO mapaGmmVO) {
		this.mapaGmmVO = mapaGmmVO;
	}
	/**
	 * @return the mapaGmmVOs
	 */
	public List<MapaGmmVO> getMapaGmmVOs() {
		return mapaGmmVOs;
	}
	/**
	 * @param mapaGmmVOs the mapaGmmVOs to set
	 */
	public void setMapaGmmVOs(List<MapaGmmVO> mapaGmmVOs) {
		this.mapaGmmVOs = mapaGmmVOs;
	}
	/**
	 * @return the estatusObjetoVOs
	 */
	public List<EstatusObjetoVO> getEstatusObjetoVOs() {
		return estatusObjetoVOs;
	}
	/**
	 * @param estatusObjetoVOs the estatusObjetoVOs to set
	 */
	public void setEstatusObjetoVOs(List<EstatusObjetoVO> estatusObjetoVOs) {
		this.estatusObjetoVOs = estatusObjetoVOs;
	}
	
}
