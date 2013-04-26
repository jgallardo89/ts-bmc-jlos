package mx.com.bbva.mapeador.ui.viewmodel.menu;

import java.util.List;

import javax.ejb.EJB;

import org.apache.log4j.Logger;


import sun.util.logging.resources.logging;

import mx.com.bbva.mapeador.ejb.menu.logicanegocio.MenuService;
import mx.com.bbva.mapeador.ejb.menu.negocio.IMenu;
import mx.com.bbva.mapeador.entity.tgm501pantalla.Tgm501Pantalla;

public class MenuDataUtil {
	@EJB
	IMenu menuService;
	private String cdCveUsuario;
	private MenuTreeNode<MenuData> root;
	private List<Tgm501Pantalla> menu;
	private List<Tgm501Pantalla> menuPrimerNivel;
	private List<Tgm501Pantalla> menuSegundoNivel;
	
	private static final Logger logger = Logger
			.getLogger(MenuDataUtil.class);
	
	public MenuTreeNode<MenuData> getRoot(String userId){
		cdCveUsuario = userId;
		root =  new MenuTreeNode<MenuData>(null, new MenuTreeNodeCollection<MenuData>()) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				//add(new MenuTreeNode<MenuData>(new MenuData("Menu","bodyPage.src=null; bodyPage.src='/app/nohome'")));
				menuService = new MenuService();
				Tgm501Pantalla tgm501Pantalla = null;
				tgm501Pantalla = new Tgm501Pantalla();
				tgm501Pantalla.setCdCveUsuario(cdCveUsuario);
				long cdFkPantalla = 1;
				tgm501Pantalla.setCdFkPantalla(cdFkPantalla);
				menu = menuService.obtenerMenuPorUsuario(tgm501Pantalla);				
				add(new MenuTreeNode<MenuData>(new MenuData(
                        "Menu", null),new MenuTreeNodeCollection<MenuData>() {
					private static final long serialVersionUID = 1L;
					{
						for (final Tgm501Pantalla tgm501Pantalla2 : menu) {
							tgm501Pantalla2.setCdCveUsuario(cdCveUsuario);
							tgm501Pantalla2.setCdFkPantalla(tgm501Pantalla2.getCdPantalla());
							menuPrimerNivel = menuService.obtenerMenuPorUsuario(tgm501Pantalla2);
							if(menuPrimerNivel.size()==0){
								add(new MenuTreeNode<MenuData>(new MenuData(
										tgm501Pantalla2.getNbPantalla(), tgm501Pantalla2.getTxUrlPantalla())));
							}else{
								add(new MenuTreeNode<MenuData>(new MenuData(
										tgm501Pantalla2.getNbPantalla(),null), new MenuTreeNodeCollection<MenuData>() {
											private static final long serialVersionUID = 1L;
											{
												for (final Tgm501Pantalla tgm501Pantalla3 : menuPrimerNivel) {
													tgm501Pantalla3.setCdCveUsuario(cdCveUsuario);
													tgm501Pantalla3.setCdFkPantalla(tgm501Pantalla3.getCdPantalla());
													menuSegundoNivel = menuService.obtenerMenuPorUsuario(tgm501Pantalla3);
													logger.debug(tgm501Pantalla3.getTxUrlPantalla());
													if(menuSegundoNivel.size()==0){
														add(new MenuTreeNode<MenuData>(new MenuData(
																tgm501Pantalla3.getNbPantalla(), tgm501Pantalla3.getTxUrlPantalla())));
													}else{
														
													}
												}
											}
										}));								
							}
						}
					}
				}));				
			}
		};
		return root;		
	}
}
