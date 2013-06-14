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
 * Nombre de clase: EstatusObjetoController.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.estatusObjeto
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.estatusObjeto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusClaveVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.mapeador.security.session.user.SessionUser;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.reportes.ReportesController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

import org.apache.log4j.Logger;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

// TODO: Auto-generated Javadoc
/**
 * The Class EstatusObjetoController.
 */
public class EstatusObjetoController extends ControllerSupport implements IController{
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(EstatusObjetoController.class);

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The nombre Pantalla */
	private static final String nombrePantalla="Catálogo Estatus Objeto";	
	
	/** The clientes grid. */
	@Wire
	private Grid clientesGrid;

	/** The consultar btn. */
	@Wire
	private Button consultarBtn;
	
	/** The descripcion estatus objeto. */
	@Wire
	private Textbox descripcionEstatusObjeto;
	
	/** The eliminar btn. */
	@Wire
	private Button eliminarBtn;		

	/** The estatus objeto dto. */
	private EstatusObjetoDTO estatusObjetoDTO = (EstatusObjetoDTO)this.read();
	
	/** The estatus objetos grid. */
	@Wire
	private Grid estatusObjetosGrid;
	
	/** The estatus objeto vo. */
	private EstatusObjetoVO estatusObjetoVO = null;

	/** The estatus objeto v os. */
	List<EstatusObjetoVO> estatusObjetoVOs = estatusObjetoDTO.getEstatusObjetoVOs();

	/** The execute permission set. */
	private boolean executePermissionSet;
	
	/** The guardar btn. */
	@Wire
	private Button guardarBtn;
	
	/** The id estatus clave. */
	@Wire
	private Textbox idEstatusClave;
	
	/** The id estatus objeto. */
	@Wire
	private Textbox idEstatusObjeto;
	
	/** The id pantalla. */
	@Wire
	private Textbox idPantalla;
	
	/** The lbl estatus objeto. */
	@Wire
	private Label lblEstatusObjeto;
	
	/** The lbl pantalla. */
	@Wire
	private Label lblPantalla;
	
	/** The limpiar btn. */
	@Wire
	private Button limpiarBtn;
	
	/** The nombre estatus objeto. */
	@Wire
	private Textbox nombreEstatusObjeto;
	
	/** The pantallas. */
	@Wire
	private Combobox pantallas;
	
	/** The reporte csv btn. */
	@Wire
	private Button reporteCsvBtn;
	
	/** The reporte excel btn. */
	@Wire
	private Button reporteExcelBtn;
	
	/** The status clave. */
	@Wire
	private Combobox statusClave;
	
	/** The str descripcion estatus objeto. */
	private String strDescripcionEstatusObjeto;
		
	/** The str id estatus clave. */
	private String strIdEstatusClave;
	
	/** The str id estatus objeto. */
	private String strIdEstatusObjeto;

	/** The str id pantalla. */
	private String strIdPantalla;

	/** The str nombre estatus objeto. */
	private String strNombreEstatusObjeto;
	
	/** The str pantallas. */
	private String strPantallas;

	/** The str status clave. */
	private String strStatusClave;

	/**
	 * Instantiates a new estatus objeto controller.
	 */
	public EstatusObjetoController() {
		super();
	}

