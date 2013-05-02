package mx.com.bbva.bancomer.commons.command;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import mx.com.bbva.bancomer.commons.exception.persistence.BbvaBusinessException;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

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
	//	Privados
	private java.util.Map< java.lang.String, java.lang.String > dtoMap;
	private java.util.Map< java.lang.String, java.lang.Object > boMap;

	//	Propiedades
	public final java.util.Map<java.lang.String, java.lang.String> getDtoMap() 						{	return dtoMap;					}
	public final void setDtoMap( final java.util.Map< java.lang.String, java.lang.String > dtoMap )	{	this.dtoMap = dtoMap;			}

	public final java.util.Map<java.lang.String, java.lang.Object> getBoMap() 						{	return boMap;					}
	public final void setBoMap( final java.util.Map< java.lang.String, java.lang.Object > boMap ) 	{	this.boMap = boMap;				}

	//  Metodos       - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	

	public < T extends BbvaAbstractDataTransferObject > T invoke ( final T type )
	throws mx.com.bbva.bancomer.commons.exception.persistence.BbvaBusinessException
		{
		//
		final	String dtoName 	= type.getClass().getSimpleName();
		//
		final	String boId		= dtoMap.get( dtoName );
		final	Object bo		= boMap.get	( boId	  );

		//
		final	Class<?> clazz		= bo.getClass();
		//
		try {
			//
			final	Method method	= clazz.getMethod( "", type.getClass() );
			final 	BbvaAbstractDataTransferObject
					bbvaAbstractDataTransferObject = ( BbvaAbstractDataTransferObject )method.invoke( bo, type );
			//
			if ( !bbvaAbstractDataTransferObject.getErrorCode().equals( BbvaAbstractDataTransferObject.RESPONSECODEOK ) )	
				throw new BbvaBusinessException( type.getErrorCode(), type.getErrorDescription() );
			//
			return type;
			} 
		catch ( Exception exception ) 
			{
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