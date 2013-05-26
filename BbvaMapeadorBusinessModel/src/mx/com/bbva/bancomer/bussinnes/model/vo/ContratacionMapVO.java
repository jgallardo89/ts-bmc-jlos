package mx.com.bbva.bancomer.bussinnes.model.vo;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

public class ContratacionMapVO extends BbvaAbstractValueObject {

	private static final long serialVersionUID = -7647811562070567055L;
	private int idContratacion;
	private int idFlujo;
	private String nombreFlujo;
	private int numeroOrdenEtapa;
	private int idEtapa;
	private String nombreEtapa;
	private int idMapaGmm;
	private String nombreMapaGmm;
	private String descripcionMapaGmm;
	private Character estatusNotificacion;
	private Integer idMensajeSalida;
	private String nombreMensajeSalida;
	private String descripcionMensajeSalida;
	private String descripcionIdUsuarios;
	
	/**
	 * @return the idContratacion
	 */
	public int getIdContratacion() {
		return idContratacion;
	}
	/**
	 * @param idContratacion the idContratacion to set
	 */
	public void setIdContratacion(int idContratacion) {
		this.idContratacion = idContratacion;
	}
	/**
	 * @return the idFlujo
	 */
	public int getIdFlujo() {
		return idFlujo;
	}
	/**
	 * @param idFlujo the idFlujo to set
	 */
	public void setIdFlujo(int idFlujo) {
		this.idFlujo = idFlujo;
	}
	/**
	 * @return the idEtapa
	 */
	public int getIdEtapa() {
		return idEtapa;
	}
	/**
	 * @param idEtapa the idEtapa to set
	 */
	public void setIdEtapa(int idEtapa) {
		this.idEtapa = idEtapa;
	}
	/**
	 * @return the idMapaGmm
	 */
	public int getIdMapaGmm() {
		return idMapaGmm;
	}
	/**
	 * @param idMapaGmm the idMapaGmm to set
	 */
	public void setIdMapaGmm(int idMapaGmm) {
		this.idMapaGmm = idMapaGmm;
	}
	/**
	 * @return the estatusNotificacion
	 */
	public Character getEstatusNotificacion() {
		return estatusNotificacion;
	}
	/**
	 * @param estatusNotificacion the estatusNotificacion to set
	 */
	public void setEstatusNotificacion(Character estatusNotificacion) {
		this.estatusNotificacion = estatusNotificacion;
	}
	/**
	 * @return the idMensajeSalida
	 */
	public Integer getIdMensajeSalida() {
		return idMensajeSalida;
	}
	/**
	 * @param idMensajeSalida the idMensajeSalida to set
	 */
	public void setIdMensajeSalida(Integer idMensajeSalida) {
		this.idMensajeSalida = idMensajeSalida;
	}
	/**
	 * @return the descripcionIdUsuarios
	 */
	public String getDescripcionIdUsuarios() {
		return descripcionIdUsuarios;
	}
	/**
	 * @param descripcionIdUsuarios the descripcionIdUsuarios to set
	 */
	public void setDescripcionIdUsuarios(String descripcionIdUsuarios) {
		this.descripcionIdUsuarios = descripcionIdUsuarios;
	}
	/**
	 * @return the nombreFlujo
	 */
	public String getNombreFlujo() {
		return nombreFlujo;
	}
	/**
	 * @param nombreFlujo the nombreFlujo to set
	 */
	public void setNombreFlujo(String nombreFlujo) {
		this.nombreFlujo = nombreFlujo;
	}
	/**
	 * @return the numeroOrdenEtapa
	 */
	public int getNumeroOrdenEtapa() {
		return numeroOrdenEtapa;
	}
	/**
	 * @param numeroOrdenEtapa the numeroOrdenEtapa to set
	 */
	public void setNumeroOrdenEtapa(int numeroOrdenEtapa) {
		this.numeroOrdenEtapa = numeroOrdenEtapa;
	}
	/**
	 * @return the nombreEtapa
	 */
	public String getNombreEtapa() {
		return nombreEtapa;
	}
	/**
	 * @param nombreEtapa the nombreEtapa to set
	 */
	public void setNombreEtapa(String nombreEtapa) {
		this.nombreEtapa = nombreEtapa;
	}
	/**
	 * @return the nombreMapaGmm
	 */
	public String getNombreMapaGmm() {
		return nombreMapaGmm;
	}
	/**
	 * @param nombreMapaGmm the nombreMapaGmm to set
	 */
	public void setNombreMapaGmm(String nombreMapaGmm) {
		this.nombreMapaGmm = nombreMapaGmm;
	}
	/**
	 * @return the descripcionMapaGmm
	 */
	public String getDescripcionMapaGmm() {
		return descripcionMapaGmm;
	}
	/**
	 * @param descripcionMapaGmm the descripcionMapaGmm to set
	 */
	public void setDescripcionMapaGmm(String descripcionMapaGmm) {
		this.descripcionMapaGmm = descripcionMapaGmm;
	}
	/**
	 * @return the nombreMensajeSalida
	 */
	public String getNombreMensajeSalida() {
		return nombreMensajeSalida;
	}
	/**
	 * @param nombreMensajeSalida the nombreMensajeSalida to set
	 */
	public void setNombreMensajeSalida(String nombreMensajeSalida) {
		this.nombreMensajeSalida = nombreMensajeSalida;
	}
	/**
	 * @return the descripcionMensajeSalida
	 */
	public String getDescripcionMensajeSalida() {
		return descripcionMensajeSalida;
	}
	/**
	 * @param descripcionMensajeSalida the descripcionMensajeSalida to set
	 */
	public void setDescripcionMensajeSalida(String descripcionMensajeSalida) {
		this.descripcionMensajeSalida = descripcionMensajeSalida;
	}
	
}
