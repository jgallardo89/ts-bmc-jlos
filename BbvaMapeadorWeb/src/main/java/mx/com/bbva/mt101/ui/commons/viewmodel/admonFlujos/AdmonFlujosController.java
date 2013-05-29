package mx.com.bbva.mt101.ui.commons.viewmodel.admonFlujos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import mx.com.bbva.bancomer.bitacora.dto.BitacoraDTO;
import mx.com.bbva.bancomer.bitacora.dto.CampoDTO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ClienteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.FlujoVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.flujo.dto.FlujoDTO;
import mx.com.bbva.bancomer.mapper.business.FlujoBO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.utils.StringUtil;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;
import mx.com.bbva.mt101.ui.commons.viewmodel.reportes.ReportesController;

/**
 * @author Julio Morales
 *
 */
public class AdmonFlujosController extends ControllerSupport implements IController {

	private static final long serialVersionUID = 671034870906549704L;
	
	@Wire
	private Textbox idFlujo;
	@Wire
	private Textbox nombreFlujo;
	@Wire
	private Textbox descripcionFlujo;
	@Wire
	private Textbox idEstatusObjeto;
	@Wire
	private Combobox statusObjeto;
	
	private boolean flagBtnGuardar;
	private FlujoDTO flujoDTO;
	private List<FlujoVO> flujoVOs;
	private FlujoVO flujoVO;
	
	public AdmonFlujosController() {
		this.read();
		this.flujoVOs = flujoDTO.getFlujoVOs();
		flagBtnGuardar = true;
	}

