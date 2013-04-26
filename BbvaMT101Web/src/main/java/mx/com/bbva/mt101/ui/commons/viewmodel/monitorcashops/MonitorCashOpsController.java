package mx.com.bbva.mt101.ui.commons.viewmodel.monitorcashops;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;

import mx.com.bbva.mt101.catalogos.stop.logicanegocio.CatalogoStOpBean;
import mx.com.bbva.mt101.catalogos.stop.negocio.ICatalogoStOp;
import mx.com.bbva.mt101.entities.Tgm139Mt101Repte;
import mx.com.bbva.mt101.entities.Tgm141Mt101Envcw;
import mx.com.bbva.mt101.entities.Tgm142Mt101Stenv;
import mx.com.bbva.mt101.monitorcash.logicanegocio.MonitorCashBean;
import mx.com.bbva.mt101.monitorcash.negocio.IMonitorCash;
import mx.com.bbva.mt101.operaciones.logicanegocio.OperacionesBean;
import mx.com.bbva.mt101.operaciones.negocio.IOperaciones;
import mx.com.bbva.mt101.ui.commons.viewmodel.operacionesduplicadas.OperacionesDuplicadasController;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;
import org.apache.log4j.Logger;


public class MonitorCashOpsController extends SelectorComposer<Component> {

	private static final Logger logger = Logger
			.getLogger(MonitorCashOpsController.class);
	
	private static final long serialVersionUID = 1L;

	@EJB
	private IOperaciones operacionesBean;
	
	@EJB
	private ICatalogoStOp catalogoStOpBean;
	
	@EJB
	IMonitorCash monitorCashBean;
		

	List<Tgm139Mt101Repte> operacionesPorCriterio = obtenOperacionesPorCriterio();
	List<Tgm142Mt101Stenv> estatusOperaciones = obtenEstatus(); 
	List<Tgm141Mt101Envcw> lotes = obtenLote(); 

	private Date dateFecProcesoInicio;
	private Date dateFecProcesoFin;
	private String strLote;
	private String strEstatus;
	private String sizeHeigth;
	private String sizeWith;
	private String strCampo20;
	private BigDecimal intCampo50L1;
	private Date dateFechaValor;
	private BigDecimal intImporte32b;

	private boolean sreenModal = false;
	@Wire
	private Datebox fecProcesoInicio;

	@Wire
	private Datebox fecProcesoFin;

	@Wire
	private Combobox lote;

	@Wire
	private Combobox estatus;

	@Wire
	Window monitorCashOpsWindows;

	@Wire
	Textbox campo20;

	@Wire
	Intbox importe32b;

	@Wire
	Datebox fechaValor;

	@Wire
	Intbox campo50L1;

