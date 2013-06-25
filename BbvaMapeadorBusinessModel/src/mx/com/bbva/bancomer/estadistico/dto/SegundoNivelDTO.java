package mx.com.bbva.bancomer.estadistico.dto;

import java.io.Serializable;
import java.util.List;

public class SegundoNivelDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7680353153838735401L;
	private String nombre;
	private List<TercerNivelDTO> tercerNivelDTOs;
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the tercerNivelDTOs
	 */
	public List<TercerNivelDTO> getTercerNivelDTOs() {
		return tercerNivelDTOs;
	}
	/**
	 * @param tercerNivelDTOs the tercerNivelDTOs to set
	 */
	public void setTercerNivelDTOs(List<TercerNivelDTO> tercerNivelDTOs) {
		this.tercerNivelDTOs = tercerNivelDTOs;
	}
	
	
}
