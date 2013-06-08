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

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

public class MensajesSistemaController extends ControllerSupport implements IController {

	private static final long serialVersionUID = 4649691032075701267L;
	@Wire
	private Label lblAsuntoMensaje;
	@Wire
	private Textbox descripcionAsuntoSalida;
	@Wire
	private Textbox idMensajeSalida;
	@Wire
	private Textbox nombreMensajeSalida;
	@Wire
	private Textbox descripcionMensajeSalida;
	@Wire
	private Textbox idEstatusObjeto;
	@Wire
	private Combobox statusObjeto;
	
	@Wire
	private Label lblIdentificadorMensaje;
	@Wire
	private Label lblEstatus;
	@Wire
	private Label lblTextoMensaje;
	@Wire
	private Label lblFechaAlta;
	@Wire
	private Label lblFechaModificacion;
	@Wire
	private Datebox fechaAlta;
	@Wire
	private Datebox fechaModificacion;
	@Wire
	private Image reporteExcelBtn;
	@Wire
	private Image reporteCsvBtn;
	@Wire
	private Button limpiarBtn;
	@Wire
	private Button guardarBtn;
	@Wire
	private Button consultarBtn;
	@Wire
	private Grid mensajesGrid;
	
	private boolean flagMensaje;
	private boolean executePermissionSet;
	private MensajeSalidaDTO mensajeSalidaDTO;
	private List<MensajeSalidaVO> mensajeSalidaVOs;
	private MensajeSalidaVO mensajeSalidaVO;
	private String idStrEstatusObjeto;
	
	public MensajesSistemaController() {
		this.read();
		this.mensajeSalidaVOs = mensajeSalidaDTO.getMensajeSalidaVOs();
		flagMensaje = false;
	}
	
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
	    mensajeSalidaDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
	    
