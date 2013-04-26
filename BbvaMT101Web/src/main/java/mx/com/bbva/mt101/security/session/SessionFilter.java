package mx.com.bbva.mt101.security.session;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.ejb.EJB;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.com.bbva.mt101.entities.Tgm023Usuario;
import mx.com.bbva.mt101.usuario.logicanegocio.UsuariosBean;
import mx.com.bbva.mt101.usuario.negocio.IUsuarios;

import org.apache.log4j.Logger;

public class SessionFilter implements Filter {

	private static final Logger logger = Logger.getLogger(SessionFilter.class);
	@EJB
	IUsuarios usuariosBean = null;
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		try {
			String url = request.getServletPath();
			boolean allowedRequest = false;

			HttpSession httpSession = request.getSession();

			Enumeration<String> enumerationSession = httpSession
					.getAttributeNames();

			logger.debug("filtrando la petición:" + request.getContextPath());
			logger.debug("filtrando la petición:" + request.getAuthType());
			logger.debug("filtrando la petición:" + request.getRequestURI());
			// logger.debug("filtrando la petición nombre obj:"+(httpSession.getValue("javax.zkoss.zk.ui.Session")).getClass().getName());
			// HttpSession httpSessionZK =
			// (HttpSession)httpSession.getAttribute("javax.zkoss.zk.ui.Session");

			String sessid = (String) request.getAttribute("JSESSIONID");
			logger.debug("filtrando la petición:" + sessid);

			String[] valoresSesion = httpSession.getValueNames();
			for (String string : valoresSesion) {
				logger.debug("filtrando la petición string:" + string);
			}
			// no paramater
			Class noparams[] = {};
			Method method = null;
			method = (httpSession.getAttribute("userMonitorGMM")).getClass()
					.getDeclaredMethod("getCdCveUsuario", noparams);
		
			String usuario = null;
			String cdClaveUsuario = null;
		
				
				
			cdClaveUsuario = (String)method.invoke(
					httpSession.getAttribute("userMonitorGMM"), noparams);
			Tgm023Usuario tgm023Usuario = null;
			tgm023Usuario = new Tgm023Usuario();
			tgm023Usuario.setCdClaveUsuario(cdClaveUsuario);
			usuariosBean = new UsuariosBean();			
			tgm023Usuario = usuariosBean.getUsuario(tgm023Usuario) ;
			logger.debug("CdUsuario:"+tgm023Usuario.getCdUsuario());
			httpSession.setAttribute("tgm023Usuario", tgm023Usuario);
			
			logger.debug("usuario:" + usuario);

			while (enumerationSession.hasMoreElements()) {
				logger.debug(enumerationSession.nextElement().toString());
			}
			chain.doFilter(req, res);
		}catch(NullPointerException e) {
			e.printStackTrace(); 			
			response.sendRedirect("http://localhost:9080/MonitorWebSwift/monitorwebswift.jsp");			
		}catch (Exception e) {
 			e.printStackTrace(); 			 
 			response.sendRedirect("http://localhost:9080/mt101/TimeOut.html");

		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		logger.debug("Dando de alta el filtro");

	}

	public IUsuarios getUsuariosBean() {
		return usuariosBean;
	}

	public void setUsuariosBean(IUsuarios usuariosBean) {
		this.usuariosBean = usuariosBean;
	}

}
