package mx.com.bbva.bancomer.contratacion.dto;

public class ValorEtapaDTO {

	/** The descripcion id usuarios. */
	private String nombreIdUsuarios;
	
	/** The descripcion mapa gmm. */
	private String nombreMapaGmm;
	
	/** The descripcion mensaje salida. */
	private String nombreMensajeSalida;
	
	/** The estatus notificacion. */
	private Character estatusNotificacion;
	
	private String estatus;

	public String getNombreIdUsuarios() {
		return nombreIdUsuarios;
	}

	public void setNombreIdUsuarios(String nombreIdUsuarios) {
		this.nombreIdUsuarios = nombreIdUsuarios;
	}

	public String getNombreMapaGmm() {
		return nombreMapaGmm;
	}

	public void setNombreMapaGmm(String nombreMapaGmm) {
		this.nombreMapaGmm = nombreMapaGmm;
	}

	public String getNombreMensajeSalida() {
		return nombreMensajeSalida;
	}

	public void setNombreMensajeSalida(String nombreMensajeSalida) {
		this.nombreMensajeSalida = nombreMensajeSalida;
	}

	public Character getEstatusNotificacion() {
		return estatusNotificacion;
	}

	public void setEstatusNotificacion(Character estatusNotificacion) {
		this.estatusNotificacion = estatusNotificacion;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
}
