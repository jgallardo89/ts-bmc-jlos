package mx.com.bbva.bancomer.mapper.business;

import java.util.List;

import mappers.estadistico.MapEstadistico;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstadisticoVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estadistico.dto.EstadisticaDTO;
import mx.com.bbva.bancomer.estadistico.dto.EstadisticoDTO;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class EstadisticoBO  implements mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject {
	private static final org.apache.log4j.Logger logger	 = Logger.getLogger(EstadisticoBO.class );
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
				List<EstadisticoVO> result = null;
				EstadisticoVO estadisticoVO = ((EstadisticaDTO)bbvaAbstractDataTransferObject).getEstadisticoVO();
				SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
						.openSession();
				MapEstadistico mapEstadistico = session
						.getMapper(MapEstadistico.class);
				if(estadisticoVO != null) {
					logger.debug(":::::::::::::::::::::" + estadisticoVO.toString());
				}
				try {
					result = mapEstadistico.obtenerEstadisticoVO(estadisticoVO);
					
					session.commit();
				} catch (Exception ex) {
					session.rollback();
					ex.printStackTrace();
				} finally {
					session.close();
				}
				((EstadisticaDTO)bbvaAbstractDataTransferObject).setEstadisticoVOs(result); 
				logger.debug("result: " + result + " -- **fin**");
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
