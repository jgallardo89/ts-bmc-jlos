var hexVals = new Array("0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
        "A", "B", "C", "D", "E", "F");
var unsafeString = "\"<>%\\^[]`\+\$\,";
//deleted these chars from the include list ";", "/", "?", ":", "@", "=", "&" and #
//so that we could analyze actual URLs

function isUnsafe(compareChar){
	//this function checks to see if a char is URL unsafe.
	//Returns bool result. True = unsafe, False = safe
	if (unsafeString.indexOf(compareChar) == -1 && compareChar.charCodeAt(0) > 32 && compareChar.charCodeAt(0) < 123)
	{ return false; } // found no unsafe chars, return false
	else
	{ return true; }
}

function decToHex(num, radix){
	//part of the hex-ifying functionality
	var hexString = "";
	while (num >= radix){
	    temp = num % radix;
	    num = Math.floor(num / radix);
	    hexString += hexVals[temp];
	   }
	hexString += hexVals[num];
	return reversal(hexString);
}

function reversal(s){ // part of the hex-ifying functionality
	var len = s.length;
	var trans = "";
	for (i=0; i<len; i++)
	 { trans = trans + s.substring(len-i-1, len-i); }
	s = trans;
	return s;
}

function convert(val) // this converts a given char to url hex form
{ return  "%" + decToHex(val.charCodeAt(0), 16); }

function UrlEncode(val){
	//changed Mar 25, 2002: added if on 122 and else block on 129 to exclude Unicode range
	var len     = val.length;
	var backlen = len;
	var i       = 0;
	
	var newStr  = "";
	var frag    = "";
	var encval  = "";
	var original = val;

	 for (i=0; i < len; i++) {
	       if (val.substring(i,i+1).charCodeAt(0) < 255)  // hack to eliminate the rest of unicode from this
	          {
	           if (isUnsafe(val.substring(i,i+1)) == false)
	              { newStr = newStr + val.substring(i,i+1); }
	           else
	              { newStr = newStr + convert(val.substring(i,i+1)); }
	          }
	       else // woopsie! restore.
	          {
	            alert ("Found a non-ISO-8859-1 character at position: " + (i+1) + ",\nPlease eliminate before continuing.");
	            newStr = original; i=len;                // short-circuit the loop and exit
	          }
	     }
	
	 return(newStr);
}

/**
 **	FUNCION QUE PERMITE SOLO LA INSERCIN DE LOS
 **	DIGITOS DEL 0 AL 9 EN UN CAMPO DE TEXTO
 **	INVOCACION: onKeyPress='SoloEnteros()'
 **/
function SoloEnteros(){
	if(window.event.keyCode < 48 || window.event.keyCode > 57){	
		window.event.returnValue = 0;
	}
}

/**
 **	FUNCION QUE PERMITE SOLO LA INSERCIN DE LOS
 **	DIGITOS DEL 0 AL 9 y un solo punto decimal (.) EN UN CAMPO DE TEXTO
 **	INVOCACION: onKeyPress='SoloNumerosDobles(valorDelCampo)'
 **/
function SoloNumerosDobles(psNumero){
	var numero = new String(psNumero);
	if(numero.length==5 && window.event.keyCode != 46){
		if(numero.indexOf(".", 0) >= 5 || numero.indexOf(".", 0) < 0){
			window.event.returnValue = 0;			
		}
	} 
	else{
		if(window.event.keyCode <48 || window.event.keyCode > 57){	
			if(window.event.keyCode != 46){
				window.event.returnValue = 0;
			}
			else{
				if(numero.indexOf(".", 0) >= 0){
					window.event.returnValue = 0;
				}
			}
		}
	}
}

/**
 **	FUNCION QUE PERMITE SOLO LA INSERCIN DE CARACTERES
 **	ALFANUMRICOS EN UN CAMPO DE TEXTO (a-z, A-Z, 0-9, Espacio)
 **	INVOCACION: onKeyPress='SoloAlfas()'
 **/
function SoloAlfas(){
	if((window.event.keyCode < 97 || window.event.keyCode > 122) &&		// a - z sin 
	   (window.event.keyCode < 65 || window.event.keyCode > 90) &&		// A - Z sin 
	   (window.event.keyCode < 48 || window.event.keyCode > 57)	&&		// 0 - 9
	   window.event.keyCode != 32){		// Espacio
		window.event.returnValue = 0;
	}
}

/**
 **	FUNCION QUE PERMITE SOLO LA INSERCIN DE CARACTERES
 **	ALFANUMRICOS EN UN CAMPO DE TEXTO (a-z, A-Z, Espacio)
 **	INVOCACION: onKeyPress='SoloChars()'
 **/
function SoloChars(){
	if((window.event.keyCode < 97 || window.event.keyCode > 122) &&		// a - z sin 
	   (window.event.keyCode < 65 || window.event.keyCode > 90) &&		// A - Z sin 
	   window.event.keyCode != 32){		// Espacio
		window.event.returnValue = 0;
	}
}

/**
 **	FUNCION QUE VALIDA QUE UNA FECHA SEA CORRECTA
 **	RECIBE EL OBJETO EN EL CUAL SE TECLEA EL DATO
 **	EJEMPLO: ValidaFecha(document.frmDatos.txtFecha);
 **/
