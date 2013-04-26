<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body onload="javascript:validSession();">
<script type="text/javascript">
function validSession(){
	validateSession_ice(parent.document.getElementById('userName').value,'<%=request.getContextPath()%>');
}
function validateSession_ice(userName, url){
	alert('Su Session ha expirado');
	window.parent.location=url+"/DeleteOneSession?user="+userName;
}
</script>
</body>
</html>