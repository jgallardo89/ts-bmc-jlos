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
 * Nombre de clase: ClientesController.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.clientes
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.clientes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ClienteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ContratacionVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.cliente.dto.ClienteDTO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.ClienteBO;
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

/**
 * The Class ClientesController.
 *
 * @author Julio Morales
 */
public class ClientesController extends ControllerSupport implements IController {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6447535392970904023L;
	
	/** The nombre Pantalla */
	private static final String nombrePantalla="Catálogo Clientes";
	
	/** The btn guardar. */
	@SuppressWarnings("unused")
	private boolean btnGuardar;
	
	/** The cliente dto. */
	private ClienteDTO clienteDTO;
	
	/** The clientes grid. */
	@Wire
	private Grid clientesGrid;
	
	/** The clientes vo. */
	private ClienteVO clientesVO;
	
	/** The clientes v os. */
	private List<ClienteVO> clientesVOs;
	
	/** The consultar btn. */
	@Wire
	private Button consultarBtn;	
	
	/** The execute permission set. */
	private boolean executePermissionSet;
	
	/** The fecha alta. */
	@Wire
	private Datebox fechaAlta;
	
	/** The fecha modificacion. */
	@Wire
	private Datebox fechaModificacion;
	
	/** The flag estatus. */
	@SuppressWarnings("unused")
	private boolean flagEstatus;
	
	/** The guardar btn. */
	@Wire
	private Button guardarBtn;
	
	/** The id cliente. */
	@Wire
	private Textbox idCliente;
	
	/** The id estatus objeto. */
	@Wire
	private Textbox idEstatusObjeto;
	
	/** The id identificador. */
	@Wire
	private Textbox idIdentificador;
	
	/** The lbl descripcion cliente. */
	@Wire
	private Label lblDescripcionCliente;
	
	/** The lbl estatus. */
	@Wire
	private Label lblEstatus;
	
	/** The lbl fecha alta. */
	@Wire
	private Label lblFechaAlta;
	
	/** The lbl fecha modificacion. */
	@Wire
	private Label lblFechaModificacion;
	
	/** The lbl identificador. */
	@Wire
	private Label lblIdentificador;
	
	/** The lbl nombre cliente. */
	@Wire
	private Label lblNombreCliente;
	
	/** The limpiar btn. */
	@Wire
	private Button limpiarBtn;
	
	/** The nombre cliente. */
	@Wire
	private Textbox nombreCliente;
	
