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
 * Nombre de aplicaci�n: MAPEADOR
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
 * Nombre de clase: AdmonFlujosController.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.admonFlujos
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.admonFlujos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.FlujoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ProductoVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.flujo.dto.FlujoDTO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.FlujoBO;
import mx.com.bbva.bancomer.mapper.business.ProductoBO;
import mx.com.bbva.bancomer.producto.dto.ProductoDTO;
import mx.com.bbva.bancomer.utils.StringUtil;
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
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmonFlujosController.
 *
 * @author Julio Morales
 */
public class AdmonFlujosController extends ControllerSupport implements IController {

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(AdmonFlujosController.class);
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 671034870906549704L;
	
	/** The consultar btn. */
	@Wire
	private Button consultarBtn;
	
	/** The descripcion flujo. */
	@Wire
	private Textbox descripcionFlujo;
	
	/** The execute permission set. */
	private boolean executePermissionSet;
	
	/** The fecha alta. */
	@Wire
	private Datebox fechaAlta;
	
	/** The fecha modificacion. */
	@Wire
	private Datebox fechaModificacion;
	
	/** The flag btn guardar. */
	private boolean flagBtnGuardar;
	
	/** The flujo dto. */
	private FlujoDTO flujoDTO;
	
	/** The flujos grid. */
	@Wire
	private Grid flujosGrid;
	
	/** The flujo vo. */
	private FlujoVO flujoVO;
	
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
	
	/** The lbl descripcion flujo. */
	@Wire
	private Label lblDescripcionFlujo;
	
	/** The lbl estatus. */
	@Wire
	private Label lblEstatus;
	
	/** The lbl fecha alta. */
	@Wire
	private Label lblFechaAlta;
	
	/** The lbl fecha modificacion. */
	@Wire
	private Label lblFechaModificacion;
	
	/** The lbl nombre flujo. */
	@Wire
	private Label lblNombreFlujo;
	
	/** The limpiar btn. */
	@Wire
	private Button limpiarBtn;
	
	/** The nombre flujo. */
	@Wire
	private Textbox nombreFlujo;
	
	/** The open image window. */
	@Wire
    Window openImageWindow;
	
	/** The reporte csv btn. */
	@Wire
	private Image reporteCsvBtn;
	
	/** The reporte excel btn. */
	@Wire
	private Image reporteExcelBtn;
	
	/** The status objeto. */
	@Wire
	private Combobox statusObjeto;

