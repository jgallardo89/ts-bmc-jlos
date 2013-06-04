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

/**
 * @author Julio Morales
 *
 */
public class ClientesController extends ControllerSupport implements IController {

	private static final long serialVersionUID = 6447535392970904023L;
	
	@Wire
	private Textbox idCliente;
	@Wire
	private Textbox idIdentificador;
	@Wire
	private Textbox nombreCliente;
	@Wire
	private Textbox nombreCortoCliente;
	@Wire
	private Textbox idEstatusObjeto;
	@Wire
	private Combobox statusObjeto;	
	
	@Wire
	private Label lblIdentificador;
	@Wire
	private Label lblNombreCliente;
	@Wire
	private Label lblFechaAlta;
	@Wire
	private Label lblDescripcionCliente;
	@Wire
	private Label lblFechaModificacion;
	@Wire
	private Label lblEstatus;
	@Wire
	private Datebox fechaAlta;
	@Wire
	private Datebox fechaModificacion;
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
	private Grid clientesGrid;
	
	private ClienteDTO clienteDTO;
	private List<ClienteVO> clientesVOs;
	private ClienteVO clientesVO;
	private boolean btnGuardar;
	private boolean flagEstatus;
	private boolean executePermissionSet;
	
	/**
	 * Constructor de CanalesController
	 */
	public ClientesController() {
		this.read();
		this.clientesVOs = clienteDTO.getClienteVOs();
		btnGuardar = true;
		flagEstatus = true;
	}
	
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
	    clienteDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
	    
