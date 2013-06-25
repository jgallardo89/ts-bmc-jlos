package mx.com.bbva.bancomer.estadistico.dto;

import java.io.Serializable;
import java.util.List;

public class PrimerNivelDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8410299245531939044L;
	private int id;
	private String nombre;
	private List<SegundoNivelDTO> segundoNivelDTOs;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
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
	 * @return the segundoNivelDTOs
	 */
	public List<SegundoNivelDTO> getSegundoNivelDTOs() {
		return segundoNivelDTOs;
	}
	/**
	 * @param segundoNivelDTOs the segundoNivelDTOs to set
	 */
	public void setSegundoNivelDTOs(List<SegundoNivelDTO> segundoNivelDTOs) {
		this.segundoNivelDTOs = segundoNivelDTOs;
	}
}
