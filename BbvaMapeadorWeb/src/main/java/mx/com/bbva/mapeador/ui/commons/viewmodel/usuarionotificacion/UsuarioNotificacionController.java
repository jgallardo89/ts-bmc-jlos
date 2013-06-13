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
 * Nombre de clase: UsuarioNotificacionController.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.usuarionotificacion
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.usuarionotificacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioNotificacionController.
 */
public class UsuarioNotificacionController  extends ControllerSupport implements IController{

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(UsuarioNotificacionController.class);
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7183766729268869941L;
	
	/** The consultar btn. */
	@Wire
	private Button consultarBtn;
	
	/** The email. */
	@Wire
	private Textbox email;

	/** The execute permission set. */
	private boolean executePermissionSet;

	/** The guardar btn. */
	@Wire
	private Button guardarBtn;
	
	/** The id estatus objeto. */
	@Wire
	private Textbox idEstatusObjeto;
	
	/** The id usuario notificado. */
	@Wire
	private Textbox idUsuarioNotificado;

	/** The lbl email. */
	@Wire
	private Label lblEmail;
	
	/** The lbl estatus. */
	@Wire
	private Label lblEstatus;
	
	/** The lbl nombre usuario. */
	@Wire
	private Label lblNombreUsuario;
	
	/** The limpiar btn. */
	@Wire
	private Button limpiarBtn;
	
	/** The nombre usuario. */
	@Wire
	private Textbox nombreUsuario;
	
	/** The reporte csv btn. */
	@Wire
	private Image reporteCsvBtn;
	
	/** The reporte excel btn. */
	@Wire
	private Image reporteExcelBtn;
	
	/** The status. */
	@Wire
	private Combobox status;

	/** The str email. */
	private String strEmail;
	
	/** The str id estatus objeto. */
	private String strIdEstatusObjeto;
	
	/** The str id usuario notificado. */
	private String strIdUsuarioNotificado;
	
	/** The str nombre usuario. */
	private String strNombreUsuario;	
	
	/** The str status. */
	private String strStatus;
	
	/** The usuario notificacion dto. */
	private UsuarioNotificacionDTO	usuarioNotificacionDTO = (UsuarioNotificacionDTO)this.read(); 
	
	/** The usuario notificacion vo. */
	private UsuarioNotificacionVO usuarioNotificacionVO; 
	
	/** The usuario notificacion v os. */
	private List<UsuarioNotificacionVO> usuarioNotificacionVOs = usuarioNotificacionDTO.getUsuarioNotificacionVOs();

	/** The usuarios negocio grid. */
	@Wire
	private Grid usuariosNegocioGrid;
	