	/** The nombre corto cliente. */
	@Wire
	private Textbox nombreCortoCliente;
	
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
	 * Constructor de CanalesController.
	 */
	public ClientesController() {
		this.read();
		this.clientesVOs = clienteDTO.getClienteVOs();
		btnGuardar = true;
		flagEstatus = true;
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
        defaultValues();
    }
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#applyPermision()
	 */
	@Override
	public boolean applyPermision() {
		boolean isApplied = false;
		HashMap<String, Component> componentes = new HashMap<String, Component>();
		componentes.put(lblIdentificador.getId(), lblIdentificador);
		componentes.put(lblNombreCliente.getId(), lblNombreCliente);
		componentes.put(lblFechaAlta.getId(), lblFechaAlta);
		componentes.put(lblDescripcionCliente.getId(), lblDescripcionCliente);
		componentes.put(lblFechaModificacion.getId(), lblFechaModificacion);
		componentes.put(lblEstatus.getId(), lblEstatus);
		componentes.put(idIdentificador.getId(), idIdentificador);
		componentes.put(nombreCliente.getId(), nombreCliente);
		componentes.put(nombreCortoCliente.getId(), nombreCortoCliente);
		componentes.put(fechaAlta.getId(), fechaAlta);
		componentes.put(fechaModificacion.getId(), fechaModificacion);
		componentes.put(statusObjeto.getId(), statusObjeto);
		componentes.put(reporteExcelBtn.getId(), reporteExcelBtn);
		componentes.put(reporteCsvBtn.getId(), reporteCsvBtn);
		componentes.put(limpiarBtn.getId(), limpiarBtn);
		componentes.put(guardarBtn.getId(), guardarBtn);	
		componentes.put(consultarBtn.getId(), consultarBtn);
		componentes.put(clientesGrid.getId(), clientesGrid);
		super.applyPermission(MapeadorConstants.CLIENTES, componentes);
		return isApplied;
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#clean()
	 */
	@Override
	@Command
	public void clean() {
		idIdentificador.clearErrorMessage();
		nombreCliente.clearErrorMessage();
		nombreCortoCliente.clearErrorMessage();
		idCliente.clearErrorMessage();
		
		fechaAlta.setValue(null);
		fechaModificacion.setValue(null);

		idIdentificador.setValue(null);
		nombreCliente.setValue(null);
		nombreCortoCliente.setValue(null);
		idCliente.setValue(null);
		defaultValues();
	}

	/**
	 * Default values.
	 */
	private void defaultValues() {
		statusObjeto.setValue(CommandConstants.NB_CLIENTE_ACTIVO);
        idEstatusObjeto.setValue(String.valueOf(CommandConstants.ID_CLIENTE_ACTIVO));       
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#delete()
	 */
	@Override
	@Command
	public void delete() {
		
	}

	/**
	 * Genera lista.
	 *
	 * @return the array list
	 */
	private ArrayList<BeanGenerico> generaLista() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		ArrayList<BeanGenerico> beanGenericos = new ArrayList<BeanGenerico>();
		BeanGenerico beanGenerico = null;
		for(ClienteVO clienteVO: clientesVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(clienteVO.getIdIdentificador());
			beanGenerico.setValor2(clienteVO.getNombreCliente());
			beanGenerico.setValor3(clienteVO.getNombreCortoCliente());
			beanGenerico.setValor4(dateFormat.format(clienteVO.getFechaAlta()));
			if(clienteVO.getFechaModificacion()!=null)
				beanGenerico.setValor5(dateFormat.format(clienteVO.getFechaModificacion()));
			beanGenerico.setValor6(clienteVO.getNombreEstatusObjeto());
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}
	
	/**
	 * Gets the cliente dto.
	 *
	 * @return the clienteDTO
	 */
	public ClienteDTO getClienteDTO() {
		return clienteDTO;
	}
	
	/**
	 * Gets the clientes v os.
	 *
	 * @return the clientesVOs
	 */
	public List<ClienteVO> getClientesVOs() {
		return clientesVOs;
	}	
	
	/**
	 * Gets the status objeto.
	 *
	 * @return the statusObjeto
	 */
	public Combobox getStatusObjeto() {		
		return statusObjeto;
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
		headersReport.add("Identificador");
		headersReport.add("Nombre cliente");
		headersReport.add("Descripción cliente");
		headersReport.add("Fecha y Hora de alta");
		headersReport.add("Fecha y Hora de modificación");
		headersReport.add("Status");
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,nombrePantalla);
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,nombrePantalla);
		}
		controller.createReport(generaLista(), headersReport, type, "CLIENTES");
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read()
	 */
	@Override
	public Object read() {
		ClienteVO clienteVO = new ClienteVO();
		clienteDTO = new ClienteDTO();
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
	    estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
	    EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
		estatusObjetoVO.setNombreTabla(CommandConstants.NOMBRE_TABLA_CLIENTES);				
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
	    estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
	    if(estatusObjetoDTO.getErrorCode().equals("SQL-001")){
	    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
	    					"\nError:"+estatusObjetoDTO.getErrorCode()+
	    					"","Error de Sistema",Messagebox.OK,Messagebox.ERROR);
	    }
	    clienteDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
	    
