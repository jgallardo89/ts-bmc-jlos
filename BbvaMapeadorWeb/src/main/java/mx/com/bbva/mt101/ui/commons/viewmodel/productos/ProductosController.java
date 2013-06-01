package mx.com.bbva.mt101.ui.commons.viewmodel.productos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.FlujoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ProductoVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.FlujoBO;
import mx.com.bbva.bancomer.mapper.business.ProductoBO;
import mx.com.bbva.bancomer.producto.dto.ProductoDTO;
import mx.com.bbva.bancomer.utils.StringUtil;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;
import mx.com.bbva.mt101.ui.commons.viewmodel.reportes.ReportesController;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

public class ProductosController extends ControllerSupport implements IController  {

	private static final long serialVersionUID = 4844657161922105877L;
	@Wire
	private Textbox idProducto;
	@Wire
	private Textbox idFlujo;
	@Wire
	private Textbox idEstatusObjeto;
	@Wire
	private Textbox nombreProducto;
	@Wire
	private Textbox descripcionProducto;
	@Wire
	private Combobox estatusObjeto;
	@Wire
	private Combobox flujo;	
	
	@Wire
	private Label lblIdentificadorFlujo;
	@Wire
	private Label lblIdentificadorProducto;
	@Wire
	private Label lblNombreProducto;
	@Wire
	private Label lblEstatus;
	@Wire
	private Label lblFechaMod;
	@Wire
	private Image reporteExcelBtn;
	@Wire
	private Image reporteCsvBtn;
	@Wire
	private Button limpiarBtn;
	@Wire
	private Button guardarBtn;
	@Wire
	private Button consultarBtn;
	@Wire
	private Datebox fechaAlta;
	@Wire
	private Datebox fechaModificacion;

	@Wire
	private Grid productosGrid;
	
	private ProductoDTO productoDTO;
	private List<ProductoVO> productoVOs;
	private ProductoVO productoVO;
	private List<FlujoVO> flujoVOs;
	private boolean flagEstatus;
	private boolean executePermissionSet;
	
	public ProductosController() {
		this.read();
		this.productoVOs = productoDTO.getProductoVOs();
	}
	
	@Override
	public Object read() {
		productoDTO = new ProductoDTO();
		ProductoVO productoVO = new ProductoVO();
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
		estatusObjetoVO.setNombreTabla(CommandConstants.NOMBRE_TABLA_PRODUCTOS);		
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
		productoDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
	    
	    FlujoBO flujoBO = new FlujoBO();
	    flujoVOs = flujoBO.readCommand();
	    productoDTO.setProductoVO(productoVO);
		ProductoBO productoBO = new ProductoBO();
		productoBO.readCommand(productoDTO);
		
		flagEstatus = true;
		
		return productoDTO;
	}
	
	private boolean validaProductoRegistrado(String nombreProducto) {
		productoVO = new ProductoVO();
		productoVO.setNombreProducto(nombreProducto.toUpperCase());
		System.out.println("********************* " + nombreProducto  );
		ProductoBO productoBO = new ProductoBO();
		productoDTO = productoBO.readCommand(productoVO);
		System.out.println("*************************** "+productoDTO.getProductoVOs().size()+" ***************************");
		if (productoDTO.getProductoVOs().size() == 0)
			return true;
		else 
			return false;
	}
	
