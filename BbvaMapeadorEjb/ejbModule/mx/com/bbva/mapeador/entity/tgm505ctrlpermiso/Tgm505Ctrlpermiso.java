package mx.com.bbva.mapeador.entity.tgm505ctrlpermiso;

import java.io.Serializable;
import javax.persistence.*;

import mx.com.bbva.mapeador.entity.tgm502componente.Tgm502Componente;
import mx.com.bbva.mapeador.entity.tgm504perfil.Tgm504Perfil;


/**
 * The persistent class for the TGM505_CTRLPERMISO database table.
 * 
 */
public class Tgm505Ctrlpermiso implements Serializable {
	private static final long serialVersionUID = 1L;

	private long cdCtrlPermiso;
	private Tgm502Componente tgm502Componente;
	private Tgm504Perfil tgm504Perfil;

	public Tgm505Ctrlpermiso() {
	}

	public long getCdCtrlPermiso() {
		return this.cdCtrlPermiso;
	}

	public void setCdCtrlPermiso(long cdCtrlPermiso) {
		this.cdCtrlPermiso = cdCtrlPermiso;
	}

	public Tgm502Componente getTgm502Componente() {
		return this.tgm502Componente;
	}

	public void setTgm502Componente(Tgm502Componente tgm502Componente) {
		this.tgm502Componente = tgm502Componente;
	}

	public Tgm504Perfil getTgm504Perfil() {
		return this.tgm504Perfil;
	}

	public void setTgm504Perfil(Tgm504Perfil tgm504Perfil) {
		this.tgm504Perfil = tgm504Perfil;
	}

}