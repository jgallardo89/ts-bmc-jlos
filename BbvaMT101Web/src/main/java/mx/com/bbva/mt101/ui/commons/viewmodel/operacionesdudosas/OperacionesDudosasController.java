package mx.com.bbva.mt101.ui.commons.viewmodel.operacionesdudosas;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
import mx.com.bbva.mt101.operaciones.logicanegocio.OperacionesBean;
import mx.com.bbva.mt101.operaciones.negocio.IOperaciones;

import org.apache.log4j.Logger;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;

public class OperacionesDudosasController extends SelectorComposer<Component> {

	private static final Logger logger = Logger
			.getLogger(OperacionesDudosasController.class);

	private static final long serialVersionUID = 1L;

	@EJB
	private IOperaciones operacionesBean;

	@EJB
	private IProcesoLog procesoLogBean;

	@EJB
	private IEventoWeb eventoWebBean;

	List<Tgm139Mt101Repte> operacionesDudosas = obtenOperacionesPorCriterio();

	private String srtFolioAceptacion;
	private String srtEstatusOperacion;
	private String strDescripcionEstatus;
	private long intCdRepteMt101;

	@Wire
	private Grid operacionesDudosasGrid;

	@Wire
	private Textbox folioAcpetacion;

	@Wire
	private Textbox estatusOperacion;

	@Wire
	private Textbox descripcionEstatus;

	@Wire
	private Intbox cdRepteMt101;

	@Wire
	private Radiogroup radiosToEdit;

	private int cantidadRegistros;

	private String strReferencia;

