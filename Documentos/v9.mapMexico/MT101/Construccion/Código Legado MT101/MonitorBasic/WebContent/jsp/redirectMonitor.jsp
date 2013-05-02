<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld"  prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="com.bancomer.gis.monitorwebswift.vo.*"%>
<html>
<head>

<%@ page import="com.bancomer.gis.monitorwebswift.vo.Convertidor" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Redirect Monitor</title>
<link href="<%=request.getContextPath()%>/css/MonitorGmmStyles.css" rel="stylesheet" type="text/css"/>


</head>
<script type="text/javascript">
function redireccionar(referer){	
	if (referer){	
		   document.forms[0].submit();
	}
	else {
		alert("Acceso desde sitio no autorizado");
		window.history.back();
	}
}

</script>
<%
String referer = request.getHeader("Referer");
String usuario = request.getParameter("ccr_swiftlatam_login");
String pais = request.getParameter("ccr_swiftlatam_pais");


%>
<body onload="redireccionar(<%=(referer != null && referer.contains("http://intranet.ccr.igrupobbva/"))? true : false%>);return false;">

<% if(referer != null && referer.contains("http://intranet.ccr.igrupobbva/")){ %>
   <html:form 
        method="post" action="/loginExterno" target='_blank'>
        <input type="hidden" id="userName" name="userName" value="<%= usuario %>">
        <input type="hidden" id="pais" name="pais" value="<%= pais %>">
    </html:form>
<%} %>    
   
</body>
</html>