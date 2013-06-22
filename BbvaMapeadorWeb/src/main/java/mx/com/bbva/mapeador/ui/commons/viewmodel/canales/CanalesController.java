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
 * Nombre de clase: CanalesController.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.canales
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.canales;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.CanalVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ContratacionVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.canal.dto.CanalDTO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.CanalBO;
import mx.com.bbva.bancomer.mapper.business.ContratacionBO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.utils.StringUtil;
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
 * The Class CanalesController.
 *
 * @author Julio Morales
 */
public class CanalesController extends ControllerSupport implements IController {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The nombre Pantalla */
	private static final String nombrePantalla="Catálogo Canales";
	
	/** The btn guardar. */
	private boolean btnGuardar;
	
	/** The canal dto. */
	private CanalDTO canalDTO;
	
	/** The canales grid. */
	@Wire
	private Grid canalesGrid;
	
	/** The canales vo. */
	private CanalVO canalesVO;
	
	/** The canales v os. */
	private List<CanalVO> canalesVOs;
	
	/** The consultar btn. */
	@Wire
	private Button consultarBtn;
	
	/** The descripcion canal. */
	@Wire
	private Textbox descripcionCanal;
	
	/** The execute permission set. */
	private boolean executePermissionSet;
	
	/** The fecha fin. */
	@Wire
	private Datebox fechaFin;
	
	/** The fecha inicio. */
	@Wire
	private Datebox fechaInicio;
	
	/** The flag clave. */
	private boolean flagClave;
	
	/** The guardar btn. */
	@Wire
	private Button guardarBtn;
	
	/** The id canal. */
	@Wire
	private Textbox idCanal;
	
	/** The id estatus objeto. */
	@Wire
	private Textbox idEstatusObjeto;
	
	/** The lbl clave. */
	@Wire
	private Label lblClave;
	
	/** The lbl descripcion canal. */
	@Wire
	private Label lblDescripcionCanal;
	
	/** The lbl estatus. */
	@Wire
	private Label lblEstatus;
	
	/** The lbl fecha hora alta. */
	@Wire
	private Label lblFechaHoraAlta;
	
	/** The limpiar btn. */
	@Wire
	private Button limpiarBtn;
	
	/** The nombre canal. */
	@Wire
	private Textbox nombreCanal;
	
	/** The reporte csv btn. */
	@Wire
	private Image reporteCsvBtn;
	
	/** The reporte excel btn. */
	@Wire
	private Image reporteExcelBtn;
	
	/** The status objeto. */
	@Wire
	private Combobox statusObjeto;
	
	/** The str id canal. */
	private String strIdCanal;
	
