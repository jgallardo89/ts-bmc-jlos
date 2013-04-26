package mx.com.bbva.mapeador.ejb.menu.negocio;

import java.util.List;

import javax.ejb.Local;

import mx.com.bbva.mapeador.entity.tgm501pantalla.Tgm501Pantalla;

@Local
public abstract interface IMenu {	
	  public abstract List<Tgm501Pantalla> obtenerMenuPorUsuario(Tgm501Pantalla tgm501Pantalla);
}
