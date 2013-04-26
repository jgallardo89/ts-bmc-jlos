package mx.com.bbva.mt101.entities;

import java.util.Date;

public class Tgm107EventoWeb {
	private long cdEventoWeb;
	private Date tmEventoWeb;
	private String txEventoWeb;
	private long cdUsuario;

	public long getCdEventoWeb() {
		return cdEventoWeb;
	}

	public long getCdUsuario() {
		return cdUsuario;
	}

	public Date getTmEventoWeb() {
		return tmEventoWeb;
	}

	public String getTxEventoWeb() {
		return txEventoWeb;
	}

	public void setCdEventoWeb(long cdEventoWeb) {
		this.cdEventoWeb = cdEventoWeb;
	}

	public void setCdUsuario(long cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public void setTmEventoWeb(Date tmEventoWeb) {
		this.tmEventoWeb = tmEventoWeb;
	}

	public void setTxEventoWeb(String txEventoWeb) {
		this.txEventoWeb = txEventoWeb;
	}
}
