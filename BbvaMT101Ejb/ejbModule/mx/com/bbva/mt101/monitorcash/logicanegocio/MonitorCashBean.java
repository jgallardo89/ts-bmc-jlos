package mx.com.bbva.mt101.monitorcash.logicanegocio;

import java.util.List;

import javax.ejb.Stateless;

import mx.com.bbva.mt101.configuration.Mt101SessionFactory;
import mx.com.bbva.mt101.entities.Tgm140Mt101Solrv;
import mx.com.bbva.mt101.entities.Tgm141Mt101Envcw;
import mx.com.bbva.mt101.mapper.MapTgm046ParamCfg;
import mx.com.bbva.mt101.mapper.MapTgm140Mt101Solrv;
import mx.com.bbva.mt101.mapper.MapTgm141Mt101Envcw;
import mx.com.bbva.mt101.monitorcash.negocio.IMonitorCash;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

@Stateless
public class MonitorCashBean implements IMonitorCash {
	private static final Logger logger = Logger
			.getLogger(MonitorCashBean.class);

	@Override
	public Tgm141Mt101Envcw getArchivoParaRenvio(
			Tgm141Mt101Envcw tgm141Mt101Envcw) {
		logger.debug("MonitorCashBean: - Metodo: getArchivoParaRenvio  -- **inicio**");
		Tgm141Mt101Envcw result = null;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm141Mt101Envcw mapTgm141Mt101Envcw = (MapTgm141Mt101Envcw) session
					.getMapper(MapTgm141Mt101Envcw.class);
			logger.debug(tgm141Mt101Envcw.getFhProceso());
			logger.debug(tgm141Mt101Envcw.getFhProcesoAnt());
			result = mapTgm141Mt101Envcw
					.obtenerArchivoParaReenviar(tgm141Mt101Envcw);
			logger.debug("MonitorCashBean: - result:" + result
					+ "  -- **inicio**");
			session.close();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("MonitorCashBean: - Metodo: getArchivoParaRenvio  -- **fin**");
		}
	}

	@Override
	public List<Tgm141Mt101Envcw> obtenerListaArchivos(
			Tgm141Mt101Envcw tgm141Mt101Envcw) {
		logger.debug("MonitorCashBean: - Metodo: obtenerListaArchivos  -- **inicio**");
		List<Tgm141Mt101Envcw> result = null;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm141Mt101Envcw mapTgm141Mt101Envcw = (MapTgm141Mt101Envcw) session
					.getMapper(MapTgm141Mt101Envcw.class);
			logger.debug(tgm141Mt101Envcw.getFhProceso());
			logger.debug(tgm141Mt101Envcw.getFhProcesoAnt());
			result = mapTgm141Mt101Envcw
					.obtenerArchivosPorCriterio(tgm141Mt101Envcw);
			logger.debug("MonitorCashBean: - result:" + result.size()
					+ "  -- **inicio**");
			session.close();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("MonitorCashBean: - Metodo: obtenerListaArchivos  -- **fin**");
		}
	}

	@Override
	public List<Tgm141Mt101Envcw> obtenerListaArchivosParaReenvio() {
		logger.debug("MonitorCashBean: - Metodo: obtenerListaArchivosParaReenvio  -- **inicio**");
		List<Tgm141Mt101Envcw> result = null;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm141Mt101Envcw mapTgm141Mt101Envcw = (MapTgm141Mt101Envcw) session
					.getMapper(MapTgm141Mt101Envcw.class);
			result = mapTgm141Mt101Envcw.obtenerArchivosParaReenviar();
			logger.debug("MonitorCashBean: - result:" + result.size()
					+ "  -- **inicio**");
			session.close();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("MonitorCashBean: - Metodo: obtenerListaArchivosParaReenvio  -- **fin**");
		}
	}

	@Override
	public int setArchivoParaReenviar(Tgm140Mt101Solrv tgm140Mt101Solrv) {
		logger.debug("MonitorCashBean: - Metodo: setArchivoParaReenviar  -- **inicio**");
		int result = 0;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm140Mt101Solrv mapTgm140Mt101Solrv = session
					.getMapper(MapTgm140Mt101Solrv.class);
			try {
				result = mapTgm140Mt101Solrv
						.insertaArchivoParaReenviar(tgm140Mt101Solrv);
				session.commit();
			} catch (Exception ex) {
				session.rollback();
				ex.printStackTrace();
			} finally {
				session.close();
			}
			logger.debug("EventoWebBean: - result: " + result + " -- **fin**");
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("MonitorCashBean: - Metodo: setArchivoParaReenviar  -- **fin**");
		}
	}

	@Override
	public int updateArchivo(Tgm141Mt101Envcw tgm141Mt101Envcw) {
		logger.debug("MonitorCashBean: - Metodo: updateArchivo  -- **inicio**");
		int result = 0;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm141Mt101Envcw mapTgm141Mt101Envcw = session
					.getMapper(MapTgm141Mt101Envcw.class);
			try {
				result = mapTgm141Mt101Envcw.actualizaArchivo(tgm141Mt101Envcw);
				session.commit();
			} catch (Exception ex) {
				session.rollback();
				ex.printStackTrace();
			} finally {
				session.close();
			}
			logger.debug("EventoWebBean: - result: " + result + " -- **fin**");
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("MonitorCashBean: - Metodo: updateArchivo  -- **fin**");
		}
	}

	@Override
	public int updateLoteSigCfg() {
		logger.debug("MonitorCashBean: - Metodo: updateLoteSigCfg  -- **inicio**");
		int result = 0;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm046ParamCfg mapTgm046ParamCfg = session
					.getMapper(MapTgm046ParamCfg.class);
			try {
				result = mapTgm046ParamCfg.actualizarParametroCfg();
				session.commit();
			} catch (Exception ex) {
				session.rollback();
				ex.printStackTrace();
			} finally {
				session.close();
			}
			logger.debug("EventoWebBean: - result: " + result + " -- **fin**");
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("MonitorCashBean: - Metodo: updateLoteSigCfg  -- **fin**");
		}
	}
}
