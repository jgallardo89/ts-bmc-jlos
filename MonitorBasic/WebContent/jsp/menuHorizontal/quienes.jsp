<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%=request.getContextPath()%>/css/MonitorGmmStyles.css"	rel="stylesheet" type="text/css"/>
<title>Plataforma GMM</title>
</head>
<body>
<div class='pageTitle'>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Plataforma GMM
</div>


  
<div align="center">
    <img src="<%=request.getContextPath()%>/images/areas.JPG" width="120px" height="60px"><br>
</div>

<a name="areasBBVA">
<table align="center" width="80%" class="tableForm">
    <tr>
        <td style="font-size:10pt;
            font-family: arial;
            font-weight:bolder;
            COLOR: #0080FF;"><a style="text-decoration: underline;" href="../areasBBVA.jsp">&Aacute;reas de Negocio BBVA</a></td>
    </tr>
    <tr>
        <td align="center">     
        <p align="justify">     
        Directorio donde se encuentran las interfaces que operan en el Swift Alliance Access,  este directorio 
        relaciona éstas interfases con sus usuarios (Áreas de Negocio) y los responsables de las aplicaciones.
        <br> 
        Este directorio tiene la finalidad de apoyar al Área de Negocio  en caso de  algún problema con una 
        aplicación sepa a quien dirigirse y viceversa.
        </p>        
        </td>
    </tr>
    <tr>
        <td align="right" valign="bottom">
            <a href="<%=request.getContextPath()%>/jsp/welcome.jsp" onclick="window.parent.scroll(0,0);"><img src="<%=request.getContextPath()%>/images/direct_access/flechaArriba.gif" border="0">Volver</a> 
        </td>
    </tr>
</table>



</body>
</html>