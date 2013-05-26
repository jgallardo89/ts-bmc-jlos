package mx.com.bbva.bancomer.mapper.business;

import java.util.List;

import javax.ejb.Stateless;

import mappers.mapagmm.MapMapaGmm;
import mx.com.bbva.bancomer.bussinnes.model.vo.MapaGmmVO;
import mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.mappers.mapagmm.dto.MapaGmmDTO;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
 
@Stateless(mappedName = "mapaGmmBO")
public class MapaGmmBO implements BbvaIBusinessObject {

	private static final org.apache.log4j.Logger logger = Logger
			.getLogger(MapaGmmBO.class);
	
	@Override
	public <T extends BbvaAbstractDataTransferObject> T createCommand(
			T bbvaAbstractDataTransferObject) {		
		logger.debug( "Entrada createCommand          -- OK" );
		logger.debug( "Datos de Entrada createCommand -- " + bbvaAbstractDataTransferObject.toString() );
		MapaGmmVO mapaGmmVO = ((MapaGmmDTO)bbvaAbstractDataTransferObject).getMapaGmmVO();
		SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
				.openSession();
		MapMapaGmm mapMapaGmm = session
				.getMapper(MapMapaGmm.class);
		try {
			mapMapaGmm.crearMapaGmm(mapaGmmVO);
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
			logger.debug("Entrada readCommand          -- OK");
			logger.debug("Datos de Entrada createCommand -- "
					+ bbvaAbstractDataTransferObject.toString());
			try {
				List<MapaGmmVO> result = null;
				MapaGmmVO mapaGmmVO = ((MapaGmmDTO) bbvaAbstractDataTransferObject)
						.getMapaGmmVO();
				SqlSession session = MapeadorSessionFactory
						.getSqlSessionFactory().openSession();
				MapMapaGmm mapMapaGmm = session.getMapper(MapMapaGmm.class);
				try {
					result = mapMapaGmm.obtenerMapaGmms(mapaGmmVO);
					session.commit();
				} catch (Exception ex) {
					session.rollback();
					ex.printStackTrace();
				} finally {
					session.close();
				}
				((MapaGmmDTO) bbvaAbstractDataTransferObject).setMapaGmmVOs(result);
				logger.debug("result: " + result + " -- **fin**");
				logger.debug("Datos de Salida invoke -- "
						+ bbvaAbstractDataTransferObject.toString());
				logger.debug("Salida invoke          -- OK");
				return bbvaAbstractDataTransferObject;
			} catch (Exception ex) {
				ex.printStackTrace();
				return bbvaAbstractDataTransferObject;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			return bbvaAbstractDataTransferObject;
		}
	}
	
	public <T extends BbvaAbstractDataTransferObject> T readCommand() {
		MapaGmmDTO mapaGmmDTO = new MapaGmmDTO();
		try {
			logger.debug("Entrada readCmbCommand -- OK");
			try {
				List<MapaGmmVO> result = null;
				SqlSession session = MapeadorSessionFactory
						.getSqlSessionFactory().openSession();
				MapMapaGmm mapMapaGmm = session.getMapper(MapMapaGmm.class);
				try {
					result = mapMapaGmm.obtenerCmbMapaGmms();
					session.commit();
				} catch (Exception ex) {
					session.rollback();
					ex.printStackTrace();
				} finally {
					session.close();
				}
				mapaGmmDTO.setMapaGmmVOs(result);
				logger.debug("result: " + result + " -- **fin**");
				logger.debug("Datos de Salida invoke -- "
						+ mapaGmmDTO.toString());
				logger.debug("Salida invoke          -- OK");
				return (T) mapaGmmDTO;
			} catch (Exception ex) {
				ex.printStackTrace();
				return (T) mapaGmmDTO;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			return (T) mapaGmmDTO;
		}
	}

	@Override
	public <T extends BbvaAbstractDataTransferObject> T updateCommand(
			T bbvaAbstractDataTransferObject) {
		logger.debug( "Entrada updateCommand          -- OK" );
		logger.debug( "Datos de Entrada updateCommand -- " + bbvaAbstractDataTransferObject.toString() );
		MapaGmmVO mapaGmmVO = ((MapaGmmDTO)bbvaAbstractDataTransferObject).getMapaGmmVO();
		SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
				.openSession();
		MapMapaGmm mapMapaGmm = session
				.getMapper(MapMapaGmm.class);
		try {
			mapMapaGmm.actualizarMapaGmm(mapaGmmVO);
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
