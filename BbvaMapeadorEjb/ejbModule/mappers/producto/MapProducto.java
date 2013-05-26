package mappers.producto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ProductoVO;

public abstract interface MapProducto {
	public abstract List<ProductoVO> obtenerProductos(ProductoVO productoVO);
	public abstract void crearProducto(ProductoVO productoVO);
	public abstract void actualizarProducto(ProductoVO productoVO);
	public abstract List<ProductoVO> obtenerCmbProductos();
}
