package mx.com.bbva.mt101.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tgm141Mt101Envcw {
	private int cdEnvCash;
	private String nbArchivoCw;
	private int nuLote;
	private Date fhProceso;
	private Date fhProcesoAnt;
	private int toRegistrosEnvio;
	private int ctNumReenvio;
	private Date fhUltimoReenv;
	private Date fhRegresoCash;
	private int toRegistrosReg;
	private int cdRegresoCash;
	private String strFhProceso;
	private String strFhProcesoAnt;
	private int nuReintentosSistema;

	public int getCdEnvCash() {
		return cdEnvCash;
	}

	public int getCdRegresoCash() {
		return cdRegresoCash;
	}

	public int getCtNumReenvio() {
		return ctNumReenvio;
	}

	public Date getFhProceso() {
		return fhProceso;
	}

	public Date getFhProcesoAnt() {
		return fhProcesoAnt;
	}

	public Date getFhRegresoCash() {
		return fhRegresoCash;
	}

	public Date getFhUltimoReenv() {
		return fhUltimoReenv;
	}

	public String getNbArchivoCw() {
		return nbArchivoCw;
	}

	public int getNuLote() {
		return nuLote;
	}

	public String getStrFhProceso() {
		return strFhProceso;
	}

	public String getStrFhProcesoAnt() {
		return strFhProcesoAnt;
	}

	public int getToRegistrosEnvio() {
		return toRegistrosEnvio;
	}

	public int getToRegistrosReg() {
		return toRegistrosReg;
	}

	public void setCdEnvCash(int cdEnvCash) {
		this.cdEnvCash = cdEnvCash;
	}

	public void setCdRegresoCash(int cdRegresoCash) {
		this.cdRegresoCash = cdRegresoCash;
	}

	public void setCtNumReenvio(int ctNumReenvio) {
		this.ctNumReenvio = ctNumReenvio;
	}

	public void setFhProceso(Date fhProceso) {
		this.fhProceso = fhProceso;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		this.strFhProceso = simpleDateFormat.format(fhProceso);
	}

	public void setFhProcesoAnt(Date fhProcesoAnt) {
		this.fhProcesoAnt = fhProcesoAnt;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		this.strFhProcesoAnt = simpleDateFormat.format(fhProcesoAnt);
	}

	public void setFhRegresoCash(Date fhRegresoCash) {
		this.fhRegresoCash = fhRegresoCash;
	}

	public void setFhUltimoReenv(Date fhUltimoReenv) {
		this.fhUltimoReenv = fhUltimoReenv;
	}

	public void setNbArchivoCw(String nbArchivoCw) {
		this.nbArchivoCw = nbArchivoCw;
	}

	public void setNuLote(int nuLote) {
		this.nuLote = nuLote;
	}

	public void setToRegistrosEnvio(int toRegistrosEnvio) {
		this.toRegistrosEnvio = toRegistrosEnvio;
	}

	public void setToRegistrosReg(int toRegistrosReg) {
		this.toRegistrosReg = toRegistrosReg;
	}

	public int getNuReintentosSistema() {
		return nuReintentosSistema;
	}

	public void setNuReintentosSistema(int nuReintentosSistema) {
		this.nuReintentosSistema = nuReintentosSistema;
	}

	public void setStrFhProceso(String strFhProceso) {
		this.strFhProceso = strFhProceso;
	}

	public void setStrFhProcesoAnt(String strFhProcesoAnt) {
		this.strFhProcesoAnt = strFhProcesoAnt;
	}
}
