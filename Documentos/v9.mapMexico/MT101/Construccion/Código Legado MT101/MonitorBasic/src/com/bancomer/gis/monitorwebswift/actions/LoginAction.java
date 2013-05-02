package com.bancomer.gis.monitorwebswift.actions;

import static com.bancomer.gis.monitorwebswift.util.Constants.CONTRASENA_USER_INVALIDOS;
import static com.bancomer.gis.monitorwebswift.util.Constants.INTENTOS_LOGEO_FALLIDOS;
import static com.bancomer.gis.monitorwebswift.util.Constants.LOGEO_EXITOSO;
import static com.bancomer.gis.monitorwebswift.util.Constants.ORACLE;
import static com.bancomer.gis.monitorwebswift.util.Constants.PASSWORD_CADUCO;
import static com.bancomer.gis.monitorwebswift.util.Constants.SESIONES_EXCEDIDAS;
import static com.bancomer.gis.monitorwebswift.util.Constants.USUARIO_BLOQUEADO;

import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bancomer.gis.monitorwebswift.dao.MenuDao;
import com.bancomer.gis.monitorwebswift.forms.LoginForm;
import com.bancomer.gis.monitorwebswift.logic.SecurityLogic;
import com.bancomer.gis.monitorwebswift.logic.ServicesLogic;
import com.bancomer.gis.monitorwebswift.vo.CountryVo;
import com.bancomer.gis.monitorwebswift.vo.MenuVo;
import com.bancomer.gis.monitorwebswift.vo.Usuario;


/**
 * @version 	1.0
 * @author		mfragoso
 */
public class LoginAction extends Action{
	
	private Logger log = null;

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

//    	log = AppLog.getLog("LoginAction");    	
        ActionErrors errors = new ActionErrors();
        ActionForward forward = new ActionForward(); // return value
        LoginForm loginForm = (LoginForm) form;
//        log.warn(loginForm.getUserName());
        try {
        	SecurityLogic security = null;
    		//security = new SecurityDao(Constants.SWIFT);
        	security = new SecurityLogic();
        	request.getSession().setAttribute("messageLogin","");
    		switch(security.login(loginForm.getUserName(), loginForm.getPassword())){
    			
    		case LOGEO_EXITOSO:
    				request.getSession().setAttribute("messageLogin", "success");
    				Usuario user = new Usuario();
    				user.setCdCveUsuario(loginForm.getUserName());
    				
    				security.fillUserData(user);
    				
    				//Cuando llenamos la informacion del usuario, tambien formamos todos los links publicos y los que tiene por 
    				// grupo y por usuario, ahora tendremos que formar el menu segun esos links. peeeero tambien por el pais..
    				//primeramente en el login nos llevaremos y formaremos el menu, dependiendo del pais de donde sea el usuario..
    				
    				ArrayList<MenuVo> menus = new MenuDao(ORACLE).buildMenuByUser((int)user.getNuPais(), (int)user.getNuUsuario());
    				request.getSession().removeAttribute("menus");
    				request.getSession().setAttribute("menus", menus);
    				request.getSession().setAttribute("userMonitorGMM", user);
    				forward = mapping.findForward("welcome");
    				//Una vez que se ha logeado exitosamente debemos cargar todo los datos generales que deben estar
    				//session
    				ServicesLogic logic = new ServicesLogic();
    				ArrayList channels 	= logic.getChannels();
    	        	ArrayList countries = logic.getCountries();
    	        	Collections.sort(countries);
    	        	CountryVo country = (CountryVo)countries.get(0);
    	        	//ArrayList codesBicEuros = logic.getCodesBicEuros();
    	        	ArrayList coins = logic.getCoins();
    	        	ArrayList products = logic.getProducts(country.getNu_pais());
    	        	ArrayList services 	= logic.getServices();
    	        	
    	        	//Si el usuario pertenece al grupo de administradores debe aparecer un combo de tooodos los paises
    	        	// en el menu en caso contrario solo los paises donde existan ligas...
    	        	/*boolean admin = false;
    	        	for(String group: user.getGroups()){
    	        		int idGroup = Integer.parseInt(group);
    	        		if(new GisDao(1).getGroupById(idGroup).equalsIgnoreCase("ADMINISTRADORES")){
    	        			admin = true;
    	        			break;
    	        		}
    	        		else admin= false;
    	        	}*/
    	        	ArrayList countriesByLinks = null;
    	        	//if(!admin){
    	        		countriesByLinks = logic.getCountriesByLinks((int)user.getNuUsuario());
    	        	/*}else{
    	        		countriesByLinks = countries;
    	        	}*/
    	        	
    	        	
    	        	request.getSession().setAttribute("channels", channels);
    	        	request.getSession().setAttribute("services", services);
    	        	request.getSession().setAttribute("countries", countries);
    	        	//request.getSession().setAttribute("codesBicEuros", codesBicEuros);
    	        	request.getSession().setAttribute("coins", coins);
    	        	request.getSession().setAttribute("products", products);
    	        	request.getSession().setAttribute("flows", logic.getAllFlows());
    	        	request.getSession().setAttribute("countriesByLinks", countriesByLinks);
    				request.getSession().setAttribute("paisMonitor", "MX");
    			break;
    			
    			case CONTRASENA_USER_INVALIDOS:
    				request.getSession().setAttribute("messageLogin", "Usuario o Contraseña incorrectos");
    				forward = mapping.findForward("login");
        		break;
        		
    			case INTENTOS_LOGEO_FALLIDOS:
    				request.getSession().setAttribute("messageLogin", "Usuario bloqueado");
    				forward = mapping.findForward("login");
            	break;
            	
    			case SESIONES_EXCEDIDAS:
    				request.getSession().setAttribute("messageLogin", "Límite de sesiones excedido");
    				forward = mapping.findForward("login");
            	break;
            	
    			case USUARIO_BLOQUEADO:
    				request.getSession().setAttribute("messageLogin", "Usuario bloqueado");
    				forward = mapping.findForward("login");
    			break;
    			
    			case PASSWORD_CADUCO:    			
    				request.getSession().setAttribute("messageLogin", "Password Ha Caducado");
    				user = new Usuario();
    				user.setCdCveUsuario(loginForm.getUserName());    				
    				security.fillUserData(user);
    				boolean servicioDesbloqueo = security.tieneServicioDebloqueo(user.getNuUsuario());
    				request.getSession().setAttribute("servDesbloqueo", servicioDesbloqueo);
    				request.getSession().setAttribute("userCaducoGMM", user);
    				forward = mapping.findForward("login");    				
    			break;
    		}
        } catch (Exception e) {
        	e.printStackTrace();
            errors.add("name", new ActionError("id"));
        }
        if (!errors.isEmpty()) {
            saveErrors(request, errors);
        }
        return (forward);
    }
}