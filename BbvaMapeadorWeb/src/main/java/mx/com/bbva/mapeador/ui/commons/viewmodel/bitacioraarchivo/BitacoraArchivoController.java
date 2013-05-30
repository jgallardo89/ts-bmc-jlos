package mx.com.bbva.mapeador.ui.commons.viewmodel.bitacioraarchivo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import mx.com.bbva.bancomer.bitacora.dto.BitacoraDTO;
import mx.com.bbva.bancomer.bitacora.dto.CampoDTO;
import mx.com.bbva.bancomer.bitacoraarchivo.dto.BitacoraArchivoDTO;
import mx.com.bbva.bancomer.bussinnes.model.vo.BitacoraArchivoVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.evento.dto.EventoMapeadorDTO;
import mx.com.bbva.bancomer.mapper.business.BitacoraArchivoBO;
import mx.com.bbva.bancomer.mapper.business.EventoMapeadorBO;
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
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Textbox;

public class BitacoraArchivoController extends ControllerSupport implements  IController{
	@Wire
	private Textbox idBitacora;
	@Wire
	private Combobox eventoMapeador;
	@Wire
	private Textbox idEventoMapeador;
	@Wire
	private Textbox nombreArchivo;
	@Wire
	private Datebox fechaInicio;
	@Wire
	private Datebox fechaFin;
	
	private BitacoraArchivoDTO bitacoraArchivoDTO = (BitacoraArchivoDTO) this.read();
	
	private List<BitacoraArchivoVO> bitacoraArchivoVOs = bitacoraArchivoDTO.getBitacoraArchivoVOs();
	
	private String strEventoMapeador;
	
	private String strIdEventoMapeador;
	
	private String strNombreArchivo;
	
	private String strFechaInicio;
	
	private String strFechaFin;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4396659274984089054L;

