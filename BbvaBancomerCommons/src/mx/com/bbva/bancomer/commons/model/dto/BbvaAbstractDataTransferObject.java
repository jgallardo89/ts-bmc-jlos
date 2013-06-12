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
 * Nombre de clase: BbvaAbstractDataTransferObject.java
 * Nombre de paquete: mx.com.bbva.bancomer.commons.model.dto
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.commons.model.dto;

import java.io.ByteArrayOutputStream;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

import org.apache.log4j.Logger;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

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
 * 30-ABR-2013  F. Emmanuel Chavarria Ortiz		Creacion        1.0.0
 *              femmanuel.chavarriao@gmail.com
 *              Consultoria
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
/**
 * The Class BbvaAbstractDataTransferObject.
 */
public 	abstract	class 	BbvaAbstractDataTransferObject 
					extends BbvaAbstractValueObject 
	{
	/** The Constant JSON. */
	public 	static final java.lang.String 			JSON			 = "json";
	
	/** The Constant logger. */
	private static final org.apache.log4j.Logger 	logger			 = Logger.getLogger( BbvaAbstractValueObject.class );
	
	//	Publicos|estaticos
	/** The Constant RESPONSECODEOK. */
	public  static final java.lang.String 			RESPONSECODEOK 	 = "0000";
	/** The Constant RESPONSEDESCOK. */
	public  static final java.lang.String 			RESPONSEDESCOK 	 = "OK";
	
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	/** The Constant serialVersionUID. */
	private static final long 						serialVersionUID = 5098322529138213759L;
	
	/** The Constant XML. */
	public 	static final java.lang.String 			XML				 = "xml";
	
	/** The Constant XMLHEADER. */
	private static final java.lang.String 			XMLHEADER 		 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
	
	/** The command id. */
	private java.lang.Integer	commandId			=	new Integer ( 2 );
	
	//	Privados
	/** The error code. */
	private java.lang.String	errorCode			=	BbvaAbstractDataTransferObject.RESPONSECODEOK;
	
	/** The error description. */
	private java.lang.String	errorDescription	=	BbvaAbstractDataTransferObject.RESPONSEDESCOK;

	/**
	 * Gets the command id.
	 *
	 * @return the command id
	 */
	public final java.lang.Integer getCommandId() 								{	return commandId;							}
	
	//	Propiedades
	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public java.lang.String getErrorCode() 										{	return errorCode;							}

	/**
	 * Gets the error description.
	 *
	 * @return the error description
	 */
	public java.lang.String getErrorDescription() 								{	return errorDescription;					}
	
	/**
	 * Sets the command id.
	 *
	 * @param commandId the new command id
	 */
	public final void setCommandId( final java.lang.Integer commandId ) 		{	this.commandId = commandId;					}

	/**
	 * Sets the error code.
	 *
	 * @param errorCode the new error code
	 */
	public void setErrorCode( final java.lang.String errorCode ) 				{	this.errorCode = errorCode;					}
	
	/**
	 * Sets the error description.
	 *
	 * @param errorDescription the new error description
	 */
	public void setErrorDescription( final java.lang.String errorDescription ) 	{	this.errorDescription = errorDescription;	}

	//  Metodos       - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	
	/**
	 * <b>toString</b>
	 * Obtiene una representacion como texto XML o JSON del objeto actual.
	 *
	 * @param stringType the string type
	 * @return java.lang.String
	 */
	public java.lang.String toString( final java.lang.String stringType )
		{
		//	En este nivel solo se debe permitir registro de bitacora a nivel de depuracion.
		//	Un nivel mas alto puede interferir en el desempeño de la aplicacion.
		logger.trace( "Entrada toString(String)          -- OK" );
		logger.trace( "Datos de Entrada toString(String) -- " + stringType );

		try {
			//	Convierte el objeto actual en su representacion JSON.
			if ( stringType.equals( BbvaAbstractDataTransferObject.JSON ) ) 
				{
				logger.trace( "Datos de Salida toString(String) -- " + JSONSerializer.toJSON( this ).toString() );
				logger.trace( "Salida toString(String)          -- OK" );
				return JSONSerializer.toJSON( this )
				                     .toString();
				}

			//	Flujo de salida para almacenar la serializacion a XML.
			final 	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

			//	Convierte el objeto actual en su representacion XML.
			final	Serializer 
					serializer = new Persister();
					serializer.write( this, byteArrayOutputStream );

			//	Agregamos encabezado.
			logger.trace( "Datos de Salida toString(String) -- " + BbvaAbstractDataTransferObject.XMLHEADER + byteArrayOutputStream.toString() );
			logger.trace( "Salida toString(String)          -- OK" );
			return BbvaAbstractDataTransferObject.XMLHEADER + byteArrayOutputStream.toString();
			} 
		catch ( Exception exception ) 
			{
			//	FIXME: Verificar la representación estandar para la bitacora.
			//	       Cualquier error de conversion regresa mensaje en formato solicitado. 
			final	String	stringError = BbvaAbstractDataTransferObject.XMLHEADER +
										  "<bbvaAbstractValueObject><errorCode>9999</errorCode>" +
										                           "<errorDescription>Error al convertir " + this.getClass().getSimpleName() + 
										                                            " en cadena " + stringType + "</errorDescription>" +
										  "</bbvaAbstractValueObject>";
			logger.warn( stringError );
			return stringType.equals( BbvaAbstractDataTransferObject.XML ) ? stringError :
																			( (JSONArray) new XMLSerializer().read( stringError ) ).toString(); 
			}
		}
	}