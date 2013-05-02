package com.bancomer.gis.monitorwebswift.vo;

import java.util.ArrayList;

public class MenuVo extends GeneralVo implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int nu_seccion;
	private String nb_seccion;
	private ArrayList<SubMenuVo> submenus;

	public MenuVo(){}

	public MenuVo(int nu_seccion, String nb_seccion) {
		this.nu_seccion = nu_seccion;
		this.nb_seccion = nb_seccion;
	}

	public MenuVo(int nu_seccion, String nb_seccion,
			ArrayList<SubMenuVo> submenus) {
		this.nu_seccion = nu_seccion;
		this.nb_seccion = nb_seccion;
		this.submenus = submenus;
	}

	public int getNu_seccion() {
		return nu_seccion;
	}

	public void setNu_seccion(int nu_seccion) {
		this.nu_seccion = nu_seccion;
	}

	public String getNb_seccion() {
		return nb_seccion;
	}

	public void setNb_seccion(String nb_seccion) {
		this.nb_seccion = nb_seccion;
	}

	public ArrayList<SubMenuVo> getSubmenus() {
		return submenus;
	}

	public void setSubmenus(ArrayList<SubMenuVo> submenus) {
		this.submenus = submenus;
	}
}
