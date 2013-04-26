package mx.com.bbva.mt101.catalogos.iva.negocio;

import java.util.List;

import javax.ejb.Local;

import mx.com.bbva.mt101.entities.Tgm041IvaMx;

@Local
public abstract interface ICatalogoIva {
	public abstract Tgm041IvaMx buscarTgm041IvaMx(Tgm041IvaMx paramTgm041IvaMx);

	public abstract List<Tgm041IvaMx> filtarTgm041IvaMx(
			Tgm041IvaMx paramTgm041IvaMx);

	public abstract List<Tgm041IvaMx> obtenerTodosTgm041IvaMx(
			Tgm041IvaMx paramTgm041IvaMx);

	public abstract void salavarCatalogo(Tgm041IvaMx paramTgm041IvaMx);
}