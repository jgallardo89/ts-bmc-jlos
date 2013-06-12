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
 * Nombre de clase: PerfilVO.java
 * Nombre de paquete: mx.com.bbva.bancomer.bussinnes.model.vo
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.bussinnes.model.vo;


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
 * The Class PerfilVO.
 */
public	class 	PerfilVO 
		extends mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject 
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4809985381338507696L;

	/** The control permiso v os. */
	private java.util.List<ControlPermisoVO> controlPermisoVOs;
	
	/** The descipcion estatus. */
	private java.lang.String	descipcionEstatus;
	
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados
	/** The descripcion perfil. */
	private java.lang.String	descripcionPerfil;	//	300 caracteres 
	
	/** The estatus perfil. */
	private java.lang.Integer 	estatusPerfil; 		//	Llave foranea [TGM534_ST_OBJETO] - 5 digitos [00000 - 99999 ]	
	
	/** The id pantalla. */
	private java.lang.Integer 	idPantalla;
	
	/** The id perfil. */
	private java.lang.Integer 	idPerfil;			//	Llave primaria[TGM504_PERFIL] - 3 digitos [000 - 999 ]
	
	/** The id perfil a copiar. */
	private java.lang.Integer 	idPerfilACopiar;
	
	/** The nombreb perfil. */
	private java.lang.String	nombrebPerfil;		//	30 caracteres
	
	/**
	 * Instantiates a new perfil vo.
	 */
	public PerfilVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new perfil vo.
	 *
	 * @param descripcionPerfil the descripcion perfil
	 * @param estatusPerfil the estatus perfil
	 * @param idPerfil the id perfil
	 * @param nombrebPerfil the nombreb perfil
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
	 * Gets the control permiso v os.
	 *
	 * @return the controPermisoVOs
	 */
	public final java.util.List<ControlPermisoVO> getControlPermisoVOs() {
		return controlPermisoVOs;
	}
	
	/**
	 * Gets the descipcion estatus.
	 *
	 * @return the descipcionEstatus
	 */
	public final java.lang.String getDescipcionEstatus() {
		return descipcionEstatus;
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
	 * Gets the estatus perfil.
	 *
	 * @return the estatusPerfil
	 */
	public java.lang.Integer getEstatusPerfil() {
		return estatusPerfil;
	}
	
	/**
	 * Gets the id pantalla.
	 *
	 * @return the idPantalla
	 */
	public final java.lang.Integer getIdPantalla() {
		return idPantalla;
	}
	
	/**
	 * Gets the id perfil.
	 *
	 * @return the idPerfil
	 */
	public java.lang.Integer getIdPerfil() {
		return idPerfil;
	}
	
	/**
	 * Gets the id perfil a copiar.
	 *
	 * @return the idPerfilACopiar
	 */
	public final java.lang.Integer getIdPerfilACopiar() {
		return idPerfilACopiar;
	}
	
	/**
	 * Gets the nombreb perfil.
	 *
	 * @return the nombrebPerfil
	 */
	public java.lang.String getNombrebPerfil() {
		return nombrebPerfil;
	}
	
	/**
	 * Sets the control permiso v os.
	 *
	 * @param controPermisoVOs the controPermisoVOs to set
	 */
	public final void setControlPermisoVOs(
			java.util.List<ControlPermisoVO> controPermisoVOs) {
		this.controlPermisoVOs = controPermisoVOs;
	}
	
	/**
	 * Sets the descipcion estatus.
	 *
	 * @param descipcionEstatus the descipcionEstatus to set
	 */
	public final void setDescipcionEstatus(java.lang.String descipcionEstatus) {
		this.descipcionEstatus = descipcionEstatus;
	}
	
	/**
	 * Sets the descripcion perfil.
	 *
	 * @param descripcionPerfil the descripcionPerfil to set
	 */
	public void setDescripcionPerfil(final java.lang.String descripcionPerfil) {
		this.descripcionPerfil = descripcionPerfil;
	}
	
	/**
	 * Sets the estatus perfil.
	 *
	 * @param estatusPerfil the estatusPerfil to set
	 */
	public void setEstatusPerfil(final java.lang.Integer estatusPerfil) {
		this.estatusPerfil = estatusPerfil;
	}
	
	/**
	 * Sets the id pantalla.
	 *
	 * @param idPantalla the idPantalla to set
	 */
	public final void setIdPantalla(java.lang.Integer idPantalla) {
		this.idPantalla = idPantalla;
	}
	
	/**
	 * Sets the id perfil.
	 *
	 * @param idPerfil the idPerfil to set
	 */
	public void setIdPerfil(final java.lang.Integer idPerfil) {
		this.idPerfil = idPerfil;
	}
	
	/**
	 * Sets the id perfil a copiar.
	 *
	 * @param idPerfilACopiar the idPerfilACopiar to set
	 */
	public final void setIdPerfilACopiar(java.lang.Integer idPerfilACopiar) {
		this.idPerfilACopiar = idPerfilACopiar;
	}
	
	/**
	 * Sets the nombreb perfil.
	 *
	 * @param nombrebPerfil the nombrebPerfil to set
	 */
	public void setNombrebPerfil(final java.lang.String nombrebPerfil) {
		this.nombrebPerfil = nombrebPerfil;
	}

	//  Metodos       - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	
	
	}