	/**
	 * After compose.
	 *
	 * @param view the view
	 */
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);
        defaultValues();
    }

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#applyPermision()
	 */
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

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#clean()
	 */
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
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#delete()
	 */
	@Override
	@Command
	public void delete() {
		logger.debug("Eliminando registro:"+idEstatusObjeto.getValue());
		if(!idEstatusObjeto.getValue().isEmpty()){
			org.zkoss.zul.Messagebox.show(
					"¿Está seguro que desea eliminar el estatus?",
					"Pregunta", org.zkoss.zul.Messagebox.YES | org.zkoss.zul.Messagebox.NO,
					org.zkoss.zul.Messagebox.QUESTION, new EventListener<Event>() {
						@Override
						public void onEvent(Event event) throws Exception {
							if (event.getName().equals(org.zkoss.zul.Messagebox.ON_YES)) {
								ReportesController controller = new ReportesController();
								EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
								EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
								estatusObjetoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
								estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
								EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
								estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);
								estatusObjetoDTO = estatusObjetoBO.deleteCommand(estatusObjetoDTO);
								if(estatusObjetoDTO.getErrorCode().equals("0002")){
									org.zkoss.zul.Messagebox.show(estatusObjetoDTO.getErrorDescription(),
											"Error", org.zkoss.zul.Messagebox.OK,
											org.zkoss.zul.Messagebox.ERROR);
									clean();
									BindUtils
											.postGlobalCommand(
													null,
													null,
													"resetGridEstatusObjetos",
													null);
								}else{
									controller.registrarEvento(null, null, CommandConstants.ELIMINACION,nombrePantalla);
									org.zkoss.zul.Messagebox.show("!El registro fue eliminado!",
											"Información", org.zkoss.zul.Messagebox.OK,
											org.zkoss.zul.Messagebox.INFORMATION);
									clean();
									BindUtils
											.postGlobalCommand(
													null,
													null,
													"resetGridEstatusObjetos",
													null);
								}
							}
						}
					});
		}else{
			org.zkoss.zul.Messagebox.show("!Favor de seleccionar el registro a eliminar!",
					"Error", org.zkoss.zul.Messagebox.OK,
					org.zkoss.zul.Messagebox.ERROR);
		}
	}

	/**
	 * Genera lista.
	 *
	 * @return the array list
	 */
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

	/**
	 * Gets the estatus objeto dto.
	 *
	 * @return the estatusObjetoDTO
	 */
	public EstatusObjetoDTO getEstatusObjetoDTO() {
		return estatusObjetoDTO;
	}

	/**
	 * Gets the estatus objeto vo.
	 *
	 * @return the estatusObjetoVO
	 */
	public final EstatusObjetoVO getEstatusObjetoVO() {
		return estatusObjetoVO;
	}

	/**
	 * Gets the estatus objeto v os.
	 *
	 * @return the estatusObjetoVOs
	 */
	public final List<EstatusObjetoVO> getEstatusObjetoVOs() {
		return estatusObjetoVOs;
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport#getSessionUser()
	 */
	@Override
	public SessionUser getSessionUser(){
		logger.debug( "Entrada getSessionUser          -- OK" );		
		String cveUsuario = null;
		logger.debug( "Datos de usuario -- " + cveUsuario);
		SessionUser sessionUser = new SessionUser();
		sessionUser.setCveUsuario(cveUsuario);
		logger.debug( "Salida getSessionUser          -- OK" );
		return sessionUser;
	}

	/**
	 * Gets the str descripcion estatus objeto.
	 *
	 * @return the strDescripcionEstatusObjeto
	 */
	public String getStrDescripcionEstatusObjeto() {
		return strDescripcionEstatusObjeto;
	}

	/**
	 * Gets the str id estatus clave.
	 *
	 * @return the strIdEstatusClave
	 */
	public String getStrIdEstatusClave() {
		return strIdEstatusClave;
	}

	/**
	 * Gets the str id estatus objeto.
	 *
	 * @return the strIdEstatusObjeto
	 */
	public String getStrIdEstatusObjeto() {
		return strIdEstatusObjeto;
	}

	/**
	 * Gets the str id pantalla.
	 *
	 * @return the strIdPantalla
	 */
	public String getStrIdPantalla() {
		return strIdPantalla;
	}
	
	/**
	 * Gets the str nombre estatus objeto.
	 *
	 * @return the strNombreEstatusObjeto
	 */
	public String getStrNombreEstatusObjeto() {
		return strNombreEstatusObjeto;
	}
		
	/**
	 * Gets the str pantallas.
	 *
	 * @return the strPantallas
	 */
	public String getStrPantallas() {
		return strPantallas;
	}
	
	/**
	 * Gets the str status clave.
	 *
	 * @return the strStatusClave
	 */
	public String getStrStatusClave() {
		return strStatusClave;
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
		headersReport.add("Pantalla");
		headersReport.add("Nombre Estatus Objeto");
		headersReport.add("Descripción estatus objeto");
		headersReport.add("Status");		
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,nombrePantalla);
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,nombrePantalla);
		}
		controller.createReport(generaLista(), headersReport, type, "ESTATUS-OBJETO");
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read()
	 */
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
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read(java.lang.Object)
	 */
	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Read selected.
	 *
	 * @param estatusObjetoVO the estatus objeto vo
	 */
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

	/**
	 * Read with filters.
	 */
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
		controller.registrarEvento(null, null, CommandConstants.CONSULTAR, nombrePantalla);
	}
	
	/**
	 * Reset grid.
	 */
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

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#save()
	 */
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
				EstatusObjetoVO estatusObjetoNuevo = new EstatusObjetoVO();
				estatusObjetoNuevo.setDescripcionEstatusObjeto("");
				estatusObjetoNuevo.setIdEstatusClave(-1);
				estatusObjetoNuevo.setIdEstatusObjeto(-1);
				estatusObjetoNuevo.setNombreEstatusObjeto("");
				estatusObjetoNuevo.setNombreTabla("");
				controller.registrarEvento(estatusObjetoVO, estatusObjetoNuevo, CommandConstants.ALTA, nombrePantalla);
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
				org.zkoss.zul.Messagebox.show("Registro creado con exito!!",
						"Confirmación", org.zkoss.zul.Messagebox.OK,
						org.zkoss.zul.Messagebox.INFORMATION);
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

				controller.registrarEvento(estatusObjetoVO, this.estatusObjetoVO, CommandConstants.MODIFICACION, nombrePantalla);

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
				org.zkoss.zul.Messagebox.show("Registro actualizado con exito!!",
						"Confirmación", org.zkoss.zul.Messagebox.OK,
						org.zkoss.zul.Messagebox.INFORMATION);
			}
		}
		
	}

	/**
	 * Default values.
	 */
	private void defaultValues() {
		idEstatusClave.setValue(String.valueOf(CommandConstants.ESTATUS_OBJETO_ACTIVO));
		statusClave.setValue(CommandConstants.NB_ESTATUS_ACTIVO);
	}

	/**
	 * Sets the estatus objeto dto.
	 *
	 * @param estatusObjetoDTO the estatusObjetoDTO to set
	 */
	public void setEstatusObjetoDTO(EstatusObjetoDTO estatusObjetoDTO) {
		this.estatusObjetoDTO = estatusObjetoDTO;
	}

	/**
	 * Sets the estatus objeto vo.
	 *
	 * @param estatusObjetoVO the estatusObjetoVO to set
	 */
	public final void setEstatusObjetoVO(EstatusObjetoVO estatusObjetoVO) {
		this.estatusObjetoVO = estatusObjetoVO;
	}

	/**
	 * Sets the estatus objeto v os.
	 *
	 * @param estatusObjetoVOs the estatusObjetoVOs to set
	 */
	public final void setEstatusObjetoVOs(List<EstatusObjetoVO> estatusObjetoVOs) {
		this.estatusObjetoVOs = estatusObjetoVOs;
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
	 * Sets the str descripcion estatus objeto.
	 *
	 * @param strDescripcionEstatusObjeto the strDescripcionEstatusObjeto to set
	 */
	public void setStrDescripcionEstatusObjeto(
			String strDescripcionEstatusObjeto) {
		this.strDescripcionEstatusObjeto = strDescripcionEstatusObjeto;
	}
	
	/**
	 * Sets the str id estatus clave.
	 *
	 * @param strIdEstatusClave the strIdEstatusClave to set
	 */
	public void setStrIdEstatusClave(String strIdEstatusClave) {
		this.strIdEstatusClave = strIdEstatusClave;
	}

	/**
	 * Sets the str id estatus objeto.
	 *
	 * @param strIdEstatusObjeto the strIdEstatusObjeto to set
	 */
	public void setStrIdEstatusObjeto(String strIdEstatusObjeto) {
		this.strIdEstatusObjeto = strIdEstatusObjeto;
	}
	
	/**
	 * Sets the str id pantalla.
	 *
	 * @param strIdPantalla the strIdPantalla to set
	 */
	public void setStrIdPantalla(String strIdPantalla) {
		this.strIdPantalla = strIdPantalla;
	}
	
	/**
	 * Sets the str nombre estatus objeto.
	 *
	 * @param strNombreEstatusObjeto the strNombreEstatusObjeto to set
	 */
	public void setStrNombreEstatusObjeto(String strNombreEstatusObjeto) {
		this.strNombreEstatusObjeto = strNombreEstatusObjeto;
	}
	
	/**
	 * Sets the str pantallas.
	 *
	 * @param strPantallas the strPantallas to set
	 */
	public void setStrPantallas(String strPantallas) {
		this.strPantallas = strPantallas;
	}	
	
	/**
	 * Sets the str status clave.
	 *
	 * @param strStatusClave the strStatusClave to set
	 */
	public void setStrStatusClave(String strStatusClave) {
		this.strStatusClave = strStatusClave;
	}
}
