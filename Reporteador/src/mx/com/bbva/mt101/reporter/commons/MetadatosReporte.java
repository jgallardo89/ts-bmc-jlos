package mx.com.bbva.mt101.reporter.commons;

import java.awt.Color;
import java.io.Serializable;

public class MetadatosReporte implements Serializable{
	String nombreReporte;
	int cantidadColumnasReporte;
	String[] nombreColumnasReporte;
	Color colorTituloColumnas;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public String getNombreReporte() {
		return nombreReporte;
	}
	public void setNombreReporte(String nombreReporte) {
		this.nombreReporte = nombreReporte;
	}
	public int getCantidadColumnasReporte() {
		return cantidadColumnasReporte;
	}
	public void setCantidadColumnasReporte(int cantidadColumnasReporte) {
		this.cantidadColumnasReporte = cantidadColumnasReporte;
	}
	public String[] getNombreColumnasReporte() {
		return nombreColumnasReporte;
	}
	public void setNombreColumnasReporte(String[] nombreColumnasReporte) {
		this.nombreColumnasReporte = nombreColumnasReporte;
	}
	public Color getColorTituloColumnas() {
		return colorTituloColumnas;
	}
	public void setColorTituloColumnas(Color colorTituloColumnas) {
		this.colorTituloColumnas = colorTituloColumnas;
	}
	
}
