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
 * Nombre de clase: BbvaCommandInvokerTestCase.java
 * Nombre de paquete: mx.com.bbva.bancomer.test.command
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.test.command;

import javax.xml.parsers.FactoryConfigurationError;

import mx.com.bbva.bancomer.commons.command.BbvaICommandInvoker;
import mx.com.bbva.bancomer.commons.exception.BbvaBusinessException;
import mx.com.bbva.bancomer.test.business.BbvaCargarPantallaUsuarioDTO;
import mx.com.bbva.bancomer.test.business.BbvaCargarTablaUsuarioDTO;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

// TODO: Auto-generated Javadoc
/**
 * The Class BbvaCommandInvokerTestCase.
 */
public class BbvaCommandInvokerTestCase 
	{
	/** The Constant SPRINGFILEPATH. */
	private static final String	 SPRINGFILEPATH		= "C:/workspace" +
								 		                "/BbvaBancomerCommons" +
								 		                  "/test/mx/com/bbva/bancomer/test/command/application-context-command.xml";
	/** The Constant applicationContext. */
	private static final ApplicationContext 	
		 				 applicationContext = new FileSystemXmlApplicationContext( SPRINGFILEPATH );
	
	/** The Constant bbvaICommandInvoker. */
	private static final BbvaICommandInvoker	
						 bbvaICommandInvoker = (BbvaICommandInvoker)applicationContext.getBean( "bbvaCommandInvoker" );
	
	
	
	static	{
			try	{
				DOMConfigurator.configure( "C:/workspace" +
								 		     "/BbvaBancomerCommons" +
								 		       "/test/mx/com/bbva/bancomer/test/command/log4j.cfg.xml" );
				}
			catch( FactoryConfigurationError factoryConfigurationError )
				{
				factoryConfigurationError.printStackTrace();
				}
			}

//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.business.BbvaAbstractBusinessObject] INFO  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.business.BbvaAbstractBusinessObject] INFO  - Constructor Business Object -- OK -- class mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.business.BbvaAbstractBusinessObject] INFO  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.business.BbvaAbstractBusinessObject] INFO  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.business.BbvaAbstractBusinessObject] INFO  - Constructor Business Object -- OK -- class mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.business.BbvaAbstractBusinessObject] INFO  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject] INFO  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject] INFO  - Constructor BbvaCommandInvoker -- OK
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject] DEBUG - Datos de Entrada                       -- {BbvaCargarPantallaUsuarioDTO=bbvaBusinessObject1, BbvaCargarTablaUsuarioDTO=bbvaBusinessObject2}
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject] DEBUG - Datos de Entrada                       -- {4=deleteCommand, 3=updateCommand, 2=readCommand, 1=createCommand}
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject] DEBUG - Datos de Entrada                       -- {bbvaBusinessObject1=mx.com.bbva.bancomer.test.business.BbvaBusinessObject@213a213a, bbvaBusinessObject2=mx.com.bbva.bancomer.test.command.BbvaBusinessObject@143a143a}
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject] INFO  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	/**
 * Test invoke.
 *
 * @throws BbvaBusinessException the bbva business exception
 */
