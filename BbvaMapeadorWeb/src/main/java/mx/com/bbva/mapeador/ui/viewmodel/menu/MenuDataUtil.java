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
 * Nombre de proyecto: BbvaMapeadorWeb
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
 * Nombre de clase: MenuDataUtil.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.viewmodel.menu
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.viewmodel.menu;

import java.util.List;

import javax.ejb.EJB;

import mx.com.bbva.mapeador.ejb.menu.logicanegocio.MenuService;
import mx.com.bbva.mapeador.ejb.menu.negocio.IMenu;
import mx.com.bbva.mapeador.entity.tgm501pantalla.Tgm501Pantalla;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuDataUtil.
 */
public class MenuDataUtil {
	
	/** The Constant logger. */
	private static final Logger logger = Logger
			.getLogger(MenuDataUtil.class);
	
	/** The cd cve usuario. */
	private String cdCveUsuario;
	
	/** The menu. */
	private List<Tgm501Pantalla> menu;
	
	/** The menu primer nivel. */
	private List<Tgm501Pantalla> menuPrimerNivel;
	
	/** The menu segundo nivel. */
	private List<Tgm501Pantalla> menuSegundoNivel;
	
	/** The menu service. */
	@EJB
	IMenu menuService;
	
	/** The root. */
	private MenuTreeNode<MenuData> root;
	
	/**
	 * Gets the root.
	 *
	 * @param userId the user id
	 * @return the root
	 */
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
                        "Menu", null, tgm501Pantalla.getTxUrlIcon()),new MenuTreeNodeCollection<MenuData>() {
					private static final long serialVersionUID = 1L;
					{
						for (final Tgm501Pantalla tgm501Pantalla2 : menu) {
							tgm501Pantalla2.setCdCveUsuario(cdCveUsuario);
							tgm501Pantalla2.setCdFkPantalla(tgm501Pantalla2.getCdPantalla());
							menuPrimerNivel = menuService.obtenerMenuPorUsuario(tgm501Pantalla2);
							if(menuPrimerNivel.size()==0){
								add(new MenuTreeNode<MenuData>(new MenuData(
										tgm501Pantalla2.getNbPantalla(), tgm501Pantalla2.getTxUrlPantalla(), tgm501Pantalla2.getTxUrlIcon())));
							}else{
								add(new MenuTreeNode<MenuData>(new MenuData(
										tgm501Pantalla2.getNbPantalla(),null, tgm501Pantalla2.getTxUrlIcon()), new MenuTreeNodeCollection<MenuData>() {
											private static final long serialVersionUID = 1L;
											{
												for (final Tgm501Pantalla tgm501Pantalla3 : menuPrimerNivel) {
													tgm501Pantalla3.setCdCveUsuario(cdCveUsuario);
													tgm501Pantalla3.setCdFkPantalla(tgm501Pantalla3.getCdPantalla());
													menuSegundoNivel = menuService.obtenerMenuPorUsuario(tgm501Pantalla3);
													logger.debug(tgm501Pantalla3.getTxUrlPantalla());
													if(menuSegundoNivel.size()==0){
														add(new MenuTreeNode<MenuData>(new MenuData(
																tgm501Pantalla3.getNbPantalla(), tgm501Pantalla3.getTxUrlPantalla(),tgm501Pantalla3.getTxUrlIcon())));
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
