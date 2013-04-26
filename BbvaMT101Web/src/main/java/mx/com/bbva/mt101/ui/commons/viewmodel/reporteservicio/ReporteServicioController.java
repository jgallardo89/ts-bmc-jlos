package mx.com.bbva.mt101.ui.commons.viewmodel.reporteservicio;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.EJB;

import mx.com.bbva.mt101.catalogos.operacion.logicanegocio.CatalogoOperacionBean;
import mx.com.bbva.mt101.catalogos.operacion.negocio.ICatalogoOperacion;
import mx.com.bbva.mt101.clientes.negocio.IClientes;
import mx.com.bbva.mt101.commons.constantes.IConstantesCatalogos;
import mx.com.bbva.mt101.entities.Tgm053TipoOpMx;
import mx.com.bbva.mt101.entities.Tgm138Mt101ctrato;
import mx.com.bbva.mt101.entities.Tgm139Mt101Repte;
import mx.com.bbva.mt101.operaciones.logicanegocio.OperacionesBean;
import mx.com.bbva.mt101.operaciones.negocio.IOperaciones;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

public class ReporteServicioController extends SelectorComposer<Component> {

	/**
	 * 
	 */
	@EJB
	private IClientes clientesBean;

	@EJB
	private ICatalogoOperacion catalogoOperacionBean;

	@EJB
	private IOperaciones operacionesBean;

	private static final long serialVersionUID = 1L;	

	private static final Logger logger = Logger
			.getLogger(ReporteServicioController.class);
	
	public static int diasDelMes(int mes, int anio) {
		switch (mes) {
		case 0: // Enero
			return 31;
		case 2: // Marzo
			return 31;
		case 4: // Mayo
			return 31;
		case 6: // Julio
			return 31;
		case 7: // Agosto
			return 31;
		case 9: // Octubre
			return 31;
		case 11: // Diciembre
			return 31;
		case 3: // Abril
			return 30;
		case 5: // Junio
			return 30;
		case 8: // Septiembre
			return 30;
		case 10: // Noviembre
			return 30;
		case 1: // Febrero
			if (((anio % 100 == 0) && (anio % 400 == 0))
					|| ((anio % 100 != 0) && (anio % 4 == 0)))
				return 29; // Año Bisiesto
			else
				return 28;
		default:
			throw new java.lang.IllegalArgumentException(
					"El mes debe estar entre 0 y 11");
		}
	}
	
	private float subTotal;
	
	private float total;

	private int cantidadOperaciones;

	private List<Tgm139Mt101Repte> operaciones = this.getReporteServicio();	
	
	@Wire
	private Label numeroCuentaLbl;

	private String periodo;
	private String cuentaMoneda;
	private String mensualidad;
	private boolean clienteAAA;
	private String anualidad;
	private boolean anualidadMenorAnio;
	private String leyendaMenorAnio;
	private String msjRecibidos;

	private float floatMensualidad;

	private float floatAnualidad;

	public String getAnualidad() {
		return anualidad;
	}

	private float getAnualidadCliente(Tgm138Mt101ctrato tgm138Mt101ctrato) {
		this.catalogoOperacionBean = new CatalogoOperacionBean();
		Tgm053TipoOpMx tgm053TipoOpMx = new Tgm053TipoOpMx();
		tgm053TipoOpMx.setCdTpOperacion(13);
		BigDecimal costoAnualidad = new BigDecimal(0);
		if (tgm138Mt101ctrato.getCdMoneda() == IConstantesCatalogos.CATALOGO_MONEDA_EUR)
			costoAnualidad = this.catalogoOperacionBean
					.getOperacionPorCriterio(tgm053TipoOpMx).getImComisionEur();
		else if (tgm138Mt101ctrato.getCdMoneda() == IConstantesCatalogos.CATALOGO_MONEDA_USD)
			costoAnualidad = this.catalogoOperacionBean
					.getOperacionPorCriterio(tgm053TipoOpMx).getImComisionUsd();
		else if (tgm138Mt101ctrato.getCdMoneda() == IConstantesCatalogos.CATALOGO_MONEDA_MXN)
			costoAnualidad = this.catalogoOperacionBean
					.getOperacionPorCriterio(tgm053TipoOpMx).getImComisionMxn();
		logger.debug(costoAnualidad);
		return tgm138Mt101ctrato.getCdAnualidad().endsWith("1")?costoAnualidad.floatValue():0;
	}

