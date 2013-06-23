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
 * Nombre de clase: PerfilBO.java
 * Nombre de paquete: mx.com.bbva.bancomer.mapper.business
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.mapper.business;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Stateless;

import mappers.componente.MapComponente;
import mappers.perfil.MapPerfil;
import mx.com.bbva.bancomer.bussinnes.model.vo.ComponenteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ControlPermisoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PerfilVO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.perfil.dto.PerfilDTO;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class PerfilBO.
 */
@Stateless(mappedName="perfilBO")
public class PerfilBO implements mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject {

	/** The Constant logger. */
	private static final org.apache.log4j.Logger logger	 = Logger.getLogger(PerfilBO.class );	
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject#createCommand(mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject)
	 */
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

	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject#readCommand(mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject)
	 */
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
				bbvaAbstractDataTransferObject.setErrorCode("SQL-001");
				bbvaAbstractDataTransferObject.setErrorDescription(ex.getMessage());
			} finally {
				session.close();
			}						
			logger.debug( "Datos de Salida invoke -- " + bbvaAbstractDataTransferObject.toString() );
			logger.debug( "Salida invoke          -- OK" );
			return bbvaAbstractDataTransferObject;
		} catch (Exception ex) {
			ex.printStackTrace();
			bbvaAbstractDataTransferObject.setErrorCode("SQL-001");
			bbvaAbstractDataTransferObject.setErrorDescription(ex.getMessage());
			return bbvaAbstractDataTransferObject;
		} 					
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject#updateCommand(mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject)
	 */
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
