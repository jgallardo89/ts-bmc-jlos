package mappers.perfil;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.PerfilVO;

public interface MapPerfil {
	List<PerfilVO> obtenerPerfiles(PerfilVO perfilVO);
}
