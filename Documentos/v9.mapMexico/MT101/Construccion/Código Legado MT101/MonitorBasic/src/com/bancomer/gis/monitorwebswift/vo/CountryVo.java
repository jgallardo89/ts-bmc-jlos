package com.bancomer.gis.monitorwebswift.vo;



public class CountryVo extends GeneralVo implements java.io.Serializable, java.lang.Comparable<Object>{
	
	private int nu_pais;
	private String cd_pais;
	private String nb_pais;
	private String cd_banco_interno;
	private String cd2_pais;
	
	public CountryVo(){}
	
	public CountryVo(int nu_pais, String cd_pais, String nb_pais, String cd_banco_interno, String cd2_pais) {
		super();
		this.nu_pais = nu_pais;
		this.cd_pais = cd_pais;
		this.nb_pais = nb_pais;
		this.cd_banco_interno = cd_banco_interno;
		this.cd2_pais = cd2_pais;
	}
	
	public CountryVo(int nu_pais, String cd_pais, String nb_pais) {
		super();
		this.nu_pais = nu_pais;
		this.cd_pais = cd_pais;
		this.nb_pais = nb_pais;
	}
	
	public CountryVo(String cd_pais, String nb_pais) {
		this.cd_pais = cd_pais;
		this.nb_pais = nb_pais;
	}
	public int getNu_pais() {
		return nu_pais;
	}
	public void setNu_pais(int nu_pais) {
		this.nu_pais = nu_pais;
	}
	public String getCd_pais() {
		return cd_pais;
	}
	public void setCd_pais(String cd_pais) {
		this.cd_pais = cd_pais;
	}
	public String getNb_pais() {
		return nb_pais;
	}
	public void setNb_pais(String nb_pais) {
		this.nb_pais = nb_pais;
	}

	public String getCd2_pais() {
		return cd2_pais;
	}

	public void setCd2_pais(String cd2_pais) {
		this.cd2_pais = cd2_pais;
	}
	
	public String getCd_banco_interno() {
		return cd_banco_interno;
	}

	public void setCd_banco_interno(String cd_banco_interno) {
		this.cd_banco_interno = cd_banco_interno;
	}

	public int compareTo(Object countryVo){
		int result = 0;
		if(countryVo!=null&& countryVo instanceof CountryVo){
			result = this.getNb_pais().compareTo(((CountryVo)countryVo).getNb_pais());
		}
		return result;
	}
	
}
