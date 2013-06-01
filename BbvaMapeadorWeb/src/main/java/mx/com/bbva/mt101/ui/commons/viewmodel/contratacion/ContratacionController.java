package mx.com.bbva.mt101.ui.commons.viewmodel.contratacion;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import mx.com.bbva.bancomer.contratacion.dto.ContratacionDTO;
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
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;
import mx.com.bbva.mt101.ui.commons.viewmodel.reportes.ReportesController;

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
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class ContratacionController extends ControllerSupport implements IController {

	private static final long serialVersionUID = -7046754339941749911L;
	@Wire
	private Tabbox tabs;
	@Wire
	private Tab tabNohome;
	@Wire
	private Textbox idContratacion;
	@Wire
	private Textbox idCanal;
	@Wire
	private Combobox canal;
	@Wire
	private Textbox idCliente;
	@Wire
	private Combobox cliente;
	@Wire
	private Textbox idProducto;
	@Wire
	private Combobox producto;
	@Wire
	private Textbox idCanalSalida;
	@Wire
	private Combobox canalSalida;
	@Wire
	private Textbox idEstatusObjeto;
	@Wire
	private Combobox estatusObjeto;
	
	private boolean botonEditar;
	private boolean botonGuardar;
	private boolean comboEstatus;
	private boolean flagNvaContra;
	private ContratacionDTO contratacionDTO;
	private List<ContratacionVO> contratacionVOs;
	private ContratacionVO contratacionVO;
	
	private ProductoVO identificadorProducto;
	
	public ContratacionController() {
		this.read();
		contratacionVOs = contratacionDTO.getContratacionVOs();
		botonEditar = true;
		botonGuardar = true;
	}

	@Override
	public Object read() {
		contratacionDTO = new ContratacionDTO();
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
	    estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
	    EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
	    //estatusObjetoVO.setNombreTabla("CONTRATACION");
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
	    clienteDTO = clienteBO.readCommand();
	    
	    ProductoBO productoBO = new ProductoBO();
	    ProductoDTO productoDTO = new ProductoDTO();
	    productoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
	    ProductoVO productoVO = new ProductoVO();
	    productoDTO.setProductoVO(productoVO);
	    productoDTO = productoBO.readCommand(productoVO);
	    
	    contratacionDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
	    contratacionDTO.setCanalVOs(canalDTO.getCanalVOs());
	    contratacionDTO.setClienteVOs(clienteDTO.getClienteVOs());
	    contratacionDTO.setProductoVOs(productoDTO.getProductoVOs());
	    
	    ContratacionBO contratacionBO = new ContratacionBO();
	    contratacionBO.readCommand(contratacionDTO);
	    
		return contratacionDTO;
	}
	
	@Command
	@GlobalCommand
	@NotifyChange({ "contratacionVOs" })
	public void readWithFilters() {
		ContratacionDTO contratacionDTO = new ContratacionDTO();
		ContratacionVO contratacionVO = new ContratacionVO();
		contratacionVO.setIdCanal(Integer.parseInt(idCanal.getValue().isEmpty()?"0":idCanal.getValue()));
		contratacionVO.setIdCanalSalida(Integer.parseInt(idCanalSalida.getValue().isEmpty()?"0":idCanalSalida.getValue()));
		contratacionVO.setIdCliente(Integer.parseInt(idCliente.getValue().isEmpty()?"0":idCliente.getValue()));
		contratacionVO.setIdProducto(Integer.parseInt(idProducto.getValue().isEmpty()?"0":idProducto.getValue()));
		contratacionVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
		contratacionVO.toString();
		contratacionDTO.setContratacionVO(contratacionVO);
		ContratacionBO contratacionBO = new ContratacionBO();
		contratacionVOs = contratacionBO.readCommand(contratacionDTO).getContratacionVOs();
		botonEditar = true;
		registraBitacora(contratacionVO, 2);		
	}
	
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

	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Command
	@NotifyChange({ "contratacionVOs","idContratacion" })
	public void save() {
		if(idContratacion.getValue().isEmpty() || idContratacion.getValue().equals("0")){
			ContratacionDTO contratacionDTO = new ContratacionDTO();
			ContratacionVO contratacionVO = new ContratacionVO();
			ContratacionBO contratacionBO = new ContratacionBO();
			contratacionVO.setIdEstatusObjeto(CommandConstants.ESTATUS_OBJETO_CONTRATACION_ACTIVO);
			contratacionVO.setIdCanal(Integer.parseInt(idCanal.getValue()));
			contratacionVO.setIdCanalSalida(Integer.parseInt(idCanalSalida.getValue()));
			contratacionVO.setIdCliente(Integer.parseInt(idCliente.getValue()));
			contratacionVO.setIdProducto(Integer.parseInt(idProducto.getValue()));
			contratacionDTO.setContratacionVO(contratacionVO);
			contratacionDTO = contratacionBO.createCommand(contratacionDTO);
			
			idContratacion.setValue(String.valueOf(contratacionDTO.getContratacionVO().getIdContratacion()));
			
			contratacionDTO = new ContratacionDTO();
			contratacionVO = new ContratacionVO();
			contratacionVO.toString();
			contratacionDTO.setContratacionVO(contratacionVO);
			contratacionBO = new ContratacionBO();
			contratacionVOs = contratacionBO.readCommand(contratacionDTO).getContratacionVOs();
			estatusObjeto.setValue(estatusObjeto.getValue());
			Messagebox.show("!El Registro de la Contratación fue exitoso!",
					"Información", Messagebox.OK,
					Messagebox.INFORMATION);
			cargaTabsDinamicosReg(Integer.parseInt((String) Sessions.getCurrent().getAttribute("idProducto")));
		}else {
			ContratacionDTO contratacionDTO = new ContratacionDTO();
			ContratacionVO contratacionVO = new ContratacionVO();
			ContratacionBO contratacionBO = new ContratacionBO();
			contratacionVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
			contratacionVO.setIdContratacion(Integer.parseInt(idContratacion.getValue()));
			contratacionDTO.setContratacionVO(contratacionVO);
			contratacionBO.updateCommand(contratacionDTO);
			
			contratacionDTO = new ContratacionDTO();
			contratacionVO = new ContratacionVO();
			contratacionVO.setIdCanal(Integer.parseInt(idCanal.getValue().isEmpty()?"0":idCanal.getValue()));
			contratacionVO.setIdCanalSalida(Integer.parseInt(idCanalSalida.getValue().isEmpty()?"0":idCanalSalida.getValue()));
			contratacionVO.setIdCliente(Integer.parseInt(idCliente.getValue().isEmpty()?"0":idCliente.getValue()));
			contratacionVO.setIdProducto(Integer.parseInt(idProducto.getValue().isEmpty()?"0":idProducto.getValue()));
			contratacionVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
			contratacionVO.toString();
			contratacionDTO.setContratacionVO(contratacionVO);
			contratacionBO = new ContratacionBO();
			contratacionVOs = contratacionBO.readCommand(contratacionDTO).getContratacionVOs();
			estatusObjeto.setValue(estatusObjeto.getValue());
			Messagebox.show("!La Actualización del Estado de la Contratación fue exitoso!",
					"Información", Messagebox.OK,
					Messagebox.INFORMATION);
		}
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
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
		botonGuardar = true;
		botonEditar = true;
	}

	@Command
	@NotifyChange({ "botonEditar","botonGuardar" })
	public void readSelected(@BindingParam("idContratacion") final ContratacionVO contratacionVO){
		insertaContratacionVO(contratacionVO);
		
		Sessions.getCurrent().setAttribute("contratacionVO", contratacionVO);
		this.contratacionVO = contratacionVO;
		setBotonEditar(false);
		botonGuardar = true;
	}
	
	private void insertaContratacionVO(ContratacionVO contratacionVO) {
		canal.setValue(contratacionVO.getNombreCanal());
		canalSalida.setValue(contratacionVO.getNombreCanalSalida());
		idCanal.setValue(String.valueOf(contratacionVO.getIdCanal()));
		producto.setValue(contratacionVO.getNombreProducto());
		cliente.setValue(contratacionVO.getNombreCliente());
		estatusObjeto.setValue(contratacionVO.getNombreEstatusObjeto());
		
		idContratacion.setValue(String.valueOf(contratacionVO.getIdContratacion()));
		idCanal.setValue(String.valueOf(contratacionVO.getIdCanal()));
		idCanalSalida.setValue(String.valueOf(contratacionVO.getIdCanalSalida()));
		idEstatusObjeto.setValue(String.valueOf(contratacionVO.getIdEstatusObjeto()));
		idProducto.setValue(String.valueOf(contratacionVO.getIdProducto()));
		idCliente.setValue(String.valueOf(contratacionVO.getIdCliente()));
		
	}
	
	@Command
	@NotifyChange({ "contratacionTabWindows" })
	public void readSelectedTab(@BindingParam("nombreEtapa") final String nombreEtapa){
		System.out.println("******************* " + nombreEtapa + " *******************" + idContratacion.getValue());
	}
	
	@Command
	public void editaContratacion() {
		Sessions.getCurrent().setAttribute("contratacionVO", contratacionVO);
		Sessions.getCurrent().removeAttribute("idProducto");
		Window window = (Window) Executions.createComponents(
				"/WEB-INF/flows/contratacion/editarOtrContratacion.zul",
				this.getSelf(), null);
		window.doModal();
	}
	
	@Command
	@NotifyChange({"botonGuardar"})
	public void nuevaContratacion(@BindingParam("contratacion") final String contratacion) {
		flagNvaContra = false;
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
		contratacionVO.setNombreEstatusObjeto(estatusObjeto.getValue());
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
	
	
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);
        contratacionVO = new ContratacionVO();
        contratacionVO = (ContratacionVO) Sessions.getCurrent().getAttribute("contratacionVO");
        if(contratacionVO != null && Sessions.getCurrent().getAttribute("idProducto") == null && tabs != null) {
        	insertaContratacionVO(contratacionVO);
			contratacionDTO.setContratacionVO(contratacionVO);
			setContratacionDTO(contratacionDTO);
			cargaTabsDinamicosUp(contratacionVO.getIdContratacion());
			//Sessions.getCurrent().removeAttribute("contratacionVO");
			comboEstatus = true;
		} else if(tabs != null) {
			canal.setValue(contratacionVO.getNombreCanal());
			canalSalida.setValue(contratacionVO.getNombreCanalSalida());
			idCanal.setValue(String.valueOf(contratacionVO.getIdCanal()));
			producto.setValue(contratacionVO.getNombreProducto());
			cliente.setValue(contratacionVO.getNombreCliente());
			estatusObjeto.setValue(contratacionVO.getNombreEstatusObjeto());
			contratacionDTO.setContratacionVO(contratacionVO);
			//cargaTabsDinamicosReg(Integer.parseInt((String) Sessions.getCurrent().getAttribute("idProducto")));
			//Sessions.getCurrent().removeAttribute("contratacionVO");
			comboEstatus = false;
		}
    }

	private void cargaTabsDinamicosUp(int idContratacion) {
		ContratacionMapeadorBO contratacionMapeadorBO = new ContratacionMapeadorBO();
		ContratacionMapDTO contratacionMapDTO = new ContratacionMapDTO();
		ContratacionMapVO contratacionMapVO = new ContratacionMapVO();
		contratacionMapVO.setIdContratacion(idContratacion);
		contratacionMapDTO.setContratacionMapVO(contratacionMapVO);
		contratacionMapDTO = contratacionMapeadorBO.readCommand(contratacionMapDTO);
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
				        		"&descripcionIdUsuarios="+mapVO.getDescripcionIdUsuarios()+"&idContratacion="+mapVO.getIdContratacion()+"&titulo="+mapVO.getNombreEtapa());
	        
	        iframe.setWidth("100%");
	        iframe.setHeight("100%");
	        newTabpanel.appendChild(iframe);
	        tabs.getTabs().insertBefore(newTab, tabNohome);
	        newTabpanel.setParent(tabs.getTabpanels());
		}
	}
	
	private void cargaTabsDinamicosReg(int idProduct) {
		ContratacionBO contratacionMapeadorBO = new ContratacionBO();
		contratacionVO.setIdProducto(idProduct);
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+idProduct+"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		contratacionDTO.setContratacionVO(contratacionVO);
		contratacionDTO = contratacionMapeadorBO.readCommandEtapas(contratacionDTO);
		
		Tab newTab = null;
		Iframe iframe = null;
		Tabpanel newTabpanel = null;
		int contador = 1;
		for(ContratacionVO contratacionVO:contratacionDTO.getContratacionVOs()) {
			newTab = new Tab(contratacionVO.getNombreEtapa());
			newTab.setClosable(false);	
			if (contador == 1) {
				newTab.setSelected(true);
			}
	        newTab.setId(contratacionVO.getNombreEtapa() + contador++);
	        newTabpanel = new Tabpanel();
	        newTabpanel.setWidth("100%");
	        newTabpanel.setHeight("100%");
	        newTabpanel.setId(contratacionVO.getNombreEtapa());
	        iframe = new Iframe("flows/contratacion/pageTab.zul");
	        iframe.setWidth("100%");
	        iframe.setHeight("100%");
	        newTabpanel.appendChild(iframe);
	        tabs.getTabs().insertBefore(newTab, tabNohome);
	        newTabpanel.setParent(tabs.getTabpanels());
	        System.out.println("******************************2*******************************");
		}
		
	}
	
	@Command
	public void onShowReport(@BindingParam("type") final String type) {
		ReportesController controller = new ReportesController();
		ArrayList<String> headersReport = new ArrayList<String>();
		headersReport.add("Canal Entrada");
		headersReport.add("Cliente");
		headersReport.add("Producto");
		headersReport.add("Canal salida");
		headersReport.add("Fecha Alta");
		headersReport.add("Fecha Modificacion");
		headersReport.add("Estatus");
		controller.createReport(generaLista(), headersReport, type,"Contratacion");
	}	
	
	private ArrayList<BeanGenerico> generaLista() {
		ArrayList<BeanGenerico> beanGenericos = new ArrayList<BeanGenerico>();
		BeanGenerico beanGenerico = null;
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
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
	
	@Command
	@NotifyChange({ "botonGuardar" })
	public void selectedValueProductos() {
		System.out.println("***************************1**2**3*****************");
		botonGuardar = false;
	}
	
	@Wire
    Window editarContratacionWindow;
	
	@Command
	@GlobalCommand
	@NotifyChange({"botonGuardar"})
	@Listen("onClick = #closeBtn")
    public void showModal(Event e) {
		botonGuardar = true;
		editarContratacionWindow.detach();
    }
	
	@Command
	@GlobalCommand
	@NotifyChange({"botonGuardar"})
	public void closeModal() {
		botonGuardar = true;
		editarContratacionWindow.detach();
    }
	
	@Command
	@NotifyChange({ "botonEditar","botonGuardar", "idProducto", "idContratacion"})
	public void seleccionaProducto() {
		idProducto.setValue(String.valueOf(identificadorProducto.getIdProducto()));
		idContratacion.setValue(null);
		botonEditar = true;
		botonGuardar = false;
	}
	
	/**
	 * @return the contratacionDTO
	 */
	public ContratacionDTO getContratacionDTO() {
		return contratacionDTO;
	}

	/**
	 * @param contratacionDTO the contratacionDTO to set
	 */
	public void setContratacionDTO(ContratacionDTO contratacionDTO) {
		this.contratacionDTO = contratacionDTO;
	}

	/**
	 * @return the contratacionVOs
	 */
	public List<ContratacionVO> getContratacionVOs() {
		return contratacionVOs;
	}

	/**
	 * @param contratacionVOs the contratacionVOs to set
	 */
	public void setContratacionVOs(List<ContratacionVO> contratacionVOs) {
		this.contratacionVOs = contratacionVOs;
	}
	
	/**
	 * @return the contratacionVO
	 */
	public ContratacionVO getContratacionVO() {
		return contratacionVO;
	}

	/**
	 * @param contratacionVO the contratacionVO to set
	 */
	public void setContratacionVO(ContratacionVO contratacionVO) {
		this.contratacionVO = contratacionVO;
	}
	
	/**
	 * @return the botonEditar
	 */
	public boolean isBotonEditar() {
		return botonEditar;
	}

	/**
	 * @param botonEditar the botonEditar to set
	 */
	public void setBotonEditar(boolean botonEditar) {
		this.botonEditar = botonEditar;
	}

	/**
	 * @return the botonGuardar
	 */
	public boolean isBotonGuardar() {
		return botonGuardar;
	}

	/**
	 * @param botonGuardar the botonGuardar to set
	 */
	public void setBotonGuardar(boolean botonGuardar) {
		this.botonGuardar = botonGuardar;
	}

	/**
	 * @return the flagNvaContra
	 */
	public boolean isFlagNvaContra() {
		return flagNvaContra;
	}

	/**
	 * @param flagNvaContra the flagNvaContra to set
	 */
	public void setFlagNvaContra(boolean flagNvaContra) {
		this.flagNvaContra = flagNvaContra;
	}
	
	/**
	 * @return the identificadorProducto
	 */
	public ProductoVO getIdentificadorProducto() {
		return identificadorProducto;
	}

	/**
	 * @param identificadorProducto the identificadorProducto to set
	 */
	public void setIdentificadorProducto(ProductoVO identificadorProducto) {
		this.identificadorProducto = identificadorProducto;
	}

	/**
	 * @return the comboEstatus
	 */
	public boolean isComboEstatus() {
		return comboEstatus;
	}

	/**
	 * @param comboEstatus the comboEstatus to set
	 */
	public void setComboEstatus(boolean comboEstatus) {
		this.comboEstatus = comboEstatus;
	}
	@Override
	public boolean applyPermision() {
		// TODO Auto-generated method stub
		return false;
	}
}
