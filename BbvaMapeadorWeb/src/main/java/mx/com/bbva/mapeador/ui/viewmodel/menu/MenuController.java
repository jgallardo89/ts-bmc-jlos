package mx.com.bbva.mapeador.ui.viewmodel.menu;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioVO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.estatusobjeto.dto.PerfilDTO;
import mx.com.bbva.bancomer.estatusobjeto.dto.UsuarioDTO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.PerfilBO;
import mx.com.bbva.bancomer.mapper.business.UsuarioBO;
import mx.com.bbva.mapeador.entity.tgm503usuario.Tgm503Usuario;

import org.zkoss.zul.DefaultTreeModel;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.TreeModel;
import org.zkoss.zul.TreeNode;

public class MenuController extends SelectorComposer<Component>{
	private String userId;
	private String userName;
	private String name;
	private String perfilName;
	UsuarioDTO usuarioDTO = (UsuarioDTO)read();
	/**
	 * @return the usuarioDTO
	 */
	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}
	/**
	 * @param usuarioDTO the usuarioDTO to set
	 */
	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the perfilName
	 */
	public final String getPerfilName() {
		return perfilName;
	}
	/**
	 * @param perfilName the perfilName to set
	 */
	public final void setPerfilName(String perfilName) {
		this.perfilName = perfilName;
	}
	/**
	 * @return the userId
	 */
	public final String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public final void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public final String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public final void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 
	 */
	public MenuController() {			
		HashMap<String, Object> htSession = null;
		htSession = (HashMap<String, Object>)this.getPage().getDesktop().getSession().getAttribute("sessionValues");
		userId = htSession.get("iv-user").toString();
		logger.debug(userId);
	}
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(MenuController.class);
	public TreeModel<TreeNode<MenuData>> getTreeModel() {
		
        TreeModel<TreeNode<MenuData>> treeModel = new DefaultTreeModel<MenuData>(new MenuDataUtil().getRoot(userId));
		return treeModel;
    }
	public Object read() {				
				
		UsuarioBO usuarioBO = new UsuarioBO();
		UsuarioVO usuarioVO = new UsuarioVO();		
		usuarioVO.setIdCveUsuario(userId);
		usuarioDTO = new UsuarioDTO();
		usuarioDTO.setUsuarioVO(usuarioVO);
		usuarioDTO = usuarioBO.readCommand(usuarioDTO);
		userId = usuarioDTO.getUsuarioVOs().get(0).getIdCveUsuario();
		userName = usuarioDTO.getUsuarioVOs().get(0).getNombreUsuario();		
		perfilName = usuarioDTO.getUsuarioVOs().get(0).getDescripcionPerfil();
		logger.debug("info user:" + userId + " --- " + userName + " --- " + perfilName);
		name = userId + " --- " + userName + " --- " + perfilName;
		return usuarioDTO;
	}
}
