package com.bancomer.gis.monitorwebswift.vo;

import java.io.Serializable;

public class AltaDesbloqueoVo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long idUsuario;	
	private String usuario;
	private Usuario usuarioObj;
	
	private String pregunta1;
	private String respuesta1;
	private String confResp1;
	
	private String pregunta2;
	private String respuesta2;
	private String confResp2;
	
	private String pregunta3;
	private String respuesta3;
	private String confResp3;
	
	private boolean existeUsuario;
	private boolean existeDesbloqUsr;
	
	
	
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
	public boolean isExisteUsuario() {
		return existeUsuario;
	}
	public void setExisteUsuario(boolean existeUsuario) {
		this.existeUsuario = existeUsuario;
	}
	public boolean isExisteDesbloqUsr() {
		return existeDesbloqUsr;
	}
	public void setExisteDesbloqUsr(boolean existeDesbloqUsr) {
		this.existeDesbloqUsr = existeDesbloqUsr;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Usuario getUsuarioObj() {
		return usuarioObj;
	}
	public void setUsuarioObj(Usuario usuarioObj) {
		this.usuarioObj = usuarioObj;
	}
	

}
