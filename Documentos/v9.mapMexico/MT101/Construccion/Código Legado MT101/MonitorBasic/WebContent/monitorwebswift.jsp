<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<%@ page import="com.bancomer.gis.monitorwebswift.logic.ServicesLogic"%>
<%@ page import="com.bancomer.gis.monitorwebswift.util.Constants"%>
<%@ page import="com.bancomer.gis.monitorwebswift.dao.MenuDao"%>
<%@ page import="com.bancomer.gis.monitorwebswift.vo.MenuVo"%>
<%@ page import="com.bancomer.gis.monitorwebswift.dao.*"%>
<%@ page import="com.bancomer.gis.monitorwebswift.vo.*"%>
<%@ page import="java.io.OutputStream"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.*"%>


<%@page import="com.bancomer.gis.monitorwebswift.logic.CatalogoAvisosLogic"%><html>
<head>
<meta http-equiv="Content-Type" 	content="text/html; charset=ISO-8859-1">
<meta http-equiv="cache-control" 	content="no-cache">
<meta http-equiv="expires" 			content="0">
<meta http-equiv="pragma" 			content="no-cache">
<title>Monitor Web SWIFT</title>
<link rel="shortcut icon" href="<%=request.getContextPath()%>/images/MonitorWeb.ico"/>
<link href="<%=request.getContextPath()%>/css/layout.css"					rel="stylesheet"	type="text/css"/>
<link href="<%=request.getContextPath()%>/css/SpryMenuBarHorizontal.css"	rel="stylesheet"	type="text/css"/>
<style>
<!--
#MenuBar7 li {
	width: 133px;
	font-family: tahoma;
	font-size: small;
	font-weight: lighter;
	font-size-adjust: inherit;
}
#MenuBar7 ul, #MenuBar7 ul li {
	width: 133px;
	font-family: tahoma;
	font-size: x-small;
}
#MenuBar7 span {
	margin: 0;
	padding: 2px;
	padding-left: 5px;
	display: block;
	background-position: 0% 50%;
	background-repeat: no-repeat;
	border-color: black;
}
#MenuBar7 #item1-1 {
	background-image: url(<%=request.getContextPath()%>/images/menu/home.gif);
}
#MenuBar7 #item1-1 {
	background-image: url(<%=request.getContextPath()%>/images/italic.gif);
}
#MenuBar7 #item3 {
	background-image: url(<%=request.getContextPath()%>/images/numberedList.gif);
}
#MenuBar7 #item3-1 {
	background-image: url(<%=request.getContextPath()%>/images/forward.gif);
}
#MenuBar7 #item3-3 {
	background-image: url(<%=request.getContextPath()%>/images/justifyAlign.gif);
}
#MenuBar7 #item3-1-1 {
	background-image: url(<%=request.getContextPath()%>/images/new.gif);
}
.fondo{
	background-color: #D3E9EB;
}

.button
{
    FONT-SIZE: 8pt;
    FONT-FAMILY: Arial;
    width: 100px; 
    text-transform: capitalize;
}
.tableForm td{
	font-family: arial;
	font-size: 12px;
	color: #055A78;
}
A.myLink:link, A.myLink:visited { text-decoration: none }
A.myLink:hover { text-decoration: underline }
-->
</style>
<script src="<%=request.getContextPath()%>/js/spry/SpryMenuBar.js" 				type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/Ajax.js"							type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/scriptaculous/lib/prototype.js"		type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/ValidateFields.js" 					type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/utilerias.js"					 		type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/FixedIP/FixedIps.js"					 		type="text/javascript"></script>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>

</head>

