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
 * Nombre de clase: BitacoraArchivoVO.java
 * Nombre de paquete: mx.com.bbva.bancomer.bussinnes.model.vo
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

// TODO: Auto-generated Javadoc
/**
 * The Class BitacoraArchivoVO.
 */
public class BitacoraArchivoVO extends BbvaAbstractValueObject {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7756929105459324889L;
	
	/** The estado archivo. */
	private String estadoArchivo;
	
	/** The fecha archivo. */
	private String fechaArchivo;
	
	/** The fecha fin. */
	private Date fechaFin;
	
	/** The fecha inici. */
	private Date fechaInici;
	
	/** The id estatus. */
	private int idEstatus;
	
	/** The nombre archivo. */
	private String nombreArchivo;
	
	/**
	 * Gets the estado archivo.
	 *
	 * @return the estadoArchivo
	 */
	public final String getEstadoArchivo() {
		return estadoArchivo;
	}
	
	/**
	 * Gets the fecha archivo.
	 *
	 * @return the fechaArchivo
	 */
	public final String getFechaArchivo() {
		return fechaArchivo;
	}
	
	/**
	 * Gets the fecha fin.
	 *
	 * @return the fechaFin
	 */
	public String getFechaFin() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");				
		if(fechaFin!=null)
			return dateFormat.format(fechaFin);
		else
			return null;
	}
	
	/**
	 * Gets the fecha inici.
	 *
	 * @return the fechaInici
	 */
	public String getFechaInici() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");				
		if(fechaInici!=null)
			return dateFormat.format(fechaInici);
		else
			return null;			
	}
	
	/**
	 * Gets the id estatus.
	 *
	 * @return the idEstatus
	 */
	public final int getIdEstatus() {
		return idEstatus;
	}
	
	/**
	 * Gets the nombre archivo.
	 *
	 * @return the nombreArchivo
	 */
	public final String getNombreArchivo() {
		return nombreArchivo;
	}	
	
	/**
	 * Sets the estado archivo.
	 *
	 * @param estadoArchivo the estadoArchivo to set
	 */
	public final void setEstadoArchivo(String estadoArchivo) {
		this.estadoArchivo = estadoArchivo;
	}
	
	/**
	 * Sets the fecha archivo.
	 *
	 * @param fechaArchivo the fechaArchivo to set
	 */
	public final void setFechaArchivo(String fechaArchivo) {
		this.fechaArchivo = fechaArchivo;
	}
	
	/**
	 * Sets the fecha fin.
	 *
	 * @param fechaFin the fechaFin to set
	 */
	public final void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	/**
	 * Sets the fecha inici.
	 *
	 * @param fechaInici the fechaInici to set
	 */
	public final void setFechaInici(Date fechaInici) {
		this.fechaInici = fechaInici;
	}
	
	/**
	 * Sets the id estatus.
	 *
	 * @param idEstatus the idEstatus to set
	 */
	public final void setIdEstatus(int idEstatus) {
		this.idEstatus = idEstatus;
	}
	
	/**
	 * Sets the nombre archivo.
	 *
	 * @param nombreArchivo the nombreArchivo to set
	 */
	public final void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	
}
