package mappers.cliente;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ClienteVO;

public abstract interface MapCliente {
	public abstract List<ClienteVO> obtenerClientes(ClienteVO ClienteVO);
	public abstract void crearCliente(ClienteVO ClienteVO);
	public abstract void actualizarCliente(ClienteVO ClienteVO);
}
