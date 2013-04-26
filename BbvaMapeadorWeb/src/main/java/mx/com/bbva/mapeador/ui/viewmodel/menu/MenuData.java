package mx.com.bbva.mapeador.ui.viewmodel.menu;

public class MenuData {
	private final String url;
    private final String description;    
 
    public MenuData(String description, String url) {
        this.url = url;
        this.description = description;        
    }
    
 
    public String getUrl() {
        return url;
    }
 
    public String getDescription() {
        return description;
    }    
}
