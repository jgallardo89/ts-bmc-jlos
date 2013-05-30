package mx.com.bbva.bancomer.monitoreoarchivos.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstadoArchivoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MonitoreoArchivosVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

public class MonitoreoArchivosDTO extends BbvaAbstractDataTransferObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1838624864417229783L;
	private MonitoreoArchivosVO monitoreoArchivosVO;
	private List<MonitoreoArchivosVO> monitoreoArchivosVOs;
	private List<EstadoArchivoVO> estadoArchivoVOs;
	/**
	 * @return the monitoreoArchivosVO
	 */
	public MonitoreoArchivosVO getMonitoreoArchivosVO() {
		return monitoreoArchivosVO;
	}
	/**
	 * @param monitoreoArchivosVO the monitoreoArchivosVO to set
	 */
	public void setMonitoreoArchivosVO(MonitoreoArchivosVO monitoreoArchivosVO) {
		this.monitoreoArchivosVO = monitoreoArchivosVO;
	}
	/**
	 * @return the monitoreoArchivosVOs
	 */
	public List<MonitoreoArchivosVO> getMonitoreoArchivosVOs() {
		return monitoreoArchivosVOs;
	}
	/**
	 * @param monitoreoArchivosVOs the monitoreoArchivosVOs to set
	 */
	public void setMonitoreoArchivosVOs(
			List<MonitoreoArchivosVO> monitoreoArchivosVOs) {
		this.monitoreoArchivosVOs = monitoreoArchivosVOs;
	}
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
	
}
