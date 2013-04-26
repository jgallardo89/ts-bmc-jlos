package mx.com.bbva.mt101.entities;

import java.io.Serializable;
import java.util.List;

public class Tgm042MonedaMx implements Serializable {
	private static final long serialVersionUID = 1L;
	private long cdMoneda;
	private String nbMoneda;
	private List<Tgm138Mt101ctrato> tgm138Mt101ctratos;

	public Tgm138Mt101ctrato addTgm138Mt101ctrato(
			Tgm138Mt101ctrato tgm138Mt101ctrato) {
		getTgm138Mt101ctratos().add(tgm138Mt101ctrato);
		tgm138Mt101ctrato.setTgm042MonedaMx(this);

		return tgm138Mt101ctrato;
	}

	public long getCdMoneda() {
		return this.cdMoneda;
	}

	public String getNbMoneda() {
		return this.nbMoneda;
	}

	public List<Tgm138Mt101ctrato> getTgm138Mt101ctratos() {
		return this.tgm138Mt101ctratos;
	}

	public Tgm138Mt101ctrato removeTgm138Mt101ctrato(
			Tgm138Mt101ctrato tgm138Mt101ctrato) {
		getTgm138Mt101ctratos().remove(tgm138Mt101ctrato);
		tgm138Mt101ctrato.setTgm042MonedaMx(null);

		return tgm138Mt101ctrato;
	}

	public void setCdMoneda(long cdMoneda) {
		this.cdMoneda = cdMoneda;
	}

	public void setNbMoneda(String nbMoneda) {
		this.nbMoneda = nbMoneda;
	}

	public void setTgm138Mt101ctratos(List<Tgm138Mt101ctrato> tgm138Mt101ctratos) {
		this.tgm138Mt101ctratos = tgm138Mt101ctratos;
	}
}