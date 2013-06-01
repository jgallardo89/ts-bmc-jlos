package mx.com.bbva.mt101.ui.commons.viewmodel.bitacoraWeb;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;
import mx.com.bbva.mt101.ui.commons.viewmodel.reportes.ReportesController;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.wutka.jox.JOXBeanInputStream;

/**
 * @author Julio Morales
 *
 */
public class BitacoraWebController extends ControllerSupport implements IController {

	private static final long serialVersionUID = -3648403161872767250L;

	@Wire
	private Textbox idUsuario;
	@Wire
	private Textbox idEventoMapeador;
	@Wire
	private Label lblFechaInicio;
	@Wire
	private Label lblFechaFin;
	@Wire
	private Label lbIdentificadorMensaje;
	@Wire
	private Label lblUsuario;
	@Wire
	private Datebox fechaInicio;
	@Wire
	private Datebox fechaFin;
	@Wire
	private Combobox tipoEvento;
	@Wire
	private Combobox usuario;
	@Wire
	private Image reporteExcelBtn;
	@Wire
	private Image reporteCsvBtn;
	@Wire
	private Button consultarBtn;
	@Wire
	private Grid bitacoraGrid;

	private BitacoraDTO bitacoraDTO;
	private List<BitacoraVO> bitacoraVOs;
	private List<CampoDTO> campoDTOs;
	private List<UsuarioVO> usuarioVOs;
	private EventoMapeadorDTO eventoMapeadorDTO;
	private CampoDTO campoDTO;
	private boolean executePermissionSet;
	
	public BitacoraWebController() {
		this.read();
		this.bitacoraVOs = bitacoraDTO.getBitacoraVOs();
		this.campoDTOs = new ArrayList<CampoDTO>();
	}
	
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
		bitacoraBO.readCommand(bitacoraDTO);

		return bitacoraDTO;
	}
	
	@Command
	@NotifyChange({ "bitacoraVOs" })
	public void readWithFilters() {
		BitacoraDTO bitacoraDTO = new BitacoraDTO();
		BitacoraVO bitacoraVO = new BitacoraVO();
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		bitacoraVO.setFechaInicio(dateFormat.format(fechaInicio.getValue()));
		bitacoraVO.setFechaFin(dateFormat.format(fechaFin.getValue()));
		bitacoraVO.setIdEventoMapeador(Integer.parseInt(idEventoMapeador.getValue().isEmpty()?"0":idEventoMapeador.getValue()));
		bitacoraVO.setIdUsuario(Integer.parseInt(idUsuario.getValue().isEmpty()?"0":idUsuario.getValue()));
		bitacoraVO.toString();
		bitacoraDTO.setBitacoraVO(bitacoraVO);
		BitacoraBO bitacoraBO = new BitacoraBO();
		bitacoraVOs = bitacoraBO.readCommand(bitacoraDTO).getBitacoraVOs();
	}
	
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
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		mapDatos.put("campoDTOs", this.campoDTOs);
		Window window = (Window) Executions.createComponents(
				"/WEB-INF/flows/bitacoraWeb/detalleBitacora.zul",
				this.getSelf(), mapDatos);
		window.doModal();
	}
	
	@Wire
    Window detalleBitacoraWindow;
	
	@Command
    public void showModal() {
		detalleBitacoraWindow.detach();
    }

	@Command
	public void onShowReport(@BindingParam("type") final String type) {
		ReportesController controller = new ReportesController();
		ArrayList<String> headersReport = new ArrayList<String>();
		String titleReport = "Bitácora Web";
		headersReport.add("Fecha y Hora");
		headersReport.add("Usuario");
		headersReport.add("Tipo Evento");
		controller.createReport(generaLista(), headersReport, titleReport, "BITACORA_WEB");
	}	
	
	private ArrayList<BeanGenerico> generaLista() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		ArrayList<BeanGenerico> beanGenericos = new ArrayList<BeanGenerico>();
		BeanGenerico beanGenerico = null;
		for(BitacoraVO bitacoraVO: bitacoraVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(dateFormat.format(bitacoraVO.getFechaBitacora()));
			beanGenerico.setValor2(bitacoraVO.getNombreUsuario());
			beanGenerico.setValor3(bitacoraVO.getNombreEventoMapeador());
			beanGenericos.add(beanGenerico);
		}
		return beanGenericos;
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
		idUsuario.setValue(null);
		idEventoMapeador.setValue(null);
	}
	
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
        executePermissionSet = this.applyPermision();
    }

	/**
	 * @return the bitacoraDTO
	 */
	public BitacoraDTO getBitacoraDTO() {
		return bitacoraDTO;
	}

	/**
	 * @param bitacoraDTO the bitacoraDTO to set
	 */
	public void setBitacoraDTO(BitacoraDTO bitacoraDTO) {
		this.bitacoraDTO = bitacoraDTO;
	}

	/**
	 * @return the bitacoraVOs
	 */
	public List<BitacoraVO> getBitacoraVOs() {
		return bitacoraVOs;
	}

	/**
	 * @param bitacoraVOs the bitacoraVOs to set
	 */
	public void setBitacoraVOs(List<BitacoraVO> bitacoraVOs) {
		this.bitacoraVOs = bitacoraVOs;
	}

	/**
	 * @return the campoDTOs
	 */
	public List<CampoDTO> getCampoDTOs() {
		return campoDTOs;
	}

	/**
	 * @param campoDTOs the campoDTOs to set
	 */
	public void setCampoDTOs(List<CampoDTO> campoDTOs) {
		this.campoDTOs = campoDTOs;
	}

	/**
	 * @return the usuarioVOs
	 */
	public List<UsuarioVO> getUsuarioVOs() {
		return usuarioVOs;
	}

	/**
	 * @param usuarioVOs the usuarioVOs to set
	 */
	public void setUsuarioVOs(List<UsuarioVO> usuarioVOs) {
		this.usuarioVOs = usuarioVOs;
	}

	/**
	 * @return the eventoMapeadorDTO
	 */
	public EventoMapeadorDTO getEventoMapeadorDTO() {
		return eventoMapeadorDTO;
	}

	/**
	 * @param eventoMapeadorDTO the eventoMapeadorDTO to set
	 */
	public void setEventoMapeadorDTO(EventoMapeadorDTO eventoMapeadorDTO) {
		this.eventoMapeadorDTO = eventoMapeadorDTO;
	}

	/**
	 * @return the campoDTO
	 */
	public CampoDTO getCampoDTO() {
		return campoDTO;
	}

	/**
	 * @param campoDTO the campoDTO to set
	 */
	public void setCampoDTO(CampoDTO campoDTO) {
		this.campoDTO = campoDTO;
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
	
}
