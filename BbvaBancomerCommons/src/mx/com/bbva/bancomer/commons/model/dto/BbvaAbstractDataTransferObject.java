package mx.com.bbva.bancomer.commons.model.dto;

import java.io.ByteArrayOutputStream;

import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

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
	private static final long 				serialVersionUID = 5098322529138213759L;
	private static final java.lang.String 	XMLHEADER 		 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
	//	Publicos|estaticos
	public  static final java.lang.String 	RESPONSECODEOK 	 = "0000";
	public  static final java.lang.String 	RESPONSEDESCOK 	 = "OK";

	//	Privados
	private java.lang.String errorCode			=	BbvaAbstractDataTransferObject.RESPONSECODEOK;
	private java.lang.String errorDescription	=	BbvaAbstractDataTransferObject.RESPONSEDESCOK;

	//	Propiedades
	public java.lang.String getErrorCode() 										{	return errorCode;							}
	public void setErrorCode( final java.lang.String errorCode ) 				{	this.errorCode = errorCode;					}

	public java.lang.String getErrorDescription() 								{	return errorDescription;					}
	public void setErrorDescription( final java.lang.String errorDescription ) 	{	this.errorDescription = errorDescription;	}

	//  Metodos       - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	
	/**
	 * <b>toString</b>
	 * @param 	stringType - tipo de cadena de retorno XML|JSON
	 * @return	java.lang.String
	 */
	public java.lang.String toString( final java.lang.String stringType )
		{
		try {
			//
			if ( stringType.equals( BbvaAbstractValueObject.JSON ) ) return JSONSerializer.toJSON( this ).toString();

			//
			final 	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

			final	Serializer 
					serializer = new Persister();
					serializer.write( this, byteArrayOutputStream );
			//
			return BbvaAbstractDataTransferObject.XMLHEADER + byteArrayOutputStream.toString();
			} 
		catch ( Exception exception ) 
			{
			final	String	stringError = BbvaAbstractDataTransferObject.XMLHEADER +
										  "<bbvaAbstractValueObject><errorCode>9999</errorCode>" +
										                           "<errorDescription>Error al convertir " + this.getClass().getSimpleName() + 
										                                            " en cadena " + stringType + "</errorDescription>" +
										  "</bbvaAbstractValueObject>";

			return stringType.equals( BbvaAbstractValueObject.XML ) ? stringError :
																	( (JSONArray) new XMLSerializer().read( stringError ) ).toString(); 
			}
		}
	}