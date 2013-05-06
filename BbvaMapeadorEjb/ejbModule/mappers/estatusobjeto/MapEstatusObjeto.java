package mappers.estatusobjeto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;

public abstract interface MapEstatusObjeto {
	public abstract List<EstatusObjetoVO> obtenerEstatusObjeto(EstatusObjetoVO estatusObjetoVO);
}