	    clienteDTO.setClienteVO(clienteVO);
		ClienteBO clienteBO = new ClienteBO();
		clienteDTO = clienteBO.readCommand(clienteDTO);
		if(clienteDTO.getErrorCode().equals("SQL-001")){
	    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
	    					"\nError:"+clienteDTO.getErrorCode()+
	    					"\nDescripción:"+clienteDTO.getErrorDescription(),"Error de Sistema",Messagebox.OK,Messagebox.ERROR);
	    }
		return clienteDTO;
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read(java.lang.Object)
	 */
	@Override
	@Command
	public Object read(Object t) {

		return null;
	}

	/**
	 * Read selected.
	 *
	 * @param clienteVO the cliente vo
	 */
	@Command
	@NotifyChange({"btnGuardar","flagEstatus"})
	public void readSelected(@BindingParam("idCliente") final ClienteVO clienteVO){
		clientesVO = clienteVO;
		clienteVO.toString();
		idIdentificador.setValue(clienteVO.getIdIdentificador());
		nombreCliente.setValue(clienteVO.getNombreCliente());
		nombreCortoCliente.setValue(clienteVO.getNombreCortoCliente());
		statusObjeto.setValue(clienteVO.getNombreEstatusObjeto());
		idCliente.setValue(Integer.toString(clienteVO.getIdCliente()));
		idEstatusObjeto.setValue(Integer.toString(clienteVO.getIdEstatusObjeto()));
		btnGuardar = false;
		flagEstatus = false;
		
		fechaAlta.setValue(clienteVO.getFechaAlta());
		fechaModificacion.setValue(clienteVO.getFechaModificacion());
	}

	/**
	 * Read with filters.
	 */
	@GlobalCommand
	@Command
	@NotifyChange({ "clientesVOs" })
	public void readWithFilters() {
		ReportesController controller = new ReportesController();
		ClienteDTO clienteDTO = new ClienteDTO();
		ClienteVO clienteVO = new ClienteVO();
		clienteVO.setIdIdentificador(StringUtil.validaLike(idIdentificador.getValue()));
		clienteVO.setNombreCliente(StringUtil.validaLike(nombreCliente.getValue()));
		clienteVO.setNombreCortoCliente(StringUtil.validaLike(nombreCortoCliente.getValue()));
		clienteVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
		
		clienteVO.toString();
		clienteDTO.setClienteVO(clienteVO);
		ClienteBO clienteBO = new ClienteBO();
		clienteDTO = clienteBO.readCommand(clienteDTO);
		if(clienteDTO.getErrorCode().equals("SQL-001")){
	    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
	    					"\nError:"+clienteDTO.getErrorCode()+
	    					"\nDescripción:"+clienteDTO.getErrorDescription(),"Error de Sistema",Messagebox.OK,Messagebox.ERROR);
	    }
		clientesVOs = clienteDTO.getClienteVOs();
		
		controller.registrarEvento(null, null, CommandConstants.CONSULTAR, nombrePantalla);
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#save()
	 */
	@Override
	@Command
	@NotifyChange({ "clientesVOs", "btnGuardar", "flagEstatus"})
	public void save() {
		final ReportesController controller = new ReportesController();
		boolean errorGuardar = false;
		final ClienteBO clienteBO = new ClienteBO();
		if (idIdentificador.getValue().isEmpty()) {
			idIdentificador
					.setErrorMessage("Favor de introducir el Identificador del Cliente");
			errorGuardar = true;
		}
		if (nombreCliente.getValue().isEmpty()) {
			nombreCliente
					.setErrorMessage("Favor de introducir el nombre del Cliente");
			errorGuardar = true;
		}
		if (nombreCortoCliente.getValue().isEmpty()) {
			nombreCortoCliente
			.setErrorMessage("Favor de introducir el nombre corto del Cliente");
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
						if(idCliente.getValue().isEmpty() || idCliente.getValue().equals("0")){
							ClienteVO clienteVO = new ClienteVO();
							clienteDTO = new ClienteDTO();
							clienteVO.setIdIdentificador(idIdentificador.getValue().toUpperCase().trim());
							clienteDTO = clienteBO.readCommand(clienteVO);
							if(clienteDTO.getErrorCode().equals("SQL-001")){
						    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
						    					"\nError:"+clienteDTO.getErrorCode()+
						    					"\nDescripción:"+clienteDTO.getErrorDescription(),"Error de Sistema",Messagebox.OK,Messagebox.ERROR);
						    }
							if(clienteDTO.getClienteVOs().size()==0) {
								clienteVO.setIdIdentificador(idIdentificador.getValue().toUpperCase().trim());
								clienteVO.setNombreCliente(nombreCliente.getValue().toUpperCase().trim());
								clienteVO.setNombreCortoCliente(nombreCortoCliente.getValue().toUpperCase().trim());
								clienteVO.setIdEstatusObjeto(CommandConstants.ESTATUS_OBJETO_ACTIVO_CLIENTES);
								clienteDTO.setClienteVO(clienteVO);
								
								clienteDTO = clienteBO.createCommand(clienteDTO);
								if(clienteDTO.getErrorCode().equals("SQL-001")){
							    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
							    					"\nError:"+clienteDTO.getErrorCode()+
							    					"\nDescripción:"+clienteDTO.getErrorDescription(),"Error de Sistema",Messagebox.OK,Messagebox.ERROR);
							    }else{
									clienteDTO.toString(BbvaAbstractDataTransferObject.XML);
				
									ClienteVO clienteNuevo = new ClienteVO();
									clienteNuevo.setIdIdentificador("");
									clienteNuevo.setNombreCliente("");
									clienteNuevo.setNombreCortoCliente("");
									clienteNuevo.setIdEstatusObjeto(CommandConstants.ESTATUS_OBJETO_ACTIVO_CLIENTES);					
									controller.registrarEvento(clienteVO, clienteNuevo, CommandConstants.ALTA, nombrePantalla);
									clean();
				
									
									clienteVO.setIdIdentificador(StringUtil.validaLike(idIdentificador.getValue()));
									clienteVO.setNombreCliente(StringUtil.validaLike(nombreCliente.getValue()));
									clienteVO.setNombreCortoCliente(StringUtil.validaLike(nombreCortoCliente.getValue()));
									clienteVO.setIdEstatusObjeto(0);
				
									
									clienteVO.toString();
									clienteDTO.setClienteVO(clienteVO);
									clienteDTO = clienteBO.readCommand(clienteDTO);
									if(clienteDTO.getErrorCode().equals("SQL-001")){
								    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
								    					"\nError:"+clienteDTO.getErrorCode()+
								    					"\nDescripción:"+clienteDTO.getErrorDescription(),"Error de Sistema",Messagebox.OK,Messagebox.ERROR);
								    }
									clientesVOs = clienteDTO.getClienteVOs();
									org.zkoss.zul.Messagebox.show("!El Registro del Cliente fue exitoso!",
											"Información", org.zkoss.zul.Messagebox.OK,
											org.zkoss.zul.Messagebox.INFORMATION);
							    }
							} else {
								clienteVO.setIdIdentificador(idIdentificador.getValue().toUpperCase().trim());
								clienteVO.setNombreCliente(nombreCliente.getValue().toUpperCase().trim());
								clienteVO.setNombreCortoCliente(nombreCortoCliente.getValue().toUpperCase().trim());
								clienteVO.setIdEstatusObjeto(CommandConstants.ESTATUS_OBJETO_ACTIVO_CLIENTES);
								ClienteVO clienteNuevo = new ClienteVO();
								clienteNuevo.setIdIdentificador("");
								clienteNuevo.setNombreCliente("");
								clienteNuevo.setNombreCortoCliente("");
								clienteNuevo.setIdEstatusObjeto(CommandConstants.ESTATUS_OBJETO_ACTIVO_CLIENTES);					
								controller.registrarEvento(clienteVO, clienteNuevo, CommandConstants.ALTA_FALLIDA, nombrePantalla);
								clean();
								
								org.zkoss.zul.Messagebox.show("!Ya existe un Cliente con el mismo Identificador!",
										"Información", org.zkoss.zul.Messagebox.OK,
										org.zkoss.zul.Messagebox.EXCLAMATION);
							}
						} else {
							ContratacionBO contratacionBO = new ContratacionBO();
							ContratacionVO contratacionVO = new ContratacionVO();
							contratacionVO.setIdCliente(Integer.parseInt(idCliente.getValue()));
							ClienteVO clienteVO = new ClienteVO();
							clienteDTO = new ClienteDTO();
							clienteVO.setIdIdentificador(idIdentificador.getValue().toUpperCase());
							clienteVO.setIdCliente(Integer.parseInt(idCliente.getValue()));
							clienteDTO = clienteBO.readCommand(clienteVO);
							if(clienteDTO.getErrorCode().equals("SQL-001")){
						    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
						    					"\nError:"+clienteDTO.getErrorCode()+
						    					"\nDescripción:"+clienteDTO.getErrorDescription(),"Error de Sistema",Messagebox.OK,Messagebox.ERROR);
						    }
							if(clienteDTO.getClienteVOs()!=null && clienteDTO.getClienteVOs().size()>0){
								clienteVO.setIdIdentificador(idIdentificador.getValue().toUpperCase().trim());
								clienteVO.setNombreCliente(nombreCliente.getValue().toUpperCase().trim());
								clienteVO.setNombreCortoCliente(nombreCortoCliente.getValue().toUpperCase().trim());
								clienteVO.setIdEstatusObjeto(CommandConstants.ESTATUS_OBJETO_ACTIVO_CLIENTES);	
								ClienteVO clienteNuevo = new ClienteVO();
								clienteNuevo.setIdIdentificador("");
								clienteNuevo.setNombreCliente("");
								clienteNuevo.setNombreCortoCliente("");
								clienteNuevo.setIdEstatusObjeto(CommandConstants.ESTATUS_OBJETO_ACTIVO_CLIENTES);
								controller.registrarEvento(clienteVO, clienteNuevo, CommandConstants.ALTA_FALLIDA, nombrePantalla);
								org.zkoss.zul.Messagebox.show("!Ya existe un Cliente con el mismo Identificador!",
										"Información", org.zkoss.zul.Messagebox.OK,
										org.zkoss.zul.Messagebox.EXCLAMATION);
							}else{
								if(Integer.parseInt(idEstatusObjeto.getValue()) == CommandConstants.ESTATUS_OBJETO_ACTIVO_CLIENTES || 
										contratacionBO.readCommandValidaContratacion(contratacionVO)){
									ClienteDTO clienteDTO = new ClienteDTO();
									clienteVO = new ClienteVO();
									clienteVO.setIdCliente(Integer.parseInt(idCliente.getValue()));
									clienteVO.setIdIdentificador(idIdentificador.getValue().toUpperCase().trim());
									clienteVO.setNombreCliente(nombreCliente.getValue().toUpperCase().trim());
									clienteVO.setNombreCortoCliente(nombreCortoCliente.getValue().toUpperCase().trim());
									clienteVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
									clienteDTO.setClienteVO(clienteVO);
									
									clienteDTO = clienteBO.updateCommand(clienteDTO);
									if(clienteDTO.getErrorCode().equals("SQL-001")){
								    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
								    					"\nError:"+clienteDTO.getErrorCode()+
								    					"\nDescripción:"+clienteDTO.getErrorDescription(),"Error de Sistema",Messagebox.OK,Messagebox.ERROR);
								    }else{
										clienteDTO.toString(BbvaAbstractDataTransferObject.XML);
										if (Integer.parseInt(statusObjeto.getSelectedItem().getValue().toString())==CommandConstants.ID_CLIENTE_BAJA) {
											controller.registrarEvento(clienteVO, clientesVO, CommandConstants.BAJA, nombrePantalla);					
										} else if (Integer.parseInt(statusObjeto.getSelectedItem().getValue().toString())==CommandConstants.ID_CLIENTE_INACTIVO) { 
											controller.registrarEvento(clienteVO, clientesVO, CommandConstants.INACTIVACION, nombrePantalla);				
										} else {
											controller.registrarEvento(clienteVO, clientesVO, CommandConstants.MODIFICACION, nombrePantalla);
										}
				
										clean();
										clienteVO.setIdIdentificador(StringUtil.validaLike(idIdentificador.getValue()));
										clienteVO.setNombreCliente(StringUtil.validaLike(nombreCliente.getValue()));
										clienteVO.setNombreCortoCliente(StringUtil.validaLike(nombreCortoCliente.getValue()));
										clienteVO.setIdEstatusObjeto(0);
										clienteVO.toString();
										clienteDTO.setClienteVO(clienteVO);
										clienteDTO = clienteBO.readCommand(clienteDTO);
										if(clienteDTO.getErrorCode().equals("SQL-001")){
									    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
									    					"\nError:"+clienteDTO.getErrorCode()+
									    					"\nDescripción:"+clienteDTO.getErrorDescription(),"Error de Sistema",Messagebox.OK,Messagebox.ERROR);
									    }
										clientesVOs = clienteDTO.getClienteVOs();
										
										org.zkoss.zul.Messagebox.show("!La Actualización del Cliente fue exitoso!",
												"Información", org.zkoss.zul.Messagebox.OK,
												org.zkoss.zul.Messagebox.INFORMATION);
								    }
								} else {
									clienteVO = new ClienteVO();
									clienteVO.setIdCliente(Integer.parseInt(idCliente.getValue()));
									clienteVO.setIdIdentificador(idIdentificador.getValue().toUpperCase().trim());
									clienteVO.setNombreCliente(nombreCliente.getValue().toUpperCase().trim());
									clienteVO.setNombreCortoCliente(nombreCortoCliente.getValue().toUpperCase().trim());
									clienteVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
									if (Integer.parseInt(statusObjeto.getSelectedItem().getValue().toString())==CommandConstants.ID_CLIENTE_BAJA) {
										controller.registrarEvento(clienteVO, clientesVO, CommandConstants.BAJA_FALLIDA, nombrePantalla);					
									} else if (Integer.parseInt(statusObjeto.getSelectedItem().getValue().toString())==CommandConstants.ID_CLIENTE_INACTIVO) { 
										controller.registrarEvento(clienteVO, clientesVO, CommandConstants.INACTIVACION_FALLIDA, nombrePantalla);				
									} else {
										controller.registrarEvento(clienteVO, clientesVO, CommandConstants.MODIFICACION_FALLIDA, nombrePantalla);
									}
									clean();
				//					ClienteVO clienteVO = new ClienteVO();
				//					clienteVO.setIdIdentificador(StringUtil.validaLike(idIdentificador.getValue()));
				//					clienteVO.setNombreCliente(StringUtil.validaLike(nombreCliente.getValue()));
				//					clienteVO.setNombreCortoCliente(StringUtil.validaLike(nombreCortoCliente.getValue()));
				//					clienteVO.setIdEstatusObjeto(0);
				//					clienteVO.toString();
				//					clienteDTO.setClienteVO(clienteVO);
				//					clientesVOs = clienteBO.readCommand(clienteDTO).getClienteVOs();
									
									org.zkoss.zul.Messagebox.show("!No se puede dar de Baja, ya que esta siendo Usado por la Contratación!",
											"Información", org.zkoss.zul.Messagebox.OK,
											org.zkoss.zul.Messagebox.EXCLAMATION);
								}
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
		btnGuardar = true;
		flagEstatus = true;
	}
	
	/**
	 * Sets the cliente dto.
	 *
	 * @param clienteDTO the clienteDTO to set
	 */
	public void setClienteDTO(ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}
	
	/**
	 * Sets the clientes v os.
	 *
	 * @param clientesVOs the clientesVOs to set
	 */
	public void setClientesVOs(List<ClienteVO> clientesVOs) {
		this.clientesVOs = clientesVOs;
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
	 * Sets the status objeto.
	 *
	 * @param statusObjeto the statusObjeto to set
	 */
	public void setStatusObjeto(Combobox statusObjeto) {
		this.statusObjeto = statusObjeto;
	}	
	
}
