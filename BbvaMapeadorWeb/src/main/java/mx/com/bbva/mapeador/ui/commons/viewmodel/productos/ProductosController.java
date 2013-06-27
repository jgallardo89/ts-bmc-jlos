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
 * Nombre de clase: ProductosController.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.productos
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.productos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ContratacionVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.FlujoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ProductoVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.ContratacionBO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.FlujoBO;
import mx.com.bbva.bancomer.mapper.business.ProductoBO;
import mx.com.bbva.bancomer.producto.dto.ProductoDTO;
import mx.com.bbva.bancomer.utils.StringUtil;
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
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductosController.
 */
public class ProductosController extends ControllerSupport implements IController  {

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(ProductosController.class);
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4844657161922105877L;
	
	/** The nombre Pantalla */
	private static final String nombrePantalla="Catálogo Productos";
	
	/** The consultar btn. */
	@Wire
	private Button consultarBtn;
	
	/** The descripcion producto. */
	@Wire
	private Textbox descripcionProducto;
	
	/** The estatus objeto. */
	@Wire
	private Combobox estatusObjeto;
	
	/** The execute permission set. */
	private boolean executePermissionSet;
	
	/** The fecha alta. */
	@Wire
	private Datebox fechaAlta;
	
	/** The fecha modificacion. */
	@Wire
	private Datebox fechaModificacion;
	
	/** The flag estatus. */
	private boolean flagEstatus;	
	
	/** The flujo. */
	@Wire
	private Combobox flujo;
	
	/** The flujo v os. */
	private List<FlujoVO> flujoVOs;
	
	/** The guardar btn. */
	@Wire
	private Button guardarBtn;
	
	/** The id estatus objeto. */
	@Wire
	private Textbox idEstatusObjeto;
	
	/** The id flujo. */
	@Wire
	private Textbox idFlujo;
	
	/** The id producto. */
	@Wire
	private Textbox idProducto;
	
	/** The lbl estatus. */
	@Wire
	private Label lblEstatus;
	
	/** The lbl fecha mod. */
	@Wire
	private Label lblFechaMod;
	
	/** The lbl identificador flujo. */
	@Wire
	private Label lblIdentificadorFlujo;
	
	/** The lbl identificador producto. */
	@Wire
	private Label lblIdentificadorProducto;
	
	/** The lbl nombre producto. */
	@Wire
	private Label lblNombreProducto;
	
	/** The limpiar btn. */
	@Wire
	private Button limpiarBtn;

	/** The nombre producto. */
	@Wire
	private Textbox nombreProducto;
	
	/** The producto dto. */
	private ProductoDTO productoDTO;
	
	/** The productos grid. */
	@Wire
	private Grid productosGrid;
	
	/** The producto vo. */
	private ProductoVO productoVO;
	
	/** The producto v os. */
	private List<ProductoVO> productoVOs;
	
	/** The reporte csv btn. */
	@Wire
	private Image reporteCsvBtn;
	
	/** The reporte excel btn. */
	@Wire
	private Image reporteExcelBtn;
	
	/**
	 * Instantiates a new productos controller.
	 */
	public ProductosController() {
		this.read();
		this.productoVOs = productoDTO.getProductoVOs();
	}
	
