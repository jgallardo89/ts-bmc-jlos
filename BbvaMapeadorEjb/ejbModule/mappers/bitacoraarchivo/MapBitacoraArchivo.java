package mappers.bitacoraarchivo;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.BitacoraArchivoVO;

public interface MapBitacoraArchivo { 
	public abstract List<BitacoraArchivoVO> obtenerBitacoraArchivos(BitacoraArchivoVO bitacoraArchivoVO);
}
