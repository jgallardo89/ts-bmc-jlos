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
 * Nombre de clase: RegistroProcesoVO.java
 * Nombre de paquete: mx.com.bbva.bancomer.bussinnes.model.vo
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.util.Date;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;
// TODO: Auto-generated Javadoc

/**
 * The Class RegistroProcesoVO.
 */
public class RegistroProcesoVO extends BbvaAbstractValueObject {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -9097673350468469013L;
	
	/** The fecha fin. */
	private String fechaFin;
	
	/** The fecha inicio. */
	private String fechaInicio;
	
	/** The fecha lote. */
	private Date fechaLote;
	
	/** The fecha status proceso. */
	private Date fechaStatusProceso;
	
	/** The hora proceso fin. */
	private Date horaProcesoFin;
	
	/** The hora proceso ini. */
	private Date horaProcesoIni;
	
	/** The id canal. */
	private long idCanal;
	
	/** The id cliente. */
	private long idCliente;
	
	/** The id contratacion. */
	public long idContratacion;
	
	/** The id estatus mapeador. */
	private long idEstatusMapeador;
	
	/** The id etapa. */
	private long idEtapa;
	
	/** The id flujo. */
	private long idFlujo;
	
	/** The id identificador. */
	private String idIdentificador;
	
	/** The id producto. */
	private long idProducto;
	
	/** The id reg arch entra. */
	private long idRegArchEntra;
	
	/** The nombre canal. */
	private String nombreCanal;
	
	/** The nombre estatus mapeador. */
	private String nombreEstatusMapeador;
	
	/** The nombre etapa. */
	private String nombreEtapa;
	
	/** The nombre flujo. */
	private String nombreFlujo;
	
	/** The nombre producto. */
	private String nombreProducto;
	
	/** The nombre reg arch entra. */
	private String nombreRegArchEntra;
	
	/** The numero lote. */
	private long numeroLote; 
	
	/**
	 * Instantiates a new registro proceso vo.
	 */
	public RegistroProcesoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new registro proceso vo.
	 *
	 * @param idContratacion the id contratacion
	 * @param idCanal the id canal
	 * @param nombreCanal the nombre canal
	 * @param idCliente the id cliente
	 * @param idIdentificador the id identificador
	 * @param idProducto the id producto
	 * @param nombreProducto the nombre producto
	 * @param numeroLote the numero lote
	 * @param fechaLote the fecha lote
	 * @param idRegArchEntra the id reg arch entra
	 * @param nombreRegArchEntra the nombre reg arch entra
	 * @param horaProcesoIni the hora proceso ini
	 * @param horaProcesoFin the hora proceso fin
	 * @param fechaStatusProceso the fecha status proceso
	 * @param idFlujo the id flujo
	 * @param nombreFlujo the nombre flujo
	 * @param idEtapa the id etapa
	 * @param nombreEtapa the nombre etapa
	 * @param idEstatusMapeador the id estatus mapeador
	 * @param nombreEstatusMapeador the nombre estatus mapeador
	 * @param fechaInicio the fecha inicio
	 * @param fechaFin the fecha fin
	 */
	public RegistroProcesoVO(long idContratacion, long idCanal,
			String nombreCanal, long idCliente, String idIdentificador,
			long idProducto, String nombreProducto, long numeroLote,
			Date fechaLote, long idRegArchEntra, String nombreRegArchEntra,
			Date horaProcesoIni, Date horaProcesoFin, Date fechaStatusProceso,
			long idFlujo, String nombreFlujo, long idEtapa, String nombreEtapa,
			long idEstatusMapeador, String nombreEstatusMapeador,
			String fechaInicio, String fechaFin) {
		super();
		this.idContratacion = idContratacion;
		this.idCanal = idCanal;
		this.nombreCanal = nombreCanal;
		this.idCliente = idCliente;
		this.idIdentificador = idIdentificador;
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.numeroLote = numeroLote;
		this.fechaLote = fechaLote;
		this.idRegArchEntra = idRegArchEntra;
		this.nombreRegArchEntra = nombreRegArchEntra;
		this.horaProcesoIni = horaProcesoIni;
		this.horaProcesoFin = horaProcesoFin;
		this.fechaStatusProceso = fechaStatusProceso;
		this.idFlujo = idFlujo;
		this.nombreFlujo = nombreFlujo;
		this.idEtapa = idEtapa;
		this.nombreEtapa = nombreEtapa;
		this.idEstatusMapeador = idEstatusMapeador;
		this.nombreEstatusMapeador = nombreEstatusMapeador;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
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
	 * Gets the fecha lote.
	 *
	 * @return the fechaLote
	 */
	public Date getFechaLote() {
		return fechaLote;
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
	 * Gets the id canal.
	 *
	 * @return the idCanal
	 */
	public long getIdCanal() {
		return idCanal;
	}
	
	/**
	 * Gets the id cliente.
	 *
	 * @return the idCliente
	 */
	public long getIdCliente() {
		return idCliente;
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
	 * Gets the id identificador.
	 *
	 * @return the idIdentificador
	 */
	public String getIdIdentificador() {
		return idIdentificador;
	}
	
	/**
	 * Gets the id producto.
	 *
	 * @return the idProducto
	 */
	public long getIdProducto() {
		return idProducto;
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
	 * Gets the nombre canal.
	 *
	 * @return the nombreCanal
	 */
	public String getNombreCanal() {
		return nombreCanal;
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
	 * Gets the nombre producto.
	 *
	 * @return the nombreProducto
	 */
	public String getNombreProducto() {
		return nombreProducto;
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
	 * Sets the fecha lote.
	 *
	 * @param fechaLote the fechaLote to set
	 */
	public void setFechaLote(Date fechaLote) {
		this.fechaLote = fechaLote;
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
	 * Sets the id canal.
	 *
	 * @param idCanal the idCanal to set
	 */
	public void setIdCanal(long idCanal) {
		this.idCanal = idCanal;
	}
	
	/**
	 * Sets the id cliente.
	 *
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
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
	 * Sets the id identificador.
	 *
	 * @param idIdentificador the idIdentificador to set
	 */
	public void setIdIdentificador(String idIdentificador) {
		this.idIdentificador = idIdentificador;
	}
	
	/**
	 * Sets the id producto.
	 *
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
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
	 * Sets the nombre canal.
	 *
	 * @param nombreCanal the nombreCanal to set
	 */
	public void setNombreCanal(String nombreCanal) {
		this.nombreCanal = nombreCanal;
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
	 * Sets the nombre producto.
	 *
	 * @param nombreProducto the nombreProducto to set
	 */
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
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
