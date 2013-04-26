package mx.com.bbva.mt101.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * The persistent class for the TGM023_USUARIO database table.
 * 
 */
public class Tgm023Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cdClaveUsuario;

	private String cdContrasenia;

	private BigDecimal cdPais;

	private BigDecimal cdUsuario;

	private BigDecimal ctConexActivas;

	private BigDecimal ctConexLimite;

	private BigDecimal ctLogeoErroneo;

	private String nbApellMat;

	private String nbApellPat;

	private String nbNombreUsr;

	private BigDecimal nuExtension;

	private Timestamp tmCambioCntrasen;

	private Timestamp tmUltimoAcceso;

	private String txCorreoElectr;

	public Tgm023Usuario() {
	}

	public String getCdClaveUsuario() {
		return this.cdClaveUsuario;
	}

	public String getCdContrasenia() {
		return this.cdContrasenia;
	}

	public BigDecimal getCdPais() {
		return this.cdPais;
	}

	public BigDecimal getCdUsuario() {
		return this.cdUsuario;
	}

	public BigDecimal getCtConexActivas() {
		return this.ctConexActivas;
	}

	public BigDecimal getCtConexLimite() {
		return this.ctConexLimite;
	}

	public BigDecimal getCtLogeoErroneo() {
		return this.ctLogeoErroneo;
	}

	public String getNbApellMat() {
		return this.nbApellMat;
	}

	public String getNbApellPat() {
		return this.nbApellPat;
	}

	public String getNbNombreUsr() {
		return this.nbNombreUsr;
	}

	public BigDecimal getNuExtension() {
		return this.nuExtension;
	}

	public Timestamp getTmCambioCntrasen() {
		return this.tmCambioCntrasen;
	}

	public Timestamp getTmUltimoAcceso() {
		return this.tmUltimoAcceso;
	}

	public String getTxCorreoElectr() {
		return this.txCorreoElectr;
	}

	public void setCdClaveUsuario(String cdClaveUsuario) {
		this.cdClaveUsuario = cdClaveUsuario;
	}

	public void setCdContrasenia(String cdContrasenia) {
		this.cdContrasenia = cdContrasenia;
	}

	public void setCdPais(BigDecimal cdPais) {
		this.cdPais = cdPais;
	}

	public void setCdUsuario(BigDecimal cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public void setCtConexActivas(BigDecimal ctConexActivas) {
		this.ctConexActivas = ctConexActivas;
	}

	public void setCtConexLimite(BigDecimal ctConexLimite) {
		this.ctConexLimite = ctConexLimite;
	}

	public void setCtLogeoErroneo(BigDecimal ctLogeoErroneo) {
		this.ctLogeoErroneo = ctLogeoErroneo;
	}

	public void setNbApellMat(String nbApellMat) {
		this.nbApellMat = nbApellMat;
	}

	public void setNbApellPat(String nbApellPat) {
		this.nbApellPat = nbApellPat;
	}

	public void setNbNombreUsr(String nbNombreUsr) {
		this.nbNombreUsr = nbNombreUsr;
	}

	public void setNuExtension(BigDecimal nuExtension) {
		this.nuExtension = nuExtension;
	}

	public void setTmCambioCntrasen(Timestamp tmCambioCntrasen) {
		this.tmCambioCntrasen = tmCambioCntrasen;
	}

	public void setTmUltimoAcceso(Timestamp tmUltimoAcceso) {
		this.tmUltimoAcceso = tmUltimoAcceso;
	}

	public void setTxCorreoElectr(String txCorreoElectr) {
		this.txCorreoElectr = txCorreoElectr;
	}

}