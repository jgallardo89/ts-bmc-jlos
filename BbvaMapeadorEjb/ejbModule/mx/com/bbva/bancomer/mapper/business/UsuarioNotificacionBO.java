package mx.com.bbva.bancomer.mapper.business;

import java.util.List;

import javax.ejb.Stateless;

import mappers.usuarionotificacion.MapUsuarioNotificacion;
import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioNotificacionVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.usuarionotificacion.dto.UsuarioNotificacionDTO;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

@Stateless(mappedName="usuarioNotificacionBO")
public class UsuarioNotificacionBO implements mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject {
	private static final org.apache.log4j.Logger logger	 = Logger.getLogger(UsuarioBO.class );
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
					result = mapUsuarioNotificacion.obtenerUsuariosNotificacion(usuarioNotificacionVO);
					
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

	@Override
	public <T extends BbvaAbstractDataTransferObject> T deleteCommand(
			T bbvaAbstractDataTransferObject) {
		// TODO Auto-generated method stub
		return null;
	}

}
