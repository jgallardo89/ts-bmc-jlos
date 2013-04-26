package mx.com.bbva.mapeador.entity.tgm504perfil;

import java.io.Serializable;
import javax.persistence.*;

import mx.com.bbva.mapeador.entity.tgm503usuario.Tgm503Usuario;
import mx.com.bbva.mapeador.entity.tgm505ctrlpermiso.Tgm505Ctrlpermiso;
import mx.com.bbva.mapeador.entity.tgm534StObjeto.Tgm534StObjeto;

import java.util.List;


/**
 * The persistent class for the TGM504_PERFIL database table.
 * 
 */
public class Tgm504Perfil implements Serializable {
	private static final long serialVersionUID = 1L;
	private long cdPerfil;
	private String nbPerfil;
	private String txPerfil;
	private List<Tgm503Usuario> tgm503Usuarios;
	private Tgm534StObjeto tgm534StObjeto;
	private List<Tgm505Ctrlpermiso> tgm505Ctrlpermisos;

	public Tgm504Perfil() {
	}

	public long getCdPerfil() {
		return this.cdPerfil;
	}

	public void setCdPerfil(long cdPerfil) {
		this.cdPerfil = cdPerfil;
	}

	public String getNbPerfil() {
		return this.nbPerfil;
	}

	public void setNbPerfil(String nbPerfil) {
		this.nbPerfil = nbPerfil;
	}

	public String getTxPerfil() {
		return this.txPerfil;
	}

	public void setTxPerfil(String txPerfil) {
		this.txPerfil = txPerfil;
	}

	public List<Tgm503Usuario> getTgm503Usuarios() {
		return this.tgm503Usuarios;
	}

	public void setTgm503Usuarios(List<Tgm503Usuario> tgm503Usuarios) {
		this.tgm503Usuarios = tgm503Usuarios;
	}

	public Tgm503Usuario addTgm503Usuario(Tgm503Usuario tgm503Usuario) {
		getTgm503Usuarios().add(tgm503Usuario);
		tgm503Usuario.setTgm504Perfil(this);

		return tgm503Usuario;
	}

	public Tgm503Usuario removeTgm503Usuario(Tgm503Usuario tgm503Usuario) {
		getTgm503Usuarios().remove(tgm503Usuario);
		tgm503Usuario.setTgm504Perfil(null);

		return tgm503Usuario;
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
		tgm505Ctrlpermiso.setTgm504Perfil(this);

		return tgm505Ctrlpermiso;
	}

	public Tgm505Ctrlpermiso removeTgm505Ctrlpermiso(Tgm505Ctrlpermiso tgm505Ctrlpermiso) {
		getTgm505Ctrlpermisos().remove(tgm505Ctrlpermiso);
		tgm505Ctrlpermiso.setTgm504Perfil(null);

		return tgm505Ctrlpermiso;
	}

}