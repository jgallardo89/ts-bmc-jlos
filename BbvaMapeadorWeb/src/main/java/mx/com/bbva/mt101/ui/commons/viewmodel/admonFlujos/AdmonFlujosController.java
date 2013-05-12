package mx.com.bbva.mt101.ui.commons.viewmodel.admonFlujos;

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

import mx.com.bbva.bancomer.bussinnes.model.vo.FlujoVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.flujo.dto.FlujoDTO;
import mx.com.bbva.bancomer.mapper.business.FlujoBO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.utils.StringUtil;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

/**
 * @author Julio Morales
 *
 */
public class AdmonFlujosController extends ControllerSupport implements IController {

	private static final long serialVersionUID = 671034870906549704L;
	
	@Wire
	private Textbox idFlujo;
	@Wire
	private Textbox nombreFlujo;
	@Wire
	private Textbox descripcionFlujo;
	@Wire
	private Textbox idEstatusObjeto;
	@Wire
	private Combobox statusObjeto;
	
	private boolean flagBtnGuardar;
	private FlujoDTO flujoDTO;
	private List<FlujoVO> flujoVOs;
	
	public AdmonFlujosController() {
		this.read();
		this.flujoVOs = flujoDTO.getFlujoVOs();
		flagBtnGuardar = true;
	}

	@Override
	public Object read() {
		flujoDTO = new FlujoDTO();
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
	    estatusObjetoDTO.setCommandId(2);
	    estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
	    flujoDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
	    
		FlujoBO FlujoBO = new FlujoBO();
		FlujoBO.readCommand(flujoDTO);
		return flujoDTO;
	}

	@Command
	@NotifyChange({ "flujoVOs" })
	public void readWithFilters() {
		FlujoDTO flujoDTO = new FlujoDTO();
		FlujoVO flujoVO = new FlujoVO();
		flujoVO.setNombreFlujo(StringUtil.validaLike(nombreFlujo.getValue()));
		flujoVO.setDescripcionFlujo(StringUtil.validaLike(descripcionFlujo.getValue()));
		flujoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
		flujoVO.toString();
		flujoDTO.setFlujoVO(flujoVO);
		FlujoBO FlujoBO = new FlujoBO();
		flujoVOs = FlujoBO.readCommand(flujoDTO).getFlujoVOs();
	}
	
	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Command
	@NotifyChange({ "flujoVOs","flagBtnGuardar" })
	public void save() {
		FlujoBO flujoBO = new FlujoBO();
		boolean errorGuardar = false;
		if (statusObjeto.getSelectedItem() == null
				|| statusObjeto.getSelectedItem().getValue() == null
				|| statusObjeto.getSelectedItem().getValue().toString().isEmpty()) {
			statusObjeto.setErrorMessage("Favor de seleccionar el Estatus");
			errorGuardar = true;
		}
		if (nombreFlujo.getValue().isEmpty()) {
			nombreFlujo
					.setErrorMessage("Favor de introducir el nombre del Flujo");
			errorGuardar = true;
		}
		if (descripcionFlujo.getValue().isEmpty()) {
			descripcionFlujo
					.setErrorMessage("Favor de introducir la descripción del Flujo");
			errorGuardar = true;
		}
		if(!errorGuardar && !idFlujo.getValue().isEmpty()){
			FlujoDTO FlujoDTO = new FlujoDTO();
			FlujoVO flujoVO = new FlujoVO();
			flujoVO.setNombreFlujo(nombreFlujo.getValue().toUpperCase());
			flujoVO.setDescripcionFlujo(descripcionFlujo.getValue().toUpperCase());
			flujoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
			flujoVO.setIdFlujo(Integer.parseInt(idFlujo.getValue()));
			flujoDTO.setFlujoVO(flujoVO);
			flujoBO.updateCommand(flujoDTO);
			FlujoDTO.toString(BbvaAbstractDataTransferObject.XML);
			clean();
			flujoVO.setNombreFlujo(StringUtil.validaLike(nombreFlujo.getValue()));
			flujoVO.setDescripcionFlujo(StringUtil.validaLike(descripcionFlujo.getValue()));
			flujoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
			flujoVO.toString();
			FlujoDTO.setFlujoVO(flujoVO);
			flujoVOs = flujoBO.readCommand(FlujoDTO).getFlujoVOs();
		}
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Command
	@NotifyChange({"flagBtnGuardar"})
	public void clean() {
		nombreFlujo.clearErrorMessage();
		descripcionFlujo.clearErrorMessage();
		statusObjeto.clearErrorMessage();
		
		nombreFlujo.setValue(null);
		descripcionFlujo.setValue(null);
		statusObjeto.setValue(null);
		
		idFlujo.setValue(null);
		idEstatusObjeto.setValue(null);
		setFlagBtnGuardar(true);
	}
	
	@Command
	@NotifyChange({"flagBtnGuardar"})
	public void readSelected(@BindingParam("idFlujo") final FlujoVO flujoVO){
		flujoVO.toString();
		nombreFlujo.setValue(flujoVO.getNombreFlujo());
		descripcionFlujo.setValue(flujoVO.getDescripcionFlujo());
		statusObjeto.setValue(flujoVO.getNombreEstatusObjeto());
		idFlujo.setValue(Integer.toString(flujoVO.getIdFlujo()));
		idEstatusObjeto.setValue(Integer.toString(flujoVO.getIdEstatusObjeto()));
		
		setFlagBtnGuardar(false);
	}
	
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
    }

	/**
	 * @return the flagBtnGuardar
	 */
	public boolean isFlagBtnGuardar() {
		return flagBtnGuardar;
	}

	/**
	 * @param flagBtnGuardar the flagBtnGuardar to set
	 */
	public void setFlagBtnGuardar(boolean flagBtnGuardar) {
		this.flagBtnGuardar = flagBtnGuardar;
	}

	/**
	 * @return the flujoDTO
	 */
	public FlujoDTO getFlujoDTO() {
		return flujoDTO;
	}

	/**
	 * @param flujoDTO the flujoDTO to set
	 */
	public void setFlujoDTO(FlujoDTO flujoDTO) {
		this.flujoDTO = flujoDTO;
	}

	/**
	 * @return the flujoVOs
	 */
	public List<FlujoVO> getFlujoVOs() {
		return flujoVOs;
	}

	/**
	 * @param flujoVOs the flujoVOs to set
	 */
	public void setFlujoVOs(List<FlujoVO> flujoVOs) {
		this.flujoVOs = flujoVOs;
	}

}
