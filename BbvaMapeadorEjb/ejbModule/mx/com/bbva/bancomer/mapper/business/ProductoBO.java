package mx.com.bbva.bancomer.mapper.business;

import java.util.List;

import javax.ejb.Stateless;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import mappers.cliente.MapCliente;
import mappers.producto.MapProducto;
import mx.com.bbva.bancomer.bussinnes.model.vo.ClienteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ProductoVO;
import mx.com.bbva.bancomer.cliente.dto.ClienteDTO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.producto.dto.ProductoDTO;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

@Stateless(mappedName = "productoBO")
public class ProductoBO implements
		mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject {
	private static final org.apache.log4j.Logger logger = Logger
			.getLogger(ProductoBO.class);

	// @Autowired
	private mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject bbvaIDataAccessObject;

	/**
	 * @return the bbvaIDataAccessObject
	 */
	public final mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject getBbvaIDataAccessObject() {
		return bbvaIDataAccessObject;
	}

	public void setBbvaIDataAccessObject(
			mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject bbvaIDataAccessObject) {
		this.bbvaIDataAccessObject = bbvaIDataAccessObject;
	}

	@Override
	public <T extends BbvaAbstractDataTransferObject> T createCommand(
			T bbvaAbstractDataTransferObject) {		
			logger.debug( "Entrada createCommand          -- OK" );
			logger.debug( "Datos de Entrada createCommand -- " + bbvaAbstractDataTransferObject.toString() );
			ProductoVO ProductoVO = ((ProductoDTO)bbvaAbstractDataTransferObject).getProductoVO();
			SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
					.openSession();
			MapProducto mapProducto = session.getMapper(MapProducto.class);
			try {
				mapProducto.crearProducto(ProductoVO);
				session.commit();
			} catch (Exception ex) {
				session.rollback();
				ex.printStackTrace();
			} finally {
				session.close();
			}
			logger.debug( "Datos de Salida invoke -- " + bbvaAbstractDataTransferObject.toString() );
			logger.debug( "Salida invoke          -- OK" );
			return bbvaAbstractDataTransferObject;														
	}

	@Override
	public <T extends BbvaAbstractDataTransferObject> T readCommand(
			T bbvaAbstractDataTransferObject) {
		try {
			logger.debug("Entrada readCommand          -- OK");
			logger.debug("Datos de Entrada readCommand -- "
					+ bbvaAbstractDataTransferObject.toString());
			try {
				List<ProductoVO> result = null;
				ProductoVO productoVO = ((ProductoDTO) bbvaAbstractDataTransferObject)
						.getProductoVO();
				SqlSession session = MapeadorSessionFactory
						.getSqlSessionFactory().openSession();
				MapProducto mapProducto = session.getMapper(MapProducto.class);
				try {
					productoVO.setIdBaja(CommandConstants.ESTATUS_OBJETO_BAJA);
					result = mapProducto.obtenerProductos(productoVO);
					session.commit();
				} catch (Exception ex) {
					session.rollback();
					ex.printStackTrace();
				} finally {
					session.close();
				}
				((ProductoDTO) bbvaAbstractDataTransferObject).setProductoVOs(result);
				logger.debug("result: " + result + " -- **fin**");
				logger.debug("Datos de Salida invoke -- "
						+ bbvaAbstractDataTransferObject.toString());
				logger.debug("Salida invoke          -- OK");
				return bbvaAbstractDataTransferObject;
			} catch (Exception ex) {
				ex.printStackTrace();
				return bbvaAbstractDataTransferObject;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			return bbvaAbstractDataTransferObject;
		}
	}
	
	public <T extends BbvaAbstractDataTransferObject> T readCommand() {
		ProductoDTO productoDTO = new ProductoDTO();
		try {
			logger.debug("Entrada readCmbCommand -- OK");
			try {
				List<ProductoVO> result = null;
				SqlSession session = MapeadorSessionFactory
						.getSqlSessionFactory().openSession();
				MapProducto mapProducto = session.getMapper(MapProducto.class);
				try {
					result = mapProducto.obtenerCmbProductos();
					session.commit();
				} catch (Exception ex) {
					session.rollback();
					ex.printStackTrace();
				} finally {
					session.close();
				}
				productoDTO.setProductoVOs(result);
				logger.debug("result: " + result + " -- **fin**");
				logger.debug("Datos de Salida invoke -- "
						+ productoDTO.toString());
				logger.debug("Salida invoke          -- OK");
				return (T) productoDTO;
			} catch (Exception ex) {
				ex.printStackTrace();
				return (T) productoDTO;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			return (T) productoDTO;
		}
	}

	@Override
	public <T extends BbvaAbstractDataTransferObject> T updateCommand(
			T bbvaAbstractDataTransferObject) {
		logger.debug( "Entrada updateCommand          -- OK" );
		logger.debug( "Datos de Entrada updateCommand -- " + bbvaAbstractDataTransferObject.toString() );
		ProductoVO ProductoVO = ((ProductoDTO) bbvaAbstractDataTransferObject).getProductoVO();
		SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
				.openSession();
		MapProducto mapProducto = session.getMapper(MapProducto.class);
		try {
			mapProducto.actualizarProducto(ProductoVO);
			session.commit();
		} catch (Exception ex) {
			session.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		logger.debug( "Datos de Salida invoke -- " + bbvaAbstractDataTransferObject.toString() );
		logger.debug( "Salida invoke          -- OK" );
		return bbvaAbstractDataTransferObject;	
	}

	@Override
	public <T extends BbvaAbstractDataTransferObject> T deleteCommand(
			T bbvaAbstractDataTransferObject) {
		// TODO Auto-generated method stub
		return null;
	}

}
