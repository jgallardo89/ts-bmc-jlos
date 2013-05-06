package mx.com.bbva.mapeador.ui.commons.viewmodel.estatusObjeto;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusClaveVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PantallaVO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.PantallaBO;
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
	@Command
	public void delete() {
		logger.debug("Eliminando registro:"+idEstatusObjeto.getValue());
		if(!idEstatusObjeto.getValue().isEmpty()){
			Messagebox.show(
					"¿Está seguro que desea eliminar el estatus?",
					"Pregunta", Messagebox.YES | Messagebox.NO,
					Messagebox.QUESTION, new EventListener<Event>() {
						@Override
						public void onEvent(Event event) throws Exception {
							EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
							EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
							estatusObjetoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
							estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
							EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
							estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);
							estatusObjetoBO.deleteCommand(estatusObjetoDTO);
							clean();
							BindUtils
									.postGlobalCommand(
											null,
											null,
											"resetGridEstatusObjetos",
											null);
						}
					});
		}else{
			Messagebox.show("!Favor de seleccionar el registro a eliminar!",
					"Error", Messagebox.OK,
					Messagebox.ERROR);
		}
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
		estatusObjetoVO.setNombreTabla(pantallas.getValue().isEmpty()?null:pantallas.getValue().toUpperCase());
		estatusObjetoVO.setNombreEstatusObjeto(nombreEstatusObjeto.getValue().isEmpty()?"%":"%"+nombreEstatusObjeto.getValue().toUpperCase()+"%");
		estatusObjetoVO.setIdEstatusClave(Integer.parseInt(idEstatusClave.getValue().isEmpty()?"0":idEstatusClave.getValue()));
		estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
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
		logger.debug("*estatusObjetoVO*");
		estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();				
		estatusObjetoVO.setDescripcionEstatusObjeto(strDescripcionEstatusObjeto==null?"%":"%"+strDescripcionEstatusObjeto.toUpperCase()+"%");
		estatusObjetoVO.setNombreTabla(strPantallas==null?null:"%"+strPantallas.toUpperCase()+"%");
		estatusObjetoVO.setNombreEstatusObjeto(strNombreEstatusObjeto==null?"%":"%"+strNombreEstatusObjeto.toUpperCase()+"%");
		estatusObjetoVO.setIdEstatusObjeto(Integer.parseInt(strIdEstatusClave==null?"0":strIdEstatusClave));		
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
		estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);		
		estatusObjetoDTO.setEstatusObjetoVOs(estatusObjetoBO.readCommand(estatusObjetoDTO).getEstatusObjetoVOs());
		logger.debug("*pantallaVO*");
		PantallaVO pantallaVO = new PantallaVO();
		PantallaBO pantallaBO = new PantallaBO();
		estatusObjetoDTO.setPantallaVO(pantallaVO);
		estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);	
		List<PantallaVO> pantallaVOs = pantallaBO.readCommand(estatusObjetoDTO).getPantallaVOs();
		estatusObjetoDTO.setPantallaVOs(pantallaVOs);
		logger.debug("*estatusClaveVO*");
		estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_CLAVE);
		EstatusClaveVO estatusClaveVO = new EstatusClaveVO();
		estatusObjetoDTO.setEstatusClaveVO(estatusClaveVO);
		List<EstatusClaveVO> estatusClaveVOs = estatusObjetoBO.readCommand(estatusObjetoDTO).getEstatusClaveVOs();
		estatusObjetoDTO.setEstatusClaveVOs(estatusClaveVOs);
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
		idEstatusObjeto.setValue(Integer.toString(estatusObjetoVO.getIdEstatusObjeto()));
	}

	@Override
	@Command
	@NotifyChange({ "estatusObjetoVOs" })
	public void save() {
		boolean errorGuardar = false;
		String nombreTabla = null;
		if (pantallas.getSelectedItem() == null
				|| pantallas.getSelectedItem().getValue() == null
				|| pantallas.getSelectedItem().getValue().toString().isEmpty()) {
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
			if(idEstatusObjeto.getValue().isEmpty()){
				nombreTabla = pantallas.getSelectedItem().getLabel().toUpperCase();
				EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
				EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
				estatusObjetoVO.setDescripcionEstatusObjeto(descripcionEstatusObjeto.getValue().toUpperCase());
				estatusObjetoVO.setIdEstatusClave(Integer.parseInt(idEstatusClave.getValue()));
				estatusObjetoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
				estatusObjetoVO.setNombreEstatusObjeto(nombreEstatusObjeto.getValue().toUpperCase());
				estatusObjetoVO.setNombreTabla(nombreTabla);
				estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
				estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);
				EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
				estatusObjetoBO.createCommand(estatusObjetoDTO);
				clean();			
				logger.debug("*estatusObjetoVO*");
				estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
				estatusObjetoVO = new EstatusObjetoVO();				
				estatusObjetoVO.setDescripcionEstatusObjeto(strDescripcionEstatusObjeto==null?"%":"%"+strDescripcionEstatusObjeto.toUpperCase()+"%");
				estatusObjetoVO.setNombreTabla(strPantallas==null?null:"%"+strPantallas.toUpperCase()+"%");
				estatusObjetoVO.setNombreEstatusObjeto(strNombreEstatusObjeto==null?"%":"%"+strNombreEstatusObjeto.toUpperCase()+"%");
				estatusObjetoVO.setIdEstatusObjeto(Integer.parseInt(strIdEstatusClave==null?"0":strIdEstatusClave));		
				estatusObjetoBO = new EstatusObjetoBO();
				estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
				estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);		
				estatusObjetoDTO.setEstatusObjetoVOs(estatusObjetoBO.readCommand(estatusObjetoDTO).getEstatusObjetoVOs());
				estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
				estatusObjetoVOs = estatusObjetoBO.readCommand(estatusObjetoDTO).getEstatusObjetoVOs();
				Messagebox.show("Registro actualizado con exito!!",
						"Confirmación", Messagebox.OK,
						Messagebox.INFORMATION);
			}else{
				nombreTabla = pantallas.getSelectedItem().getLabel().toUpperCase();
				EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
				EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
				estatusObjetoVO.setDescripcionEstatusObjeto(descripcionEstatusObjeto.getValue().toUpperCase());
				estatusObjetoVO.setIdEstatusClave(Integer.parseInt(idEstatusClave.getValue()));
				estatusObjetoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
				estatusObjetoVO.setNombreEstatusObjeto(nombreEstatusObjeto.getValue().toUpperCase());
				estatusObjetoVO.setNombreTabla(nombreTabla);
				estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
				estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);
				EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
				estatusObjetoBO.updateCommand(estatusObjetoDTO);
				clean();			
				logger.debug("*estatusObjetoVO*");
				estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
				estatusObjetoVO = new EstatusObjetoVO();				
				estatusObjetoVO.setDescripcionEstatusObjeto(strDescripcionEstatusObjeto==null?"%":"%"+strDescripcionEstatusObjeto.toUpperCase()+"%");
				estatusObjetoVO.setNombreTabla(strPantallas==null?null:"%"+strPantallas.toUpperCase()+"%");
				estatusObjetoVO.setNombreEstatusObjeto(strNombreEstatusObjeto==null?"%":"%"+strNombreEstatusObjeto.toUpperCase()+"%");
				estatusObjetoVO.setIdEstatusObjeto(Integer.parseInt(strIdEstatusClave==null?"0":strIdEstatusClave));		
				estatusObjetoBO = new EstatusObjetoBO();
				estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
				estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);		
				estatusObjetoDTO.setEstatusObjetoVOs(estatusObjetoBO.readCommand(estatusObjetoDTO).getEstatusObjetoVOs());
				estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
				estatusObjetoVOs = estatusObjetoBO.readCommand(estatusObjetoDTO).getEstatusObjetoVOs();
				Messagebox.show("Registro actualizado con exito!!",
						"Confirmación", Messagebox.OK,
						Messagebox.INFORMATION);
			}
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
	@GlobalCommand("resetGridEstatusObjetos")
	@NotifyChange({ "estatusObjetoVOs" })
	public void resetGrid() {
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();		
		estatusObjetoVO.setDescripcionEstatusObjeto(descripcionEstatusObjeto.getValue().isEmpty()?"%":"%"+descripcionEstatusObjeto.getValue().toUpperCase()+"%");
		estatusObjetoVO.setNombreTabla(pantallas.getValue().isEmpty()?null:pantallas.getValue().toUpperCase());
		estatusObjetoVO.setNombreEstatusObjeto(nombreEstatusObjeto.getValue().isEmpty()?"%":"%"+nombreEstatusObjeto.getValue().toUpperCase()+"%");
		estatusObjetoVO.setIdEstatusClave(Integer.parseInt(idEstatusClave.getValue().isEmpty()?"0":idEstatusClave.getValue()));
		estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
		estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);		
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
		logger.debug("size:"+estatusObjetoDTO.getEstatusObjetoVOs().size());
		estatusObjetoVOs = estatusObjetoDTO.getEstatusObjetoVOs();
		//operacionesDudosasGrid.invalidate();
	}
}
