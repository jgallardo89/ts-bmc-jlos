package mappers.mensajesalida;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.MensajeSalidaVO;

public abstract interface MapMensajeSalida {
	public abstract List<MensajeSalidaVO> obtenerMensajesSalida(MensajeSalidaVO mensajeSalidaVO);
	public abstract void actualizarMensajeSalida(MensajeSalidaVO mensajeSalidaVO);
	public abstract void crearMensajeSalida(MensajeSalidaVO mensajeSalidaVO);
	public abstract List<MensajeSalidaVO> obtenerMensajesCmbSalida();
	public abstract MensajeSalidaVO validaMensajesSalida(MensajeSalidaVO mensajeSalidaVO);
	public abstract List<MensajeSalidaVO> obtenerMensajesSalidaUsuario();
}
