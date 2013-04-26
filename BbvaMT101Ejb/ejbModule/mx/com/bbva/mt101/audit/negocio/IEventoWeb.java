package mx.com.bbva.mt101.audit.negocio;

import javax.ejb.Local;

import mx.com.bbva.mt101.entities.Tgm107EventoWeb;

@Local
public abstract interface IEventoWeb {
	public abstract int setEventoWeb(Tgm107EventoWeb tgm107EventoWeb);
}
