package mx.com.bbva.mapeador.ejb.perfil.negocio;

import java.util.List;

import javax.ejb.Local;

import mx.com.bbva.mapeador.entity.tgm504perfil.Tgm504Perfil;

@Local
public abstract interface IPerfil {
	public abstract List<Tgm504Perfil> obtenerPerfilesActivo();
}
