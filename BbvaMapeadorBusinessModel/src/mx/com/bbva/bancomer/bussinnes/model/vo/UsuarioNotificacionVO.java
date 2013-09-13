/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Informacion Confidencial:
 * Este software contiene informacion totalmente confidencial propiedad de Grupo Financiero BBVA Bancomer. 
 * Queda totalmente prohibido su uso o divulgacion en forma parcial o total y solamente podra ser utilizada de acuerdo a los terminos y estatutos 
 * que determine el Grupo Financiero BBVA Bancomer.
 * 
 * Todos los derechos reservados, Mexico 2013.
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * DESCRIPCION DEL PROGRAMA
 * Nombre de aplicación: MAPEADOR
 * Nombre de proyecto: BbvaMapeadorBusinessModel
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * HISTORIAL DE CAMBIOS:
 * 
 * Fecha:									         	
 * 30-ABR-2013  
 * @Author:	Jose Luis Ortiz Salazar
 * @Email: jortizsalazar@gmail.com    	
 * Razon: Creacion        
 * Version: 1.0.0
 * Nombre de clase: UsuarioNotificacionVO.java
 * Nombre de paquete: mx.com.bbva.bancomer.bussinnes.model.vo
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.bussinnes.model.vo;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioNotificacionVO.
 */
public class UsuarioNotificacionVO extends mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8480678918746525659L;
	
	/** The descripcion email. */
	private String descripcionEmail;
	
	/** The descripcion id usuarios. */
	private String descripcionIdUsuarios;
	
	/** The existe. */
	private int existe;
	
	/** The id estatus objeto. */
	private long idEstatusObjeto;
	
	/** The id mensaje notificacion. */
	private int idMensajeNotificacion;
	
	/** The id usuario notificado. */
	private long idUsuarioNotificado;
	
	/** The Id usuarios. */
	private int[] IdUsuarios;
	
	/** The nombre estatus objeto. */
	private String nombreEstatusObjeto;
	
	/** The nombre usuario notificado. */
	private String nombreUsuarioNotificado;
	
	/** The tipo notificacion. */
	private String tipoNotificacion;
	
	/**
	 * Instantiates a new usuario notificacion vo.
	 */
	public UsuarioNotificacionVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new usuario notificacion vo.
	 *
	 * @param idUsuarioNotificado the id usuario notificado
	 * @param nombreUsuarioNotificado the nombre usuario notificado
	 * @param descripcionEmail the descripcion email
	 * @param idEstatusObjeto the id estatus objeto
	 * @param nombreEstatusObjeto the nombre estatus objeto
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
	 * Gets the descripcion email.
	 *
	 * @return the descripcionEmail
	 */
	public String getDescripcionEmail() {
		return descripcionEmail;
	}
	
	/**
	 * Gets the descripcion email Upper.
	 *
	 * @return the descripcionEmail Upper
	 */
	public String getDescripcionEmailUpper() {
		return descripcionEmail.toUpperCase();
	}
	
	/**
	 * Gets the descripcion id usuarios.
	 *
	 * @return the descripcionIdUsuarios
	 */
	public String getDescripcionIdUsuarios() {
		return descripcionIdUsuarios;
	}
	
	/**
	 * Gets the existe.
	 *
	 * @return the existe
	 */
	public final int getExiste() {
		return existe;
	}
	
	/**
	 * Gets the id estatus objeto.
	 *
	 * @return the idEstatusObjeto
	 */
	public long getIdEstatusObjeto() {
		return idEstatusObjeto;
	}
	
	/**
	 * Gets the id mensaje notificacion.
	 *
	 * @return the idMensajeNotificacion
	 */
	public final int getIdMensajeNotificacion() {
		return idMensajeNotificacion;
	}
	
	/**
	 * Gets the id usuario notificado.
	 *
	 * @return the idUsuarioNotificado
	 */
	public long getIdUsuarioNotificado() {
		return idUsuarioNotificado;
	}
	
	/**
	 * Gets the id usuarios.
	 *
	 * @return the idUsuarios
	 */
	public int[] getIdUsuarios() {
		return IdUsuarios;
	}
	
	/**
	 * Gets the nombre estatus objeto.
	 *
	 * @return the nombreEstatusObjeto
	 */
	public String getNombreEstatusObjeto() {
		return nombreEstatusObjeto;
	}
	
	/**
	 * Gets the nombre usuario notificado.
	 *
	 * @return the nombreUsuarioNotificado
	 */
	public String getNombreUsuarioNotificado() {
		return nombreUsuarioNotificado;
	}
	
	/**
	 * Gets the tipo notificacion.
	 *
	 * @return the tipoNotificacion
	 */
	public String getTipoNotificacion() {
		return tipoNotificacion;
	}
	
	/**
	 * Sets the descripcion email.
	 *
	 * @param descripcionEmail the descripcionEmail to set
	 */
	public void setDescripcionEmail(String descripcionEmail) {
		this.descripcionEmail = descripcionEmail;
	}
	
	/**
	 * Sets the descripcion id usuarios.
	 *
	 * @param descripcionIdUsuarios the descripcionIdUsuarios to set
	 */
	public void setDescripcionIdUsuarios(String descripcionIdUsuarios) {
		this.descripcionIdUsuarios = descripcionIdUsuarios;
	}
	
	/**
	 * Sets the existe.
	 *
	 * @param existe the existe to set
	 */
	public final void setExiste(int existe) {
		this.existe = existe;
	}
	
	/**
	 * Sets the id estatus objeto.
	 *
	 * @param idEstatusObjeto the idEstatusObjeto to set
	 */
	public void setIdEstatusObjeto(long idEstatusObjeto) {
		this.idEstatusObjeto = idEstatusObjeto;
	}
	
	/**
	 * Sets the id mensaje notificacion.
	 *
	 * @param idMensajeNotificacion the idMensajeNotificacion to set
	 */
	public final void setIdMensajeNotificacion(int idMensajeNotificacion) {
		this.idMensajeNotificacion = idMensajeNotificacion;
	}
	
	/**
	 * Sets the id usuario notificado.
	 *
	 * @param idUsuarioNotificado the idUsuarioNotificado to set
	 */
	public void setIdUsuarioNotificado(long idUsuarioNotificado) {
		this.idUsuarioNotificado = idUsuarioNotificado;
	}
	
	/**
	 * Sets the id usuarios.
	 *
	 * @param idUsuarios the idUsuarios to set
	 */
	public void setIdUsuarios(int[] idUsuarios) {
		IdUsuarios = idUsuarios;
	}
	
	/**
	 * Sets the nombre estatus objeto.
	 *
	 * @param nombreEstatusObjeto the nombreEstatusObjeto to set
	 */
	public void setNombreEstatusObjeto(String nombreEstatusObjeto) {
		this.nombreEstatusObjeto = nombreEstatusObjeto;
	}
	
	/**
	 * Sets the nombre usuario notificado.
	 *
	 * @param nombreUsuarioNotificado the nombreUsuarioNotificado to set
	 */
	public void setNombreUsuarioNotificado(String nombreUsuarioNotificado) {
		this.nombreUsuarioNotificado = nombreUsuarioNotificado;
	}
	
	/**
	 * Sets the tipo notificacion.
	 *
	 * @param tipoNotificacion the tipoNotificacion to set
	 */
	public void setTipoNotificacion(String tipoNotificacion) {
		this.tipoNotificacion = tipoNotificacion;
	}	
	
}
