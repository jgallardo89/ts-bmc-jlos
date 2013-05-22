package mx.com.bbva.mapeador.ui.commons.viewmodel.perfil;

import java.util.ArrayList;
import java.util.List;


import mx.com.bbva.bancomer.bussinnes.model.vo.CanalVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ComponenteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ControlPermisoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ControlPermisoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PantallaVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PerfilVO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;
import mx.com.bbva.bancomer.componente.dto.ComponenteDTO;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.estatusobjeto.dto.UsuarioDTO;
import mx.com.bbva.bancomer.mapper.business.ComponenteBO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.PantallaBO;
import mx.com.bbva.bancomer.mapper.business.PerfilBO;
import mx.com.bbva.bancomer.pantalla.dto.PantallaDTO;
import mx.com.bbva.bancomer.estatusobjeto.dto.PerfilDTO;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.perfil.PerfilController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

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
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

public class PerfilController extends ControllerSupport implements  IController{

	private static final Logger logger = Logger
			.getLogger(PerfilController.class);
	
	private int cantidadRegistros;
		
	
	private ComponenteDTO componentePantallaDTO;
	/**
	 * @return the componentePantallaDTO
	 */
	public final ComponenteDTO getComponentePantallaDTO() {
		return componentePantallaDTO;
	}

	/**
	 * @param componentePantallaDTO the componentePantallaDTO to set
	 */
	public final void setComponentePantallaDTO(ComponenteDTO componentePantallaDTO) {
		this.componentePantallaDTO = componentePantallaDTO;
	}

	/**
	 * @return the componentePantallaPerfilDTO
	 */
	public final ComponenteDTO getComponentePantallaPerfilDTO() {
		return componentePantallaPerfilDTO;
	}

	/**
	 * @param componentePantallaPerfilDTO the componentePantallaPerfilDTO to set
	 */
	public final void setComponentePantallaPerfilDTO(
			ComponenteDTO componentePantallaPerfilDTO) {
		this.componentePantallaPerfilDTO = componentePantallaPerfilDTO;
	}

	private ComponenteDTO componentePantallaPerfilDTO;
	
	
	@Wire
	Listbox componentesPantalla;
	
	@Wire
	Listbox componentesPerfil;
	
	@Wire
	private Textbox descripcionPerfil;

	@Wire
	private Textbox nombrePerfil;
	
	@Wire
	private Combobox status;
	
	@Wire
	private Combobox pantallas;
	
	@Wire
	private Textbox idPerfil;
	
	private String strDescripcionPerfil;
	
	private String strNombrePerfil;		
	
	private String strPantalla;
	
	private String strStatus;
	
	private PerfilDTO perfilDTO = (PerfilDTO)this.read(); 
	
	private List<PerfilVO> perfilVOs = perfilDTO.getPerfilVOs(); 

	/**
	 * @return the perfilVOs
	 */
	public final List<PerfilVO> getPerfilVOs() {
		return perfilVOs;
	}

	/**
	 * @param perfilVOs the perfilVOs to set
	 */
	public final void setPerfilVOs(List<PerfilVO> perfilVOs) {
		this.perfilVOs = perfilVOs;
	}

	/**
	 * @return the perfilDTO
	 */
	public final PerfilDTO getPerfilDTO() {
		return perfilDTO;
	}

