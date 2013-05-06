package mx.com.bbva.mt101.ui.commons.viewmodel.clientes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Textbox;

import mx.com.bbva.bancomer.bussinnes.model.vo.ClienteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.cliente.dto.ClienteDTO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

/**
 * @author Julio Morales
 *
 */
public class ClientesController extends ControllerSupport implements IController {

	private static final long serialVersionUID = 6447535392970904023L;

	private ClienteDTO clienteDTO = (ClienteDTO)this.read();	
	
	@Wire
	private Textbox idCliente;
	@Wire
	private Textbox idIdentificador;
	@Wire
	private Textbox nombreCliente;
	@Wire
	private Datebox fechaAlta;
	@Wire
	private Textbox nombreCortoCliente;
	@Wire
	private Datebox fechaModificacion;	
	@Wire
	private Combobox statusObjeto;
	
	
	@Override
	public Object read() {
		ClienteDTO clienteDTO = new ClienteDTO();
		
		List<EstatusObjetoVO> estatusObjetoVOs = new ArrayList<EstatusObjetoVO>();
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
		estatusObjetoVO.setIdEstatusObjeto(1);
		estatusObjetoVO.setNombreEstatusObjeto("Activo");
		estatusObjetoVOs.add(estatusObjetoVO);
		estatusObjetoVO = new EstatusObjetoVO();
		estatusObjetoVO.setIdEstatusObjeto(2);
		estatusObjetoVO.setNombreEstatusObjeto("Inactivo");
		estatusObjetoVOs.add(estatusObjetoVO);
		clienteDTO.setEstatusObjetoVOs(estatusObjetoVOs);
		
		List<ClienteVO> clienteVOs = new ArrayList<ClienteVO>();
		ClienteVO clienteVO = new ClienteVO();
		
		clienteVO.setIdIdentificador("CL1");
		clienteVO.setNombreCliente("Julio Cesar");
		clienteVO.setNombreCortoCliente("Morales Ortega");
		clienteVO.setIdCliente(1);
		clienteVO.setFechaAlta(new Date());
		clienteVO.setFechaModificacion(new Date());
		clienteVO.setIdEstatusObjeto(1);
		clienteVO.setNombreEstatusObjeto("Activo");
		clienteVOs.add(clienteVO);
		
		clienteVO = new ClienteVO();
		clienteVO.setIdIdentificador("CL2");
		clienteVO.setNombreCliente("Miguel Angel");
		clienteVO.setNombreCortoCliente("Martinez");
		clienteVO.setIdCliente(2);
		clienteVO.setFechaAlta(new Date());
		clienteVO.setFechaModificacion(new Date());
		clienteVO.setIdEstatusObjeto(2);
		clienteVO.setNombreEstatusObjeto("Inactivo");
		clienteVOs.add(clienteVO);
		
		clienteDTO.setClienteVOs(clienteVOs);
		
		return clienteDTO;
	}

	@Override
	@Command
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Command
	public void save() {
		boolean errorGuardar = false;
		int estatusObjeto = 0;
		if (statusObjeto.getSelectedItem() == null
				|| statusObjeto.getSelectedItem().getValue() == null
				|| statusObjeto.getSelectedItem().getValue().toString().isEmpty()) {
			estatusObjeto = statusObjeto.getSelectedIndex();
			statusObjeto.setErrorMessage("Favor de seleccionar el Estatus");
			errorGuardar = true;
		}
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
		if (fechaAlta.getValue() == null) {
			fechaAlta
			.setErrorMessage("Favor de introducir la fecha alta del Cliente");
			errorGuardar = true;
		}
		if (nombreCortoCliente.getValue().isEmpty()) {
			nombreCortoCliente
			.setErrorMessage("Favor de introducir el nombre corto del Cliente");
			errorGuardar = true;
		}
		if (fechaModificacion.getValue() == null) {
			fechaModificacion
			.setErrorMessage("Favor de introducir la fecha de modificación del Cliente");
			errorGuardar = true;
		}
		if(!errorGuardar){
			ClienteDTO clienteDTO = new ClienteDTO();
			ClienteVO clienteVO = new ClienteVO();
			clienteVO.setIdIdentificador("CL1");
			clienteVO.setNombreCliente("Jose Luis");
			clienteVO.setNombreCortoCliente("Ortiz");
			clienteVO.setIdCliente(3);
			clienteVO.setFechaAlta(new Date());
			clienteVO.setFechaModificacion(new Date());
			clienteVO.setIdEstatusObjeto(estatusObjeto);
			clienteDTO.toString(BbvaAbstractDataTransferObject.XML);
		}
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
		//fechaAlta.clearErrorMessage();
		nombreCortoCliente.clearErrorMessage();
		fechaModificacion.clearErrorMessage();
		statusObjeto.clearErrorMessage();

		idIdentificador.setValue(null);
		nombreCliente.setValue(null);
		//fechaAlta.setValue(null);
		nombreCortoCliente.setValue(null);
		fechaModificacion.setValue(null);
		statusObjeto.setValue(null);
	}
	
	@Command
	public void readSelected(@BindingParam("idCliente") final ClienteVO clienteVO){
		clienteVO.toString();
		idIdentificador.setValue(clienteVO.getIdIdentificador());
		nombreCliente.setValue(clienteVO.getNombreCliente());
		//fechaAlta.setValue(clienteVO.getFechaAlta().toString());
		nombreCortoCliente.setValue(clienteVO.getNombreCortoCliente());
		fechaModificacion.setValue(clienteVO.getFechaModificacion());
		statusObjeto.setValue(clienteVO.getNombreEstatusObjeto());
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
	
}
