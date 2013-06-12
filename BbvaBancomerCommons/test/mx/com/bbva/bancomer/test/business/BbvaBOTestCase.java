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
 * Nombre de clase: BbvaBOTestCase.java
 * Nombre de paquete: mx.com.bbva.bancomer.test.business
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.test.business;

import javax.xml.parsers.FactoryConfigurationError;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

// TODO: Auto-generated Javadoc
/**
 * The Class BbvaBOTestCase.
 */
public class BbvaBOTestCase 
	{
	/** The Constant SPRINGFILEPATH. */ 
	private static final String	 SPRINGFILEPATH		= "C:/workspace" +
								 		                "/BbvaBancomerCommons" +
								 		                  "/test/mx/com/bbva/bancomer/test/business/application-context-business.xml";
	
	/** The Constant applicationContext. */
	private static final ApplicationContext 	
		 				 applicationContext = new FileSystemXmlApplicationContext( SPRINGFILEPATH );
	
	/** The Constant bbvaBusinessObject. */
	private static final BbvaBusinessObject	
						 bbvaBusinessObject = (BbvaBusinessObject)applicationContext.getBean( "bbvaBusinessObject" );
		
	
	static	{
			try	{
				DOMConfigurator.configure( "C:/workspace" +
								 		     "/BbvaBancomerCommons" +
								 		       "/test/mx/com/bbva/bancomer/test/business/log4j.cfg.xml" );
				}
			catch( FactoryConfigurationError factoryConfigurationError )
				{
				factoryConfigurationError.printStackTrace();
				}
			}
//	[08-05-13 22:33:22:033 LOG] [mx.com.bbva.bancomer.commons.business.BbvaAbstractBusinessObject] INFO  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	[08-05-13 22:33:22:033 LOG] [mx.com.bbva.bancomer.commons.business.BbvaAbstractBusinessObject] INFO  - Constructor Business Object -- OK -- class mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO
//	[08-05-13 22:33:22:033 LOG] [mx.com.bbva.bancomer.commons.business.BbvaAbstractBusinessObject] INFO  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	/**
 * Test create command.
 */
@Test
	public final void testCreateCommand() 
		{
		System.out.println( "Creacion  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
		}
//	Actualizacion - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	/**
 * Test delete command.
 */
@Test
	public final void testDeleteCommand() 
		{
		System.out.println( "Eliminacion - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
		}
//	Eliminacion - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	Creacion  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	/**
 * Test read command.
 */
@Test
	public final void testReadCommand() 
		{
		System.out.println( "Consulta  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );

		final	BbvaCargarPantallaUsuarioDTO
				bbvaCargarPantallaUsuarioDTO = bbvaBusinessObject.readCommand( new BbvaCargarPantallaUsuarioDTO () );
		
		System.out.println( bbvaCargarPantallaUsuarioDTO.toString() );

		System.out.println( "Consulta  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );

		final	BbvaCargarTablaUsuarioDTO 
				bbvaCargarTablaUsuarioDTO = bbvaBusinessObject.readCommand( new BbvaCargarTablaUsuarioDTO () );
		
		System.out.println( bbvaCargarTablaUsuarioDTO.toString() );
		}
//	Consulta  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	[08-05-13 22:33:22:033 LOG] [mx.com.bbva.bancomer.test.business.BbvaBusinessObject] INFO  - Entrada readCommand -- OK
//	[08-05-13 22:33:22:033 LOG] [mx.com.bbva.bancomer.test.business.BbvaBusinessObject] INFO  - Datos de Entrada      -- [BbvaCargarPantallaUsuarioDTO:BbvaUsuarioVO=null,BbvaUsuarioVOList=null]
//	[08-05-13 22:33:22:033 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Entrada queryForList -- OK
//	[08-05-13 22:33:22:033 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Datos de Entrada     -- MantenimientoCatalogoMapper|readBbvaUsuarioVOList
//	[08-05-13 22:33:23:033 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=2,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	[08-05-13 22:33:23:033 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=3,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	[08-05-13 22:33:23:033 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=9,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	[08-05-13 22:33:23:033 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=7,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	[08-05-13 22:33:23:033 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=5,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	[08-05-13 22:33:23:033 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Salida -- queryForObject Ejecutado -- OK
//	[08-05-13 22:33:23:033 LOG] [mx.com.bbva.bancomer.test.business.BbvaBusinessObject] INFO  - Salida readCommand  -- OK
//	[08-05-13 22:33:23:033 LOG] [mx.com.bbva.bancomer.test.business.BbvaBusinessObject] INFO  - Datos de Salida       -- [BbvaCargarPantallaUsuarioDTO:BbvaUsuarioVO=[BbvaUsuarioVO:CdUsuario=null,CdCveUsuario=null,NbUsuario=null,TxPasswordUsr=null,TmAlta=null,TmModificacion=null,FhUsuario=null,TmCambioPws=null,NuIntentos=null,StUsuario=null,CdPerfil=null],BbvaUsuarioVOList=[[BbvaUsuarioVO:CdUsuario=2,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=3,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=9,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=7,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=5,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]]]
//	[BbvaCargarPantallaUsuarioDTO:BbvaUsuarioVO=[BbvaUsuarioVO:CdUsuario=null,CdCveUsuario=null,NbUsuario=null,TxPasswordUsr=null,TmAlta=null,TmModificacion=null,FhUsuario=null,TmCambioPws=null,NuIntentos=null,StUsuario=null,CdPerfil=null],BbvaUsuarioVOList=[[BbvaUsuarioVO:CdUsuario=2,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=3,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=9,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=7,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=5,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]]]
//
//	 Consulta  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	[08-05-13 22:33:23:033 LOG] [mx.com.bbva.bancomer.test.business.BbvaBusinessObject] INFO  - Entrada readCommand -- OK
//	[08-05-13 22:33:23:033 LOG] [mx.com.bbva.bancomer.test.business.BbvaBusinessObject] INFO  - Datos de Entrada      -- [BbvaCargarTablaUsuarioDTO:BbvaUsuarioVOList=null]
//	[08-05-13 22:33:23:033 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Entrada queryForList -- OK
//	[08-05-13 22:33:23:033 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Datos de Entrada     -- MantenimientoCatalogoMapper|readBbvaUsuarioVOList
//	[08-05-13 22:33:23:033 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=2,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	[08-05-13 22:33:23:033 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=3,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	[08-05-13 22:33:23:033 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=9,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	[08-05-13 22:33:23:033 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=7,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	[08-05-13 22:33:23:033 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=5,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	[08-05-13 22:33:23:033 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Salida -- queryForObject Ejecutado -- OK
//	[08-05-13 22:33:23:033 LOG] [mx.com.bbva.bancomer.test.business.BbvaBusinessObject] INFO  - Salida readCommand  -- OK
//	[08-05-13 22:33:23:033 LOG] [mx.com.bbva.bancomer.test.business.BbvaBusinessObject] INFO  - Datos de Salida       -- [BbvaCargarTablaUsuarioDTO:BbvaUsuarioVOList=[[BbvaUsuarioVO:CdUsuario=2,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=3,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=9,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=7,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=5,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]]]
//	[BbvaCargarTablaUsuarioDTO:BbvaUsuarioVOList=[[BbvaUsuarioVO:CdUsuario=2,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=3,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=9,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=7,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=5,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]]]
	/**
 * Test update command.
 */
@Test
	public final void testUpdateCommand() 
		{
		System.out.println( "Actualizacion - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
		}
	}