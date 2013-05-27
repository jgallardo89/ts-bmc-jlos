package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.util.Date; 

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;
public class RegistroProcesoVO extends BbvaAbstractValueObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9097673350468469013L;
	public long idContratacion;
	private long idCanal;
	private String nombreCanal;
	private long idCliente;
	private String idIdentificador;
	private long idProducto;
	private String nombreProducto;
	private long numeroLote;
	private Date fechaLote;
	private long idRegArchEntra;
	private String nombreRegArchEntra;
	private Date horaProcesoIni;
	private Date horaProcesoFin;
	private Date fechaStatusProceso;
	private long idFlujo;
	private String nombreFlujo;
	private long idEtapa;
	private String nombreEtapa;
	private long idEstatusMapeador;
	private String nombreEstatusMapeador;
	private String fechaInicio;
	private String fechaFin; 
	/**
	 * 
	 */
	public RegistroProcesoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param idContratacion
	 * @param idCanal
	 * @param nombreCanal
	 * @param idCliente
	 * @param idIdentificador
	 * @param idProducto
	 * @param nombreProducto
	 * @param numeroLote
	 * @param fechaLote
	 * @param idRegArchEntra
	 * @param nombreRegArchEntra
	 * @param horaProcesoIni
	 * @param horaProcesoFin
	 * @param fechaStatusProceso
	 * @param idFlujo
	 * @param nombreFlujo
	 * @param idEtapa
	 * @param nombreEtapa
	 * @param idEstatusMapeador
	 * @param nombreEstatusMapeador
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public RegistroProcesoVO(long idContratacion, long idCanal,
			String nombreCanal, long idCliente, String idIdentificador,
			long idProducto, String nombreProducto, long numeroLote,
			Date fechaLote, long idRegArchEntra, String nombreRegArchEntra,
			Date horaProcesoIni, Date horaProcesoFin, Date fechaStatusProceso,
			long idFlujo, String nombreFlujo, long idEtapa, String nombreEtapa,
			long idEstatusMapeador, String nombreEstatusMapeador,
			String fechaInicio, String fechaFin) {
		super();
		this.idContratacion = idContratacion;
		this.idCanal = idCanal;
		this.nombreCanal = nombreCanal;
		this.idCliente = idCliente;
		this.idIdentificador = idIdentificador;
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.numeroLote = numeroLote;
		this.fechaLote = fechaLote;
		this.idRegArchEntra = idRegArchEntra;
		this.nombreRegArchEntra = nombreRegArchEntra;
		this.horaProcesoIni = horaProcesoIni;
		this.horaProcesoFin = horaProcesoFin;
		this.fechaStatusProceso = fechaStatusProceso;
		this.idFlujo = idFlujo;
		this.nombreFlujo = nombreFlujo;
		this.idEtapa = idEtapa;
		this.nombreEtapa = nombreEtapa;
		this.idEstatusMapeador = idEstatusMapeador;
		this.nombreEstatusMapeador = nombreEstatusMapeador;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	/**
	 * @return the idContratacion
	 */
	public long getIdContratacion() {
		return idContratacion;
	}
	/**
	 * @param idContratacion the idContratacion to set
	 */
	public void setIdContratacion(long idContratacion) {
		this.idContratacion = idContratacion;
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
	 * @return the numeroLote
	 */
	public long getNumeroLote() {
		return numeroLote;
	}
	/**
	 * @param numeroLote the numeroLote to set
	 */
	public void setNumeroLote(long numeroLote) {
		this.numeroLote = numeroLote;
	}
	/**
	 * @return the fechaLote
	 */
	public Date getFechaLote() {
		return fechaLote;
	}
	/**
	 * @param fechaLote the fechaLote to set
	 */
	public void setFechaLote(Date fechaLote) {
		this.fechaLote = fechaLote;
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
	 * @return the horaProcesoIni
	 */
	public Date getHoraProcesoIni() {
		return horaProcesoIni;
	}
	/**
	 * @param horaProcesoIni the horaProcesoIni to set
	 */
	public void setHoraProcesoIni(Date horaProcesoIni) {
		this.horaProcesoIni = horaProcesoIni;
	}
	/**
	 * @return the horaProcesoFin
	 */
	public Date getHoraProcesoFin() {
		return horaProcesoFin;
	}
	/**
	 * @param horaProcesoFin the horaProcesoFin to set
	 */
	public void setHoraProcesoFin(Date horaProcesoFin) {
		this.horaProcesoFin = horaProcesoFin;
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
	 * @return the idFlujo
	 */
	public long getIdFlujo() {
		return idFlujo;
	}
	/**
	 * @param idFlujo the idFlujo to set
	 */
	public void setIdFlujo(long idFlujo) {
		this.idFlujo = idFlujo;
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
	 * @return the idEtapa
	 */
	public long getIdEtapa() {
		return idEtapa;
	}
	/**
	 * @param idEtapa the idEtapa to set
	 */
	public void setIdEtapa(long idEtapa) {
		this.idEtapa = idEtapa;
	}
	/**
	 * @return the nombreEtapa
	 */
	public String getNombreEtapa() {
		return nombreEtapa;
	}
	/**
	 * @param nombreEtapa the nombreEtapa to set
	 */
	public void setNombreEtapa(String nombreEtapa) {
		this.nombreEtapa = nombreEtapa;
	}
	/**
	 * @return the idEstatusMapeador
	 */
	public long getIdEstatusMapeador() {
		return idEstatusMapeador;
	}
	/**
	 * @param idEstatusMapeador the idEstatusMapeador to set
	 */
	public void setIdEstatusMapeador(long idEstatusMapeador) {
		this.idEstatusMapeador = idEstatusMapeador;
	}
	/**
	 * @return the nombreEstatusMapeador
	 */
	public String getNombreEstatusMapeador() {
		return nombreEstatusMapeador;
	}
	/**
	 * @param nombreEstatusMapeador the nombreEstatusMapeador to set
	 */
	public void setNombreEstatusMapeador(String nombreEstatusMapeador) {
		this.nombreEstatusMapeador = nombreEstatusMapeador;
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
