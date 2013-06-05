package mx.com.bbva.mapeador.ui.commons.viewmodel.perfil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.com.bbva.bancomer.bussinnes.model.vo.ClienteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ComponenteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ControlPermisoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PantallaVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PerfilVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.componente.dto.ComponenteDTO;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.estatusobjeto.dto.UsuarioDTO;
import mx.com.bbva.bancomer.mapper.business.ComponenteBO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.PantallaBO;
import mx.com.bbva.bancomer.mapper.business.PerfilBO;
import mx.com.bbva.bancomer.mapper.business.UsuarioBO;
import mx.com.bbva.bancomer.pantalla.dto.PantallaDTO;
import mx.com.bbva.bancomer.perfil.dto.PerfilDTO;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.reportes.ReportesController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

import org.apache.log4j.Logger;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

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
	
	private ComponenteDTO componentePantallaPerfilAllDTO;
	
	
	/**
	 * @return the componentePantallaPerfilAllDTO
	 */
	public final ComponenteDTO getComponentePantallaPerfilAllDTO() {
		return componentePantallaPerfilAllDTO;
	}

	/**
	 * @param componentePantallaPerfilAllDTO the componentePantallaPerfilAllDTO to set
	 */
	public final void setComponentePantallaPerfilAllDTO(
			ComponenteDTO componentePantallaPerfilAllDTO) {
		this.componentePantallaPerfilAllDTO = componentePantallaPerfilAllDTO;
	}

	@Wire
	Listbox componentesPantalla;
	
	@Wire
	Listbox componentesPerfil;
	
	@Wire
	Listbox componentesPerfilAll;
	
	@Wire
	private Textbox descripcionPerfil;

	@Wire
	private Textbox nombrePerfil;
	
	@Wire
	private Combobox status;
	
	@Wire
	private Combobox pantallas;
	
	@Wire
	private Label lblNombrePerfil;
	@Wire
	private Label lblEstatus;
	@Wire
	private Label lblDescripcionPerfil;
	@Wire
	private Label lblPantalla;

	@Wire
	private Button limpiarBtn;
	@Wire
	private Button guardarBtn;
	@Wire
	private Button consultarBtn;
	@Wire
	private Button duplicarBtn;

	@Wire
	private Grid perfilGrid;
	
	@Wire
	private Textbox idPerfil;
	
	private String strDescripcionPerfil;
	
	private String strNombrePerfil;		
	
	private String strPantalla;
	
	private String strStatus;
	
	private boolean executePermissionSet;
	
	private PerfilDTO perfilDTO = (PerfilDTO)this.read(); 
	
	private List<PerfilVO> perfilVOs = perfilDTO.getPerfilVOs(); 
	
	private PerfilVO perfilVO = null;
	
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
        executePermissionSet = this.applyPermision();
    }

	@Override
	@Command
	@NotifyChange({"componentePantallaDTO", "componentePantallaPerfilDTO", "componentePantallaPerfilAllDTO"})
	public void clean() {
		nombrePerfil.clearErrorMessage();
		descripcionPerfil.clearErrorMessage();
		status.clearErrorMessage();
		pantallas.clearErrorMessage();
		
		nombrePerfil.setValue(null);
		descripcionPerfil.setValue(null);
		status.setValue(null);
		pantallas.setSelectedItem(null);
		
		idPerfil.setValue(null);
		
		componentePantallaDTO = null;
		componentePantallaPerfilDTO = null;
		componentePantallaPerfilAllDTO = null;
		perfilVO = null;
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
		
		perfilDTO = new PerfilDTO();
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
		logger.debug("pantallaVOs:"+pantallaVOs);
		estatusObjetoDTO.setPantallaVOs(pantallaVOs);
		estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);			
		PerfilBO perfilBO = new PerfilBO();		
		perfilDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
		perfilDTO.setPantallaVOs(estatusObjetoDTO.getPantallaVOs());		
		perfilDTO.setPerfilVO(perfilVO);
		perfilDTO.setCommandId(CommandConstants.PERFIL_COMMAND_READ_ALL);
		perfilDTO = perfilBO.readCommand(perfilDTO);
		
		return perfilDTO;
	}

	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Command
	@NotifyChange({ "perfilVOs" })
	public void readWithFilters() {
		
		PerfilVO perfilVO = new PerfilVO();
		perfilVO.setEstatusPerfil(status.getSelectedItem()==null?0:Integer.parseInt(status.getSelectedItem().getValue().toString()));				
		perfilVO.setDescripcionPerfil(descripcionPerfil.getValue().isEmpty()?"%":"%"+descripcionPerfil.getValue().toUpperCase()+"%");
		perfilVO.setNombrebPerfil(nombrePerfil.getValue().isEmpty()?"%":"%"+nombrePerfil.getValue().toString()+"%");
		perfilVO.setIdPantalla(pantallas.getSelectedItem()==null?0:Integer.parseInt(pantallas.getSelectedItem().getValue().toString()));
		PerfilBO perfilBO = new PerfilBO();							
		perfilDTO.setPerfilVO(perfilVO);
		perfilDTO.setCommandId(CommandConstants.PERFIL_COMMAND_READ_ALL);
		perfilDTO = perfilBO.readCommand(perfilDTO);
		 			
		perfilVOs = perfilDTO.getPerfilVOs();
		
		ReportesController controller = new ReportesController();
		controller.registrarEventoPerfil(null, null, CommandConstants.CONSULTAR, "Catálogo Perfiles");
	}
	@Override
	@Command
	@NotifyChange({"componentePantallaDTO", "componentePantallaPerfilDTO", "perfilDTO", "perfilVOs", "componentePantallaPerfilAllDTO"})
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
		if(!idPerfil.getValue().isEmpty()){	
			if (status.getSelectedItem() == null
					|| status.getSelectedItem().getValue() == null
					|| status.getSelectedItem().getValue().toString().isEmpty()) {
				status.setErrorMessage("Favor de seleccionar el estatus.");
				error = true;
			}			
		}
		if(!error){
			if(!idPerfil.getValue().isEmpty()){	
				if(Integer.parseInt(status.getSelectedItem().getValue().toString())==CommandConstants.ID_PERFIL_INACTIVO
						||Integer.parseInt(status.getSelectedItem().getValue().toString())==CommandConstants.ID_PERFIL_BAJA){
					UsuarioDTO usuarioDTO = new UsuarioDTO();
					UsuarioVO usuarioVO = new UsuarioVO();
					UsuarioBO usuarioBO = new UsuarioBO();
					usuarioVO.setIdPerfil(Integer.parseInt(idPerfil.getValue()));
					usuarioDTO.setUsuarioVO(usuarioVO);
					usuarioDTO = usuarioBO.readCommand(usuarioDTO);
					if(usuarioDTO.getUsuarioVOs().size()>0){
						Messagebox.show("El perfil no puede ser cancelado o inactivado ya que existen usuarios activos o inactivos.",
								"Confirmación", Messagebox.OK,
								Messagebox.EXCLAMATION);
						error = true;
					}
				}
				if(!error){
					PerfilDTO perfilDTOValida = new PerfilDTO();
					PerfilVO perfilVOValida = new PerfilVO();
					PerfilBO perfilBOvalida = new PerfilBO();
					perfilVOValida.setIdPerfil(Integer.parseInt(idPerfil.getValue()));
					perfilVOValida.setNombrebPerfil(nombrePerfil.getValue());
					perfilDTOValida.setPerfilVO(perfilVOValida);
					perfilDTOValida.setCommandId(CommandConstants.PERFIL_COMMAND_READ_ALL);
					perfilDTOValida = perfilBOvalida.readCommand(perfilDTOValida);
					if(perfilDTOValida.getPerfilVOs().size()>0){
						Messagebox.show("Ya existe un perfil con el mismo identificador",
								"Confirmación", Messagebox.OK,
								Messagebox.EXCLAMATION);
					}else{
						PerfilDTO perfilDTO = new PerfilDTO();
						PerfilVO perfilVO = new PerfilVO();
						perfilVO.setNombrebPerfil(nombrePerfil.getValue()==null?"":nombrePerfil.getValue().toUpperCase().trim());
						perfilVO.setDescripcionPerfil(descripcionPerfil.getValue()==null?"":descripcionPerfil.getValue().toUpperCase().trim());
						perfilVO.setEstatusPerfil(Integer.parseInt(status.getSelectedItem().getValue().toString()));
						perfilVO.setDescipcionEstatus(status.getSelectedItem().getLabel());
						perfilVO.setIdPerfil(Integer.parseInt(idPerfil.getValue()));
						perfilVO.setIdPantalla(pantallas.getSelectedItem()==null?0:Integer.parseInt(pantallas.getSelectedItem().getValue().toString()));
						List<ControlPermisoVO> controlPermisoVOs = null;
						controlPermisoVOs = new ArrayList<ControlPermisoVO>();
						ControlPermisoVO controlPermisoVO;
						if(componentePantallaPerfilDTO!=null){
							List<ComponenteVO> componenteVOsLocal = componentePantallaPerfilDTO.getComponentePantallaPerfilVOs();				
							for (ComponenteVO componenteVO : componenteVOsLocal) {
								controlPermisoVO = new ControlPermisoVO();
								controlPermisoVO.setIdComponente(componenteVO.idComponente);
								controlPermisoVO.setIdPerfil(Integer.parseInt(idPerfil.getValue()));
								controlPermisoVO.setNombreComponente(componenteVO.getNombreComponente());
								controlPermisoVOs.add(controlPermisoVO);
							}		
							perfilVO.setControlPermisoVOs(controlPermisoVOs);
						}
						perfilDTO.setPerfilVO(perfilVO);		
						perfilDTO.toString(BbvaAbstractDataTransferObject.XML);
						PerfilBO perfilBO = new PerfilBO();
						perfilBO.updateCommand(perfilDTO);
						
						ReportesController controller = new ReportesController();
						List<ControlPermisoVO> controlPermiso2VOs = new ArrayList<ControlPermisoVO>(); 
						PerfilVO perfilVO2 = new PerfilVO();
						if(componentePantallaDTO!=null){
							List<ComponenteVO> componenteVOsLocal = componentePantallaDTO.getComponentePantallaVOs();				
							for (ComponenteVO componenteVO : componenteVOsLocal) {
								controlPermisoVO = new ControlPermisoVO();
								controlPermisoVO.setIdComponente(componenteVO.idComponente);
								controlPermisoVO.setIdPerfil(Integer.parseInt(idPerfil.getValue()));
								controlPermisoVO.setNombreComponente(componenteVO.getNombreComponente());
								controlPermiso2VOs.add(controlPermisoVO);
							}		
							perfilVO2.setControlPermisoVOs(controlPermiso2VOs);
						}
						this.perfilDTO.setPerfilVO(this.perfilVO);
						this.perfilDTO.getPerfilVO().setControlPermisoVOs(controlPermiso2VOs);				
						controller.registrarEventoPerfil(perfilDTO, this.perfilDTO, CommandConstants.MODIFICACION, "Catálogo Perfiles");
						
						clean();
						perfilDTO = (PerfilDTO)this.read();
						perfilVOs = perfilDTO.getPerfilVOs();
										
						Messagebox.show("Registro actualizado con exito!!",
								"Confirmación", Messagebox.OK,
								Messagebox.INFORMATION);
					}
				}
			}else{				
				PerfilDTO perfilDTOValida = new PerfilDTO();
				PerfilVO perfilVOValida = new PerfilVO();
				PerfilBO perfilBOvalida = new PerfilBO();				
				perfilVOValida.setNombrebPerfil(nombrePerfil.getValue().toUpperCase());
				perfilDTOValida.setPerfilVO(perfilVOValida);
				perfilDTOValida.setCommandId(CommandConstants.PERFIL_COMMAND_READ_ALL);
				perfilDTOValida = perfilBOvalida.readCommand(perfilDTOValida);
				if(perfilDTOValida.getPerfilVOs().size()>0){
					Messagebox.show("Ya existe un perfil con el mismo identificador",
							"Confirmación", Messagebox.OK,
							Messagebox.EXCLAMATION);
				}else{
					PerfilDTO perfilDTO = new PerfilDTO();
					PerfilVO perfilVO = new PerfilVO();
					perfilVO.setNombrebPerfil(nombrePerfil.getValue()==null?"":nombrePerfil.getValue().toUpperCase().trim());
					perfilVO.setDescripcionPerfil(descripcionPerfil.getValue()==null?"":descripcionPerfil.getValue().toUpperCase().trim());
					perfilVO.setEstatusPerfil(CommandConstants.ID_PERFIL_ACTIVO);				
					perfilVO.setDescipcionEstatus(status.getSelectedItem().getLabel());				
					perfilDTO.setPerfilVO(perfilVO);		
					perfilDTO.toString(BbvaAbstractDataTransferObject.XML);
					PerfilBO perfilBO = new PerfilBO();
					perfilBO.createCommand(perfilDTO);
					
					ReportesController controller = new ReportesController();
					controller.registrarEventoPerfil(perfilDTO, this.perfilDTO, CommandConstants.ALTA, "Catálogo Perfiles");
					
					perfilDTO = (PerfilDTO)this.read();
					perfilVOs = perfilDTO.getPerfilVOs();
					clean();
					Messagebox.show("Registro creado con exito!!",
							"Confirmación", Messagebox.OK,
							Messagebox.INFORMATION);
				}
			}						
		}
	}
	
	@Command
	@NotifyChange({"componentePantallaDTO", "componentePantallaPerfilDTO"})
	public void chooseOne(){
		if(componentePantallaPerfilDTO!=null && componentePantallaDTO!=null){
			if(componentesPantalla.getSelectedItem()!=null){
				componentePantallaPerfilDTO.getComponentePantallaPerfilVOs().add(componentePantallaDTO.getComponentePantallaVOs().get(componentesPantalla.getSelectedIndex()));
				componentePantallaDTO.getComponentePantallaVOs().remove(componentesPantalla.getSelectedIndex());
				
			}
		}
	}
	@Command
	@NotifyChange({"componentePantallaDTO", "componentePantallaPerfilDTO"})
	public void chooseAll(){		
		List<ComponenteVO> componenteVOs = componentePantallaDTO.getComponentePantallaVOs();
		if(componentePantallaPerfilDTO!=null && componentePantallaDTO!=null){
			for (ComponenteVO componenteVO : componenteVOs) {
				componentePantallaPerfilDTO.getComponentePantallaPerfilVOs().add(componenteVO);
			}
			componentePantallaDTO.getComponentePantallaVOs().clear();
		}
	}
	@Command
	@NotifyChange({"componentePantallaDTO", "componentePantallaPerfilDTO"})
	public void removeOne(){		
		if(componentePantallaPerfilDTO!=null && componentePantallaDTO!=null){
			if(componentesPerfil.getSelectedItem()!=null){
				componentePantallaDTO.getComponentePantallaVOs().add(componentePantallaPerfilDTO.getComponentePantallaPerfilVOs().get(componentesPerfil.getSelectedIndex()));
				componentePantallaPerfilDTO.getComponentePantallaPerfilVOs().remove(componentesPerfil.getSelectedIndex());
			}
		}
	}
	@Command
	@NotifyChange({"componentePantallaDTO", "componentePantallaPerfilDTO"})
	public void removeAll(){		
		if(componentePantallaPerfilDTO!=null && componentePantallaDTO!=null){
			List<ComponenteVO> componenteVOs = componentePantallaPerfilDTO.getComponentePantallaPerfilVOs();
			for (ComponenteVO componenteVO : componenteVOs) {
				componentePantallaDTO.getComponentePantallaVOs().add(componenteVO);
			}
			componentePantallaPerfilDTO.getComponentePantallaPerfilVOs().clear();
		}
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
	@NotifyChange({"componentePantallaDTO", "componentePantallaPerfilDTO", "componentePantallaPerfilAllDTO"})
	public void readSelected(@BindingParam("idPerfil") final PerfilVO perfilVO){
		this.perfilVO = perfilVO;
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
		
		ComponenteBO componenteBO = new ComponenteBO();
		ComponenteVO componenteVO = new ComponenteVO();
		componenteVO.setIdPerfil(Integer.parseInt(idPerfil.getValue().toString()));
		componentePantallaPerfilAllDTO = new ComponenteDTO();
		componentePantallaPerfilAllDTO.setCommandId(CommandConstants.COMPONENTE_PANTALLA_PERFIL_ALL);
		componentePantallaPerfilAllDTO.setComponenteVO(componenteVO);
		componentePantallaPerfilAllDTO = componenteBO.readCommand(componentePantallaPerfilAllDTO);
		componentePantallaPerfilAllDTO.toString(BbvaAbstractDataTransferObject.XML);
	}
	
	@Command
	@NotifyChange({"componentePantallaDTO", "componentePantallaPerfilDTO"})
	public void readComponentesPantalla(){
		ComponenteVO componenteVO = new ComponenteVO();
		componenteVO.setIdPantalla(Integer.parseInt(pantallas.getSelectedItem().getValue().toString()))	;
		logger.debug("ID-PANTALLA:"+pantallas.getSelectedItem().getValue());
		if(!idPerfil.getValue().isEmpty())
			componenteVO.setIdPerfil(Integer.parseInt(idPerfil.getValue().toString()));
		else
			componenteVO.setIdPerfil(0);
		componentePantallaDTO = new ComponenteDTO();
		componentePantallaDTO.setCommandId(CommandConstants.COMPONENTE_PANTALLA);
		componentePantallaDTO.setComponenteVO(componenteVO);
		ComponenteBO componenteBO = new ComponenteBO();		
		componentePantallaDTO = componenteBO.readCommand(componentePantallaDTO);		
		if(componenteVO.getIdPerfil()!=0){			
			componentePantallaPerfilDTO = new ComponenteDTO();
			componentePantallaPerfilDTO.setCommandId(CommandConstants.COMPONENTE_PANTALLA_PERFIL);
			componentePantallaPerfilDTO.setComponenteVO(componenteVO);
			componentePantallaPerfilDTO = componenteBO.readCommand(componentePantallaPerfilDTO);	
			
			componentePantallaPerfilAllDTO = new ComponenteDTO();
			componentePantallaPerfilAllDTO.setCommandId(CommandConstants.COMPONENTE_PANTALLA_PERFIL_ALL);
			componentePantallaPerfilAllDTO.setComponenteVO(componenteVO);
			componentePantallaPerfilAllDTO = componenteBO.readCommand(componentePantallaPerfilAllDTO);
		}
	}

	/**
	 * @return the executePermissionSet
	 */
	public boolean isExecutePermissionSet() {
		return executePermissionSet;
	}
	/**
	 * @param executePermissionSet the executePermissionSet to set
	 */
	public void setExecutePermissionSet(boolean executePermissionSet) {
		this.executePermissionSet = executePermissionSet;
	}
	@Override
	public boolean applyPermision() {
		boolean isApplied = false;
		HashMap<String, Component> componentes = new HashMap<String, Component>();
		componentes.put(lblNombrePerfil.getId(), lblNombrePerfil);
		componentes.put(lblEstatus.getId(), lblEstatus);
		componentes.put(lblDescripcionPerfil.getId(), lblDescripcionPerfil);
		componentes.put(lblPantalla.getId(), lblPantalla);
		componentes.put(nombrePerfil.getId(), nombrePerfil);
		componentes.put(descripcionPerfil.getId(), descripcionPerfil);
		componentes.put(componentesPantalla.getId(), componentesPantalla);
		componentes.put(componentesPerfil.getId(), componentesPerfil);
		componentes.put(status.getId(), status);
		componentes.put(limpiarBtn.getId(), limpiarBtn);
		componentes.put(guardarBtn.getId(), guardarBtn);
		componentes.put(consultarBtn.getId(), consultarBtn);
		componentes.put(duplicarBtn.getId(), duplicarBtn);
		componentes.put(perfilGrid.getId(), perfilGrid);
		componentes.put(componentesPerfilAll.getId(), componentesPerfilAll);
		super.applyPermission(MapeadorConstants.PERFILES, componentes);
		return isApplied;
	}
	
	@Command
	@NotifyChange({"componentePantallaDTO", "componentePantallaPerfilDTO", "perfilDTO", "perfilVOs", "componentePantallaPerfilAllDTO"})
	public void duply(){
		boolean error = false;
		if(idPerfil.getValue().isEmpty()){
			nombrePerfil.setErrorMessage("Favor de Seleccionar el Perfil a Copiar.");
			error = true;
		}
		if(nombrePerfil.getValue().isEmpty()){
			nombrePerfil.setErrorMessage("Favor de Introducir el Nombre del Perfil.");
			error = true;
		}
		if(descripcionPerfil.getValue().isEmpty()){
			descripcionPerfil.setErrorMessage("Favor de introducir la descripción del perfil.");
			error = true;
		}
		if(!error){
			PerfilDTO perfilDTO = new PerfilDTO();
			PerfilVO perfilVO = new PerfilVO();
			perfilVO.setNombrebPerfil("COPIA DE "+nombrePerfil.getValue().toUpperCase().trim());
			perfilVO.setDescripcionPerfil("COPIA DE "+descripcionPerfil.getValue().toUpperCase().trim());
			perfilVO.setEstatusPerfil(CommandConstants.ID_PERFIL_ACTIVO);
			perfilVO.setIdPerfilACopiar(Integer.parseInt(idPerfil.getValue()));
			
			perfilDTO.setPerfilVO(perfilVO);		
			perfilDTO.toString(BbvaAbstractDataTransferObject.XML);
			PerfilBO perfilBO = new PerfilBO();
			perfilBO.createCommand(perfilDTO);
			ReportesController controller = new ReportesController();			
			controller.registrarEventoPerfil(perfilDTO, this.perfilDTO, CommandConstants.ALTA, "Catálogo Perfiles");
			clean();
			perfilDTO = (PerfilDTO)this.read();
			perfilVOs = perfilDTO.getPerfilVOs();
			Messagebox.show("Registro creado con exito!!",
					"Confirmación", Messagebox.OK,
					Messagebox.INFORMATION);
		}
	}
	
	@Command
	public void showModal(@BindingParam("idPerfil") final PerfilVO perfilVO){
		Map<String, Object> mapDatos;
		mapDatos = new HashMap<String, Object>();
		logger.debug("idPerfil:"+perfilVO.toString());		
		mapDatos.put("perfilVO", perfilVO);		
		Window window = (Window) Executions.createComponents(
				"/WEB-INF/flows/perfil/detallePerfil.zul",
				this.getSelf(), mapDatos);
			window.doModal();		
	}
	
	@Command
	public void onShowReport(@BindingParam("type") final String type) {
		ReportesController controller = new ReportesController();
		ArrayList<String> headersReport = new ArrayList<String>();
		headersReport.add("Nombre Perfil");
		headersReport.add("Descripción Perfil");
		headersReport.add("Estatus");		
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Catálogo Perfiles");
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Catálogo Perfiles");
		}
		controller.createReport(generaLista(), headersReport, type, "PERFILES");				
	}	
	
	private ArrayList<BeanGenerico> generaLista() {
		ArrayList<BeanGenerico> beanGenericos = new ArrayList<BeanGenerico>();
		BeanGenerico beanGenerico = null;
		for(PerfilVO perfilVo: perfilVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(perfilVo.getNombrebPerfil());
			beanGenerico.setValor2(perfilVo.getDescripcionPerfil());
			beanGenerico.setValor3(perfilVo.getDescipcionEstatus());			
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}
}
