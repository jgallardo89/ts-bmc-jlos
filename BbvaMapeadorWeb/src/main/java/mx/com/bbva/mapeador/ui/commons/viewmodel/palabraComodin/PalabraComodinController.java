package mx.com.bbva.mapeador.ui.commons.viewmodel.palabraComodin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.PalabraComodinVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.mapper.business.PalabraComodinBO;
import mx.com.bbva.bancomer.palabracomodin.dto.PalabraComodinDTO;
import mx.com.bbva.bancomer.utils.StringUtil;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.reportes.ReportesController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

/**
 * @author Julio Morales
 *
 */
public class PalabraComodinController extends ControllerSupport implements IController {

	private static final long serialVersionUID = -1115200714153449567L;

	@Wire
	private Textbox nombrePalabraComodin;
	@Wire
	private Textbox descripcionPalabraComodin;
	@Wire
	private Label lblNombrePalabraComodin;
	@Wire
	private Label lblDescripcionPalabraComodin;
	@Wire
	private Image reporteExcelBtn;
	@Wire
	private Image reporteCsvBtn;
	@Wire
	private Button limpiarBtn;
	@Wire
	private Button consultarBtn;
	@Wire
	private Grid palabraComodinGrid;
	
	private PalabraComodinDTO palabraComodinDTO;
	private List<PalabraComodinVO> comodinVOs;
	private boolean executePermissionSet;
	
	public PalabraComodinController() {
		this.read();
		this.comodinVOs = palabraComodinDTO.getPalabraComodinVOs();
	}
	
	@Override
	public Object read() {
		palabraComodinDTO = new PalabraComodinDTO();
		PalabraComodinVO palabraComodinVO = new PalabraComodinVO();
		PalabraComodinBO palabraComodinBO = new PalabraComodinBO();
		palabraComodinVO.toString();
		palabraComodinDTO.setPalabraComodinVO(palabraComodinVO);
		palabraComodinBO.readCommand(palabraComodinDTO);
		return palabraComodinDTO;
	}

	@Command
	@NotifyChange({ "comodinVOs" })
	public void readWithFilters() {
		palabraComodinDTO = new PalabraComodinDTO();
		ReportesController controller = new ReportesController();
		PalabraComodinVO palabraComodinVO = new PalabraComodinVO();
		PalabraComodinBO palabraComodinBO = new PalabraComodinBO();
		
		palabraComodinVO.setNombrePalabraComodin(StringUtil.validaLike(nombrePalabraComodin.getValue()));
		palabraComodinVO.setDescripcionPalabraComodin(StringUtil.validaLike(descripcionPalabraComodin.getValue()));
		palabraComodinVO.toString();
		palabraComodinDTO.setPalabraComodinVO(palabraComodinVO);
		comodinVOs = palabraComodinBO.readCommand(palabraComodinDTO).getPalabraComodinVOs();
		
		controller.registrarEvento(null, null, CommandConstants.CONSULTAR, "Catálogo Palabra Comodín");
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
	@Command
	public void clean() {
		descripcionPalabraComodin.clearErrorMessage();
		nombrePalabraComodin.clearErrorMessage();
		descripcionPalabraComodin.setValue(null);
		nombrePalabraComodin.setValue(null);
	}
	
	@Command
	public void onShowReport(@BindingParam("type") final String type) {
		ReportesController controller = new ReportesController();
		ArrayList<String> headersReport = new ArrayList<String>();
		headersReport.add("Nombre Palabra Comodín");
		headersReport.add("Descripción palabra comodín");
		
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Catálogo Palabra Comodín");
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Catálogo Palabra Comodín");
		}
		controller.createReport(generaLista(), headersReport, type, "PALABRA_COMODIN");
	}	
	
	private ArrayList<BeanGenerico> generaLista() {
		ArrayList<BeanGenerico> beanGenericos = new ArrayList<BeanGenerico>();
		BeanGenerico beanGenerico = null;
		for(PalabraComodinVO palabraComodinVO: comodinVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(palabraComodinVO.getNombrePalabraComodin());
			beanGenerico.setValor2(palabraComodinVO.getDescripcionPalabraComodin());
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}
	
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);       
        executePermissionSet = this.applyPermision();
    }

	/**
	 * @return the palabraComodinDTO
	 */
	public PalabraComodinDTO getPalabraComodinDTO() {
		return palabraComodinDTO;
	}

	/**
	 * @param palabraComodinDTO the palabraComodinDTO to set
	 */
	public void setPalabraComodinDTO(PalabraComodinDTO palabraComodinDTO) {
		this.palabraComodinDTO = palabraComodinDTO;
	}

	/**
	 * @return the comodinVOs
	 */
	public List<PalabraComodinVO> getComodinVOs() {
		return comodinVOs;
	}

	/**
	 * @param comodinVOs the comodinVOs to set
	 */
	public void setComodinVOs(List<PalabraComodinVO> comodinVOs) {
		this.comodinVOs = comodinVOs;
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
		componentes.put(lblNombrePalabraComodin.getId(), lblNombrePalabraComodin);
		componentes.put(lblDescripcionPalabraComodin.getId(), lblDescripcionPalabraComodin);
		componentes.put(nombrePalabraComodin.getId(), nombrePalabraComodin);
		componentes.put(descripcionPalabraComodin.getId(), descripcionPalabraComodin);
		componentes.put(reporteExcelBtn.getId(), reporteExcelBtn);
		componentes.put(reporteCsvBtn.getId(), reporteCsvBtn);
		componentes.put(limpiarBtn.getId(), limpiarBtn);
		componentes.put(consultarBtn.getId(), consultarBtn);
		componentes.put(palabraComodinGrid.getId(), palabraComodinGrid);
		super.applyPermission(MapeadorConstants.PALABRAS_COMODIN, componentes);
		return isApplied;
	}	

}
