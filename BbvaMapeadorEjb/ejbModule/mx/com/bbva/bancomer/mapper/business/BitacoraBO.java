/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Informacion Confidencial:
 * Este software contiene informacion totalmente confidencial propiedad de Grupo Financiero BBVA Bancomer. 
 * Queda totalmente prohibido su uso o divulgacion en forma parcial o total y solamente podra ser utilizada de acuerdo a los terminos y estatutos 
 * que determine el Grupo Financiero BBVA Bancomer.
 * 
 * Todos los derechos reservados, Mexico 2013.
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * DESCRIPCION DEL PROGRAMA
 * Nombre de aplicación: MAPEADOR
 * Nombre de proyecto: BbvaMapeadorEjb
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * HISTORIAL DE CAMBIOS:
 * 
 * Fecha:									         	
 * 30-ABR-2013  
 * @Author:	Jose Luis Ortiz Salazar
 * @Email: jortizsalazar@gmail.com    	
 * Razon: Creacion        
 * Version: 1.0.0
 * Nombre de clase: BitacoraBO.java
 * Nombre de paquete: mx.com.bbva.bancomer.mapper.business
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
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

// TODO: Auto-generated Javadoc
/**
 * The Class BitacoraBO.
 */
@Stateless(mappedName = "bitacoraBO")
public class BitacoraBO implements BbvaIBusinessObject { 

	/** The Constant logger. */
	private static final org.apache.log4j.Logger logger = Logger
			.getLogger(BitacoraBO.class);
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject#createCommand(mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject)
	 */
	@Override
	public <T extends BbvaAbstractDataTransferObject> T createCommand(
			T bbvaAbstractDataTransferObject) {
		logger.debug( "Entrada createCommand          -- OK" );
		logger.debug( "Datos de Entrada createCommand -- review" + bbvaAbstractDataTransferObject.toString() );
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
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject#deleteCommand(mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject)
	 */
	@Override
	public <T extends BbvaAbstractDataTransferObject> T deleteCommand(
			T bbvaAbstractDataTransferObject) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Object to string xml.
	 *
	 * @param campoDTOs the campo dt os
	 * @return the string
	 */
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
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject#readCommand(mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject)
	 */
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
	
	/**
	 * Read command parameters.
	 *
	 * @param <T> the generic type
	 * @param bbvaAbstractDataTransferObject the bbva abstract data transfer object
	 * @return the t
	 */
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
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject#updateCommand(mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject)
	 */
	@Override
	public <T extends BbvaAbstractDataTransferObject> T updateCommand(
			T bbvaAbstractDataTransferObject) {
		return null;	
	}
}
