package mx.com.bbva.mt101.ui.commons.viewmodel.reportes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import mx.com.bbva.bancomer.bitacora.dto.BitacoraDTO;
import mx.com.bbva.bancomer.bitacora.dto.CampoDTO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.Selectors;

/**
 * @author Julio Morales
 *
 */
public class ReportesController extends ControllerSupport {

	private static final long serialVersionUID = 1L;
	
	public void createReport(ArrayList<BeanGenerico> fieldsReport, ArrayList<String> headersReport,String typeReport) {
		Sessions.getCurrent().setAttribute("listBeanGenerico", fieldsReport);
		Sessions.getCurrent().setAttribute("headersReport", headersReport);
		Sessions.getCurrent().setAttribute("typeReport", typeReport);
		
		Executions.sendRedirect("/ServletReport");
    }
	
	public void registrarEvento(Object nuevo, Object anterior, int idEvento, String nombreBitacora){
		List<CampoDTO> campoDTOs = new ArrayList<CampoDTO>(); 
		BitacoraDTO dto = new BitacoraDTO(); 
		if(nuevo != null && anterior != null) {
			Field[] fieldsNuevo = nuevo.getClass().getDeclaredFields(); 
			Field[] fieldsAnterior = anterior.getClass().getDeclaredFields(); 
			try {
				for(Field f : fieldsNuevo){
					String field = f.getName(); 
					if (!field.equals("serialVersionUID")){
						CampoDTO campo = new CampoDTO(); 
						campo.setNombre_campo(field); 
						Method getter;
						getter = nuevo.getClass().getMethod("get" + String.valueOf(field.charAt(0)).toUpperCase() +
								field.substring(1)); 
				        Object value = getter.invoke(nuevo, new Object[0]);
				        campo.setValor_nuevo((value != null && (!value.toString().equals("%") && !value.toString().equals("0")))? value.toString() : null);
				        for(Field f1 : fieldsAnterior){ 
							String field1 = f1.getName(); 
							if (!field1.equals("serialVersionUID")){ 
								 if(field.equals(field1)){
									Method getter1;
									getter1 = anterior.getClass().getMethod("get" + String.valueOf(field.charAt(0)).toUpperCase() +
											field.substring(1)); 
							        Object value1 = getter1.invoke(anterior, new Object[0]);
							        campo.setValor_anterior((value1 != null && (!value1.toString().equals("%") && !value1.toString().equals("0")))? value1.toString() : null);
								 }
						     }
						}
				        if(campo.getValor_anterior() != null && campo.getValor_nuevo()!= null 
				        		&& !campo.getValor_anterior().equals(campo.getValor_nuevo())) {
				        	campoDTOs.add(campo); 
				        }
				     }
				}
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		dto.setCampoDTOs(campoDTOs);
		super.registraEvento(dto, nombreBitacora, idEvento);
	}
	
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
    }
}
