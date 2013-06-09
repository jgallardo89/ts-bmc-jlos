package mx.com.bbva.bancomer.estadistico.dto;

import java.io.Serializable;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ProductoVO;

public class ClienteMockDTO implements Serializable {

	private static final long serialVersionUID = 676025520912830887L;
	private String nombreCliente;
	private List<ProductoVO> productoVOs;

	
	/**
	 * @return the nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}

	/**
	 * @param nombreCliente the nombreCliente to set
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	/**
	 * @return the productoVOs
	 */
	public List<ProductoVO> getProductoVOs() {
		return productoVOs;
	}

	/**
	 * @param productoVOs the productoVOs to set
	 */
	public void setProductoVOs(List<ProductoVO> productoVOs) {
		this.productoVOs = productoVOs;
	}
	
	
}
