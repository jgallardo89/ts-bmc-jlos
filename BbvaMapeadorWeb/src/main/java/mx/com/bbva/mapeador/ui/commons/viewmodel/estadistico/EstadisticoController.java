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
 * Nombre de clase: EstadisticoController.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.estadistico
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.estadistico;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.CanalVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ClienteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstadisticoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ProductoVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.canal.dto.CanalDTO;
import mx.com.bbva.bancomer.cliente.dto.ClienteDTO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estadistico.dto.CanalMockDTO;
import mx.com.bbva.bancomer.estadistico.dto.EstadisticaDTO;
import mx.com.bbva.bancomer.estadistico.dto.EstadisticoDTO;
import mx.com.bbva.bancomer.estadistico.dto.EstadisticoMockDTO;
import mx.com.bbva.bancomer.estadistico.dto.PrimerNivelDTO;
import mx.com.bbva.bancomer.estadistico.dto.SegundoNivelDTO;
import mx.com.bbva.bancomer.estadistico.dto.TercerNivelDTO;
import mx.com.bbva.bancomer.mapper.business.CanalBO;
import mx.com.bbva.bancomer.mapper.business.ClienteBO;
import mx.com.bbva.bancomer.mapper.business.EstadisticoBO;
import mx.com.bbva.bancomer.mapper.business.ProductoBO;
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
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Table;
import org.zkoss.zhtml.Tbody;
import org.zkoss.zhtml.Td;
import org.zkoss.zhtml.Tr;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Textbox;

import com.sun.mail.handlers.image_gif;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticoController.
 */
public class EstadisticoController extends ControllerSupport implements  IController{
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(EstadisticoController.class);
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The canal. */
	@Wire
	private Combobox canal;
	
	/** The canal mock dt os. */
	private List<CanalMockDTO> canalMockDTOs;
	
	/** The canal v os. */
	private List<mx.com.bbva.mapeador.ui.commons.viewmodel.estadistico.CanalVO> canalVOs =  getListaCanalVOs();
	
	/** The cliente. */
	@Wire
	private Combobox cliente;
	
	/** The consultar btn. */
	@Wire
	private Button consultarBtn;
	
	/** The criterio. */
	@Wire
	private Combobox criterio;
	
	/** The estadistico dto. */
	private EstadisticoDTO estadisticoDTO;//= (EstadisticoDTO) read();
	
	/** The estadistico mock dto. */
	private EstadisticoMockDTO estadisticoMockDTO;
	
	/** The estadisticos grid. */
	@Wire
	private Grid estadisticosGrid;
	
	/** The estadistico v os. */
	private List<EstadisticoVO> estadisticoVOs;// = estadisticoDTO.getEstadisticoVOs();
	
	/** The execute permission set. */
	private boolean executePermissionSet;
	
	/** The fecha fin. */
	@Wire
	private Datebox fechaFin;
	
	/** The fecha inicio. */
	@Wire	
	private Datebox fechaInicio;
	
	/** The id canal. */
	@Wire
	private Textbox idCanal;
	
	/** The id cliente. */
	@Wire
	private Textbox idCliente;
	
	/** The id criterio. */
	@Wire
	private Textbox idCriterio;
	
	/** The id producto. */
	@Wire
	private Textbox idProducto;
	
	/** The lbl a. */
	@Wire
	private Label lblA;
	
	/** The lbl canal. */
	@Wire
	private Label lblCanal;
	
	/** The lbl fecha alta. */
	@Wire
	private Label lblFechaAlta;
	
	/** The lbl id cliente. */
	@Wire
	private Label lblIdCliente;
	
	/** The lbl producto. */
	@Wire
	private Label lblProducto;
	
	/** The limpiar btn. */
	@Wire
	private Button limpiarBtn;
	
	/** The producto. */
	@Wire
	private Combobox producto;
	
	/** The Criterio de Consulta. */
	@Wire
	private Combobox tipoFiltro;
	
	/** The reporte csv btn. */
	@Wire
	private Image reporteCsvBtn;
		
	/** The reporte excel btn. */
	@Wire
	private Image reporteExcelBtn;
	
	/** The scanal. */
	@Wire
	private Combobox scanal;
	
	/** The scliente. */
	@Wire
	private Combobox scliente;
	
	/** The sproducto. */
	@Wire
	private Combobox sproducto;
	
