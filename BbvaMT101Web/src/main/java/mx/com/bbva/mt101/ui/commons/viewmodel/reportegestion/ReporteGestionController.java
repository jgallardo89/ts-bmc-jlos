package mx.com.bbva.mt101.ui.commons.viewmodel.reportegestion;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import mx.com.bbva.mt101.operaciones.logicanegocio.OperacionesBean;
import mx.com.bbva.mt101.operaciones.negocio.IOperaciones;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;

public class ReporteGestionController extends SelectorComposer<Component>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IOperaciones operacionesBean;

	/**
	 * @return the operacionesBean
	 */
	public IOperaciones getOperacionesBean() {
		return operacionesBean;
	}

	/**
	 * @param operacionesBean the operacionesBean to set
	 */
	public void setOperacionesBean(IOperaciones operacionesBean) {
		this.operacionesBean = operacionesBean;
	}
	
	private List<Mes> meses = this.getListaMeses();	
	private List<String> anios = this.getListaAnios();	
	
	/**
	 * @return the anios
	 */
	public List<String> getAnios() {
		return anios;
	}

	/**
	 * @param anios the anios to set
	 */
	public void setAnios(List<String> anios) {
		this.anios = anios;
	}

	/**
	 * @return the meses
	 */
	public List<Mes> getMeses() {
		return meses;
	}

	/**
	 * @param meses the meses to set
	 */
	public void setMeses(List<Mes> meses) {
		this.meses = meses;
	}

	public List<Mes> getListaMeses(){
		List<Mes> meses = null;
		operacionesBean = new OperacionesBean();
		List<String> stringMeses = operacionesBean.getMeses();
		meses = obtenListaMeses(stringMeses);
		return meses;
	}
	
	public List<String> getListaAnios(){		
		operacionesBean = new OperacionesBean();				
		return operacionesBean.getAnios();
	}
	
	public List<Mes> obtenListaMeses(List<String> stringMeses) {
		List<Mes> meses = new ArrayList<Mes>();
		Mes mes; 
		for (String stringMes : stringMeses) {
			int intMes = Integer.parseInt(stringMes);
			switch (intMes) {
			case 1: 
				mes = new Mes();
				mes.setNombreMes("Enero");
				mes.setIdMes(intMes);
				meses.add(mes);
				break;
			case 2:
				mes = new Mes();
				mes.setNombreMes("Febrero");
				mes.setIdMes(intMes);
				meses.add(mes);
				break;
			case 3:
				mes = new Mes();
				mes.setNombreMes("Marzo");
				mes.setIdMes(intMes);
				meses.add(mes);
				break;
			case 4:
				mes = new Mes();
				mes.setNombreMes("Abril");
				mes.setIdMes(intMes);
				meses.add(mes);
				break;
			case 5:
				mes = new Mes();
				mes.setNombreMes("Mayo");
				mes.setIdMes(intMes);
				meses.add(mes);
				break;
			case 6:
				mes = new Mes();
				mes.setNombreMes("Junio");
				mes.setIdMes(intMes);
				meses.add(mes);
				break;
			case 7:
				mes = new Mes();
				mes.setNombreMes("Julio");
				mes.setIdMes(intMes);
				meses.add(mes);
				break;
			case 8:
				mes = new Mes();
				mes.setNombreMes("Agosto");
				mes.setIdMes(intMes);
				meses.add(mes);
				break;
			case 9:
				mes = new Mes();
				mes.setNombreMes("Septiembre");
				mes.setIdMes(intMes);
				meses.add(mes);
				break;
			case 10:
				mes = new Mes();
				mes.setNombreMes("Octubre");
				mes.setIdMes(intMes);
				meses.add(mes);
				break;
			case 11:
				mes = new Mes();
				mes.setNombreMes("Noviembre");
				mes.setIdMes(intMes);
				meses.add(mes);
				break;
			case 12:
				mes = new Mes();
				mes.setNombreMes("Diciembre");
				mes.setIdMes(intMes);
				meses.add(mes);
				break;
			default:
				throw new java.lang.IllegalArgumentException(
						"El mes debe estar entre 1 y 12");
			}
		}
		return meses;
	}
	
	
}
