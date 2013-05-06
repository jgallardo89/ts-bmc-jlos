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

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusClaveVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PantallaVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

public class EstatusObjetoController extends ControllerSupport implements IController{
	private static final Logger logger = Logger.getLogger(EstatusObjetoController.class);

	private static final long serialVersionUID = 1L;
	
	
	@Wire
	private Textbox descripcionEstatusObjeto;		

	private EstatusObjetoDTO estatusObjetoDTO = (EstatusObjetoDTO)this.read();
	
	@Wire
	private Textbox idEstatusClave;
	
	@Wire
	private Textbox idEstatusObjeto;
	
	@Wire
	private Textbox idPantalla;
	
	@Wire
	private Textbox nombreEstatusObjeto;
	
	@Wire
	private Combobox pantallas;
	@Wire
	private Combobox statusClave;
		
	private String strDescripcionEstatusObjeto;
	
	private String strIdEstatusClave;

	private String strIdEstatusObjeto;

	private String strIdPantalla;

	private String strNombreEstatusObjeto;

	private String strPantallas;

	private String strStatusClave;

	public EstatusObjetoController() {
		super();
	}

	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
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

	@Override
	public void delete() {
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
		estatusObjetoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
		estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);	
	}

	/**
	 * @return the estatusObjetoDTO
	 */
	public EstatusObjetoDTO getEstatusObjetoDTO() {
		return estatusObjetoDTO;
	}

	/**
	 * @return the strDescripcionEstatusObjeto
	 */
	public final String getStrDescripcionEstatusObjeto() {
		return strDescripcionEstatusObjeto;
	}

	/**
	 * @return the strIdEstatusClave
	 */
	public final String getStrIdEstatusClave() {
		return strIdEstatusClave;
	}

	/**
	 * @return the strIdEstatusObjeto
	 */
	public final String getStrIdEstatusObjeto() {
		return strIdEstatusObjeto;
	}

	/**
	 * @return the strIdPantalla
	 */
	public final String getStrIdPantalla() {
		return strIdPantalla;
	}
	
	/**
	 * @return the strNombreEstatusObjeto
	 */
	public final String getStrNombreEstatusObjeto() {
		return strNombreEstatusObjeto;
	}
		
	/**
	 * @return the strPantallas
	 */
	public final String getStrPantallas() {
		return strPantallas;
	}
	
	/**
	 * @return the strStatusClave
	 */
	public final String getStrStatusClave() {
		return strStatusClave;
	}
	
	@Override
	@Command
	public Object read() {
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
		logger.debug(descripcionEstatusObjeto.getValue());
		estatusObjetoVO.setDescripcionEstatusObjeto(strDescripcionEstatusObjeto==null?"%":"%"+strDescripcionEstatusObjeto.toUpperCase()+"%");
		estatusObjetoVO.setNombreTabla(pantallas.getValue()==null?null:"%"+strPantallas.toUpperCase()+"%");
		estatusObjetoVO.setNombreEstatusObjeto(nombreEstatusObjeto.getValue()==null?"%":"%"+nombreEstatusObjeto.getValue().toUpperCase()+"%");
		estatusObjetoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusClave.getValue()==null?"0":idEstatusClave.getValue()));
