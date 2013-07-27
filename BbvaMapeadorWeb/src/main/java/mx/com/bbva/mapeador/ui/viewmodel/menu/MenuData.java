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
 * Nombre de clase: MenuData.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.viewmodel.menu
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.viewmodel.menu;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuData.
 */
public class MenuData {
	
	/** The description. */
    private final String description;
    
    /** The icon. */
    private final String icon; 
    
    /** The url. */
	private final String url;
	
	private final long idPantalla;
 
    /**
	 * @return the idPantalla
	 */
	public final long getIdPantalla() {
		return idPantalla;
	}


	/**
	 * Instantiates a new menu data.
	 *
	 * @param description the description
	 * @param url the url
	 * @param icon the icon
	 */
	public MenuData(String description, String url, String icon, long idPantalla) {
        this.url = url;
        this.description = description;
        this.icon = icon;
        this.idPantalla = idPantalla;
    }


	/**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    
 
    /**
     * Gets the icon.
     *
     * @return the icon
     */
	public final String getIcon() {
		return icon;
	}
 
    /**
     * Gets the url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }    
}
