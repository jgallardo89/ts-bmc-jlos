package mx.com.bbva.bancomer.test.model;

import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

import org.junit.Test;

public class DtoTestCase 
	{
	@Test
	public final void testToStringString() 
		{
		final	TestDTO
				testDTO = new TestDTO();

		System.out.println( testDTO.toString( BbvaAbstractDataTransferObject.XML  ) );
		System.out.println( testDTO.toString( BbvaAbstractDataTransferObject.JSON ) );
		}
//	Ejecucion de JUnit 
//	log4j:WARN No appenders could be found for logger (mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject).
//	log4j:WARN Please initialize the log4j system properly.
//	log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
//	<?xml version="1.0" encoding="UTF-8"?>
//	<testDTO>
//	   <errorCode>0000</errorCode>
//	   <errorDescription>OK</errorDescription>
//	   <commandId>0</commandId>
//	   <testText>Texto de Prueba -- DTO</testText>
//	   <testVO>
//	      <integerValue>1</integerValue>
//	      <longValue>1</longValue>
//	      <doubleValue>1.0</doubleValue>
//	      <charValue>a</charValue>
//	      <booleanValue>false</booleanValue>
//	      <integerWrapper>1</integerWrapper>
//	      <longWrapper>1</longWrapper>
//	      <doubleWrapper>1.0</doubleWrapper>
//	      <characterWrapper>a</characterWrapper>
//	      <booleanWrapper>false</booleanWrapper>
//	      <testText>Texto de Prueba -- VO</testText>
//	      <testDate>2013-05-02 14:16:12.911 CDT</testDate>
//	   </testVO>
//	   <testVOList class="java.util.ArrayList">
//	      <testVO>
//	         <integerValue>1</integerValue>
//	         <longValue>1</longValue>
//	         <doubleValue>1.0</doubleValue>
//	         <charValue>a</charValue>
//	         <booleanValue>false</booleanValue>
//	         <integerWrapper>1</integerWrapper>
//	         <longWrapper>1</longWrapper>
//	         <doubleWrapper>1.0</doubleWrapper>
//	         <characterWrapper>a</characterWrapper>
//	         <booleanWrapper>false</booleanWrapper>
//	         <testText>Texto de Prueba -- VO</testText>
//	         <testDate>2013-05-02 14:16:12.911 CDT</testDate>
//	      </testVO>
//	      <testVO>
//	         <integerValue>1</integerValue>
//	         <longValue>1</longValue>
//	         <doubleValue>1.0</doubleValue>
//	         <charValue>a</charValue>
//	         <booleanValue>false</booleanValue>
//	         <integerWrapper>1</integerWrapper>
//	         <longWrapper>1</longWrapper>
//	         <doubleWrapper>1.0</doubleWrapper>
//	         <characterWrapper>a</characterWrapper>
//	         <booleanWrapper>false</booleanWrapper>
//	         <testText>Texto de Prueba -- VO</testText>
//	         <testDate>2013-05-02 14:16:12.911 CDT</testDate>
//	      </testVO>
//	   </testVOList>
//	</testDTO>
//	{"commandId":0,"errorCode":"0000","errorDescription":"OK","testText":"Texto de Prueba -- DTO","testVO":{"booleanValue":false,"booleanWrapper":false,"charValue":"a","characterWrapper":"a","doubleValue":1,"doubleWrapper":1,"integerValue":1,"integerWrapper":1,"longValue":1,"longWrapper":1,"testDate":{"date":2,"day":4,"hours":14,"minutes":16,"month":4,"seconds":12,"time":1367522172911,"timezoneOffset":300,"year":113},"testText":"Texto de Prueba -- VO"},"testVOList":[{"booleanValue":false,"booleanWrapper":false,"charValue":"a","characterWrapper":"a","doubleValue":1,"doubleWrapper":1,"integerValue":1,"integerWrapper":1,"longValue":1,"longWrapper":1,"testDate":{"date":2,"day":4,"hours":14,"minutes":16,"month":4,"seconds":12,"time":1367522172911,"timezoneOffset":300,"year":113},"testText":"Texto de Prueba -- VO"},{"booleanValue":false,"booleanWrapper":false,"charValue":"a","characterWrapper":"a","doubleValue":1,"doubleWrapper":1,"integerValue":1,"integerWrapper":1,"longValue":1,"longWrapper":1,"testDate":{"date":2,"day":4,"hours":14,"minutes":16,"month":4,"seconds":12,"time":1367522172911,"timezoneOffset":300,"year":113},"testText":"Texto de Prueba -- VO"}]}
	@Test
	public final void testToString() 
		{
		final	TestDTO
				testDTO = new TestDTO();
		System.out.println( testDTO.toString() );
		}
//	[TestDTO:TestText=Texto de Prueba -- DTO,TestVO=[TestVO:IntegerValue=1,LongValue=1,DoubleValue=1.0,CharValue=a,IntegerWrapper=1,LongWrapper=1,DoubleWrapper=1.0,CharacterWrapper=a,BooleanWrapper=false,TestText=Texto de Prueba -- VO,TestDate=Thu May 02 14:16:13 CDT 2013],TestVOList=[[TestVO:IntegerValue=1,LongValue=1,DoubleValue=1.0,CharValue=a,IntegerWrapper=1,LongWrapper=1,DoubleWrapper=1.0,CharacterWrapper=a,BooleanWrapper=false,TestText=Texto de Prueba -- VO,TestDate=Thu May 02 14:16:13 CDT 2013], [TestVO:IntegerValue=1,LongValue=1,DoubleValue=1.0,CharValue=a,IntegerWrapper=1,LongWrapper=1,DoubleWrapper=1.0,CharacterWrapper=a,BooleanWrapper=false,TestText=Texto de Prueba -- VO,TestDate=Thu May 02 14:16:13 CDT 2013]]]
	}