function ValidaFecha(obj){
	var dateStr = obj.value;
    var datePat = /^(\d{1,2})(\/|-)(\d{1,2})\2(\d{4})$/;
    var matchArray = dateStr.match(datePat); // is the format ok?

    if (matchArray == null) {
        alert("Formato invalido de la Fecha");
        obj.focus();
        return (false);
    }
    month = matchArray[1]; // parse date into variables
    day = matchArray[3];
    year = matchArray[4];
    if (month < 1 || month > 12) { // check month range
        alert("El mes debe estar dentro de un rango de 1 a 12");
        obj.focus();
        return (false);
    }
    if (day < 1 || day > 31) {
        alert("Los dias deben estar en un rango de 1 a 31");
        obj.focus();
        return (false);
    }
    if ((month==4 || month==6 || month==9 || month==11) && day==31) {
        alert("El mes "+month+" no tiene 31 dias");
        obj.focus();
        return (false);
    }
    if (month == 2) { // check for february 29th
        var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
        if (day>29 || (day==29 && !isleap)) {
            alert("Febrero " + year + " no tiene " + day + " dias!");
            obj.focus();
            return (false);
       }
    }
    return (true);  // date is valid
}


/**
 * Funcion que regresa true, cuando la cadena pasada es secuencia de dígitos únicamente
 * @param cadena
 * @return
 */
function cadenaSoloEnteros(cadena){
	var isNumero = true;	
	var numeros="0123456789";
	for(i=0; i<cadena.length; i++){
		if (numeros.indexOf(cadena.charAt(i),0)==-1){
			isNumero = false;
		}
	}
	return isNumero;
}


/**
 * Funcion que regresa true, cuando la cadena pasada es secuencia de dígitos y tiene máximo un punto decimal
 * @param cadena
 * @return
 */
function validaNumero(cadena){
	var isNumero = true;	
	var numeros="0123456789.";
	var puntos = 0;
	for(i=0; i<cadena.length; i++){		
		if (numeros.indexOf(cadena.charAt(i),0)==-1){
			isNumero = false;
		}
		if (cadena.charAt(i)=='.' || cadena.charAt(i)==','){
			puntos++;
		}			
	}
	if(puntos > 1){
		isNumero = false;
	}
	return isNumero;
	}


/**
 **	FUNCION QUE ABRE UN POPUP CON LA URL ESPECIFICADA
 **	TAMBIEN SE LEEN LAS OPCIONES Y EL TITULO DE LA VENTANA
 **/
function abrir(url, PCompleta, BHerram, BDir, BEdo, BMenu, BDesp, Resize, Ancho, Alto, Izq, Arriba, Sustituir){
	Izq = (screen.width - Ancho) / 2;
    Arriba = (screen.height - Alto) / 2;
    var opciones = "fullscreen=" + PCompleta +
                   ",toolbar=" + BHerram +
                   ",location=" + BDir +
                   ",status=" + BEdo +
                   ",menubar=" + BMenu +
                   ",scrollbars=" + BDesp +
                   ",resizable=" + Resize +
                   ",width=" + Ancho +
                   ",height=" + Alto +
                   ",left=" + Izq +
                   ",top=" + Arriba;
    var ventana = window.open(url, "PopUp", opciones, Sustituir);
}


function validateSession(userName, url){
	$Ajax(url+"/ValidateSession?o=" + userName , {
		cache:false,
		requestType:$requestType.TEXT, 
		onfinish:function(html){
			if(html==0){
				alert("La sesion ha expirado");
				window.parent.location= url;
			}else{}
		},
		onerror:function(html){
			alert("Ha ocurrido un error al validar session");
		}
		});
}


function getPreviewArchivo(urlArchivo){		
	if ( urlArchivo != "") {		
		document.getElementById("previewArchivo").src = urlArchivo;		
	}
}


/*Funcion para validar el browser*/
function getBrowser(){
txt = navigator.appName;
if(txt=="Microsoft Internet Explorer")
	return true;
else
	return false;

}


/*rutina que permite extrare los nodos de una tabla*/

function getNodos(row)
{
	var tr= row.getElementsByTagName("tr")[row];
	var cells = row.getElementsByTagName("td");
	
	return cells;
	
}

/****************************************************
****** FUNCION CON FIX PARA CARGA DE DATOS DE *******
***** TABLA SPRY A FORMULARIO PARA IE Y FIREFOX *****
*****************************************************/
function ObtenerValorField(reg, indice) {
	var NvoIndice, fields;
	
	// Validar el tipo de explorador en uso
	if (navigator.appName == "Netscape"){
		NvoIndice = (indice * 2) + 1;
	}
	else if (navigator.appName.indexOf("Explorer") != -1){
		NvoIndice = indice;
	}
	
	// Crear variable fields asumiendo que el evento procede del evento de doble click (CargaRegistro)
	fields = reg.childNodes;
	
	// En caso de que variable fields sea nula, armar fields basado en funcion de DragAndDrop (pasteReg*)
	if(fields == null)
		fields = $(reg).childNodes;
	
	return fields[NvoIndice].innerHTML;
}