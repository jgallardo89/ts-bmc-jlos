package mx.com.bbva.mapeador.ui.commons.viewmodel.monitoreoprocesos;

import java.util.Date;
import java.util.List;

public class LoteVO {
	private long numeroLote;
	private Date fechaLote;
	private List<EtapaVO> etapaVOs;
	/**
	 * @return the numeroLote
	 */
	public long getNumeroLote() {
		return numeroLote;
	}
	/**
	 * @param numeroLote the numeroLote to set
	 */
	public void setNumeroLote(long numeroLote) {
		this.numeroLote = numeroLote;
	}
	/**
	 * @return the fechaLote
	 */
	public Date getFechaLote() {
		return fechaLote;
	}
	/**
	 * @param fechaLote the fechaLote to set
	 */
	public void setFechaLote(Date fechaLote) {
		this.fechaLote = fechaLote;
	}
	/**
	 * @return the etapaVOs
	 */
	public List<EtapaVO> getEtapaVOs() {
		return etapaVOs;
	}
	/**
	 * @param etapaVOs the etapaVOs to set
	 */
	public void setEtapaVOs(List<EtapaVO> etapaVOs) {
		this.etapaVOs = etapaVOs;
	}
	
}
