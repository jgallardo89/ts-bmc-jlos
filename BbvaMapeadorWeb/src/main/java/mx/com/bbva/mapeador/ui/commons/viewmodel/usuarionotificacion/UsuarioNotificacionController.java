package mx.com.bbva.mapeador.ui.commons.viewmodel.usuarionotificacion;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioNotificacionVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.UsuarioNotificacionBO;
import mx.com.bbva.bancomer.usuarionotificacion.dto.UsuarioNotificacionDTO;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
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
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;

public class UsuarioNotificacionController  extends ControllerSupport implements IController{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7183766729268869941L;
	private static final Logger logger = Logger.getLogger(UsuarioNotificacionController.class);
	@Wire
	private Textbox nombreUsuario;
	
	@Wire
	private Textbox email;
	
	@Wire
	private Combobox status;
	
	@Wire
	private Textbox idEstatusObjeto;
	
	@Wire
	private Textbox idUsuarioNotificado;
	
	private UsuarioNotificacionDTO	usuarioNotificacionDTO = (UsuarioNotificacionDTO)this.read();	
	
	private List<UsuarioNotificacionVO> usuarioNotificacionVOs = usuarioNotificacionDTO.getUsuarioNotificacionVOs();
	
	private String strIdUsuarioNotificado; 
	
	private String strIdEstatusObjeto; 
	
	private String strNombreUsuario;

	private String strEmail;
	
	private String strStatus;

	@Override
	public Object read() {
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
		return usuarioNotificacionDTO;
	}

	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
    }
	
	@Command
	public void readSelected(@BindingParam("idUsuarioNotificado") final UsuarioNotificacionVO usuarioNotificacionVO){
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

		usuarioNotificacionDTO.setUsuarioNotificacionVO(usuarioNotificacionVO);
		usuarioNotificacionDTO.toString(BbvaAbstractDataTransferObject.XML);	
		
		//LLamada a BO  UsuarioNotificacion para consulta por criterio
		UsuarioNotificacionBO usuarioNotificacionBO = new UsuarioNotificacionBO();
		
		//Asignacion resultado de consulta al mismo DTO de UsuarioNotificacion
		usuarioNotificacionDTO = usuarioNotificacionBO.readCommand(usuarioNotificacionDTO);
		
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
		if(!errorGuardar){
			if(!idUsuarioNotificado.getValue().isEmpty()){
				logger.info("::::::Actualizar::::");
				UsuarioNotificacionDTO usuarioNotificacionDTO = new UsuarioNotificacionDTO();
				UsuarioNotificacionVO usuarioNotificacionVO = new UsuarioNotificacionVO();
				usuarioNotificacionVO.setIdUsuarioNotificado(Integer.parseInt(idUsuarioNotificado.getValue().isEmpty()?"0":idUsuarioNotificado.getValue()));
				usuarioNotificacionVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"1":idEstatusObjeto.getValue()));
				
				usuarioNotificacionVO.setNombreUsuarioNotificado(nombreUsuario.getValue().toUpperCase());
				usuarioNotificacionVO.setDescripcionEmail(email.getValue().toUpperCase());
							
				//Seteo de VO a DTO 
				usuarioNotificacionDTO.setUsuarioNotificacionVO(usuarioNotificacionVO);
				usuarioNotificacionDTO.toString(BbvaAbstractDataTransferObject.XML);	
				
				UsuarioNotificacionBO UsuarioNotificacionBO = new UsuarioNotificacionBO();
				UsuarioNotificacionBO.updateCommand(usuarioNotificacionDTO);
				clean();			
				
				//Textbox
				usuarioNotificacionVO.setNombreUsuarioNotificado(nombreUsuario.getValue().isEmpty()?"%":"%"+nombreUsuario.getValue().toUpperCase()+"%");
				usuarioNotificacionVO.setDescripcionEmail(email.getValue().isEmpty()?"%":"%"+email.getValue().toUpperCase()+"%");
				
				//Combos Validar el nombre de los parametros en HTML VS Controller
				usuarioNotificacionVO.setIdEstatusObjeto((Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue())));

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
			}else{ 
				logger.info("::::::Crear::::");
				UsuarioNotificacionDTO usuarioNotificacionDTO = new UsuarioNotificacionDTO();
				UsuarioNotificacionVO usuarioNotificacionVO = new UsuarioNotificacionVO();
				usuarioNotificacionVO.setIdUsuarioNotificado(Integer.parseInt(idUsuarioNotificado.getValue().isEmpty()?"0":idUsuarioNotificado.getValue()));
				usuarioNotificacionVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"1":idEstatusObjeto.getValue()));
				
				usuarioNotificacionVO.setNombreUsuarioNotificado(nombreUsuario.getValue().toUpperCase());
				usuarioNotificacionVO.setDescripcionEmail(email.getValue().toUpperCase());
							
				//Seteo de VO a DTO 
				usuarioNotificacionDTO.setUsuarioNotificacionVO(usuarioNotificacionVO);
				usuarioNotificacionDTO.toString(BbvaAbstractDataTransferObject.XML);	
				
				UsuarioNotificacionBO UsuarioNotificacionBO = new UsuarioNotificacionBO();

				UsuarioNotificacionBO.createCommand(usuarioNotificacionDTO);
				clean();	
				//Textbox
				usuarioNotificacionVO.setNombreUsuarioNotificado(nombreUsuario.getValue().isEmpty()?"%":"%"+nombreUsuario.getValue().toUpperCase()+"%");
				usuarioNotificacionVO.setDescripcionEmail(email.getValue().isEmpty()?"%":"%"+email.getValue().toUpperCase()+"%");
				
				//Combos Validar el nombre de los parametros en HTML VS Controller
				usuarioNotificacionVO.setIdEstatusObjeto((Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue())));

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

	@Override
	public boolean applyPermision() {
		// TODO Auto-generated method stub
		return false;
	}

}
