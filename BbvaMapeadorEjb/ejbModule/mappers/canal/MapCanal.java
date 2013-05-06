package mappers.canal;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.CanalVO;

public abstract interface MapCanal {
	public abstract List<CanalVO> obtenerCanales(CanalVO canalVO);
	public abstract void crearCanal(CanalVO canalVO);
	public abstract void actualizarCanal(CanalVO canalVO);
}
