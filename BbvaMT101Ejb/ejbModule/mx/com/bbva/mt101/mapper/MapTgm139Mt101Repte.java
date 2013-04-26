package mx.com.bbva.mt101.mapper;

import java.util.List;

import mx.com.bbva.mt101.entities.Tgm139Mt101Repte;

public interface MapTgm139Mt101Repte {
	public abstract int actualizaEstatusOperacion(
			Tgm139Mt101Repte tgm139Mt101Repte);

	public abstract int actualizaEstatusOperacionReprocesar(
			Tgm139Mt101Repte tgm139Mt101Repte);

	public abstract List<Tgm139Mt101Repte> obtenerOperacionesFuturas(
			Tgm139Mt101Repte tgm139Mt101Repte);

	public abstract List<Tgm139Mt101Repte> obtenerOperacionesPorCriterio(
			Tgm139Mt101Repte tgm139Mt101Repte);

	public abstract List<Tgm139Mt101Repte> obtenerOperacionesPorEstatus(
			Tgm139Mt101Repte tgm139Mt101Repte);

	public abstract List<Tgm139Mt101Repte> obtenerTotalesOperacionesPorCriterios(
			Tgm139Mt101Repte tgm139Mt101Repte);
}
