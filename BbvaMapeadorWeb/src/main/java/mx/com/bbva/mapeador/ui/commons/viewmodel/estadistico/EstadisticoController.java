package mx.com.bbva.mapeador.ui.commons.viewmodel.estadistico;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ProductoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.CanalVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ClienteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstadisticoVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.canal.dto.CanalDTO;
import mx.com.bbva.bancomer.cliente.dto.ClienteDTO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estadistico.dto.CanalMockDTO;
import mx.com.bbva.bancomer.estadistico.dto.ClienteMockDTO;
import mx.com.bbva.bancomer.estadistico.dto.EstadisticaDTO;
import mx.com.bbva.bancomer.estadistico.dto.EstadisticoDTO;
import mx.com.bbva.bancomer.estadistico.dto.EstadisticoMockDTO;
import mx.com.bbva.bancomer.estadistico.dto.ProductoEstadisticoDTO;
import mx.com.bbva.bancomer.mapper.business.CanalBO;
import mx.com.bbva.bancomer.mapper.business.ClienteBO;
import mx.com.bbva.bancomer.mapper.business.EstadisticoBO;
import mx.com.bbva.bancomer.mapper.business.ProductoBO;
import mx.com.bbva.bancomer.producto.dto.ProductoDTO;
import mx.com.bbva.mapeador.security.session.user.SessionUser;
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
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Textbox;

