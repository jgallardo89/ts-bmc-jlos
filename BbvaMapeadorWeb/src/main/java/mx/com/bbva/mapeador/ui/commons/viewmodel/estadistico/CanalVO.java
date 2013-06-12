/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Informacion Confidencial:
 * Este software contiene informacion totalmente confidencial propiedad de Grupo Financiero BBVA Bancomer. 
 * Queda totalmente prohibido su uso o divulgacion en forma parcial o total y solamente podra ser utilizada de acuerdo a los terminos y estatutos 
 * que determine el Grupo Financiero BBVA Bancomer.
 * 
 * Todos los derechos reservados, Mexico 2013.
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * DESCRIPCION DEL PROGRAMA
 * Nombre de aplicación: MAPEADOR
 * Nombre de proyecto: BbvaMapeadorWeb
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * HISTORIAL DE CAMBIOS:
 * 
 * Fecha:									         	
 * 30-ABR-2013  
 * @Author:	Jose Luis Ortiz Salazar
 * @Email: jortizsalazar@gmail.com    	
 * Razon: Creacion        
 * Version: 1.0.0
 * Nombre de clase: CanalVO.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.estadistico
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.estadistico;

import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVO.
 */
public class CanalVO {
	
	/** The cliente v os. */
	private List<ClienteVO> clienteVOs;
	
	/** The id canal. */
	public long idCanal;
	
	/** The nombre canal. */
	public String nombreCanal;
	
	/**
	 * Instantiates a new canal vo.
	 */
	public CanalVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new canal vo.
	 *
	 * @param idCanal the id canal
	 * @param nombreCanal the nombre canal
	 * @param clienteVOs the cliente v os
	 */
	public CanalVO(long idCanal, String nombreCanal, List<ClienteVO> clienteVOs) {
		super();
		this.idCanal = idCanal;
		this.nombreCanal = nombreCanal;
		this.clienteVOs = clienteVOs;
	}
	
	/**
	 * Gets the cliente v os.
	 *
	 * @return the cliente v os
	 */
	public ListModel<ClienteVO> getClienteVOs() {
		return new ListModelList<ClienteVO>(clienteVOs);
	}
	
	/**
	 * Gets the id canal.
	 *
	 * @return the idCanal
	 */
	public long getIdCanal() {
		return idCanal;
	}
	
	/**
	 * Gets the lista clientes.
	 *
	 * @return the lista clientes
	 */
	public List<ClienteVO> getListaClientes() {
		return clienteVOs;
	}
	
	/**
	 * Gets the nombre canal.
	 *
	 * @return the nombreCanal
	 */
	public String getNombreCanal() {
		return nombreCanal;
	}
	
	/**
	 * Sets the cliente v os.
	 *
	 * @param clienteVOs the clienteVOs to set
	 */
	public void setClienteVOs(List<ClienteVO> clienteVOs) {
		this.clienteVOs = clienteVOs;
	}
	
	/**
	 * Sets the id canal.
	 *
	 * @param idCanal the idCanal to set
	 */
	public void setIdCanal(long idCanal) {
		this.idCanal = idCanal;
	}
	
	/**
	 * Sets the nombre canal.
	 *
	 * @param nombreCanal the nombreCanal to set
	 */
	public void setNombreCanal(String nombreCanal) {
		this.nombreCanal = nombreCanal;
	}
}
