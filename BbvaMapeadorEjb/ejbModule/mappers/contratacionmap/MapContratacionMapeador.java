package mappers.contratacionmap;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ContratacionMapVO;

public abstract interface MapContratacionMapeador {
	public abstract List<ContratacionMapVO> obtenerContratacionesMap(ContratacionMapVO contratacionMapVO);
	public abstract List<ContratacionMapVO> obtenerContratacionesEtapasMap(ContratacionMapVO contratacionMapVO);
	public abstract void crearContratacionMap(ContratacionMapVO contratacionMapVO);
	public abstract void actualizarContratacionMap(ContratacionMapVO contratacionMapVO);
	public abstract ContratacionMapVO validaMensajeContratacionMap(ContratacionMapVO contratacionMapVO);
}
