function Guardar() {
	document.forms[0].method.value = "guardarCuentaAsociada";
	
	var flagCO=document.forms[0].flagCO.value;
	var digitoChequeo="00";
	
	if(flagCO==0){
		digitoChequeo=document.forms[0].digitoChequeo.value;	
	}
	
	
	var idCuentaAsociada = document.forms[0].idCuentaAsociada.value;
	//es una actualizacion de datos de una cuenta existente
	
	if(idCuentaAsociada !=  null && idCuentaAsociada!= '')
	{
    	//alert('chkCuenta' + idCuentaAsociada);
    	//alert(document.forms[0].chkCuenta' + idCuentaAsociada).checked);
		document.forms[0].cuentaActiva.value = document.forms[0].chkCuenta+ idCuentaAsociada.checked;
        if (confirm("¿Desea actualizar los datos de la cuenta?")) {
            document.forms[0].submit();
        }
        /*abrir('jsp/catalogos/cliente-SWIFT/cuentaAsociadaGuardar.jsp?idCuentaAsociada=' +
                document.forms[0].idCuentaAsociada.value +'cuentaAso='+ document.forms[0].bancoInterno.value + document.forms[0].oficina.value +
                document.forms[0].digitoChequeo.value + document.forms[0].cuentaAso.value +'&referencia='+ document.forms[0].referencia.value,
                0, 0, 0, 0, 0, 0, 0, 500, 120, 100, 100, 1);*/
    }
    //es una insercion normal de datos
    
    if(idCuentaAsociada ==  null || idCuentaAsociada== '') {
    	document.forms[0].cuentaActiva.value = 1;
    	document.forms[0].idCuentaAsociada.value = 0;
         if(confirm("¿Desea guardar la cuenta: " + document.forms[0].bancoInterno.value + document.forms[0].oficina.value +
        		 digitoChequeo + document.forms[0].cuenta.value + " para la referencia " +  document.forms[0].referencia.value)){
        	   document.forms[0].submit();
         }   
    }
    
}

function regresar() {
    document.forms[1].method.value = "load";    
    document.forms[1].submit();
}

function desactivar(){
	
	var flagCO=document.forms[0].flagCO.value;
	var digitoChequeo="00";
	if(flagCO==0){
		digitoChequeo=document.forms[0].digitoChequeo.value;	
	}
	
	if(confirm("Esta seguro que desea desactivar la cuenta: " + document.forms[0].bancoInterno.value + document.forms[0].oficina.value +
			digitoChequeo + document.forms[0].cuenta.value + " de la referencia " +  document.forms[0].referencia.value)){
		document.forms[0].method.value = "desactivarCuentaAsociada";
		document.forms[0].submit();
	}
}

function activar(){
	
	var flagCO=document.forms[0].flagCO.value;
	var digitoChequeo="00";
	
	if(flagCO==0){
		digitoChequeo=document.forms[0].digitoChequeo.value;	
	}
	
    if(confirm("Esta seguro que desea activar la cuenta: " + document.forms[0].bancoInterno.value + document.forms[0].oficina.value +
    		digitoChequeo + document.forms[0].cuenta.value + " de la referencia " +  document.forms[0].referencia.value)){
        document.forms[0].method.value = "activarCuentaAsociada";
        document.forms[0].submit();
    }
}

function eliminar(){
	
	var flagCO=document.forms[0].flagCO.value;
	var digitoChequeo="00";
	
	if(flagCO==0){
		digitoChequeo=document.forms[0].digitoChequeo.value;	
	}
	
	
	if(confirm("Esta seguro que desea eliminar permanentemente la cuenta: " + document.forms[0].bancoInterno.value + document.forms[0].oficina.value +
			digitoChequeo + document.forms[0].cuenta.value + " de la referencia " +  document.forms[0].referencia.value)){
	    document.forms[0].method.value = "eliminarCuentaAsociada";
	    document.forms[0].submit();
	}
}

function limpiaForm(){
	document.forms[0].btnEliminar.disabled = true;
	document.forms[0].btnDesactivar.disabled = true;
	document.forms[0].btnActivar.disabled = true;
	document.forms[0].btnGuardar.disabled = true;
	document.forms[0].idCuentaAsociada.value = '';
	document.forms[0].reset();
}

/*Funcion para validar las posiciones*/
function validaPosicion(campo){
	
	var valorCampo 	= campo.value;
	
	var valorCampoPos3;
	var valorCampoPos4;
	var idCampo		= campo.id;
	var valorCampoFinal = '';
	if( valorCampo!='' && valorCampo!='0')
	{
		
		valorCampoPos3=valorCampo.substring(2,3);
		valorCampoPos4=valorCampo.substring(3,4);
		
		if(valorCampoPos3>0)
		{
			alert("La posicion 3 de la cuenta debe ser cero");
			document.forms[0].btnGuardar.disabled = true;
			return false;
		}else{
			rellenaCeros(campo,10);
			activaBotones();
		}	
		if(valorCampoPos4>0)
		{
			alert("La posicion 4 de la cuenta debe ser cero");
			document.forms[0].btnGuardar.disabled = true;
			return false;
		}else{
			rellenaCeros(campo,10);
			activaBotones();
		}
		
	}
}


function activaBotones(){
	
    var activarBol = true;
    
    var flagCO=document.forms[0].flagCO.value;
    
    
    
    if(document.forms[0].bicbei.value == '' || document.forms[0].bicbei.value.length < 11 || validateZeros(document.forms[0].bicbei.value)){
        activarBol = false;
    }
    
    if(document.forms[0].bancoInterno.value == '' || validateZeros(document.forms[0].bancoInterno.value)){
        activarBol = false;
    }   
    
    
    if(document.forms[0].oficina.value == '' || validateZeros(document.forms[0].oficina.value)){
        activarBol = false;
    }
    
	if(flagCO==0)
	{
		if(document.forms[0].digitoChequeo.value == '' || validateZeros(document.forms[0].digitoChequeo.value))
    	{
    		activarBol = false;
    	}
    }
    if(document.forms[0].cuenta.value == '' || validateZeros(document.forms[0].cuenta.value)){
        activarBol = false;
    }

    if(activarBol){        
        document.forms[0].btnGuardar.disabled = false;
        if(document.forms[0].idCuentaAsociada.value !=null && document.forms[0].idCuentaAsociada.value != '')
        {
            //document.forms[0].btnEliminar.disabled = false;
            //document.forms[0].btnDesactivar.disabled = false;
        }
        
    }else{
        document.forms[0].btnGuardar.disabled = true;
        if(document.forms[0].idCuentaAsociada.value ==null || document.forms[0].idCuentaAsociada.value == ''){
        	document.forms[0].btnEliminar.disabled = true;
            document.forms[0].btnDesactivar.disabled = true;
        }
        
    }
}

function muestraMensaje(mensaje) {
	alert(mensaje);
}

//Nueva funcion para invocar la configuracion del formato MT101

function agregarFormato()
{
	document.forms[2].method.value = "consultarRutasFormato";
	document.forms[2].submit();
}