	    clienteDTO.setClienteVO(clienteVO);
		ClienteBO clienteBO = new ClienteBO();
		clienteBO.readCommand(clienteDTO);
		return clienteDTO;
	}
	
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
		clientesVOs = clienteBO.readCommand(clienteDTO).getClienteVOs();
		
		controller.registrarEvento(null, null, CommandConstants.CONSULTAR, "Catálogo Clientes");
	}

	@Override
	@Command
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Command
	@NotifyChange({ "clientesVOs", "btnGuardar", "flagEstatus"})
	public void save() {
		ReportesController controller = new ReportesController();
		boolean errorGuardar = false;
		ClienteBO clienteBO = new ClienteBO();
		if (idIdentificador.getValue().isEmpty()) {
			idIdentificador
					.setErrorMessage("Favor de introducir el Identificdor del Cliente");
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
			if(idCliente.getValue().isEmpty() || idCliente.getValue().equals("0")){
				ClienteVO clienteVO = new ClienteVO();
				clienteDTO = new ClienteDTO();
				clienteVO.setIdIdentificador(idIdentificador.getValue().toUpperCase());
				clienteDTO = clienteBO.readCommand(clienteVO);
				
				if(clienteDTO.getClienteVOs().size()==0) {
					clienteVO.setIdIdentificador(idIdentificador.getValue().toUpperCase());
					clienteVO.setNombreCliente(nombreCliente.getValue().toUpperCase());
					clienteVO.setNombreCortoCliente(nombreCortoCliente.getValue().toUpperCase());
					clienteVO.setIdEstatusObjeto(CommandConstants.ESTATUS_OBJETO_ACTIVO_CLIENTES);
					clienteDTO.setClienteVO(clienteVO);
					clienteBO.createCommand(clienteDTO);
					clienteDTO.toString(BbvaAbstractDataTransferObject.XML);
					clean();
					
					clienteVO.setIdIdentificador(StringUtil.validaLike(idIdentificador.getValue()));
					clienteVO.setNombreCliente(StringUtil.validaLike(nombreCliente.getValue()));
					clienteVO.setNombreCortoCliente(StringUtil.validaLike(nombreCortoCliente.getValue()));
					clienteVO.setIdEstatusObjeto(0);
					controller.registrarEvento(clienteVO, clientesVO, CommandConstants.ALTA, "Catálogo Clientes");
					
					clienteVO.toString();
					clienteDTO.setClienteVO(clienteVO);
					clientesVOs = clienteBO.readCommand(clienteDTO).getClienteVOs();
					Messagebox.show("!El Registro del Cliente fue exitoso!",
							"Información", Messagebox.OK,
							Messagebox.INFORMATION);
				} else {
					clean();
//					clienteVO.setIdIdentificador(StringUtil.validaLike(idIdentificador.getValue()));
//					clienteVO.setNombreCliente(StringUtil.validaLike(nombreCliente.getValue()));
//					clienteVO.setNombreCortoCliente(StringUtil.validaLike(nombreCortoCliente.getValue()));
//					clienteVO.setIdEstatusObjeto(0);
//					controller.registrarEvento(clienteVO, clientesVO, CommandConstants.ALTA, "Catálogo Clientes");
//					
//					clienteVO.toString();
//					clienteDTO.setClienteVO(clienteVO);
//					clientesVOs = clienteBO.readCommand(clienteDTO).getClienteVOs();
					Messagebox.show("!Ya existe un Cliente con el mismo Identificador!",
							"Información", Messagebox.OK,
							Messagebox.EXCLAMATION);
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
				if(clienteDTO.getClienteVOs()!=null && clienteDTO.getClienteVOs().size()>0){
					Messagebox.show("!Ya existe un Cliente con el mismo Identificador!",
							"Información", Messagebox.OK,
							Messagebox.EXCLAMATION);
				}else{
					if(Integer.parseInt(idEstatusObjeto.getValue()) == CommandConstants.ESTATUS_OBJETO_ACTIVO_CLIENTES || 
							contratacionBO.readCommandValidaContratacion(contratacionVO)){
						ClienteDTO clienteDTO = new ClienteDTO();
						clienteVO = new ClienteVO();
						clienteVO.setIdCliente(Integer.parseInt(idCliente.getValue()));
						clienteVO.setIdIdentificador(idIdentificador.getValue().toUpperCase());
						clienteVO.setNombreCliente(nombreCliente.getValue().toUpperCase());
						clienteVO.setNombreCortoCliente(nombreCortoCliente.getValue().toUpperCase());
						clienteVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
						clienteDTO.setClienteVO(clienteVO);
						
						clienteBO.updateCommand(clienteDTO);
						clienteDTO.toString(BbvaAbstractDataTransferObject.XML);
						controller.registrarEvento(clienteVO, clientesVO, CommandConstants.MODIFICACION, "Catálogo Clientes");
						clean();
						clienteVO.setIdIdentificador(StringUtil.validaLike(idIdentificador.getValue()));
						clienteVO.setNombreCliente(StringUtil.validaLike(nombreCliente.getValue()));
						clienteVO.setNombreCortoCliente(StringUtil.validaLike(nombreCortoCliente.getValue()));
						clienteVO.setIdEstatusObjeto(0);
						clienteVO.toString();
						clienteDTO.setClienteVO(clienteVO);
						clientesVOs = clienteBO.readCommand(clienteDTO).getClienteVOs();
						
						Messagebox.show("!La Actualización del Cliente fue exitoso!",
								"Información", Messagebox.OK,
								Messagebox.INFORMATION);
					} else {
						clean();
	//					ClienteVO clienteVO = new ClienteVO();
	//					clienteVO.setIdIdentificador(StringUtil.validaLike(idIdentificador.getValue()));
	//					clienteVO.setNombreCliente(StringUtil.validaLike(nombreCliente.getValue()));
	//					clienteVO.setNombreCortoCliente(StringUtil.validaLike(nombreCortoCliente.getValue()));
	//					clienteVO.setIdEstatusObjeto(0);
	//					clienteVO.toString();
	//					clienteDTO.setClienteVO(clienteVO);
	//					clientesVOs = clienteBO.readCommand(clienteDTO).getClienteVOs();
						Messagebox.show("!No se puede dar de Baja, ya que esta siendo Usado por la Contratación!",
								"Información", Messagebox.OK,
								Messagebox.EXCLAMATION);
					}
				}
			}
		}
		btnGuardar = true;
		flagEstatus = true;
	}

	@Override
	@Command
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Command
	public void clean() {
		idIdentificador.clearErrorMessage();
		nombreCliente.clearErrorMessage();
		nombreCortoCliente.clearErrorMessage();
		idCliente.clearErrorMessage();

		idIdentificador.setValue(null);
		nombreCliente.setValue(null);
		nombreCortoCliente.setValue(null);
		idCliente.setValue(null);
		defaultValues();
	}
	
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
	
	@Command
	public void onShowReport(@BindingParam("type") final String type) {
		ReportesController controller = new ReportesController();
		ArrayList<String> headersReport = new ArrayList<String>();
		headersReport.add("Identificador");
		headersReport.add("Nombre Cliente");
		headersReport.add("Descripcion Cliente");
		headersReport.add("Fecha y Hora de Alta");
		headersReport.add("Fecha y Hora de Modificación");
		headersReport.add("Estatus");
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Catálogo Clientes");
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Catálogo Clientes");
		}
		controller.createReport(generaLista(), headersReport, type, "CLIENTES");
	}	
	
	private ArrayList<BeanGenerico> generaLista() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
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
	
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);   
        executePermissionSet = this.applyPermision();
        defaultValues();
    }
	private void defaultValues() {
		statusObjeto.setValue(CommandConstants.NB_CLIENTE_ACTIVO);
        idEstatusObjeto.setValue(String.valueOf(CommandConstants.ID_CLIENTE_ACTIVO));
        fechaAlta.setValue(new Date());
		fechaModificacion.setValue(new Date());
	}

	/**
	 * @return the clienteDTO
	 */
	public ClienteDTO getClienteDTO() {
		return clienteDTO;
	}

	/**
	 * @param clienteDTO the clienteDTO to set
	 */
	public void setClienteDTO(ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}

	/**
	 * @return the clientesVOs
	 */
	public List<ClienteVO> getClientesVOs() {
		return clientesVOs;
	}

	/**
	 * @param clientesVOs the clientesVOs to set
	 */
	public void setClientesVOs(List<ClienteVO> clientesVOs) {
		this.clientesVOs = clientesVOs;
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

	/**
	 * @return the statusObjeto
	 */
	public Combobox getStatusObjeto() {		
		return statusObjeto;
	}

	/**
	 * @param statusObjeto the statusObjeto to set
	 */
	public void setStatusObjeto(Combobox statusObjeto) {
		this.statusObjeto = statusObjeto;
	}	
	
}
