package mx.com.bbva.mapeador.security.session.user;

import java.io.Serializable;

public class SessionUser implements Serializable {	
	private String cveUsuario;
	private int idPerfil;
	/**
	 * @return the idPerfil
	 */
	public final int getIdPerfil() {
		return idPerfil;
	}

	/**
	 * @param idPerfil the idPerfil to set
	 */
	public final void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	/**
	 * @return the idUsuario
	 */
	public final int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public final void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	private int idUsuario;

	/**
	 * @return the cveUsuario
	 */
	public String getCveUsuario() {
		return cveUsuario;
	}

	/**
	 * @param cveUsuario the cveUsuario to set
	 */
	public void setCveUsuario(String cveUsuario) {
		this.cveUsuario = cveUsuario;
	}
	
}
