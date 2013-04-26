package mx.com.bbva.mt101.entities;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import mx.com.bbva.mt101.commons.constantes.IConstantesCatalogos;

public class Tgm139Mt101Repte {
	private Date fhProceso;
	private BigDecimal cdRepteMt101;
	private String nbCampo20;
	private String nbTpOperacion;
	private String nbCampo50aOcl1;
	private String nbCampo59al1;
	private String imCampo32bMonto;
	private BigDecimal cdStEnvioMt101;
	private BigDecimal cdStEnvioMt101T;
	private String nbFolAcepCw;
	private String nbDescStCw;
	private String nbStOpeCw;
	private BigDecimal cdBicOrigen;
	private String nbCampo21;
	private Date fhCampo30;
	private Date fhProcesoA;
	private String nbStEnvioMt101;
	private BigDecimal cdCampo32bMnda;
	private String nbCampo50aOcL2;
	private String nbCampo50aOcL3;
	private String nbCampo57aL1;
	private String nbCampo70L1;
	private Date fhProcesoRepte;
	private String nbArchCash;
	private Date fhProcesoFin;
	private Date fhProcesoInicio;
	private Date fhCampo30T;
	private Date fhCampo30T2;
	private int validaNoNuloArchivo;
	private int nuLoteEnvio;
	private int fila;
	private long cdCuentaCheques;
	private String nbCampo50h;
	private List<Long> cdStEnvioMt101List;
	private int numeroOperaciones;
	private int ctTpOperacion;
	private String txTpOperacion;
	private float totalComEur;
	private float totalComUsd;
	private float totalComMxn;
	private float subTotalEur;
	private float subTotalUsd;
	private float subTotalMxn;
	private float costo;
	private int cdMoneda;
	private int consecutivo;
	
	public BigDecimal getCdBicOrigen() {
		return cdBicOrigen;
	}

	public BigDecimal getCdCampo32bMnda() {
		return cdCampo32bMnda;
	}

	public long getCdCuentaCheques() {
		return cdCuentaCheques;
	}

	public BigDecimal getCdRepteMt101() {
		return cdRepteMt101;
	}

	public BigDecimal getCdStEnvioMt101() {
		return cdStEnvioMt101;
	}

	public List<Long> getCdStEnvioMt101List() {
		return cdStEnvioMt101List;
	}

	public float getCosto() {
		switch (this.cdMoneda) {
		case IConstantesCatalogos.CATALOGO_MONEDA_EUR:
			costo = this.totalComEur;
			break;
		case IConstantesCatalogos.CATALOGO_MONEDA_USD:
			costo = this.totalComUsd;
			break;
		case IConstantesCatalogos.CATALOGO_MONEDA_MXN:
			costo = this.totalComMxn;
			break;
		default:
			break;
		}
		return costo;
	}

	public int getCtTpOperacion() {
		return ctTpOperacion;
	}

