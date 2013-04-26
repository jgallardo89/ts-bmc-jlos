package mx.com.bbva.mapeador.entity.tgm502componente;

import java.io.Serializable;
import javax.persistence.*;

import mx.com.bbva.mapeador.entity.tgm501pantalla.Tgm501Pantalla;
import mx.com.bbva.mapeador.entity.tgm505ctrlpermiso.Tgm505Ctrlpermiso;
import mx.com.bbva.mapeador.entity.tgm534StObjeto.Tgm534StObjeto;

import java.util.List;


/**
 * The persistent class for the TGM502_COMPONENTE database table.
 * 
 */
public class Tgm502Componente implements Serializable {
	private static final long serialVersionUID = 1L;

	private long cdComponente;
	private String cdDefault;
	private String nbComponente;
	private String tpComponente;
	private Tgm501Pantalla tgm501Pantalla;
	private Tgm534StObjeto tgm534StObjeto;
	private List<Tgm505Ctrlpermiso> tgm505Ctrlpermisos;

	public Tgm502Componente() {
	}

	public long getCdComponente() {
		return this.cdComponente;
	}

	public void setCdComponente(long cdComponente) {
		this.cdComponente = cdComponente;
	}

	public String getCdDefault() {
		return this.cdDefault;
	}

	public void setCdDefault(String cdDefault) {
		this.cdDefault = cdDefault;
	}

	public String getNbComponente() {
		return this.nbComponente;
	}

	public void setNbComponente(String nbComponente) {
		this.nbComponente = nbComponente;
	}

	public String getTpComponente() {
		return this.tpComponente;
	}

	public void setTpComponente(String tpComponente) {
		this.tpComponente = tpComponente;
	}

	public Tgm501Pantalla getTgm501Pantalla() {
		return this.tgm501Pantalla;
	}

	public void setTgm501Pantalla(Tgm501Pantalla tgm501Pantalla) {
		this.tgm501Pantalla = tgm501Pantalla;
	}

	public Tgm534StObjeto getTgm534StObjeto() {
		return this.tgm534StObjeto;
	}

	public void setTgm534StObjeto(Tgm534StObjeto tgm534StObjeto) {
		this.tgm534StObjeto = tgm534StObjeto;
	}

	public List<Tgm505Ctrlpermiso> getTgm505Ctrlpermisos() {
		return this.tgm505Ctrlpermisos;
	}

	public void setTgm505Ctrlpermisos(List<Tgm505Ctrlpermiso> tgm505Ctrlpermisos) {
		this.tgm505Ctrlpermisos = tgm505Ctrlpermisos;
	}

	public Tgm505Ctrlpermiso addTgm505Ctrlpermiso(Tgm505Ctrlpermiso tgm505Ctrlpermiso) {
		getTgm505Ctrlpermisos().add(tgm505Ctrlpermiso);
		tgm505Ctrlpermiso.setTgm502Componente(this);

		return tgm505Ctrlpermiso;
	}

	public Tgm505Ctrlpermiso removeTgm505Ctrlpermiso(Tgm505Ctrlpermiso tgm505Ctrlpermiso) {
		getTgm505Ctrlpermisos().remove(tgm505Ctrlpermiso);
		tgm505Ctrlpermiso.setTgm502Componente(null);

		return tgm505Ctrlpermiso;
	}

}