package com.bancomer.gis.monitorwebswift.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import com.bancomer.gis.monitorwebswift.logic.AltaDesbloqueoService;
import com.bancomer.gis.monitorwebswift.vo.AltaDesbloqueoVo;
import com.icesoft.faces.context.effects.JavascriptContext;

public class CambioPasswordController {
	
	private AltaDesbloqueoVo desbloqueoVo = new AltaDesbloqueoVo();	
	
	private String usuario;
	
	private String pregunta1;
	
	private String respuesta1;
	
	private String confResp1;
	
	private String pregunta2;
	
	private String respuesta2;
	
	private String confResp2;
	
	private String pregunta3;
	
	private String respuesta3;
	
	private String confResp3;
	
	private String oldPassword;
	
	private String newPassword;
	
	private String confPassword;
	
	private int idUsuario;
	
	private boolean requerido = false;
	
	private boolean renderAutoDesbloqueo = true;
	
	private AltaDesbloqueoService altaDesbloqueoService;
	
	private boolean confirmarPreguntas = false;
	
	
	public String cambiarPassword(){
		altaDesbloqueoService.cambioPassword(idUsuario, newPassword, oldPassword);
		String javaScriptText = "alert('El Password de su usuario se ha modificado');  window.close();";
		JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
		return "success";
	}
	
	public String registrarServicio(){
		if (pregunta1.equals(pregunta2) || pregunta1.equals(pregunta3) ||
				pregunta3.equals(pregunta2)){
			confirmarPreguntas =  true;
		}
		else {
			desbloqueoVo.setUsuario(usuario.toUpperCase());
			desbloqueoVo.setConfResp1(confResp1.toUpperCase());
			desbloqueoVo.setConfResp2(confResp2.toUpperCase());
			desbloqueoVo.setConfResp3(confResp3.toUpperCase());
			desbloqueoVo.setPregunta1(pregunta1.toUpperCase());
			desbloqueoVo.setPregunta2(pregunta2.toUpperCase());
			desbloqueoVo.setPregunta3(pregunta3.toUpperCase());
			desbloqueoVo.setRespuesta1(respuesta1.toUpperCase());
			desbloqueoVo.setRespuesta2(respuesta2.toUpperCase());
			desbloqueoVo.setRespuesta3(respuesta3.toUpperCase());
			altaDesbloqueoService.altaDesbloqueo(desbloqueoVo);
			renderAutoDesbloqueo = false;
			requerido = true;
		}
		return "success";
	}
	
	public void limpiarDatos(ActionEvent event){
		usuario = "";
		confResp1 = "";
		confResp2 = "";
		confResp3 = "";
		respuesta1 = "";
		respuesta2 = "";
		respuesta3 = "";
		pregunta1 = "";
		pregunta2 = "";
		pregunta3 = "";
	}
	
	public void cerrarPantallaDesbloqueo(ActionEvent event){
		//no hace nada la pnatalla se cieera una vez que termine el proceso
		//de solicitud de desbloqueo
	}
	
	public void closePnlPreguntas(ActionEvent event) {
		confirmarPreguntas = false;
	}
	
	public void validarIdUsuario(FacesContext context, UIComponent validate, Object value){
		idUsuario = Integer.parseInt(((String) value));
	}	
	
	public void validarOldPassword(FacesContext context, UIComponent validate, Object value){
		oldPassword = (String)value;
		boolean oldPassValido = false;
		oldPassValido = altaDesbloqueoService.validarOldPassword(idUsuario, oldPassword);
		if(!oldPassValido){
			String strTextoError = "El password actual no es correcto";					
			throw new ValidatorException(new FacesMessage(strTextoError));
		}
	}
	
	public void validarNewPassword(FacesContext context, UIComponent validate, Object value){
		newPassword = ((String) value).toUpperCase();
		boolean passwordsIguales = false;
		passwordsIguales = altaDesbloqueoService.validarOldPassword(idUsuario, newPassword);
		if (newPassword.length() < 8){			
			String strTextoError = "El password debe ser al menos de 8 caracteres";
			throw new ValidatorException(new FacesMessage(strTextoError));
		}
		else if (passwordsIguales){			
			String strTextoError = "El password actual es identico al password nuevo," +
			" favor de escribir otra contraseña";
			throw new ValidatorException(new FacesMessage(strTextoError));
		}
		
	}
	
