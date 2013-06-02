package mx.com.bbva.bancomer.bussinnes.model.vo;


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
public	class 	PerfilVO 
		extends mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject 
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	private static final long serialVersionUID = -4809985381338507696L;

	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados
	private java.lang.String	descripcionPerfil;	//	300 caracteres 
	private java.lang.Integer 	estatusPerfil; 		//	Llave foranea [TGM534_ST_OBJETO] - 5 digitos [00000 - 99999 ]	
	private java.lang.Integer 	idPerfil;			//	Llave primaria[TGM504_PERFIL] - 3 digitos [000 - 999 ]
	private java.lang.String	nombrebPerfil;		//	30 caracteres
	private java.lang.String	descipcionEstatus;
	private java.util.List<ControlPermisoVO> controlPermisoVOs;
	private java.lang.Integer 	idPantalla;
	private java.lang.Integer 	idPerfilACopiar;
	/**
	 * @return the idPerfilACopiar
	 */
	public final java.lang.Integer getIdPerfilACopiar() {
		return idPerfilACopiar;
	}
	/**
	 * @param idPerfilACopiar the idPerfilACopiar to set
	 */
	public final void setIdPerfilACopiar(java.lang.Integer idPerfilACopiar) {
		this.idPerfilACopiar = idPerfilACopiar;
	}
	/**
	 * @return the idPantalla
	 */
	public final java.lang.Integer getIdPantalla() {
		return idPantalla;
	}
	/**
	 * @param idPantalla the idPantalla to set
	 */
	public final void setIdPantalla(java.lang.Integer idPantalla) {
		this.idPantalla = idPantalla;
	}
	/**
	 * @return the controPermisoVOs
	 */
	public final java.util.List<ControlPermisoVO> getControlPermisoVOs() {
		return controlPermisoVOs;
	}
	/**
	 * @param controPermisoVOs the controPermisoVOs to set
	 */
	public final void setControlPermisoVOs(
			java.util.List<ControlPermisoVO> controPermisoVOs) {
		this.controlPermisoVOs = controPermisoVOs;
	}
	/**
	 * @return the descipcionEstatus
	 */
	public final java.lang.String getDescipcionEstatus() {
		return descipcionEstatus;
	}
	/**
	 * @param descipcionEstatus the descipcionEstatus to set
	 */
	public final void setDescipcionEstatus(java.lang.String descipcionEstatus) {
		this.descipcionEstatus = descipcionEstatus;
	}
	/**
	 * @return the descripcionPerfil
	 */
	public java.lang.String getDescripcionPerfil() {
		return descripcionPerfil;
	}
	/**
	 * @return the estatusPerfil
	 */
	public java.lang.Integer getEstatusPerfil() {
		return estatusPerfil;
	}
	/**
	 * @return the idPerfil
	 */
	public java.lang.Integer getIdPerfil() {
		return idPerfil;
	}
	/**
	 * @return the nombrebPerfil
	 */
	public java.lang.String getNombrebPerfil() {
		return nombrebPerfil;
	}
	/**
	 * @param descripcionPerfil the descripcionPerfil to set
	 */
	public void setDescripcionPerfil(final java.lang.String descripcionPerfil) {
		this.descripcionPerfil = descripcionPerfil;
	}
	/**
	 * @param estatusPerfil the estatusPerfil to set
	 */
	public void setEstatusPerfil(final java.lang.Integer estatusPerfil) {
		this.estatusPerfil = estatusPerfil;
	}
	/**
	 * @param idPerfil the idPerfil to set
	 */
	public void setIdPerfil(final java.lang.Integer idPerfil) {
		this.idPerfil = idPerfil;
	}
	/**
	 * @param nombrebPerfil the nombrebPerfil to set
	 */
	public void setNombrebPerfil(final java.lang.String nombrebPerfil) {
		this.nombrebPerfil = nombrebPerfil;
	}
	/**
	 * @param descripcionPerfil
	 * @param estatusPerfil
	 * @param idPerfil
	 * @param nombrebPerfil
	 */
	public PerfilVO(String descripcionPerfil, Integer estatusPerfil,
			Integer idPerfil, String nombrebPerfil) {
		super();
		this.descripcionPerfil = descripcionPerfil;
		this.estatusPerfil = estatusPerfil;
		this.idPerfil = idPerfil;
		this.nombrebPerfil = nombrebPerfil;
	}
	/**
	 * 
	 */
	public PerfilVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	//  Metodos       - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	
	
	}