	private int cantidadRegistros;
	private int intEstatusId;

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
	}

	private List<Tgm141Mt101Envcw> obtenLote() {
		monitorCashBean = new MonitorCashBean();
		Tgm141Mt101Envcw tgm141Mt101Envcw = new Tgm141Mt101Envcw();
		tgm141Mt101Envcw.setFhProceso(new Date());
		tgm141Mt101Envcw.setFhProcesoAnt(new Date());
		List<Tgm141Mt101Envcw> tgm141Mt101Envcws = monitorCashBean.obtenerListaArchivos(tgm141Mt101Envcw);
		return tgm141Mt101Envcws;
	}

	private List<Tgm142Mt101Stenv> obtenEstatus() {
		catalogoStOpBean = new CatalogoStOpBean();
		List<Tgm142Mt101Stenv> tgm142Mt101Stenvs = catalogoStOpBean.getTodosEstatus(); 		
		return tgm142Mt101Stenvs;
	}

	public Date getDateFechaValor() {
		return dateFechaValor;
	}

	public Date getDateFecProcesoFin() {
		return dateFecProcesoFin;
	}

	public Date getDateFecProcesoInicio() {
		return dateFecProcesoInicio;
	}

	public Combobox getEstatus() {
		return estatus;
	}

	public BigDecimal getIntCampo50L1() {
		return intCampo50L1;
	}

	public BigDecimal getIntImporte32b() {
		return intImporte32b;
	}

	public IOperaciones getOperacionesBean() {
		return operacionesBean;
	}

	public List<Tgm139Mt101Repte> getoperacionesPorCriterio() {
		return operacionesPorCriterio;
	}

	public List<Tgm139Mt101Repte> getOperacionesPorCriterio() {
		return operacionesPorCriterio;
	}

	public String getSizeHeigth() {
		return sizeHeigth;
	}

	public String getSizeWith() {
		return sizeWith;
	}

	public String getStrCampo20() {
		return strCampo20;
	}

	public String getStrEstatus() {
		return strEstatus;
	}

	public String getStrLote() {
		return strLote;
	}

	public boolean isSreenModal() {
		return sreenModal;
	}
	@Command
	@NotifyChange({ "operacionesPorCriterio" })
	public List<Tgm139Mt101Repte> obtenOperacionesPorCriterio() {
		List<Tgm139Mt101Repte> tgm139Mt101Reptes = null;
		if (Executions.getCurrent() != null) {
			Tgm139Mt101Repte tgm139Mt101Repte = (Tgm139Mt101Repte) Executions
					.getCurrent().getArg().get("tgm139Mt101Repte");
			operacionesBean = new OperacionesBean();
			if (tgm139Mt101Repte != null) {
				try {
					dateFecProcesoInicio = new SimpleDateFormat("dd-MM-yyyy")
							.parse(tgm139Mt101Repte.getFhCampo30());
					dateFecProcesoFin = new SimpleDateFormat("dd-MM-yyyy")
							.parse(tgm139Mt101Repte.getFhCampo30());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				strLote = Integer.toString(tgm139Mt101Repte.getNuLoteEnvio());
				sreenModal = true;
				sizeWith = "70%";
				sizeHeigth = "50%";
				tgm139Mt101Reptes = operacionesBean.getOperacionesPorCriterio(tgm139Mt101Repte);
				cantidadRegistros = tgm139Mt101Reptes.size();
				return tgm139Mt101Reptes;
			} else {				
				sreenModal = false;
				sizeWith = "100%";
				sizeHeigth = "100%";
				boolean error = false;
				try{
					this.fecProcesoFin.clearErrorMessage();
					if (this.fecProcesoInicio == null || this.fecProcesoInicio.getValue() == null) {
						this.fecProcesoInicio
								.setErrorMessage("Favor de capturar la fecha de proceso inicio.");
						error = true;
					}
					else if (this.fecProcesoFin == null || this.fecProcesoFin.getValue() == null) {
						this.fecProcesoFin
								.setErrorMessage("Favor de capturar la fecha de proceso fin.");
						error = true;
					} else if (this.fecProcesoFin.getValue().getTime() < this.fecProcesoInicio
							.getValue().getTime()) {
						this.fecProcesoFin
								.setErrorMessage("La fecha de proceso fin no puede ser menor al a fecha de proceso inicio.");
						error = true;
					}else if(rangoFechasSobrePasaMes()){
						this.fecProcesoFin
						.setErrorMessage("No se puede consultar un rango mayor a un mes");
						error = true;
					}
					logger.debug("error:"+error);
					logger.debug("error:"+(error==false));
					if(error==false){
						logger.debug("entrando a obtener operaciones en base a criterios....");
						tgm139Mt101Repte = new Tgm139Mt101Repte();
						tgm139Mt101Repte.setFhProcesoInicio(this.fecProcesoInicio
								.getValue());
						tgm139Mt101Repte.setFhProcesoFin(this.fecProcesoFin
								.getValue());
						tgm139Mt101Repte.setNuLoteEnvio(Integer.parseInt(this.lote.getValue()
								.equals("") ? "0" : this.lote.getValue()));
						tgm139Mt101Repte.setCdStEnvioMt101(new BigDecimal(this.estatus
								.getValue().equals("") ? "0" : this.estatus.getValue()));
						tgm139Mt101Repte.setNbCampo20(campo20.getValue().isEmpty()?null:campo20.getValue());
//						tgm139Mt101Repte.setImCampo32bMonto(Integer.toString(importe32b.getValue()));
//						tgm139Mt101Repte.setNbCampo21(fechaValor.getValue().toString());
//						tgm139Mt101Repte.setNbCampo50aOcl1(Integer.toString(campo50L1.getValue()));
						logger.debug("getOperacionesPorCriterio");
						logger.debug("tgm139Mt101Repte.getFhProcesoInicio"+tgm139Mt101Repte.getFhProcesoInicio());
						logger.debug("tgm139Mt101Repte.getFhProcesoFin"+tgm139Mt101Repte.getFhProcesoFin());
						logger.debug("tgm139Mt101Repte.getNuLoteEnvio"+tgm139Mt101Repte.getNuLoteEnvio());
						logger.debug("tgm139Mt101Repte.getNbCampo20"+tgm139Mt101Repte.getNbCampo20());
						
						tgm139Mt101Reptes = operacionesBean.getOperacionesPorCriterio(tgm139Mt101Repte);
						cantidadRegistros = tgm139Mt101Reptes.size();
						operacionesPorCriterio = tgm139Mt101Reptes;						
						return tgm139Mt101Reptes;
					}else{
						logger.debug("entrando al else..-.-..");
						return null;
					}
				}catch(Exception ex){
					ex.printStackTrace();
					return null;
				}
			}
		} else {
			return null;
		}
	}

	private boolean rangoFechasSobrePasaMes() {
		BigDecimal valorMes = new BigDecimal(1*60*60*24*30);
		logger.debug("valorMes:"+valorMes);
		logger.debug("fecProcesoFin:"+this.fecProcesoFin.getValue().getTime()/1000);
		logger.debug("fecProcesoInicio:"+this.fecProcesoInicio.getValue().getTime()/1000);
		logger.debug("operation:"+(this.fecProcesoFin.getValue().getTime()-this.fecProcesoInicio.getValue().getTime()));
		if(valorMes.compareTo(new BigDecimal((this.fecProcesoFin.getValue().getTime()-this.fecProcesoInicio.getValue().getTime())/1000))==-1)
			return true;
		else
			return false;
	}

	@Command
	@NotifyChange({ "operacionesPorCriterio" })
	public void reprocesarConsultaOperacion() {
		operacionesBean = new OperacionesBean();
		this.fecProcesoFin.clearErrorMessage();
		if (this.fecProcesoFin == null || this.fecProcesoFin.getValue() == null) {
			this.fecProcesoFin
					.setErrorMessage("Favor de capturar la fecha de proceso fin.");
		} else if (this.fecProcesoFin.getValue().getTime() < this.fecProcesoInicio
				.getValue().getTime()) {
			this.fecProcesoFin
					.setErrorMessage("La fecha de proceso fin no puede ser menor al a fecha de proceso inicio.");
		}

		Tgm139Mt101Repte tgm139Mt101Repte = new Tgm139Mt101Repte();
		tgm139Mt101Repte.setFhProcesoInicio(new Timestamp(this.fecProcesoInicio
				.getValue().getTime()));
		tgm139Mt101Repte.setFhProcesoFin(new Timestamp(this.fecProcesoFin
				.getValue().getTime()));
		tgm139Mt101Repte.setNuLoteEnvio(Integer.parseInt(this.lote.getValue()
				.equals("") ? "0" : this.lote.getValue()));
		tgm139Mt101Repte.setCdStEnvioMt101(new BigDecimal(this.estatus
				.getValue().equals("") ? "0" : this.estatus.getValue()));

		operacionesPorCriterio = operacionesBean
				.getOperacionesPorCriterio(tgm139Mt101Repte);
	}

	public void setDateFechaValor(Date dateFechaValor) {
		this.dateFechaValor = dateFechaValor;
	}

	public void setDateFecProcesoFin(Date dateFecProcesoFin) {
		this.dateFecProcesoFin = dateFecProcesoFin;
	}

	public void setDateFecProcesoInicio(Date dateFecProcesoInicio) {
		this.dateFecProcesoInicio = dateFecProcesoInicio;
	}

	public void setEstatus(Combobox estatus) {
		this.estatus = estatus;
	}

	public void setIntCampo50L1(BigDecimal intCampo50l1) {
		intCampo50L1 = intCampo50l1;
	}

	public void setIntImporte32b(BigDecimal intImporte32b) {
		this.intImporte32b = intImporte32b;
	}

	public void setOperacionesBean(IOperaciones operacionesBean) {
		this.operacionesBean = operacionesBean;
	}

	public void setOperacionesPorCriterio(
			List<Tgm139Mt101Repte> operacionesPorCriterio) {
		this.operacionesPorCriterio = operacionesPorCriterio;
	}

	public void setSizeHeigth(String sizeHeigth) {
		this.sizeHeigth = sizeHeigth;
	}

	public void setSizeWith(String sizeWith) {
		this.sizeWith = sizeWith;
	}

	public void setSreenModal(boolean sreenModal) {
		this.sreenModal = sreenModal;
	}

	public void setStrCampo20(String strCampo20) {
		this.strCampo20 = strCampo20;
	}

	public void setStrEstatus(String strEstatus) {
		this.strEstatus = strEstatus;
	}

	public void setStrLote(String strLote) {
		this.strLote = strLote;
	}

	@Command
	public void showModal(Event e) {
		monitorCashOpsWindows.detach();
	}

	public ICatalogoStOp getCatalogoStOpBean() {
		return catalogoStOpBean;
	}

	public void setCatalogoStOpBean(ICatalogoStOp catalogoStOpBean) {
		this.catalogoStOpBean = catalogoStOpBean;
	}

	public int getCantidadRegistros() {
		return cantidadRegistros;
	}

	public void setCantidadRegistros(int cantidadRegistros) {
		this.cantidadRegistros = cantidadRegistros;
	}

	public int getIntEstatusId() {
		return intEstatusId;
	}

	public void setIntEstatusId(int intEstatusId) {
		this.intEstatusId = intEstatusId;
	}

	public List<Tgm142Mt101Stenv> getEstatusOperaciones() {
		return estatusOperaciones;
	}

	public void setEstatusOperaciones(List<Tgm142Mt101Stenv> estatusOperaciones) {
		this.estatusOperaciones = estatusOperaciones;
	}

	public IMonitorCash getMonitorCashBean() {
		return monitorCashBean;
	}

	public void setMonitorCashBean(IMonitorCash monitorCashBean) {
		this.monitorCashBean = monitorCashBean;
	}

	public List<Tgm141Mt101Envcw> getLotes() {
		return lotes;
	}

	public void setLotes(List<Tgm141Mt101Envcw> lotes) {
		this.lotes = lotes;
	}
}
