package mx.com.bbva.bancomer.mapper.business;

import java.util.List;

import javax.ejb.Stateless;

import mappers.cliente.MapCliente;
import mappers.mensajesalida.MapMensajeSalida;
import mx.com.bbva.bancomer.bussinnes.model.vo.ClienteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MensajeSalidaVO;
import mx.com.bbva.bancomer.cliente.dto.ClienteDTO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.mensajesalida.dto.MensajeSalidaDTO;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

@Stateless(mappedName = "mensajeSalidaBO")
public class MensajeSalidaBO implements
		mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject {
	private static final org.apache.log4j.Logger logger = Logger
			.getLogger(MensajeSalidaBO.class);

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
			MensajeSalidaVO mensajeSalidaVO = ((MensajeSalidaDTO)bbvaAbstractDataTransferObject).getMensajeSalidaVO();
			SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
					.openSession();
			MapMensajeSalida mapMensajeSalida = session.getMapper(MapMensajeSalida.class);
			try {
				mapMensajeSalida.crearMensajeSalida(mensajeSalidaVO);
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
				List<MensajeSalidaVO> result = null;
				MensajeSalidaVO mensajeSalidaVO = ((MensajeSalidaDTO) bbvaAbstractDataTransferObject)
						.getMensajeSalidaVO();
				SqlSession session = MapeadorSessionFactory
						.getSqlSessionFactory().openSession();
				MapMensajeSalida mapMensajeSalida = session.getMapper(MapMensajeSalida.class);
				try {
					result = mapMensajeSalida.obtenerMensajesSalida(mensajeSalidaVO);
					session.commit();
				} catch (Exception ex) {
					session.rollback();
					ex.printStackTrace();
				} finally {
					session.close();
				}
				((MensajeSalidaDTO) bbvaAbstractDataTransferObject).setMensajeSalidaVOs(result);
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
		MensajeSalidaDTO mensajeSalidaDTO = new MensajeSalidaDTO();
		try {
			logger.debug("Entrada readCmbCommand -- OK");
			try {
				List<MensajeSalidaVO> result = null;
				SqlSession session = MapeadorSessionFactory
						.getSqlSessionFactory().openSession();
				MapMensajeSalida mapMensajeSalida = session.getMapper(MapMensajeSalida.class);
				try {
					result = mapMensajeSalida.obtenerMensajesCmbSalida();
					session.commit();
				} catch (Exception ex) {
					session.rollback();
					ex.printStackTrace();
				} finally {
					session.close();
				}
				mensajeSalidaDTO.setMensajeSalidaVOs(result);
				logger.debug("result: " + result + " -- **fin**");
				logger.debug("Datos de Salida invoke -- "
						+ mensajeSalidaDTO.toString());
				logger.debug("Salida invoke          -- OK");
				return (T) mensajeSalidaDTO;
			} catch (Exception ex) {
				ex.printStackTrace();
				return (T) mensajeSalidaDTO;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			return (T) mensajeSalidaDTO;
		}
	}

	@Override
	public <T extends BbvaAbstractDataTransferObject> T updateCommand(
			T bbvaAbstractDataTransferObject) {
		logger.debug( "Entrada updateCommand          -- OK" );
		logger.debug( "Datos de Entrada updateCommand -- " + bbvaAbstractDataTransferObject.toString() );
		MensajeSalidaVO mensajeSalidaVO = ((MensajeSalidaDTO) bbvaAbstractDataTransferObject).getMensajeSalidaVO();
		SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
				.openSession();
		MapMensajeSalida mapMensajeSalida = session.getMapper(MapMensajeSalida.class);
		try {
			mapMensajeSalida.actualizarMensajeSalida(mensajeSalidaVO);
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
