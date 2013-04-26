package com.bancomer.gis.monitorwebswift.vo;

public class LinkVo extends GeneralVo implements java.io.Serializable,Comparable{

	private static final long serialVersionUID = 1L;
	private int nu_liga;
	private int nu_tipo_liga;
	private String nb_liga;
	private String nb_ruta_liga;
	private int tp_liga_privada;
	private String nb_descripcion;
	private int order;
	
	public LinkVo(){}

	public LinkVo(int nu_liga, int nu_tipo_liga, String nb_liga,
			String nb_ruta_liga, int tp_liga_privada, String nb_descripcion, int order) {
		this.nu_liga = nu_liga;
		this.nu_tipo_liga = nu_tipo_liga;
		this.nb_liga = nb_liga;
		this.nb_ruta_liga = nb_ruta_liga;
		this.tp_liga_privada = tp_liga_privada;
		this.nb_descripcion = nb_descripcion;
		this.order = order;
	}

	public int getNu_liga() {
		return nu_liga;
	}

	public void setNu_liga(int nu_liga) {
		this.nu_liga = nu_liga;
	}

	public int getNu_tipo_liga() {
		return nu_tipo_liga;
	}

	public void setNu_tipo_liga(int nu_tipo_liga) {
		this.nu_tipo_liga = nu_tipo_liga;
	}

	public String getNb_liga() {
		return nb_liga;
	}

	public void setNb_liga(String nb_liga) {
		this.nb_liga = nb_liga;
	}

	public String getNb_ruta_liga() {
		return nb_ruta_liga;
	}

	public void setNb_ruta_liga(String nb_ruta_liga) {
		this.nb_ruta_liga = nb_ruta_liga;
	}

	public int getTp_liga_privada() {
		return tp_liga_privada;
	}

	public void setTp_liga_privada(int tp_liga_privada) {
		this.tp_liga_privada = tp_liga_privada;
	}

	public String getNb_descripcion() {
		return nb_descripcion;
	}

	public void setNb_descripcion(String nb_descripcion) {
		this.nb_descripcion = nb_descripcion;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
	public int compareTo(Object o) {
		if(o instanceof LinkVo){
			LinkVo linkCompare = (LinkVo)o;
			if(linkCompare.getOrder()>this.order){
				return -1;
			}
			else if(linkCompare.getOrder()==this.order){
				return 0;
			}else if(linkCompare.getOrder()<this.order) {
				return 1;
			}
			else{
				return -1;
			}
		}
		else{
			return -1;
		}
	}
}
