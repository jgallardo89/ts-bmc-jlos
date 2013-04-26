package mx.com.bbva.mt101.catalogos.stop.negocio;

import java.util.List;

import javax.ejb.Local;

import mx.com.bbva.mt101.entities.Tgm142Mt101Stenv;

@Local
public abstract interface ICatalogoStOp {
	public abstract List<Tgm142Mt101Stenv> getTodosEstatus();  
}
