package mx.com.bbva.bancomer.commons.persistence.dao;

import java.util.List;

import mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException;
import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

import org.apache.log4j.Logger;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Informacion Confidencial:
 * Este software contiene informacion totalmente confidencial propiedad de Grupo Financiero BBVA Bancomer. 
 * Queda totalmente prohibido su uso o divulgacion en forma parcial o total y solamente podra ser utilizada de acuerdo a los terminos y estatutos 
 * que determine el Grupo Financiero BBVA Bancomer.
 * 
 * Todos los derechos reservados, Mexico 2013.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * DESCRIPCION DEL PROGRAMA:
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * HISTORIAL DE CAMBIOS:
 * 
 * Fecha:		Por:							Razon:         	Version
 * 02-MAY-2013  F. Emmanuel Chavarria Ortiz		Creacion        1.0.0
 *              femmanuel.chavarriao@gmail.com
 *              Consultoria
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
public 	class 		BbvaHibernateDAO 
		extends 	org.springframework.orm.hibernate3.support.HibernateDaoSupport 
		implements	BbvaIDataAccessObject 
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	private static final org.apache.log4j.Logger 	logger			 = Logger.getLogger( BbvaHibernateDAO.class );

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
		catch ( Exception exception ) 
			{
			throw new BbvaDataBaseException( "9901|BbvaHibernateDAO|queryForObject", exception );
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
		catch ( Exception exception ) 
			{
			throw new BbvaDataBaseException( "9901|BbvaHibernateDAO|queryForObject", exception );
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
		catch ( Exception exception ) 
			{
			throw new BbvaDataBaseException( "9901|BbvaHibernateDAO|queryForList", exception );
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
		catch ( Exception exception ) 
			{
			throw new BbvaDataBaseException( "9901|BbvaHibernateDAO|queryForList", exception );
			}
		}
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject#queryForList(java.lang.String, java.util.List)
	 */
	public <T extends BbvaAbstractValueObject> List<T> queryForList ( final String queryName, final List<T> bbvaAbstractValueObject )
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
		catch ( Exception exception ) 
			{
			throw new BbvaDataBaseException( "9901|BbvaHibernateDAO|queryForList", exception );
			}
		}
	}