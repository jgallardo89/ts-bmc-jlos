package mappers.perfil;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ControlPermisoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PerfilVO;

public interface MapPerfil {
	public abstract List<PerfilVO> obtenerPerfiles(PerfilVO perfilVO);
	public abstract void actualizarPerfil(PerfilVO perfilVO);
	public abstract void eliminarPermisos(ControlPermisoVO controlPermisoVO);
	public abstract void insertarPermiso(ControlPermisoVO controlPermisoVO);
	public abstract void insertarPerfil(PerfilVO perfilVO);
}
