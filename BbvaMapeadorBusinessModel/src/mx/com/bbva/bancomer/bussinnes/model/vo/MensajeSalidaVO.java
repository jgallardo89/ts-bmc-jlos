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
 * Nombre de clase: MensajeSalidaVO.java
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
 * The Class MensajeSalidaVO.
 *
 * @author Julio Morales
 */
public class MensajeSalidaVO extends BbvaAbstractValueObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5486816589925844320L;
	
	/** The descripcion asunto salida. */
	private String descripcionAsuntoSalida;
	
	/** The descripcion mensaje salida. */
	private String descripcionMensajeSalida;
	
	/** The fecha alta. */
	private Date fechaAlta;
	
	/** The fecha modificacion. */
	private Date fechaModificacion;
	
	/** The id baja. */
	private int idBaja;
	
	/** The id estatus objeto. */
	private int idEstatusObjeto;
	
	/** The id mensaje salida. */
	private int idMensajeSalida;
	
	/** The mail usuario. */
	private String mailUsuario;
	
	/** The nombre estatus objeto. */
	private String nombreEstatusObjeto;
	
	/** The nombre mensaje salida. */
	private String nombreMensajeSalida;
	
	/** The nombre usuario. */
	private String nombreUsuario;
	
	/** The num mensaje. */
	private int numMensaje;
	
	/** The tipo notificacion. */
	private String tipoNotificacion;
	
	/**
	 * Gets the descripcion asunto salida.
	 *
	 * @return the descripcionAsuntoSalida
	 */
	public final String getDescripcionAsuntoSalida() {
		return descripcionAsuntoSalida;
	}
	
	/**
	 * Gets the descripcion mensaje salida.
	 *
	 * @return the descripcionMensajeSalida
	 */
	public String getDescripcionMensajeSalida() {
		return descripcionMensajeSalida;
	}
	
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
	 * Gets the id estatus objeto.
	 *
	 * @return the idEstatusObjeto
	 */
	public int getIdEstatusObjeto() {
		return idEstatusObjeto;
	}
	
	/**
	 * Gets the id mensaje salida.
	 *
	 * @return the idMensajeSalida
	 */
	public int getIdMensajeSalida() {
		return idMensajeSalida;
	}
	
	/**
	 * Gets the mail usuario.
	 *
	 * @return the mailUsuario
	 */
	public final String getMailUsuario() {
		return mailUsuario;
	}
	
	/**
	 * Gets the nombre estatus objeto.
	 *
	 * @return the nombreEstatusObjeto
	 */
	public String getNombreEstatusObjeto() {
		return nombreEstatusObjeto;
	}
	
	/**
	 * Gets the nombre mensaje salida.
	 *
	 * @return the nombreMensajeSalida
	 */
	public String getNombreMensajeSalida() {
		return nombreMensajeSalida;
	}
	
	/**
	 * Gets the nombre usuario.
	 *
	 * @return the nombreUsuario
	 */
	public final String getNombreUsuario() {
		return nombreUsuario;
	}
	
	/**
	 * Gets the num mensaje.
	 *
	 * @return the numMensaje
	 */
	public int getNumMensaje() {
		return numMensaje;
	}
	
	/**
	 * Gets the tipo notificacion.
	 *
	 * @return the tipoNotificacion
	 */
	public String getTipoNotificacion() {
		return tipoNotificacion;
	}
	
	/**
	 * Sets the descripcion asunto salida.
	 *
	 * @param descripcionAsuntoSalida the descripcionAsuntoSalida to set
	 */
	public final void setDescripcionAsuntoSalida(String descripcionAsuntoSalida) {
		this.descripcionAsuntoSalida = descripcionAsuntoSalida;
	}
	
	/**
	 * Sets the descripcion mensaje salida.
	 *
	 * @param descripcionMensajeSalida the descripcionMensajeSalida to set
	 */
	public void setDescripcionMensajeSalida(String descripcionMensajeSalida) {
		this.descripcionMensajeSalida = descripcionMensajeSalida;
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
	 * Sets the id estatus objeto.
	 *
	 * @param idEstatusObjeto the idEstatusObjeto to set
	 */
	public void setIdEstatusObjeto(int idEstatusObjeto) {
		this.idEstatusObjeto = idEstatusObjeto;
	}
	
	/**
	 * Sets the id mensaje salida.
	 *
	 * @param idMensajeSalida the idMensajeSalida to set
	 */
	public void setIdMensajeSalida(int idMensajeSalida) {
		this.idMensajeSalida = idMensajeSalida;
	}
	
	/**
	 * Sets the mail usuario.
	 *
	 * @param mailUsuario the mailUsuario to set
	 */
	public final void setMailUsuario(String mailUsuario) {
		this.mailUsuario = mailUsuario;
	}
	
	/**
	 * Sets the nombre estatus objeto.
	 *
	 * @param nombreEstatusObjeto the nombreEstatusObjeto to set
	 */
	public void setNombreEstatusObjeto(String nombreEstatusObjeto) {
		this.nombreEstatusObjeto = nombreEstatusObjeto;
	}
	
	/**
	 * Sets the nombre mensaje salida.
	 *
	 * @param nombreMensajeSalida the nombreMensajeSalida to set
	 */
	public void setNombreMensajeSalida(String nombreMensajeSalida) {
		this.nombreMensajeSalida = nombreMensajeSalida;
	}
	
	/**
	 * Sets the nombre usuario.
	 *
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public final void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	/**
	 * Sets the num mensaje.
	 *
	 * @param numMensaje the numMensaje to set
	 */
	public void setNumMensaje(int numMensaje) {
		this.numMensaje = numMensaje;
	}
	
	/**
	 * Sets the tipo notificacion.
	 *
	 * @param tipoNotificacion the tipoNotificacion to set
	 */
	public void setTipoNotificacion(String tipoNotificacion) {
		this.tipoNotificacion = tipoNotificacion;
	}
}
