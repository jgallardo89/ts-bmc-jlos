package mx.com.bbva.bancomer.bitacora.dto;

import java.io.Serializable;

public class CampoDTO implements Serializable {

	private static final long serialVersionUID = 5345154030968378742L;
	private String nombre_campo;
	private String valor_anterior;
	private String valor_nuevo;
	/**
	 * @return the nombre_campo
	 */
	public String getNombre_campo() {
		return nombre_campo;
	}
	/**
	 * @param nombre_campo the nombre_campo to set
	 */
	public void setNombre_campo(String nombre_campo) {
		this.nombre_campo = nombre_campo;
	}
	/**
	 * @return the valor_anterior
	 */
	public String getValor_anterior() {
		return valor_anterior;
	}
	/**
	 * @param valor_anterior the valor_anterior to set
	 */
	public void setValor_anterior(String valor_anterior) {
		this.valor_anterior = valor_anterior;
	}
	/**
	 * @return the valor_nuevo
	 */
	public String getValor_nuevo() {
		return valor_nuevo;
	}
	/**
	 * @param valor_nuevo the valor_nuevo to set
	 */
	public void setValor_nuevo(String valor_nuevo) {
		this.valor_nuevo = valor_nuevo;
	}
	
}