	public void validarConfPassword(FacesContext context, UIComponent validate, Object value){
		confPassword = ((String) value).toUpperCase();
		if (!confPassword.equals(newPassword)) {
			
			String strTextoError = "La confirmación del password no coincide con el nuevo password";
			throw new ValidatorException(new FacesMessage(strTextoError));
		}
		
	}
	
	public void validarUsuario(FacesContext context, UIComponent validate, Object value){
		usuario = ((String)value).toUpperCase();		
	}
	
	public void validarPreguntas(FacesContext context, UIComponent validate, Object value) {
    	String idComponente = validate.getId();
    	//validaciones  = validaciones + 1;
    	if (idComponente.equals("pregunta1Txt")){
    		pregunta1 = ((String)value).toUpperCase();
//    		if (pregunta1.equals(pregunta2) || pregunta1.equals(pregunta3)){
//    			String strTextoError = "Ya existe esta pregunta, favor de cambiarla";
//                throw new ValidatorException(new FacesMessage(strTextoError));
//    		}
    	}
    	
    	if (idComponente.equals("pregunta2Txt")){
    		pregunta2 = ((String)value).toUpperCase();
//    		if (pregunta2.equals(pregunta1) || pregunta2.equals(pregunta3)){
//    			String strTextoError = "Ya existe esta pregunta, favor de cambiarla";
//                throw new ValidatorException(new FacesMessage(strTextoError));
//    		}
    	}
    	
    	if (idComponente.equals("pregunta3Txt")){
    		pregunta3 = ((String)value).toUpperCase();
//    		if (pregunta3.equals(pregunta1) || pregunta3.equals(pregunta2)){
//    			String strTextoError = "Ya existe esta pregunta, favor de cambiarla";
//                throw new ValidatorException(new FacesMessage(strTextoError));
//    		}
    	}
//    	if (validaciones > 1){
//    		validaciones = 0;
//    		if (pregunta1.equals(pregunta2) || pregunta1.equals(pregunta3) ||
//    				pregunta3.equals(pregunta2)){
//    			String strTextoError = "Ya existe esta pregunta, favor de cambiarla";
//                throw new ValidatorException(new FacesMessage(strTextoError));
//    		}
//    	}
//    	if (pregunta1.equals(pregunta2) || pregunta1.equals(pregunta3) ||
//				pregunta3.equals(pregunta2)){
//			confirmarPreguntas =  true;
//		}
    	
    }
	
	
	
	public void validarRespuesta1(FacesContext context, UIComponent validate, Object value) {
		respuesta1 = ((String) value).toUpperCase();
		if (respuesta1.equals("")) {
			
			String strTextoError = "Favor de capturar la respuesta 1";					
            throw new ValidatorException(new FacesMessage(strTextoError));
		}
		
	}
	
	public void validarRespuesta2(FacesContext context, UIComponent validate, Object value) {
		respuesta2 = ((String) value).toUpperCase();
		if (respuesta2.equals("")) {
			
			String strTextoError = "Favor de capturar la respuesta 2";					
            throw new ValidatorException(new FacesMessage(strTextoError));            
		}
		
	}
	
	public void validarRespuesta3(FacesContext context, UIComponent validate, Object value) {
		respuesta3 = ((String) value).toUpperCase();
		if (respuesta3.equals("")) {
			
			String strTextoError = "Favor de capturar la respuesta 3";					
            throw new ValidatorException(new FacesMessage(strTextoError));
		}
		
	}
	
	public void validarconfRespuesta1(FacesContext context, UIComponent validate, Object value) {
		confResp1 = ((String) value).toUpperCase();
		if (confResp1.equals("")) {
			
			String strTextoError = "Favor de capturar la confirmación a respuesta 1";					
            throw new ValidatorException(new FacesMessage(strTextoError));
		}
		else if(!confResp1.equals(respuesta1)) {
			
			String strTextoError = "Confirmacion de respuesta 1 no coincide con respuesta 1";
            throw new ValidatorException(new FacesMessage(strTextoError));
		}
		
	}
	
