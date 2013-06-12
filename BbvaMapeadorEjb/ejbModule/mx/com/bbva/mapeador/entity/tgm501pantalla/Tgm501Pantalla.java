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
 * Nombre de proyecto: BbvaMapeadorEjb
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
 * Nombre de clase: Tgm501Pantalla.java
 * Nombre de paquete: mx.com.bbva.mapeador.entity.tgm501pantalla
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.entity.tgm501pantalla;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


// TODO: Auto-generated Javadoc
/**
 * The persistent class for the TGM501_PANTALLA database table.
 * 
 */
public class Tgm501Pantalla implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The cd cve usuario. */
	private String cdCveUsuario;
	
	/** The cd fk pantalla. */
	private long cdFkPantalla;
	
	/** The cd pantalla. */
	private long cdPantalla;
	
	/** The cd perfil. */
	private BigDecimal cdPerfil;
	
	/** The nb pantalla. */
	private String nbPantalla;
	
	/** The nu ord pantalla. */
	private BigDecimal nuOrdPantalla;

	/** The tgm501 pantalla. */
	private Tgm501Pantalla tgm501Pantalla;

	/** The tgm501 pantallas. */
	private List<Tgm501Pantalla> tgm501Pantallas;

	/** The tx url icon. */
	private String txUrlIcon;

	/** The tx url pantalla. */
	private String txUrlPantalla;
	
	/**
	 * Instantiates a new tgm501 pantalla.
	 */
	public Tgm501Pantalla() {
	}
	
	/**
	 * Adds the tgm501 pantalla.
	 *
	 * @param tgm501Pantalla the tgm501 pantalla
	 * @return the tgm501 pantalla
	 */
	public Tgm501Pantalla addTgm501Pantalla(Tgm501Pantalla tgm501Pantalla) {
		getTgm501Pantallas().add(tgm501Pantalla);
		tgm501Pantalla.setTgm501Pantalla(this);

		return tgm501Pantalla;
	}
	
	/**
	 * Gets the cd cve usuario.
	 *
	 * @return the cd cve usuario
	 */
	public String getCdCveUsuario() {
		return cdCveUsuario;
	}
	
	/**
	 * Gets the cd fk pantalla.
	 *
	 * @return the cd fk pantalla
	 */
	public long getCdFkPantalla() {
		return cdFkPantalla;
	}	

	/**
	 * Gets the cd pantalla.
	 *
	 * @return the cd pantalla
	 */
	public long getCdPantalla() {
		return this.cdPantalla;
	}

	/**
	 * Gets the cd perfil.
	 *
	 * @return the cd perfil
	 */
	public BigDecimal getCdPerfil() {
		return this.cdPerfil;
	}

	/**
	 * Gets the nb pantalla.
	 *
	 * @return the nb pantalla
	 */
	public String getNbPantalla() {
		return this.nbPantalla;
	}

	/**
	 * Gets the nu ord pantalla.
	 *
	 * @return the nu ord pantalla
	 */
	public BigDecimal getNuOrdPantalla() {
		return this.nuOrdPantalla;
	}

	/**
	 * Gets the tgm501 pantalla.
	 *
	 * @return the tgm501 pantalla
	 */
	public Tgm501Pantalla getTgm501Pantalla() {
		return this.tgm501Pantalla;
	}

	/**
	 * Gets the tgm501 pantallas.
	 *
	 * @return the tgm501 pantallas
	 */
	public List<Tgm501Pantalla> getTgm501Pantallas() {
		return this.tgm501Pantallas;
	}

	/**
	 * Gets the tx url icon.
	 *
	 * @return the tx url icon
	 */
	public String getTxUrlIcon() {
		return this.txUrlIcon;
	}

	/**
	 * Gets the tx url pantalla.
	 *
	 * @return the tx url pantalla
	 */
	public String getTxUrlPantalla() {
		return this.txUrlPantalla;
	}

	/**
	 * Removes the tgm501 pantalla.
	 *
	 * @param tgm501Pantalla the tgm501 pantalla
	 * @return the tgm501 pantalla
	 */
	public Tgm501Pantalla removeTgm501Pantalla(Tgm501Pantalla tgm501Pantalla) {
		getTgm501Pantallas().remove(tgm501Pantalla);
		tgm501Pantalla.setTgm501Pantalla(null);

		return tgm501Pantalla;
	}

	/**
	 * Sets the cd cve usuario.
	 *
	 * @param cdCveUsuario the new cd cve usuario
	 */
	public void setCdCveUsuario(String cdCveUsuario) {
		this.cdCveUsuario = cdCveUsuario;
	}

	/**
	 * Sets the cd fk pantalla.
	 *
	 * @param cdFkPantalla the new cd fk pantalla
	 */
	public void setCdFkPantalla(long cdFkPantalla) {
		this.cdFkPantalla = cdFkPantalla;
	}

	/**
	 * Sets the cd pantalla.
	 *
	 * @param cdPantalla the new cd pantalla
	 */
	public void setCdPantalla(long cdPantalla) {
		this.cdPantalla = cdPantalla;
	}

	/**
	 * Sets the cd perfil.
	 *
	 * @param cdPerfil the new cd perfil
	 */
	public void setCdPerfil(BigDecimal cdPerfil) {
		this.cdPerfil = cdPerfil;
	}

	/**
	 * Sets the nb pantalla.
	 *
	 * @param nbPantalla the new nb pantalla
	 */
	public void setNbPantalla(String nbPantalla) {
		this.nbPantalla = nbPantalla;
	}

	/**
	 * Sets the nu ord pantalla.
	 *
	 * @param nuOrdPantalla the new nu ord pantalla
	 */
	public void setNuOrdPantalla(BigDecimal nuOrdPantalla) {
		this.nuOrdPantalla = nuOrdPantalla;
	}

	/**
	 * Sets the tgm501 pantalla.
	 *
	 * @param tgm501Pantalla the new tgm501 pantalla
	 */
	public void setTgm501Pantalla(Tgm501Pantalla tgm501Pantalla) {
		this.tgm501Pantalla = tgm501Pantalla;
	}

	/**
	 * Sets the tgm501 pantallas.
	 *
	 * @param tgm501Pantallas the new tgm501 pantallas
	 */
	public void setTgm501Pantallas(List<Tgm501Pantalla> tgm501Pantallas) {
		this.tgm501Pantallas = tgm501Pantallas;
	}

	/**
	 * Sets the tx url icon.
	 *
	 * @param txUrlIcon the new tx url icon
	 */
	public void setTxUrlIcon(String txUrlIcon) {
		this.txUrlIcon = txUrlIcon;
	}

	/**
	 * Sets the tx url pantalla.
	 *
	 * @param txUrlPantalla the new tx url pantalla
	 */
	public void setTxUrlPantalla(String txUrlPantalla) {
		this.txUrlPantalla = txUrlPantalla;
	}

}