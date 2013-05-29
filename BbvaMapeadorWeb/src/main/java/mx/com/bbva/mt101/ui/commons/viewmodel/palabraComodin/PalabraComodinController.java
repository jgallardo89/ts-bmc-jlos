package mx.com.bbva.mt101.ui.commons.viewmodel.palabraComodin;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;

import mx.com.bbva.bancomer.bitacora.dto.BitacoraDTO;
import mx.com.bbva.bancomer.bitacora.dto.CampoDTO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PalabraComodinVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ProductoVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.mapper.business.PalabraComodinBO;
import mx.com.bbva.bancomer.palabracomodin.dto.PalabraComodinDTO;
import mx.com.bbva.bancomer.utils.StringUtil;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;
import mx.com.bbva.mt101.ui.commons.viewmodel.reportes.ReportesController;

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
	
	private PalabraComodinDTO palabraComodinDTO;
	private List<PalabraComodinVO> comodinVOs;
	
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
		
		controller.registrarEvento(null, null, CommandConstants.CONSULTAR, "Cat�logo Palabra Comod�n");
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
		String titleReport = "Palabras Comod�n";
		headersReport.add("Nombre Palabra Comod�n");
		headersReport.add("Descripci�n Palabra Comod�n");
		
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Cat�logo Palabra Comod�n");
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Cat�logo Palabra Comod�n");
		}		
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

	@Override
	public boolean applyPermision() {
		// TODO Auto-generated method stub
		return false;
	}

}
