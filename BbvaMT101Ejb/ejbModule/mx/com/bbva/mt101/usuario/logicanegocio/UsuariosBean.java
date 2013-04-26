package mx.com.bbva.mt101.usuario.logicanegocio;

import javax.ejb.Stateless;

import mx.com.bbva.mt101.configuration.Mt101SessionFactory;
import mx.com.bbva.mt101.entities.Tgm023Usuario;
import mx.com.bbva.mt101.mapper.MapTgm023Usuario;
import mx.com.bbva.mt101.usuario.negocio.IUsuarios;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

@Stateless
public class UsuariosBean implements IUsuarios {
	private static final Logger logger = Logger.getLogger(UsuariosBean.class);

	@Override
	public Tgm023Usuario getUsuario(Tgm023Usuario tgm023Usuario) {
		logger.debug("UsuariosBean: - Metodo: getUsuario  -- **inicio**");
		Tgm023Usuario result = null;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm023Usuario mapTgm023Usuario = (MapTgm023Usuario) session
					.getMapper(MapTgm023Usuario.class);
			result = mapTgm023Usuario.obtenerUsuario(tgm023Usuario);
			logger.debug("UsuariosBean: - result:" + result + "  -- **inicio**");
			session.close();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("UsuariosBean: - Metodo: getUsuario  -- **fin**");
		}
	}

}
