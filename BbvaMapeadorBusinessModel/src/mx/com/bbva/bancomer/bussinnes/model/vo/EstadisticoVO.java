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
 * Nombre de clase: EstadisticoVO.java
 * Nombre de paquete: mx.com.bbva.bancomer.bussinnes.model.vo
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.util.Date;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticoVO.
 */
public class EstadisticoVO  extends BbvaAbstractValueObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3633362440139077011L;
	
	/** The fecha fin. */
	private String fechaFin;
	
	/** The fecha inicio. */
	private String fechaInicio;
	
	/** The fecha status proceso. */
	public Date fechaStatusProceso;
	
	/** The id canal. */
	public long idCanal;
	
	/** The id cliente. */
	public long idCliente;
	
	/** The id identificador. */
	public String idIdentificador;
	
	/** The id producto. */
	public long idProducto;
	
	/** The id reg arch entra. */
	public long idRegArchEntra;
	
	/** The nombre canal. */
	public String nombreCanal;
	
	/** The nombre producto. */
	public String nombreProducto;
	
	/** The nombre reg arch entra. */
	public String nombreRegArchEntra;
	
	/** The numero operacione. */
	public long numeroOperacione;
	
	/**
	 * Instantiates a new estadistico vo.
	 */
	public EstadisticoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new estadistico vo.
	 *
	 * @param idCanal the id canal
	 * @param nombreCanal the nombre canal
	 * @param idCliente the id cliente
	 * @param idIdentificador the id identificador
	 * @param idProducto the id producto
	 * @param nombreProducto the nombre producto
	 * @param idRegArchEntra the id reg arch entra
	 * @param nombreRegArchEntra the nombre reg arch entra
	 * @param numeroOperacione the numero operacione
	 * @param fechaStatusProceso the fecha status proceso
	 * @param fechaInicio the fecha inicio
	 * @param fechaFin the fecha fin
	 */
	public EstadisticoVO(long idCanal, String nombreCanal, long idCliente,
			String idIdentificador, long idProducto, String nombreProducto,
			long idRegArchEntra, String nombreRegArchEntra,
			long numeroOperacione, Date fechaStatusProceso, String fechaInicio,
			String fechaFin) {
		super();
		this.idCanal = idCanal;
		this.nombreCanal = nombreCanal;
		this.idCliente = idCliente;
		this.idIdentificador = idIdentificador;
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.idRegArchEntra = idRegArchEntra;
		this.nombreRegArchEntra = nombreRegArchEntra;
		this.numeroOperacione = numeroOperacione;
		this.fechaStatusProceso = fechaStatusProceso;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	/**
	 * Gets the fecha fin.
	 *
	 * @return the fechaFin
	 */
	public String getFechaFin() {
		return fechaFin;
	}
	
	/**
	 * Gets the fecha inicio.
	 *
	 * @return the fechaInicio
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}
	
	/**
	 * Gets the fecha status proceso.
	 *
	 * @return the fechaStatusProceso
	 */
	public Date getFechaStatusProceso() {
		return fechaStatusProceso;
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
	 * Gets the id reg arch entra.
	 *
	 * @return the idRegArchEntra
	 */
	public long getIdRegArchEntra() {
		return idRegArchEntra;
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
	 * Gets the nombre producto.
	 *
	 * @return the nombreProducto
	 */
	public String getNombreProducto() {
		return nombreProducto;
	}
	
	/**
	 * Gets the nombre reg arch entra.
	 *
	 * @return the nombreRegArchEntra
	 */
	public String getNombreRegArchEntra() {
		return nombreRegArchEntra;
	}
	
	/**
	 * Gets the numero operacione.
	 *
	 * @return the numeroOperacione
	 */
	public long getNumeroOperacione() {
		return numeroOperacione;
	}
	
	/**
	 * Sets the fecha fin.
	 *
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	/**
	 * Sets the fecha inicio.
	 *
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	/**
	 * Sets the fecha status proceso.
	 *
	 * @param fechaStatusProceso the fechaStatusProceso to set
	 */
	public void setFechaStatusProceso(Date fechaStatusProceso) {
		this.fechaStatusProceso = fechaStatusProceso;
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
	 * Sets the id reg arch entra.
	 *
	 * @param idRegArchEntra the idRegArchEntra to set
	 */
	public void setIdRegArchEntra(long idRegArchEntra) {
		this.idRegArchEntra = idRegArchEntra;
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
	 * Sets the nombre producto.
	 *
	 * @param nombreProducto the nombreProducto to set
	 */
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	
	/**
	 * Sets the nombre reg arch entra.
	 *
	 * @param nombreRegArchEntra the nombreRegArchEntra to set
	 */
	public void setNombreRegArchEntra(String nombreRegArchEntra) {
		this.nombreRegArchEntra = nombreRegArchEntra;
	}
	
	/**
	 * Sets the numero operacione.
	 *
	 * @param numeroOperacione the numeroOperacione to set
	 */
	public void setNumeroOperacione(long numeroOperacione) {
		this.numeroOperacione = numeroOperacione;
	}
		
}
