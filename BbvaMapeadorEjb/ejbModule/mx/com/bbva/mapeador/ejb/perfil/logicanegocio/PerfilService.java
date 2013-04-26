package mx.com.bbva.mapeador.ejb.perfil.logicanegocio;

import java.util.List;

import javax.ejb.Stateless;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import mx.com.bbva.mapeador.ejb.menu.logicanegocio.MenuService;
import mx.com.bbva.mapeador.ejb.perfil.negocio.IPerfil;
import mx.com.bbva.mapeador.entity.tgm501pantalla.MapTgm501Pantalla;
import mx.com.bbva.mapeador.entity.tgm501pantalla.Tgm501Pantalla;
import mx.com.bbva.mapeador.entity.tgm504perfil.MapTgm504Perfil;
import mx.com.bbva.mapeador.entity.tgm504perfil.Tgm504Perfil;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

@Stateless
public class PerfilService implements IPerfil {

	private static final Logger logger = Logger
			.getLogger(PerfilService.class);
	
	@Override
	public List<Tgm504Perfil> obtenerPerfilesActivo() {
		logger.debug("PerfilService: - Metodo: obtenerPerfilesActivo -- **inicio**");
		List<Tgm504Perfil> result = null;
		try {
			SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm504Perfil mapTgm504Perfil = (MapTgm504Perfil) session
					.getMapper(MapTgm504Perfil.class);
			result = mapTgm504Perfil.obtenerPerfilesActivos();
			session.close();
			return result;
		} catch (Exception ex) {
			logger.debug("PerfilService: - Metodo: obtenerPerfilesActivo -- **Excepción**");
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("PerfilService: - Metodo: obtenerPerfilesActivo -- **fin**");
		}
	}

}
