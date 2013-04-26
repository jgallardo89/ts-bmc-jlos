package mx.com.bbva.mt101.audit.logicanegocio;

import javax.ejb.Stateless;

import mx.com.bbva.mt101.audit.negocio.IEventoWeb;
import mx.com.bbva.mt101.configuration.Mt101SessionFactory;
import mx.com.bbva.mt101.entities.Tgm107EventoWeb;
import mx.com.bbva.mt101.mapper.MapTgm107EventoWeb;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

@Stateless
public class EventoWebBean implements IEventoWeb {

	private static final Logger logger = Logger.getLogger(EventoWebBean.class);

	@Override
	public int setEventoWeb(Tgm107EventoWeb tgm107EventoWeb) {
		logger.debug("EventoWebBean: - Metodo: setEventoWeb  -- **inicio**");
		int result = 0;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm107EventoWeb mapTgm107EventoWeb = session
					.getMapper(MapTgm107EventoWeb.class);
			try {
				result = mapTgm107EventoWeb.salvarEventoWeb(tgm107EventoWeb);
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
			logger.debug("EventoWebBean: - Metodo: setEventoWeb  -- **fin**");
		}
	}
}
