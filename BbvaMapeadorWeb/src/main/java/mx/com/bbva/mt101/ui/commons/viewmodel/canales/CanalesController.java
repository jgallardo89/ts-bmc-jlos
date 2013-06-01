package mx.com.bbva.mt101.ui.commons.viewmodel.canales;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.CanalVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ContratacionVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.canal.dto.CanalDTO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.CanalBO;
import mx.com.bbva.bancomer.mapper.business.ContratacionBO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.utils.StringUtil;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;
import mx.com.bbva.mt101.ui.commons.viewmodel.reportes.ReportesController;

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
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

/**
 * @author Julio Morales
 *
 */
public class CanalesController extends ControllerSupport implements IController {

	private static final long serialVersionUID = 1L;
	@Wire
	private Textbox idEstatusObjeto;
	@Wire
	private Textbox idCanal;
	
	@Wire
	private Label lblClave;
	@Wire
	private Label lblFechaHoraAlta;
	@Wire
	private Label lblDescripcionCanal;
	@Wire
	private Label lblEstatus;
	@Wire
	private Textbox nombreCanal;
	@Wire
	private Textbox descripcionCanal;
	@Wire
	private Datebox fechaInicio;
	@Wire
	private Datebox fechaFin;
	@Wire
	private Combobox statusObjeto;
	@Wire
	private Image reporteExcelBtn;
	@Wire
	private Image reporteCsvBtn;
	@Wire
	private Button limpiarBtn;
	@Wire
	private Button guardarBtn;
	@Wire
	private Button consultarBtn;
	@Wire
	private Grid canalesGrid;
	
	private boolean btnGuardar;
	private boolean flagClave;
	private boolean executePermissionSet;
	private CanalDTO canalDTO;
	private String strIdCanal;
	private List<CanalVO> canalesVOs;
	private CanalVO canalesVO;
	
	/**
	 * Constructor de CanalesController
	 */
	public CanalesController() {
		this.read();
		this.canalesVOs = canalDTO.getCanalVOs();
		btnGuardar = true;
	}
	
	@Override
	public Object read() {
		canalDTO = new CanalDTO();
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
	    estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
	    EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
	    estatusObjetoVO.setNombreTabla(CommandConstants.NOMBRE_TABLA_CANALES);
	    estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
	    estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
	    canalDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
	    CanalVO canalVO = new CanalVO();
	    canalDTO.setCanalVO(canalVO);
		CanalBO canalBO = new CanalBO();
		canalBO.readCommand(canalDTO);
		return canalDTO;
	}
	
	@Command
	@NotifyChange({ "canalesVOs" })
	public void readWithFilters() {
		ReportesController controller = new ReportesController();
		CanalDTO canalDTO = new CanalDTO();
		CanalVO canalVO = new CanalVO();
		DateFormat dateFormatIni = new SimpleDateFormat("dd-MM-yyyy 00:00");
		DateFormat dateFormatFin = new SimpleDateFormat("dd-MM-yyyy 23:59");
		canalVO.setFechaInicio(dateFormatIni.format(fechaInicio.getValue()));
		canalVO.setFechaFin(dateFormatFin.format(fechaFin.getValue()));
		canalVO.setNombreCanal(StringUtil.validaLike(nombreCanal.getValue()));
		canalVO.setDescripcionCanal(StringUtil.validaLike(descripcionCanal.getValue()));
		canalVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
		canalVO.toString();
		canalDTO.setCanalVO(canalVO);
		CanalBO canalBO = new CanalBO();
		canalesVOs = canalBO.readCommand(canalDTO).getCanalVOs();
		
		controller.registrarEvento(canalVO, canalVO, CommandConstants.CONSULTAR, "Catálogo Canal");
	}
	
