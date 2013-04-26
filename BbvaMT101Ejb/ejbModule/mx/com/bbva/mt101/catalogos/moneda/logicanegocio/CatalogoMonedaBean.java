package mx.com.bbva.mt101.catalogos.moneda.logicanegocio;

import java.util.List;

import javax.ejb.Stateless;

import mx.com.bbva.mt101.catalogos.moneda.negocio.ICatalogoMoneda;
import mx.com.bbva.mt101.configuration.Mt101SessionFactory;
import mx.com.bbva.mt101.entities.Tgm042MonedaMx;
import mx.com.bbva.mt101.mapper.MapTgm042MonedaMx;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

@Stateless
public class CatalogoMonedaBean implements ICatalogoMoneda {
	private static final Logger logger = Logger
			.getLogger(CatalogoMonedaBean.class);

	public Tgm042MonedaMx buscarTgm042MonedaMx(Tgm042MonedaMx tgm042MonedaMx) {
		return null; 
	}

	public List<Tgm042MonedaMx> filtarTgm042MonedaMx(
			Tgm042MonedaMx tgm042MonedaMx) {
		return null;
	}

	public List<Tgm042MonedaMx> obtenerTodosTgm042MonedaMx(
			Tgm042MonedaMx tgm042MonedaMx) {
		logger.debug("CatalogoMonedaBean: - Metodo: obtenerTodosTgm042MonedaMx -- **inicio**");
		List<Tgm042MonedaMx> result = null;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm042MonedaMx mapTgm042MonedaMx = (MapTgm042MonedaMx) session
					.getMapper(MapTgm042MonedaMx.class);
			result = mapTgm042MonedaMx.buscarTodasMonedas();
			session.close();
			return result;
		} catch (Exception ex) {
			logger.debug("CatalogoMonedaBean: - Metodo: obtenerTodosTgm042MonedaMx -- **Excepción**");
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("CatalogoMonedaBean: - Metodo: obtenerTodosTgm042MonedaMx -- **fin**");
		}
	}

	public void salavarCatalogo(Tgm042MonedaMx tgm042MonedaMx) {
	}
}