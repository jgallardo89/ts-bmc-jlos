package mx.com.bbva.mapeador.ui.viewmodel.menu;

import java.util.HashMap;
import java.util.Hashtable;

import mx.com.bbva.mapeador.entity.tgm503usuario.Tgm503Usuario;

import org.zkoss.zul.DefaultTreeModel;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.TreeModel;
import org.zkoss.zul.TreeNode;

public class MenuController extends SelectorComposer<Component>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(MenuController.class);
	public TreeModel<TreeNode<MenuData>> getTreeModel() {
		String userId = null;		
		HashMap<String, Object> htSession = null;
		htSession = (HashMap<String, Object>)this.getPage().getDesktop().getSession().getAttribute("sessionValues");
		userId = htSession.get("iv-user").toString();
		logger.debug(userId);
        TreeModel<TreeNode<MenuData>> treeModel = new DefaultTreeModel<MenuData>(new MenuDataUtil().getRoot(userId));
		return treeModel;
    }		
}
