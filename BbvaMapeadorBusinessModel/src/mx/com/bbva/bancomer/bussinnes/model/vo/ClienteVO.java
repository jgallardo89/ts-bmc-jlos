package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.util.Date;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

/**
 * @author Julio Morales
 * VO de la Entidad de Clientes
 */
public class ClienteVO extends BbvaAbstractValueObject {

	private static final long serialVersionUID = -2367427400828740984L;
	
	private int idCliente;
	private String idIdentificador;
	private String nombreCortoCliente;
	private String nombreCliente;
	private Date fechaAlta;
	private Date fechaModificacion;
	private int idEstatusObjeto;
	private String nombreEstatusObjeto;
	private int idBaja;
	/**
	 * @return the idCliente
	 */
	public int getIdCliente() {
		return idCliente;
	}
	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(int idCliente) {
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
	 * @return the nombreCortoCliente
	 */
	public String getNombreCortoCliente() {
		return nombreCortoCliente;
	}
	/**
	 * @param nombreCortoCliente the nombreCortoCliente to set
	 */
	public void setNombreCortoCliente(String nombreCortoCliente) {
		this.nombreCortoCliente = nombreCortoCliente;
	}
	/**
	 * @return the nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}
	/**
	 * @param nombreCliente the nombreCliente to set
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	/**
	 * @return the fechaAlta
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}
	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	/**
	 * @return the fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	/**
	 * @return the idEstatusObjeto
	 */
	public int getIdEstatusObjeto() {
		return idEstatusObjeto;
	}
	/**
	 * @param idEstatusObjeto the idEstatusObjeto to set
	 */
	public void setIdEstatusObjeto(int idEstatusObjeto) {
		this.idEstatusObjeto = idEstatusObjeto;
	}
	/**
	 * @return the nombreEstatusObjeto
	 */
	public String getNombreEstatusObjeto() {
		return nombreEstatusObjeto;
	}
	/**
	 * @param nombreEstatusObjeto the nombreEstatusObjeto to set
	 */
	public void setNombreEstatusObjeto(String nombreEstatusObjeto) {
		this.nombreEstatusObjeto = nombreEstatusObjeto;
	}
	/**
	 * @return the idBaja
	 */
	public int getIdBaja() {
		return idBaja;
	}
	/**
	 * @param idBaja the idBaja to set
	 */
	public void setIdBaja(int idBaja) {
		this.idBaja = idBaja;
	}
	
}