//		estatusObjetoDTO.setCommandId(1);
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
//		List<PantallaVO> pantallaVOs = new  ArrayList<PantallaVO>();		
//		PantallaVO pantallaVO = new PantallaVO();
//		pantallaVO.setIdPantalla(1);
//		pantallaVO.setNombrePantalla("Estatus Objeto");
//		pantallaVOs.add(pantallaVO);
//		pantallaVO = new PantallaVO();
//		pantallaVO.setIdPantalla(2);
//		pantallaVO.setNombrePantalla("Usuario Mapeador");
//		pantallaVOs.add(pantallaVO);
//		estatusObjetoDTO.setPantallaVOs(pantallaVOs);
//		
//		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
//		estatusObjetoVO.setNombreEstatusObjeto("Activo");
//		
//		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
//
//		List<EstatusClaveVO> estatusClaveVOs = new ArrayList<EstatusClaveVO>();
//		EstatusClaveVO estatusClaveVO = new EstatusClaveVO();
//		estatusClaveVO.setIdEstatusClave(1);
//		estatusClaveVO.setNombreEstatusClave("Activo");
//		estatusClaveVOs.add(estatusClaveVO);
//		estatusClaveVO = new EstatusClaveVO();
//		estatusClaveVO.setIdEstatusClave(2);
//		estatusClaveVO.setNombreEstatusClave("Inactivo");
//		estatusClaveVOs.add(estatusClaveVO);
//		
//		estatusObjetoDTO.setEstatusClaveVOs(estatusClaveVOs);
//		
//		List<EstatusObjetoVO> estatusObjetoVOs = new ArrayList<EstatusObjetoVO>();
//		estatusObjetoVO = new EstatusObjetoVO();
//		estatusObjetoVO.setDescripcionEstatusObjeto("Activo para pantalla 1");
//		estatusObjetoVO.setIdEstatusClave(1);
//		estatusObjetoVO.setIdEstatusObjeto(1);
//		estatusObjetoVO.setNombreEstatusObjeto("Activo");
//		estatusObjetoVO.setNombreStatusClave("Activo");
//		estatusObjetoVO.setNombreTabla("Usuario");
//		
//		estatusObjetoVOs.add(estatusObjetoVO);
//		
//		estatusObjetoVO = new EstatusObjetoVO();
//		estatusObjetoVO.setDescripcionEstatusObjeto("Inactivo para pantalla 1");
//		estatusObjetoVO.setIdEstatusClave(2);
//		estatusObjetoVO.setIdEstatusObjeto(2);
//		estatusObjetoVO.setNombreEstatusObjeto("Inactivo");
//		estatusObjetoVO.setNombreStatusClave("Inactivo");
//		estatusObjetoVO.setNombreTabla("Usuario");
//		
//		estatusObjetoVOs.add(estatusObjetoVO);
//		
//		estatusObjetoDTO.setEstatusObjetoVOs(estatusObjetoVOs);
		
		return estatusObjetoDTO;
	}
	
	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Command
	public void readSelected(@BindingParam("idEstatusObjeto") final EstatusObjetoVO estatusObjetoVO){
		estatusObjetoVO.toString();
		pantallas.setValue(estatusObjetoVO.getNombreTabla());
		nombreEstatusObjeto.setValue(estatusObjetoVO.getNombreEstatusObjeto());
		descripcionEstatusObjeto.setValue(estatusObjetoVO.getDescripcionEstatusObjeto());
		statusClave.setValue(estatusObjetoVO.getNombreStatusClave());
		idEstatusClave.setValue(Integer.toString(estatusObjetoVO.getIdEstatusClave()));
		idPantalla.setValue(estatusObjetoVO.getNombreTabla());
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

	/**
	 * @param estatusObjetoDTO the estatusObjetoDTO to set
	 */
	public void setEstatusObjetoDTO(EstatusObjetoDTO estatusObjetoDTO) {
		this.estatusObjetoDTO = estatusObjetoDTO;
	}
	/**
	 * @param strDescripcionEstatusObjeto the strDescripcionEstatusObjeto to set
	 */
	public final void setStrDescripcionEstatusObjeto(
			String strDescripcionEstatusObjeto) {
		this.strDescripcionEstatusObjeto = strDescripcionEstatusObjeto;
	}

	/**
	 * @param strIdEstatusClave the strIdEstatusClave to set
	 */
	public final void setStrIdEstatusClave(String strIdEstatusClave) {
		this.strIdEstatusClave = strIdEstatusClave;
	}

	/**
	 * @param strIdEstatusObjeto the strIdEstatusObjeto to set
	 */
	public final void setStrIdEstatusObjeto(String strIdEstatusObjeto) {
		this.strIdEstatusObjeto = strIdEstatusObjeto;
	}

	/**
	 * @param strIdPantalla the strIdPantalla to set
	 */
	public final void setStrIdPantalla(String strIdPantalla) {
		this.strIdPantalla = strIdPantalla;
	}

	/**
	 * @param strNombreEstatusObjeto the strNombreEstatusObjeto to set
	 */
	public final void setStrNombreEstatusObjeto(String strNombreEstatusObjeto) {
		this.strNombreEstatusObjeto = strNombreEstatusObjeto;
	}

	/**
	 * @param strPantallas the strPantallas to set
	 */
	public final void setStrPantallas(String strPantallas) {
		this.strPantallas = strPantallas;
	}
	
	/**
	 * @param strStatusClave the strStatusClave to set
	 */
	public final void setStrStatusClave(String strStatusClave) {
		this.strStatusClave = strStatusClave;
	}
	
}
