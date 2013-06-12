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
 * Nombre de proyecto: BbvaMapeadorBusinessModel
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
 * Nombre de clase: DatosPrincipalesProcesoVO.java
 * Nombre de paquete: mx.com.bbva.bancomer.bussinnes.model.vo
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.util.Date;
import java.util.List;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

// TODO: Auto-generated Javadoc
/**
 * The Class DatosPrincipalesProcesoVO.
 */
public class DatosPrincipalesProcesoVO extends BbvaAbstractValueObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3600666394155627405L;

	/** The fecha lote. */
	private Date fechaLote;
	
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
	
	/** The nombre canal. */
	private String nombreCanal;
	
	/** The nombre estatus mapeador. */
	private String nombreEstatusMapeador;
	
	/** The nombre producto. */
	private String nombreProducto;
	
	/** The numero lote. */
	private long numeroLote;
	
	/** The registro porceso v os. */
	private List<RegistroProcesoVO> registroPorcesoVOs;
	
	/**
	 * Instantiates a new datos principales proceso vo.
	 */
	public DatosPrincipalesProcesoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new datos principales proceso vo.
	 *
	 * @param idCanal the id canal
	 * @param nombreCanal the nombre canal
	 * @param idCliente the id cliente
	 * @param idIdentificador the id identificador
	 * @param idProducto the id producto
	 * @param nombreProducto the nombre producto
	 * @param idEstatusMapeador the id estatus mapeador
	 * @param nombreEstatusMapeador the nombre estatus mapeador
	 * @param fechaLote the fecha lote
	 * @param numeroLote the numero lote
	 * @param registroPorcesoVOs the registro porceso v os
	 */
	public DatosPrincipalesProcesoVO(long idCanal, String nombreCanal,
			long idCliente, String idIdentificador, long idProducto,
			String nombreProducto, long idEstatusMapeador,
			String nombreEstatusMapeador, Date fechaLote, long numeroLote,
			List<RegistroProcesoVO> registroPorcesoVOs) {
		super();
		this.idCanal = idCanal;
		this.nombreCanal = nombreCanal;
		this.idCliente = idCliente;
		this.idIdentificador = idIdentificador;
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.idEstatusMapeador = idEstatusMapeador;
		this.nombreEstatusMapeador = nombreEstatusMapeador;
		this.fechaLote = fechaLote;
		this.numeroLote = numeroLote;
		this.registroPorcesoVOs = registroPorcesoVOs;
	}
	
	/**
	 * Gets the fecha lote.
	 *
	 * @return the fechaLote
	 */
	public Date getFechaLote() {
		return fechaLote;
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
	 * Gets the numero lote.
	 *
	 * @return the numeroLote
	 */
	public long getNumeroLote() {
		return numeroLote;
	}
	
	/**
	 * Gets the registro porceso v os.
	 *
	 * @return the registroPorcesoVOs
	 */
	public List<RegistroProcesoVO> getRegistroPorcesoVOs() {
		return registroPorcesoVOs;
	}
	
	/**
	 * Sets the fecha lote.
	 *
	 * @param fechaLote the fechaLote to set
	 */
	public void setFechaLote(Date fechaLote) {
		this.fechaLote = fechaLote;
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
	
	/**
	 * Sets the numero lote.
	 *
	 * @param numeroLote the numeroLote to set
	 */
	public void setNumeroLote(long numeroLote) {
		this.numeroLote = numeroLote;
	}
	
	/**
	 * Sets the registro porceso v os.
	 *
	 * @param registroPorcesoVOs the registroPorcesoVOs to set
	 */
	public void setRegistroPorcesoVOs(List<RegistroProcesoVO> registroPorcesoVOs) {
		this.registroPorcesoVOs = registroPorcesoVOs;
	}
	
}
