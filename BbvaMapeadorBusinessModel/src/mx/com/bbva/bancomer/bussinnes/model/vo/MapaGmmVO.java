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
 * Nombre de clase: MapaGmmVO.java
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
 * The Class MapaGmmVO.
 */
public class MapaGmmVO extends BbvaAbstractValueObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5584220190403589439L;
	
	/** The descripcion mapa gmm. */
	public String descripcionMapaGmm;
	
	/** The fecha alta. */
	public Date fechaAlta;
	
	/** The fecha modificacion. */
	public Date fechaModificacion;
	
	/** The id estatus objeto. */
	public long idEstatusObjeto;
	
	/** The id mapa gmm. */
	public long idMapaGmm;
	
	/** The nombre estatus objeto. */
	public String nombreEstatusObjeto;
	
	/** The nombre mapa gmm. */
	public String nombreMapaGmm;
	
	/** The nombre proceso si. */
	public String nombreProcesoSi;
	
	/**
	 * Instantiates a new mapa gmm vo.
	 */
	public MapaGmmVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new mapa gmm vo.
	 *
	 * @param idMapaGmm the id mapa gmm
	 * @param nombreMapaGmm the nombre mapa gmm
	 * @param descripcionMapaGmm the descripcion mapa gmm
	 * @param fechaAlta the fecha alta
	 * @param fechaModificacion the fecha modificacion
	 * @param nombreProcesoSi the nombre proceso si
	 * @param idEstatusObjeto the id estatus objeto
	 * @param nombreEstatusObjeto the nombre estatus objeto
	 */
	public MapaGmmVO(long idMapaGmm, String nombreMapaGmm,
			String descripcionMapaGmm, Date fechaAlta, Date fechaModificacion,
			String nombreProcesoSi, long idEstatusObjeto,
			String nombreEstatusObjeto) {
		super();
		this.idMapaGmm = idMapaGmm;
		this.nombreMapaGmm = nombreMapaGmm;
		this.descripcionMapaGmm = descripcionMapaGmm;
		this.fechaAlta = fechaAlta;
		this.fechaModificacion = fechaModificacion;
		this.nombreProcesoSi = nombreProcesoSi;
		this.idEstatusObjeto = idEstatusObjeto;
		this.nombreEstatusObjeto = nombreEstatusObjeto;
	}
	
	/**
	 * Gets the descripcion mapa gmm.
	 *
	 * @return the descripcionMapaGmm
	 */
	public String getDescripcionMapaGmm() {
		return descripcionMapaGmm;
	}
	
	/**
	 * Gets the fecha alta.
	 *
	 * @return the fechaAlta
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}
	
	/**
	 * Gets the fecha modificacion.
	 *
	 * @return the fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	
	/**
	 * Gets the id estatus objeto.
	 *
	 * @return the idEstatusObjeto
	 */
	public long getIdEstatusObjeto() {
		return idEstatusObjeto;
	}
	
	/**
	 * Gets the id mapa gmm.
	 *
	 * @return the idMapaGmm
	 */
	public long getIdMapaGmm() {
		return idMapaGmm;
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
	 * Gets the nombre mapa gmm.
	 *
	 * @return the nombreMapaGmm
	 */
	public String getNombreMapaGmm() {
		return nombreMapaGmm;
	}
	
	/**
	 * Gets the nombre proceso si.
	 *
	 * @return the nombreProcesoSi
	 */
	public String getNombreProcesoSi() {
		return nombreProcesoSi;
	}
	
	/**
	 * Sets the descripcion mapa gmm.
	 *
	 * @param descripcionMapaGmm the descripcionMapaGmm to set
	 */
	public void setDescripcionMapaGmm(String descripcionMapaGmm) {
		this.descripcionMapaGmm = descripcionMapaGmm;
	}
	
	/**
	 * Sets the fecha alta.
	 *
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	/**
	 * Sets the fecha modificacion.
	 *
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
	/**
	 * Sets the id estatus objeto.
	 *
	 * @param idEstatusObjeto the idEstatusObjeto to set
	 */
	public void setIdEstatusObjeto(long idEstatusObjeto) {
		this.idEstatusObjeto = idEstatusObjeto;
	}
	
	/**
	 * Sets the id mapa gmm.
	 *
	 * @param idMapaGmm the idMapaGmm to set
	 */
	public void setIdMapaGmm(long idMapaGmm) {
		this.idMapaGmm = idMapaGmm;
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
	 * Sets the nombre mapa gmm.
	 *
	 * @param nombreMapaGmm the nombreMapaGmm to set
	 */
	public void setNombreMapaGmm(String nombreMapaGmm) {
		this.nombreMapaGmm = nombreMapaGmm;
	}
	
	/**
	 * Sets the nombre proceso si.
	 *
	 * @param nombreProcesoSi the nombreProcesoSi to set
	 */
	public void setNombreProcesoSi(String nombreProcesoSi) {
		this.nombreProcesoSi = nombreProcesoSi;
	}
	
	
}
