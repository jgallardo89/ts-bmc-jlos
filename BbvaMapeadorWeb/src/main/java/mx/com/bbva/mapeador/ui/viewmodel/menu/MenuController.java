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
 * Nombre de clase: MenuController.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.viewmodel.menu
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.viewmodel.menu;

import java.util.HashMap;

import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioVO;
import mx.com.bbva.bancomer.estatusobjeto.dto.UsuarioDTO;
import mx.com.bbva.bancomer.mapper.business.UsuarioBO;

import org.apache.log4j.Logger;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.TreeModel;
import org.zkoss.zul.TreeNode;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuController.
 */
public class MenuController extends SelectorComposer<Component>{
	
	/** The Constant logger. */
	private static final Logger logger = Logger
			.getLogger(MenuController.class);
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The body tab. */
	@Wire
	private Tabbox bodyTab;
	
	/** The name. */
	private String name;
	
	/** The perfil name. */
	private String perfilName;
	
	/** The tab nohome. */
	@Wire
	private Tab tabNohome;
	
	/** The user id. */
	private String userId;
	
	/** The user name. */
	private String userName;
	
	/** The usuario dto. */
	UsuarioDTO usuarioDTO = (UsuarioDTO)read();
	
	/**
	 * Instantiates a new menu controller.
	 */
	public MenuController() {			
		HashMap<String, Object> htSession = null;
		htSession = (HashMap<String, Object>)this.getPage().getDesktop().getSession().getAttribute("sessionValues");
		userId = htSession.get("iv-user").toString();
		logger.debug("1-userId:"+userId);
	}
	
	/**
	 * After compose.
	 *
	 * @param view the view
	 */
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
    }
	
	/**
	 * Creates the tab.
	 *
	 * @param menuData the menu data
	 */
	@Command
	public void createTab(@BindingParam("url") MenuData menuData){
		if(menuData.getUrl()!=null){
			Tab newTab = new Tab(menuData.getDescription());
			newTab.setClosable(true);		
	        newTab.setSelected(true);
	        Tabpanel newTabpanel = new Tabpanel();
	        newTabpanel.setWidth("100%");
	        newTabpanel.setHeight("100%");
	        Iframe iframe = new Iframe(menuData.getUrl());
	        iframe.setWidth("100%");
	        iframe.setHeight("100%");
	        newTabpanel.appendChild(iframe);
	        bodyTab.getTabs().insertBefore(newTab, tabNohome);
	        newTabpanel.setParent(bodyTab.getTabpanels());
		}
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public final String getName() {
		return name;
	}
	
	/**
	 * Gets the perfil name.
	 *
	 * @return the perfilName
	 */
	public final String getPerfilName() {
		return perfilName;
	}
	
	/**
	 * Gets the tree model.
	 *
	 * @return the tree model
	 */
	public TreeModel<TreeNode<MenuData>> getTreeModel() {
		logger.debug("2-userId:"+userId);
        TreeModel<TreeNode<MenuData>> treeModel = new DefaultTreeModel<MenuData>(new MenuDataUtil().getRoot(userId));
		return treeModel;
    }
	
	/**
	 * Gets the user id.
	 *
	 * @return the userId
	 */
	public final String getUserId() {
		return userId;
	}
	
	/**
	 * Gets the user name.
	 *
	 * @return the userName
	 */
	public final String getUserName() {
		return userName;
	}
	
	/**
	 * Gets the usuario dto.
	 *
	 * @return the usuarioDTO
	 */
	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}
	
	/**
	 * Read.
	 *
	 * @return the object
	 */
	public Object read() {				
				
		UsuarioBO usuarioBO = new UsuarioBO();
		UsuarioVO usuarioVO = new UsuarioVO();
		if(userId==null){
			HashMap<String, Object> htSession = null;
			htSession = (HashMap<String, Object>)this.getPage().getDesktop().getSession().getAttribute("sessionValues");
			userId = htSession.get("iv-user").toString();
		}
		usuarioVO.setIdCveUsuario(userId);
		logger.debug("userId:"+userId);
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
	
	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the perfil name.
	 *
	 * @param perfilName the perfilName to set
	 */
	public final void setPerfilName(String perfilName) {
		this.perfilName = perfilName;
	}
	
	/**
	 * Sets the user id.
	 *
	 * @param userId the userId to set
	 */
	public final void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Sets the user name.
	 *
	 * @param userName the userName to set
	 */
	public final void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * Sets the usuario dto.
	 *
	 * @param usuarioDTO the usuarioDTO to set
	 */
	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

}
