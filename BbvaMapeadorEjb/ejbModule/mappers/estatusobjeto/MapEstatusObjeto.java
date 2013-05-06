package mappers.estatusobjeto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusClaveVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;

public abstract interface MapEstatusObjeto {
	public abstract List<EstatusObjetoVO> obtenerEstatusObjeto(EstatusObjetoVO estatusObjetoVO);
	public abstract List<EstatusClaveVO> obtenerEstatusClave(EstatusClaveVO estatusClaveO);
	public abstract void crearEstatusObjeto(EstatusObjetoVO estatusObjetoVO);
}
