/*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+
 *+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+
 @Descripcion: Script para inicialización de los objetos y la tabla
 			   Spry para las consultas Relay De la segunda pestaña 
 *+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+
 *+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*/

function showOptMexicoRelay(select){
	if(select.value=="6"){
		var optmx = new Spry.Effect.Fade('optMexicoRelay', {toggle:true});
		optmx.start();
		return false;
		
	}else{
		//new Effect.BlindUp('optMexico');
		Effect.Fade('optMexicoRelay');
		return false;
	}
}
function backOptionsRelay(){
	$('backBlankRelay').submit();
}

function sendFormRelay(context){
	
	if($('clientAAARelay').checked){ $('clientAAARelay').value='1';}
	else{$('clientAAARelay').value='0';}

	var success=false;
	var success2=false;
	if( !(validate($('clientNameRelay'),true)) 				||
		!(validate($('acronimoRelay'),true,true,3)) 		|| 
	  	!(validate($('referenceRelay'),true,true,8,false,true)) 		|| 
	  	!(validate($('acountRelay'),false,true,10,false,true)) 		||
	  	!(validate($('RcuentaRelay2'),true,false,0,false,true)) 				||
	  	!(validate($('RBICRelay'),true,false,11,true,true))		||
	  	!(validate($('BICCodeRelay'),true,false,11,true,true))  	){
		success=false;
	}
	else{
		success=true;
	}	
	if (document.getElementById('clientTypeLRelay').checked){		
		document.getElementById('clientTypeLRelay').value = "LATAM";
	}	
	if(document.getElementById('clientTypeERelay').checked && $('BICEuroRelay').value==0){
		$('divmessageBICEuroRelay').innerHTML="Debe elegir un código BIC";
		document.getElementById('clientTypeERelay').value="spain";
		Effect.Appear('messageBICEuroRelay');
		success2=false;
	}else{
		$('divmessageBICEuroRelay').innerHTML='';
		Effect.Fade('messageBICEuroRelay');
		success2=true;
	}
	
  	if(success && success2){
		//Si descomentas esto lo puedes hacer con AJAX
		/*var values = $('saveClient').serialize();
		$Ajax('save-client-operations.jsp',{method: $method.POST,
							  parameters: values,
							  onfinish: alert('Guardando Información')});
		*/
		$("aux1").value = $('RcuentaRelay2').value;

		
		if($('idClientRelay').value==0){
			alert("Esta Apunto de Guardar");
			document.forms[0].submit();
		}
		else{
			document.forms[0].action=context+"/updateRelay.do";
			document.forms[0].submit();
		}
  	}
}
function updateClientRelay(element,ra){
	var ids = element.id.split('-');
	$('idClientUpdateRelay').value = ids[1];
	$('serviceTypeClientRelay').value = $('serviceTypeRelay').value;
	$('relayAcount').value = ra;
	document.forms[5].submit();
}



function pasteRegRelay(idRow, idTable){	
	$('registerRelay').innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Actualizar cliente';
	//Habilitamos todos los botones por si estan deshabilitados
	$('saveButtonRec').disabled = false;
	$('resetButtonRec').disabled = false;
	$('saveButtonRey').disabled = false;
	$('resetButtonRey').disabled = false;
	//$('saveButtonPay').disabled = false;
	//$('resetButtonPay').disabled = false;
	
	var element = this.getNodos(idRow);
	
		$('idClientRelay').value = element[0].innerHTML;
		$('clientNameRelay').value = $('clientName').value 	= element[1].innerHTML;
		$('acronimoRelay').value   = $('acronimo').value	= element[4].innerHTML;
		$('referenceRelay').value  = $('reference').value 	= element[5].innerHTML;
		$('acount').value     = $('acountRelay').value = element[13].innerHTML;
	
	if($('acount').value=="-"){ $('acount').value =""; $('acountRelay').value ="";}
	var options = $('country').options;
	for(var i = 0; i < options.length; i++){
		if(options[i].value==element[2].innerHTML){
    		options[i].selected = true;
		}
	}
	options = $('countryRelay').options;
	for(i = 0; i < options.length; i++){
		if(options[i].value==element[2].innerHTML){
    		options[i].selected = true;
		}
	}
	/*options = $('countryPay').options;
	for(i = 0; i < options.length; i++){
		if(options[i].value==element[2].innerHTML){
    		options[i].selected = true;
		}
	}*/
		$('BICCodeRelay').value = $('BICCode').value = element[6].innerHTML;
		$('RcuentaRelay2').value = element[26].innerHTML;
		$('RBICRelay').value = element[27].innerHTML;

	if(element[7].innerHTML==1){
		$('clientTypeL').checked = true;
		$('clientTypeL').value='LATAM';
		$('clientTypeRelay').value =$('clientTypeL'); 
		
		$('clientTypeLRelay').checked = true;
		$('clientTypeLRelay').value='LATAM';
		$('clientTypeRelay').value =$('clientTypeL');
		
		/*$('clientTypeLPay').checked = true;
		Effect.Fade('BEPay'); 
		Effect.Fade('messageBICEuroPay'); 
		$('clientTypeLPay').value='LATAM';
		$('clientTypePay').value =$('clientTypeL');*/
		
	}else{
		$('clientTypeE').checked=true;
		
		$('clientTypeE').value='spain';
		$('clientTypeRelay').value = $('clientTypeE').value;
		options = $('BICEuro').options;
		for(i = 0; i < options.length; i++){
			if(options[i].value==element[9].innerHTML){
	    		options[i].selected = true;
			}
		}
		
		$('clientTypeERelay').checked=true;

		$('clientTypeERelay').value='spain';
		$('clientTypeRelay').value = $('clientTypeERelay').value;
		options = $('BICEuroRelay').options;
		for(i = 0; i < options.length; i++){
			if(options[i].value==element[9].innerHTML){
	    		options[i].selected = true;
			}
		}
		
		/*$('clientTypeEPay').checked=true;
		$('BICSendPay').value='';
		$('BICSendPay').disabled=true;
		Effect.Appear('BEPay'); 
		$('clientTypeEPay').value='spain';
		$('clientTypePay').value = $('clientTypeEPay').value;
		options = $('BICEuroPay').options;
		for(i = 0; i < options.length; i++){
			if(options[i].value==element[9].innerHTML){
	    		options[i].selected = true;
			}
		}*/
	}
	$('referenceSwift').value = element[18].innerHTML;
	$('referenceSwiftRelay').value = element[26].innerHTML;
	$('company').value = element[19].innerHTML;
	$('companyRelay').value = element[19].innerHTML;
	$('pciva').value = element[20].innerHTML;
	$('pcivaRelay').value = element[20].innerHTML;
	$('sicoco').value = element[22].innerHTML;
	$('sicocoRelay').value = element[22].innerHTML;	
	$('referenceBicRelay').value = element[27].innerHTML;;
	
	if(element[21].innerHTML == 1){
		$('clientAAA').checked=true;
		$('clientAAARelay').checked=true;
	}
	else{
		$('clientAAA').checked=false;
		$('clientAAARelay').checked=false;
	}
	if(element[23].innerHTML == 1){
		$('anualidad').checked=true;
		$('anualidadRelay').checked=true;
	}
	else{
		$('anualidad').checked=false;
		$('anualidadRelay').checked=false;
	}
	if(element[24].innerHTML == 1){
		$('mensualidad').checked=true;
		$('mensualidadRelay').checked=true;
	}
	else{
		$('mensualidad').checked=false;
		$('mensualidadRelay').checked=false;
	}
	
}