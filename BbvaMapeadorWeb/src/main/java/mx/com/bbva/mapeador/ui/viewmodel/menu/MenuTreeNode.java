package mx.com.bbva.mapeador.ui.viewmodel.menu;

import org.zkoss.zul.DefaultTreeNode;

public class MenuTreeNode<T> extends DefaultTreeNode<T> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean open = false;
	 
    public MenuTreeNode(T data, MenuTreeNodeCollection<T> children, boolean open) {
        super(data, children);
        this.setOpen(open);
    }
 
    public MenuTreeNode(T data, MenuTreeNodeCollection<T> children) {
        super(data, children);
    }
 
    public MenuTreeNode(T data) {
        super(data);
    }
 
    public boolean isOpen() {
        return open;
    }
 
    public void setOpen(boolean open) {
        this.open = open;
    }
	
}
