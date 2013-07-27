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
 * Nombre de clase: BitacoraWebController.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.bitacoraWeb
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.bitacoraWeb;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.com.bbva.bancomer.bitacora.dto.BitacoraDTO;
import mx.com.bbva.bancomer.bitacora.dto.CampoDTO;
import mx.com.bbva.bancomer.bussinnes.model.vo.BitacoraVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.evento.dto.EventoMapeadorDTO;
import mx.com.bbva.bancomer.mapper.business.BitacoraBO;
import mx.com.bbva.bancomer.mapper.business.EventoMapeadorBO;
import mx.com.bbva.bancomer.mapper.business.UsuarioBO;
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
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.wutka.jox.JOXBeanInputStream;

// TODO: Auto-generated Javadoc
/**
 * The Class BitacoraWebController.
 *
 * @author Julio Morales
 */
public class BitacoraWebController extends ControllerSupport implements IController {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3648403161872767250L;

	/** The bitacora dto. */
	private BitacoraDTO bitacoraDTO;
	
	/** The bitacora grid. */
	@Wire
	private Grid bitacoraGrid;
	
	/** The bitacora v os. */
	private List<BitacoraVO> bitacoraVOs;
	
	/** The campo dto. */
	private CampoDTO campoDTO;
	
	/** The campo dt os. */
	private List<CampoDTO> campoDTOs;
	
	/** The consultar btn. */
	@Wire
	private Button consultarBtn;
	
	/** The detalle bitacora window. */
	@Wire
    Window detalleBitacoraWindow;
	
	/** The evento mapeador dto. */
	private EventoMapeadorDTO eventoMapeadorDTO;
	
	/** The execute permission set. */
	private boolean executePermissionSet;
	
	/** The fecha fin. */
	@Wire
	private Datebox fechaFin;
	
	/** The fecha inicio. */
	@Wire
	private Datebox fechaInicio;
	
	/** The id evento mapeador. */
	@Wire
	private Textbox idEventoMapeador;
	
	/** The id usuario. */
	@Wire
	private Textbox idUsuario;
	
	/** The lb identificador mensaje. */
	@Wire
	private Label lbIdentificadorMensaje;

	/** The lbl fecha fin. */
	@Wire
	private Label lblFechaFin;
	
	/** The lbl fecha inicio. */
	@Wire
	private Label lblFechaInicio;
	
	/** The lbl usuario. */
	@Wire
	private Label lblUsuario;
	
	/** The reporte csv btn. */
	@Wire
	private Image reporteCsvBtn;
	
	/** The reporte excel btn. */
	@Wire
	private Image reporteExcelBtn;
	
	/** The tipo evento. */
	@Wire
	private Combobox tipoEvento;
	
	/** The usuario. */
	@Wire
	private Combobox usuario;
	
	/** The usuario v os. */
	private List<UsuarioVO> usuarioVOs;
	
	/**
	 * Instantiates a new bitacora web controller.
	 */
	public BitacoraWebController() {
		this.read();
//		this.bitacoraVOs = bitacoraDTO.getBitacoraVOs();
//		this.campoDTOs = new ArrayList<CampoDTO>();
	}
	
