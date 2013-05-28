package mx.com.bbva.mt101.ui.commons.viewmodel.mensajes;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
import org.zkoss.zkex.zul.Jasperreport;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;

import mx.com.bbva.bancomer.bitacora.dto.BitacoraDTO;
import mx.com.bbva.bancomer.bitacora.dto.CampoDTO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MensajeSalidaVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.MensajeSalidaBO;
import mx.com.bbva.bancomer.mensajesalida.dto.MensajeSalidaDTO;
import mx.com.bbva.bancomer.utils.StringUtil;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;
import mx.com.bbva.mt101.ui.commons.viewmodel.reportes.ReportesController;

public class MensajesController extends ControllerSupport implements IController {

	private static final long serialVersionUID = 4649691032075701267L;

	@Wire
	private Textbox idMensajeSalida;
	@Wire
	private Textbox nombreMensajeSalida;
	@Wire
	private Textbox descripcionMensajeSalida;
	@Wire
	private Textbox idEstatusObjeto;
	@Wire
	private Combobox statusObjeto;
	@Wire
	private Jasperreport report;
	
	private boolean flagMensaje;
	private MensajeSalidaDTO mensajeSalidaDTO;
	private List<MensajeSalidaVO> mensajeSalidaVOs;
	private MensajeSalidaVO mensajeSalidaVO;
	
	public MensajesController() {
		this.read();
		this.mensajeSalidaVOs = mensajeSalidaDTO.getMensajeSalidaVOs();
		flagMensaje = false;
	}
	
	@Override
	public Object read() {
		mensajeSalidaDTO = new MensajeSalidaDTO();
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		//estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
		//estatusObjetoVO.setNombreTabla(CommandConstants.NOMBRE_TABLA_MAPA);		
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
	    mensajeSalidaDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
	    
	    MensajeSalidaVO mensajeSalidaVO = new MensajeSalidaVO();
	    mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
		MensajeSalidaBO MensajeSalidaBO = new MensajeSalidaBO();
		MensajeSalidaBO.readCommand(mensajeSalidaDTO);
		return mensajeSalidaDTO;
	}
	
	@Command
	@NotifyChange({ "mensajeSalidaVOs" })
	public void readWithFilters() {
		ReportesController controller = new ReportesController();
		MensajeSalidaDTO mensajeSalidaDTO = new MensajeSalidaDTO();
		MensajeSalidaVO mensajeSalidaVO = new MensajeSalidaVO();
		mensajeSalidaVO.setNombreMensajeSalida(StringUtil.validaLike(nombreMensajeSalida.getValue()));
		mensajeSalidaVO.setDescripcionMensajeSalida(StringUtil.validaLike(descripcionMensajeSalida.getValue()));
		mensajeSalidaVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
		mensajeSalidaVO.toString();
		mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
		MensajeSalidaBO mensajeSalidaBO = new MensajeSalidaBO();
		mensajeSalidaVOs = mensajeSalidaBO.readCommand(mensajeSalidaDTO).getMensajeSalidaVOs();
		controller.registrarEvento(null, null, CommandConstants.CONSULTAR, "Catálogo de Mensajes de Notificación");
		registraBitacora(mensajeSalidaVO, 2);
	}
	