public class EstadisticoController extends ControllerSupport implements  IController{
	private static final Logger logger = Logger.getLogger(EstadisticoController.class);
	public SessionUser getSessionUser(){
		logger.debug( "Entrada getSessionUser          -- OK" );		
		String cveUsuario = null;
		logger.debug( "Datos de usuario -- " + cveUsuario);
		SessionUser sessionUser = new SessionUser();
		sessionUser.setCveUsuario(cveUsuario);
		logger.debug( "Salida getSessionUser          -- OK" );
		return sessionUser;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Wire
	private Combobox criterio;
	@Wire
	private Combobox canal;
	@Wire
	private Combobox cliente;
	@Wire
	private Combobox producto;
	@Wire	
	private Datebox fechaInicio;
	@Wire
	private Datebox fechaFin;
	@Wire
	private Textbox idCriterio;
	@Wire
	private Textbox idCanal;
	@Wire
	private Textbox idCliente;
	@Wire
	private Textbox idProducto;
	
	@Wire
	private Label lblCanal;
	@Wire
	private Label lblIdCliente;
	@Wire
	private Label lblProducto;
	@Wire
	private Label lblFechaAlta;
	@Wire
	private Label lblA;
	@Wire
	private Combobox scanal;
	@Wire
	private Combobox scliente;
	@Wire
	private Combobox sproducto;
	@Wire
	private Image reporteExcelBtn;
	@Wire
	private Image reporteCsvBtn;
	@Wire
	private Button limpiarBtn;
	@Wire
	private Button consultarBtn;
	@Wire
	private Grid estadisticosGrid;
	
	private EstadisticoDTO estadisticoDTO = (EstadisticoDTO) read();
	
	private List<EstadisticoVO> estadisticoVOs = estadisticoDTO.getEstadisticoVOs();
		
	private String strCriterio;
	
	private String strCanal;
	
	private String strCliente;
	
	private String strProducto;
	
	private String strFechaInicio;
	
	private String strFechaFin;
	
	private String strIdCriterio;
	
	private String strIdCanal;
	
	private String strIdCliente;
	
	private String strIdProducto;
	
	private boolean executePermissionSet;
	private EstadisticoMockDTO estadisticoMockDTO;
	private List<CanalMockDTO> canalMockDTOs;
	private List<mx.com.bbva.mapeador.ui.commons.viewmodel.estadistico.CanalVO> canalVOs =  getListaCanalVOs();
	
	
	
	@Override
	public Object read() {
		estadisticoDTO = new EstadisticoDTO();
		EstadisticoVO estadisticoVO = new EstadisticoVO();
		EstadisticaDTO estadisticaDTO = new EstadisticaDTO();
		CanalDTO canalDTO = new CanalDTO();
		ClienteDTO clienteDTO = new ClienteDTO();
		ProductoDTO productoDTO = new ProductoDTO();

		CanalVO canalVO = new CanalVO();
		ClienteVO clienteVO = new ClienteVO();
		mx.com.bbva.bancomer.bussinnes.model.vo.ProductoVO productoVO = new ProductoVO();
		
		estadisticoDTO.setEstadisticoVO(estadisticoVO);
		canalDTO.setCanalVO(canalVO);
		clienteDTO.setClienteVO(clienteVO);
		productoDTO.setProductoVO(productoVO);
		
		EstadisticoBO estadisticoBO = new EstadisticoBO();
		CanalBO canalBO = new CanalBO();
		ClienteBO clienteBO = new ClienteBO();
		ProductoBO productoBO = new ProductoBO();
		estadisticaDTO.setEstadisticoVO(estadisticoVO);
		estadisticaDTO = estadisticoBO.readCommand(estadisticaDTO);
		canalDTO = canalBO.readCommand(canalDTO);
		clienteDTO = clienteBO.readCommand(clienteDTO);
		productoDTO = productoBO.readCommand(productoDTO);
		
		
		logger.info("::::::::::::::SIZE::::::::::" + estadisticoDTO.getEstadisticoVOs());
		
		estadisticoDTO.setCanalVOs(canalDTO.getCanalVOs());
		estadisticoDTO.setClienteVOs(clienteDTO.getClienteVOs());
		estadisticoDTO.setProductoVOs(productoDTO.getProductoVOs());
		estadisticoDTO.setEstadisticoVOs(estadisticaDTO.getEstadisticoVOs());
		//controller.registrarEvento(estadisticoVO, estadisticoVO, CommandConstants.CONSULTAR, "Estadístico");
		//armarListaGrid(estadisticoDTO.getEstadisticoVOs());
		createListGrid(estadisticaDTO);
		return estadisticoDTO;
	}
	
	private void createListGrid(EstadisticaDTO estadisticaDTO) {
		canalMockDTOs = new ArrayList<CanalMockDTO>();
		HashMap<Integer, String> mapCliente = new HashMap<Integer, String>();
		
		for(EstadisticoVO estadisticoVO:estadisticaDTO.getEstadisticoVOs()) {
			mapCliente.put((int) estadisticoVO.idCanal, estadisticoVO.nombreCanal+":"+estadisticoVO.idIdentificador);
		}
		
		Collection<String> clienteC = mapCliente.values();
   	 	Iterator<String> iteratorC = clienteC.iterator();
		
	   	 while(iteratorC.hasNext()){
	   		ArrayList<ProductoEstadisticoDTO> productoVOs = new ArrayList<ProductoEstadisticoDTO>();
	   		ArrayList<ClienteMockDTO> clienteMockDTOs = new ArrayList<ClienteMockDTO>();
	   		CanalMockDTO canalMockDTO = new CanalMockDTO();
	   		String cliente = (String)iteratorC.next();
	   		String[] str_array = cliente.split(":");
			String nombreCanal = str_array[0]; 
			String idIdentificador = str_array[1];
			ClienteMockDTO clienteMockDTO = new ClienteMockDTO();
			clienteMockDTO.setNombreCliente(idIdentificador);
			canalMockDTO.setNombreCanal(nombreCanal);
			for(EstadisticoVO estadisticoVO:estadisticaDTO.getEstadisticoVOs()) {
				if(estadisticoVO.getNombreCanal().equals(nombreCanal) && estadisticoVO.getIdIdentificador().equals(idIdentificador)) {
					ProductoEstadisticoDTO productoVO = new ProductoEstadisticoDTO();
					productoVO.setFechaStatusProceso(estadisticoVO.getFechaStatusProceso());
					productoVO.setNombreProducto(estadisticoVO.getNombreProducto());
					productoVO.setNombreRegArchEntra(estadisticoVO.getNombreRegArchEntra());
					productoVO.setNumeroOperaciones(estadisticoVO.getNumeroOperacione());
					productoVOs.add(productoVO);
				}
			}
			clienteMockDTO.setProductoVOs(productoVOs);
			clienteMockDTOs.add(clienteMockDTO);
			canalMockDTO.setClienteMockDTOs(clienteMockDTOs);
		   	canalMockDTOs.add(canalMockDTO);
	   	 }
	}
	
	public ListModel<mx.com.bbva.mapeador.ui.commons.viewmodel.estadistico.CanalVO> getCanalVOs() {
		return new ListModelList<mx.com.bbva.mapeador.ui.commons.viewmodel.estadistico.CanalVO>(getListaCanalVOs());
	}
	
	public List<mx.com.bbva.mapeador.ui.commons.viewmodel.estadistico.CanalVO> getListaCanalVOs() {
		return canalVOs;
	} 
	
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
        executePermissionSet = this.applyPermision();
    }
	
