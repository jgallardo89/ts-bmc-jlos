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
 * Nombre de clase: AsignarUsuariosNotController.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.asignarusuariosnot
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.asignarusuariosnot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MensajeSalidaVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioNotificacionVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.MensajeSalidaBO;
import mx.com.bbva.bancomer.mapper.business.UsuarioNotificacionBO;
import mx.com.bbva.bancomer.mensajesalida.dto.MensajeSalidaDTO;
import mx.com.bbva.bancomer.usuarionotificacion.dto.UsuarioNotificacionDTO;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.reportes.ReportesController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

import org.apache.log4j.Logger;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

// TODO: Auto-generated Javadoc
/**
 * The Class AsignarUsuariosNotController.
 *
 * @author
 */
public class AsignarUsuariosNotController extends ControllerSupport implements  IController{
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(AsignarUsuariosNotController.class);
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6786596344010411900L;
	
	/** The consultar btn. */
	@Wire
	private Button consultarBtn;
	
	/** The descripcion mensaje. */
	@Wire
	private Textbox descripcionMensaje;
	
	/** The execute permission set. */
	private boolean executePermissionSet;
	
	/** The guardar btn. */
	@Wire
	private Button guardarBtn;
	
	/** The lbl descripcion mensaje. */
	@Wire
	private Label lblDescripcionMensaje;
	
	/** The lbl mensaje. */
	@Wire
	private Label lblMensaje;
	
	/** The limpiar btn. */
	@Wire
	private Button limpiarBtn;

	/** The mensaje salida dto. */
	private MensajeSalidaDTO mensajeSalidaDTO;
	
	/** The mensajes sistema. */
	@Wire
	private Combobox mensajesSistema;
	
	/** The mensajes usuarios grid. */
	@Wire
	private Grid mensajesUsuariosGrid;
	
	/** The reporte csv btn. */
	@Wire
	private Image reporteCsvBtn;
	
	/** The reporte excel btn. */
	@Wire
	private Image reporteExcelBtn;
	
	/** The usuario notificacion asignado dto. */
	private UsuarioNotificacionDTO usuarioNotificacionAsignadoDTO;
	
	/** The usuario notificacion no asignado dto. */
	private UsuarioNotificacionDTO usuarioNotificacionNoAsignadoDTO;
	
	/** The usuarios. */
	@Wire
	private Listbox usuarios;
	
	/** The usuarios mensaje. */
	@Wire
	private Listbox usuariosMensaje;
	
	/**
	 * Instantiates a new asignar usuarios not controller.
	 */
	public AsignarUsuariosNotController() {
		this.read();
	}
	
