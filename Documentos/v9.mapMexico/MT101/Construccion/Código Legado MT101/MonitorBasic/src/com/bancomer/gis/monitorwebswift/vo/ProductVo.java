package com.bancomer.gis.monitorwebswift.vo;

public class ProductVo extends GeneralVo implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String description;
	private String active;
	private int pais;
	private String nombrePais;
	
	public ProductVo(){}
	
	public ProductVo(int id, String name, String description, String active) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.active = active;
	}
	public ProductVo(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	
	
	public ProductVo(int id, String name, String description, String active,
			int pais, String nombrePais) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.active = active;
		this.pais = pais;
		this.nombrePais = nombrePais;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public int getPais() {
		return pais;
	}

	public void setPais(int pais) {
		this.pais = pais;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

}
