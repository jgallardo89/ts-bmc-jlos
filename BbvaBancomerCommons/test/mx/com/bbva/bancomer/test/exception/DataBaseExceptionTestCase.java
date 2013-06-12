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
 * Nombre de clase: DataBaseExceptionTestCase.java
 * Nombre de paquete: mx.com.bbva.bancomer.test.exception
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.test.exception;

import mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException;

import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

// TODO: Auto-generated Javadoc
/**
 * The Class DataBaseExceptionTestCase.
 */
public class DataBaseExceptionTestCase 
	{
	static
		{
		new FileSystemXmlApplicationContext( "C:/workspace" +
				                               "/BbvaBancomerCommons" +
				                                 "/test/mx/com/bbva/bancomer/test/exception/application-context-exception.xml" );
		}

	/**
	 * Test bbva data base exception string.
	 */
	@Test
	public final void testBbvaDataBaseExceptionString() 
		{
		try	{
			if ( 1 + 1 == 2 )
				throw new BbvaDataBaseException( "9902|ExceptionTestCase|testBbvaDataBaseExceptionString" );
			}
		catch ( BbvaDataBaseException bbvaDataBaseException )
			{	bbvaDataBaseException.printStackTrace();	}
		}
//	Ejecucion de JUnit 
//	log4j:WARN No appenders could be found for logger (mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject).
//	log4j:WARN Please initialize the log4j system properly.
//	log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	Excepcion   : mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException
//	Codigo      : 9902
//	Origen      : ExceptionTestCase
//	Metodo      : testBbvaDataBaseExceptionString
//	Descripcion : Mensaje de Error de Base de Datos	3
//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	/**
 * Test bbva data base exception string throwable.
 */
@Test
	public final void testBbvaDataBaseExceptionStringThrowable() 
		{
		try	{
			if ( 1 + 1 == 2 )
				throw new BbvaDataBaseException(  "9903|ExceptionTestCase|testBbvaDataBaseExceptionStringThrowable", 
				                                  new NullPointerException( "Objeto Nulo Generado con proposito de Pruebas Unitarias." ) );
			}
		catch ( BbvaDataBaseException bbvaDataBaseException )
			{	bbvaDataBaseException.printStackTrace();	}
		}
//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	Excepcion   : java.lang.NullPointerException -- Objeto Nulo Generado con proposito de Pruebas Unitarias.
//	Causa       : Sin causa aparente.
//	Codigo      : 9903
//	Origen      : ExceptionTestCase
//	Metodo      : testBbvaDataBaseExceptionStringThrowable
//	Descripcion : Mensaje de Error de Base de Datos	4
//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	}