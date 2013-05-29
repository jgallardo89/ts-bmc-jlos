package mx.com.bbva.bancomer.mapper.business;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import mappers.perfil.MapPerfil;
import mappers.producto.MapProducto;
import mappers.usuario.MapUsuario;
import mx.com.bbva.bancomer.bussinnes.model.vo.ControlPermisoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PerfilVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ProductoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioVO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.PerfilDTO;
import mx.com.bbva.bancomer.estatusobjeto.dto.UsuarioDTO;
import mx.com.bbva.bancomer.producto.dto.ProductoDTO;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

@Stateless(mappedName="perfilBO")
public class PerfilBO implements mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject {

	private static final org.apache.log4j.Logger logger	 = Logger.getLogger(PerfilBO.class );	
	@Override
	public <T extends BbvaAbstractDataTransferObject> T createCommand(
			T bbvaAbstractDataTransferObject) {
		logger.debug( "Entrada createCommand          -- OK" );
		logger.debug( "Datos de Entrada createCommand -- " + bbvaAbstractDataTransferObject.toString() );
		PerfilVO perfilVO = ((PerfilDTO)bbvaAbstractDataTransferObject).getPerfilVO();
		List<ControlPermisoVO> controlPermisoVOs = perfilVO.getControlPermisoVOs();
		ControlPermisoVO controlPermisoVO;		
		SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
				.openSession();
		MapPerfil mapPerfil = session.getMapper(MapPerfil.class);
		try {
			mapPerfil.actualizarPerfil(perfilVO);
			if(controlPermisoVOs.size()>0){
				controlPermisoVO = new ControlPermisoVO();
				controlPermisoVO.setIdComponente(controlPermisoVOs.get(0).getIdComponente());
				controlPermisoVO.setIdPerfil(controlPermisoVOs.get(0).getIdPerfil());				
				mapPerfil.eliminarPermisos(controlPermisoVO);
			}
			for (ControlPermisoVO controlPermisoVO2 : controlPermisoVOs) {
				mapPerfil.insertarPermiso(controlPermisoVO2);
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
		return bbvaAbstractDataTransferObject;
	}

	@Override
	public <T extends BbvaAbstractDataTransferObject> T readCommand(
			T bbvaAbstractDataTransferObject) {
		logger.debug( "Entrada createCommand          -- OK" );
		logger.debug( "Datos de Entrada createCommand -- " + bbvaAbstractDataTransferObject.toString() );					
		try {					
			SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
					.openSession();
			MapPerfil mapPerfil = session
					.getMapper(MapPerfil.class);
			try {
				if(bbvaAbstractDataTransferObject.getCommandId()==CommandConstants.PERFIL_COMMAND_READ_ALL){
					PerfilVO perfilVO = ((PerfilDTO)bbvaAbstractDataTransferObject).getPerfilVO();
					List<PerfilVO> result = null;				
					result = mapPerfil.obtenerPerfiles(perfilVO);
					((PerfilDTO)bbvaAbstractDataTransferObject).setPerfilVOs(result);
				}
				else if(bbvaAbstractDataTransferObject.getCommandId()==CommandConstants.PERFIL_COMMAND_READ_PERMISSION){
					ControlPermisoVO controlPermisoVO = ((PerfilDTO)bbvaAbstractDataTransferObject).getControlPermisoVO();
					List<ControlPermisoVO> controlPermisoVOs =mapPerfil.obtenerPermisos(controlPermisoVO);
					HashMap<String, Boolean> result = new HashMap<String, Boolean>();							
					for (ControlPermisoVO controlPermisoVO2 : controlPermisoVOs) {
						logger.debug("controlPermisoVO2.getNombreComponente():"+controlPermisoVO2.getNombreComponente());
						result.put(controlPermisoVO2.getNombreComponente(), new Boolean(controlPermisoVO2.isPermiso()));
					}					
					((PerfilDTO)bbvaAbstractDataTransferObject).setControlPermisoVOs(result);
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
			return bbvaAbstractDataTransferObject;
		} catch (Exception ex) {
			ex.printStackTrace();
			return bbvaAbstractDataTransferObject;
		} 					
	}

	@Override
	public <T extends BbvaAbstractDataTransferObject> T updateCommand(
			T bbvaAbstractDataTransferObject) {
		logger.debug( "Entrada createCommand          -- OK" );
		logger.debug( "Datos de Entrada createCommand -- " + bbvaAbstractDataTransferObject.toString() );
		PerfilVO perfilVO = ((PerfilDTO)bbvaAbstractDataTransferObject).getPerfilVO();		
		List<ControlPermisoVO> controlPermisoVOs = perfilVO.getControlPermisoVOs();
		ControlPermisoVO controlPermisoVO;		
		SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
				.openSession();
		MapPerfil mapPerfil = session.getMapper(MapPerfil.class);
		try {
			mapPerfil.actualizarPerfil(perfilVO);
			if(controlPermisoVOs!= null){				
				if(controlPermisoVOs.size()>0){
					controlPermisoVO = new ControlPermisoVO();
					controlPermisoVO.setIdComponente(controlPermisoVOs.get(0).getIdComponente());
					controlPermisoVO.setIdPerfil(controlPermisoVOs.get(0).getIdPerfil());				
					mapPerfil.eliminarPermisos(controlPermisoVO);
				}
				for (ControlPermisoVO controlPermisoVO2 : controlPermisoVOs) {
					mapPerfil.insertarPermiso(controlPermisoVO2);
				}
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
		return bbvaAbstractDataTransferObject;
	}

	@Override
	public <T extends BbvaAbstractDataTransferObject> T deleteCommand(
			T bbvaAbstractDataTransferObject) {
		// TODO Auto-generated method stub
		return null;
	}

}
