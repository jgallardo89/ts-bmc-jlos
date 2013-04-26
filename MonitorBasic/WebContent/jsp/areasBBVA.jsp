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
<link href="<%=request.getContextPath()%>/css/MonitorGmmStyles.css"	rel="stylesheet" type="text/css"/>

<script src="<%=request.getContextPath()%>/js/Ajax.js" 								type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/scriptaculous/lib/prototype.js"		type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/scriptaculous/src/scriptaculous.js" 	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/spry/includes/SpryData.js" 			type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/spry/includes/SpryHTMLDataSet.js" 	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/spry/includes/xpath.js" 				type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/spry/includes/SpryPagedView.js"							  ></script>
<script src="<%=request.getContextPath()%>/js/ValidateFields.js" 					type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/utilerias.js"		 					type="text/javascript"></script>

<script type="text/javascript">
var documentos_ds = new Spry.Data.HTMLDataSet(null, "idtable", {firstRowAsHeaders:false, columnNames:["id","idPais","pais","nombreInterfaz","tipoInterfaz","horario","equipoContra","sistemaContra","interfaz1","interfaz2","txAreaNegocio","txServicio","txRespUsuario","txRespAplicacion"]});
var pageDocumentos = new Spry.Data.PagedView(documentos_ds, {pageSize: 30});
pageInfoDocumentos = pageDocumentos.getPagingInfo();

ToggleFilter = function(){
	if (!this.filtered){
		pageDocumentos.filter(function(ds, row, rowNum) { 
			if (rowNum % 2)	return row;
			return null; 
		});
	}else{
		pageDocumentos.filter(null);
	}
	this.filtered = !this.filtered;
};

function FilterData(columName,element){
	var tf = element;
	if (!tf.value){
		documentos_ds.filter(null);
		return;
	}
	var regExpStr = tf.value;
	var regExp = new RegExp(regExpStr, "i");
	var filterFunc = function(ds, row, rowNumber){
		var str = row[columName];
		if (str && str.search(regExp) != -1)
			return row;
		return null;
	};
	documentos_ds.filter(filterFunc);
}

function StartFilterTimer(columName,element){
	if (StartFilterTimer.timerID)
		clearTimeout(StartFilterTimer.timerID);
	StartFilterTimer.timerID = setTimeout(function() { StartFilterTimer.timerID = null; FilterData(columName,element); }, 100);
}


</script>
</head>

<body onload="window.parent.scroll(0,0);">

<div class='pageTitle'>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Inventario de Interfaces
</div>


<html:form action='/documentacion' method="post">
<input type="hidden" name="id"  id="id" value="0">
<input type="hidden" value="" name="method" id="method">
<input type="hidden" value="" name="tipoDocumentacion" id="tipoDocumentacion">
</html:form>
<br>

	<table align="center" width="98%" class="tableForm" >
			<tr> 
								
				<td align="right">
					<div class="SpryHiddenRegion" spry:region="documentos_ds" align='center'>
					<bean:message key="monitorswift.find.registers"/>
					({ds_RowCount} de {ds_UnfilteredRowCount})
					</div>
				</td>
			</tr>
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
			</tr>
			
	</table>
	<div class="SpryHiddenRegion" spry:region="pageDocumentos pageInfoDocumentos" >
		<table border='0' align="center" cellspacing="2" cellpadding="0" width="98%" id="tableProductsSpry" class="tableXP">			
			<tr>
				<th spry:sort="pageDocumentos pais" 	style="cursor:hand" align="center">Pa&iacute;s</th>
				<th spry:sort="pageDocumentos txAreaNegocio"     style="cursor:hand" align="center">&Aacute;rea de negocio</th>
				<th spry:sort="pageDocumentos txServicio"  style="cursor:hand" align="center">Servicio</th>
				<th spry:sort="pageDocumentos nombreInterfaz" 	style="cursor:hand" align="center">Interfaz</th>
				<th spry:sort="pageDocumentos txRespUsuario" 	style="cursor:hand" align="center">Responsable usuario</th>
				<th spry:sort="pageDocumentos txRespAplicacion" 	style="cursor:hand" align="center">Responsable aplicaci&oacute;n</th>
				<th spry:sort="pageDocumentos interfaz1" 	style="cursor:hand" align="center">Descripci&oacute;n</th>
			</tr>
	  		<tr spry:repeat="pageDocumentos" spry:hover="hover" spry:odd="row1" spry:even="row2" id='login-{id}'">
		        <td style="center">{pais}</td>
		        <td style="center">{txAreaNegocio}</td>
		        <td style="center">{txServicio}</td>		      
		        <td style="center">{nombreInterfaz}</td>		        
		        <td style="center">{txRespUsuario}</td>
		        <td style="center">{txRespAplicacion}</td>
		        <td style="center">{interfaz1}</td>		        
		    </tr>		
		</table>		
	</div>
	    <table id="idtable" style="display:none;">  
		<logic:present name="interfaces">
			<logic:iterate name="interfaces" id="interfaz">
				<tr>
					<td><bean:write name="interfaz" property="cdInterfaz"/></td>
					<td><bean:write name="interfaz" property="idPais"/></td>
					<td><bean:write name="interfaz" property="cdPais"/></td>
					<td><bean:write name="interfaz" property="nbInterfaz"/></td>
					<td><bean:write name="interfaz" property="tpInterfaz"/></td>
					<td><bean:write name="interfaz" property="txHorario"/></td>
					<td><bean:write name="interfaz" property="txEquipoContraparte"/></td>
					<td><bean:write name="interfaz" property="txSistemaContraparte"/></td>
					<td><bean:write name="interfaz" property="txInterfaz1"/></td>
					<td><bean:write name="interfaz" property="txInterfaz2"/></td>
					<td><bean:write name="interfaz" property="txAreaNegocio"/></td>
					<td><bean:write name="interfaz" property="txServicio"/></td>
					<td><bean:write name="interfaz" property="txRespUsuario"/></td>
					<td><bean:write name="interfaz" property="txRespAplicacion"/></td>
				</tr>
			</logic:iterate>
		</logic:present>

    </table>
	
	
<script type="text/javascript">
//validateSession(parent.document.getElementById('userName').value, '<%=request.getContextPath()%>');
</script>
</body>
</html>