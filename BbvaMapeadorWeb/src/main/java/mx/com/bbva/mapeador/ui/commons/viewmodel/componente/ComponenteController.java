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
 * Nombre de clase: ComponenteController.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.componente
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.componente;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ComponenteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PantallaVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.componente.dto.ComponenteDTO;
import mx.com.bbva.bancomer.mapper.business.ComponenteBO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.PantallaBO;
import mx.com.bbva.bancomer.pantalla.dto.PantallaDTO;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.pantalla.PantallaController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.reportes.ReportesController;
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
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

// TODO: Auto-generated Javadoc
/**
 * The Class ComponenteController.
 */
public class ComponenteController extends ControllerSupport implements  IController{

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(ComponenteController.class);
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3505275489025917085L;
	
	/** The nombre Pantalla */
	private static final String nombrePantalla="Componentes";	
	
		
	/** The componente dto. */
	private ComponenteDTO componenteDTO =  (ComponenteDTO) this.read();
	
	/** The componentes grid. */
	@Wire
	private Grid componentesGrid;
	
	/** The componente v os. */
	private List<ComponenteVO> componenteVOs = componenteDTO.getComponenteVOs();
	
	/** The consultar btn. */
	@Wire
	private Button consultarBtn;
	
	/** The default component. */
	@Wire
	private Checkbox defaultComponent;
	
	/** The eliminar btn. */
	@Wire
	private Button eliminarBtn;
	
	/** The execute permission set. */
	private boolean executePermissionSet;
	
	/** The guardar btn. */
	@Wire
	private Button guardarBtn;
	
	/** The id componente. */
	@Wire
	private Textbox idComponente;
	
	/** The id pantalla. */
	@Wire
	private Textbox idPantalla;
	
	/** The lbl default. */
	@Wire
	private Label lblDefault;
	
	/** The lbl nombre componente. */
	@Wire
	private Label lblNombreComponente;
	
	/** The lbl pantalla. */
	@Wire
	private Label lblPantalla;
	
	/** The lbl tipo componente. */
	@Wire
	private Label lblTipoComponente;
	
	/** The limpiar btn. */
	@Wire
	private Button limpiarBtn;
	
	/** The nombre componente. */
	@Wire
	private Textbox nombreComponente;
	
	/** The pantalla. */
	@Wire
	private Combobox pantalla;
	
	/** The str id componente. */
	private String strIdComponente; 
	
	/** The str id pantalla. */
	private String strIdPantalla; 
	
	/** The str nombre componente. */
	private String strNombreComponente;

	/** The str pantalla. */
	private String strPantalla;
	
	/** The str tipo componente. */
	private String strTipoComponente;
	
