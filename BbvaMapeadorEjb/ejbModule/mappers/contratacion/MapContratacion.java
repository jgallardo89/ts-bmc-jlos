package mappers.contratacion;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ContratacionVO;

public abstract interface MapContratacion {
	public abstract List<ContratacionVO> obtenerContrataciones(ContratacionVO contratacionVO);
	public abstract List<ContratacionVO> obtenerContratacionEtapas(ContratacionVO contratacionVO);
	public abstract void crearContratacion(ContratacionVO contratacionVO);
	public abstract void actualizarContratacion(ContratacionVO contratacionVO);
	public abstract List<ContratacionVO> validarEstatusContratacion(ContratacionVO contratacionVO);
}
