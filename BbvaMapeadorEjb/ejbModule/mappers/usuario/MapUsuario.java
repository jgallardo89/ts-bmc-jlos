package mappers.usuario;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioVO;

public interface MapUsuario {
	List<UsuarioVO> obtenerUsuarios(UsuarioVO usuarioVO);
}
