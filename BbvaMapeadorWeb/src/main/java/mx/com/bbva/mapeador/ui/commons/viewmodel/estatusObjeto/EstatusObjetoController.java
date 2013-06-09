package mx.com.bbva.mapeador.ui.commons.viewmodel.estatusObjeto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ClienteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusClaveVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PantallaVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.PantallaBO;
import mx.com.bbva.bancomer.pantalla.dto.PantallaDTO;
import mx.com.bbva.mapeador.security.session.user.SessionUser;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.reportes.ReportesController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;
import mx.com.bbva.mt101.reporter.reportesnegocio.ReporteClientesAAA;

import org.apache.log4j.Logger;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

public class EstatusObjetoController extends ControllerSupport implements IController{
	private static final Logger logger = Logger.getLogger(EstatusObjetoController.class);

	private static final long serialVersionUID = 1L;
	
	public SessionUser getSessionUser(){
		logger.debug( "Entrada getSessionUser          -- OK" );		
		String cveUsuario = null;
		logger.debug( "Datos de usuario -- " + cveUsuario);
		SessionUser sessionUser = new SessionUser();
		sessionUser.setCveUsuario(cveUsuario);
		logger.debug( "Salida getSessionUser          -- OK" );
		return sessionUser;
	}

	@Wire
	private Button reporteExcelBtn;
	@Wire
	private Button reporteCsvBtn;
	@Wire
	private Textbox descripcionEstatusObjeto;		

	private EstatusObjetoDTO estatusObjetoDTO = (EstatusObjetoDTO)this.read();
	private EstatusObjetoVO estatusObjetoVO = null;
	
	/**
	 * @return the estatusObjetoVO
	 */
	public final EstatusObjetoVO getEstatusObjetoVO() {
		return estatusObjetoVO;
	}

	/**
	 * @param estatusObjetoVO the estatusObjetoVO to set
	 */
	public final void setEstatusObjetoVO(EstatusObjetoVO estatusObjetoVO) {
		this.estatusObjetoVO = estatusObjetoVO;
	}

	@Wire
	private Textbox idEstatusClave;
	@Wire
	private Textbox idEstatusObjeto;
	@Wire
	private Textbox idPantalla;
	@Wire
	private Textbox nombreEstatusObjeto;
	@Wire
	private Combobox pantallas;
	@Wire
	private Combobox statusClave;
	@Wire
	private Label lblPantalla;
	@Wire
	private Label lblEstatusObjeto;
	@Wire
	private Button limpiarBtn;
	@Wire
	private Button guardarBtn;
	@Wire
	private Button consultarBtn;
	@Wire
	private Button eliminarBtn;
	@Wire
	private Grid estatusObjetosGrid;
	@Wire
	private Grid clientesGrid;
		
	List<EstatusObjetoVO> estatusObjetoVOs = estatusObjetoDTO.getEstatusObjetoVOs();
	
	/**
	 * @return the estatusObjetoVOs
	 */
	public final List<EstatusObjetoVO> getEstatusObjetoVOs() {
		return estatusObjetoVOs;
	}

	/**
	 * @param estatusObjetoVOs the estatusObjetoVOs to set
	 */
	public final void setEstatusObjetoVOs(List<EstatusObjetoVO> estatusObjetoVOs) {
		this.estatusObjetoVOs = estatusObjetoVOs;
	}

	private String strDescripcionEstatusObjeto;
	
	private String strIdEstatusClave;

	private String strIdEstatusObjeto;

	private String strIdPantalla;

	private String strNombreEstatusObjeto;

	private String strPantallas;

	private String strStatusClave;
	
	private boolean executePermissionSet;

