package com.bancomer.gis.monitorwebswift.vo;

public class CteSwBicInternoVo extends GeneralVo implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private long id_bic;
	private String clave_bic;
	private String nombre;
	private String usuario;
	
	public CteSwBicInternoVo(){}

	public long getId_bic() {
		return id_bic;
	}

	public void setId_bic(long idBic) {
		id_bic = idBic;
	}

	public String getClave_bic() {
		return clave_bic;
	}

	public void setClave_bic(String claveBic) {
		clave_bic = claveBic;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
