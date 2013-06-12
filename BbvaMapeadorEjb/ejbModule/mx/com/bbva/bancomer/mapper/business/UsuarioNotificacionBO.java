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
 * Nombre de clase: UsuarioNotificacionBO.java
 * Nombre de paquete: mx.com.bbva.bancomer.mapper.business
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.mapper.business;

import java.util.List;

import javax.ejb.Stateless;

import mappers.usuarionotificacion.MapUsuarioNotificacion;
import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioNotificacionVO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.contratacion.dto.ContratacionDTO;
import mx.com.bbva.bancomer.usuarionotificacion.dto.UsuarioNotificacionDTO;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioNotificacionBO.
 */
@Stateless(mappedName = "usuarioNotificacionBO")
public class UsuarioNotificacionBO implements
		mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject {
	
	/** The Constant logger. */
	private static final org.apache.log4j.Logger logger = Logger
			.getLogger(UsuarioNotificacionBO.class);

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
		UsuarioNotificacionVO usuarioNotificacionVO = ((UsuarioNotificacionDTO)bbvaAbstractDataTransferObject).getUsuarioNotificacionVO();		
		if(usuarioNotificacionVO != null){
			SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
					.openSession();
			MapUsuarioNotificacion mapUsuarioNotificacion = session.getMapper(MapUsuarioNotificacion.class);
			try {
				mapUsuarioNotificacion.crearUsuarioNotificacion(usuarioNotificacionVO);
				session.commit();
			} catch (Exception ex) {
				session.rollback();
				ex.printStackTrace();
			} finally {
				session.close();
			}
			logger.debug( "Datos de Salida invoke -- " + bbvaAbstractDataTransferObject.toString() );
			logger.debug( "Salida invoke          -- OK" );
		}else{
			bbvaAbstractDataTransferObject.setErrorCode("0001");
			bbvaAbstractDataTransferObject.setErrorDescription("El usuario ya existe");
		}			
		return bbvaAbstractDataTransferObject;	
	}

	/**
	 * Creates the command usuario notificacion.
	 *
	 * @param <T> the generic type
	 * @param bbvaAbstractDataTransferObject the bbva abstract data transfer object
	 * @return the t
	 */
	public <T extends BbvaAbstractDataTransferObject> T createCommandUsuarioNotificacion(T bbvaAbstractDataTransferObject) {		
		logger.debug( "Entrada createCommand          -- OK" );
		logger.debug( "Datos de Entrada createCommand -- " + bbvaAbstractDataTransferObject.toString() );		
		List<UsuarioNotificacionVO> usuarioNotificacionVOs = ((UsuarioNotificacionDTO)bbvaAbstractDataTransferObject).getUsuarioNotificacionVOs();		
		if(usuarioNotificacionVOs != null){
			SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
					.openSession();
			MapUsuarioNotificacion mapUsuarioNotificacion = session.getMapper(MapUsuarioNotificacion.class);
			try {
				mapUsuarioNotificacion.eliminaUsuarioMensaje(((UsuarioNotificacionDTO)bbvaAbstractDataTransferObject).getIdMensajeNotificacion());
				for (UsuarioNotificacionVO usuarioNotificacionVO : usuarioNotificacionVOs) {
					usuarioNotificacionVO.setIdMensajeNotificacion(((UsuarioNotificacionDTO)bbvaAbstractDataTransferObject).getIdMensajeNotificacion());
					mapUsuarioNotificacion.insertaUsuarioMensaje(usuarioNotificacionVO);
				}
				session.commit();
			} catch (Exception ex) {
				session.rollback();
				ex.printStackTrace();
			} finally {
				session.close();
			}
			logger.debug( "Datos de Salida invoke -- " + bbvaAbstractDataTransferObject.toString() );
			logger.debug( "Salida invoke          -- OK" );
		}else{
			bbvaAbstractDataTransferObject.setErrorCode("0001");
			bbvaAbstractDataTransferObject.setErrorDescription("El usuario ya existe");
		}			
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
	 * @param idUsuarios the id usuarios
	 * @return the t
	 */
	public <T extends BbvaAbstractDataTransferObject> T readCommand(int[] idUsuarios) {
		ContratacionDTO contratacionDTO = new ContratacionDTO();
		try {
			logger.debug("Entrada readCmbCommand -- OK");
			try {
				UsuarioNotificacionVO usuarioNotificacionVO = new UsuarioNotificacionVO();
				List<UsuarioNotificacionVO> result = null;
				SqlSession session = MapeadorSessionFactory
						.getSqlSessionFactory().openSession();
				MapUsuarioNotificacion mapUsuarioNotificacion = session.getMapper(MapUsuarioNotificacion.class);
				try {
					usuarioNotificacionVO.setIdUsuarios(idUsuarios);					
					result = mapUsuarioNotificacion.obtenerListUsuarios(usuarioNotificacionVO);
					session.commit();
				} catch (Exception ex) {
					session.rollback();
					ex.printStackTrace();
				} finally {
					session.close();
				}
				contratacionDTO.setUsuarioNotificacionVOs(result);
				logger.debug("result: " + result + " -- **fin**");
				logger.debug("Datos de Salida invoke -- "
						+ contratacionDTO.toString());
				logger.debug("Salida invoke          -- OK");
				return (T) contratacionDTO;
			} catch (Exception ex) {
				ex.printStackTrace();
				return (T) contratacionDTO;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			return (T) contratacionDTO;
		}
	}
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject#readCommand(mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject)
	 */
	@Override
	public <T extends BbvaAbstractDataTransferObject> T readCommand(
			T bbvaAbstractDataTransferObject) {
		try {
			logger.debug( "Entrada createCommand          -- OK" );
			logger.debug( "Datos de Entrada createCommand -- " + bbvaAbstractDataTransferObject.toString() );					
			try {
				List<UsuarioNotificacionVO> result = null;
				UsuarioNotificacionVO usuarioNotificacionVO = ((UsuarioNotificacionDTO)bbvaAbstractDataTransferObject).getUsuarioNotificacionVO();
				SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
						.openSession();
				MapUsuarioNotificacion mapUsuarioNotificacion = session
						.getMapper(MapUsuarioNotificacion.class);
				if(usuarioNotificacionVO != null) {
					logger.debug(":::::::::::::::::::::" + usuarioNotificacionVO.toString());
				}
				try {
					if(bbvaAbstractDataTransferObject.getCommandId()==CommandConstants.CONSULTA_USUARIOS_NO_ASIGNADOS){
						logger.debug("Obteniendo CONSULTA_USUARIOS_NO_ASIGNADOS ......");
						result = mapUsuarioNotificacion.obtenerUsuariosNotificacionSistemaNoAsignados(usuarioNotificacionVO);
					}else if(bbvaAbstractDataTransferObject.getCommandId()==CommandConstants.CONSULTA_USUARIOS_ASIGNADOS){
						logger.debug("Obteniendo CONSULTA_USUARIOS_ASIGNADOS ......");
						result = mapUsuarioNotificacion.obtenerUsuariosNotificacionSistemaAsignados(usuarioNotificacionVO);
					}else{
						result = mapUsuarioNotificacion.obtenerUsuariosNotificacion(usuarioNotificacionVO);
					}
					session.commit();
				} catch (Exception ex) {
					session.rollback();
					ex.printStackTrace();
				} finally {
					session.close();
				}
				((UsuarioNotificacionDTO)bbvaAbstractDataTransferObject).setUsuarioNotificacionVOs(result); 
				logger.debug("result: " + result + " -- **fin**");
				logger.debug( "Datos de Salida invoke -- " + bbvaAbstractDataTransferObject.toString() );
				logger.debug( "Salida invoke          -- OK" );
				return bbvaAbstractDataTransferObject;
			} catch (Exception ex) {
				ex.printStackTrace();
				return bbvaAbstractDataTransferObject;
			} 					
		} 
		catch ( Exception exception ) 
		{
			exception.printStackTrace();
			return bbvaAbstractDataTransferObject;
		}
	}
	
	/**
	 * Read command validate exist.
	 *
	 * @param <T> the generic type
	 * @param bbvaAbstractDataTransferObject the bbva abstract data transfer object
	 * @return the t
	 */
	public <T extends BbvaAbstractDataTransferObject> T readCommandValidateExist(
			T bbvaAbstractDataTransferObject) {
		try {
			logger.debug( "Entrada createCommand          -- OK" );
			logger.debug( "Datos de Entrada createCommand -- " + bbvaAbstractDataTransferObject.toString() );					
			try {
				List<UsuarioNotificacionVO> result = null;
				UsuarioNotificacionVO usuarioNotificacionVO = ((UsuarioNotificacionDTO)bbvaAbstractDataTransferObject).getUsuarioNotificacionVO();
				SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
						.openSession();
				MapUsuarioNotificacion mapUsuarioNotificacion = session
						.getMapper(MapUsuarioNotificacion.class);
				if(usuarioNotificacionVO != null) {
					logger.debug(":::::::::::::::::::::" + usuarioNotificacionVO.toString());
				}
				try {
					result = mapUsuarioNotificacion.validaExisteUsuario(usuarioNotificacionVO);
					
					session.commit();
				} catch (Exception ex) {
					session.rollback();
					ex.printStackTrace();
				} finally {
					session.close();
				}
				((UsuarioNotificacionDTO)bbvaAbstractDataTransferObject).setUsuarioNotificacionVOs(result); 
				logger.debug("result: " + result + " -- **fin**");
				logger.debug( "Datos de Salida invoke -- " + bbvaAbstractDataTransferObject.toString() );
				logger.debug( "Salida invoke          -- OK" );
				return bbvaAbstractDataTransferObject;
			} catch (Exception ex) {
				ex.printStackTrace();
				return bbvaAbstractDataTransferObject;
			} 					
		} 
		catch ( Exception exception ) 
		{
			exception.printStackTrace();
			return bbvaAbstractDataTransferObject;
		}
	}
	
	/**
	 * Read command validate existe permiso.
	 *
	 * @param <T> the generic type
	 * @param bbvaAbstractDataTransferObject the bbva abstract data transfer object
	 * @return the t
	 */
	public <T extends BbvaAbstractDataTransferObject> T readCommandValidateExistePermiso(
			T bbvaAbstractDataTransferObject) {
		try {
			logger.debug( "Entrada createCommand          -- OK" );
			logger.debug( "Datos de Entrada createCommand -- " + bbvaAbstractDataTransferObject.toString() );					
			try {
				List<UsuarioNotificacionVO> result = null;
				UsuarioNotificacionVO usuarioNotificacionVO = ((UsuarioNotificacionDTO)bbvaAbstractDataTransferObject).getUsuarioNotificacionVO();
				SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
						.openSession();
				MapUsuarioNotificacion mapUsuarioNotificacion = session
						.getMapper(MapUsuarioNotificacion.class);
				if(usuarioNotificacionVO != null) {
					logger.debug(":::::::::::::::::::::" + usuarioNotificacionVO.toString());
				}
				try {
					result = mapUsuarioNotificacion.existeUsuario(usuarioNotificacionVO);
					
					session.commit();
				} catch (Exception ex) {
					session.rollback();
					ex.printStackTrace();
				} finally {
					session.close();
				}
				((UsuarioNotificacionDTO)bbvaAbstractDataTransferObject).setUsuarioNotificacionVOs(result); 
				logger.debug("result: " + result + " -- **fin**");
				logger.debug( "Datos de Salida invoke -- " + bbvaAbstractDataTransferObject.toString() );
				logger.debug( "Salida invoke          -- OK" );
				return bbvaAbstractDataTransferObject;
			} catch (Exception ex) {
				ex.printStackTrace();
				return bbvaAbstractDataTransferObject;
			} 					
		} 
		catch ( Exception exception ) 
		{
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
		UsuarioNotificacionVO usuarioNotificacionVO = ((UsuarioNotificacionDTO)bbvaAbstractDataTransferObject).getUsuarioNotificacionVO();
		SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
				.openSession();
		MapUsuarioNotificacion mapUsuarioNotificacion = session
				.getMapper(MapUsuarioNotificacion.class);
		try {
			mapUsuarioNotificacion.actualizarUsuarioNotificacion(usuarioNotificacionVO);
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

}