	/**
	 * Constructor de CanalesController.
	 */
	public CanalesController() {
		this.read();
		this.canalesVOs = canalDTO.getCanalVOs();
		btnGuardar = true;
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
		componentes.put(lblClave.getId(), lblClave);
		componentes.put(lblFechaHoraAlta.getId(), lblFechaHoraAlta);
		componentes.put(lblDescripcionCanal.getId(), lblDescripcionCanal);
		componentes.put(lblEstatus.getId(), lblEstatus);
		componentes.put(nombreCanal.getId(), nombreCanal);
		componentes.put(descripcionCanal.getId(), descripcionCanal);
		componentes.put(fechaInicio.getId(), fechaInicio);
		componentes.put(fechaFin.getId(), fechaFin);
		componentes.put(statusObjeto.getId(), statusObjeto);
		componentes.put(reporteExcelBtn.getId(), reporteExcelBtn);
		componentes.put(reporteCsvBtn.getId(), reporteCsvBtn);
		componentes.put(limpiarBtn.getId(), limpiarBtn);
		componentes.put(guardarBtn.getId(), guardarBtn);
		componentes.put(consultarBtn.getId(), consultarBtn);
		componentes.put(canalesGrid.getId(), canalesGrid);
		super.applyPermission(MapeadorConstants.CANALES, componentes);
		return isApplied;
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#clean()
	 */
	@Override
	@Command
	@NotifyChange({"btnGuardar", "flagClave" })
	public void clean() {
		nombreCanal.clearErrorMessage();
		descripcionCanal.clearErrorMessage();
		statusObjeto.clearErrorMessage();
		
		fechaFin.setValue(null);
		fechaInicio.setValue(null);
		
		nombreCanal.setValue(null);
		descripcionCanal.setValue(null);
		statusObjeto.setValue(null);
		
		idCanal.setValue(null);
		idEstatusObjeto.setValue(null);
		btnGuardar = true;
		flagClave = false;
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
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		BeanGenerico beanGenerico = null;
		for(CanalVO canalVO: canalesVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(canalVO.getNombreCanal());
			beanGenerico.setValor2(canalVO.getDescripcionCanal());
			beanGenerico.setValor3(dateFormat.format(canalVO.getFechaAlta()));
			beanGenerico.setValor4(canalVO.getNombreEstatusObjeto());
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}
	
	/**
	 * Gets the canal dto.
	 *
	 * @return the canalDTO
	 */
	public CanalDTO getCanalDTO() {
		return canalDTO;
	}

	/**
	 * Gets the canales vo.
	 *
	 * @return the canalesVO
	 */
	public CanalVO getCanalesVO() {
		return canalesVO;
	}

	/**
	 * Gets the canales v os.
	 *
	 * @return the canalesVOs
	 */
	public List<CanalVO> getCanalesVOs() {
		return canalesVOs;
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
	 * Checks if is flag clave.
	 *
	 * @return the flagClave
	 */
	public boolean isFlagClave() {
		return flagClave;
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
		headersReport.add("Clave");
		headersReport.add("Descripción canal");
		headersReport.add("Fecha y Hora de alta");
		headersReport.add("Status");
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,nombrePantalla);
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,nombrePantalla);
		}
		controller.createReport(generaLista(), headersReport, type, "CANALES");
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read()
	 */
	@Override
	public Object read() {
		canalDTO = new CanalDTO();
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
	    estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
	    EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
	    estatusObjetoVO.setNombreTabla(CommandConstants.NOMBRE_TABLA_CANALES);
	    estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
	    estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
	    if(estatusObjetoDTO.getErrorCode().equals("SQL-001")){
	    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el adminsitrador del sistema:\n"+
	    					"\nError:"+estatusObjetoDTO.getErrorCode()+
	    					"\nDescripción:"+estatusObjetoDTO.getErrorDescription(),"Error de Sistema",Messagebox.OK,Messagebox.ERROR);
	    }
	    canalDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
	    CanalVO canalVO = new CanalVO();
	    canalDTO.setCanalVO(canalVO);
		CanalBO canalBO = new CanalBO();
		canalDTO = canalBO.readCommand(canalDTO);
		if(canalDTO.getErrorCode().equals("SQL-001")){
	    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el adminsitrador del sistema:\n"+
	    					"\nError:"+canalDTO.getErrorCode()+
	    					"\nDescripción:"+canalDTO.getErrorDescription(),"Error de Sistema",Messagebox.OK,Messagebox.ERROR);
	    }
		return canalDTO;
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
	 * @param canalVO the canal vo
	 */
	@Command
	@NotifyChange({"btnGuardar","flagClave"})
	public void readSelected(@BindingParam("idCanal") final CanalVO canalVO){
		canalesVO = canalVO;
		canalVO.toString();
		nombreCanal.setValue(canalVO.getNombreCanal());
		descripcionCanal.setValue(canalVO.getDescripcionCanal());
		statusObjeto.setValue(canalVO.getNombreEstatusObjeto());
		idCanal.setValue(Integer.toString(canalVO.getIdCanal()));
		idEstatusObjeto.setValue(Integer.toString(canalVO.getIdEstatusObjeto()));
		fechaInicio.setValue(canalVO.getFechaAlta());
		btnGuardar = false;
		flagClave = true;
	}
	
