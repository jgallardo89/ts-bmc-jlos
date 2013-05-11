package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.sql.Clob;
import java.util.Date;

import oracle.sql.CLOB;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

/**
 * @author Julio Morales
 *
 */
public class BitacoraVO extends BbvaAbstractValueObject {

	private static final long serialVersionUID = 8324523900377713166L;
	private int idBitacora;
	private int idUsuario;
	private String nombreBitacora;
	private Clob descripcionBitacora;
	private Date horaBitacora;
	private Date fechaBitacora;
	private int idEventoMapeador;
	private Date fechaInicio;
	private Date fechaFin;
	
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
	public Clob getDescripcionBitacora() {
		return descripcionBitacora;
	}
	/**
	 * @param descripcionBitacora the descripcionBitacora to set
	 */
	public void setDescripcionBitacora(Clob descripcionBitacora) {
		this.descripcionBitacora = descripcionBitacora;
	}
	/**
	 * @param descripcionBitacora the descripcionBitacora to set
	 */
	public void setDescripcionBitacora(CLOB descripcionBitacora) {
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
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
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
	public Date getFechaFin() {
		return fechaFin;
	}
	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
}
