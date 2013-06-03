package mx.com.bbva.bancomer.mapper.business;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import mappers.componente.MapComponente;
import mappers.perfil.MapPerfil;
import mappers.producto.MapProducto;
import mappers.usuario.MapUsuario;
import mx.com.bbva.bancomer.bussinnes.model.vo.ComponenteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ControlPermisoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PerfilVO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.perfil.dto.PerfilDTO;
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
		SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
				.openSession();
		MapPerfil mapPerfil = session.getMapper(MapPerfil.class);
		try {
			mapPerfil.insertarPerfil(perfilVO);				
			if(perfilVO.getIdPerfilACopiar()!=null){
				MapComponente mapComponente = session.getMapper(MapComponente.class);				
				ComponenteVO componenteVO = new ComponenteVO();
				componenteVO.setIdPerfil(perfilVO.getIdPerfilACopiar());
				List<ComponenteVO> componenteVOs = mapComponente.obtenerComponentesPantallaPerfilAll(componenteVO);
				ControlPermisoVO controlPermisoVO;
				for (ComponenteVO componenteVO2 : componenteVOs) {
					controlPermisoVO = new ControlPermisoVO();
					controlPermisoVO.setIdComponente(componenteVO2.getIdComponente());
					controlPermisoVO.setIdPerfil(perfilVO.getIdPerfil());
					mapPerfil.insertarPermiso(controlPermisoVO);
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
		SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
				.openSession();
		MapPerfil mapPerfil = session.getMapper(MapPerfil.class);
		try {
			mapPerfil.actualizarPerfil(perfilVO);
			logger.debug("controlPermisoVOs:"+controlPermisoVOs);
			if(controlPermisoVOs!= null){				
				
				ComponenteVO componenteVO = new ComponenteVO();
				List<ComponenteVO> componenteVOs = null;
				componenteVO.setIdPantalla(perfilVO.getIdPantalla());				
				MapComponente mapComponente = session.getMapper(MapComponente.class);
				componenteVOs = mapComponente.obtenerComponentesParaEliminar(componenteVO);
				ControlPermisoVO controlPermisoVO;
				for (ComponenteVO componenteVOToDelete : componenteVOs) {
					controlPermisoVO = new ControlPermisoVO();
					controlPermisoVO.setIdComponente(componenteVOToDelete.getIdComponente());
					controlPermisoVO.setIdPerfil(perfilVO.getIdPerfil());
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
