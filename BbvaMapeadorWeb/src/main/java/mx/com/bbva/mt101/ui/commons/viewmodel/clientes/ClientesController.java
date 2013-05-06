package mx.com.bbva.mt101.ui.commons.viewmodel.clientes;

import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;

import mx.com.bbva.bancomer.bussinnes.model.vo.ClienteVO;
import mx.com.bbva.bancomer.cliente.dto.ClienteDTO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.ClienteBO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.utils.StringUtil;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

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
	
	private ClienteDTO clienteDTO;
	private List<ClienteVO> clientesVOs;
	
	/**
	 * Constructor de CanalesController
	 */
	public ClientesController() {
		this.read();
		this.clientesVOs = clienteDTO.getClienteVOs();
	}
	
	@Override
	public Object read() {
		clienteDTO = new ClienteDTO();
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
	    estatusObjetoDTO.setCommandId(2);
	    estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
	    clienteDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
	    
		ClienteBO clienteBO = new ClienteBO();
		clienteBO.readCommand(clienteDTO);
		return clienteDTO;
	}
	
	@Command
	@NotifyChange({ "clientesVOs" })
	public void readWithFilters() {
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
	}

	@Override
	@Command
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Command
	@NotifyChange({ "clientesVOs" })
	public void save() {
		boolean errorGuardar = false;
		if (statusObjeto.getSelectedItem() == null
				|| statusObjeto.getSelectedItem().getValue() == null
				|| statusObjeto.getSelectedItem().getValue().toString().isEmpty()) {
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
		if (nombreCortoCliente.getValue().isEmpty()) {
			nombreCortoCliente
			.setErrorMessage("Favor de introducir el nombre corto del Cliente");
			errorGuardar = true;
		}
		if(!errorGuardar){
			if(idCliente.getValue().isEmpty()){
				ClienteDTO clienteDTO = new ClienteDTO();
				ClienteVO clienteVO = new ClienteVO();
				clienteVO.setIdIdentificador(idIdentificador.getValue().toUpperCase());
				clienteVO.setNombreCliente(nombreCliente.getValue().toUpperCase());
				clienteVO.setNombreCortoCliente(nombreCortoCliente.getValue().toUpperCase());
				clienteVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
				clienteDTO.setClienteVO(clienteVO);
				ClienteBO clienteBO = new ClienteBO();
				clienteBO.createCommand(clienteDTO);
				clienteDTO.toString(BbvaAbstractDataTransferObject.XML);
				clean();
				
				clienteVO.setIdIdentificador(StringUtil.validaLike(idIdentificador.getValue()));
				clienteVO.setNombreCliente(StringUtil.validaLike(nombreCliente.getValue()));
				clienteVO.setNombreCortoCliente(StringUtil.validaLike(nombreCortoCliente.getValue()));
				clienteVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
				
				clienteVO.toString();
				clienteDTO.setClienteVO(clienteVO);
				clientesVOs = clienteBO.readCommand(clienteDTO).getClienteVOs();
				
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
				
				clean();
				clienteVO.setIdIdentificador(StringUtil.validaLike(idIdentificador.getValue()));
				clienteVO.setNombreCliente(StringUtil.validaLike(nombreCliente.getValue()));
				clienteVO.setNombreCortoCliente(StringUtil.validaLike(nombreCortoCliente.getValue()));
				clienteVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
				
				clienteVO.toString();
				clienteDTO.setClienteVO(clienteVO);
				clientesVOs = clienteBO.readCommand(clienteDTO).getClienteVOs();
			}
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
	public void readSelected(@BindingParam("idCliente") final ClienteVO clienteVO){
		clienteVO.toString();
		idIdentificador.setValue(clienteVO.getIdIdentificador());
		nombreCliente.setValue(clienteVO.getNombreCliente());
		nombreCortoCliente.setValue(clienteVO.getNombreCortoCliente());
		statusObjeto.setValue(clienteVO.getNombreEstatusObjeto());
		idCliente.setValue(Integer.toString(clienteVO.getIdCliente()));
		idEstatusObjeto.setValue(Integer.toString(clienteVO.getIdEstatusObjeto()));
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
	
}
