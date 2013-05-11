package mx.com.bbva.bancomer.mapper.business;

import java.util.List;

import javax.ejb.Stateless;

import mappers.palabracomodin.MapPalabraComodin;
import mx.com.bbva.bancomer.bussinnes.model.vo.PalabraComodinVO;
import mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.palabracomodin.dto.PalabraComodinDTO;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

@Stateless(mappedName = "palabraComodinBO")
public class PalabraComodinBO implements BbvaIBusinessObject { 

	private static final org.apache.log4j.Logger logger = Logger
			.getLogger(PalabraComodinBO.class);
	
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
				List<PalabraComodinVO> result = null;
				PalabraComodinVO palabraComodinVO = ((PalabraComodinDTO) bbvaAbstractDataTransferObject)
						.getPalabraComodinVO();
				SqlSession session = MapeadorSessionFactory
						.getSqlSessionFactory().openSession();
				MapPalabraComodin mapPalabraComodin = session.getMapper(MapPalabraComodin.class);
				try {
					result = mapPalabraComodin.obtenerPalabrasComodin(palabraComodinVO);
					session.commit();
				} catch (Exception ex) {
					session.rollback();
					ex.printStackTrace();
				} finally {
					session.close();
				}
				((PalabraComodinDTO) bbvaAbstractDataTransferObject).setPalabraComodinVOs(result);
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
