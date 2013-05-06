/**
 * 
 */
package mx.com.bbva.bancomer.cliente.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ClienteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

/**
 * @author Julio Morales
 * DTO para las Transacciones de la Entidad Cliente
 */
public class ClienteDTO extends BbvaAbstractDataTransferObject {

	private static final long serialVersionUID = 6661118547911208226L;
	
	private List<EstatusObjetoVO> estatusObjetoVOs;
	private List<ClienteVO> clienteVOs;
	private ClienteVO clienteVO;
	
	/**
	 * @return the estatusObjetoVOs
	 */
	public List<EstatusObjetoVO> getEstatusObjetoVOs() {
		return estatusObjetoVOs;
	}
	/**
	 * @param estatusObjetoVOs the estatusObjetoVOs to set
	 */
	public void setEstatusObjetoVOs(List<EstatusObjetoVO> estatusObjetoVOs) {
		this.estatusObjetoVOs = estatusObjetoVOs;
	}
	/**
	 * @return the clienteVOs
	 */
	public List<ClienteVO> getClienteVOs() {
		return clienteVOs;
	}
	/**
	 * @param clienteVOs the clienteVOs to set
	 */
	public void setClienteVOs(List<ClienteVO> clienteVOs) {
		this.clienteVOs = clienteVOs;
	}
	/**
	 * @return the clienteVO
	 */
	public ClienteVO getClienteVO() {
		return clienteVO;
	}
	/**
	 * @param clienteVO the clienteVO to set
	 */
	public void setClienteVO(ClienteVO clienteVO) {
		this.clienteVO = clienteVO;
	}	
}
