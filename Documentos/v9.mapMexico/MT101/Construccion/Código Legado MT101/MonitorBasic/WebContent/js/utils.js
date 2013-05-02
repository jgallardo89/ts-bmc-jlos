//All Browsers
var UNDEFINED = -1;
var IE = 1;
var MOZILLA = 2;
var SAFARI = 3;
var OPERA  = 4;


function resetTap1(){
	$('divmessageclientName').innerHTML='';
	$('clientName').value='';
	$('divmessageacronimo').innerHTML='';
	$('acronimo').value='';
	$('divmessagereference').innerHTML='';
	$('reference').value='';
	$('divmessageacount').innerHTML='';
	$('acount').value='';
	$('divmessageBICCode').innerHTML='';
	$('BICCode').value='';
	$('saveButtonRec').disabled=true;
	$('resetButtonRec').disabled=true;
	$('eliminarButton').disabled=true; 
	$('saveButtonRec').value='Guardar';
	$('registerRecaudos').innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Registrar cliente';
	$('idRecaudo').value='0';
}
function resetTap2(){
	$('divmessageclientNameRelay').innerHTML='';
	$('clientNameRelay').value='';
	$('divmessageacronimoRelay').innerHTML='';
	$('acronimoRelay').value='';
	$('divmessagereferenceRelay').innerHTML='';
	$('referenceRelay').value='';
	$('divmessageacountRelay').innerHTML='';
	$('acountRelay').value='';
	$('divmessageBICCodeRelay').innerHTML='';
	$('BICCodeRelay').value='';
	//$('divmessageRcuentaRelay').innerHTML='';
	$('RcuentaRelay2').value='';
	$('divmessageRBICRelay').innerHTML='';
	$('RBICRelay').value='';
	$('saveButtonRey').disabled=true;
	$('resetButtonRey').disabled=true;
	$('eliminarButton').disabled=true;
	$('saveButtonRey').value='Guardar';
	$('registerRelay').innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Registrar cliente';
	$('idClientRelay').value='0';
}
function resetTap3(){
	$('divmessageclientNamePay').innerHTML='';
	$('clientNamePay').value='';
	$('divmessageacronimoPay').innerHTML='';
	$('acronimoPay').value='';
	$('divmessagereferencePay').innerHTML='';
	$('referencePay').value='';
	$('divmessageacountPay').innerHTML='';
	$('acountPay').value='';
	$('divmessageBICCodePay').innerHTML='';
	$('BICCodePay').value='';
	$('divmessageBICSendPay').innerHTML='';
	$('BICSendPay').value='';
	deleteAll();
	$('saveButtonPay').disabled=true;
	$('resetButtonPay').disabled=true;
	$('saveButtonPay').value='Guardar';
	$('registerPay').innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Registrar cliente';
	$('idClientPay').value='0';
}

function showBrowserProperties(){
	document.write("<center><B>Nombre de navegador: </B>" + navigator.appName + "<BR>");
	document.write("<B>Agente: </B>" + navigator.userAgent + "<BR>");
	document.write("<B>Versión: </B>" + navigator.appVersion + "<BR></center>");
}

function browserDetect(){
	if(navigator.appName == "Microsoft Internet Explorer") return IE;
	else if(navigator.appName == "Netscape") return MOZILLA;
	else return UNDEFINED;
}

function compareDates(date1, date2){
	var ddmmYYYY1 = date1.split("-");
	var ddmmYYYY2 = date2.split("-");
	var dateStart = new Date();
	var dateEnd   = new Date();
	
	dateStart.setFullYear(ddmmYYYY1[2], ddmmYYYY1[1]-1, ddmmYYYY1[0]);
	dateEnd.setFullYear(ddmmYYYY2[2], ddmmYYYY2[1]-1, ddmmYYYY2[0]);
	
	return  (dateEnd.getTime()/86400000)-(dateStart.getTime()/86400000);

}