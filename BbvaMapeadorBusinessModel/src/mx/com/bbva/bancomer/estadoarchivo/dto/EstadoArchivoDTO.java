package mx.com.bbva.bancomer.estadoarchivo.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstadoArchivoVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

public class EstadoArchivoDTO extends BbvaAbstractDataTransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3752398274641215109L;
	private EstadoArchivoVO estadoArchivoVO;
	private List<EstadoArchivoVO> estadoArchivoVOs;
	/**
	 * @return the estadoArchivoVOs
	 */
	public List<EstadoArchivoVO> getEstadoArchivoVOs() {
		return estadoArchivoVOs;
	}
	/**
	 * @param estadoArchivoVOs the estadoArchivoVOs to set
	 */
	public void setEstadoArchivoVOs(List<EstadoArchivoVO> estadoArchivoVOs) {
		this.estadoArchivoVOs = estadoArchivoVOs;
	}
	/**
	 * @return the estadoArchivoVO
	 */
	public EstadoArchivoVO getEstadoArchivoVO() {
		return estadoArchivoVO;
	}
	/**
	 * @param estadoArchivoVO the estadoArchivoVO to set
	 */
	public void setEstadoArchivoVO(EstadoArchivoVO estadoArchivoVO) {
		this.estadoArchivoVO = estadoArchivoVO;
	}
	
}
