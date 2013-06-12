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
 * Nombre de clase: ClienteVO.java
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
 * The Class ClienteVO.
 */
public class ClienteVO {
	
	/** The id cliente. */
	public long idCliente;
	
	/** The id identificador. */
	public String idIdentificador;
	
	/** The producto v os. */
	private List<ProductoVO> productoVOs;
	
	/**
	 * Instantiates a new cliente vo.
	 */
	public ClienteVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new cliente vo.
	 *
	 * @param idCliente the id cliente
	 * @param idIdentificador the id identificador
	 * @param productoVOs the producto v os
	 */
	public ClienteVO(long idCliente, String idIdentificador,
			List<ProductoVO> productoVOs) {
		super();
		this.idCliente = idCliente;
		this.idIdentificador = idIdentificador;
		this.productoVOs = productoVOs;
	}
	
	/**
	 * Gets the id cliente.
	 *
	 * @return the idCliente
	 */
	public long getIdCliente() {
		return idCliente;
	}
	
	/**
	 * Gets the id identificador.
	 *
	 * @return the idIdentificador
	 */
	public String getIdIdentificador() {
		return idIdentificador;
	}
	
	/**
	 * Gets the lista producto v os.
	 *
	 * @return the productoVOs
	 */
	public List<ProductoVO> getListaProductoVOs() {
		return productoVOs;
	}
	
	/**
	 * Gets the producto v os.
	 *
	 * @return the producto v os
	 */
	public ListModel<ProductoVO> getProductoVOs() {
		return new ListModelList<ProductoVO>(productoVOs);
	}
	
	/**
	 * Sets the id cliente.
	 *
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	
	/**
	 * Sets the id identificador.
	 *
	 * @param idIdentificador the idIdentificador to set
	 */
	public void setIdIdentificador(String idIdentificador) {
		this.idIdentificador = idIdentificador;
	}
	
	/**
	 * Sets the producto v os.
	 *
	 * @param productoVOs the productoVOs to set
	 */
	public void setProductoVOs(List<ProductoVO> productoVOs) {
		this.productoVOs = productoVOs;
	}
	
}
