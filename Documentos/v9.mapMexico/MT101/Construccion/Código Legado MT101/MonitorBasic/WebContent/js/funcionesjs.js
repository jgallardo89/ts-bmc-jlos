
/********** Creando Objeto XMLHttpRequest *********/
 
function getXMLHttpRequest(){
	var req = false;
	
	try {
		req = new XMLHttpRequest();
	}catch(e){
		try{
		req = new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e){
			try{
			req = new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e){
				req = false;
			}
		}
	}
	return req;
}


function consultaLibro(){
	var req = getXMLHttpRequest();
	var divLibro = document.getElementById("divLibro");
	
	req.open("POST","SConsultaLibro",true);
	req.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	req.onreadystatechange = function(){
		if(req.readyState == 4){
			//alert(req.responseText);
			divLibro.innerHTML = req.responseText;
		}
	}
	var titulo = document.frmConsulta.titulo;
	
	var datos = "txtTitulo="+titulo.value;
	//alert(datos);
	req.send(datos);

}







