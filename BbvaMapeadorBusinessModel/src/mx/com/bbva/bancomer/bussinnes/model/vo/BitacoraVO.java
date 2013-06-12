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
 * Nombre de clase: BitacoraVO.java
 * Nombre de paquete: mx.com.bbva.bancomer.bussinnes.model.vo
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

// TODO: Auto-generated Javadoc
/**
 * The Class BitacoraVO.
 *
 * @author Julio Morales
 */
public class BitacoraVO extends BbvaAbstractValueObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8324523900377713166L;
	
	/** The descripcion bitacora. */
	private String descripcionBitacora;
	
	/** The descripcion bitacora web. */
	private String descripcionBitacoraWeb;
	
	/** The fecha bitacora. */
	private Date fechaBitacora;
	
	/** The fecha fin. */
	private Date fechaFin;
	
	/** The fecha inicio. */
	private Date fechaInicio;
	
	/** The hora bitacora. */
	private Date horaBitacora;
	
	/** The id bitacora. */
	private int idBitacora;
	
	/** The id evento mapeador. */
	private int idEventoMapeador;
	
	/** The id usuario. */
	private int idUsuario;
	
	/** The nombre bitacora. */
	private String nombreBitacora;
	
	/** The nombre evento mapeador. */
	private String nombreEventoMapeador;
	
	/** The nombre usuario. */
	private String nombreUsuario;
	
	/**
	 * Gets the descripcion bitacora.
	 *
	 * @return the descripcionBitacora
	 */
	public String getDescripcionBitacora() {
		return descripcionBitacora;
	}
	
	/**
	 * Gets the descripcion bitacora web.
	 *
	 * @return the descripcionBitacoraWeb
	 */
	public String getDescripcionBitacoraWeb() {
		this.descripcionBitacoraWeb = nombreEventoMapeador +" - "+ nombreBitacora;
		return descripcionBitacoraWeb;
	}
	
	/**
	 * Gets the fecha bitacora.
	 *
	 * @return the fechaBitacora
	 */
	public Date getFechaBitacora() {
		return fechaBitacora;
	}
	
	/**
	 * Gets the fecha fin.
	 *
	 * @return the fechaFin
	 */
	public String getFechaFin() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");				
		if(fechaFin!=null)
			return dateFormat.format(fechaFin);
		else
			return null;
	}
	
	/**
	 * Gets the fecha inicio.
	 *
	 * @return the fechaInicio
	 */
	public String getFechaInicio() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");				
		if(fechaInicio!=null)
			return dateFormat.format(fechaInicio);
		else
			return null;	
	}
	
	/**
	 * Gets the hora bitacora.
	 *
	 * @return the horaBitacora
	 */
	public Date getHoraBitacora() {
		return horaBitacora;
	}
	
	/**
	 * Gets the id bitacora.
	 *
	 * @return the idBitacora
	 */
	public int getIdBitacora() {
		return idBitacora;
	}
	
	/**
	 * Gets the id evento mapeador.
	 *
	 * @return the idEventoMapeador
	 */
	public int getIdEventoMapeador() {
		return idEventoMapeador;
	}
	
	/**
	 * Gets the id usuario.
	 *
	 * @return the idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}
	
	/**
	 * Gets the nombre bitacora.
	 *
	 * @return the nombreBitacora
	 */
	public String getNombreBitacora() {
		return nombreBitacora;
	}
	
	/**
	 * Gets the nombre evento mapeador.
	 *
	 * @return the nombreEventoMapeador
	 */
	public String getNombreEventoMapeador() {
		return nombreEventoMapeador;
	}
	
	/**
	 * Gets the nombre usuario.
	 *
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	/**
	 * Sets the descripcion bitacora.
	 *
	 * @param descripcionBitacora the descripcionBitacora to set
	 */
	public void setDescripcionBitacora(String descripcionBitacora) {
		this.descripcionBitacora = descripcionBitacora;
	}
	
	/**
	 * Sets the descripcion bitacora web.
	 *
	 * @param descripcionBitacoraWeb the descripcionBitacoraWeb to set
	 */
	public void setDescripcionBitacoraWeb(String descripcionBitacoraWeb) {
		this.descripcionBitacoraWeb = descripcionBitacoraWeb;
	}
	
	/**
	 * Sets the fecha bitacora.
	 *
	 * @param fechaBitacora the fechaBitacora to set
	 */
	public void setFechaBitacora(Date fechaBitacora) {
		this.fechaBitacora = fechaBitacora;
	}
	
	/**
	 * Sets the fecha fin.
	 *
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	/**
	 * Sets the fecha inicio.
	 *
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	/**
	 * Sets the hora bitacora.
	 *
	 * @param horaBitacora the horaBitacora to set
	 */
	public void setHoraBitacora(Date horaBitacora) {
		this.horaBitacora = horaBitacora;
	}
	
	/**
	 * Sets the id bitacora.
	 *
	 * @param idBitacora the idBitacora to set
	 */
	public void setIdBitacora(int idBitacora) {
		this.idBitacora = idBitacora;
	}
	
	/**
	 * Sets the id evento mapeador.
	 *
	 * @param idEventoMapeador the idEventoMapeador to set
	 */
	public void setIdEventoMapeador(int idEventoMapeador) {
		this.idEventoMapeador = idEventoMapeador;
	}
	
	/**
	 * Sets the id usuario.
	 *
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	/**
	 * Sets the nombre bitacora.
	 *
	 * @param nombreBitacora the nombreBitacora to set
	 */
	public void setNombreBitacora(String nombreBitacora) {
		this.nombreBitacora = nombreBitacora;
	}
	
	/**
	 * Sets the nombre evento mapeador.
	 *
	 * @param nombreEventoMapeador the nombreEventoMapeador to set
	 */
	public void setNombreEventoMapeador(String nombreEventoMapeador) {
		this.nombreEventoMapeador = nombreEventoMapeador;
	}
	
	/**
	 * Sets the nombre usuario.
	 *
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
}
