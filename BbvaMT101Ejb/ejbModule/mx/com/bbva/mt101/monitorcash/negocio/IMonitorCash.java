package mx.com.bbva.mt101.monitorcash.negocio;

import java.util.List;

import javax.ejb.Local;

import mx.com.bbva.mt101.entities.Tgm140Mt101Solrv;
import mx.com.bbva.mt101.entities.Tgm141Mt101Envcw;

@Local
public interface IMonitorCash {
	public Tgm141Mt101Envcw getArchivoParaRenvio(
			Tgm141Mt101Envcw tgm141Mt101Envcw);

	public List<Tgm141Mt101Envcw> obtenerListaArchivos(
			Tgm141Mt101Envcw tgm141Mt101Envcw);

	public List<Tgm141Mt101Envcw> obtenerListaArchivosParaReenvio();

	public int setArchivoParaReenviar(Tgm140Mt101Solrv tgm140Mt101Solrv);

	public int updateArchivo(Tgm141Mt101Envcw tgm141Mt101Envcw);
	
	public int updateLoteSigCfg();
}
