package mx.com.bbva.mt101.entities;

import java.util.Date;

public class Tgm048ProcesoLog {
	private long cdProcesoLog;
	private long cdTpEvento;
	private long cdProcesoGis;
	private Date tmProcesoLog;
	private String txProcesoLog;

	public long getCdProcesoGis() {
		return cdProcesoGis;
	}

	public long getCdProcesoLog() {
		return cdProcesoLog;
	}

	public long getCdTpEvento() {
		return cdTpEvento;
	}

	public Date getTmProcesoLog() {
		return tmProcesoLog;
	}

	public String getTxProcesoLog() {
		return txProcesoLog;
	}

	public void setCdProcesoGis(long cdProcesoGis) {
		this.cdProcesoGis = cdProcesoGis;
	}

	public void setCdProcesoLog(long cdProcesoLog) {
		this.cdProcesoLog = cdProcesoLog;
	}

	public void setCdTpEvento(long cdTpEvento) {
		this.cdTpEvento = cdTpEvento;
	}

	public void setTmProcesoLog(Date tmProcesoLog) {
		this.tmProcesoLog = tmProcesoLog;
	}

	public void setTxProcesoLog(String txProcesoLog) {
		this.txProcesoLog = txProcesoLog;
	}

}