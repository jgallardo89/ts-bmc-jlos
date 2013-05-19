package mappers.usuarionotificacion;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioNotificacionVO; 

public interface MapUsuarioNotificacion {
	public abstract List<UsuarioNotificacionVO> obtenerUsuariosNotificacion(UsuarioNotificacionVO usuarioNotificacionVO);
	public abstract void crearUsuarioNotificacion(UsuarioNotificacionVO usuarioNotificacionVO);
	public abstract void actualizarUsuarioNotificacion(UsuarioNotificacionVO usuarioNotificacionVO); 
}