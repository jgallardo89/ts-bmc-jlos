/**
 * 
 */
package mx.com.bbva.mapeador.ui.commons.viewmodel.pantalla;

import java.util.ArrayList;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PantallaVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.mapper.business.PantallaBO;
import mx.com.bbva.bancomer.pantalla.dto.PantallaDTO;
import mx.com.bbva.mapeador.security.session.user.SessionUser;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
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
import org.zkoss.zkex.zul.Jasperreport;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;

/**
 * @author 
 *
 */
public class PantallaController extends ControllerSupport implements  IController{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6786596344010411900L;
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
	private Textbox idPantalla;
	
	@Wire
	private Combobox pantallaPadre;

	@Wire
	private Combobox status;
	
	@Wire
	private Textbox idPantallaPadre;
	
	@Wire
	private Textbox idEstatusObjeto;

	@Wire
	private Textbox nombrePantalla;
	
	@Wire
	private Textbox url;
	
	@Wire
	private Textbox icono;
	
	@Wire
	private Textbox orden;
	
	@Wire
	private Jasperreport report;
	
	private PantallaVO pantallaVO;
	
	private PantallaDTO pantallaDTO =  (PantallaDTO) this.read();
	
	private List<PantallaVO> pantallaVOs = pantallaDTO.getPantallaVOs();
	
	
	private String strDescripcionEstatusObjeto;
	
	private String strIdEstatusClave;

	private String strIdEstatusObjeto;

	private String strIdPantalla;

	private String strNombreEstatusObjeto;

	private String strPantallas;

	private String strStatusClave;
	
	private String strIdpantallaPadre;
	
	private String strNombrePantalla;
	
	private String strPantallaPadre;
	
	private String strUrl;
	
	private String strIcono;
	
	private String strOrden;
	@Override
	public Object read() {
		ReportesController controller = new ReportesController();
		PantallaVO pantallaVO = new PantallaVO();
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
		estatusObjetoVO.setNombreTabla(CommandConstants.NOMBRE_TABLA_PANTALLA);		
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
		PantallaDTO pantallaDTO = new PantallaDTO();		
		PantallaBO pantallaBO = new PantallaBO();		
		pantallaDTO.setEstatusObjetoVO(estatusObjetoVO);
		pantallaDTO = pantallaBO.readCommand(pantallaDTO);
		logger.info("::::::::::::::SIZE::::::::::" + pantallaDTO.getPantallaVOs());
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
		pantallaDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
		controller.registrarEvento(pantallaVO, pantallaVO, CommandConstants.CONSULTAR,"Catálogo Pantalla");
		return pantallaDTO;
	}
	
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
    }
	//Cambiar al objeto que pertenezca el componente en este caso PantallasVOs
	@Command
	@NotifyChange({ "pantallaVOs" })
	public void readWithFilters() {
		ReportesController controller = new ReportesController();
		PantallaDTO pantallaDTO = new PantallaDTO();
		PantallaVO pantallaVO = new PantallaVO();
//		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();	
		//Textbox
		pantallaVO.setNombrePantalla(nombrePantalla.getValue().isEmpty()?"%":"%"+nombrePantalla.getValue().toUpperCase()+"%");
		pantallaVO.setDescripcionUrlPantalla(url.getValue().isEmpty()?"%":"%"+url.getValue().toLowerCase()+"%");
		pantallaVO.setDescripcionUrlIcon(icono.getValue().isEmpty()?"%":"%"+icono.getValue().toUpperCase()+"%");
		
		//Combos Validar el nombre de los parametros en HTML VS Controller
		pantallaVO.setIdPantallaPadre((Integer.parseInt(idPantallaPadre.getValue().isEmpty()?"0":idPantallaPadre.getValue())));
		pantallaVO.setEstatusPantalla((Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue())));
		pantallaVO.setNumeroOrdenPantalla(Integer.parseInt(orden.getValue().isEmpty()?"0":orden.getValue()));
		//Consulta Parametrizada
