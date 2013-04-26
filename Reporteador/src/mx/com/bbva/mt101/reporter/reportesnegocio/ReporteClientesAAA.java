package mx.com.bbva.mt101.reporter.reportesnegocio;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import mx.com.bbva.mt101.entities.Tgm138Mt101ctrato;
import mx.com.bbva.mt101.reporter.commons.MetadatosReporte;

public class ReporteClientesAAA {
	private String claveReporte;
	private Object datosReporte;	
	private MetadatosReporte metadatosReporte;	
	private int idReporte;	
	public String generaReporte(String claveReporte, Object datosReporte, int idReporte, MetadatosReporte metadatosReporte) throws Exception{
		this.claveReporte = claveReporte;
		this.datosReporte = datosReporte;
		this.idReporte = idReporte;
		this.metadatosReporte = metadatosReporte;
		long idTime= new Date().getTime();
		String folderPadre = "../reportesMt101/";
		File reporte = new File(folderPadre);
		if(!reporte.exists())
			reporte.mkdir();		
		String reportName = folderPadre+this.claveReporte+idTime+".xls";
		File reporteFile = new File(reportName);
		FileOutputStream outReporte = new FileOutputStream(reporteFile);
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet();
		Row row = null;
		Cell cell = null;
		CellStyle cellStyleHeader = wb.createCellStyle();
		CellStyle cellStyleData = wb.createCellStyle();
		DataFormat df = wb.createDataFormat();
		Font fontHeader = wb.createFont();
		fontHeader.setFontHeightInPoints((short) 12);		
		fontHeader.setBoldweight(Font.BOLDWEIGHT_BOLD);		
		//fontHeader.setColor(HSSFColor.LIGHT_BLUE.index);
		cellStyleHeader.setFont(fontHeader);		
		cellStyleHeader.setAlignment(CellStyle.ALIGN_CENTER);
		cellStyleData.setAlignment(CellStyle.ALIGN_CENTER);
		Font fontData = wb.createFont();
		fontData.setFontHeightInPoints((short) 10);		
		fontData.setBoldweight(Font.BOLDWEIGHT_NORMAL);
		cellStyleData.setFont(fontData);
		cellStyleHeader.setFillBackgroundColor(HSSFColor.RED.index);
		cellStyleHeader.setFillPattern(CellStyle.SOLID_FOREGROUND);
		wb.setSheetName(0, this.claveReporte);
		
		
		List<Tgm138Mt101ctrato> listTgm138Mt101ctratos = (List<Tgm138Mt101ctrato>)this.datosReporte;
		row = sheet.createRow(0);	
		//Creando titulos
		String titulo;
		int anchoPorCaracter = (256+(12*8)) ;
		for(int titulos = 0; titulos < this.metadatosReporte.getCantidadColumnasReporte(); titulos++){
			titulo = this.metadatosReporte.getNombreColumnasReporte()[titulos];
			cell = row.createCell(titulos);
			sheet.setColumnWidth(titulos,titulo.length()*anchoPorCaracter);
			cell.setCellStyle(cellStyleHeader);			
			cell.setCellValue(titulo);
		}
		int renglonesDatos=0;
		for (Tgm138Mt101ctrato tgm138Mt101ctrato : listTgm138Mt101ctratos) {
			row = sheet.createRow(renglonesDatos+1);
			renglonesDatos++;
			cell = row.createCell(0);
			if(sheet.getColumnWidth(0)<tgm138Mt101ctrato.getCdCuentaCheques().length()*anchoPorCaracter)
				sheet.setColumnWidth(0,tgm138Mt101ctrato.getCdCuentaCheques().length()*anchoPorCaracter);
			cell.setCellStyle(cellStyleData);			
			cell.setCellValue(tgm138Mt101ctrato.getCdCuentaCheques());
			
			cell = row.createCell(1);
			if(sheet.getColumnWidth(1)<tgm138Mt101ctrato.getNbEmpresa().length()*anchoPorCaracter)
				sheet.setColumnWidth(1,tgm138Mt101ctrato.getNbEmpresa().length()*anchoPorCaracter);
			cell.setCellStyle(cellStyleData);			
			cell.setCellValue(tgm138Mt101ctrato.getNbEmpresa());
			
			cell = row.createCell(2);
			if(sheet.getColumnWidth(2)<tgm138Mt101ctrato.getCdCodSwRec().length()*anchoPorCaracter)
				sheet.setColumnWidth(2,tgm138Mt101ctrato.getCdCodSwRec().length()*anchoPorCaracter);
			cell.setCellStyle(cellStyleData);			
			cell.setCellValue(tgm138Mt101ctrato.getCdCodSwRec());
			
			cell = row.createCell(3);
			if(tgm138Mt101ctrato.getCdCodSwEnv()!=null)
				if(sheet.getColumnWidth(3)<tgm138Mt101ctrato.getCdCodSwEnv().length()*anchoPorCaracter)
					sheet.setColumnWidth(3,tgm138Mt101ctrato.getCdCodSwEnv().length()*anchoPorCaracter);
			cell.setCellStyle(cellStyleData);			
			cell.setCellValue(tgm138Mt101ctrato.getCdCodSwEnv());
			
			cell = row.createCell(4);
			if(sheet.getColumnWidth(4)<Long.toString(tgm138Mt101ctrato.getCdContrato()).length()*anchoPorCaracter)
				sheet.setColumnWidth(4,Long.toString(tgm138Mt101ctrato.getCdContrato()).length()*anchoPorCaracter);
			cell.setCellStyle(cellStyleData);			
			cell.setCellValue(tgm138Mt101ctrato.getCdContrato());
			
			cell = row.createCell(5);
			if(sheet.getColumnWidth(5)<tgm138Mt101ctrato.getNbMoneda().length()*anchoPorCaracter)
				sheet.setColumnWidth(5,tgm138Mt101ctrato.getNbMoneda().length()*anchoPorCaracter);
			cell.setCellStyle(cellStyleData);			
			cell.setCellValue(tgm138Mt101ctrato.getNbMoneda());
			
			cell = row.createCell(6);
			if(sheet.getColumnWidth(6)<tgm138Mt101ctrato.getNuPorcentaje().length()*anchoPorCaracter)
				sheet.setColumnWidth(6,tgm138Mt101ctrato.getNuPorcentaje().length()*anchoPorCaracter);
			cell.setCellStyle(cellStyleData);			
			cell.setCellValue(tgm138Mt101ctrato.getNuPorcentaje());
			
			cell = row.createCell(7);
			if(tgm138Mt101ctrato.getCdTpClienteAaa()!=null)
				if(sheet.getColumnWidth(7)<tgm138Mt101ctrato.getCdTpClienteAaa().length()*anchoPorCaracter)
					sheet.setColumnWidth(7,tgm138Mt101ctrato.getCdTpClienteAaa().length()*anchoPorCaracter);
			cell.setCellStyle(cellStyleData);			
			cell.setCellValue(tgm138Mt101ctrato.getCdTpClienteAaa().equals("1")?"SI":"NO");
			
			cell = row.createCell(8);
			if(sheet.getColumnWidth(8)<tgm138Mt101ctrato.getFhAlta().toString().length()*anchoPorCaracter)
				sheet.setColumnWidth(8,tgm138Mt101ctrato.getFhAlta().toString().length()*anchoPorCaracter);
			cell.setCellStyle(cellStyleData);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			cell.setCellValue(sdf.format(tgm138Mt101ctrato.getFhAlta()));			
		}		
		wb.write(outReporte);
		outReporte.close();
		return reportName;
	}
	
}