	public EstatusObjetoController() {
		super();
	}

	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
    }

	@Override
	@Command	
	public void clean() {		
		pantallas.clearErrorMessage();
		nombreEstatusObjeto.clearErrorMessage();
		descripcionEstatusObjeto.clearErrorMessage();
		statusClave.clearErrorMessage();
		
		pantallas.setValue(null);
		nombreEstatusObjeto.setValue(null);
		descripcionEstatusObjeto.setValue(null);
		statusClave.setValue(null);
		idEstatusClave.setValue(null);
		idPantalla.setValue(null);
		idEstatusObjeto.setValue(null);
		estatusObjetoVO = null;
	}

	@Override
	@Command
	public void delete() {
		logger.debug("Eliminando registro:"+idEstatusObjeto.getValue());
		if(!idEstatusObjeto.getValue().isEmpty()){
			Messagebox.show(
					"¿Está seguro que desea eliminar el estatus?",
					"Pregunta", Messagebox.YES | Messagebox.NO,
					Messagebox.QUESTION, new EventListener<Event>() {
						@Override
						public void onEvent(Event event) throws Exception {
							EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
							EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
							estatusObjetoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
							estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
							EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
							estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);
							estatusObjetoDTO = estatusObjetoBO.deleteCommand(estatusObjetoDTO);
							if(estatusObjetoDTO.getErrorCode().equals("0002")){
								Messagebox.show(estatusObjetoDTO.getErrorDescription(),
										"Error", Messagebox.OK,
										Messagebox.ERROR);
								clean();
								BindUtils
										.postGlobalCommand(
												null,
												null,
												"resetGridEstatusObjetos",
												null);
							}else{
								Messagebox.show("!El registro fue eliminado!",
										"Información", Messagebox.OK,
										Messagebox.INFORMATION);
								clean();
								BindUtils
										.postGlobalCommand(
												null,
												null,
												"resetGridEstatusObjetos",
												null);
							}
						}
					});
		}else{
			Messagebox.show("!Favor de seleccionar el registro a eliminar!",
					"Error", Messagebox.OK,
					Messagebox.ERROR);
		}
	}

	/**
	 * @return the estatusObjetoDTO
	 */
	public EstatusObjetoDTO getEstatusObjetoDTO() {
		return estatusObjetoDTO;
	}

	/**
	 * @return the strDescripcionEstatusObjeto
	 */
	public String getStrDescripcionEstatusObjeto() {
		return strDescripcionEstatusObjeto;
	}

	/**
	 * @return the strIdEstatusClave
	 */
	public String getStrIdEstatusClave() {
		return strIdEstatusClave;
	}

	/**
	 * @return the strIdEstatusObjeto
	 */
	public String getStrIdEstatusObjeto() {
		return strIdEstatusObjeto;
	}

	/**
	 * @return the strIdPantalla
	 */
	public String getStrIdPantalla() {
		return strIdPantalla;
	}
	
	/**
	 * @return the strNombreEstatusObjeto
	 */
	public String getStrNombreEstatusObjeto() {
		return strNombreEstatusObjeto;
	}
		
	/**
	 * @return the strPantallas
	 */
	public String getStrPantallas() {
		return strPantallas;
	}
	
	/**
	 * @return the strStatusClave
	 */
	public String getStrStatusClave() {
		return strStatusClave;
	}
	@Command
	@NotifyChange({ "estatusObjetoVOs" })
	public void readWithFilters() {
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();		
		estatusObjetoVO.setDescripcionEstatusObjeto(descripcionEstatusObjeto.getValue().isEmpty()?"%":"%"+descripcionEstatusObjeto.getValue().toUpperCase()+"%");
		estatusObjetoVO.setNombreTabla(pantallas.getValue().isEmpty()?null:pantallas.getValue().toUpperCase());
		estatusObjetoVO.setNombreEstatusObjeto(nombreEstatusObjeto.getValue().isEmpty()?"%":"%"+nombreEstatusObjeto.getValue().toUpperCase()+"%");
		estatusObjetoVO.setIdEstatusClave(Integer.parseInt(idEstatusClave.getValue().isEmpty()?"0":idEstatusClave.getValue()));
		estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
		estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);		
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
		logger.debug("size:"+estatusObjetoDTO.getEstatusObjetoVOs().size());
		estatusObjetoVOs = estatusObjetoDTO.getEstatusObjetoVOs();
		ReportesController controller = new ReportesController();
		controller.registrarEvento(null, null, CommandConstants.CONSULTAR, "Estatus Objeto");
	}
	
	
	
	@Override	
	public Object read() {
		
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		logger.debug("*estatusObjetoVO*");
		estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();				
		estatusObjetoVO.setDescripcionEstatusObjeto(strDescripcionEstatusObjeto==null?"%":"%"+strDescripcionEstatusObjeto.toUpperCase()+"%");
		estatusObjetoVO.setNombreTabla(strPantallas==null?null:"%"+strPantallas.toUpperCase()+"%");
		estatusObjetoVO.setNombreEstatusObjeto(strNombreEstatusObjeto==null?"%":"%"+strNombreEstatusObjeto.toUpperCase()+"%");
		estatusObjetoVO.setIdEstatusObjeto(Integer.parseInt(strIdEstatusClave==null?"0":strIdEstatusClave));		
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
		estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);		
		estatusObjetoDTO.setEstatusObjetoVOs(estatusObjetoBO.readCommand(estatusObjetoDTO).getEstatusObjetoVOs());
		logger.debug("*pantallaVO*");		
		estatusObjetoDTO.setCommandId(CommandConstants.NOMBRE_PANTALLA);
		estatusObjetoBO = new EstatusObjetoBO();
		estatusObjetoDTO.setEstatusObjetoPantallaVOs(estatusObjetoBO.readCommand(estatusObjetoDTO).getEstatusObjetoPantallaVOs());
		logger.debug("*estatusClaveVO*");
		estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_CLAVE);
		EstatusClaveVO estatusClaveVO = new EstatusClaveVO();
		estatusObjetoDTO.setEstatusClaveVO(estatusClaveVO);
		List<EstatusClaveVO> estatusClaveVOs = estatusObjetoBO.readCommand(estatusObjetoDTO).getEstatusClaveVOs();
		estatusObjetoDTO.setEstatusClaveVOs(estatusClaveVOs);
		return estatusObjetoDTO;
	}
	
	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Command
	public void readSelected(@BindingParam("idEstatusObjeto") final EstatusObjetoVO estatusObjetoVO){
		estatusObjetoVO.toString();
		this.estatusObjetoVO = estatusObjetoVO;
		pantallas.setValue(estatusObjetoVO.getNombreTabla());		
		nombreEstatusObjeto.setValue(estatusObjetoVO.getNombreEstatusObjeto());
		descripcionEstatusObjeto.setValue(estatusObjetoVO.getDescripcionEstatusObjeto());
		statusClave.setValue(estatusObjetoVO.getNombreStatusClave());
		idEstatusClave.setValue(Integer.toString(estatusObjetoVO.getIdEstatusClave()));
		idPantalla.setValue(estatusObjetoVO.getNombreTabla());
		idEstatusObjeto.setValue(Integer.toString(estatusObjetoVO.getIdEstatusObjeto()));			
	}

	@Override
	@Command
	@NotifyChange({ "estatusObjetoVOs" })
	public void save() {
		boolean errorGuardar = false;
		String nombreTabla = null;
		if (pantallas.getSelectedItem() == null
				|| pantallas.getSelectedItem().getValue() == null
				|| pantallas.getSelectedItem().getValue().toString().isEmpty()) {
			pantallas.setErrorMessage("Favor de seleccionar la Pantalla.");
			errorGuardar = true;
		}
		if (nombreEstatusObjeto.getValue().isEmpty()) {
			nombreEstatusObjeto
					.setErrorMessage("Favor de introducir nombre del Estatus del Objeto");
			errorGuardar = true;
		} 
		if (statusClave.getSelectedItem() == null
				|| statusClave.getSelectedItem().getValue() == null
				|| statusClave.getSelectedItem().getValue().toString().isEmpty()) {
			statusClave.setErrorMessage("Favor de seleccionar el Estatus del Objeto.");
			errorGuardar = true;
		}
		if (descripcionEstatusObjeto.getValue().isEmpty()) {
			descripcionEstatusObjeto
					.setErrorMessage("Favor de introducir la descripción del Estatus del Objeto");
			errorGuardar = true;
		}
		ReportesController controller = new ReportesController();
		if(!errorGuardar){
			if(idEstatusObjeto.getValue().isEmpty()){
				nombreTabla = pantallas.getSelectedItem().getLabel().toUpperCase();
				EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
				EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
				estatusObjetoVO.setDescripcionEstatusObjeto(descripcionEstatusObjeto.getValue().toUpperCase().trim());
				estatusObjetoVO.setIdEstatusClave(Integer.parseInt(idEstatusClave.getValue()));
				estatusObjetoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
				estatusObjetoVO.setNombreEstatusObjeto(nombreEstatusObjeto.getValue().toUpperCase().trim());
				estatusObjetoVO.setNombreTabla(nombreTabla);
				estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
				estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);
				EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
				estatusObjetoBO.createCommand(estatusObjetoDTO);				
				controller.registrarEvento(null, null, CommandConstants.ALTA, "Estatus Objeto");
				clean();			
				logger.debug("*estatusObjetoVO*");
				estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
				estatusObjetoVO = new EstatusObjetoVO();				
				estatusObjetoVO.setDescripcionEstatusObjeto(strDescripcionEstatusObjeto==null?"%":"%"+strDescripcionEstatusObjeto.toUpperCase()+"%");
				estatusObjetoVO.setNombreTabla(strPantallas==null?null:"%"+strPantallas.toUpperCase()+"%");
				estatusObjetoVO.setNombreEstatusObjeto(strNombreEstatusObjeto==null?"%":"%"+strNombreEstatusObjeto.toUpperCase()+"%");
				estatusObjetoVO.setIdEstatusObjeto(Integer.parseInt(strIdEstatusClave==null?"0":strIdEstatusClave));		
				estatusObjetoBO = new EstatusObjetoBO();
				estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
				estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);		
				estatusObjetoDTO.setEstatusObjetoVOs(estatusObjetoBO.readCommand(estatusObjetoDTO).getEstatusObjetoVOs());
				estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
				estatusObjetoVOs = estatusObjetoBO.readCommand(estatusObjetoDTO).getEstatusObjetoVOs();
				Messagebox.show("Registro creado con exito!!",
						"Confirmación", Messagebox.OK,
						Messagebox.INFORMATION);
			}else{
				nombreTabla = pantallas.getSelectedItem().getLabel().toUpperCase();
				EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
				EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
				estatusObjetoVO.setDescripcionEstatusObjeto(descripcionEstatusObjeto.getValue().toUpperCase().trim());
				estatusObjetoVO.setIdEstatusClave(Integer.parseInt(idEstatusClave.getValue()));
				estatusObjetoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
				estatusObjetoVO.setNombreEstatusObjeto(nombreEstatusObjeto.getValue().toUpperCase().trim());
				estatusObjetoVO.setNombreTabla(nombreTabla);
				estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
				estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);
				EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
				estatusObjetoBO.updateCommand(estatusObjetoDTO);
				controller.registrarEvento(estatusObjetoVO, this.estatusObjetoVO, CommandConstants.MODIFICACION, "Estatus Objeto");
				clean();			
				logger.debug("*estatusObjetoVO*");
				estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
				estatusObjetoVO = new EstatusObjetoVO();				
				estatusObjetoVO.setDescripcionEstatusObjeto(strDescripcionEstatusObjeto==null?"%":"%"+strDescripcionEstatusObjeto.toUpperCase()+"%");
				estatusObjetoVO.setNombreTabla(strPantallas==null?null:"%"+strPantallas.toUpperCase()+"%");
				estatusObjetoVO.setNombreEstatusObjeto(strNombreEstatusObjeto==null?"%":"%"+strNombreEstatusObjeto.toUpperCase()+"%");
				estatusObjetoVO.setIdEstatusObjeto(Integer.parseInt(strIdEstatusClave==null?"0":strIdEstatusClave));		
				estatusObjetoBO = new EstatusObjetoBO();
				estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
				estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);		
				estatusObjetoDTO.setEstatusObjetoVOs(estatusObjetoBO.readCommand(estatusObjetoDTO).getEstatusObjetoVOs());
				estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
				estatusObjetoVOs = estatusObjetoBO.readCommand(estatusObjetoDTO).getEstatusObjetoVOs();				
				Messagebox.show("Registro actualizado con exito!!",
						"Confirmación", Messagebox.OK,
						Messagebox.INFORMATION);
			}
		}
		
	}

	/**
	 * @param estatusObjetoDTO the estatusObjetoDTO to set
	 */
	public void setEstatusObjetoDTO(EstatusObjetoDTO estatusObjetoDTO) {
		this.estatusObjetoDTO = estatusObjetoDTO;
	}
	/**
	 * @param strDescripcionEstatusObjeto the strDescripcionEstatusObjeto to set
	 */
	public void setStrDescripcionEstatusObjeto(
			String strDescripcionEstatusObjeto) {
		this.strDescripcionEstatusObjeto = strDescripcionEstatusObjeto;
	}

	/**
	 * @param strIdEstatusClave the strIdEstatusClave to set
	 */
	public void setStrIdEstatusClave(String strIdEstatusClave) {
		this.strIdEstatusClave = strIdEstatusClave;
	}

	/**
	 * @param strIdEstatusObjeto the strIdEstatusObjeto to set
	 */
	public void setStrIdEstatusObjeto(String strIdEstatusObjeto) {
		this.strIdEstatusObjeto = strIdEstatusObjeto;
	}

	/**
	 * @param strIdPantalla the strIdPantalla to set
	 */
	public void setStrIdPantalla(String strIdPantalla) {
		this.strIdPantalla = strIdPantalla;
	}

	/**
	 * @param strNombreEstatusObjeto the strNombreEstatusObjeto to set
	 */
	public void setStrNombreEstatusObjeto(String strNombreEstatusObjeto) {
		this.strNombreEstatusObjeto = strNombreEstatusObjeto;
	}

	/**
	 * @param strPantallas the strPantallas to set
	 */
	public void setStrPantallas(String strPantallas) {
		this.strPantallas = strPantallas;
	}
	
	/**
	 * @param strStatusClave the strStatusClave to set
	 */
	public void setStrStatusClave(String strStatusClave) {
		this.strStatusClave = strStatusClave;
	}
	@GlobalCommand("resetGridEstatusObjetos")
	@NotifyChange({ "estatusObjetoVOs" })
	public void resetGrid() {
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();		
		estatusObjetoVO.setDescripcionEstatusObjeto(descripcionEstatusObjeto.getValue().isEmpty()?"%":"%"+descripcionEstatusObjeto.getValue().toUpperCase()+"%");
		estatusObjetoVO.setNombreTabla(pantallas.getValue().isEmpty()?null:pantallas.getValue().toUpperCase());
		estatusObjetoVO.setNombreEstatusObjeto(nombreEstatusObjeto.getValue().isEmpty()?"%":"%"+nombreEstatusObjeto.getValue().toUpperCase()+"%");
		estatusObjetoVO.setIdEstatusClave(Integer.parseInt(idEstatusClave.getValue().isEmpty()?"0":idEstatusClave.getValue()));
		estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
		estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);		
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
		logger.debug("size:"+estatusObjetoDTO.getEstatusObjetoVOs().size());
		estatusObjetoVOs = estatusObjetoDTO.getEstatusObjetoVOs();
		//operacionesDudosasGrid.invalidate();
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
		componentes.put(lblPantalla.getId(), lblPantalla);
		componentes.put(lblEstatusObjeto.getId(), lblEstatusObjeto);
		componentes.put(nombreEstatusObjeto.getId(), nombreEstatusObjeto);
		componentes.put(descripcionEstatusObjeto.getId(), descripcionEstatusObjeto);
		componentes.put(pantallas.getId(), pantallas);
		componentes.put(statusClave.getId(), statusClave);
		componentes.put(limpiarBtn.getId(), limpiarBtn);
		componentes.put(guardarBtn.getId(), guardarBtn);
		componentes.put(consultarBtn.getId(), consultarBtn);
		componentes.put(eliminarBtn.getId(), eliminarBtn);
		componentes.put(estatusObjetosGrid.getId(), estatusObjetosGrid);
		componentes.put(reporteExcelBtn.getId(), reporteExcelBtn);
		componentes.put(reporteCsvBtn.getId(), reporteCsvBtn);
		super.applyPermission(MapeadorConstants.ESTATUS, componentes);
		return isApplied;
	}
	
	@Command
	public void onShowReport(@BindingParam("type") final String type) {
		ReportesController controller = new ReportesController();
		ArrayList<String> headersReport = new ArrayList<String>();
		headersReport.add("Pantalla");
		headersReport.add("Nombre Estatus Objeto");
		headersReport.add("Descripción estatus objeto");
		headersReport.add("Status");		
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Catálogo Estatus");
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Catálogo Estatus");
		}
		controller.createReport(generaLista(), headersReport, type, "ESTATUS-OBJETO");
	}	
	
	private ArrayList<BeanGenerico> generaLista() {		
		ArrayList<BeanGenerico> beanGenericos = new ArrayList<BeanGenerico>();
		BeanGenerico beanGenerico = null;
		for(EstatusObjetoVO estatusObjetoVO: estatusObjetoVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(estatusObjetoVO.getNombreTabla());
			beanGenerico.setValor2(estatusObjetoVO.getNombreEstatusObjeto());
			beanGenerico.setValor3(estatusObjetoVO.getDescripcionEstatusObjeto());
			beanGenerico.setValor4(estatusObjetoVO.getNombreEstatusObjeto());			
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}
}
