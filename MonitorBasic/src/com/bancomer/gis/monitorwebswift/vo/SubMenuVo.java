package com.bancomer.gis.monitorwebswift.vo;

import java.util.ArrayList;

public class SubMenuVo extends GeneralVo implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int nu_subseccion;
	private String nb_subseccion;
	private ArrayList<LinkVo> links;
	
	public SubMenuVo(){}

	public SubMenuVo(int nu_subseccion, String nb_subseccion,
			ArrayList<LinkVo> links) {
		this.nu_subseccion = nu_subseccion;
		this.nb_subseccion = nb_subseccion;
		this.links = links;
	}

	public SubMenuVo(int nu_subseccion, String nb_subseccion) {
		this.nu_subseccion = nu_subseccion;
		this.nb_subseccion = nb_subseccion;
	}

	public int getNu_subseccion() {
		return nu_subseccion;
	}

	public void setNu_subseccion(int nu_subseccion) {
		this.nu_subseccion = nu_subseccion;
	}

	public String getNb_subseccion() {
		return nb_subseccion;
	}

	public void setNb_subseccion(String nb_subseccion) {
		this.nb_subseccion = nb_subseccion;
	}

	public ArrayList<LinkVo> getLinks() {
		return links;
	}

	public void setLinks(ArrayList<LinkVo> links) {
		this.links = links;
	}
}