	public int getCantidadOperaciones() {
		return cantidadOperaciones;
	}

	public ICatalogoOperacion getCatalogoOperacionBean() {
		return catalogoOperacionBean;
	}

	public boolean getClienteAAA() {
		return clienteAAA;
	}

	public IClientes getClientesBean() {
		return clientesBean;
	}

	public String getCuentaMoneda() {
		return cuentaMoneda;
	}

	public String getLeyendaMenorAnio() {
		return leyendaMenorAnio;
	}

	public String getMensualidad() {
		return mensualidad;
	}

	private float getMensualidad(Date fhCurrent,
			Tgm138Mt101ctrato tgm138Mt101ctrato) {
		this.catalogoOperacionBean = new CatalogoOperacionBean();
		Tgm053TipoOpMx tgm053TipoOpMx = new Tgm053TipoOpMx();
		tgm053TipoOpMx.setCdTpOperacion(12);
		BigDecimal costoMensualidad = new BigDecimal(0);
		if (tgm138Mt101ctrato.getCdMoneda() == IConstantesCatalogos.CATALOGO_MONEDA_EUR)
			costoMensualidad = this.catalogoOperacionBean
					.getOperacionPorCriterio(tgm053TipoOpMx).getImComisionEur();
		else if (tgm138Mt101ctrato.getCdMoneda() == IConstantesCatalogos.CATALOGO_MONEDA_USD)
			costoMensualidad = this.catalogoOperacionBean
					.getOperacionPorCriterio(tgm053TipoOpMx).getImComisionUsd();
		else if (tgm138Mt101ctrato.getCdMoneda() == IConstantesCatalogos.CATALOGO_MONEDA_MXN)
			costoMensualidad = this.catalogoOperacionBean
					.getOperacionPorCriterio(tgm053TipoOpMx).getImComisionMxn();
		logger.debug(costoMensualidad);
		Calendar calendar = null;
		calendar = new GregorianCalendar();
		calendar.setTime(fhCurrent);
		int diasMes = diasDelMes(calendar.get(Calendar.MONTH),
				calendar.get(Calendar.YEAR));
		float costoDia = costoMensualidad.floatValue() / diasMes;
		costoMensualidad = new BigDecimal(costoDia
				* calendar.get(Calendar.DATE));
		return tgm138Mt101ctrato.getCdMensualidad().equals("1")?costoMensualidad.floatValue():0;
	}

	public String getMsjRecibidos() {
		return msjRecibidos;
	}

	public ListModel<Tgm139Mt101Repte> getOperaciones() {
		return new ListModelList<Tgm139Mt101Repte>(operaciones);
	}

	public IOperaciones getOperacionesBean() {
		return operacionesBean;
	}

	public String getPeriodo() {
		return periodo;
	}

