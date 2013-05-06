package mx.com.bbva.bancomer.mapper.business;

import java.util.List;

import javax.ejb.Stateless;

import mappers.usuario.MapUsuario;
import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.UsuarioDTO;
import mx.com.bbva.mapeador.oralce.session.MapeadorSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

@Stateless(mappedName="usuarioBO")
public class UsuarioBO implements mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject {

	private static final org.apache.log4j.Logger logger	 = Logger.getLogger(UsuarioBO.class );	
	@Override
	public <T extends BbvaAbstractDataTransferObject> T createCommand(
			T bbvaAbstractDataTransferObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends BbvaAbstractDataTransferObject> T readCommand(
			T bbvaAbstractDataTransferObject) {
		logger.debug( "Entrada createCommand          -- OK" );
		logger.debug( "Datos de Entrada createCommand -- " + bbvaAbstractDataTransferObject.toString() );					
		try {
			List<UsuarioVO> result = null;
			UsuarioVO usuarioVO = ((UsuarioDTO)bbvaAbstractDataTransferObject).getUsuarioVO();
			SqlSession session = MapeadorSessionFactory.getSqlSessionFactory()
					.openSession();
			MapUsuario mapUsuario = session
					.getMapper(MapUsuario.class);
			if(usuarioVO.getIdCveUsuario() != null) {
				logger.debug(":::::::::::::::::::::" + usuarioVO.getIdCveUsuario());
			}
			try {
				result = mapUsuario.obtenerUsuarios(usuarioVO);
				
				session.commit();
			} catch (Exception ex) {
				session.rollback();
				ex.printStackTrace();
			} finally {
				session.close();
			}
			((UsuarioDTO)bbvaAbstractDataTransferObject).setUsuarioVOs(result);
			logger.debug("result: " + result + " -- **fin**");
			logger.debug( "Datos de Salida invoke -- " + bbvaAbstractDataTransferObject.toString() );
			logger.debug( "Salida invoke          -- OK" );
			return bbvaAbstractDataTransferObject;
		} catch (Exception ex) {
			ex.printStackTrace();
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
