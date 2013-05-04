package mx.com.bbva.mapeador.security.session.user;

import java.io.Serializable;

public class SessionUser implements Serializable {	
	private String cveUsuario;

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
