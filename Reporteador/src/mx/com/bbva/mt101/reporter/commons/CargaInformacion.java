package mx.com.bbva.mt101.reporter.commons;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CargaInformacion {
	private static CargaInformacion instance = null;
	private Properties infoReportes;
	public Properties getInfoReportes() {
		return infoReportes;
	}
	public void setInfoReportes(Properties infoReportes) {
		this.infoReportes = infoReportes;
	}
	public CargaInformacion() {
		infoReportes = new Properties();		 
    	try{    		
    		//infoReportes.load(new FileInputStream(fileConfig));              
    		infoReportes.load(CargaInformacion.class.getResourceAsStream("configReportes.properties"));
    	} catch (IOException ex) {
    		ex.printStackTrace();
        }
	}		
	public static CargaInformacion getInstance() {
		if(instance == null) {
			instance = new CargaInformacion();
		}
		return instance;
   }
}
