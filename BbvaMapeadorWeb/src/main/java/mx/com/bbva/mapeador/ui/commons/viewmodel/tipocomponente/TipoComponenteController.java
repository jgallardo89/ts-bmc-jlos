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
 * Nombre de aplicaci�n: MAPEADOR
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
 * Nombre de clase: TipoComponenteController.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.tipocomponente
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.tipocomponente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.TipoComponenteVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.mapper.business.TipoComponenteBO;
import mx.com.bbva.bancomer.tipocomponente.dto.TipoComponenteDTO;
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
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoComponenteController.
 */
public class TipoComponenteController extends ControllerSupport implements
		IController {

	/** The execute permission set. */
	private boolean executePermissionSet;
	
	/** The guardar btn. */
	@Wire
	private Button guardarBtn;
	
	/** The id tipo componente. */
	@Wire
	private Intbox idTipoComponente;

	/** The lbl tipo componente. */
	@Wire
	private Label lblTipoComponente;
	
	/** The limpiar btn. */
	@Wire
	private Button limpiarBtn;

	/** The reporte csv btn. */
	@Wire
	private Image reporteCsvBtn;

	/** The reporte excel btn. */
	@Wire
	private Image reporteExcelBtn;

	/** The tipo componente. */
	@Wire
	private Textbox tipoComponente;

	/** The tipo componente dto. */
	private TipoComponenteDTO tipoComponenteDTO;
	
	/** The tipo componentes grid. */
	@Wire
	private Grid tipoComponentesGrid;
	
	/** The tipo componente vo. */
	private TipoComponenteVO tipoComponenteVO;
	
	/** The tipo componente v os. */
	private List<TipoComponenteVO> tipoComponenteVOs;
	
	/**
	 * Instantiates a new tipo componente controller.
	 */
	public TipoComponenteController() {
		tipoComponenteVOs = ((TipoComponenteDTO)this.read()).getTipoComponenteVOs();
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
		componentes.put(lblTipoComponente.getId(),lblTipoComponente);
		componentes.put(tipoComponente.getId(),tipoComponente);
		componentes.put(reporteExcelBtn.getId(),reporteExcelBtn);
		componentes.put(reporteCsvBtn.getId(),reporteCsvBtn);
		componentes.put(guardarBtn.getId(),guardarBtn);
		componentes.put(limpiarBtn.getId(),limpiarBtn);
		componentes.put(tipoComponentesGrid.getId(),tipoComponentesGrid);		
		super.applyPermission(MapeadorConstants.TIPO_COMPONENTE, componentes);
		return isApplied;
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#clean()
	 */
	@Override
	@Command	
	public void clean() {
		tipoComponente.clearErrorMessage();
		tipoComponente.setValue(null);		
		idTipoComponente.setValue(0);
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
		for(TipoComponenteVO tipoComponenteVO: tipoComponenteVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(Integer.toString(tipoComponenteVO.getIdTipoComponente()));
			beanGenerico.setValor2(tipoComponenteVO.getNombreTipoComponente());					
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}

	/**
	 * Gets the tipo componente v os.
	 *
	 * @return the tipoComponenteVOs
	 */
	public final List<TipoComponenteVO> getTipoComponenteVOs() {
		return tipoComponenteVOs;
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
		headersReport.add("Identificador Tipo Componente");
		headersReport.add("Nombre Tipo Componente");		
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Tipo Componente");
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Tipo Componente");
		}
		controller.createReport(generaLista(), headersReport, type, "TIPO-COMPONENTE");				
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read()
	 */
	@Override
	public Object read() {		
		tipoComponenteDTO = new TipoComponenteDTO();
		TipoComponenteBO tipoComponenteBO = new TipoComponenteBO();
		tipoComponenteDTO = tipoComponenteBO.readCommand(tipoComponenteDTO);
		return tipoComponenteDTO;
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
	 *
	 * @param tipoComponenteVO the tipo componente vo
	 */
	@Command		
	public void readSelected(@BindingParam("idTipoComponente") final TipoComponenteVO tipoComponenteVO){
		this.tipoComponenteVO = tipoComponenteVO;
		this.tipoComponente.setValue(tipoComponenteVO.getNombreTipoComponente());		
		this.idTipoComponente.setValue(tipoComponenteVO.getIdTipoComponente());		
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#save()
	 */
	@Override
	@Command
	@NotifyChange({"tipoComponenteVOs"})
	public void save() {
		if(tipoComponente.getValue().isEmpty()){
			tipoComponente.setErrorMessage("Favor de introducir el nombre del tipo de componente.");
		}else{
						
			tipoComponenteDTO = new TipoComponenteDTO();
			TipoComponenteVO tipoComponenteVO = new TipoComponenteVO();
			ReportesController reportesController = new ReportesController();
			tipoComponenteVO.setIdTipoComponente(idTipoComponente.getValue());
			tipoComponenteVO.setNombreTipoComponente(tipoComponente.getValue().toUpperCase().trim());			
			tipoComponenteDTO.setTipoComponenteVO(tipoComponenteVO);			
			TipoComponenteBO tipoComponenteBO = new TipoComponenteBO();
			
			TipoComponenteDTO tipoComponenteDTOValidaExiste = new TipoComponenteDTO();
			TipoComponenteVO tipoComponenteVOValidaExiste = new TipoComponenteVO();
			tipoComponenteVOValidaExiste.setNombreTipoComponente(tipoComponente.getValue().toUpperCase().trim());
			tipoComponenteDTOValidaExiste.setCommandId(CommandConstants.CONSULTA_EXISTE_TIPO_COMPONENTE);
			tipoComponenteDTOValidaExiste.setTipoComponenteVO(tipoComponenteVOValidaExiste);
			tipoComponenteDTOValidaExiste = tipoComponenteBO.readCommand(tipoComponenteDTOValidaExiste);
			tipoComponenteVOValidaExiste = tipoComponenteDTOValidaExiste.getTipoComponenteVOs().get(0);
			int existe = tipoComponenteVOValidaExiste.getExiste();
			if(existe==0){
				if(idTipoComponente.getValue()!=0){
					tipoComponenteBO.updateCommand(tipoComponenteDTO);
					reportesController.registrarEvento(tipoComponenteVO, this.tipoComponenteVO, CommandConstants.MODIFICACION, "TIPO-COMPONENTE");
					Messagebox.show("El registro se actualiz� con exito",
							"Informaci�n", Messagebox.OK,
							Messagebox.INFORMATION);
				}else{
					tipoComponenteBO.createCommand(tipoComponenteDTO);
					reportesController.registrarEvento(null, null, CommandConstants.ALTA, "TIPO-COMPONENTE");
					Messagebox.show("El registro se cre� con exito",
							"Informaci�n", Messagebox.OK,
							Messagebox.INFORMATION);
				}						
				clean();
				tipoComponenteVOs = ((TipoComponenteDTO)this.read()).getTipoComponenteVOs();
			}else{
				Messagebox.show("El tipo de componente ya existe",
						"Error", Messagebox.OK,
						Messagebox.ERROR);
			}
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
	 * Sets the tipo componente v os.
	 *
	 * @param tipoComponenteVOs the tipoComponenteVOs to set
	 */
	public final void setTipoComponenteVOs(List<TipoComponenteVO> tipoComponenteVOs) {
		this.tipoComponenteVOs = tipoComponenteVOs;
	}
}
