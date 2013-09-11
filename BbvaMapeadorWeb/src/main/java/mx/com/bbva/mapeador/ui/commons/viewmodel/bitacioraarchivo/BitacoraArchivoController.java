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
 * Nombre de clase: BitacoraArchivoController.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.bitacioraarchivo
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.bitacioraarchivo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import mx.com.bbva.bancomer.bitacoraarchivo.dto.BitacoraArchivoDTO;
import mx.com.bbva.bancomer.bussinnes.model.vo.BitacoraArchivoVO;
import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.command.MapeadorConstants;
import mx.com.bbva.bancomer.evento.dto.EventoMapeadorDTO;
import mx.com.bbva.bancomer.mapper.business.BitacoraArchivoBO;
import mx.com.bbva.bancomer.mapper.business.EventoMapeadorBO;
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
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

// TODO: Auto-generated Javadoc
/**
 * The Class BitacoraArchivoController.
 */
public class BitacoraArchivoController extends ControllerSupport implements  IController{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4396659274984089054L;
	
	/** The bitacora archivo dto. */
	private BitacoraArchivoDTO bitacoraArchivoDTO = (BitacoraArchivoDTO) this.read();
	
	/** The bitacora archivo grid. */
	@Wire
	private Grid bitacoraArchivoGrid;
	
	/** The bitacora archivo v os. */
	private List<BitacoraArchivoVO> bitacoraArchivoVOs = null;// bitacoraArchivoDTO.getBitacoraArchivoVOs();
	
	/** The consultar btn. */
	@Wire
	private Button consultarBtn;
	
	/** The evento mapeador. */
	@Wire
	private Combobox eventoMapeador;
	
	/** The execute permission set. */
	private boolean executePermissionSet;
	
	/** The fecha fin. */
	@Wire
	private Datebox fechaFin;
	
	/** The fecha inicio. */
	@Wire
	private Datebox fechaInicio;
	
	/** The id bitacora. */
	@Wire
	private Textbox idBitacora;
	
	/** The id evento mapeador. */
	@Wire
	private Textbox idEventoMapeador;
	
	/** The lbl estado archivo. */
	@Wire
	private Label lblEstadoArchivo;
	
	/** The lbl fecha fin. */
	@Wire
	private Label lblFechaFin;
	
	/** The lbl fecha inicio. */
	@Wire
	private Label lblFechaInicio;
	
	/** The lbl nombre archivo. */
	@Wire
	private Label lblNombreArchivo;
	
	/** The nombre archivo. */
	@Wire
	private Textbox nombreArchivo;
	
	/** The reporte csv btn. */
	@Wire
	private Image reporteCsvBtn;
	
	/** The reporte excel btn. */
	@Wire
	private Image reporteExcelBtn;
	
	/** The str evento mapeador. */
	private String strEventoMapeador;
	
	/** The str fecha fin. */
	private String strFechaFin;
	
	/** The str fecha inicio. */
	private String strFechaInicio;
	
	/** The str id evento mapeador. */
	private String strIdEventoMapeador;
	
	/** The str nombre archivo. */
	private String strNombreArchivo;

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
	
