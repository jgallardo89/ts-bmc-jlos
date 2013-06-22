/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Informacion Confidencial:
 * Este software contiene informacion totalmente confidencial propiedad de Grupo Financiero BBVA Bancomer. 
 * Queda totalmente prohibido su uso o divulgacion en forma parcial o total y solamente podra ser utilizada de acuerdo a los terminos y estatutos 
 * que determine el Grupo Financiero BBVA Bancomer.
 * 
 * Todos los derechos reservados, Mexico 2013.
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * DESCRIPCION DEL PROGRAMA
 * Nombre de aplicación: MAPEADOR
 * Nombre de proyecto: BbvaMapeadorEjb
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * HISTORIAL DE CAMBIOS:
 * 
 * Fecha:									         	
 * 30-ABR-2013  
 * @Author:	Jose Luis Ortiz Salazar
 * @Email: jortizsalazar@gmail.com    	
 * Razon: Creacion        
 * Version: 1.0.0
 * Nombre de clase: ClienteBO.java
 * Nombre de paquete: mx.com.bbva.bancomer.mapper.business
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.mapper.business;

import java.util.List;

import javax.ejb.Stateless;

import mappers.cliente.MapCliente;
import mx.com.bbva.bancomer.bussinnes.model.vo.ClienteVO;
import mx.com.bbva.bancomer.cliente.dto.ClienteDTO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class ClienteBO.
 */
