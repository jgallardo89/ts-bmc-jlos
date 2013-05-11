package mx.com.bbva.mt101.ui.commons.viewmodel.bitacoraWeb;

import java.sql.Clob;
import java.util.Date;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;

import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

/**
 * @author Julio Morales
 *
 */
public class BitacoraWebController extends ControllerSupport implements IController {

	private static final long serialVersionUID = -3648403161872767250L;

	private int idBitacora;
	private int idUsuario;
	private String nombreBitacora;
	private Clob descripcionBitacora;
	private Date horaBitacora;
	private Date fechaBitacora;
	private int idEventoMapeador;
	private Date fechaInicio;
	private Date fechaFin;
	
	
	
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

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub
		
	}
	
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
    }

}
