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
 * Nombre de clase: MensajesSistemaController.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.mensajessistema
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.mensajessistema;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import mx.com.bbva.bancomer.bitacora.dto.BitacoraDTO;
import mx.com.bbva.bancomer.bitacora.dto.CampoDTO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ContratacionMapVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MensajeSalidaVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.ContratacionMapeadorBO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.MensajeSalidaBO;
import mx.com.bbva.bancomer.mensajesalida.dto.MensajeSalidaDTO;
import mx.com.bbva.bancomer.utils.StringUtil;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.reportes.ReportesController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

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
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

// TODO: Auto-generated Javadoc
/**
 * The Class MensajesSistemaController.
 */
public class MensajesSistemaController extends ControllerSupport implements IController {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4649691032075701267L;
	
	/** The consultar btn. */
	@Wire
	private Button consultarBtn;
	
	/** The descripcion asunto salida. */
	@Wire
	private Textbox descripcionAsuntoSalida;
	
	/** The descripcion mensaje salida. */
	@Wire
	private Textbox descripcionMensajeSalida;
	
	/** The execute permission set. */
	private boolean executePermissionSet;
	
	/** The fecha alta. */
	@Wire
	private Datebox fechaAlta;
	
	/** The fecha modificacion. */
	@Wire
	private Datebox fechaModificacion;
	
	/** The flag mensaje. */
	private boolean flagMensaje;
	
	/** The guardar btn. */
	@Wire
	private Button guardarBtn;
	
	/** The id estatus objeto. */
	@Wire
	private Textbox idEstatusObjeto;
	
	/** The id mensaje salida. */
	@Wire
	private Textbox idMensajeSalida;
	
	/** The id str estatus objeto. */
	private String idStrEstatusObjeto;
	
	/** The lbl asunto mensaje. */
	@Wire
	private Label lblAsuntoMensaje;
	
	/** The lbl estatus. */
	@Wire
	private Label lblEstatus;
	
	/** The lbl fecha alta. */
	@Wire
	private Label lblFechaAlta;
	
	/** The lbl fecha modificacion. */
	@Wire
	private Label lblFechaModificacion;
	
	/** The lbl identificador mensaje. */
	@Wire
	private Label lblIdentificadorMensaje;
	
	/** The lbl texto mensaje. */
	@Wire
	private Label lblTextoMensaje;
	
	/** The limpiar btn. */
	@Wire
	private Button limpiarBtn;
	
	/** The mensaje salida dto. */
	private MensajeSalidaDTO mensajeSalidaDTO;
	
	/** The mensaje salida vo. */
	private MensajeSalidaVO mensajeSalidaVO;
	
	/** The mensaje salida v os. */
	private List<MensajeSalidaVO> mensajeSalidaVOs;
	
	/** The mensajes grid. */
	@Wire
	private Grid mensajesGrid;
	
	/** The nombre mensaje salida. */
	@Wire
	private Textbox nombreMensajeSalida;
	
	/** The reporte csv btn. */
	@Wire
	private Image reporteCsvBtn;
	
	/** The reporte excel btn. */
	@Wire
	private Image reporteExcelBtn;
	
	/** The status objeto. */
	@Wire
	private Combobox statusObjeto;
	
	/**
	 * Instantiates a new mensajes sistema controller.
	 */
	public MensajesSistemaController() {
		this.read();
		this.mensajeSalidaVOs = mensajeSalidaDTO.getMensajeSalidaVOs();
		flagMensaje = false;
	}
	
