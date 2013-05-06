package mx.com.bbva.bancomer.mapper.business;

import java.util.List;

import javax.ejb.Stateless;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import mappers.canal.MapCanal;
import mx.com.bbva.bancomer.bussinnes.model.vo.CanalVO;
import mx.com.bbva.bancomer.canal.dto.CanalDTO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

@Stateless(mappedName = "canalBO")
public class CanalBO implements
		mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject {
	private static final org.apache.log4j.Logger logger = Logger
			.getLogger(CanalBO.class);

	// @Autowired
	private mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject bbvaIDataAccessObject;

	/**
	 * @return the bbvaIDataAccessObject
	 */
	public final mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject getBbvaIDataAccessObject() {
		return bbvaIDataAccessObject;
	}

	public void setBbvaIDataAccessObject(
			mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject bbvaIDataAccessObject) {
		this.bbvaIDataAccessObject = bbvaIDataAccessObject;
	}

	@Override
	public <T extends BbvaAbstractDataTransferObject> T createCommand(
			T bbvaAbstractDataTransferObject) {		
			logger.debug( "Entrada createCommand          -- OK" );
			logger.debug( "Datos de Entrada createCommand -- " + bbvaAbstractDataTransferObject.toString() );
			CanalVO canalVO = ((CanalDTO)bbvaAbstractDataTransferObject).getCanalVO();
			SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
					.openSession();
			MapCanal mapCanal = session.getMapper(MapCanal.class);
			try {
				mapCanal.crearCanal(canalVO);
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
			logger.debug("Entrada createCommand          -- OK");
			logger.debug("Datos de Entrada createCommand -- "
					+ bbvaAbstractDataTransferObject.toString());
			try {
				List<CanalVO> result = null;
				CanalVO canalVO = ((CanalDTO) bbvaAbstractDataTransferObject)
						.getCanalVO();
				SqlSession session = MapeadorSessionFactory
						.getSqlSessionFactory().openSession();
				MapCanal mapCanal = session.getMapper(MapCanal.class);
				try {
					result = mapCanal.obtenerCanales(canalVO);
					session.commit();
				} catch (Exception ex) {
					session.rollback();
					ex.printStackTrace();
				} finally {
					session.close();
				}
				((CanalDTO) bbvaAbstractDataTransferObject).setCanalVOs(result);
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
		logger.debug( "Entrada updateCommand          -- OK" );
		logger.debug( "Datos de Entrada updateCommand -- " + bbvaAbstractDataTransferObject.toString() );
		CanalVO canalVO = ((CanalDTO) bbvaAbstractDataTransferObject).getCanalVO();
		SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
				.openSession();
		MapCanal mapCanal = session.getMapper(MapCanal.class);
		try {
			mapCanal.actualizarCanal(canalVO);
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
