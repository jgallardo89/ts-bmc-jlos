package mx.com.bbva.mt101.usuario.negocio;

import javax.ejb.Local;

import mx.com.bbva.mt101.entities.Tgm023Usuario;

@Local
public interface IUsuarios {
	public Tgm023Usuario getUsuario(Tgm023Usuario tgm023Usuario);
}
