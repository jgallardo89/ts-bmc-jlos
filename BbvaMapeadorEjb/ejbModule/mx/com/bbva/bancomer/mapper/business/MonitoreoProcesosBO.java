package mx.com.bbva.bancomer.mapper.business;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mappers.monitoreoprocesos.MapMonitoreoProcesos;
import mx.com.bbva.bancomer.bussinnes.model.vo.MonitoreoProcesosVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.monitoreoprocesos.dto.MonitoreoProcesosDTO;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class MonitoreoProcesosBO implements mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject {
	private static final org.apache.log4j.Logger logger	 = Logger.getLogger(MonitoreoProcesosBO.class );

	@Override
	public <T extends BbvaAbstractDataTransferObject> T createCommand(
			T bbvaAbstractDataTransferObject) {
		// TODO Auto-generated method stub
		return null;
	}

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
					monitoreoProcesosVOs = mapMonitoreoProcesos.obtenerMonitoreoProcesosVO(monitoreoProcesosVO);
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

	@Override
	public <T extends BbvaAbstractDataTransferObject> T deleteCommand(
			T bbvaAbstractDataTransferObject) {
		// TODO Auto-generated method stub
		return null;
	}

}
