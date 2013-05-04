package mx.com.bbva.mapeador.security.session.filter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class SessionFilterTam implements Filter{

	private static final Logger logger = Logger.getLogger(SessionFilterTam.class);
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		Enumeration<String> headerNames = null; 
		headerNames = ((Enumeration<String>)request.getHeaderNames());
		Map<String, Object> sessionValues = new HashMap<String, Object>();
	    while(headerNames.hasMoreElements()) {
	      String headerName = (String)headerNames.nextElement();
	      logger.debug("headerName:"+headerName);
	      logger.debug("headerNameValue:"+request.getHeader(headerName));
	      
	      sessionValues.put(headerName, request.getHeader(headerName));
	      
	      
	    }
	    HttpSession httpSession = request.getSession();
	    logger.debug("SessionId:"+httpSession.getId());	    
	    httpSession.setAttribute("sessionValues", sessionValues);
	    if(sessionValues.get("iv-user") != null){
	    	chain.doFilter(req, res);
	    }
	    else{
	    	logger.debug("No hay session valida");
	    	response.sendRedirect("https://localhost/bbva/mapeador/app/menu");
	    	chain.doFilter(req, res);
	    }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
