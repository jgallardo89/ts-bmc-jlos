package mx.com.bbva.mapeador.ejb.menu.logicanegocio;

import java.util.List;

import javax.ejb.Stateless;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import mx.com.bbva.mapeador.ejb.menu.negocio.IMenu;
import mx.com.bbva.mapeador.entity.tgm501pantalla.MapTgm501Pantalla;
import mx.com.bbva.mapeador.entity.tgm501pantalla.Tgm501Pantalla;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

@Stateless
public class MenuService implements IMenu {
	
	private static final Logger logger = Logger
			.getLogger(MenuService.class);
	
	@Override
	public List<Tgm501Pantalla> obtenerMenuPorUsuario(Tgm501Pantalla tgm501Pantalla) {
		logger.debug("MenuService: - Metodo: obtenerMenuPorUsuario -- **inicio**");
		List<Tgm501Pantalla> result = null;
		try {
			SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm501Pantalla mapTgm501Pantalla = (MapTgm501Pantalla) session
					.getMapper(MapTgm501Pantalla.class);
			result = mapTgm501Pantalla.obtenerPantallasPorUsuario(tgm501Pantalla);
			session.close();
			return result;
		} catch (Exception ex) {
			logger.debug("MenuService: - Metodo: obtenerMenuPorUsuario -- **Excepción**");
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("MenuService: - Metodo: obtenerMenuPorUsuario -- **fin**");
		}
	}

}
