package mx.com.bbva.mapeador.ui.commons.viewmodel.perfil;

import mx.com.bbva.mapeador.ui.commons.viewmodel.perfil.PerfilController;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;

public class PerfilController extends SelectorComposer<Component> {

	private static final Logger logger = Logger
			.getLogger(PerfilController.class);
	
	@Wire
	private Textbox nombrePerfil;
	
	@Wire
	private Textbox descripcionPerfil;

	@Wire
	private Combobox status;
	
	private String strNombrePerfil;
	
	private String strDescripcionPerfil;
	
	private String strStatus;		
	
	private int cantidadRegistros;
	
	private String strPantalla;

	public String getStrNombrePerfil() {
		return strNombrePerfil;
	}

	public void setStrNombrePerfil(String strNombrePerfil) {
		this.strNombrePerfil = strNombrePerfil;
	}

	public String getStrDescripcionPerfil() {
		return strDescripcionPerfil;
	}

	public void setStrDescripcionPerfil(String strDescripcionPerfil) {
		this.strDescripcionPerfil = strDescripcionPerfil;
	}

	public String getStrStatus() {
		return strStatus;
	}

	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}

	public int getCantidadRegistros() {
		return cantidadRegistros;
	}

	public String getStrPantalla() {
		return strPantalla;
	}

	public void setStrPantalla(String strPantalla) {
		this.strPantalla = strPantalla;
	}

}
