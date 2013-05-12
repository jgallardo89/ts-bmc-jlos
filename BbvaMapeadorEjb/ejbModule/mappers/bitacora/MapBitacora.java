package mappers.bitacora;

import java.util.List;


import mx.com.bbva.bancomer.bussinnes.model.vo.BitacoraVO;

public abstract interface MapBitacora {
	public abstract List<BitacoraVO> obtenerBitacora(BitacoraVO bitacoraVO);
	public abstract BitacoraVO obtenerDetalleBitacora(BitacoraVO bitacoraVO);
}