	/** The str canal. */
	private String strCanal;
	
	/** The str cliente. */
	private String strCliente;
	
	/** The str criterio. */
	private String strCriterio;
	
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
	
	/** The str id producto. */
	private String strIdProducto;
	
	/** The str producto. */
	private String strProducto;
	
	/** The Tabla. */
	Table table;
	
	/** The Table Body Tabla. */
	Tbody tbody;
	
	/** The div Tabla. */
	@Wire
	private Div divTabla;
	
	
	private List<PrimerNivelDTO> primerNivelDTOs;
	private int totalPaginas;
	private int numeroPagina;
	private int registroInicio;
	private int registroFin;
	private String modulo1;
	private String modulo2;
	
	@Wire
	private Textbox inicio;
	@Wire
	private Textbox fin;
	
	@Wire
	private Image backAllBtn;
	@Wire
	private Image backBtn;
	@Wire
	private Textbox pagina;
	@Wire
	private Image nextBtn;
	@Wire
	private Image nextAllBtn;
	
	private boolean flagBack;
	private boolean flagNext;
		
	/**
	 * After compose.
	 *
	 * @param view the view
	 */
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);
        executePermissionSet = this.applyPermision();        
        estadisticoVOs = new ArrayList<EstadisticoVO>();
        estadisticoDTO = (EstadisticoDTO) read();
        estadisticoVOs = estadisticoDTO.getEstadisticoVOs();
    }
	
	/* 
	 * (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read()
	 */
	@Override
	public Object read() {
		fechaInicio.setValue(null);
		fechaFin.setValue(null);
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
		
		estadisticoDTO.setCanalVOs(canalDTO.getCanalVOs());
		estadisticoDTO.setClienteVOs(clienteDTO.getClienteVOs());
		estadisticoDTO.setProductoVOs(productoDTO.getProductoVOs());
		estadisticoDTO.setEstadisticoVOs(estadisticaDTO.getEstadisticoVOs());
		//controller.registrarEvento(estadisticoVO, estadisticoVO, CommandConstants.CONSULTAR, "Estadístico");
		//armarListaGrid(estadisticoDTO.getEstadisticoVOs());
		createCanalClienteProducto(estadisticaDTO);
		return estadisticoDTO;
	}

	
	/**
	 * Creates the list grid order: CANAL-CLIENTE-PRODUCTO
	 * @param estadisticaDTO
	 */
	public void createCanalClienteProducto(EstadisticaDTO estadisticaDTO) {
		primerNivelDTOs = new ArrayList<PrimerNivelDTO>();
		HashMap<Integer, String> mapCanal = new HashMap<Integer, String>();
		PrimerNivelDTO primerNivelDTO = new PrimerNivelDTO();
		SegundoNivelDTO segundoNivelDTO = new SegundoNivelDTO();
		TercerNivelDTO tercerNivelDTO = new TercerNivelDTO();
		List<SegundoNivelDTO> segundoNivelDTOs = new ArrayList<SegundoNivelDTO>();
		List<TercerNivelDTO> tercerNivelDTOs = new ArrayList<TercerNivelDTO>();
		
		for(EstadisticoVO estadisticoVO:estadisticaDTO.getEstadisticoVOs()) {
			mapCanal.put((int) estadisticoVO.idCanal, estadisticoVO.nombreCanal);
		}
		
		Collection<String> canalC = mapCanal.values();
   	 	Iterator<String> iteratorC = canalC.iterator();

	   	 while(iteratorC.hasNext()){
	   		segundoNivelDTOs = new ArrayList<SegundoNivelDTO>();
	   		primerNivelDTO = new PrimerNivelDTO();
	   		HashMap<String, String> mapCliente = new HashMap<String, String>();
	   		String canal = iteratorC.next();
	   		
	   		primerNivelDTO.setNombre(canal);
	   		
			for(EstadisticoVO estadisticoVO:estadisticaDTO.getEstadisticoVOs()) {
				if(estadisticoVO.getNombreCanal().equals(canal)) {
					mapCliente.put(""+estadisticoVO.getIdCliente(),estadisticoVO.getIdCanal()+":"+estadisticoVO.getIdIdentificador());
				}
			}
			Collection<String> client = mapCliente.values();
	   	 	Iterator<String> iteratorCli = client.iterator();
	   	
		   	 while(iteratorCli.hasNext()){
		   		tercerNivelDTOs = new ArrayList<TercerNivelDTO>();
		   		segundoNivelDTO = new SegundoNivelDTO();
		   		
		   		String identificador = iteratorCli.next();		   		
		   		String[] str_array = identificador.split(":");
				String ident = str_array[1];
				segundoNivelDTO.setNombre(ident);
				segundoNivelDTOs.add(segundoNivelDTO);
		   		for(EstadisticoVO estadisticoVO:estadisticaDTO.getEstadisticoVOs()) {
					if((estadisticoVO.getIdCanal()+":"+estadisticoVO.getIdIdentificador()).equals(identificador)) {
						tercerNivelDTO = new TercerNivelDTO();
						tercerNivelDTO.setFechaStatusProceso(estadisticoVO.getFechaStatusProceso());
						tercerNivelDTO.setNombre(estadisticoVO.getNombreProducto());
						tercerNivelDTO.setNombreRegArchEntra(estadisticoVO.getNombreRegArchEntra());
						tercerNivelDTO.setNumeroOperaciones(estadisticoVO.getNumeroOperacione());
						tercerNivelDTOs.add(tercerNivelDTO);
					}
				}
		   		segundoNivelDTO.setTercerNivelDTOs(tercerNivelDTOs);
		   	 }
		   	primerNivelDTO.setSegundoNivelDTOs(segundoNivelDTOs);
		   	this.primerNivelDTOs.add(primerNivelDTO);
	   	 }
	   	this.totalPaginas = (int)Math.ceil((double)this.primerNivelDTOs.size()/CommandConstants.PAGINADO_ESTADISTICOS);
	   	this.registroInicio = 0;
	   	this.numeroPagina = 1;
		this.registroFin = this.registroInicio + CommandConstants.PAGINADO_ESTADISTICOS;
		if(this.primerNivelDTOs.size()==0) {
			logger.debug("************************ LISTA SIN REGISTROS ************************");
		} else {
			this.modulo1 = "CANAL";
			this.modulo2 = "CLIENTE";
			paginarEstadisticos();
		}
	} 

	@Command
	@NotifyChange({"primerNivelDTOs","numeroPagina"})
	public void nextOne() {
		if(this.registroFin<this.primerNivelDTOs.size()) {
			this.registroInicio = this.registroFin;
			this.registroFin = this.registroInicio + CommandConstants.PAGINADO_ESTADISTICOS;
			paginarEstadisticos();
			this.numeroPagina += 1;
		}
		logger.debug("************************ inicio= "+ this.registroInicio + " - fin= " + this.registroFin);
	}
	
	@Command
	@NotifyChange({"primerNivelDTOs","numeroPagina"})
	public void backOne() {
		if(this.registroInicio>0) {
			this.registroInicio = this.registroFin - (CommandConstants.PAGINADO_ESTADISTICOS*2);
			this.registroFin = this.registroInicio + CommandConstants.PAGINADO_ESTADISTICOS;
			paginarEstadisticos();
			this.numeroPagina -= 1;
		}
		logger.debug("************************ inicio= "+ this.registroInicio + " - fin= " + this.registroFin);
	}
	
	@Command
	@NotifyChange({"primerNivelDTOs","numeroPagina"})
	public void nextAll() {
		if(this.registroFin<=this.primerNivelDTOs.size()) {
			this.registroInicio = CommandConstants.PAGINADO_ESTADISTICOS * (totalPaginas-1);
			this.registroFin = this.primerNivelDTOs.size();
			this.numeroPagina = this.totalPaginas; 
			paginarEstadisticos();
		}
		logger.debug("************************ inicio= "+ this.registroInicio + " - fin= " + this.registroFin);
	}
	
	@Command
	@NotifyChange({"primerNivelDTOs","numeroPagina"})
	public void backAll() {
		if(this.registroInicio>0) {
			this.registroInicio = 0;
			this.registroFin = this.registroInicio + CommandConstants.PAGINADO_ESTADISTICOS;
			this.numeroPagina = 1;
			paginarEstadisticos();
		}
		logger.debug("************************ inicio= "+ this.registroInicio + " - fin= " + this.registroFin);
	}
	
	public void paginarEstadisticos() {
		 armaEstiloTabla();
		 for(int i = registroInicio; i<registroInicio+CommandConstants.PAGINADO_ESTADISTICOS;i++) {
			 if(i < this.primerNivelDTOs.size()) {
				PrimerNivelDTO dto0 = primerNivelDTOs.get(i);
		   		cabecera(this.modulo1,1);
		   		armaRegistroNivel2(dto0.getNombre());
		   		for(SegundoNivelDTO dto:dto0.getSegundoNivelDTOs()) {
			   		cabecera(this.modulo2,2);
			   		armaHijos(dto.getNombre());
			   		if (this.modulo1.equals("PRODUCTO")) {
			   			armaEncabezadoNivelCliente();
			   		} else {
			   			armaEncabezadoNivel3();
			   		}
			   		 for(TercerNivelDTO dto2:dto.getTercerNivelDTOs()) {
			   			armaHijosTercerNivel(dto2);
			   		 }
		   		}
			 }
		 }
	}
	
	/**
	 * Creates the list grid order: CLIENTE-CANAL-PRODUCTO 
	 * @param estadisticaDTO
	 */
	@Command
	@NotifyChange({"totalPaginas"})
	private void createClienteCanalProducto(EstadisticaDTO estadisticaDTO) {
		primerNivelDTOs = new ArrayList<PrimerNivelDTO>();
		HashMap<Integer, String> mapCliente = new HashMap<Integer, String>();
		PrimerNivelDTO primerNivelDTO = new PrimerNivelDTO();
		SegundoNivelDTO segundoNivelDTO = new SegundoNivelDTO();
		TercerNivelDTO tercerNivelDTO = new TercerNivelDTO();
		List<SegundoNivelDTO> segundoNivelDTOs = new ArrayList<SegundoNivelDTO>();
		List<TercerNivelDTO> tercerNivelDTOs = new ArrayList<TercerNivelDTO>();
		
		for(EstadisticoVO estadisticoVO:estadisticaDTO.getEstadisticoVOs()) {
			mapCliente.put((int) estadisticoVO.idCliente, estadisticoVO.idIdentificador);
		}
		
		Collection<String> clienteC = mapCliente.values();
   	 	Iterator<String> iteratorC = clienteC.iterator();
	   	 while(iteratorC.hasNext()){
	   	 segundoNivelDTOs = new ArrayList<SegundoNivelDTO>();
	   		primerNivelDTO = new PrimerNivelDTO();
	   		HashMap<Integer, String> mapCanal = new HashMap<Integer, String>();
	   		String cliente = iteratorC.next();
			primerNivelDTO.setNombre(cliente);

			for(EstadisticoVO estadisticoVO:estadisticaDTO.getEstadisticoVOs()) {
				if(estadisticoVO.getIdIdentificador().equals(cliente)) {
					mapCanal.put((int)estadisticoVO.getIdCanal(),estadisticoVO.getIdCliente()+":"+estadisticoVO.getNombreCanal());
				}
			}
			Collection<String> can = mapCanal.values();
	   	 	Iterator<String> iteratorCan = can.iterator();
	   	
		   	 while(iteratorCan.hasNext()){
		   	 tercerNivelDTOs = new ArrayList<TercerNivelDTO>();
		   		segundoNivelDTO = new SegundoNivelDTO();
		   		String identificador = iteratorCan.next();
		   		
		   		String[] str_array = identificador.split(":");
				String ident = str_array[1];
				armaHijos(ident);
				armaEncabezadoNivel3();
				segundoNivelDTO.setNombre(ident);
				segundoNivelDTOs.add(segundoNivelDTO);
		   		for(EstadisticoVO estadisticoVO:estadisticaDTO.getEstadisticoVOs()) {
					if((estadisticoVO.getIdCliente()+":"+estadisticoVO.getNombreCanal()).equals(identificador)) {
					tercerNivelDTO = new TercerNivelDTO();
						tercerNivelDTO.setFechaStatusProceso(estadisticoVO.getFechaStatusProceso());
						tercerNivelDTO.setNombre(estadisticoVO.getNombreProducto());
						tercerNivelDTO.setNombreRegArchEntra(estadisticoVO.getNombreRegArchEntra());
						tercerNivelDTO.setNumeroOperaciones(estadisticoVO.getNumeroOperacione());
						tercerNivelDTOs.add(tercerNivelDTO);
					}
				}
				segundoNivelDTO.setTercerNivelDTOs(tercerNivelDTOs);
		   	 }
			primerNivelDTO.setSegundoNivelDTOs(segundoNivelDTOs);
		   	this.primerNivelDTOs.add(primerNivelDTO);
	   	 }
	   	this.totalPaginas = (int)Math.ceil((double)this.primerNivelDTOs.size()/CommandConstants.PAGINADO_ESTADISTICOS);
	   	logger.debug("totalPaginas _-------- " + this.primerNivelDTOs.size() + " ************ "+ CommandConstants.PAGINADO_ESTADISTICOS);
	   	this.registroInicio = 0;
	   	this.numeroPagina = 1;
		this.registroFin = this.registroInicio + CommandConstants.PAGINADO_ESTADISTICOS;
		if(this.primerNivelDTOs.size()==0) {
			logger.debug("************************ LISTA SIN REGISTROS ************************");
		} else {
			this.modulo1 = "CLIENTE";
			this.modulo2 = "CANAL";
			paginarEstadisticos();
		}
	}
	
	/**
	 * Creates the list grid order: PRODUCTO-CANAL-CLIENTE
	 * @param estadisticaDTO
	 */
	private void createProductoCanalCliente(EstadisticaDTO estadisticaDTO) {		
		primerNivelDTOs = new ArrayList<PrimerNivelDTO>();
		HashMap<Integer, String> mapProducto = new HashMap<Integer, String>();
		PrimerNivelDTO primerNivelDTO = new PrimerNivelDTO();
		SegundoNivelDTO segundoNivelDTO = new SegundoNivelDTO();
		TercerNivelDTO tercerNivelDTO = new TercerNivelDTO();
		List<SegundoNivelDTO> segundoNivelDTOs = new ArrayList<SegundoNivelDTO>();
		List<TercerNivelDTO> tercerNivelDTOs = new ArrayList<TercerNivelDTO>();
		
		for(EstadisticoVO estadisticoVO:estadisticaDTO.getEstadisticoVOs()) {
			mapProducto.put((int) estadisticoVO.getIdProducto(), estadisticoVO.getNombreProducto());
		}
		
		Collection<String> proC = mapProducto.values();
   	 	Iterator<String> iteratorP = proC.iterator();		
	   	 while(iteratorP.hasNext()){
	   	 	segundoNivelDTOs = new ArrayList<SegundoNivelDTO>();
	   		primerNivelDTO = new PrimerNivelDTO();
	   		HashMap<Integer, String> mapCanal = new HashMap<Integer, String>();
	   		String producto = iteratorP.next();
			primerNivelDTO.setNombre(producto);
	  
			for(EstadisticoVO estadisticoVO:estadisticaDTO.getEstadisticoVOs()) {
				if(estadisticoVO.getNombreProducto().equals(producto)) {
					mapCanal.put((int)estadisticoVO.getIdCanal(),estadisticoVO.getIdProducto()+":"+estadisticoVO.getNombreCanal());
				}
			}
			Collection<String> can = mapCanal.values();
	   	 	Iterator<String> iteratorCan = can.iterator();
	   	
		   	 while(iteratorCan.hasNext()){
		   		tercerNivelDTOs = new ArrayList<TercerNivelDTO>();
		   		segundoNivelDTO = new SegundoNivelDTO();
		   		String identificador = iteratorCan.next();
		   		
		   		String[] str_array = identificador.split(":");
				String ident = str_array[1];
				armaRegistroNivel2(ident);
				segundoNivelDTO.setNombre(ident);
				segundoNivelDTOs.add(segundoNivelDTO);
		   		for(EstadisticoVO estadisticoVO:estadisticaDTO.getEstadisticoVOs()) {
					if((estadisticoVO.getIdProducto()+":"+estadisticoVO.getNombreCanal()).equals(identificador)) {
						tercerNivelDTO = new TercerNivelDTO();
						tercerNivelDTO.setFechaStatusProceso(estadisticoVO.getFechaStatusProceso());
						tercerNivelDTO.setNombre(estadisticoVO.getIdIdentificador());
						tercerNivelDTO.setNombreRegArchEntra(estadisticoVO.getNombreRegArchEntra());
						tercerNivelDTO.setNumeroOperaciones(estadisticoVO.getNumeroOperacione());
						tercerNivelDTOs.add(tercerNivelDTO);
					}
				}
				segundoNivelDTO.setTercerNivelDTOs(tercerNivelDTOs);
		   	 }
			primerNivelDTO.setSegundoNivelDTOs(segundoNivelDTOs);
		   	this.primerNivelDTOs.add(primerNivelDTO);
	   	 }
	   	this.totalPaginas = (int)Math.ceil((double)this.primerNivelDTOs.size()/CommandConstants.PAGINADO_ESTADISTICOS);
	   	this.registroInicio = 0;
	   	this.numeroPagina = 1;
		this.registroFin = this.registroInicio + CommandConstants.PAGINADO_ESTADISTICOS;
		if(this.primerNivelDTOs.size()==0) {
			logger.debug("************************ LISTA SIN REGISTROS ************************");
		} else {
			this.modulo1 = "PRODUCTO";
			this.modulo2 = "CANAL";
			paginarEstadisticos();
		}
	}
	
	
	/**
	 * Creates Style Table
	 */
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
	
	/**
	 * Read with filters.
	 */
	@Command
	@NotifyChange({"primerNivelDTOs","numeroPagina","totalPaginas"})
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
							
			if(tipoFiltro.getValue().equals("CANAL-CLIENTE-PRODUCTO")) {
				createCanalClienteProducto(estadisticaDTO);
			} else if(tipoFiltro.getValue().equals("CLIENTE-CANAL-PRODUCTO")) {
				createClienteCanalProducto(estadisticaDTO);
			} else if(tipoFiltro.getValue().equals("PRODUCTO-CANAL-CLIENTE")) {
				createProductoCanalCliente(estadisticaDTO);
			}

			estadisticoDTO.setEstadisticoVOs(estadisticaDTO.getEstadisticoVOs());
			controller.registrarEvento(null, null, CommandConstants.CONSULTAR, "Estadístico");
		}
	}
	
	/**
	 * 
	 */
	public void armaEncabezadoNivel3(){
		Tr tr = new Tr();	
		tr.setSclass("sClassTitulos");
		Td td1 = new Td();
		td1.appendChild(new Label("FECHA"));
		Td td2 = new Td();
		td2.appendChild(new Label("PRODUCTO"));
		Td td3 = new Td();
		td3.appendChild(new Label("NOMBRE ARCHIVO"));
		Td td4 = new Td();
		td4.appendChild(new Label("OPERACIONES"));	
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tbody.appendChild(tr);
	}
	
	/**
	 * 
	 */
	public void armaEncabezadoNivelCliente(){
		Tr tr = new Tr();	
		tr.setSclass("sClassTitulos");
		Td td1 = new Td();
		td1.appendChild(new Label("FECHA"));
		Td td2 = new Td();
		td2.appendChild(new Label("CLIENTE"));
		Td td3 = new Td();
		td3.appendChild(new Label("NOMBRE ARCHIVO"));
		Td td4 = new Td();
		td4.appendChild(new Label("OPERACIONES"));	
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tbody.appendChild(tr);
	}
	
	/**
	 * @param identificador
	 */
	public void armaHijos(String identificador){
		Tr tr;
		Td td1;
		tr = new Tr();	
		tr.setSclass("sClassArchivos");
		td1 = new Td();
		td1.setDynamicProperty("colspan", "4");
		td1.appendChild(new Label(identificador));
		
		tr.appendChild(td1);
		
		tbody.appendChild(tr);
		
	}
	
	/**
	 * @param pro
	 */
	public void armaHijos2(EstadisticoVO pro){
		Tr tr = new Tr();	
		tr.setSclass("sClassArchivos");
		Td td1 = new Td();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		td1.appendChild(new Label(dateFormat.format(pro.getFechaStatusProceso())));
		Td td2 = new Td();
		td2.appendChild(new Label(pro.getNombreProducto()));
		Td td3 = new Td();
		td3.appendChild(new Label(pro.getNombreRegArchEntra()));
		Td td4 = new Td();
		td4.appendChild(new Label(String.valueOf(pro.getNumeroOperacione())));
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tbody.appendChild(tr);
		
	}
	
	/**
	 * @param pro
	 */
	public void armaHijosTercerNivel(TercerNivelDTO pro){
		Tr tr = new Tr();	
		tr.setSclass("sClassArchivos");
		Td td1 = new Td();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		td1.appendChild(new Label(dateFormat.format(pro.getFechaStatusProceso())));
		Td td2 = new Td();
		td2.appendChild(new Label(pro.getNombre()));
		Td td3 = new Td();
		td3.appendChild(new Label(pro.getNombreRegArchEntra()));
		Td td4 = new Td();
		td4.appendChild(new Label(String.valueOf(pro.getNumeroOperaciones())));
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tbody.appendChild(tr);
		
	}
	

	/**
	 * @param pro
	 */
	public void armaHijosCliente(EstadisticoVO pro){
		Tr tr = new Tr();	
		tr.setSclass("sClassArchivos");
		Td td1 = new Td();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		td1.appendChild(new Label(dateFormat.format(pro.getFechaStatusProceso())));
		Td td2 = new Td();
		td2.appendChild(new Label(pro.getIdIdentificador()));
		Td td3 = new Td();
		td3.appendChild(new Label(pro.getNombreRegArchEntra()));
		Td td4 = new Td();
		td4.appendChild(new Label(String.valueOf(pro.getNumeroOperacione())));
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tbody.appendChild(tr);
		
	}
	
	/**
	 * @param nombre
	 * @param noCabecera
	 */
	public void cabecera(String nombre, int noCabecera){
		Tr tr = new Tr();	
		
		if(noCabecera==1)
			tr.setSclass("sClassThead");
		else if(noCabecera==2)
			tr.setSclass("sClassDatosPrimerNivel");
		else
			tr.setSclass("sClassTitulos");
		
		Td td1 = new Td();
		td1.setDynamicProperty("colspan", "4");	
		td1.appendChild(new Label(nombre));
		tr.appendChild(td1);
		tbody.appendChild(tr);
	}
	
	
	/**
	 * @param nombre
	 */
	public void armaRegistroNivel2(String nombre){
		Tr tr = new Tr();	
		tr.setSclass("sClassArchivos");
		Td td1 = new Td();
		td1.setDynamicProperty("colspan", "4");	
		td1.appendChild(new Label(nombre));
		tr.appendChild(td1);
		tbody.appendChild(tr);
	}
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#applyPermision()
	 */
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
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#clean()
	 */
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
	
	/**
	 * Gets the canal.
	 *
	 * @return the canal
	 */
	public Combobox getCanal() {
		return canal;
	}
	
	/**
	 * Gets the canal mock dt os.
	 *
	 * @return the canalMockDTOs
	 */
	public List<CanalMockDTO> getCanalMockDTOs() {
		return canalMockDTOs;
	}	
	
	/**
	 * Gets the canal v os.
	 *
	 * @return the canal v os
	 */
	public ListModel<mx.com.bbva.mapeador.ui.commons.viewmodel.estadistico.CanalVO> getCanalVOs() {
		return new ListModelList<mx.com.bbva.mapeador.ui.commons.viewmodel.estadistico.CanalVO>(getListaCanalVOs());
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
	 * Gets the estadistico dto.
	 *
	 * @return the estadisticoDTO
	 */
	public EstadisticoDTO getEstadisticoDTO() {
		return estadisticoDTO;
	}

	/**
	 * Gets the estadistico mock dto.
	 *
	 * @return the estadisticoMockDTO
	 */
	public EstadisticoMockDTO getEstadisticoMockDTO() {
		return estadisticoMockDTO;
	}

	/**
	 * Gets the estadistico v os.
	 *
	 * @return the estadisticoVOs
	 */
	public List<EstadisticoVO> getEstadisticoVOs() {
		return estadisticoVOs;
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
	 * Gets the id criterio.
	 *
	 * @return the idCriterio
	 */
	public Textbox getIdCriterio() {
		return idCriterio;
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
	 * Gets the lista canal v os.
	 *
	 * @return the lista canal v os
	 */
	public List<mx.com.bbva.mapeador.ui.commons.viewmodel.estadistico.CanalVO> getListaCanalVOs() {
		return canalVOs;
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
	 * Gets the str criterio.
	 *
	 * @return the strCriterio
	 */
	public String getStrCriterio() {
		return strCriterio;
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
	 * Gets the str id producto.
	 *
	 * @return the strIdProducto
	 */
	public String getStrIdProducto() {
		return strIdProducto;
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
		headersReport.add("Canal");
		headersReport.add("Cliente");
		headersReport.add("Fecha");
		headersReport.add("Producto"); 
		headersReport.add("Nombre Archivo"); 
		headersReport.add("Operaciones"); 
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Estadístico");
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Estadístico");
		}
		controller.createReport(generaLista(), headersReport, type, "ESTADISTICO");
	}

	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read(java.lang.Object)
	 */
	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#save()
	 */
	@Override
	public void save() {
		// TODO Auto-generated method stub
		
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
	 * Sets the canal mock dt os.
	 *
	 * @param canalMockDTOs the canalMockDTOs to set
	 */
	public void setCanalMockDTOs(List<CanalMockDTO> canalMockDTOs) {
		this.canalMockDTOs = canalMockDTOs;
	}

	/**
	 * Sets the canal v os.
	 *
	 * @param canalVOs the canalVOs to set
	 */
	public void setCanalVOs(
			List<mx.com.bbva.mapeador.ui.commons.viewmodel.estadistico.CanalVO> canalVOs) {
		this.canalVOs = canalVOs;
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
	 * Sets the estadistico dto.
	 *
	 * @param estadisticoDTO the estadisticoDTO to set
	 */
	public void setEstadisticoDTO(EstadisticoDTO estadisticoDTO) {
		this.estadisticoDTO = estadisticoDTO;
	}

	/**
	 * Sets the estadistico mock dto.
	 *
	 * @param estadisticoMockDTO the estadisticoMockDTO to set
	 */
	public void setEstadisticoMockDTO(EstadisticoMockDTO estadisticoMockDTO) {
		this.estadisticoMockDTO = estadisticoMockDTO;
	}

	/**
	 * Sets the estadistico v os.
	 *
	 * @param estadisticoVOs the estadisticoVOs to set
	 */
	public void setEstadisticoVOs(List<EstadisticoVO> estadisticoVOs) {
		this.estadisticoVOs = estadisticoVOs;
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
	 * Sets the id criterio.
	 *
	 * @param idCriterio the idCriterio to set
	 */
	public void setIdCriterio(Textbox idCriterio) {
		this.idCriterio = idCriterio;
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
	 * Sets the str criterio.
	 *
	 * @param strCriterio the strCriterio to set
	 */
	public void setStrCriterio(String strCriterio) {
		this.strCriterio = strCriterio;
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
	 * Sets the str id producto.
	 *
	 * @param strIdProducto the strIdProducto to set
	 */
	public void setStrIdProducto(String strIdProducto) {
		this.strIdProducto = strIdProducto;
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
	 * @return the primerNivelDTOs
	 */
	public List<PrimerNivelDTO> getPrimerNivelDTOs() {
		return primerNivelDTOs;
	}

	/**
	 * @param primerNivelDTOs the primerNivelDTOs to set
	 */
	public void setPrimerNivelDTOs(List<PrimerNivelDTO> primerNivelDTOs) {
		this.primerNivelDTOs = primerNivelDTOs;
	}

	/**
	 * @return the totalPaginas
	 */
	public int getTotalPaginas() {
		return totalPaginas;
	}

	/**
	 * @param totalPaginas the totalPaginas to set
	 */
	public void setTotalPaginas(int totalPaginas) {
		this.totalPaginas = totalPaginas;
	}

	/**
	 * @return the numeroPagina
	 */
	public int getNumeroPagina() {
		return numeroPagina;
	}

	/**
	 * @param numeroPagina the numeroPagina to set
	 */
	public void setNumeroPagina(int numeroPagina) {
		this.numeroPagina = numeroPagina;
	}

	/**
	 * @return the registroInicio
	 */
	public int getRegistroInicio() {
		return registroInicio;
	}

	/**
	 * @param registroInicio the registroInicio to set
	 */
	public void setRegistroInicio(int registroInicio) {
		this.registroInicio = registroInicio;
	}

	/**
	 * @return the registroFin
	 */
	public int getRegistroFin() {
		return registroFin;
	}

	/**
	 * @param registroFin the registroFin to set
	 */
	public void setRegistroFin(int registroFin) {
		this.registroFin = registroFin;
	}

	/**
	 * @return the flagBack
	 */
	public boolean isFlagBack() {
		return flagBack;
	}

	/**
	 * @param flagBack the flagBack to set
	 */
	public void setFlagBack(boolean flagBack) {
		this.flagBack = flagBack;
	}

	/**
	 * @return the flagNext
	 */
	public boolean isFlagNext() {
		return flagNext;
	}

	/**
	 * @param flagNext the flagNext to set
	 */
	public void setFlagNext(boolean flagNext) {
		this.flagNext = flagNext;
	}	
	
}
