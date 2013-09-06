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
 * Nombre de clase: PantallaController.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.pantalla
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.pantalla;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PantallaVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.PantallaBO;
import mx.com.bbva.bancomer.pantalla.dto.PantallaDTO;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
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
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

// TODO: Auto-generated Javadoc
/**
 * The Class PantallaController.
 *
 * @author
 */
public class PantallaController extends ControllerSupport implements  IController{
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(PantallaController.class);
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6786596344010411900L;
	
	/** The nombre Pantalla */
	private static final String tituloPantalla="Pantallas";	

		
	/** The consultar btn. */
	@Wire
	private Button consultarBtn;
	
	/** The execute permission set. */
	private boolean executePermissionSet;

	/** The guardar btn. */
	@Wire
	private Button guardarBtn;
	
	/** The icono. */
	@Wire
	private Textbox icono;
	
	/** The id estatus objeto. */
	@Wire
	private Textbox idEstatusObjeto;

	/** The id pantalla. */
	@Wire
	private Textbox idPantalla;
	
	/** The id pantalla padre. */
	@Wire
	private Textbox idPantallaPadre;
	
	/** The lbl icono. */
	@Wire
	private Label lblIcono;
	
	/** The lbl orden. */
	@Wire
	private Label lblOrden;
	
	/** The lbl pantalla. */
	@Wire
	private Label lblPantalla;
	
	/** The lbl pantalla padre. */
	@Wire
	private Label lblPantallaPadre;
	
	/** The lbl status. */
	@Wire
	private Label lblStatus;
	
	/** The lbl url. */
	@Wire
	private Label lblURL;
	
	/** The limpiar btn. */
	@Wire
	private Button limpiarBtn;
	
	/** The nombre pantalla. */
	@Wire
	private Textbox nombrePantalla;
	
	/** The orden. */
	@Wire
	private Textbox orden;
	
	/** The pantalla dto. */
	private PantallaDTO pantallaDTO =  (PantallaDTO) this.read();
	
	/** The pantalla padre. */
	@Wire
	private Combobox pantallaPadre;
	
	/** The pantalla vo. */
	private PantallaVO pantallaVO;
	
	/** The pantalla v os. */
	private List<PantallaVO> pantallaVOs = pantallaDTO.getPantallaVOs();
	
	/** The reporte csv btn. */
	@Wire
	private Image reporteCsvBtn;
	
	/** The reporte excel btn. */
	@Wire
	private Image reporteExcelBtn;
	
	/** The status. */
	@Wire
	private Combobox status;
	
	
	/** The str descripcion estatus objeto. */
	private String strDescripcionEstatusObjeto;
	
	/** The str icono. */
	private String strIcono;

	/** The str id estatus clave. */
	private String strIdEstatusClave;

	/** The str id estatus objeto. */
	private String strIdEstatusObjeto;

	/** The str id pantalla. */
	private String strIdPantalla;

	/** The str idpantalla padre. */
	private String strIdpantallaPadre;

	/** The str nombre estatus objeto. */
	private String strNombreEstatusObjeto;
	
	/** The str nombre pantalla. */
	private String strNombrePantalla;
	
	/** The str orden. */
	private String strOrden;
	
	/** The str pantalla padre. */
	private String strPantallaPadre;
	
	/** The str pantallas. */
	private String strPantallas;
	
	/** The str status clave. */
	private String strStatusClave;
	
	/** The str url. */
	private String strUrl;
	
	/** The url. */
	@Wire
	private Textbox url;
	