	/**
	 * After compose.
	 *
	 * @param view the view
	 */
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);   
        executePermissionSet = this.applyPermision();
        statusObjeto.setValue(CommandConstants.NB_MENSAJE_ACTIVO);
        idStrEstatusObjeto = String.valueOf(CommandConstants.ID_MENSAJE_ACTIVO);
        
    }
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#applyPermision()
	 */
	@Override
	public boolean applyPermision() {
		boolean isApplied = false;
		HashMap<String, Component> componentes = new HashMap<String, Component>();
		componentes.put(lblIdentificadorMensaje.getId(), lblIdentificadorMensaje);
		componentes.put(lblEstatus.getId(), lblEstatus);
		componentes.put(lblTextoMensaje.getId(), lblTextoMensaje);
		componentes.put(lblFechaAlta.getId(), lblFechaAlta);
		componentes.put(lblFechaModificacion.getId(), lblFechaModificacion);
		componentes.put(nombreMensajeSalida.getId(), nombreMensajeSalida);
		componentes.put(descripcionMensajeSalida.getId(), descripcionMensajeSalida);
		componentes.put(statusObjeto.getId(), statusObjeto);
		componentes.put(fechaAlta.getId(), fechaAlta);
		componentes.put(fechaModificacion.getId(), fechaModificacion);
		componentes.put(reporteExcelBtn.getId(), reporteExcelBtn);
		componentes.put(reporteCsvBtn.getId(), reporteCsvBtn);
		componentes.put(limpiarBtn.getId(), limpiarBtn);
		componentes.put(guardarBtn.getId(), guardarBtn);
		componentes.put(consultarBtn.getId(), consultarBtn);
		componentes.put(mensajesGrid.getId(), mensajesGrid);
		componentes.put(lblAsuntoMensaje.getId(), lblAsuntoMensaje);
		componentes.put(descripcionAsuntoSalida.getId(), descripcionAsuntoSalida);
		
		super.applyPermission(MapeadorConstants.MENSAJES_SISTEMA, componentes);
		return isApplied;
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#clean()
	 */
	@Override
	@Command
	@NotifyChange({"idStrEstatusObjeto","statusObjeto"})
	public void clean() {
		nombreMensajeSalida.clearErrorMessage();
		descripcionMensajeSalida.clearErrorMessage();
		idEstatusObjeto.clearErrorMessage();
		statusObjeto.clearErrorMessage();
		idMensajeSalida.clearErrorMessage();
		descripcionAsuntoSalida.clearErrorMessage();
		
		nombreMensajeSalida.setValue(null);
		nombreMensajeSalida.setReadonly(false);
		nombreMensajeSalida.setDisabled(false);
		descripcionMensajeSalida.setValue(null);
//		statusObjeto.setValue(CommandConstants.NB_MENSAJE_ACTIVO);
		statusObjeto.setValue(null);
//        idStrEstatusObjeto = String.valueOf(CommandConstants.ID_MENSAJE_ACTIVO);
        fechaAlta.setValue(null);
		fechaModificacion.setValue(null);
		idMensajeSalida.setValue(null);
		descripcionAsuntoSalida.setValue(null);
		fechaAlta.setButtonVisible(true);
		fechaModificacion.setButtonVisible(true);
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
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		for(MensajeSalidaVO mensajeSalidaVO: mensajeSalidaVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(mensajeSalidaVO.getNombreMensajeSalida());
			beanGenerico.setValor2(mensajeSalidaVO.getDescripcionAsuntoSalida());
			beanGenerico.setValor3(mensajeSalidaVO.getDescripcionMensajeSalida());
			if (mensajeSalidaVO.getFechaAlta() != null)
				beanGenerico.setValor4(dateFormat.format(mensajeSalidaVO.getFechaAlta()));				
			if (mensajeSalidaVO.getFechaModificacion() != null)
				beanGenerico.setValor5(dateFormat.format(mensajeSalidaVO.getFechaModificacion()));
			beanGenerico.setValor6(mensajeSalidaVO.getNombreEstatusObjeto());
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}

	/**
	 * Gets the id estatus objeto.
	 *
	 * @return the idEstatusObjeto
	 */
	public Textbox getIdEstatusObjeto() {
		return idEstatusObjeto;
	}

	/**
	 * Gets the id str estatus objeto.
	 *
	 * @return the idStrEstatusObjeto
	 */
	public String getIdStrEstatusObjeto() {
		return idStrEstatusObjeto;
	}
	
	/**
	 * Gets the mensaje salida dto.
	 *
	 * @return the mensajeSalidaDTO
	 */
	public MensajeSalidaDTO getMensajeSalidaDTO() {
		return mensajeSalidaDTO;
	}
	
	/**
	 * Gets the mensaje salida vo.
	 *
	 * @return the mensajeSalidaVO
	 */
	public MensajeSalidaVO getMensajeSalidaVO() {
		return mensajeSalidaVO;
	}

	/**
	 * Gets the mensaje salida v os.
	 *
	 * @return the mensajeSalidaVOs
	 */
	public List<MensajeSalidaVO> getMensajeSalidaVOs() {
		return mensajeSalidaVOs;
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
	 * Checks if is flag mensaje.
	 *
	 * @return the flagMensaje
	 */
	public boolean isFlagMensaje() {
		return flagMensaje;
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
		headersReport.add("Identificador del Mensaje");
		headersReport.add("Asunto de mensaje");
		headersReport.add("Texto de mensaje");
		headersReport.add("Fecha alta");
		headersReport.add("Fecha modificación");
		headersReport.add("Status");
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Mensajes de Notificación Sistema");
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Mensajes de Notificación Sistema");
		}
		controller.createReport(generaLista(), headersReport, type, "MENSAJES-SISTEMA");
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read()
	 */
	@Override
	public Object read() {
		mensajeSalidaDTO = new MensajeSalidaDTO();
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
		estatusObjetoVO.setNombreTabla(CommandConstants.NOMBRE_TABLA_MENSAJE);		
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
		if(estatusObjetoDTO.getErrorCode().equals("SQL-001")){
	    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
	    					"\nError:"+estatusObjetoDTO.getErrorCode()+
	    					"\nDescripción:"+estatusObjetoDTO.getErrorDescription(),"Error de Sistema",Messagebox.OK,Messagebox.ERROR);
	    }
	    mensajeSalidaDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
	    
	    MensajeSalidaVO mensajeSalidaVO = new MensajeSalidaVO();
	    mensajeSalidaVO.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_SISTEMA);
	    mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
		MensajeSalidaBO mensajeSalidaBO = new MensajeSalidaBO();
		mensajeSalidaDTO = mensajeSalidaBO.readCommand(mensajeSalidaDTO);
		if(mensajeSalidaDTO.getErrorCode().equals("SQL-001")){
	    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
	    					"\nError:"+mensajeSalidaDTO.getErrorCode()+
	    					"","Error de Sistema",Messagebox.OK,Messagebox.ERROR);
	    }
		return mensajeSalidaDTO;
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
	 * @param mensajeSalidaVO the mensaje salida vo
	 */
	@Command
	@NotifyChange({"flagMensaje"})
	public void readSelected(@BindingParam("idMensajeSalida") final MensajeSalidaVO mensajeSalidaVO){
		this.mensajeSalidaVO = mensajeSalidaVO;
		mensajeSalidaVO.toString();
		nombreMensajeSalida.setValue(mensajeSalidaVO.getNombreMensajeSalida());
		descripcionMensajeSalida.setValue(mensajeSalidaVO.getDescripcionMensajeSalida());
		statusObjeto.setValue(mensajeSalidaVO.getNombreEstatusObjeto());
		idMensajeSalida.setValue(Integer.toString(mensajeSalidaVO.getIdMensajeSalida()));
		idEstatusObjeto.setValue(Integer.toString(mensajeSalidaVO.getIdEstatusObjeto()));
		fechaAlta.setValue(mensajeSalidaVO.getFechaAlta());
		fechaModificacion.setValue(mensajeSalidaVO.getFechaModificacion());
		descripcionAsuntoSalida.setValue(mensajeSalidaVO.getDescripcionAsuntoSalida());
		flagMensaje = true;
		fechaAlta.setButtonVisible(true);
		fechaModificacion.setButtonVisible(true);
	}
	
	/**
	 * Read with filters.
	 */
	@GlobalCommand
	@Command
	@NotifyChange({ "mensajeSalidaVOs" })
	public void readWithFilters() {
		ReportesController controller = new ReportesController();
		MensajeSalidaDTO mensajeSalidaDTO = new MensajeSalidaDTO();
		MensajeSalidaVO mensajeSalidaVO = new MensajeSalidaVO();
		mensajeSalidaVO.setNombreMensajeSalida(StringUtil.validaLike(nombreMensajeSalida.getValue()));
		mensajeSalidaVO.setDescripcionMensajeSalida(StringUtil.validaLike(descripcionMensajeSalida.getValue()));
		mensajeSalidaVO.setIdEstatusObjeto(Integer.parseInt(statusObjeto.getSelectedItem()==null?"0":statusObjeto.getSelectedItem().getValue().toString()));
		mensajeSalidaVO.setDescripcionAsuntoSalida(descripcionAsuntoSalida.getValue().isEmpty()?"%":"%"+descripcionAsuntoSalida.getValue().toUpperCase()+"%");
		mensajeSalidaVO.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_SISTEMA);
		mensajeSalidaVO.setFechaAlta(fechaAlta.getValue());
		mensajeSalidaVO.setFechaModificacion(fechaModificacion.getValue());
		mensajeSalidaVO.toString();
		mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
		MensajeSalidaBO mensajeSalidaBO = new MensajeSalidaBO();
		mensajeSalidaDTO = mensajeSalidaBO.readCommand(mensajeSalidaDTO);
		if(mensajeSalidaDTO.getErrorCode().equals("SQL-001")){
	    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
	    					"\nError:"+mensajeSalidaDTO.getErrorCode()+
	    					"","Error de Sistema",Messagebox.OK,Messagebox.ERROR);
	    }
		mensajeSalidaVOs = mensajeSalidaDTO.getMensajeSalidaVOs();
		controller.registrarEvento(null, null, CommandConstants.CONSULTAR, "Catálogo de Mensajes de Notificación");
		//registraBitacora(mensajeSalidaVO, 2);
	}
	
	/**
	 * Registra bitacora.
	 *
	 * @param mensajeSalidaVO the mensaje salida vo
	 * @param evento the evento
	 */
	private void registraBitacora(MensajeSalidaVO mensajeSalidaVO, int evento) {
		List<CampoDTO> campoDTOs = new ArrayList<CampoDTO>(); 
		BitacoraDTO dto = new BitacoraDTO();
		Field[] atributos = mensajeSalidaVO.getClass().getFields(); 
		for (int i = 0; i < atributos.length; i++) {
			CampoDTO campo = new CampoDTO();
			campo.setNombre_campo(atributos[i].getName()); 
			campoDTOs.add(campo);
		}		
		dto.setCampoDTOs(campoDTOs);
		registraEvento(dto, "Catálogo de Mensajes de Notificación", evento);
	}	

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#save()
	 */
	@Override
	@Command
	@NotifyChange({ "mensajeSalidaVOs","flagMensaje"})
	public void save() {
		final ReportesController controller = new ReportesController();
		final MensajeSalidaBO mensajeSalidaBO = new MensajeSalidaBO();
		boolean errorGuardar = false;
		if (nombreMensajeSalida.getValue().isEmpty()) {
			nombreMensajeSalida
					.setErrorMessage("Favor de introducir el nombre del Mensaje de Salida");
			errorGuardar = true;
		}
		if (descripcionAsuntoSalida.getValue().isEmpty()) {
			descripcionAsuntoSalida
					.setErrorMessage("Favor de introducir la descripción del Asunto de Mensaje de Salida");
			errorGuardar = true;
		}
		if (descripcionMensajeSalida.getValue().isEmpty()) {
			descripcionMensajeSalida
					.setErrorMessage("Favor de introducir la descripción del Mensaje de Salida");
			errorGuardar = true;
		}
		if(!errorGuardar){
			Messagebox.show(
					"¿Está seguro que desea continuar con la operación?",
					"Pregunta", org.zkoss.zul.Messagebox.YES | org.zkoss.zul.Messagebox.NO,
			org.zkoss.zul.Messagebox.QUESTION, new EventListener<Event>() {
				@Override
				public void onEvent(Event event) throws Exception {
					if (event.getName().equals(org.zkoss.zul.Messagebox.ON_YES)) {
						System.out.println("/////////////////////////// "+idMensajeSalida.getValue());
						if(idMensajeSalida.getValue().isEmpty() || idMensajeSalida.getValue().equals("0")) {
							mensajeSalidaVO = new MensajeSalidaVO();
							mensajeSalidaVO.setNombreMensajeSalida(nombreMensajeSalida.getValue().toUpperCase());
							if(mensajeSalidaBO.readCommandValidaMensaje(mensajeSalidaVO)) {
								mensajeSalidaVO.setNombreMensajeSalida("");
								MensajeSalidaDTO mensajeSalidaDTO = new MensajeSalidaDTO();
								MensajeSalidaVO mensajeSalidaVOL = new MensajeSalidaVO();
								mensajeSalidaVOL.setNombreMensajeSalida(nombreMensajeSalida.getValue().toUpperCase().trim());
								mensajeSalidaVOL.setDescripcionMensajeSalida(descripcionMensajeSalida.getValue().toUpperCase().trim());
								mensajeSalidaVOL.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
								mensajeSalidaVOL.setDescripcionAsuntoSalida(descripcionAsuntoSalida.getValue().toUpperCase().trim());
								mensajeSalidaVOL.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_SISTEMA);
								//mensajeSalidaVO.setIdMensajeSalida(Integer.parseInt(idMensajeSalida.getValue()));
								mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVOL);
								mensajeSalidaDTO = mensajeSalidaBO.createCommand(mensajeSalidaDTO);
								mensajeSalidaDTO.toString(BbvaAbstractDataTransferObject.XML);
								MensajeSalidaVO mensajeSalidaVONuevo = new MensajeSalidaVO();
								mensajeSalidaVONuevo.setNombreMensajeSalida("");
								mensajeSalidaVONuevo.setDescripcionMensajeSalida("");								
								mensajeSalidaVONuevo.setDescripcionAsuntoSalida("");
								if(mensajeSalidaDTO.getErrorCode().equals("SQL-001")){
							    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
							    					"\nError:"+mensajeSalidaDTO.getErrorCode()+
							    					"","Error de Sistema",Messagebox.OK,Messagebox.ERROR);
							    	controller.registrarEvento(mensajeSalidaVOL, mensajeSalidaVONuevo, CommandConstants.ERROR_SISTEMA, "Mensajes Sistema");
								}else{									
									controller.registrarEvento(mensajeSalidaVOL, mensajeSalidaVONuevo, CommandConstants.ALTA, "Mensajes Sistema");
									clean();
									mensajeSalidaVOL = new MensajeSalidaVO();
									mensajeSalidaVOL.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_SISTEMA);
									mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVOL);
									mensajeSalidaDTO = mensajeSalidaBO.readCommand(mensajeSalidaDTO);
									if(mensajeSalidaDTO.getErrorCode().equals("SQL-001")){
								    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
								    					"\nError:"+mensajeSalidaDTO.getErrorCode()+
								    					"","Error de Sistema",Messagebox.OK,Messagebox.ERROR);
								    }
									mensajeSalidaVOs = mensajeSalidaDTO.getMensajeSalidaVOs();								
									org.zkoss.zul.Messagebox.show("!El Registro del Mensaje fue exitoso!",
											"Información", org.zkoss.zul.Messagebox.OK,
											org.zkoss.zul.Messagebox.INFORMATION);
								}
							} else {
								clean();
								mensajeSalidaVO.setNombreMensajeSalida(StringUtil.validaLike(nombreMensajeSalida.getValue()));
								mensajeSalidaVO.setDescripcionMensajeSalida(StringUtil.validaLike(descripcionMensajeSalida.getValue()));
								mensajeSalidaVO.setIdEstatusObjeto(0);
								mensajeSalidaVO.toString();
								mensajeSalidaVO.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_SISTEMA);
								mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
								mensajeSalidaDTO = mensajeSalidaBO.readCommand(mensajeSalidaDTO);
								if(mensajeSalidaDTO.getErrorCode().equals("SQL-001")){
							    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
							    					"\nError:"+mensajeSalidaDTO.getErrorCode()+
							    					"","Error de Sistema",Messagebox.OK,Messagebox.ERROR);
							    }
								mensajeSalidaVOs = mensajeSalidaDTO.getMensajeSalidaVOs();								
								org.zkoss.zul.Messagebox.show("!No se puede registrar más de un Mensaje con el mismo Nombre!",
										"Información", org.zkoss.zul.Messagebox.OK,
										org.zkoss.zul.Messagebox.EXCLAMATION);
							}
						} else {
							ContratacionMapeadorBO mapeadorBO = new ContratacionMapeadorBO();
							ContratacionMapVO contratacionMapVO = new ContratacionMapVO();
							contratacionMapVO.setIdMensajeSalida(Integer.parseInt(idMensajeSalida.getValue()));
							if(Integer.parseInt(idEstatusObjeto.getValue()) == CommandConstants.ESTATUS_OBJETO_MENSAJE_SALIDA_ACTIVO || 
									mapeadorBO.readCommandValidaMensajeContratMap(contratacionMapVO)) {
								MensajeSalidaDTO mensajeSalidaDTO = new MensajeSalidaDTO();
								MensajeSalidaVO mensajeSalidaVOL = new MensajeSalidaVO();
								mensajeSalidaVOL.setNombreMensajeSalida(nombreMensajeSalida.getValue().toUpperCase().trim());
								mensajeSalidaVOL.setDescripcionMensajeSalida(descripcionMensajeSalida.getValue().toUpperCase().trim());
								mensajeSalidaVOL.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
								mensajeSalidaVOL.setIdMensajeSalida(Integer.parseInt(idMensajeSalida.getValue()));
								mensajeSalidaVOL.setDescripcionAsuntoSalida(descripcionAsuntoSalida.getValue().toUpperCase().trim());
								mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVOL);
								mensajeSalidaDTO = mensajeSalidaBO.updateCommand(mensajeSalidaDTO);								
								if(mensajeSalidaDTO.getErrorCode().equals("SQL-001")){
							    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
							    					"\nError:"+mensajeSalidaDTO.getErrorCode()+
							    					"","Error de Sistema",Messagebox.OK,Messagebox.ERROR);
								}else{
									mensajeSalidaVOs = mensajeSalidaDTO.getMensajeSalidaVOs();
									mensajeSalidaDTO.toString(BbvaAbstractDataTransferObject.XML);
									String nombrePantalla = "Mensajes Sistema";
									mensajeSalidaVOs = mensajeSalidaDTO.getMensajeSalidaVOs();
									mensajeSalidaDTO.toString(BbvaAbstractDataTransferObject.XML);
									if (Integer.parseInt(statusObjeto.getSelectedItem().getValue().toString())==CommandConstants.ID_MENSAJE_BAJA) {
										controller.registrarEvento(mensajeSalidaVOL, mensajeSalidaVO, CommandConstants.BAJA, nombrePantalla);					
									} else if (Integer.parseInt(statusObjeto.getSelectedItem().getValue().toString())==CommandConstants.ID_CANAL_INACTIVO) { 
										controller.registrarEvento(mensajeSalidaVOL, mensajeSalidaVO, CommandConstants.INACTIVACION, nombrePantalla);				
									} else {
										controller.registrarEvento(mensajeSalidaVOL, mensajeSalidaVO, CommandConstants.MODIFICACION, nombrePantalla);
									}								
									clean();
									mensajeSalidaVO.setNombreMensajeSalida(StringUtil.validaLike(nombreMensajeSalida.getValue()));
									mensajeSalidaVO.setDescripcionMensajeSalida(StringUtil.validaLike(descripcionMensajeSalida.getValue()));
									mensajeSalidaVO.setIdEstatusObjeto(0);
									mensajeSalidaVO.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_SISTEMA);
									mensajeSalidaVO.toString();
									mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
									mensajeSalidaDTO = mensajeSalidaBO.readCommand(mensajeSalidaDTO);
									if(mensajeSalidaDTO.getErrorCode().equals("SQL-001")){
								    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
								    					"\nError:"+mensajeSalidaDTO.getErrorCode()+
								    					"","Error de Sistema",Messagebox.OK,Messagebox.ERROR);
								    }
									mensajeSalidaVOs = mensajeSalidaDTO.getMensajeSalidaVOs();								
									org.zkoss.zul.Messagebox.show("!La Actualización del Mensaje fue exitoso!",
											"Información", org.zkoss.zul.Messagebox.OK,
											org.zkoss.zul.Messagebox.INFORMATION);
								}
							} else {
								mensajeSalidaVO = new MensajeSalidaVO();
								clean();
								mensajeSalidaVO.toString();
								mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
								mensajeSalidaDTO = mensajeSalidaBO.readCommand(mensajeSalidaDTO);
								if(mensajeSalidaDTO.getErrorCode().equals("SQL-001")){
							    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
							    					"\nError:"+mensajeSalidaDTO.getErrorCode()+
							    					"","Error de Sistema",Messagebox.OK,Messagebox.ERROR);
							    }
								mensajeSalidaVOs = mensajeSalidaDTO.getMensajeSalidaVOs();								
								org.zkoss.zul.Messagebox.show("!No se puede dar de Baja o Inactivar, ya que esta siendo Usado por la Contratación Mapeador!",
										"Información", org.zkoss.zul.Messagebox.OK,
										org.zkoss.zul.Messagebox.EXCLAMATION);
							}
						}
						BindUtils
						.postGlobalCommand(
								null,
								null,
								"readWithFilters",
								null);
					}
				}
			});
		}
		flagMensaje = false;
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
	 * Sets the flag mensaje.
	 *
	 * @param flagMensaje the flagMensaje to set
	 */
	public void setFlagMensaje(boolean flagMensaje) {
		this.flagMensaje = flagMensaje;
	}

	/**
	 * Sets the id estatus objeto.
	 *
	 * @param idEstatusObjeto the idEstatusObjeto to set
	 */
	public void setIdEstatusObjeto(Textbox idEstatusObjeto) {
		this.idEstatusObjeto = idEstatusObjeto;
	}

	/**
	 * Sets the id str estatus objeto.
	 *
	 * @param idStrEstatusObjeto the idStrEstatusObjeto to set
	 */
	public void setIdStrEstatusObjeto(String idStrEstatusObjeto) {
		this.idStrEstatusObjeto = idStrEstatusObjeto;
	}

	/**
	 * Sets the mensaje salida dto.
	 *
	 * @param mensajeSalidaDTO the mensajeSalidaDTO to set
	 */
	public void setMensajeSalidaDTO(MensajeSalidaDTO mensajeSalidaDTO) {
		this.mensajeSalidaDTO = mensajeSalidaDTO;
	}

	/**
	 * Sets the mensaje salida vo.
	 *
	 * @param mensajeSalidaVO the mensajeSalidaVO to set
	 */
	public void setMensajeSalidaVO(MensajeSalidaVO mensajeSalidaVO) {
		this.mensajeSalidaVO = mensajeSalidaVO;
	}

	/**
	 * Sets the mensaje salida v os.
	 *
	 * @param mensajeSalidaVOs the mensajeSalidaVOs to set
	 */
	public void setMensajeSalidaVOs(List<MensajeSalidaVO> mensajeSalidaVOs) {
		this.mensajeSalidaVOs = mensajeSalidaVOs;
	}

}
