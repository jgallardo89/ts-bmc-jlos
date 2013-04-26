<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
	
<html>
<head>

<script src="<%=request.getContextPath()%>/js/Ajax.js" 								type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/scriptaculous/lib/prototype.js"		type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/spry/includes/SpryData.js" 			type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/spry/includes/SpryHTMLDataSet.js" 	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/spry/includes/SpryPagedView.js"							  ></script>
<script src="<%=request.getContextPath()%>/js/scriptaculous/src/scriptaculous.js" 	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/scriptaculous/src/unittest.js" 		type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/utilerias.js"					 		type="text/javascript"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%=request.getContextPath()%>/css/MonitorGmmStyles.css"	rel="stylesheet" type="text/css"/>
<title>Fin de Sesión</title>
</head>
<body>
<br><br><br><br>
<div align="left" class="pageTitle" style="width: 100%; font-size: 25pt;">
 <MARQUEE> Su session ha expirado... </MARQUEE>
</div>
<center><br><br><br><br><br><br>
<script type="text/javascript">
validateSession(parent.document.getElementById('userName').value, '<%=request.getContextPath()%>');
</script>
<script type="text/javascript">
document.write("<table class=\'tableForm\'><tr><td>");
document.write("<B>Nombre de navegador :&nbsp;&nbsp;&nbsp;</B>" + navigator.appName + "<BR><br><br>");
document.write("<B>IP:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</B><%=request.getRemoteAddr()%><BR><br><br>");
document.write("<B>Redireccionando a inicio de sesion, por favor espere ...&nbsp;&nbsp;&nbsp;</B><br>");
//document.write("<lu><li>a.labra@bbva.bancomer.com</li>");
//document.write("<li>XAZERFA1@bbva.bancomer.com@bbva.bancomer.com</li>");
//document.write("<li>arturo.aguilar.2@bbva.bancomer.com</li>");
//document.write("<li>marcos.fragoso@bbva.bancomer.com</li></lu>");
document.write("</td></tr></table>");

</script>
<br>
<img src="<%=request.getContextPath()%>/images/loaderBigCircleBall.gif" width="50px" height="50px">
</center>
</body>
</html>