package mx.com.bbva.mapeador.ui.commons.viewmodel.clientes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
import org.zkoss.zkex.zul.Jasperreport;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;

import mx.com.bbva.bancomer.bussinnes.model.vo.ClienteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.cliente.dto.ClienteDTO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.ClienteBO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.utils.StringUtil;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;
import mx.com.bbva.mt101.ui.commons.viewmodel.reportes.ReportesController;

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
	private Jasperreport report;
	
	private ClienteDTO clienteDTO;
	private List<ClienteVO> clientesVOs;
	private ClienteVO clientesVO;
	private boolean btnGuardar;
	private boolean flagEstatus;
	
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
	    //estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
	    EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
		//estatusObjetoVO.setNombreTabla(CommandConstants.NOMBRE_TABLA_CLIENTES);				
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
				ClienteDTO clienteDTO = new ClienteDTO();
				ClienteVO clienteVO = new ClienteVO();
				clienteVO.setIdIdentificador(idIdentificador.getValue().toUpperCase());
				clienteVO.setNombreCliente(nombreCliente.getValue().toUpperCase());
				clienteVO.setNombreCortoCliente(nombreCortoCliente.getValue().toUpperCase());
				clienteVO.setIdEstatusObjeto(CommandConstants.ESTATUS_OBJETO_ACTIVO);
				clienteDTO.setClienteVO(clienteVO);
				ClienteBO clienteBO = new ClienteBO();
				clienteBO.createCommand(clienteDTO);
				clienteDTO.toString(BbvaAbstractDataTransferObject.XML);
				clean();
				
				clienteVO.setIdIdentificador(StringUtil.validaLike(idIdentificador.getValue()));
				clienteVO.setNombreCliente(StringUtil.validaLike(nombreCliente.getValue()));
				clienteVO.setNombreCortoCliente(StringUtil.validaLike(nombreCortoCliente.getValue()));
				clienteVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
				
				controller.registrarEvento(clienteVO, clientesVO, CommandConstants.ALTA, "Catálogo Clientes");
				
				clienteVO.toString();
				clienteDTO.setClienteVO(clienteVO);
				clientesVOs = clienteBO.readCommand(clienteDTO).getClienteVOs();
				Messagebox.show("!El Registro del Cliente fue exitoso!",
						"Información", Messagebox.OK,
						Messagebox.INFORMATION);
			} else {
				ClienteDTO clienteDTO = new ClienteDTO();
				ClienteVO clienteVO = new ClienteVO();
				clienteVO.setIdCliente(Integer.parseInt(idCliente.getValue()));
				clienteVO.setIdIdentificador(idIdentificador.getValue().toUpperCase());
				clienteVO.setNombreCliente(nombreCliente.getValue().toUpperCase());
				clienteVO.setNombreCortoCliente(nombreCortoCliente.getValue().toUpperCase());
				clienteVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
				clienteDTO.setClienteVO(clienteVO);
				ClienteBO clienteBO = new ClienteBO();
				clienteBO.updateCommand(clienteDTO);
				clienteDTO.toString(BbvaAbstractDataTransferObject.XML);
				controller.registrarEvento(clienteVO, clientesVO, CommandConstants.MODIFICACION, "Catálogo Clientes");
				clean();
				clienteVO.setIdIdentificador(StringUtil.validaLike(idIdentificador.getValue()));
				clienteVO.setNombreCliente(StringUtil.validaLike(nombreCliente.getValue()));
				clienteVO.setNombreCortoCliente(StringUtil.validaLike(nombreCortoCliente.getValue()));
				clienteVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
				
				clienteVO.toString();
				clienteDTO.setClienteVO(clienteVO);
				clientesVOs = clienteBO.readCommand(clienteDTO).getClienteVOs();
				
				Messagebox.show("!La Actualización del Cliente fue exitoso!",
						"Información", Messagebox.OK,
						Messagebox.INFORMATION);
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
		statusObjeto.clearErrorMessage();
		idCliente.clearErrorMessage();
		idEstatusObjeto.clearErrorMessage();

		idIdentificador.setValue(null);
		nombreCliente.setValue(null);
		nombreCortoCliente.setValue(null);
		statusObjeto.setValue(null);
		idCliente.setValue(null);
		idEstatusObjeto.setValue(null);
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
	}
	
	@Command
	public void onShowReport(@BindingParam("type") final String type) {
		ReportesController controller = new ReportesController();
		ArrayList<String> headersReport = new ArrayList<String>();
		String titleReport = "Catálogo Clientes";
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
		controller.createReport(generaLista(), headersReport, titleReport, report, type);
	}	
	
	private ArrayList<BeanGenerico> generaLista() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
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
	 * @return the btnGuardar
	 */
	public boolean isBtnGuardar() {
		return btnGuardar;
	}

	/**
	 * @param btnGuardar the btnGuardar to set
	 */
	public void setBtnGuardar(boolean btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	/**
	 * @return the clientesVO
	 */
	public ClienteVO getClientesVO() {
		return clientesVO;
	}

	/**
	 * @param clientesVO the clientesVO to set
	 */
	public void setClientesVO(ClienteVO clientesVO) {
		this.clientesVO = clientesVO;
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
	@Override
	public boolean applyPermision() {
		// TODO Auto-generated method stub
		return false;
	}
}
