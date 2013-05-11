package mx.com.bbva.bancomer.bussinnes.model.vo;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

/**
 * @author Julio Morales
 *
 */
public class PalabraComodinVO extends BbvaAbstractValueObject {

	private static final long serialVersionUID = -8401195388066841617L;
	private int idPalabraComodin;
	private String nombrePalabraComodin;
	private String descripcionPalabraComodin;
	/**
	 * @return the idPalabraComodin
	 */
	public int getIdPalabraComodin() {
		return idPalabraComodin;
	}
	/**
	 * @param idPalabraComodin the idPalabraComodin to set
	 */
	public void setIdPalabraComodin(int idPalabraComodin) {
		this.idPalabraComodin = idPalabraComodin;
	}
	/**
	 * @return the nombrePalabraComodin
	 */
	public String getNombrePalabraComodin() {
		return nombrePalabraComodin;
	}
	/**
	 * @param nombrePalabraComodin the nombrePalabraComodin to set
	 */
	public void setNombrePalabraComodin(String nombrePalabraComodin) {
		this.nombrePalabraComodin = nombrePalabraComodin;
	}
	/**
	 * @return the descripcionPalabraComodin
	 */
	public String getDescripcionPalabraComodin() {
		return descripcionPalabraComodin;
	}
	/**
	 * @param descripcionPalabraComodin the descripcionPalabraComodin to set
	 */
	public void setDescripcionPalabraComodin(String descripcionPalabraComodin) {
		this.descripcionPalabraComodin = descripcionPalabraComodin;
	}
}
