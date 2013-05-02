<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld"  prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html"%>
<%@ page import="com.bancomer.gis.monitorwebswift.vo.*"%>

<%@page import="java.util.ArrayList"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=(String)request.getSession().getAttribute("tipoDocumentacion")%></title>
<link href="<%=request.getContextPath()%>/css/MonitorGmmStyles.css" rel="stylesheet" type="text/css"/>

<script src="<%=request.getContextPath()%>/js/Ajax.js"                              type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/scriptaculous/lib/prototype.js"       type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/scriptaculous/src/scriptaculous.js"   type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/spry/includes/SpryData.js"            type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/spry/includes/SpryHTMLDataSet.js"     type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/spry/includes/xpath.js"               type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/spry/includes/SpryPagedView.js"                             ></script>
<script src="<%=request.getContextPath()%>/js/ValidateFields.js"                    type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/utilerias.js"                         type="text/javascript"></script>

<title>Contacto</title>

<script type="text/javascript">

var users_ds = new Spry.Data.HTMLDataSet(null, "idtable", {firstRowAsHeaders:false, columnNames:["nombre","telefono","extension","email"]});  
var pageUsers = new Spry.Data.PagedView(users_ds, {pageSize: 7});
pageInfoUsers = pageUsers.getPagingInfo();

var documentos_ds = new Spry.Data.HTMLDataSet(null, "idtable2", {firstRowAsHeaders:false, columnNames:["pais","banco","nombre","telefono","email"]});  
var pageDocumentos = new Spry.Data.PagedView(documentos_ds, {pageSize: 20});
pageInfoDocumentos = pageDocumentos.getPagingInfo();

</script>

</head>
<body>

<div class='pageTitle'>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cont&aacute;ctenos
</div><br>
<div class='sectionTitle' id="newBicTitle">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    D y D Plataformas de Pago Globales
</div>
<br>
<table align="center" width="80%" class="tableForm">
    <tr>
        <td align="center">
        Si le interesa algún tema que no este publicado, o requiere alguna información<br>
        específica puede utilizar alguno de los siguientes medios: 
        <br><br>
        Correo electrónico: <a href="mailto:gmmlatam@bbva.bancomer.com">gmmlatam@bbva.bancomer.com</a>
        </td>
    </tr>
</table>
<br>

    <table align="center" width="80%" class="tableForm" border="0">
            <tr>                                
                <td align="left" valign="top" colspan="2">
                <bean:message key="monitorswift.pager"/>:
                    <a href="#" onclick="pageUsers.previousPage();">«</a>
                    &nbsp;&nbsp;&nbsp;
                    <span class="SpryHiddenRegion" spry:region="pageInfoUsers" spry:repeatchildren="pageInfoUsers">
                        <a spry:if="{ds_CurrentRowNumber} != {ds_RowNumber}" href="#" onclick="pageUsers.goToPage('{ds_PageNumber}'); return false;">{ds_PageNumber}</a>
                        <span spry:if="{ds_CurrentRowNumber} == {ds_RowNumber}" class="currentPage">{ds_PageNumber}</span>
                    </span>
                    &nbsp;&nbsp;&nbsp;
                    <a href="#"  onclick="pageUsers.nextPage();" >»</a>
                </td>
                <td align="right">                  
                    <div class="SpryHiddenRegion" spry:region="users_ds" align="right">
                    ({ds_RowCount} de {ds_UnfilteredRowCount})
                    </div>
                </td>                
            </tr>           
    </table><br>



<div spry:region="pageUsers pageInfoUsers" class="SpryHiddenRegion">
        <table class="tableXP" align="center" cellspacing="2" cellpadding="0" width="80%" id="tableUsersSpry">
            <tr>
                <th spry:sort="pageUsers nombre"   style="cursor:hand;" align="center">Nombre</th>
                <th spry:sort="pageUsers telefono"   style="cursor:hand;" align="center">Tel&eacute;fono</th>                
                <th spry:sort="pageUsers extension"   style="cursor:hand;" align="center">Extensi&oacute;n</th>
                <th spry:sort="pageUsers email"   style="cursor:hand;" align="center">Correo</th>
            </tr>
            <tr spry:repeat="pageUsers" spry:hover="hover" spry:odd="row1" spry:even="row2" id='login-{id}'>
                <td align="left">{nombre}</td>
                <td align="left">{telefono}</td>            
                <td align="left">{extension}</td>
                <td align="left"><a href="mailto:{email}">{email}</a></td>                
             </tr>      
        </table>
