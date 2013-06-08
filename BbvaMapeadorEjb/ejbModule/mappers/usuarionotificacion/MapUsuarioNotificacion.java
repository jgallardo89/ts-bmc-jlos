package mappers.usuarionotificacion;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioNotificacionVO;

public interface MapUsuarioNotificacion {
	public abstract List<UsuarioNotificacionVO> obtenerListUsuarios(UsuarioNotificacionVO usuarioNotificacionVO);
	public abstract List<UsuarioNotificacionVO> obtenerUsuariosNotificacion(UsuarioNotificacionVO usuarioNotificacionVO);
	public abstract void crearUsuarioNotificacion(UsuarioNotificacionVO usuarioNotificacionVO);
	public abstract void actualizarUsuarioNotificacion(UsuarioNotificacionVO usuarioNotificacionVO);
	public abstract List<UsuarioNotificacionVO> validaExisteUsuario(UsuarioNotificacionVO usuarioNotificacionVO);
	public abstract List<UsuarioNotificacionVO> obtenerUsuariosNotificacionSistemaNoAsignados(UsuarioNotificacionVO usuarioNotificacionVO);
	public abstract List<UsuarioNotificacionVO> obtenerUsuariosNotificacionSistemaAsignados(UsuarioNotificacionVO usuarioNotificacionVO);
	public abstract void eliminaUsuarioMensaje(int idMensajeNotificacion);
	public abstract void insertaUsuarioMensaje(UsuarioNotificacionVO usuarioNotificacionVO);
}
