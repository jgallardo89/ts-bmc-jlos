package mx.com.bbva.bancomer.mapper.business;

import java.util.List;

import javax.ejb.Stateless;

import mappers.componente.MapComponente;
import mappers.tipocomponente.MapTipoComponente;
import mx.com.bbva.bancomer.bussinnes.model.vo.ComponenteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.TipoComponenteVO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.componente.dto.ComponenteDTO;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;


@Stateless(mappedName="componenteBO")
public class ComponenteBO implements mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject {

	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	private static final org.apache.log4j.Logger 	logger			 = Logger.getLogger(ComponenteBO.class);
	
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados	
	private mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject bbvaIDataAccessObject;

	/**
	 * @return the bbvaIDataAccessObject
	 */
	public final mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject getBbvaIDataAccessObject() {
		return bbvaIDataAccessObject;
	}
	//	Propiedades
	//	public final mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject getBbvaIDataAccessObject() 
	//		{	return bbvaIDataAccessObject;							}
	public void setBbvaIDataAccessObject( mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject bbvaIDataAccessObject )
		{	this.bbvaIDataAccessObject = bbvaIDataAccessObject;		}
	
	@Override
	public <T extends BbvaAbstractDataTransferObject> T createCommand(
			T bbvaAbstractDataTransferObject) {		
		logger.debug( "Entrada createCommand          -- OK" );
		logger.debug( "Datos de Entrada createCommand -- " + bbvaAbstractDataTransferObject.toString() );
		ComponenteVO componenteVO = ((ComponenteDTO)bbvaAbstractDataTransferObject).getComponenteVO();
		SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
				.openSession();
		MapComponente mapComponente = session
				.getMapper(MapComponente.class);
		try {
			mapComponente.crearComponente(componenteVO);
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
			logger.debug( "Entrada createCommand          -- OK" );
			logger.debug( "Datos de Entrada createCommand -- " + bbvaAbstractDataTransferObject.toString() );					
			try {
				List<ComponenteVO> componenteVOs= null;
				List<TipoComponenteVO> tipoComponenteVOs= null;
				ComponenteVO componenteVO = ((ComponenteDTO)bbvaAbstractDataTransferObject).getComponenteVO();
				SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
						.openSession();
				MapComponente mapComponente = session
						.getMapper(MapComponente.class);
				if(componenteVO != null) {
					logger.debug(":::::::::::::::::::::" + componenteVO.toString());
				}
				try {
					if(bbvaAbstractDataTransferObject.getCommandId()!=null && bbvaAbstractDataTransferObject.getCommandId().equals(CommandConstants.COMPONENTE_PANTALLA)){
						componenteVOs = mapComponente.obtenerComponentesPantalla(componenteVO);
						((ComponenteDTO)bbvaAbstractDataTransferObject).setComponentePantallaVOs(componenteVOs);
					}else if(bbvaAbstractDataTransferObject.getCommandId()!=null && bbvaAbstractDataTransferObject.getCommandId().equals(CommandConstants.COMPONENTE_PANTALLA_PERFIL)){
						componenteVOs = mapComponente.obtenerComponentesPantallaPerfil(componenteVO);
						((ComponenteDTO)bbvaAbstractDataTransferObject).setComponentePantallaPerfilVOs(componenteVOs);
					}else if(bbvaAbstractDataTransferObject.getCommandId()!=null && bbvaAbstractDataTransferObject.getCommandId().equals(CommandConstants.COMPONENTE_PANTALLA_PERFIL_ALL)){
						componenteVOs = mapComponente.obtenerComponentesPantallaPerfilAll(componenteVO);
						((ComponenteDTO)bbvaAbstractDataTransferObject).setComponentePantallaPerfilAllVOs(componenteVOs);
					}else if(bbvaAbstractDataTransferObject.getCommandId()!=null && bbvaAbstractDataTransferObject.getCommandId().equals(CommandConstants.COMPONENTE_PANTALLA_REFERENCE_PERFIL)){
						componenteVOs = mapComponente.obtenerComponentesDetallePerfil(componenteVO);
						((ComponenteDTO)bbvaAbstractDataTransferObject).setComponentePantallaPerfilAllVOs(componenteVOs);
					}else{
						MapTipoComponente mapTipoComponente = session.getMapper(MapTipoComponente.class);
						componenteVOs = mapComponente.obtenerComponentes(componenteVO);
						tipoComponenteVOs = mapTipoComponente.obtenerTiposComponentes();
						((ComponenteDTO)bbvaAbstractDataTransferObject).setComponenteVOs(componenteVOs);
						((ComponenteDTO)bbvaAbstractDataTransferObject).setTipoComponenteVOs(tipoComponenteVOs);
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
		ComponenteVO componenteVO = ((ComponenteDTO)bbvaAbstractDataTransferObject).getComponenteVO();
		SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
				.openSession();
		MapComponente mapComponente = session
				.getMapper(MapComponente.class);
		try {
			mapComponente.actualizarComponente(componenteVO);
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
		logger.debug( "Entrada deleteCommand          -- OK" );
		logger.debug( "Datos de Entrada deleteCommand -- " + bbvaAbstractDataTransferObject.toString() );
		ComponenteVO componenteVO = ((ComponenteDTO)bbvaAbstractDataTransferObject).getComponenteVO();
		SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
				.openSession();
		MapComponente mapComponente = session.getMapper(MapComponente.class);
		try {
			mapComponente.eliminarComponente(componenteVO);
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
