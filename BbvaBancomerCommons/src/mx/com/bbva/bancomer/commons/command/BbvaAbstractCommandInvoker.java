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
public class BbvaAbstractCommandInvoker 
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	private static final org.apache.log4j.Logger 	logger			 = Logger.getLogger( BbvaAbstractValueObject.class );

	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados
	//	FIXME: Esta configuracion se puede granularizar en archivos de propiedades.
	private java.util.Map< java.lang.String, java.lang.String > 											dtoMap;
	private java.util.Map< java.lang.String, mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject > 	boMap;
	private java.util.Map< java.lang.String, java.lang.String >												cmdMap;

	//	Propiedades
//	public final java.util.Map<java.lang.String, java.lang.String> getDtoMap()
//		{	return dtoMap;					}
	public final void setDtoMap( final java.util.Map< java.lang.String, java.lang.String > dtoMap )
		{	this.dtoMap = dtoMap;			}

//	public final java.util.Map<java.lang.String, mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject> getBoMap()
//		{	return boMap;					}
	public final void setBoMap( final java.util.Map< java.lang.String, mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject > boMap )
		{	this.boMap = boMap;				}

//	public final java.util.Map<java.lang.String, java.lang.String> getCmdMap()
//		{	return cmdMap;					}
	public final void setCmdMap( final java.util.Map< java.lang.String, java.lang.String > cmdMap )
		{	this.cmdMap = cmdMap;			}
	
	//  Metodos       - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	
	/**
	 * <b>invoke</b>
	 * Invocacion generica de un Objeto de Negocio -POJO, EJB, WS, RMI- identificado mediante la relacion de la firma de sus metodos.
	 * 
	 * @param <T> - bbvaAbstractDataTransferObject - Bean contenedor especifico para cada caso de uso.
	 * @return mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject
	 * @throws mx.com.bbva.bancomer.commons.exception.BbvaBusinessException
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
		final	String 				boId				= dtoMap.get( dtoName );
		final	BbvaIBusinessObject bbvaIBusinessObject	= boMap.get	( boId	  );
		logger.debug( "Objeto de Negocio       -- " + bbvaIBusinessObject.getClass() );
		try {
			//	Obtenemos la accion que se debe ejecutar.
			final	String	commandAction	= cmdMap.get( bbvaAbstractDataTransferObject.getCommandId()
																						.toString() );

			//	Obtenemos el metodo que se debe ejecutar.
			final	Method method	= bbvaIBusinessObject.getClass()
														 .getMethod( commandAction, bbvaAbstractDataTransferObject.getClass() );

			//	Ejecutamos el metodos pasandole bbvaAbstractDataTransferObject como parametro.
			final 	BbvaAbstractDataTransferObject
					bbvaAbstractDTO = ( BbvaAbstractDataTransferObject ) method.invoke( bbvaIBusinessObject, bbvaAbstractDataTransferObject );

			//	Si la respuesta es diferente de 0000 construimos una excepcion de negocio y la lanzamos.
			if ( !bbvaAbstractDTO.getErrorCode().equals( BbvaAbstractDataTransferObject.RESPONSECODEOK ) )	
				throw new BbvaBusinessException( bbvaAbstractDTO.getErrorCode(), bbvaAbstractDTO.getErrorDescription() );

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
			if ( exception instanceof SecurityException 		)	errorCode= "9998" ;
			if ( exception instanceof NoSuchMethodException 	)	errorCode= "9997" ;
			if ( exception instanceof IllegalArgumentException 	)	errorCode= "9996" ;
			if ( exception instanceof IllegalAccessException 	)	errorCode= "9995" ;
			if ( exception instanceof InvocationTargetException )	errorCode= "9994" ;

			throw new BbvaBusinessException( errorCode, exception.getMessage() + "\n" + exception.getCause() );
			} 
		}
	}	