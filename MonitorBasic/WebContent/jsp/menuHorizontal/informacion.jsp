<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

<%@ page import="com.bancomer.gis.monitorwebswift.vo.*" %>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Información</title>
<link href="<%=request.getContextPath()%>/css/MonitorGmmStyles.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/css/SpryAccordion.css"                rel="stylesheet"    type="text/css"/>

<script src="<%=request.getContextPath()%>/js/scriptaculous/lib/prototype.js"       type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/spry/SpryAccordion.js"            type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/FixedIP/FixedIps.js"			 		type="text/javascript"></script>
</head>
<body onload="window.parent.scroll(0,0);">

    <div class='pageTitle'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Información</div>
    <br>

    <br></br>
    <div class="Accordion" id="sampleAccordion"  tabindex="0">    
        <div class="AccordionPanel">
            <div class="AccordionPanelTab">
            Swift Latam
            </div>
            <div class="AccordionPanelContent" style="overflow:auto;">
                <div align="center">    
                    <img border="0" width="150" height="150" src="<%=request.getContextPath()%>/images/swiftlatam.png">    
                </div>
	            <div>
	            Éste es un portal en el cual podrás encontrar información de interés acerca de la plataforma SWIFT. Si eres usuario registrado 
	            para este portal podrás además acceder a reportes y otros servicios solicitados previamente con tu administrador de SWIFT local. 
	            Para realizar requerimientos ponte en contacto con tu administrador de SWIFT local o contáctanos y te orientaremos: 
	            gmmlatam@bbva.bancomer.com <br><font style="Color:navy;">***** Para acceso a Swift Alliance vía CITRIX - Utilice cualquiera de 
	            las siguientes direcciones: Producción: http://swift.ccr.igrupobbva Respaldo: http://swift1.ccr.igrupobbva Contingencia: 
	            http://swift2.ccr.igrupobbva ***** </font> 
	            </div>
            </div>
        </div>
        <!--  
        <div class="AccordionPanel">
            <div class="AccordionPanelTab">
            Cronología SAA / SAG
            </div>
            <div class="AccordionPanelContent" style="overflow:auto;">
                <div align="center">    
                    <img border="0" width="150" height="150" src="<%=request.getContextPath()%>/images/noticias_mercadosglobales.jpg">    
                </div>
                <div>
                <font style="Color:navy;">Liberaciones:</font><br> - 23/11/2009 Implementación de los nuevos estándares SWIFT 2009.
                <br> - 9/11/2009 Cliente SWIFT Fase 1 (México).<br> - 24/10/2009 Virtualización de la Capa Gestora SWIFT.
                <br> - 17/10/2009 Cambio de discos en SAA productivo.
                <br> - 12/10/2009 Liberación y actualización de las interfaces Fircosoft Países.
                </div>
            </div>
        </div>
        -->
        <div class="AccordionPanel">
            <div class="AccordionPanelTab">
            Centro de Atención a Usuarios
            </div>
            <div class="AccordionPanelContent" style="overflow:auto;">
                <div align="center">    
                    <img border="0" width="150" height="150" src="<%=request.getContextPath()%>/images/noticias_centroatencion usuarios.jpg">    
                </div>
                <div>
                Si tienes problemas con tu user de SWIFT Alliance, el Citrix, la Impresora, la Interfase o con la aplicación, deberás reportarlo 
                al Centro de Atención a Usuarios (CAU) en la extensión 6-1190.<br>Y para los países a través del Frente Unico de tu Región
                </div>
            </div>
        </div>    
        <div class="AccordionPanel">
            <div class="AccordionPanelTab">
            ¿Que hacer con mensajes que no son de mi unidad?
            </div>
            <div class="AccordionPanelContent" style="overflow:auto;">
                <div align="center">    
                    <img border="0" width="150" height="150" src="<%=request.getContextPath()%>/images/quehacer.jpg">    
                </div>
                <div>
                Si encuentras mensajes que no correspondan a tu área o país deberás enviar un mail al Mario Alberto Urdañez Anguiano
                (mario.urdanez@bbva.bancomer.com), Ext. 1-1037, informando la fecha del mensaje así como el TRN.
                </div>
            </div>
        </div>    
        <div class="AccordionPanel">
            <div class="AccordionPanelTab">
            ¿Dudas sobre SWIFTAlliance Access?
            </div>
            <div class="AccordionPanelContent" style="overflow:auto;">
                <div align="center">    
                    <img border="0" width="150" height="150" src="<%=request.getContextPath()%>/images/noticiasdudassobreswiftalliance.jpg">    
                </div>
                <div>
                En la sección de Manuales de este portal encontrarás una liga a las guías del SWIFT Alliance los cuales muestran detalladamente 
                la funcionalidad del sistema.Sintaxis del cuerpo de los mensajes MT, Así como explicación del error de acuerdo a las claves 
                enviadas por Alliance
                </div>
            </div>
        </div>  
        <div class="AccordionPanel">
            <div class="AccordionPanelTab">
            SWIFT 2010
            </div>
            <div class="AccordionPanelContent" style="overflow:auto;">
                <div align="center">    
                    <img border="0" width="150" height="120" src="<%=request.getContextPath()%>/images/ServiciosSwift_1.JPG">    
                </div>
                <div align="left">Aquí encontraras una Presentación la cual contiene información General de Swift 
                <a href="javascript:openFixedURL(fxInformacion_Presentacion,'bodyGMM');">(Ver presentación).</a>
                </div>
            </div>
        </div>   
        <!--  
<hr align="center" >
<br>
<div align="center">
    <img src="<%=request.getContextPath()%>/images/plataforma.JPG"><br>
</div>
<a name="plataformaCCR">
<table align="center" width="80%" class="tableForm">
    <tr>
        
            <td style="font-size:10pt;
            font-family: arial;
            font-weight:bolder;
            COLOR: #0080FF;"><a style="text-decoration: underline;" href="plataformasCCR.html">Plataforma CCR SWIFT</a></td>
            
    </tr>
    <tr>        
        <td align="center">
        <p align="justify">
        El HUB BBVA AMERICA consiste en una serie de componentes, tanto servidores, redes, así como 
        una gama de productos de Software que en conjunto, brindan un servicio completo y robusto. 
        En estos diagramas se plasma la situación actual y futura de la infraestructura de CCR.
        </p>
        </td>
    </tr>
    <tr>
        <td align="right" valign="bottom">
            <a href="<%=request.getContextPath()%>/jsp/welcome.jsp" onclick="window.parent.scroll(0,0);"><img src="<%=request.getContextPath()%>/images/direct_access/flechaArriba.gif" border="0">Volver</a> 
        </td>
        
    </tr>
</table>
-->
        <div class="AccordionPanel">
            <div class="AccordionPanelTab">
            Plataforma CCR SWIFT
            </div>
            <div class="AccordionPanelContent" style="overflow:auto;">
                <div align="center">                    
                    <img src="<%=request.getContextPath()%>/images/plataforma.JPG"><br>
                </div>
                <div align="center">
                <p align="justify">
		        El HUB BBVA AMERICA consiste en una serie de componentes, tanto servidores, redes, así como 
		        una gama de productos de Software que en conjunto, brindan un servicio completo y robusto. 
		        En estos diagramas se plasma la situación actual y futura de la infraestructura de CCR. <a style="text-decoration: none;" href="../plataformasCCR.html">(Ver diagrama).</a></td> 
		        </p>
                </div>
            </div>
        </div> 
       
    </div>
    <script type="text/javascript">
    var sampleAccordion = new Spry.Widget.Accordion("sampleAccordion");
    </script>

</body>
</html>