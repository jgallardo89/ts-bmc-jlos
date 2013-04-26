package mx.com.bbva.mt101.audit.logicanegocio;

import javax.ejb.Stateless;

import mx.com.bbva.mt101.audit.negocio.IProcesoLog;
import mx.com.bbva.mt101.configuration.Mt101SessionFactory;
import mx.com.bbva.mt101.entities.Tgm048ProcesoLog;
import mx.com.bbva.mt101.mapper.MapTgm048ProcesoLog;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

@Stateless
public class ProcesoLogBean implements IProcesoLog {

	private static final Logger logger = Logger.getLogger(ProcesoLogBean.class);

	@Override
	public int setProcesoLog(Tgm048ProcesoLog tgm048ProcesoLog) {
		logger.debug("ProcesoLogBean: - Metodo: setProcesoLog  -- **inicio**");
		int result = 0;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm048ProcesoLog mapTgm048ProcesoLog = session
					.getMapper(MapTgm048ProcesoLog.class);
			try {
				result = mapTgm048ProcesoLog.salvarProcesoLog(tgm048ProcesoLog);

				session.commit();
			} catch (Exception ex) {
				session.rollback();
				ex.printStackTrace();
			} finally {
				session.close();
			}
			logger.debug("ProcesoLogBean: - result: " + result + " -- **fin**");
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("ProcesoLogBean: - Metodo: setProcesoLog  -- **fin**");
		}
	}

}
