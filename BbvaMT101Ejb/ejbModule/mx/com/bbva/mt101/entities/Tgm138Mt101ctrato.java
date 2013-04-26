package mx.com.bbva.mt101.entities;

import java.io.Serializable;
import java.util.Date;

public class Tgm138Mt101ctrato implements Serializable {
	private static final long serialVersionUID = 1L;
	private long cdContrato;
	private int cdMoneda;
	private int cdIva;
	private String nuPorcentaje;
	private String nbMoneda;
	private String cdAnualidad;
	private String cdCodSwEnv;
	private String cdCodSwRec;
	private String cdContratoSicoco;
	private String cdCuentaCheques;
	private String cdMensualidad;
	private String cdTpClienteAaa;
	private Date fhAlta;
	private Date fhBaja;
	private String nbEmpresa;
	private Tgm041IvaMx tgm041IvaMx;
	private Tgm042MonedaMx tgm042MonedaMx;
	private String cdContratoStr;

	public String getCdAnualidad() {
		return this.cdAnualidad;
	}

	public String getCdCodSwEnv() {
		return this.cdCodSwEnv;
	}

	public String getCdCodSwRec() {
		return this.cdCodSwRec;
	}

	public long getCdContrato() {
		return this.cdContrato;
	}

	public String getCdContratoSicoco() {
		return this.cdContratoSicoco;
	}

	public String getCdContratoStr() {
		return this.cdContratoStr;
	}

	public String getCdCuentaCheques() {
		return this.cdCuentaCheques;
	}

	public int getCdIva() {
		return this.cdIva;
	}

	public String getCdMensualidad() {
		return this.cdMensualidad;
	}

	public int getCdMoneda() {
		return this.cdMoneda;
	}

	public String getCdTpClienteAaa() {
		return this.cdTpClienteAaa;
	}

	public Date getFhAlta() {
		return this.fhAlta;
	}

	public Date getFhBaja() {
		return this.fhBaja;
	}

	public String getNbEmpresa() {
		return this.nbEmpresa;
	}

	public String getNbMoneda() {
		return this.nbMoneda;
	}

	public String getNuPorcentaje() {
		return this.nuPorcentaje;
	}

	public Tgm041IvaMx getTgm041IvaMx() {
		return this.tgm041IvaMx;
	}

	public Tgm042MonedaMx getTgm042MonedaMx() {
		return this.tgm042MonedaMx;
	}

	public void setCdAnualidad(String cdAnualidad) {
		this.cdAnualidad = cdAnualidad;
	}

	public void setCdCodSwEnv(String cdCodSwEnv) {
		this.cdCodSwEnv = cdCodSwEnv;
	}

	public void setCdCodSwRec(String cdCodSwRec) {
		this.cdCodSwRec = cdCodSwRec;
	}

	public void setCdContrato(long cdContrato) {
		this.cdContrato = cdContrato;
	}

	public void setCdContratoSicoco(String cdContratoSicoco) {
		this.cdContratoSicoco = cdContratoSicoco;
	}

	public void setCdContratoStr(String cdContratoStr) {
		this.cdContratoStr = cdContratoStr;
	}

	public void setCdCuentaCheques(String cdCuentaCheques) {
		this.cdCuentaCheques = cdCuentaCheques;
	}

	public void setCdIva(int cdIva) {
		this.cdIva = cdIva;
	}

	public void setCdMensualidad(String cdMensualidad) {
		this.cdMensualidad = cdMensualidad;
	}

	public void setCdMoneda(int cdMoneda) {
		this.cdMoneda = cdMoneda;
	}

	public void setCdTpClienteAaa(String cdTpClienteAaa) {
		this.cdTpClienteAaa = cdTpClienteAaa;
	}

	public void setFhAlta(Date fhAlta) {
		this.fhAlta = fhAlta;
	}

	public void setFhBaja(Date fhBaja) {
		this.fhBaja = fhBaja;
	}

	public void setNbEmpresa(String nbEmpresa) {
		this.nbEmpresa = nbEmpresa;
	}

	public void setNbMoneda(String nbMoneda) {
		this.nbMoneda = nbMoneda;
	}

	public void setNuPorcentaje(String nuPorcentaje) {
		this.nuPorcentaje = nuPorcentaje;
	}

	public void setTgm041IvaMx(Tgm041IvaMx tgm041IvaMx) {
		this.tgm041IvaMx = tgm041IvaMx;
	}

	public void setTgm042MonedaMx(Tgm042MonedaMx tgm042MonedaMx) {
		this.tgm042MonedaMx = tgm042MonedaMx;
	}
}