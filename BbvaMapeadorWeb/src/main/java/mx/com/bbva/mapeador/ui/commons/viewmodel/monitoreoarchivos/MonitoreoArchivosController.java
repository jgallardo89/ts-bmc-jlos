package mx.com.bbva.mapeador.ui.commons.viewmodel.monitoreoarchivos;

import java.util.HashMap;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstadoArchivoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MonitoreoArchivosVO;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estadoarchivo.dto.EstadoArchivoDTO;
import mx.com.bbva.bancomer.mapper.business.EstadoArchivoBO;
import mx.com.bbva.bancomer.mapper.business.MonitoreoArchivosBO;
import mx.com.bbva.bancomer.monitoreoarchivos.dto.MonitoreoArchivosDTO;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

import org.apache.log4j.Logger;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

public class MonitoreoArchivosController extends ControllerSupport implements  IController{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(MonitoreoArchivosController.class);
	@Wire
	private Combobox statusPapa;
	@Wire
	private Combobox statusHijo;
	@Wire
	private Textbox idEstatusPapa;
	@Wire
	private Textbox idEstatusHijo;
	
	private MonitoreoArchivosDTO monitoreoArchivosDTO = (MonitoreoArchivosDTO) this.read();
	
	private List<MonitoreoArchivosVO> monitoreoArchivosVOs = monitoreoArchivosDTO.getMonitoreoArchivosVOs();
	
	@Wire
	private String strStatusPapa;
	@Wire
	private String strStatusHijo;
	@Wire
	private String strIdEstatusPapa;
	@Wire
	private String strIdEstatusHijo;
	private boolean executePermissionSet;
	
	@Wire
	private Label lblHDRStatus;
	@Wire
	private Label lblDataEstatus;
	@Wire
	private Button limpiarBtn;
	@Wire
	private Button consultarBtn;
	@Wire
	private Grid archivoGrid;
	
