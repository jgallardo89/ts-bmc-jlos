package mx.com.bbva.mapeador.ui.commons.viewmodel.usuarioMapeador;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.estatusobjeto.dto.PerfilDTO;
import mx.com.bbva.bancomer.estatusobjeto.dto.UsuarioDTO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.PerfilBO;
import mx.com.bbva.bancomer.mapper.business.UsuarioBO;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
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
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;

public class UsuarioMapeadorController extends ControllerSupport implements IController{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2636239878370242704L;

	private static final Logger logger = Logger
			.getLogger(UsuarioMapeadorController.class);

	private UsuarioDTO	usuarioDTO = (UsuarioDTO)this.read();	

	@Wire
	private Combobox perfilesDisponibles;

	@Wire
	private Combobox status;
	
	@Wire
	private Textbox idPerfil;
	
	@Wire
	private Textbox idEstatusObjeto;
	
	@Wire
	private Textbox identificadorUsuario;

	@Wire
	private Textbox nombreUsuario;
	
	private List<UsuarioVO> usuarioVOs = usuarioDTO.getUsuarioVOs();

	
	/**
	 * @return the usuarioVOs
	 */
	public List<UsuarioVO> getUsuarioVOs() {
		return usuarioVOs;
	}

	/**
	 * @param usuarioVOs the usuarioVOs to set
	 */
	public void setUsuarioVOs(List<UsuarioVO> usuarioVOs) {
		this.usuarioVOs = usuarioVOs;
	}

	@Override
	public Object read() {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		estatusObjetoDTO.setCommandId(2);
		UsuarioBO usuarioBO = new UsuarioBO();
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		usuarioDTO = usuarioBO.readCommand(usuarioDTO);
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
		usuarioDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
		PerfilDTO perfilDTO = new PerfilDTO();
		PerfilBO perfilBO = new PerfilBO();
		perfilDTO = perfilBO.readCommand(perfilDTO);
		usuarioDTO.setPerfilVOs(perfilDTO.getPerfilVOs());
		return usuarioDTO;
	}

	@Command
	@NotifyChange({ "usuarioVOs" })
	public void readWithFilters() {
		UsuarioBO usuarioBO = new UsuarioBO();
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		UsuarioVO usuarioVO = new UsuarioVO();		
		usuarioVO.setNombreUsuario(nombreUsuario.getValue().isEmpty()?null:"%"+nombreUsuario.getValue().toUpperCase()+"%");
		usuarioVO.setIdCveUsuario(identificadorUsuario.getValue().isEmpty()?null:"%"+identificadorUsuario.getValue().toUpperCase()+"%");
		usuarioVO.setIdPerfil(Integer.parseInt(idPerfil.getValue().isEmpty()?"0":idPerfil.getValue()));
		usuarioVO.setEstatusUsuario(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
		usuarioDTO.setUsuarioVO(usuarioVO);
		usuarioDTO.toString(BbvaAbstractDataTransferObject.XML);		
		usuarioDTO = usuarioBO.readCommand(usuarioDTO);
		logger.debug("size:"+usuarioDTO.getUsuarioVOs().size());
		usuarioVOs = usuarioDTO.getUsuarioVOs();
		
	}
	
	@Override
	@Command
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Command
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Command
	public void save() {
		boolean errorGuardar = false;
		if (perfilesDisponibles.getSelectedItem() == null
				|| perfilesDisponibles.getSelectedItem().getValue() == null
				|| perfilesDisponibles.getSelectedItem().getValue().toString().isEmpty()) {
			idPerfil = perfilesDisponibles.getSelectedItem().getValue();
			perfilesDisponibles.setErrorMessage("Favor de seleccionar el perfil.");
			errorGuardar = true;
		}
		if (nombreUsuario.getValue().isEmpty()) {
			nombreUsuario
					.setErrorMessage("Favor de introducir nombre del Usuaruio del Objeto");
			errorGuardar = true;
		} 
		if (identificadorUsuario.getValue().isEmpty()) {
			identificadorUsuario
					.setErrorMessage("Favor de introducir Identificador del Usuario del Objeto");
			errorGuardar = true;
		}
		if(!errorGuardar){
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			UsuarioVO usuarioVO = new UsuarioVO();
			usuarioVO.setEstatusUsuario( status.getSelectedIndex() );
			usuarioVO.setIdCveUsuario( identificadorUsuario.getValue() );
			usuarioVO.setIdPerfil( perfilesDisponibles.getSelectedIndex());
			usuarioVO.setNombreUsuario( nombreUsuario.getValue() );
			usuarioDTO.setUsuarioVO(usuarioVO);
			usuarioDTO.toString(BbvaAbstractDataTransferObject.XML);
		}
		
	}

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
	}

	@Command
	public void readSelected(@BindingParam("idCveUsuario") final UsuarioVO usuarioVO){
		usuarioVO.toString();
		
		perfilesDisponibles.setValue(usuarioVO.getDescripcionPerfil()); 
		status.setValue(usuarioVO.getNombreEstatusObjeto());
		idPerfil.setValue(Integer.toString(usuarioVO.getIdPerfil()));
		idEstatusObjeto.setValue(Integer.toString(usuarioVO.getEstatusUsuario()));
		identificadorUsuario.setValue(usuarioVO.getIdCveUsuario());
		nombreUsuario.setValue(usuarioVO.getNombreUsuario());
		
	}
	
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
    }

	/**
	 * @return the usuarioDTO
	 */
	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	/**
	 * @param usuarioDTO the usuarioDTO to set
	 */
	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	/**
	 * @return the perfilesDisponibles
	 */
	public Combobox getPerfilesDisponibles() {
		return perfilesDisponibles;
	}

	/**
	 * @param perfilesDisponibles the perfilesDisponibles to set
	 */
	public void setPerfilesDisponibles(Combobox perfilesDisponibles) {
		this.perfilesDisponibles = perfilesDisponibles;
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
	 * @return the idPerfil
	 */
	public Textbox getIdPerfil() {
		return idPerfil;
	}

	/**
	 * @param idPerfil the idPerfil to set
	 */
	public void setIdPerfil(Textbox idPerfil) {
		this.idPerfil = idPerfil;
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
	 * @return the identificadorUsuario
	 */
	public Textbox getIdentificadorUsuario() {
		return identificadorUsuario;
	}

	/**
	 * @param identificadorUsuario the identificadorUsuario to set
	 */
	public void setIdentificadorUsuario(Textbox identificadorUsuario) {
		this.identificadorUsuario = identificadorUsuario;
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
	
}
