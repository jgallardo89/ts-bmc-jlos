package mx.com.bbva.bancomer.test.exception;

import mx.com.bbva.bancomer.commons.exception.BbvaException;

import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ExceptionTestCase 
	{
	static
		{
		new FileSystemXmlApplicationContext( "C:/workspace" +
				                               "/BbvaBancomerCommons" +
				                                 "/test/mx/com/bbva/bancomer/test/exception/application-context-exception.xml" );
		}
	
	@Test
	public final void testBbvaExceptionString() 
		{
		try	{
			if ( 1 + 1 == 2 )
				throw new BbvaException( "9900|ExceptionTestCase|testBbvaExceptionString" );
			}
		catch ( BbvaException bbvaException )
			{	bbvaException.printStackTrace();	}
		}
//	Ejecucion de JUnit 
//	log4j:WARN No appenders could be found for logger (mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject).
//	log4j:WARN Please initialize the log4j system properly.
//	log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	Excepcion   : mx.com.bbva.bancomer.commons.exception.BbvaException
//	Codigo      : 9900
//	Origen      : ExceptionTestCase
//	Metodo      : testBbvaExceptionString
//	Descripcion : Mensaje de Error de Base de Datos	1
//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	@Test
	public final void testBbvaExceptionStringThrowable() 
		{
		try	{
			if ( 1 + 1 == 2 )
				throw new BbvaException( 	"9901|ExceptionTestCase|testBbvaExceptionStringThrowable", 
											new NullPointerException( "Objeto Nulo Generado con proposito de Pruebas Unitarias." ) );
			}
		catch ( BbvaException bbvaException )
			{	bbvaException.printStackTrace();	}
		}
//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	Excepcion   : java.lang.NullPointerException--Objeto Nulo Generado con proposito de Pruebas Unitarias
//	Causa       : Sin causa aparente.
//	Codigo      : 9901
//	Origen      : ExceptionTestCase
//	Metodo      : testBbvaExceptionStringThrowable
//	Descripcion : Mensaje de Error de Base de Datos	2
//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	}