package com.bancomer.gis.monitorwebswift.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

import com.bancomer.gis.monitorwebswift.logic.PropertiesService;
import com.bancomer.gis.monitorwebswift.logic.impl.PropertiesServiceImpl;

public final class Utils {
	private static PropertiesService propertiesService;
	public static final double roundDouble(double nD, int nDec){
		//String format ="";
		//double dou = Math.round(nD*Math.pow(10,nDec))/Math.pow(10,nDec);
		
		return Math.round(nD*Math.pow(10,nDec))/Math.pow(10,nDec);
	}
	
	public static final String quitarAcentos(String cadena){
		String cad = cadena;
		cad = cadena.replace("á", "&aacute;");
		cad = cad.replace("é", "&eacute;");
		cad = cad.replace("í", "&iacute;");
		cad = cad.replace("ó", "&oacute;");
		cad = cad.replace("ú", "&uacute;");
		return cad;
	}
	
	public static ArrayList< String > LeerSicocos(int tipo){
    	boolean inicioListado = false;
    	URL miURL = null;
    	ArrayList < String > archivos = new ArrayList<String>();
    	propertiesService=new PropertiesServiceImpl();
        try {
        	if(tipo == 101)
            	miURL = new URL(propertiesService.getProperty("fxUtils_URL1"));
            else if(tipo == 940)
            	miURL = new URL(propertiesService.getProperty("fxUtils_URL2"));
            else if(tipo == 999)
            	miURL = new URL(propertiesService.getProperty("fxUtils_URL3"));

            if(miURL == null) return archivos;
            
            DataInputStream dis = new DataInputStream(miURL.openStream());
            String inputLine;
			
            while((inputLine = dis.readLine()) != null) {
            	inputLine = inputLine.trim();
            	if(inputLine.contains("<tbody>"))
            		inicioListado = true;
            	else if(inputLine.contains("</tbody>"))
            		inicioListado = false;
            	
            	if(inicioListado){
            		if(inputLine.startsWith("<td class=\"")&& inputLine.contains("<a href=\"")){
            			inputLine = inputLine.substring(inputLine.indexOf("<a href="));
            			inputLine = inputLine.substring(inputLine.indexOf("\">") + 1);
            			inputLine = inputLine.substring(1, inputLine.length() - 9);
            			System.out.println(inputLine);
            			archivos.add(inputLine);
            		}
            	}
            }            
            dis.close();       
        } catch (MalformedURLException me) {
            System.out.println("MalformedURLException: " + me);
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe);
        }
        return archivos;
    }

	public static String limpiarNombre(String nombre){
		String nombreAux = nombre.replace(' ', '-');
		String aux[] = nombreAux.split("-");
		String nomesp = null;
		String nuevoNombre = "";

		for (int i=0; i < aux.length; i++){
			nomesp = aux[i];
			if(nomesp.length() > 0){
				nuevoNombre += nomesp + " ";
			}
		}	
		return nuevoNombre;
	}
	
	public static String limpiarGuionNombre(String nombre){
		String nombreAux = nombre.replace('_', ' ');
		String aux[] = nombreAux.split("-");
		String nomesp = null;
		String nuevoNombre = "";

		for (int i=0; i < aux.length; i++){
			nomesp = aux[i];
			if(nomesp.length() > 0){
				nuevoNombre += nomesp + " ";
			}
		}	
		return capitalize(nuevoNombre);
	}

	public static String capitalize(String s) {
			if (s.length() == 0) return s;
			return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}
	
	
	public static HSSFWorkbook generateExcel(List registros, ArrayList<String> atributos,ArrayList<String> encabezados, String nombreHoja){

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet firstSheet = workbook.createSheet(nombreHoja);
		
		//firstSheet.autoSizeColumn(1);
		firstSheet.setColumnWidth(1, 6000);
		firstSheet.setColumnWidth(2, 7000);
		firstSheet.setColumnWidth(3, 7000);
		firstSheet.setColumnWidth(4, 9000);
		firstSheet.setColumnWidth(4, 7000);
		firstSheet.setColumnWidth(6, 6000);
		firstSheet.setColumnWidth(7, 8000);
		
		HSSFRow r = null;
		HSSFCell c = null;
		
		HSSFPalette paleta = workbook.getCustomPalette();
		HSSFColor verdeTextoTh = paleta.findSimilarColor((byte)5, (byte)90, (byte)120);
		HSSFColor verdeFondoTh = paleta.findSimilarColor((byte)154, (byte)194, (byte)229);
		HSSFColor verdeAlterno = paleta.findSimilarColor((byte)229, (byte)245, (byte)240);
		
		HSSFCellStyle cs  = workbook.createCellStyle();
		HSSFCellStyle cs2 = workbook.createCellStyle();
		HSSFCellStyle cs3 = workbook.createCellStyle();
		HSSFCellStyle cs4 = workbook.createCellStyle();
		HSSFCellStyle cs5 = workbook.createCellStyle();
		
		
		HSSFDataFormat df = workbook.createDataFormat();
		HSSFFont f0 = workbook.createFont();
		HSSFFont f = workbook.createFont();
		HSSFFont f2 = workbook.createFont();
		
		f0.setFontHeightInPoints((short)14);
		f0.setColor(verdeTextoTh.getIndex());
		f.setFontHeightInPoints((short)10);
		f.setColor(verdeTextoTh.getIndex());
		f.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		f2.setFontHeightInPoints((short)8);
		f2.setColor(HSSFColor.BLACK.index);
		f2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
				
		cs.setFont(f);
		cs.setDataFormat(HSSFDataFormat.getBuiltinFormat("text"));
		cs.setFillForegroundColor(verdeFondoTh.getIndex());
		cs.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cs.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cs.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		cs.setBorderBottom(CellStyle.BORDER_MEDIUM);
		cs.setBottomBorderColor(IndexedColors.WHITE.getIndex());
		cs.setBorderTop(CellStyle.BORDER_MEDIUM);
		cs.setTopBorderColor(IndexedColors.WHITE.getIndex());
		cs.setBorderLeft(CellStyle.BORDER_MEDIUM);
		cs.setLeftBorderColor(IndexedColors.WHITE.getIndex());
		cs.setBorderRight(CellStyle.BORDER_MEDIUM);
		cs.setRightBorderColor(IndexedColors.WHITE.getIndex());
		
		cs2.setFont(f2);
		cs2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		
		
		cs3.setFont(f2);
		cs3.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cs3.setFillForegroundColor(verdeAlterno.getIndex());
		cs3.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
		cs4.setFont(f2);
		cs4.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		
		cs5.setFont(f2);
		cs5.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		cs5.setFillForegroundColor(verdeAlterno.getIndex());
		cs5.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
		r = firstSheet.createRow(0);
		for (int i=0; i < encabezados.size(); i++){
			c = r.createCell(i);c.setCellStyle(cs);c.setCellValue(new HSSFRichTextString(encabezados.get(i)));
		}
		int styleRowCount = 1;
		HSSFCellStyle styleRow = cs2;
		HSSFCellStyle styleRow2 = cs4;
		for(int i=0; i < registros.size(); i++){
			Object registro = registros.get(i);
			if((styleRowCount%2)!=0){
				styleRow=cs2;
				styleRow2=cs4;
			}else{
				styleRow=cs3;
				styleRow2=cs5;
			}
			r = firstSheet.createRow(styleRowCount);
			styleRow.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			//Crear un registro
			for (int numAtributos = 0; numAtributos < atributos.size(); numAtributos++) {
                try {
                    String valor = BeanUtils.getSimpleProperty(registro,
                            atributos.get(numAtributos));
                    c = r.createCell(numAtributos);c.setCellStyle(styleRow);c.setCellValue(valor);
                   
                }
                catch (IllegalAccessException e) {
                }
                catch (InvocationTargetException e) {                   
                }
                catch (NoSuchMethodException e) {                    
                }
            }			
			styleRowCount++;
		}
		return workbook;
	}
	/* (non-Javadoc)
	 * @see bbva.bancomer.com.ppg.csp.generadorXls.services.GeneradorXlsService#generaXlsEstatusXProyecto()
	 */	
	public static InputStream generarXlsInputStream(HSSFWorkbook wb) {
		InputStream inputStream = null;
		try{			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			wb.write(baos);			
			inputStream = new ByteArrayInputStream(baos.toByteArray());
		}catch (IOException ioe) {
			System.out.println("Error al generar el archivo \n"+ ioe);
		}
			// Se transforma el buffer en un stream esperado
		return inputStream;
	}
	
	
	public static HSSFWorkbook generateExcel(List registros, ArrayList<String> atributos,ArrayList<String> encabezados, String nombreHoja, int page){

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet firstSheet = workbook.createSheet(nombreHoja);
		
		//firstSheet.autoSizeColumn(1);
		firstSheet.setColumnWidth(1, 6000);
		firstSheet.setColumnWidth(2, 5500);
		firstSheet.setColumnWidth(4, 8000);
		firstSheet.setColumnWidth(6, 5500);
		firstSheet.setColumnWidth(7, 8000);
		
		HSSFRow r = null;
		HSSFCell c = null;
		
		HSSFPalette paleta = workbook.getCustomPalette();
		HSSFColor verdeTextoTh = paleta.findSimilarColor((byte)5, (byte)90, (byte)120);
		HSSFColor verdeFondoTh = paleta.findSimilarColor((byte)154, (byte)194, (byte)229);
		HSSFColor verdeAlterno = paleta.findSimilarColor((byte)229, (byte)245, (byte)240);
		
		HSSFCellStyle cs  = workbook.createCellStyle();
		HSSFCellStyle cs2 = workbook.createCellStyle();
		HSSFCellStyle cs3 = workbook.createCellStyle();
		HSSFCellStyle cs4 = workbook.createCellStyle();
		HSSFCellStyle cs5 = workbook.createCellStyle();
		
		
		HSSFDataFormat df = workbook.createDataFormat();
		HSSFFont f0 = workbook.createFont();
		HSSFFont f = workbook.createFont();
		HSSFFont f2 = workbook.createFont();
		
		f0.setFontHeightInPoints((short)14);
		f0.setColor(verdeTextoTh.getIndex());
		f.setFontHeightInPoints((short)10);
		f.setColor(verdeTextoTh.getIndex());
		f.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		f2.setFontHeightInPoints((short)8);
		f2.setColor(HSSFColor.BLACK.index);
		f2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
				
		cs.setFont(f);
		cs.setDataFormat(HSSFDataFormat.getBuiltinFormat("text"));
		cs.setFillForegroundColor(verdeFondoTh.getIndex());
		cs.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cs.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cs.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		cs.setBorderBottom(CellStyle.BORDER_MEDIUM);
		cs.setBottomBorderColor(IndexedColors.WHITE.getIndex());
		cs.setBorderTop(CellStyle.BORDER_MEDIUM);
		cs.setTopBorderColor(IndexedColors.WHITE.getIndex());
		cs.setBorderLeft(CellStyle.BORDER_MEDIUM);
		cs.setLeftBorderColor(IndexedColors.WHITE.getIndex());
		cs.setBorderRight(CellStyle.BORDER_MEDIUM);
		cs.setRightBorderColor(IndexedColors.WHITE.getIndex());
		
		cs2.setFont(f2);
		cs2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		
		
		cs3.setFont(f2);
		cs3.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cs3.setFillForegroundColor(verdeAlterno.getIndex());
		cs3.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
		cs4.setFont(f2);
		cs4.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		
		cs5.setFont(f2);
		cs5.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		cs5.setFillForegroundColor(verdeAlterno.getIndex());
		cs5.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
		r = firstSheet.createRow(0);
		for (int i=0; i < encabezados.size(); i++){
			c = r.createCell(i);c.setCellStyle(cs);c.setCellValue(new HSSFRichTextString(encabezados.get(i)));
		}
		int styleRowCount = 1;
		HSSFCellStyle styleRow = cs2;
		HSSFCellStyle styleRow2 = cs4;
		for(int i=0; i < registros.size(); i++){
			Object registro = registros.get(i);
			if((styleRowCount%2)!=0){
				styleRow=cs2;
				styleRow2=cs4;
			}else{
				styleRow=cs3;
				styleRow2=cs5;
			}
			r = firstSheet.createRow(styleRowCount);
			styleRow.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			//Crear un registro
			for (int numAtributos = 0; numAtributos < atributos.size(); numAtributos++) {
                try {
                    String valor = BeanUtils.getSimpleProperty(registro,
                            atributos.get(numAtributos));
                    if(page==1){
	                    if(numAtributos == 2 || numAtributos == 3){
	                    	c = r.createCell(numAtributos);c.setCellStyle(styleRow);c.setCellValue(Integer.parseInt(valor));
	                    }
	                    else {
	                    c = r.createCell(numAtributos);c.setCellStyle(styleRow);c.setCellValue(valor);
	                    }
                    }else if(page == 2){
	                    if(numAtributos == 5){
	                    	c = r.createCell(numAtributos);c.setCellStyle(styleRow);c.setCellValue(Integer.parseInt(valor));
	                    }
	                    else {
	                    c = r.createCell(numAtributos);c.setCellStyle(styleRow);c.setCellValue(valor);
	                    }                    	                    	
                    }
                }
                catch (IllegalAccessException e) {
                }
                catch (InvocationTargetException e) {                   
                }
                catch (NoSuchMethodException e) {                    
                }
            }			
			styleRowCount++;
		}
		return workbook;
	}
	
	public static String executeCommand ( String command, boolean flagbackground) {
		// Definimos la cadena del interprete de comandos del sistema
		String commandShell=null;
		String resultado = "";
		// Recuperamos el sistema operativo
		String osName = System.getProperty("os.name");
	
		// Cargamos la cadena del interprete de comandos según el sistema operativo y el comando a ejecutar
		if ( osName.equals ("Windows NT") ||  osName.equals ("Windows XP")) {
			commandShell = "cmd.exe /C " + command;
		}
		else if ( osName.equals ("Windows 95") || osName.equals ("Windows 98") ) {
			commandShell = "start " + command;
		}
		else {
			// En UNIX y LUNUX podemos lanzar el proceso en background sufijandolo con &
			if (flagbackground){
				commandShell = "" + command +" &" ;
			}
			else{
				commandShell = "" + command ;
			}
		}
	
		// Lanzamos el proceso
		try {
			Process proc = Runtime.getRuntime ().exec (commandShell);
			BufferedReader brStdOut = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			BufferedReader brStdErr = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
			String str=null;
			while ((str = brStdOut.readLine())!=null) {
				System.out.println (str);
				resultado = resultado + str; 
			}
			brStdOut.close();
			brStdErr.close();
		} catch (IOException eproc) {
			System.out.println ("Error to execute the command : "+eproc);
			resultado = "Error to execute the command : "+eproc;
			return resultado;
		}
		return resultado;
	} 
	
	/**Mapa que contiene los meses para diversas operaciones
	 * 
	 * @input none
	 * @return Map<Integer,String>
	 * */
	
	
	
	
	public static final Map<Integer,String>  regresaMeses()
	
	{
		Map<Integer,String> meses=new HashMap<Integer, String>();
			
			meses.put(1, "Enero");
			meses.put(2, "Febrero");
			meses.put(3, "Marzo");
			meses.put(4, "Abril");
			meses.put(5, "Mayo");
			meses.put(6, "Junio");
			meses.put(7, "Julio");
			meses.put(8, "Agosto");
			meses.put(9, "Septiembre");
			meses.put(10, "Octubre");
			meses.put(11, "Noviembre");
			meses.put(12, "Diciembre");
		
		return meses;
		
	}
	
	
	public static final String regresaMes(int numMes)
	{
		String retornoMes=null;
		Map catalogo=regresaMeses();
		
			Iterator it=catalogo.entrySet().iterator();
			
			while(it.hasNext())
			{
				Map.Entry e = (Map.Entry)it.next();
				int mes=(Integer)e.getKey();
					if(mes==numMes)
					{
						retornoMes=(String)e.getValue();
						break;
					}
			}
			
		return retornoMes;
	}
	
	/*Se agrega nueva modificacion para validar los objetos resultantes de un RD*/
	
	public static final String validaNulos(String input)
	{
	String retorno="";	
		
		if(input==null)
			retorno="";
		else if(input.equals(" "))
			retorno="";
		else
			retorno=input;
		
		return retorno;
		
	}
	
	/*Regres un % para consultas de BD*/
	public static final String validaNulosReturn(String input)
	{
		String retorno="%";	
			
			if(input==null)
				retorno="%";
			else if(input.equals(" "))
				retorno="%";
			else if(input.equals(""))
				retorno="%";
			else
				retorno=input;
			
			return retorno;
			
	}
	
	/*Para formatos de fecha*/
	public static final Date obtieneSQLDate()
	{
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		//Con formato de java.sql.Date
		//System.out.println(sqlDate);
		return sqlDate;
	}
	
	public static String regresaFechaFormateada()
	{
		String fecha=null;
		
		Date fechaSql=obtieneSQLDate();
		
		String[] fechaArray=fechaSql.toString().split("-");
		
		fecha=fechaArray[2].toString()+fechaArray[1].toString()+fechaArray[0].toString();
		
		
		return fecha;
		
	}
	
	public static String regresaFechaFormateadaExcel()
	{
		String fecha=null;
		
		Date fechaSql=obtieneSQLDate();
		
		String[] fechaArray=fechaSql.toString().split("-");
		
		fecha=fechaArray[0].substring(2,4).toString()+fechaArray[1].toString()+fechaArray[2].toString();
		
		
		return fecha;
		
	}
	
	
}
