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
 * Nombre de clase: ProductoVO.java
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
 * The Class ProductoVO.
 */
public class ProductoVO extends BbvaAbstractValueObject  {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2430567530623634920L;
	
	/** The descripcion flujo. */
	private String descripcionFlujo;
	
	/** The descripcion producto. */
	private String descripcionProducto;
	
	/** The fecha alta. */
	private Date fechaAlta;
	
	/** The fecha modificacion. */
	private Date fechaModificacion;
	
	/** The id baja. */
	private int idBaja;
	
	/** The id estatus objeto. */
	private int idEstatusObjeto;
	
	/** The id flujo. */
	private int idFlujo;
	
	/** The id producto. */
	private int idProducto;
	
	/** The nombre estatus objeto. */
	private String nombreEstatusObjeto;
	
	/** The nombre flujo. */
	private String nombreFlujo;
	
	/** The nombre producto. */
	private String nombreProducto;
	
	/**
	 * Gets the descripcion flujo.
	 *
	 * @return the descripcionFlujo
	 */
	public String getDescripcionFlujo() {
		return descripcionFlujo;
	}
	
	/**
	 * Gets the descripcion producto.
	 *
	 * @return the descripcionProducto
	 */
	public String getDescripcionProducto() {
		return descripcionProducto;
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
	 * Gets the nombre estatus objeto.
	 *
	 * @return the nombreEstatusObjeto
	 */
	public String getNombreEstatusObjeto() {
		return nombreEstatusObjeto;
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
	 * Gets the nombre producto.
	 *
	 * @return the nombreProducto
	 */
	public String getNombreProducto() {
		return nombreProducto;
	}
	
	/**
	 * Sets the descripcion flujo.
	 *
	 * @param descripcionFlujo the descripcionFlujo to set
	 */
	public void setDescripcionFlujo(String descripcionFlujo) {
		this.descripcionFlujo = descripcionFlujo;
	}
	
	/**
	 * Sets the descripcion producto.
	 *
	 * @param descripcionProducto the descripcionProducto to set
	 */
	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
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
	 * Sets the nombre estatus objeto.
	 *
	 * @param nombreEstatusObjeto the nombreEstatusObjeto to set
	 */
	public void setNombreEstatusObjeto(String nombreEstatusObjeto) {
		this.nombreEstatusObjeto = nombreEstatusObjeto;
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
	 * Sets the nombre producto.
	 *
	 * @param nombreProducto the nombreProducto to set
	 */
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	
}

