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
<link href="<%=request.getContextPath()%>/css/MonitorGmmStyles.css" rel="stylesheet" type="text/css"/>
<title>Calendario</title>
<style type="text/css">

.main {
width:100%;
height: 400px;
border:1px solid #D3E9EB;
}

.month {
background-color:#9ac2e5;
font:bold 12px verdana;
color:white;
}

.daysofweek {
background-color:gray;
font:bold 12px verdana;
color:white;
}

.days {
font-size: 12px;
font-family:verdana;
color:black;
background-color: white;
padding: 5px;
}

.days #today{
font-weight: bold;
color: red;
}

</style>
<script src="<%=request.getContextPath()%>/js/Ajax.js"                              type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/scriptaculous/lib/prototype.js"       type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/scriptaculous/src/scriptaculous.js"   type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/scriptaculous/src/unittest.js"        type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/utilerias.js"                         type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/calendars/scw.js"                                         type="text/javascript"></script> 
</head>
<% 
String fecha    = "";
Date date = new Date();
SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
fecha = formato.format(date);
%>
<body onload="scwShow(document.getElementById('fecha'),this); validateChange(document.getElementById('fecha').value);">

<br>
<div style="position: absolute; left: 100px;">
<table width="24%" border="0" align="center" id="calendar" class="tableForm">
    <tr>
        <td height="237px" align="center" onmouseover="scwShow(document.getElementById('fecha'),this); validateChange(document.getElementById('fecha').value);">
                <input type="hidden" value="<%=fecha%>" id="fecha" name="fecha">
                Situe el mouse aqui!!       
        </td> 
    </tr>
</table>
</div>

<br><br><br><br><br><br><br><br><br><br>
<br><br><br><br>
    <table class="tableForm" width="80%" align="center">
        <tr>
            <td align="left">
                <div style="width: 15px; height: 15px; background-color: #FFFF00; display: inline; float: left;"></div>&nbsp;&nbsp;Cambio programado
            </td>
        </tr>
    </table>
<script type="text/javascript">
function validateChange(fecha){
    $('titleChanges').innerHTML = "Cambios  <b>* "+fecha+" *</b>";
    var cal = document.getElementById('calendar');
    cal.style.border=0;
    //alert(fecha);
    //Aqui vamos a meter una peticion ajax para que nos traiga todos los eventos 
    // de la fecha marcada..

    var url = '<%=request.getContextPath()%>';
    url += "/LoadEvents?date=" + fecha;
    $Ajax(url , {
        cache:false,
        requestType:$requestType.XML, 
        onfinish:function(xml){
            $('eventList').innerHTML = "";
            var events = xml.getElementsByTagName("event");
            if(events.length>0){
                for(var indexEvent =0; indexEvent < events.length;indexEvent++){
                    var idEvent     = events[indexEvent].getElementsByTagName("id")[0];
                    var nameEvent   = events[indexEvent].getElementsByTagName("name")[0];
                    var dateEvent   = events[indexEvent].getElementsByTagName("date")[0];       
                    var li      = document.createElement("li");
                    var br      = document.createElement("hr");
                    
                    var text    = document.createTextNode(nameEvent.firstChild.nodeValue);
                    li.appendChild(text);
                    li.style.fontfamily = 'arial';
                    li.style.fontsize = '12px';
                    li.style.color =  "#055A78";
                    $('eventList').appendChild(li);
                    $('eventList').appendChild(br);
                }
            }else{
                /*li        = document.createElement("li");
                br      = document.createElement("hr");
                
                text    = document.createTextNode("No existen cambios");
                li.appendChild(text);
                li.style.fontfamily = 'arial';
                li.style.fontsize = '15px';
                li.style.color =  "red";
                $('eventList').appendChild(li);
                $('eventList').appendChild(br);*/
            }
        },
        onerror:function(xml){
            alert("Ha ocurrido un error al obtener los eventos en la fecha "+fecha);
        }
        }); 
}
</script>
<% 
//Obtenemos todas las fechas que tiene eventos
CalendarEventsLogic logic = new CalendarEventsLogic();
ArrayList datesEvents =  logic.getEventDates();
int cont =0;
for(int numDateEvents = 0; numDateEvents < datesEvents.size(); numDateEvents++){
    String dateDisabled = (String)datesEvents.get(numDateEvents);
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