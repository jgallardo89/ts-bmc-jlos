<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld"  prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html"%>
<%@ page import="com.bancomer.gis.monitorwebswift.logic.CalendarEventsLogic"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calendario de Cambios</title>
<link href="<%=request.getContextPath()%>/css/MonitorGmmStyles.css" rel="stylesheet" type="text/css"/>

<script src="<%=request.getContextPath()%>/js/Ajax.js"                              type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/scriptaculous/lib/prototype.js"       type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/scriptaculous/src/scriptaculous.js"   type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/spry/includes/SpryData.js"            type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/spry/includes/SpryHTMLDataSet.js"     type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/spry/includes/SpryPagedView.js"                             ></script>
<script src="<%=request.getContextPath()%>/js/calendars/scw.js"                     type="text/javascript"></script>

<script type="text/javascript">
var events_ds = new Spry.Data.HTMLDataSet(null, "tableEvents", {firstRowAsHeaders:false});
var pageEvents = new Spry.Data.PagedView(events_ds, {pageSize: 20});
pageInfoEvents = pageEvents.getPagingInfo();


function listEvents(){
    $('method').value="list";
    document.forms[0].submit(); 
}

function loadEvent(row){
    var fields = $(row).childNodes;
    $('newEventTitle').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Actualizar Evento";
    $('id').value=fields[0].innerHTML;
    $('name').value=fields[1].innerHTML;
    $("btnLimpiar").disabled=false;
    $("btnGuardar").disabled=false;
    $("deleteButton").disabled=false;
}



function chageTitle(){
      if($('name').value=="" ){ $('newEventTitle').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Nuevo aviso";
      $('id').value="0";
      }
}

</script>
</head>
<% 
SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
String fecha = (String)request.getSession().getAttribute("fechaEventos");
if(fecha==null || fecha.trim().length()<=0) fecha = format.format(new Date());

CalendarEventsLogic logic = new CalendarEventsLogic();
ArrayList events = logic.listEventsByDate(fecha);
request.getSession().setAttribute("events", events);

%>
<body>

<div class='pageTitle'>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Calendario de Cambios
</div>
<br>

<br>
<html:form action="eventsNewCalendar" method="post">
<input type="hidden" value="0" name="id" id="id">
<input type="hidden" value="0" name="method" id="method">
<table id="channelForm" align="center" width="98%" class="tableForm" border="0">
    <tr>
        <td align="center" valign="middle">
            Fecha: <input name="date" id="date" type="text" value="<%=fecha%>" onclick="scwShow(this,event)" style="cursor: help;" size="8"></td>
        <td align="right" valign="top" width="58%" height="90">
        <table align="center" width="60%" class="tableForm" border="0">

    <tr><td colspan="2">&nbsp;</td></tr>
    <tr> 
        <td align="right" width="50%"><bean:message key="monitorswift.pager"/>&nbsp;&nbsp;&nbsp;</td>
        <td align="left" >
            
        <a href="#" onclick="pageEvents.previousPage();">«</a>
        &nbsp;&nbsp;&nbsp;
        <span spry:region="pageInfoEvents" spry:repeatchildren="pageInfoEvents" class="SpryHiddenRegion">
            <a spry:if="{ds_CurrentRowNumber} != {ds_RowNumber}" href="#" onclick="pageEvents.goToPage('{ds_PageNumber}'); return false;">{ds_PageNumber}</a>
            <span spry:if="{ds_CurrentRowNumber} == {ds_RowNumber}" class="currentPage">{ds_PageNumber}</span>
        </span>
        &nbsp;&nbsp;&nbsp;
        <a href="#"  onclick="pageEvents.nextPage();" >»</a>
        </td>
        <td>
    </tr>
    </table>
        
    <div spry:region="pageEvents pageInfoEvents" class="SpryHiddenRegion">
        <table class="tableXP" align="center" cellspacing="2" cellpadding="0" width="98%" >
            <tr>
                <th style="display:none" align="center">id</th>
                <th spry:sort="pageEvents column1"  style="cursor:hand" align="center">Cambio</th>
                <th spry:sort="pageEvents column2"  style="cursor:hand" align="center">Fecha</th>
            </tr>
            <tr spry:repeat="pageEvents" spry:hover="hover" spry:odd="row1" spry:even="row2" id='login-{column0}'">
                <td style="display:none">{column0}</td>
                <td style="cursor:hand" align="center">{column1}</td>
                <td style="cursor:hand" align="center">{column2}</td>           
             </tr>      
        </table>
    </div>
        </td>
    </tr>
</table><br>

<br>
<center>
    <input name="" id="" type="button" class="button" value="consultar" onclick="listEvents();">
</center>
</html:form>

<br><br><br><br><br><br>
    <table class="tableForm" width="80%" align="center">
        <tr>
            <td align="left">
                <div style="width: 15px; height: 15px; background-color: #FFFF00; display: inline; float: left;"></div>&nbsp;&nbsp;Cambio programado
            </td>
        </tr>
    </table>

<table style="display:none;" id="tableEvents">
    <logic:present name="events">
        <logic:iterate name="events" id="event">
            <tr>
                <td><bean:write name="event" property="coinId"/></td>
                <td><bean:write name="event" property="name"/></td>
                <td><bean:write name="event" property="idCoinSW"/></td>
            </tr>
        </logic:iterate>
    </logic:present>
</table>
<% 
//Obtenemos todas las fechas que tiene eventos

ArrayList datesEvents =  logic.getEventDates();
int cont =0;
//for(String dateDisabled: datesEvents){
for(int numEvents = 0; numEvents < datesEvents.size(); numEvents++){
    String dateDisabled = (String)datesEvents.get(numEvents);
    String[] dateSplit = dateDisabled.split("-");
    String day = dateSplit[0];
    String month =  dateSplit[1];
    String year =  dateSplit[2];
    
    int dayInt = Integer.parseInt(day);
    int monthInt = Integer.parseInt(month)-1;
    int yearInt = Integer.parseInt(year);
    
%>
    <script>
        scwDisabledDates[<%=cont%>] = new Date(<%=yearInt%>,<%=monthInt%>,<%=dayInt%>);
    </script>
    
<%cont++;}%>
</body>
</html>