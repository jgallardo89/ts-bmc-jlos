package mx.com.bbva.mt101.catalogos.stop.logicanegocio;

import java.util.List;

import javax.ejb.Stateless;

import mx.com.bbva.mt101.catalogos.stop.negocio.ICatalogoStOp;
import mx.com.bbva.mt101.configuration.Mt101SessionFactory;
import mx.com.bbva.mt101.entities.Tgm142Mt101Stenv;
import mx.com.bbva.mt101.mapper.MapTgm142Mt101Stenv;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

@Stateless
public class CatalogoStOpBean implements ICatalogoStOp {

	private static final Logger logger = Logger
			.getLogger(CatalogoStOpBean.class);

	@Override
	public List<Tgm142Mt101Stenv> getTodosEstatus() {
		logger.debug("CatalogoStOpBean: - Metodo: getTodosEstatus -- **inicio**");
		List<Tgm142Mt101Stenv> result = null;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm142Mt101Stenv maptgm142mt101stenv = (MapTgm142Mt101Stenv) session
					.getMapper(MapTgm142Mt101Stenv.class);
			result = maptgm142mt101stenv.buscarTodosEstatus();
			session.close();
			return result;
		} catch (Exception ex) {
			logger.debug("CatalogoStOpBean: - Metodo: getTodosEstatus -- **Excepción**");
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("CatalogoStOpBean: - Metodo: getTodosEstatus -- **fin**");
		}
	}

}
