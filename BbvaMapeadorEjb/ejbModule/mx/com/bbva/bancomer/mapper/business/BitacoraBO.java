package mx.com.bbva.bancomer.mapper.business;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.ejb.Stateless;

import mappers.bitacora.MapBitacora;
import mx.com.bbva.bancomer.bitacora.dto.BitacoraDTO;
import mx.com.bbva.bancomer.bitacora.dto.CampoDTO;
import mx.com.bbva.bancomer.bussinnes.model.vo.BitacoraVO;
import mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.wutka.jox.JOXBeanOutputStream;

@Stateless(mappedName = "bitacoraBO")
public class BitacoraBO implements BbvaIBusinessObject { 

	private static final org.apache.log4j.Logger logger = Logger
			.getLogger(BitacoraBO.class);
	
	@Override
	public <T extends BbvaAbstractDataTransferObject> T createCommand(
			T bbvaAbstractDataTransferObject) {
		logger.debug( "Entrada createCommand          -- OK" );
		logger.debug( "Datos de Entrada createCommand -- " + bbvaAbstractDataTransferObject.toString() );
		BitacoraVO canalVO = ((BitacoraDTO)bbvaAbstractDataTransferObject).getBitacoraVO();
		String xml = objectToStringXML(((BitacoraDTO)bbvaAbstractDataTransferObject).getCampoDTOs());
		canalVO.setDescripcionBitacora(xml);
		SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
				.openSession();
		MapBitacora mapBitacora = session.getMapper(MapBitacora.class);
		try {
			mapBitacora.crearBitacora(canalVO);
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
	
	private String objectToStringXML(List<CampoDTO> campoDTOs) {
		ByteArrayOutputStream xml = null;
		BitacoraDTO dto = new BitacoraDTO();
		CampoDTO[] campoArray = new CampoDTO[campoDTOs.size()];
		int i = 0;
		for(CampoDTO campo: campoDTOs) {
			campoArray[i++] = campo;
		}
		dto.setCommandId(null);
		dto.setErrorCode(null);
		dto.setErrorDescription(null);
		dto.setCampo(campoArray);
		try {
			xml = new ByteArrayOutputStream();
			JOXBeanOutputStream joxOut = new JOXBeanOutputStream(xml);
			joxOut.writeObject("xml", dto);
			System.out.println(xml.toString());
			xml.close();
			joxOut.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xml.toString();
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
				String result = null;
				BitacoraVO BitacoraVO = ((BitacoraDTO) bbvaAbstractDataTransferObject)
						.getBitacoraVO();
				SqlSession session = MapeadorSessionFactory
						.getSqlSessionFactory().openSession();
				MapBitacora mapBitacora = session.getMapper(MapBitacora.class);
				try {
					result = mapBitacora.obtenerDetalleBitacora(BitacoraVO).getDescripcionBitacora();
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
