package mx.com.bbva.bancomer.commons.exception;

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
 * 04-MAY-2013  F. Emmanuel Chavarria Ortiz		Creacion        1.0.0
 *              femmanuel.chavarriao@gmail.com
 *              Consultoria
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
public 	class 	BbvaException 
		extends java.lang.Exception 
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	private static final long serialVersionUID = -2912558963068489575L;
	private static final org.apache.log4j.Logger 	logger			 = Logger.getLogger( BbvaException.class );

	//	Privados
	private static java.util.Properties errorProperties;
	private java.lang.String			errorCode;
	private java.lang.String			errorDescription;

	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados
//	public final java.util.Properties getErrorProperties() 								{	return errorProperties;						}
	public final void setErrorProperties( final java.util.Properties errorProperties )
		{	if ( BbvaException.errorProperties == null ) BbvaException.errorProperties = errorProperties;		}

	public final java.lang.String getErrorCode() 										{	return errorCode;							}
	public final void setErrorCode( final java.lang.String errorCode ) 					{	this.errorCode = errorCode;					}

	public final java.lang.String getErrorDescription() 								{	return errorDescription;					}
	public final void setErrorDescription( final java.lang.String errorDescription ) 	{	this.errorDescription = errorDescription;	}

	//  Constructores - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	
	/**
	 * <b>BbvaException</b>
	 * @param message
	 */
	public BbvaException( final java.lang.String message ) 
		{
		super( message );
		final	String[] splitString = message.split( "[|]" ); 
				errorCode 			= splitString[ 0 ];
				errorDescription	= BbvaException.errorProperties.getProperty( splitString[ 0 ] );

		logger.warn( "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
		logger.warn( "Excepcion   : " + this.getClass().getName()  );
		logger.warn( "Codigo      : " + splitString[ 0 ] );
		logger.warn( "Origen      : " + splitString[ 1 ] );
		logger.warn( "Metodo      : " + splitString[ 2 ] );
		logger.warn( "Descripcion : " + errorProperties.getProperty( splitString[ 0 ] ) );
		logger.warn( "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
		}
	/**
	 * <b>BbvaException</b>
	 * @param message
	 * @param cause
	 */
	public BbvaException( final java.lang.String message, java.lang.Throwable cause ) 
		{
		super( message, cause );
		final	String[] splitString = message.split( "[|]" ); 
				errorCode 			= splitString[ 0 ];
				errorDescription	= BbvaException.errorProperties.getProperty( splitString[ 0 ] );

		logger.warn( "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
		logger.warn( "Excepcion   : " + cause.getClass().getName() + "--" + cause.getMessage() );
		logger.warn( "Causa       : " + cause.getCause().getClass().getName() + "--" + cause.getCause().getMessage() );
		logger.warn( "Codigo      : " + splitString[ 0 ] );
		logger.warn( "Origen      : " + splitString[ 1 ] );
		logger.warn( "Metodo      : " + splitString[ 2 ] );
		logger.warn( "Descripcion : " + errorProperties.getProperty( splitString[ 0 ] ) );
		logger.warn( "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
		}
	}