	@Override
	public Object read() {
		MonitoreoArchivosDTO monitoreoArchivosDTO = new MonitoreoArchivosDTO();
		EstadoArchivoDTO estadoArchivoDTO = new EstadoArchivoDTO(); 

		MonitoreoArchivosVO monitoreoArchivosVO = new MonitoreoArchivosVO();
		EstadoArchivoVO estadoArchivoVO = new EstadoArchivoVO();
		
		monitoreoArchivosDTO.setMonitoreoArchivosVO(monitoreoArchivosVO);
		estadoArchivoDTO.setEstadoArchivoVO(estadoArchivoVO);
		
		MonitoreoArchivosBO monitoreoArchivosBO = new MonitoreoArchivosBO();
		EstadoArchivoBO estadoArchivoBO = new EstadoArchivoBO();
		
		
		monitoreoArchivosDTO = monitoreoArchivosBO.readCommand(monitoreoArchivosDTO);
		estadoArchivoDTO = estadoArchivoBO.readCommand(estadoArchivoDTO);
		
		logger.info("::::::::::::::SIZE::::::::::" + monitoreoArchivosDTO.getMonitoreoArchivosVOs());
		
		monitoreoArchivosDTO.setEstadoArchivoVOs(estadoArchivoDTO.getEstadoArchivoVOs());
		
		return monitoreoArchivosDTO;
	}
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
        executePermissionSet = this.applyPermision();
    } 

	@Command
	@GlobalCommand
	@NotifyChange({ "monitoreoArchivosVOs" })
	public void readWithFilters() {
		MonitoreoArchivosDTO monitoreoArchivosDTO = new MonitoreoArchivosDTO(); 

		MonitoreoArchivosVO monitoreoArchivosVO = new MonitoreoArchivosVO(); 
		
		monitoreoArchivosVO.setIdEstadoArchivoPapa((Integer.parseInt(idEstatusPapa.getValue().isEmpty()?"0":idEstatusPapa.getValue())));
		monitoreoArchivosVO.setIdEstadoArchivoHijo((Integer.parseInt(idEstatusHijo.getValue().isEmpty()?"0":idEstatusHijo.getValue())));
		monitoreoArchivosDTO.setMonitoreoArchivosVO(monitoreoArchivosVO);
		monitoreoArchivosDTO.toString(BbvaAbstractDataTransferObject.XML);
		
		MonitoreoArchivosBO monitoreoArchivosBO = new MonitoreoArchivosBO();
		monitoreoArchivosDTO = monitoreoArchivosBO.readCommand(monitoreoArchivosDTO);
		
		monitoreoArchivosVOs = monitoreoArchivosDTO.getMonitoreoArchivosVOs();
	}
	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the statusPapa
	 */
	public Combobox getStatusPapa() {
		return statusPapa;
	}

	/**
	 * @param statusPapa the statusPapa to set
	 */
	public void setStatusPapa(Combobox statusPapa) {
		this.statusPapa = statusPapa;
	}

	/**
	 * @return the statusHijo
	 */
	public Combobox getStatusHijo() {
		return statusHijo;
	}

	/**
	 * @param statusHijo the statusHijo to set
	 */
	public void setStatusHijo(Combobox statusHijo) {
		this.statusHijo = statusHijo;
	}

	/**
	 * @return the idEstatusPapa
	 */
	public Textbox getIdEstatusPapa() {
		return idEstatusPapa;
	}

	/**
	 * @param idEstatusPapa the idEstatusPapa to set
	 */
	public void setIdEstatusPapa(Textbox idEstatusPapa) {
		this.idEstatusPapa = idEstatusPapa;
	}

	/**
	 * @return the idEstatusHijo
	 */
	public Textbox getIdEstatusHijo() {
		return idEstatusHijo;
	}

	/**
	 * @param idEstatusHijo the idEstatusHijo to set
	 */
	public void setIdEstatusHijo(Textbox idEstatusHijo) {
		this.idEstatusHijo = idEstatusHijo;
	}

	/**
	 * @return the monitoreoArchivosDTO
	 */
	public MonitoreoArchivosDTO getMonitoreoArchivosDTO() {
		return monitoreoArchivosDTO;
	}

	/**
	 * @param monitoreoArchivosDTO the monitoreoArchivosDTO to set
	 */
	public void setMonitoreoArchivosDTO(MonitoreoArchivosDTO monitoreoArchivosDTO) {
		this.monitoreoArchivosDTO = monitoreoArchivosDTO;
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
	 * @return the strStatusPapa
	 */
	public String getStrStatusPapa() {
		return strStatusPapa;
	}

	/**
	 * @param strStatusPapa the strStatusPapa to set
	 */
	public void setStrStatusPapa(String strStatusPapa) {
		this.strStatusPapa = strStatusPapa;
	}

	/**
	 * @return the strStatusHijo
	 */
	public String getStrStatusHijo() {
		return strStatusHijo;
	}

	/**
	 * @param strStatusHijo the strStatusHijo to set
	 */
	public void setStrStatusHijo(String strStatusHijo) {
		this.strStatusHijo = strStatusHijo;
	}

	/**
	 * @return the strIdEstatusPapa
	 */
	public String getStrIdEstatusPapa() {
		return strIdEstatusPapa;
	}

	/**
	 * @param strIdEstatusPapa the strIdEstatusPapa to set
	 */
	public void setStrIdEstatusPapa(String strIdEstatusPapa) {
		this.strIdEstatusPapa = strIdEstatusPapa;
	}

	/**
	 * @return the strIdEstatusHijo
	 */
	public String getStrIdEstatusHijo() {
		return strIdEstatusHijo;
	}

	/**
	 * @param strIdEstatusHijo the strIdEstatusHijo to set
	 */
	public void setStrIdEstatusHijo(String strIdEstatusHijo) {
		this.strIdEstatusHijo = strIdEstatusHijo;
	}
	/**
	 * @return the executePermissionSet
	 */
	public boolean isExecutePermissionSet() {
		return executePermissionSet;
	}
	/**
	 * @param executePermissionSet the executePermissionSet to set
	 */
	public void setExecutePermissionSet(boolean executePermissionSet) {
		this.executePermissionSet = executePermissionSet;
	}
	@Override
	public boolean applyPermision() {
		boolean isApplied = false;
		HashMap<String, Component> componentes = new HashMap<String, Component>();
		componentes.put(lblHDRStatus.getId(), lblHDRStatus);
		componentes.put(lblDataEstatus.getId(), lblDataEstatus);
		componentes.put(statusPapa.getId(), statusPapa);
		componentes.put(statusHijo.getId(), statusHijo);
		componentes.put(limpiarBtn.getId(), limpiarBtn);
		componentes.put(consultarBtn.getId(), consultarBtn);
		componentes.put(archivoGrid.getId(), archivoGrid);
		super.applyPermission(MapeadorConstants.MONITOREO_ARCHIVOS, componentes);
		return isApplied;
	}	

}
