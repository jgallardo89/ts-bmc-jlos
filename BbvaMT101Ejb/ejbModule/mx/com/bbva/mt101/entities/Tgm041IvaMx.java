package mx.com.bbva.mt101.entities;

import java.io.Serializable;
import java.util.List;

public class Tgm041IvaMx implements Serializable {
	private static final long serialVersionUID = 1L;
	private int cdIva;
	private int nuPorcentaje;
	private List<Tgm138Mt101ctrato> tgm138Mt101ctratos;

	public Tgm138Mt101ctrato addTgm138Mt101ctrato(
			Tgm138Mt101ctrato tgm138Mt101ctrato) {
		getTgm138Mt101ctratos().add(tgm138Mt101ctrato);
		tgm138Mt101ctrato.setTgm041IvaMx(this);

		return tgm138Mt101ctrato;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Tgm041IvaMx)) {
			return false;
		}
		Tgm041IvaMx other = (Tgm041IvaMx) obj;
		if (this.cdIva != other.cdIva) {
			return false;
		}
		return true;
	}

	public int getCdIva() {
		return this.cdIva;
	}

	public int getNuPorcentaje() {
		return this.nuPorcentaje;
	}

	public List<Tgm138Mt101ctrato> getTgm138Mt101ctratos() {
		return this.tgm138Mt101ctratos;
	}

	public int hashCode() {
		int result = 1;
		result = 31 * result + (this.cdIva ^ this.cdIva >>> 32);
		return result;
	}

	public Tgm138Mt101ctrato removeTgm138Mt101ctrato(
			Tgm138Mt101ctrato tgm138Mt101ctrato) {
		getTgm138Mt101ctratos().remove(tgm138Mt101ctrato);
		tgm138Mt101ctrato.setTgm041IvaMx(null);

		return tgm138Mt101ctrato;
	}

	public void setCdIva(int cdIva) {
		this.cdIva = cdIva;
	}

	public void setNuPorcentaje(int nuPorcentaje) {
		this.nuPorcentaje = nuPorcentaje;
	}

	public void setTgm138Mt101ctratos(List<Tgm138Mt101ctrato> tgm138Mt101ctratos) {
		this.tgm138Mt101ctratos = tgm138Mt101ctratos;
	}
}