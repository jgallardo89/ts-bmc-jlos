package mx.com.bbva.mapeador.ui.commons.viewmodel.estadistico;

import java.util.Date;

public class ProductoVO {
	public long idProducto;
	public String nombreProducto;
	public long idRegArchEntra;
	public String nombreRegArchEntra;
	public long numeroOperacione;
	public Date fechaStatusProceso;
	private String fechaInicio;
	private String fechaFin;
	/**
	 * @return the idProducto
	 */
	public long getIdProducto() {
		return idProducto;
	}
	/**
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
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
	 * @return the idRegArchEntra
	 */
	public long getIdRegArchEntra() {
		return idRegArchEntra;
	}
	/**
	 * @param idRegArchEntra the idRegArchEntra to set
	 */
	public void setIdRegArchEntra(long idRegArchEntra) {
		this.idRegArchEntra = idRegArchEntra;
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
	 * @return the numeroOperacione
	 */
	public long getNumeroOperacione() {
		return numeroOperacione;
	}
	/**
	 * @param numeroOperacione the numeroOperacione to set
	 */
	public void setNumeroOperacione(long numeroOperacione) {
		this.numeroOperacione = numeroOperacione;
	}
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
