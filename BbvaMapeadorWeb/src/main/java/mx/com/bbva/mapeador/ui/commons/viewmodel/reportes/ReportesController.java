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
 * Nombre de clase: ReportesController.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.reportes
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.reportes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import mx.com.bbva.bancomer.bitacora.dto.BitacoraDTO;
import mx.com.bbva.bancomer.bitacora.dto.CampoDTO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ControlPermisoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PerfilVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.perfil.dto.PerfilDTO;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.Selectors;

// TODO: Auto-generated Javadoc
/**
 * The Class ReportesController.
 *
 * @author Julio Morales
 */
public class ReportesController extends ControllerSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * After compose.
	 *
	 * @param view the view
	 */
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
    }
	
	/**
	 * Creates the report.
	 *
	 * @param fieldsReport the fields report
	 * @param headersReport the headers report
	 * @param typeReport the type report
	 * @param nameReport the name report
	 */
	public void createReport(ArrayList<BeanGenerico> fieldsReport, ArrayList<String> headersReport,String typeReport, String nameReport) {
		Sessions.getCurrent().setAttribute("listBeanGenerico", fieldsReport);
		Sessions.getCurrent().setAttribute("headersReport", headersReport);
		Sessions.getCurrent().setAttribute("typeReport", typeReport);
		Sessions.getCurrent().setAttribute("nameReport", nameReport);
		
		Executions.sendRedirect("/ServletReport");
		org.zkoss.zul.Messagebox.show("!Se generó el Reporte de tipo "+typeReport+" con éxito",
				"Información", org.zkoss.zul.Messagebox.OK,
				org.zkoss.zul.Messagebox.INFORMATION);
    }
	
	/**
	 * Registrar evento.
	 *
	 * @param nuevo the nuevo
	 * @param anterior the anterior
	 * @param idEvento the id evento
	 * @param nombreBitacora the nombre bitacora
	 */
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
	
	/**
	 * Registrar evento perfil.
	 *
	 * @param nuevo the nuevo
	 * @param anterior the anterior
	 * @param idEvento the id evento
	 * @param nombreBitacora the nombre bitacora
	 */
	public void registrarEventoPerfil(PerfilDTO nuevo,PerfilDTO anterior, int idEvento, String nombreBitacora){
		List<CampoDTO> campoDTOs = new ArrayList<CampoDTO>(); 
		BitacoraDTO dto = new BitacoraDTO(); 
		CampoDTO campo = new CampoDTO();
		PerfilVO perfilVONuevo =   nuevo.getPerfilVO();
		PerfilVO perfilVOAnterior =   anterior.getPerfilVO();
		if(perfilVOAnterior.getNombrebPerfil()!=perfilVONuevo.getNombrebPerfil()){
			campo = new CampoDTO();
			campo.setNombre_campo("nombrePerfil");
			campo.setValor_anterior(perfilVOAnterior.getNombrebPerfil());
			campo.setValor_nuevo(perfilVONuevo.getNombrebPerfil());
			campoDTOs.add(campo);
		}
		if(perfilVOAnterior.getDescripcionPerfil()!=perfilVONuevo.getDescripcionPerfil()){
			campo = new CampoDTO();
			campo.setNombre_campo("descripcionPerfil");
			campo.setValor_anterior(perfilVOAnterior.getDescripcionPerfil());
			campo.setValor_nuevo(perfilVONuevo.getDescripcionPerfil());
			campoDTOs.add(campo);
		}
		if(perfilVOAnterior.getDescipcionEstatus()!=perfilVONuevo.getDescipcionEstatus()){
			campo = new CampoDTO();
			campo.setNombre_campo("estatusPerfil");
			campo.setValor_anterior(perfilVOAnterior.getDescipcionEstatus());
			campo.setValor_nuevo(perfilVONuevo.getDescipcionEstatus());		
			campoDTOs.add(campo);
		}
		List<ControlPermisoVO> controlPermisoVOsNuevo = perfilVONuevo.getControlPermisoVOs(); 
		
		if(controlPermisoVOsNuevo!=null){
			for (ControlPermisoVO controlPermisoVO : controlPermisoVOsNuevo) {
				campo = new CampoDTO();
				campo.setNombre_campo("Permiso");
				campo.setValor_anterior("");
				campo.setValor_nuevo("Se crea--"+controlPermisoVO.getNombreComponente());
				campoDTOs.add(campo);
			}
		}
		List<ControlPermisoVO> controlPermisoVOsAnterior = perfilVOAnterior.getControlPermisoVOs();
		if(controlPermisoVOsAnterior!=null){
			for (ControlPermisoVO controlPermisoVO : controlPermisoVOsAnterior) {
				campo = new CampoDTO();
				campo.setNombre_campo("Permiso");
				campo.setValor_anterior("Se elimina--"+controlPermisoVO.getNombreComponente());
				campo.setValor_nuevo("");
				campoDTOs.add(campo);
			}
		}
				
		dto.setCampoDTOs(campoDTOs);
		super.registraEvento(dto, nombreBitacora, idEvento);
	}
}
