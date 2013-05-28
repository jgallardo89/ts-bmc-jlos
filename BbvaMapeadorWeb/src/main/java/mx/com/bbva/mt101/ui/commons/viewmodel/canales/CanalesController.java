package mx.com.bbva.mt101.ui.commons.viewmodel.canales;

import java.util.ArrayList;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.CanalVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.canal.dto.CanalDTO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.CanalBO;
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
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zkex.zul.Jasperreport;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;

/**
 * @author Julio Morales
 *
 */
public class CanalesController extends ControllerSupport implements IController {

	private static final long serialVersionUID = 1L;

	@Wire
	private Textbox nombreCanal;
	
	@Wire
	private Textbox descripcionCanal;
	
	@Wire
	private Textbox idEstatusObjeto;
	
	@Wire
	private Textbox idCanal;
	
	@Wire
	private Combobox statusObjeto;
	
	@Wire
	private Jasperreport report;
	
	private boolean btnGuardar;
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
	    //estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
	    EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
	    //estatusObjetoVO.setNombreTabla("CANALES");
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
	@NotifyChange({ "canalesVOs", "btnGuardar" })
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
				//registraBitacora(canalVO,4);
			}
		}
	}
	
	@Override
	@Command
	@NotifyChange({"btnGuardar" })
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
	}
	
	@Command
	@NotifyChange({"btnGuardar"})
	public void readSelected(@BindingParam("idCanal") final CanalVO canalVO){
		canalesVO = canalVO;
		canalVO.toString();
		nombreCanal.setValue(canalVO.getNombreCanal());
		descripcionCanal.setValue(canalVO.getDescripcionCanal());
		statusObjeto.setValue(canalVO.getNombreEstatusObjeto());
		idCanal.setValue(Integer.toString(canalVO.getIdCanal()));
		idEstatusObjeto.setValue(Integer.toString(canalVO.getIdEstatusObjeto()));
		btnGuardar = false;
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
    }
	
	@Command
	public void onShowReport(@BindingParam("type") final String type) {
		ReportesController controller = new ReportesController();
		ArrayList<String> headersReport = new ArrayList<String>();
		String titleReport = "Catálogo Canales";
		headersReport.add("Clave");
		headersReport.add("Descripción canal");
		headersReport.add("Fecha y Hora alta");
		headersReport.add("Status");
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Catálogo Canal");
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Catálogo Canal");
		}
		
		controller.createReport(generaLista(), headersReport, titleReport, report, type);
	}	
	
	private ArrayList<BeanGenerico> generaLista() {
		ArrayList<BeanGenerico> beanGenericos = new ArrayList<BeanGenerico>();
		BeanGenerico beanGenerico = null;
		for(CanalVO canalVO: canalesVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(canalVO.getNombreCanal());
			beanGenerico.setValor2(canalVO.getDescripcionCanal());
			beanGenerico.setValor3(canalVO.getFechaAlta().toString());
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
	
}
