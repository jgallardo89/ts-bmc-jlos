package mappers.componente;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ComponenteVO;

public abstract interface MapComponente {
	public abstract List<ComponenteVO> obtenerComponentes(ComponenteVO componenteVO);
	public abstract void crearComponente(ComponenteVO pantallaVO);
	public abstract void actualizarComponente(ComponenteVO componenteVO);
	public abstract void eliminarComponente(ComponenteVO componenteVO);
	public abstract List<ComponenteVO> obtenerComponentesPantalla(ComponenteVO componenteVO);
	public abstract List<ComponenteVO> obtenerComponentesPantallaPerfil(ComponenteVO componenteVO);
	public abstract List<ComponenteVO> obtenerComponentesPantallaPerfilAll(ComponenteVO componenteVO);
	public abstract List<ComponenteVO> obtenerComponentesParaEliminar(ComponenteVO componenteVO);
	public abstract List<ComponenteVO> obtenerComponentesDetallePerfil(ComponenteVO componenteVO);
	
}
