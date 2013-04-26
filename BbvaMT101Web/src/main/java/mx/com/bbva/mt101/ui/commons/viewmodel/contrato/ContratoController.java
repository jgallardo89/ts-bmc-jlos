package mx.com.bbva.mt101.ui.commons.viewmodel.contrato;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;

import mx.com.bbva.mt101.audit.logicanegocio.EventoWebBean;
import mx.com.bbva.mt101.audit.negocio.IEventoWeb;
import mx.com.bbva.mt101.clientes.logicanegocio.ClientesBean;
import mx.com.bbva.mt101.clientes.negocio.IClientes;
import mx.com.bbva.mt101.entities.Tgm023Usuario;
import mx.com.bbva.mt101.entities.Tgm107EventoWeb;
import mx.com.bbva.mt101.entities.Tgm138Mt101ctrato;
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
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class ContratoController extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger
			.getLogger(ContratoController.class);

	@EJB
	IClientes clientesBean;

	@EJB
	IOperaciones operacionesBean;
	
	@EJB
	private IEventoWeb eventoWebBean;

	Tgm138Mt101ctrato tgm138Mt101ctrato;

	@Wire
	private Button generaReporteServicoBtn;

	@Wire
	private Textbox cuentaCheques;

	private String strCuentaCheques;

	private boolean ctaCheqReadOnly;

	@Wire
	private Grid clientesGrid;

	@Wire
	private Textbox nombreCliente;

	@Wire
	private Textbox codigoBicRecepcion;

	@Wire
	private Textbox codigoBicEnvio;

	@Wire
	private Textbox cdContratoSicoco;

	@Wire
	private Radiogroup iva;

	@Wire
	private Comboitem once;

	@Wire
	private Comboitem dieciseis;

	@Wire
	private Intbox moneda;

	@Wire
	private Checkbox clienteAAA;

	@Wire
	private Checkbox cuentaActiva;

	@Wire
	private Checkbox mensualidad;

	@Wire
	private Checkbox anualidad;

	@Wire
	private Combobox monedaCbx;

	@Wire
	private Datebox fechaAlta;

	@Wire
	private Textbox errorIva;

	@Wire
	private Button editarClienteBtn;
	
	@Wire
	private Button generaSicocoBtn;

	@Wire
	private Label fechaBajaLbl;

	@Wire
	private Datebox fechaBaja;

	@Wire
	private Textbox cdContrato;

	private String strCdContrato;

	private String filtroCuentaCheques;

	private String filtroNombreCliente;

	private String filtroCodigoBicRecepcion;

	private String filtroCodigoBicEnvio;

	private String filtroContrato;

	private String filtroMonedaCbx;

	private String filtroIvaCbx;

	private String filtroClienteAAA;

	private List<Tgm138Mt101ctrato> clientes = this.getAllClientes();

	private String strNombreCliente;

	private String strCodigoBicRecepcion;

	private String strCodigoBicEnvio;

	private String strCdContratoSicoco;

	private boolean boolOnce;

	private boolean boolDieciseis;

	private String strMonedaCbxId;

	private String strMonedaCbxValue;

	private boolean boolClienteAAA;

	private boolean boolCuentaActiva = false;
	
	private boolean boolGeneraSicoco = false;

	private boolean boolMensualidad;

	private boolean boolAnualidad;

	private Date dateFechaAlta;

	private Date dateFechaBaja;

	private boolean lblFechaBaja;

	private boolean dateBoxFecha;
	
	private int cantidadRegistros;

	/**
	 * 
	 */
	public ContratoController() {

	}

	@Command
	@NotifyChange({ "clientes" })
	public void eliminarCliente() {
		if (!this.strCdContrato.isEmpty()) {
			Messagebox.show("¿Esta seguro que desea dar de baja el cliente?",
					"Pregunta", Messagebox.YES | Messagebox.NO,
					Messagebox.QUESTION, new EventListener<Event>() {
						@Override
						public void onEvent(Event event) throws Exception {
							if (event.getName().equals(Messagebox.ON_YES)) {
								logger.debug("Dando de baja cliente");
								tgm138Mt101ctrato = new Tgm138Mt101ctrato();
								tgm138Mt101ctrato.setCdContrato(new Long(
										strCdContrato));
								tgm138Mt101ctrato.setCdCuentaCheques(cuentaCheques.getValue());
								Tgm139Mt101Repte tgm139Mt101Repte = new Tgm139Mt101Repte();
								tgm139Mt101Repte.setCdCuentaCheques(new Long(
										strCuentaCheques));
								if (validaOperacionesFuturo(tgm139Mt101Repte)) {
									clientesBean
											.eliminaClienteActivo(tgm138Mt101ctrato);
									registraEvento("eliminó la cuenta " + tgm138Mt101ctrato.getCdCuentaCheques());
									Messagebox.show(
											"¡El registro se ha eliminado!",
											"Información", Messagebox.OK,
											Messagebox.INFORMATION);
									fechaBajaLbl.setVisible(true);
									fechaBaja.setValue(new Date());
									fechaBaja.setVisible(true);																		
									cuentaActiva.setChecked(false);
									generaSicocoBtn.setVisible(true);	
									BindUtils.postGlobalCommand(null, null, "resetGridClientes", null);
								} else {
									Messagebox
											.show("¡No se dio de baja la cuenta, debido a que tiene operaciones con fecha valor a futuro!",
													"Error", Messagebox.OK,
													Messagebox.ERROR);
								}
							} else if (event.getName().equals(Messagebox.ON_NO)) {
								logger.debug("No haciendo nada:");
							}							
						}

						private boolean validaOperacionesFuturo(
								Tgm139Mt101Repte tgm139Mt101Repte) {
							operacionesBean = new OperacionesBean();
							List<Tgm139Mt101Repte> tgm139Mt101Reptes = operacionesBean.getOperacionesFuturas(tgm139Mt101Repte);
							if(tgm139Mt101Reptes != null && tgm139Mt101Reptes.size()>0){
								return false;
							}else{
								return true;
							}
						}
					});
		} else {
			Messagebox.show(
					"¡Primero debe de seleccionar el cliente a eliminar!",
					"Error", Messagebox.OK, Messagebox.ERROR);
		}			
	}

	@Command
	@NotifyChange({ "clientes" })
	public void establecerFiltroClientes() {
		logger.debug("Entrando");
		logger.debug(this.filtroCuentaCheques != null ? this.filtroCuentaCheques
				: "");
		logger.debug(this.filtroNombreCliente != null ? this.filtroNombreCliente
				: "");
		logger.debug(this.filtroCodigoBicRecepcion != null ? this.filtroCodigoBicRecepcion
				: "");
		logger.debug(this.filtroCodigoBicEnvio != null ? this.filtroCodigoBicEnvio
				: "");
		logger.debug(this.filtroContrato != null ? this.filtroContrato : "");
		logger.debug(this.filtroMonedaCbx != null ? this.filtroMonedaCbx : "");
		logger.debug(this.filtroIvaCbx != null ? this.filtroIvaCbx : "");
		logger.debug(this.filtroClienteAAA != null ? (this.filtroClienteAAA
				.equals("Cliente AAA") ? "1" : "0") : "");
		// to delete
		this.clientesBean = new ClientesBean();
		tgm138Mt101ctrato = new Tgm138Mt101ctrato();
		tgm138Mt101ctrato
				.setCdCuentaCheques(this.filtroCuentaCheques != null ? "%"
						+ this.filtroCuentaCheques.toUpperCase().trim() + "%"
						: "%");
		tgm138Mt101ctrato.setNbEmpresa(this.filtroNombreCliente != null ? "%"
				+ this.filtroNombreCliente.toUpperCase().trim() + "%" : "%");
		tgm138Mt101ctrato
				.setCdCodSwRec(this.filtroCodigoBicRecepcion != null ? "%"
						+ this.filtroCodigoBicRecepcion.toUpperCase().trim()
						+ "%" : "%");
		tgm138Mt101ctrato.setCdCodSwEnv(this.filtroCodigoBicEnvio != null ? "%"
				+ this.filtroCodigoBicEnvio.toUpperCase().trim() + "%" : "%%");
		tgm138Mt101ctrato.setCdContratoStr(this.filtroContrato != null ? "%"
				+ this.filtroContrato.toString().toUpperCase().trim() + "%"
				: "%");
		tgm138Mt101ctrato.setNbMoneda(this.filtroMonedaCbx != null ? "%"
				+ this.filtroMonedaCbx.toUpperCase().trim() + "%" : "%");
		tgm138Mt101ctrato.setNuPorcentaje(this.filtroIvaCbx != null ? "%"
				+ this.filtroIvaCbx.toUpperCase().trim() + "%" : "%");
		tgm138Mt101ctrato
				.setCdTpClienteAaa(this.filtroClienteAAA != null ? (this.filtroClienteAAA
						.equals("Cliente AAA") ? "1" : this.filtroClienteAAA
						.equals("No Cliente AAA") ? "0" : "%") : "%");
		List<Tgm138Mt101ctrato> tgm138Mt101ctratos = this.clientesBean.filtarTgm138Mt101ctrato(tgm138Mt101ctrato);
		cantidadRegistros = tgm138Mt101ctratos.size();		
		this.clientes = tgm138Mt101ctratos;
	}

	public List<Tgm138Mt101ctrato> getAllClientes() {
		this.clientesBean = new ClientesBean();
		tgm138Mt101ctrato = new Tgm138Mt101ctrato();
		tgm138Mt101ctrato.setCdCuentaCheques("%%");
		tgm138Mt101ctrato.setNbEmpresa("%%");
		tgm138Mt101ctrato.setCdCodSwRec("%%");
		tgm138Mt101ctrato.setCdCodSwEnv("%%");
		tgm138Mt101ctrato.setCdContratoStr("%%");
		tgm138Mt101ctrato.setNbMoneda("%%");
		tgm138Mt101ctrato.setNuPorcentaje("%%");
		tgm138Mt101ctrato.setCdTpClienteAaa("%%");
		List<Tgm138Mt101ctrato> tgm138Mt101ctratos = this.clientesBean.filtarTgm138Mt101ctrato(tgm138Mt101ctrato);
		cantidadRegistros = tgm138Mt101ctratos.size();
		return tgm138Mt101ctratos;
	}

	public ListModel<Tgm138Mt101ctrato> getClientes() {
		return new ListModelList<Tgm138Mt101ctrato>(this.clientes);
	}

	public IClientes getClientesBean() {
		return clientesBean;
	}

	@Command
	@NotifyChange({ "strCuentaCheques", "ctaCheqReadOnly", "strNombreCliente",
			"strCodigoBicRecepcion", "strCodigoBicEnvio",
			"strCdContratoSicoco", "boolOnce", "boolDieciseis",
			"strMonedaCbxId", "strMonedaCbxValue", "boolClienteAAA",
			"boolCuentaActiva", "boolMensualidad", "boolAnualidad",
			"dateFechaAlta", "dateFechaBaja", "lblFechaBaja", "dateBoxFecha",
			"boolGeneraReporteServicoBtn", "clientes", "strCdContrato", "boolGeneraSicoco" })
	public void getContrato(
			@BindingParam("idCliente") final Tgm138Mt101ctrato tgm138Mt101ctrato) {
		this.strCuentaCheques = tgm138Mt101ctrato.getCdCuentaCheques();
		this.ctaCheqReadOnly = true;
		this.strNombreCliente = tgm138Mt101ctrato.getNbEmpresa();
		this.strCodigoBicRecepcion = tgm138Mt101ctrato.getCdCodSwRec();
		this.strCodigoBicEnvio = tgm138Mt101ctrato.getCdCodSwEnv();
		this.strCdContratoSicoco = tgm138Mt101ctrato.getCdContratoSicoco();
		this.strCdContrato = Long.toString(tgm138Mt101ctrato.getCdContrato());
		if (tgm138Mt101ctrato.getCdIva() == 1) {
			this.boolOnce = true;
		} else {
			this.boolOnce = false;
		}
		if (tgm138Mt101ctrato.getCdIva() == 2) {
			this.boolDieciseis = true;
		} else {
			this.boolDieciseis = false;
		}
		this.strMonedaCbxId = new Integer(tgm138Mt101ctrato.getCdMoneda())
				.toString();
		this.strMonedaCbxValue = tgm138Mt101ctrato.getNbMoneda();
		this.boolClienteAAA = tgm138Mt101ctrato.getCdTpClienteAaa().equals("1") ? true
				: false;
		this.boolCuentaActiva = tgm138Mt101ctrato.getFhBaja() == null ? true
				: false;
		this.boolMensualidad = tgm138Mt101ctrato.getCdMensualidad().equals("1") ? true
				: false;
		this.boolAnualidad = tgm138Mt101ctrato.getCdAnualidad().equals("1") ? true
				: false;
		this.dateFechaAlta = new Date(tgm138Mt101ctrato.getFhAlta().getTime());

		logger.debug("Fecha e baja:" + tgm138Mt101ctrato.getFhBaja());

		if (tgm138Mt101ctrato.getFhBaja() != null) {
			this.dateFechaBaja = new Date(tgm138Mt101ctrato.getFhBaja()
					.getTime());
			dateFechaBaja = tgm138Mt101ctrato.getFhBaja();
			lblFechaBaja = true;
			dateBoxFecha = true;
			Messagebox
					.show("El cliente consultado esta dado de baja. ¿Deseas activarlo?",
							"Pregunta", Messagebox.YES | Messagebox.NO,
							Messagebox.QUESTION, new EventListener<Event>() {
								@Override
								public void onEvent(Event event)
										throws Exception {
									if (event.getName().equals(
											Messagebox.ON_YES)) {
										logger.debug("Activando cliente");											
										boolGeneraSicoco = true;
										tgm138Mt101ctrato.setFhBaja(null);
										clientesBean
												.actualizarClienteInactivo(tgm138Mt101ctrato);
										registraEvento("editó la cuenta " + tgm138Mt101ctrato.getCdCuentaCheques());
										dateFechaBaja = null;
										fechaBajaLbl.setVisible(false);
										fechaBaja.setVisible(false);										
										cuentaActiva.setChecked(true);
										generaSicocoBtn.setVisible(false);
										BindUtils.postGlobalCommand(null, null, "resetGridClientes", null);
									} else if (event.getName().equals(
											Messagebox.ON_NO)) {
										logger.debug("No haciendo nada:"
												+ tgm138Mt101ctrato.getFhBaja());
										generaSicocoBtn.setVisible(true);
									}
								}
							});
		}				
	}
	@GlobalCommand("resetGridClientes")
	@NotifyChange({"clientes","cantidadRegistros"})
	public void resetGrid() {
		clientes = getAllClientes();
		clientesGrid.invalidate();
	}
	public Date getDateFechaAlta() {
		return dateFechaAlta;
	}

	public Date getDateFechaBaja() {
		return dateFechaBaja;
	}

	public String getFiltroClienteAAA() {
		return filtroClienteAAA;
	}

	public String getFiltroCodigoBicEnvio() {
		return filtroCodigoBicEnvio;
	}

	public String getFiltroCodigoBicRecepcion() {
		return filtroCodigoBicRecepcion;
	}

	public String getFiltroContrato() {
		return filtroContrato;
	}

	public String getFiltroCuentaCheques() {
		return filtroCuentaCheques;
	}

	public String getFiltroIvaCbx() {
		return filtroIvaCbx;
	}

	public String getFiltroMonedaCbx() {
		return filtroMonedaCbx;
	}

	public String getFiltroNombreCliente() {
		return filtroNombreCliente;
	}

	public IOperaciones getOperacionesBean() {
		return operacionesBean;
	}

	public String getStrCdContrato() {
		return strCdContrato;
	}

	public String getStrCdContratoSicoco() {
		return strCdContratoSicoco;
	}

	public String getStrCodigoBicEnvio() {
		return strCodigoBicEnvio;
	}

	public String getStrCodigoBicRecepcion() {
		return strCodigoBicRecepcion;
	}

	public String getStrCuentaCheques() {
		return strCuentaCheques;
	}

	public String getStrMonedaCbxId() {
		return strMonedaCbxId;
	}

	public String getStrMonedaCbxValue() {
		return strMonedaCbxValue;
	}

	public String getStrNombreCliente() {
		return strNombreCliente;
	}

	public boolean isBoolAnualidad() {
		return boolAnualidad;
	}

	public boolean isBoolClienteAAA() {
		return boolClienteAAA;
	}

	public boolean isBoolCuentaActiva() {
		return boolCuentaActiva;
	}

	public boolean isBoolDieciseis() {
		return boolDieciseis;
	}

	public boolean isBoolMensualidad() {
		return boolMensualidad;
	}

	public boolean isBoolOnce() {
		return boolOnce;
	}

	public boolean isCtaCheqReadOnly() {
		return ctaCheqReadOnly;
	}

	public boolean isDateBoxFecha() {
		return dateBoxFecha;
	}

	public boolean isLblFechaBaja() {
		return lblFechaBaja;
	}
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
    }

	@Command	
	public void limpiar(Event evt) {			
					cuentaCheques.clearErrorMessage();
					nombreCliente.clearErrorMessage();
					codigoBicEnvio.clearErrorMessage();
					codigoBicRecepcion.clearErrorMessage();
					cdContratoSicoco.clearErrorMessage();
					errorIva.clearErrorMessage();
					moneda.clearErrorMessage();
			
					cdContratoSicoco.setValue(null);
					cdContrato.setValue(null);
					cuentaCheques.setValue(null);
					moneda.setValue(null);
					monedaCbx.setValue(null);
					codigoBicRecepcion.setValue(null);
					codigoBicEnvio.setValue(null);
					nombreCliente.setValue(null);
					clienteAAA.setChecked(false);
					mensualidad.setChecked(false);
					anualidad.setChecked(false);
					cuentaActiva.setChecked(true);
					iva.setSelectedItem(null);
			
					filtroClienteAAA = "";
					filtroCodigoBicEnvio = "";
					filtroCodigoBicRecepcion = "";
					filtroContrato = "";
					filtroCuentaCheques = "";
					filtroIvaCbx = "";
					filtroMonedaCbx = "";
					filtroNombreCliente = "";
			
					cuentaCheques.setReadonly(false);
					fechaBaja.setVisible(false);
					fechaBajaLbl.setVisible(false);		
					generaSicocoBtn.setVisible(false);
	}

	public void setBoolAnualidad(boolean boolAnualidad) {
		this.boolAnualidad = boolAnualidad;
	}

	public void setBoolClienteAAA(boolean boolClienteAAA) {
		this.boolClienteAAA = boolClienteAAA;
	}

	public void setBoolCuentaActiva(boolean boolCuentaActiva) {
		this.boolCuentaActiva = boolCuentaActiva;
	}

	public void setBoolDieciseis(boolean boolDieciseis) {
		this.boolDieciseis = boolDieciseis;
	}

	public void setBoolMensualidad(boolean boolMensualidad) {
		this.boolMensualidad = boolMensualidad;
	}

	public void setBoolOnce(boolean boolOnce) {
		this.boolOnce = boolOnce;
	}

	@Command
	@NotifyChange({"clientes"})
	public void setCliente(Event evt) {		 
				 clientesBean = new ClientesBean();
		
					cuentaCheques.clearErrorMessage();
					nombreCliente.clearErrorMessage();
					codigoBicEnvio.clearErrorMessage();
					codigoBicRecepcion.clearErrorMessage();
					cdContratoSicoco.clearErrorMessage();
					errorIva.clearErrorMessage();
					moneda.clearErrorMessage();
			
					logger.debug("Entrando");
					logger.debug(cuentaCheques.getValue());
					logger.debug(nombreCliente.getValue());
					logger.debug(codigoBicRecepcion.getValue());
					logger.debug(codigoBicEnvio.getValue());
					logger.debug(iva.getSelectedItem() != null ? iva.getSelectedItem()
							.getValue() : "");
					logger.debug(moneda.getValue());
					logger.debug(clienteAAA.isChecked());
					logger.debug(cuentaActiva.isChecked());
					logger.debug(mensualidad.isChecked());
					logger.debug(anualidad.isChecked());
					logger.debug(fechaAlta.getValue());
					logger.debug(cdContratoSicoco.getValue());
			
					boolean errorGuardar = false;
					if (cuentaCheques.getValue().isEmpty()) {
						cuentaCheques
								.setErrorMessage("Favor de introducir el Número de Cuenta de Cheques");
						errorGuardar = true;
					} else if (cuentaCheques.getValue().length() < 10) {
						cuentaCheques
								.setErrorMessage("El Número de Cuenta de Cheques dede ser de 10 digitos");
						errorGuardar = true;
					} else if (!cuentaCheques.getValue().matches(".[0-9]+")) {
						cuentaCheques
								.setErrorMessage("El Número de Cuenta de Cheques solo debe contener números");
						errorGuardar = true;
					}
			
					if (codigoBicRecepcion.getValue().isEmpty()) {
						codigoBicRecepcion
								.setErrorMessage("Favor de introducir el Código BIC de Recepción");
						errorGuardar = true;
					} else if (codigoBicRecepcion.getValue().length() < 11) {
						codigoBicRecepcion
								.setErrorMessage("El Código BIC de Recepción dede ser de 11 digitos");
						errorGuardar = true;
					} else if (!codigoBicRecepcion.getValue().matches(".[a-zA-Z0-9]+")) {
						codigoBicRecepcion
								.setErrorMessage("El Código BIC de Recepción solo debe contener números o letras");
						errorGuardar = true;
					}
			
					if (!codigoBicEnvio.getValue().isEmpty()) {
						if (codigoBicEnvio.getValue().length() < 11) {
							codigoBicEnvio
									.setErrorMessage("El Código BIC de Envío dede ser de 11 digitos");
							errorGuardar = true;
						} else if (!codigoBicEnvio.getValue().matches(".[a-zA-Z0-9]+")) {
							codigoBicEnvio
									.setErrorMessage("El Código BIC de Envío solo debe contener números o letras");
							errorGuardar = true;
						}
					}
			
					if (cdContratoSicoco.getValue().isEmpty()) {
						cdContratoSicoco
								.setErrorMessage("Favor de introducir el Número de Contrato");
						errorGuardar = true;
					} else if (cdContratoSicoco.getValue().length() < 12) {
						cdContratoSicoco
								.setErrorMessage("El Número de Contado dede ser de 12 digitos");
						errorGuardar = true;
					} else if (!cdContratoSicoco.getValue().matches(".[0-9]+")) {
						cdContratoSicoco
								.setErrorMessage("El Número de Contrato solo debe contener números");
						errorGuardar = true;
					}
			
					if (iva.getSelectedItem() == null
							|| iva.getSelectedItem().getValue() == null
							|| iva.getSelectedItem().getValue().toString().isEmpty()) {
						errorIva.setErrorMessage("No se ha seleccionado el valor del IVA.");
						errorGuardar = true;
					}
			
					if (nombreCliente.getValue().isEmpty()) {
						nombreCliente
								.setErrorMessage("Favor de introducir el nombre del cliente.");
						errorGuardar = true;
					}
			
					if (monedaCbx.getValue() != null && monedaCbx.getValue().isEmpty()) {
						monedaCbx.setErrorMessage("Favor de seleccionar la moneda");
						errorGuardar = true;
					}
			
					if (!cuentaActiva.isChecked()) {
						cuentaActiva.setChecked(true);
					}
			
					if (!errorGuardar) {
						// if(false){
						logger.info("ContratoController: - Metodo: setCliente -- **inicio**");
						tgm138Mt101ctrato = new Tgm138Mt101ctrato();
						tgm138Mt101ctrato.setCdCuentaCheques(cuentaCheques.getValue()
								.toUpperCase().trim());
						tgm138Mt101ctrato.setCdMoneda(new Integer(moneda.getValue()));
						tgm138Mt101ctrato.setCdCodSwRec(codigoBicRecepcion.getValue()
								.toUpperCase().trim());
						tgm138Mt101ctrato.setCdCodSwEnv(codigoBicEnvio.getValue()
								.toUpperCase().trim());
						tgm138Mt101ctrato.setNbEmpresa(nombreCliente.getValue()
								.toUpperCase().trim());
						tgm138Mt101ctrato.setCdTpClienteAaa(((Boolean) clienteAAA
								.isChecked()).toString().trim().equals("true") ? "1" : "0");
						// tgm138Mt101ctrato.setCdContrato(null);
						tgm138Mt101ctrato.setCdContratoSicoco(cdContratoSicoco.getValue()
								.toUpperCase().trim());
						tgm138Mt101ctrato.setCdMensualidad(((Boolean) mensualidad
								.isChecked()).toString().trim().equals("true") ? "1" : "0");
						tgm138Mt101ctrato.setCdAnualidad(((Boolean) anualidad.isChecked())
								.toString().trim().equals("true") ? "1" : "0");
						tgm138Mt101ctrato.setCdIva(new Integer((String) iva
								.getSelectedItem().getValue()));
						Timestamp timestampFechaAlta = new Timestamp(fechaAlta.getValue()
								.getTime());
						tgm138Mt101ctrato.setFhAlta(timestampFechaAlta);
						// ((Boolean)this.cuentaActiva.isChecked()).toString().trim()
						if (cuentaCheques.isReadonly()) {
							if (clientesBean.existeCodigoBicRecepcion(tgm138Mt101ctrato) == null) {
								codigoBicRecepcion
										.setErrorMessage("No existe el código BIC de recepción capturado.");
								errorGuardar = true;
							}
							if (!tgm138Mt101ctrato.getCdCodSwEnv().isEmpty()) {
								if (clientesBean.existeCodigoBicEnvio(tgm138Mt101ctrato) == null) {
									codigoBicEnvio
											.setErrorMessage("No existe el código BIC de envío capturado.");
									errorGuardar = true;
								}
							}
							if (!errorGuardar) {
								logger.debug("Actualizando cliente");
								clientesBean.actualizarCliente(tgm138Mt101ctrato);
								registraEvento("editó la cuenta " + tgm138Mt101ctrato.getCdCuentaCheques());
								cdContratoSicoco.setValue(null);
								cdContrato.setValue(null);
								cuentaCheques.setValue(null);
								moneda.setValue(null);
								monedaCbx.setValue(null);
								codigoBicRecepcion.setValue(null);
								codigoBicEnvio.setValue(null);
								nombreCliente.setValue(null);
								clienteAAA.setChecked(false);
								mensualidad.setChecked(false);
								anualidad.setChecked(false);
								cuentaActiva.setChecked(false);
								iva.setSelectedItem(null);
								cuentaCheques.setReadonly(false);
								establecerFiltroClientes();
								
								Messagebox.show("Registro actualizado con exito!!",
										"Confirmación", Messagebox.OK,
										Messagebox.INFORMATION);
								this.clientes = this.getAllClientes();
								this.clientesGrid.invalidate();
							}
						} else {
							if (clientesBean.obtieneCuentaCheques(tgm138Mt101ctrato) != null) {
								cuentaCheques
										.setErrorMessage("El número de cuenta ya tiene servicio.");
								errorGuardar = true;
							}
							if (clientesBean.existeCodigoBicRecepcion(tgm138Mt101ctrato) == null) {
								codigoBicRecepcion
										.setErrorMessage("No existe el código BIC de recepción capturado.");
								errorGuardar = true;
							}
							if (!tgm138Mt101ctrato.getCdCodSwEnv().isEmpty()) {
								if (clientesBean.existeCodigoBicEnvio(tgm138Mt101ctrato) == null) {
									codigoBicEnvio
											.setErrorMessage("No existe el código BIC de envío capturado.");
									errorGuardar = true;
								}
							}
							if (!errorGuardar) {
			
								logger.debug("Registrando nuevo cliente");
								clientesBean.salvarCliente(tgm138Mt101ctrato);
								registraEvento("regsitró la cuenta " + tgm138Mt101ctrato.getCdCuentaCheques());
								cdContratoSicoco.setValue(null);
								cdContrato.setValue(null);
								cuentaCheques.setValue(null);
								moneda.setValue(null);
								monedaCbx.setValue(null);
								codigoBicRecepcion.setValue(null);
								codigoBicEnvio.setValue(null);
								nombreCliente.setValue(null);
								clienteAAA.setChecked(false);
								mensualidad.setChecked(false);
								anualidad.setChecked(false);
								cuentaActiva.setChecked(false);
								iva.setSelectedItem(null);
								cuentaCheques.setReadonly(false);
								Messagebox.show("Registro guardado con exito!!",
										"Confirmación", Messagebox.OK,
										Messagebox.INFORMATION);
								this.clientes = this.getAllClientes();
								this.clientesGrid.invalidate();
							}
						}
					}							
	}

	public void setClientes(List<Tgm138Mt101ctrato> clientes) {
		this.clientes = clientes;
	}

	public void setClientesBean(IClientes clientesBean) {
		this.clientesBean = clientesBean;
	}

	public void setCtaCheqReadOnly(boolean ctaCheqReadOnly) {
		this.ctaCheqReadOnly = ctaCheqReadOnly;
	}

	public void setDateBoxFecha(boolean dateBoxFecha) {
		this.dateBoxFecha = dateBoxFecha;
	}

	public void setDateFechaAlta(Date dateFechaAlta) {
		this.dateFechaAlta = dateFechaAlta;
	}

	public void setDateFechaBaja(Date dateFechaBaja) {
		this.dateFechaBaja = dateFechaBaja;
	}

	public void setFiltroClienteAAA(String filtroClienteAAA) {
		this.filtroClienteAAA = filtroClienteAAA;
	}

	public void setFiltroCodigoBicEnvio(String filtroCodigoBicEnvio) {
		this.filtroCodigoBicEnvio = filtroCodigoBicEnvio;
	}

	public void setFiltroCodigoBicRecepcion(String filtroCodigoBicRecepcion) {
		this.filtroCodigoBicRecepcion = filtroCodigoBicRecepcion;
	}

	public void setFiltroContrato(String filtroContrato) {
		this.filtroContrato = filtroContrato;
	}

	public void setFiltroCuentaCheques(String filtroCuentaCheques) {
		this.filtroCuentaCheques = filtroCuentaCheques;
	}

	public void setFiltroIvaCbx(String filtroIvaCbx) {
		this.filtroIvaCbx = filtroIvaCbx;
	}

	public void setFiltroMonedaCbx(String filtroMonedaCbx) {
		this.filtroMonedaCbx = filtroMonedaCbx;
	}

	public void setFiltroNombreCliente(String filtroNombreCliente) {
		this.filtroNombreCliente = filtroNombreCliente;
	}

	public void setLblFechaBaja(boolean lblFechaBaja) {
		this.lblFechaBaja = lblFechaBaja;
	}

	public void setOperacionesBean(IOperaciones operacionesBean) {
		this.operacionesBean = operacionesBean;
	}

	public void setStrCdContrato(String strCdContrato) {
		this.strCdContrato = strCdContrato;
	}

	public void setStrCdContratoSicoco(String strCdContratoSicoco) {
		this.strCdContratoSicoco = strCdContratoSicoco;
	}

	public void setStrCodigoBicEnvio(String strCodigoBicEnvio) {
		this.strCodigoBicEnvio = strCodigoBicEnvio;
	}

	public void setStrCodigoBicRecepcion(String strCodigoBicRecepcion) {
		this.strCodigoBicRecepcion = strCodigoBicRecepcion;
	}

	public void setStrCuentaCheques(String strCuentaCheques) {
		this.strCuentaCheques = strCuentaCheques;
	}

	public void setStrMonedaCbxId(String strMonedaCbxId) {
		this.strMonedaCbxId = strMonedaCbxId;
	}

	public void setStrMonedaCbxValue(String strMonedaCbxValue) {
		this.strMonedaCbxValue = strMonedaCbxValue;
	}

	public void setStrNombreCliente(String strNombreCliente) {
		this.strNombreCliente = strNombreCliente;
	}
	@Command
	@NotifyChange({ "strCuentaCheques", "ctaCheqReadOnly", "strNombreCliente",
			"strCodigoBicRecepcion", "strCodigoBicEnvio",
			"strCdContratoSicoco", "boolOnce", "boolDieciseis",
			"strMonedaCbxId", "strMonedaCbxValue", "boolClienteAAA",
			"boolCuentaActiva", "boolMensualidad", "boolAnualidad",
			"dateFechaAlta", "dateFechaBaja", "lblFechaBaja", "dateBoxFecha",
			"boolGeneraReporteServicoBtn", "clientes", "strCdContrato" })
	public void showModal(Event evt) {		 
					Map<String, Object> mapDatos;
					mapDatos = new HashMap<String, Object>();
					logger.debug("this.strCuentaCheques:" + this.cuentaCheques.getValue());
					if(!this.cuentaCheques.getValue().isEmpty()){
						tgm138Mt101ctrato = new Tgm138Mt101ctrato();
						tgm138Mt101ctrato.setCdCuentaCheques(cuentaCheques.getValue()
								.toUpperCase().trim());
						tgm138Mt101ctrato.setCdMoneda(new Integer(moneda.getValue()));
						tgm138Mt101ctrato.setNbMoneda(monedaCbx.getValue());
						tgm138Mt101ctrato.setCdCodSwRec(codigoBicRecepcion.getValue()
								.toUpperCase().trim());
						tgm138Mt101ctrato.setCdCodSwEnv(codigoBicEnvio.getValue().toUpperCase()
								.trim());
						tgm138Mt101ctrato.setNbEmpresa(nombreCliente.getValue().toUpperCase()
								.trim());
						tgm138Mt101ctrato.setCdTpClienteAaa(((Boolean) clienteAAA.isChecked())
								.toString().trim().equals("true") ? "1" : "0");
						tgm138Mt101ctrato.setCdContratoSicoco(cdContratoSicoco.getValue());
						tgm138Mt101ctrato.setCdContrato(new Long(cdContrato.getValue()
								.toUpperCase().trim()));
						tgm138Mt101ctrato.setCdMensualidad(((Boolean) mensualidad.isChecked())
								.toString().trim().equals("true") ? "1" : "0");
						tgm138Mt101ctrato.setCdAnualidad(((Boolean) anualidad.isChecked())
								.toString().trim().equals("true") ? "1" : "0");
						tgm138Mt101ctrato.setCdIva(new Integer((String) iva.getSelectedItem()
								.getValue()));
						Timestamp timestampFechaAlta = new Timestamp(fechaAlta.getValue()
								.getTime());
						tgm138Mt101ctrato.setFhAlta(timestampFechaAlta);			
						tgm138Mt101ctrato.setFhBaja(fechaBaja.getValue()!=null?
								fechaBaja.getValue():null);
						mapDatos.put("numeroCuenta", this.cuentaCheques.getValue());
						mapDatos.put("tgm138Mt101ctrato", tgm138Mt101ctrato);
						Window window = (Window) Executions.createComponents(
								"/WEB-INF/flows/reporteServicio/reporteServicio.zul",
								this.getSelf(), mapDatos);
						window.doModal();
					}else{
						Messagebox.show(
								"¡Primero debe de seleccionar el cliente a consultar!",
								"Error", Messagebox.OK, Messagebox.ERROR);
					}
			 }

	public boolean isBoolGeneraSicoco() {
		return boolGeneraSicoco;
	}

	public void setBoolGeneraSicoco(boolean boolGeneraSicoco) {
		this.boolGeneraSicoco = boolGeneraSicoco;
	}
	
	protected void registraEvento(String txEventoWeb) {
		Tgm023Usuario tgm023Usuario = null;
		tgm023Usuario = (Tgm023Usuario)this.getPage().getDesktop().getSession().getAttribute("tgm023Usuario");		
				
		this.eventoWebBean = new EventoWebBean();
		Tgm107EventoWeb tgm107EventoWeb = null;
		tgm107EventoWeb = new Tgm107EventoWeb();
		tgm107EventoWeb.setCdUsuario(tgm023Usuario.getCdUsuario().longValue());
		tgm107EventoWeb.setTmEventoWeb(new Date());
		tgm107EventoWeb.setTxEventoWeb("El usuario "+ tgm023Usuario.getCdClaveUsuario() + " " +txEventoWeb);	
		this.eventoWebBean.setEventoWeb(tgm107EventoWeb);
	}

	public IEventoWeb getEventoWebBean() {
		return eventoWebBean;
	}

	public void setEventoWebBean(IEventoWeb eventoWebBean) {
		this.eventoWebBean = eventoWebBean;
	}

	public int getCantidadRegistros() {
		return cantidadRegistros;
	}

	public void setCantidadRegistros(int cantidadRegistros) {
		this.cantidadRegistros = cantidadRegistros;
	}
}
