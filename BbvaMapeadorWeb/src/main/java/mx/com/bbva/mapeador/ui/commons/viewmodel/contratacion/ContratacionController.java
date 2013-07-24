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
 * Nombre de clase: ContratacionController.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.contratacion
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.contratacion;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import mx.com.bbva.bancomer.bitacora.dto.BitacoraDTO;
import mx.com.bbva.bancomer.bitacora.dto.CampoDTO;
import mx.com.bbva.bancomer.bussinnes.model.vo.CanalVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ClienteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ContratacionMapVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ContratacionVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ProductoVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.canal.dto.CanalDTO;
import mx.com.bbva.bancomer.cliente.dto.ClienteDTO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.contratacion.dto.ContratacionDTO;
import mx.com.bbva.bancomer.contratacion.dto.ValorEtapaDTO;
import mx.com.bbva.bancomer.contratacionmap.dto.ContratacionMapDTO;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.CanalBO;
import mx.com.bbva.bancomer.mapper.business.ClienteBO;
import mx.com.bbva.bancomer.mapper.business.ContratacionBO;
import mx.com.bbva.bancomer.mapper.business.ContratacionMapeadorBO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.ProductoBO;
import mx.com.bbva.bancomer.producto.dto.ProductoDTO;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.reportes.ReportesController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

// TODO: Auto-generated Javadoc
/**
 * The Class ContratacionController.
 */
public class ContratacionController extends ControllerSupport implements IController {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7046754339941749911L;
	
	/** The boton editar. */
	private boolean botonEditar;
	
	/** The boton guardar. */
	private boolean botonGuardar;
	
	/** The boton guardar modal. */
	private boolean botonGuardarModal;
	
	/** The canal. */
	@Wire
	private Combobox canal;
	
	/** The canal salida. */
	@Wire
	private Combobox canalSalida;
	
	/** The cliente. */
	@Wire
	private Combobox cliente;
	
	/** The close btn. */
	@Wire
	private Button closeBtn;
	
	/** The combo producto. */
	private boolean comboProducto;
	
	/** The consultar btn. */
	@Wire
	private Button consultarBtn;
	
	/** The contratacion dto. */
	private ContratacionDTO contratacionDTO;
	
	/** The contratacion grid. */
	@Wire
	private Grid contratacionGrid;
	
	/** The contratacion vo. */
	private ContratacionVO contratacionVO;
	
	/** The contratacion v os. */
	private List<ContratacionVO> contratacionVOs;
	
	/** The editar btn. */
	@Wire
	private Button editarBtn;
	
	/** The editar contratacion windows. */
	@Wire
    Window editarContratacionWindows;
	
	/** The estatus objeto. */
	@Wire
	private Combobox estatusObjeto;
	
	/** The fecha alta. */
	@Wire
	private Datebox fechaAlta;
	
	/** The fecha modificacion. */
	@Wire
	private Datebox fechaModificacion;
	
	/** The flag nva contra. */
	private boolean flagNvaContra;
	
	/** The guarda btn. */
	@Wire
	private Button guardaBtn;
	
	/** The id canal. */
	@Wire
	private Textbox idCanal;
	
	/** The id canal salida. */
	@Wire
	private Textbox idCanalSalida;
	
	/** The id cliente. */
	@Wire
	private Textbox idCliente;
	
	/** The id contratacion. */
	@Wire
	private Textbox idContratacion;
	
	/** The identificador producto. */
	private ProductoVO identificadorProducto;
	
	/** The id estatus objeto. */
	@Wire
	private Textbox idEstatusObjeto;
	
	/** The id producto. */
	@Wire
	private Textbox idProducto;
	
	/** The img csv report. */
	@Wire
	private Image imgCSVReport;
	
	/** The img xls report. */
	@Wire
	private Image imgXLSReport;
	
	/** The lbl canal entrada. */
	@Wire
	private Label lblCanalEntrada;
	
	/** The lbl canal salida. */
	@Wire
	private Label lblCanalSalida;
	
	/** The lbl cliente. */
	@Wire
	private Label lblCliente;
	
	/** The lbl fecha alta. */
	@Wire
	private Label lblFechaAlta;
	
	/** The lbl fecha modificacion. */
	@Wire
	private Label lblFechaModificacion;
	
	/** The lbl producto. */
	@Wire
	private Label lblProducto;
	
	/** The lbl status. */
	@Wire
	private Label lblStatus;
	
	/** The limpiar btn. */
	@Wire
	private Button limpiarBtn;
	
	/** The nueva btn. */
	@Wire
	private Button nuevaBtn;
	
	/** The producto. */
	@Wire
	private Combobox producto;
	
	/** The tab nohome. */
	@Wire
	private Tab tabNohome;
	
	/** The tabs. */
	@Wire
	private Tabbox tabs;
	
	/** The tabs. */
	@Wire
	private Textbox idMapaGmm;
	
	/** The tabs. */
	@Wire
	private Tab newTab;
	
	boolean continuar = true;
	private List<ValorEtapaDTO> valAnteriorContratacion;

	/**
	 * Instantiates a new contratacion controller.
	 */
	public ContratacionController() {
		this.read();
		contratacionVOs = contratacionDTO.getContratacionVOs();
		botonEditar = true;
		botonGuardar = true;
	}
	
