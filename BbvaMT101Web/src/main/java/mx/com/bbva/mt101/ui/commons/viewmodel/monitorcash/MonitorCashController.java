package mx.com.bbva.mt101.ui.commons.viewmodel.monitorcash;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;

import mx.com.bbva.mt101.audit.logicanegocio.EventoWebBean;
import mx.com.bbva.mt101.audit.logicanegocio.ProcesoLogBean;
import mx.com.bbva.mt101.audit.negocio.IEventoWeb;
import mx.com.bbva.mt101.audit.negocio.IProcesoLog;
import mx.com.bbva.mt101.commons.constantes.IConstantesCatalogos;
import mx.com.bbva.mt101.entities.Tgm023Usuario;
import mx.com.bbva.mt101.entities.Tgm048ProcesoLog;
import mx.com.bbva.mt101.entities.Tgm107EventoWeb;
import mx.com.bbva.mt101.entities.Tgm139Mt101Repte;
import mx.com.bbva.mt101.entities.Tgm140Mt101Solrv;
import mx.com.bbva.mt101.entities.Tgm141Mt101Envcw;
import mx.com.bbva.mt101.monitorcash.logicanegocio.MonitorCashBean;
import mx.com.bbva.mt101.monitorcash.negocio.IMonitorCash;
import mx.com.bbva.mt101.operaciones.logicanegocio.OperacionesBean;
import mx.com.bbva.mt101.operaciones.negocio.IOperaciones;

