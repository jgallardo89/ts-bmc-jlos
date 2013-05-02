function validate(field, notnull, length, max, bicFlag, zeros){
	var message="";
	var success=true;
	if(notnull){
		if(field.value==""){
			message="<li>El campo no puede estar vacío</li>";
			success=false;
		}else{
			success=true;
		}
	}

	if(field.value.length>0 && bicFlag && success){
		if(!validateBIC(field)){
			message+="<li>Código BIC válido solamente 8 u 11 posiciones</li>";
			success=false;
		}else{
			if(zeros){
				if(validateZeros(field.value)){
					message="<li>El campo no pueden ser solo ceros</li>";
					success=false;
				}else{
					success=true;
					flagAux = false;
				}
			}
		}
		
	}
	
	if(field.value.length>0 && length && success){
		if(field.value.length < max ){
			message+="<li>El campo no puede ser menor a "+max+" caracteres</li>";
			success=false;
		}else{
			if(zeros){
				if(validateZeros(field.value)){
					message="<li>El campo no pueden ser solo ceros</li>";
					success=false;
				}else{
					success=true;
					flagAux = false;
				}
			}
		}
	}
	
	if(!success){
			$("divmessage"+field.id).innerHTML=message;
			return success;
	}else{
			$("divmessage"+field.id).innerHTML='';
		return success;
	}
}

function validaEspacio(){
	if ((window.event.keyCode == 32)){
		window.event.returnValue=0;
	}
}

function rellenaCeros(campo,totalCaracs){
	var valorCampo 	= campo.value;
	var idCampo		= campo.id;
	var valorCampoFinal = '';
	if( valorCampo!='' && valorCampo!='0'){
		for(i=0;i<(totalCaracs-valorCampo.length);i++){
			valorCampoFinal+='0';
		}
		valorCampoFinal+=valorCampo;
		$(idCampo).value = valorCampoFinal;
	}
}


 





function validateNumbers(){
	/*
	 * Validación [0-9]
	 */
	if (window.event.keyCode <48 || window.event.keyCode > 57){	
			window.event.returnValue=0;
	}
}

function validateCharacters(){
	/*
	 * Validación para caracteres [a-z] [A-Z] [\.] y [ ](espacio) [-]guion
	 */
	if ((window.event.keyCode >=97 && window.event.keyCode <= 122) || 
		(window.event.keyCode >=65 && window.event.keyCode <= 90)  ||
		(window.event.keyCode == 46) || (window.event.keyCode == 32)){	
		//window.event.returnValue=0;
	}
	else{
		/*
		 * Validación para caracteres especiales á, é, í, ó y ú
		 */
		if((window.event.keyCode == 225) || (window.event.keyCode == 233) ||
				(window.event.keyCode == 237) || (window.event.keyCode == 243) ||
				(window.event.keyCode == 250)){
		}else{
			window.event.returnValue=0;
		}
	}
}

function validateAlfaNumerics(){
	if ((window.event.keyCode >=97 && window.event.keyCode <= 122) || 
			(window.event.keyCode >=65 && window.event.keyCode <= 90) ||
			(window.event.keyCode >=48 && window.event.keyCode <= 57)){	
	}
	else{
		window.event.returnValue=0;
	}
}

function validateAlfaNumericsPunto(){	
	if ((window.event.keyCode >=97 && window.event.keyCode <= 122) || 
			(window.event.keyCode >=65 && window.event.keyCode <= 90) ||
			(window.event.keyCode >=48 && window.event.keyCode <= 57) ||
			(window.event.keyCode == 46)){	
	}
	else{
		window.event.returnValue=0;
	}
}

function validateAlfaNumEspGuion(){
	if ((window.event.keyCode >=97 && window.event.keyCode <= 122) || 
			(window.event.keyCode >=65 && window.event.keyCode <= 90) ||
			(window.event.keyCode >=48 && window.event.keyCode <= 57) || (window.event.keyCode == 32) ||
			(window.event.keyCode == 45)){	
	}
	else {
		window.event.returnValue=0;
	}
}

function validateAlfaNumGuion(){
	if ((window.event.keyCode >=97 && window.event.keyCode <= 122) || 
			(window.event.keyCode >=65 && window.event.keyCode <= 90) ||
			(window.event.keyCode >=48 && window.event.keyCode <= 57) || (window.event.keyCode == 32)){	
	}
	else {
		window.event.returnValue=0;
	}
}

function validateRelayAcount(){
	if ((window.event.keyCode >=97 && window.event.keyCode <= 122) || 
			(window.event.keyCode >=65 && window.event.keyCode <= 90) ||
			(window.event.keyCode >=48 && window.event.keyCode <= 57)
			|| (window.event.keyCode == 45)|| (window.event.keyCode == 32)){	
	}
	else{
		window.event.returnValue=0;
	}
}

function validateBIC(field){
	var success;
	if(field.value.length==8){
		success=true;
	}else if(field.value.length==11){
		success=true;
	}else{
		success=false;
	}
	return success;
}
function upper(obj){
	obj.value = obj.value.toUpperCase();
}
function chgButton() {
	   
	if (document.images) {
			document.images[chgButton.arguments[0]].src = eval(chgButton.arguments[1] + ".src");
	}
	return true;
}

function validateZeros(text){
	var pattern = /^0*0$/;
	var value = text;
	if(value.search(pattern)==0){
		return true;
	}
	else{
		return false;
	}
}