	public String getFhCampo30() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");		
		if(fhCampo30!=null)
			return dateFormat.format(fhCampo30);
		else
			return null;		
	}

	public Date getFhProceso() {
		return fhProceso;
	}

	public Date getFhProcesoA() {
		return fhProcesoA;
	}

	public String getFhProcesoFin() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");				
		if(fhProcesoFin!=null)
			return dateFormat.format(fhProcesoFin);
		else
			return null;	
	}

	public String getFhProcesoInicio() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");				
		if(fhProcesoInicio!=null)
			return dateFormat.format(fhProcesoInicio);
		else
			return null;	
	}

	public Date getFhProcesoRepte() {
		return fhProcesoRepte;
	}

	public int getFila() {
		return fila;
	}

	public String getImCampo32bMonto() {
		return imCampo32bMonto;
	}

	public String getNbArchCash() {
		return nbArchCash;
	}

	public String getNbCampo20() {
		return nbCampo20;
	}

	public String getNbCampo21() {
		return nbCampo21;
	}

	public String getNbCampo50aOcl1() {
		return nbCampo50aOcl1;
	}

	public String getNbCampo50aOcL2() {
		return nbCampo50aOcL2;
	}

	public String getNbCampo50aOcL3() {
		return nbCampo50aOcL3;
	}

	public String getNbCampo50h() {
		return nbCampo50h;
	}

	public String getNbCampo57aL1() {
		return nbCampo57aL1;
	}

	public String getNbCampo59al1() {
		return nbCampo59al1;
	}

	public String getNbCampo70L1() {
		return nbCampo70L1;
	}

	public String getNbDescStCw() {
		return nbDescStCw;
	}

	public String getNbFolAcepCw() {
		return nbFolAcepCw;
	}

	public String getNbStEnvioMt101() {
		return nbStEnvioMt101;
	}

	public String getNbStOpeCw() {
		return nbStOpeCw;
	}

	public String getNbTpOperacion() {
		return nbTpOperacion;
	}

	public int getNuLoteEnvio() {
		return nuLoteEnvio;
	}

	public int getNumeroOperaciones() {
		return numeroOperaciones;
	}

	public float getSubTotalEur() {
		return subTotalEur;
	}

	public float getSubTotalMxn() {
		return subTotalMxn;
	}

	public float getSubTotalUsd() {
		return subTotalUsd;
	}

	public float getTotalComEur() {
		return totalComEur;
	}

	public float getTotalComMxn() {
		return totalComMxn;
	}

	public float getTotalComUsd() {
		return totalComUsd;
	}

	public String getTxTpOperacion() {
		return txTpOperacion;
	}

	public void setCdBicOrigen(BigDecimal cdBicOrigen) {
		this.cdBicOrigen = cdBicOrigen;
	}

	public void setCdCampo32bMnda(BigDecimal cdCampo32bMnda) {
		this.cdCampo32bMnda = cdCampo32bMnda;
	}

	public void setCdCuentaCheques(long cdCuentaCheques) {
		this.cdCuentaCheques = cdCuentaCheques;
	}

	public void setCdRepteMt101(BigDecimal cdRepteMt101) {
		this.cdRepteMt101 = cdRepteMt101;
	}

	public void setCdStEnvioMt101(BigDecimal cdStEnvioMt101) {
		this.cdStEnvioMt101 = cdStEnvioMt101;
	}

	public void setCdStEnvioMt101List(List<Long> cdStEnvioMt101List) {
		this.cdStEnvioMt101List = cdStEnvioMt101List;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public void setCtTpOperacion(int ctTpOperacion) {
		this.ctTpOperacion = ctTpOperacion;
	}

	public void setFhCampo30(Date fhCampo30) {
		this.fhCampo30 = fhCampo30;
	}

	public void setFhProceso(Date fhProceso) {
		this.fhProceso = fhProceso;
	}

	public void setFhProcesoA(Date fhProcesoA) {
		this.fhProcesoA = fhProcesoA;
	}

	public void setFhProcesoFin(Date fhProcesoFin) {
		this.fhProcesoFin = fhProcesoFin;
	}

	public void setFhProcesoInicio(Date fhProcesoInicio) {
		this.fhProcesoInicio = fhProcesoInicio;
	}

	public void setFhProcesoRepte(Date fhProcesoRepte) {
		this.fhProcesoRepte = fhProcesoRepte;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public void setImCampo32bMonto(String imCampo32bMonto) {
		this.imCampo32bMonto = imCampo32bMonto;
	}

	public void setNbArchCash(String nbArchCash) {
		this.nbArchCash = nbArchCash;
	}

	public void setNbCampo20(String nbCampo20) {
		this.nbCampo20 = nbCampo20;
	}

	public void setNbCampo21(String nbCampo21) {
		this.nbCampo21 = nbCampo21;
	}

	public void setNbCampo50aOcl1(String nbCampo50aOcl1) {
		this.nbCampo50aOcl1 = nbCampo50aOcl1;
	}

	public void setNbCampo50aOcL2(String nbCampo50aOcL2) {
		this.nbCampo50aOcL2 = nbCampo50aOcL2;
	}

	public void setNbCampo50aOcL3(String nbCampo50aOcL3) {
		this.nbCampo50aOcL3 = nbCampo50aOcL3;
	}

	public void setNbCampo50h(String nbCampo50h) {
		this.nbCampo50h = nbCampo50h;
	}

	public void setNbCampo57aL1(String nbCampo57aL1) {
		this.nbCampo57aL1 = nbCampo57aL1;
	}

	public void setNbCampo59al1(String nbCampo59al1) {
		this.nbCampo59al1 = nbCampo59al1;
	}

	public void setNbCampo70L1(String nbCampo70L1) {
		this.nbCampo70L1 = nbCampo70L1;
	}

	public void setNbDescStCw(String nbDescStCw) {
		this.nbDescStCw = nbDescStCw;
	}

	public void setNbFolAcepCw(String nbFolAcepCw) {
		this.nbFolAcepCw = nbFolAcepCw;
	}

	public void setNbStEnvioMt101(String nbStEnvioMt101) {
		this.nbStEnvioMt101 = nbStEnvioMt101;
	}

	public void setNbStOpeCw(String nbStOpeCw) {
		this.nbStOpeCw = nbStOpeCw;
	}

	public void setNbTpOperacion(String nbTpOperacion) {
		this.nbTpOperacion = nbTpOperacion;
	}

	public void setNuLoteEnvio(int nuLoteEnvio) {
		this.nuLoteEnvio = nuLoteEnvio;
	}

	public void setNumeroOperaciones(int numeroOperaciones) {
		this.numeroOperaciones = numeroOperaciones;
	}

	public void setSubTotalEur(float subTotalEur) {
		this.subTotalEur = subTotalEur;
	}

	public void setSubTotalMxn(float subTotalMxn) {
		this.subTotalMxn = subTotalMxn;
	}

	public void setSubTotalUsd(float subTotalUsd) {
		this.subTotalUsd = subTotalUsd;
	}

	public void setTotalComEur(float totalComEur) {
		this.totalComEur = totalComEur;
	}

	public void setTotalComMxn(float totalComMxn) {
		this.totalComMxn = totalComMxn;
	}

	public void setTotalComUsd(float totalComUsd) {
		this.totalComUsd = totalComUsd;
	}

	public void setTxTpOperacion(String txTpOperacion) {
		this.txTpOperacion = txTpOperacion;
	}

	public int getCdMoneda() {
		return cdMoneda;
	}

	public void setCdMoneda(int cdMoneda) {
		this.cdMoneda = cdMoneda;
	}

	public int getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(int consecutivo) {
		this.consecutivo = consecutivo;
	}

	public String getFhCampo30T() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		if(fhCampo30T!=null)
			return dateFormat.format(fhCampo30T);
		else
			return null;
	}

	public void setFhCampo30T(Date fhCampo30T) {
		this.fhCampo30T = fhCampo30T;
	}
	public String getFhCampo30T2() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");				
		if(fhCampo30T2!=null)
			return dateFormat.format(fhCampo30T2);
		else
			return null;
	}

	public void setFhCampo30T2(Date fhCampo30T2) {
		this.fhCampo30T2 = fhCampo30T2;
	}

	public int getValidaNoNuloArchivo() {
		return validaNoNuloArchivo;
	}

	public void setValidaNoNuloArchivo(int validaNoNuloArchivo) {
		this.validaNoNuloArchivo = validaNoNuloArchivo;
	}

	public BigDecimal getCdStEnvioMt101T() {
		return cdStEnvioMt101T;
	}

	public void setCdStEnvioMt101T(BigDecimal cdStEnvioMt101T) {
		this.cdStEnvioMt101T = cdStEnvioMt101T;
	}
}
