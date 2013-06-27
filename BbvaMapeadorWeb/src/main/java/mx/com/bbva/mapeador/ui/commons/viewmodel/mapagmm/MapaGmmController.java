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
 * Nombre de clase: MapaGmmController.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.mapagmm
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.mapagmm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MapaGmmVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.MapaGmmBO;
import mx.com.bbva.bancomer.mappers.mapagmm.dto.MapaGmmDTO;
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
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

// TODO: Auto-generated Javadoc
/**
 * The Class MapaGmmController.
 */
public class MapaGmmController  extends ControllerSupport implements  IController{

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(PantallaController.class);
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1420939655567271610L;	
	
	/** The nombre Pantalla */
	private static final String nombrePantalla="Catálogo Mapas";
	
	/** The btn guardar. */
	private boolean btnGuardar = true;
	
	/** The consultar btn. */
	@Wire
	private Button consultarBtn;
	
	/** The descripcion mapa. */
	@Wire
	private Textbox descripcionMapa;
	
	/** The execute permission set. */
	private boolean executePermissionSet;
	
	/** The fecha alta. */
	@Wire
	private Datebox fechaAlta;
	
	/** The fecha modificacion. */
	@Wire
	private Datebox fechaModificacion;
	
	/** The guardar btn. */
	@Wire
	private Button guardarBtn;	
	
	
	/** The identificador mapa. */
	@Wire
	private Textbox identificadorMapa;
	
	/** The id mapa gmm. */
	@Wire
	private Textbox idMapaGmm;
	
	/** The id status. */
	@Wire
	private Textbox idStatus;
	
	/** The lbl descricion mapa. */
	@Wire
	private Label lblDescricionMapa;
	
	/** The lbl estatus. */
	@Wire
	private Label lblEstatus;
	
	/** The lbl fecha alta. */
	@Wire
	private Label lblFechaAlta;
	
	/** The lbl fecha modificacion. */
	@Wire
	private Label lblFechaModificacion;

	/** The lbl identificador mapa. */
	@Wire
	private Label lblIdentificadorMapa;
	
	/** The limpiar btn. */
	@Wire
	private Button limpiarBtn;
	
	/** The mapa gmm dto. */
	private MapaGmmDTO mapaGmmDTO =  (MapaGmmDTO) this.read();

	/** The mapa gmms grid. */
	@Wire
	private Grid mapaGmmsGrid;
	
	/** The mapa gmm vo. */
	private MapaGmmVO mapaGmmVO;
	
	/** The mapa gmm v os. */
	private List<MapaGmmVO> mapaGmmVOs = mapaGmmDTO.getMapaGmmVOs(); 
	
	/** The reporte csv btn. */
	@Wire
	private Image reporteCsvBtn;
	
	/** The reporte excel btn. */
	@Wire
	private Image reporteExcelBtn;
	
	/** The status. */
	@Wire
	private Combobox status;
	
	/** The str descripcion mapa. */
	private String strDescripcionMapa;
	
	/** The str fecha alta. */
	private String strFechaAlta;
	
	/** The str fecha modificacion. */
	private String strFechaModificacion;
	
	/** The str identificador mapa. */
	private String strIdentificadorMapa;

	/** The str id mapa gmm. */
	private String strIdMapaGmm;
	