	/**
	 * After compose.
	 *
	 * @param view the view
	 */
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false); 
        try{
	        fechaInicio.setValue(new Date());
	        fechaFin.setValue(new Date());
        }catch(Exception ex){}
        executePermissionSet = this.applyPermision();
    }
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#applyPermision()
	 */
	@Override
	public boolean applyPermision() {
		boolean isApplied = false;
		HashMap<String, Component> componentes = new HashMap<String, Component>();
		try{
			componentes.put(lblFechaInicio.getId(), lblFechaInicio);
			componentes.put(lblFechaFin.getId(), lblFechaFin);
			componentes.put(lbIdentificadorMensaje.getId(), lbIdentificadorMensaje);
			componentes.put(lblUsuario.getId(), lblUsuario);
			componentes.put(fechaInicio.getId(), fechaInicio);
			componentes.put(fechaFin.getId(), fechaFin);
			componentes.put(tipoEvento.getId(), tipoEvento);
			componentes.put(usuario.getId(), usuario);
			componentes.put(reporteExcelBtn.getId(), reporteExcelBtn);
			componentes.put(reporteCsvBtn.getId(), reporteCsvBtn);
			componentes.put(consultarBtn.getId(), consultarBtn);
			componentes.put(bitacoraGrid.getId(), bitacoraGrid);
			super.applyPermission(MapeadorConstants.BITACORA, componentes);
		}catch(Exception ex){}
		return isApplied;
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#clean()
	 */
	@Override
	@Command
	public void clean() {
		idUsuario.setValue(null);
		idEventoMapeador.setValue(null);
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
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		ArrayList<BeanGenerico> beanGenericos = new ArrayList<BeanGenerico>();
		BeanGenerico beanGenerico = null;
		for(BitacoraVO bitacoraVO: bitacoraVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(dateFormat.format(bitacoraVO.getHoraBitacora()));
			beanGenerico.setValor2(bitacoraVO.getNombreUsuario());
			beanGenerico.setValor3(bitacoraVO.getDescripcionBitacoraWeb());
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
	}	
	
	/**
	 * Gets the bitacora dto.
	 *
	 * @return the bitacoraDTO
	 */
	public BitacoraDTO getBitacoraDTO() {
		return bitacoraDTO;
	}
	
	/**
	 * Gets the bitacora v os.
	 *
	 * @return the bitacoraVOs
	 */
	public List<BitacoraVO> getBitacoraVOs() {
		return bitacoraVOs;
	}

	/**
	 * Gets the campo dto.
	 *
	 * @return the campoDTO
	 */
	public CampoDTO getCampoDTO() {
		return campoDTO;
	}

	/**
	 * Gets the campo dt os.
	 *
	 * @return the campoDTOs
	 */
	public List<CampoDTO> getCampoDTOs() {
		return campoDTOs;
	}

	/**
	 * Gets the evento mapeador dto.
	 *
	 * @return the eventoMapeadorDTO
	 */
	public EventoMapeadorDTO getEventoMapeadorDTO() {
		return eventoMapeadorDTO;
	}
	
	/**
	 * Gets the usuario v os.
	 *
	 * @return the usuarioVOs
	 */
	public List<UsuarioVO> getUsuarioVOs() {
		return usuarioVOs;
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
		headersReport.add("Fecha y Hora");
		headersReport.add("Usuario");
		headersReport.add("Tipo Evento");
		controller.createReport(generaLista(), headersReport, type, "BITACORA_WEB");
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read()
	 */
	@Override
	public Object read() {
		bitacoraDTO = new BitacoraDTO();
		EventoMapeadorBO eventoMapeadorBO = new EventoMapeadorBO();
		UsuarioBO usuarioBO = new UsuarioBO();
		eventoMapeadorDTO = new EventoMapeadorDTO();
		eventoMapeadorDTO.setCommandId(2);
		eventoMapeadorDTO = eventoMapeadorBO.readCommand(eventoMapeadorDTO);
		eventoMapeadorDTO.setEventoMapeadorVOs(eventoMapeadorDTO.getEventoMapeadorVOs());
		usuarioVOs = usuarioBO.readCommand();
		
		BitacoraBO bitacoraBO = new BitacoraBO();
		//bitacoraBO.readCommand(bitacoraDTO);

		return bitacoraDTO;
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
	 * Read event detail.
	 *
	 * @param bitacoraVO the bitacora vo
	 */
	@Command
	@NotifyChange({ "campoDTOs" })
	public void readEventDetail(@BindingParam("idBitacora") final BitacoraVO bitacoraVO) {
		Map<String, Object> mapDatos = new HashMap<String, Object>();
		campoDTOs = new ArrayList<CampoDTO>();
		InputStream is = null;
		bitacoraDTO = new BitacoraDTO();
		bitacoraDTO.setBitacoraVO(bitacoraVO);
		BitacoraBO bitacoraBO = new BitacoraBO();
		String xml = bitacoraBO.readCommandParameters(bitacoraDTO).getXml();
		try {
			if(xml != null) {
				is = new ByteArrayInputStream(xml.getBytes("UTF-8"));
				JOXBeanInputStream joxIn = new JOXBeanInputStream(is);
				bitacoraDTO = (BitacoraDTO) joxIn.readObject(BitacoraDTO.class);
				if(bitacoraDTO.getCampo()!=null) {
					for (CampoDTO campo:bitacoraDTO.getCampo()) {
						campoDTOs.add(campo);
					}
				}
				bitacoraDTO.setCampoDTOs(campoDTOs);
				joxIn.close();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		mapDatos.put("campoDTOs", this.campoDTOs);
		try{
			Window window = (Window) Executions.createComponents(
					"/WEB-INF/flows/bitacoraWeb/detalleBitacora.zul",
					this.getSelf(), mapDatos);
			window.doModal();
		}catch(Exception ex){}
	}

	/**
	 * Read with filters.
	 */
	@Command
	@NotifyChange({ "bitacoraVOs" })
	public void readWithFilters() {		
		boolean error = false;
		if(fechaInicio.getValue()!=null && fechaFin.getValue()!=null){
			if(fechaInicio.getValue().compareTo(fechaFin.getValue()) > 0 ){
				fechaInicio.setErrorMessage("La fecha de inicio no puede ser mayor a la fecha de fin");
				error = true;
			}
		}else if(fechaInicio.getValue()!=null && fechaFin.getValue()==null){
			fechaFin.setErrorMessage("Favor de introducir la fecha de fin");
			error = true;
		}else if(fechaInicio.getValue()==null && fechaFin.getValue()!=null){
			fechaInicio.setErrorMessage("Favor de introducir la fecha de inicio");
			error = true;
		}
		if(!error){
			BitacoraDTO bitacoraDTO = new BitacoraDTO();
			BitacoraVO bitacoraVO = new BitacoraVO();
								
			bitacoraVO.setFechaInicio(fechaInicio.getValue()==null?null:fechaInicio.getValue());
			bitacoraVO.setFechaFin(fechaFin.getValue()==null?null:fechaFin.getValue());
			bitacoraVO.setIdEventoMapeador(Integer.parseInt(idEventoMapeador.getValue().isEmpty()?"0":idEventoMapeador.getValue()));
			bitacoraVO.setIdUsuario(Integer.parseInt(idUsuario.getValue().isEmpty()?"0":idUsuario.getValue()));
			bitacoraVO.toString();
			bitacoraDTO.setBitacoraVO(bitacoraVO);
			BitacoraBO bitacoraBO = new BitacoraBO();
			bitacoraVOs = bitacoraBO.readCommand(bitacoraDTO).getBitacoraVOs();
			if(bitacoraVOs.size()>500){
				Messagebox.show("En base a los parametros introducidos le informamos que la consulta obtuvo mas de 500 registros.\n" +
						"Solo se le mostraran los primeros 500.","Información", Messagebox.OK, Messagebox.INFORMATION);
				bitacoraVOs.remove(500);
			}
		}
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#save()
	 */
	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Sets the bitacora dto.
	 *
	 * @param bitacoraDTO the bitacoraDTO to set
	 */
	public void setBitacoraDTO(BitacoraDTO bitacoraDTO) {
		this.bitacoraDTO = bitacoraDTO;
	}

	/**
	 * Sets the bitacora v os.
	 *
	 * @param bitacoraVOs the bitacoraVOs to set
	 */
	public void setBitacoraVOs(List<BitacoraVO> bitacoraVOs) {
		this.bitacoraVOs = bitacoraVOs;
	}

	/**
	 * Sets the campo dto.
	 *
	 * @param campoDTO the campoDTO to set
	 */
	public void setCampoDTO(CampoDTO campoDTO) {
		this.campoDTO = campoDTO;
	}

	/**
	 * Sets the campo dt os.
	 *
	 * @param campoDTOs the campoDTOs to set
	 */
	public void setCampoDTOs(List<CampoDTO> campoDTOs) {
		this.campoDTOs = campoDTOs;
	}

	/**
	 * Sets the evento mapeador dto.
	 *
	 * @param eventoMapeadorDTO the eventoMapeadorDTO to set
	 */
	public void setEventoMapeadorDTO(EventoMapeadorDTO eventoMapeadorDTO) {
		this.eventoMapeadorDTO = eventoMapeadorDTO;
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
	 * Sets the usuario v os.
	 *
	 * @param usuarioVOs the usuarioVOs to set
	 */
	public void setUsuarioVOs(List<UsuarioVO> usuarioVOs) {
		this.usuarioVOs = usuarioVOs;
	}
	
	/**
	 * Show modal.
	 */
	@Command
    public void showModal() {
		detalleBitacoraWindow.detach();
    }
	
}
