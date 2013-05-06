package mx.com.bbva.bancomer.mapper.business;

import java.util.List;

import javax.ejb.Stateless;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import mappers.estatusobjeto.MapEstatusObjeto;
import mappers.pantalla.MapPantalla;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PantallaVO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject;
import mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

@Stateless(mappedName="pantallaBO")
public class PantallaBO implements mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject {
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	private static final org.apache.log4j.Logger 	logger			 = Logger.getLogger(PantallaBO.class);
	
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados	
	private mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject bbvaIDataAccessObject;

	/**
	 * @return the bbvaIDataAccessObject
	 */
	public final mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject getBbvaIDataAccessObject() {
		return bbvaIDataAccessObject;
	}

	//	Propiedades
	//	public final mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject getBbvaIDataAccessObject() 
	//		{	return bbvaIDataAccessObject;							}
	public void setBbvaIDataAccessObject( mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject bbvaIDataAccessObject )
		{	this.bbvaIDataAccessObject = bbvaIDataAccessObject;		}
	
	@Override
	public <T extends BbvaAbstractDataTransferObject> T createCommand(
			T bbvaAbstractDataTransferObject) {
		try {
			logger.debug( "Entrada createCommand          -- OK" );
			logger.debug( "Datos de Entrada createCommand -- " + bbvaAbstractDataTransferObject.toString() );
			
//			switch (bbvaAbstractDataTransferObject.getCommandId()) {
//			case CommandConstants.ESTATUS_OBJETO_COMBO_PANTALLAS:
//				List<PantallaVO> pantallaVOs = bbvaIDataAccessObject.queryForList("ConsultarCatalogoMapper|readBbvaPantallaComboVO");
//				((EstatusObjetoDTO)bbvaAbstractDataTransferObject).setPantallaVOs(pantallaVOs);
//				break;
//
//			default:
//				break;
//			}			
			
			logger.debug( "Datos de Salida invoke -- " + bbvaAbstractDataTransferObject.toString() );
			logger.debug( "Salida invoke          -- OK" );
			return null;
		} 
		catch ( Exception exception ) 
		{
			return null;
		}
	}

	@Override
	public <T extends BbvaAbstractDataTransferObject> T readCommand(
			T bbvaAbstractDataTransferObject) {
		try {
			logger.debug( "Entrada createCommand          -- OK" );
			logger.debug( "Datos de Entrada createCommand -- " + bbvaAbstractDataTransferObject.toString() );
			
//			switch (bbvaAbstractDataTransferObject.getCommandId()) {
//				case CommandConstants.ESTATUS_OBJETO_COMBO_PANTALLAS:
//					String SPRINGFILEPATH		= "C:/Bancomer/workspace_map/BbvaMapeadorWeb/WebContent/WEB-INF/config/db-config.xml";
//					ApplicationContext 	applicationContext = new FileSystemXmlApplicationContext( SPRINGFILEPATH );
//					BbvaIDataAccessObject bbvaIDataAccessObject = (BbvaIDataAccessObject)applicationContext.getBean( "bbvaMyBatisDAO" );					
//					List<PantallaVO> pantallaVOs = bbvaIDataAccessObject.queryForList("ConsultarCatalogoMapper|readPantallaVO");
//					((EstatusObjetoDTO)bbvaAbstractDataTransferObject).setPantallaVOs(pantallaVOs);
//					break;	
//				default:
//					break;
//			}						
			try {
				List<PantallaVO> result = null;
				PantallaVO pantallaVO = ((EstatusObjetoDTO)bbvaAbstractDataTransferObject).getPantallaVO();				
				SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
						.openSession();
				MapPantalla mapPantalla = session
						.getMapper(MapPantalla.class);
				try {
					result = mapPantalla.obtenerPantallas(pantallaVO);					
				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					session.close();
				}
				((EstatusObjetoDTO)bbvaAbstractDataTransferObject).setPantallaVOs(result);
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
