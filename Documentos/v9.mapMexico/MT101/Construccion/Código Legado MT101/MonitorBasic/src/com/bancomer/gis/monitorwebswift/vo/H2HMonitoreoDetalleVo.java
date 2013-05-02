package com.bancomer.gis.monitorwebswift.vo;

public class H2HMonitoreoDetalleVo extends GeneralVo implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private long id_archivo;
	private String nombre_archivo;
	private String fecha;
	private String hora;
	private String status;
	private String archivo_respaldo;
	private int id_status;
	private String conexion;
	private int detalle_err;
	protected boolean selected;
	
	public H2HMonitoreoDetalleVo(){
		this.detalle_err = 0;
	}

	public String getNombre_archivo() {
		return nombre_archivo;
	}

	public void setNombre_archivo(String nombreArchivo) {
		nombre_archivo = nombreArchivo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getArchivo_respaldo() {
		return archivo_respaldo;
	}

	public void setArchivo_respaldo(String archivoRespaldo) {
		archivo_respaldo = archivoRespaldo;
	}

	public int getId_status() {
		return id_status;
	}

	public void setId_status(int idStatus) {
		id_status = idStatus;
	}

	public String getConexion() {
		return conexion;
	}

	public void setConexion(String conexion) {
		this.conexion = conexion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getDetalle_err() {
		return detalle_err;
	}

	public void setDetalle_err(int detalleErr) {
		detalle_err = detalleErr;
	}

	public long getId_archivo() {
		return id_archivo;
	}

	public void setId_archivo(long idArchivo) {
		id_archivo = idArchivo;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
}