	//Cambiar al objeto que pertenezca el componente en este caso estadisticoVOs
	@Command
	@NotifyChange({"canalMockDTOs"})
	public void readWithFilters() {
		if(fechaInicio.getValue()!=null && fechaInicio.getValue() != null && fechaInicio.getValue().compareTo(fechaFin.getValue()) > 0 ){
			fechaInicio.setErrorMessage("La fecha de inicio no puede ser mayor a la fecha de fin");
		}else{
			ReportesController controller = new ReportesController();
			
			EstadisticaDTO estadisticaDTO = new EstadisticaDTO();
			EstadisticoVO estadisticoVO = new EstadisticoVO(); 
			
			//Combos Validar el nombre de los parametros en HTML VS Controller
			estadisticoVO.setIdCanal((Integer.parseInt(idCanal.getValue().isEmpty()?"0":idCanal.getValue())));
			estadisticoVO.setIdCliente((Integer.parseInt(idCliente.getValue().isEmpty()?"0":idCliente.getValue())));
			estadisticoVO.setIdProducto((Integer.parseInt(idProducto.getValue().isEmpty()?"0":idProducto.getValue())));
			
			//Fechas
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			if(fechaInicio.getValue()!=null)
			estadisticoVO.setFechaInicio(dateFormat.format(fechaInicio.getValue()));
			if(fechaFin.getValue()!=null)
			estadisticoVO.setFechaFin(dateFormat.format(fechaFin.getValue()));
	
			estadisticaDTO.setEstadisticoVO(estadisticoVO);
			estadisticaDTO.toString(BbvaAbstractDataTransferObject.XML);	
			
			//LLamada a BO  EstadisticoBO para consulta por criterio
			EstadisticoBO estadisticoBO = new EstadisticoBO();
			
			//Asignacion resultado de consulta al mismo DTO de Estadistico
			estadisticaDTO = estadisticoBO.readCommand(estadisticaDTO);
			
			//Tamaño de la lista de acuerdo al criterio de busqueda y objeto Estadistico
			if(estadisticaDTO.getEstadisticoVOs() != null) {
				logger.debug("size:"+estadisticaDTO.getEstadisticoVOs().size());
			} else{
				logger.debug(":::::::::::Lista Vacia::::::::::");
			}
			
			createListGrid(estadisticaDTO);
			estadisticoDTO.setEstadisticoVOs(estadisticaDTO.getEstadisticoVOs());
			//controller.registrarEvento(null, null, CommandConstants.CONSULTAR, "Estadístico");
		}
	}
	@Override
	@Command
	public void clean() {
		//Mensajes HTML
		canal.clearErrorMessage();
		cliente.clearErrorMessage();
		producto.clearErrorMessage();
		
		//Mensajes Setear a Null
		canal.setValue(null);
		cliente.setValue(null);
		producto.setValue(null);  
		fechaFin.setValue(null);
		fechaInicio.setValue(null);
		//Setear IDs Invisibles
		idCanal.setValue(null);
		idCliente.setValue(null);
		idProducto.setValue(null);
		
	}
	
	@Command
	public void onShowReport(@BindingParam("type") final String type) {
		ReportesController controller = new ReportesController();
		ArrayList<String> headersReport = new ArrayList<String>();
		headersReport.add("Canal");
		headersReport.add("Cliente");
		headersReport.add("Fecha");
		headersReport.add("Producto"); 
		headersReport.add("Nombre Archivo"); 
		headersReport.add("Operaciones"); 
//		if(type.equals("xls")) {
//			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Estadístico");
//		} else {
//			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Estadístico");
//		}
		controller.createReport(generaLista(), headersReport, type, "ESTADISTICO");
	}	
	