	/**
	 * Instantiates a new admon flujos controller.
	 */
	public AdmonFlujosController() {
		this.read();
		this.flujoVOs = flujoDTO.getFlujoVOs();
		flagBtnGuardar = true;
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
    }
	
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#applyPermision()
	 */
	@Override
	public boolean applyPermision() {
		boolean isApplied = false;
		HashMap<String, Component> componentes = new HashMap<String, Component>();
		componentes.put(lblNombreFlujo.getId(), lblNombreFlujo);
		componentes.put(lblDescripcionFlujo.getId(), lblDescripcionFlujo);
		componentes.put(lblFechaAlta.getId(), lblFechaAlta);
		componentes.put(lblFechaModificacion.getId(), lblFechaModificacion);
		componentes.put(lblEstatus.getId(), lblEstatus);
		componentes.put(nombreFlujo.getId(), nombreFlujo);
		componentes.put(descripcionFlujo.getId(), descripcionFlujo);
		componentes.put(statusObjeto.getId(), statusObjeto);
		componentes.put(fechaAlta.getId(), fechaAlta);
		componentes.put(fechaModificacion.getId(), fechaModificacion);
		componentes.put(reporteExcelBtn.getId(), reporteExcelBtn);
		componentes.put(reporteCsvBtn.getId(), reporteCsvBtn);
		componentes.put(limpiarBtn.getId(), limpiarBtn);
		componentes.put(guardarBtn.getId(), guardarBtn);
		componentes.put(consultarBtn.getId(), consultarBtn);
		componentes.put(flujosGrid.getId(), flujosGrid);
		super.applyPermission(MapeadorConstants.FLUJOS, componentes);
		return isApplied;
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#clean()
	 */
	@Override
	@Command
	@NotifyChange({"flagBtnGuardar"})
	public void clean() {
		nombreFlujo.clearErrorMessage();
		descripcionFlujo.clearErrorMessage();
		statusObjeto.clearErrorMessage();
		
		nombreFlujo.setValue(null);
		descripcionFlujo.setValue(null);
		statusObjeto.setValue(null);
		
		idFlujo.setValue(null);
		idEstatusObjeto.setValue(null);
		setFlagBtnGuardar(true);
		fechaAlta.setValue(new Date());
		fechaModificacion.setValue(new Date());
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
		
		for(FlujoVO flujoVO: flujoVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(flujoVO.getNombreFlujo());
			beanGenerico.setValor2(flujoVO.getDescripcionFlujo());
			beanGenerico.setValor3(dateFormat.format(flujoVO.getFechaAlta()));
			beanGenerico.setValor4(dateFormat.format(flujoVO.getFechaModificacion()));
			beanGenerico.setValor5(flujoVO.getDescripcionEtapa());
			beanGenerico.setValor6(flujoVO.getNombreEstatusObjeto());
			beanGenerico.setValor7(flujoVO.getDescripcionUrlImagen());
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}
	
	/**
	 * Gets the flujo dto.
	 *
	 * @return the flujoDTO
	 */
	public FlujoDTO getFlujoDTO() {
		return flujoDTO;
	}
	
	/**
	 * Gets the flujo vo.
	 *
	 * @return the flujoVO
	 */
	public FlujoVO getFlujoVO() {
		return flujoVO;
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
	 * Checks if is execute permission set.
	 *
	 * @return the executePermissionSet
	 */
	public final boolean isExecutePermissionSet() {
		return executePermissionSet;
	}
	
	/**
	 * Checks if is flag btn guardar.
	 *
	 * @return the flagBtnGuardar
	 */
	public boolean isFlagBtnGuardar() {
		return flagBtnGuardar;
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
		headersReport.add("Identificador de Flujo");
		headersReport.add("Descripci�n flujo");
		headersReport.add("Fecha alta");
		headersReport.add("Fecha modificaci�n");
		headersReport.add("Etapas del flujo");
		headersReport.add("Status");
		headersReport.add("Diagrama");
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Cat�logo Flujos");
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Cat�logo Flujos");
		}
		controller.createReport(generaLista(), headersReport, type, "FLUJOS");
	}	
	
	/**
	 * Open image.
	 *
	 * @param flujoVO the flujo vo
	 */
	@Command
	public void openImage(@BindingParam("descripcionUrlImagen") final FlujoVO flujoVO) {
		Map<String, Object> mapDatos = new HashMap<String, Object>();
		mapDatos.put("descripcionUrlImagen", flujoVO.getDescripcionUrlImagen());
		System.out.println("**************" + flujoVO.getDescripcionUrlImagen());
		Window window = (Window) Executions.createComponents(
				"/WEB-INF/flows/admonFlujos/openImage.zul",this.getSelf(), mapDatos);
		window.doModal();
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read()
	 */
	@Override
	public Object read() {
		flujoDTO = new FlujoDTO();
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
		estatusObjetoVO.setNombreTabla(CommandConstants.NOMBRE_TABLA_FLUJOS);		
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);		
	    flujoDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
	    FlujoVO flujoVO = new FlujoVO();
	    flujoDTO.setFlujoVO(flujoVO);
		FlujoBO FlujoBO = new FlujoBO();
		FlujoBO.readCommand(flujoDTO);
		return flujoDTO;
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
	 * @param flujoVO the flujo vo
	 */
	@Command
	@NotifyChange({"flagBtnGuardar"})
	public void readSelected(@BindingParam("idFlujo") final FlujoVO flujoVO){
		this.flujoVO = flujoVO;
		flujoVO.toString();
		nombreFlujo.setValue(flujoVO.getNombreFlujo());
		descripcionFlujo.setValue(flujoVO.getDescripcionFlujo());
		statusObjeto.setValue(flujoVO.getNombreEstatusObjeto());
		idFlujo.setValue(Integer.toString(flujoVO.getIdFlujo()));
		idEstatusObjeto.setValue(Integer.toString(flujoVO.getIdEstatusObjeto()));
		fechaAlta.setValue(flujoVO.getFechaAlta());
		fechaModificacion.setValue(flujoVO.getFechaModificacion());
		setFlagBtnGuardar(false);
	}

	/**
	 * Read with filters.
	 */
	@Command
	@NotifyChange({ "flujoVOs" })
	public void readWithFilters() {
		ReportesController controller = new ReportesController();
		FlujoDTO flujoDTO = new FlujoDTO();
		FlujoVO flujoVO = new FlujoVO();
		flujoVO.setNombreFlujo(StringUtil.validaLike(nombreFlujo.getValue()));
		flujoVO.setDescripcionFlujo(StringUtil.validaLike(descripcionFlujo.getValue()));
		flujoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
		flujoVO.toString();
		flujoDTO.setFlujoVO(flujoVO);
		FlujoBO FlujoBO = new FlujoBO();
		flujoVOs = FlujoBO.readCommand(flujoDTO).getFlujoVOs();
		controller.registrarEvento(null, null, CommandConstants.CONSULTAR, "Cat�logo Flujos");
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#save()
	 */
	@Override
	@Command
	@NotifyChange({ "flujoVOs","flagBtnGuardar" })
	public void save() {
		ReportesController controller = new ReportesController();
		FlujoBO flujoBO = new FlujoBO();
		boolean errorGuardar = false;
		if (nombreFlujo.getValue().isEmpty()) {
			nombreFlujo
					.setErrorMessage("Favor de introducir el nombre del Flujo");
			errorGuardar = true;
		}
		if (descripcionFlujo.getValue().isEmpty()) {
			descripcionFlujo
					.setErrorMessage("Favor de introducir la descripci�n del Flujo");
			errorGuardar = true;
		}
		if(!errorGuardar && !idFlujo.getValue().isEmpty()){
			ProductoDTO productoDTO = null;
			logger.debug("statusObjeto:"+statusObjeto.getSelectedItem().getValue());
			if(Integer.parseInt(statusObjeto.getSelectedItem().getValue().toString())==CommandConstants.ID_FLUJO_BAJA
					||Integer.parseInt(statusObjeto.getSelectedItem().getValue().toString())==CommandConstants.ID_FLUJO_INACTIVO){
				ProductoBO productoBO = new ProductoBO();
				ProductoVO productoVO = new ProductoVO();
				productoVO.setIdFlujo(Integer.parseInt(idFlujo.getValue()));
				productoDTO = productoBO.readCommandCmb(productoVO);
			}
			logger.debug("productoDTO:"+productoDTO);
			if (productoDTO==null || productoDTO.getProductoVOs().size() == 0){
				FlujoDTO flujoDTO = new FlujoDTO();
				FlujoVO flujoVO = new FlujoVO();
				flujoVO.setNombreFlujo(nombreFlujo.getValue().toUpperCase().trim());
				flujoVO.setDescripcionFlujo(descripcionFlujo.getValue().toUpperCase().trim());
				flujoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
				flujoVO.setIdFlujo(Integer.parseInt(idFlujo.getValue()));
				flujoDTO.setFlujoVO(flujoVO);
				flujoBO.updateCommand(flujoDTO);
				flujoDTO.toString(BbvaAbstractDataTransferObject.XML);
				controller.registrarEvento(flujoVO, this.flujoVO, CommandConstants.MODIFICACION, "Cat�logo Flujos");
				clean();
				flujoVO.setNombreFlujo(StringUtil.validaLike(nombreFlujo.getValue()));
				flujoVO.setDescripcionFlujo(StringUtil.validaLike(descripcionFlujo.getValue()));
				flujoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":statusObjeto.getSelectedItem().getValue().toString()));
				flujoVO.toString();
				flujoDTO.setFlujoVO(flujoVO);
				flujoVOs = flujoBO.readCommand(flujoDTO).getFlujoVOs();
				org.zkoss.zul.Messagebox.show("!La Actualizaci�n del Flujo fue exitoso!",
						"Informaci�n", org.zkoss.zul.Messagebox.OK,
						org.zkoss.zul.Messagebox.INFORMATION);
			} else {
//				FlujoVO flujoVO = new FlujoVO();
				clean();
//				flujoVO.setNombreFlujo(StringUtil.validaLike(nombreFlujo.getValue()));
//				flujoVO.setDescripcionFlujo(StringUtil.validaLike(descripcionFlujo.getValue()));
//				flujoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
//				flujoVO.toString();
//				flujoDTO.setFlujoVO(flujoVO);
//				flujoVOs = flujoBO.readCommand(flujoDTO).getFlujoVOs();
				  org.zkoss.zul.Messagebox.show("!No se puede dar de Baja, ya que esta siendo usado por alg�n Producto!",
							"Informaci�n", org.zkoss.zul.Messagebox.OK,
							org.zkoss.zul.Messagebox.EXCLAMATION);
			}
		}
	}

	/**
	 * Sets the execute permission set.
	 *
	 * @param executePermissionSet the executePermissionSet to set
	 */
	public final void setExecutePermissionSet(boolean executePermissionSet) {
		this.executePermissionSet = executePermissionSet;
	}

	/**
	 * Sets the flag btn guardar.
	 *
	 * @param flagBtnGuardar the flagBtnGuardar to set
	 */
	public void setFlagBtnGuardar(boolean flagBtnGuardar) {
		this.flagBtnGuardar = flagBtnGuardar;
	}

	/**
	 * Sets the flujo dto.
	 *
	 * @param flujoDTO the flujoDTO to set
	 */
	public void setFlujoDTO(FlujoDTO flujoDTO) {
		this.flujoDTO = flujoDTO;
	}
	
	/**
	 * Sets the flujo vo.
	 *
	 * @param flujoVO the flujoVO to set
	 */
	public void setFlujoVO(FlujoVO flujoVO) {
		this.flujoVO = flujoVO;
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
	 * Show modal.
	 *
	 * @param e the e
	 */
	@Listen("onClick = #closeBtn")
    public void showModal(Event e) {
		openImageWindow.detach();
    }	

}
