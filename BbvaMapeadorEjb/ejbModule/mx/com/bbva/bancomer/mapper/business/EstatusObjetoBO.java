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
 * Nombre de clase: EstatusObjetoBO.java
 * Nombre de paquete: mx.com.bbva.bancomer.mapper.business
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.mapper.business;

import java.util.List;

import javax.ejb.Stateless;

import mappers.estatusobjeto.MapEstatusObjeto;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusClaveVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;


// TODO: Auto-generated Javadoc
/**
 * The Class EstatusObjetoBO.
 */
@Stateless(mappedName="estatusObjetoBO")
public class EstatusObjetoBO implements mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject {
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	/** The Constant logger. */
	private static final org.apache.log4j.Logger 	logger			 = Logger.getLogger(EstatusObjetoBO.class);
	
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados	
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
		logger.debug( "Entrada deleteCommand          -- OK" );
		logger.debug( "Datos de Entrada deleteCommand -- " + bbvaAbstractDataTransferObject.toString() );
		EstatusObjetoVO estatusObjetoVO = ((EstatusObjetoDTO)bbvaAbstractDataTransferObject).getEstatusObjetoVO();
		SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
				.openSession();
		MapEstatusObjeto mapEstatusObjeto = session.getMapper(MapEstatusObjeto.class);
		try {
			logger.debug("revisando id:"+estatusObjetoVO.getIdEstatusObjeto());
			EstatusObjetoVO estatusObjetoVOexist = mapEstatusObjeto.existEstatusObjeto(estatusObjetoVO);
			logger.debug("revisando si nulo:"+estatusObjetoVOexist);
			if(estatusObjetoVOexist==null){				
				mapEstatusObjeto.eliminarEstatusObjeto(estatusObjetoVO);
			}
			else{ 
				bbvaAbstractDataTransferObject.setErrorCode("0002");
				bbvaAbstractDataTransferObject.setErrorDescription("El registro contiene referencias por lo que no pudo ser eliminado");
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
	
	/**
	 * Gets the bbva i data access object.
	 *
	 * @return the bbvaIDataAccessObject
	 */
	public final mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject getBbvaIDataAccessObject() {
		return bbvaIDataAccessObject;
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject#readCommand(mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject)
	 */
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
					logger.debug("estatusObjetoVO--nombreTabla:"+estatusObjetoVO);
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
				case CommandConstants.NOMBRE_PANTALLA:
					estatusObjetoVOs = null;
					session = MapeadorSessionFactory.getSqlSessionFactory().openSession();
					mapEstatusObjeto = session.getMapper(MapEstatusObjeto.class);
					try {
						estatusObjetoVOs = mapEstatusObjeto.obtenerNombreTabla();					
					} catch (Exception ex) {
						ex.printStackTrace();
						return bbvaAbstractDataTransferObject;
					} finally {
						session.close();
					}
					((EstatusObjetoDTO)bbvaAbstractDataTransferObject).setEstatusObjetoPantallaVOs(estatusObjetoVOs);
					logger.debug("result: " + estatusObjetoVOs + " -- **fin**");
					logger.debug( "Datos de Salida invoke -- " + bbvaAbstractDataTransferObject.toString() );
					logger.debug( "Salida invoke          -- OK" );
					return bbvaAbstractDataTransferObject;
				default:
					return bbvaAbstractDataTransferObject;
			}
	}

	//	Propiedades
	//	public final mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject getBbvaIDataAccessObject() 
	//		{	return bbvaIDataAccessObject;							}
	/**
	 * Sets the bbva i data access object.
	 *
	 * @param bbvaIDataAccessObject the new bbva i data access object
	 */
	public void setBbvaIDataAccessObject( mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject bbvaIDataAccessObject )
		{	this.bbvaIDataAccessObject = bbvaIDataAccessObject;		}

	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject#updateCommand(mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject)
	 */
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
			mapEstatusObjeto.actualizaEstatusObjeto(estatusObjetoVO);
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
