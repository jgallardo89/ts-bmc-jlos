package mx.com.bbva.mt101.ui.commons.viewmodel.reportes;
/*
 * ServletReport.java
 *
 * Created on 1 de octubre de 2009, 01:10 PM
 */

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.*;

import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;

/**
 *
 * @author Julio Morales
 * @version 
 */
public class ServletReport extends HttpServlet {
  
	private static final long serialVersionUID = 1045887506771008190L;

/** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
   * @param request servlet request
   * @param response servlet response
   */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		ServletOutputStream ouputStream = response.getOutputStream();
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		JRExporter exporter = null;
		JRTextExporter exporterTXT = null;
		JasperPrint jasperPrint = null;
		ByteArrayOutputStream baos = null;
		int contador = 1;
			try {
				HttpSession session = request.getSession();
				ArrayList<String> headersReport = (ArrayList<String>) session.getAttribute("headersReport");
				ArrayList<BeanGenerico> fieldsReport = (ArrayList<BeanGenerico>) session.getAttribute("listBeanGenerico");
				String typeReport = (String) session.getAttribute("typeReport");
				String nameReport = (String) session.getAttribute("nameReport");
				
		        Map<String, Object> parameters = new HashMap<String, Object>();
		        for(String header:headersReport) {
		        	parameters.put("parameter" + contador++, header);
		        }
				JRDataSource source = new JRBeanCollectionDataSource(fieldsReport, false);
				parameters.put("dataSource" ,source);
				
				String webappBase = getServletContext().getRealPath("/");
				InputStream input = new FileInputStream(webappBase + 
						File.separator + "/WEB-INF/reportes/reporteGenerico_NumColumnas_"+headersReport.size()+"_510.jasper");
				jasperPrint = JasperFillManager.fillReport(
						input, parameters, source);
				System.out.println("################################"+parameters.size());
				if(typeReport.equals("xls")) {
					response.setContentType("application/vnd.ms-excel");  
					exporter = new JRXlsExporter();
					baos = new ByteArrayOutputStream();
					exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
					exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos );
					exporter.exportReport();
				} else {
					response.setContentType("text/plain");
					baos = new ByteArrayOutputStream();
					exporterTXT = new JRTextExporter();
					exporterTXT.setParameter(JRTextExporterParameter.PAGE_HEIGHT        , new Float(1000));
					exporterTXT.setParameter(JRTextExporterParameter.PAGE_WIDTH         , new Float(1000));
					exporterTXT.setParameter(JRTextExporterParameter.CHARACTER_WIDTH    , new Float(10));
					exporterTXT.setParameter(JRTextExporterParameter.CHARACTER_HEIGHT   , new Float(14));
					exporterTXT.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
					exporterTXT.setParameter(JRExporterParameter.OUTPUT_STREAM, baos );
					exporterTXT.exportReport();
				}
				
				
				
				
				
				byte[] bytes = baos.toByteArray();
				baos.close();
				response.setContentLength(bytes.length);
				response.setHeader("Content-Disposition", "attachment;filename= Reporte_"+
												nameReport+"_"+dateFormat.format(new Date())+"."+typeReport);
				ouputStream.write(bytes);
				System.out.println("************************************************************ " + typeReport);
				ouputStream.flush();
				session.removeAttribute("headersReport");
				session.removeAttribute("typeReport");
				session.removeAttribute("nameReport");
				session.removeAttribute("listBeanGenerico");
		} catch (JRException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		finally {
			if (ouputStream != null) {
				ouputStream.close();
			}
		}
	}
  
  /** Handles the HTTP <code>GET</code> method.
   * @param request servlet request
   * @param response servlet response
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    processRequest(request, response);
  }
  
  /** Handles the HTTP <code>POST</code> method.
   * @param request servlet request
   * @param response servlet response
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    processRequest(request, response);
  }
  
  /** Returns a short description of the servlet.
   */
  public String getServletInfo() {
    return "Short description";
  }
}
