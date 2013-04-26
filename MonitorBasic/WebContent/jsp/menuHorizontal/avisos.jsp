<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.bancomer.gis.monitorwebswift.logic.CatalogoAvisosLogic" %>
<%@ page import="com.bancomer.gis.monitorwebswift.vo.CoinVo" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%=request.getContextPath()%>/css/MonitorGmmStyles.css"	rel="stylesheet" type="text/css"/>
<title>Avisos</title>
</head>
<%
CatalogoAvisosLogic logic = new CatalogoAvisosLogic();
ArrayList avisos = logic.list();
%>
<body>

<div class='pageTitle'>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Avisos
</div>
<br>
<div class='sectionTitle' id="newBicTitle">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	Avisos Monitor Web Swift
</div><br>
<table align="center" width="80%" class="tableForm">
	<tr>
		<td>
			<ul>
				<%//for(CoinVo aviso: avisos){
				for(int numAviso=0; numAviso< avisos.size(); numAviso++){
					CoinVo aviso = (CoinVo)avisos.get(numAviso); 
					String [] fecha =   aviso.getIdCoinSW().split("-");
					int month = Integer.parseInt(fecha[1]);
					switch(month){
						case 1: fecha[1]="Ene"; break;
						case 2: fecha[1]="Feb"; break;
						case 3: fecha[1]="Mar"; break;
						case 4: fecha[1]="Abr"; break;
						case 5: fecha[1]="May"; break;
						case 6: fecha[1]="Jun"; break;
						case 7: fecha[1]="Jul"; break;
						case 8: fecha[1]="Ago"; break;
						case 9: fecha[1]="Sep"; break;
						case 10: fecha[1]="Oct"; break;
						case 11: fecha[1]="Nov"; break;
						case 12: fecha[1]="Dic"; break;
					}
					aviso.setIdCoinSW(fecha[0]+"-"+fecha[1]+"-"+fecha[2]);
				%>
					<li><%="<b>("+aviso.getIdCoinSW()+")</b>&nbsp;&nbsp;&nbsp;"+aviso.getName()%><br><br></li>
				<%}%>
			</ul>
		</td>
	</tr>
</table>
</body>
</html>