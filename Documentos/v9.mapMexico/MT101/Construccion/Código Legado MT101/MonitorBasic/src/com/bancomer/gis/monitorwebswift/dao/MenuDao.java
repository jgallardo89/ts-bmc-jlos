package com.bancomer.gis.monitorwebswift.dao;

import java.util.ArrayList;
import java.util.Collections;

import com.bancomer.gis.monitorwebswift.db.DataBase;
import com.bancomer.gis.monitorwebswift.vo.LinkVo;
import com.bancomer.gis.monitorwebswift.vo.MenuVo;
import com.bancomer.gis.monitorwebswift.vo.SubMenuVo;
import com.bancomer.gis.monitorwebswift.vo.Usuario;

public class MenuDao extends GeneralDAO{

	public MenuDao(int switchConnection) throws Exception {
		super(switchConnection);
	}
	
	public ArrayList<MenuVo> buildmenu() throws Exception{
		ArrayList<MenuVo> menus = null;
		ArrayList<SubMenuVo> submenus = null;
		try {
			ps = con.prepareStatement(DataBase.getQuery("getAllMenus"));
			rs = ps.executeQuery();
			menus = new ArrayList<MenuVo>();
			while(rs.next()){
				menus.add(
						new MenuVo(
								rs.getInt(1),
								rs.getString(2)
						)
				);
			}
			closeAll(new Object[]{ps,rs});
			
			//Por cada nodo raiz buscamos sus nodos hijos
			//que son links directos
			//en estos nodos cada subseccion es un link por eso dentro de cada link solo tiene
			// un objeto linkVo.
			for(MenuVo menu: menus){
				ps = con.prepareStatement(DataBase.getQuery("getSubMenuLinkPublic"));
				ps.setInt(1, menu.getNu_seccion());
				rs = ps.executeQuery();
				submenus = new ArrayList<SubMenuVo>();
				while(rs.next()){
					SubMenuVo submenu = new SubMenuVo(
							rs.getInt(4),
							rs.getString(6)
					);
					LinkVo link = new LinkVo(
								rs.getInt(1),
								rs.getInt(5),
								rs.getString(6),
								rs.getString(7),
								rs.getInt(9),
								rs.getString(10),
								rs.getInt(8)
					);
					ArrayList <LinkVo> links =  new ArrayList<LinkVo>();
					links.add(link);
					Collections.sort(links);
					submenu.setLinks(links);
					submenus.add(submenu);
				}
				closeAll(new Object[]{ps,rs});
				
				//Buscamos todos los submenus restantes por cada nodo raiz
				ps = con.prepareStatement(DataBase.getQuery("getSubMenu"));
				ps.setInt(1, menu.getNu_seccion());
				rs = ps.executeQuery();
				while(rs.next()){
					submenus.add(
							new SubMenuVo(
									rs.getInt(1),
									rs.getString(2)
							)
					);
				}
				closeAll(new Object[]{ps,rs});
				menu.setSubmenus(submenus);
			}
			
			for(MenuVo menu: menus){
				for(SubMenuVo submenu:menu.getSubmenus()){
					if(submenu.getNu_subseccion()!=0){
						ps = con.prepareStatement(DataBase.getQuery("getLinksPublic"));
						ps.setInt(1, menu.getNu_seccion());
						ps.setInt(2, submenu.getNu_subseccion());
						rs = ps.executeQuery();
						ArrayList <LinkVo> links =  new ArrayList<LinkVo>();
						while(rs.next()){
							LinkVo link = new LinkVo(
									rs.getInt(1),
									rs.getInt(5),
									rs.getString(6),
									rs.getString(7),
									rs.getInt(9),
									rs.getString(10),
									rs.getInt(8)
							);
							links.add(link);
						}
						Collections.sort(links);
						submenu.setLinks(links);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(new Object[]{ps,rs,con});
		}
		return menus;
	}
	
	public ArrayList<MenuVo> buildMenuByUser(int pais, int usuario) throws Exception{
		ArrayList<MenuVo> menus = null;
		ArrayList<SubMenuVo> submenus = null;
		ArrayList<LinkVo> links = null;
		MenuVo menu = null;
		SubMenuVo submenu = null;
		
		boolean agregar = false;
		int LastMenu, LastSubMenu;
		
		try {
			LastMenu = LastSubMenu = -1;
			// Obtenemos las ligas del menú a desplegar para el usuario
			ps = con.prepareStatement(DataBase.getQuery("ArmarMenu"));
			ps.setInt(1, usuario);
			ps.setInt(2, usuario);
			ps.setInt(3, pais);
			rs = ps.executeQuery();
			menus = new ArrayList<MenuVo>();
			submenus = new ArrayList<SubMenuVo>();
			
			while(rs.next()){
				// Si se cambia de subseccion, o no hay subseccion
				if(rs.getInt("CD_SUBSECCION") == 0 || rs.getInt("CD_SUBSECCION") != LastSubMenu){
					// Si ya hay una subseccion anterior creada, agregarle sus ligas
					if(agregar){
						submenu.setLinks(links);
						submenus.add(submenu);
					}
					
					// Si se cambia de seccion
					if(rs.getInt("CD_SECCION") != LastMenu){
						// Si ya hay una seccion anterior creada, agregarle sus submenús
						if(agregar){
							menu.setSubmenus(submenus);
							submenus = new ArrayList<SubMenuVo>();
							menus.add(menu);
						}
						
						// Crear nuevo menú
						menu = new MenuVo(rs.getInt("CD_SECCION"), rs.getString("NB_SECCION"));
						LastMenu = rs.getInt("CD_SECCION");
					}
					
					// Crear nuevo submenu
					submenu = new SubMenuVo(rs.getInt("CD_SUBSECCION"), rs.getString("NB_SUBSECCION"));
					
					// Crear nueva lista de ligas
					links = new ArrayList<LinkVo>();
					
					LastSubMenu = rs.getInt("CD_SUBSECCION");
				}
				
				LinkVo link = new LinkVo(
						rs.getInt("CD_LIGA"),
						rs.getInt("CD_TP_LIGA"),
						rs.getString("NB_LIGA"),
						rs.getString("NB_RUTA_LIGA"),
						rs.getInt("TP_LIGA_PRIVADA"),
						rs.getString("TX_LIGA"),
						rs.getInt("ORD_LIG")
				);
				links.add(link);
				
				agregar = true;
			}
			closeAll(new Object[]{ps,rs});
			
			// Si quedaron elementos por insertar
			if(links.size() > 0){
				submenu.setLinks(links);
				submenus.add(submenu);
				
				menu.setSubmenus(submenus);
				menus.add(menu);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(new Object[]{ps,rs,con});
		}
		return menus;
	}
	
	public ArrayList<MenuVo> buildMenuByCountry(Usuario user) throws Exception{
		ArrayList<MenuVo> menus = null;
		ArrayList<SubMenuVo> submenus = null;
    	
		try {
			ps = con.prepareStatement(DataBase.getQuery("getAllMenus"));
			rs = ps.executeQuery();
			menus = new ArrayList<MenuVo>();
			while(rs.next()){
				menus.add(
						new MenuVo(
								rs.getInt(1),
								rs.getString(2)
						)
				);
			}
			closeAll(new Object[]{ps,rs});
			
			//Por cada nodo raiz buscamos sus nodos hijos
			//que son links directos
			//en estos nodos cada subseccion es un link por eso dentro de cada link solo tiene
			// un objeto linkVo.
			for(MenuVo menu: menus){
				ps = con.prepareStatement(DataBase.getQuery("getSubMenuLinkPrivateByCountry"));
				ps.setInt(1, menu.getNu_seccion());
				ps.setInt(2, (int)user.getNuPais());
				ps.setInt(3, menu.getNu_seccion());
				rs = ps.executeQuery();
				submenus = new ArrayList<SubMenuVo>();
				while(rs.next()){
					SubMenuVo submenu = new SubMenuVo(
							rs.getInt(4),
							rs.getString(6)
					);
					LinkVo link = new LinkVo(
							rs.getInt(1),
							rs.getInt(5),
							rs.getString(6),
							rs.getString(7),
							rs.getInt(9),
							rs.getString(10),
							rs.getInt(8)
					);
					ArrayList <LinkVo> links =  new ArrayList<LinkVo>();
					links.add(link);
					Collections.sort(links);
					submenu.setLinks(links);
					submenus.add(submenu);
				}
				closeAll(new Object[]{ps,rs});
				
				//Buscamos todos los submenus restantes por cada nodo raiz
				ps = con.prepareStatement(DataBase.getQuery("getSubMenu"));
				ps.setInt(1, menu.getNu_seccion());
				rs = ps.executeQuery();
				while(rs.next()){
					submenus.add(
							new SubMenuVo(
									rs.getInt(1),
									rs.getString(2)
							)
					);
				}
				closeAll(new Object[]{ps,rs});
				menu.setSubmenus(submenus);
			}
			
			for(MenuVo menu: menus){
				for(SubMenuVo submenu:menu.getSubmenus()){
					if(submenu.getNu_subseccion()!=0){
						ps = con.prepareStatement(DataBase.getQuery("getLinksPrivateByCountry"));
						ps.setInt(1, menu.getNu_seccion());
						ps.setInt(2, submenu.getNu_subseccion());
						ps.setInt(3, (int)user.getNuPais());
						ps.setInt(4, menu.getNu_seccion());
						ps.setInt(5, submenu.getNu_subseccion());
						rs = ps.executeQuery();
						ArrayList <LinkVo> links =  new ArrayList<LinkVo>();
						while(rs.next()){
							LinkVo link = new LinkVo(
									rs.getInt(1),
									rs.getInt(5),
									rs.getString(6),
									rs.getString(7),
									rs.getInt(9),
									rs.getString(10),
									rs.getInt(8)
							);
							links.add(link);
						}
						Collections.sort(links);
						submenu.setLinks(links);
					}
				}
			}
		}catch(Exception e){
			throw new Exception (e.getMessage());
		}finally{
			closeAll(new Object[]{ps,rs,con});
		}
	return menus;
	}
}