package com.bancomer.gis.monitorwebswift.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bancomer.gis.monitorwebswift.dao.SecurityDao;
import com.bancomer.gis.monitorwebswift.util.AppLog;
import com.bancomer.gis.monitorwebswift.vo.Usuario;

import static com.bancomer.gis.monitorwebswift.util.Constants.*;
/**
 * Servlet implementation class DeleteOneSession
 */
public class DeleteOneSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private Logger log = null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario user = (Usuario)request.getSession().getAttribute("userMonitorGMM");
		if(user==null){
			user = new Usuario();
			String userName = request.getParameter("user");
			user.setCdCveUsuario(userName);
		}
		log = AppLog.getLog("CatalogoArchivosProcesadosLogic");
		if(user!=null){
			try {
				SecurityDao security = new SecurityDao(SWIFT);
				security.closeSession(user.getCdCveUsuario());
				request.getSession().removeAttribute("userMonitorGMM");
				request.getSession().removeAttribute("menus");
				request.getSession().removeAttribute("messageLogin");
				request.getSession().removeAttribute("channels");
				request.getSession().removeAttribute("countries");
				request.getSession().removeAttribute("codesBicEuros");
				request.getSession().removeAttribute("coins");
				request.getSession().removeAttribute("products");
				request.getSession().removeAttribute("flows");
				request.getSession().invalidate();
			} catch (Exception e) {
				log.error("Error al cerrar sesión "+e.getMessage());
			}finally{
				response.sendRedirect(request.getContextPath());
			}
			
		}
			
	}
}
