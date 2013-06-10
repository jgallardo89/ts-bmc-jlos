package mx.com.bbva.mapeador.ui.commons.viewmodel.monitoreoprocesos;

import java.util.List;

public class ProcesoVO {
	private long idCanal;
	private String nombreCanal;
	private long idCliente;
	private String idIdentificador;
	private long idProducto;
	private String nombreProducto;
	private long idEstatusMapeador;
	private String nombreEstatusMapeador;
	private String imagenEstatus; 
	private List<LoteVO> loteVOs;
	
	

	/**
	 * @return the imagenEstatus
	 */
	public String getImagenEstatus() {
		return imagenEstatus;
	}
	/**
	 * @param imagenEstatus the imagenEstatus to set
	 */
	public void setImagenEstatus(String imagenEstatus) {
		this.imagenEstatus = imagenEstatus;
	}
	/**
	 * @return the idCanal
	 */
	public long getIdCanal() {
		return idCanal;
	}
	/**
	 * @param idCanal the idCanal to set
	 */
	public void setIdCanal(long idCanal) {
		this.idCanal = idCanal;
	}
	/**
	 * @return the nombreCanal
	 */
	public String getNombreCanal() {
		return nombreCanal;
	}
	/**
	 * @param nombreCanal the nombreCanal to set
	 */
	public void setNombreCanal(String nombreCanal) {
		this.nombreCanal = nombreCanal;
	}
	/**
	 * @return the idCliente
	 */
	public long getIdCliente() {
		return idCliente;
	}
	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	/**
	 * @return the idIdentificador
	 */
	public String getIdIdentificador() {
		return idIdentificador;
	}
	/**
	 * @param idIdentificador the idIdentificador to set
	 */
	public void setIdIdentificador(String idIdentificador) {
		this.idIdentificador = idIdentificador;
	}
	/**
	 * @return the idProducto
	 */
	public long getIdProducto() {
		return idProducto;
	}
	/**
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}
	/**
	 * @return the nombreProducto
	 */
	public String getNombreProducto() {
		return nombreProducto;
	}
	/**
	 * @param nombreProducto the nombreProducto to set
	 */
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	/**
	 * @return the idEstatusMapeador
	 */
	public long getIdEstatusMapeador() {
		return idEstatusMapeador;
	}
	/**
	 * @param idEstatusMapeador the idEstatusMapeador to set
	 */
	public void setIdEstatusMapeador(long idEstatusMapeador) {
		this.idEstatusMapeador = idEstatusMapeador;
	}
	/**
	 * @return the nombreEstatusMapeador
	 */
	public String getNombreEstatusMapeador() {
		return nombreEstatusMapeador;
	}
	/**
	 * @param nombreEstatusMapeador the nombreEstatusMapeador to set
	 */
	public void setNombreEstatusMapeador(String nombreEstatusMapeador) {
		this.nombreEstatusMapeador = nombreEstatusMapeador;
	}
	/**
	 * @return the loteVOs
	 */
	public List<LoteVO> getLoteVOs() {
		return loteVOs;
	}
	/**
	 * @param loteVOs the loteVOs to set
	 */
	public void setLoteVOs(List<LoteVO> loteVOs) {
		this.loteVOs = loteVOs;
	} 

	
} 
