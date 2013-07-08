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
 * Nombre de clase: ContratacionMapVO.java
 * Nombre de paquete: mx.com.bbva.bancomer.bussinnes.model.vo
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.bussinnes.model.vo;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

// TODO: Auto-generated Javadoc
/**
 * The Class ContratacionMapVO.
 */
public class ContratacionMapVO extends BbvaAbstractValueObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7647811562070567055L;
	
	/** The descripcion id usuarios. */
	private String descripcionIdUsuarios;
	
	/** The descripcion mapa gmm. */
	private String descripcionMapaGmm;
	
	/** The descripcion mensaje salida. */
	private String descripcionMensajeSalida;
	
	/** The estatus notificacion. */
	private Character estatusNotificacion;
	
	/** The id baja. */
	private int idBaja;
	
	/** The id contratacion. */
	private int idContratacion;
	
	/** The id etapa. */
	private int idEtapa;
	
	/** The id flujo. */
	private int idFlujo;
	
	/** The id mapa gmm. */
	private int idMapaGmm;
	
	/** The id mensaje salida. */
	private Integer idMensajeSalida;
	
	/** The nombre etapa. */
	private String nombreEtapa;
	
	/** The nombre flujo. */
	private String nombreFlujo;
	
	/** The nombre mapa gmm. */
	private String nombreMapaGmm;
	
	/** The nombre mensaje salida. */
	private String nombreMensajeSalida;
	
	/** The numero orden etapa. */
	private int numeroOrdenEtapa;
	
	/** The num mensaje. */
	private int numMensaje;
	
	private boolean valNotificacion;
	
	/**
	 * Gets the descripcion id usuarios.
	 *
	 * @return the descripcionIdUsuarios
	 */
	public String getDescripcionIdUsuarios() {
		return descripcionIdUsuarios;
	}
	
	/**
	 * Gets the descripcion mapa gmm.
	 *
	 * @return the descripcionMapaGmm
	 */
	public String getDescripcionMapaGmm() {
		return descripcionMapaGmm;
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
	 * Gets the estatus notificacion.
	 *
	 * @return the estatusNotificacion
	 */
	public Character getEstatusNotificacion() {
		return estatusNotificacion;
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
	 * Gets the id contratacion.
	 *
	 * @return the idContratacion
	 */
	public int getIdContratacion() {
		return idContratacion;
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
	 * Gets the id mapa gmm.
	 *
	 * @return the idMapaGmm
	 */
	public int getIdMapaGmm() {
		return idMapaGmm;
	}
	
	/**
	 * Gets the id mensaje salida.
	 *
	 * @return the idMensajeSalida
	 */
	public Integer getIdMensajeSalida() {
		return idMensajeSalida;
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
	 * Gets the nombre flujo.
	 *
	 * @return the nombreFlujo
	 */
	public String getNombreFlujo() {
		return nombreFlujo;
	}
	
	/**
	 * Gets the nombre mapa gmm.
	 *
	 * @return the nombreMapaGmm
	 */
	public String getNombreMapaGmm() {
		return nombreMapaGmm;
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
	 * Gets the numero orden etapa.
	 *
	 * @return the numeroOrdenEtapa
	 */
	public int getNumeroOrdenEtapa() {
		return numeroOrdenEtapa;
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
	 * Sets the descripcion id usuarios.
	 *
	 * @param descripcionIdUsuarios the descripcionIdUsuarios to set
	 */
	public void setDescripcionIdUsuarios(String descripcionIdUsuarios) {
		this.descripcionIdUsuarios = descripcionIdUsuarios;
	}
	
	/**
	 * Sets the descripcion mapa gmm.
	 *
	 * @param descripcionMapaGmm the descripcionMapaGmm to set
	 */
	public void setDescripcionMapaGmm(String descripcionMapaGmm) {
		this.descripcionMapaGmm = descripcionMapaGmm;
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
	 * Sets the estatus notificacion.
	 *
	 * @param estatusNotificacion the estatusNotificacion to set
	 */
	public void setEstatusNotificacion(Character estatusNotificacion) {
		this.estatusNotificacion = estatusNotificacion;
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
	 * Sets the id contratacion.
	 *
	 * @param idContratacion the idContratacion to set
	 */
	public void setIdContratacion(int idContratacion) {
		this.idContratacion = idContratacion;
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
	 * Sets the id mapa gmm.
	 *
	 * @param idMapaGmm the idMapaGmm to set
	 */
	public void setIdMapaGmm(int idMapaGmm) {
		this.idMapaGmm = idMapaGmm;
	}
	
	/**
	 * Sets the id mensaje salida.
	 *
	 * @param idMensajeSalida the idMensajeSalida to set
	 */
	public void setIdMensajeSalida(Integer idMensajeSalida) {
		this.idMensajeSalida = idMensajeSalida;
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
	 * Sets the nombre flujo.
	 *
	 * @param nombreFlujo the nombreFlujo to set
	 */
	public void setNombreFlujo(String nombreFlujo) {
		this.nombreFlujo = nombreFlujo;
	}
	
	/**
	 * Sets the nombre mapa gmm.
	 *
	 * @param nombreMapaGmm the nombreMapaGmm to set
	 */
	public void setNombreMapaGmm(String nombreMapaGmm) {
		this.nombreMapaGmm = nombreMapaGmm;
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
	 * Sets the numero orden etapa.
	 *
	 * @param numeroOrdenEtapa the numeroOrdenEtapa to set
	 */
	public void setNumeroOrdenEtapa(int numeroOrdenEtapa) {
		this.numeroOrdenEtapa = numeroOrdenEtapa;
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
	 * @return the valNotificacion
	 */
	public boolean getValNotificacion() {
		return valNotificacion;
	}

	/**
	 * @param valNotificacion the valNotificacion to set
	 */
	public void setValNotificacion(boolean valNotificacion) {
		this.valNotificacion = valNotificacion;
	}
}