@Stateless(mappedName = "clienteBO")
public class ClienteBO implements
		mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject {
	
	/** The Constant logger. */
	private static final org.apache.log4j.Logger logger = Logger
			.getLogger(ClienteBO.class);

	// @Autowired
	/** The bbva i data access object. */
	private mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject bbvaIDataAccessObject;

	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject#createCommand(mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject)
	 */
	@Override
	public <T extends BbvaAbstractDataTransferObject> T createCommand(
			T bbvaAbstractDataTransferObject) {		
			logger.debug( "Entrada createCommand          -- OK" );
			logger.debug( "Datos de Entrada createCommand -- " + bbvaAbstractDataTransferObject.toString() );
			ClienteVO ClienteVO = ((ClienteDTO)bbvaAbstractDataTransferObject).getClienteVO();
			SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
					.openSession();
			MapCliente mapCliente = session.getMapper(MapCliente.class);
			try {
				mapCliente.crearCliente(ClienteVO);
				session.commit();
			} catch (Exception ex) {
				session.rollback();
				ex.printStackTrace();
				bbvaAbstractDataTransferObject.setErrorCode("SQL-001");
				bbvaAbstractDataTransferObject.setErrorDescription(ex.getMessage());
			} finally {
				session.close();
			}
			logger.debug( "Datos de Salida invoke -- " + bbvaAbstractDataTransferObject.toString() );
			logger.debug( "Salida invoke          -- OK" );
			return bbvaAbstractDataTransferObject;														
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject#deleteCommand(mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject)
	 */
	@Override
	public <T extends BbvaAbstractDataTransferObject> T deleteCommand(
			T bbvaAbstractDataTransferObject) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets the bbva i data access object.
	 *
	 * @return the bbvaIDataAccessObject
	 */
	public final mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject getBbvaIDataAccessObject() {
		return bbvaIDataAccessObject;
	}

	/**
	 * Read command.
	 *
	 * @param <T> the generic type
	 * @param clienteVO the cliente vo
	 * @return the t
	 */
	public <T extends BbvaAbstractDataTransferObject> T readCommand(ClienteVO clienteVO) {
		ClienteDTO clienteDTO = new ClienteDTO();
		try {
			logger.debug("Entrada readCmbCommand -- OK");
			try {
				List<ClienteVO> result = null;
				SqlSession session = MapeadorSessionFactory
						.getSqlSessionFactory().openSession();
				MapCliente mapCliente = session.getMapper(MapCliente.class);
				try {
					clienteVO.setIdBaja(CommandConstants.ESTATUS_OBJETO_CLIENTE_BAJA);
					result = mapCliente.obtenerCmbClientes(clienteVO);
					session.commit();
				} catch (Exception ex) {
					session.rollback();
					ex.printStackTrace();
					clienteDTO.setErrorCode("SQL-001");
					clienteDTO.setErrorDescription(ex.getMessage());
				} finally {
					session.close();
				}
				clienteDTO.setClienteVOs(result);
				logger.debug("result: " + result + " -- **fin**");
				logger.debug("Datos de Salida invoke -- "
						+ clienteDTO.toString());
				logger.debug("Salida invoke          -- OK");
				return (T) clienteDTO;
			} catch (Exception ex) {
				ex.printStackTrace();
				return (T) clienteDTO;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			return (T) clienteDTO;
		}
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject#readCommand(mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject)
	 */
	@Override
	public <T extends BbvaAbstractDataTransferObject> T readCommand(
			T bbvaAbstractDataTransferObject) {
		try {
			logger.debug("Entrada createCommand          -- OK");
			logger.debug("Datos de Entrada createCommand -- "
					+ bbvaAbstractDataTransferObject.toString());
			try {
				List<ClienteVO> result = null;
				ClienteVO clienteVO = ((ClienteDTO) bbvaAbstractDataTransferObject)
						.getClienteVO();
				SqlSession session = MapeadorSessionFactory
						.getSqlSessionFactory().openSession();
				MapCliente mapCliente = session.getMapper(MapCliente.class);
				if(clienteVO!=null)
					clienteVO.setIdBaja(CommandConstants.ID_CLIENTE_BAJA);
				try {
					result = mapCliente.obtenerClientes(clienteVO);
					session.commit();
				} catch (Exception ex) {
					session.rollback();
					ex.printStackTrace();
					bbvaAbstractDataTransferObject.setErrorCode("SQL-001");
					bbvaAbstractDataTransferObject.setErrorDescription(ex.getMessage());
				} finally {
					session.close();
				}
				((ClienteDTO) bbvaAbstractDataTransferObject).setClienteVOs(result);
				logger.debug("result: " + result + " -- **fin**");
				logger.debug("Datos de Salida invoke -- "
						+ bbvaAbstractDataTransferObject.toString());
				logger.debug("Salida invoke          -- OK");
				return bbvaAbstractDataTransferObject;
			} catch (Exception ex) {
				ex.printStackTrace();
				bbvaAbstractDataTransferObject.setErrorCode("SQL-001");
				bbvaAbstractDataTransferObject.setErrorDescription(ex.getMessage());
				return bbvaAbstractDataTransferObject;				
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			return bbvaAbstractDataTransferObject;
		}
	}

	/**
	 * Sets the bbva i data access object.
	 *
	 * @param bbvaIDataAccessObject the new bbva i data access object
	 */
	public void setBbvaIDataAccessObject(
			mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject bbvaIDataAccessObject) {
		this.bbvaIDataAccessObject = bbvaIDataAccessObject;
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject#updateCommand(mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject)
	 */
	@Override
	public <T extends BbvaAbstractDataTransferObject> T updateCommand(
			T bbvaAbstractDataTransferObject) {
		logger.debug( "Entrada updateCommand          -- OK" );
		logger.debug( "Datos de Entrada updateCommand -- " + bbvaAbstractDataTransferObject.toString() );
		ClienteVO ClienteVO = ((ClienteDTO) bbvaAbstractDataTransferObject).getClienteVO();
		SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
				.openSession();
		MapCliente mapCliente = session.getMapper(MapCliente.class);
		try {
			mapCliente.actualizarCliente(ClienteVO);
			session.commit();
		} catch (Exception ex) {
			session.rollback();
			ex.printStackTrace();
			bbvaAbstractDataTransferObject.setErrorCode("SQL-001");
			bbvaAbstractDataTransferObject.setErrorDescription(ex.getMessage());
		} finally {
			session.close();
		}
		logger.debug( "Datos de Salida invoke -- " + bbvaAbstractDataTransferObject.toString() );
		logger.debug( "Salida invoke          -- OK" );
		return bbvaAbstractDataTransferObject;	
	}

}
