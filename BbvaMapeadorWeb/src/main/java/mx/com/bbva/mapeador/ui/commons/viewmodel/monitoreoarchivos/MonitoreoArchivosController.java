/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Informacion Confidencial:
 * Este software contiene informacion totalmente confidencial propiedad de Grupo Financiero BBVA Bancomer. 
 * Queda totalmente prohibido su uso o divulgacion en forma parcial o total y solamente podra ser utilizada de acuerdo a los terminos y estatutos 
 * que determine el Grupo Financiero BBVA Bancomer.
 * 
 * Todos los derechos reservados, Mexico 2013.
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * DESCRIPCION DEL PROGRAMA
 * Nombre de aplicación: MAPEADOR
 * Nombre de proyecto: BbvaMapeadorWeb
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * HISTORIAL DE CAMBIOS:
 * 
 * Fecha:									         	
 * 30-ABR-2013  
 * @Author:	Jose Luis Ortiz Salazar
 * @Email: jortizsalazar@gmail.com    	
 * Razon: Creacion        
 * Version: 1.0.0
 * Nombre de clase: MonitoreoArchivosController.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.monitoreoarchivos
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.monitoreoarchivos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstadoArchivoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MonitoreoArchivosVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estadoarchivo.dto.EstadoArchivoDTO;
import mx.com.bbva.bancomer.mapper.business.EstadoArchivoBO;
import mx.com.bbva.bancomer.mapper.business.MonitoreoArchivosBO;
import mx.com.bbva.bancomer.monitoreoarchivos.dto.MonitoreoArchivosDTO;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.reportes.ReportesController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

import org.apache.log4j.Logger;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
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

// TODO: Auto-generated Javadoc
/**
 * The Class MonitoreoArchivosController.
 */
public class MonitoreoArchivosController extends ControllerSupport implements  IController{
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(MonitoreoArchivosController.class);
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The archivo grid. */
	@Wire
	private Grid archivoGrid;
	
	/** The consultar btn. */
	@Wire
	private Button consultarBtn;
	
	/** The execute permission set. */
	private boolean executePermissionSet;
	
	/** The id estatus hijo. */
	@Wire
	private Textbox idEstatusHijo;
	
	/** The id estatus papa. */
	@Wire
	private Textbox idEstatusPapa;
	
	/** The lbl data estatus. */
	@Wire
	private Label lblDataEstatus;
	
	/** The lbl hdr status. */
	@Wire
	private Label lblHDRStatus;
	
	/** The limpiar btn. */
	@Wire
	private Button limpiarBtn;
	
	/** The monitoreo archivos dto. */
	private MonitoreoArchivosDTO monitoreoArchivosDTO = (MonitoreoArchivosDTO) this.read();
	
	/** The monitoreo archivos v os. */
	private List<MonitoreoArchivosVO> monitoreoArchivosVOs = monitoreoArchivosDTO.getMonitoreoArchivosVOs();
	
	/** The status hijo. */
	@Wire
	private Combobox statusHijo;
	
	/** The status papa. */
	@Wire
	private Combobox statusPapa;
	
	/** The str id estatus hijo. */
	@Wire
	private String strIdEstatusHijo;
	
	/** The str id estatus papa. */
	@Wire
	private String strIdEstatusPapa;
	
	/** The str status hijo. */
	@Wire
	private String strStatusHijo;
	
	/** The str status papa. */
	@Wire
	private String strStatusPapa;
	