	/**
	 * After compose.
	 *
	 * @param view the view
	 */
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
        executePermissionSet = this.applyPermision();
        estatusObjeto.setValue(CommandConstants.NB_PRODUCTO_ACTIVO);
        idEstatusObjeto.setValue(String.valueOf(CommandConstants.ID_PRODUCTO_ACTIVO));
    }
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#applyPermision()
	 */
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
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#clean()
	 */
	@Override
	@Command
	@NotifyChange({"flagEstatus"})
	public void clean() {
		nombreProducto.clearErrorMessage();
		descripcionProducto.clearErrorMessage();
		estatusObjeto.clearErrorMessage();
		flujo.clearErrorMessage();
		
		fechaAlta.setValue(null);
		fechaModificacion.setValue(null);

		idProducto.setValue(null);
		idFlujo.setValue(null);
		idEstatusObjeto.setValue(null);
		nombreProducto.setValue(null);
		descripcionProducto.setValue(null);
		estatusObjeto.setValue(null);
		flujo.setValue(null);
		flagEstatus = true;
		
		estatusObjeto.setValue(CommandConstants.NB_PRODUCTO_ACTIVO);
        idEstatusObjeto.setValue(String.valueOf(CommandConstants.ID_PRODUCTO_ACTIVO));
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
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
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
	
	/**
	 * Gets the flujo v os.
	 *
	 * @return the flujoVOs
	 */
	public List<FlujoVO> getFlujoVOs() {
		return flujoVOs;
	}
	
	/**
	 * Gets the producto dto.
	 *
	 * @return the productoDTO
	 */
	public ProductoDTO getProductoDTO() {
		return productoDTO;
	}
	
	/**
	 * Gets the producto vo.
	 *
	 * @return the productoVO
	 */
	public ProductoVO getProductoVO() {
		return productoVO;
	}
	
	/**
	 * Gets the producto v os.
	 *
	 * @return the productoVOs
	 */
	public List<ProductoVO> getProductoVOs() {
		return productoVOs;
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
	 * Checks if is flag estatus.
	 *
	 * @return the flagEstatus
	 */
	public boolean isFlagEstatus() {
		return flagEstatus;
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
		headersReport.add("Identificador Producto");
		headersReport.add("Nombre del Producto");
		headersReport.add("Identificador del Flujo");
		headersReport.add("Fecha alta");
		headersReport.add("Fecha modificación");
		headersReport.add("Status");
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,nombrePantalla);
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,nombrePantalla);
		}
		controller.createReport(generaLista(), headersReport, type, "PRODUCTO");
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read()
	 */
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
		productoDTO = productoBO.readCommand(productoDTO);
		
		flagEstatus = true;
		
		return productoDTO;
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
	 * @param productoVO the producto vo
	 */
	@Command
	@NotifyChange({"flagEstatus"})
	public void readSelected(@BindingParam("idProducto") final ProductoVO productoVO){
		this.productoVO = productoVO;
		logger.debug("productoVO--"+this.productoVO.toString());
		idProducto.setValue(Integer.toString(this.productoVO.getIdProducto()));
		idFlujo.setValue(Integer.toString(this.productoVO.getIdFlujo()));
		nombreProducto.setValue(this.productoVO.getNombreProducto());
		descripcionProducto.setValue(this.productoVO.getDescripcionProducto());
		idEstatusObjeto.setValue(Integer.toString(this.productoVO.getIdEstatusObjeto()));
		flujo.setValue(this.productoVO.getNombreFlujo() +" - "+ this.productoVO.getDescripcionFlujo());
		estatusObjeto.setValue(this.productoVO.getNombreEstatusObjeto());
		fechaAlta.setValue(this.productoVO.getFechaAlta());
		fechaModificacion.setValue(this.productoVO.getFechaModificacion());
		flagEstatus = false;
	}

	/**
	 * Read with filters.
	 */
	@GlobalCommand
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
		productoDTO = productoBO.readCommand(productoDTO);
		
		productoVOs = productoDTO.getProductoVOs();
		controller.registrarEvento(productoVO, productoVO, CommandConstants.CONSULTAR, nombrePantalla);
		flagEstatus = false;
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#save()
	 */
	@Override
	@Command
	@NotifyChange({ "productoVOs","flagEstatus"})
	public void save() {
		final ReportesController controller = new ReportesController();
		final ProductoBO productoBO = new ProductoBO();
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
			Messagebox.show(
					"¿Está seguro que desea continuar con la operación?",
					"Pregunta", org.zkoss.zul.Messagebox.YES | org.zkoss.zul.Messagebox.NO,
			org.zkoss.zul.Messagebox.QUESTION, new EventListener<Event>() {
				@Override
				public void onEvent(Event event) throws Exception {
					if (event.getName().equals(org.zkoss.zul.Messagebox.ON_YES)) {
						if(idProducto.getValue().isEmpty() || idProducto.getValue().equals("0")){
							System.out.println("********************** "+nombreProducto.getValue());
							if(validaProductoRegistrado(nombreProducto.getValue().toUpperCase().trim(),0)) {
								ProductoDTO productoDTO = new ProductoDTO();
								ProductoVO productoVOL = new ProductoVO();
								productoVOL.setNombreProducto(nombreProducto.getValue().toUpperCase().trim());
								productoVOL.setDescripcionProducto(descripcionProducto.getValue().toUpperCase().trim());
								productoVOL.setIdEstatusObjeto(CommandConstants.ESTATUS_PRODUCTO_ACTIVO);
								productoVOL.setIdFlujo(Integer.parseInt(idFlujo.getValue()));
								productoDTO.setProductoVO(productoVOL);
								productoDTO = productoBO.createCommand(productoDTO);
								productoDTO.toString(BbvaAbstractDataTransferObject.XML);
								productoVO = new ProductoVO();
								ProductoVO productoNuevo = new ProductoVO();
								productoNuevo.setNombreProducto("");
								productoNuevo.setDescripcionProducto("");
								productoNuevo.setIdEstatusObjeto(CommandConstants.ESTATUS_PRODUCTO_ACTIVO);
								productoNuevo.setIdFlujo(0);
								if(productoDTO.getErrorCode().equals("SQL-001")){
							    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
							    					"\nError:"+productoDTO.getErrorCode()
							    					,"Error de Sistema",Messagebox.OK,Messagebox.ERROR);
							    	controller.registrarEvento(productoVOL, productoNuevo, CommandConstants.ERROR_SISTEMA, nombrePantalla);
							    }else{									
									controller.registrarEvento(productoVOL, productoNuevo, CommandConstants.ALTA, nombrePantalla);
									clean();
									productoVO.setIdFlujo(Integer.parseInt(idFlujo.getValue().isEmpty()?"0":idFlujo.getValue()));
									productoVO.setNombreProducto(StringUtil.validaLike(nombreProducto.getValue()));
									productoVO.setDescripcionProducto(StringUtil.validaLike(descripcionProducto.getValue()));
									productoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
									productoVO.toString();
									productoDTO.setProductoVO(productoVO);
									productoDTO = productoBO.readCommand(productoDTO);
									
									productoVOs = productoDTO.getProductoVOs();
									org.zkoss.zul.Messagebox.show("!El Registro del Producto fue exitoso!",
											"Información", org.zkoss.zul.Messagebox.OK,
											org.zkoss.zul.Messagebox.INFORMATION);
							    }
							} else {
								ProductoVO productoVO = new ProductoVO();
								productoVO.setNombreProducto(nombreProducto.getValue().toUpperCase().trim());
								productoVO.setDescripcionProducto(descripcionProducto.getValue().toUpperCase().trim());
								productoVO.setIdEstatusObjeto(CommandConstants.ESTATUS_PRODUCTO_ACTIVO);
								productoVO.setIdFlujo(Integer.parseInt(idFlujo.getValue()));
								
								ProductoVO productoNuevo = new ProductoVO();
								productoNuevo.setNombreProducto("");
								productoNuevo.setDescripcionProducto("");
								productoNuevo.setIdEstatusObjeto(CommandConstants.ESTATUS_PRODUCTO_ACTIVO);
								productoNuevo.setIdFlujo(0);
			
								logger.debug(productoVO.getNombreProducto() + " " +  productoNuevo.getNombreProducto());
								logger.debug(productoVO.getDescripcionProducto() + " " +  productoNuevo.getDescripcionProducto());	
								logger.debug(productoVO.getIdEstatusObjeto() + " " +  productoNuevo.getIdEstatusObjeto());
								logger.debug(productoVO.getIdFlujo() + " " +  productoNuevo.getIdFlujo());	
								controller.registrarEvento(productoVO, productoNuevo, CommandConstants.ALTA_FALLIDA, nombrePantalla);
			
								org.zkoss.zul.Messagebox.show("!Ya existe Un Producto registrado con ese Nombre!",
										"Información", org.zkoss.zul.Messagebox.OK,
										org.zkoss.zul.Messagebox.EXCLAMATION);
								clean();
							}
						} else {
							ContratacionBO contratacionBO = new ContratacionBO();
							ContratacionVO contratacionVO = new ContratacionVO();
							contratacionVO.setIdProducto(Integer.parseInt(idProducto.getValue()));
							if(validaProductoRegistrado(nombreProducto.getValue().toUpperCase().trim(),Integer.parseInt(idProducto.getValue()))) {
								if(Integer.parseInt(idEstatusObjeto.getValue()) == CommandConstants.ESTATUS_OBJETO_PRODUCTO_ACTIVO || 
										contratacionBO.readCommandValidaContratacion(contratacionVO)){
									ProductoDTO productoDTO = new ProductoDTO();
									ProductoVO productoVOL = new ProductoVO();
									productoVOL.setNombreProducto(nombreProducto.getValue().toUpperCase().trim());
									productoVOL.setDescripcionProducto(descripcionProducto.getValue().toUpperCase().trim());
									productoVOL.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
									productoVOL.setIdFlujo(Integer.parseInt(idFlujo.getValue()));
									productoVOL.setIdProducto(Integer.parseInt(idProducto.getValue()));
									productoDTO.setProductoVO(productoVOL);
									productoDTO = productoBO.updateCommand(productoDTO);
									if(productoDTO.getErrorCode().equals("SQL-001")){
								    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
								    					"\nError:"+productoDTO.getErrorCode()
								    					,"Error de Sistema",Messagebox.OK,Messagebox.ERROR);
								    	controller.registrarEvento(productoVOL, productoVO, CommandConstants.BAJA, nombrePantalla);
								    }else{
										productoDTO.toString(BbvaAbstractDataTransferObject.XML);
										logger.debug("Estatus--"+estatusObjeto.getSelectedItem().getValue().toString());
										logger.debug(productoVOL.getNombreProducto() + " " +  productoVO.getNombreProducto());
										logger.debug(productoVOL.getDescripcionProducto() + " " +  productoVO.getDescripcionProducto());
										logger.debug(productoVOL.getIdEstatusObjeto() + " " +  productoVO.getIdEstatusObjeto());
										logger.debug(productoVOL.getIdFlujo() + " " +  productoVO.getIdFlujo());
										if (Integer.parseInt(estatusObjeto.getSelectedItem().getValue().toString())==CommandConstants.ID_PRODUCTO_BAJA) {
											controller.registrarEvento(productoVOL, productoVO, CommandConstants.BAJA, nombrePantalla);					
										} else if (Integer.parseInt(estatusObjeto.getSelectedItem().getValue().toString())==CommandConstants.ID_PRODUCTO_INACTIVO) { 
											controller.registrarEvento(productoVOL, productoVO, CommandConstants.INACTIVACION, nombrePantalla);				
										} else {
											logger.debug("local: "+productoVOL);
											logger.debug("leido: "+productoVO);
											controller.registrarEvento(productoVOL, productoVO, CommandConstants.MODIFICACION, nombrePantalla);
										}						
				
										
										clean();
										productoVO.setIdFlujo(Integer.parseInt(idFlujo.getValue().isEmpty()?"0":idFlujo.getValue()));
										productoVO.setNombreProducto(StringUtil.validaLike(nombreProducto.getValue()));
										productoVO.setDescripcionProducto(StringUtil.validaLike(descripcionProducto.getValue()));
										productoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
										productoVO.toString();
										productoDTO.setProductoVO(productoVO);
										productoDTO = productoBO.readCommand(productoDTO);
										
										productoVOs = productoDTO.getProductoVOs();
										org.zkoss.zul.Messagebox.show("!La Actualización del Producto fue exitoso!",
												"Información", org.zkoss.zul.Messagebox.OK,
												org.zkoss.zul.Messagebox.INFORMATION);
								    }
								}				
								else {
									ProductoVO productoVOL = new ProductoVO();
									productoVOL.setNombreProducto(nombreProducto.getValue().toUpperCase().trim());
									productoVOL.setDescripcionProducto(descripcionProducto.getValue().toUpperCase().trim());
									productoVOL.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
									productoVOL.setIdFlujo(Integer.parseInt(idFlujo.getValue()));
									productoVOL.setIdProducto(Integer.parseInt(idProducto.getValue()));						
									logger.debug("Estatus--"+estatusObjeto.getSelectedItem().getValue().toString());
									logger.debug(productoVOL.getNombreProducto() + " " +  productoVOL.getNombreProducto());
									logger.debug(productoVOL.getDescripcionProducto() + " " +  productoVOL.getDescripcionProducto());
									logger.debug(productoVOL.getIdEstatusObjeto() + " " +  productoVOL.getIdEstatusObjeto());
									logger.debug(productoVOL.getIdFlujo() + " " +  productoVOL.getIdFlujo());
									if (Integer.parseInt(estatusObjeto.getSelectedItem().getValue().toString())==CommandConstants.ID_PRODUCTO_BAJA) {
										controller.registrarEvento(productoVOL, productoVO, CommandConstants.BAJA_FALLIDA, nombrePantalla);					
									} else if (Integer.parseInt(estatusObjeto.getSelectedItem().getValue().toString())==CommandConstants.ID_PRODUCTO_INACTIVO) { 
										controller.registrarEvento(productoVOL, productoVO, CommandConstants.INACTIVACION_FALLIDA, nombrePantalla);				
									} else {
										controller.registrarEvento(productoVOL, productoVO, CommandConstants.MODIFICACION_FALLIDA, nombrePantalla);
									}							
									org.zkoss.zul.Messagebox.show("!El Producto no puede darse de Baja, porque esta siendo usado por la Contratación!",
											"Información", org.zkoss.zul.Messagebox.OK,
											org.zkoss.zul.Messagebox.EXCLAMATION);
									clean();
								}
							}else{
								ProductoVO productoVOL = new ProductoVO();
								productoVOL.setNombreProducto(nombreProducto.getValue().toUpperCase().trim());
								productoVOL.setDescripcionProducto(descripcionProducto.getValue().toUpperCase().trim());
								productoVOL.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
								productoVOL.setIdFlujo(Integer.parseInt(idFlujo.getValue()));
								productoVOL.setIdProducto(Integer.parseInt(idProducto.getValue()));					
								logger.debug("Estatus--"+estatusObjeto.getSelectedItem().getValue().toString());
								logger.debug(productoVOL.getNombreProducto() + " " +  productoVO.getNombreProducto());
								logger.debug(productoVOL.getDescripcionProducto() + " " +  productoVO.getDescripcionProducto());
								logger.debug(productoVOL.getIdEstatusObjeto() + " " +  productoVO.getIdEstatusObjeto());
								logger.debug(productoVOL.getIdFlujo() + " " +  productoVO.getIdFlujo());
								controller.registrarEvento(productoVOL, productoVO, CommandConstants.MODIFICACION_FALLIDA, nombrePantalla);
								org.zkoss.zul.Messagebox.show("!Ya existe Un Producto registrado con ese Nombre!",
										"Información", org.zkoss.zul.Messagebox.OK,
										org.zkoss.zul.Messagebox.EXCLAMATION);
								clean();
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
		flagEstatus = true;
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
	 * Sets the flag estatus.
	 *
	 * @param flagEstatus the flagEstatus to set
	 */
	public void setFlagEstatus(boolean flagEstatus) {
		this.flagEstatus = flagEstatus;
	}
	
	/**
	 * Sets the flujo v os.
	 *
	 * @param flujoVOs the flujoVOs to set
	 */
	public void setFlujoVOs(List<FlujoVO> flujoVOs) {
		this.flujoVOs = flujoVOs;
	}

	/**
	 * Sets the producto dto.
	 *
	 * @param productoDTO the productoDTO to set
	 */
	public void setProductoDTO(ProductoDTO productoDTO) {
		this.productoDTO = productoDTO;
	}

	/**
	 * Sets the producto vo.
	 *
	 * @param productoVO the productoVO to set
	 */
	public void setProductoVO(ProductoVO productoVO) {
		this.productoVO = productoVO;
	}

	/**
	 * Sets the producto v os.
	 *
	 * @param productoVOs the productoVOs to set
	 */
	public void setProductoVOs(List<ProductoVO> productoVOs) {
		this.productoVOs = productoVOs;
	}

	/**
	 * Valida producto registrado.
	 *
	 * @param nombreProducto the nombre producto
	 * @param idProducto the id producto
	 * @return true, if successful
	 */
	private boolean validaProductoRegistrado(String nombreProducto, int idProducto) {
		ProductoVO productoVO = new ProductoVO();
		ProductoDTO productoDTO = new ProductoDTO();
		productoVO.setNombreProducto(nombreProducto);
		productoVO.setIdProducto(idProducto);
//		System.out.println("********************* " + nombreProducto  );
		ProductoBO productoBO = new ProductoBO();		
		productoDTO = productoBO.readCommandCmb(productoVO);
		
//		System.out.println("*************************** "+productoDTO.getProductoVOs().size()+" ***************************");
		if (productoDTO.getProductoVOs().size() == 0)
			return true;
		else 
			return false;
	}
	
}