<%
//Se obtiene el ultimo aviso que se ha publicado en la web
CatalogoAvisosLogic logic = new CatalogoAvisosLogic();
ArrayList avisos = logic.list();
String ultimoAviso = "";
String fechaUltAviso = "";
if(avisos != null && avisos.size() > 0){
    CoinVo aviso = (CoinVo)avisos.get(0);
	
	String [] fecha =   aviso.getIdCoinSW().split("-");
	int month = Integer.parseInt(fecha[1]);
	switch(month){
		case 1: fecha[1]="Ene"; break;
		case 2: fecha[1]="Feb"; break;
		case 3: fecha[1]="Mar"; break;
		case 4: fecha[1]="Abr"; break;
		case 5: fecha[1]="May"; break;
		case 6: fecha[1]="Jun"; break;
		case 7: fecha[1]="Jul"; break;
		case 8: fecha[1]="Ago"; break;
		case 9: fecha[1]="Sep"; break;
		case 10: fecha[1]="Oct"; break;
		case 11: fecha[1]="Nov"; break;
		case 12: fecha[1]="Dic"; break;
	}
	fechaUltAviso = '(' + fecha[0]+"-"+fecha[1]+"-"+fecha[2] + ')';
	ultimoAviso = aviso.getName();
}
String userName ="Acceso General";
ArrayList menus = null;
//Obtenemos la session, una nueva session, la cual pues aun no tiene el objeto del usuario.
//Eso quiere decir que aun no se ha logeado el cliente
Usuario user = (Usuario)request.getSession().getAttribute("userMonitorGMM");
String mensaje = (String) request.getSession().getAttribute("messageLogin");
Usuario usuarioCaduco = (Usuario)request.getSession().getAttribute("userCaducoGMM");
Boolean servDesbloqueo = (Boolean)request.getSession().getAttribute("servDesbloqueo");
//Si este objeto es null 
if(user == null){
	//Contruimos un menu de acceso general
	menus = new MenuDao(Constants.SWIFT).buildmenu();
}else{
	menus = (ArrayList)request.getSession().getAttribute("menus");
}
if(user!=null){
	userName = user.getCdCveUsuario();
}
if(mensaje != null && mensaje.equals("Password Ha Caducado")){
	request.getSession().removeAttribute("userMonitorGMM");
}
%>
<body onload="<% if(usuarioCaduco != null && mensaje != null && mensaje.equals("Password Ha Caducado")){ 
	out.write("changePassword('" + usuarioCaduco.getNuUsuario() + "','" + usuarioCaduco.getCdCveUsuario() + "'," + 1 + ", " + servDesbloqueo + ");");} %>">
