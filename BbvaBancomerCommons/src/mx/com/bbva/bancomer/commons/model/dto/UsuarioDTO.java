package mx.com.bbva.bancomer.commons.model.dto;

import java.math.BigDecimal;
import java.util.Date;


public class UsuarioDTO extends BbvaAbstractDataTransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4734786766109305693L;
	private long cdUsuario;
	private String cdCveUsuario;
	private Date fhUsuario;
	private String nbUsuario;
	private BigDecimal nuIntentos;
	private Date tmAlta;
	private Date tmCambioPws;
	private Date tmModificacion;
	private String txPasswordUsr;
	
	/**
	 * 
	 */
	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param cdUsuario
	 * @param cdCveUsuario
	 * @param fhUsuario
	 * @param nbUsuario
	 * @param nuIntentos
	 * @param tmAlta
	 * @param tmCambioPws
	 * @param tmModificacion
	 * @param txPasswordUsr
	 */
	public UsuarioDTO(long cdUsuario, String cdCveUsuario, Date fhUsuario,
			String nbUsuario, BigDecimal nuIntentos, Date tmAlta,
			Date tmCambioPws, Date tmModificacion, String txPasswordUsr) {
		super();
		this.cdUsuario = cdUsuario;
		this.cdCveUsuario = cdCveUsuario;
		this.fhUsuario = fhUsuario;
		this.nbUsuario = nbUsuario;
		this.nuIntentos = nuIntentos;
		this.tmAlta = tmAlta;
		this.tmCambioPws = tmCambioPws;
		this.tmModificacion = tmModificacion;
		this.txPasswordUsr = txPasswordUsr;
	}
	/**
	 * @return the cdUsuario
	 */
	public long getCdUsuario() {
		return cdUsuario;
	}
	/**
	 * @param cdUsuario the cdUsuario to set
	 */
	public void setCdUsuario(long cdUsuario) {
		this.cdUsuario = cdUsuario;
	}
	/**
	 * @return the cdCveUsuario
	 */
	public String getCdCveUsuario() {
		return cdCveUsuario;
	}
	/**
	 * @param cdCveUsuario the cdCveUsuario to set
	 */
	public void setCdCveUsuario(String cdCveUsuario) {
		this.cdCveUsuario = cdCveUsuario;
	}
	/**
	 * @return the fhUsuario
	 */
	public Date getFhUsuario() {
		return fhUsuario;
	}
	/**
	 * @param fhUsuario the fhUsuario to set
	 */
	public void setFhUsuario(Date fhUsuario) {
		this.fhUsuario = fhUsuario;
	}
	/**
	 * @return the nbUsuario
	 */
	public String getNbUsuario() {
		return nbUsuario;
	}
	/**
	 * @param nbUsuario the nbUsuario to set
	 */
	public void setNbUsuario(String nbUsuario) {
		this.nbUsuario = nbUsuario;
	}
	/**
	 * @return the nuIntentos
	 */
	public BigDecimal getNuIntentos() {
		return nuIntentos;
	}
	/**
	 * @param nuIntentos the nuIntentos to set
	 */
	public void setNuIntentos(BigDecimal nuIntentos) {
		this.nuIntentos = nuIntentos;
	}
	/**
	 * @return the tmAlta
	 */
	public Date getTmAlta() {
		return tmAlta;
	}
	/**
	 * @param tmAlta the tmAlta to set
	 */
	public void setTmAlta(Date tmAlta) {
		this.tmAlta = tmAlta;
	}
	/**
	 * @return the tmCambioPws
	 */
	public Date getTmCambioPws() {
		return tmCambioPws;
	}
	/**
	 * @param tmCambioPws the tmCambioPws to set
	 */
	public void setTmCambioPws(Date tmCambioPws) {
		this.tmCambioPws = tmCambioPws;
	}
	/**
	 * @return the tmModificacion
	 */
	public Date getTmModificacion() {
		return tmModificacion;
	}
	/**
	 * @param tmModificacion the tmModificacion to set
	 */
	public void setTmModificacion(Date tmModificacion) {
		this.tmModificacion = tmModificacion;
	}
	/**
	 * @return the txPasswordUsr
	 */
	public String getTxPasswordUsr() {
		return txPasswordUsr;
	}
	/**
	 * @param txPasswordUsr the txPasswordUsr to set
	 */
	public void setTxPasswordUsr(String txPasswordUsr) {
		this.txPasswordUsr = txPasswordUsr;
	} 

}
