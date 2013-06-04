package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

/**
 * @author Julio Morales
 *
 */
public class BitacoraVO extends BbvaAbstractValueObject {

	private static final long serialVersionUID = 8324523900377713166L;
	private int idBitacora;
	private int idUsuario;
	private String nombreUsuario;
	private String nombreBitacora;
	private String descripcionBitacora;
	private Date horaBitacora;
	private Date fechaBitacora;
	private int idEventoMapeador;
	private String nombreEventoMapeador;
	private Date fechaInicio;
	private Date fechaFin;
	private String descripcionBitacoraWeb;
	
	/**
	 * @return the idBitacora
	 */
	public int getIdBitacora() {
		return idBitacora;
	}
	/**
	 * @param idBitacora the idBitacora to set
	 */
	public void setIdBitacora(int idBitacora) {
		this.idBitacora = idBitacora;
	}
	/**
	 * @return the idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}
	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * @return the nombreBitacora
	 */
	public String getNombreBitacora() {
		return nombreBitacora;
	}
	/**
	 * @param nombreBitacora the nombreBitacora to set
	 */
	public void setNombreBitacora(String nombreBitacora) {
		this.nombreBitacora = nombreBitacora;
	}
	
	/**
	 * @return the descripcionBitacora
	 */
	public String getDescripcionBitacora() {
		return descripcionBitacora;
	}
	/**
	 * @param descripcionBitacora the descripcionBitacora to set
	 */
	public void setDescripcionBitacora(String descripcionBitacora) {
		this.descripcionBitacora = descripcionBitacora;
	}
	/**
	 * @return the idEventoMapeador
	 */
	public int getIdEventoMapeador() {
		return idEventoMapeador;
	}
	/**
	 * @param idEventoMapeador the idEventoMapeador to set
	 */
	public void setIdEventoMapeador(int idEventoMapeador) {
		this.idEventoMapeador = idEventoMapeador;
	}
	/**
	 * @return the horaBitacora
	 */
	public Date getHoraBitacora() {
		return horaBitacora;
	}
	/**
	 * @param horaBitacora the horaBitacora to set
	 */
	public void setHoraBitacora(Date horaBitacora) {
		this.horaBitacora = horaBitacora;
	}
	/**
	 * @return the fechaBitacora
	 */
	public Date getFechaBitacora() {
		return fechaBitacora;
	}
	/**
	 * @param fechaBitacora the fechaBitacora to set
	 */
	public void setFechaBitacora(Date fechaBitacora) {
		this.fechaBitacora = fechaBitacora;
	}
	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	/**
	 * @return the nombreEventoMapeador
	 */
	public String getNombreEventoMapeador() {
		return nombreEventoMapeador;
	}
	/**
	 * @param nombreEventoMapeador the nombreEventoMapeador to set
	 */
	public void setNombreEventoMapeador(String nombreEventoMapeador) {
		this.nombreEventoMapeador = nombreEventoMapeador;
	}
	/**
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
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	/**
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
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	/**
	 * @return the descripcionBitacoraWeb
	 */
	public String getDescripcionBitacoraWeb() {
		this.descripcionBitacoraWeb = nombreEventoMapeador +" - "+ nombreBitacora;
		return descripcionBitacoraWeb;
	}
	/**
	 * @param descripcionBitacoraWeb the descripcionBitacoraWeb to set
	 */
	public void setDescripcionBitacoraWeb(String descripcionBitacoraWeb) {
		this.descripcionBitacoraWeb = descripcionBitacoraWeb;
	}
	
}