	/**
	 * After compose.
	 *
	 * @param view the view
	 */
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
        executePermissionSet = this.applyPermision();
    }
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#applyPermision()
	 */
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

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#clean()
	 */
	@Override
	@Command
	public void clean() {
		statusPapa.setValue(null);
		statusHijo.setValue(null);
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#delete()
	 */
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Genera lista.
	 *
	 * @return the array list
	 */
	private ArrayList<BeanGenerico> generaLista() {
		ArrayList<BeanGenerico> beanGenericos = new ArrayList<BeanGenerico>();
		BeanGenerico beanGenerico = null;
		for(MonitoreoArchivosVO monitoreoArchivosVO: monitoreoArchivosVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(monitoreoArchivosVO.getNombreArchEntraPapa());
			beanGenerico.setValor2(monitoreoArchivosVO.getNombreEstadoArchivoPapa());
			beanGenerico.setValor3(monitoreoArchivosVO.getNombreArchEntraHijo());
			beanGenerico.setValor4(monitoreoArchivosVO.getNombreEstadoArchivoHijo());
			beanGenerico.setValor5("");
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}

	/**
	 * Gets the id estatus hijo.
	 *
	 * @return the idEstatusHijo
	 */
	public Textbox getIdEstatusHijo() {
		return idEstatusHijo;
	}

	/**
	 * Gets the id estatus papa.
	 *
	 * @return the idEstatusPapa
	 */
	public Textbox getIdEstatusPapa() {
		return idEstatusPapa;
	}

	/**
	 * Gets the monitoreo archivos dto.
	 *
	 * @return the monitoreoArchivosDTO
	 */
	public MonitoreoArchivosDTO getMonitoreoArchivosDTO() {
		return monitoreoArchivosDTO;
	}

	/**
	 * Gets the monitoreo archivos v os.
	 *
	 * @return the monitoreoArchivosVOs
	 */
	public List<MonitoreoArchivosVO> getMonitoreoArchivosVOs() {
		return monitoreoArchivosVOs;
	}

	/**
	 * Gets the status hijo.
	 *
	 * @return the statusHijo
	 */
	public Combobox getStatusHijo() {
		return statusHijo;
	}

	/**
	 * Gets the status papa.
	 *
	 * @return the statusPapa
	 */
	public Combobox getStatusPapa() {
		return statusPapa;
	}

	/**
	 * Gets the str id estatus hijo.
	 *
	 * @return the strIdEstatusHijo
	 */
	public String getStrIdEstatusHijo() {
		return strIdEstatusHijo;
	}

	/**
	 * Gets the str id estatus papa.
	 *
	 * @return the strIdEstatusPapa
	 */
	public String getStrIdEstatusPapa() {
		return strIdEstatusPapa;
	}

	/**
	 * Gets the str status hijo.
	 *
	 * @return the strStatusHijo
	 */
	public String getStrStatusHijo() {
		return strStatusHijo;
	}

	/**
	 * Gets the str status papa.
	 *
	 * @return the strStatusPapa
	 */
	public String getStrStatusPapa() {
		return strStatusPapa;
	}

	/**
	 * Checks if is execute permission set.
	 *
	 * @return the executePermissionSet
	 */
	public boolean isExecutePermissionSet() {
		return executePermissionSet;
	}

	/**
	 * On show report.
	 *
	 * @param type the type
	 */
	@Command
	public void onShowReport(@BindingParam("type") final String type) {
		ReportesController controller = new ReportesController();
		ArrayList<String> headersReport = new ArrayList<String>();
		headersReport.add("Nombre HDR");
		headersReport.add("Estatus HDR");
		headersReport.add("Nombre DATA");		
		headersReport.add("Estatus DATA");
		headersReport.add("Reproceso");
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Monitoreo de Archivos");
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Monitoreo de Archivos");
		}
		controller.createReport(generaLista(), headersReport, type, "MONITOREO-ARCHIVOS");
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read()
	 */
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
		List<MonitoreoArchivosVO> monitoreoArchivosVOsLocal = monitoreoArchivosDTO.getMonitoreoArchivosVOs();
		long estadoArchivoHijo;
		long estadoArchivoPapa;
		for (MonitoreoArchivosVO monitoreoArchivosVOLocal : monitoreoArchivosVOsLocal) {
			estadoArchivoHijo = monitoreoArchivosVOLocal.getIdEstadoArchivoHijo();
			estadoArchivoPapa = monitoreoArchivosVOLocal.getIdEstadoArchivoPapa();
			if(estadoArchivoHijo!=4 && estadoArchivoHijo!=5 && estadoArchivoHijo!=9 &&
					estadoArchivoPapa!=4 && estadoArchivoPapa!=5 && estadoArchivoPapa!=9){
				monitoreoArchivosVOLocal.setUrlImagenReproceso("/img/valid.jpg");
			}else if(estadoArchivoHijo==4 || estadoArchivoPapa==4){
				monitoreoArchivosVOLocal.setUrlImagenReproceso("/img/Cancel.png");
			}
		}
		logger.info("::::::::::::::SIZE::::::::::" + monitoreoArchivosDTO.getMonitoreoArchivosVOs());
		
		monitoreoArchivosDTO.setEstadoArchivoVOs(estadoArchivoDTO.getEstadoArchivoVOs());
		
		return monitoreoArchivosDTO;
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read(java.lang.Object)
	 */
	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Read with filters.
	 */
	@Command
	@GlobalCommand
	@NotifyChange({ "monitoreoArchivosVOs" })
	public void readWithFilters() {
		MonitoreoArchivosDTO monitoreoArchivosDTO = new MonitoreoArchivosDTO(); 

		MonitoreoArchivosVO monitoreoArchivosVO = new MonitoreoArchivosVO(); 
		
		monitoreoArchivosVO.setIdEstadoArchivoPapa((Integer.parseInt(statusPapa.getSelectedItem()==null?"0":statusPapa.getSelectedItem().getValue().toString())));
		monitoreoArchivosVO.setIdEstadoArchivoHijo((Integer.parseInt(statusHijo.getSelectedItem()==null?"0":statusHijo.getSelectedItem().getValue().toString())));
		monitoreoArchivosDTO.setMonitoreoArchivosVO(monitoreoArchivosVO);
		monitoreoArchivosDTO.toString(BbvaAbstractDataTransferObject.XML);
		
		MonitoreoArchivosBO monitoreoArchivosBO = new MonitoreoArchivosBO();
		monitoreoArchivosDTO = monitoreoArchivosBO.readCommand(monitoreoArchivosDTO);
		List<MonitoreoArchivosVO> monitoreoArchivosVOsLocal = monitoreoArchivosDTO.getMonitoreoArchivosVOs();
		long estadoArchivoHijo;
		long estadoArchivoPapa;
		for (MonitoreoArchivosVO monitoreoArchivosVOLocal : monitoreoArchivosVOsLocal) {
			estadoArchivoHijo = monitoreoArchivosVOLocal.getIdEstadoArchivoHijo();
			estadoArchivoPapa = monitoreoArchivosVOLocal.getIdEstadoArchivoPapa();
			if(estadoArchivoHijo!=4 && estadoArchivoHijo!=5 && estadoArchivoHijo!=9 &&
					estadoArchivoPapa!=4 && estadoArchivoPapa!=5 && estadoArchivoPapa!=9){
				monitoreoArchivosVOLocal.setUrlImagenReproceso("/img/valid.jpg");
			}else if(estadoArchivoHijo==4 || estadoArchivoPapa==4){
				monitoreoArchivosVOLocal.setUrlImagenReproceso("/img/Cancel.png");
			}
		}
		monitoreoArchivosDTO.setMonitoreoArchivosVOs(monitoreoArchivosVOsLocal);
		monitoreoArchivosVOs = monitoreoArchivosDTO.getMonitoreoArchivosVOs();
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#save()
	 */
	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Sets the execute permission set.
	 *
	 * @param executePermissionSet the executePermissionSet to set
	 */
	public void setExecutePermissionSet(boolean executePermissionSet) {
		this.executePermissionSet = executePermissionSet;
	}

	/**
	 * Sets the id estatus hijo.
	 *
	 * @param idEstatusHijo the idEstatusHijo to set
	 */
	public void setIdEstatusHijo(Textbox idEstatusHijo) {
		this.idEstatusHijo = idEstatusHijo;
	}

	/**
	 * Sets the id estatus papa.
	 *
	 * @param idEstatusPapa the idEstatusPapa to set
	 */
	public void setIdEstatusPapa(Textbox idEstatusPapa) {
		this.idEstatusPapa = idEstatusPapa;
	}

	/**
	 * Sets the monitoreo archivos dto.
	 *
	 * @param monitoreoArchivosDTO the monitoreoArchivosDTO to set
	 */
	public void setMonitoreoArchivosDTO(MonitoreoArchivosDTO monitoreoArchivosDTO) {
		this.monitoreoArchivosDTO = monitoreoArchivosDTO;
	}

	/**
	 * Sets the monitoreo archivos v os.
	 *
	 * @param monitoreoArchivosVOs the monitoreoArchivosVOs to set
	 */
	public void setMonitoreoArchivosVOs(
			List<MonitoreoArchivosVO> monitoreoArchivosVOs) {
		this.monitoreoArchivosVOs = monitoreoArchivosVOs;
	}

	/**
	 * Sets the status hijo.
	 *
	 * @param statusHijo the statusHijo to set
	 */
	public void setStatusHijo(Combobox statusHijo) {
		this.statusHijo = statusHijo;
	}
	
	/**
	 * Sets the status papa.
	 *
	 * @param statusPapa the statusPapa to set
	 */
	public void setStatusPapa(Combobox statusPapa) {
		this.statusPapa = statusPapa;
	}
	
	/**
	 * Sets the str id estatus hijo.
	 *
	 * @param strIdEstatusHijo the strIdEstatusHijo to set
	 */
	public void setStrIdEstatusHijo(String strIdEstatusHijo) {
		this.strIdEstatusHijo = strIdEstatusHijo;
	}
	
	/**
	 * Sets the str id estatus papa.
	 *
	 * @param strIdEstatusPapa the strIdEstatusPapa to set
	 */
	public void setStrIdEstatusPapa(String strIdEstatusPapa) {
		this.strIdEstatusPapa = strIdEstatusPapa;
	}	
	
	/**
	 * Sets the str status hijo.
	 *
	 * @param strStatusHijo the strStatusHijo to set
	 */
	public void setStrStatusHijo(String strStatusHijo) {
		this.strStatusHijo = strStatusHijo;
	}	
	
	/**
	 * Sets the str status papa.
	 *
	 * @param strStatusPapa the strStatusPapa to set
	 */
	public void setStrStatusPapa(String strStatusPapa) {
		this.strStatusPapa = strStatusPapa;
	}
}
