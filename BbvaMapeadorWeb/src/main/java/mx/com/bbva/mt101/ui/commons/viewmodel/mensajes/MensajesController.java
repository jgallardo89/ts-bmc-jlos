package mx.com.bbva.mt101.ui.commons.viewmodel.mensajes;

import java.util.List;

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

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MensajeSalidaVO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.MensajeSalidaBO;
import mx.com.bbva.bancomer.mensajesalida.dto.MensajeSalidaDTO;
import mx.com.bbva.bancomer.utils.StringUtil;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

public class MensajesController extends ControllerSupport implements IController {

	private static final long serialVersionUID = 4649691032075701267L;

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
	
	private MensajeSalidaDTO mensajeSalidaDTO;
	private List<MensajeSalidaVO> mensajeSalidaVOs;
	
	public MensajesController() {
		this.read();
		this.mensajeSalidaVOs = mensajeSalidaDTO.getMensajeSalidaVOs();
	}
	
	@Override
	public Object read() {
		mensajeSalidaDTO = new MensajeSalidaDTO();
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
		estatusObjetoVO.setNombreTabla(CommandConstants.NOMBRE_TABLA_MAPA);		
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
	    mensajeSalidaDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
	    
		MensajeSalidaBO MensajeSalidaBO = new MensajeSalidaBO();
		MensajeSalidaBO.readCommand(mensajeSalidaDTO);
		return mensajeSalidaDTO;
	}
	
	@Command
	@NotifyChange({ "mensajeSalidaVOs" })
	public void readWithFilters() {
		MensajeSalidaDTO mensajeSalidaDTO = new MensajeSalidaDTO();
		MensajeSalidaVO mensajeSalidaVO = new MensajeSalidaVO();
		mensajeSalidaVO.setNombreMensajeSalida(StringUtil.validaLike(nombreMensajeSalida.getValue()));
		mensajeSalidaVO.setDescripcionMensajeSalida(StringUtil.validaLike(descripcionMensajeSalida.getValue()));
		mensajeSalidaVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
		mensajeSalidaVO.toString();
		mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
		MensajeSalidaBO mensajeSalidaBO = new MensajeSalidaBO();
		mensajeSalidaVOs = mensajeSalidaBO.readCommand(mensajeSalidaDTO).getMensajeSalidaVOs();
	}

	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Command
	@NotifyChange({ "mensajeSalidaVOs"})
	public void save() {
		MensajeSalidaBO mensajeSalidaBO = new MensajeSalidaBO();
		boolean errorGuardar = false;
		if (statusObjeto.getSelectedItem() == null
				|| statusObjeto.getSelectedItem().getValue() == null
				|| statusObjeto.getSelectedItem().getValue().toString().isEmpty()) {
			statusObjeto.setErrorMessage("Favor de seleccionar el Estatus");
			errorGuardar = true;
		}
		if (nombreMensajeSalida.getValue().isEmpty()) {
			nombreMensajeSalida
					.setErrorMessage("Favor de introducir el nombre del Mensaje de Salida");
			errorGuardar = true;
		}
		if (descripcionMensajeSalida.getValue().isEmpty()) {
			descripcionMensajeSalida
					.setErrorMessage("Favor de introducir la descripción del Mensaje de Salida");
			errorGuardar = true;
		}
		if(!errorGuardar){
			
			if(idMensajeSalida.getValue().isEmpty()) {
				MensajeSalidaDTO mensajeSalidaDTO = new MensajeSalidaDTO();
				MensajeSalidaVO mensajeSalidaVO = new MensajeSalidaVO();
				mensajeSalidaVO.setNombreMensajeSalida(nombreMensajeSalida.getValue().toUpperCase());
				mensajeSalidaVO.setDescripcionMensajeSalida(descripcionMensajeSalida.getValue().toUpperCase());
				mensajeSalidaVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
				//mensajeSalidaVO.setIdMensajeSalida(Integer.parseInt(idMensajeSalida.getValue()));
				mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
				mensajeSalidaBO.createCommand(mensajeSalidaDTO);
				mensajeSalidaDTO.toString(BbvaAbstractDataTransferObject.XML);
				clean();
				mensajeSalidaVO.setNombreMensajeSalida(StringUtil.validaLike(nombreMensajeSalida.getValue()));
				mensajeSalidaVO.setDescripcionMensajeSalida(StringUtil.validaLike(descripcionMensajeSalida.getValue()));
				mensajeSalidaVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
				mensajeSalidaVO.toString();
				mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
				mensajeSalidaVOs = mensajeSalidaBO.readCommand(mensajeSalidaDTO).getMensajeSalidaVOs();
			} else {
				MensajeSalidaDTO mensajeSalidaDTO = new MensajeSalidaDTO();
				MensajeSalidaVO mensajeSalidaVO = new MensajeSalidaVO();
				mensajeSalidaVO.setNombreMensajeSalida(nombreMensajeSalida.getValue().toUpperCase());
				mensajeSalidaVO.setDescripcionMensajeSalida(descripcionMensajeSalida.getValue().toUpperCase());
				mensajeSalidaVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
				mensajeSalidaVO.setIdMensajeSalida(Integer.parseInt(idMensajeSalida.getValue()));
				mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
				mensajeSalidaBO.updateCommand(mensajeSalidaDTO);
				mensajeSalidaDTO.toString(BbvaAbstractDataTransferObject.XML);
				clean();
				mensajeSalidaVO.setNombreMensajeSalida(StringUtil.validaLike(nombreMensajeSalida.getValue()));
				mensajeSalidaVO.setDescripcionMensajeSalida(StringUtil.validaLike(descripcionMensajeSalida.getValue()));
				mensajeSalidaVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
				mensajeSalidaVO.toString();
				mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
				mensajeSalidaVOs = mensajeSalidaBO.readCommand(mensajeSalidaDTO).getMensajeSalidaVOs();
			}
		}
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Command
	public void clean() {
		nombreMensajeSalida.clearErrorMessage();
		descripcionMensajeSalida.clearErrorMessage();
		idEstatusObjeto.clearErrorMessage();
		statusObjeto.clearErrorMessage();
		idMensajeSalida.clearErrorMessage();
		
		nombreMensajeSalida.setValue(null);
		descripcionMensajeSalida.setValue(null);
		idEstatusObjeto.setValue(null);
		statusObjeto.setValue(null);
		idMensajeSalida.setValue(null);
	}
	
	@Command
	public void readSelected(@BindingParam("idMensajeSalida") final MensajeSalidaVO mensajeSalidaVO){
		mensajeSalidaVO.toString();
		nombreMensajeSalida.setValue(mensajeSalidaVO.getNombreMensajeSalida());
		descripcionMensajeSalida.setValue(mensajeSalidaVO.getDescripcionMensajeSalida());
		statusObjeto.setValue(mensajeSalidaVO.getNombreEstatusObjeto());
		idMensajeSalida.setValue(Integer.toString(mensajeSalidaVO.getIdMensajeSalida()));
		idEstatusObjeto.setValue(Integer.toString(mensajeSalidaVO.getIdEstatusObjeto()));
	}
	
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
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

}
