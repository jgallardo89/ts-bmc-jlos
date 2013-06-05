package mx.com.bbva.mapeador.ui.viewmodel.menu;

public class MenuData {
	private final String url;
    private final String description; 
    private final String icon;
 
    /**
	 * @return the icon
	 */
	public final String getIcon() {
		return icon;
	}


	public MenuData(String description, String url, String icon) {
        this.url = url;
        this.description = description;
        this.icon = icon;
    }
    
 
    public String getUrl() {
        return url;
    }
 
    public String getDescription() {
        return description;
    }    
}
