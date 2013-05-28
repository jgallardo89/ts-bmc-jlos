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

import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioVO;
import mx.com.bbva.bancomer.estatusobjeto.dto.UsuarioDTO;
import mx.com.bbva.bancomer.mapper.business.UsuarioBO;

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
	      sessionValues.put(headerName, request.getHeader(headerName).toUpperCase());
	    }
	    //Linea para pasar sin tam
	    logger.debug("request.getSession().getAttribute(iv-user):"+request.getSession().getAttribute("iv-user"));
	    if(request.getSession().getAttribute("iv-user")!=null)
	    	sessionValues.put("iv-user", request.getSession().getAttribute("iv-user"));
	    
	    HttpSession httpSession = request.getSession();
	    logger.debug("SessionId:"+httpSession.getId());	    
	    httpSession.setAttribute("sessionValues", sessionValues);
	    if(sessionValues.get("iv-user") != null){
	    	UsuarioBO usuarioBO = new UsuarioBO();
			UsuarioVO usuarioVO = new UsuarioVO();		
			usuarioVO.setIdCveUsuario(sessionValues.get("iv-user").toString());
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setUsuarioVO(usuarioVO);
			usuarioDTO = usuarioBO.readCommand(usuarioDTO);
			logger.debug("usuarioDTO.getUsuarioVOs().size():"+usuarioDTO.getUsuarioVOs().size());
			if(usuarioDTO.getUsuarioVOs().size()==1){
				logger.debug(usuarioDTO.getUsuarioVOs().get(0).getIdPerfil());
				logger.debug(usuarioDTO.getUsuarioVOs().get(0).getIdUsuario());
				sessionValues.put("id-perfil", usuarioDTO.getUsuarioVOs().get(0).getIdPerfil());
				sessionValues.put("id-usuario", usuarioDTO.getUsuarioVOs().get(0).getIdUsuario());
				httpSession.setAttribute("sessionValues", sessionValues);				
	    		chain.doFilter(req, res);
			}else{
    	    	logger.debug("No hay session valida");
    	    	response.sendRedirect("https://localhost/bbva/mapeador/app/menu");
    	    	chain.doFilter(req, res);
    	    }
	    }	    
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
