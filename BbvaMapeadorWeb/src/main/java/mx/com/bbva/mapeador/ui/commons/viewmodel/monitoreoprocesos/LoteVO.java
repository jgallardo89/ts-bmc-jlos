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
 * Nombre de clase: LoteVO.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.monitoreoprocesos
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.monitoreoprocesos;

import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class LoteVO.
 */
public class LoteVO {
	
	/** The etapa v os. */
	private List<EtapaVO> etapaVOs;
	
	/** The fecha lote. */
	private Date fechaLote;
	
	/** The numero lote. */
	private long numeroLote;
	
	/**
	 * Gets the etapa v os.
	 *
	 * @return the etapaVOs
	 */
	public List<EtapaVO> getEtapaVOs() {
		return etapaVOs;
	}
	
	/**
	 * Gets the fecha lote.
	 *
	 * @return the fechaLote
	 */
	public Date getFechaLote() {
		return fechaLote;
	}
	
	/**
	 * Gets the numero lote.
	 *
	 * @return the numeroLote
	 */
	public long getNumeroLote() {
		return numeroLote;
	}
	
	/**
	 * Sets the etapa v os.
	 *
	 * @param etapaVOs the etapaVOs to set
	 */
	public void setEtapaVOs(List<EtapaVO> etapaVOs) {
		this.etapaVOs = etapaVOs;
	}
	
	/**
	 * Sets the fecha lote.
	 *
	 * @param fechaLote the fechaLote to set
	 */
	public void setFechaLote(Date fechaLote) {
		this.fechaLote = fechaLote;
	}
	
	/**
	 * Sets the numero lote.
	 *
	 * @param numeroLote the numeroLote to set
	 */
	public void setNumeroLote(long numeroLote) {
		this.numeroLote = numeroLote;
	}
	
}
