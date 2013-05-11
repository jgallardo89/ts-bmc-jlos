package mx.com.bbva.bancomer.mapper.business;

import java.sql.Clob;
import java.util.List;

import javax.ejb.Stateless;

import mappers.bitacora.MapBitacora;
import mx.com.bbva.bancomer.bitacora.dto.BitacoraDTO;
import mx.com.bbva.bancomer.bussinnes.model.vo.BitacoraVO;
import mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

@Stateless(mappedName = "bitacoraBO")
public class BitacoraBO implements BbvaIBusinessObject { 

	private static final org.apache.log4j.Logger logger = Logger
			.getLogger(BitacoraBO.class);
	
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
			logger.debug("Entrada readCommand          -- OK");
			logger.debug("Datos de Entrada createCommand -- "
					+ bbvaAbstractDataTransferObject.toString());
			try {
				List<BitacoraVO> result = null;
				BitacoraVO BitacoraVO = ((BitacoraDTO) bbvaAbstractDataTransferObject)
						.getBitacoraVO();
				SqlSession session = MapeadorSessionFactory
						.getSqlSessionFactory().openSession();
				MapBitacora mapBitacora = session.getMapper(MapBitacora.class);
				try {
					result = mapBitacora.obtenerBitacora(BitacoraVO);
					session.commit();
				} catch (Exception ex) {
					session.rollback();
					ex.printStackTrace();
				} finally {
					session.close();
				}
				((BitacoraDTO) bbvaAbstractDataTransferObject).setBitacoraVOs(result);
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
	
	public <T extends BbvaAbstractDataTransferObject> T readCommandParameters(
			T bbvaAbstractDataTransferObject) {
		try {
			logger.debug("Entrada readCommand          -- OK");
			logger.debug("Datos de Entrada createCommand -- "
					+ bbvaAbstractDataTransferObject.toString());
			try {
				Clob result = null;
				BitacoraVO BitacoraVO = ((BitacoraDTO) bbvaAbstractDataTransferObject)
						.getBitacoraVO();
				SqlSession session = MapeadorSessionFactory
						.getSqlSessionFactory().openSession();
				MapBitacora mapBitacora = session.getMapper(MapBitacora.class);
				try {
					result = mapBitacora.obtenerDetalleBitacora(BitacoraVO);
					session.commit();
				} catch (Exception ex) {
					session.rollback();
					ex.printStackTrace();
				} finally {
					session.close();
				}
				((BitacoraDTO) bbvaAbstractDataTransferObject).setXml(result);
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
	
	@Override
	public <T extends BbvaAbstractDataTransferObject> T updateCommand(
			T bbvaAbstractDataTransferObject) {
		return null;	
	}
	
	@Override
	public <T extends BbvaAbstractDataTransferObject> T deleteCommand(
			T bbvaAbstractDataTransferObject) {
		// TODO Auto-generated method stub
		return null;
	}
}
