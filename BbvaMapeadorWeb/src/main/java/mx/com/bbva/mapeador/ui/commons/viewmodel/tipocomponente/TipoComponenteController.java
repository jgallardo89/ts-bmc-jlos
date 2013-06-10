package mx.com.bbva.mapeador.ui.commons.viewmodel.tipocomponente;

import java.util.HashMap;
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
import org.zkoss.zul.Button;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import mx.com.bbva.bancomer.bussinnes.model.vo.PerfilVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.TipoComponenteVO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.mapper.business.TipoComponenteBO;
import mx.com.bbva.bancomer.tipocomponente.dto.TipoComponenteDTO;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.reportes.ReportesController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

public class TipoComponenteController extends ControllerSupport implements
		IController {

	private List<TipoComponenteVO> tipoComponenteVOs;
	private TipoComponenteDTO tipoComponenteDTO;
	private TipoComponenteVO tipoComponenteVO;

	private boolean executePermissionSet;
	
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

	/**
	 * @return the tipoComponenteVOs
	 */
	public final List<TipoComponenteVO> getTipoComponenteVOs() {
		return tipoComponenteVOs;
	}

	/**
	 * @param tipoComponenteVOs the tipoComponenteVOs to set
	 */
	public final void setTipoComponenteVOs(List<TipoComponenteVO> tipoComponenteVOs) {
		this.tipoComponenteVOs = tipoComponenteVOs;
	}

	@Wire
	private Label lblTipoComponente;
	@Wire
	private Textbox tipoComponente;
	@Wire
	private Intbox idTipoComponente;
	@Wire
	private Image reporteExcelBtn;
	@Wire
	private Image reporteCsvBtn;
	@Wire
	private Button guardarBtn; 
	@Wire
	private Button limpiarBtn;
	@Wire
	private Grid tipoComponentesGrid;
	
	public TipoComponenteController() {
		tipoComponenteVOs = ((TipoComponenteDTO)this.read()).getTipoComponenteVOs();
	}
	@Override
	public Object read() {		
		tipoComponenteDTO = new TipoComponenteDTO();
		TipoComponenteBO tipoComponenteBO = new TipoComponenteBO();
		tipoComponenteDTO = tipoComponenteBO.readCommand(tipoComponenteDTO);
		return tipoComponenteDTO;
	}

	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

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
					Messagebox.show("El registro se actualizó con exito",
							"Información", Messagebox.OK,
							Messagebox.INFORMATION);
				}else{
					tipoComponenteBO.createCommand(tipoComponenteDTO);
					reportesController.registrarEvento(null, null, CommandConstants.ALTA, "TIPO-COMPONENTE");
					Messagebox.show("El registro se creó con exito",
							"Información", Messagebox.OK,
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

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Command	
	public void clean() {
		tipoComponente.clearErrorMessage();
		tipoComponente.setValue(null);		
		idTipoComponente.setValue(0);
	}

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

	@Command		
	public void readSelected(@BindingParam("idTipoComponente") final TipoComponenteVO tipoComponenteVO){
		this.tipoComponenteVO = tipoComponenteVO;
		this.tipoComponente.setValue(tipoComponenteVO.getNombreTipoComponente());		
		this.idTipoComponente.setValue(tipoComponenteVO.getIdTipoComponente());		
	}
	
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
        executePermissionSet = this.applyPermision();
    }
}