	private List<Tgm139Mt101Repte> getReporteServicio() {
		if (Executions.getCurrent() != null) {
			logger.debug("arg size:"
					+ Executions.getCurrent().getArg().get("numeroCuenta"));
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

			Tgm138Mt101ctrato tgm138Mt101ctrato = (Tgm138Mt101ctrato) Executions
					.getCurrent().getArg().get("tgm138Mt101ctrato");
			this.cuentaMoneda = "Actividad de la cuenta "
					+ tgm138Mt101ctrato.getCdCuentaCheques() + " ("
					+ tgm138Mt101ctrato.getNbMoneda() + ") en el mes";
			Calendar calendar1DiasMes = new GregorianCalendar();
			Date fechaHoy = new Date();
			DecimalFormat decimalFormat = new DecimalFormat("###.##");
			
			Tgm139Mt101Repte tgm139Mt101Repte = null;
			tgm139Mt101Repte = new Tgm139Mt101Repte();
			if (tgm138Mt101ctrato.getFhBaja() != null) {
				calendar1DiasMes.setTime(tgm138Mt101ctrato.getFhBaja());
				calendar1DiasMes.set(Calendar.DAY_OF_MONTH, 1);
				this.periodo = dateFormat.format(calendar1DiasMes.getTime())
						+ " al "
						+ dateFormat.format(tgm138Mt101ctrato.getFhBaja()
								.getTime());
				this.mensualidad = decimalFormat.format(getMensualidad(
						tgm138Mt101ctrato.getFhBaja(), tgm138Mt101ctrato));
				tgm139Mt101Repte.setFhProcesoInicio(calendar1DiasMes.getTime());
				tgm139Mt101Repte.setFhProcesoFin(tgm138Mt101ctrato.getFhBaja());
			} else {
				calendar1DiasMes.setTime(fechaHoy);
				calendar1DiasMes.set(Calendar.DAY_OF_MONTH, 1);
				this.periodo = dateFormat.format(calendar1DiasMes.getTime())
						+ " al " + dateFormat.format(new Date().getTime());
				this.mensualidad = decimalFormat.format(getMensualidad(
						fechaHoy, tgm138Mt101ctrato));
				tgm139Mt101Repte.setFhProcesoInicio(calendar1DiasMes.getTime());
				tgm139Mt101Repte.setFhProcesoFin(fechaHoy);
			}
			floatMensualidad = Float.parseFloat(this.mensualidad);			
			this.clienteAAA = tgm138Mt101ctrato.getCdTpClienteAaa().equals("1") ? true
					: false;
			if (!this.clienteAAA) {
				Calendar calendarAlta = null;
				calendarAlta = new GregorianCalendar();
				calendarAlta.setTime(tgm138Mt101ctrato.getFhAlta());

				Calendar calendarActual = null;
				calendarActual = new GregorianCalendar();
				calendarActual.setTime(new Date());

				int anioAlta = calendarAlta.get(Calendar.YEAR);
				int anioActual = calendarActual.get(Calendar.YEAR);
				if ((anioActual - anioAlta) >= 1) {
					Calendar calendarUltimaFechaCobro = null;
					calendarUltimaFechaCobro = new GregorianCalendar();
					calendarUltimaFechaCobro.set(anioActual - 1,
							calendarAlta.get(Calendar.MONTH),
							calendarAlta.get(Calendar.DATE));
					Date ultimaFechaCobro = calendarUltimaFechaCobro.getTime();
					long servicioVigente = (new Date().getTime() - ultimaFechaCobro
							.getTime());
					logger.debug(servicioVigente);
					long valorMiliAnio = 1000 * 60 * 60 * 24 * 365;
					BigDecimal bigServicioVigente = new BigDecimal(
							servicioVigente);
					BigDecimal bigValorMiliAnio = new BigDecimal(valorMiliAnio);
					int anioServicio = bigServicioVigente.divide(
							bigValorMiliAnio, 0).intValue();
					if (anioServicio >= 1) {
						logger.debug("hay que cobrar servicio");
						this.anualidad = Float
								.toString(getAnualidadCliente(tgm138Mt101ctrato));
						floatAnualidad = Float.parseFloat(this.anualidad);
					}
				} else {
					this.anualidadMenorAnio = true;
					Calendar calendarCobroFactura = null;
					calendarCobroFactura = new GregorianCalendar();
					calendarCobroFactura.set(
							calendarAlta.get(Calendar.YEAR) + 1,
							calendarAlta.get(Calendar.MONTH),
							calendarAlta.get(Calendar.DATE));
					Date fechaCobroFutura = calendarCobroFactura.getTime();
					this.leyendaMenorAnio = "La anualidad se cobrara hasta el: "
							+ dateFormat.format(fechaCobroFutura);
				}
			}
			operacionesBean = new OperacionesBean();
			List<Long> longs = new ArrayList<Long>();
			longs.add(9l);
			longs.add(11l);
			tgm139Mt101Repte.setCdStEnvioMt101List(longs);
			tgm139Mt101Repte.setNbCampo50h(tgm138Mt101ctrato.getCdCuentaCheques());
			tgm139Mt101Repte.setCdMoneda(tgm138Mt101ctrato.getCdMoneda());
			operaciones = operacionesBean
					.getOperacionesPorCriterio(tgm139Mt101Repte);
			msjRecibidos = Integer.toString(operaciones.size());
			
			cantidadOperaciones = Integer.parseInt(msjRecibidos);
			
			operaciones = operacionesBean
					.getTotalesOperacionesPorCriterios(tgm139Mt101Repte);
			floatMensualidad = this.clienteAAA==true?0.0f:floatMensualidad;
			if(operaciones.size()>0){
				switch (tgm139Mt101Repte.getCdMoneda()) {
				case IConstantesCatalogos.CATALOGO_MONEDA_USD:
					subTotal = operaciones.get(0).getSubTotalUsd();					
					total = subTotal + floatAnualidad + floatMensualidad;
					break;
				case IConstantesCatalogos.CATALOGO_MONEDA_MXN:
					subTotal = operaciones.get(0).getSubTotalMxn();
					total = subTotal + floatAnualidad + floatMensualidad;
					break;
				case IConstantesCatalogos.CATALOGO_MONEDA_EUR:
					subTotal = operaciones.get(0).getSubTotalEur();
					total = subTotal + floatAnualidad + floatMensualidad;
					break;
				default:
					break;
				}
			}else{
				switch (tgm139Mt101Repte.getCdMoneda()) {
				case IConstantesCatalogos.CATALOGO_MONEDA_USD:
					subTotal = 0.0f;					
					total = subTotal + floatAnualidad + floatMensualidad;
					break;
				case IConstantesCatalogos.CATALOGO_MONEDA_MXN:
					subTotal = 0.0f;
					total = subTotal + floatAnualidad + floatMensualidad;
					break;
				case IConstantesCatalogos.CATALOGO_MONEDA_EUR:
					subTotal = 0.0f;
					total = subTotal + floatAnualidad + floatMensualidad;
					break;
				default:
					break;
				}
			}
		}
		return operaciones;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public float getTotal() {
		return total;
	}

	public boolean isAnualidadMenorAnio() {
		return anualidadMenorAnio;
	}

	public void setAnualidad(String anualidad) {
		this.anualidad = anualidad;
	}

	public void setAnualidadMenorAnio(boolean anualidadMenorAnio) {
		this.anualidadMenorAnio = anualidadMenorAnio;
	}

	public void setCantidadOperaciones(int cantidadOperaciones) {
		this.cantidadOperaciones = cantidadOperaciones;
	}

	public void setCatalogoOperacionBean(
			CatalogoOperacionBean catalogoOperacionBean) {
		this.catalogoOperacionBean = catalogoOperacionBean;
	}

	public void setCatalogoOperacionBean(
			ICatalogoOperacion catalogoOperacionBean) {
		this.catalogoOperacionBean = catalogoOperacionBean;
	}

	public void setClienteAAA(boolean clienteAAA) {
		this.clienteAAA = clienteAAA;
	}

	public void setClientesBean(IClientes clientesBean) {
		this.clientesBean = clientesBean;
	}

	public void setCuentaMoneda(String cuentaMoneda) {
		this.cuentaMoneda = cuentaMoneda;
	}

	public void setLeyendaMenorAnio(String leyendaMenorAnio) {
		this.leyendaMenorAnio = leyendaMenorAnio;
	}

	public void setMensualidad(String mensualidad) {
		this.mensualidad = mensualidad;
	}

	public void setMsjRecibidos(String msjRecibidos) {
		this.msjRecibidos = msjRecibidos;
	}

	public void setOperaciones(List<Tgm139Mt101Repte> operaciones) {
		this.operaciones = operaciones;
	}

	public void setOperacionesBean(IOperaciones operacionesBean) {
		this.operacionesBean = operacionesBean;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
	@Wire
    Window reporteServicioWindow;
	
	@Listen("onClick = #closeBtn")
    public void showModal(Event e) {
		logger.debug("cerrando ventana");
		reporteServicioWindow.detach();
    }
}
