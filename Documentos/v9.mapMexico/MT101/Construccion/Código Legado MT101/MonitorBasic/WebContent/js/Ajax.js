/**
 * @author mfragoso
*/

/**
 * Variables para definir las opciones de tipo de
 * respuesta
 */
var $requestType= {XML:0, TEXT:1, JSON:2};

/**
 * Variables para definir los tipo para m�todo
 */
var $method = {GET:"GET", POST:"POST"};


/**}
 * Realiza un nuevo requerimiento AJAX a la url especificada
 * con las opciones definidas
 * 
 * @param {String}url, La URL donde realizar la petici�n
 * @param {Object} options, Un objeto JSON con los atributos opcionales
 * que queremos definirle
 * 
 * Opciones disponibles:
 * 
 * 		id: Un identificador interno para ser recibido junto a los datos
 * 		myMethod: $method.POST o $method.GET
 * 		requestType: $requestType.TEXT, $requestType.JSON, $requestType.XML
 * 		parameters: un string  formato URL o un objeto Hash
 * 		cache: true o false
 * 		messageLoading: define el id de un elemento que queremos usar como cartel de "Cargando"
 * 						mientras la petici�n se hace
 * 		onfinish: funci�n a ejecutarse cuando se reciban los datos.
 * 					Esta funci�n recibir� el texto, JSON o XML recibidos y e� id de la petici�n
 * 		onerror: funci�n a ejecutarse cuando se produzca un error.
 * 					Esta funci�n recibe un objeto con detalles del error y el id de la petici�n
 * 
*/
function $Ajax(url, options){
	//preguntamos si no quiere cach�
	if(__$P(options,"cache",true)==false){
		//agregamos un parametro random a la url
		//ponemos  ? o & segun la presencia de parametros anteriores
		var character ="?";
		if(url.indexOf("?")>0) character="&";
		url+=character+Math.random();
	}
	
	var myMethod = __$P(options, "method",$method.GET);
	var parameters = __$P(options,"parameters");
	
	//Genera un JSON de propiedades necesarias para Prototype
	//Despues de puede reemplazar por otra libreria
	var protoOpt = {
			method:myMethod,
			onSuccess: __$AjaxGet.bind(this, options),
			onException: __$AjaxError.bind(this,options),
			onFailure: __$AjaxError.bind(this,options)
	}
	//si se definieron los parametros los agregamos
	if(parameters!=undefined){
		protoOpt.parameters = parameters;
	}
	
	//Genera la nueva petici�n via prototype
	var request = new Ajax.Request(url, protoOpt);
	
	//Activa el aviso de cargando
	if(__$P(options,"messageLoading")!=undefined){
		__$AjaxLoading(options.messageLoading,true);
	}
}

/**
 * Funci�n interna que se encarga de recibir la petici�n lista desde prototype y ejecutar
 * el evento onFinish de la petici�n
*/
function __$AjaxGet(options, xhr){
	//Si se ejecuta este metodo estamos seguros que readyState==4 y status==200
	
	//Detenemos el mensage de cargando
	if(__$P(options,"messageLoading")!=undefined){
		__$AjaxLoading(options.messageLoading,false);			
	}
	
	//Llamamos a onfinish si fue definida
	var returnFunction = __$P(options,"onfinish");
	
	//Traemos el id de la peticion si fue definido
	var id = __$P(options, "id");
	
	if(returnFunction != undefined){
		//Si el usuario indico que quiere recibir la respuesta
		//TEXTO sera el tipo por deafult
		
		var requestType = __$P(options,"requestType",$requestType.TEXT);
		switch(requestType){
			case $requestType.TEXT: 
									returnFunction(xhr.responseText,id);
									break;
			case $requestType.XML:
									returnFunction(xhr.responseXML,id);
									break;
			case $requestType.JSON:
									//Intentamos evaluar el JSON por si no es valido
									var object;
									try{
										object = xhr.responseText.evalJSON();
									}catch(e){
										__$AjaxError(options, xhr, {code:-1,message:"JSON No V�lido"});
										return;
									}
									returnFunction(object,id);
		}
	}
}

/**
*Funci�n interna que se encarga de prender o apagar
* el cardel de cargando, si existiera
*/
function __$AjaxLoading(cartel, enabled){
	if(enabled){
		$(cartel).show();
	}else{
		$(cartel).hide();
	}
}


/**
 * Funci�n interna que se encarga de recibir la ejecuci�n
 * cuando se produzca un error en la petici�n desde prototype 
*/

function __$AjaxError(options, xhr, exception){
	//Apagamos el cartel de cargando si existiera
	if(__$P(options,"messageLoading")!=undefined){
		__$AjaxLoading(options.messageLoading, false);
	}
	
	//Cuando se trata de un error del servidor, no hay exception
	var errorFunction = __$P(options, "onerror");
	if(exception==undefined){
		errorFunction(exception, __$P(options,"id"));
	}
}

/**
* Funci�n interna que se encarga de entregar un parametro opcional
* desde una coleccion tipo JSON, con un valor por defecto
*/

function __$P(colection, param, def){
	
	if(colection==undefined){
		return def;
	}else{
		if(colection[param]==undefined){
			return def;
		}else{
			return colection[param];
		}
	}
}