	/**
	 * Apply permision.
	 *
	 * @return the report
	 */	
	@Override
	public boolean applyPermision() {
		boolean isApplied = false;
		HashMap<String, Component> componentes = new HashMap<String, Component>();
		componentes.put(lblFechaInicio.getId(), lblFechaInicio);
		componentes.put(lblFechaFin.getId(), lblFechaFin);
		componentes.put(lblEstadoArchivo.getId(), lblEstadoArchivo);
		componentes.put(lblNombreArchivo.getId(), lblNombreArchivo);
		componentes.put(fechaInicio.getId(), fechaInicio);
		componentes.put(fechaFin.getId(), fechaFin);
		componentes.put(eventoMapeador.getId(), eventoMapeador);
		componentes.put(nombreArchivo.getId(), nombreArchivo);
		componentes.put(reporteExcelBtn.getId(), reporteExcelBtn);
		componentes.put(reporteCsvBtn.getId(), reporteCsvBtn);
		componentes.put(consultarBtn.getId(), consultarBtn);
		componentes.put(bitacoraArchivoGrid.getId(), bitacoraArchivoGrid);
		super.applyPermission(MapeadorConstants.BITACORA_ARCHIVOS, componentes);
		return isApplied;
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#clean()
	 */
	@Override
	@Command
	public void clean() {
		idEventoMapeador.setValue(null);
		eventoMapeador.setValue(null);
		nombreArchivo.setValue(null);		
		fechaFin.setValue(null);
		fechaInicio.setValue(null);
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
		BeanGenerico beanGenerico = null;
		ArrayList<BeanGenerico> beanGenericos = new ArrayList<BeanGenerico>();
		try{						
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			for(BitacoraArchivoVO bitacoraArchivoVO: bitacoraArchivoVOs) {
				beanGenerico = new BeanGenerico();
				beanGenerico.setValor1(dateFormat.format(bitacoraArchivoVO.getFechaArchivo()));
				beanGenerico.setValor2(bitacoraArchivoVO.getNombreArchivo());
				beanGenerico.setValor3(bitacoraArchivoVO.getEstadoArchivo()); 
				beanGenericos.add(beanGenerico);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return beanGenericos;
	}	
	
	/**
	 * Gets the bitacora archivo dto.
	 *
	 * @return the bitacoraArchivoDTO
	 */
	public BitacoraArchivoDTO getBitacoraArchivoDTO() {
		return bitacoraArchivoDTO;
	}

	/**
	 * Gets the bitacora archivo v os.
	 *
	 * @return the bitacoraArchivoVOs
	 */
	public List<BitacoraArchivoVO> getBitacoraArchivoVOs() {
		return bitacoraArchivoVOs;
	}

	/**
	 * Gets the evento mapeador.
	 *
	 * @return the eventoMapeador
	 */
	public Combobox getEventoMapeador() {
		return eventoMapeador;
	}

	/**
	 * Gets the fecha fin.
	 *
	 * @return the fechaFin
	 */
	public Datebox getFechaFin() {
		return fechaFin;
	}


	
	/**
	 * Gets the fecha inicio.
	 *
	 * @return the fechaInicio
	 */
	public Datebox getFechaInicio() {
		return fechaInicio;
	}
	
	/**
	 * Gets the id bitacora.
	 *
	 * @return the idBitacora
	 */
	public Textbox getIdBitacora() {
		return idBitacora;
	}
	
	/**
	 * Gets the id evento mapeador.
	 *
	 * @return the idEventoMapeador
	 */
	public Textbox getIdEventoMapeador() {
		return idEventoMapeador;
	}
	
	/**
	 * Gets the nombre archivo.
	 *
	 * @return the nombreArchivo
	 */
	public Textbox getNombreArchivo() {
		return nombreArchivo;
	}
	
	/**
	 * Gets the str evento mapeador.
	 *
	 * @return the strEventoMapeador
	 */
	public String getStrEventoMapeador() {
		return strEventoMapeador;
	}
	
	/**
	 * Gets the str fecha fin.
	 *
	 * @return the strFechaFin
	 */
	public String getStrFechaFin() {
		return strFechaFin;
	}
	
	/**
	 * Gets the str fecha inicio.
	 *
	 * @return the strFechaInicio
	 */
	public String getStrFechaInicio() {
		return strFechaInicio;
	}
	
	/**
	 * Gets the str id evento mapeador.
	 *
	 * @return the strIdEventoMapeador
	 */
	public String getStrIdEventoMapeador() {
		return strIdEventoMapeador;
	}
	
	/**
	 * Gets the str nombre archivo.
	 *
	 * @return the strNombreArchivo
	 */
	public String getStrNombreArchivo() {
		return strNombreArchivo;
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
		headersReport.add("Archivo");
		headersReport.add("Estado de archivo");
		if(type.equals("xls")) {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_EXCEL,"Bitácora de Archivos");
		} else {
			controller.registrarEvento(null, null, CommandConstants.EXPORTAR_TEXTO,"Bitácora de Archivos");
		}
		controller.createReport(generaLista(), headersReport, type, "BITACORA_ARCHIVOS");
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read()
	 */
	@Override
	public Object read() {
		ReportesController controller = new ReportesController();
		BitacoraArchivoDTO bitacoraArchivoDTO = new BitacoraArchivoDTO();
		BitacoraArchivoVO bitacoraArchivoVO= new BitacoraArchivoVO();
		EventoMapeadorDTO eventoMapeadorDTO = new EventoMapeadorDTO();
		EventoMapeadorBO eventoMapeadorBO = new EventoMapeadorBO();
		eventoMapeadorDTO.setCommandId(CommandConstants.ESTADOS_ARCHIVOS);
		eventoMapeadorDTO = eventoMapeadorBO.readCommand(eventoMapeadorDTO);
		bitacoraArchivoDTO.setEstadoArchivoVOs(eventoMapeadorDTO.getEstadoArchivoVOs());
		BitacoraArchivoBO bitacoraArchivoBO = new BitacoraArchivoBO();
		bitacoraArchivoDTO = bitacoraArchivoBO.readCommand(bitacoraArchivoDTO);
		controller.registrarEvento(bitacoraArchivoVO, bitacoraArchivoVO, CommandConstants.CONSULTAR,"Bitácora de Archivos");
		return bitacoraArchivoDTO;
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
	@NotifyChange({ "bitacoraArchivoVOs" })
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
			ReportesController controller = new ReportesController();
			BitacoraArchivoDTO bitacoraArchivoDTO = new BitacoraArchivoDTO();
			BitacoraArchivoVO bitacoraArchivoVO = new BitacoraArchivoVO();
			
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			
			bitacoraArchivoVO.setFechaInici(fechaInicio.getValue()==null?null:fechaInicio.getValue());
			bitacoraArchivoVO.setFechaFin(fechaFin.getValue()==null?null:fechaFin.getValue());			
			bitacoraArchivoVO.setIdEstatus(Integer.parseInt(idEventoMapeador.getValue().isEmpty()?"0":idEventoMapeador.getValue()));
			bitacoraArchivoVO.setNombreArchivo(nombreArchivo.getValue().isEmpty()?"%":"%"+nombreArchivo.getValue().toUpperCase()+"%");
			bitacoraArchivoVO.toString();
			bitacoraArchivoDTO.setBitacoraArchivoVO(bitacoraArchivoVO);
			BitacoraArchivoBO bitacoraArchivoBO = new BitacoraArchivoBO();
			bitacoraArchivoVOs = bitacoraArchivoBO.readCommand(bitacoraArchivoDTO).getBitacoraArchivoVOs();
			if(bitacoraArchivoVOs.size()>500){
				Messagebox.show("En base a los parametros introducidos le informamos que la consulta obtuvo mas de 500 registros.\n" +
						"Solo se le mostraran los primeros 500.","Información", Messagebox.OK, Messagebox.INFORMATION);
				bitacoraArchivoVOs.remove(500);
			}			
			controller.registrarEvento(bitacoraArchivoVO, bitacoraArchivoVO, CommandConstants.CONSULTAR, "Bitácora de Archivos");
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
	 * Sets the bitacora archivo dto.
	 *
	 * @param bitacoraArchivoDTO the bitacoraArchivoDTO to set
	 */
	public void setBitacoraArchivoDTO(BitacoraArchivoDTO bitacoraArchivoDTO) {
		this.bitacoraArchivoDTO = bitacoraArchivoDTO;
	}
	
	/**
	 * Sets the bitacora archivo v os.
	 *
	 * @param bitacoraArchivoVOs the bitacoraArchivoVOs to set
	 */
	public void setBitacoraArchivoVOs(List<BitacoraArchivoVO> bitacoraArchivoVOs) {
		this.bitacoraArchivoVOs = bitacoraArchivoVOs;
	}
	
	/**
	 * Sets the evento mapeador.
	 *
	 * @param eventoMapeador the eventoMapeador to set
	 */
	public void setEventoMapeador(Combobox eventoMapeador) {
		this.eventoMapeador = eventoMapeador;
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
	 * Sets the fecha fin.
	 *
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Datebox fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	/**
	 * Sets the fecha inicio.
	 *
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Datebox fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	/**
	 * Sets the id bitacora.
	 *
	 * @param idBitacora the idBitacora to set
	 */
	public void setIdBitacora(Textbox idBitacora) {
		this.idBitacora = idBitacora;
	}
	
	/**
	 * Sets the id evento mapeador.
	 *
	 * @param idEventoMapeador the idEventoMapeador to set
	 */
	public void setIdEventoMapeador(Textbox idEventoMapeador) {
		this.idEventoMapeador = idEventoMapeador;
	}
	
	/**
	 * Sets the nombre archivo.
	 *
	 * @param nombreArchivo the nombreArchivo to set
	 */
	public void setNombreArchivo(Textbox nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	/**
	 * Sets the str evento mapeador.
	 *
	 * @param strEventoMapeador the strEventoMapeador to set
	 */
	public void setStrEventoMapeador(String strEventoMapeador) {
		this.strEventoMapeador = strEventoMapeador;
	}
	
	/**
	 * Sets the str fecha fin.
	 *
	 * @param strFechaFin the strFechaFin to set
	 */
	public void setStrFechaFin(String strFechaFin) {
		this.strFechaFin = strFechaFin;
	}
	
	/**
	 * Sets the str fecha inicio.
	 *
	 * @param strFechaInicio the strFechaInicio to set
	 */
	public void setStrFechaInicio(String strFechaInicio) {
		this.strFechaInicio = strFechaInicio;
	}
	
	/**
	 * Sets the str id evento mapeador.
	 *
	 * @param strIdEventoMapeador the strIdEventoMapeador to set
	 */
	public void setStrIdEventoMapeador(String strIdEventoMapeador) {
		this.strIdEventoMapeador = strIdEventoMapeador;
	}
	
	/**
	 * Sets the str nombre archivo.
	 *
	 * @param strNombreArchivo the strNombreArchivo to set
	 */
	public void setStrNombreArchivo(String strNombreArchivo) {
		this.strNombreArchivo = strNombreArchivo;
	}	
}