	/**
	 * After compose.
	 *
	 * @param view the view
	 */
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);   
        executePermissionSet = this.applyPermision();
    }
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#applyPermision()
	 */
	@Override
	public boolean applyPermision() {
		boolean isApplied = false;
		HashMap<String, Component> componentes = new HashMap<String, Component>();
		componentes.put(mensajesSistema.getId(),mensajesSistema);				
		componentes.put(guardarBtn.getId(),guardarBtn);			
		componentes.put(lblMensaje.getId(),lblMensaje);
		componentes.put(descripcionMensaje.getId(),descripcionMensaje);
		componentes.put(lblDescripcionMensaje.getId(),lblDescripcionMensaje);
		componentes.put(usuarios.getId(),usuarios);
		componentes.put(usuariosMensaje.getId(),usuariosMensaje);
		componentes.put(reporteExcelBtn.getId(),reporteExcelBtn);
		componentes.put(reporteCsvBtn.getId(),reporteCsvBtn);
		super.applyPermission(MapeadorConstants.ASIGNAR_USUARIO_SISTEMA, componentes);
		return isApplied;
	}
	
	/**
	 * Choose all.
	 */
	@Command
	@NotifyChange({"usuarioNotificacionNoAsignadoDTO", "usuarioNotificacionAsignadoDTO"})
	public void chooseAll(){		
		List<UsuarioNotificacionVO> usuarioNotificacionVOs = usuarioNotificacionNoAsignadoDTO.getUsuarioNotificacionVOs();
		if(usuarioNotificacionAsignadoDTO!=null && usuarioNotificacionNoAsignadoDTO!=null){
			for (UsuarioNotificacionVO usuarioNotificacionVO : usuarioNotificacionVOs) {
				usuarioNotificacionAsignadoDTO.getUsuarioNotificacionVOs().add(usuarioNotificacionVO);
			}
			usuarioNotificacionNoAsignadoDTO.getUsuarioNotificacionVOs().clear();
		}
	}
	
	/**
	 * Choose one.
	 */
	@Command
	@NotifyChange({"usuarioNotificacionNoAsignadoDTO", "usuarioNotificacionAsignadoDTO"})
	public void chooseOne(){
		if(usuarioNotificacionAsignadoDTO!=null && usuarioNotificacionAsignadoDTO!=null){
			if(usuarios.getSelectedItem()!=null){
				usuarioNotificacionAsignadoDTO.getUsuarioNotificacionVOs().add(usuarioNotificacionNoAsignadoDTO.getUsuarioNotificacionVOs().get(usuarios.getSelectedIndex()));
				usuarioNotificacionNoAsignadoDTO.getUsuarioNotificacionVOs().remove(usuarios.getSelectedIndex());
				
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#clean()
	 */
	@Override
	public void clean() {
		// TODO Auto-generated method stub
		
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#delete()
	 */
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Genera lista.
	 *
	 * @return the array list
	 */
	private ArrayList<BeanGenerico> generaLista() {
		ArrayList<BeanGenerico> beanGenericos = new ArrayList<BeanGenerico>();
		BeanGenerico beanGenerico = null;
		MensajeSalidaDTO mensajeSalidaDTO = new MensajeSalidaDTO();
		mensajeSalidaDTO.setCommandId(CommandConstants.CONSULTA_MENSAJES_USUARIOS);
		MensajeSalidaVO mensajeSalidaVOS = new MensajeSalidaVO();
		mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVOS);
		MensajeSalidaBO mensajeSalidaBO = new MensajeSalidaBO();
		mensajeSalidaDTO = mensajeSalidaBO.readCommand(mensajeSalidaDTO);
		if(mensajeSalidaDTO.getErrorCode().equals("SQL-001")){
	    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
	    					"\nError:"+mensajeSalidaDTO.getErrorCode()+
	    					"\nDescripción:"+mensajeSalidaDTO.getErrorDescription(),"Error de Sistema",Messagebox.OK,Messagebox.ERROR);
	    }
		List<MensajeSalidaVO> mensajeSalidaVOs = mensajeSalidaDTO.getMensajeSalidaVOs();
		for(MensajeSalidaVO mensajeSalidaVO: mensajeSalidaVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(mensajeSalidaVO.getNombreUsuario());
			beanGenerico.setValor2(mensajeSalidaVO.getMailUsuario());
			beanGenerico.setValor3(mensajeSalidaVO.getNombreMensajeSalida());
			beanGenerico.setValor4(mensajeSalidaVO.getDescripcionMensajeSalida());
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}
	
	/**
	 * Gets the mensaje salida dto.
	 *
	 * @return the mensajeSalidaDTO
	 */
	public final MensajeSalidaDTO getMensajeSalidaDTO() {
		return mensajeSalidaDTO;
	}
	
	/**
	 * Gets the usuario notificacion asignado dto.
	 *
	 * @return the usuarioNotificacionAsignadoDTO
	 */
	public final UsuarioNotificacionDTO getUsuarioNotificacionAsignadoDTO() {
		return usuarioNotificacionAsignadoDTO;
	}
	
	/**
	 * Gets the usuario notificacion no asignado dto.
	 *
	 * @return the usuarioNotificacionNoAsignadoDTO
	 */
	public final UsuarioNotificacionDTO getUsuarioNotificacionNoAsignadoDTO() {
		return usuarioNotificacionNoAsignadoDTO;
	}
	
	/**
	 * Checks if is execute permission set.
	 *
	 * @return the executePermissionSet
	 */
	public final boolean isExecutePermissionSet() {
		return executePermissionSet;
	}
	
	/**
	 * On show report.
	 *
	 * @param type the type
	 */
	@Command
	public void onShowReport(@BindingParam("type") final String type) {
		ReportesController controller = new ReportesController();
		ArrayList<String> headersReport = new ArrayList<String>();
		headersReport.add("Nombre de Usuario");
		headersReport.add("Email");
		headersReport.add("Nombre Mensaje Salida");
		headersReport.add("Texto Mensaje Salida");
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Usuarios Mensajes Sistema");
		} else {			
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Usuarios Mensajes Sistema");
		}
		controller.createReport(generaLista(), headersReport, type, "USUARIOS-MENSAJES-SISTEMA");
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read()
	 */
	@Override
	public Object read() {
		mensajeSalidaDTO = new MensajeSalidaDTO();
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
		estatusObjetoVO.setNombreTabla(CommandConstants.NOMBRE_TABLA_MENSAJE);		
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
		if(estatusObjetoDTO.getErrorCode().equals("SQL-001")){
	    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
	    					"\nError:"+estatusObjetoDTO.getErrorCode()+
	    					"\nDescripción:"+estatusObjetoDTO.getErrorDescription(),"Error de Sistema",Messagebox.OK,Messagebox.ERROR);
	    }
	    mensajeSalidaDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
	    
	    MensajeSalidaVO mensajeSalidaVO = new MensajeSalidaVO();
	    mensajeSalidaVO.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_SISTEMA);
	    mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
		MensajeSalidaBO MensajeSalidaBO = new MensajeSalidaBO();
		MensajeSalidaBO.readCommand(mensajeSalidaDTO);
		if(mensajeSalidaDTO.getErrorCode().equals("SQL-001")){
	    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
	    					"\nError:"+mensajeSalidaDTO.getErrorCode()+
	    					"\nDescripción:"+mensajeSalidaDTO.getErrorDescription(),"Error de Sistema",Messagebox.OK,Messagebox.ERROR);
	    }
		return mensajeSalidaDTO;
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read(java.lang.Object)
	 */
	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Read selected.
	 */
	@Command	
	@NotifyChange({"usuarioNotificacionNoAsignadoDTO","usuarioNotificacionAsignadoDTO"})
	public void readSelected(){
		if(mensajesSistema.getSelectedItem()!=null){
			descripcionMensaje.setValue(mensajesSistema.getSelectedItem().getAutag());
			UsuarioNotificacionBO usuarioNotificacionBO = null;
			UsuarioNotificacionVO usuarioNotificacionVO = new UsuarioNotificacionVO();
			usuarioNotificacionVO.setIdMensajeNotificacion(Integer.parseInt(mensajesSistema.getSelectedItem().getValue().toString()));
			usuarioNotificacionBO = new UsuarioNotificacionBO();
			
			usuarioNotificacionNoAsignadoDTO = new UsuarioNotificacionDTO();												
			usuarioNotificacionNoAsignadoDTO.setCommandId(CommandConstants.CONSULTA_USUARIOS_NO_ASIGNADOS);
			usuarioNotificacionNoAsignadoDTO.setUsuarioNotificacionVO(usuarioNotificacionVO);					
			usuarioNotificacionNoAsignadoDTO = usuarioNotificacionBO.readCommand(usuarioNotificacionNoAsignadoDTO);
			if(usuarioNotificacionNoAsignadoDTO.getErrorCode().equals("SQL-001")){
		    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
		    					"\nError:"+usuarioNotificacionNoAsignadoDTO.getErrorCode()+
		    					"\nDescripción:"+usuarioNotificacionNoAsignadoDTO.getErrorDescription(),"Error de Sistema",Messagebox.OK,Messagebox.ERROR);
		    }
			usuarioNotificacionAsignadoDTO = new UsuarioNotificacionDTO();												
			usuarioNotificacionAsignadoDTO.setCommandId(CommandConstants.CONSULTA_USUARIOS_ASIGNADOS);
			usuarioNotificacionAsignadoDTO.setUsuarioNotificacionVO(usuarioNotificacionVO);					
			usuarioNotificacionAsignadoDTO = usuarioNotificacionBO.readCommand(usuarioNotificacionAsignadoDTO);	
			if(usuarioNotificacionAsignadoDTO.getErrorCode().equals("SQL-001")){
		    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
		    					"\nError:"+usuarioNotificacionAsignadoDTO.getErrorCode()+
		    					"","Error de Sistema",Messagebox.OK,Messagebox.ERROR);
		    }
		}	
	}
	
	/**
	 * Read with filters.
	 */
	@Command
	@NotifyChange({ "flujoVOs" })
	public void readWithFilters() {
	
	}		
	
	/**
	 * Removes the all.
	 */
	@Command
	@NotifyChange({"usuarioNotificacionNoAsignadoDTO", "usuarioNotificacionAsignadoDTO"})
	public void removeAll(){		
		if(usuarioNotificacionAsignadoDTO!=null && usuarioNotificacionAsignadoDTO!=null){
			List<UsuarioNotificacionVO> usuarioNotificacionVOs = usuarioNotificacionAsignadoDTO.getUsuarioNotificacionVOs();
			for (UsuarioNotificacionVO usuarioNotificacionVO : usuarioNotificacionVOs) {
				usuarioNotificacionNoAsignadoDTO.getUsuarioNotificacionVOs().add(usuarioNotificacionVO);
			}
			usuarioNotificacionAsignadoDTO.getUsuarioNotificacionVOs().clear();
		}
	}
	
	/**
	 * Removes the one.
	 */
	@Command
	@NotifyChange({"usuarioNotificacionNoAsignadoDTO", "usuarioNotificacionAsignadoDTO"})
	public void removeOne(){		
		if(usuarioNotificacionAsignadoDTO!=null && usuarioNotificacionNoAsignadoDTO!=null){
			if(usuariosMensaje.getSelectedItem()!=null){
				usuarioNotificacionNoAsignadoDTO.getUsuarioNotificacionVOs().add(usuarioNotificacionAsignadoDTO.getUsuarioNotificacionVOs().get(usuariosMensaje.getSelectedIndex()));
				usuarioNotificacionAsignadoDTO.getUsuarioNotificacionVOs().remove(usuariosMensaje.getSelectedIndex());
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#save()
	 */
	@Override
	@Command
	@NotifyChange({"usuarioNotificacionNoAsignadoDTO", "usuarioNotificacionAsignadoDTO"})
	public void save() {		
		if(mensajesSistema.getSelectedItem()!=null){
			Messagebox.show(
					"¿Está seguro que desea continuar con la operación?",
					"Pregunta", org.zkoss.zul.Messagebox.YES | org.zkoss.zul.Messagebox.NO,
			org.zkoss.zul.Messagebox.QUESTION, new EventListener<Event>() {
				@Override
				public void onEvent(Event event) throws Exception {
					ReportesController reportesController = new ReportesController();
					if (event.getName().equals(org.zkoss.zul.Messagebox.ON_YES)) {
						UsuarioNotificacionBO usuarioNotificacionBO = new UsuarioNotificacionBO();		
						usuarioNotificacionAsignadoDTO.setIdMensajeNotificacion(Integer.parseInt(mensajesSistema.getSelectedItem().getValue().toString()));
						usuarioNotificacionAsignadoDTO = usuarioNotificacionBO.createCommandUsuarioNotificacion(usuarioNotificacionAsignadoDTO);						
						if(usuarioNotificacionAsignadoDTO.getErrorCode().equals("SQL-001")){
					    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
					    					"\nError:"+usuarioNotificacionAsignadoDTO.getErrorCode()+
					    					"","Error de Sistema",Messagebox.OK,Messagebox.ERROR);
					    	reportesController.registrarEvento(null, null, CommandConstants.ERROR_SISTEMA, "ASIGNAR-USUARIO");
					    }else{							
							reportesController.registrarEvento(null, null, CommandConstants.MODIFICACION, "ASIGNAR-USUARIO");		
							usuarioNotificacionAsignadoDTO = null;
							usuarioNotificacionNoAsignadoDTO = null;
							mensajesSistema.setValue(null);
							descripcionMensaje.setValue(null);
							org.zkoss.zul.Messagebox.show("Registro actualizado con exito!!",
									"Información", org.zkoss.zul.Messagebox.OK,
									org.zkoss.zul.Messagebox.INFORMATION);
					    }
					}
				}
			});
		}else{
			org.zkoss.zul.Messagebox.show("Favor de seleccionar el mensaje a modificar!!",
					"Error", org.zkoss.zul.Messagebox.OK,
					org.zkoss.zul.Messagebox.ERROR);
		}
	}
	
	/**
	 * Sets the execute permission set.
	 *
	 * @param executePermissionSet the executePermissionSet to set
	 */
	public final void setExecutePermissionSet(boolean executePermissionSet) {
		this.executePermissionSet = executePermissionSet;
	}
	
	/**
	 * Sets the mensaje salida dto.
	 *
	 * @param mensajeSalidaDTO the mensajeSalidaDTO to set
	 */
	public final void setMensajeSalidaDTO(MensajeSalidaDTO mensajeSalidaDTO) {
		this.mensajeSalidaDTO = mensajeSalidaDTO;
	}
	
	/**
	 * Sets the usuario notificacion asignado dto.
	 *
	 * @param usuarioNotificacionAsignadoDTO the usuarioNotificacionAsignadoDTO to set
	 */
	public final void setUsuarioNotificacionAsignadoDTO(
			UsuarioNotificacionDTO usuarioNotificacionAsignadoDTO) {
		this.usuarioNotificacionAsignadoDTO = usuarioNotificacionAsignadoDTO;
	}	
	
	/**
	 * Sets the usuario notificacion no asignado dto.
	 *
	 * @param usuarioNotificacionNoAsignadoDTO the usuarioNotificacionNoAsignadoDTO to set
	 */
	public final void setUsuarioNotificacionNoAsignadoDTO(
			UsuarioNotificacionDTO usuarioNotificacionNoAsignadoDTO) {
		this.usuarioNotificacionNoAsignadoDTO = usuarioNotificacionNoAsignadoDTO;
	}
}
	