	/**
	 * After compose.
	 *
	 * @param view the view
	 */
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
        executePermissionSet = this.applyPermision();
		status.setValue(CommandConstants.NB_USUARIO_NOTIFICACION_ACTIVO);
		idEstatusObjeto.setValue(String.valueOf(CommandConstants.ESTATUS_USUARIO_NOTIFICACION_ACTIVO));             
    }
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#applyPermision()
	 */
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

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#clean()
	 */
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
		for(UsuarioNotificacionVO usuarioNotificacionVO: usuarioNotificacionVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(usuarioNotificacionVO.getNombreUsuarioNotificado());
			beanGenerico.setValor2(usuarioNotificacionVO.getDescripcionEmail());
			beanGenerico.setValor3(usuarioNotificacionVO.getNombreEstatusObjeto());			
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public Textbox getEmail() {
		return email;
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
	 * Gets the id usuario notificado.
	 *
	 * @return the idUsuarioNotificado
	 */
	public Textbox getIdUsuarioNotificado() {
		return idUsuarioNotificado;
	}

	/**
	 * Gets the nombre usuario.
	 *
	 * @return the nombreUsuario
	 */
	public Textbox getNombreUsuario() {
		return nombreUsuario;
	}
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public Combobox getStatus() {
		return status;
	}
	
	/**
	 * Gets the str email.
	 *
	 * @return the strEmail
	 */
	public String getStrEmail() {
		return strEmail;
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
	 * Gets the str id usuario notificado.
	 *
	 * @return the strIdUsuarioNotificado
	 */
	public String getStrIdUsuarioNotificado() {
		return strIdUsuarioNotificado;
	}

	/**
	 * Gets the str nombre usuario.
	 *
	 * @return the strNombreUsuario
	 */
	public String getStrNombreUsuario() {
		return strNombreUsuario;
	}

	/**
	 * Gets the str status.
	 *
	 * @return the strStatus
	 */
	public String getStrStatus() {
		return strStatus;
	}

	/**
	 * Gets the usuario notificacion dto.
	 *
	 * @return the usuarioNotificacionDTO
	 */
	public UsuarioNotificacionDTO getUsuarioNotificacionDTO() {
		return usuarioNotificacionDTO;
	}

	/**
	 * Gets the usuario notificacion vo.
	 *
	 * @return the usuarioNotificacionVO
	 */
	public final UsuarioNotificacionVO getUsuarioNotificacionVO() {
		return usuarioNotificacionVO;
	}

	/**
	 * Gets the usuario notificacion v os.
	 *
	 * @return the usuarioNotificacionVOs
	 */
	public List<UsuarioNotificacionVO> getUsuarioNotificacionVOs() {
		return usuarioNotificacionVOs;
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
		headersReport.add("Nombre usuario");
		headersReport.add("e-mail");
		headersReport.add("Status");		
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Usuarios Notificación Negocio");
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Usuarios Notificación Negocio");
		}
		controller.createReport(generaLista(), headersReport, type, "USUARIOS-NEGOCIO");
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read()
	 */
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
		usuarioNotificacionVO.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_NEGOCIO);
		usuarioNotificacionDTO.setUsuarioNotificacionVO(usuarioNotificacionVO);
		usuarioNotificacionDTO = usuarioNotificacionBO.readCommand(usuarioNotificacionDTO);
		logger.info("::::::::::::::SIZE::::::::::" + usuarioNotificacionDTO.getUsuarioNotificacionVOs());
		usuarioNotificacionDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
		return usuarioNotificacionDTO;
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
	 * @param usuarioNotificacionVO the usuario notificacion vo
	 */
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
	/**
	 * Read with filters.
	 */
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
		usuarioNotificacionVO.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_NEGOCIO);
		usuarioNotificacionDTO.setUsuarioNotificacionVO(usuarioNotificacionVO);
		usuarioNotificacionDTO.toString(BbvaAbstractDataTransferObject.XML);	
		
		//LLamada a BO  UsuarioNotificacion para consulta por criterio
		UsuarioNotificacionBO usuarioNotificacionBO = new UsuarioNotificacionBO();
		
		//Asignacion resultado de consulta al mismo DTO de UsuarioNotificacion
		usuarioNotificacionDTO = usuarioNotificacionBO.readCommand(usuarioNotificacionDTO);
		
		ReportesController controller = new ReportesController();
		controller.registrarEvento(usuarioNotificacionVO, this.usuarioNotificacionVO, CommandConstants.CONSULTAR, "Usuario Negocio");
		//Tamaño de la lista de acuerdo al criterio de busqueda y objeto UsuarioNotificacion
		if(usuarioNotificacionDTO.getUsuarioNotificacionVOs() != null) {
			logger.debug("Tamaño de la lista de acuerdo al criterio de busqueda y objeto UsuarioNotificacion size:"+usuarioNotificacionDTO.getUsuarioNotificacionVOs().size());
		} else{
			logger.debug(":::::::::::Lista Vacia::::::::::");
		}
		//Asignacion de la lista a la variable global de la clase
		usuarioNotificacionVOs = usuarioNotificacionDTO.getUsuarioNotificacionVOs();
		
	}

	/**
	 * Reset grid.
	 */
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

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#save()
	 */
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
				notificacionVOValida.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_NEGOCIO);
				notificacionVOValida.setDescripcionEmail(email.getValue());
				notificacionVOValida.setIdUsuarioNotificado(Integer.parseInt(idUsuarioNotificado.getValue()));
				usuarioNotificacionDTOValida.setUsuarioNotificacionVO(notificacionVOValida);
				usuarioNotificacionDTOValida = usuarioNotificacionBOValida.readCommandValidateExist(usuarioNotificacionDTOValida);				
				if(usuarioNotificacionDTOValida.getUsuarioNotificacionVOs().get(0).getExiste()>0){
					org.zkoss.zul.Messagebox.show("!Ya existe un usuario de negocio con el mismo email!",
							"Información", org.zkoss.zul.Messagebox.OK,
							org.zkoss.zul.Messagebox.EXCLAMATION);
				}else{
					logger.info("::::::Actualizar::::");
					UsuarioNotificacionDTO usuarioNotificacionDTO = new UsuarioNotificacionDTO();
					UsuarioNotificacionVO usuarioNotificacionVO = new UsuarioNotificacionVO();
					usuarioNotificacionVO.setIdUsuarioNotificado(Integer.parseInt(idUsuarioNotificado.getValue()));
					usuarioNotificacionVO.setIdEstatusObjeto(Integer.parseInt(status.getSelectedItem().getValue().toString()));
					usuarioNotificacionVO.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_NEGOCIO);
					usuarioNotificacionVO.setNombreUsuarioNotificado(nombreUsuario.getValue().toUpperCase().trim());
					usuarioNotificacionVO.setDescripcionEmail(email.getValue().trim());
								
					//Seteo de VO a DTO 
					usuarioNotificacionDTO.setUsuarioNotificacionVO(usuarioNotificacionVO);
					usuarioNotificacionDTO.toString(BbvaAbstractDataTransferObject.XML);	
					UsuarioNotificacionBO usuarioNotificacionBO = new UsuarioNotificacionBO();
					if(Integer.parseInt(status.getSelectedItem().getValue().toString())==20 ||
							Integer.parseInt(status.getSelectedItem().getValue().toString())==19){						
						UsuarioNotificacionDTO usuarioNotificacionDTOValidaExiste = new UsuarioNotificacionDTO();
						UsuarioNotificacionVO usuarioNotificacionVOValidaExiste  = new UsuarioNotificacionVO();
						usuarioNotificacionVOValidaExiste.setIdUsuarioNotificado(Integer.parseInt(idUsuarioNotificado.getValue()));
						usuarioNotificacionVOValidaExiste.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_NEGOCIO);
						usuarioNotificacionDTOValidaExiste.setUsuarioNotificacionVO(usuarioNotificacionVOValidaExiste);
						usuarioNotificacionDTOValidaExiste = usuarioNotificacionBO.readCommandValidateExistePermiso(usuarioNotificacionDTOValidaExiste);
						if(usuarioNotificacionDTOValidaExiste.getUsuarioNotificacionVOs().get(0).getExiste()==1){							
							org.zkoss.zul.Messagebox.show("El usuario no se puede desactivar o dar de baja debido a que esta asociado a notificaciones!!",
									"Error", org.zkoss.zul.Messagebox.OK,
									org.zkoss.zul.Messagebox.ERROR);
						}else{
							usuarioNotificacionBO.updateCommand(usuarioNotificacionDTO);
							ReportesController controller = new ReportesController();
							controller.registrarEvento(usuarioNotificacionVO, this.usuarioNotificacionVO, CommandConstants.MODIFICACION, "Usuario Negocio");
							clean();			
							
							usuarioNotificacionVO = new UsuarioNotificacionVO();
							usuarioNotificacionVO.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_NEGOCIO);
							usuarioNotificacionDTO.setUsuarioNotificacionVO(usuarioNotificacionVO);
							usuarioNotificacionDTO.toString(BbvaAbstractDataTransferObject.XML);																		
							
							//Asignacion resultado de consulta al mismo DTO de UsuarioNotificacion
							usuarioNotificacionDTO = usuarioNotificacionBO.readCommand(usuarioNotificacionDTO);
							
							
							org.zkoss.zul.Messagebox.show("Registro actualizado con exito!!",
									"Confirmación", org.zkoss.zul.Messagebox.OK,
									org.zkoss.zul.Messagebox.INFORMATION);
							
							usuarioNotificacionVOs = usuarioNotificacionDTO.getUsuarioNotificacionVOs();
						}
					}else{						
						usuarioNotificacionBO.updateCommand(usuarioNotificacionDTO);
						ReportesController controller = new ReportesController();
						controller.registrarEvento(usuarioNotificacionVO, this.usuarioNotificacionVO, CommandConstants.MODIFICACION, "Usuario Negocio");
						clean();			
						
						usuarioNotificacionVO = new UsuarioNotificacionVO();
						usuarioNotificacionVO.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_NEGOCIO);
						usuarioNotificacionDTO.setUsuarioNotificacionVO(usuarioNotificacionVO);
						usuarioNotificacionDTO.toString(BbvaAbstractDataTransferObject.XML);																		
						
						//Asignacion resultado de consulta al mismo DTO de UsuarioNotificacion
						usuarioNotificacionDTO = usuarioNotificacionBO.readCommand(usuarioNotificacionDTO);
						
						
						org.zkoss.zul.Messagebox.show("Registro actualizado con exito!!",
								"Confirmación", org.zkoss.zul.Messagebox.OK,
								org.zkoss.zul.Messagebox.INFORMATION);
						
						usuarioNotificacionVOs = usuarioNotificacionDTO.getUsuarioNotificacionVOs();						
					}
				}
			}else{ 
				UsuarioNotificacionVO notificacionVOValida = new UsuarioNotificacionVO();
				UsuarioNotificacionBO usuarioNotificacionBOValida = new UsuarioNotificacionBO();
				UsuarioNotificacionDTO usuarioNotificacionDTOValida = new UsuarioNotificacionDTO();
				notificacionVOValida.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_NEGOCIO);
				notificacionVOValida.setDescripcionEmail(email.getValue());
				notificacionVOValida.setIdUsuarioNotificado(0);				
				usuarioNotificacionDTOValida.setUsuarioNotificacionVO(notificacionVOValida);
				usuarioNotificacionDTOValida = usuarioNotificacionBOValida.readCommandValidateExist(usuarioNotificacionDTOValida);
				if(usuarioNotificacionDTOValida.getUsuarioNotificacionVOs().get(0).getExiste()>0){
					org.zkoss.zul.Messagebox.show("!Ya existe un usuario de negocio con el mismo email!",
							"Información", org.zkoss.zul.Messagebox.OK,
							org.zkoss.zul.Messagebox.EXCLAMATION);
				}else{
					logger.info("::::::Crear::::");
					UsuarioNotificacionDTO usuarioNotificacionDTO = new UsuarioNotificacionDTO();
					UsuarioNotificacionVO usuarioNotificacionVO = new UsuarioNotificacionVO();
					usuarioNotificacionVO.setIdUsuarioNotificado(Integer.parseInt(idUsuarioNotificado.getValue().isEmpty()?"0":idUsuarioNotificado.getValue()));
					usuarioNotificacionVO.setIdEstatusObjeto(Integer.parseInt(status.getSelectedItem().getValue().toString()));
					usuarioNotificacionVO.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_NEGOCIO);
					usuarioNotificacionVO.setNombreUsuarioNotificado(nombreUsuario.getValue().toUpperCase().trim());
					usuarioNotificacionVO.setDescripcionEmail(email.getValue().trim());
								
					//Seteo de VO a DTO 
					usuarioNotificacionDTO.setUsuarioNotificacionVO(usuarioNotificacionVO);
					usuarioNotificacionDTO.toString(BbvaAbstractDataTransferObject.XML);	
					
					UsuarioNotificacionBO UsuarioNotificacionBO = new UsuarioNotificacionBO();
	
					UsuarioNotificacionBO.createCommand(usuarioNotificacionDTO);
					ReportesController controller = new ReportesController();
					controller.registrarEvento(null, null, CommandConstants.ALTA, "Usuario Negocio");
					clean();	
	
					usuarioNotificacionVO = new UsuarioNotificacionVO();
					usuarioNotificacionVO.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_NEGOCIO);
	
					usuarioNotificacionDTO.setUsuarioNotificacionVO(usuarioNotificacionVO);
					usuarioNotificacionDTO.toString(BbvaAbstractDataTransferObject.XML);	
					
					//LLamada a BO  UsuarioNotificacion para consulta por criterio
					UsuarioNotificacionBO usuarioNotificacionBO = new UsuarioNotificacionBO();
					
					//Asignacion resultado de consulta al mismo DTO de UsuarioNotificacion
					usuarioNotificacionDTO = usuarioNotificacionBO.readCommand(usuarioNotificacionDTO);
					
					org.zkoss.zul.Messagebox.show("Registro creo con exito!!",
							"Confirmación", org.zkoss.zul.Messagebox.OK,
							org.zkoss.zul.Messagebox.INFORMATION);
					
					usuarioNotificacionVOs = usuarioNotificacionDTO.getUsuarioNotificacionVOs();
				}
			}
		}
	}

	/**
	 * Sets the email.
	 *
	 * @param email the email to set
	 */
	public void setEmail(Textbox email) {
		this.email = email;
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
	 * Sets the id estatus objeto.
	 *
	 * @param idEstatusObjeto the idEstatusObjeto to set
	 */
	public void setIdEstatusObjeto(Textbox idEstatusObjeto) {
		this.idEstatusObjeto = idEstatusObjeto;
	}

	/**
	 * Sets the id usuario notificado.
	 *
	 * @param idUsuarioNotificado the idUsuarioNotificado to set
	 */
	public void setIdUsuarioNotificado(Textbox idUsuarioNotificado) {
		this.idUsuarioNotificado = idUsuarioNotificado;
	}

	/**
	 * Sets the nombre usuario.
	 *
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(Textbox nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(Combobox status) {
		this.status = status;
	}

	/**
	 * Sets the str email.
	 *
	 * @param strEmail the strEmail to set
	 */
	public void setStrEmail(String strEmail) {
		this.strEmail = strEmail;
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
	 * Sets the str id usuario notificado.
	 *
	 * @param strIdUsuarioNotificado the strIdUsuarioNotificado to set
	 */
	public void setStrIdUsuarioNotificado(String strIdUsuarioNotificado) {
		this.strIdUsuarioNotificado = strIdUsuarioNotificado;
	}

	/**
	 * Sets the str nombre usuario.
	 *
	 * @param strNombreUsuario the strNombreUsuario to set
	 */
	public void setStrNombreUsuario(String strNombreUsuario) {
		this.strNombreUsuario = strNombreUsuario;
	}

	/**
	 * Sets the str status.
	 *
	 * @param strStatus the strStatus to set
	 */
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}
	
	/**
	 * Sets the usuario notificacion dto.
	 *
	 * @param usuarioNotificacionDTO the usuarioNotificacionDTO to set
	 */
	public void setUsuarioNotificacionDTO(
			UsuarioNotificacionDTO usuarioNotificacionDTO) {
		this.usuarioNotificacionDTO = usuarioNotificacionDTO;
	}
	
	/**
	 * Sets the usuario notificacion vo.
	 *
	 * @param usuarioNotificacionVO the usuarioNotificacionVO to set
	 */
	public final void setUsuarioNotificacionVO(
			UsuarioNotificacionVO usuarioNotificacionVO) {
		this.usuarioNotificacionVO = usuarioNotificacionVO;
	}		
	
	/**
	 * Sets the usuario notificacion v os.
	 *
	 * @param usuarioNotificacionVOs the usuarioNotificacionVOs to set
	 */
	public void setUsuarioNotificacionVOs(
			List<UsuarioNotificacionVO> usuarioNotificacionVOs) {
		this.usuarioNotificacionVOs = usuarioNotificacionVOs;
	}	
	
	/**
	 * Valida mail.
	 *
	 * @param hex the hex
	 * @return true, if successful
	 */
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
}
