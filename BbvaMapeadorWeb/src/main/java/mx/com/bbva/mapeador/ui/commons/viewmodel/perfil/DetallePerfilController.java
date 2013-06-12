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
 * Nombre de clase: DetallePerfilController.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.perfil
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.perfil;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ComponenteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PerfilVO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.componente.dto.ComponenteDTO;
import mx.com.bbva.bancomer.mapper.business.ComponenteBO;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

import org.apache.log4j.Logger;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;

// TODO: Auto-generated Javadoc
/**
 * The Class DetallePerfilController.
 */
public class DetallePerfilController extends ControllerSupport implements  IController{

	/** The Constant logger. */
	private static final Logger logger = Logger
			.getLogger(DetallePerfilController.class);

	/** The componente dto. */
	private ComponenteDTO componenteDTO = (ComponenteDTO)this.read();
	
	/** The componente v os. */
	private List<ComponenteVO> componenteVOs = this.componenteDTO.getComponentePantallaPerfilAllVOs();
	
	/** The detalle perfil windows. */
	@Wire
	Window detallePerfilWindows;
	
	/** The str descripcion perfil. */
	private String strDescripcionPerfil =  this.getStrDescripcionPerfil();
	
	/** The str estatus perfil. */
	private String strEstatusPerfil = this.getStrEstatusPerfil();
	
	/** The str nombre perfil. */
	private String strNombrePerfil = this.getStrNombrePerfil();

	/**
	 * After compose.
	 *
	 * @param view the view
	 */
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);                
    }

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#applyPermision()
	 */
	@Override
	public boolean applyPermision() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#clean()
	 */
	@Override
	public void clean() {
		// TODO Auto-generated method stub
		
	}	
	
	/**
	 * Close.
	 */
	@Command
	public void close() {
		logger.debug("cerrando ventana");
		detallePerfilWindows.detach();
    }

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#delete()
	 */
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Gets the componente dto.
	 *
	 * @return the componenteDTO
	 */
	public final ComponenteDTO getComponenteDTO() {
		return componenteDTO;
	}

	/**
	 * Gets the componente v os.
	 *
	 * @return the componenteVOs
	 */
	public final List<ComponenteVO> getComponenteVOs() {
		return componenteVOs;
	}

	/**
	 * Gets the str descripcion perfil.
	 *
	 * @return the strDescripcionPerfil
	 */
	public final String getStrDescripcionPerfil() {
		return strDescripcionPerfil;
	}

	/**
	 * Gets the str estatus perfil.
	 *
	 * @return the strEstatusPerfil
	 */
	public final String getStrEstatusPerfil() {
		return strEstatusPerfil;
	}

	/**
	 * Gets the str nombre perfil.
	 *
	 * @return the strNombrePerfil
	 */
	public final String getStrNombrePerfil() {
		return strNombrePerfil;
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read()
	 */
	@Override
	public Object read() {
		ComponenteDTO componenteDTO = new ComponenteDTO();
		if (Executions.getCurrent() != null) {
			PerfilVO perfilVO = (PerfilVO)Executions.getCurrent().getArg().get("perfilVO");
			this.strNombrePerfil = perfilVO.getNombrebPerfil();
			this.strDescripcionPerfil = perfilVO.getDescripcionPerfil();
			this.strEstatusPerfil = perfilVO.getDescipcionEstatus();
			logger.debug(perfilVO.toString());
			ComponenteBO componenteBO = new ComponenteBO();			
			ComponenteVO componenteVO = new ComponenteVO();
			componenteVO.setIdPerfil(perfilVO.getIdPerfil());
			componenteDTO.setCommandId(CommandConstants.COMPONENTE_PANTALLA_REFERENCE_PERFIL);
			componenteDTO.setComponenteVO(componenteVO);
			componenteDTO = componenteBO.readCommand(componenteDTO);
		}		
		return componenteDTO;
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read(java.lang.Object)
	 */
	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#save()
	 */
	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Sets the componente dto.
	 *
	 * @param componenteDTO the componenteDTO to set
	 */
	public final void setComponenteDTO(ComponenteDTO componenteDTO) {
		this.componenteDTO = componenteDTO;
	}

	/**
	 * Sets the componente v os.
	 *
	 * @param componenteVOs the componenteVOs to set
	 */
	public final void setComponenteVOs(List<ComponenteVO> componenteVOs) {
		this.componenteVOs = componenteVOs;
	}

	/**
	 * Sets the str descripcion perfil.
	 *
	 * @param strDescripcionPerfil the strDescripcionPerfil to set
	 */
	public final void setStrDescripcionPerfil(String strDescripcionPerfil) {
		this.strDescripcionPerfil = strDescripcionPerfil;
	}
	
	/**
	 * Sets the str estatus perfil.
	 *
	 * @param strEstatusPerfil the strEstatusPerfil to set
	 */
	public final void setStrEstatusPerfil(String strEstatusPerfil) {
		this.strEstatusPerfil = strEstatusPerfil;
	}
	
	/**
	 * Sets the str nombre perfil.
	 *
	 * @param strNombrePerfil the strNombrePerfil to set
	 */
	public final void setStrNombrePerfil(String strNombrePerfil) {
		this.strNombrePerfil = strNombrePerfil;
	}
}