	/** The tipo componente. */
	@Wire
	private Combobox tipoComponente;
	
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
		componentes.put(lblPantalla.getId(), lblPantalla);
		componentes.put(lblNombreComponente.getId(), lblNombreComponente);
		componentes.put(lblTipoComponente.getId(), lblTipoComponente);
		componentes.put(pantalla.getId(), pantalla);
		componentes.put(tipoComponente.getId(), tipoComponente);
		componentes.put(nombreComponente.getId(), nombreComponente);
		componentes.put(limpiarBtn.getId(), limpiarBtn);
		componentes.put(guardarBtn.getId(), guardarBtn);
		componentes.put(consultarBtn.getId(), consultarBtn);
		componentes.put(eliminarBtn.getId(), eliminarBtn);
		componentes.put(componentesGrid.getId(), componentesGrid);
		componentes.put(lblDefault.getId(), lblDefault);
		componentes.put(defaultComponent.getId(), defaultComponent);
		super.applyPermission(MapeadorConstants.COMPONENTES, componentes);
		return isApplied;
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#clean()
	 */
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
		defaultComponent.setChecked(false);
		
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#delete()
	 */
	@Override
	@Command
	public void delete() {
		
		logger.debug("Eliminando registro:"+idComponente.getValue());
		if(!idComponente.getValue().isEmpty()){
			org.zkoss.zul.Messagebox.show(
					"¿Está seguro que desea eliminar el Componente?",
					"Pregunta", org.zkoss.zul.Messagebox.YES | org.zkoss.zul.Messagebox.NO,
					org.zkoss.zul.Messagebox.QUESTION, new EventListener<Event>() {
						@Override
						public void onEvent(Event event) throws Exception {
							ReportesController controller = new ReportesController();
							ComponenteDTO componenteDTO = new ComponenteDTO();
							ComponenteVO componenteVO = new ComponenteVO();
							componenteVO.setIdComponente(Integer.parseInt(idComponente.getValue().isEmpty()?"0":idComponente.getValue()));
							componenteDTO.setComponenteVO(componenteVO);
							ComponenteBO componenteBO = new ComponenteBO();
							componenteDTO.toString(BbvaAbstractDataTransferObject.XML);
							componenteBO.deleteCommand(componenteDTO);
							controller.registrarEvento(null, null, CommandConstants.ELIMINACION,nombrePantalla);
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
			org.zkoss.zul.Messagebox.show("!Favor de seleccionar el registro a eliminar!",
					"Error", org.zkoss.zul.Messagebox.OK,
					org.zkoss.zul.Messagebox.ERROR);
		}
	}
	
	/**
	 * Genera lista.
	 *
	 * @return the array list
	 */
	private ArrayList<BeanGenerico> generaLista() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		ArrayList<BeanGenerico> beanGenericos = new ArrayList<BeanGenerico>();
		BeanGenerico beanGenerico = null;
		for(ComponenteVO componenteVO: componenteVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(componenteVO.getNombrePantalla());
			beanGenerico.setValor2(componenteVO.nombreComponente);
			beanGenerico.setValor3(componenteVO.nombreTipoComponente);
			beanGenerico.setValor4(componenteVO.getIdDefault());			
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}

	/**
	 * Gets the componente dto.
	 *
	 * @return the componenteDTO
	 */
	public ComponenteDTO getComponenteDTO() {
		return componenteDTO;
	}
	
	/**
	 * Gets the componente v os.
	 *
	 * @return the componenteVOs
	 */
	public List<ComponenteVO> getComponenteVOs() {
		return componenteVOs;
	}
	
	/**
	 * Gets the id componente.
	 *
	 * @return the idComponente
	 */
	public Textbox getIdComponente() {
		return idComponente;
	}
	
	/**
	 * Gets the id pantalla.
	 *
	 * @return the idPantalla
	 */
	public Textbox getIdPantalla() {
		return idPantalla;
	}
	
	/**
	 * Gets the nombre componente.
	 *
	 * @return the nombreComponente
	 */
	public Textbox getNombreComponente() {
		return nombreComponente;
	}
	
	/**
	 * Gets the pantalla.
	 *
	 * @return the pantalla
	 */
	public Combobox getPantalla() {
		return pantalla;
	}
	
	/**
	 * Gets the str id componente.
	 *
	 * @return the strIdComponente
	 */
	public String getStrIdComponente() {
		return strIdComponente;
	}
	
	/**
	 * Gets the str id pantalla.
	 *
	 * @return the strIdPantalla
	 */
	public String getStrIdPantalla() {
		return strIdPantalla;
	}
	
	/**
	 * Gets the str nombre componente.
	 *
	 * @return the strNombreComponente
	 */
	public String getStrNombreComponente() {
		return strNombreComponente;
	}
	
	/**
	 * Gets the str pantalla.
	 *
	 * @return the strPantalla
	 */
	public String getStrPantalla() {
		return strPantalla;
	}
	
	/**
	 * Gets the str tipo componente.
	 *
	 * @return the strTipoComponente
	 */
	public String getStrTipoComponente() {
		return strTipoComponente;
	}
	
	/**
	 * Gets the tipo componente.
	 *
	 * @return the tipoComponente
	 */
	public Combobox getTipoComponente() {
		return tipoComponente;
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
		headersReport.add("Pantalla");
		headersReport.add("Nombre del componente");
		headersReport.add("Tipo componente");
		headersReport.add("Default");		
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,nombrePantalla);
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,nombrePantalla);
		}
		controller.createReport(generaLista(), headersReport, type, "COMPONENTES");
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read()
	 */
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
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read(java.lang.Object)
	 */
	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Read selected.
	 *
	 * @param componenteVO the componente vo
	 */
	@Command
	public void readSelected(@BindingParam("idComponente") final ComponenteVO componenteVO){
		//Seteo de datos de Acuerdo al id de los compoenetes del HTML VS VO
		componenteVO.toString();
		pantalla.setValue(componenteVO.getNombrePantalla());
		nombreComponente.setValue(componenteVO.getNombreComponente());
		tipoComponente.setValue(componenteVO.getNombreTipoComponente());
		idComponente.setValue(String.valueOf(componenteVO.getIdComponente()));
		defaultComponent.setChecked(componenteVO.getIdDefault().equalsIgnoreCase("T")?true:false);
	}
	
	//Cambiar al objeto que pertenezca el componente en este caso componenteVOs
	/**
	 * Read with filters.
	 */
	@Command
	@NotifyChange({ "componenteVOs" })
	public void readWithFilters() {
		ComponenteDTO componenteDTO = new ComponenteDTO();
		ComponenteVO componenteVO = new ComponenteVO();			
		//Textbox
		componenteVO.setNombreComponente(nombreComponente.getValue().isEmpty()?"%":"%"+nombreComponente.getValue()+"%");
		componenteVO.setIdTipoComponente(tipoComponente.getSelectedItem()==null?0:Integer.parseInt(tipoComponente.getSelectedItem().getValue().toString())); 
		
		//Combos Validar el nombre de los parametros en HTML VS Controller
		componenteVO.setIdPantalla((Integer.parseInt(idPantalla.getValue().isEmpty()?"0":idPantalla.getValue())));
		
		componenteVO.setIdDefault(defaultComponent.isChecked()?"T":"F");
		
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
		ReportesController controller = new ReportesController();
		controller.registrarEvento(null, null, CommandConstants.CONSULTAR,nombrePantalla);
		componenteVOs = componenteDTO.getComponenteVOs();
		
	}
	
	/**
	 * Reset grid.
	 */
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
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#save()
	 */
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
				componenteVO.setIdDefault(defaultComponent.isChecked()?"T":"F");
				componenteVO.setNombreComponente(nombreComponente.getValue());
				componenteVO.setIdTipoComponente(Integer.parseInt(tipoComponente.getSelectedItem().getValue().toString()));
							
				//Seteo de VO a DTO 
				componenteDTO.setComponenteVO(componenteVO);
				componenteDTO.toString(BbvaAbstractDataTransferObject.XML);	
				
				ComponenteBO componenteBO = new ComponenteBO();
				componenteBO.updateCommand(componenteDTO);

				ReportesController controller = new ReportesController();
				controller.registrarEvento(componenteVO, this.componenteDTO.getComponenteVO(), CommandConstants.MODIFICACION,nombrePantalla);

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
								
				org.zkoss.zul.Messagebox.show("Registro actualizado con exito!!",
						"Confirmación", org.zkoss.zul.Messagebox.OK,
						org.zkoss.zul.Messagebox.INFORMATION);
				
				componenteVOs = componenteDTO.getComponenteVOs();
			}else{ 
				logger.info("::::::Crear::::");
				ComponenteDTO componenteDTO = new ComponenteDTO();
				ComponenteVO componenteVO = new ComponenteVO();
				componenteVO.setIdComponente(Integer.parseInt(idComponente.getValue().isEmpty()?"0":idComponente.getValue()));
				componenteVO.setIdPantalla(Integer.parseInt(pantalla.getSelectedItem().getValue().toString()));
				componenteVO.setNombreComponente(nombreComponente.getValue());
				componenteVO.setIdTipoComponente(Integer.parseInt(tipoComponente.getSelectedItem().getValue().toString()));
				componenteVO.setIdDefault(defaultComponent.isChecked()?"T":"F");	
				//Seteo de VO a DTO 
				componenteDTO.setComponenteVO(componenteVO);
				componenteDTO.toString(BbvaAbstractDataTransferObject.XML);	
				
				ComponenteBO componenteBO = new ComponenteBO();
				componenteBO.createCommand(componenteDTO);
				
				ReportesController controller = new ReportesController();
				
				ComponenteVO componenteNuevo = new ComponenteVO();
				componenteNuevo.setIdComponente(-1);
				componenteNuevo.setIdPantalla(-1);
				componenteNuevo.setNombreComponente("");
				componenteNuevo.setIdTipoComponente(-1);
				componenteNuevo.setIdDefault("");	
				
				controller.registrarEvento(componenteVO, componenteNuevo, CommandConstants.ALTA,nombrePantalla);
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
				
				org.zkoss.zul.Messagebox.show("Registro creado con exito!!",
						"Confirmación", org.zkoss.zul.Messagebox.OK,
						org.zkoss.zul.Messagebox.INFORMATION);				
			}
		}
	}
	
	/**
	 * Sets the componente dto.
	 *
	 * @param componenteDTO the componenteDTO to set
	 */
	public void setComponenteDTO(ComponenteDTO componenteDTO) {
		this.componenteDTO = componenteDTO;
	}
	
	/**
	 * Sets the componente v os.
	 *
	 * @param componenteVOs the componenteVOs to set
	 */
	public void setComponenteVOs(List<ComponenteVO> componenteVOs) {
		this.componenteVOs = componenteVOs;
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
	 * Sets the id componente.
	 *
	 * @param idComponente the idComponente to set
	 */
	public void setIdComponente(Textbox idComponente) {
		this.idComponente = idComponente;
	}
	
	/**
	 * Sets the id pantalla.
	 *
	 * @param idPantalla the idPantalla to set
	 */
	public void setIdPantalla(Textbox idPantalla) {
		this.idPantalla = idPantalla;
	}
	
	/**
	 * Sets the nombre componente.
	 *
	 * @param nombreComponente the nombreComponente to set
	 */
	public void setNombreComponente(Textbox nombreComponente) {
		this.nombreComponente = nombreComponente;
	}
	
	/**
	 * Sets the pantalla.
	 *
	 * @param pantalla the pantalla to set
	 */
	public void setPantalla(Combobox pantalla) {
		this.pantalla = pantalla;
	}
	
	/**
	 * Sets the str id componente.
	 *
	 * @param strIdComponente the strIdComponente to set
	 */
	public void setStrIdComponente(String strIdComponente) {
		this.strIdComponente = strIdComponente;
	}
	
	/**
	 * Sets the str id pantalla.
	 *
	 * @param strIdPantalla the strIdPantalla to set
	 */
	public void setStrIdPantalla(String strIdPantalla) {
		this.strIdPantalla = strIdPantalla;
	}
	
	/**
	 * Sets the str nombre componente.
	 *
	 * @param strNombreComponente the strNombreComponente to set
	 */
	public void setStrNombreComponente(String strNombreComponente) {
		this.strNombreComponente = strNombreComponente;
	}
	
	/**
	 * Sets the str pantalla.
	 *
	 * @param strPantalla the strPantalla to set
	 */
	public void setStrPantalla(String strPantalla) {
		this.strPantalla = strPantalla;
	}	
	
	/**
	 * Sets the str tipo componente.
	 *
	 * @param strTipoComponente the strTipoComponente to set
	 */
	public void setStrTipoComponente(String strTipoComponente) {
		this.strTipoComponente = strTipoComponente;
	}	
	
	/**
	 * Sets the tipo componente.
	 *
	 * @param tipoComponente the tipoComponente to set
	 */
	public void setTipoComponente(Combobox tipoComponente) {
		this.tipoComponente = tipoComponente;
	}
	
}
