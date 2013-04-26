package com.bancomer.gis.monitorwebswift.vo;

import java.io.Serializable;

public class ServiceVo extends GeneralVo implements Serializable {
	
	int id;
	String name;
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
	
	public ServiceVo(){	}
	
	public ServiceVo(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
