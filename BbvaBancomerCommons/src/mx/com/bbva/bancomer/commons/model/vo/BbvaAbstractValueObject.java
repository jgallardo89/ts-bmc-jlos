package mx.com.bbva.bancomer.commons.model.vo;

import java.lang.reflect.Method;

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
public 	abstract class 		BbvaAbstractValueObject 
				 implements java.io.Serializable 
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	private static final long 						serialVersionUID	= -966884264279020290L;
	private static final org.apache.log4j.Logger 	logger				= Logger.getLogger( BbvaAbstractValueObject.class );

	//  Metodos       - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Publicos
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public java.lang.String toString()
		{
		//	En este nivel solo se debe permitir registro de bitacora a nivel de depuracion.
		//	Un nivel mas alto puede interferir en el desempeño de la aplicacion.
		logger.trace( "Entrada toString -- OK" );

		//	Creamos un buffer para la representacion texto plano del objeto actual.
		//	En primer lugar imprimimos el nombre de la clase.
		final	StringBuffer stringBuffer = new StringBuffer( "[" + this.getClass().getSimpleName() + ":" );

		try {
			//	Obtenemos todos lo metodos de la clase -Constructores, propiedades, heredados de Object-
			final Method[] methodList = this.getClass()
			                                .getDeclaredMethods();

			//	Recorremos el arreglo y filtramos para obtener solamente los metodos get.
			//	Impime correctamente atributos de tipo: primitivo, Cadena, Booleano, Wrappers, List, VO, DTO.
			for ( final Method method : methodList )
				if ( method.getName()
				           .startsWith( "get" ) )
					try	{
						logger.trace( "Agregando atributo --" + method.getName().substring( 3 ) + "--" );
						stringBuffer.append( method.getName().substring( 3 ) + "=" + method.invoke( this ) + "," );
						}
					catch ( Exception exception ) 
						{
						// FIXME: Verificar si se lanza algun tipo de excepcion de infraestructura en este punto.
						logger.warn( "Error al agregar atributo --" + method.getName().substring( 3 ) + "--" + exception.getMessage() );
						}

			//	La cadena se construyo exitosamente.
			stringBuffer.append( "]" );
			logger.trace( "Datos de Salida toString -- " + stringBuffer.toString().replaceFirst( ",]", "]" ) );
			logger.trace( "Salida toString          -- OK" );
			} 
		catch ( SecurityException securityException ) 
			{
			//	FIXME: Existen restricciones de seguridad para el usuario que ejecuta el contenedor web|ejb.
			//         Verificar si se lanza algun tipo de excepcion de infraestructura en este punto.
			logger.warn( "Error en toString --" + securityException.getMessage() );
			}
		return stringBuffer.toString()
		                   .replaceFirst( ",]", "]" );
		}
	}