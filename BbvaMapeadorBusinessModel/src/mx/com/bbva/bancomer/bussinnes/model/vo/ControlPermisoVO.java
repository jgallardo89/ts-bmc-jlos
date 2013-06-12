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
 * Nombre de clase: ControlPermisoVO.java
 * Nombre de paquete: mx.com.bbva.bancomer.bussinnes.model.vo
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.bussinnes.model.vo;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

// TODO: Auto-generated Javadoc
/**
 * The Class ControlPermisoVO.
 *
 * @author Julio Morales
 */
public class ControlPermisoVO extends BbvaAbstractValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The id componente. */
	private long idComponente;
	
	/** The id control permiso. */
	private long idControlPermiso;
	
	/** The id default. */
	private String idDefault;
	
	/** The id pantalla. */
	private long idPantalla;
	
	/** The id perfil. */
	private long idPerfil;
	
	/** The id usuario. */
	private long idUsuario;
	
	/** The nombre componente. */
	private String nombreComponente;
	
	/** The permiso. */
	private String permiso;
	
	/**
	 * Gets the id componente.
	 *
	 * @return the idComponente
	 */
	public final long getIdComponente() {
		return idComponente;
	}
	
	/**
	 * Gets the id control permiso.
	 *
	 * @return the idControlPermiso
	 */
	public final long getIdControlPermiso() {
		return idControlPermiso;
	}
	
	/**
	 * Gets the id default.
	 *
	 * @return the idDefault
	 */
	public final String getIdDefault() {
		return idDefault;
	}
	
	/**
	 * Gets the id pantalla.
	 *
	 * @return the idPantalla
	 */
	public final long getIdPantalla() {
		return idPantalla;
	}
	
	/**
	 * Gets the id perfil.
	 *
	 * @return the idPerfil
	 */
	public final long getIdPerfil() {
		return idPerfil;
	}
	
	/**
	 * Gets the id usuario.
	 *
	 * @return the idUsuario
	 */
	public final long getIdUsuario() {
		return idUsuario;
	}
	
	/**
	 * Gets the nombre componente.
	 *
	 * @return the nombreComponente
	 */
	public final String getNombreComponente() {
		return nombreComponente;
	}
	
	/**
	 * Checks if is permiso.
	 *
	 * @return the permiso
	 */
	public final String isPermiso() {
		return permiso;
	}
	
	/**
	 * Sets the id componente.
	 *
	 * @param idComponente the idComponente to set
	 */
	public final void setIdComponente(long idComponente) {
		this.idComponente = idComponente;
	}
	
	/**
	 * Sets the id control permiso.
	 *
	 * @param idControlPermiso the idControlPermiso to set
	 */
	public final void setIdControlPermiso(long idControlPermiso) {
		this.idControlPermiso = idControlPermiso;
	}
	
	/**
	 * Sets the id default.
	 *
	 * @param idDefault the idDefault to set
	 */
	public final void setIdDefault(String idDefault) {
		this.idDefault = idDefault;
	}
	
	/**
	 * Sets the id pantalla.
	 *
	 * @param idPantalla the idPantalla to set
	 */
	public final void setIdPantalla(long idPantalla) {
		this.idPantalla = idPantalla;
	}
	
	/**
	 * Sets the id perfil.
	 *
	 * @param idPerfil the idPerfil to set
	 */
	public final void setIdPerfil(long idPerfil) {
		this.idPerfil = idPerfil;
	}
	
	/**
	 * Sets the id usuario.
	 *
	 * @param idUsuario the idUsuario to set
	 */
	public final void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	/**
	 * Sets the nombre componente.
	 *
	 * @param nombreComponente the nombreComponente to set
	 */
	public final void setNombreComponente(String nombreComponente) {
		this.nombreComponente = nombreComponente;
	}
	
	/**
	 * Sets the permiso.
	 *
	 * @param permiso the permiso to set
	 */
	public final void setPermiso(String permiso) {
		this.permiso = permiso;
	}
}
