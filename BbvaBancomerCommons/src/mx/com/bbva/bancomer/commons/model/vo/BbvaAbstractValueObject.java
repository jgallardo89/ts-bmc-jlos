package mx.com.bbva.bancomer.commons.model.vo;

import java.lang.reflect.Method;
import java.util.Arrays;

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
	private static final long serialVersionUID = -966884264279020290L;

	//	Publicos|estaticos
	public static final java.lang.String XML	= "xml";
	public static final java.lang.String JSON	= "json";
	
	//  Metodos       - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Publicos
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public java.lang.String toString()
		{
		final	StringBuffer stringBuffer = new StringBuffer( "[" + this.getClass().getSimpleName() + ":" );
		
		try {
			//
			final Method[] methodList = this.getClass().getDeclaredMethods();
			Arrays.sort( methodList );
			//
			for ( final Method method : methodList )
				if ( method.getName().startsWith( "get" ) )
					try	{
						// TODO: Que imprime con Lista, Colecciones, Mapas, Arreglos
						stringBuffer.append( method.getName().substring( 3 ) + "=" + method.invoke( this ) + "," );
						}
					catch ( Exception exception ) 
						{
						// TODO: Eliminar despues de las pruebas unitarias
						// OJO:  Callar la excepcion
						exception.printStackTrace();
						}
			//
			stringBuffer.append( "]" );
			} 
		catch ( SecurityException securityException ) 
			{
			// TODO: Eliminar despues de las pruebas unitarias
			// OJO:  Callar la excepcion
			securityException.printStackTrace();
			}
		return stringBuffer.toString().replaceFirst( ",]", "]" );
		}
	}