import org.apache.log4j.Logger;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModelArray;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class MonitorCashController extends SelectorComposer<Component> {

	private static final Logger logger = Logger
			.getLogger(MonitorCashController.class);

	@EJB
	IMonitorCash monitorCashBean;

	@EJB
	private IProcesoLog procesoLogBean;

	@EJB
	private IEventoWeb eventoWebBean;

	@EJB
	private IOperaciones operacionesBean;

	private List<Tgm141Mt101Envcw> listaArchivos = obtenListaArchivos();
	private List<Tgm141Mt101Envcw> listaArchivosParaReenviar = obtenListaArchivosParaReenviar();
	private int opsDudodas = getOperacionesDudosas();
	private int opsDuplicadas = getOperacionesDuplicadas();
	private int opsRecibidas = getOperacionesRecibidas();
	private int opsEnviadas = getOperacionesEnviadas();
	private int opsFuturo = getOperacionesAFuturo();
	private int opsPenEnv = getOperacionesPendientesEnvio();
	private int cantidadRegistros;
	@Wire
	private Intbox cdEnvCash;

	@Wire
	private Textbox comentarioReenvio;

	@Wire
	private Combobox archivosReenvio;

	private int intCdEnvCash;

	private String strComentarioReenvio;

	private static final long serialVersionUID = 1L;

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
	}

	@Command
	@NotifyChange({ "clientes" })
	public void getArchivo(
			@BindingParam("idArchivo") final Tgm141Mt101Envcw tgm141Mt101Envcw) {
		logger.debug("Consultando detalle de archivo:"
				+ tgm141Mt101Envcw.getNbArchivoCw());
		Map<String, Object> mapDatos;
		mapDatos = new HashMap<String, Object>();

		Tgm139Mt101Repte tgm139Mt101Repte = new Tgm139Mt101Repte();
		tgm139Mt101Repte.setNbArchCash(tgm141Mt101Envcw.getNbArchivoCw());
		tgm139Mt101Repte.setNuLoteEnvio(tgm141Mt101Envcw.getNuLote());
		tgm139Mt101Repte.setFhCampo30(tgm141Mt101Envcw.getFhProceso());

		mapDatos.put("tgm139Mt101Repte", tgm139Mt101Repte);
		Window window = (Window) Executions.createComponents(
				"/WEB-INF/flows/monitorCashOps/monitorCashOps.zul",
				this.getSelf(), mapDatos);
		window.doModal();

	}

	public int getCantidadRegistros() {
		return cantidadRegistros;
	}

	public IEventoWeb getEventoWebBean() {
		return eventoWebBean;
	}

	public int getIntCdEnvCash() {
		return intCdEnvCash;
	}

	public List<Tgm141Mt101Envcw> getListaArchivos() {
		return listaArchivos;
	}

	public List<Tgm141Mt101Envcw> getListaArchivosParaReenviar() {
		return listaArchivosParaReenviar;
	}

	public IMonitorCash getMonitorCashBean() {
		return monitorCashBean;
	}

	private int getOperacionesAFuturo() {
		operacionesBean = new OperacionesBean();
		List<Tgm139Mt101Repte> tgm139Mt101Reptes = null;
		Tgm139Mt101Repte tgm139Mt101Repte = null;
		tgm139Mt101Repte = new Tgm139Mt101Repte();
		tgm139Mt101Repte.setFhCampo30T(new Date());
		tgm139Mt101Repte.setCdStEnvioMt101(new BigDecimal(1));
		tgm139Mt101Reptes = operacionesBean
				.getOperacionesPorCriterio(tgm139Mt101Repte);
		return tgm139Mt101Reptes.size();
	}

	public IOperaciones getOperacionesBean() {
		return operacionesBean;
	}

	public int getOperacionesDudosas() {
		operacionesBean = new OperacionesBean();
		List<Tgm139Mt101Repte> tgm139Mt101Reptes = null;
		Tgm139Mt101Repte tgm139Mt101Repte = null;
		tgm139Mt101Repte = new Tgm139Mt101Repte();
		tgm139Mt101Repte.setCdStEnvioMt101(new BigDecimal(7));
		tgm139Mt101Reptes = operacionesBean
				.getOperacionesPorCriterio(tgm139Mt101Repte);
		return tgm139Mt101Reptes.size();
	}

	public int getOperacionesDuplicadas() {
		operacionesBean = new OperacionesBean();
		List<Tgm139Mt101Repte> tgm139Mt101Reptes = null;
		Tgm139Mt101Repte tgm139Mt101Repte = null;
		tgm139Mt101Repte = new Tgm139Mt101Repte();
		tgm139Mt101Repte.setCdStEnvioMt101(new BigDecimal(13));
		tgm139Mt101Reptes = operacionesBean
				.getOperacionesPorCriterio(tgm139Mt101Repte);
		return tgm139Mt101Reptes.size();
	}

	private int getOperacionesEnviadas() {
		operacionesBean = new OperacionesBean();
		List<Tgm139Mt101Repte> tgm139Mt101Reptes = null;
		Tgm139Mt101Repte tgm139Mt101Repte = null;
		tgm139Mt101Repte = new Tgm139Mt101Repte();
		tgm139Mt101Repte.setFhCampo30T2(new Date());
		tgm139Mt101Repte.setValidaNoNuloArchivo(1);
		tgm139Mt101Reptes = operacionesBean
				.getOperacionesPorCriterio(tgm139Mt101Repte);
		return tgm139Mt101Reptes.size();
	}

	private int getOperacionesPendientesEnvio() {
		operacionesBean = new OperacionesBean();
		List<Tgm139Mt101Repte> tgm139Mt101Reptes = null;
		Tgm139Mt101Repte tgm139Mt101Repte = null;
		tgm139Mt101Repte = new Tgm139Mt101Repte();
		tgm139Mt101Repte.setFhProcesoInicio(new Date());
		tgm139Mt101Repte.setFhProcesoFin(new Date());
		tgm139Mt101Repte.setCdStEnvioMt101(new BigDecimal(1));
		tgm139Mt101Reptes = operacionesBean
				.getOperacionesPorCriterio(tgm139Mt101Repte);
		return tgm139Mt101Reptes.size();
	}

	private int getOperacionesRecibidas() {
		operacionesBean = new OperacionesBean();
		List<Tgm139Mt101Repte> tgm139Mt101Reptes = null;
		Tgm139Mt101Repte tgm139Mt101Repte = null;
		tgm139Mt101Repte = new Tgm139Mt101Repte();
		tgm139Mt101Repte.setFhCampo30T2(new Date());
		tgm139Mt101Repte.setValidaNoNuloArchivo(1);
		tgm139Mt101Repte.setCdStEnvioMt101T(new BigDecimal(2));
		tgm139Mt101Reptes = operacionesBean
				.getOperacionesPorCriterio(tgm139Mt101Repte);
		return tgm139Mt101Reptes.size();
	}

	public int getOpsDudodas() {
		return opsDudodas;
	}

	public int getOpsDuplicadas() {
		return opsDuplicadas;
	}

	public int getOpsEnviadas() {
		return opsEnviadas;
	}

	public int getOpsFuturo() {
		return opsFuturo;
	}

	public int getOpsPenEnv() {
		return opsPenEnv;
	}

	public int getOpsRecibidas() {
		return opsRecibidas;
	}

	public IProcesoLog getProcesoLogBean() {
		return procesoLogBean;
	}

	public String getStrComentarioReenvio() {
		return strComentarioReenvio;
	}

	@Command
	public void loteSiguiente() {
		Messagebox.show("¿Está seguro de enviar lote siguiente? ", "Pregunta",
				Messagebox.YES | Messagebox.NO, Messagebox.QUESTION,
				new EventListener<Event>() {
					@Override
					public void onEvent(Event event) throws Exception {
						if (event.getName().equals(Messagebox.ON_YES)) {
							monitorCashBean = new MonitorCashBean();
							monitorCashBean.updateLoteSigCfg();
							registraEvento(" envió el lote siguiente ", 402);
						}
					}
				});
	}

	@Command
	@NotifyChange({ "cantidadRegistros", "listaArchivos" })
	public List<Tgm141Mt101Envcw> obtenListaArchivos() {
		monitorCashBean = new MonitorCashBean();

		Tgm141Mt101Envcw tgm141Mt101Envcw = new Tgm141Mt101Envcw();
		Date fechaHoy = new Date();
		tgm141Mt101Envcw.setFhProceso(fechaHoy);
		long diaMilis = 24 * 60 * 60 * 1000;
		Date fechaAnterior = new Date(fechaHoy.getTime() - diaMilis);
		logger.debug(fechaHoy);
		logger.debug(fechaAnterior);
		if (fechaAnterior.getDay() == Calendar.SUNDAY)
			fechaAnterior = new Date(fechaHoy.getTime() - diaMilis);
		if (fechaAnterior.getDay() == Calendar.SATURDAY)
			fechaAnterior = new Date(fechaAnterior.getTime() - diaMilis);
		tgm141Mt101Envcw.setFhProcesoAnt(fechaAnterior);
		logger.debug(fechaAnterior);
		List<Tgm141Mt101Envcw> tgm141Mt101Envcws = monitorCashBean
				.obtenerListaArchivos(tgm141Mt101Envcw);
		cantidadRegistros = tgm141Mt101Envcws.size();
		listaArchivos = tgm141Mt101Envcws;
		return tgm141Mt101Envcws;
	}

	private List<Tgm141Mt101Envcw> obtenListaArchivosParaReenviar() {
		monitorCashBean = new MonitorCashBean();
		return monitorCashBean.obtenerListaArchivosParaReenvio();
	}

	@Command
	@NotifyChange({ "listaArchivosParaReenviar" })
	public void reenviarArchivo() {
		logger.debug("Reenviando...");
		boolean error = false;
		// Seleccione un archivo válido a reenviar
		if (cdEnvCash.getValue() == 0) {
			archivosReenvio
					.setErrorMessage("Seleccione un archivo válido a reenviar");
			error = true;
		}
		if (comentarioReenvio.getValue().isEmpty()) {
			comentarioReenvio
					.setErrorMessage("Escriba un comentario para el reenvío");
			error = true;
		}
		if (error == false) {
			Messagebox.show("¿Está seguro de reenviar? ", "Pregunta",
					Messagebox.YES | Messagebox.NO, Messagebox.QUESTION,
					new EventListener<Event>() {
						@Override
						public void onEvent(Event event) throws Exception {
							if (event.getName().equals(Messagebox.ON_YES)) {
								monitorCashBean = new MonitorCashBean();
								Tgm141Mt101Envcw tgm141Mt101Envcw = null;
								tgm141Mt101Envcw = new Tgm141Mt101Envcw();
								tgm141Mt101Envcw.setCdEnvCash(cdEnvCash
										.getValue());
								tgm141Mt101Envcw = monitorCashBean
										.getArchivoParaRenvio(tgm141Mt101Envcw);
								if (tgm141Mt101Envcw.getCdRegresoCash() == 0) {
									if (tgm141Mt101Envcw.getCtNumReenvio() >= tgm141Mt101Envcw
											.getNuReintentosSistema()) {
										tgm141Mt101Envcw
												.setCtNumReenvio(tgm141Mt101Envcw
														.getCtNumReenvio() + 1);
										tgm141Mt101Envcw
												.setFhUltimoReenv(new Date());
										monitorCashBean
												.updateArchivo(tgm141Mt101Envcw);
										Tgm140Mt101Solrv tgm140Mt101Solrv = null;
										tgm140Mt101Solrv = new Tgm140Mt101Solrv();
										tgm140Mt101Solrv.setCdEnvCash(new BigDecimal(
												tgm141Mt101Envcw.getCdEnvCash()));
										Tgm023Usuario tgm023Usuario = null;
										tgm023Usuario = (Tgm023Usuario) getPage()
												.getDesktop().getSession()
												.getAttribute("tgm023Usuario");
										tgm140Mt101Solrv
												.setCdUsuario(tgm023Usuario
														.getCdUsuario());
										tgm140Mt101Solrv
												.setNuLote(new BigDecimal(
														tgm141Mt101Envcw
																.getNuLote()));
										tgm140Mt101Solrv
												.setStLote(new BigDecimal(0));
										tgm140Mt101Solrv
												.setTmFechaLote(new Date());
										tgm140Mt101Solrv
												.setTmReenvio(new Date());
										tgm140Mt101Solrv
												.setTxComentario(comentarioReenvio
														.getValue());
										monitorCashBean
												.setArchivoParaReenviar(tgm140Mt101Solrv);
										registraEvento(" reenvió el lote "
												+ tgm141Mt101Envcw.getNuLote(),
												401);
										archivosReenvio.invalidate();
										listaArchivosParaReenviar = obtenListaArchivosParaReenviar();
										archivosReenvio
												.setModel(new ListModelArray<Tgm141Mt101Envcw>(
														listaArchivosParaReenviar));
										cdEnvCash.setValue(null);
										comentarioReenvio.setValue("");
										archivosReenvio.setValue("");
										Messagebox
												.show("Se realizó el reenvío con éxito",
														"Información",
														Messagebox.OK,
														Messagebox.INFORMATION);
									} else {
										Messagebox
												.show("Aún no se ha cumpldo el número de reintos por sistema",
														"Error", Messagebox.OK,
														Messagebox.ERROR);
									}
								} else {
									Messagebox
											.show("EL archivo ya cuenta con acuse de recibo CASH",
													"Error", Messagebox.OK,
													Messagebox.ERROR);
								}
							}

						}
					});
		}
	}

	protected void registraEvento(String txEventoWebLog, int tpEvento) {
		Tgm023Usuario tgm023Usuario = null;
		tgm023Usuario = (Tgm023Usuario) this.getPage().getDesktop()
				.getSession().getAttribute("tgm023Usuario");
		this.procesoLogBean = new ProcesoLogBean();
		Tgm048ProcesoLog tgm048ProcesoLog = null;
		tgm048ProcesoLog = new Tgm048ProcesoLog();
		tgm048ProcesoLog.setCdTpEvento(tpEvento);
		tgm048ProcesoLog.setTxProcesoLog("El usuario "
				+ tgm023Usuario.getCdClaveUsuario() + " " + txEventoWebLog);
		tgm048ProcesoLog.setTmProcesoLog(new Date());
		tgm048ProcesoLog.setCdProcesoGis(IConstantesCatalogos.CD_PROCESO_GIS);
		this.procesoLogBean.setProcesoLog(tgm048ProcesoLog);

		this.eventoWebBean = new EventoWebBean();
		Tgm107EventoWeb tgm107EventoWeb = null;
		tgm107EventoWeb = new Tgm107EventoWeb();
		tgm107EventoWeb.setCdUsuario(tgm023Usuario.getCdUsuario().longValue());
		tgm107EventoWeb.setTmEventoWeb(new Date());
		tgm107EventoWeb.setTxEventoWeb("El usuario "
				+ tgm023Usuario.getCdClaveUsuario() + " " + txEventoWebLog);
		this.eventoWebBean.setEventoWeb(tgm107EventoWeb);
	}

	public void setCantidadRegistros(int cantidadRegistros) {
		this.cantidadRegistros = cantidadRegistros;
	}

	public void setEventoWebBean(IEventoWeb eventoWebBean) {
		this.eventoWebBean = eventoWebBean;
	}

	public void setIntCdEnvCash(int intCdEnvCash) {
		this.intCdEnvCash = intCdEnvCash;
	}

	public void setListaArchivos(List<Tgm141Mt101Envcw> listaArchivos) {
		this.listaArchivos = listaArchivos;
	}

	public void setListaArchivosParaReenviar(
			List<Tgm141Mt101Envcw> listaArchivosParaReenviar) {
		this.listaArchivosParaReenviar = listaArchivosParaReenviar;
	}

	public void setMonitorCashBean(IMonitorCash monitorCashBean) {
		this.monitorCashBean = monitorCashBean;
	}

	public void setOperacionesBean(IOperaciones operacionesBean) {
		this.operacionesBean = operacionesBean;
	}

	public void setOpsDudodas(int opsDudodas) {
		this.opsDudodas = opsDudodas;
	}

	public void setOpsDuplicadas(int opsDuplicadas) {
		this.opsDuplicadas = opsDuplicadas;
	}

	public void setOpsEnviadas(int opsEnviadas) {
		this.opsEnviadas = opsEnviadas;
	}

	public void setOpsFuturo(int opsFuturo) {
		this.opsFuturo = opsFuturo;
	}

	public void setOpsPenEnv(int opsPenEnv) {
		this.opsPenEnv = opsPenEnv;
	}

	public void setOpsRecibidas(int opsRecibidas) {
		this.opsRecibidas = opsRecibidas;
	}

	public void setProcesoLogBean(IProcesoLog procesoLogBean) {
		this.procesoLogBean = procesoLogBean;
	}

	public void setStrComentarioReenvio(String strComentarioReenvio) {
		this.strComentarioReenvio = strComentarioReenvio;
	}
}
