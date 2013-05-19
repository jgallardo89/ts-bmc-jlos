package mx.com.bbva.bancomer.bussinnes.model.vo;

public class UsuarioNotificacionVO extends mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8480678918746525659L;
	private long idUsuarioNotificado;
	private String nombreUsuarioNotificado;
	private String descripcionEmail;
	private long idEstatusObjeto;
	private String nombreEstatusObjeto;
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
	
	
}
