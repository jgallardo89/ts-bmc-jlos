package mx.com.bbva.mapeador.entity.tgm501pantalla;

import java.io.Serializable;
import javax.persistence.*;

import mx.com.bbva.mapeador.entity.tgm502componente.Tgm502Componente;
import mx.com.bbva.mapeador.entity.tgm534StObjeto.Tgm534StObjeto;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TGM501_PANTALLA database table.
 * 
 */
public class Tgm501Pantalla implements Serializable {
	private static final long serialVersionUID = 1L;

	private long cdPantalla;
	private BigDecimal cdPerfil;
	private String nbPantalla;
	private BigDecimal nuOrdPantalla;
	private long cdFkPantalla;
	public long getCdFkPantalla() {
		return cdFkPantalla;
	}

	public void setCdFkPantalla(long cdFkPantalla) {
		this.cdFkPantalla = cdFkPantalla;
	}

	public String getCdCveUsuario() {
		return cdCveUsuario;
	}

	public void setCdCveUsuario(String cdCveUsuario) {
		this.cdCveUsuario = cdCveUsuario;
	}

	private String cdCveUsuario;
	private String txUrlIcon;
	private String txUrlPantalla;
	private Tgm501Pantalla tgm501Pantalla;
	private List<Tgm501Pantalla> tgm501Pantallas;
	private Tgm534StObjeto tgm534StObjeto;
	private List<Tgm502Componente> tgm502Componentes;

	public Tgm501Pantalla() {
	}

	public long getCdPantalla() {
		return this.cdPantalla;
	}

	public void setCdPantalla(long cdPantalla) {
		this.cdPantalla = cdPantalla;
	}

	public BigDecimal getCdPerfil() {
		return this.cdPerfil;
	}

	public void setCdPerfil(BigDecimal cdPerfil) {
		this.cdPerfil = cdPerfil;
	}

	public String getNbPantalla() {
		return this.nbPantalla;
	}

	public void setNbPantalla(String nbPantalla) {
		this.nbPantalla = nbPantalla;
	}

	public BigDecimal getNuOrdPantalla() {
		return this.nuOrdPantalla;
	}

	public void setNuOrdPantalla(BigDecimal nuOrdPantalla) {
		this.nuOrdPantalla = nuOrdPantalla;
	}

	public String getTxUrlIcon() {
		return this.txUrlIcon;
	}

	public void setTxUrlIcon(String txUrlIcon) {
		this.txUrlIcon = txUrlIcon;
	}

	public String getTxUrlPantalla() {
		return this.txUrlPantalla;
	}

	public void setTxUrlPantalla(String txUrlPantalla) {
		this.txUrlPantalla = txUrlPantalla;
	}

	public Tgm501Pantalla getTgm501Pantalla() {
		return this.tgm501Pantalla;
	}

	public void setTgm501Pantalla(Tgm501Pantalla tgm501Pantalla) {
		this.tgm501Pantalla = tgm501Pantalla;
	}

	public List<Tgm501Pantalla> getTgm501Pantallas() {
		return this.tgm501Pantallas;
	}

	public void setTgm501Pantallas(List<Tgm501Pantalla> tgm501Pantallas) {
		this.tgm501Pantallas = tgm501Pantallas;
	}

	public Tgm501Pantalla addTgm501Pantalla(Tgm501Pantalla tgm501Pantalla) {
		getTgm501Pantallas().add(tgm501Pantalla);
		tgm501Pantalla.setTgm501Pantalla(this);

		return tgm501Pantalla;
	}

	public Tgm501Pantalla removeTgm501Pantalla(Tgm501Pantalla tgm501Pantalla) {
		getTgm501Pantallas().remove(tgm501Pantalla);
		tgm501Pantalla.setTgm501Pantalla(null);

		return tgm501Pantalla;
	}

	public Tgm534StObjeto getTgm534StObjeto() {
		return this.tgm534StObjeto;
	}

	public void setTgm534StObjeto(Tgm534StObjeto tgm534StObjeto) {
		this.tgm534StObjeto = tgm534StObjeto;
	}

	public List<Tgm502Componente> getTgm502Componentes() {
		return this.tgm502Componentes;
	}

	public void setTgm502Componentes(List<Tgm502Componente> tgm502Componentes) {
		this.tgm502Componentes = tgm502Componentes;
	}

	public Tgm502Componente addTgm502Componente(Tgm502Componente tgm502Componente) {
		getTgm502Componentes().add(tgm502Componente);
		tgm502Componente.setTgm501Pantalla(this);

		return tgm502Componente;
	}

	public Tgm502Componente removeTgm502Componente(Tgm502Componente tgm502Componente) {
		getTgm502Componentes().remove(tgm502Componente);
		tgm502Componente.setTgm501Pantalla(null);

		return tgm502Componente;
	}

}