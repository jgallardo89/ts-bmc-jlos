package com.bancomer.gis.monitorwebswift.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.bancomer.gis.monitorwebswift.dao.PropertiesDao;
import com.bancomer.gis.monitorwebswift.logic.ComboService;
import com.bancomer.gis.monitorwebswift.logic.H2HMonitoreoDetalleErrService;
import com.bancomer.gis.monitorwebswift.logic.H2HMonitoreoService_CGS;
import com.bancomer.gis.monitorwebswift.logic.PropertiesService;
import com.bancomer.gis.monitorwebswift.util.Utils;
import com.bancomer.gis.monitorwebswift.vo.H2HMonitoreoDetalleVo;
import com.bancomer.gis.monitorwebswift.vo.ResourceVo;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.context.Resource;

public class H2HMonitoreoController_CGS implements PhaseListener {
	private static final Logger log=Logger.getLogger(H2HMonitoreoController_CGS.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * fecha inicial del registro de la aclaracion
     */
    private Date fechaInicial = new Date();
    /**
     * fecha final del registro de la aclaracion
     */
    private Date fechaFinal = new Date();
    
    /**
     * Lista de archivos procesados
     */
    private ArrayList archivosProcesadosH2H;
    /**
     * numero total de archivos procesados de la consulta con los criterios dados
     */
    private int numArchivosProcesados;
    
    /**
     * pagina actual de resultados
     */
    private int paginaActual;
    
    /**
     * num archivos por pagina
     */
    private int numArchivosXPagina = 10;
    /**
     * Servicio para el monitoreo H2H
     */
    private H2HMonitoreoService_CGS h2HMonitoreoService;
    
    private ComboService comboService;
    
    private H2HMonitoreoDetalleErrService h2HMonitoreoDetalleErrService;
    
    private ArrayList paginas = new ArrayList();
    
    private SimpleDateFormat formatoMDA = new SimpleDateFormat("MM/dd/yyyy");
    
    private SimpleDateFormat formatoDMA = new SimpleDateFormat("dd/MM/yyyy");
    
    private int numPaginas;
    
    private String bicRec;
    
    private Resource excelResource;
    
    private ArrayList<H2HMonitoreoDetalleVo> archivosFolioDesconocido = new ArrayList<H2HMonitoreoDetalleVo>();
    
    private boolean renderArchivosFolioDesconocido;
    
    private String bic;
    
    private H2HMonitoreoDetalleVo archivoSelecionado = new H2HMonitoreoDetalleVo();
        
    private boolean descending = false;
    
    private boolean oldDescending = descending;
    /**
     * ordenados por ddefecto por la fecha de proceso en orden ascendente
     */
    private String columnName = "bic1";
    
    private String oldColumnName = columnName;
    
    private String FixedIp;
    private String FixedIpDesc;
    
    private PropertiesService propertiesService;
    
    public H2HMonitoreoController_CGS(){
    }
    private void loadFixedIp(){
    	log.info("Getting Fixed Ip");
    	if(FixedIp==null){
    		FixedIp=propertiesService.getProperty("fxMonitorieo_GD_FileDesc");
    	}
    	if(FixedIpDesc==null){
    		FixedIpDesc=propertiesService.getProperty("fxMonitoreoH2H_FD_FileDesc");
    	}
    	log.info("Gotted : "+FixedIp);
    }
    public String obtenerArchivosProcesados() throws IOException {
    	paginaActual = 1;
    	excelResource = null;
    	numArchivosProcesados = h2HMonitoreoService.obtenerNumArchivosProcesadosH2H(
    			formatoMDA.format(fechaInicial), formatoMDA.format(fechaFinal), bicRec);    	
    	loadFixedIp();
    	if (numArchivosProcesados == 0){
    		numPaginas = 0;
    		paginaActual = 0;
    		excelResource = null;
    	}
    	archivosProcesadosH2H = (ArrayList)h2HMonitoreoService.obtenerArchivosProcesadosH2HXPagina(formatoMDA.format(fechaInicial), 
    			formatoMDA.format(fechaFinal),paginaActual, bicRec, numArchivosXPagina, columnName, descending);
        return "success";
    }
    
    public String obtenerArchivosProcesadosOrdenados() throws IOException, ParseException {
    	loadFixedIp();
    	H2HMonitoreoController_CGS h2HMonitoreoControllerH2H =
            (H2HMonitoreoController_CGS)FacesUtil.getManagedBean("h2HMonitoreoController");
    	h2HMonitoreoControllerH2H.numArchivosProcesados = h2HMonitoreoControllerH2H.h2HMonitoreoService.obtenerNumArchivosProcesadosH2H(
    			formatoMDA.format(h2HMonitoreoControllerH2H.getFechaInicial()), formatoMDA.format(h2HMonitoreoControllerH2H.getFechaFinal()), h2HMonitoreoControllerH2H.getBicRec());    	
    	h2HMonitoreoControllerH2H.paginaActual = 1;    	
    	if (h2HMonitoreoControllerH2H.numArchivosProcesados == 0){
    		numPaginas = 0;
    		paginaActual = 0;
    		excelResource = null;
    	}
    	
    	h2HMonitoreoControllerH2H.archivosProcesadosH2H = (ArrayList)h2HMonitoreoControllerH2H.h2HMonitoreoService.obtenerArchivosProcesadosH2HXPagina(formatoMDA.format(h2HMonitoreoControllerH2H.getFechaInicial()), 
    			formatoMDA.format(h2HMonitoreoControllerH2H.getFechaFinal()), h2HMonitoreoControllerH2H.paginaActual, h2HMonitoreoControllerH2H.getBicRec(), h2HMonitoreoControllerH2H.numArchivosXPagina, h2HMonitoreoControllerH2H.getColumnName(), h2HMonitoreoControllerH2H.isDescending());
        return "success";
    }
    
    public void limpiarExcel(ActionEvent event) {
    	excelResource = null;
    }
    
  
    public void obtenerArchivosFolioDesconocido(){
    	
    	archivosFolioDesconocido = (ArrayList<H2HMonitoreoDetalleVo>)h2HMonitoreoDetalleErrService.obtenerArchivosFolioDesconocido(
    			formatoMDA.format(fechaInicial),formatoMDA.format(fechaFinal));
    	if(archivosFolioDesconocido.size() > 0){
    		renderArchivosFolioDesconocido = true;
    	}
    }
    
    /**
     * SelectionListener bound to the ice:rowSelector component.  Called
     * when a row is selected in the UI.
     *
     * @param event from the ice:rowSelector component
     */
    public void rowSelectionListener(RowSelectorEvent event) {
    	int registroSelected = event.getRow();
    	if (archivosFolioDesconocido.get(registroSelected).isSelected()) {
    		String nombreArchivoDeconocido = archivosFolioDesconocido.get(registroSelected).getNombre_archivo();
        	int  idArchivoDeconocido = new Long(archivosFolioDesconocido.get(registroSelected).getId_archivo()).intValue();
        	archivoSelecionado.setNombre_archivo(nombreArchivoDeconocido);
        	archivoSelecionado.setId_archivo(idArchivoDeconocido);        	
    	}
    	else {
    		archivoSelecionado.setNombre_archivo("");
        	archivoSelecionado.setId_archivo(0);
    	}
    	
    }
    
    public void actualizarArchFolioDesconocido(){
    	h2HMonitoreoDetalleErrService.actualizarArchivoFolioDesconocido(
    			new Long(archivoSelecionado.getId_archivo()).intValue(), bic);
    	archivosFolioDesconocido = (ArrayList<H2HMonitoreoDetalleVo>)h2HMonitoreoDetalleErrService.obtenerArchivosFolioDesconocido(
    			formatoMDA.format(fechaInicial),formatoMDA.format(fechaFinal));
    	archivoSelecionado.setNombre_archivo("");
    	archivoSelecionado.setId_archivo(0);
    }
    
    public void obtenerPrimerPaginaArchivos(){    	
    	if (numArchivosProcesados > 0 && paginaActual != 1) {
    		paginaActual = 1;
    		obtenerArchivosPorPagina(paginaActual);
    	}
    }
    
    public void obtenerPaginaPreviaArchivos(){
    	if (numArchivosProcesados > 0 && paginaActual > 1) {
    		paginaActual = paginaActual-1;
    		obtenerArchivosPorPagina(paginaActual);
    	}
    }
    
    public void obtenerPaginaSiguienteArchivos(){    	
    	if (numArchivosProcesados > 0 && paginaActual < numPaginas) {
    		paginaActual = paginaActual + 1;
    		obtenerArchivosPorPagina(paginaActual);
    	}
    }
    
    public void obtenerUltimaPaginaArchivos(){    	
    	if (numArchivosProcesados > 0 && paginaActual != numPaginas) {
    		paginaActual = numPaginas;
    		obtenerArchivosPorPagina(paginaActual);
    	}
    }
    
    public void obtenerPagina(ActionEvent event){
    	
    	String pagina = FacesUtil.getRequestParameter("pagina");
    	if (!pagina.equals(""+paginaActual)) {
    		paginaActual = new Integer(pagina).intValue();
        	obtenerArchivosPorPagina(paginaActual);
    	}    	
    }
    
    private void obtenerArchivosPorPagina(int pagina){
    	archivosProcesadosH2H = (ArrayList)h2HMonitoreoService.obtenerArchivosProcesadosH2HXPagina(
    		formatoMDA.format(fechaInicial), formatoMDA.format(fechaFinal),pagina, bicRec, numArchivosXPagina, columnName, descending);
    } 
    public void bicChangeListener(ValueChangeEvent event){
		Object bic = event.getNewValue();
		if (event.getNewValue() != null) {
			bic = bic.toString();
		}
	}
    public void closeArchivosFolioDesconocido(){
    	renderArchivosFolioDesconocido = !renderArchivosFolioDesconocido;
    	archivosFolioDesconocido = new ArrayList<H2HMonitoreoDetalleVo>();
    	archivoSelecionado = new H2HMonitoreoDetalleVo();
    }
    
    public Date getFechaInicial() throws ParseException {    	
		return formatoDMA.parse(formatoDMA.format(fechaInicial));
	}


	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}


	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}	
	
	public ComboService getComboService() {
		return comboService;
	}

	public void setComboService(ComboService comboService) {
		this.comboService = comboService;
	}

	public H2HMonitoreoService_CGS getH2HMonitoreoService_CGS() {
		return h2HMonitoreoService;
	}

	public void setH2HMonitoreoService_CGS(H2HMonitoreoService_CGS h2hMonitoreoService) {
		h2HMonitoreoService = h2hMonitoreoService;
	}	
	
	public H2HMonitoreoDetalleErrService getH2HMonitoreoDetalleErrService() {
		return h2HMonitoreoDetalleErrService;
	}

	public void setH2HMonitoreoDetalleErrService(
			H2HMonitoreoDetalleErrService h2hMonitoreoDetalleErrService) {
		h2HMonitoreoDetalleErrService = h2hMonitoreoDetalleErrService;
	}
	public H2HMonitoreoDetalleVo getArchivoSelecionado() {
		return archivoSelecionado;
	}

	public void setArchivoSelecionado(H2HMonitoreoDetalleVo archivoSelecionado) {
		this.archivoSelecionado = archivoSelecionado;
	}

	public ArrayList getGruposArchivosProcesados(){
		return archivosProcesadosH2H;
	}
	
	public int getNumArchivosProcesados() {
		return numArchivosProcesados;
	}

	public void setNumArchivosProcesados(int numArchivosProcesados) {
		this.numArchivosProcesados = numArchivosProcesados;
	}
	
	public ArrayList<H2HMonitoreoDetalleVo> getArchivosFolioDesconocido() {
		return archivosFolioDesconocido;
	}

	public void setArchivosFolioDesconocido(
			ArrayList<H2HMonitoreoDetalleVo> archivosFolioDesconocido) {
		this.archivosFolioDesconocido = archivosFolioDesconocido;
	}

	public int getPaginaActual() {
		return paginaActual;
	}

	public void setPaginaActual(int paginaActual) {
		this.paginaActual = paginaActual;
	}
	
	public String getBicRec() {
		return bicRec;
	}

	public void setBicRec(String bicRec) {
		this.bicRec = bicRec;
	}
	
	
	
	public boolean isRenderArchivosFolioDesconocido() {
		return renderArchivosFolioDesconocido;
	}

	public void setRenderArchivosFolioDesconocido(
			boolean renderArchivosFolioDesconocido) {
		this.renderArchivosFolioDesconocido = renderArchivosFolioDesconocido;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	
	
	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}
	
	public int getNumArchivosXPagina() {
		return numArchivosXPagina;
	}

	public void setNumArchivosXPagina(int numArchivosXPagina) {
		this.numArchivosXPagina = numArchivosXPagina;
	}

	/**
	 *Geter para 
	 * @return the excelResource
	 */
	public Resource getExcelResource() {
		return this.excelResource;
	}
	
	public List < SelectItem > getBics() throws Exception{
		List < SelectItem > bics = new ArrayList < SelectItem >();
		bics = comboService.getDatosCombo("bicsCombo");
		return bics;
	}
	
	/**
	 * @param excelResource the excelResource to set
	 */
	public void setExcelResource(Resource excelResource) {
		this.excelResource = excelResource;
	}
	
	 public void beforePhase(PhaseEvent event) {
		 H2HMonitoreoController_CGS h2HMonitoreoControllerH2H =
             (H2HMonitoreoController_CGS)FacesUtil.getManagedBean("h2HMonitoreoController_CGS");
		 
	        if ((h2HMonitoreoControllerH2H.descending != h2HMonitoreoControllerH2H.oldDescending) ||
	                (!h2HMonitoreoControllerH2H.columnName.equals(h2HMonitoreoControllerH2H.oldColumnName))){	            
	            try {
					obtenerArchivosProcesadosOrdenados();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				h2HMonitoreoControllerH2H.oldDescending = h2HMonitoreoControllerH2H.descending;
				h2HMonitoreoControllerH2H.oldColumnName = h2HMonitoreoControllerH2H.columnName;
	        }
		
	}
	 
	/**
    * <p>Handle a notification that the processing for a particular
    * phase has just been completed.</p>
    */
    public void afterPhase(PhaseEvent event) {}
    
    /**
     * <p>Return the identifier of the request processing phase during
     * which this listener is interested in processing {@link javax.faces.event.PhaseEvent}
     * events.  Legal values are the singleton instances defined by the
     * {@link javax.faces.event.PhaseId} class, including <code>PhaseId.ANY_PHASE</code>
     * to indicate an interest in being notified for all standard phases.</p>
     */
    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }
    
	public boolean isDescending() {
		return descending;
	}

	public void setDescending(boolean descending) {
		oldDescending = this.descending;
        this.descending = descending;
	}

	public boolean isOldDescending() {
		return oldDescending;
	}

	public void setOldDescending(boolean oldDescending) {
		this.oldDescending = oldDescending;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		oldColumnName = this.columnName;
        this.columnName = columnName;
	}

	public String getOldColumnName() {
		return oldColumnName;
	}

	public void setOldColumnName(String oldColumnName) {
		this.oldColumnName = oldColumnName;
	}

	public ArrayList getPaginas(){		
		paginas = new ArrayList();
		if(numArchivosProcesados > 0){			
			numPaginas = (numArchivosProcesados % numArchivosXPagina > 0)?(int)(numArchivosProcesados / numArchivosXPagina)+ 1:(int)(numArchivosProcesados / numArchivosXPagina);			
			for(int i=1; i <= numPaginas; i++){
				paginas.add(i);
			}
		}
		return paginas;
	}
	
	/**
     * time zone
     * @return timezone
     */
    public TimeZone getTimeZone() {
        return TimeZone.getDefault();
    }

	public PropertiesService getPropertiesService() {
		return propertiesService;
	}

	public void setPropertiesService(PropertiesService propertiesService) {
		this.propertiesService = propertiesService;
	}

	public String getFixedIp() {
		loadFixedIp();
		return FixedIp;
	}
	public String getFixedIpDesc() {
		loadFixedIp();
		return FixedIpDesc;
	}
}
