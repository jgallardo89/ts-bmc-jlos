/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Informacion Confidencial:
 * Este software contiene informacion totalmente confidencial propiedad de Grupo Financiero BBVA Bancomer. 
 * Queda totalmente prohibido su uso o divulgacion en forma parcial o total y solamente podra ser utilizada de acuerdo a los terminos y estatutos 
 * que determine el Grupo Financiero BBVA Bancomer.
 * 
 * Todos los derechos reservados, Mexico 2013.
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * DESCRIPCION DEL PROGRAMA
 * Nombre de aplicación: MAPEADOR
 * Nombre de proyecto: BbvaMapeadorEjb
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * HISTORIAL DE CAMBIOS:
 * 
 * Fecha:									         	
 * 30-ABR-2013  
 * @Author:	Jose Luis Ortiz Salazar
 * @Email: jortizsalazar@gmail.com    	
 * Razon: Creacion        
 * Version: 1.0.0
 * Nombre de clase: MenuService.java
 * Nombre de paquete: mx.com.bbva.mapeador.ejb.menu.logicanegocio
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ejb.menu.logicanegocio;

import java.util.List;

import javax.ejb.Stateless;

import mx.com.bbva.mapeador.ejb.menu.negocio.IMenu;
import mx.com.bbva.mapeador.entity.tgm501pantalla.MapTgm501Pantalla;
import mx.com.bbva.mapeador.entity.tgm501pantalla.Tgm501Pantalla;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuService.
 */
@Stateless
public class MenuService implements IMenu {
	
	/** The Constant logger. */
	private static final Logger logger = Logger
			.getLogger(MenuService.class);
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ejb.menu.negocio.IMenu#obtenerMenuPorUsuario(mx.com.bbva.mapeador.entity.tgm501pantalla.Tgm501Pantalla)
	 */
	@Override
	public List<Tgm501Pantalla> obtenerMenuPorUsuario(Tgm501Pantalla tgm501Pantalla) {
		logger.debug("MenuService: - Metodo: obtenerMenuPorUsuario -- **inicio**");
		List<Tgm501Pantalla> result = null;
		try {
			SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm501Pantalla mapTgm501Pantalla = session
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
