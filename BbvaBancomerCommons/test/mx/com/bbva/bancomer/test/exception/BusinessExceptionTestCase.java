package mx.com.bbva.bancomer.test.exception;

import mx.com.bbva.bancomer.commons.exception.BbvaBusinessException;

import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BusinessExceptionTestCase 
	{
	static
		{
		new FileSystemXmlApplicationContext( "C:/workspace" +
				                               "/BbvaBancomerCommons" +
				                                 "/test/mx/com/bbva/bancomer/test/exception/application-context-exception.xml" );
		}

	@Test
	public final void testBbvaBusinessExceptionString() 
		{
		try	{
			if ( 1 + 1 == 2 )
				throw new BbvaBusinessException( "9904|ExceptionTestCase|testBbvaBusinessExceptionString" );
			}
		catch ( BbvaBusinessException bbvaBusinessException )
			{	bbvaBusinessException.printStackTrace();	}
		}
//		Ejecucion de JUnit 
//		log4j:WARN No appenders could be found for logger (mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject).
//		log4j:WARN Please initialize the log4j system properly.
//		log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
//		- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//		Excepcion   : mx.com.bbva.bancomer.commons.exception.BbvaBusinessException
//		Codigo      : 9904
//		Origen      : ExceptionTestCase
//		Metodo      : testBbvaBusinessExceptionString
//		Descripcion : Mensaje de Error de Base de Datos	5
//		- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	@Test
	public final void testBbvaBusinessExceptionStringThrowable() 
		{
		try	{
			if ( 1 + 1 == 2 )
				throw new BbvaBusinessException(  "9905|ExceptionTestCase|testBbvaBusinessExceptionStringThrowable", 
				                                  new NullPointerException( "Objeto Nulo Generado con proposito de Pruebas Unitarias." ) );
			}
		catch ( BbvaBusinessException bbvaBusinessException )
			{	bbvaBusinessException.printStackTrace();	}
		}
//		- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//		Excepcion   : java.lang.NullPointerException -- Objeto Nulo Generado con proposito de Pruebas Unitarias.
//		Causa       : Sin causa aparente.
//		Codigo      : 9905
//		Origen      : ExceptionTestCase
//		Metodo      : testBbvaBusinessExceptionStringThrowable
//		Descripcion : Mensaje de Error de Base de Datos	6
//		- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
		}