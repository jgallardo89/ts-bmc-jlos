package mx.com.bbva.bancomer.estadistico.dto;

import java.io.Serializable;
import java.util.Date;

public class TercerNivelDTO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7851873603506588802L;

	/** The fecha status proceso. */
	public Date fechaStatusProceso;
	
	public String nombre;
	
	/** The nombre reg arch entra. */
	public String nombreRegArchEntra;
	
	/** The numero operaciones. */
	public long numeroOperaciones;

	/**
	 * @return the fechaStatusProceso
	 */
	public Date getFechaStatusProceso() {
		return fechaStatusProceso;
	}

	/**
	 * @param fechaStatusProceso the fechaStatusProceso to set
	 */
	public void setFechaStatusProceso(Date fechaStatusProceso) {
		this.fechaStatusProceso = fechaStatusProceso;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the nombreRegArchEntra
	 */
	public String getNombreRegArchEntra() {
		return nombreRegArchEntra;
	}

	/**
	 * @param nombreRegArchEntra the nombreRegArchEntra to set
	 */
	public void setNombreRegArchEntra(String nombreRegArchEntra) {
		this.nombreRegArchEntra = nombreRegArchEntra;
	}

	/**
	 * @return the numeroOperaciones
	 */
	public long getNumeroOperaciones() {
		return numeroOperaciones;
	}

	/**
	 * @param numeroOperaciones the numeroOperaciones to set
	 */
	public void setNumeroOperaciones(long numeroOperaciones) {
		this.numeroOperaciones = numeroOperaciones;
	}
	
}
