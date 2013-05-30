package mappers.monitoreoarchivos;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstadoArchivoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MonitoreoArchivosVO;

public interface MapMonitoreoArchivos {
	
	List<MonitoreoArchivosVO> obtenerMonitoreoArchivoVO(MonitoreoArchivosVO monitoreoArchivosVO); 
	List<EstadoArchivoVO> obtenerEdosArchivo(EstadoArchivoVO estadoArchivoVO); 
}
