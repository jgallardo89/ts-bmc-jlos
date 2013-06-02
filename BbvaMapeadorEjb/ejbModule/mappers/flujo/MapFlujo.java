package mappers.flujo;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.FlujoVO;

public abstract interface MapFlujo {
	public abstract List<FlujoVO> obtenerFlujos(FlujoVO flujoVO);
	public abstract void actualizarFlujo(FlujoVO flujoVO);
	public abstract List<FlujoVO> obtenerCBFlujos(FlujoVO flujoVO);
}
