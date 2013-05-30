package mx.com.bbva.bancomer.mapper.business;

import java.util.List;

import mappers.monitoreoarchivos.MapMonitoreoArchivos;
import mx.com.bbva.bancomer.bussinnes.model.vo.MonitoreoArchivosVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.monitoreoarchivos.dto.MonitoreoArchivosDTO;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class MonitoreoArchivosBO implements mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject {
	private static final org.apache.log4j.Logger logger	 = Logger.getLogger(MonitoreoArchivosBO.class );

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
				List<MonitoreoArchivosVO> monitoreoArchivosVOs = null;
				MonitoreoArchivosVO monitoreoArchivosVO = ((MonitoreoArchivosDTO)bbvaAbstractDataTransferObject).getMonitoreoArchivosVO();
				SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
						.openSession();
				MapMonitoreoArchivos mapMonitoreoArchivos = session
						.getMapper(MapMonitoreoArchivos.class);
				if(monitoreoArchivosVO != null) {
					logger.debug(":::::::::::::::::::::" + monitoreoArchivosVO.toString());
				}
				try {
					monitoreoArchivosVOs = mapMonitoreoArchivos.obtenerMonitoreoArchivoVO(monitoreoArchivosVO);
					session.commit();
				} catch (Exception ex) {
					session.rollback();
					ex.printStackTrace();
				} finally {
					session.close();
				}
				((MonitoreoArchivosDTO)bbvaAbstractDataTransferObject).setMonitoreoArchivosVOs(monitoreoArchivosVOs); 
				logger.debug("result: " + monitoreoArchivosVOs + " -- **fin**");
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends BbvaAbstractDataTransferObject> T deleteCommand(
			T bbvaAbstractDataTransferObject) {
		// TODO Auto-generated method stub
		return null;
	}


}