<a style="text-align: center"> </a>
<div id="content">
	<div id="title">
		<img src="<%=request.getContextPath()%>/images/bbvaamerica.JPG" border="0" width="80%" height="100%">
	</div>
	<div id="menu">
		<div align="center" style="display: inline; height: 40px;" onmouseover="hidePDF();" onmouseout="blnMostrarPDF=true;setTimeout('showPDF()', 100);" onclick="blnMostrarPDF=true;setTimeout('showPDF()', 100);">
 			<ul id="MenuBar7" class="MenuBarHorizontal">
 				<%
 					
 						if(menus!=null){
 							//for(MenuVo menu:menus){
 								for(int numMenus=0; numMenus < menus.size(); numMenus++){
 									MenuVo menu = (MenuVo)menus.get(numMenus);
	 								try{
	 									
	 									if(menu.getSubmenus() != null && menu.getSubmenus().size() > 0 && ((SubMenuVo)menu.getSubmenus().get(0)).getLinks().size()>0){
		 									out.print("<li>");
		 									out.print("<a class=\'MenuBarItemSubmenu\' href=\'#\'><span>"+menu.getNb_seccion()+"</span></a>");
		 									out.print("<ul>");
		 									//for(SubMenuVo submenu: menu.getSubmenus()){		 									
		 									for(int numSubMenus = 0; numSubMenus < menu.getSubmenus().size(); numSubMenus++){
		 										SubMenuVo submenu =  (SubMenuVo)menu.getSubmenus().get(numSubMenus);
		 										if(submenu.getLinks().size()==1 && submenu.getNu_subseccion()==0){
		 											LinkVo link = (LinkVo)submenu.getLinks().get(0);
		 											switch(link.getNu_tipo_liga()){
														case 1: out.print("<li><a href=\'"+link.getNb_ruta_liga()+"\' target=\'bodyGMM\'><span>"+link.getNb_liga()+"</span></a></li>");
																break;
														case 2: out.print("<li><a href=\'"+request.getContextPath()+"/DoctosXliga?valorLiga="+link.getNu_liga()+"\' target=\'bodyGMM\'><span>"+link.getNb_liga()+"</span></a></li>");
																break;
														case 3: out.print("<li><a href=\'"+link.getNb_ruta_liga()+"\' target=\'bodyGMM\'><span>"+link.getNb_liga()+"</span></a></li>");
																break; 
													}
												}
		 										if(submenu.getLinks().size()==1 && submenu.getNu_subseccion()!=0){
		 											LinkVo link = (LinkVo)submenu.getLinks().get(0);
		 											out.print("<li><a href='#'><span>"+submenu.getNb_subseccion()+"</span></a>");
			 											out.print("<ul>");
			 												out.print("<li><a href=\'"+link.getNb_ruta_liga()+"\' target=\'bodyGMM\'><span>"+link.getNb_liga()+"</span></a></li>");
														out.print("</ul>");
													out.print("</li>");
								 				}
		 										if(submenu.getLinks().size()>1 && submenu.getNu_subseccion()==0){
		 											LinkVo link = (LinkVo)submenu.getLinks().get(0);
		 											switch(link.getNu_tipo_liga()){
														case 1: out.print("<li><a href=\'"+link.getNb_ruta_liga()+"\' target=\'bodyGMM\'><span>"+link.getNb_liga()+"</span></a></li>");
																	break;
														case 2: out.print("<li><a href=\'"+request.getContextPath()+"/DoctosXliga?valorLiga="+link.getNu_liga()+"\' target=\'bodyGMM\'><span>"+link.getNb_liga()+"</span></a></li>");
																break;
														case 3: out.print("<li><a href=\'"+link.getNb_ruta_liga()+"\' target=\'bodyGMM\'><span>"+link.getNb_liga()+"</span></a></li>");
																break; 
													}
												}
							 					if(submenu.getLinks().size()>1 && submenu.getNu_subseccion()>0){
							 						out.print("<li><a href=\'#\'><span>"+submenu.getNb_subseccion()+"</span></a>");
							 						out.print("<ul>");
							 						//for(LinkVo link:submenu.getLinks()){
													for(int numLinks=0; numLinks<submenu.getLinks().size(); numLinks++){	
							 							LinkVo link = (LinkVo)submenu.getLinks().get(numLinks);
														switch(link.getNu_tipo_liga()){
															case 1: out.print("<li><a href=\'"+link.getNb_ruta_liga()+"\' target=\'bodyGMM\'><span>"+link.getNb_liga()+"</span></a>");
																	break;
															case 2: out.print("<li><a href=\'"+request.getContextPath()+"/DoctosXliga?valorLiga="+link.getNu_liga()+"\' target=\'bodyGMM\'><span>"+link.getNb_liga()+"</span></a>");
																	break;
															case 3: out.print("<li><a href=\'"+link.getNb_ruta_liga()+"\' target=\'bodyGMM\'><span>"+link.getNb_liga()+"</span></a>");
																	break; 
														}
														
													 }
							 						out.print("</ul>");
								 					out.print("</li>");
								 				}
							 				}
		 									out.print("</ul>");
						 					out.print("</li>");
						 				}
	 								}catch(Exception e){
	 									
	 								}
 							}
 						}
		 %>
			</ul>
		</div>
		
	</div>
	<div id="directAccess">
	
		<a href="<%=request.getContextPath()%>/jsp/welcome.jsp" target="bodyGMM">
  		<img src="<%=request.getContextPath()%>/images/direct_access/home.png" border="0" width="40" height="45" style="behavior: url(<%=request.getContextPath()%>/js/iepngfix.htc);" alt="Inicio" title="Inicio"></a>
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
		<a href="<%=request.getContextPath()%>/jsp/menuHorizontal/avisos.jsp" target="bodyGMM">
  		<img src="<%=request.getContextPath()%>/images/direct_access/personas.png" border="0" width="40" height="45" style="behavior: url(<%=request.getContextPath()%>/js/iepngfix.htc);" alt="Extensión" title="Contactos LATAM"></a>
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
		<a href="<%=request.getContextPath()%>/jsp/menuHorizontal/avisos.jsp" target="bodyGMM">
  		<img src="<%=request.getContextPath()%>/images/direct_access/avisos.png" border="0" width="40" height="45" style="behavior: url(<%=request.getContextPath()%>/js/iepngfix.htc);" alt="Avisos" title="Avisos"></a>
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
  		
  		<a href="<%=request.getContextPath()%>/jsp/welcome.jsp" target="bodyGMM">
  		<img src="<%=request.getContextPath()%>/images/direct_access/calendario.png" border="0" width="40" height="45" style="behavior: url(<%=request.getContextPath()%>/js/iepngfix.htc);" alt="Calendario" title="Calendario"></a>
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		
  		<a href="<%=request.getContextPath()%>/contacto.do?method=initContacto" target="bodyGMM">
  		<img src="<%=request.getContextPath()%>/images/direct_access/telefono.png" border="0" width="40" height="45" style="behavior: url(<%=request.getContextPath()%>/js/iepngfix.htc);" alt="Comunicación" title="Contáctenos"></a>
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		  		  		
  		<a href="<%=request.getContextPath()%>/jsp/menuHorizontal/informacion.jsp" target="bodyGMM">
        <img src="<%=request.getContextPath()%>/images/direct_access/informacion.png" border="0" width="40" height="45" style="behavior: url(<%=request.getContextPath()%>/js/iepngfix.htc);" alt="Información" title="Información"></a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		
  		<a href="<%=request.getContextPath()%>/interfaces.do?method=list" target="bodyGMM">
  		<img src="<%=request.getContextPath()%>/images/direct_access/comunicacion.png" border="0" width="40" height="45" style="behavior: url(<%=request.getContextPath()%>/js/iepngfix.htc);" alt="Personas" title="Inventario de Interfaces"></a>
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		
  		<!--  
  		<a href="mailto:gmmlatam@bbva.bancomer.com">
  		<img src="<%=request.getContextPath()%>/images/direct_access/email.png" border="0" width="40" height="45" style="behavior: url(<%=request.getContextPath()%>/js/iepngfix.htc);" alt="e-mail" title="e-mail"></a>
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		-->
  		<logic:present name="userMonitorGMM">
  			<logic:notEmpty name="userMonitorGMM">
	  			<a href="<%=request.getContextPath()%>/rating.do?method=init" target="bodyGMM">
	  			<img src="<%=request.getContextPath()%>/images/direct_access/evaluacion.png" border="0" width="40" height="45" style="behavior: url(<%=request.getContextPath()%>/js/iepngfix.htc);" alt="Evaluación" title="Evaluación"></a>
	  			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  			</logic:notEmpty>
  		</logic:present>
  		
  		<a href="javascript:openFixedURL(fxMonitorWebswift_ManualUsuario,'bodyGMM');">
        <img src="<%=request.getContextPath()%>/images/direct_access/ayuda.jpg" border="0" width="45" height="45" style="behavior: url(<%=request.getContextPath()%>/js/iepngfix.htc);" alt="Ayuda" title="Manual de Usuario"></a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		
	</div>
	<div id="verticalSection"><br/><br/>
		<font style="color:#08c;" size="2"><b>Monitor Web Swift</b></font><br/><br/>
		<logic:notPresent name="userMonitorGMM">
		<html:form method="post" action="/login">
			<table width="100%" height="105px" align="center" class="tableForm">
				<logic:present name="messageLogin">
				<logic:notEqual name="messageLogin" value="success">
				<tr><td valign="top" align="center" colspan="2" class="myclass" ><br>
						<font color="red"><bean:write name="messageLogin" /></font>
				</td></tr>
				</logic:notEqual>
				</logic:present>
				<tr><td width="80%" valign="middle" align="center" height="10px">Usuario:</td></tr>
				<tr><td width="80%" valign="middle" align="center" height="10px"><input type="text" name="userName" id="userName" class="inputText" size="15" onblur="upper(this);" onkeyup="upper(this);"></td></tr>
				<tr><td width="80%" valign="middle" align="center" height="10px">Password:</td></tr>
				<tr><td width="80%" valign="middle" align="center" height="10px"><input type="password" name="password" id="password" size="15" class="inputText" onblur="upper(this);" onkeyup="upper(this);"></td></tr>
				<tr><td width="80%" valign="middle" align="center" height="10px"><div align="center"><input type="submit" value="login" class="button"></div></td></tr>				
			</table>
			<br></br>
			<br></br>
			<table width="95%" class="tableForm">
				<tr><td><b>Avisos</b></td></tr>				
				<tr align="justify"><td> <p align="justify"> <%= "<b>" + fechaUltAviso + "</b>" + ' ' +  ultimoAviso%> </p></td></tr>
			</table>
		</html:form>
		<% request.getSession().removeAttribute("messageLogin");%>
		</logic:notPresent>
		<logic:present name="userMonitorGMM">
			<html:form action="/refreshMenuByCountry" method="post" style="display:inline;">
				<select name="id" id='id' class="clasCombos" onchange="reloadMenuByCountry(this)" style="display:inline;">
					<logic:present name="countriesByLinks">
						<logic:iterate name="countriesByLinks"  id="country" >
							<% Integer holdcountry = (Integer)request.getSession().getAttribute("holdCountry");
								if(holdcountry == null) holdcountry = new Integer(6);
								String complete = ""+holdcountry.intValue();
							%>
							<logic:equal name="country" property="nu_pais" value="<%=complete%>">
								<option value='<bean:write name="country" property="nu_pais" />' selected="selected"><bean:write name="country" property="nb_pais"/></option>
							</logic:equal>
							<logic:notEqual name="country" property="nu_pais" value="<%=complete%>" >
								<option value='<bean:write name="country" property="nu_pais" />'><bean:write name="country" property="nb_pais"/></option>
							</logic:notEqual>
						</logic:iterate>
					</logic:present>
				</select><br>				
				</html:form>
			<% 
				if(user instanceof com.bancomer.gis.monitorwebswift.vo.Usuario){%>
				<font style="font-family: arial; font-size: 12px; color:#055A78;">
					Bienvenido <br>
					<bean:write name="userMonitorGMM" property="nbNombreUsr"/>&nbsp;<bean:write name="userMonitorGMM" property="nbApellPat"/><br>
					<input type="hidden" id="userName" name="userName" value='<bean:write name="userMonitorGMM" property="cdCveUsuario"/>'>
				<%}%>
				</font><br>
           		<a href="#" style="color: #08c;" class="myLink" onclick="changePassword('<bean:write name="userMonitorGMM" property="nuUsuario"/>','<bean:write name="userMonitorGMM" property="cdCveUsuario"/>', 0);">Cambiar Password</a><br>
				<a  style="color: #08c;" class="myLink" href="<%=request.getContextPath()%>/DeleteOneSession?user=<bean:write name="userMonitorGMM" property="cdCveUsuario"/>" onclick="alert('Su sesión ha finalizado');" >Cerrar Sesión</a>
				<br></br>
				<br></br>
				<br></br>
				<table width="95%" class="tableForm">
				<tr><td><b>Avisos</b></td></tr>				
				<tr align="justify"><td> <p align="justify"> <%= "<b>" + fechaUltAviso + "</b>" + ' ' +  ultimoAviso%> </p></td></tr>
				</table>
		</logic:present>
	</div>
	
	<div id="bodyContent">
		<iframe src="<%=request.getContextPath()%>/jsp/welcome.jsp" frameborder="0" width="100%" height="99%" scrolling="no" name="bodyGMM" id="bodyGMM"></iframe>
	</div>
	
	<div id="pie">
  	<table width="100%" border="0" cellspacing="0" cellpadding="0" height="20">
		  <tr valign="middle" class="fondo"> 
		    <td width="348"><font size="1" face="Verdana, Arial, Helvetica, sans-serif" color="#055A78">&nbsp;Copyright 
		      © 2009&nbsp;<b>BBVA Am&eacute;rica </b> v 1.33</font></td>
		    <td width="402"> 
		      <div align="center"><font color="#CFD8DE" size="1" face="Verdana, Arial, Helvetica, sans-serif"><b> <a href="mailto:gmmlatam@bbva.bancomer.com">contacto</a></b></font></div>		     
		    </td>
		  </tr>
	</table>
  </div>
