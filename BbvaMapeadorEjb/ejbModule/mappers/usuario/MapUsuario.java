package mappers.usuario;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioVO;

public interface MapUsuario {
	public abstract List<UsuarioVO> obtenerUsuarios(UsuarioVO usuarioVO);
	public abstract void crearUsuario(UsuarioVO usuarioVO);
	public abstract void actualizarUsuario(UsuarioVO usuarioVO);
}