	private void registraBitacora(MensajeSalidaVO mensajeSalidaVO, int evento) {
		List<CampoDTO> campoDTOs = new ArrayList<CampoDTO>(); 
		BitacoraDTO dto = new BitacoraDTO();
		Field[] atributos = mensajeSalidaVO.getClass().getFields(); 
		for (int i = 0; i < atributos.length; i++) {
			CampoDTO campo = new CampoDTO();
			campo.setNombre_campo(atributos[i].getName()); 
			campoDTOs.add(campo);
		}		
		dto.setCampoDTOs(campoDTOs);
		registraEvento(dto, "Catálogo de Mensajes de Notificación", evento);
	}

	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Command
	@NotifyChange({ "mensajeSalidaVOs","flagMensaje"})
	public void save() {
		ReportesController controller = new ReportesController();
		MensajeSalidaBO mensajeSalidaBO = new MensajeSalidaBO();
		boolean errorGuardar = false;
		if (statusObjeto.getSelectedItem() == null
				|| statusObjeto.getSelectedItem().getValue() == null
				|| statusObjeto.getSelectedItem().getValue().toString().isEmpty()) {
			statusObjeto.setErrorMessage("Favor de seleccionar el Estatus");
			errorGuardar = true;
		}
		if (nombreMensajeSalida.getValue().isEmpty()) {
			nombreMensajeSalida
					.setErrorMessage("Favor de introducir el nombre del Mensaje de Salida");
			errorGuardar = true;
		}
		if (descripcionMensajeSalida.getValue().isEmpty()) {
			descripcionMensajeSalida
					.setErrorMessage("Favor de introducir la descripción del Mensaje de Salida");
			errorGuardar = true;
		}
		if(!errorGuardar){
			
			if(idMensajeSalida.getValue().isEmpty() || idMensajeSalida.getValue().equals("0")) {
				MensajeSalidaDTO mensajeSalidaDTO = new MensajeSalidaDTO();
				MensajeSalidaVO mensajeSalidaVO = new MensajeSalidaVO();
				mensajeSalidaVO.setNombreMensajeSalida(nombreMensajeSalida.getValue().toUpperCase());
				mensajeSalidaVO.setDescripcionMensajeSalida(descripcionMensajeSalida.getValue().toUpperCase());
				mensajeSalidaVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
				//mensajeSalidaVO.setIdMensajeSalida(Integer.parseInt(idMensajeSalida.getValue()));
				mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
				mensajeSalidaBO.createCommand(mensajeSalidaDTO);
				mensajeSalidaDTO.toString(BbvaAbstractDataTransferObject.XML);
				controller.registrarEvento(mensajeSalidaVO, this.mensajeSalidaVO, CommandConstants.ALTA, "Catálogo de Mensajes de Notificación");
				clean();
				mensajeSalidaVO.setNombreMensajeSalida(StringUtil.validaLike(nombreMensajeSalida.getValue()));
				mensajeSalidaVO.setDescripcionMensajeSalida(StringUtil.validaLike(descripcionMensajeSalida.getValue()));
				mensajeSalidaVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
				mensajeSalidaVO.toString();
				mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
				mensajeSalidaVOs = mensajeSalidaBO.readCommand(mensajeSalidaDTO).getMensajeSalidaVOs();
				Messagebox.show("!El Registro del Mensaje fue exitoso!",
						"Información", Messagebox.OK,
						Messagebox.INFORMATION);
			} else {
				MensajeSalidaDTO mensajeSalidaDTO = new MensajeSalidaDTO();
				MensajeSalidaVO mensajeSalidaVO = new MensajeSalidaVO();
				mensajeSalidaVO.setNombreMensajeSalida(nombreMensajeSalida.getValue().toUpperCase());
				mensajeSalidaVO.setDescripcionMensajeSalida(descripcionMensajeSalida.getValue().toUpperCase());
				mensajeSalidaVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
				mensajeSalidaVO.setIdMensajeSalida(Integer.parseInt(idMensajeSalida.getValue()));
				mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
				mensajeSalidaBO.updateCommand(mensajeSalidaDTO);
				mensajeSalidaDTO.toString(BbvaAbstractDataTransferObject.XML);
				controller.registrarEvento(mensajeSalidaVO, mensajeSalidaVO, CommandConstants.MODIFICACION, "Catálogo de Mensajes de Notificación");
				clean();
				mensajeSalidaVO.setNombreMensajeSalida(StringUtil.validaLike(nombreMensajeSalida.getValue()));
				mensajeSalidaVO.setDescripcionMensajeSalida(StringUtil.validaLike(descripcionMensajeSalida.getValue()));
				mensajeSalidaVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
				mensajeSalidaVO.toString();
				mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
				mensajeSalidaVOs = mensajeSalidaBO.readCommand(mensajeSalidaDTO).getMensajeSalidaVOs();
				Messagebox.show("!La Actualización del Mensaje fue exitoso!",
						"Información", Messagebox.OK,
						Messagebox.INFORMATION);
			}
		}
		flagMensaje = false;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Command
	public void clean() {
		nombreMensajeSalida.clearErrorMessage();
		descripcionMensajeSalida.clearErrorMessage();
		idEstatusObjeto.clearErrorMessage();
		statusObjeto.clearErrorMessage();
		idMensajeSalida.clearErrorMessage();
		
		nombreMensajeSalida.setValue(null);
		descripcionMensajeSalida.setValue(null);
		idEstatusObjeto.setValue(null);
		statusObjeto.setValue(null);
		idMensajeSalida.setValue(null);
	}
	
	@Command
	@NotifyChange({"flagMensaje"})
	public void readSelected(@BindingParam("idMensajeSalida") final MensajeSalidaVO mensajeSalidaVO){
		this.mensajeSalidaVO = mensajeSalidaVO;
		mensajeSalidaVO.toString();
		nombreMensajeSalida.setValue(mensajeSalidaVO.getNombreMensajeSalida());
		descripcionMensajeSalida.setValue(mensajeSalidaVO.getDescripcionMensajeSalida());
		statusObjeto.setValue(mensajeSalidaVO.getNombreEstatusObjeto());
		idMensajeSalida.setValue(Integer.toString(mensajeSalidaVO.getIdMensajeSalida()));
		idEstatusObjeto.setValue(Integer.toString(mensajeSalidaVO.getIdEstatusObjeto()));
		flagMensaje = true;
	}
	
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
    }

