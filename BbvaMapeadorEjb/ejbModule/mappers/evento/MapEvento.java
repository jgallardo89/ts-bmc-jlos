package mappers.evento;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EventoMapeadorVO;

public abstract interface MapEvento {
	public abstract List<EventoMapeadorVO> obtenerEventoMapeador();
}
