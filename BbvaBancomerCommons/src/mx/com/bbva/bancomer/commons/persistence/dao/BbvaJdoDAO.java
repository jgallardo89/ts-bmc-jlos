package mx.com.bbva.bancomer.commons.persistence.dao;

import java.util.List;

import mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException;
import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

import org.apache.log4j.Logger;

@SuppressWarnings("deprecation")
public 	class 		BbvaJdoDAO 
		extends 	org.springframework.orm.jdo.support.JdoDaoSupport 
		implements BbvaIDataAccessObject 
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	private static final org.apache.log4j.Logger 	logger			 = Logger.getLogger( BbvaJdoDAO.class );

	//  Metodos       - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject#queryForObject(java.lang.String)
	 */
	public synchronized <T extends BbvaAbstractValueObject> T queryForObject ( final java.lang.String queryName )
	throws mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException
		{
		try {
			logger.debug( "Entrada queryForObject -- OK" );
			logger.debug( "Datos de Entrada       -- " + queryName );
			
			// TODO: Implementacion de cada uno los Framework
			
			logger.debug( "queryForObject Ejecutado -- OK" );
			logger.debug( "Datos de Salida          -- " + "" );
			return null;
			} 
		catch (Exception e) 
			{
			throw new mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException();
			}
		}
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject#queryForObject(java.lang.String, java.util.Map)
	 */
	public synchronized <T extends BbvaAbstractValueObject> T queryForObject ( 	final java.lang.String queryName, final T bbvaAbstractValueObject )
	throws mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException
		{
		try {
			logger.debug( "Entrada queryForObject -- OK" );
			logger.debug( "Datos de Entrada       -- " + queryName + " -- " + bbvaAbstractValueObject );
			
			// TODO: Implementacion de cada uno los Framework
			
			logger.debug( "queryForObject Ejecutado -- OK" );
			logger.debug( "Datos de Salida          -- " + "" );
			return null;
			} 
		catch (Exception e) 
			{
			throw new mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException();
			}
		}
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject#queryForList(java.lang.String)
	 */
	public <T extends BbvaAbstractValueObject> List< T > queryForList ( final java.lang.String queryName )
	throws mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException
		{
		try {
			logger.debug( "Entrada queryForList -- OK" );
			logger.debug( "Datos de Entrada     -- " + queryName );
			
			// TODO: Implementacion de cada uno los Framework
			
			logger.debug( "queryForList Ejecutado -- OK" );
			logger.debug( "Datos de Salida        -- " + "" );
			return null;
			} 
		catch (Exception e) 
			{
			throw new mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException();
			}
		}
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject#queryForList(java.lang.String, java.util.Map)
	 */
	public <T extends BbvaAbstractValueObject> List< T > queryForList (	final java.lang.String queryName, final T bbvaAbstractValueObject )
	throws mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException
		{
		try {
			logger.debug( "Entrada queryForList -- OK" );
			logger.debug( "Datos de Entrada       -- " + queryName + " -- " + bbvaAbstractValueObject );
			
			// TODO: Implementacion de cada uno los Framework
			
			logger.debug( "queryForList Ejecutado -- OK" );
			logger.debug( "Datos de Salida        -- " + "" );
			return null;
			} 
		catch (Exception e) 
			{
			throw new mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException();
			}
		}
	@Override
	public <T extends BbvaAbstractValueObject> List<T> queryForList(
			String queryName, List<T> bbvaAbstractValueObject)
			throws BbvaDataBaseException {
		// TODO Auto-generated method stub
		return null;
	}
	}
