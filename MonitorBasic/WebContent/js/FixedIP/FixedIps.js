var fxMonitorWebswift_ManualUsuario="http://150.250.250.150:60150/manuales-usuario/Manual_de_Usuario_de_Operacion_Monitor_GMM.pdf";
var fxInformacion_Presentacion="http://150.250.250.150:60150/otros/Servicio_SWIFTusuariosv2.pdf";


//--check for the replace in the file for production
var fxPswOperacion_Proc="http://150.250.250.150:60111/UtilMonitorWebSwift/MX_MT940_ProcManual.jsp?UsuarioWeb=";
var fxPswOperacion_ReProc="http://150.250.250.150:60111/UtilMonitorWebSwift/MX_MT940_Reproceso.jsp?UsuarioWeb=";
//END chk
var fxArchivosCntoServerH2H_VerArchivo="http://alabra5gint5/webccr/archivos/CLIENTE_SWIFT_MX/";
var fxH2HMonitoreo_VerArchivo="http://1alabra5gint5/webccr/archivos/CLIENTE_SWIFT_MX/";
var fxGenIp="http://alabra5gint5/webccr/archivos/CLIENTE-SWIFT/";
var fxGenIp2="http://alabra5gint5/webccr/archivos/CLIENTE_SWIFT_MX/";
var fxCancelAntMt101_DownLink="http://alabra5gint5/webccr/archivos/MT101-SICOCOS/";
var fxAtencionJSPDIr="\\150.100.160.36\logs\iconotelefonos.xls";

function openFixedURL(uri,target){
	window.open(uri,target);
}
function redirecToFixedURL(uri){
	window.location=uri;
}
function openFile(uri){
	openFixedURL(uri,'_blank');
}
function getVarValue(val){
	return val;
}