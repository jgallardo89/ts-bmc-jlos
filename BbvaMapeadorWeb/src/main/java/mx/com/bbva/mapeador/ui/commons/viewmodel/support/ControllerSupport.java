/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Informacion Confidencial:
 * Este software contiene informacion totalmente confidencial propiedad de Grupo Financiero BBVA Bancomer. 
 * Queda totalmente prohibido su uso o divulgacion en forma parcial o total y solamente podra ser utilizada de acuerdo a los terminos y estatutos 
 * que determine el Grupo Financiero BBVA Bancomer.
 * 
 * Todos los derechos reservados, Mexico 2013.
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * DESCRIPCION DEL PROGRAMA
 * Nombre de aplicación: MAPEADOR
 * Nombre de proyecto: BbvaMapeadorWeb
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * HISTORIAL DE CAMBIOS:
 * 
 * Fecha:									         	
 * 30-ABR-2013  
 * @Author:	Jose Luis Ortiz Salazar
 * @Email: jortizsalazar@gmail.com    	
 * Razon: Creacion        
 * Version: 1.0.0
 * Nombre de clase: ControllerSupport.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.support
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
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
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;

// TODO: Auto-generated Javadoc
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
/**
 * The Class ControllerSupport.
 */
public class ControllerSupport extends SelectorComposer<Component> implements ISecurityController{	

	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	/** The Constant logger. */
	private static final org.apache.log4j.Logger 	logger			 = Logger.getLogger( ControllerSupport.class );
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6876680585065352357L;	
	
	/** The identificador pantalla. */
	private int identificadorPantalla;
	
	/** The invoker. */
	@Autowired
	BbvaICommandInvoker invoker;
	
	

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.security.session.controller.ISecurityController#applyPermission(int, java.util.HashMap)
	 */
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
		HashMap<String, Boolean> permisos = perfilBO.readCommand(perfilDTO).getControlPermisoVOs();
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

	/**
	 * Gets the identificador pantalla.
	 *
	 * @return the identificadorPantalla
	 */
	public final int getIdentificadorPantalla() {
		return identificadorPantalla;
	}

	/**
	 * Gets the invoker.
	 *
	 * @return the invoker
	 */
	public BbvaICommandInvoker getInvoker() {
		return invoker;
	}
	
	/**
	 * Gets the session user.
	 *
	 * @return the session user
	 */
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
	
	/**
	 * Registra evento.
	 *
	 * @param dto the dto
	 * @param nombreBitacora the nombre bitacora
	 * @param idEventoMapeador the id evento mapeador
	 */
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
	 * Sets the identificador pantalla.
	 *
	 * @param identificadorPantalla the identificadorPantalla to set
	 */
	public final void setIdentificadorPantalla(int identificadorPantalla) {
		this.identificadorPantalla = identificadorPantalla;
	}	
	
	/**
	 * Sets the invoker.
	 *
	 * @param invoker the invoker to set
	 */
	public void setInvoker(BbvaICommandInvoker invoker) {
		this.invoker = invoker;
	}
	
	
	
	
		
}
