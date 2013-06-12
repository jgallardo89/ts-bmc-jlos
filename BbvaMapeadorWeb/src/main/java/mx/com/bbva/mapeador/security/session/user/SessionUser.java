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
 * Nombre de proyecto: BbvaMapeadorWeb
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
 * Nombre de clase: SessionUser.java
 * Nombre de paquete: mx.com.bbva.mapeador.security.session.user
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.security.session.user;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class SessionUser.
 */
public class SessionUser implements Serializable {	
	
	/** The cve usuario. */
	private String cveUsuario;
	
	/** The id perfil. */
	private int idPerfil;
	
	/** The id usuario. */
	private int idUsuario;

	/**
	 * Gets the cve usuario.
	 *
	 * @return the cveUsuario
	 */
	public String getCveUsuario() {
		return cveUsuario;
	}

	/**
	 * Gets the id perfil.
	 *
	 * @return the idPerfil
	 */
	public final int getIdPerfil() {
		return idPerfil;
	}

	/**
	 * Gets the id usuario.
	 *
	 * @return the idUsuario
	 */
	public final int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * Sets the cve usuario.
	 *
	 * @param cveUsuario the cveUsuario to set
	 */
	public void setCveUsuario(String cveUsuario) {
		this.cveUsuario = cveUsuario;
	}

	/**
	 * Sets the id perfil.
	 *
	 * @param idPerfil the idPerfil to set
	 */
	public final void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	/**
	 * Sets the id usuario.
	 *
	 * @param idUsuario the idUsuario to set
	 */
	public final void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
