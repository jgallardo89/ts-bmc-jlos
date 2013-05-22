package mx.com.bbva.mapeador.ui.commons.viewmodel.componente;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ComponenteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PantallaVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.TipoComponenteVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.componente.dto.ComponenteDTO;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.ComponenteBO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.PantallaBO;
import mx.com.bbva.bancomer.pantalla.dto.PantallaDTO;
import mx.com.bbva.mapeador.security.session.user.SessionUser;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.pantalla.PantallaController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

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
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;

public class ComponenteController extends ControllerSupport implements  IController{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3505275489025917085L;
	private static final Logger logger = Logger.getLogger(PantallaController.class);
	
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
	private Textbox idComponente;
	
	@Wire
	private Textbox idPantalla;
	
	@Wire
	private Combobox pantalla;
	
	@Wire
	private Textbox nombreComponente;
	
	@Wire
	private Combobox tipoComponente;
	
	private ComponenteDTO componenteDTO =  (ComponenteDTO) this.read();
	
	private List<ComponenteVO> componenteVOs = componenteDTO.getComponenteVOs();
	
	private String strIdComponente; 
	
	private String strIdPantalla; 
	
	private String strPantalla;

	private String strNombreComponente;
	
	private String strTipoComponente;
	
	@Override
	public Object read() {
		ComponenteDTO componenteDTO = new ComponenteDTO();
		PantallaDTO pantallaDTO = new PantallaDTO();
		PantallaVO pantallaVO = new PantallaVO();
		pantallaDTO.setPantallaVO(pantallaVO);
		PantallaBO pantallaBO = new PantallaBO();		
		ComponenteBO componenteBO = new ComponenteBO();		
		componenteDTO = componenteBO.readCommand(componenteDTO);		
		logger.info("::::::::::::::SIZE::::::::::" + componenteDTO.getComponenteVOs());
		pantallaDTO = pantallaBO.readCommand(pantallaDTO);
		componenteDTO.setPantallaVOs(pantallaDTO.getPantallaVOs());
		return componenteDTO;
	}
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
    }
	
	@Command
	public void readSelected(@BindingParam("idComponente") final ComponenteVO componenteVO){
		//Seteo de datos de Acuerdo al id de los compoenetes del HTML VS VO
		componenteVO.toString();
		pantalla.setValue(componenteVO.getNombrePantalla());
		nombreComponente.setValue(componenteVO.getNombreComponente());
		tipoComponente.setValue(componenteVO.getNombreTipoComponente());
		idComponente.setValue(String.valueOf(componenteVO.getIdComponente()));
	}
	
	//Cambiar al objeto que pertenezca el componente en este caso componenteVOs
	@Command
	@NotifyChange({ "componenteVOs" })
	public void readWithFilters() {
		ComponenteDTO componenteDTO = new ComponenteDTO();
		ComponenteVO componenteVO = new ComponenteVO();			
		//Textbox
		componenteVO.setNombreComponente(nombreComponente.getValue().isEmpty()?"%":"%"+nombreComponente.getValue()+"%");
		componenteVO.setIdTipoComponente(Integer.parseInt(tipoComponente.getSelectedItem().getValue().toString())); 
		
		//Combos Validar el nombre de los parametros en HTML VS Controller
		componenteVO.setIdPantalla((Integer.parseInt(idPantalla.getValue().isEmpty()?"0":idPantalla.getValue())));
		
		//Consulta Parametrizada

		componenteDTO.setComponenteVO(componenteVO);
		componenteDTO.toString(BbvaAbstractDataTransferObject.XML);	
		
		//LLamada a BO  Componente para consulta por criterio
		ComponenteBO componenteBO = new ComponenteBO();
		
		//Asignacion resultado de consulta al mismo DTO de Componente
		componenteDTO = componenteBO.readCommand(componenteDTO);
		
		//Tamaño de la lista de acuerdo al criterio de busqueda y objeto Componente
		if(componenteDTO.getComponenteVOs() != null) {
			logger.debug("size:"+componenteDTO.getComponenteVOs().size());
		} else{
			logger.debug(":::::::::::Lista Vacia::::::::::");
		}
		//Asignacion de la lista a la variable global de la clase
		componenteVOs = componenteDTO.getComponenteVOs();
		
	}
	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Command
	@NotifyChange({ "componenteVOs" })
	public void save() {
		//Validar Todos Los campos de pantalla
		boolean errorGuardar = false; 
		if (pantalla.getSelectedItem() == null
				|| pantalla.getSelectedItem().getValue() == null
				|| pantalla.getSelectedItem().getValue().toString().isEmpty()) {
			pantalla.setErrorMessage("Favor de seleccionar la Pantalla.");
			errorGuardar = true;
		}
		if (nombreComponente.getValue().isEmpty()) {
			nombreComponente
					.setErrorMessage("Favor de introducir nombre del Componente");
			errorGuardar = true;
		} 
		if (tipoComponente.getValue().isEmpty()) {
			tipoComponente
					.setErrorMessage("Favor de introducir tipo del Componente");
			errorGuardar = true;
		} 
		if(!errorGuardar){
			if(!idComponente.getValue().isEmpty()){
				logger.info("::::::Actualizar::::");
				ComponenteDTO componenteDTO = new ComponenteDTO();
				ComponenteVO componenteVO = new ComponenteVO();
				componenteVO.setIdComponente(Integer.parseInt(idComponente.getValue().isEmpty()?"0":idComponente.getValue()));
				componenteVO.setIdPantalla(Integer.parseInt(pantalla.getSelectedItem().getValue().toString()));
				
				componenteVO.setNombreComponente(nombreComponente.getValue());
				componenteVO.setIdTipoComponente(Integer.parseInt(tipoComponente.getSelectedItem().getValue().toString()));
							
				//Seteo de VO a DTO 
				componenteDTO.setComponenteVO(componenteVO);
				componenteDTO.toString(BbvaAbstractDataTransferObject.XML);	
				
				ComponenteBO componenteBO = new ComponenteBO();
				componenteBO.updateCommand(componenteDTO);
				clean();			
				
				//Textbox
				componenteVO.setNombreComponente(null);
				componenteVO.setIdTipoComponente(0); 			
				componenteVO.setIdPantalla(0);
				//Consulta Parametrizada
	
				componenteDTO.setComponenteVO(componenteVO);
				componenteDTO.toString(BbvaAbstractDataTransferObject.XML);	
				
				//Asignacion resultado de consulta al mismo DTO de Componente
				componenteDTO = componenteBO.readCommand(componenteDTO);
				
				
				Messagebox.show("Registro actualizado con exito!!",
						"Confirmación", Messagebox.OK,
						Messagebox.INFORMATION);
				
				componenteVOs = componenteDTO.getComponenteVOs();
			}else{ 
				logger.info("::::::Crear::::");
				ComponenteDTO componenteDTO = new ComponenteDTO();
				ComponenteVO componenteVO = new ComponenteVO();
				componenteVO.setIdComponente(Integer.parseInt(idComponente.getValue().isEmpty()?"0":idComponente.getValue()));
				componenteVO.setIdPantalla(Integer.parseInt(pantalla.getSelectedItem().getValue().toString()));
				componenteVO.setNombreComponente(nombreComponente.getValue());
				componenteVO.setIdTipoComponente(Integer.parseInt(tipoComponente.getSelectedItem().getValue().toString()));
							
				//Seteo de VO a DTO 
				componenteDTO.setComponenteVO(componenteVO);
				componenteDTO.toString(BbvaAbstractDataTransferObject.XML);	
				
				ComponenteBO componenteBO = new ComponenteBO();
				componenteBO.createCommand(componenteDTO);
				clean();	
				//Textbox
				componenteVO.setNombreComponente(null);
				componenteVO.setIdTipoComponente(0); 
				componenteVO.setIdPantalla(0);
				//Combos Validar el nombre de los parametros en HTML VS Controller

				
				//Consulta Parametrizada
	
				componenteDTO.setComponenteVO(componenteVO);
				componenteDTO.toString(BbvaAbstractDataTransferObject.XML);	
				
				//Asignacion resultado de consulta al mismo DTO de Componente
				componenteDTO = componenteBO.readCommand(componenteDTO);
				
				componenteVOs = componenteDTO.getComponenteVOs();
				
				Messagebox.show("Registro creado con exito!!",
						"Confirmación", Messagebox.OK,
						Messagebox.INFORMATION);				
			}
		}
	}
	@Override
	@Command
	public void delete() {
		logger.debug("Eliminando registro:"+idComponente.getValue());
		if(!idComponente.getValue().isEmpty()){
			Messagebox.show(
					"¿Está seguro que desea eliminar el Componente?",
					"Pregunta", Messagebox.YES | Messagebox.NO,
					Messagebox.QUESTION, new EventListener<Event>() {
						@Override
						public void onEvent(Event event) throws Exception {
							ComponenteDTO componenteDTO = new ComponenteDTO();
							ComponenteVO componenteVO = new ComponenteVO();
							componenteVO.setIdComponente(Integer.parseInt(idComponente.getValue().isEmpty()?"0":idComponente.getValue()));
							componenteDTO.setComponenteVO(componenteVO);
							ComponenteBO componenteBO = new ComponenteBO();
							componenteDTO.toString(BbvaAbstractDataTransferObject.XML);
							componenteBO.deleteCommand(componenteDTO); 
							clean();
							BindUtils
									.postGlobalCommand(
											null,
											null,
											"resetGridComponente",
											null);
						}
					});
		}else{
			Messagebox.show("!Favor de seleccionar el registro a eliminar!",
					"Error", Messagebox.OK,
					Messagebox.ERROR);
		}
	}
	@GlobalCommand("resetGridComponente")
	@NotifyChange({ "componenteVOs" })
	public void resetGrid() {
		ComponenteDTO componenteDTO = new ComponenteDTO();
		PantallaDTO pantallaDTO = new PantallaDTO();
		PantallaVO pantallaVO = new PantallaVO();
		pantallaDTO.setPantallaVO(pantallaVO);
		PantallaBO pantallaBO = new PantallaBO();
		ComponenteBO componenteBO = new ComponenteBO();
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		componenteDTO = componenteBO.readCommand(componenteDTO);
		logger.info("::::::::::::::SIZE::::::::::" + componenteDTO.getComponenteVOs());
		pantallaDTO = pantallaBO.readCommand(pantallaDTO);
		componenteDTO.setPantallaVOs(pantallaDTO.getPantallaVOs());
		
		componenteVOs = componenteDTO.getComponenteVOs();
	}
	@Override
	@Command
	public void clean() {
		//Mensajes HTML
		pantalla.clearErrorMessage();
		nombreComponente.clearErrorMessage();
		tipoComponente.clearErrorMessage();
		
		
		//Mensajes Setear a Null
		pantalla.setValue(null);
		nombreComponente.setValue(null);
		tipoComponente.setValue(null); 
		idPantalla.setValue(null);
		 
		//Setear IDs Invisibles
		idComponente.setValue(null); 
		
	}
	/**
	 * @return the idPantalla
	 */
	public Textbox getIdPantalla() {
		return idPantalla;
	}
	/**
	 * @param idPantalla the idPantalla to set
	 */
	public void setIdPantalla(Textbox idPantalla) {
		this.idPantalla = idPantalla;
	}
	/**
	 * @return the pantalla
	 */
	public Combobox getPantalla() {
		return pantalla;
	}
	/**
	 * @param pantalla the pantalla to set
	 */
	public void setPantalla(Combobox pantalla) {
		this.pantalla = pantalla;
	}
	/**
	 * @return the nombreComponente
	 */
	public Textbox getNombreComponente() {
		return nombreComponente;
	}
	/**
	 * @param nombreComponente the nombreComponente to set
	 */
	public void setNombreComponente(Textbox nombreComponente) {
		this.nombreComponente = nombreComponente;
	}
	/**
	 * @return the tipoComponente
	 */
	public Combobox getTipoComponente() {
		return tipoComponente;
	}
	/**
	 * @param tipoComponente the tipoComponente to set
	 */
	public void setTipoComponente(Combobox tipoComponente) {
		this.tipoComponente = tipoComponente;
	}
	/**
	 * @return the componenteDTO
	 */
	public ComponenteDTO getComponenteDTO() {
		return componenteDTO;
	}
	/**
	 * @param componenteDTO the componenteDTO to set
	 */
	public void setComponenteDTO(ComponenteDTO componenteDTO) {
		this.componenteDTO = componenteDTO;
	}
	/**
	 * @return the componenteVOs
	 */
	public List<ComponenteVO> getComponenteVOs() {
		return componenteVOs;
	}
	/**
	 * @param componenteVOs the componenteVOs to set
	 */
	public void setComponenteVOs(List<ComponenteVO> componenteVOs) {
		this.componenteVOs = componenteVOs;
	}
	/**
	 * @return the idComponente
	 */
	public Textbox getIdComponente() {
		return idComponente;
	}
	/**
	 * @param idComponente the idComponente to set
	 */
	public void setIdComponente(Textbox idComponente) {
		this.idComponente = idComponente;
	}
	/**
	 * @return the strIdComponente
	 */
	public String getStrIdComponente() {
		return strIdComponente;
	}
	/**
	 * @param strIdComponente the strIdComponente to set
	 */
	public void setStrIdComponente(String strIdComponente) {
		this.strIdComponente = strIdComponente;
	}
	/**
	 * @return the strIdPantalla
	 */
	public String getStrIdPantalla() {
		return strIdPantalla;
	}
	/**
	 * @param strIdPantalla the strIdPantalla to set
	 */
	public void setStrIdPantalla(String strIdPantalla) {
		this.strIdPantalla = strIdPantalla;
	}
	/**
	 * @return the strPantalla
	 */
	public String getStrPantalla() {
		return strPantalla;
	}
	/**
	 * @param strPantalla the strPantalla to set
	 */
	public void setStrPantalla(String strPantalla) {
		this.strPantalla = strPantalla;
	}
	/**
	 * @return the strNombreComponente
	 */
	public String getStrNombreComponente() {
		return strNombreComponente;
	}
	/**
	 * @param strNombreComponente the strNombreComponente to set
	 */
	public void setStrNombreComponente(String strNombreComponente) {
		this.strNombreComponente = strNombreComponente;
	}
	/**
	 * @return the strTipoComponente
	 */
	public String getStrTipoComponente() {
		return strTipoComponente;
	}
	/**
	 * @param strTipoComponente the strTipoComponente to set
	 */
	public void setStrTipoComponente(String strTipoComponente) {
		this.strTipoComponente = strTipoComponente;
	}

	
}
