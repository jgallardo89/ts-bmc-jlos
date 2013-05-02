<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%=request.getContextPath()%>/css/MonitorGmmStyles.css"	rel="stylesheet" type="text/css"/>
<title>Page not found</title>
</head>
<body>
<br><br><br><br>
<div align="left" class="pageTitle" style="width: 100%; font-size: 25pt;">
 <MARQUEE> P&aacute;gina en construcci&oacute;n </MARQUEE>
</div>
<center><br><br><br><br><br><br>
<script type="text/javascript">
document.write("<table class=\'tableForm\'><tr><td>");
document.write("<B>Nombre de navegador :&nbsp;&nbsp;&nbsp;</B>" + navigator.appName + "<BR><br><br>");
document.write("<B>IP:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</B><%=request.getRemoteAddr()%><BR><br><br>");
document.write("<B>Pongase en contacto con los administradores del sitio:&nbsp;&nbsp;&nbsp;</B><br>");
document.write("<lu><li>a.labra@bbva.com</li>");
document.write("<li>bfswiftl@bbva.com</li>");
document.write("<li>antonio.rios@bbva.bancomer.com</li>");
document.write("<li>GMMLATAM@bbva.bancomer.com</li>");
document.write("</td></tr></table>");
</script>
<br>
<img src="<%=request.getContextPath()%>/images/loaderBigCircleBall.gif" width="50px" height="50px">
</center>
</body>
</html>