</div>
<script type="text/javascript">
var MenuBar7 = new Spry.Widget.MenuBar("MenuBar7", {imgDown:"SpryMenuBarDownHover.gif", imgRight:"SpryMenuBarRightHover.gif"});
var blnMostrarPDF;

function hidePDF(){
    var elem = document.getElementById('bodyGMM');
	var extBodyGMM;

	try{
		extBodyGMM = new String(bodyGMM.location);
		extBodyGMM = extBodyGMM.toUpperCase();
		extBodyGMM = extBodyGMM.substring(extBodyGMM.length - 4);
	}
	catch(err){
		extBodyGMM = ".PDF";
	}
	
	if(extBodyGMM == ".PDF" || extBodyGMM == ".DOC" || extBodyGMM == ".PPT" || extBodyGMM == ".XLS"){
		blnMostrarPDF = false;
		if(elem.style.display != "none")
			elem.style.display = "none"; 
	}
}

function showPDF(){
    var elem = document.getElementById('bodyGMM');

	if(blnMostrarPDF == true)
    	if(elem.style.display == "none")
    		elem.style.display = "block";
}

function closeSession(url){
	$Ajax(url , {
		cache:false, 
		onfinish:function(html){
		},
		onerror:function(html){
			alert("Ocurrió un error al cerrar sesión");
		}
		});
}
function reloadMenuByCountry(element){
	document.forms[0].submit();
}

function changePassword(usr,cd,cambio, servDesbloqueo){	
	if(cambio == 0){
		if(confirm("¿En verdad desea modificar su contraseña?")){
			abrir('jsp/changePassword.jsp?o='+usr+'&u='+cd, 0, 0, 0, 0, 0, 0, 0, 400, 190, 100, 100, 1);
		}
	}
	else{
		if (servDesbloqueo){
			abrir('jsp/changePassword.jsp?o='+usr+'&u='+cd, 0, 0, 0, 0, 0, 0, 0, 400, 190, 100, 100, 1);
		}
		else {
			abrir('jsp/changePassword.jspx?o='+usr+'&u='+cd+'&serv='+servDesbloqueo, 0, 0, 0, 0, 0, 0, false, 1000, 550, 100, 100, 1);
		}
	}
}
</script>
</body>
</html>