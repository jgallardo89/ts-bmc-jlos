package com.bancomer.gis.monitorwebswift.vo;

public class CoinVo extends GeneralVo implements java.io.Serializable{

	private int coinId;
	private String idCoinSW;
	private String name;
	private int digitos;
	private String cdPaisSw;
	private String nbPaisSw;
	
	
	public CoinVo(){
		
	}
	
	public CoinVo(String name){
		this.name = name;
	}
	
	public CoinVo(int coinId, String name) {
		this.coinId = coinId;
		this.name = name;
	}

	public CoinVo(String idCoinSW, String name, int digitos) {
		this.idCoinSW = idCoinSW;
		this.name = name;
		this.digitos = digitos;
	}
	
	public CoinVo(String idCoinSW, String name, int digitos, String paisSw, String nbPaisSw) {
		this.idCoinSW = idCoinSW;
		this.name = name;
		this.digitos = digitos;
		this.cdPaisSw = paisSw;
		this.nbPaisSw = nbPaisSw;
	}
	

	public CoinVo(int coinId, String name , String idCoinSW ) {
		this.coinId = coinId;
		this.idCoinSW = idCoinSW;
		this.name = name;
	}


	public int getCoinId() {
		return coinId;
	}
	public void setCoinId(int coinId) {
		this.coinId = coinId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public int getDigitos() {
		return digitos;
	}


	public void setDigitos(int digitos) {
		this.digitos = digitos;
	}


	public String getIdCoinSW() {
		return idCoinSW;
	}


	public void setIdCoinSW(String idCoinSW) {
		this.idCoinSW = idCoinSW;
	}

	public String getCdPaisSw() {
		return cdPaisSw;
	}

	public void setCdPaisSw(String cdPaisSw) {
		this.cdPaisSw = cdPaisSw;
	}

	public String getNbPaisSw() {
		return nbPaisSw;
	}

	public void setNbPaisSw(String nbPaisSw) {
		this.nbPaisSw = nbPaisSw;
	}
	
	
}
