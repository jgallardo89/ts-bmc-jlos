package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.util.Date;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

/**
 * @author Julio Morales
 */
public class FlujoVO extends BbvaAbstractValueObject {

	private static final long serialVersionUID = 1403592109860998251L;
	private int idFlujo;
	private String nombreFlujo;
	private String descripcionFlujo;
	private String descripcionUrlImagen;
	private Date fechaAlta;
	private Date fechaModificacion;
	private int idEstatusObjeto;
	private String nombreEstatusObjeto;
	private String descripcionEtapa;
	private String descripcionCmbflujos;
	private int idBaja;
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
	 * @return the descripcionFlujo
	 */
	public String getDescripcionFlujo() {
		return descripcionFlujo;
	}
	/**
	 * @param descripcionFlujo the descripcionFlujo to set
	 */
	public void setDescripcionFlujo(String descripcionFlujo) {
		this.descripcionFlujo = descripcionFlujo;
	}
	/**
	 * @return the descripcionUrlImagen
	 */
	public String getDescripcionUrlImagen() {
		return descripcionUrlImagen;
	}
	/**
	 * @param descripcionUrlImagen the descripcionUrlImagen to set
	 */
	public void setDescripcionUrlImagen(String descripcionUrlImagen) {
		this.descripcionUrlImagen = descripcionUrlImagen;
	}
	/**
	 * @return the fechaAlta
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}
	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	/**
	 * @return the idEstatusObjeto
	 */
	public int getIdEstatusObjeto() {
		return idEstatusObjeto;
	}
	/**
	 * @param idEstatusObjeto the idEstatusObjeto to set
	 */
	public void setIdEstatusObjeto(int idEstatusObjeto) {
		this.idEstatusObjeto = idEstatusObjeto;
	}
	/**
	 * @return the nombreEstatusObjeto
	 */
	public String getNombreEstatusObjeto() {
		return nombreEstatusObjeto;
	}
	/**
	 * @param nombreEstatusObjeto the nombreEstatusObjeto to set
	 */
	public void setNombreEstatusObjeto(String nombreEstatusObjeto) {
		this.nombreEstatusObjeto = nombreEstatusObjeto;
	}
	/**
	 * @return the descripcionEtapa
	 */
	public String getDescripcionEtapa() {
		return descripcionEtapa;
	}
	/**
	 * @param descripcionEtapa the descripcionEtapa to set
	 */
	public void setDescripcionEtapa(String descripcionEtapa) {
		this.descripcionEtapa = descripcionEtapa;
	}
	/**
	 * @return the fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	/**
	 * @return the idBaja
	 */
	public int getIdBaja() {
		return idBaja;
	}
	/**
	 * @param idBaja the idBaja to set
	 */
	public void setIdBaja(int idBaja) {
		this.idBaja = idBaja;
	}
	/**
	 * @return the descripcionCmbflujos
	 */
	public String getDescripcionCmbflujos() {
		descripcionCmbflujos = nombreFlujo +" - "+ descripcionFlujo;
		return descripcionCmbflujos;
	}
	/**
	 * @param descripcionCmbflujos the descripcionCmbflujos to set
	 */
	public void setDescripcionCmbflujos(String descripcionCmbflujos) {
		this.descripcionCmbflujos = descripcionCmbflujos;
	}
	
}