//		pantallaDTO.setCommandId(CommandConstants.ESTATUS_OBJETO_COMBO_PANTALLAS);
		//Seteo de VO a DTO 
		pantallaDTO.setPantallaVO(pantallaVO);
		pantallaDTO.toString(BbvaAbstractDataTransferObject.XML);	
		
		//LLamada a BO  Pantalla para consulta por criterio
		PantallaBO pantallaBO = new PantallaBO();
		
		//Asignacion resultado de consulta al mismo DTO de pantalla
		pantallaDTO = pantallaBO.readCommand(pantallaDTO);
		
		//Tamaño de la lista de acuerdo al criterio de busqueda y objeto Pantalla
		if(pantallaDTO.getPantallaVOs() != null) {
			logger.debug("size:"+pantallaDTO.getPantallaVOs().size());
		} else{
			logger.debug(":::::::::::Lista Vacia::::::::::");
		}
		//Asignacion de la lista a la variable global de la clase
		pantallaVOs = pantallaDTO.getPantallaVOs();
		controller.registrarEvento(pantallaVO, pantallaVO, CommandConstants.CONSULTAR,"Catálogo Pantalla");
	}
	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Command
	public void readSelected(@BindingParam("idPantalla") final PantallaVO pantallaVO){
		//Seteo de datos de Acuerdo al id de los compoenetes del HTML VS VO
		this.pantallaVO = pantallaVO;
		pantallaVO.toString();
		pantallaPadre.setValue(pantallaVO.getNombrePantallaPadre());
		nombrePantalla.setValue(pantallaVO.getNombrePantalla());
		status.setValue(pantallaVO.getNombreEstatusObjeto());
		url.setValue(pantallaVO.getDescripcionUrlPantalla());
		icono.setValue(pantallaVO.getDescripcionUrlIcon());
		orden.setValue(String.valueOf(pantallaVO.getNumeroOrdenPantalla()));
		idPantalla.setValue(String.valueOf(pantallaVO.getIdPantalla()));
		idPantallaPadre.setValue(String.valueOf(pantallaVO.getIdPantallaPadre()));
	}
	
	@Override
	@Command
	@NotifyChange({ "pantallaVOs"})
	public void save() {
		ReportesController controller = new ReportesController();
		//Validar Todos Los campos de pantalla
		boolean errorGuardar = false; 
		if (pantallaPadre.getSelectedItem() == null
				|| pantallaPadre.getSelectedItem().getValue() == null
				|| pantallaPadre.getSelectedItem().getValue().toString().isEmpty()) {
			pantallaPadre.setErrorMessage("Favor de seleccionar la Pantalla Padre.");
			errorGuardar = true;
		}
		if (nombrePantalla.getValue().isEmpty()) {
			nombrePantalla
					.setErrorMessage("Favor de introducir nombre de la Pantalla");
			errorGuardar = true;
		} 
		if (status.getSelectedItem() == null
				|| status.getSelectedItem().getValue() == null
				|| status.getSelectedItem().getValue().toString().isEmpty()) {
			status.setErrorMessage("Favor de seleccionar el Estatus del Objeto.");
			errorGuardar = true;
		}
		if (url.getValue().isEmpty()) {
			url
					.setErrorMessage("Favor de introducir la URL");
			errorGuardar = true;
		}
		if (icono.getValue().isEmpty()) {
			icono
					.setErrorMessage("Favor de introducir el Icono");
			errorGuardar = true;
		}
		if (orden.getValue().isEmpty()) {
			orden
					.setErrorMessage("Favor de introducir el Orden");
			errorGuardar = true;
		}
		if(!errorGuardar){
			if(!idPantalla.getValue().isEmpty()){
				logger.info("::::::Actualizar::::");
				PantallaDTO pantallaDTO = new PantallaDTO();
				PantallaVO pantallaVO = new PantallaVO();
				pantallaVO.setIdPantalla(Integer.parseInt(idPantalla.getValue().toString()));
				pantallaVO.setIdPantallaPadre(Integer.parseInt(idPantallaPadre.getValue()));
				pantallaVO.setEstatusPantalla(Integer.parseInt(status.getSelectedItem().getValue().toString()));
				pantallaVO.setNumeroOrdenPantalla(Integer.parseInt(orden.getValue()));								
				pantallaVO.setNombrePantalla(nombrePantalla.getValue().toUpperCase().trim());
				pantallaVO.setDescripcionUrlPantalla(url.getValue().trim());
				pantallaVO.setDescripcionUrlIcon(icono.getValue().toUpperCase().trim());
				
				//Seteo de VO a DTO 
				pantallaDTO.setPantallaVO(pantallaVO);
				pantallaDTO.toString(BbvaAbstractDataTransferObject.XML);	
				
				PantallaBO pantallaBO = new PantallaBO();
				pantallaBO.updateCommand(pantallaDTO);
				clean();			
				pantallaVO = new PantallaVO();							
				//Consulta Parametrizada
//				pantallaDTO.setCommandId(CommandConstants.ESTATUS_OBJETO_COMBO_PANTALLAS);
				//Seteo de VO a DTO 
				pantallaDTO.setPantallaVO(pantallaVO);
				pantallaDTO.toString(BbvaAbstractDataTransferObject.XML);
				
				//Asignacion resultado de consulta al mismo DTO de pantalla
				pantallaDTO = pantallaBO.readCommand(pantallaDTO);
				controller.registrarEvento(pantallaVO, this.pantallaVO, CommandConstants.MODIFICACION, "Catálogo Pantallas");
				
				Messagebox.show("Registro actualizado con exito!!",
						"Confirmación", Messagebox.OK,
						Messagebox.INFORMATION);
				this.pantallaDTO = pantallaDTO;
				pantallaVOs = pantallaDTO.getPantallaVOs();								
				
			}else{ 
				logger.info("::::::Crear::::");
				PantallaDTO pantallaDTO = new PantallaDTO();
				PantallaVO pantallaVO = new PantallaVO();
				pantallaVO.setIdPantallaPadre(Integer.parseInt(pantallaPadre.getSelectedItem().getValue().toString()));
				pantallaVO.setEstatusPantalla(Integer.parseInt(status.getSelectedItem().getValue().toString()));
				pantallaVO.setNumeroOrdenPantalla(Integer.parseInt(orden.getValue()));
				
				pantallaVO.setNombrePantalla(nombrePantalla.getValue().toUpperCase());
				pantallaVO.setDescripcionUrlPantalla(url.getValue().toLowerCase());
				pantallaVO.setDescripcionUrlIcon(icono.getValue().toUpperCase());
				
				//Seteo de VO a DTO 
				pantallaDTO.setPantallaVO(pantallaVO);
				pantallaDTO.toString(BbvaAbstractDataTransferObject.XML);	
				
				PantallaBO pantallaBO = new PantallaBO();
				pantallaBO.createCommand(pantallaDTO);
				controller.registrarEvento(pantallaVO, pantallaVO, CommandConstants.ALTA,"Catálogo Pantallas");
				clean();	
				pantallaVO = new PantallaVO();
				pantallaDTO.setPantallaVO(pantallaVO);
				pantallaDTO.toString(BbvaAbstractDataTransferObject.XML);
				
				//Asignacion resultado de consulta al mismo DTO de pantalla
				pantallaDTO = pantallaBO.readCommand(pantallaDTO);
				this.pantallaDTO = pantallaDTO;
				pantallaVOs = pantallaDTO.getPantallaVOs();
				
				Messagebox.show("Registro creado con exito!!",
						"Confirmación", Messagebox.OK,
						Messagebox.INFORMATION);
			}
		}
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Command
	public void clean() {
		//Mensajes HTML
		pantallaPadre.clearErrorMessage();
		nombrePantalla.clearErrorMessage();
		status.clearErrorMessage();
		url.clearErrorMessage();
		icono.clearErrorMessage();
		orden.clearErrorMessage();
		
		//Mensajes Setear a Null
		pantallaPadre.setValue(null);
		nombrePantalla.setValue(null);
		status.setValue(null);
		url.setValue(null);
		icono.setValue(null);
		orden.setValue(null);
		
		//Setear IDs Invisibles
		idPantallaPadre.setValue(null);
		idEstatusObjeto.setValue(null);
	}
	@Command
	public void onShowReport(@BindingParam("type") final String type) {
		ReportesController controller = new ReportesController();
		ArrayList<String> headersReport = new ArrayList<String>();
		String titleReport = "Catálogo Pantallas";
		headersReport.add("Pantalla Padre");
		headersReport.add("Pantalla");
		headersReport.add("URL Pantalla");
		headersReport.add("URL Icono");
		headersReport.add("Orden");
		headersReport.add("Estatus");
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Catálogo Pantalla");
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Catálogo Pantalla");
		}
		controller.createReport(generaLista(), headersReport, titleReport, report, type);
	}	
	
	private ArrayList<BeanGenerico> generaLista() { 
		ArrayList<BeanGenerico> beanGenericos = new ArrayList<BeanGenerico>();
		BeanGenerico beanGenerico = null;
		for(PantallaVO pantallaVO: pantallaVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(pantallaVO.getNombrePantallaPadre());
			beanGenerico.setValor2(pantallaVO.getNombrePantalla());
			beanGenerico.setValor3(pantallaVO.getDescripcionUrlPantalla());
			beanGenerico.setValor4(pantallaVO.getDescripcionUrlIcon()); 
			beanGenerico.setValor5(pantallaVO.getNombreEstatusObjeto());  
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}
	/**
	 * @return the pantallaPadre
	 */
	public Combobox getPantallaPadre() {
		return pantallaPadre;
	}

	/**
	 * @param pantallaPadre the pantallaPadre to set
	 */
	public void setPantallaPadre(Combobox pantallaPadre) {
		this.pantallaPadre = pantallaPadre;
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
	 * @return the idpantallaPadre
	 */
	public Textbox getIdPantallaPadre() {
		return idPantallaPadre;
	}

	/**
	 * @param idpantallaPadre the idpantallaPadre to set
	 */
	public void setIdPantallaPadre(Textbox idPantallaPadre) {
		this.idPantallaPadre = idPantallaPadre;
	}

	/**
	 * @return the idEstatusObjeto
	 */
	public Textbox getIdEstatusObjeto() {
		return idEstatusObjeto;
	}

	/**
	 * @param idEstatusObjeto the idEstatusObjeto to set
	 */
	public void setIdEstatusObjeto(Textbox idEstatusObjeto) {
		this.idEstatusObjeto = idEstatusObjeto;
	}

	/**
	 * @return the nombrePantalla
	 */
	public Textbox getNombrePantalla() {
		return nombrePantalla;
	}

	/**
	 * @param nombrePantalla the nombrePantalla to set
	 */
	public void setNombrePantalla(Textbox nombrePantalla) {
		this.nombrePantalla = nombrePantalla;
	}

	/**
	 * @return the url
	 */
	public Textbox getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(Textbox url) {
		this.url = url;
	}

	/**
	 * @return the icono
	 */
	public Textbox getIcono() {
		return icono;
	}

	/**
	 * @param icono the icono to set
	 */
	public void setIcono(Textbox icono) {
		this.icono = icono;
	}

	/**
	 * @return the orden
	 */
	public Textbox getOrden() {
		return orden;
	}

	/**
	 * @param orden the orden to set
	 */
	public void setOrden(Textbox orden) {
		this.orden = orden;
	}

	/**
	 * @return the pantallaDTO
	 */
	public PantallaDTO getPantallaDTO() {
		return pantallaDTO;
	}

	/**
	 * @param pantallaDTO the pantallaDTO to set
	 */
	public void setPantallaDTO(PantallaDTO pantallaDTO) {
		this.pantallaDTO = pantallaDTO;
	}

	/**
	 * @return the pantallaVOs
	 */
	public List<PantallaVO> getPantallaVOs() {
		return pantallaVOs;
	}

	/**
	 * @param pantallaVOs the pantallaVOs to set
	 */
	public void setPantallaVOs(List<PantallaVO> pantallaVOs) {
		this.pantallaVOs = pantallaVOs;
	}

	/**
	 * @return the strDescripcionEstatusObjeto
	 */
	public String getStrDescripcionEstatusObjeto() {
		return strDescripcionEstatusObjeto;
	}

	/**
	 * @param strDescripcionEstatusObjeto the strDescripcionEstatusObjeto to set
	 */
	public void setStrDescripcionEstatusObjeto(String strDescripcionEstatusObjeto) {
		this.strDescripcionEstatusObjeto = strDescripcionEstatusObjeto;
	}

	/**
	 * @return the strIdEstatusClave
	 */
	public String getStrIdEstatusClave() {
		return strIdEstatusClave;
	}

	/**
	 * @param strIdEstatusClave the strIdEstatusClave to set
	 */
	public void setStrIdEstatusClave(String strIdEstatusClave) {
		this.strIdEstatusClave = strIdEstatusClave;
	}

	/**
	 * @return the strIdEstatusObjeto
	 */
	public String getStrIdEstatusObjeto() {
		return strIdEstatusObjeto;
	}

	/**
	 * @param strIdEstatusObjeto the strIdEstatusObjeto to set
	 */
	public void setStrIdEstatusObjeto(String strIdEstatusObjeto) {
		this.strIdEstatusObjeto = strIdEstatusObjeto;
	}

	/**
	 * @return the strIdPantalla
	 */
	public String getStrIdPantalla() {
		return strIdPantalla;
	}

	/**
	 * @param strIdPantalla the strIdPantalla to set
	 */
	public void setStrIdPantalla(String strIdPantalla) {
		this.strIdPantalla = strIdPantalla;
	}

	/**
	 * @return the strNombreEstatusObjeto
	 */
	public String getStrNombreEstatusObjeto() {
		return strNombreEstatusObjeto;
	}

	/**
	 * @param strNombreEstatusObjeto the strNombreEstatusObjeto to set
	 */
	public void setStrNombreEstatusObjeto(String strNombreEstatusObjeto) {
		this.strNombreEstatusObjeto = strNombreEstatusObjeto;
	}

	/**
	 * @return the strPantallas
	 */
	public String getStrPantallas() {
		return strPantallas;
	}

	/**
	 * @param strPantallas the strPantallas to set
	 */
	public void setStrPantallas(String strPantallas) {
		this.strPantallas = strPantallas;
	}

	/**
	 * @return the strStatusClave
	 */
	public String getStrStatusClave() {
		return strStatusClave;
	}

	/**
	 * @param strStatusClave the strStatusClave to set
	 */
	public void setStrStatusClave(String strStatusClave) {
		this.strStatusClave = strStatusClave;
	}
	/**
	 * @return the strIdpantallaPadre
	 */
	public String getStrIdpantallaPadre() {
		return strIdpantallaPadre;
	}
	/**
	 * @param strIdpantallaPadre the strIdpantallaPadre to set
	 */
	public void setStrIdpantallaPadre(String strIdpantallaPadre) {
		this.strIdpantallaPadre = strIdpantallaPadre;
	}

	/**
	 * @return the strNombrePantalla
	 */
	public String getStrNombrePantalla() {
		return strNombrePantalla;
	}

	/**
	 * @param strNombrePantalla the strNombrePantalla to set
	 */
	public void setStrNombrePantalla(String strNombrePantalla) {
		this.strNombrePantalla = strNombrePantalla;
	}

	/**
	 * @return the strPantallaPadre
	 */
	public String getStrPantallaPadre() {
		return strPantallaPadre;
	}

	/**
	 * @param strPantallaPadre the strPantallaPadre to set
	 */
	public void setStrPantallaPadre(String strPantallaPadre) {
		this.strPantallaPadre = strPantallaPadre;
	}

	/**
	 * @return the strUrl
	 */
	public String getStrUrl() {
		return strUrl;
	}

	/**
	 * @param strUrl the strUrl to set
	 */
	public void setStrUrl(String strUrl) {
		this.strUrl = strUrl;
	}

	/**
	 * @return the strIcono
	 */
	public String getStrIcono() {
		return strIcono;
	}

	/**
	 * @param strIcono the strIcono to set
	 */
	public void setStrIcono(String strIcono) {
		this.strIcono = strIcono;
	}

	/**
	 * @return the strOrden
	 */
	public String getStrOrden() {
		return strOrden;
	}

	/**
	 * @param strOrden the strOrden to set
	 */
	public void setStrOrden(String strOrden) {
		this.strOrden = strOrden;
	}

	/**
	 * @return the idpantalla
	 */
	public Textbox getIdPantalla() {
		return idPantalla;
	}

	/**
	 * @param idpantalla the idpantalla to set
	 */
	public void setIdPantalla(Textbox idPantalla) {
		this.idPantalla = idPantalla;
	}

	@Override
	public boolean applyPermision() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @return the report
	 */
	public Jasperreport getReport() {
		return report;
	}

	/**
	 * @param report the report to set
	 */
	public void setReport(Jasperreport report) {
		this.report = report;
	}

	/**
	 * @return the pantallaVO
	 */
	public PantallaVO getPantallaVO() {
		return pantallaVO;
	}

	/**
	 * @param pantallaVO the pantallaVO to set
	 */
	public void setPantallaVO(PantallaVO pantallaVO) {
		this.pantallaVO = pantallaVO;
	}
}