	/**
	 * After compose.
	 *
	 * @param view the view
	 */
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);
        contratacionVO = new ContratacionVO();
        contratacionVO = (ContratacionVO) Sessions.getCurrent().getAttribute("contratacionVO");
        if(contratacionVO != null && Sessions.getCurrent().getAttribute("idProducto") == null && tabs != null) {
        	insertaContratacionVO(contratacionVO);
			contratacionDTO.setContratacionVO(contratacionVO);
			setContratacionDTO(contratacionDTO);
			//cargaTabsDinamicosUp(contratacionVO.getIdContratacion());
			mergeEtapas(contratacionVO.getIdContratacion(), contratacionVO.getIdProducto());
			estatusObjeto.setDisabled(false);
			//Sessions.getCurrent().removeAttribute("contratacionVO");
			flagNvaContra = true;
			comboProducto = true;
			cargarCombos();
		} else if(tabs != null) {
			canal.setValue(contratacionVO.getNombreCanal());
			canalSalida.setValue(contratacionVO.getNombreCanalSalida());
			idCanal.setValue(String.valueOf(contratacionVO.getIdCanal()));
			producto.setValue(contratacionVO.getNombreProducto());
			cliente.setValue(contratacionVO.getNombreCliente());
			estatusObjeto.setValue(contratacionVO.getNombreEstatusObjeto());
			contratacionDTO.setContratacionVO(contratacionVO);
			producto.setDisabled(true);
			cargaTabsDinamicosReg(Integer.parseInt((String) Sessions.getCurrent().getAttribute("idProducto")));
			//Sessions.getCurrent().removeAttribute("contratacionVO");
			comboProducto = true;
		}
    }
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#applyPermision()
	 */
	@Override
	public boolean applyPermision() {
		boolean isApplied = false;
		HashMap<String, Component> componentes = new HashMap<String, Component>();
		componentes.put(lblCanalEntrada.getId(), lblCanalEntrada);
		componentes.put(lblCanalSalida.getId(), lblCanalSalida);
		componentes.put(lblCliente.getId(), lblCliente);
		componentes.put(lblProducto.getId(), lblProducto);
		componentes.put(lblFechaAlta.getId(), lblFechaAlta);
		componentes.put(lblFechaModificacion.getId(), lblFechaModificacion);
		componentes.put(lblStatus.getId(), lblStatus);
		componentes.put(canal.getId(), canal);
		componentes.put(canalSalida.getId(), canalSalida);
		componentes.put(cliente.getId(), cliente);
		componentes.put(producto.getId(), producto);
		componentes.put(estatusObjeto.getId(), estatusObjeto);
		componentes.put(fechaAlta.getId(), fechaAlta);
		componentes.put(fechaModificacion.getId(), fechaModificacion);
		componentes.put(imgXLSReport.getId(), imgXLSReport);
		componentes.put(imgCSVReport.getId(), imgCSVReport);
		componentes.put(limpiarBtn.getId(), limpiarBtn);
		componentes.put(consultarBtn.getId(), consultarBtn);
		componentes.put(editarBtn.getId(), editarBtn);
		componentes.put(nuevaBtn.getId(), nuevaBtn);
		componentes.put(guardaBtn.getId(), guardaBtn);
		componentes.put(closeBtn.getId(), closeBtn);
		componentes.put(contratacionGrid.getId(), contratacionGrid);
		super.applyPermission(MapeadorConstants.CANALES, componentes);
		return isApplied;
	}
	
	/**
	 * Cargar combos.
	 */
	private void cargarCombos() {
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
	    estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
	    EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
	    estatusObjetoVO.setNombreTabla(CommandConstants.NOMBRE_TABLA_CONTRATACION);
	    estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
	    estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
	    
	    CanalBO canalBO = new CanalBO();
	    CanalDTO canalDTO = new CanalDTO();
	    canalDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
	    CanalVO canalVO = new CanalVO();
	    canalDTO.setCanalVO(canalVO);
	    canalDTO = canalBO.readCommand();
	    
	    ClienteBO clienteBO = new ClienteBO();
	    ClienteDTO clienteDTO = new ClienteDTO();
	    clienteDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
	    ClienteVO clienteVO = new ClienteVO();
	    clienteDTO.setClienteVO(clienteVO);
	    clienteDTO = clienteBO.readCommand(clienteVO);
	    
	    ProductoBO productoBO = new ProductoBO();
	    ProductoDTO productoDTO = new ProductoDTO();
	    productoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
	    ProductoVO productoVO = new ProductoVO();
	    productoDTO.setProductoVO(productoVO);
	    productoDTO = productoBO.readCommandCmb(productoVO);
	    
	    contratacionDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
	    contratacionDTO.setCanalVOs(canalDTO.getCanalVOs());
	    contratacionDTO.setClienteVOs(clienteDTO.getClienteVOs());
	    contratacionDTO.setProductoVOs(productoDTO.getProductoVOs());
	}
	
	/**
	 * Carga tabs dinamicos reg.
	 *
	 * @param idProduct the id product
	 */
	private void cargaTabsDinamicosReg(int idProduct) {
		ContratacionBO contratacionMapeadorBO = new ContratacionBO();
		
		List<ContratacionMapVO> contratacionMapVOs = new ArrayList<ContratacionMapVO>();
		ContratacionMapVO contratacionMapVO = null;
		
		contratacionVO.setIdProducto(idProduct);
		contratacionDTO.setContratacionVO(contratacionVO);
		contratacionDTO = contratacionMapeadorBO.readCommandEtapas(contratacionDTO);
		Sessions.getCurrent().setAttribute("idContratacionReg", idContratacion);
		//Tab newTab = null;
		Iframe iframe = null;
		Tabpanel newTabpanel = null;
		int contador = 1;
		for(ContratacionVO contratacionVO:contratacionDTO.getContratacionVOs()) {
			
			contratacionMapVO = new ContratacionMapVO();
						
			newTab = new Tab(contratacionVO.getNombreEtapa());
			newTab.setClosable(false);
			newTab.setId(String.valueOf(contador));
			if (contador == 1) {
				newTab.setSelected(true);
			}
	        
	        newTabpanel = new Tabpanel();
	        newTabpanel.setWidth("100%");
	        newTabpanel.setHeight("100%");
	        newTabpanel.setId(contratacionVO.getNombreEtapa());
	        
	        
	        iframe = new Iframe("flows/contratacion/pageTab.zul?idEtapa="+contratacionVO.getIdEtapa()+"&idFlujo="+
	        										contratacionVO.getIdFlujo()+"&idContratacion="+idContratacion.getValue()+
	        										"&estatusNotificacion='T'&idTransaccion=0&idTab="+contador++);
	        iframe.setWidth("100%");
	        iframe.setHeight("100%");
	        newTabpanel.appendChild(iframe);
	        tabs.getTabs().insertBefore(newTab, tabNohome);
	        newTabpanel.setParent(tabs.getTabpanels());
	        contratacionMapVO.setNombreEtapa(contratacionVO.getNombreEtapa());
	        contratacionMapVO.setIdFlujo(contratacionVO.getIdFlujo());
	        contratacionMapVO.setIdEtapa(contratacionVO.getIdEtapa());
	        contratacionMapVO.setEstatusNotificacion('T');
	        contratacionMapVOs.add(contratacionMapVO);
		}
		
		Sessions.getCurrent().setAttribute("contratacionMapVOs", contratacionMapVOs);
		Sessions.getCurrent().setAttribute("contador", contador);
		
	}
	
	/**
	 * Carga tabs dinamicos up.
	 *
	 * @param idContratacion the id contratacion
	 */
	private void cargaTabsDinamicosUp(int idContratacion) {
		ContratacionMapeadorBO contratacionMapeadorBO = new ContratacionMapeadorBO();
		ContratacionMapDTO contratacionMapDTO = new ContratacionMapDTO();
		ContratacionMapVO contratacionMapVO = new ContratacionMapVO();
		contratacionMapVO.setIdContratacion(idContratacion);
		contratacionMapDTO.setContratacionMapVO(contratacionMapVO);
		contratacionMapDTO = contratacionMapeadorBO.readCommand(contratacionMapDTO);
		Sessions.getCurrent().removeAttribute("idContratacionReg");
		Tab newTab = null;
		Iframe iframe = null;
		Tabpanel newTabpanel = null;
		int contador = 1;
		for(ContratacionMapVO mapVO:contratacionMapDTO.getContratacionMapVOs()) {
			newTab = new Tab(mapVO.getNombreEtapa());
			newTab.setClosable(false);	
			if (contador == 1) {
				newTab.setSelected(true);
			}
	        newTab.setId(mapVO.getNombreEtapa() + contador++);
	        newTabpanel = new Tabpanel();
	        newTabpanel.setWidth("100%");
	        newTabpanel.setHeight("100%");
	        newTabpanel.setId(mapVO.getNombreEtapa());
	        iframe = new Iframe("flows/contratacion/pageTab.zul?nombreMapaGmm="+mapVO.getNombreMapaGmm()+"&idMapaGmm="+mapVO.getIdMapaGmm()+
				        		"&idEtapa="+mapVO.getIdEtapa()+"&idFlujo="+mapVO.getIdFlujo()+"&idMensajeSalida="+mapVO.getIdMensajeSalida()+
				        		"&descripcionMapaGmm="+mapVO.getDescripcionMapaGmm()+"&estatusNotificacion="+mapVO.getEstatusNotificacion()+
				        		"&nombreMensajeSalida="+mapVO.getNombreMensajeSalida()+"&descripcionMensajeSalida="+mapVO.getDescripcionMensajeSalida()+
				        		"&descripcionIdUsuarios="+mapVO.getDescripcionIdUsuarios()+"&idContratacion="+mapVO.getIdContratacion()+"&titulo="+
				        		mapVO.getNombreEtapa());
	        iframe.setWidth("100%");
	        iframe.setHeight("100%");
	        newTabpanel.appendChild(iframe);
	        tabs.getTabs().insertBefore(newTab, tabNohome);
	        newTabpanel.setParent(tabs.getTabpanels());
		}
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#clean()
	 */
	@Override
	@GlobalCommand
	@Command
	@NotifyChange({ "botonEditar","botonGuardar" })
	public void clean() {
		canal.setValue(null);
		canalSalida.setValue(null);
		cliente.setValue(null);
		producto.setValue(null);
		estatusObjeto.setValue(null);
		idCanal.setValue(null);
		idCanalSalida.setValue(null);
		idEstatusObjeto.setValue(null);
		idProducto.setValue(null);
		idCliente.setValue(null);
		if(fechaAlta!=null)
		fechaAlta.setValue(null);
		if(fechaModificacion!=null)
		fechaModificacion.setValue(null);
		botonGuardar = true;
		botonEditar = true;
		enabledComponents();
	}

	/**
	 * Close modal.
	 */
	@Command
	@GlobalCommand
	@NotifyChange({"botonGuardar","estatusObjeto"})
	public void closeModal() {
		clean();
		botonGuardar = true;
		botonGuardarModal = true;
		editarContratacionWindows.detach();
    }

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#delete()
	 */
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Disabled components.
	 */
	private void disabledComponents() {
		canal.setDisabled(true);
		canalSalida.setDisabled(true);
		producto.setDisabled(true);
		cliente.setDisabled(true);
		estatusObjeto.setDisabled(true);
	}

	/**
	 * Edita contratacion.
	 */
	@Command
	@NotifyChange({ "flagNvaContra" })
	public void editaContratacion() {
		flagNvaContra = true;
		Sessions.getCurrent().setAttribute("contratacionVO", contratacionVO);
		Sessions.getCurrent().removeAttribute("idProducto");
		Window window = (Window) Executions.createComponents(
				"/WEB-INF/flows/contratacion/editarOtrContratacion.zul",
				this.getSelf(), null);
		window.doModal();
	}

	/**
	 * Enabled components.
	 */
	private void enabledComponents() {
		canal.setDisabled(false);
		canalSalida.setDisabled(false);
		producto.setDisabled(false);
		cliente.setDisabled(false);
		estatusObjeto.setDisabled(false);
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
		for(ContratacionVO contratacionVO: contratacionVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(contratacionVO.getNombreCanal());
			beanGenerico.setValor2(contratacionVO.getNombreCliente());
			beanGenerico.setValor3(contratacionVO.getNombreProducto());
			beanGenerico.setValor4(contratacionVO.getNombreCanalSalida());
			beanGenerico.setValor5(dateFormat.format(contratacionVO.getFechaAlta()));
			if(contratacionVO.getFechaModificacion() != null)
			beanGenerico.setValor6(dateFormat.format(contratacionVO.getFechaModificacion()));
			beanGenerico.setValor7(contratacionVO.getNombreEstatusObjeto());
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}
	
	/**
	 * Gets the contratacion dto.
	 *
	 * @return the contratacionDTO
	 */
	public ContratacionDTO getContratacionDTO() {
		return contratacionDTO;
	}
	
	/**
	 * Gets the contratacion vo.
	 *
	 * @return the contratacionVO
	 */
	public ContratacionVO getContratacionVO() {
		return contratacionVO;
	}
	
	/**
	 * Gets the contratacion v os.
	 *
	 * @return the contratacionVOs
	 */
	public List<ContratacionVO> getContratacionVOs() {
		return contratacionVOs;
	}
	
	
	/**
	 * Gets the identificador producto.
	 *
	 * @return the identificadorProducto
	 */
	public ProductoVO getIdentificadorProducto() {
		return identificadorProducto;
	}
	
	/**
	 * Inserta contratacion vo.
	 *
	 * @param contratacionVO the contratacion vo
	 */
	private void insertaContratacionVO(ContratacionVO contratacionVO) {
		canal.setValue(contratacionVO.getNombreCanal());
		canalSalida.setValue(contratacionVO.getNombreCanalSalida());
		idCanal.setValue(String.valueOf(contratacionVO.getIdCanal()));
		producto.setValue(contratacionVO.getNombreProducto());
		cliente.setValue(contratacionVO.getNombreCliente());
		estatusObjeto.setValue(contratacionVO.getNombreEstatusObjeto());
		disabledComponents();
		
		idContratacion.setValue(String.valueOf(contratacionVO.getIdContratacion()));
		idCanal.setValue(String.valueOf(contratacionVO.getIdCanal()));
		idCanalSalida.setValue(String.valueOf(contratacionVO.getIdCanalSalida()));
		idEstatusObjeto.setValue(String.valueOf(contratacionVO.getIdEstatusObjeto()));
		idProducto.setValue(String.valueOf(contratacionVO.getIdProducto()));
		idCliente.setValue(String.valueOf(contratacionVO.getIdCliente()));
		

	}

	/**
	 * Checks if is boton editar.
	 *
	 * @return the botonEditar
	 */
	public boolean isBotonEditar() {
		return botonEditar;
	}
	
	/**
	 * Checks if is boton guardar.
	 *
	 * @return the botonGuardar
	 */
	public boolean isBotonGuardar() {
		return botonGuardar;
	}
	
	/**
	 * Checks if is boton guardar modal.
	 *
	 * @return the botonGuardarModal
	 */
	public boolean isBotonGuardarModal() {
		return botonGuardarModal;
	}	
	
	/**
	 * Checks if is combo producto.
	 *
	 * @return the comboEstatus
	 */
	public boolean isComboProducto() {
		return comboProducto;
	}
	
	/**
	 * Checks if is flag nva contra.
	 *
	 * @return the flagNvaContra
	 */
	public boolean isFlagNvaContra() {
		return flagNvaContra;
	}
	
	/**
	 * Merge etapas.
	 *
	 * @param idContratacion the id contratacion
	 * @param idProduct the id product
	 */
	private void mergeEtapas(int idContratacion, int idProduct) {
		HashMap<Integer, ContratacionMapVO> hashMapEtapa = new HashMap<Integer, ContratacionMapVO>();
		String mensaje = "";
		ContratacionMapDTO contratacionMapDTO = new ContratacionMapDTO();
		ContratacionVO contratacionVO = new ContratacionVO();
		ContratacionDTO contratacionDTO = new ContratacionDTO();
		ContratacionBO contratacionBO = new ContratacionBO();
		contratacionVO.setIdProducto(idProduct);
		contratacionDTO.setContratacionVO(contratacionVO);
		contratacionDTO = contratacionBO.readCommandEtapas(contratacionDTO);
		
		ContratacionMapeadorBO contratacionMapeadorBO = new ContratacionMapeadorBO();
		ContratacionMapVO contratacionMapVO = new ContratacionMapVO();
		contratacionMapVO.setIdContratacion(idContratacion);
		contratacionMapDTO.setContratacionMapVO(contratacionMapVO);
		contratacionMapDTO = contratacionMapeadorBO.readCommand(contratacionMapDTO);
		Sessions.getCurrent().removeAttribute("idContratacionReg");
		valAnteriorContratacion = new ArrayList<ValorEtapaDTO>();
		
		List<ContratacionMapVO> contratacionMapVOs = new ArrayList<ContratacionMapVO>();
		
		Iframe iframe = null;
		Tabpanel newTabpanel = null;
		int contador = 1;
		
		for(ContratacionVO conVO:contratacionDTO.getContratacionVOs()) {
			ContratacionMapVO mapVO = new ContratacionMapVO();
			mapVO.setIdEtapa(conVO.getIdEtapa());
			mapVO.setIdFlujo(conVO.getIdFlujo());
			mapVO.setIdContratacion(conVO.getIdContratacion());
			mapVO.setNombreEtapa(conVO.getNombreEtapa());
		    hashMapEtapa.put(conVO.getNumeroOrdenEtapa(), mapVO);
		}
		for(ContratacionMapVO mapVO:contratacionMapDTO.getContratacionMapVOs()) {
			hashMapEtapa.put(mapVO.getNumeroOrdenEtapa(), mapVO);
		}
		Collection<ContratacionMapVO> s = hashMapEtapa.values();
   	 	Iterator<ContratacionMapVO> it2 = s.iterator();
	   	 while(it2.hasNext()){
	   		ContratacionMapVO mapVO = it2.next();
				newTab = new Tab(mapVO.getNombreEtapa());
				newTab.setClosable(false);					
				if (contador == 1) {
					newTab.setSelected(true);
				}
		        newTab.setId(String.valueOf(contador));
		        newTabpanel = new Tabpanel();
		        newTabpanel.setWidth("100%");
		        newTabpanel.setHeight("100%");
		        newTabpanel.setId(mapVO.getNombreEtapa());
		      
		        if(mapVO.getNombreMapaGmm()!=null) {
		        	mensaje = mapVO.getDescripcionMensajeSalida().replace("%", "|");
			        iframe = new Iframe("flows/contratacion/pageTab.zul?nombreMapaGmm="+mapVO.getNombreMapaGmm()+"&idMapaGmm="+mapVO.getIdMapaGmm()+
						        		"&idEtapa="+mapVO.getIdEtapa()+"&idFlujo="+mapVO.getIdFlujo()+"&idMensajeSalida="+mapVO.getIdMensajeSalida()+
						        		"&descripcionMapaGmm="+mapVO.getDescripcionMapaGmm()+"&estatusNotificacion="+mapVO.getEstatusNotificacion()+
						        		"&nombreMensajeSalida="+mapVO.getNombreMensajeSalida()+"&descripcionMensajeSalida="+mensaje+
						        		"&descripcionIdUsuarios="+mapVO.getDescripcionIdUsuarios()+"&idContratacion="+mapVO.getIdContratacion()+"&titulo="+
						        		mapVO.getNombreEtapa()+"&idTransaccion=1&idTab="+contador++);			        
		        } else {
		        	iframe = new Iframe("flows/contratacion/pageTab.zul?idEtapa="+mapVO.getIdEtapa()+"&idFlujo="+
		        			mapVO.getIdFlujo()+"&idContratacion="+idContratacion+"&estatusNotificacion='T'&idTransaccion=0&idTab="+contador++);
		        }
		        contratacionMapVOs.add(mapVO);
		        iframe.setWidth("100%");
		        iframe.setHeight("100%");
		        newTabpanel.appendChild(iframe);
		        tabs.getTabs().insertBefore(newTab, tabNohome);
		        newTabpanel.setParent(tabs.getTabpanels());
		        
		        ValorEtapaDTO valorEtapaDTO = new ValorEtapaDTO();
		        
		        valorEtapaDTO.setNombreIdUsuarios(mapVO.getDescripcionIdUsuarios());
		        valorEtapaDTO.setNombreMapaGmm(mapVO.getNombreMapaGmm());
		        valorEtapaDTO.setNombreMensajeSalida(mapVO.getNombreMensajeSalida());
		        valorEtapaDTO.setEstatusNotificacion(mapVO.getEstatusNotificacion());
		        valorEtapaDTO.setEstatus(estatusObjeto.getValue());
		        
		        this.valAnteriorContratacion.add(valorEtapaDTO);
		}
	   	Sessions.getCurrent().setAttribute("contratacionMapVOs", contratacionMapVOs);	   	
	}
	
	/**
	 * Nueva contratacion.
	 *
	 * @param contratacion the contratacion
	 */
	@Command
	@NotifyChange({"botonGuardar","flagNvaContra"})
	public void nuevaContratacion(@BindingParam("contratacion") final String contratacion) {
		flagNvaContra = true;
			contratacionVO = new ContratacionVO();
		if(!idCanal.getValue().equals(""))
			contratacionVO.setIdCanal(Integer.parseInt(idCanal.getValue()));
		if(!idCanalSalida.getValue().equals(""))
			contratacionVO.setIdCanalSalida(Integer.parseInt(idCanalSalida.getValue()));
		if(!idCliente.getValue().equals(""))
			contratacionVO.setIdCliente(Integer.parseInt(idCliente.getValue()));
		if(!idProducto.getValue().equals(""))
			contratacionVO.setIdProducto(Integer.parseInt(idProducto.getValue()));
		if(!idEstatusObjeto.getValue().equals(""))
			contratacionVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
		
		contratacionVO.setNombreCanal(canal.getValue());
		contratacionVO.setNombreCanalSalida(canalSalida.getValue());
		contratacionVO.setNombreCliente(cliente.getValue());
		contratacionVO.setNombreProducto(producto.getValue());
		contratacionVO.setNombreEstatusObjeto(CommandConstants.NB_CONTRATACION_ACTIVO);
		Sessions.getCurrent().setAttribute("contratacionVO", contratacionVO);
		Sessions.getCurrent().setAttribute("idProducto", idProducto.getValue());
		Window window = (Window) Executions.createComponents(
				"/WEB-INF/flows/contratacion/editarOtrContratacion.zul",
				this.getSelf(), null);
		window.doModal();
		canal.setValue(null);
		canalSalida.setValue(null);
		cliente.setValue(null);
		producto.setValue(null);
		estatusObjeto.setValue(null);
		botonGuardar = true;
		botonEditar = true;
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
		headersReport.add("Canal Entrada");
		headersReport.add("Cliente");
		headersReport.add("Producto");
		headersReport.add("Canal Salida");
		headersReport.add("Fecha alta");
		headersReport.add("Fecha modificación");
		headersReport.add("Status");
		controller.createReport(generaLista(), headersReport, type,"CONTRATACION");
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read()
	 */
	@Override
	public Object read() {
		contratacionDTO = new ContratacionDTO();
		cargarCombos();
	    contratacionVO = new ContratacionVO();
	    contratacionDTO.setContratacionVO(contratacionVO);
	    ContratacionBO contratacionBO = new ContratacionBO();
	    contratacionBO.readCommand(contratacionDTO);
	    
		return contratacionDTO;
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
	 * Read contratacion.
	 */
	@Command
	@GlobalCommand
	@NotifyChange({ "contratacionVOs", "estatusObjeto" })
	public void readContratacion() {
		ContratacionDTO contratacionDTO = new ContratacionDTO();
		ContratacionVO contratacionVO = new ContratacionVO();
		contratacionDTO.setContratacionVO(contratacionVO);
		ContratacionBO contratacionBO = new ContratacionBO();
		contratacionVOs = contratacionBO.readCommand(contratacionDTO).getContratacionVOs();
		botonEditar = true;	
	}

	/**
	 * Read selected.
	 *
	 * @param contratacionVO the contratacion vo
	 */
	@Command
	@NotifyChange({ "botonEditar","botonGuardar" })
	public void readSelected(@BindingParam("idContratacion") final ContratacionVO contratacionVO){
		insertaContratacionVO(contratacionVO);
		fechaAlta.setValue(contratacionVO.getFechaAlta());
		fechaModificacion.setValue(contratacionVO.getFechaModificacion());
		Sessions.getCurrent().setAttribute("contratacionVO", contratacionVO);
		this.contratacionVO = contratacionVO;
		setBotonEditar(false);
		botonGuardar = true;
	}

	/**
	 * Read selected tab.
	 *
	 * @param nombreEtapa the nombre etapa
	 */
	@Command
	@NotifyChange({ "contratacionTabWindows" })
	public void readSelectedTab(@BindingParam("nombreEtapa") final String nombreEtapa){
	}
	
	/**
	 * Read with filters.
	 */
	@Command	
	@NotifyChange({ "contratacionVOs" })
	public void readWithFilters() {
		ContratacionDTO contratacionDTO = new ContratacionDTO();
		ContratacionVO contratacionVO = new ContratacionVO();
		contratacionVO.setIdCanal(Integer.parseInt(idCanal.getValue().isEmpty()?"0":idCanal.getValue()));
		contratacionVO.setIdCanalSalida(Integer.parseInt(idCanalSalida.getValue().isEmpty()?"0":idCanalSalida.getValue()));
		contratacionVO.setIdCliente(Integer.parseInt(idCliente.getValue().isEmpty()?"0":idCliente.getValue()));
		contratacionVO.setIdProducto(Integer.parseInt(idProducto.getValue().isEmpty()?"0":idProducto.getValue()));
		contratacionVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
		contratacionVO.setFechaAlta(fechaAlta.getValue());
		contratacionVO.setFechaModificacion(fechaModificacion.getValue());
		contratacionVO.toString();
		contratacionDTO.setContratacionVO(contratacionVO);
		ContratacionBO contratacionBO = new ContratacionBO();
		contratacionVOs = contratacionBO.readCommand(contratacionDTO).getContratacionVOs();
		botonEditar = true;
		ReportesController controller = new ReportesController();
		controller.registrarEvento(null, null, CommandConstants.CONSULTAR, "CONTRATACIÓN");
		//registraBitacora(contratacionVO, CommandConstants.CONSULTAR);		
	}
	
	@GlobalCommand
	@NotifyChange({ "contratacionVOs" })
	public void readWithOutFilters() {
		ContratacionDTO contratacionDTO = new ContratacionDTO();
		ContratacionVO contratacionVO = new ContratacionVO();				
		contratacionVO.toString();
		contratacionDTO.setContratacionVO(contratacionVO);
		ContratacionBO contratacionBO = new ContratacionBO();
		contratacionVOs = contratacionBO.readCommand(contratacionDTO).getContratacionVOs();
		botonEditar = true;		
	}
	/**
	 * Registra bitacora.
	 *
	 * @param contratacionVO the contratacion vo
	 * @param evento the evento
	 */
	private void registraBitacora(ContratacionVO contratacionVO, int evento) {
		List<CampoDTO> campoDTOs = new ArrayList<CampoDTO>(); 
		BitacoraDTO dto = new BitacoraDTO();
		Field[] atributos = contratacionVO.getClass().getFields(); 
		for (int i = 0; i < atributos.length; i++) {
			CampoDTO campo = new CampoDTO();
			campo.setNombre_campo(atributos[i].getName()); 
			campoDTOs.add(campo);
		}		
		dto.setCampoDTOs(campoDTOs);
		registraEvento(dto, "Contratación", evento);
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#save()
	 */
	@Override
	@Command
	@NotifyChange({ "contratacionVOs","idContratacion","botonGuardarModal" })
	public void save() {
		final List<ValorEtapaDTO> valorEtapaDTOs = this.valAnteriorContratacion;
		final ReportesController controller = new ReportesController();
		boolean errorGuardar = false;
		Sessions.getCurrent().removeAttribute("flgCambio");
		continuar = true;
		if(idContratacion.getValue().isEmpty() || idContratacion.getValue().equals("0")) {
			if (canal.getSelectedItem() == null
					|| canal.getSelectedItem().getValue() == null
					|| canal.getSelectedItem().getValue().toString().isEmpty()) {
				canal.setErrorMessage("Favor de seleccionar el Canal Entrada");
				errorGuardar = true;
			}
			if (canalSalida.getSelectedItem() == null
					|| canalSalida.getSelectedItem().getValue() == null
					|| canalSalida.getSelectedItem().getValue().toString().isEmpty()) {
				canalSalida.setErrorMessage("Favor de seleccionar el Canal Salida");
				errorGuardar = true;
			}
			if (producto.getSelectedItem() == null
					|| producto.getSelectedItem().getValue() == null
					|| producto.getSelectedItem().getValue().toString().isEmpty()) {
				producto.setErrorMessage("Favor de seleccionar el Producto");
				errorGuardar = true;
			}
			if (cliente.getSelectedItem() == null
					|| cliente.getSelectedItem().getValue() == null
					|| cliente.getSelectedItem().getValue().toString().isEmpty()) {
				cliente.setErrorMessage("Favor de seleccionar el Cliente");
				errorGuardar = true;
			}
		}
		contratacionDTO = new ContratacionDTO();
		contratacionVO = new ContratacionVO();
		contratacionVO.toString();
		contratacionVO.setIdCanal(Integer.parseInt(idCanal.getValue().isEmpty()?"0":idCanal.getValue()));
		contratacionVO.setIdCanalSalida(Integer.parseInt(idCanalSalida.getValue().isEmpty()?"0":idCanalSalida.getValue()));
		contratacionVO.setIdCliente(Integer.parseInt(idCliente.getValue().isEmpty()?"0":idCliente.getValue()));
		contratacionVO.setIdProducto(Integer.parseInt(idProducto.getValue().isEmpty()?"0":idProducto.getValue()));
		contratacionDTO.setContratacionVO(contratacionVO);
		
		final ContratacionBO contratacionBO = new ContratacionBO();
		final List<ContratacionVO> conVOs = contratacionBO.readCommand(contratacionDTO).getContratacionVOs();
		if(!errorGuardar) {
			ArrayList<ContratacionMapVO> contratacionMapVOs = (ArrayList<ContratacionMapVO>) Sessions.getCurrent().getAttribute("contratacionMapVOs");
			continuar = validaNotificacion(contratacionMapVOs);
			if(continuar) {
				Messagebox.show(
						"¿Está seguro que desea continuar con la operación?",
						"Pregunta", org.zkoss.zul.Messagebox.YES | org.zkoss.zul.Messagebox.NO,
				org.zkoss.zul.Messagebox.QUESTION, new EventListener<Event>() {
					@Override
					public void onEvent(Event event) throws Exception {
						if (event.getName().equals(org.zkoss.zul.Messagebox.ON_YES)) {
							if(idContratacion.getValue().isEmpty() || idContratacion.getValue().equals("0")){
								ArrayList<ContratacionMapVO> contratacionMapVOs = (ArrayList<ContratacionMapVO>) Sessions.getCurrent().getAttribute("contratacionMapVOs");
								ContratacionMapeadorBO contratacionMapeadorBO = new ContratacionMapeadorBO();
								ContratacionMapDTO contratacionMapDTO = new ContratacionMapDTO();
								
								ContratacionDTO contratacionDTO = new ContratacionDTO();
								ContratacionVO contratacionVOL = new ContratacionVO();
								contratacionVOL.setIdEstatusObjeto(CommandConstants.ESTATUS_OBJETO_CONTRATACION_ACTIVO);
								contratacionVOL.setIdCanal(Integer.parseInt(idCanal.getValue()));
								contratacionVOL.setIdCanalSalida(Integer.parseInt(idCanalSalida.getValue()));
								contratacionVOL.setIdCliente(Integer.parseInt(idCliente.getValue()));
								contratacionVOL.setIdProducto(Integer.parseInt(idProducto.getValue()));
								contratacionDTO.setContratacionVO(contratacionVOL);
								
								if(conVOs.size() == 0) {
									contratacionDTO = contratacionBO.createCommand(contratacionDTO);
								}
								idContratacion.setValue(String.valueOf(contratacionDTO.getContratacionVO().getIdContratacion()));										
								ContratacionVO contratacionVONuevo = new ContratacionVO();
								contratacionVONuevo.setIdEstatusObjeto(-1);
								contratacionVONuevo.setIdCanal(-1);
								contratacionVONuevo.setIdCanalSalida(-1);
								contratacionVONuevo.setIdCliente(-1);
								contratacionVONuevo.setIdProducto(-1);								
								if(contratacionDTO.getErrorCode().equals("SQL-001")){
							    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
							    					"\nError:"+contratacionDTO.getErrorCode()+
							    					"","Error de Sistema",Messagebox.OK,Messagebox.ERROR);
							    	controller.registrarEvento(contratacionVOL, contratacionVONuevo, CommandConstants.ERROR_SISTEMA, "CONTRATACIÓN");
								}else{
									if(conVOs.size() == 0) {
										etapa:
										for(ContratacionMapVO contratacionMapVO:contratacionMapVOs) {
											if(contratacionMapVO.getEstatusNotificacion().equals('F')) {
												contratacionMapVO.setIdMensajeSalida(null);
												contratacionMapVO.setDescripcionIdUsuarios(null);
											}
											contratacionMapVO.setIdContratacion(contratacionDTO.getContratacionVO().getIdContratacion());
											contratacionMapDTO.setContratacionMapVO(contratacionMapVO);
											contratacionMapeadorBO.createCommand(contratacionMapDTO);
											if(contratacionMapDTO.getErrorCode().equals("SQL-001")){
												controller.registrarEvento(new ContratacionMapVO(), contratacionMapVO, CommandConstants.ERROR_SISTEMA, "ETAPA CONTRATACIÓN");
										    	Messagebox.show("Actualización Etapas, Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
										    					"\nError:"+contratacionMapDTO.getErrorCode()+
										    					"","Error de Sistema",Messagebox.OK,Messagebox.ERROR);
										    	continuar = false;
										    	break etapa;
											} else {
												contratacionMapVO.setEstatus(estatusObjeto.getValue());
											}
										}
										if(continuar) {
											controller.registrarEvento(contratacionVOL, contratacionVONuevo, CommandConstants.ALTA, "CONTRATACIÓN");
											contratacionDTO = new ContratacionDTO();
											contratacionVO = new ContratacionVO();
											contratacionVO.toString();
											contratacionDTO.setContratacionVO(contratacionVO);								
											contratacionVOs = contratacionBO.readCommand(contratacionDTO).getContratacionVOs();
											disabledComponents();
											botonGuardarModal = true;
											org.zkoss.zul.Messagebox.show("!El Registro de la Contratación fue exitoso!",
													"Información", org.zkoss.zul.Messagebox.OK,
													org.zkoss.zul.Messagebox.INFORMATION);
											BindUtils
											.postGlobalCommand(
													null,
													null,
													"showModal",
													null);
										}
									} else {
										org.zkoss.zul.Messagebox.show("!Fallo el registro, contratación existente!",
												"Información", org.zkoss.zul.Messagebox.OK,
												org.zkoss.zul.Messagebox.EXCLAMATION);
										contratacionVONuevo = new ContratacionVO();
										contratacionVONuevo.setIdEstatusObjeto(-1);
										contratacionVONuevo.setIdCanal(-1);
										contratacionVONuevo.setIdCanalSalida(-1);
										contratacionVONuevo.setIdCliente(-1);
										contratacionVONuevo.setIdProducto(-1);
										clean();
										BindUtils
										.postGlobalCommand(
												null,
												null,
												"showModal",
												null);
									}
								}
							} else {
								ContratacionVO contratacionVOL = new ContratacionVO();
								contratacionVOL.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
								contratacionVOL.setIdContratacion(Integer.parseInt(idContratacion.getValue()));
								if(Integer.parseInt(idEstatusObjeto.getValue()) == CommandConstants.ESTATUS_OBJETO_CONTRATACION_ACTIVO || 
									contratacionBO.validarProcesoContratacion(contratacionVO)) {
									ArrayList<ContratacionMapVO> contratacionMapVOs = (ArrayList<ContratacionMapVO>) Sessions.getCurrent().getAttribute("contratacionMapVOs");
									ContratacionMapeadorBO contratacionMapeadorBO = new ContratacionMapeadorBO();
									ContratacionMapDTO contratacionMapDTO = new ContratacionMapDTO();
	
									//INICIA LA ACTUALIZACIÓN DEL ESTATUS DE LA CONTRATACIÓN
									ContratacionDTO contratacionDTO = new ContratacionDTO();
									contratacionDTO.setContratacionVO(contratacionVOL);
									contratacionDTO = contratacionBO.updateCommand(contratacionDTO);
									if(contratacionDTO.getErrorCode().equals("SQL-001")) {
								    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
								    					"\nError:"+contratacionDTO.getErrorCode()+
								    					"","Error de Sistema",Messagebox.OK,Messagebox.ERROR);
								    	controller.registrarEvento(contratacionVOL, contratacionVO, CommandConstants.ERROR_SISTEMA, "CONTRATACIÓN");
									}else{
										if(Integer.parseInt(idEstatusObjeto.getValue())==CommandConstants.ID_CONTRATACION_BAJA){
											controller.registrarEvento(contratacionVOL, contratacionVO, CommandConstants.BAJA, "CONTRATACIÓN");
											BindUtils
											.postGlobalCommand(
													null,
													null,
													"showModal",
													null);
										}		
										else if(Integer.parseInt(idEstatusObjeto.getValue())!=CommandConstants.ID_CONTRATACION_BAJA)  {
											//INICIA LA ACTUALIZACIÓN DE LAS ETAPAS DE LA CONTRATACIÓN
											etapa:
											for(ContratacionMapVO contratacionMapVO:contratacionMapVOs) {
												if(contratacionMapVO.getEstatusNotificacion().equals('F')) {
													contratacionMapVO.setIdMensajeSalida(null);
													contratacionMapVO.setDescripcionIdUsuarios(null);
												}
												contratacionMapDTO.setContratacionMapVO(contratacionMapVO);
												contratacionMapeadorBO.updateCommand(contratacionMapDTO);
												if(contratacionMapDTO.getErrorCode().equals("SQL-001")){
													controller.registrarEventoContratacion(contratacionMapVOs, valorEtapaDTOs, "CONTRATACIÓN" ,CommandConstants.ERROR_SISTEMA, "ERROR");
											    	Messagebox.show("Actualización Etapas, Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
											    					"\nError:"+contratacionMapDTO.getErrorCode()+
											    					"","Error de Sistema",Messagebox.OK,Messagebox.ERROR);
											    	continuar = false;
											    	break etapa;
												} else {
													contratacionMapVO.setEstatus(estatusObjeto.getValue());
												}
											}
											if(continuar) {
												if(Integer.parseInt(idEstatusObjeto.getValue())==CommandConstants.ID_CONTRATACION_ACTIVO) {
													controller.registrarEventoContratacion(contratacionMapVOs, valorEtapaDTOs, "CONTRATACIÓN",CommandConstants.MODIFICACION, "ACTIVO");
												}
												else {
													controller.registrarEventoContratacion(contratacionMapVOs, valorEtapaDTOs, "CONTRATACIÓN",CommandConstants.INACTIVACION, "INACTIVO");
												}
												contratacionDTO = new ContratacionDTO();
												contratacionVO = new ContratacionVO();
												contratacionVO.toString();
												contratacionDTO.setContratacionVO(contratacionVO);								
												contratacionVOs = contratacionBO.readCommand(contratacionDTO).getContratacionVOs();
												botonGuardarModal = true;
												org.zkoss.zul.Messagebox.show("!La Actualización de la Contratación fue exitoso!",
														"Información", org.zkoss.zul.Messagebox.OK,
														org.zkoss.zul.Messagebox.INFORMATION);
												BindUtils
												.postGlobalCommand(
														null,
														null,
														"showModal",
														null);
											}
										}
										else {
											org.zkoss.zul.Messagebox.show("!No se selecciono un Estatus!",
													"Información", org.zkoss.zul.Messagebox.OK,
													org.zkoss.zul.Messagebox.INFORMATION);
										}
									}
								} else {
									org.zkoss.zul.Messagebox.show("!La contratación no se puede dar de Baja o Inactivar!",
											"Información", org.zkoss.zul.Messagebox.OK,
											org.zkoss.zul.Messagebox.EXCLAMATION);
									ContratacionVO contratacionVONuevo = new ContratacionVO();
									contratacionVONuevo.setIdEstatusObjeto(-1);
									contratacionVONuevo.setIdCanal(-1);
									contratacionVONuevo.setIdCanalSalida(-1);
									contratacionVONuevo.setIdCliente(-1);
									contratacionVONuevo.setIdProducto(-1);
									
									if(Integer.parseInt(idEstatusObjeto.getValue())==CommandConstants.ID_CONTRATACION_BAJA)
										controller.registrarEvento(contratacionVOL, contratacionVONuevo, CommandConstants.BAJA_FALLIDA, "CONTRATACIÓN");
									else
										controller.registrarEvento(contratacionVOL, contratacionVONuevo, CommandConstants.INACTIVACION_FALLIDA, "CONTRATACIÓN");
									clean();
								}
							}
							BindUtils
							.postGlobalCommand(
									null,
									null,
									"readWithOutFilters",
									null);
						}
					}
				});
			}
		}
	}
	
	private boolean validaNotificacion(ArrayList<ContratacionMapVO> contratacionMapVOs) {
		boolean continuar = true;
		contratacion:
		if(contratacionMapVOs!=null) {
			for(ContratacionMapVO contratacionMapVO:contratacionMapVOs) {
				if(contratacionMapVO.getIdMapaGmm()==0) {
					continuar = false;
					org.zkoss.zul.Messagebox.show("Falta seleccionar el Mapa en la Etapa: "+contratacionMapVO.getNombreEtapa(),
								"Información", org.zkoss.zul.Messagebox.OK,
								org.zkoss.zul.Messagebox.EXCLAMATION);
					break contratacion;
				}
				if(!contratacionMapVO.getEstatusNotificacion().equals('F')) {
					 if(contratacionMapVO.getIdMensajeSalida()==null) {
						 continuar = false;
						 org.zkoss.zul.Messagebox.show("Falta seleccionar el Mensaje en la Etapa: "+contratacionMapVO.getNombreEtapa(),
									"Información", org.zkoss.zul.Messagebox.OK,
									org.zkoss.zul.Messagebox.EXCLAMATION);
						 break contratacion;
					 }
					 if(contratacionMapVO.getDescripcionIdUsuarios()==null) {
						 continuar = false;
						 org.zkoss.zul.Messagebox.show("Falta seleccionar al menos un Usuario en la Etapa: "+contratacionMapVO.getNombreEtapa(),
									"Información", org.zkoss.zul.Messagebox.OK,
									org.zkoss.zul.Messagebox.EXCLAMATION);
						 break contratacion;
					 }
				}
			}
		} else {
			 continuar = false;
			 org.zkoss.zul.Messagebox.show("Ocurrió un error en la sesión",
						"Información", org.zkoss.zul.Messagebox.OK,
						org.zkoss.zul.Messagebox.EXCLAMATION);
		}
		return continuar;
	}
	
	/**
	 * Selecciona producto.
	 */
	@Command
	@NotifyChange({ "botonEditar","botonGuardar", "idProducto", "idContratacion"})
	public void seleccionaProducto() {
		idProducto.setValue(String.valueOf(identificadorProducto.getIdProducto()));
		idContratacion.setValue(null);
		botonEditar = true;
		botonGuardar = false;
	}

	/**
	 * Selected value productos.
	 */
	@Command
	@NotifyChange({ "botonGuardar" })
	public void selectedValueProductos() {
		botonGuardar = false;
	}

	/**
	 * Sets the boton editar.
	 *
	 * @param botonEditar the botonEditar to set
	 */
	public void setBotonEditar(boolean botonEditar) {
		this.botonEditar = botonEditar;
	}

	/**
	 * Sets the boton guardar.
	 *
	 * @param botonGuardar the botonGuardar to set
	 */
	public void setBotonGuardar(boolean botonGuardar) {
		this.botonGuardar = botonGuardar;
	}

	/**
	 * Sets the boton guardar modal.
	 *
	 * @param botonGuardarModal the botonGuardarModal to set
	 */
	public void setBotonGuardarModal(boolean botonGuardarModal) {
		this.botonGuardarModal = botonGuardarModal;
	}
	
	/**
	 * Sets the combo producto.
	 *
	 * @param comboProducto the new combo producto
	 */
	public void setComboProducto(boolean comboProducto) {
		this.comboProducto = comboProducto;
	}

	/**
	 * Sets the contratacion dto.
	 *
	 * @param contratacionDTO the contratacionDTO to set
	 */
	public void setContratacionDTO(ContratacionDTO contratacionDTO) {
		this.contratacionDTO = contratacionDTO;
	}

	/**
	 * Sets the contratacion vo.
	 *
	 * @param contratacionVO the contratacionVO to set
	 */
	public void setContratacionVO(ContratacionVO contratacionVO) {
		this.contratacionVO = contratacionVO;
	}

	/**
	 * Sets the contratacion v os.
	 *
	 * @param contratacionVOs the contratacionVOs to set
	 */
	public void setContratacionVOs(List<ContratacionVO> contratacionVOs) {
		this.contratacionVOs = contratacionVOs;
	}
	
	/**
	 * Sets the flag nva contra.
	 *
	 * @param flagNvaContra the flagNvaContra to set
	 */
	public void setFlagNvaContra(boolean flagNvaContra) {
		this.flagNvaContra = flagNvaContra;
	}

	/**
	 * Sets the identificador producto.
	 *
	 * @param identificadorProducto the identificadorProducto to set
	 */
	public void setIdentificadorProducto(ProductoVO identificadorProducto) {
		this.identificadorProducto = identificadorProducto;
	}

	/**
	 * Show modal.
	 *
	 * @param e the e
	 */
	@Command
	@GlobalCommand
	@NotifyChange({"botonGuardar"})
	@Listen("onClick = #closeBtn")
    public void showModal(Event e) {
		try{
			if(Sessions.getCurrent().getAttribute("flgCambio")!=null) {
				Messagebox.show(
						"¿Está seguro que desea Salir sin guardar los cambios?",
						"Pregunta", org.zkoss.zul.Messagebox.YES | org.zkoss.zul.Messagebox.NO,
				org.zkoss.zul.Messagebox.QUESTION, new EventListener<Event>() {
					@Override
					public void onEvent(Event event) throws Exception {
						if (event.getName().equals(org.zkoss.zul.Messagebox.ON_YES)) {
							botonGuardar = true;
							botonGuardarModal = true;		
							editarContratacionWindows.detach();
							BindUtils.postGlobalCommand(null, null, "clean", null);
							Sessions.getCurrent().removeAttribute("flgCambio");
							Sessions.getCurrent().removeAttribute("contratacionMapVOs");
						}
					}
				});
			} else {
				botonGuardar = true;
				botonGuardarModal = true;		
				editarContratacionWindows.detach();
				BindUtils.postGlobalCommand(null, null, "clean", null);
				Sessions.getCurrent().removeAttribute("flgCambio");
				Sessions.getCurrent().removeAttribute("contratacionMapVOs");
			}
		}catch(Exception ex){
			BindUtils.postGlobalCommand(null, null, "clean", null);
		}
    }	
}
