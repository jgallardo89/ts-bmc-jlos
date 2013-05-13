package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.util.Date;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

public class BitacoraArchivoVO extends BbvaAbstractValueObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7756929105459324889L;
	public long idBitacora;
	public long idUsuario;
	public String nombreBitacora;
	public String descripcionBitacora;
	public Date horaBitacora;
	public Date fechaBitacora;
	public long idEventoMapeador;
	public String nombreEventoMapeador;
	private String fechaInicio;
	private String fechaFin;
	/**
	 * 
	 */
	public BitacoraArchivoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param idBitacora
	 * @param idUsuario
	 * @param nombreBitacora
	 * @param descripcionBitacora
	 * @param horaBitacora
	 * @param fechaBitacora
	 * @param idEventoMapeador
	 * @param nombreEventoMapeador
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public BitacoraArchivoVO(long idBitacora, long idUsuario,
			String nombreBitacora, String descripcionBitacora,
			Date horaBitacora, Date fechaBitacora, long idEventoMapeador,
			String nombreEventoMapeador, String fechaInicio, String fechaFin) {
		super();
		this.idBitacora = idBitacora;
		this.idUsuario = idUsuario;
		this.nombreBitacora = nombreBitacora;
		this.descripcionBitacora = descripcionBitacora;
		this.horaBitacora = horaBitacora;
		this.fechaBitacora = fechaBitacora;
		this.idEventoMapeador = idEventoMapeador;
		this.nombreEventoMapeador = nombreEventoMapeador;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	/**
	 * @return the idBitacora
	 */
	public long getIdBitacora() {
		return idBitacora;
	}
	/**
	 * @param idBitacora the idBitacora to set
	 */
	public void setIdBitacora(long idBitacora) {
		this.idBitacora = idBitacora;
	}
	/**
	 * @return the idUsuario
	 */
	public long getIdUsuario() {
		return idUsuario;
	}
	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(long idUsuario) {
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
	 * @return the idEventoMapeador
	 */
	public long getIdEventoMapeador() {
		return idEventoMapeador;
	}
	/**
	 * @param idEventoMapeador the idEventoMapeador to set
	 */
	public void setIdEventoMapeador(long idEventoMapeador) {
		this.idEventoMapeador = idEventoMapeador;
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
		return fechaInicio;
	}
	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	/**
	 * @return the fechaFin
	 */
	public String getFechaFin() {
		return fechaFin;
	}
	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
}