	@Command
	@NotifyChange({ "operacionesDudosas", "cantidadRegistros" })
	public void actualizarStatus() {

		this.descripcionEstatus.clearErrorMessage();
		this.estatusOperacion.clearErrorMessage();
		this.folioAcpetacion.clearErrorMessage();
		this.cdRepteMt101.clearErrorMessage();
		if (this.cdRepteMt101 != null && this.cdRepteMt101.getValue() != null
				&& this.cdRepteMt101.getValue() != 0) {

			boolean datatosValidos = false;
			datatosValidos = validarDatos();

			if (datatosValidos) {
				Messagebox.show(
						"¿Está seguro de cambiar el estatus de la operación?",
						"Pregunta", Messagebox.YES | Messagebox.NO,
						Messagebox.QUESTION, new EventListener<Event>() {
							@Override
							public void onEvent(Event event) throws Exception {
								if (event.getName().equals(Messagebox.ON_YES)) {
									Tgm139Mt101Repte tgm139Mt101Repte;
									if (operacionesBean == null)
										operacionesBean = new OperacionesBean();
									tgm139Mt101Repte = new Tgm139Mt101Repte();
									tgm139Mt101Repte
											.setCdRepteMt101(new BigDecimal(
													cdRepteMt101.getValue()
															.intValue()));
									tgm139Mt101Repte
											.setNbFolAcepCw(folioAcpetacion
													.getValue().toUpperCase()
													.trim());
									tgm139Mt101Repte
											.setNbDescStCw(descripcionEstatus
													.getValue().toUpperCase()
													.trim());
									tgm139Mt101Repte
											.setNbStOpeCw(estatusOperacion
													.getValue().toUpperCase()
													.trim());
									if (estatusOperacion.getValue().equals(
											"CHSW000")) {
										logger.debug("Actualizando en estatus correcta");
										// CD_ST_ENVIO_MT101 = 3
										tgm139Mt101Repte
												.setCdStEnvioMt101(new BigDecimal(
														3));
										tgm139Mt101Repte.setNbStOpeCw("");
										tgm139Mt101Repte.setNbDescStCw("");
										operacionesBean
												.updateEstatusOperacion(tgm139Mt101Repte);
										registraEvento(
												"actualizó el estatus de la operación "
														+ strReferencia
														+ " de " + "Dudosa"
														+ " a " + "Correcta",
												400);
									} else if (estatusOperacion.getValue()
											.toUpperCase().startsWith("S0")
											|| estatusOperacion.getValue()
													.equals("CHSW999")) {
										logger.debug("Actualizando en error en swift");
										// CD_ST_ENVIO_MT101 = 5
										tgm139Mt101Repte
												.setCdStEnvioMt101(new BigDecimal(
														5));
										operacionesBean
												.updateEstatusOperacion(tgm139Mt101Repte);
										registraEvento(
												"actualizó el estatus de la operación "
														+ strReferencia
														+ " de " + "Dudosa"
														+ " a " + "Error Swift",
												400);
									} else if (estatusOperacion.getValue()
											.startsWith("RCASH")) {
										logger.debug("Actualizando en error en cash");
										// CD_ST_ENVIO_MT101 = 7
										tgm139Mt101Repte
												.setCdStEnvioMt101(new BigDecimal(
														7));
										operacionesBean
												.updateEstatusOperacion(tgm139Mt101Repte);
										registraEvento(
												"actualizó el estatus de la operación "
														+ strReferencia
														+ " de " + "Dudosa"
														+ " a " + "Error Cash",
												400);
									} else {
										logger.debug("Actualizando descripción y dejando en dudosa la operación");
										// No se actualiza nada o se queda en 7
										tgm139Mt101Repte
												.setCdStEnvioMt101(new BigDecimal(
														7));
										operacionesBean
												.updateEstatusOperacion(tgm139Mt101Repte);
										registraEvento(
												"actualizó el estatus de la operación "
														+ strReferencia
														+ " de " + "Dudosa"
														+ " a " + "Dudosa", 400);
									}
									Messagebox.show(
											"Registro actualizado con exito.",
											"Confirmación", Messagebox.OK,
											Messagebox.INFORMATION);
									limpiarDatos();
									BindUtils
											.postGlobalCommand(
													null,
													null,
													"resetGridOperacionesDudosas",
													null);
								}
							}
						});
			}
		} else {
			Messagebox.show("Favor de seleccionar la operación a actualizar",
					"Error", Messagebox.OK, Messagebox.ERROR);
		}
	}

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
	}

	@Command
	@NotifyChange({ "operacionesDudosas" })
	public void establecerFiltro() {
		operacionesDudosas = obtenOperacionesPorCriterio();
	}

	public int getCantidadRegistros() {
		return cantidadRegistros;
	}

	public IEventoWeb getEventoWebBean() {
		return eventoWebBean;
	}

	public long getIntCdRepteMt101() {
		return intCdRepteMt101;
	}

	@Command
	@NotifyChange({ "srtFolioAceptacion", "srtEstatusOperacion",
			"strDescripcionEstatus", "intCdRepteMt101", "strReferencia" })
	public void getOperacionDudosa(
			@BindingParam("referenciaOperacion") final Tgm139Mt101Repte tgm139Mt101Repte) {
		logger.debug(tgm139Mt101Repte.getCdRepteMt101());
		this.intCdRepteMt101 = tgm139Mt101Repte.getCdRepteMt101().intValue();
		this.strReferencia = tgm139Mt101Repte.getNbCampo20();
		this.srtFolioAceptacion = tgm139Mt101Repte.getNbFolAcepCw();
		this.strDescripcionEstatus = tgm139Mt101Repte.getNbDescStCw();
		this.srtEstatusOperacion = tgm139Mt101Repte.getNbStOpeCw();
	}

	public List<Tgm139Mt101Repte> getOperacionesDudosas() {
		return operacionesDudosas;
	}

	public IProcesoLog getProcesoLogBean() {
		return procesoLogBean;
	}

	public String getSrtEstatusOperacion() {
		return srtEstatusOperacion;
	}

	public String getSrtFolioAceptacion() {
		return srtFolioAceptacion;
	}

	public String getStrDescripcionEstatus() {
		return strDescripcionEstatus;
	}

	public String getStrReferencia() {
		return strReferencia;
	}

	@Command
	public void limpiarDatos() {
		this.descripcionEstatus.clearErrorMessage();
		this.estatusOperacion.clearErrorMessage();
		this.folioAcpetacion.clearErrorMessage();
		this.cdRepteMt101.clearErrorMessage();

		this.descripcionEstatus.setValue(null);
		this.estatusOperacion.setValue(null);
		this.folioAcpetacion.setValue(null);
		this.cdRepteMt101.setValue(null);
		this.radiosToEdit.setSelectedItem(null);
	}

	public List<Tgm139Mt101Repte> obtenOperacionesPorCriterio() {

		operacionesBean = new OperacionesBean();

		Tgm139Mt101Repte tgm139Mt101Repte = new Tgm139Mt101Repte();
		tgm139Mt101Repte.setCdStEnvioMt101(new BigDecimal(7));
		List<Tgm139Mt101Repte> tgm139Mt101Reptes = operacionesBean
				.getOperacionesPorEstatus(tgm139Mt101Repte);
		cantidadRegistros = tgm139Mt101Reptes.size();
		return tgm139Mt101Reptes;

	}

	protected void registraEvento(String txEventoWebLog, int idTpEvento) {
		Tgm023Usuario tgm023Usuario = null;
		tgm023Usuario = (Tgm023Usuario) this.getPage().getDesktop()
				.getSession().getAttribute("tgm023Usuario");
		this.procesoLogBean = new ProcesoLogBean();
		Tgm048ProcesoLog tgm048ProcesoLog = null;
		tgm048ProcesoLog = new Tgm048ProcesoLog();
		tgm048ProcesoLog.setCdTpEvento(idTpEvento);
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

	@Command
	@NotifyChange({ "operacionesDudosas", "cantidadRegistros" })
	public void reprocesarOperacion() {
		this.descripcionEstatus.clearErrorMessage();
		this.estatusOperacion.clearErrorMessage();
		this.folioAcpetacion.clearErrorMessage();
		this.cdRepteMt101.clearErrorMessage();
		this.descripcionEstatus.setValue(null);
		this.estatusOperacion.setValue(null);
		this.folioAcpetacion.setValue(null);
		if (this.cdRepteMt101 != null && this.cdRepteMt101.getValue() != null
				&& this.cdRepteMt101.getValue() != 0) {
			Messagebox.show(
					"¿Está seguro de cambiar el estatus de la operación?",
					"Pregunta", Messagebox.YES | Messagebox.NO,
					Messagebox.QUESTION, new EventListener<Event>() {
						@Override
						public void onEvent(Event event) throws Exception {
							if (event.getName().equals(Messagebox.ON_YES)) {
								Tgm139Mt101Repte tgm139Mt101Repte;
								if (operacionesBean == null)
									operacionesBean = new OperacionesBean();
								tgm139Mt101Repte = new Tgm139Mt101Repte();
								logger.debug("Enviando a reprocesar operación");
								// CD_ST_ENVIO_MT101 = 1
								tgm139Mt101Repte
										.setCdStEnvioMt101(new BigDecimal(1));
								tgm139Mt101Repte
										.setCdRepteMt101(new BigDecimal(
												cdRepteMt101.getValue()
														.intValue()));
								tgm139Mt101Repte.setNbStOpeCw("");
								tgm139Mt101Repte.setNbDescStCw("");
								tgm139Mt101Repte.setNbFolAcepCw("");
								operacionesBean
										.actualizaEstatusOperacionReprocesar(tgm139Mt101Repte);
								Messagebox.show(
										"Registro actualizado con exito.",
										"Confirmación", Messagebox.OK,
										Messagebox.INFORMATION);
								limpiarDatos();
								BindUtils.postGlobalCommand(null, null,
										"resetGridOperacionesDudosas", null);
								registraEvento("reprocesó la operación "
										+ strReferencia, 401);
							}
						}
					});
		} else {
			Messagebox.show("Favor de seleccionar la operación a reprocesar",
					"Error", Messagebox.OK, Messagebox.ERROR);
		}
	}

	@GlobalCommand("resetGridOperacionesDudosas")
	@NotifyChange({ "operacionesDudosas", "cantidadRegistros" })
	public void resetGrid() {
		operacionesDudosas = obtenOperacionesPorCriterio();
		operacionesDudosasGrid.invalidate();
	}

	public void setCantidadRegistros(int cantidadRegistros) {
		this.cantidadRegistros = cantidadRegistros;
	}

	public void setEventoWebBean(IEventoWeb eventoWebBean) {
		this.eventoWebBean = eventoWebBean;
	}

	public void setIntCdRepteMt101(long intCdRepteMt101) {
		this.intCdRepteMt101 = intCdRepteMt101;
	}

	public void setOperacionesBean(IOperaciones operacionesBean) {
		this.operacionesBean = operacionesBean;
	}

	public void setProcesoLogBean(IProcesoLog procesoLogBean) {
		this.procesoLogBean = procesoLogBean;
	}

	public void setSrtEstatusOperacion(String srtEstatusOperacion) {
		this.srtEstatusOperacion = srtEstatusOperacion;
	}

	public void setSrtFolioAceptacion(String srtFolioAceptacion) {
		this.srtFolioAceptacion = srtFolioAceptacion;
	}

	public void setStrDescripcionEstatus(String strDescripcionEstatus) {
		this.strDescripcionEstatus = strDescripcionEstatus;
	}

	public void setStrReferencia(String strReferencia) {
		this.strReferencia = strReferencia;
	}

	public void setTgm139Mt101Reptes(List<Tgm139Mt101Repte> tgm139Mt101Reptes) {
		this.operacionesDudosas = tgm139Mt101Reptes;
	}

	private boolean validarDatos() {

		boolean datosValidos = true;
		if (this.folioAcpetacion.getValue().isEmpty()) {
			this.folioAcpetacion
					.setErrorMessage("Favor de capturar el folio de Aceptación");
			datosValidos = false;
		} else if (!this.folioAcpetacion.getValue().matches(".[a-zA-Z0-9]+")) {
			this.folioAcpetacion
					.setErrorMessage("El folio de aceptación solo puede contener caracteres de la A a la Z y del 0 al 9");
			datosValidos = false;
		} else if (this.folioAcpetacion.getValue().length() < 15) {
			this.folioAcpetacion
					.setErrorMessage("El folio de aceptación debe ser de 15 digitos");
			datosValidos = false;
		}
		if (this.descripcionEstatus.getValue().isEmpty()) {
			this.descripcionEstatus
					.setErrorMessage("Favor de capturar la descripción del estatus");
			datosValidos = false;
		}
		if (this.estatusOperacion.getValue().isEmpty()) {
			this.estatusOperacion
					.setErrorMessage("Favor de capturar el estatus de la operación");
			datosValidos = false;
		} else if (!this.estatusOperacion.getValue().matches(".[a-zA-Z0-9]+")) {
			this.estatusOperacion
					.setErrorMessage("El estatus de la operación solo puede contener caracteres de la A a la Z y del 0 al 9");
			datosValidos = false;
		} else if (this.estatusOperacion.getValue().length() < 7) {
			this.estatusOperacion
					.setErrorMessage("El estatus de la operación debe ser de 7 digitos");
			datosValidos = false;
		}

		return datosValidos;
	}
}
