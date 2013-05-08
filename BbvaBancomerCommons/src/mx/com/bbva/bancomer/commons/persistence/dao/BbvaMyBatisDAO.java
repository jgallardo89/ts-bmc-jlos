package mx.com.bbva.bancomer.commons.persistence.dao;

import java.lang.reflect.Method;
import java.util.ArrayList;
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
	//	Privados	
	/**
	 * <b>validateQueryStructure</b>
	 * Programacion defensiva. ¿Nos protegemos de fuego amigo?
	 * Cualquier error en la invocacion de las consultas a base de datos es capturado en este metodo.
	 * Estos errores no deberian ocurrir, por lo tanto, sera una error de construccion en la cadena
	 * de invocacion al mismo.
	 * @param queryName - parametros de consulta contruidos de la siguiente manera: Nombre del Mapeador de MyBatis|Nombre del metodo a invocar,
	 *                    por ejemplo, ConsultarCatalogoMapper|readBbvaEstatusVO
	 * @return java.lang.String - cadena de consulta para MyBatis con el nombre calificado completo del mapeador y el metodo de la consulta,
	 *                            por ejemplo, mx.com.bbva.bancomer.mapper.persistence.sqlmapping.BbvaMantenimientoCatalogoMapper.readBbvaEstatusVO
	 * @throws mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException
	 */
	private java.lang.String validateQueryStructure( final java.lang.String queryName, final BbvaAbstractValueObject bbvaAbstractValueObject )
	throws mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException
		{
		logger.debug( "Entrada validateQueryStructure -- OK" );
		logger.debug( "Datos de Entrada               -- " + queryName );
		try {
			//	Programacion Defensiva: Verificamos el contenido del parametro queryName.
			if ( queryName == null || queryName.trim().equals( "" ) )
				throw new BbvaDataBaseException( "9950|validateQueryStructure|BbvaMyBatisDAO" );

			//	                        Verificamos la existencia de alguna de las 4 operaciones basicas.
			if ( !queryName.contains( "create" ) && !queryName.contains( "read" ) && 
					!queryName.contains( "update" ) && !queryName.contains( "delete" ) )
				throw new BbvaDataBaseException( "9951|validateQueryStructure|BbvaMyBatisDAO" );
			logger.debug( "Operacion de Base de Datos -- OK" );
			//	                        Verificamos cada uno de los elementos de la consulta.
			final String[] stringSplit = queryName.split("[|]");
			if ( stringSplit.length != 2 )
				throw new BbvaDataBaseException( "9952|validateQueryStructure|BbvaMyBatisDAO" );
			logger.debug( "queryName -- OK" );

			//	                        Verificamos la existencia del mapeador.
			final Class<?> clase       = Class.forName( BbvaIDataAccessObject.MYBATISSQLMAPPERPACKAGE + stringSplit[0] );
			logger.debug( clase.getName() + " -- Existe -- OK" );

			//	                        Verificamos la existencia del metodo.
			final Method metodo        = bbvaAbstractValueObject == null ? clase.getMethod( stringSplit[1] ) :
				                                                           clase.getMethod( stringSplit[1], bbvaAbstractValueObject.getClass() );
			logger.debug( metodo.getName() + " -- Existe -- OK" );

			//	Impimimos el resultado.
			logger.debug( "Datos de Salida                            -- " + clase.getName() + "." + metodo.getName() );
			logger.debug( "Salida -- validateQueryStructure Ejecutado -- OK" );
			return clase.getName() + "." + metodo.getName();
			} 
		catch ( BbvaDataBaseException bbvaDataBaseException ) 
			{	throw bbvaDataBaseException;				}
		catch ( Exception exception ) 
			{	throw new BbvaDataBaseException( "9906|validateQueryStructure|BbvaMyBatisDAO", exception );		}
		}
	//  Metodos       - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Publicos	
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject#queryForObject(java.lang.String)
	 */
	public synchronized <T extends BbvaAbstractValueObject> T queryForObject ( final java.lang.String queryName )
	throws mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException
		{
		logger.debug( "Entrada queryForObject -- OK" );
		logger.debug( "Datos de Entrada       -- " + queryName );
		try {
			//	Verificamos que solo sea consulta.
			if ( !queryName.contains( "read" ) )
				throw new BbvaDataBaseException( "9953|validateQueryStructure|BbvaMyBatisDAO" );
			logger.debug( "Operacion read permitida -- OK" );
			
			//	Ejecutamos la consulta de lectura.
			final T t = this.getSqlSession().selectOne( this.validateQueryStructure( queryName, null ) );

			//	TODO: ¿Si la consulta no trae registros lanzamos una excepcion? 
			if ( t == null )
				throw new BbvaDataBaseException( "9954|queryForObject|BbvaMyBatisDAO" );

			//	Impimimos el resultado.
			//	Regresamos el primer elemento de la lista.
			logger.debug( "Datos de Salida                    -- " + t.toString() );
			logger.debug( "Salida -- queryForObject Ejecutado -- OK" );
			return t;
			} 
		catch ( BbvaDataBaseException bbvaDataBaseException ) 
			{	throw bbvaDataBaseException;				}
		catch ( Exception exception ) 
			{	throw new BbvaDataBaseException( "9906|queryForObject|BbvaMyBatisDAO", exception );		}
		}
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject#queryForObject(java.lang.String, BbvaAbstractValueObject)
	 */
	public synchronized <T extends BbvaAbstractValueObject> T queryForObject ( 	final java.lang.String queryName, 
	                                                                            final T bbvaAbstractValueObject )
	throws mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException
		{
		logger.debug( "Entrada queryForObject -- OK" );
		logger.debug( "Datos de Entrada       -- " + queryName + " -- " + bbvaAbstractValueObject );
		try {
			//	Verificamos validez del parametro queryName.
			String query = this.validateQueryStructure( queryName, bbvaAbstractValueObject );
			logger.debug( "Operacion create|read|update|delete permitida -- OK" );

			//	Verificamos el parametro bbvaAbstractValueObject.
			if ( bbvaAbstractValueObject == null )
				throw new BbvaDataBaseException( "9954|queryForObject|BbvaMyBatisDAO" );

			//	Ejecutamos la consulta.
			int affectedRows = 0;
			if ( query.contains( "create" ) ) affectedRows = this.getSqlSession().insert	( query, bbvaAbstractValueObject );
			if ( query.contains( "update" ) ) affectedRows = this.getSqlSession().update	( query, bbvaAbstractValueObject );
			if ( query.contains( "delete" ) ) affectedRows = this.getSqlSession().delete	( query, bbvaAbstractValueObject );

			//	TODO: ¿Si la consulta no afecta registros lanzamos una excepcion? 
			if ( affectedRows == 0 && !query.contains( "read" ) )
				throw new BbvaDataBaseException( "9955|queryForObject|BbvaMyBatisDAO" );

			//	TODO: Si la consulta es create ¿Consultamos nuevamente el objeto para traer los id's?
			if ( query.contains( "create" ) ) query = query.replace( "create", "readByAllRequired" );
			if ( query.contains( "read" ) )
				{
				final T t = this.getSqlSession().selectOne( query, bbvaAbstractValueObject );
			
				//	TODO: ¿Si la consulta no trae registros lanzamos una excepcion? 
				if ( t == null )
					throw new BbvaDataBaseException( "9956|queryForObject|BbvaMyBatisDAO" );

				//	Impimimos el resultado.
				logger.debug( "Datos de Salida                    -- " + t );
				logger.debug( "Salida -- queryForObject Ejecutado -- OK" );
				return t;
				}
			//	Impimimos el resultado.
			logger.debug( "Datos de Salida                    -- " + bbvaAbstractValueObject );
			logger.debug( "Salida -- queryForObject Ejecutado -- OK" );
			return bbvaAbstractValueObject;
			} 
		catch ( BbvaDataBaseException bbvaDataBaseException ) 
			{	throw bbvaDataBaseException;				}
		catch ( Exception exception ) 
			{	throw new BbvaDataBaseException( "9906|queryForObject|BbvaMyBatisDAO", exception );		}
		}
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject#queryForList(java.lang.String)
	 */
	public synchronized <T extends BbvaAbstractValueObject> java.util.List< T > queryForList ( final java.lang.String queryName )
	throws mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException
		{
		logger.debug( "Entrada queryForList -- OK" );
		logger.debug( "Datos de Entrada     -- " + queryName );
		try {
			//	Verificamos que solo sea consulta.
			if ( !queryName.contains( "read" ) )
				throw new BbvaDataBaseException( "9957|validateQueryStructure|BbvaMyBatisDAO" );
			logger.debug( "Operacion read permitida -- OK" );

			//	Ejecutamos la consulta de lectura.
			final	List<T>	list = this.getSqlSession().selectList( this.validateQueryStructure( queryName, null ) );

			//	TODO: ¿Si la consulta no trae registros lanzamos una excepcion? 
			if ( list == null || list.isEmpty() )
				throw new BbvaDataBaseException( "9958|queryForList|BbvaMyBatisDAO" );

			//	Impimimos el resultado.
			for ( final T bbvaAbstractValueObject : list )
				logger.debug( "Datos de Salida                    -- " + bbvaAbstractValueObject.toString() );

			//	Regresamos la lista.
			logger.debug( "Salida -- queryForObject Ejecutado -- OK" );
			return list;
			} 
		catch ( BbvaDataBaseException bbvaDataBaseException ) 
			{	throw bbvaDataBaseException;				}
		catch ( Exception exception ) 
			{	throw new BbvaDataBaseException( "9906|queryForObject|BbvaMyBatisDAO", exception );		}
		}
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject#queryForList(java.lang.String, java.util.Map)
	 */
	public synchronized <T extends BbvaAbstractValueObject> java.util.List< T > queryForList ( final java.lang.String queryName, 
			                                                                                   final T bbvaAbstractValueObject )
	throws mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException
		{
		logger.debug( "Entrada queryForList -- OK" );
		logger.debug( "Datos de Entrada       -- " + queryName + " -- " + bbvaAbstractValueObject );
		try {
			//	Verificamos validez del parametro queryName.
			String query = this.validateQueryStructure( queryName, bbvaAbstractValueObject );

			//	Verificamos que solo sea consulta o actualizacion.
			if ( queryName.contains( "create" ) )
				throw new BbvaDataBaseException( "9959|validateQueryStructure|BbvaMyBatisDAO" );
			logger.debug( "Operacion read|update|delete permitida -- OK" );

			//	Verificamos el parametro bbvaAbstractValueObject.
			if ( bbvaAbstractValueObject == null )
				throw new BbvaDataBaseException( "9960|queryForList|BbvaMyBatisDAO" );

			//	Ejecutamos la consulta.
			int affectedRows = 0;
			if ( query.contains( "update" ) ) affectedRows = this.getSqlSession().update	( query, bbvaAbstractValueObject );
			if ( query.contains( "delete" ) ) affectedRows = this.getSqlSession().delete	( query, bbvaAbstractValueObject );

			//	TODO: ¿Si la consulta no afecta registros lanzamos una excepcion? 
			if ( affectedRows == 0 )
				throw new BbvaDataBaseException( "9961|queryForList|BbvaMyBatisDAO" );

			//	TODO: ¿Consultamos la lista para todos los objetos actualizados?
			query = query.replaceAll( "[update|delete]", "read" );

			final List<T> list = this.getSqlSession().selectList( query, bbvaAbstractValueObject );
			
			//	TODO: ¿Si la consulta no trae registros lanzamos una excepcion? 
			if ( list == null || list.isEmpty() )	throw new BbvaDataBaseException( "9962|queryForList|BbvaMyBatisDAO" );

			//	Impimimos el resultado.
			for ( final T t : list )
				logger.debug( "Datos de Salida                    -- " + t.toString() );
				
			//	
			logger.debug( "Salida -- queryForList Ejecutado -- OK" );
			return list;
			} 
		catch ( BbvaDataBaseException bbvaDataBaseException ) 
			{	throw bbvaDataBaseException;				}
		catch ( Exception exception ) 
			{	throw new BbvaDataBaseException( "9906|queryForList|BbvaMyBatisDAO", exception );		}
		}
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject#queryForList(java.lang.String, java.util.List)
	 */
	public synchronized <T extends BbvaAbstractValueObject> java.util.List< T > queryForList( final java.lang.String queryName, 
			                                                                                  final java.util.List< T > list )
	throws mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException
		{
		logger.debug( "Entrada queryForList -- OK" );
		logger.debug( "Datos de Entrada       -- " + queryName + " -- " + list );
		try {
			//	Verificamos validez del parametro queryName.
			String query = this.validateQueryStructure( queryName, list.get( 0 ) );

			//	Verificamos que solo sea consulta.
			if ( !queryName.contains( "create" ) )
				throw new BbvaDataBaseException( "9963|queryForList|BbvaMyBatisDAO" );
			logger.debug( "Operacion create permitida -- OK" );

			//	Verificamos el parametro bbvaAbstractValueObject.
			if ( list == null || list.isEmpty() )
				throw new BbvaDataBaseException( "9964|queryForList|BbvaMyBatisDAO" );

			//	Ejecutamos la consulta.
			int affectedRows = 0;
			for ( final T t : list ) 
				affectedRows += this.getSqlSession().insert	( query, t );

			//	TODO: ¿Si la consulta no registro nada lanzamos una excepcion? 
			if ( affectedRows == 0 )
				throw new BbvaDataBaseException( "9965|queryForList|BbvaMyBatisDAO" );
			//	TODO: ¿Si la lista y el numero de registros insertados no coinciden lanzamos una excepcion? 
			if ( affectedRows != list.size() )
				throw new BbvaDataBaseException( "9966|queryForList|BbvaMyBatisDAO" );

			//	TODO: ¿Consultamos la lista para todos los objetos insertados?
			//	
			query = query.replace( "create", "readByAllRequired" );
			final	List< T > tempList = new ArrayList< T >();
			for ( final T t : list ) 
				{
				final T tempT = this.getSqlSession().selectOne( query, t );
				tempList.add( tempT );
				//	Impimimos el resultado.
				logger.debug( "Datos de Salida                    -- " + tempT.toString() );
				}
			//	
			logger.debug( "Salida -- queryForList Ejecutado -- OK" );
			return tempList;
			} 
		catch ( BbvaDataBaseException bbvaDataBaseException ) 
			{	throw bbvaDataBaseException;				}
		catch ( Exception exception ) 
			{	throw new BbvaDataBaseException( "9906|queryForObject|BbvaMyBatisDAO", exception );		}
		}
	}