	@Override
	public Object read() {
		flujoDTO = new FlujoDTO();
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
		estatusObjetoVO.setNombreTabla(CommandConstants.NOMBRE_TABLA_FLUJOS);		
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);		
	    flujoDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
	    FlujoVO flujoVO = new FlujoVO();
	    flujoDTO.setFlujoVO(flujoVO);
		FlujoBO FlujoBO = new FlujoBO();
		FlujoBO.readCommand(flujoDTO);
		return flujoDTO;
	}

	@Command
	@NotifyChange({ "flujoVOs" })
	public void readWithFilters() {
		ReportesController controller = new ReportesController();
		FlujoDTO flujoDTO = new FlujoDTO();
		FlujoVO flujoVO = new FlujoVO();
		flujoVO.setNombreFlujo(StringUtil.validaLike(nombreFlujo.getValue()));
		flujoVO.setDescripcionFlujo(StringUtil.validaLike(descripcionFlujo.getValue()));
		flujoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
		flujoVO.toString();
		flujoDTO.setFlujoVO(flujoVO);
		FlujoBO FlujoBO = new FlujoBO();
		flujoVOs = FlujoBO.readCommand(flujoDTO).getFlujoVOs();
		controller.registrarEvento(null, null, CommandConstants.CONSULTAR, "Catálogo Flujos");
	}
	
	
	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Command
	@NotifyChange({ "flujoVOs","flagBtnGuardar" })
	public void save() {
		ReportesController controller = new ReportesController();
		FlujoBO flujoBO = new FlujoBO();
		boolean errorGuardar = false;
		if (nombreFlujo.getValue().isEmpty()) {
			nombreFlujo
					.setErrorMessage("Favor de introducir el nombre del Flujo");
			errorGuardar = true;
		}
		if (descripcionFlujo.getValue().isEmpty()) {
			descripcionFlujo
					.setErrorMessage("Favor de introducir la descripción del Flujo");
			errorGuardar = true;
		}
		if(!errorGuardar && !idFlujo.getValue().isEmpty()){
			FlujoDTO FlujoDTO = new FlujoDTO();
			FlujoVO flujoVO = new FlujoVO();
			flujoVO.setNombreFlujo(nombreFlujo.getValue().toUpperCase());
			flujoVO.setDescripcionFlujo(descripcionFlujo.getValue().toUpperCase());
			flujoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
			flujoVO.setIdFlujo(Integer.parseInt(idFlujo.getValue()));
			flujoDTO.setFlujoVO(flujoVO);
			flujoBO.updateCommand(flujoDTO);
			FlujoDTO.toString(BbvaAbstractDataTransferObject.XML);
			controller.registrarEvento(flujoVO, this.flujoVO, CommandConstants.MODIFICACION, "Catálogo Flujos");
			clean();
			flujoVO.setNombreFlujo(StringUtil.validaLike(nombreFlujo.getValue()));
			flujoVO.setDescripcionFlujo(StringUtil.validaLike(descripcionFlujo.getValue()));
			flujoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
			flujoVO.toString();
			FlujoDTO.setFlujoVO(flujoVO);
			flujoVOs = flujoBO.readCommand(FlujoDTO).getFlujoVOs();
			Messagebox.show("!La Actualización del Flujo fue exitoso!",
					"Información", Messagebox.OK,
					Messagebox.INFORMATION);
		}
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Command
	@NotifyChange({"flagBtnGuardar"})
	public void clean() {
		nombreFlujo.clearErrorMessage();
		descripcionFlujo.clearErrorMessage();
		statusObjeto.clearErrorMessage();
		
		nombreFlujo.setValue(null);
		descripcionFlujo.setValue(null);
		statusObjeto.setValue(null);
		
		idFlujo.setValue(null);
		idEstatusObjeto.setValue(null);
		setFlagBtnGuardar(true);
	}
	
	@Command
	@NotifyChange({"flagBtnGuardar"})
	public void readSelected(@BindingParam("idFlujo") final FlujoVO flujoVO){
		this.flujoVO = flujoVO;
		flujoVO.toString();
		nombreFlujo.setValue(flujoVO.getNombreFlujo());
		descripcionFlujo.setValue(flujoVO.getDescripcionFlujo());
		statusObjeto.setValue(flujoVO.getNombreEstatusObjeto());
		idFlujo.setValue(Integer.toString(flujoVO.getIdFlujo()));
		idEstatusObjeto.setValue(Integer.toString(flujoVO.getIdEstatusObjeto()));
		
		setFlagBtnGuardar(false);
	}
	
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
    }
	
	
	@Command
	public void openImage(@BindingParam("descripcionUrlImagen") final FlujoVO flujoVO) {
		Map<String, Object> mapDatos = new HashMap<String, Object>();
		mapDatos.put("descripcionUrlImagen", flujoVO.getDescripcionUrlImagen());
		System.out.println("**************" + flujoVO.getDescripcionUrlImagen());
		Window window = (Window) Executions.createComponents(
				"/WEB-INF/flows/admonFlujos/openImage.zul",this.getSelf(), mapDatos);
		window.doModal();
	}
	
	@Wire
    Window detalleBitacoraWindow;
	
	@Listen("onClick = #closeBtn")
    public void showModal(Event e) {
		detalleBitacoraWindow.detach();
    }
	
	@Command
	public void onShowReport(@BindingParam("type") final String type) {
		ReportesController controller = new ReportesController();
		ArrayList<String> headersReport = new ArrayList<String>();
		String titleReport = "Catálogo Flujos";
		headersReport.add("Identificador del Flujo");
		headersReport.add("Descripción Flujo");
		headersReport.add("Fecha y Hora de Alta");
		headersReport.add("Fecha y Hora de Modificación");
		headersReport.add("Etapas del Flujo");
		headersReport.add("Estatus");
		headersReport.add("Diagrama");
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Catálogo Clientes");
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Catálogo Clientes");
		}		
	}	
	
	private ArrayList<BeanGenerico> generaLista() {
		ArrayList<BeanGenerico> beanGenericos = new ArrayList<BeanGenerico>();
		BeanGenerico beanGenerico = null;
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		for(FlujoVO flujoVO: flujoVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(flujoVO.getNombreFlujo());
			beanGenerico.setValor2(flujoVO.getDescripcionFlujo());
			beanGenerico.setValor3(dateFormat.format(flujoVO.getFechaAlta()));
			beanGenerico.setValor4(dateFormat.format(flujoVO.getFechaModificacion()));
			beanGenerico.setValor5(flujoVO.getDescripcionEtapa());
			beanGenerico.setValor6(flujoVO.getNombreEstatusObjeto());
			beanGenerico.setValor7(flujoVO.getDescripcionUrlImagen());
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}
	
	/**
	 * @return the flagBtnGuardar
	 */
	public boolean isFlagBtnGuardar() {
		return flagBtnGuardar;
	}

	/**
	 * @param flagBtnGuardar the flagBtnGuardar to set
	 */
	public void setFlagBtnGuardar(boolean flagBtnGuardar) {
		this.flagBtnGuardar = flagBtnGuardar;
	}

	/**
	 * @return the flujoDTO
	 */
	public FlujoDTO getFlujoDTO() {
		return flujoDTO;
	}

	/**
	 * @param flujoDTO the flujoDTO to set
	 */
	public void setFlujoDTO(FlujoDTO flujoDTO) {
		this.flujoDTO = flujoDTO;
	}

	/**
	 * @return the flujoVOs
	 */
	public List<FlujoVO> getFlujoVOs() {
		return flujoVOs;
	}

	/**
	 * @param flujoVOs the flujoVOs to set
	 */
	public void setFlujoVOs(List<FlujoVO> flujoVOs) {
		this.flujoVOs = flujoVOs;
	}

	/**
	 * @return the flujoVO
	 */
	public FlujoVO getFlujoVO() {
		return flujoVO;
	}

	/**
	 * @param flujoVO the flujoVO to set
	 */
	public void setFlujoVO(FlujoVO flujoVO) {
		this.flujoVO = flujoVO;
	}

	@Override
	public boolean applyPermision() {
		// TODO Auto-generated method stub
		return false;
	}

}
