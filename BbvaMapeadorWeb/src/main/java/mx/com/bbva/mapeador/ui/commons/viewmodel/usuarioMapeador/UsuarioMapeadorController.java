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
 * Nombre de clase: UsuarioMapeadorController.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.usuarioMapeador
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.usuarioMapeador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.estatusobjeto.dto.UsuarioDTO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.PerfilBO;
import mx.com.bbva.bancomer.mapper.business.UsuarioBO;
import mx.com.bbva.bancomer.perfil.dto.PerfilDTO;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.reportes.ReportesController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

import org.apache.log4j.Logger;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
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
 * The Class UsuarioMapeadorController.
 */
public class UsuarioMapeadorController extends ControllerSupport implements IController{

	/** The Constant logger. */
	private static final Logger logger = Logger
			.getLogger(UsuarioMapeadorController.class);

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2636239878370242704L;

	/** The consultar btn. */
	@Wire
	private Button consultarBtn;	
	
	/** The execute permission set. */
	private boolean executePermissionSet;
	
	/** The guardar btn. */
	@Wire
	private Button guardarBtn; 
	
	/** The identificador usuario. */
	@Wire
	private Textbox identificadorUsuario;
	
	/** The id estatus objeto. */
	@Wire
	private Textbox idEstatusObjeto;
	
	/** The id perfil. */
	@Wire
	private Textbox idPerfil;

	/** The id usuario. */
	@Wire
	private Textbox idUsuario;

	/** The lbl nombre usuario. */
	@Wire
	private Label lblNombreUsuario;
	
	/** The lbl perfiles disponibles. */
	@Wire
	private Label lblPerfilesDisponibles;
	
	/** The lbl status. */
	@Wire
	private Label lblStatus;
	
	/** The lbl usuario. */
	@Wire
	private Label lblUsuario;
	
	/** The limpiar btn. */
	@Wire
	private Button limpiarBtn;
	
	/** The nombre usuario. */
	@Wire
	private Textbox nombreUsuario;

	/** The perfiles disponibles. */
	@Wire
	private Combobox perfilesDisponibles;
	
	/** The reporte csv btn. */
	@Wire
	private Image reporteCsvBtn;
	
	/** The reporte excel btn. */
	@Wire
	private Image reporteExcelBtn;
	
	/** The status. */
	@Wire
	private Combobox status;

	/** The usuario dto. */
	private UsuarioDTO	usuarioDTO = (UsuarioDTO)this.read();
	
	/** The usuarios grid. */
	@Wire
	private Grid usuariosGrid;
	
	/** The usuario vo. */
	private UsuarioVO usuarioVO = null;
	
	/** The usuario v os. */
	private List<UsuarioVO> usuarioVOs = usuarioDTO.getUsuarioVOs();
	
