<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld"  prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html"%>
<%@ page import="com.bancomer.gis.monitorwebswift.vo.Usuario"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cambio de password</title>	
<link rel="shortcut icon" href="<%=request.getContextPath()%>/images/MonitorWeb.ico"/>
<link href="<%=request.getContextPath()%>/css/MonitorGmmStyles.css"	rel="stylesheet" type="text/css"/>

<script src="<%=request.getContextPath()%>/js/Ajax.js" 								type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/scriptaculous/lib/prototype.js"		type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/scriptaculous/src/scriptaculous.js" 	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/ValidateFields.js" 					type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/utilerias.js"		 					type="text/javascript"></script>

<script Language="JavaScript">
	function Cancelar(){
		window.close();
		window.opener.focus();
	}

	function validar(){
		var url  =  '<%=request.getContextPath()%>/changePassword.do';
			url +=  '?param1=' + <%=request.getParameter("o")%>;
			url +=  '&param2=' + $('password').value;
			url +=  '&param3=' + $('confirmPass').value;
			url +=  '&param4=' + $('oldPass').value;


		if($('password').value.length<8){
			alert("El password debe ser al menos de 8 caracteres.");
			$('password').focus();
			return;
		}

			

		if($('password').value != $('confirmPass').value){
			alert("La confirmación del password no coincide con el nuevo password");
			$('password').focus();
			return;
		}
		else{
				//Primero si la validacion es correcta, validamos que la contrasenia anterior no sea igual a la nueva que acaba de escribir
				if($('oldPass').value == $('password').value){
					alert("El password actual es identico al password nuevo, favor de escribir otra contraseña");
					$('password').focus();
					return;
				}else{
					$Ajax( url, {
						cache:false,
						onfinish:function(html){
							var message ="";
													
								if(html==-1) message ="La confirmación del password no coincide con el nuevo password";
								if(html==0) message  ="El Password de su usuario se ha modificado";
								if(html==1) message  ="El password actual no es correcto";
								if(html==2) message  ="Error al actualizar el Password, inténtelo mas tarde";
							
							alert(message);
							if(html==0) Cancelar();
							
						},
						messageLoading:"loading",
						onerror:function(html){
							alert("Ha ocurrido un error al cambiar el password de operación");
						}
						});
				}
		}
	}
	</script>
<link href="<%=request.getContextPath()%>/css/MonitorGmmStyles.css"	rel="stylesheet" type="text/css"/>
</head>
<body>
<div class='sectionTitle'>
	&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;
	Cambio de password
</div>
<div id="loading" style="position:absolute;left:350px;top:10px;background-color:#fff;display:none">
	<img src="<%=request.getContextPath()%>/images/loaderindicatorBig.gif" width="20" height="20">
</div>
<table border="0" cellPadding="0" cellSpacing="0" width="100%" align='center' class="tableForm">
	<logic:present name="userMonitorGMM">
	<tr>
		<td colspan="2" align="center" class='sectionTitle'>
			<bean:write name="userMonitorGMM" property="nbNombreUsr"/>&nbsp;
			<bean:write name="userMonitorGMM" property="nbApellPat"/>&nbsp;
			<bean:write name="userMonitorGMM" property="nbApellMat"/>
		</td>
	</tr>
	</logic:present>
	<tr>
	<td colspan="2" align="center">(Favor de teclear la nueva contrase&ntilde;a)</td>
	</tr>
	<tr>
	<td colspan='2'>&nbsp;</td>
	</tr>
	<tr height='23'>
		<td align='center'>Password Actual:</td>
		<td align='center'><input name="oldPass" id="oldPass" type='password' size='30' maxlength="12" onblur="upper(this);" onkeydown="upper(this);" onkeyup="upper(this);" onkeypress="upper(this);"></td>
	</tr>
	<tr height='23'>
		<td align='center'>Nuevo Password:</td>
		<td align='center'><input name="password" id="password" type='password' size='30' maxlength="12" onblur="upper(this);" onkeydown="upper(this);" onkeyup="upper(this);" onkeypress="upper(this);"></td>
	</tr>
	<tr height='23'>
		<td align='center'>Confirmar Nuevo Psw:</td>
		<td align='center'><input name="confirmPass" id="confirmPass" type='password' size='30' maxlength="12" onblur="upper(this);" onkeydown="upper(this);" onkeyup="upper(this);" onkeypress="upper(this);"></td>
	</tr>
	<tr valign='middle' height='30'>
		<td align='center'><input type='button' id=Submit1 onClick="validar();" class="button" name="cmdAceptar" value='Aceptar'></td>
		<td align='center'><input type='button' onClick='Cancelar();' class="button" name="cmdCancelar" value='Cancelar'></td>
	</tr>
</table>
</body>

</html>