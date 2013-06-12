/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Informacion Confidencial:
 * Este software contiene informacion totalmente confidencial propiedad de Grupo Financiero BBVA Bancomer. 
 * Queda totalmente prohibido su uso o divulgacion en forma parcial o total y solamente podra ser utilizada de acuerdo a los terminos y estatutos 
 * que determine el Grupo Financiero BBVA Bancomer.
 * 
 * Todos los derechos reservados, Mexico 2013.
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * DESCRIPCION DEL PROGRAMA
 * Nombre de aplicación: MAPEADOR
 * Nombre de proyecto: BbvaMapeadorWeb
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * HISTORIAL DE CAMBIOS:
 * 
 * Fecha:									         	
 * 30-ABR-2013  
 * @Author:	Jose Luis Ortiz Salazar
 * @Email: jortizsalazar@gmail.com    	
 * Razon: Creacion        
 * Version: 1.0.0
 * Nombre de clase: PerfilController.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.perfil
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.perfil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

// TODO: Auto-generated Javadoc
/**
 * The Class PerfilController.
 */
public class PerfilController extends ControllerSupport implements  IController{

	/** The Constant logger. */
	private static final Logger logger = Logger
			.getLogger(PerfilController.class);
	
	/** The cantidad registros. */
	private int cantidadRegistros;
		
	
	/** The componente pantalla dto. */
	private ComponenteDTO componentePantallaDTO;
	
	/** The componente pantalla perfil all dto. */
	private ComponenteDTO componentePantallaPerfilAllDTO;

	/** The componente pantalla perfil dto. */
	private ComponenteDTO componentePantallaPerfilDTO;

	/** The componentes pantalla. */
	@Wire
	Listbox componentesPantalla;

	/** The componentes perfil. */
	@Wire
	Listbox componentesPerfil;

	/** The componentes perfil all. */
	@Wire
	Listbox componentesPerfilAll;
	
	/** The consultar btn. */
	@Wire
	private Button consultarBtn;
	
	
	/** The descripcion perfil. */
	@Wire
	private Textbox descripcionPerfil;

	/** The duplicar btn. */
	@Wire
	private Button duplicarBtn;

	/** The execute permission set. */
	private boolean executePermissionSet;
	
	/** The guardar btn. */
	@Wire
	private Button guardarBtn;
	
	/** The id perfil. */
	@Wire
	private Textbox idPerfil;
	
	/** The lbl descripcion perfil. */
	@Wire
	private Label lblDescripcionPerfil;

	/** The lbl estatus. */
	@Wire
	private Label lblEstatus;
	
	/** The lbl nombre perfil. */
	@Wire
	private Label lblNombrePerfil;
	
	/** The lbl pantalla. */
	@Wire
	private Label lblPantalla;
	
	/** The limpiar btn. */
	@Wire
	private Button limpiarBtn;
	
	/** The nombre perfil. */
	@Wire
	private Textbox nombrePerfil;
	
	/** The pantallas. */
	@Wire
	private Combobox pantallas;
	
	/** The perfil dto. */
	private PerfilDTO perfilDTO = (PerfilDTO)this.read();

	/** The perfil grid. */
	@Wire
	private Grid perfilGrid;
	
	/** The perfil vo. */
	private PerfilVO perfilVO = null;
	
	/** The perfil v os. */
	private List<PerfilVO> perfilVOs = perfilDTO.getPerfilVOs();
	
	/** The status. */
	@Wire
	private Combobox status;

	/** The str descripcion perfil. */
	private String strDescripcionPerfil;
	
	/** The str nombre perfil. */
	private String strNombrePerfil;
	
	/** The str pantalla. */
	private String strPantalla;
	
	/** The str status. */
	private String strStatus;		
	