	@Override
	@Command
	@NotifyChange({ "canalesVOs", "btnGuardar", "flagClave" })
	public void save() {
		CanalBO canalBO = new CanalBO();
		ReportesController controller = new ReportesController();
		boolean errorGuardar = false;
		if (statusObjeto.getSelectedItem() == null
				|| statusObjeto.getSelectedItem().getValue() == null
				|| statusObjeto.getSelectedItem().getValue().toString().isEmpty()) {
			statusObjeto.setErrorMessage("Favor de seleccionar el Estatus");
			errorGuardar = true;
		}
		if (nombreCanal.getValue().isEmpty()) {
			nombreCanal
					.setErrorMessage("Favor de introducir el nombre del Canal");
			errorGuardar = true;
		}
		if (descripcionCanal.getValue().isEmpty()) {
			descripcionCanal
					.setErrorMessage("Favor de introducir la descripción del Canal");
			errorGuardar = true;
		}
		if(!errorGuardar){
			if(idCanal.getValue().isEmpty()){
//				CanalDTO canalDTO = new CanalDTO();
//				CanalVO canalVO = new CanalVO();
//				canalVO.setNombreCanal(nombreCanal.getValue().toUpperCase());
//				canalVO.setDescripcionCanal(descripcionCanal.getValue().toUpperCase());
//				canalVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
//				canalDTO.setCanalVO(canalVO);
//				canalBO.createCommand(canalDTO);
//				canalDTO.toString(BbvaAbstractDataTransferObject.XML);
//				clean();
//				canalVO.setNombreCanal(StringUtil.validaLike(nombreCanal.getValue()));
//				canalVO.setDescripcionCanal(StringUtil.validaLike(descripcionCanal.getValue()));
//				canalVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
//				canalVO.toString();
//				canalDTO.setCanalVO(canalVO);
//				canalesVOs = canalBO.readCommand(canalDTO).getCanalVOs();
				
			} else {
				ContratacionBO contratacionBO = new ContratacionBO();
				ContratacionVO contratacionVO = new ContratacionVO();
				contratacionVO.setIdCanal(Integer.parseInt(idCanal.getValue()));
				if(Integer.parseInt(idEstatusObjeto.getValue()) == CommandConstants.ESTATUS_OBJETO_ACTIVO_CANAL || 
						contratacionBO.readCommandValidaContratacion(contratacionVO)) {
					CanalDTO canalDTO = new CanalDTO();
					CanalVO canalVO = new CanalVO();
					canalVO.setNombreCanal(nombreCanal.getValue().toUpperCase().toUpperCase());
					canalVO.setDescripcionCanal(descripcionCanal.getValue().toUpperCase().toUpperCase());
					canalVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
					canalVO.setIdCanal(Integer.parseInt(idCanal.getValue()));
					canalDTO.setCanalVO(canalVO);
					canalBO.updateCommand(canalDTO);
					canalDTO.toString(BbvaAbstractDataTransferObject.XML);
					clean();
					
					controller.registrarEvento(canalVO, canalesVO, CommandConstants.MODIFICACION, "Catálogo Canal");
					
					canalVO.setNombreCanal(StringUtil.validaLike(nombreCanal.getValue()));
					canalVO.setDescripcionCanal(StringUtil.validaLike(descripcionCanal.getValue()));
					canalVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
					canalVO.toString();
					canalDTO.setCanalVO(canalVO);
					canalesVOs = canalBO.readCommand(canalDTO).getCanalVOs();
					
					btnGuardar = true;
					Messagebox.show("!La Actualización del Canal fue exitoso!",
							"Información", Messagebox.OK,
							Messagebox.INFORMATION);
				  } else {
					  clean();
					  canalDTO = new CanalDTO();
					  CanalVO canalVO = new CanalVO();
					  canalVO.setNombreCanal(StringUtil.validaLike(nombreCanal.getValue()));
					  canalVO.setDescripcionCanal(StringUtil.validaLike(descripcionCanal.getValue()));
					  canalVO.setIdEstatusObjeto(0);
					  canalVO.toString();
					  canalDTO.setCanalVO(canalVO);
					  canalesVOs = canalBO.readCommand(canalDTO).getCanalVOs();
					  Messagebox.show("!No se puede dar de Baja, ya que esta siendo Usado por la Contratación!",
								"Información", Messagebox.OK,
								Messagebox.EXCLAMATION);
				  }
			}
			flagClave = false;
		}
	}
	
	@Override
	@Command
	@NotifyChange({"btnGuardar", "flagClave" })
	public void clean() {
		nombreCanal.clearErrorMessage();
		descripcionCanal.clearErrorMessage();
		statusObjeto.clearErrorMessage();
		
		nombreCanal.setValue(null);
		descripcionCanal.setValue(null);
		statusObjeto.setValue(null);
		
		idCanal.setValue(null);
		idEstatusObjeto.setValue(null);
		btnGuardar = true;
		flagClave = false;
	}
	
	@Command
	@NotifyChange({"btnGuardar","flagClave"})
	public void readSelected(@BindingParam("idCanal") final CanalVO canalVO){
		canalesVO = canalVO;
		canalVO.toString();
		nombreCanal.setValue(canalVO.getNombreCanal());
		descripcionCanal.setValue(canalVO.getDescripcionCanal());
		statusObjeto.setValue(canalVO.getNombreEstatusObjeto());
		idCanal.setValue(Integer.toString(canalVO.getIdCanal()));
		idEstatusObjeto.setValue(Integer.toString(canalVO.getIdEstatusObjeto()));
		btnGuardar = false;
		flagClave = true;
	}
	
	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the canalDTO
	 */
	public CanalDTO getCanalDTO() {
		return canalDTO;
	}

