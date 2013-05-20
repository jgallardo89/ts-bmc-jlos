package mappers.estadistico;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstadisticoVO;

public interface MapEstadistico {
	
	List<EstadisticoVO> obtenerEstadisticoVO(EstadisticoVO estadisticoVO);
}
