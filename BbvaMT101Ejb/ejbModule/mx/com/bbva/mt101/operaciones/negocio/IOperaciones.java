package mx.com.bbva.mt101.operaciones.negocio;

import java.util.List;

import javax.ejb.Local;

import mx.com.bbva.mt101.entities.Tgm139Mt101Repte;

@Local
public interface IOperaciones {
	public long actualizaEstatusOperacionReprocesar(
			Tgm139Mt101Repte tgm139Mt101Repte);

	public List<Tgm139Mt101Repte> getOperacionesFuturas(
			Tgm139Mt101Repte tgm139Mt101Repte);

	public List<Tgm139Mt101Repte> getOperacionesPorCriterio(
			Tgm139Mt101Repte tgm139Mt101Repte);

	public List<Tgm139Mt101Repte> getOperacionesPorEstatus(
			Tgm139Mt101Repte tgm139Mt101Repte);

	public List<Tgm139Mt101Repte> getTotalesOperacionesPorCriterios(
			Tgm139Mt101Repte tgm139Mt101Repte);

	public long updateEstatusOperacion(Tgm139Mt101Repte tgm139Mt101Repte);
}
