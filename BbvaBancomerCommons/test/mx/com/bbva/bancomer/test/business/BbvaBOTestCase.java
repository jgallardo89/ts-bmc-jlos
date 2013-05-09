package mx.com.bbva.bancomer.test.business;

import javax.xml.parsers.FactoryConfigurationError;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BbvaBOTestCase 
	{
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
	
	private static final String	 SPRINGFILEPATH		= "C:/workspace" +
								 		                "/BbvaBancomerCommons" +
								 		                  "/test/mx/com/bbva/bancomer/test/business/application-context-business.xml";
	
	private static final ApplicationContext 	
		 				 applicationContext = new FileSystemXmlApplicationContext( SPRINGFILEPATH );
	
	private static final BbvaBusinessObject	
						 bbvaBusinessObject = (BbvaBusinessObject)applicationContext.getBean( "bbvaBusinessObject" );
//	[08-05-13 22:33:22:033 LOG] [mx.com.bbva.bancomer.commons.business.BbvaAbstractBusinessObject] INFO  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	[08-05-13 22:33:22:033 LOG] [mx.com.bbva.bancomer.commons.business.BbvaAbstractBusinessObject] INFO  - Constructor Business Object -- OK -- class mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO
//	[08-05-13 22:33:22:033 LOG] [mx.com.bbva.bancomer.commons.business.BbvaAbstractBusinessObject] INFO  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	@Test
	public final void testCreateCommand() 
		{
		System.out.println( "Creacion  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
		}
//	Creacion  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
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
	@Test
	public final void testUpdateCommand() 
		{
		System.out.println( "Actualizacion - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
		}
//	Actualizacion - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	@Test
	public final void testDeleteCommand() 
		{
		System.out.println( "Eliminacion - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
		}
//	Eliminacion - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	}