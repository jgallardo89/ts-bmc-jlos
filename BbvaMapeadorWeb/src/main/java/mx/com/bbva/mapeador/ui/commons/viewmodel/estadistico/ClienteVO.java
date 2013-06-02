package mx.com.bbva.mapeador.ui.commons.viewmodel.estadistico;

import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

public class ClienteVO {
	public long idCliente;
	public String idIdentificador;
	private List<ProductoVO> productoVOs;
	/**
	 * @return the idCliente
	 */
	public long getIdCliente() {
		return idCliente;
	}
	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	/**
	 * @return the idIdentificador
	 */
	public String getIdIdentificador() {
		return idIdentificador;
	}
	/**
	 * @param idIdentificador the idIdentificador to set
	 */
	public void setIdIdentificador(String idIdentificador) {
		this.idIdentificador = idIdentificador;
	}
	/**
	 * @return the productoVOs
	 */
	public List<ProductoVO> getListaProductoVOs() {
		return productoVOs;
	}
	
	public ListModel<ProductoVO> getProductoVOs() {
		return new ListModelList<ProductoVO>(productoVOs);
	}
	/**
	 * @param productoVOs the productoVOs to set
	 */
	public void setProductoVOs(List<ProductoVO> productoVOs) {
		this.productoVOs = productoVOs;
	}
	/**
	 * @param idCliente
	 * @param idIdentificador
	 * @param productoVOs
	 */
	public ClienteVO(long idCliente, String idIdentificador,
			List<ProductoVO> productoVOs) {
		super();
		this.idCliente = idCliente;
		this.idIdentificador = idIdentificador;
		this.productoVOs = productoVOs;
	}
	/**
	 * 
	 */
	public ClienteVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
