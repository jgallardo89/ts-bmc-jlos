package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.util.Date;
import java.util.List;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

public class DatosPrincipalesProcesoVO extends BbvaAbstractValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3600666394155627405L;

	private long idCanal;
	private String nombreCanal;
	private long idCliente;
	private String idIdentificador;
	private long idProducto;
	private String nombreProducto;
	private long idEstatusMapeador;
	private String nombreEstatusMapeador;
	private Date fechaLote;
	private long numeroLote;
	private List<RegistroProcesoVO> registroPorcesoVOs;
	/**
	 * 
	 */
	public DatosPrincipalesProcesoVO() {
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
	 * @param idEstatusMapeador
	 * @param nombreEstatusMapeador
	 * @param fechaLote
	 * @param numeroLote
	 * @param registroPorcesoVOs
	 */
	public DatosPrincipalesProcesoVO(long idCanal, String nombreCanal,
			long idCliente, String idIdentificador, long idProducto,
			String nombreProducto, long idEstatusMapeador,
			String nombreEstatusMapeador, Date fechaLote, long numeroLote,
			List<RegistroProcesoVO> registroPorcesoVOs) {
		super();
		this.idCanal = idCanal;
		this.nombreCanal = nombreCanal;
		this.idCliente = idCliente;
		this.idIdentificador = idIdentificador;
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.idEstatusMapeador = idEstatusMapeador;
		this.nombreEstatusMapeador = nombreEstatusMapeador;
		this.fechaLote = fechaLote;
		this.numeroLote = numeroLote;
		this.registroPorcesoVOs = registroPorcesoVOs;
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
	 * @return the registroPorcesoVOs
	 */
	public List<RegistroProcesoVO> getRegistroPorcesoVOs() {
		return registroPorcesoVOs;
	}
	/**
	 * @param registroPorcesoVOs the registroPorcesoVOs to set
	 */
	public void setRegistroPorcesoVOs(List<RegistroProcesoVO> registroPorcesoVOs) {
		this.registroPorcesoVOs = registroPorcesoVOs;
	}
	
}
