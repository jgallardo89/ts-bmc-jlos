package com.bancomer.gis.monitorwebswift.vo;

import java.io.Serializable;


public class BlobRegistry extends GeneralVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idDocto;
	private Long nuLiga;
	private String nombreDocto;
	private Long nuOrden;
	private String liga; 

	
	
	public String getLiga() {
		return liga;
	}
	public void setLiga(String liga) {
		this.liga = liga;
	}
	public Long getIdDocto() {
		return idDocto;
	}
	public void setIdDocto(Long idDocto) {
		this.idDocto = idDocto;
	}
	public String getNombreDocto() {
		return nombreDocto;
	}
	public void setNombreDocto(String nombreDocto) {
		this.nombreDocto = nombreDocto;
	}
	public Long getNuLiga() {
		return nuLiga;
	}
	public void setNuLiga(Long nuLiga) {
		this.nuLiga = nuLiga;
	}
	public Long getNuOrden() {
		return nuOrden;
	}
	public void setNuOrden(Long nuOrden) {
		this.nuOrden = nuOrden;
	}
	

}
