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
 * Nombre de clase: ContratacionVO.java
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
 * The Class ContratacionVO.
 */
public class ContratacionVO extends BbvaAbstractValueObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2931862790072174104L;
	
	/** The fecha alta. */
	private Date fechaAlta;
	
	/** The fecha modificacion. */
	private Date fechaModificacion;
	
	/** The id baja. */
	private int idBaja;
	
	/** The id canal. */
	private int idCanal;
	
	/** The id canal salida. */
	private int idCanalSalida;
	
	/** The id cliente. */
	private int idCliente;
	
	/** The id contratacion. */
	private int idContratacion;
	
	/** The id estatus objeto. */
	private int idEstatusObjeto;
	
	/** The id etapa. */
	private int idEtapa;
	
	/** The id flujo. */
	private int idFlujo;
	
	/** The id producto. */
	private int idProducto;
	
	/** The nombre canal. */
	private String nombreCanal;
	
	/** The nombre canal salida. */
	private String nombreCanalSalida;
	
	/** The nombre cliente. */
	private String nombreCliente;
	
	/** The nombre estatus objeto. */
	private String nombreEstatusObjeto;
	
	/** The nombre etapa. */
	private String nombreEtapa;
	
	/** The nombre producto. */
	private String nombreProducto;
	
	/** The numero orden etapa. */
	private int numeroOrdenEtapa;
	
	/** The num registros. */
	private int numRegistros;
	
	/**
	 * Gets the fecha alta.
	 *
	 * @return the fechaAlta
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}
	
	/**
	 * Gets the fecha modificacion.
	 *
	 * @return the fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	
	/**
	 * Gets the id baja.
	 *
	 * @return the idBaja
	 */
	public int getIdBaja() {
		return idBaja;
	}
	
	/**
	 * Gets the id canal.
	 *
	 * @return the idCanal
	 */
	public int getIdCanal() {
		return idCanal;
	}
	
	/**
	 * Gets the id canal salida.
	 *
	 * @return the idCanalSalida
	 */
	public int getIdCanalSalida() {
		return idCanalSalida;
	}
	
	/**
	 * Gets the id cliente.
	 *
	 * @return the idCliente
	 */
	public int getIdCliente() {
		return idCliente;
	}
	
	/**
	 * Gets the id contratacion.
	 *
	 * @return the idContratacion
	 */
	public int getIdContratacion() {
		return idContratacion;
	}
	
	/**
	 * Gets the id estatus objeto.
	 *
	 * @return the idEstatusObjeto
	 */
	public int getIdEstatusObjeto() {
		return idEstatusObjeto;
	}
	
	/**
	 * Gets the id etapa.
	 *
	 * @return the idEtapa
	 */
	public int getIdEtapa() {
		return idEtapa;
	}
	
	/**
	 * Gets the id flujo.
	 *
	 * @return the idFlujo
	 */
	public int getIdFlujo() {
		return idFlujo;
	}
	
	/**
	 * Gets the id producto.
	 *
	 * @return the idProducto
	 */
	public int getIdProducto() {
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
	 * Gets the nombre canal salida.
	 *
	 * @return the nombreCanalSalida
	 */
	public String getNombreCanalSalida() {
		return nombreCanalSalida;
	}
	
	/**
	 * Gets the nombre cliente.
	 *
	 * @return the nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}
	
	/**
	 * Gets the nombre estatus objeto.
	 *
	 * @return the nombreEstatusObjet
	 */
	public String getNombreEstatusObjeto() {
		return nombreEstatusObjeto;
	}
	
	/**
	 * Gets the nombre etapa.
	 *
	 * @return the nombreEtapa
	 */
	public String getNombreEtapa() {
		return nombreEtapa;
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
	 * Gets the numero orden etapa.
	 *
	 * @return the numeroOrdenEtapa
	 */
	public int getNumeroOrdenEtapa() {
		return numeroOrdenEtapa;
	}
	
	/**
	 * Gets the num registros.
	 *
	 * @return the numRegistros
	 */
	public int getNumRegistros() {
		return numRegistros;
	}
	
	/**
	 * Sets the fecha alta.
	 *
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	/**
	 * Sets the fecha modificacion.
	 *
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
	/**
	 * Sets the id baja.
	 *
	 * @param idBaja the idBaja to set
	 */
	public void setIdBaja(int idBaja) {
		this.idBaja = idBaja;
	}
	
	/**
	 * Sets the id canal.
	 *
	 * @param idCanal the idCanal to set
	 */
	public void setIdCanal(int idCanal) {
		this.idCanal = idCanal;
	}
	
	/**
	 * Sets the id canal salida.
	 *
	 * @param idCanalSalida the idCanalSalida to set
	 */
	public void setIdCanalSalida(int idCanalSalida) {
		this.idCanalSalida = idCanalSalida;
	}
	
	/**
	 * Sets the id cliente.
	 *
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	/**
	 * Sets the id contratacion.
	 *
	 * @param idContratacion the idContratacion to set
	 */
	public void setIdContratacion(int idContratacion) {
		this.idContratacion = idContratacion;
	}
	
	/**
	 * Sets the id estatus objeto.
	 *
	 * @param idEstatusObjeto the idEstatusObjeto to set
	 */
	public void setIdEstatusObjeto(int idEstatusObjeto) {
		this.idEstatusObjeto = idEstatusObjeto;
	}
	
	/**
	 * Sets the id etapa.
	 *
	 * @param idEtapa the idEtapa to set
	 */
	public void setIdEtapa(int idEtapa) {
		this.idEtapa = idEtapa;
	}
	
	/**
	 * Sets the id flujo.
	 *
	 * @param idFlujo the idFlujo to set
	 */
	public void setIdFlujo(int idFlujo) {
		this.idFlujo = idFlujo;
	}
	
	/**
	 * Sets the id producto.
	 *
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(int idProducto) {
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
	 * Sets the nombre canal salida.
	 *
	 * @param nombreCanalSalida the nombreCanalSalida to set
	 */
	public void setNombreCanalSalida(String nombreCanalSalida) {
		this.nombreCanalSalida = nombreCanalSalida;
	}
	
	/**
	 * Sets the nombre cliente.
	 *
	 * @param nombreCliente the nombreCliente to set
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	/**
	 * Sets the nombre estatus objeto.
	 *
	 * @param nombreEstatusObjeto the new nombre estatus objeto
	 */
	public void setNombreEstatusObjeto(String nombreEstatusObjeto) {
		this.nombreEstatusObjeto = nombreEstatusObjeto;
	}
	
	/**
	 * Sets the nombre etapa.
	 *
	 * @param nombreEtapa the nombreEtapa to set
	 */
	public void setNombreEtapa(String nombreEtapa) {
		this.nombreEtapa = nombreEtapa;
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
	 * Sets the numero orden etapa.
	 *
	 * @param numeroOrdenEtapa the numeroOrdenEtapa to set
	 */
	public void setNumeroOrdenEtapa(int numeroOrdenEtapa) {
		this.numeroOrdenEtapa = numeroOrdenEtapa;
	}
	
	/**
	 * Sets the num registros.
	 *
	 * @param numRegistros the numRegistros to set
	 */
	public void setNumRegistros(int numRegistros) {
		this.numRegistros = numRegistros;
	}
	
}
