package mx.com.bbva.mt101.entities;

import java.io.Serializable;


/**
 * The persistent class for the TGM142_MT101_STENV database table.
 * 
 */
public class Tgm142Mt101Stenv implements Serializable {
	private static final long serialVersionUID = 1L;

	private long cdStEnvioMt101;
	private String nbStEnvioMt101;

	public Tgm142Mt101Stenv() {
	}

	public long getCdStEnvioMt101() {
		return this.cdStEnvioMt101;
	}

	public String getNbStEnvioMt101() {
		return this.nbStEnvioMt101;
	}

	public void setCdStEnvioMt101(long cdStEnvioMt101) {
		this.cdStEnvioMt101 = cdStEnvioMt101;
	}

	public void setNbStEnvioMt101(String nbStEnvioMt101) {
		this.nbStEnvioMt101 = nbStEnvioMt101;
	}

}