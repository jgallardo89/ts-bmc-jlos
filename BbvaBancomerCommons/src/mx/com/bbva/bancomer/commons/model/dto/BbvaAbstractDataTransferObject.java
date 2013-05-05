package mx.com.bbva.bancomer.commons.model.dto;

import java.io.ByteArrayOutputStream;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

import org.apache.log4j.Logger;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

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
public 	abstract	class 	BbvaAbstractDataTransferObject 
					extends BbvaAbstractValueObject 
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	private static final long 						serialVersionUID = 5098322529138213759L;
	private static final org.apache.log4j.Logger 	logger			 = Logger.getLogger( BbvaAbstractValueObject.class );
	private static final java.lang.String 			XMLHEADER 		 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
	//	Publicos|estaticos
	public  static final java.lang.String 			RESPONSECODEOK 	 = "0000";
	public  static final java.lang.String 			RESPONSEDESCOK 	 = "OK";
	public 	static final java.lang.String 			XML				 = "xml";
	public 	static final java.lang.String 			JSON			 = "json";
	
	//	Privados
	private java.lang.String	errorCode			=	BbvaAbstractDataTransferObject.RESPONSECODEOK;
	private java.lang.String	errorDescription	=	BbvaAbstractDataTransferObject.RESPONSEDESCOK;
	private java.lang.Integer	commandId			=	new Integer ( 0 );

	//	Propiedades
	public java.lang.String getErrorCode() 										{	return errorCode;							}
	public void setErrorCode( final java.lang.String errorCode ) 				{	this.errorCode = errorCode;					}

	public java.lang.String getErrorDescription() 								{	return errorDescription;					}
	public void setErrorDescription( final java.lang.String errorDescription ) 	{	this.errorDescription = errorDescription;	}

	public final java.lang.Integer getCommandId() 								{	return commandId;							}
	public final void setCommandId( final java.lang.Integer commandId ) 		{	this.commandId = commandId;					}

	//  Metodos       - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	
	/**
	 * <b>toString</b>
	 * Obtiene una representacion como texto XML o JSON del objeto actual.
	 * @param 	stringType - tipo de cadena de retorno XML|JSON
	 * @return	java.lang.String
	 */
	public java.lang.String toString( final java.lang.String stringType )
		{
		//	En este nivel solo se debe permitir registro de bitacora a nivel de depuracion.
		//	Un nivel mas alto puede interferir en el desempeño de la aplicacion.
		logger.debug( "Entrada toString(String)          -- OK" );
		logger.debug( "Datos de Entrada toString(String) -- " + stringType );

		try {
			//	Convierte el objeto actual en su representacion JSON.
			if ( stringType.equals( BbvaAbstractDataTransferObject.JSON ) ) 
				{
				logger.debug( "Datos de Salida toString(String) -- " + JSONSerializer.toJSON( this ).toString() );
				logger.debug( "Salida toString(String)          -- OK" );
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
			logger.debug( "Datos de Salida toString(String) -- " + BbvaAbstractDataTransferObject.XMLHEADER + byteArrayOutputStream.toString() );
			logger.debug( "Salida toString(String)          -- OK" );
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