	/** The str id status. */
	private String strIdStatus;
	
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
		componentes.put(lblIdentificadorMapa.getId(), lblIdentificadorMapa);
		componentes.put(lblFechaAlta.getId(), lblFechaAlta);
		componentes.put(lblDescricionMapa.getId(), lblDescricionMapa);
		componentes.put(lblFechaModificacion.getId(), lblFechaModificacion);
		componentes.put(lblEstatus.getId(), lblEstatus);
		componentes.put(identificadorMapa.getId(), identificadorMapa);
		componentes.put(descripcionMapa.getId(), descripcionMapa);
		componentes.put(status.getId(), status);
		componentes.put(fechaAlta.getId(), fechaAlta);
		componentes.put(fechaModificacion.getId(), fechaModificacion);
		componentes.put(reporteExcelBtn.getId(), reporteExcelBtn);
		componentes.put(reporteCsvBtn.getId(), reporteCsvBtn);
		componentes.put(limpiarBtn.getId(), limpiarBtn);
		componentes.put(guardarBtn.getId(), guardarBtn);
		componentes.put(consultarBtn.getId(), consultarBtn);
		componentes.put(mapaGmmsGrid.getId(), mapaGmmsGrid);
		super.applyPermission(MapeadorConstants.MAPAS, componentes);
		return isApplied;
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#clean()
	 */
	@Override
	@Command
	@NotifyChange({"btnGuardar"})
	public void clean() {
		//Mensajes HTML
		identificadorMapa.clearErrorMessage();
		fechaAlta.clearErrorMessage();
		fechaModificacion.clearErrorMessage();
		descripcionMapa.clearErrorMessage();
		status.clearErrorMessage();
		
		
		//Mensajes Setear a Null
		identificadorMapa.setValue(null); 
		descripcionMapa.setValue(null);
		status.setValue(null);
		 
		//Setear IDs Invisibles
		idMapaGmm.setValue(null);
		idStatus.setValue(null);
		
		identificadorMapa.setDisabled(false);
		btnGuardar = true;
		
		fechaAlta.setValue(null);
		fechaModificacion.setValue(null);
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
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		for(MapaGmmVO mapaGmmVO: mapaGmmVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(mapaGmmVO.getNombreMapaGmm());
			beanGenerico.setValor2(mapaGmmVO.getDescripcionMapaGmm());
			beanGenerico.setValor3(dateFormat.format(mapaGmmVO.getFechaAlta()));
			beanGenerico.setValor4(dateFormat.format(mapaGmmVO.getFechaModificacion())); 
			beanGenerico.setValor5(mapaGmmVO.getNombreEstatusObjeto());  
			
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}

	/**
	 * Gets the descripcion mapa.
	 *
	 * @return the descripcionMapa
	 */
	public Textbox getDescripcionMapa() {
		return descripcionMapa;
	}
	
	/**
	 * Gets the fecha alta.
	 *
	 * @return the fechaAlta
	 */
	public Datebox getFechaAlta() {
		return fechaAlta;
	}
	
	/**
	 * Gets the fecha modificacion.
	 *
	 * @return the fechaModificacion
	 */
	public Datebox getFechaModificacion() {
		return fechaModificacion;
	}
	
	/**
	 * Gets the identificador mapa.
	 *
	 * @return the identificadorMapa
	 */
	public Textbox getIdentificadorMapa() {
		return identificadorMapa;
	}	
	
	/**
	 * Gets the id mapa gmm.
	 *
	 * @return the idMapaGmm
	 */
	public Textbox getIdMapaGmm() {
		return idMapaGmm;
	}
	
	/**
	 * Gets the id status.
	 *
	 * @return the idStatus
	 */
	public Textbox getIdStatus() {
		return idStatus;
	}

	/**
	 * Gets the mapa gmm dto.
	 *
	 * @return the mapaGmmDTO
	 */
	public MapaGmmDTO getMapaGmmDTO() {
		return mapaGmmDTO;
	}

	

	/**
	 * Gets the mapa gmm vo.
	 *
	 * @return the mapaGmmVO
	 */
	public MapaGmmVO getMapaGmmVO() {
		return mapaGmmVO;
	}

	/**
	 * Gets the mapa gmm v os.
	 *
	 * @return the mapaGmmVOs
	 */
	public List<MapaGmmVO> getMapaGmmVOs() {
		return mapaGmmVOs;
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
	 * Gets the str descripcion mapa.
	 *
	 * @return the strDescripcionMapa
	 */
	public String getStrDescripcionMapa() {
		return strDescripcionMapa;
	}

	/**
	 * Gets the str fecha alta.
	 *
	 * @return the strFechaAlta
	 */
	public String getStrFechaAlta() {
		return strFechaAlta;
	}

	/**
	 * Gets the str fecha modificacion.
	 *
	 * @return the strFechaModificacion
	 */
	public String getStrFechaModificacion() {
		return strFechaModificacion;
	}

	/**
	 * Gets the str identificador mapa.
	 *
	 * @return the strIdentificadorMapa
	 */
	public String getStrIdentificadorMapa() {
		return strIdentificadorMapa;
	}

	/**
	 * Gets the str id mapa gmm.
	 *
	 * @return the strIdMapaGmm
	 */
	public String getStrIdMapaGmm() {
		return strIdMapaGmm;
	}

	/**
	 * Gets the str id status.
	 *
	 * @return the strIdStatus
	 */
	public String getStrIdStatus() {
		return strIdStatus;
	}

	/**
	 * Gets the str status.
	 *
	 * @return the strStatus
	 */
	public String getStrStatus() {
		return strStatus;
	}

	/**
	 * Checks if is btn guardar.
	 *
	 * @return the btnGuardar
	 */
	public boolean isBtnGuardar() {
		return btnGuardar;
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
		headersReport.add("Descripción");
		headersReport.add("Fecha alta");
		headersReport.add("Fecha modificación"); 
		headersReport.add("Status");
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL, nombrePantalla);
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO, nombrePantalla);
		}
		controller.createReport(generaLista(), headersReport, type, "MAPA");
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read()
	 */
	@Override
	public Object read() {
		//Catalogo Estatus
		ReportesController controller = new ReportesController();
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
		estatusObjetoVO.setNombreTabla(CommandConstants.NOMBRE_TABLA_MAPA);		
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
		if(estatusObjetoDTO.getErrorCode().equals("SQL-001")){
	    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
	    					"\nError:"+estatusObjetoDTO.getErrorCode()+
	    					"","Error de Sistema",Messagebox.OK,Messagebox.ERROR);
	    }
		MapaGmmVO mapaGmmVO = new MapaGmmVO();
		MapaGmmDTO mapaGmmDTO = new MapaGmmDTO();
		MapaGmmBO mapaGmmBO = new MapaGmmBO();
		mapaGmmDTO = mapaGmmBO.readCommand(mapaGmmDTO);
		if(mapaGmmDTO.getErrorCode().equals("SQL-001")){
	    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
	    					"\nError:"+mapaGmmDTO.getErrorCode()+
	    					"\nDescripción:"+mapaGmmDTO.getErrorDescription(),"Error de Sistema",Messagebox.OK,Messagebox.ERROR);
	    }
		logger.info("::::::::::::::SIZE::::::::::" + mapaGmmDTO.getMapaGmmVOs());
		//Seteo Catalogo de Estatus
		mapaGmmDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
		//controller.registrarEvento(mapaGmmVO, mapaGmmVO, CommandConstants.CONSULTAR, nombrePantalla);
		return mapaGmmDTO;
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
	 * @param mapaGmmVO the mapa gmm vo
	 */
	@Command
	@NotifyChange({ "btnGuardar"})
	public void readSelected(@BindingParam("idMapaGmm") final MapaGmmVO mapaGmmVO){
		//Seteo de datos de Acuerdo al id de los compoenetes del HTML VS VO
		mapaGmmVO.toString();
		this.mapaGmmVO = mapaGmmVO;
		status.setValue(mapaGmmVO.getNombreEstatusObjeto());
		identificadorMapa.setValue(mapaGmmVO.getNombreMapaGmm());
		descripcionMapa.setValue(mapaGmmVO.getDescripcionMapaGmm());
		idMapaGmm.setValue(String.valueOf(mapaGmmVO.getIdMapaGmm()));
		fechaAlta.setValue(mapaGmmVO.getFechaAlta());
		fechaModificacion.setValue(mapaGmmVO.getFechaModificacion());
		identificadorMapa.setDisabled(true);
		btnGuardar = false;
	}

	//Cambiar al objeto que pertenezca el componente en este caso mapaGmmVOs
	/**
	 * Read with filters.
	 */
	@GlobalCommand
	@Command
	@NotifyChange({ "mapaGmmVOs" })
	public void readWithFilters() {
		ReportesController controller = new ReportesController();
		MapaGmmDTO mapaGmmDTO = new MapaGmmDTO();
		MapaGmmVO mapaGmmVO = new MapaGmmVO(); 
		//Textbox
		mapaGmmVO.setNombreMapaGmm(identificadorMapa.getValue().isEmpty()?"%":"%"+identificadorMapa.getValue().toUpperCase()+"%");
		mapaGmmVO.setDescripcionMapaGmm(descripcionMapa.getValue().isEmpty()?"%":"%"+descripcionMapa.getValue().toUpperCase()+"%");
		//Fechas

//		mapaGmmVO.setFechaAlta(fechaAlta.getValue());
//		mapaGmmVO.setFechaModificacion(fechaModificacion.getValue());
		
		//Combos Validar el nombre de los parametros en HTML VS Controller
		mapaGmmVO.setIdEstatusObjeto((Integer.parseInt(idStatus.getValue().isEmpty()?"0":idStatus.getValue())));
		
		//Consulta Parametrizada

		mapaGmmDTO.setMapaGmmVO(mapaGmmVO);
		mapaGmmDTO.toString(BbvaAbstractDataTransferObject.XML);	
		
		//LLamada a BO  MapaGmm para consulta por criterio
		MapaGmmBO mapaGmmBO = new MapaGmmBO();
		
		//Asignacion resultado de consulta al mismo DTO de MapaGmm
		mapaGmmDTO = mapaGmmBO.readCommand(mapaGmmDTO);
		if(mapaGmmDTO.getErrorCode().equals("SQL-001")){
	    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
	    					"\nError:"+mapaGmmDTO.getErrorCode()+
	    					"\nDescripción:"+mapaGmmDTO.getErrorDescription(),"Error de Sistema",Messagebox.OK,Messagebox.ERROR);
	    }
		
		//Tamaño de la lista de acuerdo al criterio de busqueda y objeto MapaGmm
		if(mapaGmmDTO.getMapaGmmVOs() != null) {
			logger.debug("size:"+mapaGmmDTO.getMapaGmmVOs().size());
		} else{
			logger.debug(":::::::::::Lista Vacia::::::::::");
		}
		//Asignacion de la lista a la variable global de la clase
		mapaGmmVOs = mapaGmmDTO.getMapaGmmVOs();
		controller.registrarEvento(mapaGmmVO, mapaGmmVO,  CommandConstants.CONSULTAR,"Catálogo de Mapa");

		
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#save()
	 */
	@Override
	@Command
	@NotifyChange({ "mapaGmmVOs", "btnGuardar" })
	public void save() {
		final ReportesController controller = new ReportesController();
		//Validar Todos Los campos de pantalla
		boolean errorGuardar = false; 
		if (status.getSelectedItem() == null
				|| status.getSelectedItem().getValue() == null
				|| status.getSelectedItem().getValue().toString().isEmpty()) {
			status.setErrorMessage("Favor de seleccionar la Status.");
			errorGuardar = true;
		}
		if (identificadorMapa.getValue().isEmpty()) {
			identificadorMapa
					.setErrorMessage("Favor de introducir Identificador Mapa");
			errorGuardar = true;
		} 
		if (descripcionMapa.getValue().isEmpty()) {
			descripcionMapa
					.setErrorMessage("Favor de introducir Descripción Mapa");
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
						if(!idMapaGmm.getValue().isEmpty()){
							logger.info("::::::Actualizar::::");
							MapaGmmDTO mapaGmmDTO = new MapaGmmDTO();
							MapaGmmVO mapaGmmVOL = new MapaGmmVO();
							mapaGmmVOL.setIdMapaGmm(Integer.parseInt(idMapaGmm.getValue().isEmpty()?"0":idMapaGmm.getValue()));
							mapaGmmVOL.setIdEstatusObjeto(Integer.parseInt(status.getSelectedItem().getValue().toString().isEmpty()? ""+ CommandConstants.ID_MAPA_ACTIVO:status.getSelectedItem().getValue().toString()));
							
							mapaGmmVOL.setNombreMapaGmm(identificadorMapa.getValue().toUpperCase().trim());
							mapaGmmVOL.setDescripcionMapaGmm(descripcionMapa.getValue().toUpperCase().trim());
										
							//Seteo de VO a DTO 
							mapaGmmDTO.setMapaGmmVO(mapaGmmVOL);
							mapaGmmDTO.toString(BbvaAbstractDataTransferObject.XML);	
							
							MapaGmmBO mapaGmmBO = new MapaGmmBO();
							mapaGmmDTO = mapaGmmBO.updateCommand(mapaGmmDTO);							
							if(mapaGmmDTO.getErrorCode().equals("SQL-001")){
						    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
						    					"\nError:"+mapaGmmDTO.getErrorCode()+
						    					"\nDescripción:"+mapaGmmDTO.getErrorDescription(),"Error de Sistema",Messagebox.OK,Messagebox.ERROR);
						    	controller.registrarEvento(mapaGmmVOL, mapaGmmVO, CommandConstants.ERROR_SISTEMA, nombrePantalla);
						    }else{
								if (Integer.parseInt(status.getSelectedItem().getValue().toString())==CommandConstants.ID_MAPA_INACTIVO) { 
									controller.registrarEvento(mapaGmmVOL, mapaGmmVO, CommandConstants.INACTIVACION, nombrePantalla);				
								} else {
									controller.registrarEvento(mapaGmmVOL, mapaGmmVO, CommandConstants.MODIFICACION,nombrePantalla);
								}
								
								
								clean();			
								
								//Textbox
								mapaGmmVO = new MapaGmmVO();
								
								//Consulta Parametrizada
				
								mapaGmmDTO.setMapaGmmVO(mapaGmmVO);
								mapaGmmDTO.toString(BbvaAbstractDataTransferObject.XML);	
								
								//LLamada a BO  MapaGmm para consulta por criterio							
								
								//Asignacion resultado de consulta al mismo DTO de MapaGmm
								mapaGmmDTO = mapaGmmBO.readCommand(mapaGmmDTO);
								if(mapaGmmDTO.getErrorCode().equals("SQL-001")){
							    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
							    					"\nError:"+mapaGmmDTO.getErrorCode()+
							    					"\nDescripción:"+mapaGmmDTO.getErrorDescription(),"Error de Sistema",Messagebox.OK,Messagebox.ERROR);
							    }
								
								btnGuardar = true;
				
								org.zkoss.zul.Messagebox.show("Registro actualizado con exito!!",
										"Información", org.zkoss.zul.Messagebox.OK,
										org.zkoss.zul.Messagebox.INFORMATION);
								
								mapaGmmVOs = mapaGmmDTO.getMapaGmmVOs();
								identificadorMapa.setDisabled(false);
						    }
							
						}else{ 
							logger.info("::::::NO Crea::::"); 
			
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
	 * Sets the btn guardar.
	 *
	 * @param btnGuardar the btnGuardar to set
	 */
	public void setBtnGuardar(boolean btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	/**
	 * Sets the descripcion mapa.
	 *
	 * @param descripcionMapa the descripcionMapa to set
	 */
	public void setDescripcionMapa(Textbox descripcionMapa) {
		this.descripcionMapa = descripcionMapa;
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
	 * Sets the fecha alta.
	 *
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(Datebox fechaAlta) {
		this.fechaAlta = fechaAlta;
	}


	/**
	 * Sets the fecha modificacion.
	 *
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Datebox fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * Sets the identificador mapa.
	 *
	 * @param identificadorMapa the identificadorMapa to set
	 */
	public void setIdentificadorMapa(Textbox identificadorMapa) {
		this.identificadorMapa = identificadorMapa;
	}

	/**
	 * Sets the id mapa gmm.
	 *
	 * @param idMapaGmm the idMapaGmm to set
	 */
	public void setIdMapaGmm(Textbox idMapaGmm) {
		this.idMapaGmm = idMapaGmm;
	}

	/**
	 * Sets the id status.
	 *
	 * @param idStatus the idStatus to set
	 */
	public void setIdStatus(Textbox idStatus) {
		this.idStatus = idStatus;
	}

	/**
	 * Sets the mapa gmm dto.
	 *
	 * @param mapaGmmDTO the mapaGmmDTO to set
	 */
	public void setMapaGmmDTO(MapaGmmDTO mapaGmmDTO) {
		this.mapaGmmDTO = mapaGmmDTO;
	}

	/**
	 * Sets the mapa gmm vo.
	 *
	 * @param mapaGmmVO the mapaGmmVO to set
	 */
	public void setMapaGmmVO(MapaGmmVO mapaGmmVO) {
		this.mapaGmmVO = mapaGmmVO;
	}

	/**
	 * Sets the mapa gmm v os.
	 *
	 * @param mapaGmmVOs the mapaGmmVOs to set
	 */
	public void setMapaGmmVOs(List<MapaGmmVO> mapaGmmVOs) {
		this.mapaGmmVOs = mapaGmmVOs;
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
	 * Sets the str descripcion mapa.
	 *
	 * @param strDescripcionMapa the strDescripcionMapa to set
	 */
	public void setStrDescripcionMapa(String strDescripcionMapa) {
		this.strDescripcionMapa = strDescripcionMapa;
	}
	
	/**
	 * Sets the str fecha alta.
	 *
	 * @param strFechaAlta the strFechaAlta to set
	 */
	public void setStrFechaAlta(String strFechaAlta) {
		this.strFechaAlta = strFechaAlta;
	}
	
	/**
	 * Sets the str fecha modificacion.
	 *
	 * @param strFechaModificacion the strFechaModificacion to set
	 */
	public void setStrFechaModificacion(String strFechaModificacion) {
		this.strFechaModificacion = strFechaModificacion;
	}	

	
	/**
	 * Sets the str identificador mapa.
	 *
	 * @param strIdentificadorMapa the strIdentificadorMapa to set
	 */
	public void setStrIdentificadorMapa(String strIdentificadorMapa) {
		this.strIdentificadorMapa = strIdentificadorMapa;
	}

	/**
	 * Sets the str id mapa gmm.
	 *
	 * @param strIdMapaGmm the strIdMapaGmm to set
	 */
	public void setStrIdMapaGmm(String strIdMapaGmm) {
		this.strIdMapaGmm = strIdMapaGmm;
	}

	/**
	 * Sets the str id status.
	 *
	 * @param strIdStatus the strIdStatus to set
	 */
	public void setStrIdStatus(String strIdStatus) {
		this.strIdStatus = strIdStatus;
	}

	/**
	 * Sets the str status.
	 *
	 * @param strStatus the strStatus to set
	 */
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}
	
}
