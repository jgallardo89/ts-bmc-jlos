package mx.com.bbva.mapeador.entity.tgm503usuario;

import java.io.Serializable;
import javax.persistence.*;

import mx.com.bbva.mapeador.entity.tgm504perfil.Tgm504Perfil;
import mx.com.bbva.mapeador.entity.tgm507bitacora.Tgm507Bitacora;
import mx.com.bbva.mapeador.entity.tgm534StObjeto.Tgm534StObjeto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TGM503_USUARIO database table.
 * 
 */
public class Tgm503Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private long cdUsuario;
	private String cdCveUsuario;
	private Date fhUsuario;
	private String nbUsuario;
	private BigDecimal nuIntentos;
	private Date tmAlta;
	private Date tmCambioPws;
	private Date tmModificacion;
	private String txPasswordUsr;
	private Tgm504Perfil tgm504Perfil;
	private Tgm534StObjeto tgm534StObjeto;
	private List<Tgm507Bitacora> tgm507Bitacoras;

	public Tgm503Usuario() {
	}

	public long getCdUsuario() {
		return this.cdUsuario;
	}

	public void setCdUsuario(long cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public String getCdCveUsuario() {
		return this.cdCveUsuario;
	}

	public void setCdCveUsuario(String cdCveUsuario) {
		this.cdCveUsuario = cdCveUsuario;
	}

	public Date getFhUsuario() {
		return this.fhUsuario;
	}

	public void setFhUsuario(Date fhUsuario) {
		this.fhUsuario = fhUsuario;
	}

	public String getNbUsuario() {
		return this.nbUsuario;
	}

	public void setNbUsuario(String nbUsuario) {
		this.nbUsuario = nbUsuario;
	}

	public BigDecimal getNuIntentos() {
		return this.nuIntentos;
	}

	public void setNuIntentos(BigDecimal nuIntentos) {
		this.nuIntentos = nuIntentos;
	}

	public Date getTmAlta() {
		return this.tmAlta;
	}

	public void setTmAlta(Date tmAlta) {
		this.tmAlta = tmAlta;
	}

	public Date getTmCambioPws() {
		return this.tmCambioPws;
	}

	public void setTmCambioPws(Date tmCambioPws) {
		this.tmCambioPws = tmCambioPws;
	}

	public Date getTmModificacion() {
		return this.tmModificacion;
	}

	public void setTmModificacion(Date tmModificacion) {
		this.tmModificacion = tmModificacion;
	}

	public String getTxPasswordUsr() {
		return this.txPasswordUsr;
	}

	public void setTxPasswordUsr(String txPasswordUsr) {
		this.txPasswordUsr = txPasswordUsr;
	}

	public Tgm504Perfil getTgm504Perfil() {
		return this.tgm504Perfil;
	}

	public void setTgm504Perfil(Tgm504Perfil tgm504Perfil) {
		this.tgm504Perfil = tgm504Perfil;
	}

	public Tgm534StObjeto getTgm534StObjeto() {
		return this.tgm534StObjeto;
	}

	public void setTgm534StObjeto(Tgm534StObjeto tgm534StObjeto) {
		this.tgm534StObjeto = tgm534StObjeto;
	}

	public List<Tgm507Bitacora> getTgm507Bitacoras() {
		return this.tgm507Bitacoras;
	}

	public void setTgm507Bitacoras(List<Tgm507Bitacora> tgm507Bitacoras) {
		this.tgm507Bitacoras = tgm507Bitacoras;
	}

	public Tgm507Bitacora addTgm507Bitacora(Tgm507Bitacora tgm507Bitacora) {
		getTgm507Bitacoras().add(tgm507Bitacora);
		tgm507Bitacora.setTgm503Usuario(this);

		return tgm507Bitacora;
	}

	public Tgm507Bitacora removeTgm507Bitacora(Tgm507Bitacora tgm507Bitacora) {
		getTgm507Bitacoras().remove(tgm507Bitacora);
		tgm507Bitacora.setTgm503Usuario(null);

		return tgm507Bitacora;
	}

}