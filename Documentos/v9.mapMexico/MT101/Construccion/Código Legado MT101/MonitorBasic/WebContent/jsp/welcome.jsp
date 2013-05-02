<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%=request.getContextPath()%>/css/MonitorGmmStyles.css"	rel="stylesheet" type="text/css"/>
<title>Welcome</title>
</head>
<body>
<a name="inicio">
<div style="font-size:10pt;
			font-family: arial;
			font-weight:bolder;
			COLOR: #0080FF;" align="center">
	<b><a style="text-decoration: underline;" href="#noticiasSwift">Noticias SWIFT</a></b>&nbsp;|&nbsp;
	<b><a style="text-decoration: underline;" href="#estandares">Est&aacute;ndares SWIFT</a></b>&nbsp;|&nbsp;
	<b><a style="text-decoration: underline;" href="#diagramasSwift">Diagramas de Flujos Operativos SWIFT</a></b>&nbsp;|&nbsp;
	<b><a style="text-decoration: underline;" href="#swiftcom">swift.com</a></b>
</div>
</a>
<br>
<br>

<a name="noticiasSwift">
<table align="center" width="80%" class="tableForm">
    <tr>
        <td align="center">
            <!--  <img src="<%=request.getContextPath()%>/images/noticias.JPG" width="70px" height="70px"><br>-->
        </td>
    </tr>
    <tr>
        
            <td style="font-size:10pt;
            font-family: arial;
            font-weight:bolder;
            COLOR: #0080FF;">
            <a style="text-decoration: underline;" href="../editNews.do?method=readNews">Noticias SWIFT</a></td>
            </td>
            
            
    </tr>
    <tr>        
        <td align="center">
        <p align="justify">
        Aquí podrás encontrar información de interés acerca de SWIFT
        </p>
        </td>
    </tr>
    <tr>
        <td align="right" valign="bottom">
            <a href="<%=request.getContextPath()%>/jsp/welcome.jsp" onclick="window.parent.scroll(0,0);"><img src="<%=request.getContextPath()%>/images/direct_access/flechaArriba.gif" border="0">Volver</a> 
        </td>
        
    </tr>
</table>
</a>
<br>
<hr align="center" >
<br>


<a name="estandares">
<table align="center" width="80%" class="tableForm">
    <tr>
        <td align="center">
            <!--  <img src="<%=request.getContextPath()%>/images/estandares.JPG"><br>-->
        </td>
    </tr>
	<tr>		
			<td style="font-size:10pt;
			font-family: arial;
			font-weight:bolder;
			COLOR: #0080FF;"><a style="text-decoration: underline;" href="../documentacion.do?method=list&tipoDocumentacion=Estandares">Est&aacute;ndares SWIFT</a></td>
	</tr>
	<tr>		
		<td align="center">
		<p align="justify">
		Swift ofrece una serie de productos, herramientas y servicios estandarizados con la finalidad de dar soporte al sector financiero. 
		El ser parte de la comunidad Swift ofrece potenciales ahorros de costes, elimina los problemas de eficacia y como consecuencia ayuda a 
		sus miembros a expandirse sin problemas a todos los mercados incluyendo los inexplorados. 
		</p>
		</td>
	</tr>
	<tr>
		<td align="right" valign="bottom">
			<a href="<%=request.getContextPath()%>/jsp/welcome.jsp" onclick="window.parent.scroll(0,0);"><img src="<%=request.getContextPath()%>/images/direct_access/flechaArriba.gif" border="0">Volver</a> 
		</td>
	</tr>
</table>
</a>
<br>
<hr align="center" >
<br>

<a name="diagramasSwift">
<table align="center" width="80%" class="tableForm">
    <tr>
        <td align="center">
            <!--  <img src="<%=request.getContextPath()%>/images/diagramas.JPG" width="200px" height="100px"><br>-->
        </td>
    </tr>
    <tr>        
            <td style="font-size:10pt;
            font-family: arial;
            font-weight:bolder;
            COLOR: #0080FF;"><a style="text-decoration: underline;" href="diagramasSwift.html">Diagramas de Flujos Operativos SWIFT</a></td>
    </tr>
    <tr>        
        <td align="center">
        <p align="justify">
        Estos diagramas serán de apoyo para conocer el flujo operativo que actualmente manejan los países que se encuentran El HUB BBVA AMERICA. 
        En estos diagramas se plasma la operativa actual (CGS) y futura  (GMM) que tendrán los diferentes países.
        </p>
        </td>
    </tr>
    <tr>
        <td align="right" valign="bottom">
            <a href="<%=request.getContextPath()%>/jsp/welcome.jsp" onclick="window.parent.scroll(0,0);"><img src="<%=request.getContextPath()%>/images/direct_access/flechaArriba.gif" border="0">Volver</a> 
        </td>
    </tr>
</table>
</a>
<br>
<hr align="center" >
<br>

<div align="center">
	<!--  <img src="<%=request.getContextPath()%>/images/swift.JPG" ><br>-->
</div>
<a name="swiftcom">
<table align="center" width="80%" class="tableForm">
	<tr>
		<td style="font-size:10pt;
			font-family: arial;
			font-weight:bolder;
			COLOR: #0080FF;"><a style="text-decoration: underline;" href="http://www.swift.com">swift.com</a></td>
	</tr>
	<tr>		
		<td align="center">
		<p align="justify">
		En este sitio web (SWIFT.com) tendrás un acceso seguro a información general, soporte de casos de investigación, suscripción de servicios 
		y productos, noticias relevantes sobre SWIFT, etc.

		<br>
		Se distinguen dos tipos de contenidos en swift.com: contenido público y aplicaciones.
		</p>
		</td>
	</tr>
	<tr>
		<td align="right" valign="bottom">
			<a href="<%=request.getContextPath()%>/jsp/welcome.jsp" onclick="window.parent.scroll(0,0);"><img src="<%=request.getContextPath()%>/images/direct_access/flechaArriba.gif" border="0">Volver</a> 
		</td>
	</tr>
</table>
</a>
<br>
<hr align="center" >
<br>

</body>
</html>