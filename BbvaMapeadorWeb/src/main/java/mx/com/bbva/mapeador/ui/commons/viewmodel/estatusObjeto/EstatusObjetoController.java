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
import org.zkoss.zk.ui.select.SelectorComposer;
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
import mx.com.bbva.mapeador.security.session.user.SessionUser;
import mx.com.bbva.mapeador.ui.commons.controller.IController;

public class EstatusObjetoController extends SelectorComposer<Component> implements IController{
	private static final Logger logger = Logger.getLogger(EstatusObjetoController.class);

	private static final long serialVersionUID = 1L;
	
	public SessionUser getSessionUser(){
		logger.debug( "Entrada getSessionUser          -- OK" );		
		String cveUsuario = null;
		logger.debug( "Datos de usuario -- " + cveUsuario);
		SessionUser sessionUser = new SessionUser();
		sessionUser.setCveUsuario(cveUsuario);
		logger.debug( "Salida getSessionUser          -- OK" );
		return sessionUser;
	}
	
	@Wire
	private Textbox descripcionEstatusObjeto;		

	private EstatusObjetoDTO estatusObjetoDTO = (EstatusObjetoDTO)this.read();;  
	
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
		
	List<EstatusObjetoVO> estatusObjetoVOs = estatusObjetoDTO.getEstatusObjetoVOs();
	
	/**
	 * @return the estatusObjetoVOs
	 */
	public final List<EstatusObjetoVO> getEstatusObjetoVOs() {
		return estatusObjetoVOs;
	}

	/**
	 * @param estatusObjetoVOs the estatusObjetoVOs to set
	 */
	public final void setEstatusObjetoVOs(List<EstatusObjetoVO> estatusObjetoVOs) {
		this.estatusObjetoVOs = estatusObjetoVOs;
	}

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
	public String getStrDescripcionEstatusObjeto() {
		return strDescripcionEstatusObjeto;
	}

	/**
	 * @return the strIdEstatusClave
	 */
	public String getStrIdEstatusClave() {
		return strIdEstatusClave;
	}

	/**
	 * @return the strIdEstatusObjeto
	 */
	public String getStrIdEstatusObjeto() {
		return strIdEstatusObjeto;
	}

	/**
	 * @return the strIdPantalla
	 */
	public String getStrIdPantalla() {
		return strIdPantalla;
	}
	
	/**
	 * @return the strNombreEstatusObjeto
	 */
	public String getStrNombreEstatusObjeto() {
		return strNombreEstatusObjeto;
	}
		
	/**
	 * @return the strPantallas
	 */
	public String getStrPantallas() {
		return strPantallas;
	}
	
	/**
	 * @return the strStatusClave
	 */
	public String getStrStatusClave() {
		return strStatusClave;
	}
	@Command
	@NotifyChange({ "estatusObjetoVOs" })
	public void readWithFilters() {
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();		
		estatusObjetoVO.setDescripcionEstatusObjeto(descripcionEstatusObjeto.getValue().isEmpty()?"%":"%"+descripcionEstatusObjeto.getValue().toUpperCase()+"%");
		estatusObjetoVO.setNombreTabla(pantallas.getValue().isEmpty()?null:"%"+pantallas.getValue().toUpperCase()+"%");
		estatusObjetoVO.setNombreEstatusObjeto(nombreEstatusObjeto.getValue().isEmpty()?"%":"%"+nombreEstatusObjeto.getValue().toUpperCase()+"%");
		estatusObjetoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusClave.getValue().isEmpty()?"0":idEstatusClave.getValue()));
		estatusObjetoDTO.setCommandId(1);
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
		estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);		
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
		logger.debug("size:"+estatusObjetoDTO.getEstatusObjetoVOs().size());
		estatusObjetoVOs = estatusObjetoDTO.getEstatusObjetoVOs();
		
	}
	
	
	
	@Override	
	public Object read() {
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();				
		estatusObjetoVO.setDescripcionEstatusObjeto(strDescripcionEstatusObjeto==null?"%":"%"+strDescripcionEstatusObjeto.toUpperCase()+"%");
		logger.debug("getDescripcionEstatusObjeto:"+estatusObjetoVO.getDescripcionEstatusObjeto());
		estatusObjetoVO.setNombreTabla(strPantallas==null?null:"%"+strPantallas.toUpperCase()+"%");
		estatusObjetoVO.setNombreEstatusObjeto(strNombreEstatusObjeto==null?"%":"%"+strNombreEstatusObjeto.toUpperCase()+"%");
		estatusObjetoVO.setIdEstatusObjeto(Integer.parseInt(strIdEstatusClave==null?"0":strIdEstatusClave));
		logger.debug("*estatusObjetoVO*");
		estatusObjetoVO.toString();
//		estatusObjetoDTO.setCommandId(1);
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
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
	public void setStrDescripcionEstatusObjeto(
			String strDescripcionEstatusObjeto) {
		this.strDescripcionEstatusObjeto = strDescripcionEstatusObjeto;
	}

	/**
	 * @param strIdEstatusClave the strIdEstatusClave to set
	 */
	public void setStrIdEstatusClave(String strIdEstatusClave) {
		this.strIdEstatusClave = strIdEstatusClave;
	}

	/**
	 * @param strIdEstatusObjeto the strIdEstatusObjeto to set
	 */
	public void setStrIdEstatusObjeto(String strIdEstatusObjeto) {
		this.strIdEstatusObjeto = strIdEstatusObjeto;
	}

	/**
	 * @param strIdPantalla the strIdPantalla to set
	 */
	public void setStrIdPantalla(String strIdPantalla) {
		this.strIdPantalla = strIdPantalla;
	}

	/**
	 * @param strNombreEstatusObjeto the strNombreEstatusObjeto to set
	 */
	public void setStrNombreEstatusObjeto(String strNombreEstatusObjeto) {
		this.strNombreEstatusObjeto = strNombreEstatusObjeto;
	}

	/**
	 * @param strPantallas the strPantallas to set
	 */
	public void setStrPantallas(String strPantallas) {
		this.strPantallas = strPantallas;
	}
	
	/**
	 * @param strStatusClave the strStatusClave to set
	 */
	public void setStrStatusClave(String strStatusClave) {
		this.strStatusClave = strStatusClave;
	}
	
}