	public void validarconfRespuesta2(FacesContext context, UIComponent validate, Object value) {
		confResp2 = ((String) value).toUpperCase();
		if (confResp2.equals("")) {
			
			String strTextoError = "Favor de capturar la confirmación a respuesta 2";					
            throw new ValidatorException(new FacesMessage(strTextoError));
		}
		else if(!confResp2.equals(respuesta2)) {
			
			String strTextoError = "Confirmación de respuesta 2 no coincide con respuesta 2";
            throw new ValidatorException(new FacesMessage(strTextoError));
		}
		
	}
	public void validarconfRespuesta3(FacesContext context, UIComponent validate, Object value) {
		confResp3 = ((String) value).toUpperCase();
		if (confResp3.equals("")) {
			
			String strTextoError = "Favor de capturar la confirmación a respuesta 3";					
            throw new ValidatorException(new FacesMessage(strTextoError));
		}
		else if(!confResp3.equals(respuesta3)) {
			
			String strTextoError = "Confirmación de respuesta 3 no coincide con respuesta 3";
            throw new ValidatorException(new FacesMessage(strTextoError));
		}
		
	}
	
	
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfPassword() {
		return confPassword;
	}
	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}
	public AltaDesbloqueoService getAltaDesbloqueoService() {
		return altaDesbloqueoService;
	}
	public void setAltaDesbloqueoService(AltaDesbloqueoService altaDesbloqueoService) {
		this.altaDesbloqueoService = altaDesbloqueoService;
	}
	public boolean isRenderAutoDesbloqueo() {
		return renderAutoDesbloqueo;
	}
	public void setRenderAutoDesbloqueo(boolean renderAutoDesbloqueo) {
		this.renderAutoDesbloqueo = renderAutoDesbloqueo;
	}
	public AltaDesbloqueoVo getDesbloqueoVo() {
		return desbloqueoVo;
	}
	public void setDesbloqueoVo(AltaDesbloqueoVo desbloqueoVo) {
		this.desbloqueoVo = desbloqueoVo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPregunta1() {
		return pregunta1;
	}

	public void setPregunta1(String pregunta1) {
		this.pregunta1 = pregunta1;
	}

	public String getRespuesta1() {
		return respuesta1;
	}

	public void setRespuesta1(String respuesta1) {
		this.respuesta1 = respuesta1;
	}

	public String getConfResp1() {
		return confResp1;
	}

	public void setConfResp1(String confResp1) {
		this.confResp1 = confResp1;
	}

	public String getPregunta2() {
		return pregunta2;
	}

	public void setPregunta2(String pregunta2) {
		this.pregunta2 = pregunta2;
	}

	public String getRespuesta2() {
		return respuesta2;
	}

	public void setRespuesta2(String respuesta2) {
		this.respuesta2 = respuesta2;
	}

	public String getConfResp2() {
		return confResp2;
	}

	public void setConfResp2(String confResp2) {
		this.confResp2 = confResp2;
	}

	public String getPregunta3() {
		return pregunta3;
	}

	public void setPregunta3(String pregunta3) {
		this.pregunta3 = pregunta3;
	}

	public String getRespuesta3() {
		return respuesta3;
	}

	public void setRespuesta3(String respuesta3) {
		this.respuesta3 = respuesta3;
	}

	public String getConfResp3() {
		return confResp3;
	}

	public void setConfResp3(String confResp3) {
		this.confResp3 = confResp3;
	}

	public boolean isRequerido() {
		return requerido;
	}

	public void setRequerido(boolean requerido) {
		this.requerido = requerido;
	}

	public boolean isConfirmarPreguntas() {
		return confirmarPreguntas;
	}

	public void setConfirmarPreguntas(boolean confirmarPreguntas) {
		this.confirmarPreguntas = confirmarPreguntas;
	}

}
