package mx.com.bbva.bancomer.bussinnes.model.vo;

public class UsuarioNotificacionVO extends mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject {

	private static final long serialVersionUID = 8480678918746525659L;
	private long idUsuarioNotificado;
	private String nombreUsuarioNotificado;
	private String descripcionEmail;
	private long idEstatusObjeto;
	private String nombreEstatusObjeto;
	private String descripcionIdUsuarios;
	private int[] IdUsuarios;
	private String tipoNotificacion;
	private int existe;
	private int idMensajeNotificacion;
	/**
	 * @return the idMensajeNotificacion
	 */
	public final int getIdMensajeNotificacion() {
		return idMensajeNotificacion;
	}
	/**
	 * @param idMensajeNotificacion the idMensajeNotificacion to set
	 */
	public final void setIdMensajeNotificacion(int idMensajeNotificacion) {
		this.idMensajeNotificacion = idMensajeNotificacion;
	}
	/**
	 * @return the existe
	 */
	public final int getExiste() {
		return existe;
	}
	/**
	 * @param existe the existe to set
	 */
	public final void setExiste(int existe) {
		this.existe = existe;
	}
	/**
	 * 
	 */
	public UsuarioNotificacionVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param idUsuarioNotificado
	 * @param nombreUsuarioNotificado
	 * @param descripcionEmail
	 * @param idEstatusObjeto
	 * @param nombreEstatusObjeto
	 */
	public UsuarioNotificacionVO(long idUsuarioNotificado,
			String nombreUsuarioNotificado, String descripcionEmail,
			long idEstatusObjeto, String nombreEstatusObjeto) {
		super();
		this.idUsuarioNotificado = idUsuarioNotificado;
		this.nombreUsuarioNotificado = nombreUsuarioNotificado;
		this.descripcionEmail = descripcionEmail;
		this.idEstatusObjeto = idEstatusObjeto;
		this.nombreEstatusObjeto = nombreEstatusObjeto;
	}
	/**
	 * @return the idUsuarioNotificado
	 */
	public long getIdUsuarioNotificado() {
		return idUsuarioNotificado;
	}
	/**
	 * @param idUsuarioNotificado the idUsuarioNotificado to set
	 */
	public void setIdUsuarioNotificado(long idUsuarioNotificado) {
		this.idUsuarioNotificado = idUsuarioNotificado;
	}
	/**
	 * @return the nombreUsuarioNotificado
	 */
	public String getNombreUsuarioNotificado() {
		return nombreUsuarioNotificado;
	}
	/**
	 * @param nombreUsuarioNotificado the nombreUsuarioNotificado to set
	 */
	public void setNombreUsuarioNotificado(String nombreUsuarioNotificado) {
		this.nombreUsuarioNotificado = nombreUsuarioNotificado;
	}
	/**
	 * @return the descripcionEmail
	 */
	public String getDescripcionEmail() {
		return descripcionEmail;
	}
	/**
	 * @param descripcionEmail the descripcionEmail to set
	 */
	public void setDescripcionEmail(String descripcionEmail) {
		this.descripcionEmail = descripcionEmail;
	}
	/**
	 * @return the idEstatusObjeto
	 */
	public long getIdEstatusObjeto() {
		return idEstatusObjeto;
	}
	/**
	 * @param idEstatusObjeto the idEstatusObjeto to set
	 */
	public void setIdEstatusObjeto(long idEstatusObjeto) {
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
	 * @return the descripcionIdUsuarios
	 */
	public String getDescripcionIdUsuarios() {
		return descripcionIdUsuarios;
	}
	/**
	 * @param descripcionIdUsuarios the descripcionIdUsuarios to set
	 */
	public void setDescripcionIdUsuarios(String descripcionIdUsuarios) {
		this.descripcionIdUsuarios = descripcionIdUsuarios;
	}
	/**
	 * @return the idUsuarios
	 */
	public int[] getIdUsuarios() {
		return IdUsuarios;
	}
	/**
	 * @param idUsuarios the idUsuarios to set
	 */
	public void setIdUsuarios(int[] idUsuarios) {
		IdUsuarios = idUsuarios;
	}
	/**
	 * @return the tipoNotificacion
	 */
	public String getTipoNotificacion() {
		return tipoNotificacion;
	}
	/**
	 * @param tipoNotificacion the tipoNotificacion to set
	 */
	public void setTipoNotificacion(String tipoNotificacion) {
		this.tipoNotificacion = tipoNotificacion;
	}	
	
}
