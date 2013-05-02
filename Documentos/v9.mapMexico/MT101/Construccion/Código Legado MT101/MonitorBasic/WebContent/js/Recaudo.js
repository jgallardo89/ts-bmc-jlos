/*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+
 *+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+
 @Descripcion: Script para inicialización de los objetos y la tabla
 			   Spry para los recaudos o la primer pestaña 
 *+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+
 *+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*/
function activeSaveButtonRec(textBox){
		if(textBox.value.length>3){
			$('saveButtonRec').disabled=false; 
		}else{
			$('saveButtonRec').disabled=true;
		}
}
function activeResetButtonRec(){
	var value1;
	value1	=	$('clientName').value;
	if(value1.length>0){
		$('resetButtonRec').disabled=false;
	}else{
		$('resetButtonRec').disabled=true;
	}
}

function activeSaveButtonRey(textBox){ 
	if(textBox.value.length>3){
		$('saveButtonRey').disabled=false; 
	}else{
		$('saveButtonRey').disabled=true;
	}
}
function activeResetButtonRey(){ 
	var value1;
	value1	=	$('clientNameRelay').value; 
	if(value1.length>0){
		$('resetButtonRey').disabled=false; 
	}else{
		$('resetButtonRey').disabled=true;
	}
}

/*function activeSaveButtonPay(textBox){
	if(textBox.value.length>3){
		$('saveButtonPay').disabled=false;
	}else{
		$('saveButtonPay').disabled=true;
	}
}*/
/*function activeResetButtonPay(){
	var value1; 
	value1	=	$('clientNamePay').value;
	if(value1.length>0){
		$('resetButtonPay').disabled=false;
	}else{
		$('resetButtonPay').disabled=true;
	}
}*/
 function reloadTableRecaudos(){
	html_ds = new Spry.Data.HTMLDataSet('tableRecaudos.jsp', "tabela", {firstRowAsHeaders:true, columnNames:["id","cliente" , "acronimo","referencia" ,"cuenta" , "idpais", "pais","bic","fecha_alta"]});	
	page = new Spry.Data.PagedView(html_ds, {pageSize: 12});	
	pageInfo = page.getPagingInfo();
	Spry.Utils.updateContent($('tableRecaudo'), 'tableRecaudos.jsp');
}
 
 function showOptMexico(select){
		if(select.value=="6"){
			/*
			*Efectos SPRY
			*/
			var optmx = new Spry.Effect.Fade('optMexico', {toggle:true});
			optmx.start();
			return false;
			
		}else{
			Effect.Fade('optMexico');
			return false;
		}
	}
	function backOptions(){
		document.forms[1].submit();
	}

	function sendForm(context){
		
		if($('clientAAA').checked){ $('clientAAA').value='1';}
		else{$('clientAAA').value='0';}
		var success=false;
		var success2=false;
		if( !(validate($('clientName'),true)) 			|| 
			!(validate($('acronimo'),true,true,3))		||
			!(validate($('reference'),true,true,8,false,true)) 	||
			!(validate($('acount'),false,true,10,false,true))		||
			!(validate($('BICCode'),true,false,11,true,true))){
			success=false;
		}
		else{
			success=true;
		}
		if(document.getElementById('clientTypeE').checked && $('BICEuro').value==0){
			$('divmessageBICEuro').innerHTML="Debe elegir un código BIC";
			Effect.Appear('messageBICEuro');
			success2=false;
		}else{
			$('divmessageBICEuro').innerHTML='';
			Effect.Fade('messageBICEuro');
			success2=true;
		}
		
	  	if(success && success2){
			//Si descomentas esto lo puedes hacer con AJAX
			/*var values = $('saveClient').serialize();
			$Ajax('save-client-operations.jsp',{method: $method.POST,
								  parameters: values,
								  onfinish: alert('Guardando Información')});
			*/ 
			if($('idRecaudo').value==0){
				document.forms[0].submit();
			}
			else{
				document.forms[0].action=context+"/updateRecaudos.do";
				document.forms[0].submit();
			}
				
	  	}
	}
	function updateClient(element){
		var ids = element.id.split('-');
		$('idClientUpdate').value = ids[1];
		//$('serviceTypeClient').value = $('serviceType').value;
		document.forms[2].submit();
	}

	function makeDraggable(element){
		//alert(element.id);
		new Draggable(element.id, {ghosting: true,revert:true});
	}

	function onloadBody(){
		//Effect.Fade('messageErrPay',{duration:5.0});
		Effect.Fade('messageErrRelay',{duration:5.0});
		Effect.Fade('messageErr',{duration:5.0});

		Effect.Fade('BE'); 
		$('clientTypeL').value='LATAM';
		$('clientTypeL').checked=true;
		Effect.Fade('BERelay'); 
		$('clientTypeLRelay').value='LATAM';
		$('clientTypeLRelay').checked=true;
		//Effect.Fade('BEPay'); 
		//$('clientTypeLPay').value='LATAM';
		//$('clientTypeLPay').checked=true;
		//Inicializa el pickList
		//initIt();

	}
	
	function pasteRegRecaudo(idRow, idTable){

		
		$('registerRecaudos').innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Actualizar cliente';
	
		$('saveButtonRec').value='Actualizar';
		
		
		
		//Habilitamos todos los botones por si estan deshabilitados
		$('saveButtonRec').disabled = false;
		$('resetButtonRec').disabled = false;
		$('saveButtonRey').disabled = false;
		$('resetButtonRey').disabled = false;
		//$('saveButtonPay').disabled = false;
		//$('resetButtonPay').disabled = false;
		
		var element = this.getNodos(idRow); 
		
		
		
		
		$('idRecaudo').value = element[0].innerHTML;
		$('clientName').value = $('clientNameRelay').value = element[1].innerHTML;
		$('acronimo').value   = $('acronimoRelay').value   = element[4].innerHTML;
		$('reference').value  = $('referenceRelay').value  = element[5].innerHTML;
		$('acount').value     = $('acountRelay').value 	   = element[13].innerHTML;
		
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
		$('BICCode').value = $('BICCodeRelay').value = element[6].innerHTML;
		//showOptMexico($('country'));
		//showOptMexicoRelay($('country'));
		//showOptMexicoRelay($('countryPay'));	

		if(element[7].innerHTML==1){
			$('clientTypeL').checked = true;
			//Effect.Fade('BE'); 
			//Effect.Fade('messageBICEuro'); 
			$('clientTypeL').value='LATAM';

			$('clientTypeLRelay').checked = true;
			//Effect.Fade('BERelay'); 
			//Effect.Fade('messageBICEuroRelay'); 
			$('clientTypeLRelay').value='LATAM';
			
			/*$('clientTypeLPay').checked = true;
			Effect.Fade('BEPay'); 
			Effect.Fade('messageBICEuroPay'); 
			$('clientTypeLPay').value='LATAM';*/
		}else{
			$('clientTypeE').checked=true;
			//Effect.Appear('BE'); 
			$('clientTypeE').value='spain';
			options = $('BICEuro').options;
			for(i = 0; i < options.length; i++){
				if(options[i].value==element[9].innerHTML){
		    		options[i].selected = true;
				}
			}

			$('clientTypeERelay').checked=true;
			//Effect.Appear('BERelay'); 
			$('clientTypeERelay').value='spain';
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
			options = $('BICEuroPay').options;
			for(i = 0; i < options.length; i++){
				if(options[i].value==element[9].innerHTML){
		    		options[i].selected = true;
				}
			}*/
		}
		$('referenceSwift').value = element[18].innerHTML;
		$('referenceSwiftRelay').value = element[18].innerHTML;
		$('company').value = element[19].innerHTML;
		$('companyRelay').value = element[19].innerHTML;
		$('pciva').value = element[20].innerHTML;
		$('pcivaRelay').value = element[20].innerHTML;
		$('sicoco').value = element[22].innerHTML;
		$('sicocoRelay').value = element[22].innerHTML;
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