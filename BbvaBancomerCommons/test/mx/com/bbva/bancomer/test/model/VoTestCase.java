package mx.com.bbva.bancomer.test.model;

import org.junit.Test;

public class VoTestCase 
	{
	@Test
	public final void testToString() 
		{
		final	TestVO
				testVO = new TestVO();
		System.out.println( testVO.toString() );
		}
	}
//	Ejecucion de JUnit 
//	log4j:WARN No appenders could be found for logger (mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject).
//	log4j:WARN Please initialize the log4j system properly.
//	log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
//	[TestVO:IntegerValue=1,LongValue=1,DoubleValue=1.0,CharValue=a,IntegerWrapper=1,LongWrapper=1,DoubleWrapper=1.0,CharacterWrapper=a,BooleanWrapper=false,TestText=Texto de Prueba -- VO,TestDate=Thu May 02 14:14:59 CDT 2013]