</div>
    <table id="idtable" style="display:none;">  
        <logic:present name="contactsDirectory2">
           <logic:iterate name="contactsDirectory2" id="contact">           
           <tr>
               <td><bean:write name="contact" property="nombre"/></td>                    
               <td><bean:write name="contact" property="telefono"/></td>
               <td><bean:write name="contact" property="extension"/></td>
               <td><bean:write name="contact" property="email"/></td>
           </tr>
            </logic:iterate>
       </logic:present>        
    </table>
        
<br>
<div class='sectionTitle' id="newBicTitle">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    Centro de Mando:
</div><br>
<table align="center" width="80%" class="tableForm">
    <tr><td>56-21-3434 Extensión 61104 opción 1<td></tr>
</table>
<br>
<div class='sectionTitle' id="newBicTitle">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    Centro de Atención Usuarios :
</div><br>
<table align="center" width="80%" class="tableForm">
    <tr><td>Extensión 6-1190<td></tr>
</table>
<br>

<div class='sectionTitle' id="newBicTitle">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    Frente &Uacute;nico
</div>
<br><br>

    <table align="center" width="80%" class="tableForm" border="0">
            <tr>                                
                <td align="left" valign="top" colspan="2">
                <bean:message key="monitorswift.pager"/>:
                    <a href="#" onclick="pageDocumentos.previousPage();">«</a>
                    &nbsp;&nbsp;&nbsp;
                    <span class="SpryHiddenRegion" spry:region="pageInfoDocumentos" spry:repeatchildren="pageInfoDocumentos">
                        <a spry:if="{ds_CurrentRowNumber} != {ds_RowNumber}" href="#" onclick="pageDocumentos.goToPage('{ds_PageNumber}'); return false;">{ds_PageNumber}</a>
                        <span spry:if="{ds_CurrentRowNumber} == {ds_RowNumber}" class="currentPage">{ds_PageNumber}</span>
                    </span>
                    &nbsp;&nbsp;&nbsp;
                    <a href="#"  onclick="pageDocumentos.nextPage();" >»</a>
                </td>
                <td align="right">                  
                    <div class="SpryHiddenRegion" spry:region="documentos_ds" align="right">
                    ({ds_RowCount} de {ds_UnfilteredRowCount})
                    </div>
                </td>                
            </tr>           
    </table><br>


    <div class="SpryHiddenRegion" spry:region="pageDocumentos pageInfoDocumentos" >
        <table border='0' align="center" cellspacing="2" cellpadding="0" width="80%" id="tableFrentesSpry" class="tableXP">            
            <tr>
                <th spry:sort="pageDocumentos pais" style="cursor:hand" align="center">Pa&iacute;s</th>
                <th spry:sort="pageDocumentos banco" style="cursor:hand" align="center">Banco</th>
                <th spry:sort="pageDocumentos nombre" style="cursor:hand" align="center">Nombre</th>
                <th spry:sort="pageDocumentos telefono" style="cursor:hand" align="center">Tel&eacute;fono</th>                   
                <th spry:sort="pageDocumentos email" style="cursor:hand" align="center">Correo</th>                               
            </tr>
            <tr spry:repeat="pageDocumentos" spry:hover="hover" spry:odd="row1" spry:even="row2" id='login-{ids}'>            
                <td style="center">{pais}</td>
                <td style="center">{banco}</td>
                <td style="center">{nombre}</td>                
                <td style="center">{telefono}</td>                
                <td style="center">{email}</td>              
            </tr>
        </table>
      </div>
      <table id="idtable2" style="display:none;">  
        <logic:present name="contactsDirectory3">
           <logic:iterate name="contactsDirectory3" id="contact">           
           <tr>
               <td><bean:write name="contact" property="pais"/></td>
               <td><bean:write name="contact" property="banco"/></td>
               <td><bean:write name="contact" property="nombre"/></td>                    
                     <td>
                      <logic:equal name="contact" property="extension" value="" >
                            <bean:write name="contact" property="telefono"/>
                      </logic:equal>
                      <logic:notEqual name="contact" property="extension" value="" >
                                <bean:write name="contact" property="telefono"/> Ext. <bean:write name="contact" property="extension"/> 
                      </logic:notEqual>
                    </td>
               
               <td><a href="mailto:<bean:write name="contact" property="email"/>"><bean:write name="contact" property="email"/></a></td>
           </tr>
            </logic:iterate>
       </logic:present>        
    </table>
</body>
</html>