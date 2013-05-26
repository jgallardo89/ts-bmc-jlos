package mappers.mapagmm;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.MapaGmmVO;

public interface MapMapaGmm {
	public abstract List<MapaGmmVO> obtenerMapaGmms(MapaGmmVO mapaGmmVO);
	public abstract void crearMapaGmm(MapaGmmVO mapaGmmVO);
	public abstract void actualizarMapaGmm(MapaGmmVO mapaGmmVO);
	public abstract List<MapaGmmVO> obtenerCmbMapaGmms();
}