@Test
	public final void testInvoke() throws BbvaBusinessException 
		{
		System.out.println( "Consulta  1 - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );

		BbvaCargarPantallaUsuarioDTO
		bbvaCargarPantallaUsuarioDTO = new BbvaCargarPantallaUsuarioDTO ();
//		bbvaCargarPantallaUsuarioDTO.setCommandId( 2 );	-> createCommand
		bbvaCargarPantallaUsuarioDTO.setCommandId( 2 );
//		bbvaCargarPantallaUsuarioDTO.setCommandId( 2 );	-> updateCommand
//		bbvaCargarPantallaUsuarioDTO.setCommandId( 2 );	-> deleteCommand
		bbvaCargarPantallaUsuarioDTO = bbvaICommandInvoker.invoke( bbvaCargarPantallaUsuarioDTO );
		
		System.out.println( bbvaCargarPantallaUsuarioDTO.toString() );

		System.out.println( "Consulta  2 - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );

		BbvaCargarTablaUsuarioDTO 
		bbvaCargarTablaUsuarioDTO = new BbvaCargarTablaUsuarioDTO ();
//		bbvaCargarPantallaUsuarioDTO.setCommandId( 2 );	-> createCommand
		bbvaCargarPantallaUsuarioDTO.setCommandId( 2 );
//		bbvaCargarPantallaUsuarioDTO.setCommandId( 2 );	-> updateCommand
//		bbvaCargarPantallaUsuarioDTO.setCommandId( 2 );	-> deleteCommand
		bbvaCargarTablaUsuarioDTO = bbvaICommandInvoker.invoke( bbvaCargarTablaUsuarioDTO );
		
		System.out.println( bbvaCargarTablaUsuarioDTO.toString() );
		}
//	Consulta  1 - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject] DEBUG - Entrada invoke          -- OK
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject] DEBUG - Datos de Entrada invoke -- [BbvaCargarPantallaUsuarioDTO:BbvaUsuarioVO=null,BbvaUsuarioVOList=null]
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject] DEBUG - Objeto de Negocio       -- class mx.com.bbva.bancomer.test.business.BbvaBusinessObject
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.test.business.BbvaBusinessObject] INFO  - Entrada readCommand -- OK
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.test.business.BbvaBusinessObject] INFO  - Datos de Entrada      -- [BbvaCargarPantallaUsuarioDTO:BbvaUsuarioVO=null,BbvaUsuarioVOList=null]
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Entrada queryForList -- OK
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Datos de Entrada     -- MantenimientoCatalogoMapper|readBbvaUsuarioVOList
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=2,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=3,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=9,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=7,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=5,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Salida -- queryForObject Ejecutado -- OK
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.test.business.BbvaBusinessObject] INFO  - Salida readCommand  -- OK
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.test.business.BbvaBusinessObject] INFO  - Datos de Salida       -- [BbvaCargarPantallaUsuarioDTO:BbvaUsuarioVO=[BbvaUsuarioVO:CdUsuario=null,CdCveUsuario=null,NbUsuario=null,TxPasswordUsr=null,TmAlta=null,TmModificacion=null,FhUsuario=null,TmCambioPws=null,NuIntentos=null,StUsuario=null,CdPerfil=null],BbvaUsuarioVOList=[[BbvaUsuarioVO:CdUsuario=2,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=3,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=9,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=7,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=5,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]]]
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject] DEBUG - Datos de Salida invoke -- [BbvaCargarPantallaUsuarioDTO:BbvaUsuarioVO=[BbvaUsuarioVO:CdUsuario=null,CdCveUsuario=null,NbUsuario=null,TxPasswordUsr=null,TmAlta=null,TmModificacion=null,FhUsuario=null,TmCambioPws=null,NuIntentos=null,StUsuario=null,CdPerfil=null],BbvaUsuarioVOList=[[BbvaUsuarioVO:CdUsuario=2,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=3,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=9,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=7,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=5,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]]]
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject] DEBUG - Salida invoke          -- OK
//	[BbvaCargarPantallaUsuarioDTO:BbvaUsuarioVO=[BbvaUsuarioVO:CdUsuario=null,CdCveUsuario=null,NbUsuario=null,TxPasswordUsr=null,TmAlta=null,TmModificacion=null,FhUsuario=null,TmCambioPws=null,NuIntentos=null,StUsuario=null,CdPerfil=null],BbvaUsuarioVOList=[[BbvaUsuarioVO:CdUsuario=2,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=3,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=9,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=7,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=5,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]]]
//
//	 Consulta  2 - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject] DEBUG - Entrada invoke          -- OK
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject] DEBUG - Datos de Entrada invoke -- [BbvaCargarTablaUsuarioDTO:BbvaUsuarioVOList=null]
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject] DEBUG - Objeto de Negocio       -- class mx.com.bbva.bancomer.test.command.BbvaBusinessObject
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.test.command.BbvaBusinessObject] INFO  - Entrada readCommand -- OK
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.test.command.BbvaBusinessObject] INFO  - Datos de Entrada      -- [BbvaCargarTablaUsuarioDTO:BbvaUsuarioVOList=null]
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Entrada queryForList -- OK
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Datos de Entrada     -- MantenimientoCatalogoMapper|readBbvaUsuarioVOList
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=2,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=3,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=9,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=7,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=5,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.persistence.dao.BbvaMyBatisDAO] INFO  - Salida -- queryForObject Ejecutado -- OK
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.test.command.BbvaBusinessObject] INFO  - Salida readCommand  -- OK
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.test.command.BbvaBusinessObject] INFO  - Datos de Salida       -- [BbvaCargarTablaUsuarioDTO:BbvaUsuarioVOList=[[BbvaUsuarioVO:CdUsuario=2,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=3,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=9,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=7,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=5,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]]]
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject] DEBUG - Datos de Salida invoke -- [BbvaCargarTablaUsuarioDTO:BbvaUsuarioVOList=[[BbvaUsuarioVO:CdUsuario=2,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=3,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=9,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=7,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=5,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]]]
//	[09-05-13 12:56:38:056 LOG] [mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject] DEBUG - Salida invoke          -- OK
//	[BbvaCargarTablaUsuarioDTO:BbvaUsuarioVOList=[[BbvaUsuarioVO:CdUsuario=2,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=3,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=9,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=7,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=5,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]]]
	}