	private ArrayList<BeanGenerico> generaLista() {
		ArrayList<BeanGenerico> beanGenericos = new ArrayList<BeanGenerico>();
		BeanGenerico beanGenerico = null;
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		for(EstadisticoVO estadisticoVO: estadisticoVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(estadisticoVO.getNombreCanal());
			beanGenerico.setValor2(estadisticoVO.getIdIdentificador());
			beanGenerico.setValor3(dateFormat.format(estadisticoVO.getFechaStatusProceso()));
			beanGenerico.setValor4(estadisticoVO.getNombreProducto()); 
			beanGenerico.setValor5(estadisticoVO.getNombreRegArchEntra()); 
			beanGenerico.setValor6(String.valueOf(estadisticoVO.getNumeroOperacione())); 
			
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}
	
	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
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
	 * @return the estadisticoDTO
	 */
	public EstadisticoDTO getEstadisticoDTO() {
		return estadisticoDTO;
	}

	/**
	 * @param estadisticoDTO the estadisticoDTO to set
	 */
	public void setEstadisticoDTO(EstadisticoDTO estadisticoDTO) {
		this.estadisticoDTO = estadisticoDTO;
	}

	/**
	 * @return the estadisticoVOs
	 */
	public List<EstadisticoVO> getEstadisticoVOs() {
		return estadisticoVOs;
	}

	/**
	 * @param estadisticoVOs the estadisticoVOs to set
	 */
	public void setEstadisticoVOs(List<EstadisticoVO> estadisticoVOs) {
		this.estadisticoVOs = estadisticoVOs;
	}

	/**
	 * @return the strCriterio
	 */
	public String getStrCriterio() {
		return strCriterio;
	}

	/**
	 * @param strCriterio the strCriterio to set
	 */
	public void setStrCriterio(String strCriterio) {
		this.strCriterio = strCriterio;
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
		componentes.put(lblCanal.getId(), lblCanal);
		componentes.put(lblIdCliente.getId(), lblIdCliente);
		componentes.put(lblProducto.getId(), lblProducto);
		componentes.put(lblFechaAlta.getId(), lblFechaAlta);
		componentes.put(lblA.getId(), lblA);
		componentes.put(canal.getId(), canal);
		componentes.put(cliente.getId(), cliente);
		componentes.put(producto.getId(), producto);
		componentes.put(fechaInicio.getId(), fechaInicio);
		componentes.put(fechaFin.getId(), fechaFin);
		componentes.put(reporteExcelBtn.getId(), reporteExcelBtn);
		componentes.put(reporteCsvBtn.getId(), reporteCsvBtn);
		componentes.put(limpiarBtn.getId(), limpiarBtn);
		componentes.put(consultarBtn.getId(), consultarBtn);
//		componentes.put(estadisticosGrid.getId(), estadisticosGrid);
		super.applyPermission(MapeadorConstants.ESTADISTICO, componentes);
		return isApplied;
	}


	/**
	 * @param canalVOs the canalVOs to set
	 */
	public void setCanalVOs(
			List<mx.com.bbva.mapeador.ui.commons.viewmodel.estadistico.CanalVO> canalVOs) {
		this.canalVOs = canalVOs;
	}

	/**
	 * @return the estadisticoMockDTO
	 */
	public EstadisticoMockDTO getEstadisticoMockDTO() {
		return estadisticoMockDTO;
	}

	/**
	 * @param estadisticoMockDTO the estadisticoMockDTO to set
	 */
	public void setEstadisticoMockDTO(EstadisticoMockDTO estadisticoMockDTO) {
		this.estadisticoMockDTO = estadisticoMockDTO;
	}

	/**
	 * @return the canalMockDTOs
	 */
	public List<CanalMockDTO> getCanalMockDTOs() {
		return canalMockDTOs;
	}

	/**
	 * @param canalMockDTOs the canalMockDTOs to set
	 */
	public void setCanalMockDTOs(List<CanalMockDTO> canalMockDTOs) {
		this.canalMockDTOs = canalMockDTOs;
	}	
	
}
