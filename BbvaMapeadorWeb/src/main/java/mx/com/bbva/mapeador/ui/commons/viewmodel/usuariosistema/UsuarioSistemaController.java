package mx.com.bbva.mapeador.ui.commons.viewmodel.usuariosistema;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mx.com.bbva.bancomer.bussinnes.model.vo.ClienteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioNotificacionVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.UsuarioNotificacionBO;
import mx.com.bbva.bancomer.usuarionotificacion.dto.UsuarioNotificacionDTO;
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
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

public class UsuarioSistemaController  extends ControllerSupport implements IController{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7183766729268869941L;
	private static final Logger logger = Logger.getLogger(UsuarioSistemaController.class);
	private UsuarioNotificacionVO usuarioNotificacionVO;
	/**
	 * @return the usuarioNotificacionVO
	 */
	public final UsuarioNotificacionVO getUsuarioNotificacionVO() {
		return usuarioNotificacionVO;
	}

	/**
	 * @param usuarioNotificacionVO the usuarioNotificacionVO to set
	 */
	public final void setUsuarioNotificacionVO(
			UsuarioNotificacionVO usuarioNotificacionVO) {
		this.usuarioNotificacionVO = usuarioNotificacionVO;
	}

	@Wire
	private Image reporteExcelBtn;
	@Wire
	private Image reporteCsvBtn;
	@Wire
	private Textbox nombreUsuario;

	@Wire
	private Grid usuariosNegocioGrid;
	
	@Wire
	private Textbox email;
	
	@Wire
	private Combobox status;
	
	@Wire
	private Textbox idEstatusObjeto;
	
	@Wire
	private Textbox idUsuarioNotificado;
	
	@Wire
	private Label lblNombreUsuario;
	@Wire
	private Label lblEmail;
	@Wire
	private Label lblEstatus;

	@Wire
	private Button limpiarBtn;
	@Wire
	private Button guardarBtn;
	@Wire
	private Button consultarBtn;
	
	private UsuarioNotificacionDTO	usuarioNotificacionDTO = (UsuarioNotificacionDTO)this.read();	
	
	private List<UsuarioNotificacionVO> usuarioNotificacionVOs = usuarioNotificacionDTO.getUsuarioNotificacionVOs();
	
	private String strIdUsuarioNotificado; 
	
	private String strIdEstatusObjeto; 
	
	private String strNombreUsuario;

	private String strEmail;
	
	private String strStatus;
	
	private boolean executePermissionSet;

