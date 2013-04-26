package mx.com.bbva.mt101.reporter.engine;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import mx.com.bbva.mt101.entities.Tgm138Mt101ctrato;
import mx.com.bbva.mt101.reporter.commons.CargaInformacion;
import mx.com.bbva.mt101.reporter.commons.MetadatosReporte;
import mx.com.bbva.mt101.reporter.engine.Reportes;
import mx.com.bbva.mt101.reporter.reportesnegocio.ReporteClientesAAA;


public class MotorReportes {
	private String claveReporte;
	private Object datosReporte;	
	private MetadatosReporte metadatosReporte;
	private Properties configProperties;
	private int idReporte;
	public 	String generaReporte(String claveReporte, List datosReporte,int identificadorReporte) throws Exception{
		this.claveReporte = claveReporte;
		this.datosReporte = datosReporte;			
		this.idReporte = identificadorReporte;
		obtieneMetadatos();
		String outReporte = null;
		switch (this.idReporte) {
		case Reportes.REPORTE_CLIENTES_AAA:
			ReporteClientesAAA reporteClientesAAA = new ReporteClientesAAA();
			outReporte = reporteClientesAAA.generaReporte(this.claveReporte,this.datosReporte, this.idReporte, this.metadatosReporte);
			break;
		default:
			break;
		}											
		
		return outReporte;
	}

	private void obtieneMetadatos() {

		this.configProperties = CargaInformacion.getInstance().getInfoReportes();
		this.metadatosReporte = new MetadatosReporte();
		this.metadatosReporte.setNombreReporte(configProperties.getProperty("nombre"+this.claveReporte));
		this.metadatosReporte.setCantidadColumnasReporte(Integer.parseInt(configProperties.getProperty("cantidadColumnas"+this.claveReporte)));		
		this.metadatosReporte.setColorTituloColumnas(
				new Color(
						new Integer(configProperties.getProperty("colorTituloColumnas"+this.claveReporte+"r"))
								,new Integer(configProperties.getProperty("colorTituloColumnas"+this.claveReporte+"g"))
										,new Integer(configProperties.getProperty("colorTituloColumnas"+this.claveReporte+"b"))
						)
				);
		String[] columnas = new String[this.metadatosReporte.getCantidadColumnasReporte()];
		for(int i=0; i<this.metadatosReporte.getCantidadColumnasReporte(); i++ ){			
			columnas[i] = configProperties.getProperty("columna"+this.claveReporte+(i+1));
		}
		this.metadatosReporte.setNombreColumnasReporte(columnas);
	}
	public static void main(String[] args) {
		MotorReportes motorReportes = new MotorReportes();
		List<Tgm138Mt101ctrato> tgm138Mt101ctratos = new ArrayList<Tgm138Mt101ctrato>();
		//DATOS PARA PRUEBA
		Tgm138Mt101ctrato tgm138Mt101ctratos1 = new Tgm138Mt101ctrato();
		Tgm138Mt101ctrato tgm138Mt101ctratos2 = new Tgm138Mt101ctrato();
		tgm138Mt101ctratos1.setCdContrato(999999999);
		tgm138Mt101ctratos1.setCdCuentaCheques("1111111113");
		tgm138Mt101ctratos1.setCdMoneda(1);
		tgm138Mt101ctratos1.setNbMoneda("MXM");
		tgm138Mt101ctratos1.setCdCodSwRec("12345678901");
		tgm138Mt101ctratos1.setCdCodSwEnv("12345678902");	
		tgm138Mt101ctratos1.setNbEmpresa("EDGAR VERGARA REVELES");
		tgm138Mt101ctratos1.setCdTpClienteAaa("1");		
		tgm138Mt101ctratos1.setCdContratoSicoco("");
		tgm138Mt101ctratos1.setCdAnualidad("1");
		tgm138Mt101ctratos1.setCdMensualidad("1");
		tgm138Mt101ctratos1.setCdIva(1);
		tgm138Mt101ctratos1.setNuPorcentaje("16%");
		tgm138Mt101ctratos1.setFhAlta(new Date());
		
		tgm138Mt101ctratos2.setCdContrato(11111114);
		tgm138Mt101ctratos2.setCdCuentaCheques("1111111114");
		tgm138Mt101ctratos2.setCdMoneda(1);
		tgm138Mt101ctratos2.setNbMoneda("MXM");
		tgm138Mt101ctratos2.setCdCodSwRec("99999999999");
		tgm138Mt101ctratos2.setCdCodSwEnv("9A9D9D8D911");	
		tgm138Mt101ctratos2.setNbEmpresa("JUAN LE");
		tgm138Mt101ctratos2.setCdTpClienteAaa("1");		
		tgm138Mt101ctratos2.setCdContratoSicoco("");
		tgm138Mt101ctratos2.setCdAnualidad("1");
		tgm138Mt101ctratos2.setCdMensualidad("1");
		tgm138Mt101ctratos2.setCdIva(1);
		tgm138Mt101ctratos2.setNuPorcentaje("16%");
		tgm138Mt101ctratos2.setFhAlta(new Date());
		
		tgm138Mt101ctratos.add(tgm138Mt101ctratos1);
		tgm138Mt101ctratos.add(tgm138Mt101ctratos2);
		try {
			motorReportes.generaReporte("ReporteClientesAAA", tgm138Mt101ctratos, Reportes.REPORTE_CLIENTES_AAA);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
