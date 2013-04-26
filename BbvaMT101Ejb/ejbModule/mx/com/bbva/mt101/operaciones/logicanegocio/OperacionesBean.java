package mx.com.bbva.mt101.operaciones.logicanegocio;

import java.util.List;

import javax.ejb.Stateless;

import mx.com.bbva.mt101.configuration.Mt101SessionFactory;
import mx.com.bbva.mt101.entities.Tgm139Mt101Repte;
import mx.com.bbva.mt101.mapper.MapTgm139Mt101Repte;
import mx.com.bbva.mt101.operaciones.negocio.IOperaciones;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

@Stateless
public class OperacionesBean implements IOperaciones {

	private static final Logger logger = Logger
			.getLogger(OperacionesBean.class);

	@Override
	public long actualizaEstatusOperacionReprocesar(
			Tgm139Mt101Repte tgm139Mt101Repte) {
		logger.debug("OperacionesBean: - Metodo: actualizaEstatusOperacionReprocesar  -- **inicio**");
		long result = 0L;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm139Mt101Repte mapTgm139Mt101Repte = (MapTgm139Mt101Repte) session
					.getMapper(MapTgm139Mt101Repte.class);
			try {
				result = mapTgm139Mt101Repte
						.actualizaEstatusOperacionReprocesar(tgm139Mt101Repte);
				session.commit();
			} catch (Exception ex) {
				session.rollback();
				ex.printStackTrace();
			} finally {
				session.close();
			}
			logger.debug("OperacionesBean: - result: " + result + " -- **fin**");
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("OperacionesBean: - Metodo: actualizaEstatusOperacionReprocesar  -- **fin**");
		}
	}

	@Override
	public List<Tgm139Mt101Repte> getOperacionesFuturas(
			Tgm139Mt101Repte tgm139Mt101Repte) {
		logger.debug("OperacionesBean: - Metodo: getOperacionesFuturas  -- **inicio**");
		List<Tgm139Mt101Repte> result = null;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm139Mt101Repte mapTgm139Mt101Repte = (MapTgm139Mt101Repte) session
					.getMapper(MapTgm139Mt101Repte.class);
			result = mapTgm139Mt101Repte
					.obtenerOperacionesFuturas(tgm139Mt101Repte);
			logger.debug("OperacionesBean: - result:" + result.size()
					+ "  -- **inicio**");
			session.close();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("OperacionesBean: - Metodo: getOperacionesFuturas  -- **fin**");
		}
	}

	@Override
	public List<Tgm139Mt101Repte> getOperacionesPorCriterio(
			Tgm139Mt101Repte tgm139Mt101Repte) {
		logger.debug("OperacionesBean: - Metodo: getOperacionesPorCriterio  -- **inicio**");
		List<Tgm139Mt101Repte> result = null;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm139Mt101Repte mapTgm139Mt101Repte = (MapTgm139Mt101Repte) session
					.getMapper(MapTgm139Mt101Repte.class);
			result = mapTgm139Mt101Repte
					.obtenerOperacionesPorCriterio(tgm139Mt101Repte);
			logger.debug("OperacionesBean: - result:" + result.size()
					+ "  -- **inicio**");
			session.close();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("OperacionesBean: - Metodo: getOperacionesPorCriterio  -- **fin**");
		}
	}

	@Override
	public List<Tgm139Mt101Repte> getOperacionesPorEstatus(
			Tgm139Mt101Repte tgm139Mt101Repte) {
		logger.debug("OperacionesBean: - Metodo: getOperacionesPorEstatus  -- **inicio**");
		List<Tgm139Mt101Repte> result = null;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm139Mt101Repte mapTgm139Mt101Repte = (MapTgm139Mt101Repte) session
					.getMapper(MapTgm139Mt101Repte.class);
			result = mapTgm139Mt101Repte
					.obtenerOperacionesPorEstatus(tgm139Mt101Repte);
			logger.debug("OperacionesBean: - result:" + result.size()
					+ "  -- **inicio**");
			session.close();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("OperacionesBean: - Metodo: getOperacionesPorEstatus  -- **fin**");
		}
	}

	@Override
	public List<Tgm139Mt101Repte> getTotalesOperacionesPorCriterios(
			Tgm139Mt101Repte tgm139Mt101Repte) {
		logger.debug("OperacionesBean: - Metodo: getTotalesOperacionesPorCriterios  -- **inicio**");
		List<Tgm139Mt101Repte> result = null;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm139Mt101Repte mapTgm139Mt101Repte = (MapTgm139Mt101Repte) session
					.getMapper(MapTgm139Mt101Repte.class);
			result = mapTgm139Mt101Repte
					.obtenerTotalesOperacionesPorCriterios(tgm139Mt101Repte);
			logger.debug("OperacionesBean: - result:" + result.size()
					+ "  -- **inicio**");
			session.close();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("OperacionesBean: - Metodo: getTotalesOperacionesPorCriterios  -- **fin**");
		}
	}

	@Override
	public long updateEstatusOperacion(Tgm139Mt101Repte tgm139Mt101Repte) {
		logger.debug("OperacionesBean: - Metodo: updateEstatusOperacion  -- **inicio**");

		long result = 0L;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm139Mt101Repte mapTgm139Mt101Repte = (MapTgm139Mt101Repte) session
					.getMapper(MapTgm139Mt101Repte.class);
			try {
				result = mapTgm139Mt101Repte
						.actualizaEstatusOperacion(tgm139Mt101Repte);
				session.commit();
			} catch (Exception ex) {
				session.rollback();
				ex.printStackTrace();
			} finally {
				session.close();
			}
			logger.debug("OperacionesBean: - result: " + result + " -- **fin**");
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("OperacionesBean: - Metodo: updateEstatusOperacion  -- **fin**");
		}
	}
}
