package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.util.Date;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

public class EstadisticoVO  extends BbvaAbstractValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3633362440139077011L;
	public long idCanal;
	public String nombreCanal;
	public long idCliente;
	public String idIdentificador;
	public long idProducto;
	public String nombreProducto;
	public long idRegArchEntra;
	public String nombreRegArchEntra;
	public long numeroOperacione;
	public Date fechaStatusProceso;
	private String fechaInicio;
	private String fechaFin;
	/**
	 * 
	 */
	public EstadisticoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param idCanal
	 * @param nombreCanal
	 * @param idCliente
	 * @param idIdentificador
	 * @param idProducto
	 * @param nombreProducto
	 * @param idRegArchEntra
	 * @param nombreRegArchEntra
	 * @param numeroOperacione
	 * @param fechaStatusProceso
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public EstadisticoVO(long idCanal, String nombreCanal, long idCliente,
			String idIdentificador, long idProducto, String nombreProducto,
			long idRegArchEntra, String nombreRegArchEntra,
			long numeroOperacione, Date fechaStatusProceso, String fechaInicio,
			String fechaFin) {
		super();
		this.idCanal = idCanal;
		this.nombreCanal = nombreCanal;
		this.idCliente = idCliente;
		this.idIdentificador = idIdentificador;
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.idRegArchEntra = idRegArchEntra;
		this.nombreRegArchEntra = nombreRegArchEntra;
		this.numeroOperacione = numeroOperacione;
		this.fechaStatusProceso = fechaStatusProceso;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	/**
	 * @return the idCanal
	 */
	public long getIdCanal() {
		return idCanal;
	}
	/**
	 * @param idCanal the idCanal to set
	 */
	public void setIdCanal(long idCanal) {
		this.idCanal = idCanal;
	}
	/**
	 * @return the nombreCanal
	 */
	public String getNombreCanal() {
		return nombreCanal;
	}
	/**
	 * @param nombreCanal the nombreCanal to set
	 */
	public void setNombreCanal(String nombreCanal) {
		this.nombreCanal = nombreCanal;
	}
	/**
	 * @return the idCliente
	 */
	public long getIdCliente() {
		return idCliente;
	}
	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	/**
	 * @return the idIdentificador
	 */
	public String getIdIdentificador() {
		return idIdentificador;
	}
	/**
	 * @param idIdentificador the idIdentificador to set
	 */
	public void setIdIdentificador(String idIdentificador) {
		this.idIdentificador = idIdentificador;
	}
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
