package mx.com.bbva.bancomer.bussinnes.model.vo;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

/**
 * @author Julio Morales
 *
 */
public class EventoMapeador extends BbvaAbstractValueObject {

	private static final long serialVersionUID = 206366534004792211L;
	private int idEventoMapeador;
	private String nombreEventoMapeador;
	private String descripcionEventoMapeador;
	/**
	 * @return the idEventoMapeador
	 */
	public int getIdEventoMapeador() {
		return idEventoMapeador;
	}
	/**
	 * @param idEventoMapeador the idEventoMapeador to set
	 */
	public void setIdEventoMapeador(int idEventoMapeador) {
		this.idEventoMapeador = idEventoMapeador;
	}
	/**
	 * @return the nombreEventoMapeador
	 */
	public String getNombreEventoMapeador() {
		return nombreEventoMapeador;
	}
	/**
	 * @param nombreEventoMapeador the nombreEventoMapeador to set
	 */
	public void setNombreEventoMapeador(String nombreEventoMapeador) {
		this.nombreEventoMapeador = nombreEventoMapeador;
	}
	/**
	 * @return the descripcionEventoMapeador
	 */
	public String getDescripcionEventoMapeador() {
		return descripcionEventoMapeador;
	}
	/**
	 * @param descripcionEventoMapeador the descripcionEventoMapeador to set
	 */
	public void setDescripcionEventoMapeador(String descripcionEventoMapeador) {
		this.descripcionEventoMapeador = descripcionEventoMapeador;
	}
	
}
