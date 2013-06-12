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
 * Nombre de clase: EtapaVO.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.monitoreoprocesos
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.monitoreoprocesos;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class EtapaVO.
 */
public class EtapaVO {
	
	/** The fecha fin. */
	private String fechaFin;
	
	/** The fecha inicio. */
	private String fechaInicio;
	
	/** The fecha status proceso. */
	private Date fechaStatusProceso;
	
	/** The hora proceso fin. */
	private Date horaProcesoFin;
	
	/** The hora proceso ini. */
	private Date horaProcesoIni;
	
	/** The id contratacion. */
	public long idContratacion;
	
	/** The id estatus mapeador. */
	private long idEstatusMapeador;
	
	/** The id etapa. */
	private long idEtapa;
	
	/** The id flujo. */
	private long idFlujo; 
	
	/** The id reg arch entra. */
	private long idRegArchEntra;
	
	/** The imagen estatus. */
	private String imagenEstatus;
	
	/** The nombre estatus mapeador. */
	private String nombreEstatusMapeador;
	
	/** The nombre etapa. */
	private String nombreEtapa; 
	
	/** The nombre flujo. */
	private String nombreFlujo; 
	
	/** The nombre reg arch entra. */
	private String nombreRegArchEntra;
	
	/** The numero lote. */
	private long numeroLote;
	
	/**
	 * Gets the fecha fin.
	 *
	 * @return the fechaFin
	 */
	public String getFechaFin() {
		return fechaFin;
	}
	
	/**
	 * Gets the fecha inicio.
	 *
	 * @return the fechaInicio
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}
	
	/**
	 * Gets the fecha status proceso.
	 *
	 * @return the fechaStatusProceso
	 */
	public Date getFechaStatusProceso() {
		return fechaStatusProceso;
	}
	
	/**
	 * Gets the hora proceso fin.
	 *
	 * @return the horaProcesoFin
	 */
	public Date getHoraProcesoFin() {
		return horaProcesoFin;
	}
	
	/**
	 * Gets the hora proceso ini.
	 *
	 * @return the horaProcesoIni
	 */
	public Date getHoraProcesoIni() {
		return horaProcesoIni;
	}
	
	/**
	 * Gets the id contratacion.
	 *
	 * @return the idContratacion
	 */
	public long getIdContratacion() {
		return idContratacion;
	}
	
	/**
	 * Gets the id estatus mapeador.
	 *
	 * @return the idEstatusMapeador
	 */
	public long getIdEstatusMapeador() {
		return idEstatusMapeador;
	}
	
	/**
	 * Gets the id etapa.
	 *
	 * @return the idEtapa
	 */
	public long getIdEtapa() {
		return idEtapa;
	}
	
	/**
	 * Gets the id flujo.
	 *
	 * @return the idFlujo
	 */
	public long getIdFlujo() {
		return idFlujo;
	}
	
	/**
	 * Gets the id reg arch entra.
	 *
	 * @return the idRegArchEntra
	 */
	public long getIdRegArchEntra() {
		return idRegArchEntra;
	}
	
	/**
	 * Gets the imagen estatus.
	 *
	 * @return the imagenEstatus
	 */
	public String getImagenEstatus() {
		return imagenEstatus;
	}
	
	/**
	 * Gets the nombre estatus mapeador.
	 *
	 * @return the nombreEstatusMapeador
	 */
	public String getNombreEstatusMapeador() {
		return nombreEstatusMapeador;
	}
	
	/**
	 * Gets the nombre etapa.
	 *
	 * @return the nombreEtapa
	 */
	public String getNombreEtapa() {
		return nombreEtapa;
	}
	
	/**
	 * Gets the nombre flujo.
	 *
	 * @return the nombreFlujo
	 */
	public String getNombreFlujo() {
		return nombreFlujo;
	}
	
	/**
	 * Gets the nombre reg arch entra.
	 *
	 * @return the nombreRegArchEntra
	 */
	public String getNombreRegArchEntra() {
		return nombreRegArchEntra;
	}
	
