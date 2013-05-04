package mx.com.bbva.mapeador.ui.commons.viewmodel.estatusObjeto;

import java.util.ArrayList;
import java.util.List;

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

import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.commons.model.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.commons.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.commons.model.vo.EstatusClaveVO;
import mx.com.bbva.bancomer.commons.model.vo.PantallaVO;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

public class EstatusObjetoController extends ControllerSupport implements IController{
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(EstatusObjetoController.class);
	
	
	private EstatusObjetoDTO estatusObjetoDTO = (EstatusObjetoDTO)this.read();		

	@Wire
	private Combobox pantallas;
	
	@Wire
	private Textbox nombreEstatusObjeto;
	
	@Wire
	private Textbox descripcionEstatusObjeto;
	
	@Wire
	private Combobox statusClave;
	
	@Wire
	private Textbox idPantalla;
	
	@Wire
	private Textbox idEstatusClave;
	@Wire
	private Textbox idEstatusObjeto;
	
	/**
	 * @return the estatusObjetoDTO
	 */
	public EstatusObjetoDTO getEstatusObjetoDTO() {
		return estatusObjetoDTO;
	}

	/**
	 * @param estatusObjetoDTO the estatusObjetoDTO to set
	 */
	public void setEstatusObjetoDTO(EstatusObjetoDTO estatusObjetoDTO) {
		this.estatusObjetoDTO = estatusObjetoDTO;
	}

	public EstatusObjetoController() {
		super();
	}
	@Override
	public Object read() {
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		List<PantallaVO> pantallaVOs = new  ArrayList<PantallaVO>();		
		PantallaVO pantallaVO = new PantallaVO();
		pantallaVO.setIdPantalla(1);
		pantallaVO.setNombrePantalla("Estatus Objeto");
		pantallaVOs.add(pantallaVO);
		pantallaVO = new PantallaVO();
		pantallaVO.setIdPantalla(2);
		pantallaVO.setNombrePantalla("Usuario Mapeador");
		pantallaVOs.add(pantallaVO);
		estatusObjetoDTO.setPantallaVOs(pantallaVOs);
		
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
		estatusObjetoVO.setNombreEstatusObjeto("Activo");
		
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);

		List<EstatusClaveVO> estatusClaveVOs = new ArrayList<EstatusClaveVO>();
		EstatusClaveVO estatusClaveVO = new EstatusClaveVO();
		estatusClaveVO.setIdEstatusClave(1);
		estatusClaveVO.setNombreEstatusClave("Activo");
		estatusClaveVOs.add(estatusClaveVO);
		estatusClaveVO = new EstatusClaveVO();
		estatusClaveVO.setIdEstatusClave(2);
		estatusClaveVO.setNombreEstatusClave("Inactivo");
		estatusClaveVOs.add(estatusClaveVO);
		
		estatusObjetoDTO.setEstatusClaveVOs(estatusClaveVOs);
		
		List<EstatusObjetoVO> estatusObjetoVOs = new ArrayList<EstatusObjetoVO>();
		estatusObjetoVO = new EstatusObjetoVO();
		estatusObjetoVO.setDescripcionEstatusObjeto("Activo para pantalla 1");
		estatusObjetoVO.setIdEstatusClave(1);
		estatusObjetoVO.setIdEstatusObjeto(1);
		estatusObjetoVO.setNombreEstatusObjeto("Activo");
		estatusObjetoVO.setNombreStatusClave("Activo");
		estatusObjetoVO.setNombreTabla("Usuario");
		
		estatusObjetoVOs.add(estatusObjetoVO);
		
		estatusObjetoVO = new EstatusObjetoVO();
		estatusObjetoVO.setDescripcionEstatusObjeto("Inactivo para pantalla 1");
		estatusObjetoVO.setIdEstatusClave(2);
		estatusObjetoVO.setIdEstatusObjeto(2);
		estatusObjetoVO.setNombreEstatusObjeto("Inactivo");
		estatusObjetoVO.setNombreStatusClave("Inactivo");
		estatusObjetoVO.setNombreTabla("Usuario");
		
		estatusObjetoVOs.add(estatusObjetoVO);
		
		estatusObjetoDTO.setEstatusObjetoVOs(estatusObjetoVOs);
		
		return estatusObjetoDTO;
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

	@Override
	@Command
	public void save() {
		boolean errorGuardar = false;
		String nombreTabla = null;
		if (pantallas.getSelectedItem() == null
				|| pantallas.getSelectedItem().getValue() == null
				|| pantallas.getSelectedItem().getValue().toString().isEmpty()) {
			nombreTabla = pantallas.getSelectedItem().getValue();
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
		if(!errorGuardar){
			EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
			EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
			estatusObjetoVO.setDescripcionEstatusObjeto(descripcionEstatusObjeto.getValue());
			estatusObjetoVO.setIdEstatusClave(Integer.parseInt(idEstatusClave.getValue()));
			estatusObjetoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
			estatusObjetoVO.setNombreEstatusObjeto(nombreEstatusObjeto.getValue());
			estatusObjetoVO.setNombreTabla(nombreTabla);
			estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
			estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);
		}
		
	}

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
	}

	@Command
	public void readSelected(@BindingParam("idEstatusObjeto") final EstatusObjetoVO estatusObjetoVO){
		estatusObjetoVO.toString();
		pantallas.setValue(estatusObjetoVO.getNombreTabla());
		nombreEstatusObjeto.setValue(estatusObjetoVO.getNombreEstatusObjeto());
		descripcionEstatusObjeto.setValue(estatusObjetoVO.getDescripcionEstatusObjeto());
		statusClave.setValue(estatusObjetoVO.getNombreStatusClave());
		idEstatusClave.setValue(Integer.toString(estatusObjetoVO.getIdEstatusClave()));
		idPantalla.setValue(Integer.toString(estatusObjetoVO.getIdEstatusObjeto()));
	}
	
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
    }
	
}
