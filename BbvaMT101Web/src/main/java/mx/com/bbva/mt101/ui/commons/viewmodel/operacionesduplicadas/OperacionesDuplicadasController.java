package mx.com.bbva.mt101.ui.commons.viewmodel.operacionesduplicadas;

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
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;

public class OperacionesDuplicadasController extends
		SelectorComposer<Component> {

	private static final Logger logger = Logger
			.getLogger(OperacionesDuplicadasController.class);

	private static final long serialVersionUID = 1L;

	@EJB
	private IOperaciones operacionesBean;

	@EJB
	private IProcesoLog procesoLogBean;

	@EJB
	private IEventoWeb eventoWebBean;

	List<Tgm139Mt101Repte> operacionesDuplicadas = obtenOperacionesPorCriterio();

	private String intReferencia;

	private long intCdRepteMt101;
	@Wire
	private Grid operacionesDuplicadasGrid;

	@Wire
	private Intbox cdRepteMt101;

	@Wire
	Textbox referencia;

	@Wire
	private Radiogroup radiosToEdit;

	private int cantidadRegistros;

	private String strReferencia;

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
	}

	@Command
	@NotifyChange({ "operacionesDuplicadas", "cantidadRegistros" })
	public void cancelarOperacionDucplicada() {
		this.cdRepteMt101.clearErrorMessage();
		this.referencia.clearErrorMessage();
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
								logger.debug("Enviando a cancelar operación");
								// CD_ST_ENVIO_MT101 = 14
								tgm139Mt101Repte
										.setCdStEnvioMt101(new BigDecimal(14));
								tgm139Mt101Repte
										.setCdRepteMt101(new BigDecimal(
												cdRepteMt101.getValue()
														.intValue()));
								tgm139Mt101Repte.setNbStOpeCw("");
								tgm139Mt101Repte.setNbDescStCw("");
								operacionesBean
										.actualizaEstatusOperacionReprocesar(tgm139Mt101Repte);
								Messagebox.show(
										"Registro actualizado con exito.",
										"Confirmación", Messagebox.OK,
										Messagebox.INFORMATION);
								limpiarDatos();
								BindUtils.postGlobalCommand(null, null,
										"resetGridOperacionesDuplicadas", null);
								registraEvento("canceló la operación "
										+ strReferencia, 400);
							}
						}
					});
		} else {
			Messagebox.show("Favor de seleccionar la operación a reprocesar",
					"Error", Messagebox.OK, Messagebox.ERROR);
		}
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

	public String getIntReferencia() {
		return intReferencia;
	}

	@Command
	@NotifyChange({ "intReferencia", "intCdRepteMt101", "strReferencia" })
	public void getOperacionDuplicada(
			@BindingParam("referenciaOperacion") final Tgm139Mt101Repte tgm139Mt101Repte) {
		logger.debug(tgm139Mt101Repte.getCdRepteMt101());
		this.intCdRepteMt101 = tgm139Mt101Repte.getCdRepteMt101().intValue();
		logger.debug(tgm139Mt101Repte.getNbCampo20());
		this.strReferencia = tgm139Mt101Repte.getNbCampo20();
		this.intReferencia = new BigDecimal(tgm139Mt101Repte.getNbCampo20())
				.toString();
	}

	public IOperaciones getOperacionesBean() {
		return operacionesBean;
	}

	public List<Tgm139Mt101Repte> getOperacionesDuplicadas() {
		return operacionesDuplicadas;
	}

	public IProcesoLog getProcesoLogBean() {
		return procesoLogBean;
	}

	public String getStrReferencia() {
		return strReferencia;
	}

	@Listen("onClick = #limpiarDatosBtn")
	public void limpiarDatos() {
		this.cdRepteMt101.clearErrorMessage();
		this.referencia.clearErrorMessage();
		this.cdRepteMt101.setValue(null);
		this.referencia.setValue(null);
		this.radiosToEdit.setSelectedItem(null);
	}

	@Command
	@NotifyChange({ "operacionesDuplicadas", "cantidadRegistros" })
	public List<Tgm139Mt101Repte> obtenOperacionesPorCriterio() {

		operacionesBean = new OperacionesBean();

		Tgm139Mt101Repte tgm139Mt101Repte = new Tgm139Mt101Repte();
		tgm139Mt101Repte.setCdStEnvioMt101(new BigDecimal(13));
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
	@NotifyChange({ "operacionesDuplicadas" })
	public void reprocesarOperacion() {
		this.cdRepteMt101.clearErrorMessage();
		this.referencia.clearErrorMessage();
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
								BindUtils.postGlobalCommand(null, null,
										"resetGridOperacionesDuplicadas", null);
								Messagebox.show(
										"Registro actualizado con exito.",
										"Confirmación", Messagebox.OK,
										Messagebox.INFORMATION);
								limpiarDatos();
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

	@GlobalCommand("resetGridOperacionesDuplicadas")
	@NotifyChange({ "operacionesDuplicadas", "cantidadRegistros" })
	public void resetGrid() {
		operacionesDuplicadas = obtenOperacionesPorCriterio();
		operacionesDuplicadasGrid.invalidate();
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

	public void setIntReferencia(String intReferencia) {
		this.intReferencia = intReferencia;
	}

	public void setOperacionesBean(IOperaciones operacionesBean) {
		this.operacionesBean = operacionesBean;
	}

	public void setProcesoLogBean(IProcesoLog procesoLogBean) {
		this.procesoLogBean = procesoLogBean;
	}

	public void setStrReferencia(String strReferencia) {
		this.strReferencia = strReferencia;
	}

}
