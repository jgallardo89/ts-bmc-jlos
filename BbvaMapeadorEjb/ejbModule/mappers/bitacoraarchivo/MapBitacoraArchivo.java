package mappers.bitacoraarchivo;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.BitacoraArchivoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstadoArchivoVO;

public interface MapBitacoraArchivo { 
	public abstract List<BitacoraArchivoVO> obtenerBitacoraArchivos(BitacoraArchivoVO bitacoraArchivoVO);
	public abstract List<EstadoArchivoVO> obtenerEstadosArchivos();
}
