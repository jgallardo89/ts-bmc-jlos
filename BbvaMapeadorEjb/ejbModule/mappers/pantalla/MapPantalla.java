package mappers.pantalla;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PantallaVO;

public abstract interface MapPantalla {
	public abstract List<PantallaVO> obtenerPantallas(PantallaVO pantallaVO);
}