	@Override
	public Object read() {
		ReportesController controller = new ReportesController();
		BitacoraArchivoDTO bitacoraArchivoDTO = new BitacoraArchivoDTO();
		BitacoraArchivoVO bitacoraArchivoVO= new BitacoraArchivoVO();
		EventoMapeadorDTO eventoMapeadorDTO = new EventoMapeadorDTO();
		EventoMapeadorBO eventoMapeadorBO = new EventoMapeadorBO();
		eventoMapeadorDTO.setCommandId(2);
		eventoMapeadorDTO = eventoMapeadorBO.readCommand(eventoMapeadorDTO);
		bitacoraArchivoDTO.setEventoMapeadorVOs(eventoMapeadorDTO.getEventoMapeadorVOs());
		BitacoraArchivoBO bitacoraArchivoBO = new BitacoraArchivoBO();
		bitacoraArchivoDTO = bitacoraArchivoBO.readCommand(bitacoraArchivoDTO);
		controller.registrarEvento(bitacoraArchivoVO, bitacoraArchivoVO, CommandConstants.CONSULTAR,"Bit�cora de Archivos");
		return bitacoraArchivoDTO;
	}
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
    }
	
	@Command
	@NotifyChange({ "bitacoraArchivoVOs" })
	public void readWithFilters() {
		ReportesController controller = new ReportesController();
		BitacoraArchivoDTO bitacoraArchivoDTO = new BitacoraArchivoDTO();
		BitacoraArchivoVO bitacoraArchivoVO = new BitacoraArchivoVO();
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		bitacoraArchivoVO.setFechaInicio(dateFormat.format(fechaInicio.getValue()));
		bitacoraArchivoVO.setFechaFin(dateFormat.format(fechaFin.getValue()));
		bitacoraArchivoVO.setIdEventoMapeador(Integer.parseInt(idEventoMapeador.getValue().isEmpty()?"0":idEventoMapeador.getValue()));
		bitacoraArchivoVO.setNombreBitacora(nombreArchivo.getValue().isEmpty()?"%":"%"+nombreArchivo.getValue().toUpperCase()+"%");
		bitacoraArchivoVO.toString();
		bitacoraArchivoDTO.setBitacoraArchivoVO(bitacoraArchivoVO);
		BitacoraArchivoBO bitacoraArchivoBO = new BitacoraArchivoBO();
		bitacoraArchivoVOs = bitacoraArchivoBO.readCommand(bitacoraArchivoDTO).getBitacoraArchivoVOs();
		controller.registrarEvento(bitacoraArchivoVO, bitacoraArchivoVO, CommandConstants.CONSULTAR, "Bit�cora de Archivos");
	}
	
	@Override
	@Command
	public void clean() {
		idBitacora.setValue(null);
		idEventoMapeador.setValue(null);
		nombreArchivo.setValue(null);
	}
	@Command
	public void onShowReport(@BindingParam("type") final String type) {
		ReportesController controller = new ReportesController();
		ArrayList<String> headersReport = new ArrayList<String>();
		String titleReport = "Bit�cora Archivos";
		headersReport.add("Fecha y Hora");
		headersReport.add("Archivo");
		headersReport.add("Estado de archivo");
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Bit�cora de Archivos");
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Bit�cora de Archivos");
		}
		controller.createReport(generaLista(), headersReport, titleReport, "BITACORA_ARCHIVOS");
	}	
	
	private ArrayList<BeanGenerico> generaLista() {
		ArrayList<BeanGenerico> beanGenericos = new ArrayList<BeanGenerico>();
		BeanGenerico beanGenerico = null;
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		for(BitacoraArchivoVO bitacoraArchivoVO: bitacoraArchivoVOs) {
			beanGenerico = new BeanGenerico();
			beanGenerico.setValor1(dateFormat.format(bitacoraArchivoVO.getFechaBitacora()));
			beanGenerico.setValor2(bitacoraArchivoVO.getNombreBitacora());
			beanGenerico.setValor3(bitacoraArchivoVO.getNombreEventoMapeador()); 
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


	
	/**
	 * @return the eventoMapeador
	 */
	public Combobox getEventoMapeador() {
		return eventoMapeador;
	}
	/**
	 * @param eventoMapeador the eventoMapeador to set
	 */
	public void setEventoMapeador(Combobox eventoMapeador) {
		this.eventoMapeador = eventoMapeador;
	}
	/**
	 * @return the idEventoMapeador
	 */
	public Textbox getIdEventoMapeador() {
		return idEventoMapeador;
	}
	/**
	 * @param idEventoMapeador the idEventoMapeador to set
	 */
	public void setIdEventoMapeador(Textbox idEventoMapeador) {
		this.idEventoMapeador = idEventoMapeador;
	}
	/**
	 * @return the nombreArchivo
	 */
	public Textbox getNombreArchivo() {
		return nombreArchivo;
	}
	/**
	 * @param nombreArchivo the nombreArchivo to set
	 */
	public void setNombreArchivo(Textbox nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	/**
	 * @return the fechaInicio
	 */
	public Datebox getFechaInicio() {
		return fechaInicio;
	}
	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Datebox fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	/**
	 * @return the fechaFin
	 */
	public Datebox getFechaFin() {
		return fechaFin;
	}
	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Datebox fechaFin) {
		this.fechaFin = fechaFin;
	}
	/**
	 * @return the bitacoraArchivoDTO
	 */
	public BitacoraArchivoDTO getBitacoraArchivoDTO() {
		return bitacoraArchivoDTO;
	}
	/**
	 * @param bitacoraArchivoDTO the bitacoraArchivoDTO to set
	 */
	public void setBitacoraArchivoDTO(BitacoraArchivoDTO bitacoraArchivoDTO) {
		this.bitacoraArchivoDTO = bitacoraArchivoDTO;
	}
	/**
	 * @return the bitacoraArchivoVOs
	 */
	public List<BitacoraArchivoVO> getBitacoraArchivoVOs() {
		return bitacoraArchivoVOs;
	}
	/**
	 * @param bitacoraArchivoVOs the bitacoraArchivoVOs to set
	 */
	public void setBitacoraArchivoVOs(List<BitacoraArchivoVO> bitacoraArchivoVOs) {
		this.bitacoraArchivoVOs = bitacoraArchivoVOs;
	}
	/**
	 * @return the strEventoMapeador
	 */
	public String getStrEventoMapeador() {
		return strEventoMapeador;
	}
	/**
	 * @param strEventoMapeador the strEventoMapeador to set
	 */
	public void setStrEventoMapeador(String strEventoMapeador) {
		this.strEventoMapeador = strEventoMapeador;
	}
	/**
	 * @return the strIdEventoMapeador
	 */
	public String getStrIdEventoMapeador() {
		return strIdEventoMapeador;
	}
	/**
	 * @param strIdEventoMapeador the strIdEventoMapeador to set
	 */
	public void setStrIdEventoMapeador(String strIdEventoMapeador) {
		this.strIdEventoMapeador = strIdEventoMapeador;
	}
	/**
	 * @return the strNombreArchivo
	 */
	public String getStrNombreArchivo() {
		return strNombreArchivo;
	}
	/**
	 * @param strNombreArchivo the strNombreArchivo to set
	 */
	public void setStrNombreArchivo(String strNombreArchivo) {
		this.strNombreArchivo = strNombreArchivo;
	}
	/**
	 * @return the strFechaInicio
	 */
	public String getStrFechaInicio() {
		return strFechaInicio;
	}
	/**
	 * @param strFechaInicio the strFechaInicio to set
	 */
	public void setStrFechaInicio(String strFechaInicio) {
		this.strFechaInicio = strFechaInicio;
	}
	/**
	 * @return the strFechaFin
	 */
	public String getStrFechaFin() {
		return strFechaFin;
	}
	/**
	 * @param strFechaFin the strFechaFin to set
	 */
	public void setStrFechaFin(String strFechaFin) {
		this.strFechaFin = strFechaFin;
	}
	/**
	 * @return the idBitacora
	 */
	public Textbox getIdBitacora() {
		return idBitacora;
	}
	/**
	 * @param idBitacora the idBitacora to set
	 */
	public void setIdBitacora(Textbox idBitacora) {
		this.idBitacora = idBitacora;
	}
	/**
	 * @return the report
	 */	
	@Override
	public boolean applyPermision() {
		// TODO Auto-generated method stub
		return false;
	}
}