	    MensajeSalidaVO mensajeSalidaVO = new MensajeSalidaVO();
	    mensajeSalidaVO.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_SISTEMA);
	    mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
		MensajeSalidaBO MensajeSalidaBO = new MensajeSalidaBO();
		MensajeSalidaBO.readCommand(mensajeSalidaDTO);
		return mensajeSalidaDTO;
	}
	
	@Command
	@NotifyChange({ "mensajeSalidaVOs" })
	public void readWithFilters() {
		ReportesController controller = new ReportesController();
		MensajeSalidaDTO mensajeSalidaDTO = new MensajeSalidaDTO();
		MensajeSalidaVO mensajeSalidaVO = new MensajeSalidaVO();
		mensajeSalidaVO.setNombreMensajeSalida(StringUtil.validaLike(nombreMensajeSalida.getValue()));
		mensajeSalidaVO.setDescripcionMensajeSalida(StringUtil.validaLike(descripcionMensajeSalida.getValue()));
		mensajeSalidaVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
		mensajeSalidaVO.setDescripcionAsuntoSalida(descripcionAsuntoSalida.getValue().isEmpty()?"%":"%"+descripcionAsuntoSalida.getValue().toUpperCase()+"%");
		mensajeSalidaVO.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_SISTEMA);
		mensajeSalidaVO.toString();
		mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
		MensajeSalidaBO mensajeSalidaBO = new MensajeSalidaBO();
		mensajeSalidaVOs = mensajeSalidaBO.readCommand(mensajeSalidaDTO).getMensajeSalidaVOs();
		controller.registrarEvento(null, null, CommandConstants.CONSULTAR, "Catálogo de Mensajes de Notificación");
		registraBitacora(mensajeSalidaVO, 2);
	}
	
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

	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Command
	@NotifyChange({ "mensajeSalidaVOs","flagMensaje"})
	public void save() {
		ReportesController controller = new ReportesController();
		MensajeSalidaBO mensajeSalidaBO = new MensajeSalidaBO();
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
			System.out.println("/////////////////////////// "+idMensajeSalida.getValue());
			if(idMensajeSalida.getValue().isEmpty() || idMensajeSalida.getValue().equals("0")) {
				mensajeSalidaVO = new MensajeSalidaVO();
				mensajeSalidaVO.setNombreMensajeSalida(nombreMensajeSalida.getValue().toUpperCase());
				if(mensajeSalidaBO.readCommandValidaMensaje(mensajeSalidaVO)) {
					MensajeSalidaDTO mensajeSalidaDTO = new MensajeSalidaDTO();
					MensajeSalidaVO mensajeSalidaVO = new MensajeSalidaVO();
					mensajeSalidaVO.setNombreMensajeSalida(nombreMensajeSalida.getValue().toUpperCase());
					mensajeSalidaVO.setDescripcionMensajeSalida(descripcionMensajeSalida.getValue().toUpperCase());
					mensajeSalidaVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
					mensajeSalidaVO.setDescripcionAsuntoSalida(descripcionAsuntoSalida.getValue().toUpperCase());
					mensajeSalidaVO.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_SISTEMA);
					//mensajeSalidaVO.setIdMensajeSalida(Integer.parseInt(idMensajeSalida.getValue()));
					mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
					mensajeSalidaBO.createCommand(mensajeSalidaDTO);
					mensajeSalidaDTO.toString(BbvaAbstractDataTransferObject.XML);
					controller.registrarEvento(mensajeSalidaVO, this.mensajeSalidaVO, CommandConstants.ALTA, "Catálogo de Mensajes de Notificación");
					clean();
					mensajeSalidaVO = new MensajeSalidaVO();
					mensajeSalidaVO.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_SISTEMA);
					mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
					mensajeSalidaVOs = mensajeSalidaBO.readCommand(mensajeSalidaDTO).getMensajeSalidaVOs();
					Messagebox.show("!El Registro del Mensaje fue exitoso!",
							"Información", Messagebox.OK,
							Messagebox.INFORMATION);
				} else {
					clean();
					mensajeSalidaVO.setNombreMensajeSalida(StringUtil.validaLike(nombreMensajeSalida.getValue()));
					mensajeSalidaVO.setDescripcionMensajeSalida(StringUtil.validaLike(descripcionMensajeSalida.getValue()));
					mensajeSalidaVO.setIdEstatusObjeto(0);
					mensajeSalidaVO.toString();
					mensajeSalidaVO.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_SISTEMA);
					mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
					mensajeSalidaVOs = mensajeSalidaBO.readCommand(mensajeSalidaDTO).getMensajeSalidaVOs();
					Messagebox.show("!No se puede registrar más de un Mensaje con el mismo Nombre!",
							"Información", Messagebox.OK,
							Messagebox.EXCLAMATION);
				}
			} else {
				ContratacionMapeadorBO mapeadorBO = new ContratacionMapeadorBO();
				ContratacionMapVO contratacionMapVO = new ContratacionMapVO();
				contratacionMapVO.setIdMensajeSalida(Integer.parseInt(idMensajeSalida.getValue()));
				if(Integer.parseInt(idEstatusObjeto.getValue()) == CommandConstants.ESTATUS_OBJETO_MENSAJE_SALIDA_ACTIVO || 
						mapeadorBO.readCommandValidaMensajeContratMap(contratacionMapVO)) {
					MensajeSalidaDTO mensajeSalidaDTO = new MensajeSalidaDTO();
					MensajeSalidaVO mensajeSalidaVO = new MensajeSalidaVO();
					mensajeSalidaVO.setNombreMensajeSalida(nombreMensajeSalida.getValue().toUpperCase());
					mensajeSalidaVO.setDescripcionMensajeSalida(descripcionMensajeSalida.getValue().toUpperCase());
					mensajeSalidaVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
					mensajeSalidaVO.setIdMensajeSalida(Integer.parseInt(idMensajeSalida.getValue()));
					mensajeSalidaVO.setDescripcionAsuntoSalida(descripcionAsuntoSalida.getValue().toUpperCase());
					mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
					mensajeSalidaBO.updateCommand(mensajeSalidaDTO);
					mensajeSalidaDTO.toString(BbvaAbstractDataTransferObject.XML);
					controller.registrarEvento(mensajeSalidaVO, mensajeSalidaVO, CommandConstants.MODIFICACION, "Catálogo de Mensajes de Notificación");
					clean();
					mensajeSalidaVO.setNombreMensajeSalida(StringUtil.validaLike(nombreMensajeSalida.getValue()));
					mensajeSalidaVO.setDescripcionMensajeSalida(StringUtil.validaLike(descripcionMensajeSalida.getValue()));
					mensajeSalidaVO.setIdEstatusObjeto(0);
					mensajeSalidaVO.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_SISTEMA);
					mensajeSalidaVO.toString();
					mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
					mensajeSalidaVOs = mensajeSalidaBO.readCommand(mensajeSalidaDTO).getMensajeSalidaVOs();
					Messagebox.show("!La Actualización del Mensaje fue exitoso!",
							"Información", Messagebox.OK,
							Messagebox.INFORMATION);
				} else {
					mensajeSalidaVO = new MensajeSalidaVO();
					clean();
					mensajeSalidaVO.toString();
					mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
					mensajeSalidaVOs = mensajeSalidaBO.readCommand(mensajeSalidaDTO).getMensajeSalidaVOs();
					Messagebox.show("!No se puede dar de Baja o Inactivar, ya que esta siendo Usado por la Contratación Mapeador!",
							"Información", Messagebox.OK,
							Messagebox.EXCLAMATION);
				}
			}
		}
		flagMensaje = false;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

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
		statusObjeto.setValue(CommandConstants.NB_MENSAJE_ACTIVO);
        idStrEstatusObjeto = String.valueOf(CommandConstants.ID_MENSAJE_ACTIVO);
        fechaAlta.setValue(new Date());
		fechaModificacion.setValue(new Date());
		idMensajeSalida.setValue(null);
		descripcionAsuntoSalida.setValue(null);
	}
	
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
	}
	
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);   
        executePermissionSet = this.applyPermision();
        statusObjeto.setValue(CommandConstants.NB_MENSAJE_ACTIVO);
        idStrEstatusObjeto = String.valueOf(CommandConstants.ID_MENSAJE_ACTIVO);
        
    }

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
	 * @return the mensajeSalidaDTO
	 */
	public MensajeSalidaDTO getMensajeSalidaDTO() {
		return mensajeSalidaDTO;
	}

	/**
	 * @param mensajeSalidaDTO the mensajeSalidaDTO to set
	 */
	public void setMensajeSalidaDTO(MensajeSalidaDTO mensajeSalidaDTO) {
		this.mensajeSalidaDTO = mensajeSalidaDTO;
	}

	/**
	 * @return the mensajeSalidaVOs
	 */
	public List<MensajeSalidaVO> getMensajeSalidaVOs() {
		return mensajeSalidaVOs;
	}

	/**
	 * @param mensajeSalidaVOs the mensajeSalidaVOs to set
	 */
	public void setMensajeSalidaVOs(List<MensajeSalidaVO> mensajeSalidaVOs) {
		this.mensajeSalidaVOs = mensajeSalidaVOs;
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

	/**
	 * @return the flagMensaje
	 */
	public boolean isFlagMensaje() {
		return flagMensaje;
	}

	/**
	 * @param flagMensaje the flagMensaje to set
	 */
	public void setFlagMensaje(boolean flagMensaje) {
		this.flagMensaje = flagMensaje;
	}

	/**
	 * @return the mensajeSalidaVO
	 */
	public MensajeSalidaVO getMensajeSalidaVO() {
		return mensajeSalidaVO;
	}

	/**
	 * @param mensajeSalidaVO the mensajeSalidaVO to set
	 */
	public void setMensajeSalidaVO(MensajeSalidaVO mensajeSalidaVO) {
		this.mensajeSalidaVO = mensajeSalidaVO;
	}

	/**
	 * @return the idEstatusObjeto
	 */
	public Textbox getIdEstatusObjeto() {
		return idEstatusObjeto;
	}

	/**
	 * @param idEstatusObjeto the idEstatusObjeto to set
	 */
	public void setIdEstatusObjeto(Textbox idEstatusObjeto) {
		this.idEstatusObjeto = idEstatusObjeto;
	}

	/**
	 * @return the idStrEstatusObjeto
	 */
	public String getIdStrEstatusObjeto() {
		return idStrEstatusObjeto;
	}

	/**
	 * @param idStrEstatusObjeto the idStrEstatusObjeto to set
	 */
	public void setIdStrEstatusObjeto(String idStrEstatusObjeto) {
		this.idStrEstatusObjeto = idStrEstatusObjeto;
	}

}