	@Command
	public void onShowReport(@BindingParam("type") final String type) {
		ReportesController controller = new ReportesController();
		ArrayList<String> headersReport = new ArrayList<String>();
		String titleReport = "Palabras Comodín";
		headersReport.add("Identificador del Mensaje");
		headersReport.add("Texto del Mensaje");
		headersReport.add("Fecha y Hora de Alta");
		headersReport.add("Fecha y Hora de Modificacion");
		headersReport.add("Estatus");
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Catálogo de Mensajes de Notificación");
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Catálogo de Mensajes de Notificación");
		}
		controller.createReport(generaLista(), headersReport, titleReport, report, type);
	}	
	
	private ArrayList<BeanGenerico> generaLista() {
		ArrayList<BeanGenerico> beanGenericos = new ArrayList<BeanGenerico>();
		BeanGenerico beanGenerico = null;
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		for(MensajeSalidaVO mensajeSalidaVO: mensajeSalidaVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(mensajeSalidaVO.getNombreMensajeSalida());
			beanGenerico.setValor2(mensajeSalidaVO.getDescripcionMensajeSalida());
			if (mensajeSalidaVO.getFechaAlta() != null)
				beanGenerico.setValor3(dateFormat.format(mensajeSalidaVO.getFechaAlta()));				
			if (mensajeSalidaVO.getFechaModificacion() != null)
				beanGenerico.setValor4(dateFormat.format(mensajeSalidaVO.getFechaModificacion()));
			beanGenerico.setValor5(mensajeSalidaVO.getNombreEstatusObjeto());
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}
	/**
	 * @return the mensajeSalidaDTO
	 */
	public MensajeSalidaDTO getMensajeSalidaDTO() {
		return mensajeSalidaDTO;
	}

	/**
	 * @param mensajeSalidaDTO the mensajeSalidaDTO to set
	 */
	public void setMensajeSalidaDTO(MensajeSalidaDTO mensajeSalidaDTO) {
		this.mensajeSalidaDTO = mensajeSalidaDTO;
	}

	/**
	 * @return the mensajeSalidaVOs
	 */
	public List<MensajeSalidaVO> getMensajeSalidaVOs() {
		return mensajeSalidaVOs;
	}

	/**
	 * @param mensajeSalidaVOs the mensajeSalidaVOs to set
	 */
	public void setMensajeSalidaVOs(List<MensajeSalidaVO> mensajeSalidaVOs) {
		this.mensajeSalidaVOs = mensajeSalidaVOs;
	}

	/**
	 * @return the flagMensaje
	 */
	public boolean isFlagMensaje() {
		return flagMensaje;
	}

	/**
	 * @param flagMensaje the flagMensaje to set
	 */
	public void setFlagMensaje(boolean flagMensaje) {
		this.flagMensaje = flagMensaje;
	}

	/**
	 * @return the mensajeSalidaVO
	 */
	public MensajeSalidaVO getMensajeSalidaVO() {
		return mensajeSalidaVO;
	}

	/**
	 * @param mensajeSalidaVO the mensajeSalidaVO to set
	 */
	public void setMensajeSalidaVO(MensajeSalidaVO mensajeSalidaVO) {
		this.mensajeSalidaVO = mensajeSalidaVO;
	}

}
