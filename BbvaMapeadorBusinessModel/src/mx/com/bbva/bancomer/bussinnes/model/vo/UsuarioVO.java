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
 * Nombre de clase: UsuarioVO.java
 * Nombre de paquete: mx.com.bbva.bancomer.bussinnes.model.vo
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.util.Date;


// TODO: Auto-generated Javadoc
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
/**
 * The Class UsuarioVO.
 */
public	class 	UsuarioVO 
		extends mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject 
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6760690120038374296L;

	/** The descripcion password usr. */
	private java.lang.String	descripcionPasswordUsr;	//	35 caracteres 
	
	/** The descripcion perfil. */
	private java.lang.String	descripcionPerfil;
	
	/** The estatus usuario. */
	private java.lang.Integer 	estatusUsuario; 		//	Llave foranea [TGM534_ST_OBJETO] - 5 digitos [00000 - 99999 ]
	
	/** The fecha alta. */
	private java.util.Date		fechaAlta;			//	Formato - ??? 
	
	/** The fecha cambio pws. */
	private java.util.Date		fechaCambioPws;	//	Formato - ???
	
	/** The fecha modificacion. */
	private java.util.Date		fechaModificacion;	//	Formato - ???
	
	/** The fecha usuario. */
	private java.util.Date		fechaUsuario;		//	Formato - ???
	
	/** The id cve usuario. */
	private java.lang.String	idCveUsuario;	//	20 caracteres 
	
	/** The id perfil. */
	private java.lang.Integer 	idPerfil;		//	Llave foranea [TGM504_PERFIL]    - 3 digitos [00000 - 99999 ]
	
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados
	/** The id usuario. */
	private java.lang.Integer 	idUsuario;		//	Llave primaria[TGM503_USUARIO] - 5 digitos [00000 - 99999 ]
	
	/** The nombre estatus objeto. */
	private String nombreEstatusObjeto;
	
	/** The nombre usuario. */
	private java.lang.String	nombreUsuario;		//	50 caracteres 
	
	/** The numero intentos. */
	private java.lang.Integer 	numeroIntentos;		//	5 digitos [00000 - 99999 ]
	
	/**
	 * Instantiates a new usuario vo.
	 */
	public UsuarioVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new usuario vo.
	 *
	 * @param idUsuario the id usuario
	 * @param idCveUsuario the id cve usuario
	 * @param nombreUsuario the nombre usuario
	 * @param descripcionPasswordUsr the descripcion password usr
	 * @param fechaAlta the fecha alta
	 * @param fechaModificacion the fecha modificacion
	 * @param fechaUsuario the fecha usuario
	 * @param fechaCambioPws the fecha cambio pws
	 * @param numeroIntentos the numero intentos
	 * @param estatusUsuario the estatus usuario
	 * @param idPerfil the id perfil
	 * @param descripcionPerfil the descripcion perfil
	 * @param nombreEstatusObjeto the nombre estatus objeto
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
	 * Gets the descripcion password usr.
	 *
	 * @return the descripcionPasswordUsr
	 */
	public final java.lang.String getDescripcionPasswordUsr() {
		return descripcionPasswordUsr;
	}
	
	/**
	 * Gets the descripcion perfil.
	 *
	 * @return the descripcionPerfil
	 */
	public java.lang.String getDescripcionPerfil() {
		return descripcionPerfil;
	}
	
	/**
	 * Gets the estatus usuario.
	 *
	 * @return the estatusUsuario
	 */
	public final java.lang.Integer getEstatusUsuario() {
		return estatusUsuario;
	}
	
	/**
	 * Gets the fecha alta.
	 *
	 * @return the fechaAlta
	 */
	public final java.util.Date getFechaAlta() {
		return fechaAlta;
	}
	
	/**
	 * Gets the fecha cambio pws.
	 *
	 * @return the fechaCambioPws
	 */
	public final java.util.Date getFechaCambioPws() {
		return fechaCambioPws;
	}
	
	/**
	 * Gets the fecha modificacion.
	 *
	 * @return the fechaModificacion
	 */
	public final java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}
	
	/**
	 * Gets the fecha usuario.
	 *
	 * @return the fechaUsuario
	 */
	public final java.util.Date getFechaUsuario() {
		return fechaUsuario;
	}
	
	/**
	 * Gets the id cve usuario.
	 *
	 * @return the idCveUsuario
	 */
	public final java.lang.String getIdCveUsuario() {
		return idCveUsuario;
	}
	
	/**
	 * Gets the id perfil.
	 *
	 * @return the idPerfil
	 */
	public final java.lang.Integer getIdPerfil() {
		return idPerfil;
	}
	
	/**
	 * Gets the id usuario.
	 *
	 * @return the idUsuario
	 */
	public final java.lang.Integer getIdUsuario() {
		return idUsuario;
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
	 * Gets the nombre usuario.
	 *
	 * @return the nombreUsuario
	 */
	public final java.lang.String getNombreUsuario() {
		return nombreUsuario;
	}
	
	/**
	 * Gets the numero intentos.
	 *
	 * @return the numeroIntentos
	 */
	public final java.lang.Integer getNumeroIntentos() {
		return numeroIntentos;
	}
	
	/**
	 * Sets the descripcion password usr.
	 *
	 * @param descripcionPasswordUsr the descripcionPasswordUsr to set
	 */
	public final void setDescripcionPasswordUsr(
			final java.lang.String descripcionPasswordUsr) {
		this.descripcionPasswordUsr = descripcionPasswordUsr;
	}
	
	/**
	 * Sets the descripcion perfil.
	 *
	 * @param descripcionPerfil the descripcionPerfil to set
	 */
	public void setDescripcionPerfil(java.lang.String descripcionPerfil) {
		this.descripcionPerfil = descripcionPerfil;
	}
	
	/**
	 * Sets the estatus usuario.
	 *
	 * @param estatusUsuario the estatusUsuario to set
	 */
	public final void setEstatusUsuario(final java.lang.Integer estatusUsuario) {
		this.estatusUsuario = estatusUsuario;
	}
	
	/**
	 * Sets the fecha alta.
	 *
	 * @param fechaAlta the fechaAlta to set
	 */
	public final void setFechaAlta(final java.util.Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	/**
	 * Sets the fecha cambio pws.
	 *
	 * @param fechaCambioPws the fechaCambioPws to set
	 */
	public final void setFechaCambioPws(final java.util.Date fechaCambioPws) {
		this.fechaCambioPws = fechaCambioPws;
	}
	
	/**
	 * Sets the fecha modificacion.
	 *
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public final void setFechaModificacion(final java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
	/**
	 * Sets the fecha usuario.
	 *
	 * @param fechaUsuario the fechaUsuario to set
	 */
	public final void setFechaUsuario(final java.util.Date fechaUsuario) {
		this.fechaUsuario = fechaUsuario;
	}
	
	/**
	 * Sets the id cve usuario.
	 *
	 * @param idCveUsuario the idCveUsuario to set
	 */
	public final void setIdCveUsuario(final java.lang.String idCveUsuario) {
		this.idCveUsuario = idCveUsuario;
	}
	
	/**
	 * Sets the id perfil.
	 *
	 * @param idPerfil the idPerfil to set
	 */
	public final void setIdPerfil(final java.lang.Integer idPerfil) {
		this.idPerfil = idPerfil;
	}
	
	/**
	 * Sets the id usuario.
	 *
	 * @param idUsuario the idUsuario to set
	 */
	public final void setIdUsuario(final java.lang.Integer idUsuario) {
		this.idUsuario = idUsuario;
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
	 * Sets the nombre usuario.
	 *
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public final void setNombreUsuario(final java.lang.String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	/**
	 * Sets the numero intentos.
	 *
	 * @param numeroIntentos the numeroIntentos to set
	 */
	public final void setNumeroIntentos(final java.lang.Integer numeroIntentos) {
		this.numeroIntentos = numeroIntentos;
	}

	//  Metodos       - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	
	
}