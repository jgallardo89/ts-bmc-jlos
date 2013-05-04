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
public 	class 		BbvaMyBatisDAO 
		extends 	org.mybatis.spring.support.SqlSessionDaoSupport 
		implements 	BbvaIDataAccessObject 
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	private static final org.apache.log4j.Logger 	logger			 = Logger.getLogger( BbvaMyBatisDAO.class );

	//  Metodos       - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject#queryForObject(java.lang.String)
	 */
	public synchronized <T extends BbvaAbstractValueObject> T queryForObject ( final java.lang.String queryName )
	throws mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException
		{
		try {
			System.out.println( "Entrada queryForObject -- OK" );
			System.out.println( "Datos de Entrada       -- " + queryName );
			//	Ejecutamos la consulta de lectura.
			final	List<T>	list = this.getSqlSession().selectList( "mx.com.bbva.bancomer.mapper.persistence.sqlmapping.BbvaCatalogoMapper.readBbvaEstatusVO" );
			//	TODO: ¿Si la consulta no trae registros lanzamos una excepcion? 
			if ( list == null || list.isEmpty() )	throw new BbvaDataBaseException( "" );
			//	Impimimos el resultado.
			if ( logger.isInfoEnabled() )
				for ( final T bbvaAbstractValueObject : list )
					System.out.println( "Datos de Salida                    -- " + bbvaAbstractValueObject.toString() );
			//	Regresamos el primer elemento de la lista.
			System.out.println( "Salida -- queryForObject Ejecutado -- OK" );
			return list.get( 0 );
			} 
		catch ( Exception exception ) 
			{
			throw new BbvaDataBaseException( exception );
			}
		}
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject#queryForObject(java.lang.String, java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public synchronized <T extends BbvaAbstractValueObject> T queryForObject ( 	final java.lang.String queryName, final T bbvaAbstractValueObject )
	throws mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException
		{
		try {
			System.out.println( "Entrada queryForObject -- OK" );
			System.out.println( "Datos de Entrada       -- " + queryName + " -- " + bbvaAbstractValueObject );
			//	TODO: Programacion defensiva. ¿Nos protegemos de fuego amigo?
			if ( queryName == null || queryName.equals( "" ) ) 	throw new BbvaDataBaseException( "" );
			if ( bbvaAbstractValueObject == null ) 				throw new BbvaDataBaseException( "" );

			//	Ejecutamos la consulta de modificacion.
			final	Integer affectedRows =	( queryName.equals( "create" ) ? this.getSqlSession().insert( "", bbvaAbstractValueObject ) :
												( queryName.equals( "update" ) ? this.getSqlSession().update( "", bbvaAbstractValueObject ) :
																					this.getSqlSession().update( "", bbvaAbstractValueObject ) ) );
			//	TODO: ¿Si la consulta no afecta registros lanzamos una excepcion? 
			if ( affectedRows == null || affectedRows == 0 )	throw new BbvaDataBaseException( "" );
			//	TODO: Si la consulta es create ¿Consultamos nuevamente el objeto para traer los id?
			final	BbvaAbstractValueObject
					bbvaAbstractVO	= queryName.equals( "create" ) ? this.queryForObject( "read" ) : bbvaAbstractValueObject;

			System.out.println( "Datos de Salida                    -- " + bbvaAbstractVO );
			System.out.println( "Salida -- queryForObject Ejecutado -- OK" );
			return (T)bbvaAbstractVO;
			} 
		catch ( Exception exception ) 
			{
			throw new BbvaDataBaseException( exception );
			}
		}
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject#queryForList(java.lang.String)
	 */
	public <T extends BbvaAbstractValueObject> List< T > queryForList ( final java.lang.String queryName )
	throws mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException
		{
		try {
			System.out.println( "Entrada queryForList -- OK" );
			System.out.println( "Datos de Entrada     -- " + queryName );
			//	Ejecutamos la consulta de lectura.
			final	List<T>	list = this.getSqlSession().selectList( "mx.com.bbva.bancomer.mapper.persistence.sqlmapping.BbvaEstatusMapper.readBbvaEstatusVO" );
			//	TODO: ¿Si la consulta no trae registros lanzamos una excepcion? 
			if ( list == null || list.isEmpty() )	throw new BbvaDataBaseException( "" );
			//	Impimimos el resultado
			if ( logger.isInfoEnabled() )
				for ( final T bbvaAbstractValueObject : list )
					System.out.println( "Datos de Salida                    -- " + bbvaAbstractValueObject.toString() );
			//	Regresamos la lista.
			System.out.println( "Salida -- queryForList Ejecutado -- OK" );
			return list;
			} 
		catch ( Exception exception ) 
			{
			throw new BbvaDataBaseException( exception );
			}
		}
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject#queryForList(java.lang.String, java.util.Map)
	 */
	public <T extends BbvaAbstractValueObject> List< T > queryForList (	final java.lang.String queryName, final T bbvaAbstractValueObject )
	throws mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException
		{
		try {
			System.out.println( "Entrada queryForList -- OK" );
			System.out.println( "Datos de Entrada       -- " + queryName + " -- " + bbvaAbstractValueObject );
			//	TODO: Programacion defensiva. ¿Nos protegemos de fuego amigo?
			if ( queryName == null || queryName.equals( "" ) ) 	throw new BbvaDataBaseException( "" );
			if ( bbvaAbstractValueObject == null ) 				throw new BbvaDataBaseException( "" );

			//	Ejecutamos la consulta de lectura que regresa una lista.
			if ( queryName.equals( "read" ) )
				{
				final	List<T> list = this.getSqlSession().selectList( "", bbvaAbstractValueObject );
				//	TODO: ¿Si la consulta no trae registros lanzamos una excepcion? 
				if ( list == null || list.isEmpty() )	throw new BbvaDataBaseException( "" );
				//	Impimimos el resultado
				if ( logger.isInfoEnabled() )
					for ( final T bbvaAbstractVO : list )
						System.out.println( "Datos de Salida                    -- " + bbvaAbstractVO.toString() );
				
				//	Regresamos la lista.
				System.out.println( "Salida -- queryForList Ejecutado -- OK" );
				return list;
				}
			//	Ejecutamos la consulta de actulizacion|eliminacion.
			final	Integer affectedRows = ( queryName.equals( "update" ) ? this.getSqlSession().update( "", bbvaAbstractValueObject ) :
																			this.getSqlSession().update( "", bbvaAbstractValueObject ) );
			//	TODO: ¿Si la consulta no afecta registros lanzamos una excepcion? 
			if ( affectedRows == null || affectedRows == 0 )	throw new BbvaDataBaseException( "" );
			//	TODO: Si la consulta es create ¿Consultamos nuevamente los objeto modificados?
			final	List<T> list = this.getSqlSession().selectList( "", bbvaAbstractValueObject );
			//	Impimimos el resultado
			if ( logger.isInfoEnabled() )
				for ( final T bbvaAbstractVO : list )
					System.out.println( "Datos de Salida                    -- " + bbvaAbstractVO.toString() );

			System.out.println( "queryForList Ejecutado -- OK" );
			System.out.println( "Datos de Salida        -- " + "" );
			return list;
			} 
		catch ( Exception exception ) 
			{
			throw new BbvaDataBaseException( exception );
			}
		}
	}