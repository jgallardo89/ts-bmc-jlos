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
 * Nombre de clase: ContratacionMapeadorBO.java
 * Nombre de paquete: mx.com.bbva.bancomer.mapper.business
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.mapper.business;

import java.util.List;

import javax.ejb.Stateless;

import mappers.contratacionmap.MapContratacionMapeador;
import mx.com.bbva.bancomer.bussinnes.model.vo.ContratacionMapVO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.contratacionmap.dto.ContratacionMapDTO;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class ContratacionMapeadorBO.
 */
@Stateless(mappedName = "contratacionMapeadorBO")
public class ContratacionMapeadorBO implements
		mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject {
	
	/** The Constant logger. */
	private static final org.apache.log4j.Logger logger = Logger
			.getLogger(ContratacionMapeadorBO.class);

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
			ContratacionMapVO contratacionMapVO = ((ContratacionMapDTO)bbvaAbstractDataTransferObject).getContratacionMapVO();
			SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
					.openSession();
			MapContratacionMapeador mapContratacion = session.getMapper(MapContratacionMapeador.class);
			try {
				mapContratacion.crearContratacionMap(contratacionMapVO);
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
		try {
			logger.debug("Entrada readCommand          -- OK");
			logger.debug("Datos de Entrada readCommand -- "
					+ bbvaAbstractDataTransferObject.toString());
			try {
				List<ContratacionMapVO> result = null;
				ContratacionMapVO contratacionMapVO = ((ContratacionMapDTO) bbvaAbstractDataTransferObject)
						.getContratacionMapVO();
				SqlSession session = MapeadorSessionFactory
						.getSqlSessionFactory().openSession();
				MapContratacionMapeador contratacionMapeador 	= session.getMapper(MapContratacionMapeador.class);
				try {
					contratacionMapVO.setIdBaja(CommandConstants.ESTATUS_OBJETO_CONTRATACION_BAJA);
					result = contratacionMapeador.obtenerContratacionesMap(contratacionMapVO);
					session.commit();
				} catch (Exception ex) {
					session.rollback();
					ex.printStackTrace();
					bbvaAbstractDataTransferObject.setErrorCode("SQL-001");
					bbvaAbstractDataTransferObject.setErrorDescription(ex.getMessage());
				} finally {
					session.close();
				}
				((ContratacionMapDTO) bbvaAbstractDataTransferObject).setContratacionMapVOs(result);
				logger.debug("result: " + result + " -- **fin**");
				logger.debug("Datos de Salida invoke -- "
						+ bbvaAbstractDataTransferObject.toString());
				logger.debug("Salida invoke          -- OK");
				return bbvaAbstractDataTransferObject;
			} catch (Exception ex) {
				ex.printStackTrace();
				bbvaAbstractDataTransferObject.setErrorCode("SQL-001");
				bbvaAbstractDataTransferObject.setErrorDescription(ex.getMessage());
				return bbvaAbstractDataTransferObject;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			bbvaAbstractDataTransferObject.setErrorCode("SQL-001");
			bbvaAbstractDataTransferObject.setErrorDescription(ex.getMessage());
			return bbvaAbstractDataTransferObject;
		}
	}
	
	
	/**
	 * Read command valida mensaje contrat map.
	 *
	 * @param contratacionMapVO the contratacion map vo
	 * @return true, if successful
	 */
	public boolean readCommandValidaMensajeContratMap(ContratacionMapVO contratacionMapVO) {
		boolean result = false;
		try {
			logger.debug("Entrada readCommand          -- OK");
			logger.debug("Datos de Entrada readCommand -- "
					+ contratacionMapVO.toString());
			try {
				SqlSession session = MapeadorSessionFactory
						.getSqlSessionFactory().openSession();
				MapContratacionMapeador contratacionMapeador 	= session.getMapper(MapContratacionMapeador.class);
				try {
					System.out.println("(((((((((((((((((((( " + contratacionMapVO.getIdMensajeSalida());
					contratacionMapVO = contratacionMapeador.validaMensajeContratacionMap(contratacionMapVO);
					if(contratacionMapVO.getNumMensaje() == 0)
						result = true;
					else
						result = false;
					session.commit();
				} catch (Exception ex) {
					session.rollback();
					ex.printStackTrace();					
				} finally {
					session.close();
				}
				return result;
			} catch (Exception ex) {
				ex.printStackTrace();				
				return result;
			}
		} catch (Exception exception) {
			exception.printStackTrace();			
			return result;
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
		ContratacionMapVO contratacionMapVO  = ((ContratacionMapDTO) bbvaAbstractDataTransferObject).getContratacionMapVO();
		SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
				.openSession();
		MapContratacionMapeador mapContratacion = session.getMapper(MapContratacionMapeador.class);
		try {
			mapContratacion.actualizarContratacionMap(contratacionMapVO);
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
