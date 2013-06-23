/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Informacion Confidencial:
 * Este software contiene informacion totalmente confidencial propiedad de Grupo Financiero BBVA Bancomer. 
 * Queda totalmente prohibido su uso o divulgacion en forma parcial o total y solamente podra ser utilizada de acuerdo a los terminos y estatutos 
 * que determine el Grupo Financiero BBVA Bancomer.
 * 
 * Todos los derechos reservados, Mexico 2013.
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * DESCRIPCION DEL PROGRAMA
 * Nombre de aplicación: MAPEADOR
 * Nombre de proyecto: BbvaMapeadorWeb
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * HISTORIAL DE CAMBIOS:
 * 
 * Fecha:									         	
 * 30-ABR-2013  
 * @Author:	Jose Luis Ortiz Salazar
 * @Email: jortizsalazar@gmail.com    	
 * Razon: Creacion        
 * Version: 1.0.0
 * Nombre de clase: ServletReport.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.reportes
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.reportes;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;

// TODO: Auto-generated Javadoc
/**
 * The Class ServletReport.
 *
 * @author Julio Morales
 * @version
 */
public class ServletReport extends HttpServlet {
  
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1045887506771008190L;

/**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException the servlet exception
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    processRequest(request, response);
  }
  
  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException the servlet exception
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    processRequest(request, response);
  }
  
  /**
   * Returns a short description of the servlet.
   *
   * @return the servlet info
   */
  @Override
public String getServletInfo() {
    return "Short description";
  }
  
  /**
 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException the servlet exception
 * @throws IOException Signals that an I/O exception has occurred.
 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		ServletOutputStream ouputStream = response.getOutputStream();
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		JRExporter exporter = null;
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
		        ArrayList<BeanGenerico> fieldsReportCollection = new ArrayList<BeanGenerico>();
		        fieldsReportCollection.add(new BeanGenerico());
		        for(BeanGenerico beanGenerico:  fieldsReport) {
		        	fieldsReportCollection.add(beanGenerico);
		        }
				JRDataSource source = new JRBeanCollectionDataSource(fieldsReportCollection, true);
				parameters.put("dataSource" ,source);
				
				String webappBase = getServletContext().getRealPath("/");
				InputStream input = new FileInputStream(webappBase + 
						File.separator + "/WEB-INF/reportes/reporteGenerico_NumColumnas_"+headersReport.size()+".jasper");
				jasperPrint = JasperFillManager.fillReport(
						input, parameters, source);
				if(typeReport.equals("xls")) {
					response.setContentType("application/vnd.ms-excel");  
					exporter = new JRXlsExporter();
					baos = new ByteArrayOutputStream();
					exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
					exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos );
					exporter.setParameter(JRXlsAbstractExporterParameter.SHEET_NAMES,new String[] {nameReport});
					exporter.setParameter(JRXlsAbstractExporterParameter.CHARACTER_ENCODING, "UTF-8");
					exporter.exportReport();
				} else {
					response.setContentType("application/csv");
					baos = new ByteArrayOutputStream();
					exporter = new JRCsvExporter();
					exporter.setParameter(JRCsvExporterParameter.FIELD_DELIMITER, "\t");
					exporter.setParameter(JRCsvExporterParameter.CHARACTER_ENCODING, "UTF-8");
					exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
					exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos );
					exporter.exportReport();
				}
				byte[] bytes = baos.toByteArray();
				baos.close();
				response.setContentLength(bytes.length);
				response.setHeader("Content-Disposition", "attachment;filename= Reporte_"+
												nameReport+"_"+dateFormat.format(new Date())+"."+typeReport);
				ouputStream.write(bytes);
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
}
