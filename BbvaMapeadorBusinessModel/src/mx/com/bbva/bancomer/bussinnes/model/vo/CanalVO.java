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
 * Nombre de clase: CanalVO.java
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
 * The Class CanalVO.
 */
public class CanalVO extends BbvaAbstractValueObject  {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7463449300240248623L;
	
	/** The descripcion canal. */
	private String descripcionCanal;
	
	/** The fecha alta. */
	private Date fechaAlta;
	
	/** The fecha fin. */
	private String fechaFin;
	
	/** The fecha inicio. */
	private String fechaInicio;
	
	/** The id baja. */
	private int idBaja;
	
	/** The id canal. */
	private int idCanal;
	
	/** The id estatus objeto. */
	private int idEstatusObjeto;
	
	/** The nombre canal. */
	private String nombreCanal;
	
	/** The nombre estatus objeto. */
	private String nombreEstatusObjeto;
	
	/** The ruta canal entrada. */
	private String rutaCanalEntrada;
	
	/** The ruta canal salida. */
	private String rutaCanalSalida;
	
	/**
	 * Gets the descripcion canal.
	 *
	 * @return the descripcionCanal
	 */
	public String getDescripcionCanal() {
		return descripcionCanal;
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
	 * Gets the id estatus objeto.
	 *
	 * @return the idEstatusObjeto
	 */
	public int getIdEstatusObjeto() {
		return idEstatusObjeto;
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
	 * Gets the nombre estatus objeto.
	 *
	 * @return the nombreEstatusObjeto
	 */
	public String getNombreEstatusObjeto() {
		return nombreEstatusObjeto;
	}
	
	/**
	 * Gets the ruta canal entrada.
	 *
	 * @return the rutaCanalEntrada
	 */
	public String getRutaCanalEntrada() {
		return rutaCanalEntrada;
	}
	
	/**
	 * Gets the ruta canal salida.
	 *
	 * @return the rutaCanalSalida
	 */
	public String getRutaCanalSalida() {
		return rutaCanalSalida;
	}
	
	/**
	 * Sets the descripcion canal.
	 *
	 * @param descripcionCanal the descripcionCanal to set
	 */
	public void setDescripcionCanal(String descripcionCanal) {
		this.descripcionCanal = descripcionCanal;
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
	 * Sets the id estatus objeto.
	 *
	 * @param idEstatusObjeto the idEstatusObjeto to set
	 */
	public void setIdEstatusObjeto(int idEstatusObjeto) {
		this.idEstatusObjeto = idEstatusObjeto;
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
	 * Sets the nombre estatus objeto.
	 *
	 * @param nombreEstatusObjeto the nombreEstatusObjeto to set
	 */
	public void setNombreEstatusObjeto(String nombreEstatusObjeto) {
		this.nombreEstatusObjeto = nombreEstatusObjeto;
	}
	
	/**
	 * Sets the ruta canal entrada.
	 *
	 * @param rutaCanalEntrada the rutaCanalEntrada to set
	 */
	public void setRutaCanalEntrada(String rutaCanalEntrada) {
		this.rutaCanalEntrada = rutaCanalEntrada;
	}
	
	/**
	 * Sets the ruta canal salida.
	 *
	 * @param rutaCanalSalida the rutaCanalSalida to set
	 */
	public void setRutaCanalSalida(String rutaCanalSalida) {
		this.rutaCanalSalida = rutaCanalSalida;
	}
	
}