	/**
	 * Gets the numero lote.
	 *
	 * @return the numeroLote
	 */
	public long getNumeroLote() {
		return numeroLote;
	}
	
	/**
	 * Sets the fecha fin.
	 *
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	/**
	 * Sets the fecha inicio.
	 *
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	/**
	 * Sets the fecha status proceso.
	 *
	 * @param fechaStatusProceso the fechaStatusProceso to set
	 */
	public void setFechaStatusProceso(Date fechaStatusProceso) {
		this.fechaStatusProceso = fechaStatusProceso;
	}
	
	/**
	 * Sets the hora proceso fin.
	 *
	 * @param horaProcesoFin the horaProcesoFin to set
	 */
	public void setHoraProcesoFin(Date horaProcesoFin) {
		this.horaProcesoFin = horaProcesoFin;
	}
	
	/**
	 * Sets the hora proceso ini.
	 *
	 * @param horaProcesoIni the horaProcesoIni to set
	 */
	public void setHoraProcesoIni(Date horaProcesoIni) {
		this.horaProcesoIni = horaProcesoIni;
	}
	
	/**
	 * Sets the id contratacion.
	 *
	 * @param idContratacion the idContratacion to set
	 */
	public void setIdContratacion(long idContratacion) {
		this.idContratacion = idContratacion;
	}
	
	/**
	 * Sets the id estatus mapeador.
	 *
	 * @param idEstatusMapeador the idEstatusMapeador to set
	 */
	public void setIdEstatusMapeador(long idEstatusMapeador) {
		this.idEstatusMapeador = idEstatusMapeador;
	}
	
	/**
	 * Sets the id etapa.
	 *
	 * @param idEtapa the idEtapa to set
	 */
	public void setIdEtapa(long idEtapa) {
		this.idEtapa = idEtapa;
	}
	
	/**
	 * Sets the id flujo.
	 *
	 * @param idFlujo the idFlujo to set
	 */
	public void setIdFlujo(long idFlujo) {
		this.idFlujo = idFlujo;
	}
	
	/**
	 * Sets the id reg arch entra.
	 *
	 * @param idRegArchEntra the idRegArchEntra to set
	 */
	public void setIdRegArchEntra(long idRegArchEntra) {
		this.idRegArchEntra = idRegArchEntra;
	}
	
	/**
	 * Sets the imagen estatus.
	 *
	 * @param imagenEstatus the imagenEstatus to set
	 */
	public void setImagenEstatus(String imagenEstatus) {
		this.imagenEstatus = imagenEstatus;
	}
	
	/**
	 * Sets the nombre estatus mapeador.
	 *
	 * @param nombreEstatusMapeador the nombreEstatusMapeador to set
	 */
	public void setNombreEstatusMapeador(String nombreEstatusMapeador) {
		this.nombreEstatusMapeador = nombreEstatusMapeador;
	}
	
	/**
	 * Sets the nombre etapa.
	 *
	 * @param nombreEtapa the nombreEtapa to set
	 */
	public void setNombreEtapa(String nombreEtapa) {
		this.nombreEtapa = nombreEtapa;
	}
	
	/**
	 * Sets the nombre flujo.
	 *
	 * @param nombreFlujo the nombreFlujo to set
	 */
	public void setNombreFlujo(String nombreFlujo) {
		this.nombreFlujo = nombreFlujo;
	}
	
	/**
	 * Sets the nombre reg arch entra.
	 *
	 * @param nombreRegArchEntra the nombreRegArchEntra to set
	 */
	public void setNombreRegArchEntra(String nombreRegArchEntra) {
		this.nombreRegArchEntra = nombreRegArchEntra;
	}
	
	/**
	 * Sets the numero lote.
	 *
	 * @param numeroLote the numeroLote to set
	 */
	public void setNumeroLote(long numeroLote) {
		this.numeroLote = numeroLote;
	} 
	
}
