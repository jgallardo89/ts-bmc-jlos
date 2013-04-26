package com.bancomer.gis.monitorwebswift.vo;

public class BICEuroVo extends GeneralVo implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int nu_cod_bic_euro;
	private String nb_cod_bic_euro;
	
	public BICEuroVo(){}

	public BICEuroVo(int nu_cod_bic_euro, String nb_cod_bic_euro) {
		this.nu_cod_bic_euro = nu_cod_bic_euro;
		this.nb_cod_bic_euro = nb_cod_bic_euro;
	}

	public int getNu_cod_bic_euro() {
		return nu_cod_bic_euro;
	}

	public void setNu_cod_bic_euro(int nu_cod_bic_euro) {
		this.nu_cod_bic_euro = nu_cod_bic_euro;
	}

	public String getNb_cod_bic_euro() {
		return nb_cod_bic_euro;
	}

	public void setNb_cod_bic_euro(String nb_cod_bic_euro) {
		this.nb_cod_bic_euro = nb_cod_bic_euro;
	}
	
	

}
