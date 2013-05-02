package com.bancomer.gis.monitorwebswift.vo;

import java.io.Serializable;
import java.util.Date;

public class SwiftDetailVo extends GeneralVo implements Serializable{
	
	private int nu_lote_ent;
	private int nu_arch_procesado;
	private int nu_archivo_generado;
	private int nu_posicion_lote;
	private String cd_pais;
	private String cd_canal;
	private String cd_num_referencia;
	private String tx_cabecera_lote;
	private int nu_ote_envio;
	private Date tm_proceso_lote;
	private Date tm_ultimo_reproc;
	private Date tm_recepcion_acuse;

	
	public SwiftDetailVo(){}


	public int getNu_lote_ent() {
		return nu_lote_ent;
	}


	public void setNu_lote_ent(int nu_lote_ent) {
		this.nu_lote_ent = nu_lote_ent;
	}


	public int getNu_arch_procesado() {
		return nu_arch_procesado;
	}


	public void setNu_arch_procesado(int nu_arch_procesado) {
		this.nu_arch_procesado = nu_arch_procesado;
	}


	public int getNu_archivo_generado() {
		return nu_archivo_generado;
	}


	public void setNu_archivo_generado(int nu_archivo_generado) {
		this.nu_archivo_generado = nu_archivo_generado;
	}


	public int getNu_posicion_lote() {
		return nu_posicion_lote;
	}


	public void setNu_posicion_lote(int nu_posicion_lote) {
		this.nu_posicion_lote = nu_posicion_lote;
	}


	public String getCd_pais() {
		return cd_pais;
	}


	public void setCd_pais(String cd_pais) {
		this.cd_pais = cd_pais;
	}


	public String getCd_canal() {
		return cd_canal;
	}


	public void setCd_canal(String cd_canal) {
		this.cd_canal = cd_canal;
	}


	public String getCd_num_referencia() {
		return cd_num_referencia;
	}


	public void setCd_num_referencia(String cd_num_referencia) {
		this.cd_num_referencia = cd_num_referencia;
	}


	public String getTx_cabecera_lote() {
		return tx_cabecera_lote;
	}


	public void setTx_cabecera_lote(String tx_cabecera_lote) {
		this.tx_cabecera_lote = tx_cabecera_lote;
	}


	public int getNu_ote_envio() {
		return nu_ote_envio;
	}


	public void setNu_ote_envio(int nu_ote_envio) {
		this.nu_ote_envio = nu_ote_envio;
	}


	public Date getTm_proceso_lote() {
		return tm_proceso_lote;
	}


	public void setTm_proceso_lote(Date tm_proceso_lote) {
		this.tm_proceso_lote = tm_proceso_lote;
	}


	public Date getTm_ultimo_reproc() {
		return tm_ultimo_reproc;
	}


	public void setTm_ultimo_reproc(Date tm_ultimo_reproc) {
		this.tm_ultimo_reproc = tm_ultimo_reproc;
	}


	public Date getTm_recepcion_acuse() {
		return tm_recepcion_acuse;
	}


	public void setTm_recepcion_acuse(Date tm_recepcion_acuse) {
		this.tm_recepcion_acuse = tm_recepcion_acuse;
	}


	public SwiftDetailVo(int nu_lote_ent, int nu_arch_procesado,
			int nu_archivo_generado, int nu_posicion_lote, String cd_pais,
			String cd_canal, String cd_num_referencia, String tx_cabecera_lote,
			int nu_ote_envio, Date tm_proceso_lote, Date tm_ultimo_reproc,
			Date tm_recepcion_acuse) {
		this.nu_lote_ent = nu_lote_ent;
		this.nu_arch_procesado = nu_arch_procesado;
		this.nu_archivo_generado = nu_archivo_generado;
		this.nu_posicion_lote = nu_posicion_lote;
		this.cd_pais = cd_pais;
		this.cd_canal = cd_canal;
		this.cd_num_referencia = cd_num_referencia;
		this.tx_cabecera_lote = tx_cabecera_lote;
		this.nu_ote_envio = nu_ote_envio;
		this.tm_proceso_lote = tm_proceso_lote;
		this.tm_ultimo_reproc = tm_ultimo_reproc;
		this.tm_recepcion_acuse = tm_recepcion_acuse;
	}
	
	
}
