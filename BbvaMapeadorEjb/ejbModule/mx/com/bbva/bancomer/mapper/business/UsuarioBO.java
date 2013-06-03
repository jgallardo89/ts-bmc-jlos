package mx.com.bbva.bancomer.mapper.business;

import java.util.List;

import javax.ejb.Stateless;

import mappers.usuario.MapUsuario;
import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.UsuarioDTO;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

@Stateless(mappedName="usuarioBO")
public class UsuarioBO implements mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject {

	private static final org.apache.log4j.Logger logger	 = Logger.getLogger(UsuarioBO.class );	
	@Override
	public <T extends BbvaAbstractDataTransferObject> T createCommand(
			T bbvaAbstractDataTransferObject) {		
		logger.debug( "Entrada createCommand          -- OK" );
		logger.debug( "Datos de Entrada createCommand -- " + bbvaAbstractDataTransferObject.toString() );		
		UsuarioVO usuarioVO = ((UsuarioDTO)bbvaAbstractDataTransferObject).getUsuarioVO();
		String userName = usuarioVO.getNombreUsuario();	
		int idPerfil = usuarioVO.getIdPerfil();		
		int idEstatus = usuarioVO.getEstatusUsuario();
		usuarioVO = readCommand(usuarioVO);
		((UsuarioDTO)bbvaAbstractDataTransferObject).getUsuarioVO().setIdPerfil(idPerfil);
		((UsuarioDTO)bbvaAbstractDataTransferObject).getUsuarioVO().setNombreUsuario(userName);
		((UsuarioDTO)bbvaAbstractDataTransferObject).getUsuarioVO().setEstatusUsuario(idEstatus);		
		if(usuarioVO == null){
			SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
					.openSession();
			MapUsuario mapUsuario = session.getMapper(MapUsuario.class);
			try {
				mapUsuario.crearUsuario(((UsuarioDTO)bbvaAbstractDataTransferObject).getUsuarioVO());
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
		logger.debug( "Entrada createCommand          -- OK" );
		logger.debug( "Datos de Entrada createCommand -- " + bbvaAbstractDataTransferObject.toString() );					
		try {
			List<UsuarioVO> result = null;
			UsuarioVO usuarioVO = ((UsuarioDTO)bbvaAbstractDataTransferObject).getUsuarioVO();
			SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
					.openSession();
			MapUsuario mapUsuario = session
					.getMapper(MapUsuario.class);
			if(usuarioVO != null && usuarioVO.getIdCveUsuario() != null) {
				logger.debug(":::::::::::::::::::::" + usuarioVO.getIdCveUsuario());
			}
			try {
				result = mapUsuario.obtenerUsuarios(usuarioVO);
				
				session.commit();
			} catch (Exception ex) {
				session.rollback();
				ex.printStackTrace();
			} finally {
				session.close();
			}
			((UsuarioDTO)bbvaAbstractDataTransferObject).setUsuarioVOs(result);
			logger.debug("result: " + result + " -- **fin**");
			logger.debug( "Datos de Salida invoke -- " + bbvaAbstractDataTransferObject.toString() );
			logger.debug( "Salida invoke          -- OK" );
			return bbvaAbstractDataTransferObject;
		} catch (Exception ex) {
			ex.printStackTrace();
			return bbvaAbstractDataTransferObject;
		} 					
	}
	
	private  UsuarioVO readCommand(
			UsuarioVO usuarioVO) {
		logger.debug( "Entrada createCommand          -- OK" );
		usuarioVO.setIdPerfil(null);
		usuarioVO.setNombreUsuario(null);
		usuarioVO.setEstatusUsuario(null);
		logger.debug( "Datos de Entrada createCommand -- " + usuarioVO.toString() );
		UsuarioVO result = null;
		try {					
			SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
					.openSession();
			MapUsuario mapUsuario = session
					.getMapper(MapUsuario.class);
			if(usuarioVO != null && usuarioVO.getIdCveUsuario() != null) {
				logger.debug(":::::::::::::::::::::" + usuarioVO.getIdCveUsuario());
			}
			try {				
				result = mapUsuario.obtenerUsuarios(usuarioVO).get(0);		
			} catch (Exception ex) {
				result = null;				
			} finally {
				session.close();
			}
			
			logger.debug("result: " + result + " -- **fin**");			
			logger.debug( "Salida invoke          -- OK" );
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} 					
	}

	public List<UsuarioVO> readCommand() {
		logger.debug( "Entrada createCommand          -- OK" );
		List<UsuarioVO> result = null;
		try {					
			SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
					.openSession();
			MapUsuario mapUsuario = session
					.getMapper(MapUsuario.class);
			try {
				result = mapUsuario.obtenerUsuariosBitacora();
			} catch (Exception ex) {
				
				ex.printStackTrace();
			} finally {
				session.close();
			}
			
			logger.debug("result: " + result + " -- **fin**");
			logger.debug( "Datos de Salida invoke -- " + result.toString() );
			logger.debug( "Salida invoke          -- OK" );
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} 					
	}
	
	@Override
	public <T extends BbvaAbstractDataTransferObject> T updateCommand(
			T bbvaAbstractDataTransferObject) {
		logger.debug( "Entrada updateCommand          -- OK" );
		logger.debug( "Datos de Entrada updateCommand -- " + bbvaAbstractDataTransferObject.toString() );
		UsuarioVO usuarioVO = ((UsuarioDTO)bbvaAbstractDataTransferObject).getUsuarioVO();
		SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
				.openSession();
		MapUsuario mapUsuario = session.getMapper(MapUsuario.class);		
		String userName = usuarioVO.getNombreUsuario();	
		int idPerfil = usuarioVO.getIdPerfil();		
		int idEstatus = usuarioVO.getEstatusUsuario();
		usuarioVO = readCommand(usuarioVO);
		((UsuarioDTO)bbvaAbstractDataTransferObject).getUsuarioVO().setIdPerfil(idPerfil);
		((UsuarioDTO)bbvaAbstractDataTransferObject).getUsuarioVO().setNombreUsuario(userName);
		((UsuarioDTO)bbvaAbstractDataTransferObject).getUsuarioVO().setEstatusUsuario(idEstatus);		
		if(usuarioVO == null){
			try {				
				mapUsuario.actualizarUsuario(((UsuarioDTO)bbvaAbstractDataTransferObject).getUsuarioVO());
				session.commit();
			} catch (Exception ex) {
				session.rollback();
				ex.printStackTrace();
			} finally {
				session.close();
			}
		}else{
			bbvaAbstractDataTransferObject.setErrorCode("0001");
			bbvaAbstractDataTransferObject.setErrorDescription("El usuario ya existe");
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
