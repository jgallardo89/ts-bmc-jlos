package mx.com.bbva.bancomer.mapper.business;

import java.util.List;

import javax.ejb.Stateless;

import mappers.bitacoraarchivo.MapBitacoraArchivo;
import mx.com.bbva.bancomer.bitacoraarchivo.dto.BitacoraArchivoDTO;
import mx.com.bbva.bancomer.bussinnes.model.vo.BitacoraArchivoVO;
import mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

@Stateless(mappedName = "bitacoraArchivoBO")
public class BitacoraArchivoBO implements BbvaIBusinessObject {
	private static final org.apache.log4j.Logger logger = Logger
			.getLogger(BitacoraArchivoBO.class);
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
				List<BitacoraArchivoVO> result = null;
				BitacoraArchivoVO bitacoraArchivoVO = ((BitacoraArchivoDTO) bbvaAbstractDataTransferObject)
						.getBitacoraArchivoVO();
				SqlSession session = MapeadorSessionFactory
						.getSqlSessionFactory().openSession();
				MapBitacoraArchivo mapBitacoraArchivo = session.getMapper(MapBitacoraArchivo.class);
				try {
					result = mapBitacoraArchivo.obtenerBitacoraArchivos(bitacoraArchivoVO);
					session.commit();
				} catch (Exception ex) {
					session.rollback();
					ex.printStackTrace();
				} finally {
					session.close();
				}
				((BitacoraArchivoDTO) bbvaAbstractDataTransferObject).setBitacoraArchivoVOs(result);
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