	/**
	 * After compose.
	 *
	 * @param view the view
	 */
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);
        executePermissionSet = this.applyPermision();
        status.setValue(CommandConstants.NB_USUARIO_ACTIVO);
        idEstatusObjeto.setValue(String.valueOf(CommandConstants.ESTATUS_USUARIO_ACTIVO));
    }
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#applyPermision()
	 */
	@Override
	public boolean applyPermision() {
		boolean isApplied = false;
		HashMap<String, Component> componentes = new HashMap<String, Component>();
		logger.debug(identificadorUsuario.getValue());
		componentes.put(lblUsuario.getId(), lblUsuario);
		componentes.put(identificadorUsuario.getId(), identificadorUsuario);
		componentes.put(lblNombreUsuario.getId(), lblNombreUsuario);
		componentes.put(nombreUsuario.getId(), nombreUsuario);
		componentes.put(lblPerfilesDisponibles.getId(), lblPerfilesDisponibles);
		componentes.put(perfilesDisponibles.getId(), perfilesDisponibles);
		componentes.put(lblStatus.getId(), lblStatus);
		componentes.put(status.getId(), status);
		componentes.put(consultarBtn.getId(),consultarBtn) ;
		componentes.put(guardarBtn.getId(),guardarBtn);
		componentes.put(limpiarBtn.getId(),limpiarBtn);
		componentes.put(usuariosGrid.getId(),usuariosGrid); 
		componentes.put(reporteExcelBtn.getId(),reporteExcelBtn);
		componentes.put(reporteCsvBtn.getId(),reporteCsvBtn);
		super.applyPermission(MapeadorConstants.USUARIOS, componentes);
		return isApplied;
	}

	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#clean()
	 */
	@Override
	@Command	
	public void clean() {	
		perfilesDisponibles.clearErrorMessage();
		status.clearErrorMessage();
		idPerfil.clearErrorMessage();
		idEstatusObjeto.clearErrorMessage();
		identificadorUsuario.clearErrorMessage();
		nombreUsuario.clearErrorMessage();
		
		perfilesDisponibles.setValue(null);
		status.setValue(null);
		idPerfil.setValue(null);
		idEstatusObjeto.setValue(null);
		identificadorUsuario.setValue(null);
		nombreUsuario.setValue(null);
		idUsuario.setValue(null);
		this.usuarioVO = null;
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#delete()
	 */
	@Override
	@Command
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
		for(UsuarioVO usuarioVO: usuarioVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(usuarioVO.getIdCveUsuario());
			beanGenerico.setValor2(usuarioVO.getNombreUsuario());
			beanGenerico.setValor3(usuarioVO.getDescripcionPerfil());
			beanGenerico.setValor4(usuarioVO.getNombreEstatusObjeto());
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}

	/**
	 * Gets the identificador usuario.
	 *
	 * @return the identificadorUsuario
	 */
	public Textbox getIdentificadorUsuario() {
		return identificadorUsuario;
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
	 * Gets the id perfil.
	 *
	 * @return the idPerfil
	 */
	public Textbox getIdPerfil() {
		return idPerfil;
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
	 * Gets the perfiles disponibles.
	 *
	 * @return the perfilesDisponibles
	 */
	public Combobox getPerfilesDisponibles() {
		return perfilesDisponibles;
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
	 * Gets the usuario dto.
	 *
	 * @return the usuarioDTO
	 */
	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	/**
	 * Gets the usuario v os.
	 *
	 * @return the usuarioVOs
	 */
	public List<UsuarioVO> getUsuarioVOs() {
		return usuarioVOs;
	}

	/**
	 * Checks if is execute permission set.
	 *
	 * @return the executePermissionSet
	 */
	public final boolean isExecutePermissionSet() {
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
		headersReport.add("Identificador usuario");
		headersReport.add("Usuario");
		headersReport.add("Perfil");
		headersReport.add("Status");
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Catálogo Usuarios WEB");
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Catálogo Usuarios WEB");
		}
		controller.createReport(generaLista(), headersReport, type, "USUARIOS-WEB");
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read()
	 */
	@Override
	public Object read() {		
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
		estatusObjetoVO.setNombreTabla(CommandConstants.NOMBRE_TABLA_USUARIO);		
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
		usuarioDTO = new UsuarioDTO();		
		UsuarioBO usuarioBO = new UsuarioBO();
		usuarioDTO = usuarioBO.readCommand(usuarioDTO);
		usuarioDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
		PerfilDTO perfilDTO = new PerfilDTO();
		PerfilBO perfilBO = new PerfilBO();		
		perfilDTO.setCommandId(CommandConstants.PERFIL_COMMAND_READ_ALL);
		perfilDTO = perfilBO.readCommand(perfilDTO);
		usuarioDTO.setPerfilVOs(perfilDTO.getPerfilVOs());
		
		
		
		return usuarioDTO;
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read(java.lang.Object)
	 */
	@Override
	@Command
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Read selected.
	 *
	 * @param usuarioVO the usuario vo
	 */
	@Command
	public void readSelected(@BindingParam("idCveUsuario") final UsuarioVO usuarioVO){
		usuarioVO.toString();
		
		perfilesDisponibles.setValue(usuarioVO.getDescripcionPerfil()); 
		status.setValue(usuarioVO.getNombreEstatusObjeto());
		idPerfil.setValue(Integer.toString(usuarioVO.getIdPerfil()));
		idEstatusObjeto.setValue(Integer.toString(usuarioVO.getEstatusUsuario()));
		identificadorUsuario.setValue(usuarioVO.getIdCveUsuario());
		nombreUsuario.setValue(usuarioVO.getNombreUsuario());
		idUsuario.setValue(Integer.toString(usuarioVO.getIdUsuario()));
		this.usuarioVO =  usuarioVO;
		
	}

	/**
	 * Read with filters.
	 */
	@Command
	@NotifyChange({ "usuarioVOs" })
	public void readWithFilters() {
		UsuarioBO usuarioBO = new UsuarioBO();
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		UsuarioVO usuarioVO = new UsuarioVO();		
		usuarioVO.setNombreUsuario(nombreUsuario.getValue().isEmpty()?null:"%"+nombreUsuario.getValue().toUpperCase()+"%");
		usuarioVO.setIdCveUsuario(identificadorUsuario.getValue().isEmpty()?null:"%"+identificadorUsuario.getValue().toUpperCase()+"%");
		usuarioVO.setIdPerfil(Integer.parseInt(perfilesDisponibles.getSelectedItem()==null?"0":perfilesDisponibles.getSelectedItem().getValue().toString()));
		usuarioVO.setEstatusUsuario(Integer.parseInt(status.getSelectedItem()==null?"0":status.getSelectedItem().getValue().toString()));
		usuarioDTO.setUsuarioVO(usuarioVO);
		usuarioDTO.toString(BbvaAbstractDataTransferObject.XML);		
		usuarioDTO = usuarioBO.readCommand(usuarioDTO);
		logger.debug("size:"+usuarioDTO.getUsuarioVOs().size());
		ReportesController controller = new ReportesController();
		controller.registrarEvento(null, null, CommandConstants.CONSULTAR, "USUARIO-WEB");
		usuarioVOs = usuarioDTO.getUsuarioVOs();
		
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#save()
	 */
	@Override
	@Command
	@NotifyChange({ "usuarioVOs" })
	public void save() {
		boolean errorGuardar = false;
		if (perfilesDisponibles.getSelectedItem() == null
				|| perfilesDisponibles.getSelectedItem().getValue() == null
				|| perfilesDisponibles.getSelectedItem().getValue().toString().isEmpty()) {
			perfilesDisponibles.setErrorMessage("Favor de seleccionar el perfil.");
			errorGuardar = true;
		}
		if (nombreUsuario.getValue().isEmpty()) {
			nombreUsuario
					.setErrorMessage("Favor de introducir nombre del Usuario del Objeto");
			errorGuardar = true;
		} 
		if (identificadorUsuario.getValue().isEmpty()) {
			identificadorUsuario
					.setErrorMessage("Favor de introducir Identificador del Usuario del Objeto");
			errorGuardar = true;
		}
		if(!errorGuardar){
			if(idUsuario.getValue().isEmpty()){
				UsuarioDTO usuarioDTO = new UsuarioDTO();
				UsuarioVO usuarioVO = new UsuarioVO();
				usuarioVO.setEstatusUsuario( Integer.parseInt(status.getSelectedItem().getValue().toString()));
				usuarioVO.setIdCveUsuario( identificadorUsuario.getValue().toUpperCase().trim() );
				usuarioVO.setIdPerfil(Integer.parseInt(perfilesDisponibles.getSelectedItem().getValue().toString()));			
				usuarioVO.setNombreUsuario( nombreUsuario.getValue().toUpperCase().trim() );
				usuarioDTO.setUsuarioVO(usuarioVO);
				usuarioDTO.toString(BbvaAbstractDataTransferObject.XML);
				UsuarioBO usuarioBO = new UsuarioBO();
				usuarioDTO = usuarioBO.createCommand(usuarioDTO);
				ReportesController controller = new ReportesController();
				controller.registrarEvento(null, null, CommandConstants.ALTA, "USUARIO-WEB");
				if(usuarioDTO.getErrorCode().equals("0001")){
					org.zkoss.zul.Messagebox.show("!"+usuarioDTO.getErrorDescription()+"!",
							"Error", org.zkoss.zul.Messagebox.OK,
							org.zkoss.zul.Messagebox.ERROR);
				}else{
					clean();
					usuarioBO = new UsuarioBO();
					usuarioDTO = new UsuarioDTO();
					usuarioVO = new UsuarioVO();		
					usuarioVO.setNombreUsuario(nombreUsuario.getValue().isEmpty()?null:"%"+nombreUsuario.getValue().toUpperCase()+"%");
					usuarioVO.setIdCveUsuario(identificadorUsuario.getValue().isEmpty()?null:"%"+identificadorUsuario.getValue().toUpperCase()+"%");
					usuarioVO.setIdPerfil(Integer.parseInt(idPerfil.getValue().isEmpty()?"0":idPerfil.getValue()));
					usuarioVO.setEstatusUsuario(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
					usuarioDTO.setUsuarioVO(usuarioVO);
					usuarioDTO.toString(BbvaAbstractDataTransferObject.XML);		
					usuarioDTO = usuarioBO.readCommand(usuarioDTO);
					logger.debug("size:"+usuarioDTO.getUsuarioVOs().size());
					usuarioVOs = usuarioDTO.getUsuarioVOs();
					org.zkoss.zul.Messagebox.show("!El registro del usuario fue exitoso!",
							"Información", org.zkoss.zul.Messagebox.OK,
							org.zkoss.zul.Messagebox.INFORMATION);
				}
			}else{
				UsuarioDTO usuarioDTO = new UsuarioDTO();
				UsuarioVO usuarioVO = new UsuarioVO();
				usuarioVO.setEstatusUsuario( Integer.parseInt(status.getSelectedItem().getValue().toString()));
				usuarioVO.setIdCveUsuario(identificadorUsuario.getValue().toUpperCase().trim() );
				usuarioVO.setIdPerfil(Integer.parseInt(perfilesDisponibles.getSelectedItem().getValue().toString()));			
				usuarioVO.setNombreUsuario( nombreUsuario.getValue().toUpperCase().trim() );
				logger.debug("**USER**---"+idUsuario.getValue());
				usuarioVO.setIdUsuario(Integer.parseInt(idUsuario.getValue()));
				usuarioDTO.setUsuarioVO(usuarioVO);
				usuarioDTO.toString(BbvaAbstractDataTransferObject.XML);
				UsuarioBO usuarioBO = new UsuarioBO();
				usuarioBO.updateCommand(usuarioDTO);
				ReportesController controller = new ReportesController();
				controller.registrarEvento(usuarioVO, this.usuarioVO, CommandConstants.MODIFICACION, "USUARIO-WEB");
				if(usuarioDTO.getErrorCode().equals("0001")){
					org.zkoss.zul.Messagebox.show("!"+usuarioDTO.getErrorDescription()+"!",
							"Error", org.zkoss.zul.Messagebox.OK,
							org.zkoss.zul.Messagebox.ERROR);
				}else{
					clean();
					usuarioBO = new UsuarioBO();
					usuarioDTO = new UsuarioDTO();
					usuarioVO = new UsuarioVO();		
					usuarioVO.setNombreUsuario(nombreUsuario.getValue().isEmpty()?null:"%"+nombreUsuario.getValue().toUpperCase()+"%");
					usuarioVO.setIdCveUsuario(identificadorUsuario.getValue().isEmpty()?null:"%"+identificadorUsuario.getValue().toUpperCase()+"%");
					usuarioVO.setIdPerfil(Integer.parseInt(idPerfil.getValue().isEmpty()?"0":idPerfil.getValue()));
					usuarioVO.setEstatusUsuario(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
					
					usuarioDTO.setUsuarioVO(usuarioVO);
					usuarioDTO.toString(BbvaAbstractDataTransferObject.XML);		
					usuarioDTO = usuarioBO.readCommand(usuarioDTO);
					logger.debug("size:"+usuarioDTO.getUsuarioVOs().size());
					usuarioVOs = usuarioDTO.getUsuarioVOs();
					
					org.zkoss.zul.Messagebox.show("!La actualizacón del usuario fue exitosa!",
							"Información", org.zkoss.zul.Messagebox.OK,
							org.zkoss.zul.Messagebox.INFORMATION);
				}
			}
		}
		
	}

	/**
	 * Sets the execute permission set.
	 *
	 * @param executePermissionSet the executePermissionSet to set
	 */
	public final void setExecutePermissionSet(boolean executePermissionSet) {
		this.executePermissionSet = executePermissionSet;
	}

	/**
	 * Sets the identificador usuario.
	 *
	 * @param identificadorUsuario the identificadorUsuario to set
	 */
	public void setIdentificadorUsuario(Textbox identificadorUsuario) {
		this.identificadorUsuario = identificadorUsuario;
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
	 * Sets the id perfil.
	 *
	 * @param idPerfil the idPerfil to set
	 */
	public void setIdPerfil(Textbox idPerfil) {
		this.idPerfil = idPerfil;
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
	 * Sets the perfiles disponibles.
	 *
	 * @param perfilesDisponibles the perfilesDisponibles to set
	 */
	public void setPerfilesDisponibles(Combobox perfilesDisponibles) {
		this.perfilesDisponibles = perfilesDisponibles;
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
	 * Sets the usuario dto.
	 *
	 * @param usuarioDTO the usuarioDTO to set
	 */
	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}	
	
	/**
	 * Sets the usuario v os.
	 *
	 * @param usuarioVOs the usuarioVOs to set
	 */
	public void setUsuarioVOs(List<UsuarioVO> usuarioVOs) {
		this.usuarioVOs = usuarioVOs;
	}
}
