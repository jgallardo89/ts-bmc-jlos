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
 * Nombre de clase: MonitoreoProcesosBO.java
 * Nombre de paquete: mx.com.bbva.bancomer.mapper.business
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.mapper.business;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mappers.monitoreoprocesos.MapMonitoreoProcesos;
import mx.com.bbva.bancomer.bussinnes.model.vo.MonitoreoProcesosVO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.monitoreoprocesos.dto.MonitoreoProcesosDTO;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class MonitoreoProcesosBO.
 */
public class MonitoreoProcesosBO implements mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject {
	
	/** The Constant logger. */
	private static final org.apache.log4j.Logger logger	 = Logger.getLogger(MonitoreoProcesosBO.class );

	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject#createCommand(mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject)
	 */
	@Override
	public <T extends BbvaAbstractDataTransferObject> T createCommand(
			T bbvaAbstractDataTransferObject) {
		// TODO Auto-generated method stub
		return null;
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
		try {
			logger.debug( "Entrada createCommand          -- OK" );
			logger.debug( "Datos de Entrada createCommand -- " + bbvaAbstractDataTransferObject.toString() );					
			try {
				List<MonitoreoProcesosVO> monitoreoProcesosVOs = null;
				MonitoreoProcesosVO monitoreoProcesosVO = ((MonitoreoProcesosDTO)bbvaAbstractDataTransferObject).getMonitoreoProcesosVO();
				SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
						.openSession();
				MapMonitoreoProcesos mapMonitoreoProcesos = session
						.getMapper(MapMonitoreoProcesos.class);
				if(monitoreoProcesosVO != null) {
					logger.debug(":::::::::::::::::::::" + monitoreoProcesosVO.toString());
				}
				try {
					if(bbvaAbstractDataTransferObject.getCommandId()==CommandConstants.PROCESOS_CANAL){
						monitoreoProcesosVOs = mapMonitoreoProcesos.obtieneCanalesProcesos(monitoreoProcesosVO);
					}else if(bbvaAbstractDataTransferObject.getCommandId()==CommandConstants.PROCESOS_ARCHIVOS){
						monitoreoProcesosVOs = mapMonitoreoProcesos.obtieneEtapasArchivos(monitoreoProcesosVO);
					}else if(bbvaAbstractDataTransferObject.getCommandId()==CommandConstants.PROCESOS_ESTATUS){
						monitoreoProcesosVOs = mapMonitoreoProcesos.obtieneEstatusProceso(monitoreoProcesosVO);
					}else{
						monitoreoProcesosVOs = mapMonitoreoProcesos.obtenerMonitoreoProcesosVO(monitoreoProcesosVO);
					}
					Set<String> canal = new  HashSet<String>();
					Set<String> cliente = new  HashSet<String>();
					Set<String> producto = new  HashSet<String>();
					for (MonitoreoProcesosVO entidadVO : monitoreoProcesosVOs) {						
						canal.add(entidadVO.getNombreCanal());
						cliente.add(entidadVO.getIdIdentificador());
						producto.add(entidadVO.getNombreProducto());
					}
					for (String stringProducto : producto) {
						logger.debug("::::::::::::::" + stringProducto);
					}
					session.commit();
				} catch (Exception ex) {
					session.rollback();
					ex.printStackTrace();
				} finally {
					session.close();
				}
				((MonitoreoProcesosDTO)bbvaAbstractDataTransferObject).setMonitoreoProcesosVOs(monitoreoProcesosVOs); 
				logger.debug("result: " + monitoreoProcesosVOs + " -- **fin**");
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

	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject#updateCommand(mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject)
	 */
	@Override
	public <T extends BbvaAbstractDataTransferObject> T updateCommand(
			T bbvaAbstractDataTransferObject) {
		logger.debug( "Entrada updateCommand          -- OK" );
		logger.debug( "Datos de Entrada updateCommand -- " + bbvaAbstractDataTransferObject.toString() );
		MonitoreoProcesosVO monitoreoProcesosVO = ((MonitoreoProcesosDTO)bbvaAbstractDataTransferObject).getMonitoreoProcesosVO();
		monitoreoProcesosVO.setIdEstatusMapeador(10);
		SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
				.openSession();
		MapMonitoreoProcesos mapMonitoreoProcesos = session
				.getMapper(MapMonitoreoProcesos.class);
		try {
			mapMonitoreoProcesos.actualizarEstatusProceso(monitoreoProcesosVO);
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
