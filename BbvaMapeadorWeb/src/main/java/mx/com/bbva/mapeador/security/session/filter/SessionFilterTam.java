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
 * Nombre de clase: SessionFilterTam.java
 * Nombre de paquete: mx.com.bbva.mapeador.security.session.filter
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
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

// TODO: Auto-generated Javadoc
/**
 * The Class SessionFilterTam.
 */
public class SessionFilterTam implements Filter{

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(SessionFilterTam.class);
	
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		Enumeration<String> headerNames = null; 
		headerNames = (request.getHeaderNames());
		Map<String, Object> sessionValues = new HashMap<String, Object>();
	    while(headerNames.hasMoreElements()) {
	      String headerName = headerNames.nextElement();
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

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