	/**
	 * After compose.
	 *
	 * @param view the view
	 */
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);   
        executePermissionSet = this.applyPermision();
        status.setValue(CommandConstants.NB_PANTALLA_ACTIVO);
        strIdEstatusObjeto = String.valueOf(CommandConstants.ESTATUS_OBJETO_COMBO_PANTALLAS);
    }
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#applyPermision()
	 */
	@Override
	public boolean applyPermision() {
		boolean isApplied = false;
		HashMap<String, Component> componentes = new HashMap<String, Component>();
		componentes.put(lblPantallaPadre.getId(), lblPantallaPadre);
		componentes.put(lblPantalla.getId(), lblPantalla);
		componentes.put(lblURL.getId(), lblURL);
		componentes.put(lblOrden.getId(), lblOrden);
		componentes.put(lblStatus.getId(), lblStatus);
		componentes.put(pantallaPadre.getId(), pantallaPadre);
		componentes.put(status.getId(), status);
		componentes.put(nombrePantalla.getId(), nombrePantalla);
		componentes.put(url.getId(), url);
		componentes.put(icono.getId(), icono);
		componentes.put(orden.getId(), orden);
		componentes.put(reporteExcelBtn.getId(), reporteExcelBtn);
		componentes.put(reporteCsvBtn.getId(), reporteCsvBtn);
		componentes.put(limpiarBtn.getId(), limpiarBtn);
		componentes.put(guardarBtn.getId(), guardarBtn);
		componentes.put(consultarBtn.getId(), consultarBtn);
		super.applyPermission(MapeadorConstants.PANTALLAS, componentes);
		return isApplied;
	}
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#clean()
	 */
	@Override
	@Command
	public void clean() {
		//Mensajes HTML
		pantallaPadre.clearErrorMessage();
		nombrePantalla.clearErrorMessage();
		status.clearErrorMessage();
		url.clearErrorMessage();
		icono.clearErrorMessage();
		orden.clearErrorMessage();
		
		//Mensajes Setear a Null
		pantallaPadre.setValue(null);
		nombrePantalla.setValue(null);
		status.setValue(null);
//		status.setValue(CommandConstants.NB_PANTALLA_ACTIVO);
		url.setValue(null);
		icono.setValue(null);
		orden.setValue(null);
		
		//Setear IDs Invisibles
		idPantallaPadre.setValue(null);
		idEstatusObjeto.setValue(null);
		idPantalla.setValue(null);
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#delete()
	 */
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Genera lista.
	 *
	 * @return the array list
	 */
	private ArrayList<BeanGenerico> generaLista() { 
		ArrayList<BeanGenerico> beanGenericos = new ArrayList<BeanGenerico>();
		BeanGenerico beanGenerico = null;
		for(PantallaVO pantallaVO: pantallaVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(pantallaVO.getNombrePantallaPadre());
			beanGenerico.setValor2(pantallaVO.getNombrePantalla());
			beanGenerico.setValor3(pantallaVO.getDescripcionUrlPantalla());
			beanGenerico.setValor4(pantallaVO.getDescripcionUrlIcon()); 
			beanGenerico.setValor5(pantallaVO.getNombreEstatusObjeto());  
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}
	
	/**
	 * Gets the icono.
	 *
	 * @return the icono
	 */
	public Textbox getIcono() {
		return icono;
	}

	/**
	 * Gets the id estatus objeto.
	 *
	 * @return the idEstatusObjeto
	 */
	public Textbox getIdEstatusObjeto() {
		return idEstatusObjeto;
	}

	/**
	 * Gets the id pantalla.
	 *
	 * @return the idpantalla
	 */
	public Textbox getIdPantalla() {
		return idPantalla;
	}
	
	/**
	 * Gets the id pantalla padre.
	 *
	 * @return the idpantallaPadre
	 */
	public Textbox getIdPantallaPadre() {
		return idPantallaPadre;
	}	
	
	/**
	 * Gets the nombre pantalla.
	 *
	 * @return the nombrePantalla
	 */
	public Textbox getNombrePantalla() {
		return nombrePantalla;
	}
	
	/**
	 * Gets the orden.
	 *
	 * @return the orden
	 */
	public Textbox getOrden() {
		return orden;
	}

	/**
	 * Gets the pantalla dto.
	 *
	 * @return the pantallaDTO
	 */
	public PantallaDTO getPantallaDTO() {
		return pantallaDTO;
	}

	/**
	 * Gets the pantalla padre.
	 *
	 * @return the pantallaPadre
	 */
	public Combobox getPantallaPadre() {
		return pantallaPadre;
	}

	/**
	 * Gets the pantalla vo.
	 *
	 * @return the pantallaVO
	 */
	public PantallaVO getPantallaVO() {
		return pantallaVO;
	}

	/**
	 * Gets the pantalla v os.
	 *
	 * @return the pantallaVOs
	 */
	public List<PantallaVO> getPantallaVOs() {
		return pantallaVOs;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public Combobox getStatus() {
		return status;
	}

	/**
	 * Gets the str descripcion estatus objeto.
	 *
	 * @return the strDescripcionEstatusObjeto
	 */
	public String getStrDescripcionEstatusObjeto() {
		return strDescripcionEstatusObjeto;
	}

	/**
	 * Gets the str icono.
	 *
	 * @return the strIcono
	 */
	public String getStrIcono() {
		return strIcono;
	}

	/**
	 * Gets the str id estatus clave.
	 *
	 * @return the strIdEstatusClave
	 */
	public String getStrIdEstatusClave() {
		return strIdEstatusClave;
	}

	/**
	 * Gets the str id estatus objeto.
	 *
	 * @return the strIdEstatusObjeto
	 */
	public String getStrIdEstatusObjeto() {
		return strIdEstatusObjeto;
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
	 * Gets the str idpantalla padre.
	 *
	 * @return the strIdpantallaPadre
	 */
	public String getStrIdpantallaPadre() {
		return strIdpantallaPadre;
	}

	/**
	 * Gets the str nombre estatus objeto.
	 *
	 * @return the strNombreEstatusObjeto
	 */
	public String getStrNombreEstatusObjeto() {
		return strNombreEstatusObjeto;
	}

	/**
	 * Gets the str nombre pantalla.
	 *
	 * @return the strNombrePantalla
	 */
	public String getStrNombrePantalla() {
		return strNombrePantalla;
	}

	/**
	 * Gets the str orden.
	 *
	 * @return the strOrden
	 */
	public String getStrOrden() {
		return strOrden;
	}

	/**
	 * Gets the str pantalla padre.
	 *
	 * @return the strPantallaPadre
	 */
	public String getStrPantallaPadre() {
		return strPantallaPadre;
	}

	/**
	 * Gets the str pantallas.
	 *
	 * @return the strPantallas
	 */
	public String getStrPantallas() {
		return strPantallas;
	}

	/**
	 * Gets the str status clave.
	 *
	 * @return the strStatusClave
	 */
	public String getStrStatusClave() {
		return strStatusClave;
	}

	/**
	 * Gets the str url.
	 *
	 * @return the strUrl
	 */
	public String getStrUrl() {
		return strUrl;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public Textbox getUrl() {
		return url;
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
		headersReport.add("Pantalla Padre");
		headersReport.add("Pantalla");
		headersReport.add("URL Pantalla");
		headersReport.add("URL Icono");
		headersReport.add("Orden");
		headersReport.add("Status");
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,tituloPantalla);
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,tituloPantalla);
		}
		controller.createReport(generaLista(), headersReport, type, "PANTALLAS");
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read()
	 */
	@Override
	public Object read() {
		ReportesController controller = new ReportesController();
		PantallaVO pantallaVO = new PantallaVO();
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
		estatusObjetoVO.setNombreTabla(CommandConstants.NOMBRE_TABLA_PANTALLA);		
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
		PantallaDTO pantallaDTO = new PantallaDTO();
		pantallaDTO.setPantallaVO(pantallaVO);
		PantallaBO pantallaBO = new PantallaBO();		
		pantallaDTO.setEstatusObjetoVO(estatusObjetoVO);
		pantallaDTO = pantallaBO.readCommand(pantallaDTO);
		logger.info("::::::::::::::SIZE::::::::::" + pantallaDTO.getPantallaVOs());
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
		pantallaDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
		
		return pantallaDTO;
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
	 * @param pantallaVO the pantalla vo
	 */
	@Command
	public void readSelected(@BindingParam("idPantalla") final PantallaVO pantallaVO){
		//Seteo de datos de Acuerdo al id de los compoenetes del HTML VS VO
		this.pantallaVO = pantallaVO;
		pantallaVO.toString();
		pantallaPadre.setValue(pantallaVO.getNombrePantallaPadre());
		nombrePantalla.setValue(pantallaVO.getNombrePantalla());
		status.setValue(pantallaVO.getNombreEstatusObjeto());
		url.setValue(pantallaVO.getDescripcionUrlPantalla());
		icono.setValue(pantallaVO.getDescripcionUrlIcon());
		orden.setValue(String.valueOf(pantallaVO.getNumeroOrdenPantalla()));
		idPantalla.setValue(String.valueOf(pantallaVO.getIdPantalla()));
		idPantallaPadre.setValue(String.valueOf(pantallaVO.getIdPantallaPadre()));
	}

	//Cambiar al objeto que pertenezca el componente en este caso PantallasVOs
	/**
	 * Read with filters.
	 */
	@GlobalCommand
	@Command
	@NotifyChange({ "pantallaVOs" })
	public void readWithFilters() {
		ReportesController controller = new ReportesController();
		PantallaDTO pantallaDTO = new PantallaDTO();
		PantallaVO pantallaVO = new PantallaVO();
//		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();	
		//Textbox
		pantallaVO.setNombrePantalla(nombrePantalla.getValue().isEmpty()?"%":"%"+nombrePantalla.getValue().toUpperCase()+"%");
		pantallaVO.setDescripcionUrlPantalla(url.getValue().isEmpty()?"%":"%"+url.getValue().toLowerCase()+"%");
		pantallaVO.setDescripcionUrlIcon(icono.getValue().isEmpty()?"%":"%"+icono.getValue()+"%");
		
		//Combos Validar el nombre de los parametros en HTML VS Controller
		pantallaVO.setIdPantallaPadre((Integer.parseInt(idPantallaPadre.getValue().isEmpty()?"0":idPantallaPadre.getValue())));
		pantallaVO.setEstatusPantalla((Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue())));
		pantallaVO.setNumeroOrdenPantalla(Integer.parseInt(orden.getValue().isEmpty()?"0":orden.getValue()));
		//Consulta Parametrizada
//		pantallaDTO.setCommandId(CommandConstants.ESTATUS_OBJETO_COMBO_PANTALLAS);
		//Seteo de VO a DTO 
		pantallaDTO.setPantallaVO(pantallaVO);
		pantallaDTO.toString(BbvaAbstractDataTransferObject.XML);	
		
		//LLamada a BO  Pantalla para consulta por criterio
		PantallaBO pantallaBO = new PantallaBO();
		
		//Asignacion resultado de consulta al mismo DTO de pantalla
		pantallaDTO = pantallaBO.readCommand(pantallaDTO);
		
		//Tamaño de la lista de acuerdo al criterio de busqueda y objeto Pantalla
		if(pantallaDTO.getPantallaVOs() != null) {
			logger.debug("size:"+pantallaDTO.getPantallaVOs().size());
		} else{
			logger.debug(":::::::::::Lista Vacia::::::::::");
		}
		//Asignacion de la lista a la variable global de la clase
		pantallaVOs = pantallaDTO.getPantallaVOs();
		controller.registrarEvento(null, null, CommandConstants.CONSULTAR,"Catálogo Pantalla");
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#save()
	 */
	@Override
	@Command
	@NotifyChange({ "pantallaVOs"})
	public void save() {
		final ReportesController controller = new ReportesController();
		//Validar Todos Los campos de pantalla
		boolean errorGuardar = false; 
		if (pantallaPadre.getSelectedItem() == null
				|| pantallaPadre.getSelectedItem().getValue() == null
				|| pantallaPadre.getSelectedItem().getValue().toString().isEmpty()) {
			pantallaPadre.setErrorMessage("Favor de seleccionar la Pantalla Padre.");
			errorGuardar = true;
		}
		if (nombrePantalla.getValue().isEmpty()) {
			nombrePantalla
					.setErrorMessage("Favor de introducir nombre de la Pantalla");
			errorGuardar = true;
		} 
		if (status.getSelectedItem() == null
				|| status.getSelectedItem().getValue() == null
				|| status.getSelectedItem().getValue().toString().isEmpty()) {
			status.setErrorMessage("Favor de seleccionar el Estatus del Objeto.");
			errorGuardar = true;
		}
		if (url.getValue().isEmpty()) {
			url
					.setErrorMessage("Favor de introducir la URL");
			errorGuardar = true;
		}
		if (icono.getValue().isEmpty()) {
			icono
					.setErrorMessage("Favor de introducir el Icono");
			errorGuardar = true;
		}
		if (orden.getValue().isEmpty()) {
			orden
					.setErrorMessage("Favor de introducir el Orden");
			errorGuardar = true;
		}
		if(!errorGuardar){
			Messagebox.show(
			"¿Está seguro que desea continuar con la operación?",
			"Pregunta", org.zkoss.zul.Messagebox.YES | org.zkoss.zul.Messagebox.NO,
			org.zkoss.zul.Messagebox.QUESTION, new EventListener<Event>() {
				@Override
				public void onEvent(Event event) throws Exception {
					if (event.getName().equals(org.zkoss.zul.Messagebox.ON_YES)) {
						if(!idPantalla.getValue().isEmpty()){
							logger.info("::::::Actualizar::::");
							PantallaDTO pantallaDTOL = new PantallaDTO();
							PantallaVO pantallaVOL = new PantallaVO();
							pantallaVOL.setIdPantalla(Integer.parseInt(idPantalla.getValue().toString()));
							pantallaVOL.setIdPantallaPadre(Integer.parseInt(idPantallaPadre.getValue()));
							pantallaVOL.setEstatusPantalla(Integer.parseInt(status.getSelectedItem().getValue().toString()));
							pantallaVOL.setNumeroOrdenPantalla(Integer.parseInt(orden.getValue()));								
							pantallaVOL.setNombrePantalla(nombrePantalla.getValue().toUpperCase().trim());
							pantallaVOL.setDescripcionUrlPantalla(url.getValue().trim());
							pantallaVOL.setDescripcionUrlIcon(icono.getValue().trim());
							
							//Seteo de VO a DTO 
							pantallaDTOL.setPantallaVO(pantallaVOL);
							pantallaDTOL.toString(BbvaAbstractDataTransferObject.XML);	
							
							PantallaBO pantallaBO = new PantallaBO();
							pantallaDTOL = pantallaBO.updateCommand(pantallaDTOL);
							if(pantallaDTOL.getErrorCode().equals("SQL-001")){
						    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
						    					"\nError:"+pantallaDTOL.getErrorCode()+
						    					"","Error de Sistema",Messagebox.OK,Messagebox.ERROR);
						    	controller.registrarEvento(pantallaVOL, pantallaVO, CommandConstants.ERROR_SISTEMA, tituloPantalla);
						    }else{
								if (Integer.parseInt(status.getSelectedItem().getValue().toString())==CommandConstants.ID_PANTALLA_BAJA) {
									controller.registrarEvento(pantallaVOL, pantallaVO, CommandConstants.BAJA, tituloPantalla);					
								} else if (Integer.parseInt(status.getSelectedItem().getValue().toString())==CommandConstants.ID_PANTALLA_INACTIVO) { 
									controller.registrarEvento(pantallaVOL, pantallaVO, CommandConstants.INACTIVACION, tituloPantalla);
								} else {				
									controller.registrarEvento(pantallaVOL, pantallaVO, CommandConstants.MODIFICACION, tituloPantalla);
								}
								clean();			
								pantallaVOL = new PantallaVO();							
								//Consulta Parametrizada
				//				pantallaDTO.setCommandId(CommandConstants.ESTATUS_OBJETO_COMBO_PANTALLAS);
								//Seteo de VO a DTO 
								pantallaDTOL.setPantallaVO(pantallaVOL);
								pantallaDTOL.toString(BbvaAbstractDataTransferObject.XML);
								
								//Asignacion resultado de consulta al mismo DTO de pantalla
								pantallaDTOL = pantallaBO.readCommand(pantallaDTOL);
				
								org.zkoss.zul.Messagebox.show("Registro actualizado con exito!!",
										"Información", org.zkoss.zul.Messagebox.OK,
										org.zkoss.zul.Messagebox.INFORMATION);
								pantallaDTO = pantallaDTOL;
								pantallaVOs = pantallaDTO.getPantallaVOs();
						    }
							
						}else{ 
							logger.info("::::::Crear::::");
							PantallaDTO pantallaDTOL = new PantallaDTO();
							PantallaVO pantallaVOL = new PantallaVO();
							pantallaVOL.setIdPantallaPadre(Integer.parseInt(pantallaPadre.getSelectedItem().getValue().toString()));
							pantallaVOL.setEstatusPantalla(Integer.parseInt(status.getSelectedItem().getValue().toString()));
							pantallaVOL.setNumeroOrdenPantalla(Integer.parseInt(orden.getValue()));
							
							pantallaVOL.setNombrePantalla(nombrePantalla.getValue().toUpperCase());
							pantallaVOL.setDescripcionUrlPantalla(url.getValue().toLowerCase());
							pantallaVOL.setDescripcionUrlIcon(icono.getValue());
							
							//Seteo de VO a DTO 
							pantallaDTOL.setPantallaVO(pantallaVOL);
							pantallaDTOL.toString(BbvaAbstractDataTransferObject.XML);	
							
							PantallaBO pantallaBO = new PantallaBO();
							pantallaDTOL = pantallaBO.createCommand(pantallaDTOL);
							
							PantallaVO pantallaNuevo = new PantallaVO();
							pantallaNuevo.setIdPantallaPadre(-1);
							pantallaNuevo.setEstatusPantalla(-1);
							pantallaNuevo.setNumeroOrdenPantalla(-1);
							
							pantallaNuevo.setNombrePantalla("");
							pantallaNuevo.setDescripcionUrlPantalla("");
							pantallaNuevo.setDescripcionUrlIcon("");
							
							if(pantallaDTOL.getErrorCode().equals("SQL-001")){
						    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
						    					"\nError:"+pantallaDTOL.getErrorCode()+
						    					"","Error de Sistema",Messagebox.OK,Messagebox.ERROR);
						    	controller.registrarEvento(pantallaVOL, pantallaNuevo, CommandConstants.ERROR_SISTEMA,tituloPantalla);
						    }else{
												
								controller.registrarEvento(pantallaVOL, pantallaNuevo, CommandConstants.ALTA,tituloPantalla);
								clean();	
								pantallaVOL = new PantallaVO();
								pantallaDTOL.setPantallaVO(pantallaVOL);
								pantallaDTOL.toString(BbvaAbstractDataTransferObject.XML);
								
								//Asignacion resultado de consulta al mismo DTO de pantalla
								pantallaDTOL = pantallaBO.readCommand(pantallaDTOL);
								pantallaDTO = pantallaDTOL;
								pantallaVOs = pantallaDTO.getPantallaVOs();
								
								org.zkoss.zul.Messagebox.show("Registro creado con exito!!",
										"Información", org.zkoss.zul.Messagebox.OK,
										org.zkoss.zul.Messagebox.INFORMATION);
						    }
						}
						BindUtils
						.postGlobalCommand(
								null,
								null,
								"readWithFilters",
								null);
					}
				}
			});
		}
		
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
	 * Sets the icono.
	 *
	 * @param icono the icono to set
	 */
	public void setIcono(Textbox icono) {
		this.icono = icono;
	}

	/**
	 * Sets the id estatus objeto.
	 *
	 * @param idEstatusObjeto the idEstatusObjeto to set
	 */
	public void setIdEstatusObjeto(Textbox idEstatusObjeto) {
		this.idEstatusObjeto = idEstatusObjeto;
	}

	/**
	 * Sets the id pantalla.
	 *
	 * @param idPantalla the new id pantalla
	 */
	public void setIdPantalla(Textbox idPantalla) {
		this.idPantalla = idPantalla;
	}

	/**
	 * Sets the id pantalla padre.
	 *
	 * @param idPantallaPadre the new id pantalla padre
	 */
	public void setIdPantallaPadre(Textbox idPantallaPadre) {
		this.idPantallaPadre = idPantallaPadre;
	}

	/**
	 * Sets the nombre pantalla.
	 *
	 * @param nombrePantalla the nombrePantalla to set
	 */
	public void setNombrePantalla(Textbox nombrePantalla) {
		this.nombrePantalla = nombrePantalla;
	}

	/**
	 * Sets the orden.
	 *
	 * @param orden the orden to set
	 */
	public void setOrden(Textbox orden) {
		this.orden = orden;
	}
	
	/**
	 * Sets the pantalla dto.
	 *
	 * @param pantallaDTO the pantallaDTO to set
	 */
	public void setPantallaDTO(PantallaDTO pantallaDTO) {
		this.pantallaDTO = pantallaDTO;
	}
	
	/**
	 * Sets the pantalla padre.
	 *
	 * @param pantallaPadre the pantallaPadre to set
	 */
	public void setPantallaPadre(Combobox pantallaPadre) {
		this.pantallaPadre = pantallaPadre;
	}

	/**
	 * Sets the pantalla vo.
	 *
	 * @param pantallaVO the pantallaVO to set
	 */
	public void setPantallaVO(PantallaVO pantallaVO) {
		this.pantallaVO = pantallaVO;
	}

	/**
	 * Sets the pantalla v os.
	 *
	 * @param pantallaVOs the pantallaVOs to set
	 */
	public void setPantallaVOs(List<PantallaVO> pantallaVOs) {
		this.pantallaVOs = pantallaVOs;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(Combobox status) {
		this.status = status;
	}

	/**
	 * Sets the str descripcion estatus objeto.
	 *
	 * @param strDescripcionEstatusObjeto the strDescripcionEstatusObjeto to set
	 */
	public void setStrDescripcionEstatusObjeto(String strDescripcionEstatusObjeto) {
		this.strDescripcionEstatusObjeto = strDescripcionEstatusObjeto;
	}

	/**
	 * Sets the str icono.
	 *
	 * @param strIcono the strIcono to set
	 */
	public void setStrIcono(String strIcono) {
		this.strIcono = strIcono;
	}

	/**
	 * Sets the str id estatus clave.
	 *
	 * @param strIdEstatusClave the strIdEstatusClave to set
	 */
	public void setStrIdEstatusClave(String strIdEstatusClave) {
		this.strIdEstatusClave = strIdEstatusClave;
	}

	/**
	 * Sets the str id estatus objeto.
	 *
	 * @param strIdEstatusObjeto the strIdEstatusObjeto to set
	 */
	public void setStrIdEstatusObjeto(String strIdEstatusObjeto) {
		this.strIdEstatusObjeto = strIdEstatusObjeto;
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
	 * Sets the str idpantalla padre.
	 *
	 * @param strIdpantallaPadre the strIdpantallaPadre to set
	 */
	public void setStrIdpantallaPadre(String strIdpantallaPadre) {
		this.strIdpantallaPadre = strIdpantallaPadre;
	}

	/**
	 * Sets the str nombre estatus objeto.
	 *
	 * @param strNombreEstatusObjeto the strNombreEstatusObjeto to set
	 */
	public void setStrNombreEstatusObjeto(String strNombreEstatusObjeto) {
		this.strNombreEstatusObjeto = strNombreEstatusObjeto;
	}

	/**
	 * Sets the str nombre pantalla.
	 *
	 * @param strNombrePantalla the strNombrePantalla to set
	 */
	public void setStrNombrePantalla(String strNombrePantalla) {
		this.strNombrePantalla = strNombrePantalla;
	}

	/**
	 * Sets the str orden.
	 *
	 * @param strOrden the strOrden to set
	 */
	public void setStrOrden(String strOrden) {
		this.strOrden = strOrden;
	}

	/**
	 * Sets the str pantalla padre.
	 *
	 * @param strPantallaPadre the strPantallaPadre to set
	 */
	public void setStrPantallaPadre(String strPantallaPadre) {
		this.strPantallaPadre = strPantallaPadre;
	}
	
	/**
	 * Sets the str pantallas.
	 *
	 * @param strPantallas the strPantallas to set
	 */
	public void setStrPantallas(String strPantallas) {
		this.strPantallas = strPantallas;
	}
	
	/**
	 * Sets the str status clave.
	 *
	 * @param strStatusClave the strStatusClave to set
	 */
	public void setStrStatusClave(String strStatusClave) {
		this.strStatusClave = strStatusClave;
	}	


	/**
	 * Sets the str url.
	 *
	 * @param strUrl the strUrl to set
	 */
	public void setStrUrl(String strUrl) {
		this.strUrl = strUrl;
	}

	/**
	 * Sets the url.
	 *
	 * @param url the url to set
	 */
	public void setUrl(Textbox url) {
		this.url = url;
	}
}
