package mx.com.bbva.mapeador.entity.tgm508eventomapa;

import java.io.Serializable;
import javax.persistence.*;

import mx.com.bbva.mapeador.entity.tgm507bitacora.Tgm507Bitacora;

import java.util.List;


/**
 * The persistent class for the TGM508_EVENTO_MAPA database table.
 * 
 */
public class Tgm508EventoMapa implements Serializable {
	private static final long serialVersionUID = 1L;
	private long cdEventoMapeador;
	private String nbEventoMapeador;
	private String txEventoMapeador;
	private List<Tgm507Bitacora> tgm507Bitacoras;

	public Tgm508EventoMapa() {
	}

	public long getCdEventoMapeador() {
		return this.cdEventoMapeador;
	}

	public void setCdEventoMapeador(long cdEventoMapeador) {
		this.cdEventoMapeador = cdEventoMapeador;
	}

	public String getNbEventoMapeador() {
		return this.nbEventoMapeador;
	}

	public void setNbEventoMapeador(String nbEventoMapeador) {
		this.nbEventoMapeador = nbEventoMapeador;
	}

	public String getTxEventoMapeador() {
		return this.txEventoMapeador;
	}

	public void setTxEventoMapeador(String txEventoMapeador) {
		this.txEventoMapeador = txEventoMapeador;
	}

	public List<Tgm507Bitacora> getTgm507Bitacoras() {
		return this.tgm507Bitacoras;
	}

	public void setTgm507Bitacoras(List<Tgm507Bitacora> tgm507Bitacoras) {
		this.tgm507Bitacoras = tgm507Bitacoras;
	}

	public Tgm507Bitacora addTgm507Bitacora(Tgm507Bitacora tgm507Bitacora) {
		getTgm507Bitacoras().add(tgm507Bitacora);
		tgm507Bitacora.setTgm508EventoMapa(this);

		return tgm507Bitacora;
	}

	public Tgm507Bitacora removeTgm507Bitacora(Tgm507Bitacora tgm507Bitacora) {
		getTgm507Bitacoras().remove(tgm507Bitacora);
		tgm507Bitacora.setTgm508EventoMapa(null);

		return tgm507Bitacora;
	}

}