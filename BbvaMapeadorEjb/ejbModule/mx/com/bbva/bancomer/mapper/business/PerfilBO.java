package mx.com.bbva.bancomer.mapper.business;

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
			List<PerfilVO> result = null;
			PerfilVO perfilVO = ((PerfilDTO)bbvaAbstractDataTransferObject).getPerfilVO();
			SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
					.openSession();
			MapPerfil mapPerfil = session
					.getMapper(MapPerfil.class);
			try {
				result = mapPerfil.obtenerPerfiles(perfilVO);
				session.commit();
			} catch (Exception ex) {
				session.rollback();
				ex.printStackTrace();
			} finally {
				session.close();
			}
			((PerfilDTO)bbvaAbstractDataTransferObject).setPerfilVOs(result);
			logger.debug("result: " + result + " -- **fin**");
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
