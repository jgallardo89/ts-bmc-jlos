package mx.com.bbva.mt101.ui.commons.viewmodel.canales;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.CanalVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.canal.dto.CanalDTO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

import org.apache.log4j.Logger;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;

/**
 * @author Julio Morales
 *
 */
public class CanalesController extends ControllerSupport implements IController {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(ControllerSupport.class);
	
	
	private CanalDTO canalDTO = (CanalDTO)this.read();		
	
	@Wire
	private Textbox nombreCanal;
	
	@Wire
	private Textbox descripcionCanal;
	
	@Wire
	private Textbox rutaCanalEntrada;
	
	@Wire
	private Textbox rutaCanalSalida;
	
	@Wire
	private Textbox idEstatusObjeto;
	
	@Wire
	private Textbox idCanal;
	
	@Wire
	private Combobox statusObjeto;
	
	@Override
	public Object read() {
		//Llenado del Combo de Status Objeto
		CanalDTO canalDTO = new CanalDTO();
		List<EstatusObjetoVO> estatusObjetoVOs = new ArrayList<EstatusObjetoVO>();
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
		estatusObjetoVO.setIdEstatusObjeto(1);
		estatusObjetoVO.setNombreEstatusObjeto("Activo");
		estatusObjetoVOs.add(estatusObjetoVO);
		estatusObjetoVO = new EstatusObjetoVO();
		estatusObjetoVO.setIdEstatusObjeto(2);
		estatusObjetoVO.setNombreEstatusObjeto("Inactivo");
		estatusObjetoVOs.add(estatusObjetoVO);
		canalDTO.setEstatusObjetoVOs(estatusObjetoVOs);
		
		List<CanalVO> canalVOs = new ArrayList<CanalVO>();
		CanalVO canalVO = new CanalVO();
		canalVO.setIdCanal(1);
		canalVO.setNombreCanal("H2H");
		canalVO.setDescripcionCanal("Host to Host");
		canalVO.setFechaAlta(new Date());
		canalVO.setRutaCanalEntrada("/gmm/mx/mapeador/ejemplo/");
		canalVO.setRutaCanalSalida("/gmm/mx/mapeador/ejemplo2/");
		canalVO.setNombreEstatusObjeto("Activo");
		canalVOs.add(canalVO);
		canalVO = new CanalVO();
		canalVO.setIdCanal(2);
		canalVO.setNombreCanal("H2H E");
		canalVO.setDescripcionCanal("Host to Host example");
		canalVO.setFechaAlta(new Date());
		canalVO.setRutaCanalEntrada("/gmm/mx/mapeador/x/");
		canalVO.setRutaCanalSalida("/gmm/mx/mapeador/x/");
		canalVO.setNombreEstatusObjeto("Inactivo");
		canalVOs.add(canalVO);
		canalDTO.setCanalVOs(canalVOs);
		return canalDTO;
	}
	
	@Override
	@Command
	public void save() {
		boolean errorGuardar = false;
		int estatusObjeto = 0;
		if (statusObjeto.getSelectedItem() == null
				|| statusObjeto.getSelectedItem().getValue() == null
				|| statusObjeto.getSelectedItem().getValue().toString().isEmpty()) {
			estatusObjeto = statusObjeto.getSelectedIndex();
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
		/*if (rutaCanalEntrada.getValue().isEmpty()) {
			rutaCanalEntrada
					.setErrorMessage("Favor de introducir la ruta de entrada del Canal");
			errorGuardar = true;
		}
		if (rutaCanalSalida.getValue().isEmpty()) {
			rutaCanalSalida
			.setErrorMessage("Favor de introducir la ruta de salida del Canal");
			errorGuardar = true;
		}*/
		if(!errorGuardar){
			CanalDTO canalDTO = new CanalDTO();
			CanalVO canalVO = new CanalVO();
			canalVO.setNombreCanal("H2H");
			canalVO.setDescripcionCanal("Host to Host");
			canalVO.setFechaAlta(new Date());
			canalVO.setRutaCanalEntrada("/gmm/mx/mapeador/ejemplo/");
			canalVO.setRutaCanalSalida("/gmm/mx/mapeador/ejemplo2/");
			canalVO.setIdEstatusObjeto(estatusObjeto);
			canalDTO.setCanalVO(canalVO);
			canalDTO.toString(BbvaAbstractDataTransferObject.XML);
		}
	}
	
	@Override
	@Command
	public void clean() {
		nombreCanal.clearErrorMessage();
		descripcionCanal.clearErrorMessage();
		//rutaCanalEntrada.clearErrorMessage();
		//rutaCanalSalida.clearErrorMessage();
		statusObjeto.clearErrorMessage();
		
		nombreCanal.setValue(null);
		descripcionCanal.setValue(null);
		//rutaCanalEntrada.setValue(null);
		//rutaCanalSalida.setValue(null);
		statusObjeto.setValue(null);
		
		idCanal.setValue(null);
		idEstatusObjeto.setValue(null);
	}
	
	@Command
	public void readSelected(@BindingParam("idCanal") final CanalVO canalVO){
		canalVO.toString();
		nombreCanal.setValue(canalVO.getNombreCanal());
		descripcionCanal.setValue(canalVO.getDescripcionCanal());
		//rutaCanalEntrada.setValue(canalVO.getRutaCanalEntrada());
		//rutaCanalSalida.setValue(canalVO.getRutaCanalSalida());
		statusObjeto.setValue(canalVO.getNombreEstatusObjeto());
		
		//idCanal.setValue(Integer.toString(canalVO.getIdCanal()));
		//idEstatusObjeto.setValue(canalVO);
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
	
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
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

}
