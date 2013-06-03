package mx.com.bbva.mapeador.ui.commons.viewmodel.support;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import mx.com.bbva.bancomer.bitacora.dto.BitacoraDTO;
import mx.com.bbva.bancomer.bussinnes.model.vo.BitacoraVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ControlPermisoVO;
import mx.com.bbva.bancomer.commons.command.BbvaICommandInvoker;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.mapper.business.BitacoraBO;
import mx.com.bbva.bancomer.mapper.business.PerfilBO;
import mx.com.bbva.bancomer.perfil.dto.PerfilDTO;
import mx.com.bbva.mapeador.security.session.controller.ISecurityController;
import mx.com.bbva.mapeador.security.session.user.SessionUser;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Informacion Confidencial:
 * Este software contiene informacion totalmente confidencial propiedad de Grupo Financiero BBVA Bancomer. 
 * Queda totalmente prohibido su uso o divulgacion en forma parcial o total y solamente podra ser utilizada de acuerdo a los terminos y estatutos 
 * que determine el Grupo Financiero BBVA Bancomer.
 * 
 * Todos los derechos reservados, Mexico 2013.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * DESCRIPCION DEL PROGRAMA:
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * HISTORIAL DE CAMBIOS:
 * 
 * Fecha:		Por:							Razon:         	Version
 * 01-MAY-2013  José Luis Ortiz					Creacion        1.0.0
 *              femmanuel.chavarriao@gmail.com
 *              Consultoria
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
public class ControllerSupport extends SelectorComposer<Component> implements ISecurityController{	

	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	private static final org.apache.log4j.Logger 	logger			 = Logger.getLogger( ControllerSupport.class );
	private static final long serialVersionUID = -6876680585065352357L;	
	
	@Autowired
	BbvaICommandInvoker invoker;
	
	private int identificadorPantalla;
	
	

	/**
	 * @return the identificadorPantalla
	 */
	public final int getIdentificadorPantalla() {
		return identificadorPantalla;
	}

	/**
	 * @param identificadorPantalla the identificadorPantalla to set
	 */
	public final void setIdentificadorPantalla(int identificadorPantalla) {
		this.identificadorPantalla = identificadorPantalla;
	}

	public SessionUser getSessionUser(){
		logger.debug( "Entrada getSessionUser          -- OK" );		
		String cveUsuario = null;
		int idPerfil = 0;
		int idUsuario = 0;
		Map<String, Object> sessionValues = (HashMap<String, Object>)this.getPage().getDesktop().getSession().getAttribute("sessionValues");
		if(sessionValues==null || sessionValues.get("iv-user")==null){
			cveUsuario = "prueba desarrollo";
		}else{
			cveUsuario = sessionValues.get("iv-user").toString();
			logger.debug(sessionValues.get("iv-user"));
			logger.debug(sessionValues.get("id-perfil"));
			idPerfil = Integer.parseInt(sessionValues.get("id-perfil").toString());
			idUsuario = Integer.parseInt(sessionValues.get("id-usuario").toString());
		}
		logger.debug( "Datos de usuario -- " + cveUsuario);
		SessionUser sessionUser = new SessionUser();
		sessionUser.setCveUsuario(cveUsuario);
		sessionUser.setIdUsuario(idUsuario);
		sessionUser.setIdPerfil(idPerfil);
		logger.debug( "Salida getSessionUser          -- OK" );
		return sessionUser;
	}
	
	public void registraEvento(BitacoraDTO dto, String nombreBitacora, int idEventoMapeador){
		BitacoraVO bitacoraVO= new BitacoraVO();
		BitacoraBO bo = new BitacoraBO();
		bitacoraVO.setNombreUsuario(this.getSessionUser().getCveUsuario());
		bitacoraVO.setIdUsuario(this.getSessionUser().getIdUsuario());
		bitacoraVO.setNombreBitacora(nombreBitacora);
		bitacoraVO.setFechaBitacora(new Date());
		bitacoraVO.setIdEventoMapeador(idEventoMapeador);
		dto.setBitacoraVO(bitacoraVO);
		bo.createCommand(dto);
	}
	/**
	 * @return the invoker
	 */
	public BbvaICommandInvoker getInvoker() {
		return invoker;
	}

	/**
	 * @param invoker the invoker to set
	 */
	public void setInvoker(BbvaICommandInvoker invoker) {
		this.invoker = invoker;
	}	
	@Override
	public boolean applyPermission(int idPantalla, HashMap<String, Component> componentes) {
		logger.debug("Ingresando a aplicar permisos");
		SessionUser sessionUser = this.getSessionUser();
		logger.debug("Aplicando permisos para cveUsuario:"+sessionUser.getCveUsuario());
		logger.debug("Aplicando permisos para idUsuario:"+sessionUser.getIdUsuario());
		logger.debug("Aplicando permisos para idPerfil:"+sessionUser.getIdPerfil());
		Iterator<Component> it = componentes.values().iterator();
		PerfilDTO perfilDTO = new PerfilDTO();
		ControlPermisoVO controlPermisoVO = new ControlPermisoVO();
		controlPermisoVO.setIdPerfil(sessionUser.getIdPerfil());
		controlPermisoVO.setIdPantalla(idPantalla);
		controlPermisoVO.setIdUsuario(sessionUser.getIdUsuario());
		
		perfilDTO.setControlPermisoVO(controlPermisoVO);
		perfilDTO.setCommandId(CommandConstants.PERFIL_COMMAND_READ_PERMISSION);
		PerfilBO perfilBO = new PerfilBO();
		HashMap<String, Boolean> permisos = (HashMap<String, Boolean>)perfilBO.readCommand(perfilDTO).getControlPermisoVOs();
		Boolean permiso;
		String idComponente;
		Component component;
		while (it.hasNext()) {			
			component = it.next();
			idComponente = component.getId();
			logger.debug("Component id:"+idComponente);
		    if(permisos.containsKey(idComponente)){
		    	permiso = permisos.get(idComponente);  
		    	component.setVisible(new Boolean(permiso).booleanValue());
		    }
		}
		return true;
	}
	
	
	
	
		
}
