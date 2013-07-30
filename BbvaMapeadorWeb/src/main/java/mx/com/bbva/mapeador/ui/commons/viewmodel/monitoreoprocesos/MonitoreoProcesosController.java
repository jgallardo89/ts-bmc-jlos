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
 * Nombre de clase: MonitoreoProcesosController.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.monitoreoprocesos
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.monitoreoprocesos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.com.bbva.bancomer.bussinnes.model.vo.CanalVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ClienteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MonitoreoProcesosVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ProductoVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.canal.dto.CanalDTO;
import mx.com.bbva.bancomer.cliente.dto.ClienteDTO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.CanalBO;
import mx.com.bbva.bancomer.mapper.business.ClienteBO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.MonitoreoProcesosBO;
import mx.com.bbva.bancomer.mapper.business.ProductoBO;
import mx.com.bbva.bancomer.monitoreoprocesos.dto.MonitoreoProcesosDTO;
import mx.com.bbva.bancomer.producto.dto.ProductoDTO;
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
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zhtml.Table;
import org.zkoss.zhtml.Tbody;
import org.zkoss.zhtml.Td;
import org.zkoss.zhtml.Th;
import org.zkoss.zhtml.Thead;
import org.zkoss.zhtml.Tr;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

// TODO: Auto-generated Javadoc
/**
 * The Class MonitoreoProcesosController.
 */
public class MonitoreoProcesosController extends ControllerSupport implements  IController{
	private MonitoreoProcesosVO monitoreoProcesosVO1;
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(MonitoreoProcesosController.class);
	private MonitoreoProcesosDTO monitoreoProcesosDTOUpdate;
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The btn guardar. */
	private boolean btnGuardar;
	
	Table table;
	Tbody tbody; 
	
	/** The canal. */
	@Wire
	private Combobox canal;
	
	/** The criterios. */
	@Wire
	private Combobox criterios;
	
	/** The cliente. */
	@Wire
	private Combobox cliente;
	
	/** The consultar btn. */
	@Wire
	private Button consultarBtn;
	
	/** The criterio. */
	@Wire
	private Combobox criterio;
	
	/** The detalle proceso window. */
	@Wire
    Window detalleProcesoWindow;
	
	/** The error. */
	@Wire
	private Checkbox error;
	
	/** The espera. */
	@Wire
	private Checkbox espera;
	
	/** The estatus. */
	@Wire
	private Combobox estatus;
	
	/** The etapa vo. */
	private EtapaVO etapaVO;
	
	/** The execute permission set. */
	private boolean executePermissionSet;
	
	/** The exito. */
	@Wire
	private Checkbox exito;
	
	/** The fecha fin. */
	@Wire
	private Datebox fechaFin;
	
	/** The fecha inicio. */
	@Wire
	private Datebox fechaInicio;
	
	/** The finaliza. */
	@Wire
	private Checkbox finaliza;
	
	/** The guardar btn. */
	@Wire
	private Button guardarBtn;
	
	/** The div Tabla. */
	@Wire
	private Div divTabla;
	
	/** The id canal. */
	@Wire
	private Textbox idCanal;
	
	/** The id cliente. */
	@Wire
	private Textbox idCliente;
	
	/** The id contratacion. */
	@Wire
	private Textbox idContratacion;
	
	/** The id criterio. */
	@Wire
	private Textbox idCriterio;
	
	/** The id estatus. */
	@Wire
	private Textbox idEstatus;
	
	/** The id etapa. */
	@Wire
	private Textbox idEtapa;
	
	/** The id flujo. */
	@Wire
	private Textbox idFlujo;	
	
	
	/** The id producto. */
	@Wire
	private Textbox idProducto;
	
	/** The lbl a. */
	@Wire
	private Label lblA;
	
	/** The lbl canal. */
	@Wire
	private Label lblCanal;
	
	/** The lbl cliente. */
	@Wire
	private Label lblCliente;
	
	/** The lbl estatus. */
	@Wire
	private Label lblEstatus;
	
	/** The lbl fecha lote. */
	@Wire
	private Label lblFechaLote;
	
	/** The lbl lote. */
	@Wire
	private Label lblLote;
	
	/** The lbl producto. */
	@Wire
	private Label lblProducto;
	
	/** The limpiar btn. */
	@Wire
	private Button limpiarBtn;
	
	/** The lote. */
	@Wire
	private Textbox lote;
	
	/** The monitoreo procesos dto. */
	private MonitoreoProcesosDTO monitoreoProcesosDTO = (MonitoreoProcesosDTO) this.read();
	
	/** The monitoreo procesos vo. */
	private MonitoreoProcesosVO monitoreoProcesosVO;
	
	/** The monitoreo procesos v os. */
	private List<MonitoreoProcesosVO> monitoreoProcesosVOs = monitoreoProcesosDTO.getMonitoreoProcesosVOs();
	
	/** The procesos grid. */
	@Wire
	private Grid procesosGrid;
	
	/** The proceso v os. */
	private List<ProcesoVO> procesoVOs = getProcesoVOs();
	
	/** The producto. */
	@Wire
	private Combobox producto;
	
	/** The reporte csv btn. */
	@Wire
	private Image reporteCsvBtn;
	
	/** The reporte excel btn. */
	@Wire
	private Image reporteExcelBtn;
	
	/** The str canal. */
	private String strCanal;
	
	/** The str cliente. */
	private String strCliente;
	
	/** The str estatus. */
	private String strEstatus;
	
	/** The str fecha fin. */
	private String strFechaFin;
	
	/** The str fecha inicio. */
	private String strFechaInicio;
	
	/** The str id canal. */
	private String strIdCanal;
	
	/** The str id cliente. */
	private String strIdCliente;
	
	/** The str id criterio. */
	private String strIdCriterio;
	
	/** The str id estatus. */
	private String strIdEstatus;
	
	/** The str id producto. */
	private String strIdProducto;
	
	/** The str lote. */
	private String strLote;
	
	/** The str producto. */
	private String strProducto;
	
	/** The todos. */
	@Wire
	private Checkbox todos;
	
