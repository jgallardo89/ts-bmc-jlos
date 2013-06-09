package mappers.tipocomponente;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.PantallaVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.TipoComponenteVO;

public abstract interface MapTipoComponente {
	public abstract List<TipoComponenteVO> obtenerTiposComponentes();
	public abstract void crearTipoComponente(TipoComponenteVO tipoComponenteVO);
	public abstract void actualizarTipoComponente(TipoComponenteVO tipoComponenteVO);
}
