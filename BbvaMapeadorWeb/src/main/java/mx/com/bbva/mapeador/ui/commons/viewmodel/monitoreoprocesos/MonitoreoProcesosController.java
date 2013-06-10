package mx.com.bbva.mapeador.ui.commons.viewmodel.monitoreoprocesos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class MonitoreoProcesosController extends ControllerSupport implements  IController{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(MonitoreoProcesosController.class);
	@Wire
	private Combobox criterio;
	@Wire
	private Combobox canal;
	@Wire
	private Combobox cliente;
	@Wire
	private Combobox estatus;
	
	@Wire
	private Checkbox todos;
	@Wire
	private Checkbox exito;
	@Wire
	private Checkbox error;
	@Wire
	private Checkbox finaliza;
	@Wire
	private Checkbox espera;
	
	@Wire
	private Combobox producto;
	@Wire
	private Datebox fechaInicio;
	@Wire
	private Datebox fechaFin;
	@Wire
	private Textbox lote;
	@Wire
	private Textbox idCriterio;
	@Wire
	private Textbox idCanal;
	@Wire
	private Textbox idCliente;
	@Wire
	private Textbox idEstatus;
	@Wire
	private Textbox idProducto;
	@Wire
	private Textbox idContratacion;
	@Wire
	private Textbox idFlujo;
	@Wire
	private Textbox idEtapa;	
	
	
	@Wire
	private Label lblCanal;
	@Wire
	private Label lblCliente;
	@Wire
	private Label lblProducto;
	@Wire
	private Label lblEstatus;
	@Wire
	private Label lblFechaLote;
	@Wire
	private Label lblA;
	@Wire
	private Label lblLote;
	@Wire
	private Image reporteExcelBtn;
	@Wire
	private Image reporteCsvBtn;
	@Wire
	private Button limpiarBtn;
	@Wire
	private Button consultarBtn;
	@Wire
	private Grid procesosGrid;
	
	private MonitoreoProcesosDTO monitoreoProcesosDTO = (MonitoreoProcesosDTO) this.read();
	
	private List<MonitoreoProcesosVO> monitoreoProcesosVOs = monitoreoProcesosDTO.getMonitoreoProcesosVOs();
	
	private String strCanal;
	
	private String strCliente;
	
	private String strEstatus;
	
	private String strProducto;
	
	private String strFechaInicio;
	
	private String strFechaFin;
	
	private String strLote;
	
	private String strIdCriterio;
	
	private String strIdCanal;
	
	private String strIdCliente;
	
	private String strIdEstatus;
	
	private String strIdProducto;
	
	private boolean executePermissionSet;
	
	private MonitoreoProcesosVO monitoreoProcesosVO;
	
	private EtapaVO etapaVO;
	
	private List<ProcesoVO> procesoVOs = getProcesoVOs();
	
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
	
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);    
        executePermissionSet = this.applyPermision();
    }
	//Cambiar al objeto que pertenezca el componente en este caso 
	@Command 
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
					estados.add(CommandConstants.ESTADO_EXITO_PROCESO);
					logger.info("::::::::::::8");
				}
				if(error.isChecked()) {
					estados.add(CommandConstants.ESTADO_ERROR_PROCESO);
					logger.info("::::::::::::9");
				}
				if(finaliza.isChecked()) {
					estados.add(CommandConstants.ESTADO_FINALIZA_USUARIO_PROCESO);
					logger.info("::::::::::::10");
				}
				if(espera.isChecked()) {
					estados.add(CommandConstants.ESTADO_ESPERA_PROCESO);
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
			
			//LLamada a BO  MonitoreoProcesosBO para consulta por criterio
			MonitoreoProcesosBO monitoreoProcesosBO = new MonitoreoProcesosBO();
			
			//Asignacion resultado de consulta al mismo DTO de MonitoreoProcesos
			monitoreoProcesosDTO = monitoreoProcesosBO.readCommand(monitoreoProcesosDTO);
			
			//Tamaño de la lista de acuerdo al criterio de busqueda y objeto MonitoreoProcesos
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
				logger.debug("size:"+ monitoreoProcesosDTO.getMonitoreoProcesosVOs().size());
			} else{
				logger.debug(":::::::::::Lista Vacia::::::::::");
			}
			//Asignacion de la lista a la variable global de la clase
			monitoreoProcesosVOs = monitoreoProcesosDTO.getMonitoreoProcesosVOs();
			armarListaGrid(monitoreoProcesosDTO.getMonitoreoProcesosVOs());
			controller.registrarEvento(monitoreoProcesosVO, monitoreoProcesosVO, CommandConstants.CONSULTAR,"Monitoreo de Procesos");
		}
	}
	
	@Command 
	public void readEventDetail(@BindingParam("idContratacion") final EtapaVO etapaVO) {
		setEtapaVO(etapaVO);
		Map<String, Object> mapDatos = new HashMap<String, Object>();
		mapDatos.put("etapaVO", etapaVO); 
		Window window = (Window) Executions.createComponents(
				"/WEB-INF/flows/procesos/detalleProceso.zul",
				this.getSelf(), mapDatos);
		window.doModal();
	}
	
	@Wire
    Window detalleProcesoWindow;
	
	@Listen("onClick = #closeBtn")
    public void showModal(Event e) {
		detalleProcesoWindow.detach();
    }
	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Command
	@NotifyChange({ "monitoreoProcesosVOs" , "procesoVOs"})
	public void save() {
		ReportesController controller = new ReportesController();
		//LLamada a BO  MonitoreoProcesosBO para consulta por criterio
//		System.out.println(etapaVO.getIdContratacion());
//		System.out.println(etapaVO.getIdFlujo());
//		System.out.println(etapaVO.getIdEtapa());
		MonitoreoProcesosBO monitoreoProcesosBO = new MonitoreoProcesosBO();
		MonitoreoProcesosVO monitoreoProcesosVO = new MonitoreoProcesosVO();
		monitoreoProcesosVO.setIdContratacion(Integer.parseInt(idContratacion.getValue()));
		monitoreoProcesosVO.setIdFlujo(Integer.parseInt(idFlujo.getValue()));
		monitoreoProcesosVO.setIdEtapa(Integer.parseInt(idEtapa.getValue()));
		monitoreoProcesosDTO.setMonitoreoProcesosVO(monitoreoProcesosVO);
		//Asignacion resultado de consulta al mismo DTO de MonitoreoProcesos
		monitoreoProcesosDTO = monitoreoProcesosBO.updateCommand(monitoreoProcesosDTO);
		armarListaGrid(monitoreoProcesosDTO.getMonitoreoProcesosVOs());
		controller.registrarEvento(monitoreoProcesosVO, this.monitoreoProcesosVO, CommandConstants.MODIFICACION,"Monitoreo de Procesos");
		Messagebox.show("Registro actualizado con exito!!",
				"Confirmación", Messagebox.OK,
				Messagebox.INFORMATION);
		
		
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
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
		controller.createReport(generaLista(), headersReport, titleReport, "MONITOREO_PROCESOS");
	}	
	
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
			beanGenerico.setValor5(dateFormatFecha.format(monitoreoProcesosVO.getFechaLote()));
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
	 * @return the criterio
	 */
	public Combobox getCriterio() {
		return criterio;
	}
	/**
	 * @param criterio the criterio to set
	 */
	public void setCriterio(Combobox criterio) {
		this.criterio = criterio;
	}
	/**
	 * @return the canal
	 */
	public Combobox getCanal() {
		return canal;
	}
	/**
	 * @param canal the canal to set
	 */
	public void setCanal(Combobox canal) {
		this.canal = canal;
	}
	/**
	 * @return the cliente
	 */
	public Combobox getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Combobox cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return the estatus
	 */
	public Combobox getEstatus() {
		return estatus;
	}
	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(Combobox estatus) {
		this.estatus = estatus;
	}
	/**
	 * @return the producto
	 */
	public Combobox getProducto() {
		return producto;
	}
	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Combobox producto) {
		this.producto = producto;
	}
	/**
	 * @return the fechaInicio
	 */
	public Datebox getFechaInicio() {
		return fechaInicio;
	}
	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Datebox fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	/**
	 * @return the fechaFin
	 */
	public Datebox getFechaFin() {
		return fechaFin;
	}
	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Datebox fechaFin) {
		this.fechaFin = fechaFin;
	}
	/**
	 * @return the lote
	 */
	public Textbox getLote() {
		return lote;
	}
	/**
	 * @param lote the lote to set
	 */
	public void setLote(Textbox lote) {
		this.lote = lote;
	}
	/**
	 * @return the idCriterio
	 */
	public Textbox getIdCriterio() {
		return idCriterio;
	}
	/**
	 * @param idCriterio the idCriterio to set
	 */
	public void setIdCriterio(Textbox idCriterio) {
		this.idCriterio = idCriterio;
	}
	/**
	 * @return the idCanal
	 */
	public Textbox getIdCanal() {
		return idCanal;
	}
	/**
	 * @param idCanal the idCanal to set
	 */
	public void setIdCanal(Textbox idCanal) {
		this.idCanal = idCanal;
	}
	/**
	 * @return the idCliente
	 */
	public Textbox getIdCliente() {
		return idCliente;
	}
	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(Textbox idCliente) {
		this.idCliente = idCliente;
	}
	/**
	 * @return the idEstatus
	 */
	public Textbox getIdEstatus() {
		return idEstatus;
	}
	/**
	 * @param idEstatus the idEstatus to set
	 */
	public void setIdEstatus(Textbox idEstatus) {
		this.idEstatus = idEstatus;
	}
	/**
	 * @return the idProducto
	 */
	public Textbox getIdProducto() {
		return idProducto;
	}
	/**
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(Textbox idProducto) {
		this.idProducto = idProducto;
	}
	/**
	 * @return the monitoreoProcesosDTO
	 */
	public MonitoreoProcesosDTO getMonitoreoProcesosDTO() {
		return monitoreoProcesosDTO;
	}
	/**
	 * @param monitoreoProcesosDTO the monitoreoProcesosDTO to set
	 */
	public void setMonitoreoProcesosDTO(MonitoreoProcesosDTO monitoreoProcesosDTO) {
		this.monitoreoProcesosDTO = monitoreoProcesosDTO;
	}
	/**
	 * @return the monitoreoProcesosVOs
	 */
	public List<MonitoreoProcesosVO> getMonitoreoProcesosVOs() {
		return monitoreoProcesosVOs;
	}
	/**
	 * @param monitoreoProcesosVOs the monitoreoProcesosVOs to set
	 */
	public void setMonitoreoProcesosVOs(
			List<MonitoreoProcesosVO> monitoreoProcesosVOs) {
		this.monitoreoProcesosVOs = monitoreoProcesosVOs;
	}
	/**
	 * @return the strCanal
	 */
	public String getStrCanal() {
		return strCanal;
	}
	/**
	 * @param strCanal the strCanal to set
	 */
	public void setStrCanal(String strCanal) {
		this.strCanal = strCanal;
	}
	/**
	 * @return the strCliente
	 */
	public String getStrCliente() {
		return strCliente;
	}
	/**
	 * @param strCliente the strCliente to set
	 */
	public void setStrCliente(String strCliente) {
		this.strCliente = strCliente;
	}
	/**
	 * @return the strEstatus
	 */
	public String getStrEstatus() {
		return strEstatus;
	}
	/**
	 * @param strEstatus the strEstatus to set
	 */
	public void setStrEstatus(String strEstatus) {
		this.strEstatus = strEstatus;
	}
	/**
	 * @return the strProducto
	 */
	public String getStrProducto() {
		return strProducto;
	}
	/**
	 * @param strProducto the strProducto to set
	 */
	public void setStrProducto(String strProducto) {
		this.strProducto = strProducto;
	}
	/**
	 * @return the strFechaInicio
	 */
	public String getStrFechaInicio() {
		return strFechaInicio;
	}
	/**
	 * @param strFechaInicio the strFechaInicio to set
	 */
	public void setStrFechaInicio(String strFechaInicio) {
		this.strFechaInicio = strFechaInicio;
	}
	/**
	 * @return the strFechaFin
	 */
	public String getStrFechaFin() {
		return strFechaFin;
	}
	/**
	 * @param strFechaFin the strFechaFin to set
	 */
	public void setStrFechaFin(String strFechaFin) {
		this.strFechaFin = strFechaFin;
	}
	/**
	 * @return the strLote
	 */
	public String getStrLote() {
		return strLote;
	}
	/**
	 * @param strLote the strLote to set
	 */
	public void setStrLote(String strLote) {
		this.strLote = strLote;
	}
	/**
	 * @return the strIdCriterio
	 */
	public String getStrIdCriterio() {
		return strIdCriterio;
	}
	/**
	 * @param strIdCriterio the strIdCriterio to set
	 */
	public void setStrIdCriterio(String strIdCriterio) {
		this.strIdCriterio = strIdCriterio;
	}
	/**
	 * @return the strIdCanal
	 */
	public String getStrIdCanal() {
		return strIdCanal;
	}
	/**
	 * @param strIdCanal the strIdCanal to set
	 */
	public void setStrIdCanal(String strIdCanal) {
		this.strIdCanal = strIdCanal;
	}
	/**
	 * @return the strIdCliente
	 */
	public String getStrIdCliente() {
		return strIdCliente;
	}
	/**
	 * @param strIdCliente the strIdCliente to set
	 */
	public void setStrIdCliente(String strIdCliente) {
		this.strIdCliente = strIdCliente;
	}
	/**
	 * @return the strIdEstatus
	 */
	public String getStrIdEstatus() {
		return strIdEstatus;
	}
	/**
	 * @param strIdEstatus the strIdEstatus to set
	 */
	public void setStrIdEstatus(String strIdEstatus) {
		this.strIdEstatus = strIdEstatus;
	}
	/**
	 * @return the strIdProducto
	 */
	public String getStrIdProducto() {
		return strIdProducto;
	}
	/**
	 * @param strIdProducto the strIdProducto to set
	 */
	public void setStrIdProducto(String strIdProducto) {
		this.strIdProducto = strIdProducto;
	}

	/**
	 * @return the idContratacion
	 */
	public Textbox getIdContratacion() {
		return idContratacion;
	}

	/**
	 * @param idContratacion the idContratacion to set
	 */
	public void setIdContratacion(Textbox idContratacion) {
		this.idContratacion = idContratacion;
	}

	/**
	 * @return the idFlujo
	 */
	public Textbox getIdFlujo() {
		return idFlujo;
	}

	/**
	 * @param idFlujo the idFlujo to set
	 */
	public void setIdFlujo(Textbox idFlujo) {
		this.idFlujo = idFlujo;
	}

	/**
	 * @return the idEtapa
	 */
	public Textbox getIdEtapa() {
		return idEtapa;
	}

	/**
	 * @param idEtapa the idEtapa to set
	 */
	public void setIdEtapa(Textbox idEtapa) {
		this.idEtapa = idEtapa;
	}	

	/**
	 * @return the monitoreoProcesosVO
	 */
	public MonitoreoProcesosVO getMonitoreoProcesosVO() {
		return monitoreoProcesosVO;
	}

	/**
	 * @param monitoreoProcesosVO the monitoreoProcesosVO to set
	 */
	public void setMonitoreoProcesosVO(MonitoreoProcesosVO monitoreoProcesosVO) {
		this.monitoreoProcesosVO = monitoreoProcesosVO;
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
	 * @return the todos
	 */
	public Checkbox getTodos() {
		return todos;
	}

	/**
	 * @param todos the todos to set
	 */
	public void setTodos(Checkbox todos) {
		this.todos = todos;
	}

	/**
	 * @return the exito
	 */
	public Checkbox getExito() {
		return exito;
	}

	/**
	 * @param exito the exito to set
	 */
	public void setExito(Checkbox exito) {
		this.exito = exito;
	}

	/**
	 * @return the error
	 */
	public Checkbox getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(Checkbox error) {
		this.error = error;
	}

	/**
	 * @return the finaliza
	 */
	public Checkbox getFinaliza() {
		return finaliza;
	}

	/**
	 * @param finaliza the finaliza to set
	 */
	public void setFinaliza(Checkbox finaliza) {
		this.finaliza = finaliza;
	}

	/**
	 * @return the espera
	 */
	public Checkbox getEspera() {
		return espera;
	}

	/**
	 * @param espera the espera to set
	 */
	public void setEspera(Checkbox espera) {
		this.espera = espera;
	}
	/**
	 * @return the procesoVOs
	 */
	public List<ProcesoVO> getProcesoVOs() {
		return procesoVOs;
	}
	/**
	 * @param procesoVOs the procesoVOs to set
	 */
	public void setProcesoVOs(List<ProcesoVO> procesoVOs) {
		this.procesoVOs = procesoVOs;
	}
	/**
	 * @return the etapaVO
	 */
	public EtapaVO getEtapaVO() {
		return etapaVO;
	}
	/**
	 * @param etapaVO the etapaVO to set
	 */
	public void setEtapaVO(EtapaVO etapaVO) {
		this.etapaVO = etapaVO;
	}
 
	
	
}

