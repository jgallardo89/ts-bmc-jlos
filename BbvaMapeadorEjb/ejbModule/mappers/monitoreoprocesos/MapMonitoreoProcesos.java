package mappers.monitoreoprocesos;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EdoArchivoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MonitoreoProcesosVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.RegistroProcesoVO;

public interface MapMonitoreoProcesos {
	
	List<MonitoreoProcesosVO> obtenerMonitoreoProcesosVO(MonitoreoProcesosVO monitoreoProcesosVO);
	List<RegistroProcesoVO> obtenerRegistrosProceso(RegistroProcesoVO registroPorcesoVO);
	List<EdoArchivoVO> obtenerEdosArchivoVO(EdoArchivoVO edoArchivoVO);
	void actualizarEstatusProceso(MonitoreoProcesosVO monitoreoProcesosVO);
}
