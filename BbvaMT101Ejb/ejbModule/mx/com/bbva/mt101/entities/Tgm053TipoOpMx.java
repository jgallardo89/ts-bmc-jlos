package mx.com.bbva.mt101.entities;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The persistent class for the TGM053_TIPO_OP_MX database table.
 * 
 */
public class Tgm053TipoOpMx implements Serializable {
	private static final long serialVersionUID = 1L;

	private long cdTpOperacion;

	private BigDecimal imComisionEur;

	private BigDecimal imComisionMxn;

	private BigDecimal imComisionUsd;

	private String nbTpOperacion;

	private String nuCodigoSicoco;

	private String tpMensaje;

	private String txTpOperacion;

	private String txTpOperacion1;

	public Tgm053TipoOpMx() {
	}

	public long getCdTpOperacion() {
		return this.cdTpOperacion;
	}

	public BigDecimal getImComisionEur() {
		return this.imComisionEur;
	}

	public BigDecimal getImComisionMxn() {
		return this.imComisionMxn;
	}

	public BigDecimal getImComisionUsd() {
		return this.imComisionUsd;
	}

	public String getNbTpOperacion() {
		return this.nbTpOperacion;
	}

	public String getNuCodigoSicoco() {
		return this.nuCodigoSicoco;
	}

	public String getTpMensaje() {
		return this.tpMensaje;
	}

	public String getTxTpOperacion() {
		return this.txTpOperacion;
	}

	public String getTxTpOperacion1() {
		return this.txTpOperacion1;
	}

	public void setCdTpOperacion(long cdTpOperacion) {
		this.cdTpOperacion = cdTpOperacion;
	}

	public void setImComisionEur(BigDecimal imComisionEur) {
		this.imComisionEur = imComisionEur;
	}

	public void setImComisionMxn(BigDecimal imComisionMxn) {
		this.imComisionMxn = imComisionMxn;
	}

	public void setImComisionUsd(BigDecimal imComisionUsd) {
		this.imComisionUsd = imComisionUsd;
	}

	public void setNbTpOperacion(String nbTpOperacion) {
		this.nbTpOperacion = nbTpOperacion;
	}

	public void setNuCodigoSicoco(String nuCodigoSicoco) {
		this.nuCodigoSicoco = nuCodigoSicoco;
	}

	public void setTpMensaje(String tpMensaje) {
		this.tpMensaje = tpMensaje;
	}

	public void setTxTpOperacion(String txTpOperacion) {
		this.txTpOperacion = txTpOperacion;
	}

	public void setTxTpOperacion1(String txTpOperacion1) {
		this.txTpOperacion1 = txTpOperacion1;
	}

}