	@Override
	public Object read() {
		UsuarioNotificacionDTO usuarioNotificacionDTO = new UsuarioNotificacionDTO();
		UsuarioNotificacionVO usuarioNotificacionVO = new UsuarioNotificacionVO();
		usuarioNotificacionDTO.setUsuarioNotificacionVO(usuarioNotificacionVO);
		UsuarioNotificacionBO usuarioNotificacionBO = new UsuarioNotificacionBO();
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO); 
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
		estatusObjetoVO.setNombreTabla(CommandConstants.NOMBRE_TABLA_USUARIOS_NEGOCIO);				
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
		usuarioNotificacionVO.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_SISTEMA);
		usuarioNotificacionDTO.setUsuarioNotificacionVO(usuarioNotificacionVO);
		usuarioNotificacionDTO = usuarioNotificacionBO.readCommand(usuarioNotificacionDTO);
		logger.info("::::::::::::::SIZE::::::::::" + usuarioNotificacionDTO.getUsuarioNotificacionVOs());
		usuarioNotificacionDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
		return usuarioNotificacionDTO;
	}

	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
        executePermissionSet = this.applyPermision();
    }
	
	@Command
	public void readSelected(@BindingParam("idUsuarioNotificado") final UsuarioNotificacionVO usuarioNotificacionVO){
		this.usuarioNotificacionVO = usuarioNotificacionVO;
		//Seteo de datos de Acuerdo al id de los compoenetes del HTML VS VO
		usuarioNotificacionVO.toString();
		status.setValue(usuarioNotificacionVO.getNombreEstatusObjeto());
		nombreUsuario.setValue(usuarioNotificacionVO.getNombreUsuarioNotificado());
		email.setValue(usuarioNotificacionVO.getDescripcionEmail());
		idUsuarioNotificado.setValue(String.valueOf(usuarioNotificacionVO.getIdUsuarioNotificado()));
	}
	
	//Cambiar al objeto que pertenezca el componente en este caso usuarioNotificacionVOs
	@Command
	@NotifyChange({ "usuarioNotificacionVOs" })
	public void readWithFilters() {
		UsuarioNotificacionDTO usuarioNotificacionDTO = new UsuarioNotificacionDTO();
		UsuarioNotificacionVO usuarioNotificacionVO = new UsuarioNotificacionVO(); 
		//Textbox
		usuarioNotificacionVO.setNombreUsuarioNotificado(nombreUsuario.getValue().isEmpty()?"%":"%"+nombreUsuario.getValue().toUpperCase()+"%");
		usuarioNotificacionVO.setDescripcionEmail(email.getValue().isEmpty()?"%":"%"+email.getValue().toUpperCase()+"%");
		
		//Combos Validar el nombre de los parametros en HTML VS Controller
		usuarioNotificacionVO.setIdEstatusObjeto((Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue())));
		usuarioNotificacionVO.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_SISTEMA);
		usuarioNotificacionDTO.setUsuarioNotificacionVO(usuarioNotificacionVO);
		usuarioNotificacionDTO.toString(BbvaAbstractDataTransferObject.XML);	
		
		//LLamada a BO  UsuarioNotificacion para consulta por criterio
		UsuarioNotificacionBO usuarioNotificacionBO = new UsuarioNotificacionBO();
		
		//Asignacion resultado de consulta al mismo DTO de UsuarioNotificacion
		usuarioNotificacionDTO = usuarioNotificacionBO.readCommand(usuarioNotificacionDTO);
		
		ReportesController controller = new ReportesController();
		controller.registrarEvento(usuarioNotificacionVO, this.usuarioNotificacionVO, CommandConstants.CONSULTAR, "Usuario Sistema");
		//Tamaño de la lista de acuerdo al criterio de busqueda y objeto UsuarioNotificacion
		if(usuarioNotificacionDTO.getUsuarioNotificacionVOs() != null) {
			logger.debug("Tamaño de la lista de acuerdo al criterio de busqueda y objeto UsuarioNotificacion size:"+usuarioNotificacionDTO.getUsuarioNotificacionVOs().size());
		} else{
			logger.debug(":::::::::::Lista Vacia::::::::::");
		}
		//Asignacion de la lista a la variable global de la clase
		usuarioNotificacionVOs = usuarioNotificacionDTO.getUsuarioNotificacionVOs();
		
	}
	
	@Override
	@Command
	@NotifyChange({ "usuarioNotificacionVOs" })
	public void save() {
		//Validar Todos Los campos de pantalla
		boolean errorGuardar = false; 
		if (status.getSelectedItem() == null
				|| status.getSelectedItem().getValue() == null
				|| status.getSelectedItem().getValue().toString().isEmpty()) {
			status.setErrorMessage("Favor de seleccionar el Status.");
			errorGuardar = true;
		}
		if (nombreUsuario.getValue().isEmpty()) {
			nombreUsuario
					.setErrorMessage("Favor de introducir nombre del Usuario");
			errorGuardar = true;
		} 
		if (email.getValue().isEmpty()) {
			email
					.setErrorMessage("Favor de introducir el E-Mail");
			errorGuardar = true;
		} 
		if(!validaMail(email.getValue())){
			email.setErrorMessage("El formato del E-Mail es incorrecto");
			errorGuardar = true;
		}
		if(!errorGuardar){
			if(!idUsuarioNotificado.getValue().isEmpty()){
				UsuarioNotificacionVO notificacionVOValida = new UsuarioNotificacionVO();
				UsuarioNotificacionBO usuarioNotificacionBOValida = new UsuarioNotificacionBO();
				UsuarioNotificacionDTO usuarioNotificacionDTOValida = new UsuarioNotificacionDTO();
				notificacionVOValida.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_SISTEMA);
				notificacionVOValida.setDescripcionEmail(email.getValue());
				notificacionVOValida.setIdUsuarioNotificado(Integer.parseInt(idUsuarioNotificado.getValue()));
				usuarioNotificacionDTOValida.setUsuarioNotificacionVO(notificacionVOValida);
				usuarioNotificacionDTOValida = usuarioNotificacionBOValida.readCommandValidateExist(usuarioNotificacionDTOValida);				
				if(usuarioNotificacionDTOValida.getUsuarioNotificacionVOs().get(0).getExiste()>0){
					Messagebox.show("!Ya existe un usuario de negocio con el mismo email!",
							"Información", Messagebox.OK,
							Messagebox.EXCLAMATION);
				}else{
					logger.info("::::::Actualizar::::");
					UsuarioNotificacionDTO usuarioNotificacionDTO = new UsuarioNotificacionDTO();
					UsuarioNotificacionVO usuarioNotificacionVO = new UsuarioNotificacionVO();
					usuarioNotificacionVO.setIdUsuarioNotificado(Integer.parseInt(idUsuarioNotificado.getValue().isEmpty()?"0":idUsuarioNotificado.getValue()));
					usuarioNotificacionVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"1":idEstatusObjeto.getValue()));
					usuarioNotificacionVO.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_SISTEMA);
					usuarioNotificacionVO.setNombreUsuarioNotificado(nombreUsuario.getValue().toUpperCase());
					usuarioNotificacionVO.setDescripcionEmail(email.getValue());
								
					//Seteo de VO a DTO 
					usuarioNotificacionDTO.setUsuarioNotificacionVO(usuarioNotificacionVO);
					usuarioNotificacionDTO.toString(BbvaAbstractDataTransferObject.XML);	
					
					UsuarioNotificacionBO UsuarioNotificacionBO = new UsuarioNotificacionBO();
					UsuarioNotificacionBO.updateCommand(usuarioNotificacionDTO);
					ReportesController controller = new ReportesController();
					controller.registrarEvento(usuarioNotificacionVO, this.usuarioNotificacionVO, CommandConstants.MODIFICACION, "Usuario Sistema");
					clean();			
					
					usuarioNotificacionVO = new UsuarioNotificacionVO();
					usuarioNotificacionVO.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_SISTEMA);
					usuarioNotificacionDTO.setUsuarioNotificacionVO(usuarioNotificacionVO);
					usuarioNotificacionDTO.toString(BbvaAbstractDataTransferObject.XML);	
					
					//LLamada a BO  UsuarioNotificacion para consulta por criterio
					UsuarioNotificacionBO usuarioNotificacionBO = new UsuarioNotificacionBO();						
					
					//Asignacion resultado de consulta al mismo DTO de UsuarioNotificacion
					usuarioNotificacionDTO = usuarioNotificacionBO.readCommand(usuarioNotificacionDTO);
					
					
					Messagebox.show("Registro actualizado con exito!!",
							"Confirmación", Messagebox.OK,
							Messagebox.INFORMATION);
					
					usuarioNotificacionVOs = usuarioNotificacionDTO.getUsuarioNotificacionVOs();
				}
			}else{ 
				UsuarioNotificacionVO notificacionVOValida = new UsuarioNotificacionVO();
				UsuarioNotificacionBO usuarioNotificacionBOValida = new UsuarioNotificacionBO();
				UsuarioNotificacionDTO usuarioNotificacionDTOValida = new UsuarioNotificacionDTO();
				notificacionVOValida.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_SISTEMA);
				notificacionVOValida.setDescripcionEmail(email.getValue());
				notificacionVOValida.setIdUsuarioNotificado(0);
				usuarioNotificacionDTOValida.setUsuarioNotificacionVO(notificacionVOValida);
				usuarioNotificacionDTOValida = usuarioNotificacionBOValida.readCommandValidateExist(usuarioNotificacionDTOValida);
				if(usuarioNotificacionDTOValida.getUsuarioNotificacionVOs().get(0).getExiste()>0){
					Messagebox.show("!Ya existe un usuario de negocio con el mismo email!",
							"Información", Messagebox.OK,
							Messagebox.EXCLAMATION);
				}else{
					logger.info("::::::Crear::::");
					UsuarioNotificacionDTO usuarioNotificacionDTO = new UsuarioNotificacionDTO();
					UsuarioNotificacionVO usuarioNotificacionVO = new UsuarioNotificacionVO();
					usuarioNotificacionVO.setIdUsuarioNotificado(Integer.parseInt(idUsuarioNotificado.getValue().isEmpty()?"0":idUsuarioNotificado.getValue()));
					usuarioNotificacionVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"1":idEstatusObjeto.getValue()));
					usuarioNotificacionVO.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_SISTEMA);
					usuarioNotificacionVO.setNombreUsuarioNotificado(nombreUsuario.getValue().toUpperCase());
					usuarioNotificacionVO.setDescripcionEmail(email.getValue());
								
					//Seteo de VO a DTO 
					usuarioNotificacionDTO.setUsuarioNotificacionVO(usuarioNotificacionVO);
					usuarioNotificacionDTO.toString(BbvaAbstractDataTransferObject.XML);	
					
					UsuarioNotificacionBO UsuarioNotificacionBO = new UsuarioNotificacionBO();
	
					UsuarioNotificacionBO.createCommand(usuarioNotificacionDTO);
					ReportesController controller = new ReportesController();
					controller.registrarEvento(null, null, CommandConstants.ALTA, "Usuario Sistema");
					clean();	
	
					usuarioNotificacionVO = new UsuarioNotificacionVO();
					usuarioNotificacionVO.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_SISTEMA);
	
					usuarioNotificacionDTO.setUsuarioNotificacionVO(usuarioNotificacionVO);
					usuarioNotificacionDTO.toString(BbvaAbstractDataTransferObject.XML);	
					
					//LLamada a BO  UsuarioNotificacion para consulta por criterio
					UsuarioNotificacionBO usuarioNotificacionBO = new UsuarioNotificacionBO();
					
					//Asignacion resultado de consulta al mismo DTO de UsuarioNotificacion
					usuarioNotificacionDTO = usuarioNotificacionBO.readCommand(usuarioNotificacionDTO);
					
					Messagebox.show("Registro creo con exito!!",
							"Confirmación", Messagebox.OK,
							Messagebox.INFORMATION);
					
					usuarioNotificacionVOs = usuarioNotificacionDTO.getUsuarioNotificacionVOs();
				}
			}
		}
	}
	
	private boolean validaMail(String hex) {
		Pattern pattern;
		Matcher matcher;
		String EMAIL_PATTERN = 
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(hex);
		return matcher.matches();
	}

	@GlobalCommand("resetGridUsuarioNotificacion")
	@NotifyChange({ "usuarioNotificacionVOs" })
	public void resetGrid() {
		UsuarioNotificacionDTO usuarioNotificacionDTO = new UsuarioNotificacionDTO();
		UsuarioNotificacionVO usuarioNotificacionVO = new UsuarioNotificacionVO();
		usuarioNotificacionDTO.setUsuarioNotificacionVO(usuarioNotificacionVO);
		UsuarioNotificacionBO usuarioNotificacionBO = new UsuarioNotificacionBO();
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		estatusObjetoDTO.setCommandId(2); 
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
		usuarioNotificacionDTO = usuarioNotificacionBO.readCommand(usuarioNotificacionDTO);
		logger.info("::::::::::::::SIZE::::::::::" + usuarioNotificacionDTO.getUsuarioNotificacionVOs());
		usuarioNotificacionDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
	}
	@Override
	@Command
	public void clean() {
		//Mensajes HTML
		status.clearErrorMessage();
		nombreUsuario.clearErrorMessage();
		email.clearErrorMessage();
		
		//Mensajes Setear a Null
		status.setValue(null);
		nombreUsuario.setValue(null);
		email.setValue(null); 
		 
		//Setear IDs Invisibles
		idUsuarioNotificado.setValue(null); 
		idEstatusObjeto.setValue(null);
		
	}
	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the nombreUsuario
	 */
	public Textbox getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(Textbox nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return the email
	 */
	public Textbox getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(Textbox email) {
		this.email = email;
	}

	/**
	 * @return the status
	 */
	public Combobox getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Combobox status) {
		this.status = status;
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
	 * @return the idUsuarioNotificado
	 */
	public Textbox getIdUsuarioNotificado() {
		return idUsuarioNotificado;
	}

	/**
	 * @param idUsuarioNotificado the idUsuarioNotificado to set
	 */
	public void setIdUsuarioNotificado(Textbox idUsuarioNotificado) {
		this.idUsuarioNotificado = idUsuarioNotificado;
	}

	/**
	 * @return the usuarioNotificacionDTO
	 */
	public UsuarioNotificacionDTO getUsuarioNotificacionDTO() {
		return usuarioNotificacionDTO;
	}

	/**
	 * @param usuarioNotificacionDTO the usuarioNotificacionDTO to set
	 */
	public void setUsuarioNotificacionDTO(
			UsuarioNotificacionDTO usuarioNotificacionDTO) {
		this.usuarioNotificacionDTO = usuarioNotificacionDTO;
	}

	/**
	 * @return the usuarioNotificacionVOs
	 */
	public List<UsuarioNotificacionVO> getUsuarioNotificacionVOs() {
		return usuarioNotificacionVOs;
	}

	/**
	 * @param usuarioNotificacionVOs the usuarioNotificacionVOs to set
	 */
	public void setUsuarioNotificacionVOs(
			List<UsuarioNotificacionVO> usuarioNotificacionVOs) {
		this.usuarioNotificacionVOs = usuarioNotificacionVOs;
	}

	/**
	 * @return the strIdUsuarioNotificado
	 */
	public String getStrIdUsuarioNotificado() {
		return strIdUsuarioNotificado;
	}

	/**
	 * @param strIdUsuarioNotificado the strIdUsuarioNotificado to set
	 */
	public void setStrIdUsuarioNotificado(String strIdUsuarioNotificado) {
		this.strIdUsuarioNotificado = strIdUsuarioNotificado;
	}

	/**
	 * @return the strIdEstatusObjeto
	 */
	public String getStrIdEstatusObjeto() {
		return strIdEstatusObjeto;
	}

	/**
	 * @param strIdEstatusObjeto the strIdEstatusObjeto to set
	 */
	public void setStrIdEstatusObjeto(String strIdEstatusObjeto) {
		this.strIdEstatusObjeto = strIdEstatusObjeto;
	}

	/**
	 * @return the strNombreUsuario
	 */
	public String getStrNombreUsuario() {
		return strNombreUsuario;
	}

	/**
	 * @param strNombreUsuario the strNombreUsuario to set
	 */
	public void setStrNombreUsuario(String strNombreUsuario) {
		this.strNombreUsuario = strNombreUsuario;
	}

	/**
	 * @return the strEmail
	 */
	public String getStrEmail() {
		return strEmail;
	}

	/**
	 * @param strEmail the strEmail to set
	 */
	public void setStrEmail(String strEmail) {
		this.strEmail = strEmail;
	}

	/**
	 * @return the strStatus
	 */
	public String getStrStatus() {
		return strStatus;
	}

	/**
	 * @param strStatus the strStatus to set
	 */
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
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
		componentes.put(lblNombreUsuario.getId(), lblNombreUsuario);
		componentes.put(lblEmail.getId(), lblEmail);
		componentes.put(lblEstatus.getId(), lblEstatus);
		componentes.put(nombreUsuario.getId(), nombreUsuario);
		componentes.put(email.getId(), email);
		componentes.put(status.getId(), status);
		componentes.put(limpiarBtn.getId(), limpiarBtn);
		componentes.put(consultarBtn.getId(), consultarBtn);
		componentes.put(guardarBtn.getId(), guardarBtn);
		componentes.put(usuariosNegocioGrid.getId(), usuariosNegocioGrid);
		componentes.put(reporteExcelBtn.getId(), reporteExcelBtn);
		componentes.put(reporteCsvBtn.getId(), reporteCsvBtn);
		super.applyPermission(MapeadorConstants.USUARIOS_NEGOCIO, componentes);
		return isApplied;
	}		
	@Command
	public void onShowReport(@BindingParam("type") final String type) {
		ReportesController controller = new ReportesController();
		ArrayList<String> headersReport = new ArrayList<String>();
		headersReport.add("Nombre de Usuario");
		headersReport.add("Email");
		headersReport.add("Estatus");		
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Usuarios Notificación Sistema");
		} else {			
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Usuarios Notificación Sistema");
		}
		controller.createReport(generaLista(), headersReport, type, "USUARIOS-SISTEMA");
	}	
	
	private ArrayList<BeanGenerico> generaLista() {
		ArrayList<BeanGenerico> beanGenericos = new ArrayList<BeanGenerico>();
		BeanGenerico beanGenerico = null;
		for(UsuarioNotificacionVO usuarioNotificacionVO: usuarioNotificacionVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(usuarioNotificacionVO.getNombreUsuarioNotificado());
			beanGenerico.setValor2(usuarioNotificacionVO.getDescripcionEmail());
			beanGenerico.setValor3(usuarioNotificacionVO.getNombreEstatusObjeto());			
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}
}
