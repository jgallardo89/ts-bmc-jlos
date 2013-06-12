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
 * Nombre de clase: MenuTreeNode.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.viewmodel.menu
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.viewmodel.menu;

import org.zkoss.zul.DefaultTreeNode;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuTreeNode.
 *
 * @param <T> the generic type
 */
public class MenuTreeNode<T> extends DefaultTreeNode<T> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The open. */
	private boolean open = false;
	 
    /**
     * Instantiates a new menu tree node.
     *
     * @param data the data
     */
    public MenuTreeNode(T data) {
        super(data);
    }
 
    /**
     * Instantiates a new menu tree node.
     *
     * @param data the data
     * @param children the children
     */
    public MenuTreeNode(T data, MenuTreeNodeCollection<T> children) {
        super(data, children);
    }
 
    /**
     * Instantiates a new menu tree node.
     *
     * @param data the data
     * @param children the children
     * @param open the open
     */
    public MenuTreeNode(T data, MenuTreeNodeCollection<T> children, boolean open) {
        super(data, children);
        this.setOpen(open);
    }
 
    /**
     * Checks if is open.
     *
     * @return true, if is open
     */
    public boolean isOpen() {
        return open;
    }
 
    /**
     * Sets the open.
     *
     * @param open the new open
     */
    public void setOpen(boolean open) {
        this.open = open;
    }
	
}
