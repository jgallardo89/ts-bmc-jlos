package mx.com.bbva.mapeador.ui.commons.viewmodel.mapagmm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MapaGmmVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.MapaGmmBO;
import mx.com.bbva.bancomer.mappers.mapagmm.dto.MapaGmmDTO;
import mx.com.bbva.mapeador.security.session.user.SessionUser;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.pantalla.PantallaController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;
import mx.com.bbva.mt101.ui.commons.viewmodel.reportes.ReportesController;

import org.apache.log4j.Logger;
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

public class MapaGmmController  extends ControllerSupport implements  IController{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1420939655567271610L;
	private static final Logger logger = Logger.getLogger(PantallaController.class);
	
	public SessionUser getSessionUser(){
		logger.debug( "Entrada getSessionUser          -- OK" );		
		String cveUsuario = null;
		logger.debug( "Datos de usuario -- " + cveUsuario);
		SessionUser sessionUser = new SessionUser();
		sessionUser.setCveUsuario(cveUsuario);
		logger.debug( "Salida getSessionUser          -- OK" );
		return sessionUser;
	}
	
	@Wire
	private Textbox identificadorMapa;
	@Wire
	private Datebox fechaAlta;
	@Wire
	private Datebox fechaModificacion;
	@Wire
	private Textbox descripcionMapa;
	@Wire
	private Combobox status;
	@Wire
	private Textbox idStatus;
	@Wire
	private Textbox idMapaGmm;	
	
	
	@Wire
	private Label lblIdentificadorMapa;
	@Wire
	private Label lblFechaAlta;
	@Wire
	private Label lblDescricionMapa;
	@Wire
	private Label lblFechaModificacion;
	@Wire
	private Label lblEstatus;
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
	private Grid mapaGmmsGrid;
	
	private MapaGmmDTO mapaGmmDTO =  (MapaGmmDTO) this.read();
	
	private List<MapaGmmVO> mapaGmmVOs = mapaGmmDTO.getMapaGmmVOs(); 
	
	private String strIdentificadorMapa;
	
	private String strFechaAlta;
	
	private String strFechaModificacion;
	
	private String strDescripcionMapa;
	
	private String strStatus;
	
	private String strIdStatus;
	
	private String strIdMapaGmm;

	private MapaGmmVO mapaGmmVO;
	private boolean executePermissionSet;
	
