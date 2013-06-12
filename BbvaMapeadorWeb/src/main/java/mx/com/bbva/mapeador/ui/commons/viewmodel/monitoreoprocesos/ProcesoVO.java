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
 * Nombre de clase: ProcesoVO.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.monitoreoprocesos
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.monitoreoprocesos;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoVO.
 */
public class ProcesoVO {
	
	/** The id canal. */
	private long idCanal;
	
	/** The id cliente. */
	private long idCliente;
	
	/** The id estatus mapeador. */
	private long idEstatusMapeador;
	
	/** The id identificador. */
	private String idIdentificador;
	
	/** The id producto. */
	private long idProducto;
	
	/** The imagen estatus. */
	private String imagenEstatus;
	
	/** The lote v os. */
	private List<LoteVO> loteVOs;
	
	/** The nombre canal. */
	private String nombreCanal;
	
	/** The nombre estatus mapeador. */
	private String nombreEstatusMapeador; 
	
	/** The nombre producto. */
	private String nombreProducto;
	
	

	/**
	 * Gets the id canal.
	 *
	 * @return the idCanal
	 */
	public long getIdCanal() {
		return idCanal;
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
	 * Gets the id estatus mapeador.
	 *
	 * @return the idEstatusMapeador
	 */
	public long getIdEstatusMapeador() {
		return idEstatusMapeador;
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
	 * Gets the id producto.
	 *
	 * @return the idProducto
	 */
	public long getIdProducto() {
		return idProducto;
	}
	
	/**
	 * Gets the imagen estatus.
	 *
	 * @return the imagenEstatus
	 */
	public String getImagenEstatus() {
		return imagenEstatus;
	}
	
	/**
	 * Gets the lote v os.
	 *
	 * @return the loteVOs
	 */
	public List<LoteVO> getLoteVOs() {
		return loteVOs;
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
	 * Gets the nombre estatus mapeador.
	 *
	 * @return the nombreEstatusMapeador
	 */
	public String getNombreEstatusMapeador() {
		return nombreEstatusMapeador;
	}
	
	/**
	 * Gets the nombre producto.
	 *
	 * @return the nombreProducto
	 */
	public String getNombreProducto() {
		return nombreProducto;
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
	 * Sets the id cliente.
	 *
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	
	/**
	 * Sets the id estatus mapeador.
	 *
	 * @param idEstatusMapeador the idEstatusMapeador to set
	 */
	public void setIdEstatusMapeador(long idEstatusMapeador) {
		this.idEstatusMapeador = idEstatusMapeador;
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
	 * Sets the id producto.
	 *
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}
	
	/**
	 * Sets the imagen estatus.
	 *
	 * @param imagenEstatus the imagenEstatus to set
	 */
	public void setImagenEstatus(String imagenEstatus) {
		this.imagenEstatus = imagenEstatus;
	}
	
	/**
	 * Sets the lote v os.
	 *
	 * @param loteVOs the loteVOs to set
	 */
	public void setLoteVOs(List<LoteVO> loteVOs) {
		this.loteVOs = loteVOs;
	}
	
	/**
	 * Sets the nombre canal.
	 *
	 * @param nombreCanal the nombreCanal to set
	 */
	public void setNombreCanal(String nombreCanal) {
		this.nombreCanal = nombreCanal;
	}
	
	/**
	 * Sets the nombre estatus mapeador.
	 *
	 * @param nombreEstatusMapeador the nombreEstatusMapeador to set
	 */
	public void setNombreEstatusMapeador(String nombreEstatusMapeador) {
		this.nombreEstatusMapeador = nombreEstatusMapeador;
	}
	
	/**
	 * Sets the nombre producto.
	 *
	 * @param nombreProducto the nombreProducto to set
	 */
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	} 

	
} 
