package mx.com.bbva.bancomer.bussinnes.model.vo;

import java.util.Date;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

public class MapaGmmVO extends BbvaAbstractValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5584220190403589439L;
	public long idMapaGmm;
	public String nombreMapaGmm;
	public String descripcionMapaGmm;
	public Date fechaAlta;
	public Date fechaModificacion;
	public String nombreProcesoSi;
	public long idEstatusObjeto;
	public String nombreEstatusObjeto;
	/**
	 * 
	 */
	public MapaGmmVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param idMapaGmm
	 * @param nombreMapaGmm
	 * @param descripcionMapaGmm
	 * @param fechaAlta
	 * @param fechaModificacion
	 * @param nombreProcesoSi
	 * @param idEstatusObjeto
	 * @param nombreEstatusObjeto
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
	 * @return the idMapaGmm
	 */
	public long getIdMapaGmm() {
		return idMapaGmm;
	}
	/**
	 * @param idMapaGmm the idMapaGmm to set
	 */
	public void setIdMapaGmm(long idMapaGmm) {
		this.idMapaGmm = idMapaGmm;
	}
	/**
	 * @return the nombreMapaGmm
	 */
	public String getNombreMapaGmm() {
		return nombreMapaGmm;
	}
	/**
	 * @param nombreMapaGmm the nombreMapaGmm to set
	 */
	public void setNombreMapaGmm(String nombreMapaGmm) {
		this.nombreMapaGmm = nombreMapaGmm;
	}
	/**
	 * @return the descripcionMapaGmm
	 */
	public String getDescripcionMapaGmm() {
		return descripcionMapaGmm;
	}
	/**
	 * @param descripcionMapaGmm the descripcionMapaGmm to set
	 */
	public void setDescripcionMapaGmm(String descripcionMapaGmm) {
		this.descripcionMapaGmm = descripcionMapaGmm;
	}
	/**
	 * @return the fechaAlta
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}
	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	/**
	 * @return the fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	/**
	 * @return the nombreProcesoSi
	 */
	public String getNombreProcesoSi() {
		return nombreProcesoSi;
	}
	/**
	 * @param nombreProcesoSi the nombreProcesoSi to set
	 */
	public void setNombreProcesoSi(String nombreProcesoSi) {
		this.nombreProcesoSi = nombreProcesoSi;
	}
	/**
	 * @return the idEstatusObjeto
	 */
	public long getIdEstatusObjeto() {
		return idEstatusObjeto;
	}
	/**
	 * @param idEstatusObjeto the idEstatusObjeto to set
	 */
	public void setIdEstatusObjeto(long idEstatusObjeto) {
		this.idEstatusObjeto = idEstatusObjeto;
	}
	/**
	 * @return the nombreEstatusObjeto
	 */
	public String getNombreEstatusObjeto() {
		return nombreEstatusObjeto;
	}
	/**
	 * @param nombreEstatusObjeto the nombreEstatusObjeto to set
	 */
	public void setNombreEstatusObjeto(String nombreEstatusObjeto) {
		this.nombreEstatusObjeto = nombreEstatusObjeto;
	}
	
	
}
