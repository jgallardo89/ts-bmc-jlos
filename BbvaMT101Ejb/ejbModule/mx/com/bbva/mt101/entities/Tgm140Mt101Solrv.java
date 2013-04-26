package mx.com.bbva.mt101.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TGM140_MT101_SOLRV database table.
 * 
 */
public class Tgm140Mt101Solrv implements Serializable {
	private static final long serialVersionUID = 1L;

	private long cdSolReenvio;

	private BigDecimal cdEnvCash;

	private BigDecimal cdUsuario;

	private BigDecimal nuLote;

	private BigDecimal stLote;

	private Date tmFechaLote;

	private Date tmReenvio;

	private String txComentario;

	public Tgm140Mt101Solrv() {
	}

	public long getCdSolReenvio() {
		return this.cdSolReenvio;
	}

	public void setCdSolReenvio(long cdSolReenvio) {
		this.cdSolReenvio = cdSolReenvio;
	}

	public BigDecimal getCdEnvCash() {
		return this.cdEnvCash;
	}

	public void setCdEnvCash(BigDecimal cdEnvCash) {
		this.cdEnvCash = cdEnvCash;
	}

	public BigDecimal getCdUsuario() {
		return this.cdUsuario;
	}

	public void setCdUsuario(BigDecimal cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public BigDecimal getNuLote() {
		return this.nuLote;
	}

	public void setNuLote(BigDecimal nuLote) {
		this.nuLote = nuLote;
	}

	public BigDecimal getStLote() {
		return this.stLote;
	}

	public void setStLote(BigDecimal stLote) {
		this.stLote = stLote;
	}

	public Date getTmFechaLote() {
		return this.tmFechaLote;
	}

	public void setTmFechaLote(Date tmFechaLote) {
		this.tmFechaLote = tmFechaLote;
	}

	public Date getTmReenvio() {
		return this.tmReenvio;
	}

	public void setTmReenvio(Date tmReenvio) {
		this.tmReenvio = tmReenvio;
	}

	public String getTxComentario() {
		return this.txComentario;
	}

	public void setTxComentario(String txComentario) {
		this.txComentario = txComentario;
	}

}