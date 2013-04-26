package mx.com.bbva.mt101.catalogos.operacion.logicanegocio;

import java.util.List;

import javax.ejb.Stateless;

import mx.com.bbva.mt101.catalogos.operacion.negocio.ICatalogoOperacion;
import mx.com.bbva.mt101.configuration.Mt101SessionFactory;
import mx.com.bbva.mt101.entities.Tgm053TipoOpMx;
import mx.com.bbva.mt101.mapper.MapTgm053TipoOpMx;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

@Stateless (mappedName="CatalogoOperacionBean") 
public class CatalogoOperacionBean implements ICatalogoOperacion {
	
	private static final Logger logger = Logger
			.getLogger(CatalogoOperacionBean.class);

	@Override
	public Tgm053TipoOpMx getOperacionPorCriterio(
			Tgm053TipoOpMx tgm053TipoOpMx) {
		logger.debug("CatalogoOperacionBean: - Metodo: getOperacionPorCriterio  -- **inicio**");
		Tgm053TipoOpMx result = null;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm053TipoOpMx mapTgm053TipoOpMx = session
					.getMapper(MapTgm053TipoOpMx.class);
			result = mapTgm053TipoOpMx.buscarTpOpPorCriterio(tgm053TipoOpMx);
			logger.debug("CatalogoOperacionBean: - result:" + result.getImComisionMxn()
					+ "  -- **inicio**");
			session.close();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("CatalogoOperacionBean: - Metodo: getOperacionPorCriterio  -- **fin**");
		}
	}
}
