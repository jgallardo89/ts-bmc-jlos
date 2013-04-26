package mx.com.bbva.mt101.catalogos.operacion.negocio;

import java.util.List;

import javax.ejb.Local;

import mx.com.bbva.mt101.entities.Tgm053TipoOpMx;

@Local
public interface ICatalogoOperacion {
	public abstract Tgm053TipoOpMx getOperacionPorCriterio(Tgm053TipoOpMx tgm053TipoOpMx);
}
