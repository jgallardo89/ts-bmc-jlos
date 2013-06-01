package mappers.cliente;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ClienteVO;

public abstract interface MapCliente {
	public abstract List<ClienteVO> obtenerClientes(ClienteVO clienteVO);
	public abstract void crearCliente(ClienteVO clienteVO);
	public abstract void actualizarCliente(ClienteVO clienteVO);
	public abstract List<ClienteVO> obtenerCmbClientes(ClienteVO clienteVO);
}
