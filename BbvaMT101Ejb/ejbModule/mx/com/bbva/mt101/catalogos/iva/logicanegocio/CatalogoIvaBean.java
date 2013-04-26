package mx.com.bbva.mt101.catalogos.iva.logicanegocio;

import java.util.List;

import javax.ejb.Stateless;

import mx.com.bbva.mt101.catalogos.iva.negocio.ICatalogoIva;
import mx.com.bbva.mt101.configuration.Mt101SessionFactory;
import mx.com.bbva.mt101.entities.Tgm041IvaMx;
import mx.com.bbva.mt101.mapper.MapTgm041IvaMx;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

@Stateless
public class CatalogoIvaBean implements ICatalogoIva {
	private static final Logger logger = Logger
			.getLogger(CatalogoIvaBean.class);

	public Tgm041IvaMx buscarTgm041IvaMx(Tgm041IvaMx tgm041IvaMx) {
		return null;
	}

	public List<Tgm041IvaMx> filtarTgm041IvaMx(Tgm041IvaMx tgm041IvaMx) {
		return null;
	}

	public List<Tgm041IvaMx> obtenerTodosTgm041IvaMx(Tgm041IvaMx tgm041IvaMx) {
		logger.debug("CatalogoIvaBean: - Metodo: obtenerTodosTgm041IvaMx -- **inicio**");
		List<Tgm041IvaMx> result = null;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm041IvaMx mapTgm042MonedaMx = (MapTgm041IvaMx) session
					.getMapper(MapTgm041IvaMx.class);
			result = mapTgm042MonedaMx.buscarTodosIvas();
			session.close();
			return result;
		} catch (Exception ex) {
			logger.debug("CatalogoIvaBean: - Metodo: obtenerTodosTgm041IvaMx -- **Excepción**");
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("CatalogoIvaBean: - Metodo: obtenerTodosTgm041IvaMx -- **fin**");
		}
	}

	public void salavarCatalogo(Tgm041IvaMx tgm041IvaMx) {
	}
}