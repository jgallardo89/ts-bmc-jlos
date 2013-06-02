package mx.com.bbva.mapeador.ui.commons.viewmodel.perfil;

import java.util.List;

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

import mx.com.bbva.bancomer.bussinnes.model.vo.ComponenteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PerfilVO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.componente.dto.ComponenteDTO;
import mx.com.bbva.bancomer.mapper.business.ComponenteBO;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

public class DetallePerfilController extends ControllerSupport implements  IController{

	private static final Logger logger = Logger
			.getLogger(DetallePerfilController.class);

	private ComponenteDTO componenteDTO = (ComponenteDTO)this.read();
	private List<ComponenteVO> componenteVOs = this.componenteDTO.getComponentePantallaPerfilAllVOs();
	private String strNombrePerfil = this.getStrNombrePerfil();
	private String strDescripcionPerfil =  this.getStrDescripcionPerfil();
	private String strEstatusPerfil = this.getStrEstatusPerfil();
	/**
	 * @return the strDescripcionPerfil
	 */
	public final String getStrDescripcionPerfil() {
		return strDescripcionPerfil;
	}

	/**
	 * @param strDescripcionPerfil the strDescripcionPerfil to set
	 */
	public final void setStrDescripcionPerfil(String strDescripcionPerfil) {
		this.strDescripcionPerfil = strDescripcionPerfil;
	}

	/**
	 * @return the strEstatusPerfil
	 */
	public final String getStrEstatusPerfil() {
		return strEstatusPerfil;
	}

	/**
	 * @param strEstatusPerfil the strEstatusPerfil to set
	 */
	public final void setStrEstatusPerfil(String strEstatusPerfil) {
		this.strEstatusPerfil = strEstatusPerfil;
	}	
	/**
	 * @return the strNombrePerfil
	 */
	public final String getStrNombrePerfil() {
		return strNombrePerfil;
	}

	/**
	 * @param strNombrePerfil the strNombrePerfil to set
	 */
	public final void setStrNombrePerfil(String strNombrePerfil) {
		this.strNombrePerfil = strNombrePerfil;
	}

	/**
	 * @return the componenteDTO
	 */
	public final ComponenteDTO getComponenteDTO() {
		return componenteDTO;
	}

	/**
	 * @param componenteDTO the componenteDTO to set
	 */
	public final void setComponenteDTO(ComponenteDTO componenteDTO) {
		this.componenteDTO = componenteDTO;
	}

	/**
	 * @return the componenteVOs
	 */
	public final List<ComponenteVO> getComponenteVOs() {
		return componenteVOs;
	}

	/**
	 * @param componenteVOs the componenteVOs to set
	 */
	public final void setComponenteVOs(List<ComponenteVO> componenteVOs) {
		this.componenteVOs = componenteVOs;
	}

	@Wire
	Window detallePerfilWindows;
	
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

	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean applyPermision() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Command
	public void close() {
		logger.debug("cerrando ventana");
		detallePerfilWindows.detach();
    }
	
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);                
    }
}
