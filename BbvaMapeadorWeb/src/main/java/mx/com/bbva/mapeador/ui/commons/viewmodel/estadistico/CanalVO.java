package mx.com.bbva.mapeador.ui.commons.viewmodel.estadistico;

import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

public class CanalVO {
	public long idCanal;
	public String nombreCanal;
	private List<ClienteVO> clienteVOs;
	/**
	 * @return the idCanal
	 */
	public long getIdCanal() {
		return idCanal;
	}
	/**
	 * @param idCanal the idCanal to set
	 */
	public void setIdCanal(long idCanal) {
		this.idCanal = idCanal;
	}
	/**
	 * @return the nombreCanal
	 */
	public String getNombreCanal() {
		return nombreCanal;
	}
	/**
	 * @param nombreCanal the nombreCanal to set
	 */
	public void setNombreCanal(String nombreCanal) {
		this.nombreCanal = nombreCanal;
	}
	
	/**
	 * @param clienteVOs the clienteVOs to set
	 */
	public void setClienteVOs(List<ClienteVO> clienteVOs) {
		this.clienteVOs = clienteVOs;
	}
	/**
	 * 
	 */
	public CanalVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param idCanal
	 * @param nombreCanal
	 * @param clienteVOs
	 */
	public CanalVO(long idCanal, String nombreCanal, List<ClienteVO> clienteVOs) {
		super();
		this.idCanal = idCanal;
		this.nombreCanal = nombreCanal;
		this.clienteVOs = clienteVOs;
	}
	public ListModel<ClienteVO> getClienteVOs() {
		return new ListModelList<ClienteVO>(clienteVOs);
	}
	
	public List<ClienteVO> getListaClientes() {
		return clienteVOs;
	}
}
