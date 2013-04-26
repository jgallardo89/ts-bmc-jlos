<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%=request.getContextPath()%>/css/MonitorGmmStyles.css"	rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/css/SpryRating.css"	rel="stylesheet" type="text/css"/>

<script src="<%=request.getContextPath()%>/js/Ajax.js" 								type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/scriptaculous/lib/prototype.js"		type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/scriptaculous/src/scriptaculous.js" 	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/spry/SpryRating.js" 			type="text/javascript"></script>
<title>Evaluación</title>
</head>
<body>

<div class='pageTitle'>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Evaluación
</div>
<html:form action="/rating" method="post">
<input type="hidden" name="id"  id="id" value="">
<input type="hidden" name="method" id="method">


<table align="center" width="80%" class="tableForm">
	<tr>
		<td colspan="4" align="center">
		Por favor ayúdenos a mejorar, indique el nivel de satisfacción del área y al final de clic en guardar.
		<br></br>
		</td>
	</tr>
	<tr>	
		<!--  	
		<td align="center">&nbsp;Ámbito
			<select id="sltElemento" name="sltElemento">
					<option value="Servicio">Servicio</option>
					<option value="Requerimiento">Requerimiento</option>					
					<option value="Adaevo">Adaevo</option>
					<option value="Proyecto">Proyecto</option>					
			</select>
			<br></br>
		</td>
		-->
		<td valign="middle" align="right">
			Ámbito: 
			<select name="name" id="name" onchange="obtenerRequerimientos();">
			<logic:present name="ambitosValues">
			<% 
				String ambitoSelec = (String)request.getSession().getAttribute("ambitoSelec");
				if(ambitoSelec==null) ambitoSelec = "";
			%>
				<option value=""></option>				
				<logic:iterate name="ambitosValues" id="ambito">
				<logic:equal value="<%=ambitoSelec%>" name="ambito" property="coinId">
					<option value='<bean:write name="ambito" property="coinId"/>' selected="selected">
						<bean:write name="ambito" property="name"/>
					</option>
				</logic:equal>
				<logic:notEqual value='<%=ambitoSelec%>' name="ambito" property="coinId">
					<option value='<bean:write name="ambito" property="coinId"/>'>
						<bean:write name="ambito" property="name"/>
					</option>					 
				</logic:notEqual>						
				</logic:iterate>
				</logic:present>
			</select>
		</td>
		<td valign="middle" align="right">
			Nombre: 
			<select style="width: 160px;" name="description" id="description" onchange="obtenerDescRequerimiento();">			
			<logic:present name="requerimientosValues">
			<% 
				String requerSelec = (String)request.getSession().getAttribute("requerimientoSelec");
				if(requerSelec==null) requerSelec = "";
			%>		
			        <option value=""></option>								
					<logic:iterate name="requerimientosValues" id="requerimiento">
					<logic:equal value="<%=requerSelec%>" name="requerimiento" property="coinId">
						<option value='<bean:write name="requerimiento" property="coinId"/>' selected="selected">
							<bean:write name="requerimiento" property="name"/>
						</option>
					</logic:equal>
					<logic:notEqual value='<%=requerSelec%>' name="requerimiento" property="coinId">
						<option value='<bean:write name="requerimiento" property="coinId"/>'>
							<bean:write name="requerimiento" property="name"/>
						</option>					 
					</logic:notEqual>						
					</logic:iterate>
				</logic:present>
			</select>
		</td>
		<td valign="middle" align="right">Descripción: </td>
		<td  valign="middle">
		 
		<logic:present name="descRequerimiento">
		  <!--  <input type="text" id="descRequerimiento" name="descRequerimiento"  value="<%=(String)request.getSession().getAttribute("descRequerimiento")%>" disabled="disabled"/>-->		   
		  <textarea readonly="readonly" rows="2" cols="20" id="descRequerimiento"><%=(String)request.getSession().getAttribute("descRequerimiento")%></textarea>
		</logic:present>
		<logic:notPresent name="descRequerimiento">
		  <!--  <input type="text" id="descRequerimiento" name="descRequerimiento"  value="" disabled="disabled"/>-->		  
		  <textarea readonly="readonly" rows="2" cols="20" id="descRequerimiento"></textarea>
		</logic:notPresent>
		</td>
	</tr>
