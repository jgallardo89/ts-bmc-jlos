package mx.com.bbva.mt101.mapper;

import java.util.List;

import mx.com.bbva.mt101.entities.Tgm141Mt101Envcw;

public interface MapTgm141Mt101Envcw {
	public abstract int actualizaArchivo(Tgm141Mt101Envcw tgm141Mt101Envcw);

	public abstract List<Tgm141Mt101Envcw> obtenerArchivosParaReenviar();

	public abstract Tgm141Mt101Envcw obtenerArchivoParaReenviar(
			Tgm141Mt101Envcw tgm141Mt101Envcw);

	public abstract List<Tgm141Mt101Envcw> obtenerArchivosPorCriterio(
			Tgm141Mt101Envcw tgm141Mt101Envcw);
}