	/**
	 * After compose.
	 *
	 * @param view the view
	 */
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
        executePermissionSet = this.applyPermision();
    }
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#applyPermision()
	 */
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
	
	/**
	 * Choose all.
	 */
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
	
	/**
	 * Choose one.
	 */
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
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#clean()
	 */
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
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#delete()
	 */
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Duply.
	 */
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

	/**
	 * Genera lista.
	 *
	 * @return the array list
	 */
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

	/**
	 * Gets the cantidad registros.
	 *
	 * @return the cantidad registros
	 */
	public int getCantidadRegistros() {
		return cantidadRegistros;
	}

	/**
	 * Gets the componente pantalla dto.
	 *
	 * @return the componentePantallaDTO
	 */
	public final ComponenteDTO getComponentePantallaDTO() {
		return componentePantallaDTO;
	}

	/**
	 * Gets the componente pantalla perfil all dto.
	 *
	 * @return the componentePantallaPerfilAllDTO
	 */
	public final ComponenteDTO getComponentePantallaPerfilAllDTO() {
		return componentePantallaPerfilAllDTO;
	}

	/**
	 * Gets the componente pantalla perfil dto.
	 *
	 * @return the componentePantallaPerfilDTO
	 */
	public final ComponenteDTO getComponentePantallaPerfilDTO() {
		return componentePantallaPerfilDTO;
	}

	/**
	 * Gets the perfil dto.
	 *
	 * @return the perfilDTO
	 */
	public final PerfilDTO getPerfilDTO() {
		return perfilDTO;
	}

	/**
	 * Gets the perfil v os.
	 *
	 * @return the perfilVOs
	 */
	public final List<PerfilVO> getPerfilVOs() {
		return perfilVOs;
	}

	/**
	 * Gets the str descripcion perfil.
	 *
	 * @return the str descripcion perfil
	 */
	public String getStrDescripcionPerfil() {
		return strDescripcionPerfil;
	}

	/**
	 * Gets the str nombre perfil.
	 *
	 * @return the str nombre perfil
	 */
	public String getStrNombrePerfil() {
		return strNombrePerfil;
	}

	/**
	 * Gets the str pantalla.
	 *
	 * @return the str pantalla
	 */
	public String getStrPantalla() {
		return strPantalla;
	}

	/**
	 * Gets the str status.
	 *
	 * @return the str status
	 */
	public String getStrStatus() {
		return strStatus;
	}

	/**
	 * Checks if is execute permission set.
	 *
	 * @return the executePermissionSet
	 */
	public boolean isExecutePermissionSet() {
		return executePermissionSet;
	}

	/**
	 * On show report.
	 *
	 * @param type the type
	 */
	@Command
	public void onShowReport(@BindingParam("type") final String type) {
		ReportesController controller = new ReportesController();
		ArrayList<String> headersReport = new ArrayList<String>();
		headersReport.add("Nombre perfil");
		headersReport.add("Descripción de perfil");
		headersReport.add("Status");		
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Catálogo Perfiles");
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Catálogo Perfiles");
		}
		controller.createReport(generaLista(), headersReport, type, "PERFILES");				
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read()
	 */
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
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read(java.lang.Object)
	 */
	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Read componentes pantalla.
	 */
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
	 * Read selected.
	 *
	 * @param perfilVO the perfil vo
	 */
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
	
	/**
	 * Read with filters.
	 */
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
	
	/**
	 * Removes the all.
	 */
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
	
	/**
	 * Removes the one.
	 */
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

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#save()
	 */
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
					perfilVOValida.setNombrebPerfil(nombrePerfil.getValue().trim());
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

	/**
	 * Sets the componente pantalla dto.
	 *
	 * @param componentePantallaDTO the componentePantallaDTO to set
	 */
	public final void setComponentePantallaDTO(ComponenteDTO componentePantallaDTO) {
		this.componentePantallaDTO = componentePantallaDTO;
	}

	/**
	 * Sets the componente pantalla perfil all dto.
	 *
	 * @param componentePantallaPerfilAllDTO the componentePantallaPerfilAllDTO to set
	 */
	public final void setComponentePantallaPerfilAllDTO(
			ComponenteDTO componentePantallaPerfilAllDTO) {
		this.componentePantallaPerfilAllDTO = componentePantallaPerfilAllDTO;
	}
	
	/**
	 * Sets the componente pantalla perfil dto.
	 *
	 * @param componentePantallaPerfilDTO the componentePantallaPerfilDTO to set
	 */
	public final void setComponentePantallaPerfilDTO(
			ComponenteDTO componentePantallaPerfilDTO) {
		this.componentePantallaPerfilDTO = componentePantallaPerfilDTO;
	}
	
	/**
	 * Sets the execute permission set.
	 *
	 * @param executePermissionSet the executePermissionSet to set
	 */
	public void setExecutePermissionSet(boolean executePermissionSet) {
		this.executePermissionSet = executePermissionSet;
	}

	/**
	 * Sets the perfil dto.
	 *
	 * @param perfilDTO the perfilDTO to set
	 */
	public final void setPerfilDTO(PerfilDTO perfilDTO) {
		this.perfilDTO = perfilDTO;
	}
	
	/**
	 * Sets the perfil v os.
	 *
	 * @param perfilVOs the perfilVOs to set
	 */
	public final void setPerfilVOs(List<PerfilVO> perfilVOs) {
		this.perfilVOs = perfilVOs;
	}
	
	/**
	 * Sets the str descripcion perfil.
	 *
	 * @param strDescripcionPerfil the new str descripcion perfil
	 */
	public void setStrDescripcionPerfil(String strDescripcionPerfil) {
		this.strDescripcionPerfil = strDescripcionPerfil;
	}
	
	/**
	 * Sets the str nombre perfil.
	 *
	 * @param strNombrePerfil the new str nombre perfil
	 */
	public void setStrNombrePerfil(String strNombrePerfil) {
		this.strNombrePerfil = strNombrePerfil;
	}
	
	/**
	 * Sets the str pantalla.
	 *
	 * @param strPantalla the new str pantalla
	 */
	public void setStrPantalla(String strPantalla) {
		this.strPantalla = strPantalla;
	}
	
	/**
	 * Sets the str status.
	 *
	 * @param strStatus the new str status
	 */
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}	
	
	/**
	 * Show modal.
	 *
	 * @param perfilVO the perfil vo
	 */
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
}