</table>
</html:form>
<logic:present name="ratingQuestions">
<%int  contIdStars=1; %>
<table align="center" width="50%" class="tableXP" border="1" id="questionsTable">
	<thead>
		<tr>
			<td align="center"></td>
			<th align="center"></th>
		</tr>
	</thead>
	<tbody>
	<logic:iterate name="ratingQuestions" id="question">
		<tr id="<bean:write name="question" property="coinId" />">
			<td align="center"><bean:write name="question" property="name" /></td>
			<td align="right">
				<span id="spryrating<%=contIdStars%>" class="ratingContainer">
				    <logic:present name="ratingValues">
				    	<logic:iterate name="ratingValues" id="values">
				    		<span class="ratingButton"></span>
				    	</logic:iterate>
				    </logic:present>
				    <input id="dynamicElement<%=contIdStars%>" type="text" name="spry_dynamic<%=contIdStars%>" value="5" />
				</span>
			</td>
		</tr>
		<%contIdStars++; %>
	</logic:iterate>
	</tbody>
</table>
</logic:present>
<br>

<table class="tableForm" align="center" width="50%">
	<tr>
		<td align="center">
			Agradecemos tus comentarios:<br>
			<textarea rows="2" cols="50" id="comentarios" name="comentarios"></textarea>
		</td>
	</tr>
</table>
<br><br>
<center>
	<input type="button" value="guardar" class="button" onclick="saveRating();" id="saveRatingButton">
</center>


<script type="text/javascript">		
	var preguntas = $('questionsTable').getElementsByTagName('tr');
	var spryRating = new Array();
	for(var i=1; i<preguntas.length;i++){
		spryRating[i-1] = new Spry.Widget.Rating("spryrating"+i, {ratingValueElement:'dynamicElement'+i});
	}

function obtenerRequerimientos(){	
	$('method').value="init";
	document.forms[0].submit();
}

function obtenerDescRequerimiento(){
	$('method').value="init";
    document.forms[0].submit();
}

function saveRating(){	
	var url = '<%=request.getContextPath()%>';
	url += "/SaveRating?";
	var trs = $('questionsTable').getElementsByTagName('tr');
	for(var i=1;i<trs.length;i++){
		url += "ratings="+trs[i].id+"-"+$('dynamicElement'+i).value+"&";
		//alert("Id pregunta: "+trs[i].id+" ratingValue: "+$('dynamicElement'+i).value);
	}
	if ($('name').value != "" && $('description').value != ""){
		url += "comment="+ $('comentarios').value;
		url += "&ambito=" + $('name').value;
		url += "&requerimiento=" + $('description').value;
		//alert(url);		
		alert($('comentarios').value);
		if($('comentarios').value != ""){
			//alert($('comentarios').innerHTML);
			$Ajax(url , {
				cache:false,
				requestType:$requestType.TEXT, 
				onfinish:function(texto){
				//alert(texto);
					try{
						if(texto==0){
							alert('La evaluación se guardó con éxito, Gracias por su opinión');
							$('saveRatingButton').disabled="true";
							$('name').value = "";
							$('description').value = "";
							$('comentarios').value = "";
							$('descRequerimiento').value = "";							
							
							 $('method').value="init";
							 document.forms[0].submit();
							
							//Si se guardo correctamente la grafica y queremos pintar una grafica de como va la encuesta hacemos:
							/*
							1.- Calculamos el total de puntos acumulados
							3.- Iteramos total de preguntas
								por cada pregunta verific
							2.- Pintamos una tabla con N celdas= puntos +1
							*/
		
							
						}
					}catch(e){alert("exception");}
				},
				onerror:function(texto){
					alert("Ha ocurrido un error al guardar la evaluación");
				}
				});
		}else{
			alert("Sus comentarios son muy importantes para nosotros, por favor escriba un comentario");
		}
	}
	else {
		alert("Seleccione un ámbito y un requerimiento por favor");
		}
}
</script>
</body>
</html>