/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Informacion Confidencial:
 * Este software contiene informacion totalmente confidencial propiedad de Grupo Financiero BBVA Bancomer. 
 * Queda totalmente prohibido su uso o divulgacion en forma parcial o total y solamente podra ser utilizada de acuerdo a los terminos y estatutos 
 * que determine el Grupo Financiero BBVA Bancomer.
 * 
 * Todos los derechos reservados, Mexico 2013.
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * DESCRIPCION DEL PROGRAMA
 * Nombre de aplicación: MAPEADOR
 * Nombre de proyecto: BbvaBancomerCommons
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * HISTORIAL DE CAMBIOS:
 * 
 * Fecha:									         	
 * 30-ABR-2013  
 * @Author:	Jose Luis Ortiz Salazar
 * @Email: jortizsalazar@gmail.com    	
 * Razon: Creacion        
 * Version: 1.0.0
 * Nombre de clase: BbvaException.java
 * Nombre de paquete: mx.com.bbva.bancomer.commons.exception
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.commons.exception;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
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
/**
 * The Class BbvaException.
 */
public 	abstract class	 BbvaException 
				 extends java.lang.Exception 
	{
	//	Privados
	/** The error properties. */
	private static java.util.Properties errorProperties;
	
	/** The Constant logger. */
	private static final org.apache.log4j.Logger 	logger			 = Logger.getLogger( BbvaException.class );

	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	/** The Constant serialVersionUID. */
	private static final long 						serialVersionUID = -2912558963068489575L;
	
	/** The error code. */
	private java.lang.String			errorCode;
	
	/** The error description. */
	private java.lang.String			errorDescription;

	//  Constructores - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	
	/**
	 * <b>BbvaException</b>.
	 */
	public BbvaException( ) 
		{	super( );	}

	/**
	 * <b>BbvaException</b>.
	 *
	 * @param message the message
	 */
	public BbvaException( final java.lang.String message ) 
		{
		super( message );
		final	String[] splitString = message.split( "[|]" ); 
				errorCode 			= splitString[ 0 ];
				errorDescription	= BbvaException.errorProperties.getProperty( splitString[ 0 ] );

		logger.warn ( "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
		logger.warn ( "Excepcion   : " + this.getClass().getName()  );
		printDetail( splitString );
		}
	
	/**
	 * <b>BbvaException</b>.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public BbvaException( final java.lang.String message, java.lang.Throwable cause ) 
		{
		super( message, cause );
		final	String[] splitString = message.split( "[|]" ); 
				errorCode 			= splitString[ 0 ];
				errorDescription	= BbvaException.errorProperties.getProperty( splitString[ 0 ] );

		logger.warn ( "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
		logger.warn ( "Excepcion   : " + cause.getClass().getName() + " -- " + cause.getMessage() );
		logger.warn ( "Causa       : " + ( cause.getCause() == null ? "Sin causa aparente." : 
			                                                                cause.getCause().getClass().getName() + "--" + 
			                                                                cause.getCause().getMessage() ) );
		printDetail( splitString );
		}

	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public final java.lang.String getErrorCode() 										{	return errorCode;							}
	
	/**
	 * Gets the error description.
	 *
	 * @return the error description
	 */
	public final java.lang.String getErrorDescription() 								{	return errorDescription;					}

	//	Metodos - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//
	/**
	 * <b>printDetail</b>
	 * Imprime detalles de la excepcion.
	 *
	 * @param splitString the split string
	 */
	private void printDetail( final java.lang.String[] splitString )
		{
		logger.warn ( "Codigo      : " + splitString[ 0 ] );
		logger.warn ( "Origen      : " + splitString[ 1 ] );
		logger.warn ( "Metodo      : " + splitString[ 2 ] );
		logger.warn ( "Descripcion : " + BbvaException.errorProperties.getProperty( splitString[ 0 ] ) );
		logger.warn ( "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
		
		}
	
	/**
	 * Sets the error code.
	 *
	 * @param errorCode the new error code
	 */
	public final void setErrorCode( final java.lang.String errorCode ) 					{	this.errorCode = errorCode;					}
	
	/**
	 * Sets the error description.
	 *
	 * @param errorDescription the new error description
	 */
	public final void setErrorDescription( final java.lang.String errorDescription ) 	{	this.errorDescription = errorDescription;	}
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados
//	public final java.util.Properties getErrorProperties() 								{	return errorProperties;						}
	/**
	 * Sets the error properties.
	 *
	 * @param errorProperties the new error properties
	 */
	public final void setErrorProperties( final java.util.Properties errorProperties )
		{	if ( BbvaException.errorProperties == null ) BbvaException.errorProperties = errorProperties;		}
	}