	/**
	 * @param canalDTO the canalDTO to set
	 */
	public void setCanalDTO(CanalDTO canalDTO) {
		this.canalDTO = canalDTO;
	}
	
	/**
	 * @return the canalesVOs
	 */
	public List<CanalVO> getCanalesVOs() {
		return canalesVOs;
	}
	
	/**
	 * @param canalesVOs the canalesVOs to set
	 */
	public void setCanalesVOs(List<CanalVO> canalesVOs) {
		this.canalesVOs = canalesVOs;
	}

	/**
	 * @return the strIdCanal
	 */
	public String getStrIdCanal() {
		return strIdCanal;
	}

	/**
	 * @param strIdCanal the strIdCanal to set
	 */
	public void setStrIdCanal(String strIdCanal) {
		this.strIdCanal = strIdCanal;
	}

	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
        executePermissionSet = this.applyPermision();
    }
	
	@Command
	public void onShowReport(@BindingParam("type") final String type) {
		ReportesController controller = new ReportesController();
		ArrayList<String> headersReport = new ArrayList<String>();
		headersReport.add("Clave");
		headersReport.add("Descripción canal");
		headersReport.add("Fecha y Hora alta");
		headersReport.add("Status");
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Catálogo Canal");
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Catálogo Canal");
		}
		controller.createReport(generaLista(), headersReport, type, "CANALES");
	}	
	
	private ArrayList<BeanGenerico> generaLista() {
		ArrayList<BeanGenerico> beanGenericos = new ArrayList<BeanGenerico>();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		BeanGenerico beanGenerico = null;
		for(CanalVO canalVO: canalesVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(canalVO.getNombreCanal());
			beanGenerico.setValor2(canalVO.getDescripcionCanal());
			beanGenerico.setValor3(dateFormat.format(canalVO.getFechaAlta()));
			beanGenerico.setValor4(canalVO.getNombreEstatusObjeto());
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}
	
	/**
	 * @return the btnGuardar
	 */
	public boolean isBtnGuardar() {
		return btnGuardar;
	}

	/**
	 * @param btnGuardar the btnGuardar to set
	 */
	public void setBtnGuardar(boolean btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	/**
	 * @return the canalesVO
	 */
	public CanalVO getCanalesVO() {
		return canalesVO;
	}

	/**
	 * @param canalesVO the canalesVO to set
	 */
	public void setCanalesVO(CanalVO canalesVO) {
		this.canalesVO = canalesVO;
	}

	/**
	 * @return the flagClave
	 */
	public boolean isFlagClave() {
		return flagClave;
	}

	/**
	 * @param flagClave the flagClave to set
	 */
	public void setFlagClave(boolean flagClave) {
		this.flagClave = flagClave;
	}
	/**
	 * @return the executePermissionSet
	 */
	public boolean isExecutePermissionSet() {
		return executePermissionSet;
	}
	/**
	 * @param executePermissionSet the executePermissionSet to set
	 */
	public void setExecutePermissionSet(boolean executePermissionSet) {
		this.executePermissionSet = executePermissionSet;
	}
	@Override
	public boolean applyPermision() {
		boolean isApplied = false;
		HashMap<String, Component> componentes = new HashMap<String, Component>();
		componentes.put(lblClave.getId(), lblClave);
		componentes.put(lblFechaHoraAlta.getId(), lblFechaHoraAlta);
		componentes.put(lblDescripcionCanal.getId(), lblDescripcionCanal);
		componentes.put(lblEstatus.getId(), lblEstatus);
		componentes.put(nombreCanal.getId(), nombreCanal);
		componentes.put(descripcionCanal.getId(), descripcionCanal);
		
		componentes.put(fechaInicio.getId(), fechaInicio);
		componentes.put(fechaFin.getId(), fechaFin);
		
		componentes.put(statusObjeto.getId(), statusObjeto);
		componentes.put(reporteExcelBtn.getId(), reporteExcelBtn);
		componentes.put(reporteCsvBtn.getId(), reporteCsvBtn);
		componentes.put(limpiarBtn.getId(), limpiarBtn);
		componentes.put(guardarBtn.getId(), guardarBtn);
		componentes.put(consultarBtn.getId(), consultarBtn);
		componentes.put(canalesGrid.getId(), canalesGrid);
		super.applyPermission(MapeadorConstants.CANALES, componentes);
		return isApplied;
	}	
}
