package mx.com.bbva.mt101.ui.commons.viewmodel.reportes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mx.com.bbva.bancomer.canal.dto.BeanGenerico;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zkex.zul.Jasperreport;

/**
 * @author Julio Morales
 *
 */
public class ReportesController extends ControllerSupport {

	private static final long serialVersionUID = 1L;
	
	
	public void createReport(ArrayList<BeanGenerico> fieldsReport, 
			ArrayList<String> headersReport, String titleReport, Jasperreport report, String typeReport) {			
		int contador = 1;
		JRDataSource source = new JRBeanCollectionDataSource(fieldsReport, false);
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ReportTitle", titleReport);
        for(String header:headersReport) {
        	parameters.put("parameter" + contador++, header);
        }
        parameters.put("dataSource", source);
        parameters.put("imagen", "C:/Temp/workspace_map/BbvaMapeadorWeb/WebContent/WEB-INF/reportes/Bancomer.jpg");
        report.setSrc("/WEB-INF/reportes/reporteGenerico_NumColumnas_"+headersReport.size()+".jasper");
        report.setParameters(parameters);
        report.setType(typeReport);
    }
	
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
    }
}
