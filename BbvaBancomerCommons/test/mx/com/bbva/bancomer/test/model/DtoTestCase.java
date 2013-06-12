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
 * Nombre de clase: DtoTestCase.java
 * Nombre de paquete: mx.com.bbva.bancomer.test.model
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.test.model;

import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class DtoTestCase.
 */
public class DtoTestCase 
	{
	
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
	/**
 * Test to string.
 */
@Test
	public final void testToString() 
		{
		final	TestDTO
				testDTO = new TestDTO();
		System.out.println( testDTO.toString() );
		}
//	[TestDTO:TestText=Texto de Prueba -- DTO,TestVO=[TestVO:IntegerValue=1,LongValue=1,DoubleValue=1.0,CharValue=a,IntegerWrapper=1,LongWrapper=1,DoubleWrapper=1.0,CharacterWrapper=a,BooleanWrapper=false,TestText=Texto de Prueba -- VO,TestDate=Thu May 02 14:16:13 CDT 2013],TestVOList=[[TestVO:IntegerValue=1,LongValue=1,DoubleValue=1.0,CharValue=a,IntegerWrapper=1,LongWrapper=1,DoubleWrapper=1.0,CharacterWrapper=a,BooleanWrapper=false,TestText=Texto de Prueba -- VO,TestDate=Thu May 02 14:16:13 CDT 2013], [TestVO:IntegerValue=1,LongValue=1,DoubleValue=1.0,CharValue=a,IntegerWrapper=1,LongWrapper=1,DoubleWrapper=1.0,CharacterWrapper=a,BooleanWrapper=false,TestText=Texto de Prueba -- VO,TestDate=Thu May 02 14:16:13 CDT 2013]]]
/**
	 * Test to string string.
	 */
	@Test
	public final void testToStringString() 
		{
		final	TestDTO
				testDTO = new TestDTO();

		System.out.println( testDTO.toString( BbvaAbstractDataTransferObject.XML  ) );
		System.out.println( testDTO.toString( BbvaAbstractDataTransferObject.JSON ) );
		}
	}