	@Command
	@NotifyChange({ "productoVOs","flagEstatus"})
	public void readWithFilters() {
		ReportesController controller = new ReportesController();
		productoDTO = new ProductoDTO();
		ProductoVO productoVO = new ProductoVO();
		productoVO.setIdFlujo(Integer.parseInt(idFlujo.getValue().isEmpty()?"0":idFlujo.getValue()));
		productoVO.setNombreProducto(StringUtil.validaLike(nombreProducto.getValue()));
		productoVO.setDescripcionProducto(StringUtil.validaLike(descripcionProducto.getValue()));
		productoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
		productoDTO.setProductoVO(productoVO);
		productoVO.toString();
	
		ProductoBO productoBO = new ProductoBO();
		productoVOs = productoBO.readCommand(productoDTO).getProductoVOs();
		controller.registrarEvento(productoVO, productoVO, CommandConstants.CONSULTAR, "Catálogo de Productos");
		flagEstatus = false;
	}
	
	
	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@Command
	@NotifyChange({ "productoVOs","flagEstatus"})
	public void save() {
		ReportesController controller = new ReportesController();
		ProductoBO productoBO = new ProductoBO();
		boolean errorGuardar = false;
		if (flujo.getSelectedItem() == null
				|| flujo.getSelectedItem().getValue() == null
				|| flujo.getSelectedItem().getValue().toString().isEmpty()) {
			flujo.setErrorMessage("Favor de seleccionar el Flujo");
			errorGuardar = true;
		}
		if (nombreProducto.getValue().isEmpty()) {
			nombreProducto
					.setErrorMessage("Favor de introducir el nombre del Producto");
			errorGuardar = true;
		}
		if (descripcionProducto.getValue().isEmpty()) {
			descripcionProducto
					.setErrorMessage("Favor de introducir la descripción del Producto");
			errorGuardar = true;
		}
		if(!errorGuardar){
			if(idProducto.getValue().isEmpty() || idProducto.getValue().equals("0")){
				if(validaProductoRegistrado(nombreProducto.getValue())) {
					ProductoDTO productoDTO = new ProductoDTO();
					ProductoVO productoVO = new ProductoVO();
					productoVO.setNombreProducto(nombreProducto.getValue().toUpperCase());
					productoVO.setDescripcionProducto(descripcionProducto.getValue().toUpperCase());
					productoVO.setIdEstatusObjeto(CommandConstants.ESTATUS_PRODUCTO_ACTIVO);
					productoVO.setIdFlujo(Integer.parseInt(idFlujo.getValue()));
					productoDTO.setProductoVO(productoVO);
					productoBO.createCommand(productoDTO);
					productoDTO.toString(BbvaAbstractDataTransferObject.XML);
					controller.registrarEvento(productoVO, productoVO, CommandConstants.ALTA, "Catálogo de Productos");
					clean();
					productoVO.setIdFlujo(Integer.parseInt(idFlujo.getValue().isEmpty()?"0":idFlujo.getValue()));
					productoVO.setNombreProducto(StringUtil.validaLike(nombreProducto.getValue()));
					productoVO.setDescripcionProducto(StringUtil.validaLike(descripcionProducto.getValue()));
					productoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
					productoVO.toString();
					productoDTO.setProductoVO(productoVO);
					productoVOs = productoBO.readCommand(productoDTO).getProductoVOs();
					Messagebox.show("!El Registro del Producto fue exitoso!",
							"Información", Messagebox.OK,
							Messagebox.INFORMATION);
				} else {
					Messagebox.show("!Ya existe Un Producto registrado con ese Nombre!",
							"Información", Messagebox.OK,
							Messagebox.EXCLAMATION);
					clean();
				}
			} else {
				ProductoDTO productoDTO = new ProductoDTO();
				ProductoVO productoVO = new ProductoVO();
				productoVO.setNombreProducto(nombreProducto.getValue().toUpperCase());
				productoVO.setDescripcionProducto(descripcionProducto.getValue().toUpperCase());
				productoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
				productoVO.setIdFlujo(Integer.parseInt(idFlujo.getValue()));
				productoVO.setIdProducto(Integer.parseInt(idProducto.getValue()));
				productoDTO.setProductoVO(productoVO);
				productoBO.updateCommand(productoDTO);
				productoDTO.toString(BbvaAbstractDataTransferObject.XML);
				controller.registrarEvento(productoVO, this.productoVO, CommandConstants.MODIFICACION, "Catálogo de Productos");
				clean();
				productoVO.setIdFlujo(Integer.parseInt(idFlujo.getValue().isEmpty()?"0":idFlujo.getValue()));
				productoVO.setNombreProducto(StringUtil.validaLike(nombreProducto.getValue()));
				productoVO.setDescripcionProducto(StringUtil.validaLike(descripcionProducto.getValue()));
				productoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
				productoVO.toString();
				productoDTO.setProductoVO(productoVO);
				productoVOs = productoBO.readCommand(productoDTO).getProductoVOs();
				Messagebox.show("!La Actualización del Producto fue exitoso!",
						"Información", Messagebox.OK,
						Messagebox.INFORMATION);
			}
		}
		flagEstatus = true;
	}
	
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	@Override
	@Command
	@NotifyChange({"flagEstatus"})
	public void clean() {
		nombreProducto.clearErrorMessage();
		descripcionProducto.clearErrorMessage();
		estatusObjeto.clearErrorMessage();
		flujo.clearErrorMessage();

		idProducto.setValue(null);
		idFlujo.setValue(null);
		idEstatusObjeto.setValue(null);
		nombreProducto.setValue(null);
		descripcionProducto.setValue(null);
		estatusObjeto.setValue(null);
		flujo.setValue(null);
		flagEstatus = true;
	}
	
	@Command
	@NotifyChange({"flagEstatus"})
	public void readSelected(@BindingParam("idProducto") final ProductoVO productoVO){
		this.productoVO = productoVO;
		productoVO.toString();
		idProducto.setValue(Integer.toString(productoVO.getIdProducto()));
		idFlujo.setValue(Integer.toString(productoVO.getIdFlujo()));
		nombreProducto.setValue(productoVO.getNombreProducto());
		descripcionProducto.setValue(productoVO.getDescripcionProducto());
		idEstatusObjeto.setValue(Integer.toString(productoVO.getIdEstatusObjeto()));
		flujo.setValue(productoVO.getNombreFlujo());
		estatusObjeto.setValue(productoVO.getNombreEstatusObjeto());
		flagEstatus = false;
	}
	
