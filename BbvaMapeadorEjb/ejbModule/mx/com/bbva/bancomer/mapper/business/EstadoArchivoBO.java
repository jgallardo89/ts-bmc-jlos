package mx.com.bbva.bancomer.mapper.business;

import java.util.List;

import mappers.monitoreoarchivos.MapMonitoreoArchivos;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstadoArchivoVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estadoarchivo.dto.EstadoArchivoDTO;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class EstadoArchivoBO implements mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject {
	private static final org.apache.log4j.Logger logger	 = Logger.getLogger(EstadoArchivoBO.class );

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
				List<EstadoArchivoVO> estadoArchivoVOs = null;
				EstadoArchivoVO estadoArchivoVO = ((EstadoArchivoDTO)bbvaAbstractDataTransferObject).getEstadoArchivoVO();
				SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
						.openSession();
				MapMonitoreoArchivos mapMonitoreoArchivos = session
						.getMapper(MapMonitoreoArchivos.class);
				if(estadoArchivoVO != null) {
					logger.debug(":::::::::::::::::::::" + estadoArchivoVO.toString());
				}
				try {
					estadoArchivoVOs = mapMonitoreoArchivos.obtenerEdosArchivo(estadoArchivoVO);
					session.commit();
				} catch (Exception ex) {
					session.rollback();
					ex.printStackTrace();
				} finally {
					session.close();
				}
				((EstadoArchivoDTO)bbvaAbstractDataTransferObject).setEstadoArchivoVOs(estadoArchivoVOs);
				logger.debug("result: " + estadoArchivoVO + " -- **fin**");
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
