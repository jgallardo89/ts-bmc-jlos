package mx.com.bbva.bancomer.mapper.business;

import java.util.List;

import javax.ejb.Stateless;

import mappers.evento.MapEvento;
import mx.com.bbva.bancomer.bitacora.dto.BitacoraDTO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EventoMapeadorVO;
import mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.evento.dto.EventoMapeadorDTO;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

@Stateless(mappedName = "eventoMapeadorBO")
public class EventoMapeadorBO implements BbvaIBusinessObject { 

	private static final org.apache.log4j.Logger logger = Logger
			.getLogger(EventoMapeadorBO.class);
	
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
			logger.debug("Datos de Entrada readCommand -- "
					+ bbvaAbstractDataTransferObject.toString());
			try {
				List<EventoMapeadorVO> result = null;
				SqlSession session = MapeadorSessionFactory
						.getSqlSessionFactory().openSession();
				MapEvento mapEvento = session.getMapper(MapEvento.class);
				try {
					result = mapEvento.obtenerEventoMapeador();
					session.commit();
				} catch (Exception ex) {
					session.rollback();
					ex.printStackTrace();
				} finally {
					session.close();
				}
				((EventoMapeadorDTO) bbvaAbstractDataTransferObject).setEventoMapeadorVOs(result);
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
