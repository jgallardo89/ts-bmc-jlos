package mx.com.bbva.mapeador.ui.commons.viewmodel.perfil;

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
		// TODO Auto-generated method stub
		return null;
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