	@Override
	public Object read() {
		//Catalogo Estatus
		ReportesController controller = new ReportesController();
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
		estatusObjetoVO.setNombreTabla(CommandConstants.NOMBRE_TABLA_MAPA);		
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
		MapaGmmVO mapaGmmVO = new MapaGmmVO();
		MapaGmmDTO mapaGmmDTO = new MapaGmmDTO();
		MapaGmmBO mapaGmmBO = new MapaGmmBO();
		mapaGmmDTO = mapaGmmBO.readCommand(mapaGmmDTO);
		logger.info("::::::::::::::SIZE::::::::::" + mapaGmmDTO.getMapaGmmVOs());
		//Seteo Catalogo de Estatus
		mapaGmmDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
		controller.registrarEvento(mapaGmmVO, mapaGmmVO, CommandConstants.CONSULTAR,"Cat�logo de Mapa");
		return mapaGmmDTO;
	}

	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false); 
        executePermissionSet = this.applyPermision();
    }
	
	@Command
	public void readSelected(@BindingParam("idMapaGmm") final MapaGmmVO mapaGmmVO){
		//Seteo de datos de Acuerdo al id de los compoenetes del HTML VS VO
		mapaGmmVO.toString();
		this.mapaGmmVO = mapaGmmVO;
		status.setValue(mapaGmmVO.getNombreEstatusObjeto());
		identificadorMapa.setValue(mapaGmmVO.getNombreMapaGmm());
		descripcionMapa.setValue(mapaGmmVO.getDescripcionMapaGmm());
		idMapaGmm.setValue(String.valueOf(mapaGmmVO.getIdMapaGmm()));
		
		identificadorMapa.setDisabled(true);
	}
	
	//Cambiar al objeto que pertenezca el componente en este caso mapaGmmVOs
	@Command
	@NotifyChange({ "mapaGmmVOs" })
	public void readWithFilters() {
		ReportesController controller = new ReportesController();
		MapaGmmDTO mapaGmmDTO = new MapaGmmDTO();
		MapaGmmVO mapaGmmVO = new MapaGmmVO(); 
		//Textbox
		mapaGmmVO.setNombreMapaGmm(identificadorMapa.getValue().isEmpty()?"%":"%"+identificadorMapa.getValue().toUpperCase()+"%");
		mapaGmmVO.setDescripcionMapaGmm(descripcionMapa.getValue().isEmpty()?"%":"%"+descripcionMapa.getValue().toUpperCase()+"%");
		//Fechas
		DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		logger.debug(" :::::::::::: "+dateFormat.format(fechaAlta.getValue()));
		mapaGmmVO.setFechaAlta(fechaAlta.getValue());
		mapaGmmVO.setFechaModificacion(fechaModificacion.getValue());
		
		//Combos Validar el nombre de los parametros en HTML VS Controller
		mapaGmmVO.setIdEstatusObjeto((Integer.parseInt(idStatus.getValue().isEmpty()?"0":idStatus.getValue())));
		
		//Consulta Parametrizada

		mapaGmmDTO.setMapaGmmVO(mapaGmmVO);
		mapaGmmDTO.toString(BbvaAbstractDataTransferObject.XML);	
		
		//LLamada a BO  MapaGmm para consulta por criterio
		MapaGmmBO MapaGmmBO = new MapaGmmBO();
		
		//Asignacion resultado de consulta al mismo DTO de MapaGmm
		mapaGmmDTO = MapaGmmBO.readCommand(mapaGmmDTO);
		
		//Tama�o de la lista de acuerdo al criterio de busqueda y objeto MapaGmm
		if(mapaGmmDTO.getMapaGmmVOs() != null) {
			logger.debug("size:"+mapaGmmDTO.getMapaGmmVOs().size());
		} else{
			logger.debug(":::::::::::Lista Vacia::::::::::");
		}
		//Asignacion de la lista a la variable global de la clase
		mapaGmmVOs = mapaGmmDTO.getMapaGmmVOs();
		controller.registrarEvento(mapaGmmVO, mapaGmmVO,  CommandConstants.CONSULTAR,"Cat�logo de Mapa");

		
	}
	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Command
	@NotifyChange({ "mapaGmmVOs" })
	public void save() {
		ReportesController controller = new ReportesController();
		//Validar Todos Los campos de pantalla
		boolean errorGuardar = false; 
		if (status.getSelectedItem() == null
				|| status.getSelectedItem().getValue() == null
				|| status.getSelectedItem().getValue().toString().isEmpty()) {
			status.setErrorMessage("Favor de seleccionar la Status.");
			errorGuardar = true;
		}
		if (identificadorMapa.getValue().isEmpty()) {
			identificadorMapa
					.setErrorMessage("Favor de introducir Identificador Mapa");
			errorGuardar = true;
		} 
		if (descripcionMapa.getValue().isEmpty()) {
			descripcionMapa
					.setErrorMessage("Favor de introducir Descripcion Mapa");
			errorGuardar = true;
		} 
		if(!errorGuardar){
			if(!idMapaGmm.getValue().isEmpty()){
				logger.info("::::::Actualizar::::");
				MapaGmmDTO mapaGmmDTO = new MapaGmmDTO();
				MapaGmmVO mapaGmmVO = new MapaGmmVO();
				mapaGmmVO.setIdMapaGmm(Integer.parseInt(idMapaGmm.getValue().isEmpty()?"0":idMapaGmm.getValue()));
				mapaGmmVO.setIdEstatusObjeto(Integer.parseInt(status.getSelectedItem().getValue().toString().isEmpty()?"1":status.getSelectedItem().getValue().toString()));
				
				mapaGmmVO.setNombreMapaGmm(identificadorMapa.getValue().toUpperCase());
				mapaGmmVO.setDescripcionMapaGmm(descripcionMapa.getValue().toUpperCase());
							
				//Seteo de VO a DTO 
				mapaGmmDTO.setMapaGmmVO(mapaGmmVO);
				mapaGmmDTO.toString(BbvaAbstractDataTransferObject.XML);	
				
				MapaGmmBO mapaGmmBO = new MapaGmmBO();
				mapaGmmBO.updateCommand(mapaGmmDTO);
				controller.registrarEvento(mapaGmmVO, this.mapaGmmVO, CommandConstants.MODIFICACION,"Cat�logo de Mapa");
				clean();			
				
				//Textbox
				mapaGmmVO = new MapaGmmVO();
				
				//Consulta Parametrizada

				mapaGmmDTO.setMapaGmmVO(mapaGmmVO);
				mapaGmmDTO.toString(BbvaAbstractDataTransferObject.XML);	
				
				//LLamada a BO  MapaGmm para consulta por criterio
				MapaGmmBO MapaGmmBO = new MapaGmmBO();
				
				//Asignacion resultado de consulta al mismo DTO de MapaGmm
				mapaGmmDTO = MapaGmmBO.readCommand(mapaGmmDTO);
				
				
				Messagebox.show("Registro actualizado con exito!!",
						"Confirmaci�n", Messagebox.OK,
						Messagebox.INFORMATION);
				
				mapaGmmVOs = mapaGmmDTO.getMapaGmmVOs();
				identificadorMapa.setDisabled(false);
				
			}else{ 
				logger.info("::::::NO Crea::::"); 
//				MapaGmmDTO mapaGmmDTO = new MapaGmmDTO();
//				MapaGmmVO mapaGmmVO = new MapaGmmVO();
//				mapaGmmVO.setIdMapaGmm(Integer.parseInt(idMapaGmm.getValue().isEmpty()?"0":idMapaGmm.getValue()));
//				mapaGmmVO.setIdEstatusObjeto(Integer.parseInt((status.getSelectedItem().getValue().toString().isEmpty())?"1":status.getSelectedItem().getValue().toString()));
//				
//				mapaGmmVO.setNombreMapaGmm(identificadorMapa.getValue().toUpperCase());
//				mapaGmmVO.setDescripcionMapaGmm(descripcionMapa.getValue().toUpperCase());
//							
//				//Seteo de VO a DTO 
//				mapaGmmDTO.setMapaGmmVO(mapaGmmVO);
//				mapaGmmDTO.toString(BbvaAbstractDataTransferObject.XML);	
//				
//				MapaGmmBO mapaGmmBO = new MapaGmmBO();
//				mapaGmmBO.createCommand(mapaGmmDTO);
//				clean();			
//				
//				//Textbox
//				mapaGmmVO = new MapaGmmVO();
//				//Consulta Parametrizada
//
//				mapaGmmDTO.setMapaGmmVO(mapaGmmVO);
//				mapaGmmDTO.toString(BbvaAbstractDataTransferObject.XML);	
//				
//				//LLamada a BO  MapaGmm para consulta por criterio
//				MapaGmmBO MapaGmmBO = new MapaGmmBO();
//				
//				//Asignacion resultado de consulta al mismo DTO de MapaGmm
//				mapaGmmDTO = MapaGmmBO.readCommand(mapaGmmDTO);
//				
//				
//				Messagebox.show("Registro creo con exito!!",
//						"Confirmaci�n", Messagebox.OK,
//						Messagebox.INFORMATION);
//				mapaGmmVOs = mapaGmmDTO.getMapaGmmVOs();
			}
		}
	}
	
	@Override
	@Command
	public void clean() {
		//Mensajes HTML
		identificadorMapa.clearErrorMessage();
		fechaAlta.clearErrorMessage();
		fechaModificacion.clearErrorMessage();
		descripcionMapa.clearErrorMessage();
		status.clearErrorMessage();
		
		
		//Mensajes Setear a Null
		identificadorMapa.setValue(null); 
		descripcionMapa.setValue(null);
		status.setValue(null);
		 
		//Setear IDs Invisibles
		idMapaGmm.setValue(null);
		idStatus.setValue(null);
		
		identificadorMapa.setDisabled(false);
		
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	@Command
	public void onShowReport(@BindingParam("type") final String type) {
		ReportesController controller = new ReportesController();
		ArrayList<String> headersReport = new ArrayList<String>();
		String titleReport = "Cat�logo Mapas";
		headersReport.add("Identificador Mapa");
		headersReport.add("Descripci�n");
		headersReport.add("Fecha Alta");
		headersReport.add("Fecha modificaci�n"); 
		headersReport.add("Estatus");
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Cat�logo de Mapa");
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Cat�logo de Mapa");
		}
		controller.createReport(generaLista(), headersReport, titleReport, "MAPA");
	}	
	
	private ArrayList<BeanGenerico> generaLista() {
		ArrayList<BeanGenerico> beanGenericos = new ArrayList<BeanGenerico>();
		BeanGenerico beanGenerico = null;
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		for(MapaGmmVO mapaGmmVO: mapaGmmVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(mapaGmmVO.getNombreMapaGmm());
			beanGenerico.setValor2(mapaGmmVO.getDescripcionMapaGmm());
			beanGenerico.setValor3(dateFormat.format(mapaGmmVO.getFechaAlta()));
			beanGenerico.setValor4(dateFormat.format(mapaGmmVO.getFechaModificacion())); 
			beanGenerico.setValor5(mapaGmmVO.getNombreEstatusObjeto());  
			
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}
	
	/**
	 * @return the identificadorMapa
	 */
	public Textbox getIdentificadorMapa() {
		return identificadorMapa;
	}

	/**
	 * @param identificadorMapa the identificadorMapa to set
	 */
	public void setIdentificadorMapa(Textbox identificadorMapa) {
		this.identificadorMapa = identificadorMapa;
	}

	

	/**
	 * @return the fechaAlta
	 */
	public Datebox getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(Datebox fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * @return the fechaModificacion
	 */
	public Datebox getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Datebox fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the descripcionMapa
	 */
	public Textbox getDescripcionMapa() {
		return descripcionMapa;
	}

	/**
	 * @param descripcionMapa the descripcionMapa to set
	 */
	public void setDescripcionMapa(Textbox descripcionMapa) {
		this.descripcionMapa = descripcionMapa;
	}

	/**
	 * @return the status
	 */
	public Combobox getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Combobox status) {
		this.status = status;
	}

	/**
	 * @return the idStatus
	 */
	public Textbox getIdStatus() {
		return idStatus;
	}

	/**
	 * @param idStatus the idStatus to set
	 */
	public void setIdStatus(Textbox idStatus) {
		this.idStatus = idStatus;
	}

	/**
	 * @return the mapaGmmDTO
	 */
	public MapaGmmDTO getMapaGmmDTO() {
		return mapaGmmDTO;
	}

	/**
	 * @param mapaGmmDTO the mapaGmmDTO to set
	 */
	public void setMapaGmmDTO(MapaGmmDTO mapaGmmDTO) {
		this.mapaGmmDTO = mapaGmmDTO;
	}

	/**
	 * @return the mapaGmmVOs
	 */
	public List<MapaGmmVO> getMapaGmmVOs() {
		return mapaGmmVOs;
	}

	/**
	 * @param mapaGmmVOs the mapaGmmVOs to set
	 */
	public void setMapaGmmVOs(List<MapaGmmVO> mapaGmmVOs) {
		this.mapaGmmVOs = mapaGmmVOs;
	}

	/**
	 * @return the strIdentificadorMapa
	 */
	public String getStrIdentificadorMapa() {
		return strIdentificadorMapa;
	}

	/**
	 * @param strIdentificadorMapa the strIdentificadorMapa to set
	 */
	public void setStrIdentificadorMapa(String strIdentificadorMapa) {
		this.strIdentificadorMapa = strIdentificadorMapa;
	}

	/**
	 * @return the strFechaAlta
	 */
	public String getStrFechaAlta() {
		return strFechaAlta;
	}

	/**
	 * @param strFechaAlta the strFechaAlta to set
	 */
	public void setStrFechaAlta(String strFechaAlta) {
		this.strFechaAlta = strFechaAlta;
	}

	/**
	 * @return the strFechaModificacion
	 */
	public String getStrFechaModificacion() {
		return strFechaModificacion;
	}

	/**
	 * @param strFechaModificacion the strFechaModificacion to set
	 */
	public void setStrFechaModificacion(String strFechaModificacion) {
		this.strFechaModificacion = strFechaModificacion;
	}

	/**
	 * @return the strDescripcionMapa
	 */
	public String getStrDescripcionMapa() {
		return strDescripcionMapa;
	}

	/**
	 * @param strDescripcionMapa the strDescripcionMapa to set
	 */
	public void setStrDescripcionMapa(String strDescripcionMapa) {
		this.strDescripcionMapa = strDescripcionMapa;
	}


	/**
	 * @return the strStatus
	 */
	public String getStrStatus() {
		return strStatus;
	}

	/**
	 * @param strStatus the strStatus to set
	 */
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}

	/**
	 * @return the strIdStatus
	 */
	public String getStrIdStatus() {
		return strIdStatus;
	}

	/**
	 * @param strIdStatus the strIdStatus to set
	 */
	public void setStrIdStatus(String strIdStatus) {
		this.strIdStatus = strIdStatus;
	}

	/**
	 * @return the idMapaGmm
	 */
	public Textbox getIdMapaGmm() {
		return idMapaGmm;
	}

	/**
	 * @param idMapaGmm the idMapaGmm to set
	 */
	public void setIdMapaGmm(Textbox idMapaGmm) {
		this.idMapaGmm = idMapaGmm;
	}

	/**
	 * @return the strIdMapaGmm
	 */
	public String getStrIdMapaGmm() {
		return strIdMapaGmm;
	}

	/**
	 * @param strIdMapaGmm the strIdMapaGmm to set
	 */
	public void setStrIdMapaGmm(String strIdMapaGmm) {
		this.strIdMapaGmm = strIdMapaGmm;
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
		componentes.put(lblIdentificadorMapa.getId(), lblIdentificadorMapa);
		componentes.put(lblFechaAlta.getId(), lblFechaAlta);
		componentes.put(lblDescricionMapa.getId(), lblDescricionMapa);
		componentes.put(lblFechaModificacion.getId(), lblFechaModificacion);
		componentes.put(lblEstatus.getId(), lblEstatus);
		componentes.put(identificadorMapa.getId(), identificadorMapa);
		componentes.put(descripcionMapa.getId(), descripcionMapa);
		componentes.put(status.getId(), status);
		componentes.put(fechaAlta.getId(), fechaAlta);
		componentes.put(fechaModificacion.getId(), fechaModificacion);
		componentes.put(reporteExcelBtn.getId(), reporteExcelBtn);
		componentes.put(reporteCsvBtn.getId(), reporteCsvBtn);
		componentes.put(limpiarBtn.getId(), limpiarBtn);
		componentes.put(guardarBtn.getId(), guardarBtn);
		componentes.put(consultarBtn.getId(), consultarBtn);
		componentes.put(mapaGmmsGrid.getId(), mapaGmmsGrid);
		super.applyPermission(MapeadorConstants.MAPAS, componentes);
		return isApplied;
	}	

	
	/**
	 * @return the mapaGmmVO
	 */
	public MapaGmmVO getMapaGmmVO() {
		return mapaGmmVO;
	}

	/**
	 * @param mapaGmmVO the mapaGmmVO to set
	 */
	public void setMapaGmmVO(MapaGmmVO mapaGmmVO) {
		this.mapaGmmVO = mapaGmmVO;
	}
}