	/**
	 * @param perfilDTO the perfilDTO to set
	 */
	public final void setPerfilDTO(PerfilDTO perfilDTO) {
		this.perfilDTO = perfilDTO;
	}

	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
    }

	@Override
	@Command
	@NotifyChange({"componentePantallaDTO", "componentePantallaPerfilDTO"})
	public void clean() {
		nombrePerfil.clearErrorMessage();
		descripcionPerfil.clearErrorMessage();
		status.clearErrorMessage();
		pantallas.clearErrorMessage();
		
		nombrePerfil.setValue(null);
		descripcionPerfil.setValue(null);
		status.setSelectedItem(null);
		pantallas.setSelectedItem(null);
		
		idPerfil.setValue(null);
		
		componentePantallaDTO = null;
		componentePantallaPerfilDTO = null;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	public int getCantidadRegistros() {
		return cantidadRegistros;
	}

	public String getStrDescripcionPerfil() {
		return strDescripcionPerfil;
	}

	public String getStrNombrePerfil() {
		return strNombrePerfil;
	}

	public String getStrPantalla() {
		return strPantalla;
	}

	public String getStrStatus() {
		return strStatus;
	}

	@Override
	public Object read() {
		
		PerfilDTO perfilDTO = new PerfilDTO();
		perfilDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
		PerfilVO perfilVO = new PerfilVO();
		perfilVO.setEstatusPerfil(CommandConstants.ESTATUS_PERFIL);
		logger.debug("*estatusObjetoVO*");
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
		estatusObjetoVO.setNombreTabla(CommandConstants.NOMBRE_TABLA_PERFIL);		
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
		estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
		estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);
		logger.debug("*pantallaVO*");
		PantallaVO pantallaVO = new PantallaVO();
		PantallaBO pantallaBO = new PantallaBO();
		PantallaDTO pantallaDTO = new PantallaDTO();
		pantallaDTO.setPantallaVO(pantallaVO);
		estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);	
		List<PantallaVO> pantallaVOs = pantallaBO.readCommand(pantallaDTO).getPantallaVOs();
		estatusObjetoDTO.setPantallaVOs(pantallaVOs);
		estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);			
		PerfilBO perfilBO = new PerfilBO();		
		perfilDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
		perfilDTO.setPantallaVOs(estatusObjetoDTO.getPantallaVOs());		
		perfilDTO.setPerfilVO(perfilVO);
		perfilDTO = perfilBO.readCommand(perfilDTO);
		
		return perfilDTO;
	}

	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Command
	@NotifyChange({"componentePantallaDTO", "componentePantallaPerfilDTO", "perfilDTO"})
	public void save() {
		boolean error = false;
		if(nombrePerfil.getValue().isEmpty()){
			nombrePerfil.setErrorMessage("Favor de Introducir el Nombre del Perfil.");
			error = true;
		}
		if(descripcionPerfil.getValue().isEmpty()){
			descripcionPerfil.setErrorMessage("Favor de introducir la descripción del perfil.");
			error = true;
		}
		if(descripcionPerfil.getValue().isEmpty()){
			descripcionPerfil.setErrorMessage("Favor de introducir la descripción del perfil.");
			error = true;
		}		
		if (status.getSelectedItem() == null
				|| status.getSelectedItem().getValue() == null
				|| status.getSelectedItem().getValue().toString().isEmpty()) {
			status.setErrorMessage("Favor de seleccionar el estatus.");
			error = true;
		}
		if (pantallas.getSelectedItem() == null
				|| pantallas.getSelectedItem().getValue() == null
				|| pantallas.getSelectedItem().getValue().toString().isEmpty()) {
			pantallas.setErrorMessage("Favor de seleccionar la pantalla.");
			error = true;
		}		
		if(!idPerfil.getValue().isEmpty()){
			perfilDTO = new PerfilDTO();
			PerfilVO perfilVO = new PerfilVO();
			perfilVO.setNombrebPerfil(nombrePerfil.getValue()==null?"":nombrePerfil.getValue().toUpperCase().trim());
			perfilVO.setDescripcionPerfil(descripcionPerfil.getValue()==null?"":descripcionPerfil.getValue().toUpperCase().trim());
			perfilVO.setEstatusPerfil(Integer.parseInt(status.getSelectedItem().getValue().toString()));
			perfilVO.setIdPerfil(Integer.parseInt(idPerfil.getValue()));
			
			List<ControlPermisoVO> controlPermisoVOs = null;
			controlPermisoVOs = new ArrayList<ControlPermisoVO>();
			ControlPermisoVO controlPermisoVO;
			if(componentePantallaPerfilDTO!=null){
				List<ComponenteVO> componenteVOsLocal = componentePantallaPerfilDTO.getComponentePantallaPerfilVOs();				
				for (ComponenteVO componenteVO : componenteVOsLocal) {
					controlPermisoVO = new ControlPermisoVO();
					controlPermisoVO.setIdComponente(componenteVO.idComponente);
					controlPermisoVO.setIdPerfil(Integer.parseInt(idPerfil.getValue()));
					controlPermisoVOs.add(controlPermisoVO);
				}		
				perfilVO.setControlPermisoVOs(controlPermisoVOs);
			}
			perfilDTO.setPerfilVO(perfilVO);		
			perfilDTO.toString(BbvaAbstractDataTransferObject.XML);
			PerfilBO perfilBO = new PerfilBO();
			perfilBO.updateCommand(perfilDTO);
			clean();
			Messagebox.show("Registro actualizado con exito!!",
					"Confirmación", Messagebox.OK,
					Messagebox.INFORMATION);
		}else{
			
		}
		perfilDTO = (PerfilDTO)this.read();
	}
	
	@Command
	@NotifyChange({"componentePantallaDTO", "componentePantallaPerfilDTO"})
	public void chooseOne(){
		if(componentesPantalla.getSelectedItem()!=null){
			componentePantallaPerfilDTO.getComponentePantallaPerfilVOs().add(componentePantallaDTO.getComponentePantallaVOs().get(componentesPantalla.getSelectedIndex()));
			componentePantallaDTO.getComponentePantallaVOs().remove(componentesPantalla.getSelectedIndex());
			
		}
	}
	@Command
	@NotifyChange({"componentePantallaDTO", "componentePantallaPerfilDTO"})
	public void chooseAll(){		
		List<ComponenteVO> componenteVOs = componentePantallaDTO.getComponentePantallaVOs();
		for (ComponenteVO componenteVO : componenteVOs) {
			componentePantallaPerfilDTO.getComponentePantallaPerfilVOs().add(componenteVO);
		}
		componentePantallaDTO.getComponentePantallaVOs().clear();
	}
	@Command
	@NotifyChange({"componentePantallaDTO", "componentePantallaPerfilDTO"})
	public void removeOne(){		
		if(componentesPerfil.getSelectedItem()!=null){
			componentePantallaDTO.getComponentePantallaVOs().add(componentePantallaPerfilDTO.getComponentePantallaPerfilVOs().get(componentesPerfil.getSelectedIndex()));
			componentePantallaPerfilDTO.getComponentePantallaPerfilVOs().remove(componentesPerfil.getSelectedIndex());
		}
	}
	@Command
	@NotifyChange({"componentePantallaDTO", "componentePantallaPerfilDTO"})
	public void removeAll(){		
		List<ComponenteVO> componenteVOs = componentePantallaPerfilDTO.getComponentePantallaPerfilVOs();
		for (ComponenteVO componenteVO : componenteVOs) {
			componentePantallaDTO.getComponentePantallaVOs().add(componenteVO);
		}
		componentePantallaPerfilDTO.getComponentePantallaPerfilVOs().clear();
	}
	public void setStrDescripcionPerfil(String strDescripcionPerfil) {
		this.strDescripcionPerfil = strDescripcionPerfil;
	}

	public void setStrNombrePerfil(String strNombrePerfil) {
		this.strNombrePerfil = strNombrePerfil;
	}

	public void setStrPantalla(String strPantalla) {
		this.strPantalla = strPantalla;
	}

	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}
	
	@Command	
	@NotifyChange({"componentePantallaDTO", "componentePantallaPerfilDTO"})
	public void readSelected(@BindingParam("idPerfil") final PerfilVO perfilVO){
		perfilVO.toString();
		nombrePerfil.setValue(perfilVO.getNombrebPerfil());
		descripcionPerfil.setValue(perfilVO.getDescripcionPerfil());
		status.setValue(perfilVO.getDescipcionEstatus());
		idPerfil.setValue(Integer.toString(perfilVO.getIdPerfil()));
		pantallas.setDisabled(false);
		pantallas.setReadonly(false);
		pantallas.setSelectedIndex(-1);
		if(componentePantallaDTO!=null && componentePantallaDTO.getComponentePantallaVOs()!=null)
			componentePantallaDTO.getComponentePantallaVOs().clear();
		if(componentePantallaPerfilDTO!=null && componentePantallaPerfilDTO.getComponentePantallaPerfilVOs()!=null)
			componentePantallaPerfilDTO.getComponentePantallaPerfilVOs().clear();
	}
	
	@Command
	@NotifyChange({"componentePantallaDTO", "componentePantallaPerfilDTO"})
	public void readComponentesPantalla(){
		ComponenteVO componenteVO = new ComponenteVO();
		componenteVO.setIdPantalla(Integer.parseInt(pantallas.getSelectedItem().getValue().toString()))	;
		componenteVO.setIdPerfil(Integer.parseInt(idPerfil.getValue().toString()));
		componentePantallaDTO = new ComponenteDTO();
		componentePantallaDTO.setCommandId(CommandConstants.COMPONENTE_PANTALLA);
		componentePantallaDTO.setComponenteVO(componenteVO);
		ComponenteBO componenteBO = new ComponenteBO();		
		componentePantallaDTO = componenteBO.readCommand(componentePantallaDTO);
		componentePantallaPerfilDTO = new ComponenteDTO();
		componentePantallaPerfilDTO.setCommandId(CommandConstants.COMPONENTE_PANTALLA_PERFIL);
		componentePantallaPerfilDTO.setComponenteVO(componenteVO);
		componenteBO = new ComponenteBO();		
		componentePantallaPerfilDTO = componenteBO.readCommand(componentePantallaPerfilDTO);
	}	
}
