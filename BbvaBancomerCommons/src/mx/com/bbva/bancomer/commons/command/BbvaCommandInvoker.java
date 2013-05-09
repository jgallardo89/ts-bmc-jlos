package mx.com.bbva.bancomer.commons.command;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject;
import mx.com.bbva.bancomer.commons.exception.BbvaBusinessException;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
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
 * 30-ABR-2013  F. Emmanuel Chavarria Ortiz		Creacion        1.0.0
 *              femmanuel.chavarriao@gmail.com
 *              Consultoria
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
public 	class 		BbvaCommandInvoker 
		implements 	BbvaICommandInvoker 
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	private static final org.apache.log4j.Logger 	logger			 = Logger.getLogger( BbvaAbstractValueObject.class );

	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados
	private static java.util.Properties dtoMap;
	private static java.util.Properties	cmdMap;
	private static java.util.Map< java.lang.String, mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject > boMap;

	//	Propiedades
//	public java.util.Map<java.lang.String, java.lang.String> getDtoMap()
//		{	return dtoMap;					}
	public void setDtoMap( final java.util.Properties dtoMap )
		{	if ( BbvaCommandInvoker.dtoMap == null ) BbvaCommandInvoker.dtoMap = dtoMap;			}

//	public java.util.Map<java.lang.String, mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject> getBoMap()
//		{	return boMap;					}
	public void setBoMap( final java.util.Map< java.lang.String, mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject > boMap )
		{	if ( BbvaCommandInvoker.boMap == null ) BbvaCommandInvoker.boMap = boMap;				}

//	public java.util.Map<java.lang.String, java.lang.String> getCmdMap()
//		{	return cmdMap;					}
	public void setCmdMap( final java.util.Properties cmdMap )
		{	if ( BbvaCommandInvoker.dtoMap == null ) BbvaCommandInvoker.cmdMap = cmdMap;			}

	//  Constructor   - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	
	/**
	 * <b>BbvaCommandInvoker</b>
	 */
	public BbvaCommandInvoker ( )
		{
		logger.info ( "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
		logger.info ( "Constructor BbvaCommandInvoker -- OK" );
		logger.info ( "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
		}
	/**
	 * <b>BbvaCommandInvoker</b>
	 * @param dtoMap
	 * @param cmdMap
	 * @param boMap
	 */
	public BbvaCommandInvoker (	final java.util.Properties dtoMap,
	                            final java.util.Properties cmdMap,
	                            final java.util.Map< java.lang.String, mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject > boMap )
		{
		logger.info ( "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
		logger.info ( "Constructor BbvaCommandInvoker -- OK" );
		if ( BbvaCommandInvoker.dtoMap == null )
			{
			logger.debug( "Datos de Entrada                       -- " + dtoMap );
			BbvaCommandInvoker.dtoMap = dtoMap;
			}

		if ( BbvaCommandInvoker.cmdMap == null )
			{
			logger.debug( "Datos de Entrada                       -- " + cmdMap );
			BbvaCommandInvoker.cmdMap = cmdMap;
			}

		if ( BbvaCommandInvoker.boMap == null )
			{
			logger.debug( "Datos de Entrada                       -- " + boMap );
			BbvaCommandInvoker.boMap = boMap;
			}
		logger.info ( "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
		}

	//  Metodos       - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.command.BbvaICommandInvoker#invoke(T)
	 */
	@SuppressWarnings("unchecked")
	public < T extends BbvaAbstractDataTransferObject > T invoke ( final T bbvaAbstractDataTransferObject )
	throws mx.com.bbva.bancomer.commons.exception.BbvaBusinessException
		{
		//	Recibimos mensaje de la capa de presentacion.
		//	En este nivel solo se debe permitir registro de bitacora a nivel de depuracion.
		//	Un nivel mas alto puede interferir en el desempeño de la aplicacion.
		logger.debug( "Entrada invoke          -- OK" );
		logger.debug( "Datos de Entrada invoke -- " + bbvaAbstractDataTransferObject.toString() );

		//	Obtenemos el nombre de DTO.
		final	String dtoName 	= bbvaAbstractDataTransferObject.getClass()
																.getSimpleName();
		//	Buscamos dentro de nuestro mapeo DTO - BO.
		//	Primero obtenemos el ID del Objeto de Negocio. Con ese ID obtenemos el BO. 
		final	String 				boId				= (String)BbvaCommandInvoker.dtoMap.get( dtoName );
		final	BbvaIBusinessObject bbvaIBusinessObject	= BbvaCommandInvoker.boMap.get	( boId	  );
		logger.debug( "Objeto de Negocio       -- " + bbvaIBusinessObject.getClass() );
		try {
			//	Obtenemos la accion que se debe ejecutar.
			final	String	commandAction	= (String)BbvaCommandInvoker.cmdMap.get( bbvaAbstractDataTransferObject.getCommandId().toString() );

			//	Obtenemos el metodo que se debe ejecutar.
			final	Method method	= bbvaIBusinessObject.getClass()
														 .getMethod( commandAction, bbvaAbstractDataTransferObject.getClass() );

			//	Ejecutamos el metodos pasandole bbvaAbstractDataTransferObject como parametro.
			final 	BbvaAbstractDataTransferObject
					bbvaAbstractDTO = ( BbvaAbstractDataTransferObject ) method.invoke( bbvaIBusinessObject, bbvaAbstractDataTransferObject );

			//	Si la respuesta es diferente de 0000 construimos una excepcion de negocio y la lanzamos.
			if ( !bbvaAbstractDTO.getErrorCode().equals( BbvaAbstractDataTransferObject.RESPONSECODEOK ) )	
				throw new BbvaBusinessException( bbvaAbstractDTO.getErrorCode() + "|BbvaCommandInvoker|invoke"  );

			//	Regresamos a la capa de presentacion.
			logger.debug( "Datos de Salida invoke -- " + bbvaAbstractDTO.toString() );
			logger.debug( "Salida invoke          -- OK" );
			return ( T ) bbvaAbstractDTO;
			} 
		catch ( Exception exception ) 
			{
			//	FIXME: Verificar los codigos de error y sus respectivos mensajes.
			//	       Cualquier error de invocacion es responsabilidad de la implementacion, es decir, algo esta mal en la configuracion
			//         de Spring de estos componentes. 
			String errorCode = "";
			if ( exception instanceof SecurityException 		)	errorCode= "8899" ;
			if ( exception instanceof NoSuchMethodException 	)	errorCode= "8898" ;
			if ( exception instanceof IllegalArgumentException 	)	errorCode= "8897" ;
			if ( exception instanceof IllegalAccessException 	)	errorCode= "8896" ;
			if ( exception instanceof InvocationTargetException )	errorCode= "8896" ;

			throw new BbvaBusinessException( errorCode + "|BbvaCommandInvoker|invoke", exception );
			} 
		}
	}