	@Command
	public void onShowReport(@BindingParam("type") final String type) {
		ReportesController controller = new ReportesController();
		ArrayList<String> headersReport = new ArrayList<String>();
		headersReport.add("Identificador Producto");
		headersReport.add("Nombre del Producto");
		headersReport.add("Identificador del Flujo");
		headersReport.add("Fecha Alta");
		headersReport.add("Fecha Modificación");
		headersReport.add("Estatus");
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Catálogo Producto");
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Catálogo Producto");
		}
		controller.createReport(generaLista(), headersReport, type, "PRODUCTO");
	}	
	
	private ArrayList<BeanGenerico> generaLista() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		ArrayList<BeanGenerico> beanGenericos = new ArrayList<BeanGenerico>();
		BeanGenerico beanGenerico = null;
		int i = 1;
		for(ProductoVO productoVO: productoVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(productoVO.getNombreProducto());
			beanGenerico.setValor2(productoVO.getDescripcionProducto());
			beanGenerico.setValor3(productoVO.getNombreFlujo());
			beanGenerico.setValor4(dateFormat.format(productoVO.getFechaAlta()));
			beanGenerico.setColor(i++);
			if(productoVO.getFechaModificacion()==null) {
				beanGenerico.setValor5("");
			} else {
				beanGenerico.setValor5(dateFormat.format(productoVO.getFechaModificacion()));
			}
			beanGenerico.setValor6(productoVO.getNombreEstatusObjeto());
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}

	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
        executePermissionSet = this.applyPermision();
        estatusObjeto.setValue(CommandConstants.NB_PRODUCTO_ACTIVO);
        idEstatusObjeto.setValue(String.valueOf(CommandConstants.ID_PRODUCTO_ACTIVO));
    }

	/**
	 * @return the productoDTO
	 */
	public ProductoDTO getProductoDTO() {
		return productoDTO;
	}

	/**
	 * @param productoDTO the productoDTO to set
	 */
	public void setProductoDTO(ProductoDTO productoDTO) {
		this.productoDTO = productoDTO;
	}

	/**
	 * @return the productoVOs
	 */
	public List<ProductoVO> getProductoVOs() {
		return productoVOs;
	}

	/**
	 * @param productoVOs the productoVOs to set
	 */
	public void setProductoVOs(List<ProductoVO> productoVOs) {
		this.productoVOs = productoVOs;
	}

	/**
	 * @return the flujoVOs
	 */
	public List<FlujoVO> getFlujoVOs() {
		return flujoVOs;
	}

	/**
	 * @param flujoVOs the flujoVOs to set
	 */
	public void setFlujoVOs(List<FlujoVO> flujoVOs) {
		this.flujoVOs = flujoVOs;
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
		componentes.put(lblIdentificadorFlujo.getId(), lblIdentificadorFlujo);
		componentes.put(lblIdentificadorProducto.getId(), lblIdentificadorProducto);
		componentes.put(lblNombreProducto.getId(), lblNombreProducto);
		componentes.put(lblEstatus.getId(), lblEstatus);
		componentes.put(lblFechaMod.getId(), lblFechaMod);
		componentes.put(reporteExcelBtn.getId(), reporteExcelBtn);
		componentes.put(reporteCsvBtn.getId(), reporteCsvBtn);
		componentes.put(limpiarBtn.getId(), limpiarBtn);
		componentes.put(guardarBtn.getId(), guardarBtn);
		componentes.put(consultarBtn.getId(), consultarBtn);
		componentes.put(flujo.getId(), flujo);
		componentes.put(estatusObjeto.getId(), estatusObjeto);
		componentes.put(nombreProducto.getId(), nombreProducto);
		componentes.put(descripcionProducto.getId(), descripcionProducto);
		componentes.put(fechaAlta.getId(), fechaAlta);
		componentes.put(fechaModificacion.getId(), fechaModificacion);
		componentes.put(productosGrid.getId(), productosGrid);
		super.applyPermission(MapeadorConstants.PRODUCTOS, componentes);
		return isApplied;
	}

	/**
	 * @return the productoVO
	 */
	public ProductoVO getProductoVO() {
		return productoVO;
	}

	/**
	 * @param productoVO the productoVO to set
	 */
	public void setProductoVO(ProductoVO productoVO) {
		this.productoVO = productoVO;
	}

	/**
	 * @return the flagEstatus
	 */
	public boolean isFlagEstatus() {
		return flagEstatus;
	}

	/**
	 * @param flagEstatus the flagEstatus to set
	 */
	public void setFlagEstatus(boolean flagEstatus) {
		this.flagEstatus = flagEstatus;
	}
	
}
