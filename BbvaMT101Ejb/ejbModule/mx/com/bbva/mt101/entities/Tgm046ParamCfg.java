package mx.com.bbva.mt101.entities;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The persistent class for the TGM046_PARAM_CFG database table.
 * 
 */
public class Tgm046ParamCfg implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal cdParametro;

	private BigDecimal cdParametroPadre;

	private BigDecimal cdProcesoGis;

	private String nbGrupo;

	private String nbParamCfg;

	private String txValor;

	public Tgm046ParamCfg() {
	}

	public BigDecimal getCdParametro() {
		return this.cdParametro;
	}

	public BigDecimal getCdParametroPadre() {
		return this.cdParametroPadre;
	}

	public BigDecimal getCdProcesoGis() {
		return this.cdProcesoGis;
	}

	public String getNbGrupo() {
		return this.nbGrupo;
	}

	public String getNbParamCfg() {
		return this.nbParamCfg;
	}

	public String getTxValor() {
		return this.txValor;
	}

	public void setCdParametro(BigDecimal cdParametro) {
		this.cdParametro = cdParametro;
	}

	public void setCdParametroPadre(BigDecimal cdParametroPadre) {
		this.cdParametroPadre = cdParametroPadre;
	}

	public void setCdProcesoGis(BigDecimal cdProcesoGis) {
		this.cdProcesoGis = cdProcesoGis;
	}

	public void setNbGrupo(String nbGrupo) {
		this.nbGrupo = nbGrupo;
	}

	public void setNbParamCfg(String nbParamCfg) {
		this.nbParamCfg = nbParamCfg;
	}

	public void setTxValor(String txValor) {
		this.txValor = txValor;
	}

}