	/**
	 * Read with filters.
	 */
	@GlobalCommand
	@Command
	@NotifyChange({ "canalesVOs" })
	public void readWithFilters() {
		ReportesController controller = new ReportesController();
		CanalDTO canalDTO = new CanalDTO();
		CanalVO canalVO = new CanalVO();
		DateFormat dateFormatIni = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat dateFormatFin = new SimpleDateFormat("dd/MM/yyyy");
		boolean error = false;
		if(fechaInicio.getValue()!=null && fechaFin.getValue()!=null){
			if(fechaInicio.getValue().compareTo(fechaFin.getValue()) > 0 ){
				fechaInicio.setErrorMessage("La fecha de inicio no puede ser mayor a la fecha de fin");
				error = true;
			}else{
				canalVO.setFechaInicio(dateFormatIni.format(fechaInicio.getValue()));
				canalVO.setFechaFin(dateFormatFin.format(fechaFin.getValue()));
			}
		}
		if(!error){			
			canalVO.setNombreCanal(StringUtil.validaLike(nombreCanal.getValue()));
			canalVO.setDescripcionCanal(StringUtil.validaLike(descripcionCanal.getValue()));
			canalVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
			canalVO.toString();
			canalDTO.setCanalVO(canalVO);
			CanalBO canalBO = new CanalBO();
			canalDTO = canalBO.readCommand(canalDTO);
			if(canalDTO.getErrorCode().equals("SQL-001")){
		    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el adminsitrador del sistema:\n"+
		    					"\nError:"+canalDTO.getErrorCode()+
		    					"\nDescripción:"+canalDTO.getErrorDescription(),"Error de Sistema",Messagebox.OK,Messagebox.ERROR);
		    }
			canalesVOs = canalDTO.getCanalVOs();			
			controller.registrarEvento(canalVO, canalVO, CommandConstants.CONSULTAR, nombrePantalla);
		}		
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#save()
	 */
	@Override
	@Command
	@NotifyChange({ "canalesVOs", "btnGuardar", "flagClave" })
	public void save() {		
		boolean errorGuardar = false;
		if (statusObjeto.getSelectedItem() == null
				|| statusObjeto.getSelectedItem().getValue() == null
				|| statusObjeto.getSelectedItem().getValue().toString().isEmpty()) {
			statusObjeto.setErrorMessage("Favor de seleccionar el Estatus");
			errorGuardar = true;
		}
		if (nombreCanal.getValue().isEmpty()) {
			nombreCanal
					.setErrorMessage("Favor de introducir el nombre del Canal");
			errorGuardar = true;
		}
		if (descripcionCanal.getValue().isEmpty()) {
			descripcionCanal
					.setErrorMessage("Favor de introducir la descripción del Canal");
			errorGuardar = true;
		}
		if(!errorGuardar){
			if(idCanal.getValue().isEmpty()){
//				CanalDTO canalDTO = new CanalDTO();
//				CanalVO canalVO = new CanalVO();
//				canalVO.setNombreCanal(nombreCanal.getValue().toUpperCase());
//				canalVO.setDescripcionCanal(descripcionCanal.getValue().toUpperCase());
//				canalVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
//				canalDTO.setCanalVO(canalVO);
//				canalBO.createCommand(canalDTO);
//				canalDTO.toString(BbvaAbstractDataTransferObject.XML);
//				clean();
//				canalVO.setNombreCanal(StringUtil.validaLike(nombreCanal.getValue()));
//				canalVO.setDescripcionCanal(StringUtil.validaLike(descripcionCanal.getValue()));
//				canalVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
//				canalVO.toString();
//				canalDTO.setCanalVO(canalVO);
//				canalesVOs = canalBO.readCommand(canalDTO).getCanalVOs();
				
			} else {
				Messagebox.show(
				"¿Está seguro que desea continuar con la operación?",
				"Pregunta", org.zkoss.zul.Messagebox.YES | org.zkoss.zul.Messagebox.NO,
				org.zkoss.zul.Messagebox.QUESTION, new EventListener<Event>() {
					@Override
					public void onEvent(Event event) throws Exception {
						if (event.getName().equals(org.zkoss.zul.Messagebox.ON_YES)) {
							CanalBO canalBO = new CanalBO();
							ReportesController controller = new ReportesController();
							ContratacionBO contratacionBO = new ContratacionBO();
							ContratacionVO contratacionVO = new ContratacionVO();
							contratacionVO.setIdCanal(Integer.parseInt(idCanal.getValue()));
							if(Integer.parseInt(idEstatusObjeto.getValue()) == CommandConstants.ESTATUS_OBJETO_ACTIVO_CANAL || 
									contratacionBO.readCommandValidaContratacion(contratacionVO)) {
								CanalDTO canalDTO = new CanalDTO();
								CanalVO canalVO = new CanalVO();
								canalVO.setNombreCanal(nombreCanal.getValue().toUpperCase().trim());
								canalVO.setDescripcionCanal(descripcionCanal.getValue().toUpperCase().trim());
								canalVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
								canalVO.setIdCanal(Integer.parseInt(idCanal.getValue()));
								canalDTO.setCanalVO(canalVO);								
								canalDTO = canalBO.updateCommand(canalDTO);
								if(canalDTO.getErrorCode().equals("SQL-001")){
							    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el adminsitrador del sistema:\n"+
							    					"\nError:"+canalDTO.getErrorCode()+
							    					"\nDescripción:"+canalDTO.getErrorDescription(),"Error de Sistema",Messagebox.OK,Messagebox.ERROR);
								}else{
									canalDTO.toString(BbvaAbstractDataTransferObject.XML);
									if (Integer.parseInt(statusObjeto.getSelectedItem().getValue().toString())==CommandConstants.ID_CANAL_BAJA) {
										controller.registrarEvento(canalVO, canalesVO, CommandConstants.BAJA, nombrePantalla);					
									} else if (Integer.parseInt(statusObjeto.getSelectedItem().getValue().toString())==CommandConstants.ID_CANAL_INACTIVO) { 
										controller.registrarEvento(canalVO, canalesVO, CommandConstants.INACTIVACION, nombrePantalla);				
									} else {
										controller.registrarEvento(canalVO, canalesVO, CommandConstants.MODIFICACION, nombrePantalla);
									}
									clean();
									
				
									
									canalVO.setNombreCanal(StringUtil.validaLike(nombreCanal.getValue()));
									canalVO.setDescripcionCanal(StringUtil.validaLike(descripcionCanal.getValue()));
									canalVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
									canalVO.toString();
									canalDTO.setCanalVO(canalVO);
									canalDTO = canalBO.readCommand(canalDTO);
									if(canalDTO.getErrorCode().equals("SQL-001")){
								    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el adminsitrador del sistema:\n"+
								    					"\nError:"+canalDTO.getErrorCode()+
								    					"\nDescripción:"+canalDTO.getErrorDescription(),"Error de Sistema",Messagebox.OK,Messagebox.ERROR);
								    }
									canalesVOs = canalDTO.getCanalVOs();
									
									btnGuardar = true;
									org.zkoss.zul.Messagebox.show("!La Actualización del Canal fue exitoso!",
											"Información", org.zkoss.zul.Messagebox.OK,
											org.zkoss.zul.Messagebox.INFORMATION);
									 BindUtils
										.postGlobalCommand(
												null,
												null,
												"readWithFilters",
												null);
								}
							  } else {
									CanalVO canalVO = new CanalVO();
									canalVO.setNombreCanal(nombreCanal.getValue().toUpperCase().trim());
									canalVO.setDescripcionCanal(descripcionCanal.getValue().toUpperCase().trim());
									canalVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
									canalVO.setIdCanal(Integer.parseInt(idCanal.getValue()));					  
									if (Integer.parseInt(statusObjeto.getSelectedItem().getValue().toString())==CommandConstants.ID_CANAL_BAJA) {
										controller.registrarEvento(canalVO, canalesVO, CommandConstants.BAJA_FALLIDA, nombrePantalla);					
									} else if (Integer.parseInt(statusObjeto.getSelectedItem().getValue().toString())==CommandConstants.ID_CANAL_INACTIVO) { 
										controller.registrarEvento(canalVO, canalesVO, CommandConstants.INACTIVACION_FALLIDA, nombrePantalla);				
									} else {
										controller.registrarEvento(canalVO, canalesVO, CommandConstants.MODIFICACION_FALLIDA, nombrePantalla);
									}				  
								  clean();
								  canalDTO = new CanalDTO();
								  canalVO = new CanalVO();
								  canalVO.setNombreCanal(StringUtil.validaLike(nombreCanal.getValue()));
								  canalVO.setDescripcionCanal(StringUtil.validaLike(descripcionCanal.getValue()));
								  canalVO.setIdEstatusObjeto(0);
								  canalVO.toString();
								  canalDTO.setCanalVO(canalVO);
								  canalDTO = canalBO.readCommand(canalDTO);
								  if(canalDTO.getErrorCode().equals("SQL-001")){
								    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el adminsitrador del sistema:\n"+
								    					"\nError:"+canalDTO.getErrorCode()+
								    					"\nDescripción:"+canalDTO.getErrorDescription(),"Error de Sistema",Messagebox.OK,Messagebox.ERROR);
								  }
								  canalesVOs = canalDTO.getCanalVOs();
								  org.zkoss.zul.Messagebox.show("!No se puede dar de Baja, ya que esta siendo Usado por la Contratación!",
											"Información", org.zkoss.zul.Messagebox.OK,
											org.zkoss.zul.Messagebox.EXCLAMATION);								 
						  	}
						}
						flagClave = false;
					}
				});
			}
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
	 * Sets the canal dto.
	 *
	 * @param canalDTO the canalDTO to set
	 */
	public void setCanalDTO(CanalDTO canalDTO) {
		this.canalDTO = canalDTO;
	}

	/**
	 * Sets the canales vo.
	 *
	 * @param canalesVO the canalesVO to set
	 */
	public void setCanalesVO(CanalVO canalesVO) {
		this.canalesVO = canalesVO;
	}

	/**
	 * Sets the canales v os.
	 *
	 * @param canalesVOs the canalesVOs to set
	 */
	public void setCanalesVOs(List<CanalVO> canalesVOs) {
		this.canalesVOs = canalesVOs;
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
	 * Sets the flag clave.
	 *
	 * @param flagClave the flagClave to set
	 */
	public void setFlagClave(boolean flagClave) {
		this.flagClave = flagClave;
	}
	
	/**
	 * Sets the str id canal.
	 *
	 * @param strIdCanal the strIdCanal to set
	 */
	public void setStrIdCanal(String strIdCanal) {
		this.strIdCanal = strIdCanal;
	}	
}
