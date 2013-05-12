package mx.com.bbva.mapeador.ui.commons.viewmodel.perfil;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PantallaVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PerfilVO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.estatusobjeto.dto.UsuarioDTO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.PantallaBO;
import mx.com.bbva.bancomer.mapper.business.PerfilBO;
import mx.com.bbva.bancomer.estatusobjeto.dto.PerfilDTO;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.perfil.PerfilController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

import org.apache.log4j.Logger;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Textbox;

public class PerfilController extends ControllerSupport implements  IController{

	private static final Logger logger = Logger
			.getLogger(PerfilController.class);
	
	private int cantidadRegistros;
	
	@Wire
	Listbox componentesPantalla;
	
	@Wire
	Listbox componentesPerfil;
	
	@Wire
	private Textbox descripcionPerfil;

	@Wire
	private Textbox nombrePerfil;
	
	@Wire
	private Combobox status;
	
	private String strDescripcionPerfil;
	
	private String strNombrePerfil;		
	
	private String strPantalla;
	
	private String strStatus;
	
	private PerfilDTO perfilDTO = (PerfilDTO)this.read(); 

	/**
	 * @return the perfilDTO
	 */
	public final PerfilDTO getPerfilDTO() {
		return perfilDTO;
	}

	/**
	 * @param perfilDTO the perfilDTO to set
	 */
	public final void setPerfilDTO(PerfilDTO perfilDTO) {
		this.perfilDTO = perfilDTO;
	}

	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
    }

	@Override
	public void clean() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	public int getCantidadRegistros() {
		return cantidadRegistros;
	}

	public String getStrDescripcionPerfil() {
		return strDescripcionPerfil;
	}

	public String getStrNombrePerfil() {
		return strNombrePerfil;
	}

	public String getStrPantalla() {
		return strPantalla;
	}

	public String getStrStatus() {
		return strStatus;
	}

	@Override
	public Object read() {
		
		PerfilDTO perfilDTO = new PerfilDTO();
		perfilDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
		PerfilVO perfilVO = new PerfilVO();
		logger.debug("*estatusObjetoVO*");
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
		estatusObjetoVO.setNombreTabla(CommandConstants.NOMBRE_TABLA_PERFIL);		
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
		estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
		estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);
		logger.debug("*pantallaVO*");
		PantallaVO pantallaVO = new PantallaVO();
		PantallaBO pantallaBO = new PantallaBO();
		estatusObjetoDTO.setPantallaVO(pantallaVO);
		estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);	
		List<PantallaVO> pantallaVOs = pantallaBO.readCommand(estatusObjetoDTO).getPantallaVOs();
		estatusObjetoDTO.setPantallaVOs(pantallaVOs);
		estatusObjetoDTO.toString(BbvaAbstractDataTransferObject.XML);
		PerfilBO perfilBO = new PerfilBO();
		perfilDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
		perfilDTO.setPantallaVOs(estatusObjetoDTO.getPantallaVOs());
		perfilDTO = perfilBO.readCommand(perfilDTO);
		
		return perfilDTO;
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
	
	@Command
	public void choose(){
//		logger.debug("Label: "+componentesPantalla.getSelectedItem().getLabel());
//		logger.debug("Label: "+componentesPantalla.getSelectedItem().getAutag());
//		Listcell listcell =  new Listcell(componentesPantalla.getSelectedItem().getLabel());
//		listcell.setAutag(componentesPantalla.getSelectedItem().getAutag());
//		componentesPerfil.appendChild(listcell);
		logger.debug("Label: "+componentesPantalla.getModel());	
		//componentesPerfil.addItemToSelection(componentesPantalla.getSelectedItem());
		componentesPantalla.removeItemAt(componentesPantalla.getSelectedIndex());
	}

	public void setStrDescripcionPerfil(String strDescripcionPerfil) {
		this.strDescripcionPerfil = strDescripcionPerfil;
	}

	public void setStrNombrePerfil(String strNombrePerfil) {
		this.strNombrePerfil = strNombrePerfil;
	}

	public void setStrPantalla(String strPantalla) {
		this.strPantalla = strPantalla;
	}

	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}
}
