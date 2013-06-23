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
 * Nombre de clase: PalabraComodinController.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.palabraComodin
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
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

// TODO: Auto-generated Javadoc
/**
 * The Class PalabraComodinController.
 *
 * @author Julio Morales
 */
public class PalabraComodinController extends ControllerSupport implements IController {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1115200714153449567L;

	/** The comodin v os. */
	private List<PalabraComodinVO> comodinVOs;
	
	/** The consultar btn. */
	@Wire
	private Button consultarBtn;
	
	/** The descripcion palabra comodin. */
	@Wire
	private Textbox descripcionPalabraComodin;
	
	/** The execute permission set. */
	private boolean executePermissionSet;
	
	/** The lbl descripcion palabra comodin. */
	@Wire
	private Label lblDescripcionPalabraComodin;
	
	/** The lbl nombre palabra comodin. */
	@Wire
	private Label lblNombrePalabraComodin;
	
	/** The limpiar btn. */
	@Wire
	private Button limpiarBtn;
	
	/** The nombre palabra comodin. */
	@Wire
	private Textbox nombrePalabraComodin;
	
	/** The palabra comodin dto. */
	private PalabraComodinDTO palabraComodinDTO;
	
	/** The palabra comodin grid. */
	@Wire
	private Grid palabraComodinGrid;
	
	/** The reporte csv btn. */
	@Wire
	private Image reporteCsvBtn;
	
	/** The reporte excel btn. */
	@Wire
	private Image reporteExcelBtn;
	
	/**
	 * Instantiates a new palabra comodin controller.
	 */
	public PalabraComodinController() {
		this.read();
		this.comodinVOs = palabraComodinDTO.getPalabraComodinVOs();
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
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#clean()
	 */
	@Override
	@Command
	public void clean() {
		descripcionPalabraComodin.clearErrorMessage();
		nombrePalabraComodin.clearErrorMessage();
		descripcionPalabraComodin.setValue(null);
		nombrePalabraComodin.setValue(null);
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
		for(PalabraComodinVO palabraComodinVO: comodinVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(palabraComodinVO.getNombrePalabraComodin());
			beanGenerico.setValor2(palabraComodinVO.getDescripcionPalabraComodin());
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}

	/**
	 * Gets the comodin v os.
	 *
	 * @return the comodinVOs
	 */
	public List<PalabraComodinVO> getComodinVOs() {
		return comodinVOs;
	}
	
	/**
	 * Gets the palabra comodin dto.
	 *
	 * @return the palabraComodinDTO
	 */
	public PalabraComodinDTO getPalabraComodinDTO() {
		return palabraComodinDTO;
	}	
	
	/**
	 * Checks if is execute permission set.
	 *
	 * @return the executePermissionSet
	 */
	public boolean isExecutePermissionSet() {
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
		headersReport.add("Nombre palabra comodín");
		headersReport.add("Descripción palabra comodín");
		
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Catálogo Palabras Comodín");
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Catálogo Palabras Comodín");
		}
		controller.createReport(generaLista(), headersReport, type, "PALABRA_COMODIN");
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read()
	 */
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

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read(java.lang.Object)
	 */
	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Read with filters.
	 */
	@Command
	@NotifyChange({ "comodinVOs" })
	public void readWithFilters() {
		palabraComodinDTO = new PalabraComodinDTO();
		ReportesController controller = new ReportesController();
		PalabraComodinVO palabraComodinVO = new PalabraComodinVO();
		PalabraComodinBO palabraComodinBO = new PalabraComodinBO();
		
		palabraComodinVO.setNombrePalabraComodin(nombrePalabraComodin.getValue().isEmpty()?"%":"%"+nombrePalabraComodin.getValue()+"%");
		palabraComodinVO.setDescripcionPalabraComodin(StringUtil.validaLike(descripcionPalabraComodin.getValue()));
		palabraComodinVO.toString();
		palabraComodinDTO.setPalabraComodinVO(palabraComodinVO);
		comodinVOs = palabraComodinBO.readCommand(palabraComodinDTO).getPalabraComodinVOs();
		
		controller.registrarEvento(null, null, CommandConstants.CONSULTAR, "Catálogo Palabra Comodín");
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#save()
	 */
	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Sets the comodin v os.
	 *
	 * @param comodinVOs the comodinVOs to set
	 */
	public void setComodinVOs(List<PalabraComodinVO> comodinVOs) {
		this.comodinVOs = comodinVOs;
	}
	
	/**
	 * Sets the execute permission set.
	 *
	 * @param executePermissionSet the executePermissionSet to set
	 */
	public void setExecutePermissionSet(boolean executePermissionSet) {
		this.executePermissionSet = executePermissionSet;
	}
	
	/**
	 * Sets the palabra comodin dto.
	 *
	 * @param palabraComodinDTO the palabraComodinDTO to set
	 */
	public void setPalabraComodinDTO(PalabraComodinDTO palabraComodinDTO) {
		this.palabraComodinDTO = palabraComodinDTO;
	}	

}