	/**
	 * After compose.
	 *
	 * @param view the view
	 */
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
        executePermissionSet = this.applyPermision();
        fechaFin.setValue(new Date());
        fechaInicio.setValue(new Date());
        todos.setChecked(true);
        readWithFilters();
    }
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#applyPermision()
	 */
	@Override
	public boolean applyPermision() {
		boolean isApplied = false;
		HashMap<String, Component> componentes = new HashMap<String, Component>();
//		componentes.put(lblCanal.getId(), lblCanal);
//		componentes.put(lblCliente.getId(), lblCliente);
//		componentes.put(lblProducto.getId(), lblProducto);
//		componentes.put(lblEstatus.getId(), lblEstatus);
//		componentes.put(lblFechaLote.getId(), lblFechaLote);
//		componentes.put(lblA.getId(), lblA);
//		componentes.put(lblLote.getId(), lblLote);
//		componentes.put(canal.getId(), canal);
//		componentes.put(cliente.getId(), cliente);
//		componentes.put(producto.getId(), producto);
////		componentes.put(estatus.getId(), estatus);
//		componentes.put(fechaInicio.getId(), fechaInicio);
//		componentes.put(fechaFin.getId(), fechaFin);
//		componentes.put(lote.getId(), lote);
//		componentes.put(reporteExcelBtn.getId(), reporteExcelBtn);
//		componentes.put(reporteCsvBtn.getId(), reporteCsvBtn);
//		componentes.put(limpiarBtn.getId(), limpiarBtn);
//		componentes.put(consultarBtn.getId(), consultarBtn);
////		componentes.put(procesosGrid.getId(), procesosGrid);
		super.applyPermission(MapeadorConstants.MONITOREO, componentes);
		return isApplied;
	}
	/**
	 * Armar lista grid.
	 *
	 */
	private void armarListaGrid(MonitoreoProcesosDTO monitoreoProcesosDTO){			
		int tipoReporte = monitoreoProcesosDTO.getTipoReporte();
		armaEstiloTabla();		
		armaEncabezadoTabla(tipoReporte);
		monitoreoProcesosDTO.getMonitoreoProcesosVO().setTipoReporte(tipoReporte);		
		armaCuerpoTablaCanalClienteProducto(monitoreoProcesosDTO);												
	}
	public void armaCuerpoTablaCanalClienteProducto(MonitoreoProcesosDTO monitoreoProcesosDTO){
		//Leo los canales
		MonitoreoProcesosBO monitoreoProcesosBO = new MonitoreoProcesosBO();
		monitoreoProcesosDTO.setCommandId(CommandConstants.PROCESOS_CANAL);
		List<MonitoreoProcesosVO> monitoreoProcesosVOsCanal;
		monitoreoProcesosVOsCanal = ((MonitoreoProcesosDTO)monitoreoProcesosBO.readCommand(monitoreoProcesosDTO)).getMonitoreoProcesosVOs();
		List<MonitoreoProcesosVO> monitoreoProcesosVOsProductos;
		MonitoreoProcesosDTO monitoreoProcesosDTOProductos = new MonitoreoProcesosDTO();
		MonitoreoProcesosVO monitoreoProcesosVOProductos;
		MonitoreoProcesosDTO monitoreoProcesosDTOEstatusProceso = new MonitoreoProcesosDTO();
		List<MonitoreoProcesosVO> monitoreoProcesosVOsEstatus;
		int estatusProceso;
		for (MonitoreoProcesosVO monitoreoProcesosVO : monitoreoProcesosVOsCanal) {			
			monitoreoProcesosDTOEstatusProceso.setMonitoreoProcesosVO(monitoreoProcesosVO);
			monitoreoProcesosDTOEstatusProceso.setCommandId(CommandConstants.PROCESOS_ESTATUS);
			monitoreoProcesosVOsEstatus = ((MonitoreoProcesosDTO)monitoreoProcesosBO.readCommand(monitoreoProcesosDTOEstatusProceso)).getMonitoreoProcesosVOs();
			estatusProceso = obtieneEstatusProceso(monitoreoProcesosVOsEstatus);
			monitoreoProcesosVO.setIdEstatusMapeador(estatusProceso);
			armaRegistroNivel1(monitoreoProcesosVO,monitoreoProcesosDTO.getTipoReporte());
			armaEncabezadoNivel1();
			monitoreoProcesosDTOProductos.setCommandId(CommandConstants.PROCESOS_ARCHIVOS);
			monitoreoProcesosVOProductos = new MonitoreoProcesosVO();
			monitoreoProcesosVOProductos.setIdCanal(monitoreoProcesosVO.getIdCanal());
			monitoreoProcesosVOProductos.setIdCliente(monitoreoProcesosVO.getIdCliente());
			monitoreoProcesosVOProductos.setIdProducto(monitoreoProcesosVO.getIdProducto());
			monitoreoProcesosVOProductos.setNumeroLote(monitoreoProcesosVO.getNumeroLote());
			monitoreoProcesosVOProductos.setFechaStatusProceso(monitoreoProcesosVO.getFechaStatusProceso());			
			monitoreoProcesosDTOProductos.setMonitoreoProcesosVO(monitoreoProcesosVOProductos);
			monitoreoProcesosDTOProductos.getMonitoreoProcesosVO().setEstados(monitoreoProcesosDTO.getMonitoreoProcesosVO().getEstados());
			monitoreoProcesosVOsProductos = ((MonitoreoProcesosDTO)monitoreoProcesosBO.readCommand(monitoreoProcesosDTOProductos)).getMonitoreoProcesosVOs();
			logger.debug("monitoreoProcesosVOsProductos:"+monitoreoProcesosVOsProductos.size());
			armaHijos(monitoreoProcesosVOsProductos);
		}			
	}
	public int obtieneEstatusProceso(List<MonitoreoProcesosVO> monitoreoProcesosVOsEstatus){
		int estatus =0;
		int amarillo = 0;
		int rojo = 0;
		int azul = 0;
		int verde = 0;
		for (MonitoreoProcesosVO monitoreoProcesosVO : monitoreoProcesosVOsEstatus) {
			if(monitoreoProcesosVO.getIdEstatusMapeador()==CommandConstants.PROCESO_ERROR_ROJO){
				rojo++;
			}else if(monitoreoProcesosVO.getIdEstatusMapeador()==CommandConstants.PROCESO_FINALIZA_USUARIO_AZUL){
				azul++;				
			}else if(monitoreoProcesosVO.getIdEstatusMapeador()==CommandConstants.PROCESO_ESPERA_AMARILLO){
				amarillo++;				
			}else if(monitoreoProcesosVO.getIdEstatusMapeador()==CommandConstants.PROCESO_EXITO_VERDE){
				verde++;				
			}
			
		}
		if(rojo!=0)
			estatus = CommandConstants.PROCESO_ERROR_ROJO;
		else if(azul!=0)
			estatus = CommandConstants.PROCESO_FINALIZA_USUARIO_AZUL;
		else if(amarillo!=0)
			estatus = CommandConstants.PROCESO_ESPERA_AMARILLO;
		else if(verde!=0)
			estatus = CommandConstants.PROCESO_EXITO_VERDE;
		return estatus;
	}
	public void armaEstiloTabla(){
		try{
			divTabla.removeChild(table);
		}catch(Exception ex){
			//NO HACER NADA
		}
		divTabla.setSclass("divTabla");
		table = new Table();
		tbody = new Tbody();
		table.setStyle("width:100%");
		table.appendChild(tbody);		
		divTabla.appendChild(table);
	}
	
	public void armaEncabezadoTabla(int tipoReporte){
		Thead thead = new Thead();
		Th th1 = new Th();
		Th th2 = new Th();
		Th th3 = new Th();
		Th th4 = new Th();
		Th th5 = new Th();
		Th th6 = new Th();
		switch (tipoReporte) {
			case CommandConstants.CANAL_CLIENTE_PRODUCTO:										
				th1.appendChild(new Label("Canal"));				
				th2.appendChild(new Label("Cliente"));				
				th3.appendChild(new Label("Producto"));				
				th4.appendChild(new Label("Fecha Lote"));				
				th5.appendChild(new Label("Lote"));				
				th6.appendChild(new Label("Status"));					
				break;
			case CommandConstants.CLIENTE_CANAL_PRODUCTO:
				th1.appendChild(new Label("Cliente"));				
				th2.appendChild(new Label("Canal"));				
				th3.appendChild(new Label("Producto"));				
				th4.appendChild(new Label("Fecha Lote"));				
				th5.appendChild(new Label("Lote"));				
				th6.appendChild(new Label("Status"));	
				break;
			case CommandConstants.PRODUCTO_CANAL_CLIENTE:
				th1.appendChild(new Label("Producto"));				
				th2.appendChild(new Label("Canal"));				
				th3.appendChild(new Label("Cliente"));				
				th4.appendChild(new Label("Fecha Lote"));				
				th5.appendChild(new Label("Lote"));				
				th6.appendChild(new Label("Status"));	
				break;
			default:
				break;
		}		
		thead.setSclass("sClassThead");
		thead.appendChild(th1);
		thead.appendChild(th2);
		thead.appendChild(th3);			
		thead.appendChild(th4);
		thead.appendChild(th5);
		thead.appendChild(th6);				
		table.appendChild(thead);
	}
	
	public void armaEncabezadoNivel1(){
		Tr tr = new Tr();	
		tr.setSclass("sClassTitulos");
		Td td1 = new Td();
		td1.appendChild(new Label("ETAPA"));
		Td td2 = new Td();
		td2.appendChild(new Label("NOMBRE ARCHIVO"));
		Td td3 = new Td();
		td3.appendChild(new Label("FECHA INICIO"));
		Td td4 = new Td();
		td4.appendChild(new Label("HORA INICIO"));
		Td td5 = new Td();
		td5.appendChild(new Label("HORA FIN"));
		Td td6 = new Td();
		td6.appendChild(new Label("STATUS"));		
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tr.appendChild(td5);
		tr.appendChild(td6);
		tbody.appendChild(tr);
	}
	public void armaRegistroNivel1(MonitoreoProcesosVO monitoreoProcesosVO, int tipoReporte){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Tr tr = new Tr();	
		tr.setSclass("sClassDatosPrimerNivel");
		Td td1 = new Td();
		Td td2 = new Td();
		Td td3 = new Td();
		Td td4 = new Td();
		Td td5 = new Td();
		Td td6 = new Td();
		switch (tipoReporte) {
		case CommandConstants.CANAL_CLIENTE_PRODUCTO:
			td1.appendChild(new Label(monitoreoProcesosVO.getNombreCanal()));		
			td2.appendChild(new Label(monitoreoProcesosVO.getNombreCliente()));		
			td3.appendChild(new Label(monitoreoProcesosVO.getNombreProducto()));							
			break;
		case CommandConstants.CLIENTE_CANAL_PRODUCTO:
			td1.appendChild(new Label(monitoreoProcesosVO.getNombreCliente()));		
			td2.appendChild(new Label(monitoreoProcesosVO.getNombreCanal()));		
			td3.appendChild(new Label(monitoreoProcesosVO.getNombreProducto()));
			break;
		case CommandConstants.PRODUCTO_CANAL_CLIENTE:
			td1.appendChild(new Label(monitoreoProcesosVO.getNombreProducto()));
			td2.appendChild(new Label(monitoreoProcesosVO.getNombreCanal()));		
			td3.appendChild(new Label(monitoreoProcesosVO.getNombreCliente()));					
			break;
		default:
			break;
		}
		
		td4.appendChild(new Label(dateFormat.format(monitoreoProcesosVO.getFechaStatusProceso())));		
		td5.appendChild(new Label(Long.toString(monitoreoProcesosVO.getNumeroLote())));		
		String urlImage = "";
		if(monitoreoProcesosVO.getIdEstatusMapeador()==CommandConstants.PROCESO_EXITO_VERDE)
			urlImage = CommandConstants.IMG_VERDE_EXITO_PNG; 
		else if(monitoreoProcesosVO.getIdEstatusMapeador()==CommandConstants.PROCESO_ERROR_ROJO)
			urlImage = CommandConstants.IMG_ERROR_ROJO_PNG;
		else if(monitoreoProcesosVO.getIdEstatusMapeador()==CommandConstants.PROCESO_ESPERA_AMARILLO)
			urlImage = CommandConstants.IMG_AMARILLO_ESPERA_PNG;
		else if(monitoreoProcesosVO.getIdEstatusMapeador()==CommandConstants.PROCESO_FINALIZA_USUARIO_AZUL)
			urlImage = CommandConstants.IMG_AZUL_FINALIZAUSUARIO_PNG;
		td6.appendChild(new Image(urlImage));
		
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tr.appendChild(td5);
		tr.appendChild(td6);
		tbody.appendChild(tr);
	}
	public void armaHijos(List<MonitoreoProcesosVO> monitoreoProcesosVOsProductos){
		Tr tr;
		Td td1;
		Td td2;
		Td td3;
		Td td4;
		Td td5;
		Td td6;
		for (MonitoreoProcesosVO monitoreoProcesosVO2 : monitoreoProcesosVOsProductos) {
			monitoreoProcesosVO1 = monitoreoProcesosVO2;
			tr = new Tr();	
			tr.setSclass("sClassArchivos");
			td1 = new Td();
			td1.appendChild(new Label(monitoreoProcesosVO1.getNombreEtapa()));
			td2 = new Td();
			td2.appendChild(new Label(monitoreoProcesosVO1.getNombreRegArchEntra()));
			td3 = new Td();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			td3.appendChild(new Label(dateFormat.format(monitoreoProcesosVO1.getFechaStatusProceso())));			
			td4 = new Td();			
			td4.appendChild(new Label(monitoreoProcesosVO1.getFechaInicio()));
			td5 = new Td();			
			td5.appendChild(new Label(monitoreoProcesosVO1.getFechaFin()));
			td6 = new Td();
			String urlImage = "";
			Image image = new Image();
			if(monitoreoProcesosVO1.getIdEstatusMapeador()==CommandConstants.PROCESO_EXITO_VERDE)
				urlImage = CommandConstants.IMG_VERDE_EXITO_PNG; 
			else if(monitoreoProcesosVO1.getIdEstatusMapeador()==CommandConstants.PROCESO_ERROR_ROJO){
				urlImage = CommandConstants.IMG_ERROR_ROJO_PNG;
				image.setAttribute("idProceso", monitoreoProcesosVO);				
				String data;
				final DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				data = monitoreoProcesosVO1.getIdContratacion()+"-"+
					monitoreoProcesosVO1.getIdFlujo()+"-"+
					monitoreoProcesosVO1.getIdEtapa()+"-"+					
					format.format(monitoreoProcesosVO1.getFechaStatusProceso())+"-"+
					monitoreoProcesosVO1.getNumeroLote();
				image.setAutag(data);
				image.setSclass("buttonStyle");
				image.addEventListener("onClick", new EventListener<Event>() {
					@Override
					public void onEvent(Event event) throws Exception {						
						logger.debug("monitoreoProcesosVO..to..update:"+event.getTarget().getAutag());									
						final String[] valuesToUpdate = event.getTarget().getAutag().split("-");
						logger.debug(valuesToUpdate.length);						
						Messagebox.show("¿Está seguro que desea actualizar el estatus?",
								"Pregunta", org.zkoss.zul.Messagebox.YES | org.zkoss.zul.Messagebox.NO,
								org.zkoss.zul.Messagebox.QUESTION, new EventListener<Event>() {
							@Override
							public void onEvent(Event event) throws Exception {
								if (event.getName().equals(Messagebox.ON_YES)) {
									MonitoreoProcesosBO monitoreoProcesosBO = new MonitoreoProcesosBO();
									monitoreoProcesosDTOUpdate = new MonitoreoProcesosDTO();
									ReportesController  controller = new ReportesController();
									logger.debug("target:"+	event.getTarget());
									MonitoreoProcesosVO monitoreoProcesosVO;															
									MonitoreoProcesosVO monitoreoProcesosVONuevo;
									monitoreoProcesosVO = new MonitoreoProcesosVO();						
									monitoreoProcesosVONuevo = new MonitoreoProcesosVO();
									monitoreoProcesosVO.setIdContratacion(Long.parseLong(valuesToUpdate[0]));
									monitoreoProcesosVO.setIdFlujo(Long.parseLong(valuesToUpdate[1]));
									monitoreoProcesosVO.setIdEtapa(Long.parseLong(valuesToUpdate[2]));						
									monitoreoProcesosVO.setFechaStatusProceso(format.parse(valuesToUpdate[3]));
									monitoreoProcesosVO.setNumeroLote(Long.parseLong(valuesToUpdate[4]));
									monitoreoProcesosVO.setIdEstatusMapeador(36);
									monitoreoProcesosVO.setDescripcionContratacion( "El usuario "+ getSessionUser().getCveUsuario() + " ha terminado esta etapa");
									
									monitoreoProcesosDTOUpdate.setMonitoreoProcesosVO(monitoreoProcesosVO);
									monitoreoProcesosDTOUpdate = monitoreoProcesosBO.updateCommand(monitoreoProcesosDTOUpdate);									
									
									MonitoreoProcesosVO monitoreoProcesosVOAnt = monitoreoProcesosVO;
									monitoreoProcesosVOAnt.setDescripcionContratacion("");
									monitoreoProcesosVOAnt.setIdEstatusMapeador(35);
									monitoreoProcesosVONuevo.setIdEstatusMapeador(36);
									monitoreoProcesosVONuevo.setDescripcionContratacion( "El usuario "+ getSessionUser().getCveUsuario() + " ha terminado esta etapa");
									monitoreoProcesosVOAnt.setIdEstatusMapeador(CommandConstants.PROCESO_ERROR_ROJO);
									controller.registrarEvento(monitoreoProcesosVONuevo, monitoreoProcesosVOAnt, CommandConstants.MODIFICACION,"Monitoreo de Procesos");
									BindUtils.postGlobalCommand(null, null, "readWithFilters", null);
									Messagebox.show("Registro actualizado con exito!!",
											"Información", org.zkoss.zul.Messagebox.OK,
											org.zkoss.zul.Messagebox.INFORMATION);
								}
							}
						});	
					}
				});
				td6.setStyle("cursor: pointer;");
			}
			else if(monitoreoProcesosVO1.getIdEstatusMapeador()==CommandConstants.PROCESO_ESPERA_AMARILLO)
				urlImage = CommandConstants.IMG_AMARILLO_ESPERA_PNG;
			else if(monitoreoProcesosVO1.getIdEstatusMapeador()==CommandConstants.PROCESO_FINALIZA_USUARIO_AZUL)
				urlImage = CommandConstants.IMG_AZUL_FINALIZAUSUARIO_PNG;
			image.setSrc(urlImage);
			logger.debug("monitoreoProcesosVO1.getDescripcionContratacion():"+monitoreoProcesosVO1.getDescripcionContratacion());
			image.setTooltiptext(monitoreoProcesosVO1.getDescripcionContratacion()==null?"":monitoreoProcesosVO1.getDescripcionContratacion());
			td6.appendChild(image);		
			tr.appendChild(td1);
			tr.appendChild(td2);
			tr.appendChild(td3);
			tr.appendChild(td4);
			tr.appendChild(td5);
			tr.appendChild(td6);
			tbody.appendChild(tr);
		}
	}
	@Command
	public void updateEtapa(){
		logger.debug("updateEtapa-monitoreoProcesosVO:"+monitoreoProcesosVO);
//		monitoreoProcesosDTO.setMonitoreoProcesosVO(monitoreoProcesosVO);
//		monitoreoProcesosDTO = monitoreoProcesosBO.updateCommand(monitoreoProcesosDTO);
//		armarListaGrid(monitoreoProcesosDTO.getMonitoreoProcesosVOs());
//		controller.registrarEvento(monitoreoProcesosVO, this.monitoreoProcesosVO, CommandConstants.MODIFICACION,"Monitoreo de Procesos");
//		org.zkoss.zul.Messagebox.show("Registro actualizado con exito!!",
//				"Información", org.zkoss.zul.Messagebox.OK,
//				org.zkoss.zul.Messagebox.INFORMATION);
	}
	/**
	 * Armar lista grid.
	 *
	 * @param listaMonitoreoProcesosVO the lista monitoreo procesos vo
	 */
	private void armarListaGrid(List<MonitoreoProcesosVO> listaMonitoreoProcesosVO){ 
		List<ProcesoVO> procesoVOs =  new ArrayList<ProcesoVO>();
		
		if(listaMonitoreoProcesosVO != null){ 
			for (MonitoreoProcesosVO mProcesosVO : listaMonitoreoProcesosVO) {
				ProcesoVO procesoVO = new ProcesoVO();
				procesoVO.setIdCanal(mProcesosVO.getIdCanal());
				procesoVO.setNombreCanal(mProcesosVO.getNombreCanal());
				procesoVO.setIdCliente(mProcesosVO.getIdCliente());
				procesoVO.setIdIdentificador(mProcesosVO.getIdIdentificador());
				procesoVO.setIdProducto(mProcesosVO.getIdProducto());
				procesoVO.setNombreProducto(mProcesosVO.getNombreProducto());
				if(mProcesosVO.getIdEstatusMapeador() == 8) {
					procesoVO.setImagenEstatus(CommandConstants.IMG_VERDE_EXITO_PNG);
				} else if(mProcesosVO.getIdEstatusMapeador() == 9) {
					procesoVO.setImagenEstatus(CommandConstants.IMG_ERROR_ROJO_PNG);
				} else if(mProcesosVO.getIdEstatusMapeador() == 10) {
					procesoVO.setImagenEstatus(CommandConstants.IMG_AZUL_FINALIZAUSUARIO_PNG);
				} else if(mProcesosVO.getIdEstatusMapeador() == 11) {
					procesoVO.setImagenEstatus(CommandConstants.IMG_AMARILLO_ESPERA_PNG);
				} else{
					procesoVO.setImagenEstatus(CommandConstants.IMG_VERDE_EXITO_PNG);
				}
				procesoVOs.add(procesoVO);
			}
		
			for (ProcesoVO procesoVO : procesoVOs) {
				List<LoteVO> loteVOs = new ArrayList<LoteVO>();
				for (MonitoreoProcesosVO mProcesosVO : listaMonitoreoProcesosVO) {
					if(procesoVO.getIdCanal() == mProcesosVO.getIdCanal() && 
							procesoVO.getIdCliente() == mProcesosVO.getIdCliente() && 
								procesoVO.getIdProducto() == mProcesosVO.getIdProducto()){
						LoteVO loteVO = new LoteVO();
						loteVO.setNumeroLote(mProcesosVO.getNumeroLote());
						loteVO.setFechaLote(mProcesosVO.getFechaLote());
						loteVOs.add(loteVO);
					}
				}
				procesoVO.setLoteVOs(loteVOs);
			}
		
			for (ProcesoVO procesoVO : procesoVOs) {
				List<LoteVO> listaLoteVOs = procesoVO.getLoteVOs();
				for (LoteVO loteVO : listaLoteVOs) {
					List<EtapaVO> etapaVOs = new ArrayList<EtapaVO>();
					for (MonitoreoProcesosVO mProcesosVO : listaMonitoreoProcesosVO) {
						if(procesoVO.getIdCanal() == mProcesosVO.getIdCanal() && 
							procesoVO.getIdCliente() == mProcesosVO.getIdCliente() && 
								procesoVO.getIdProducto() == mProcesosVO.getIdProducto() &&
									loteVO.getNumeroLote() == mProcesosVO.getNumeroLote()){
							EtapaVO etapaVO = new EtapaVO();
							etapaVO.setNumeroLote(mProcesosVO.getNumeroLote());
							etapaVO.setIdContratacion(mProcesosVO.getIdContratacion());
							etapaVO.setIdFlujo(mProcesosVO.getIdFlujo());
							etapaVO.setIdEtapa(mProcesosVO.getIdEtapa());
							etapaVO.setNombreEtapa(mProcesosVO.getNombreEtapa());
							etapaVO.setIdRegArchEntra(mProcesosVO.getIdRegArchEntra());
							etapaVO.setNombreRegArchEntra(mProcesosVO.getNombreRegArchEntra());
							etapaVO.setFechaStatusProceso(mProcesosVO.getFechaStatusProceso());
							etapaVO.setHoraProcesoIni(mProcesosVO.getHoraProcesoIni());
							etapaVO.setHoraProcesoFin(mProcesosVO.getHoraProcesoFin());
							etapaVO.setIdEstatusMapeador(mProcesosVO.getIdEstatusMapeador());
							if(mProcesosVO.getIdEstatusMapeador() == 8) {
								etapaVO.setImagenEstatus(CommandConstants.IMG_VERDE_EXITO_PNG);
							} else if(mProcesosVO.getIdEstatusMapeador() == 9) {
								etapaVO.setImagenEstatus(CommandConstants.IMG_ERROR_ROJO_PNG);
							} else if(mProcesosVO.getIdEstatusMapeador() == 10) {
								etapaVO.setImagenEstatus(CommandConstants.IMG_AZUL_FINALIZAUSUARIO_PNG);
							} else if(mProcesosVO.getIdEstatusMapeador() == 11) {
								etapaVO.setImagenEstatus(CommandConstants.IMG_AMARILLO_ESPERA_PNG);
							} else{
								etapaVO.setImagenEstatus(CommandConstants.IMG_VERDE_EXITO_PNG);
							}
							etapaVOs.add(etapaVO);
						}
					}
					loteVO.setEtapaVOs(etapaVOs);
				}
			}
		} 
		setProcesoVOs(procesoVOs);
	
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#clean()
	 */
	@Override
	@Command
	public void clean() {
		canal.setValue(null); 
		cliente.setValue(null);
//		estatus.setValue(null);
		producto.setValue(null);
		lote.setValue(null);
		idCanal.setValue(null); 
		idProducto.setValue(null);
		idCliente.setValue(null);
		todos.setChecked(false);
		exito.setChecked(false);
		error.setChecked(false);
		finaliza.setChecked(false);
		espera.setChecked(false);
		idEstatus.setValue(null);
//		idContratacion.setValue(null);
//		idFlujo.setValue(null);
//		idEtapa.setValue(null); 
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
		DateFormat dateFormatFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		DateFormat dateFormatHora = new SimpleDateFormat("hh:mm:ss");
		for(MonitoreoProcesosVO monitoreoProcesosVO: monitoreoProcesosVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(monitoreoProcesosVO.getNombreCanal());
			beanGenerico.setValor2(monitoreoProcesosVO.getIdIdentificador()); 
			beanGenerico.setValor3(monitoreoProcesosVO.getNombreProducto());
			beanGenerico.setValor4(monitoreoProcesosVO.getNombreEstatusMapeador());
			try{
				beanGenerico.setValor5(dateFormatFecha.format(monitoreoProcesosVO.getFechaLote()));
			}catch(Exception ex){
				beanGenerico.setValor5("");
			}
			beanGenerico.setValor6(String.valueOf(monitoreoProcesosVO.getNumeroLote()));
			beanGenerico.setValor7(monitoreoProcesosVO.getNombreEtapa());
			beanGenerico.setValor8(monitoreoProcesosVO.getNombreRegArchEntra());
			beanGenerico.setValor9(dateFormatFecha.format(monitoreoProcesosVO.getFechaStatusProceso()));
			beanGenerico.setValor10(dateFormatHora.format(monitoreoProcesosVO.getHoraProcesoIni()));
			beanGenerico.setValor11(dateFormatHora.format(monitoreoProcesosVO.getHoraProcesoFin()));
			beanGenerico.setValor12(monitoreoProcesosVO.getNombreEstatusMapeador());
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}
	
	/**
	 * Gets the canal.
	 *
	 * @return the canal
	 */
	public Combobox getCanal() {
		return canal;
	}

	/**
	 * Gets the cliente.
	 *
	 * @return the cliente
	 */
	public Combobox getCliente() {
		return cliente;
	}
	
	/**
	 * Gets the criterio.
	 *
	 * @return the criterio
	 */
	public Combobox getCriterio() {
		return criterio;
	}
	
	/**
	 * Gets the error.
	 *
	 * @return the error
	 */
	public Checkbox getError() {
		return error;
	}
	 
	/**
	 * Gets the espera.
	 *
	 * @return the espera
	 */
	public Checkbox getEspera() {
		return espera;
	}
	
	/**
	 * Gets the estatus.
	 *
	 * @return the estatus
	 */
	public Combobox getEstatus() {
		return estatus;
	}	
	
	/**
	 * Gets the etapa vo.
	 *
	 * @return the etapaVO
	 */
	public EtapaVO getEtapaVO() {
		return etapaVO;
	}
	
	/**
	 * Gets the exito.
	 *
	 * @return the exito
	 */
	public Checkbox getExito() {
		return exito;
	}
	
	/**
	 * Gets the fecha fin.
	 *
	 * @return the fechaFin
	 */
	public Datebox getFechaFin() {
		return fechaFin;
	}
	
	/**
	 * Gets the fecha inicio.
	 *
	 * @return the fechaInicio
	 */
	public Datebox getFechaInicio() {
		return fechaInicio;
	}
	
	/**
	 * Gets the finaliza.
	 *
	 * @return the finaliza
	 */
	public Checkbox getFinaliza() {
		return finaliza;
	}
	
	/**
	 * Gets the guardar btn.
	 *
	 * @return the guardarBtn
	 */
	public Button getGuardarBtn() {
		return guardarBtn;
	}
	
	/**
	 * Gets the id canal.
	 *
	 * @return the idCanal
	 */
	public Textbox getIdCanal() {
		return idCanal;
	}
	
	/**
	 * Gets the id cliente.
	 *
	 * @return the idCliente
	 */
	public Textbox getIdCliente() {
		return idCliente;
	}
	
	/**
	 * Gets the id contratacion.
	 *
	 * @return the idContratacion
	 */
	public Textbox getIdContratacion() {
		return idContratacion;
	}
	
	/**
	 * Gets the id criterio.
	 *
	 * @return the idCriterio
	 */
	public Textbox getIdCriterio() {
		return idCriterio;
	}
	
	/**
	 * Gets the id estatus.
	 *
	 * @return the idEstatus
	 */
	public Textbox getIdEstatus() {
		return idEstatus;
	}
	
	/**
	 * Gets the id etapa.
	 *
	 * @return the idEtapa
	 */
	public Textbox getIdEtapa() {
		return idEtapa;
	}
	
	/**
	 * Gets the id flujo.
	 *
	 * @return the idFlujo
	 */
	public Textbox getIdFlujo() {
		return idFlujo;
	}
	
	/**
	 * Gets the id producto.
	 *
	 * @return the idProducto
	 */
	public Textbox getIdProducto() {
		return idProducto;
	}
	
	/**
	 * Gets the lote.
	 *
	 * @return the lote
	 */
	public Textbox getLote() {
		return lote;
	}
	
	/**
	 * Gets the monitoreo procesos dto.
	 *
	 * @return the monitoreoProcesosDTO
	 */
	public MonitoreoProcesosDTO getMonitoreoProcesosDTO() {
		return monitoreoProcesosDTO;
	}
	
	/**
	 * Gets the monitoreo procesos vo.
	 *
	 * @return the monitoreoProcesosVO
	 */
	public MonitoreoProcesosVO getMonitoreoProcesosVO() {
		return monitoreoProcesosVO;
	}
	
	/**
	 * Gets the monitoreo procesos v os.
	 *
	 * @return the monitoreoProcesosVOs
	 */
	public List<MonitoreoProcesosVO> getMonitoreoProcesosVOs() {
		return monitoreoProcesosVOs;
	}
	
	/**
	 * Gets the proceso v os.
	 *
	 * @return the procesoVOs
	 */
	public List<ProcesoVO> getProcesoVOs() {
		return procesoVOs;
	}
	
	/**
	 * Gets the producto.
	 *
	 * @return the producto
	 */
	public Combobox getProducto() {
		return producto;
	}
	
	/**
	 * Gets the str canal.
	 *
	 * @return the strCanal
	 */
	public String getStrCanal() {
		return strCanal;
	}
	
	/**
	 * Gets the str cliente.
	 *
	 * @return the strCliente
	 */
	public String getStrCliente() {
		return strCliente;
	}
	
	/**
	 * Gets the str estatus.
	 *
	 * @return the strEstatus
	 */
	public String getStrEstatus() {
		return strEstatus;
	}
	
	/**
	 * Gets the str fecha fin.
	 *
	 * @return the strFechaFin
	 */
	public String getStrFechaFin() {
		return strFechaFin;
	}
	
	/**
	 * Gets the str fecha inicio.
	 *
	 * @return the strFechaInicio
	 */
	public String getStrFechaInicio() {
		return strFechaInicio;
	}
	
	/**
	 * Gets the str id canal.
	 *
	 * @return the strIdCanal
	 */
	public String getStrIdCanal() {
		return strIdCanal;
	}
	
	/**
	 * Gets the str id cliente.
	 *
	 * @return the strIdCliente
	 */
	public String getStrIdCliente() {
		return strIdCliente;
	}
	
	/**
	 * Gets the str id criterio.
	 *
	 * @return the strIdCriterio
	 */
	public String getStrIdCriterio() {
		return strIdCriterio;
	}
	
	/**
	 * Gets the str id estatus.
	 *
	 * @return the strIdEstatus
	 */
	public String getStrIdEstatus() {
		return strIdEstatus;
	}
	
	/**
	 * Gets the str id producto.
	 *
	 * @return the strIdProducto
	 */
	public String getStrIdProducto() {
		return strIdProducto;
	}
	
	/**
	 * Gets the str lote.
	 *
	 * @return the strLote
	 */
	public String getStrLote() {
		return strLote;
	}
	
	/**
	 * Gets the str producto.
	 *
	 * @return the strProducto
	 */
	public String getStrProducto() {
		return strProducto;
	}
	
	/**
	 * Gets the todos.
	 *
	 * @return the todos
	 */
	public Checkbox getTodos() {
		return todos;
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
		String titleReport = "Monitoreo de Procesos";
		headersReport.add("Canal");
		headersReport.add("Cliente");
		headersReport.add("Producto");
		headersReport.add("Estatus"); 
		headersReport.add("Fecha Lote");
		headersReport.add("Lote");
		headersReport.add("Etapa");
		headersReport.add("Nombre Archivo");
		headersReport.add("Fecha Inicio");
		headersReport.add("Hora inicio");
		headersReport.add("Hora fin");
		headersReport.add("Estatus");
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Monitoreo de Procesos");
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Monitoreo de Procesos");
		}
		controller.createReport(generaLista(), headersReport, type, "MONITOREO_PROCESOS");
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read()
	 */
	@Override
	@GlobalCommand
	public Object read() {
		ReportesController controller = new ReportesController();
		MonitoreoProcesosDTO monitoreoProcesosDTO = new MonitoreoProcesosDTO();
		CanalDTO canalDTO = new CanalDTO();
		ClienteDTO clienteDTO = new ClienteDTO();
		ProductoDTO productoDTO = new ProductoDTO();
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();

		MonitoreoProcesosVO monitoreoProcesosVO = new MonitoreoProcesosVO();
		CanalVO canalVO = new CanalVO();
		ClienteVO clienteVO = new ClienteVO();
		ProductoVO productoVO = new ProductoVO();
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
		estatusObjetoVO.setNombreTabla(CommandConstants.NOMBRE_TABLA_PROCESO);
		monitoreoProcesosDTO.setMonitoreoProcesosVO(monitoreoProcesosVO);
		canalDTO.setCanalVO(canalVO);
		clienteDTO.setClienteVO(clienteVO);
		productoDTO.setProductoVO(productoVO);
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
		
		MonitoreoProcesosBO monitoreoProcesosBO = new MonitoreoProcesosBO();
		CanalBO canalBO = new CanalBO();
		ClienteBO clienteBO = new ClienteBO();
		ProductoBO productoBO = new ProductoBO();
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		
		monitoreoProcesosDTO = monitoreoProcesosBO.readCommand(monitoreoProcesosDTO);
		canalDTO = canalBO.readCommand(canalDTO);
		clienteDTO = clienteBO.readCommand(clienteDTO);
		productoDTO = productoBO.readCommand(productoDTO);
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
		
		
		logger.info("::::::::::::::SIZE::::::::::" + monitoreoProcesosDTO.getMonitoreoProcesosVOs());
		
		monitoreoProcesosDTO.setCanalVOs(canalDTO.getCanalVOs());
		monitoreoProcesosDTO.setClienteVOs(clienteDTO.getClienteVOs());
		monitoreoProcesosDTO.setProductoVOs(productoDTO.getProductoVOs());
		monitoreoProcesosDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
		List<EstatusObjetoVO> estatusObjetoVOs = new ArrayList<EstatusObjetoVO>();
		if(estatusObjetoDTO.getEstatusObjetoVOs() != null){
			EstatusObjetoVO estatusObjeto = new EstatusObjetoVO();
			estatusObjeto.setIdEstatusObjeto(0);
			estatusObjeto.setNombreEstatusObjeto(CommandConstants.TODOS);
			estatusObjeto.setImagenEstatus(CommandConstants.IMG_U276_NORMAL_PNG);
			estatusObjetoVOs.add(estatusObjeto);
			for (EstatusObjetoVO estatus : estatusObjetoDTO.getEstatusObjetoVOs()) {
				if(estatus.getNombreTabla().equals(CommandConstants.NOMBRE_TABLA_PROCESO)){
					if(estatus.getIdEstatusObjeto() == 8) {
						estatus.setImagenEstatus(CommandConstants.IMG_VERDE_EXITO_PNG);
					} else if(estatus.getIdEstatusObjeto() == 9) {
						estatus.setImagenEstatus(CommandConstants.IMG_ERROR_ROJO_PNG);
					} else if(estatus.getIdEstatusObjeto() == 10) {
						estatus.setImagenEstatus(CommandConstants.IMG_AZUL_FINALIZAUSUARIO_PNG);
					} else if(estatus.getIdEstatusObjeto() == 11) {
						estatus.setImagenEstatus(CommandConstants.IMG_AMARILLO_ESPERA_PNG);
					} else{
						estatus.setImagenEstatus(CommandConstants.IMG_VERDE_EXITO_PNG);
					}
					estatusObjetoVOs.add(estatus);
				}
				
			}
			monitoreoProcesosDTO.setEstatusObjetoVOs(estatusObjetoVOs);
		}
		
		if(monitoreoProcesosDTO.getMonitoreoProcesosVOs() != null) { 
			for (MonitoreoProcesosVO entidad : monitoreoProcesosDTO.getMonitoreoProcesosVOs()) {
				if(entidad.getIdEstatusMapeador() == 8) {
					entidad.setImagenEstatus(CommandConstants.IMG_VERDE_EXITO_PNG);
				} else if(entidad.getIdEstatusMapeador() == 9) {
					entidad.setImagenEstatus(CommandConstants.IMG_ERROR_ROJO_PNG);
				} else if(entidad.getIdEstatusMapeador() == 10) {
					entidad.setImagenEstatus(CommandConstants.IMG_AZUL_FINALIZAUSUARIO_PNG);
				} else if(entidad.getIdEstatusMapeador() == 11) {
					entidad.setImagenEstatus(CommandConstants.IMG_AMARILLO_ESPERA_PNG);
				} else{
					entidad.setImagenEstatus(CommandConstants.IMG_VERDE_EXITO_PNG);
				}
				
			}
		}
		armarListaGrid(monitoreoProcesosDTO.getMonitoreoProcesosVOs());
		controller.registrarEvento(monitoreoProcesosVO, monitoreoProcesosVO, CommandConstants.CONSULTAR, "Monitoreo de Procesos");
		return monitoreoProcesosDTO;
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
	 * Read event detail.
	 *
	 * @param etapaVO the etapa vo
	 */
	@Command  
	public void readEventDetail(@BindingParam("idContratacion") final EtapaVO etapaVO) {
		if(etapaVO.getIdEstatusMapeador() == CommandConstants.ESTADO_ERROR_PROCESO){
			setEtapaVO(etapaVO);
			Map<String, Object> mapDatos = new HashMap<String, Object>();
			mapDatos.put("etapaVO", etapaVO); 
			Window window = (Window) Executions.createComponents(
					"/WEB-INF/flows/procesos/detalleProceso.zul",
					this.getSelf(), mapDatos);
			window.doModal();
		}
	}
	
	//Cambiar al objeto que pertenezca el componente en este caso 
	/**
	 * Read with filters.
	 */
	@Command
	@GlobalCommand
	@NotifyChange({ "monitoreoProcesosVOs", "procesoVOs" })
	public void readWithFilters() {
		if(fechaInicio.getValue().compareTo(fechaFin.getValue()) > 0 ){
			fechaInicio.setErrorMessage("La fecha de inicio no puede ser mayor a la fecha de fin");
		}else{
			
			
			ReportesController controller = new ReportesController();
			MonitoreoProcesosDTO monitoreoProcesosDTO = new MonitoreoProcesosDTO();
			MonitoreoProcesosVO monitoreoProcesosVO = new MonitoreoProcesosVO(); 
			
			//Combos Validar el nombre de los parametros en HTML VS Controller
			monitoreoProcesosVO.setIdCanal((Integer.parseInt(idCanal.getValue().isEmpty()?"0":idCanal.getValue())));
			monitoreoProcesosVO.setIdCliente((Integer.parseInt(idCliente.getValue().isEmpty()?"0":idCliente.getValue())));
			monitoreoProcesosVO.setIdProducto((Integer.parseInt(idProducto.getValue().isEmpty()?"0":idProducto.getValue())));
			monitoreoProcesosVO.setNumeroLote((Integer.parseInt(lote.getValue().isEmpty()?"0":lote.getValue())));
			monitoreoProcesosVO.setIdEstatusMapeador((Integer.parseInt(idEstatus.getValue().isEmpty()?"0":idEstatus.getValue())));
			
			//Fechas
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			monitoreoProcesosVO.setFechaInicio(dateFormat.format(fechaInicio.getValue()));
			monitoreoProcesosVO.setFechaFin(dateFormat.format(fechaFin.getValue()));
			ArrayList<Integer> estados = new ArrayList<Integer>();
			int []arregloEstados;
			if(!todos.isChecked()) {
				if(exito.isChecked()) {
					estados.add(CommandConstants.PROCESO_EXITO_VERDE);
					logger.info("::::::::::::8");
				}
				if(error.isChecked()) {
					estados.add(CommandConstants.PROCESO_ERROR_ROJO);
					logger.info("::::::::::::9");
				}
				if(finaliza.isChecked()) {
					estados.add(CommandConstants.PROCESO_FINALIZA_USUARIO_AZUL);
					logger.info("::::::::::::10");
				}
				if(espera.isChecked()) {
					estados.add(CommandConstants.PROCESO_ESPERA_AMARILLO);
					logger.info("::::::::::::11");
				}
				if(estados.size()>0){
					arregloEstados = new int[estados.size()];
					int count = 0;
					for (Integer integer : estados) {
						arregloEstados[count] = integer;
						count ++;
					}
					logger.info(arregloEstados.toString());
					monitoreoProcesosVO.setEstados(arregloEstados);
				}
			}
			
			monitoreoProcesosDTO.setMonitoreoProcesosVO(monitoreoProcesosVO);
			monitoreoProcesosDTO.toString(BbvaAbstractDataTransferObject.XML);	
			
			monitoreoProcesosDTO.setTipoReporte(Integer.parseInt(criterios.getSelectedItem().getValue().toString()));
			
			armarListaGrid(monitoreoProcesosDTO);
			controller.registrarEvento(monitoreoProcesosVO, monitoreoProcesosVO, CommandConstants.CONSULTAR,"Monitoreo de Procesos");
//			//LLamada a BO  MonitoreoProcesosBO para consulta por criterio
//			MonitoreoProcesosBO monitoreoProcesosBO = new MonitoreoProcesosBO();
//			
//			//Asignacion resultado de consulta al mismo DTO de MonitoreoProcesos
//			monitoreoProcesosDTO = monitoreoProcesosBO.readCommand(monitoreoProcesosDTO);
//			
//			//Tamaño de la lista de acuerdo al criterio de busqueda y objeto MonitoreoProcesos
//			if(monitoreoProcesosDTO.getMonitoreoProcesosVOs() != null) { 
//					for (MonitoreoProcesosVO entidad : monitoreoProcesosDTO.getMonitoreoProcesosVOs()) {
//						if(entidad.getIdEstatusMapeador() == 8) {
//							entidad.setImagenEstatus(CommandConstants.IMG_VERDE_EXITO_PNG);
//						} else if(entidad.getIdEstatusMapeador() == 9) {
//							entidad.setImagenEstatus(CommandConstants.IMG_ERROR_ROJO_PNG);
//						} else if(entidad.getIdEstatusMapeador() == 10) {
//							entidad.setImagenEstatus(CommandConstants.IMG_AZUL_FINALIZAUSUARIO_PNG);
//						} else if(entidad.getIdEstatusMapeador() == 11) {
//							entidad.setImagenEstatus(CommandConstants.IMG_AMARILLO_ESPERA_PNG);
//						} else{
//							entidad.setImagenEstatus(CommandConstants.IMG_VERDE_EXITO_PNG);
//						} 
//				}
//				logger.debug("size:"+ monitoreoProcesosDTO.getMonitoreoProcesosVOs().size());
//			} else{
//				logger.debug(":::::::::::Lista Vacia::::::::::");
//			}
//			//Asignacion de la lista a la variable global de la clase
//			monitoreoProcesosVOs = monitoreoProcesosDTO.getMonitoreoProcesosVOs();
//			armarListaGrid(monitoreoProcesosDTO.getMonitoreoProcesosVOs());
//			controller.registrarEvento(monitoreoProcesosVO, monitoreoProcesosVO, CommandConstants.CONSULTAR,"Monitoreo de Procesos");
		}
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#save()
	 */
	@Override
	@Command	
	public void save() {
		ReportesController controller = new ReportesController();
		MonitoreoProcesosBO monitoreoProcesosBO = new MonitoreoProcesosBO();
		MonitoreoProcesosVO monitoreoProcesosVO = new MonitoreoProcesosVO();
		monitoreoProcesosVO.setIdContratacion(Integer.parseInt(idContratacion.getValue()));
		monitoreoProcesosVO.setIdFlujo(Integer.parseInt(idFlujo.getValue()));
		monitoreoProcesosVO.setIdEtapa(Integer.parseInt(idEtapa.getValue()));
		monitoreoProcesosDTO.setMonitoreoProcesosVO(monitoreoProcesosVO);
		monitoreoProcesosDTO = monitoreoProcesosBO.updateCommand(monitoreoProcesosDTO);
		armarListaGrid(monitoreoProcesosDTO.getMonitoreoProcesosVOs());
		controller.registrarEvento(monitoreoProcesosVO, this.monitoreoProcesosVO, CommandConstants.MODIFICACION,"Monitoreo de Procesos");
		org.zkoss.zul.Messagebox.show("Registro actualizado con exito!!",
				"Información", org.zkoss.zul.Messagebox.OK,
				org.zkoss.zul.Messagebox.INFORMATION);
		
		
	}
	
	/**
	 * Seleccion estatus.
	 */
	@Command
	public void seleccionEstatus() {
		
		if(todos.isChecked()){
			exito.setChecked(false);
			error.setChecked(false);
			finaliza.setChecked(false);
			espera.setChecked(false); 
			exito.setDisabled(true);
			error.setDisabled(true);
			finaliza.setDisabled(true);
			espera.setDisabled(true);
		} else {
			exito.setDisabled(false);
			error.setDisabled(false);
			finaliza.setDisabled(false);
			espera.setDisabled(false);
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
	 * Sets the canal.
	 *
	 * @param canal the canal to set
	 */
	public void setCanal(Combobox canal) {
		this.canal = canal;
	}
	
	/**
	 * Sets the cliente.
	 *
	 * @param cliente the cliente to set
	 */
	public void setCliente(Combobox cliente) {
		this.cliente = cliente;
	}
	
	/**
	 * Sets the criterio.
	 *
	 * @param criterio the criterio to set
	 */
	public void setCriterio(Combobox criterio) {
		this.criterio = criterio;
	}
	
	/**
	 * Sets the error.
	 *
	 * @param error the error to set
	 */
	public void setError(Checkbox error) {
		this.error = error;
	}
	
	/**
	 * Sets the espera.
	 *
	 * @param espera the espera to set
	 */
	public void setEspera(Checkbox espera) {
		this.espera = espera;
	}
	
	/**
	 * Sets the estatus.
	 *
	 * @param estatus the estatus to set
	 */
	public void setEstatus(Combobox estatus) {
		this.estatus = estatus;
	}
	
	/**
	 * Sets the etapa vo.
	 *
	 * @param etapaVO the etapaVO to set
	 */
	public void setEtapaVO(EtapaVO etapaVO) {
		this.etapaVO = etapaVO;
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
	 * Sets the exito.
	 *
	 * @param exito the exito to set
	 */
	public void setExito(Checkbox exito) {
		this.exito = exito;
	}
	
	/**
	 * Sets the fecha fin.
	 *
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Datebox fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	/**
	 * Sets the fecha inicio.
	 *
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Datebox fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	/**
	 * Sets the finaliza.
	 *
	 * @param finaliza the finaliza to set
	 */
	public void setFinaliza(Checkbox finaliza) {
		this.finaliza = finaliza;
	}

	/**
	 * Sets the guardar btn.
	 *
	 * @param guardarBtn the guardarBtn to set
	 */
	public void setGuardarBtn(Button guardarBtn) {
		this.guardarBtn = guardarBtn;
	}

	/**
	 * Sets the id canal.
	 *
	 * @param idCanal the idCanal to set
	 */
	public void setIdCanal(Textbox idCanal) {
		this.idCanal = idCanal;
	}

	/**
	 * Sets the id cliente.
	 *
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(Textbox idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * Sets the id contratacion.
	 *
	 * @param idContratacion the idContratacion to set
	 */
	public void setIdContratacion(Textbox idContratacion) {
		this.idContratacion = idContratacion;
	}

	/**
	 * Sets the id criterio.
	 *
	 * @param idCriterio the idCriterio to set
	 */
	public void setIdCriterio(Textbox idCriterio) {
		this.idCriterio = idCriterio;
	}

	/**
	 * Sets the id estatus.
	 *
	 * @param idEstatus the idEstatus to set
	 */
	public void setIdEstatus(Textbox idEstatus) {
		this.idEstatus = idEstatus;
	}	

	/**
	 * Sets the id etapa.
	 *
	 * @param idEtapa the idEtapa to set
	 */
	public void setIdEtapa(Textbox idEtapa) {
		this.idEtapa = idEtapa;
	}

	/**
	 * Sets the id flujo.
	 *
	 * @param idFlujo the idFlujo to set
	 */
	public void setIdFlujo(Textbox idFlujo) {
		this.idFlujo = idFlujo;
	}
	
	/**
	 * Sets the id producto.
	 *
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(Textbox idProducto) {
		this.idProducto = idProducto;
	}
	
	/**
	 * Sets the lote.
	 *
	 * @param lote the lote to set
	 */
	public void setLote(Textbox lote) {
		this.lote = lote;
	}
	
	/**
	 * Sets the monitoreo procesos dto.
	 *
	 * @param monitoreoProcesosDTO the monitoreoProcesosDTO to set
	 */
	public void setMonitoreoProcesosDTO(MonitoreoProcesosDTO monitoreoProcesosDTO) {
		this.monitoreoProcesosDTO = monitoreoProcesosDTO;
	}

	/**
	 * Sets the monitoreo procesos vo.
	 *
	 * @param monitoreoProcesosVO the monitoreoProcesosVO to set
	 */
	public void setMonitoreoProcesosVO(MonitoreoProcesosVO monitoreoProcesosVO) {
		this.monitoreoProcesosVO = monitoreoProcesosVO;
	}

	/**
	 * Sets the monitoreo procesos v os.
	 *
	 * @param monitoreoProcesosVOs the monitoreoProcesosVOs to set
	 */
	public void setMonitoreoProcesosVOs(
			List<MonitoreoProcesosVO> monitoreoProcesosVOs) {
		this.monitoreoProcesosVOs = monitoreoProcesosVOs;
	}

	/**
	 * Sets the proceso v os.
	 *
	 * @param procesoVOs the procesoVOs to set
	 */
	public void setProcesoVOs(List<ProcesoVO> procesoVOs) {
		this.procesoVOs = procesoVOs;
	}

	/**
	 * Sets the producto.
	 *
	 * @param producto the producto to set
	 */
	public void setProducto(Combobox producto) {
		this.producto = producto;
	}

	/**
	 * Sets the str canal.
	 *
	 * @param strCanal the strCanal to set
	 */
	public void setStrCanal(String strCanal) {
		this.strCanal = strCanal;
	}

	/**
	 * Sets the str cliente.
	 *
	 * @param strCliente the strCliente to set
	 */
	public void setStrCliente(String strCliente) {
		this.strCliente = strCliente;
	}

	/**
	 * Sets the str estatus.
	 *
	 * @param strEstatus the strEstatus to set
	 */
	public void setStrEstatus(String strEstatus) {
		this.strEstatus = strEstatus;
	}

	/**
	 * Sets the str fecha fin.
	 *
	 * @param strFechaFin the strFechaFin to set
	 */
	public void setStrFechaFin(String strFechaFin) {
		this.strFechaFin = strFechaFin;
	}

	/**
	 * Sets the str fecha inicio.
	 *
	 * @param strFechaInicio the strFechaInicio to set
	 */
	public void setStrFechaInicio(String strFechaInicio) {
		this.strFechaInicio = strFechaInicio;
	}

	/**
	 * Sets the str id canal.
	 *
	 * @param strIdCanal the strIdCanal to set
	 */
	public void setStrIdCanal(String strIdCanal) {
		this.strIdCanal = strIdCanal;
	}
	
	/**
	 * Sets the str id cliente.
	 *
	 * @param strIdCliente the strIdCliente to set
	 */
	public void setStrIdCliente(String strIdCliente) {
		this.strIdCliente = strIdCliente;
	}
	
	/**
	 * Sets the str id criterio.
	 *
	 * @param strIdCriterio the strIdCriterio to set
	 */
	public void setStrIdCriterio(String strIdCriterio) {
		this.strIdCriterio = strIdCriterio;
	}
	
	/**
	 * Sets the str id estatus.
	 *
	 * @param strIdEstatus the strIdEstatus to set
	 */
	public void setStrIdEstatus(String strIdEstatus) {
		this.strIdEstatus = strIdEstatus;
	}
	
	/**
	 * Sets the str id producto.
	 *
	 * @param strIdProducto the strIdProducto to set
	 */
	public void setStrIdProducto(String strIdProducto) {
		this.strIdProducto = strIdProducto;
	}
	
	/**
	 * Sets the str lote.
	 *
	 * @param strLote the strLote to set
	 */
	public void setStrLote(String strLote) {
		this.strLote = strLote;
	}
	
	/**
	 * Sets the str producto.
	 *
	 * @param strProducto the strProducto to set
	 */
	public void setStrProducto(String strProducto) {
		this.strProducto = strProducto;
	}
	
	/**
	 * Sets the todos.
	 *
	 * @param todos the todos to set
	 */
	public void setTodos(Checkbox todos) {
		this.todos = todos;
	}
	
	/**
	 * Show modal.
	 *
	 * @param e the e
	 */
	@Listen("onClick = #closeBtn")
    public void showModal(Event e) {
		detalleProcesoWindow.detach();
    }
 
	
	
}

