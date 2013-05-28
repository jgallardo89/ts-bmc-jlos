package mx.com.bbva.mapeador.ui.commons.viewmodel.support;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import mx.com.bbva.bancomer.bitacora.dto.BitacoraDTO;
import mx.com.bbva.bancomer.bussinnes.model.vo.BitacoraVO;
import mx.com.bbva.bancomer.commons.command.BbvaICommandInvoker;
import mx.com.bbva.bancomer.mapper.business.BitacoraBO;
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
public class ControllerSupport extends SelectorComposer<Component>{	

	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	private static final org.apache.log4j.Logger 	logger			 = Logger.getLogger( ControllerSupport.class );
	private static final long serialVersionUID = -6876680585065352357L;
	
	@Autowired
	BbvaICommandInvoker invoker;
	
	public SessionUser getSessionUser(){
		logger.debug( "Entrada getSessionUser          -- OK" );		
		String cveUsuario = null;
		Map<String, Object> sessionValues = (HashMap<String, Object>)this.getPage().getDesktop().getSession().getAttribute("sessionValues");
		if(sessionValues==null && sessionValues.get("iv-user")==null){
			cveUsuario = "prueba desarrollo";
		}else{
			cveUsuario = sessionValues.get("iv-user").toString();
		}
		logger.debug( "Datos de usuario -- " + cveUsuario);
		SessionUser sessionUser = new SessionUser();
		sessionUser.setCveUsuario(cveUsuario);
		logger.debug( "Salida getSessionUser          -- OK" );
		return sessionUser;
	}
	
	public void registraEvento(BitacoraDTO dto, String nombreBitacora, int idEventoMapeador){
		BitacoraVO bitacoraVO= new BitacoraVO();
		BitacoraBO bo = new BitacoraBO();
		bitacoraVO.setIdUsuario(1);
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
}
