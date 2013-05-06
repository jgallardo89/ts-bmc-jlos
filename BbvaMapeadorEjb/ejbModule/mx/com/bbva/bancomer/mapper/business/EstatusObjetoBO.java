package mx.com.bbva.bancomer.mapper.business;

import java.util.List;

import javax.ejb.Stateless;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import mappers.estatusobjeto.MapEstatusObjeto;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusClaveVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PantallaVO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject;
import mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;


@Stateless(mappedName="estatusObjetoBO")
public class EstatusObjetoBO implements mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject {
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	private static final org.apache.log4j.Logger 	logger			 = Logger.getLogger(EstatusObjetoBO.class);
	
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
			EstatusObjetoVO estatusObjetoVO = ((EstatusObjetoDTO)bbvaAbstractDataTransferObject).getEstatusObjetoVO();
			SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
					.openSession();
			MapEstatusObjeto mapEstatusObjeto = session.getMapper(MapEstatusObjeto.class);
			try {
				mapEstatusObjeto.crearEstatusObjeto(estatusObjetoVO);
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
			
//			switch (bbvaAbstractDataTransferObject.getCommandId()) {
//				case CommandConstants.ESTATUS_OBJETO_COMBO_PANTALLAS:
//					String SPRINGFILEPATH		= "C:/Bancomer/workspace_map/BbvaMapeadorWeb/WebContent/WEB-INF/config/db-config.xml";
//					ApplicationContext 	applicationContext = new FileSystemXmlApplicationContext( SPRINGFILEPATH );
//					BbvaIDataAccessObject bbvaIDataAccessObject = (BbvaIDataAccessObject)applicationContext.getBean( "bbvaMyBatisDAO" );					
//					List<PantallaVO> pantallaVOs = bbvaIDataAccessObject.queryForList("ConsultarCatalogoMapper|readPantallaVO");
//					((EstatusObjetoDTO)bbvaAbstractDataTransferObject).setPantallaVOs(pantallaVOs);
//					break;	
//				default:
//					break;
//			}
			SqlSession session;
			MapEstatusObjeto mapEstatusObjeto;
			switch (bbvaAbstractDataTransferObject.getCommandId()) {
				case CommandConstants.ESTATUS_OBJETO:					
					List<EstatusObjetoVO> estatusObjetoVOs = null;
					EstatusObjetoVO estatusObjetoVO = ((EstatusObjetoDTO)bbvaAbstractDataTransferObject).getEstatusObjetoVO();					
					session = MapeadorSessionFactory.getSqlSessionFactory()
							.openSession();
					mapEstatusObjeto = session
							.getMapper(MapEstatusObjeto.class);
					try {
						estatusObjetoVOs = mapEstatusObjeto.obtenerEstatusObjeto(estatusObjetoVO);					
					} catch (Exception ex) {
						ex.printStackTrace();
						return bbvaAbstractDataTransferObject;
					} finally {
						session.close();
					}
					((EstatusObjetoDTO)bbvaAbstractDataTransferObject).setEstatusObjetoVOs(estatusObjetoVOs);
					logger.debug("result: " + estatusObjetoVOs + " -- **fin**");
					logger.debug( "Datos de Salida invoke -- " + bbvaAbstractDataTransferObject.toString() );
					logger.debug( "Salida invoke          -- OK" );
					return bbvaAbstractDataTransferObject;
				case CommandConstants.ESTATUS_CLAVE:					
					List<EstatusClaveVO> estatusClaveVOs = null;
					EstatusClaveVO estatusClaveVO = ((EstatusObjetoDTO)bbvaAbstractDataTransferObject).getEstatusClaveVO();					
					session = MapeadorSessionFactory.getSqlSessionFactory()
							.openSession();
					mapEstatusObjeto = session
							.getMapper(MapEstatusObjeto.class);
					try {
						estatusClaveVOs = mapEstatusObjeto.obtenerEstatusClave(estatusClaveVO);					
					} catch (Exception ex) {
						ex.printStackTrace();
						return bbvaAbstractDataTransferObject;
					} finally {
						session.close();
					}
					((EstatusObjetoDTO)bbvaAbstractDataTransferObject).setEstatusClaveVOs(estatusClaveVOs);
					logger.debug("result: " + estatusClaveVOs + " -- **fin**");
					logger.debug( "Datos de Salida invoke -- " + bbvaAbstractDataTransferObject.toString() );
					logger.debug( "Salida invoke          -- OK" );
					return bbvaAbstractDataTransferObject;
				default:
					return bbvaAbstractDataTransferObject;
			}
	}

	@Override
	public <T extends BbvaAbstractDataTransferObject> T updateCommand(
			T bbvaAbstractDataTransferObject) {
		logger.debug( "Entrada updateCommand          -- OK" );
		logger.debug( "Datos de Entrada updateCommand -- " + bbvaAbstractDataTransferObject.toString() );
		EstatusObjetoVO estatusObjetoVO = ((EstatusObjetoDTO)bbvaAbstractDataTransferObject).getEstatusObjetoVO();
		SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
				.openSession();
		MapEstatusObjeto mapEstatusObjeto = session.getMapper(MapEstatusObjeto.class);
		try {
			mapEstatusObjeto.actualizarEstatusObjeto(estatusObjetoVO);
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
		EstatusObjetoVO estatusObjetoVO = ((EstatusObjetoDTO)bbvaAbstractDataTransferObject).getEstatusObjetoVO();
		SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
				.openSession();
		MapEstatusObjeto mapEstatusObjeto = session.getMapper(MapEstatusObjeto.class);
		try {
			mapEstatusObjeto.eliminarEstatusObjeto(estatusObjetoVO);
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
