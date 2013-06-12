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
 * Nombre de clase: ComponenteVO.java
 * Nombre de paquete: mx.com.bbva.bancomer.bussinnes.model.vo
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.bussinnes.model.vo;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

// TODO: Auto-generated Javadoc
/**
 * The Class ComponenteVO.
 */
public class ComponenteVO extends BbvaAbstractValueObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5822068522237430017L;
	
	/** The estatus componen. */
	public long estatusComponen;
	
	/** The id componente. */
	public long idComponente;
	
	/** The id default. */
	public String idDefault;
	
	/** The id pantalla. */
	public long idPantalla;	
	
	/** The id perfil. */
	public long idPerfil;
	
	/** The id tipo componente. */
	public int idTipoComponente;
	
	/** The nombre componente. */
	public String nombreComponente;
	
	/** The nombre estatus. */
	public String nombreEstatus;
	
	/** The nombre pantalla. */
	public String nombrePantalla;
	
	/** The nombre p erfil. */
	public String nombrePErfil;
	
	/** The nombre tipo componente. */
	public String nombreTipoComponente;
	
	/**
	 * Instantiates a new componente vo.
	 */
	public ComponenteVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new componente vo.
	 *
	 * @param idPantalla the id pantalla
	 * @param idComponente the id componente
	 * @param nombreComponente the nombre componente
	 * @param idTipoComponente the id tipo componente
	 * @param idDefault the id default
	 * @param estatusComponen the estatus componen
	 * @param nombrePantalla the nombre pantalla
	 * @param nombreEstatus the nombre estatus
	 */
	public ComponenteVO(long idPantalla, long idComponente,
			String nombreComponente, int idTipoComponente, String idDefault,
			long estatusComponen, String nombrePantalla, String nombreEstatus) {
		super();
		this.idPantalla = idPantalla;
		this.idComponente = idComponente;
		this.nombreComponente = nombreComponente;
		this.idTipoComponente = idTipoComponente;
		this.idDefault = idDefault;
		this.estatusComponen = estatusComponen;
		this.nombrePantalla = nombrePantalla;
		this.nombreEstatus = nombreEstatus;
	}
	
	/**
	 * Gets the estatus componen.
	 *
	 * @return the estatusComponen
	 */
	public long getEstatusComponen() {
		return estatusComponen;
	}
	
	/**
	 * Gets the id componente.
	 *
	 * @return the idComponente
	 */
	public long getIdComponente() {
		return idComponente;
	}
	
	/**
	 * Gets the id default.
	 *
	 * @return the idDefault
	 */
	public String getIdDefault() {
		return idDefault;
	}
	
	/**
	 * Gets the id pantalla.
	 *
	 * @return the idPantalla
	 */
	public long getIdPantalla() {
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
	 * Gets the id tipo componente.
	 *
	 * @return the tipoComponente
	 */
	public int getIdTipoComponente() {
		return idTipoComponente;
	}
	
	/**
	 * Gets the nombre componente.
	 *
	 * @return the nombreComponente
	 */
	public String getNombreComponente() {
		return nombreComponente;
	}
	
	/**
	 * Gets the nombre estatus.
	 *
	 * @return the nombreEstatus
	 */
	public String getNombreEstatus() {
		return nombreEstatus;
	}
	
	/**
	 * Gets the nombre pantalla.
	 *
	 * @return the nombrePantalla
	 */
	public String getNombrePantalla() {
		return nombrePantalla;
	}
	
	/**
	 * Gets the nombre p erfil.
	 *
	 * @return the nombrePErfil
	 */
	public final String getNombrePErfil() {
		return nombrePErfil;
	}
	
	/**
	 * Gets the nombre tipo componente.
	 *
	 * @return the nombreTipoComponente
	 */
	public final String getNombreTipoComponente() {
		return nombreTipoComponente;
	}
	
	/**
	 * Sets the estatus componen.
	 *
	 * @param estatusComponen the estatusComponen to set
	 */
	public void setEstatusComponen(long estatusComponen) {
		this.estatusComponen = estatusComponen;
	}
	
	/**
	 * Sets the id componente.
	 *
	 * @param idComponente the idComponente to set
	 */
	public void setIdComponente(long idComponente) {
		this.idComponente = idComponente;
	}
	
	/**
	 * Sets the id default.
	 *
	 * @param idDefault the idDefault to set
	 */
	public void setIdDefault(String idDefault) {
		this.idDefault = idDefault;
	}
	
	/**
	 * Sets the id pantalla.
	 *
	 * @param idPantalla the idPantalla to set
	 */
	public void setIdPantalla(long idPantalla) {
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
	 * Sets the id tipo componente.
	 *
	 * @param idTipoComponente the new id tipo componente
	 */
	public void setIdTipoComponente(int idTipoComponente) {
		this.idTipoComponente = idTipoComponente;
	}
	
	/**
	 * Sets the nombre componente.
	 *
	 * @param nombreComponente the nombreComponente to set
	 */
	public void setNombreComponente(String nombreComponente) {
		this.nombreComponente = nombreComponente;
	}
	
	/**
	 * Sets the nombre estatus.
	 *
	 * @param nombreEstatus the nombreEstatus to set
	 */
	public void setNombreEstatus(String nombreEstatus) {
		this.nombreEstatus = nombreEstatus;
	}
	
	/**
	 * Sets the nombre pantalla.
	 *
	 * @param nombrePantalla the nombrePantalla to set
	 */
	public void setNombrePantalla(String nombrePantalla) {
		this.nombrePantalla = nombrePantalla;
	}
	
	/**
	 * Sets the nombre p erfil.
	 *
	 * @param nombrePErfil the nombrePErfil to set
	 */
	public final void setNombrePErfil(String nombrePErfil) {
		this.nombrePErfil = nombrePErfil;
	}
	
	/**
	 * Sets the nombre tipo componente.
	 *
	 * @param nombreTipoComponente the nombreTipoComponente to set
	 */
	public final void setNombreTipoComponente(String nombreTipoComponente) {
		this.nombreTipoComponente = nombreTipoComponente;
	}
	
}
