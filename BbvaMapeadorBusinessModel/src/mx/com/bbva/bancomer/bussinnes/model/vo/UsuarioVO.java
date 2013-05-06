package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.util.Date;


/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Informacion Confidencial:
 * Este software contiene informacion totalmente confidencial propiedad de Grupo Financiero BBVA Bancomer. 
 * Queda totalmente prohibido su uso o divulgacion en forma parcial o total y solamente podra ser utilizada de acuerdo a los terminos y estatutos 
 * que determine el Grupo Financiero BBVA Bancomer.
 * 
 * Todos los derechos reservados, Mexico 2013.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * DESCRIPCION DEL PROGRAMA:
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * HISTORIAL DE CAMBIOS:
 * 
 * Fecha:		Por:							Razon:         	Version
 * 02-MAY-2013  F. Emmanuel Chavarria Ortiz		Creacion        1.0.0
 *              femmanuel.chavarriao@gmail.com
 *              Consultoria
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
public	class 	UsuarioVO 
		extends mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject 
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	private static final long serialVersionUID = 6760690120038374296L;

	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados
	private java.lang.Integer 	idUsuario;		//	Llave primaria[TGM503_USUARIO] - 5 digitos [00000 - 99999 ]
	private java.lang.String	idCveUsuario;	//	20 caracteres 
	private java.lang.String	nombreUsuario;		//	50 caracteres 
	private java.lang.String	descripcionPasswordUsr;	//	35 caracteres 
	private java.util.Date		fechaAlta;			//	Formato - ??? 
	private java.util.Date		fechaModificacion;	//	Formato - ???
	private java.util.Date		fechaUsuario;		//	Formato - ???
	private java.util.Date		fechaCambioPws;	//	Formato - ???
	private java.lang.Integer 	numeroIntentos;		//	5 digitos [00000 - 99999 ]
	private java.lang.Integer 	estatusUsuario; 		//	Llave foranea [TGM534_ST_OBJETO] - 5 digitos [00000 - 99999 ]
	private java.lang.Integer 	idPerfil;		//	Llave foranea [TGM504_PERFIL]    - 3 digitos [00000 - 99999 ]
	private java.lang.String	descripcionPerfil;
	private String nombreEstatusObjeto;
	/**
	 * @return the idUsuario
	 */
	public final java.lang.Integer getIdUsuario() {
		return idUsuario;
	}
	/**
	 * @param idUsuario the idUsuario to set
	 */
	public final void setIdUsuario(final java.lang.Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * @return the idCveUsuario
	 */
	public final java.lang.String getIdCveUsuario() {
		return idCveUsuario;
	}
	/**
	 * @param idCveUsuario the idCveUsuario to set
	 */
	public final void setIdCveUsuario(final java.lang.String idCveUsuario) {
		this.idCveUsuario = idCveUsuario;
	}
	/**
	 * @return the nombreUsuario
	 */
	public final java.lang.String getNombreUsuario() {
		return nombreUsuario;
	}
	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public final void setNombreUsuario(final java.lang.String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	/**
	 * @return the descripcionPasswordUsr
	 */
	public final java.lang.String getDescripcionPasswordUsr() {
		return descripcionPasswordUsr;
	}
	/**
	 * @param descripcionPasswordUsr the descripcionPasswordUsr to set
	 */
	public final void setDescripcionPasswordUsr(
			final java.lang.String descripcionPasswordUsr) {
		this.descripcionPasswordUsr = descripcionPasswordUsr;
	}
	/**
	 * @return the fechaAlta
	 */
	public final java.util.Date getFechaAlta() {
		return fechaAlta;
	}
	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public final void setFechaAlta(final java.util.Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	/**
	 * @return the fechaModificacion
	 */
	public final java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}
	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public final void setFechaModificacion(final java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	/**
	 * @return the fechaUsuario
	 */
	public final java.util.Date getFechaUsuario() {
		return fechaUsuario;
	}
	/**
	 * @param fechaUsuario the fechaUsuario to set
	 */
	public final void setFechaUsuario(final java.util.Date fechaUsuario) {
		this.fechaUsuario = fechaUsuario;
	}
	/**
	 * @return the fechaCambioPws
	 */
	public final java.util.Date getFechaCambioPws() {
		return fechaCambioPws;
	}
	/**
	 * @param fechaCambioPws the fechaCambioPws to set
	 */
	public final void setFechaCambioPws(final java.util.Date fechaCambioPws) {
		this.fechaCambioPws = fechaCambioPws;
	}
	/**
	 * @return the numeroIntentos
	 */
	public final java.lang.Integer getNumeroIntentos() {
		return numeroIntentos;
	}
	/**
	 * @param numeroIntentos the numeroIntentos to set
	 */
	public final void setNumeroIntentos(final java.lang.Integer numeroIntentos) {
		this.numeroIntentos = numeroIntentos;
	}
	/**
	 * @return the estatusUsuario
	 */
	public final java.lang.Integer getEstatusUsuario() {
		return estatusUsuario;
	}
	/**
	 * @param estatusUsuario the estatusUsuario to set
	 */
	public final void setEstatusUsuario(final java.lang.Integer estatusUsuario) {
		this.estatusUsuario = estatusUsuario;
	}
	/**
	 * @return the idPerfil
	 */
	public final java.lang.Integer getIdPerfil() {
		return idPerfil;
	}
	/**
	 * @param idPerfil the idPerfil to set
	 */
	public final void setIdPerfil(final java.lang.Integer idPerfil) {
		this.idPerfil = idPerfil;
	}
	/**
	 * @return the descripcionPerfil
	 */
	public java.lang.String getDescripcionPerfil() {
		return descripcionPerfil;
	}
	/**
	 * @param descripcionPerfil the descripcionPerfil to set
	 */
	public void setDescripcionPerfil(java.lang.String descripcionPerfil) {
		this.descripcionPerfil = descripcionPerfil;
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
	 * @param idUsuario
	 * @param idCveUsuario
	 * @param nombreUsuario
	 * @param descripcionPasswordUsr
	 * @param fechaAlta
	 * @param fechaModificacion
	 * @param fechaUsuario
	 * @param fechaCambioPws
	 * @param numeroIntentos
	 * @param estatusUsuario
	 * @param idPerfil
	 * @param descripcionPerfil
	 * @param nombreEstatusObjeto
	 */
	public UsuarioVO(Integer idUsuario, String idCveUsuario,
			String nombreUsuario, String descripcionPasswordUsr,
			Date fechaAlta, Date fechaModificacion, Date fechaUsuario,
			Date fechaCambioPws, Integer numeroIntentos,
			Integer estatusUsuario, Integer idPerfil, String descripcionPerfil,
			String nombreEstatusObjeto) {
		super();
		this.idUsuario = idUsuario;
		this.idCveUsuario = idCveUsuario;
		this.nombreUsuario = nombreUsuario;
		this.descripcionPasswordUsr = descripcionPasswordUsr;
		this.fechaAlta = fechaAlta;
		this.fechaModificacion = fechaModificacion;
		this.fechaUsuario = fechaUsuario;
		this.fechaCambioPws = fechaCambioPws;
		this.numeroIntentos = numeroIntentos;
		this.estatusUsuario = estatusUsuario;
		this.idPerfil = idPerfil;
		this.descripcionPerfil = descripcionPerfil;
		this.nombreEstatusObjeto = nombreEstatusObjeto;
	}
	/**
	 * 
	 */
	public UsuarioVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	//  Metodos       - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	
	
}