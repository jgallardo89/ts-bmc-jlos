package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.util.Date;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

public class ProductoVO extends BbvaAbstractValueObject  {

	private static final long serialVersionUID = 2430567530623634920L;
	private int idProducto;
	private int idFlujo;
	private String nombreProducto;
	private String descripcionProducto;
	private Date fechaAlta;
	private Date fechaModificacion;
	private int idEstatusObjeto;
	private String nombreEstatusObjeto;
	private String nombreFlujo;
	private int idBaja;
	/**
	 * @return the idProducto
	 */
	public int getIdProducto() {
		return idProducto;
	}
	/**
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
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
	 * @return the nombreProducto
	 */
	public String getNombreProducto() {
		return nombreProducto;
	}
	/**
	 * @param nombreProducto the nombreProducto to set
	 */
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	/**
	 * @return the descripcionProducto
	 */
	public String getDescripcionProducto() {
		return descripcionProducto;
	}
	/**
	 * @param descripcionProducto the descripcionProducto to set
	 */
	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
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
	
}

