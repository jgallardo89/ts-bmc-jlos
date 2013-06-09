/**
 * 
 */
package mx.com.bbva.mapeador.ui.commons.viewmodel.asignarusuariosnot;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ComponenteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.FlujoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MensajeSalidaVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PantallaVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioNotificacionVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.MensajeSalidaBO;
import mx.com.bbva.bancomer.mapper.business.PantallaBO;
import mx.com.bbva.bancomer.mapper.business.UsuarioNotificacionBO;
import mx.com.bbva.bancomer.mensajesalida.dto.MensajeSalidaDTO;
import mx.com.bbva.bancomer.pantalla.dto.PantallaDTO;
import mx.com.bbva.bancomer.usuarionotificacion.dto.UsuarioNotificacionDTO;
import mx.com.bbva.mapeador.security.session.user.SessionUser;
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
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

/**
 * @author 
 *
 */
public class AsignarUsuariosNotController extends ControllerSupport implements  IController{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6786596344010411900L;
	private static final Logger logger = Logger.getLogger(AsignarUsuariosNotController.class);
	
	private boolean executePermissionSet;
	
	private MensajeSalidaDTO mensajeSalidaDTO;
	private UsuarioNotificacionDTO usuarioNotificacionNoAsignadoDTO;
	/**
	 * @return the usuarioNotificacionNoAsignadoDTO
	 */
	public final UsuarioNotificacionDTO getUsuarioNotificacionNoAsignadoDTO() {
		return usuarioNotificacionNoAsignadoDTO;
	}
	/**
	 * @param usuarioNotificacionNoAsignadoDTO the usuarioNotificacionNoAsignadoDTO to set
	 */
	public final void setUsuarioNotificacionNoAsignadoDTO(
			UsuarioNotificacionDTO usuarioNotificacionNoAsignadoDTO) {
		this.usuarioNotificacionNoAsignadoDTO = usuarioNotificacionNoAsignadoDTO;
	}
	/**
	 * @return the usuarioNotificacionAsignadoDTO
	 */
	public final UsuarioNotificacionDTO getUsuarioNotificacionAsignadoDTO() {
		return usuarioNotificacionAsignadoDTO;
	}
	/**
	 * @param usuarioNotificacionAsignadoDTO the usuarioNotificacionAsignadoDTO to set
	 */
	public final void setUsuarioNotificacionAsignadoDTO(
			UsuarioNotificacionDTO usuarioNotificacionAsignadoDTO) {
		this.usuarioNotificacionAsignadoDTO = usuarioNotificacionAsignadoDTO;
	}

	private UsuarioNotificacionDTO usuarioNotificacionAsignadoDTO;
	public AsignarUsuariosNotController() {
		this.read();
	}
	/**
	 * @return the mensajeSalidaDTO
	 */
	public final MensajeSalidaDTO getMensajeSalidaDTO() {
		return mensajeSalidaDTO;
	}
	/**
	 * @param mensajeSalidaDTO the mensajeSalidaDTO to set
	 */
	public final void setMensajeSalidaDTO(MensajeSalidaDTO mensajeSalidaDTO) {
		this.mensajeSalidaDTO = mensajeSalidaDTO;
	}
	@Wire
	private Image reporteExcelBtn;
	@Wire
	private Image reporteCsvBtn;
	@Wire
	private Combobox mensajesSistema;
	@Wire
	private Button limpiarBtn;
	@Wire
	private Button guardarBtn;
	@Wire
	private Button consultarBtn;
	@Wire
	private Grid mensajesUsuariosGrid;
	@Wire
	private Label lblMensaje;
	@Wire
	private Textbox descripcionMensaje;
	@Wire
	private Label lblDescripcionMensaje;
	@Wire
	private Listbox usuarios;
	@Wire
	private Listbox usuariosMensaje;
	/**
	 * @return the executePermissionSet
	 */
	public final boolean isExecutePermissionSet() {
		return executePermissionSet;
	}
	/**
	 * @param executePermissionSet the executePermissionSet to set
	 */
	public final void setExecutePermissionSet(boolean executePermissionSet) {
		this.executePermissionSet = executePermissionSet;
	}
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
	    mensajeSalidaDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
	    
	    MensajeSalidaVO mensajeSalidaVO = new MensajeSalidaVO();
	    mensajeSalidaVO.setTipoNotificacion(CommandConstants.TIPO_NOTIFICACION_SISTEMA);
	    mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
		MensajeSalidaBO MensajeSalidaBO = new MensajeSalidaBO();
		MensajeSalidaBO.readCommand(mensajeSalidaDTO);
		return mensajeSalidaDTO;
	}
	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	@Command
	@NotifyChange({"usuarioNotificacionNoAsignadoDTO", "usuarioNotificacionAsignadoDTO"})
	public void save() {		
		if(mensajesSistema.getSelectedItem()!=null){
			UsuarioNotificacionBO usuarioNotificacionBO = new UsuarioNotificacionBO();		
			usuarioNotificacionAsignadoDTO.setIdMensajeNotificacion(Integer.parseInt(mensajesSistema.getSelectedItem().getValue().toString()));
			usuarioNotificacionBO.createCommandUsuarioNotificacion(usuarioNotificacionAsignadoDTO);
			ReportesController reportesController = new ReportesController();
			reportesController.registrarEvento(null, null, CommandConstants.MODIFICACION, "ASIGNAR-USUARIO");		
			usuarioNotificacionAsignadoDTO = null;
			usuarioNotificacionNoAsignadoDTO = null;
			mensajesSistema.setValue(null);
			descripcionMensaje.setValue(null);
			Messagebox.show("Registro actualizado con exito!!",
					"Confirmación", Messagebox.OK,
					Messagebox.INFORMATION);
		}else{
			Messagebox.show("Favor de seleccionar el mensaje a modificar!!",
					"Error", Messagebox.OK,
					Messagebox.ERROR);
		}
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void clean() {
		// TODO Auto-generated method stub
		
	}
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
	
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);   
        executePermissionSet = this.applyPermision();
    }
	
	@Command
	@NotifyChange({ "flujoVOs" })
	public void readWithFilters() {
	
	}		
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
			
			usuarioNotificacionAsignadoDTO = new UsuarioNotificacionDTO();												
			usuarioNotificacionAsignadoDTO.setCommandId(CommandConstants.CONSULTA_USUARIOS_ASIGNADOS);
			usuarioNotificacionAsignadoDTO.setUsuarioNotificacionVO(usuarioNotificacionVO);					
			usuarioNotificacionAsignadoDTO = usuarioNotificacionBO.readCommand(usuarioNotificacionAsignadoDTO);					
		}	
	}
	
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
	
	private ArrayList<BeanGenerico> generaLista() {
		ArrayList<BeanGenerico> beanGenericos = new ArrayList<BeanGenerico>();
		BeanGenerico beanGenerico = null;
		MensajeSalidaDTO mensajeSalidaDTO = new MensajeSalidaDTO();
		mensajeSalidaDTO.setCommandId(CommandConstants.CONSULTA_MENSAJES_USUARIOS);
		MensajeSalidaVO mensajeSalidaVOS = new MensajeSalidaVO();
		mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVOS);
		MensajeSalidaBO mensajeSalidaBO = new MensajeSalidaBO();
		mensajeSalidaDTO = mensajeSalidaBO.readCommand(mensajeSalidaDTO);
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
}
	