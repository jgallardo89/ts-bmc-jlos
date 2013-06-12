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
 * Nombre de clase: MyBatisDAOTestCase.java
 * Nombre de paquete: mx.com.bbva.bancomer.test.dao
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.test.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException;
import mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

// TODO: Auto-generated Javadoc
//Consulta inicial SELECT * FROM "MAPEADOR"."TGM503_USUARIO"
//CD_USUARIO CD_CVE_USUARIO NB_USUARIO TX_PASSWORD_USR TM_ALTA TM_MODIFICACION FH_USUARIO TM_CAMBIO_PWS NU_INTENTOS ST_USUARIO CD_PERFIL
//---------- -------------- ---------- --------------- ------- --------------- ---------- ------------- ----------- ---------- ---------

//Consulta final SELECT * FROM "MAPEADOR"."TGM503_USUARIO"
//CD_USUARIO CD_CVE_USUARIO   NB_USUARIO                    TX_PASSWORD_USR TM_ALTA             TM_MODIFICACION     FH_USUARIO          TM_CAMBIO_PWS       NU_INTENTOS ST_USUARIO CD_PERFIL
//---------- ---------------- ----------------------------- --------------- ------------------- ------------------- ------------------- ------------------- ----------- ---------- ---------
//         2 prueba0123456789 Usuario de Prueba - Insercion qwerty          2013-05-08 14:20:35 2013-05-08 14:20:35 2013-05-08 14:20:35 2013-05-08 14:20:35           0          0         0
//         3 prueba0123456789 Usuario de Prueba - Insercion qwerty          2013-05-08 14:20:35 2013-05-08 14:20:35 2013-05-08 14:20:35 2013-05-08 14:20:35           0          0         0
//         5 prueba0123456789 Usuario de Prueba - Insercion qwerty          2013-05-08 14:20:35 2013-05-08 14:20:35 2013-05-08 14:20:35 2013-05-08 14:20:35           0          0         0
//         7 prueba0123456789 Usuario de Prueba - Insercion qwerty          2013-05-08 14:20:35 2013-05-08 14:20:35 2013-05-08 14:20:35 2013-05-08 14:20:35           0          0         0
//         9 prueba0123456789 Usuario de Prueba - Insercion qwerty          2013-05-08 14:20:35 2013-05-08 14:20:35 2013-05-08 14:20:35 2013-05-08 14:20:35           0          0         0

/**
 * The Class MyBatisDAOTestCase.
 */
public class MyBatisDAOTestCase 
	{
	
	/** The Constant SPRINGFILEPATH. */
	private static final String
						 SPRINGFILEPATH		= "C:/workspace" +
						 		                "/BbvaBancomerCommons" +
						 		                  "/test/mx/com/bbva/bancomer/test/dao/application-context-dao.xml";
	
	/** The Constant applicationContext. */
	private static final ApplicationContext 	
						 applicationContext = new FileSystemXmlApplicationContext( SPRINGFILEPATH );

	/** The Constant bbvaIDataAccessObject. */
	private static final BbvaIDataAccessObject	
						 bbvaIDataAccessObject = (BbvaIDataAccessObject)applicationContext.getBean( "bbvaMyBatisDAO" );

	

	//	Insercion - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	Entrada queryForObject -- OK
//	Datos de Entrada       -- MantenimientoCatalogoMapper|createBbvaUsuarioVO -- [BbvaUsuarioVO:CdUsuario=1,
//	                                                                              CdCveUsuario=prueba0123456789,
//	                                                                              NbUsuario=Usuario de Prueba - Insercion,
//	                                                                              TxPasswordUsr=qwerty,
//	                                                                              TmAlta=Wed May 08 13:43:29 CDT 2013,
//	                                                                              TmModificacion=Wed May 08 13:43:29 CDT 2013,
//	                                                                              FhUsuario=Wed May 08 13:43:29 CDT 2013,
//	                                                                              TmCambioPws=Wed May 08 13:43:29 CDT 2013,
//	                                                                              NuIntentos=0,
//	                                                                              StUsuario=0,
//	                                                                              CdPerfil=0]
//		Entrada validateQueryStructure -- OK
//		Datos de Entrada               -- MantenimientoCatalogoMapper|createBbvaUsuarioVO
//		Operacion de Base de Datos -- OK
//		queryName -- OK
//		mx.com.bbva.bancomer.mapper.persistence.sqlmapping.BbvaMantenimientoCatalogoMapper -- Existe -- OK
//		createBbvaUsuarioVO -- Existe -- OK
//		Datos de Salida                            -- mx.com.bbva.bancomer.mapper.persistence.sqlmapping.BbvaMantenimientoCatalogoMapper.createBbvaUsuarioVO
//		Salida -- validateQueryStructure Ejecutado -- OK
//	Operacion create|read|update|delete permitida -- OK
//	Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=1,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 13:43:29 CDT 2013,TmModificacion=Wed May 08 13:43:29 CDT 2013,FhUsuario=Wed May 08 13:43:29 CDT 2013,TmCambioPws=Wed May 08 13:43:29 CDT 2013,NuIntentos=null,StUsuario=0,CdPerfil=0]
//	Salida -- queryForObject Ejecutado -- OK
//	[BbvaUsuarioVO:CdUsuario=1,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 13:43:29 CDT 2013,TmModificacion=Wed May 08 13:43:29 CDT 2013,FhUsuario=Wed May 08 13:43:29 CDT 2013,TmCambioPws=Wed May 08 13:43:29 CDT 2013,NuIntentos=null,StUsuario=0,CdPerfil=0]
//
//	Consulta  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	Entrada queryForObject -- OK
//	Datos de Entrada       -- MantenimientoCatalogoMapper|readByAllRequiredBbvaUsuarioVO -- [BbvaUsuarioVO:CdUsuario=1,
//	                                                                                         CdCveUsuario=prueba0123456789,
//	                                                                                         NbUsuario=Usuario de Prueba - Insercion,
//	                                                                                         TxPasswordUsr=qwerty,
//	                                                                                         TmAlta=Wed May 08 13:43:29 CDT 2013,
//	                                                                                         TmModificacion=Wed May 08 13:43:29 CDT 2013,
//	                                                                                         FhUsuario=Wed May 08 13:43:29 CDT 2013,
//	                                                                                         TmCambioPws=Wed May 08 13:43:29 CDT 2013,
//	                                                                                         NuIntentos=0,
//	                                                                                         StUsuario=0,
//	                                                                                         CdPerfil=0]
//		Entrada validateQueryStructure -- OK
//		Datos de Entrada               -- MantenimientoCatalogoMapper|readByAllRequiredBbvaUsuarioVO
//		Operacion de Base de Datos -- OK
//		queryName -- OK
//		mx.com.bbva.bancomer.mapper.persistence.sqlmapping.BbvaMantenimientoCatalogoMapper -- Existe -- OK
//		readByAllRequiredBbvaUsuarioVO -- Existe -- OK
//		Datos de Salida                            -- mx.com.bbva.bancomer.mapper.persistence.sqlmapping.BbvaMantenimientoCatalogoMapper.readByAllRequiredBbvaUsuarioVO
//		Salida -- validateQueryStructure Ejecutado -- OK
//	Operacion create|read|update|delete permitida -- OK
//	Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=1,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 13:43:29 CDT 2013,TmModificacion=Wed May 08 13:43:29 CDT 2013,FhUsuario=Wed May 08 13:43:29 CDT 2013,TmCambioPws=Wed May 08 13:43:29 CDT 2013,NuIntentos=null,StUsuario=0,CdPerfil=0]
//	Salida -- queryForObject Ejecutado -- OK
//	[BbvaUsuarioVO:CdUsuario=1,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 13:43:29 CDT 2013,TmModificacion=Wed May 08 13:43:29 CDT 2013,FhUsuario=Wed May 08 13:43:29 CDT 2013,TmCambioPws=Wed May 08 13:43:29 CDT 2013,NuIntentos=null,StUsuario=0,CdPerfil=0]
//
//	Actualizacion - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	Entrada queryForObject -- OK
//	Datos de Entrada       -- MantenimientoCatalogoMapper|updateBbvaUsuarioVO -- [BbvaUsuarioVO:CdUsuario=1,
//	                                                                              CdCveUsuario=prueba0123456789,
//	                                                                              NbUsuario=Usuario de Prueba - Actualizacion,
//	                                                                              TxPasswordUsr=qwerty,T
//	                                                                              mAlta=Wed May 08 13:43:29 CDT 2013,
//	                                                                              TmModificacion=Wed May 08 13:43:29 CDT 2013,
//	                                                                              FhUsuario=Wed May 08 13:44:01 CDT 2013,
//	                                                                              TmCambioPws=Wed May 08 13:43:29 CDT 2013,
//	                                                                              NuIntentos=0,
//	                                                                              StUsuario=0,
//	                                                                              CdPerfil=0]
//		Entrada validateQueryStructure -- OK
//		Datos de Entrada               -- MantenimientoCatalogoMapper|updateBbvaUsuarioVO
//		Operacion de Base de Datos -- OK
//		queryName -- OK
//		mx.com.bbva.bancomer.mapper.persistence.sqlmapping.BbvaMantenimientoCatalogoMapper -- Existe -- OK
//		updateBbvaUsuarioVO -- Existe -- OK
//		Datos de Salida                            -- mx.com.bbva.bancomer.mapper.persistence.sqlmapping.BbvaMantenimientoCatalogoMapper.updateBbvaUsuarioVO
//		Salida -- validateQueryStructure Ejecutado -- OK
//	Operacion create|read|update|delete permitida -- OK
//	Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=1,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Actualizacion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 13:43:29 CDT 2013,TmModificacion=Wed May 08 13:43:29 CDT 2013,FhUsuario=Wed May 08 13:43:29 CDT 2013,TmCambioPws=Wed May 08 13:43:29 CDT 2013,NuIntentos=0,StUsuario=0,CdPerfil=0]
//	Salida -- queryForObject Ejecutado -- OK
//	[BbvaUsuarioVO:CdUsuario=1,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Actualizacion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 13:43:29 CDT 2013,TmModificacion=Wed May 08 13:43:29 CDT 2013,FhUsuario=Wed May 08 13:43:29 CDT 2013,TmCambioPws=Wed May 08 13:43:29 CDT 2013,NuIntentos=0,StUsuario=0,CdPerfil=0]
	/**
 * Test query for list string.
 */
@Test
	public final void testQueryForListString() 
		{
		try {
			final	List<BbvaUsuarioVO> list = bbvaIDataAccessObject.queryForList( "MantenimientoCatalogoMapper|readBbvaUsuarioVOList" );

			System.out.println( list );
			} 
		catch ( BbvaDataBaseException bbvaDataBaseException ) 
			{
			bbvaDataBaseException.printStackTrace();
			}
		}
//	Entrada queryForList -- OK
//	Datos de Entrada     -- MantenimientoCatalogoMapper|readBbvaUsuarioVOList
//	Operacion read permitida -- OK
//		Entrada validateQueryStructure -- OK
//		Datos de Entrada               -- MantenimientoCatalogoMapper|readBbvaUsuarioVOList
//		Operacion de Base de Datos -- OK
//		queryName -- OK
//		mx.com.bbva.bancomer.mapper.persistence.sqlmapping.BbvaMantenimientoCatalogoMapper -- Existe -- OK
//		readBbvaUsuarioVOList -- Existe -- OK
//		Datos de Salida                            -- mx.com.bbva.bancomer.mapper.persistence.sqlmapping.BbvaMantenimientoCatalogoMapper.readBbvaUsuarioVOList
//		Salida -- validateQueryStructure Ejecutado -- OK
//	Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=1,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Actualizacion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	Salida -- queryForObject Ejecutado -- OK
//	[[BbvaUsuarioVO:CdUsuario=1,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Actualizacion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]]
	/**
 * Test query for list string t.
 */
@Test
	public final void testQueryForListStringT() 
		{
		try {
			System.out.println( "Insercion - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
			final	List<BbvaUsuarioVO> list = new ArrayList<BbvaUsuarioVO>();
			for ( int i = 2; i < 10; i++ )
				{
				final	BbvaUsuarioVO 
						bbvaUsuarioVO = new BbvaUsuarioVO();
						bbvaUsuarioVO.setCdUsuario		( i );
						bbvaUsuarioVO.setCdCveUsuario	( "prueba0123456789" );
						bbvaUsuarioVO.setNbUsuario		( "Usuario de Prueba - Insercion" );
						bbvaUsuarioVO.setTxPasswordUsr	( "qwerty" );
						bbvaUsuarioVO.setTmAlta			( new Date() );
						bbvaUsuarioVO.setTmModificacion	( new Date() );
						bbvaUsuarioVO.setFhUsuario		( new Date() );
						bbvaUsuarioVO.setTmCambioPws	( new Date() );
						bbvaUsuarioVO.setNuIntentos		( Integer.parseInt( "0" ) );
						bbvaUsuarioVO.setStUsuario		( Integer.parseInt( "0" ) );
						bbvaUsuarioVO.setCdPerfil		( Integer.parseInt( "0" ) );
				list.add( bbvaUsuarioVO );
				}
			
			final	List<BbvaUsuarioVO>	resultList	= bbvaIDataAccessObject.queryForList( "MantenimientoCatalogoMapper|createBbvaUsuarioVO", list );
			System.out.println( resultList );
		
			System.out.println( "Consulta  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
			final	List<BbvaUsuarioVO> searchList	= bbvaIDataAccessObject.queryForList( "MantenimientoCatalogoMapper|readBbvaUsuarioVOList" );
			System.out.println( searchList );
		
			System.out.println( "Eliminacion   - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
			int i = 0;
			for ( final BbvaUsuarioVO bbvaUsuarioVO : searchList )
				{
				if ( i++ % 2 == 0 ) continue;
				final	BbvaUsuarioVO
						bbvaUsuario	 = bbvaIDataAccessObject.queryForObject( "MantenimientoCatalogoMapper|deleteBbvaUsuarioVO", bbvaUsuarioVO );
				
				System.out.println( bbvaUsuario.toString() );
				}
		} 
		catch ( BbvaDataBaseException bbvaDataBaseException ) 
			{
			bbvaDataBaseException.printStackTrace();
			}
		}
//	Insercion - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	Entrada queryForList -- OK
//	Datos de Entrada       -- MantenimientoCatalogoMapper|createBbvaUsuarioVO -- [[BbvaUsuarioVO:CdUsuario=2,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=0,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=3,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=0,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=4,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=0,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=5,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=0,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=6,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=0,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=7,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=0,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=8,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=0,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=9,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=0,CdPerfil=0]]
//		Entrada validateQueryStructure -- OK
//		Datos de Entrada               -- MantenimientoCatalogoMapper|createBbvaUsuarioVO
//		Operacion de Base de Datos -- OK
//		queryName -- OK
//		mx.com.bbva.bancomer.mapper.persistence.sqlmapping.BbvaMantenimientoCatalogoMapper -- Existe -- OK
//		createBbvaUsuarioVO -- Existe -- OK
//		Datos de Salida                            -- mx.com.bbva.bancomer.mapper.persistence.sqlmapping.BbvaMantenimientoCatalogoMapper.createBbvaUsuarioVO
//		Salida -- validateQueryStructure Ejecutado -- OK
//	Operacion create permitida -- OK
//	Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=2,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=3,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=4,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=5,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=6,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=7,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=8,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=9,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	Salida -- queryForList Ejecutado -- OK
//	[[BbvaUsuarioVO:CdUsuario=2,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=3,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=4,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=5,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=6,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=7,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=8,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=9,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]]
//
//	Consulta  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	Entrada queryForList -- OK
//	Datos de Entrada     -- MantenimientoCatalogoMapper|readBbvaUsuarioVOList
//	Operacion read permitida -- OK
//		Entrada validateQueryStructure -- OK
//		Datos de Entrada               -- MantenimientoCatalogoMapper|readBbvaUsuarioVOList
//		Operacion de Base de Datos -- OK
//		queryName -- OK
//		mx.com.bbva.bancomer.mapper.persistence.sqlmapping.BbvaMantenimientoCatalogoMapper -- Existe -- OK
//		readBbvaUsuarioVOList -- Existe -- OK
//		Datos de Salida                            -- mx.com.bbva.bancomer.mapper.persistence.sqlmapping.BbvaMantenimientoCatalogoMapper.readBbvaUsuarioVOList
//		Salida -- validateQueryStructure Ejecutado -- OK
//	Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=2,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=1,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Actualizacion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=3,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=4,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=9,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=6,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=7,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=8,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=5,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	Salida -- queryForObject Ejecutado -- OK
//	[[BbvaUsuarioVO:CdUsuario=2,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=1,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Actualizacion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=3,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=4,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=9,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=6,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=7,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=8,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0], [BbvaUsuarioVO:CdUsuario=5,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]]
//
//	Eliminacion   - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	Entrada queryForObject -- OK
//	Datos de Entrada       -- MantenimientoCatalogoMapper|deleteBbvaUsuarioVO -- [BbvaUsuarioVO:CdUsuario=1,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Actualizacion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//		Entrada validateQueryStructure -- OK
//		Datos de Entrada               -- MantenimientoCatalogoMapper|deleteBbvaUsuarioVO
//		Operacion de Base de Datos -- OK
//		queryName -- OK
//		mx.com.bbva.bancomer.mapper.persistence.sqlmapping.BbvaMantenimientoCatalogoMapper -- Existe -- OK
//		deleteBbvaUsuarioVO -- Existe -- OK
//		Datos de Salida                            -- mx.com.bbva.bancomer.mapper.persistence.sqlmapping.BbvaMantenimientoCatalogoMapper.deleteBbvaUsuarioVO
//		Salida -- validateQueryStructure Ejecutado -- OK
//	Operacion create|read|update|delete permitida -- OK
//	Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=1,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Actualizacion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	Salida -- queryForObject Ejecutado -- OK
//	[BbvaUsuarioVO:CdUsuario=1,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Actualizacion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//
//	Entrada queryForObject -- OK
//	Datos de Entrada       -- MantenimientoCatalogoMapper|deleteBbvaUsuarioVO -- [BbvaUsuarioVO:CdUsuario=4,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//		Entrada validateQueryStructure -- OK
//		Datos de Entrada               -- MantenimientoCatalogoMapper|deleteBbvaUsuarioVO
//		Operacion de Base de Datos -- OK
//		queryName -- OK
//		mx.com.bbva.bancomer.mapper.persistence.sqlmapping.BbvaMantenimientoCatalogoMapper -- Existe -- OK
//		deleteBbvaUsuarioVO -- Existe -- OK
//		Datos de Salida                            -- mx.com.bbva.bancomer.mapper.persistence.sqlmapping.BbvaMantenimientoCatalogoMapper.deleteBbvaUsuarioVO
//		Salida -- validateQueryStructure Ejecutado -- OK
//	Operacion create|read|update|delete permitida -- OK
//	Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=4,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	Salida -- queryForObject Ejecutado -- OK
//	[BbvaUsuarioVO:CdUsuario=4,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//
//	Entrada queryForObject -- OK
//	Datos de Entrada       -- MantenimientoCatalogoMapper|deleteBbvaUsuarioVO -- [BbvaUsuarioVO:CdUsuario=6,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//		Entrada validateQueryStructure -- OK
//		Datos de Entrada               -- MantenimientoCatalogoMapper|deleteBbvaUsuarioVO
//		Operacion de Base de Datos -- OK
//		queryName -- OK
//		mx.com.bbva.bancomer.mapper.persistence.sqlmapping.BbvaMantenimientoCatalogoMapper -- Existe -- OK
//		deleteBbvaUsuarioVO -- Existe -- OK
//		Datos de Salida                            -- mx.com.bbva.bancomer.mapper.persistence.sqlmapping.BbvaMantenimientoCatalogoMapper.deleteBbvaUsuarioVO
//		Salida -- validateQueryStructure Ejecutado -- OK
//	Operacion create|read|update|delete permitida -- OK
//	Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=6,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	Salida -- queryForObject Ejecutado -- OK
//	[BbvaUsuarioVO:CdUsuario=6,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//
//	Entrada queryForObject -- OK
//	Datos de Entrada       -- MantenimientoCatalogoMapper|deleteBbvaUsuarioVO -- [BbvaUsuarioVO:CdUsuario=8,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//		Entrada validateQueryStructure -- OK
//		Datos de Entrada               -- MantenimientoCatalogoMapper|deleteBbvaUsuarioVO
//		Operacion de Base de Datos -- OK
//		queryName -- OK
//		mx.com.bbva.bancomer.mapper.persistence.sqlmapping.BbvaMantenimientoCatalogoMapper -- Existe -- OK
//		deleteBbvaUsuarioVO -- Existe -- OK
//		Datos de Salida                            -- mx.com.bbva.bancomer.mapper.persistence.sqlmapping.BbvaMantenimientoCatalogoMapper.deleteBbvaUsuarioVO
//		Salida -- validateQueryStructure Ejecutado -- OK
//	Operacion create|read|update|delete permitida -- OK
//	Datos de Salida                    -- [BbvaUsuarioVO:CdUsuario=8,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
//	Salida -- queryForObject Ejecutado -- OK
//	[BbvaUsuarioVO:CdUsuario=8,CdCveUsuario=prueba0123456789,NbUsuario=Usuario de Prueba - Insercion,TxPasswordUsr=qwerty,TmAlta=Wed May 08 14:20:35 CDT 2013,TmModificacion=Wed May 08 14:20:35 CDT 2013,FhUsuario=Wed May 08 14:20:35 CDT 2013,TmCambioPws=Wed May 08 14:20:35 CDT 2013,NuIntentos=0,StUsuario=null,CdPerfil=0]
/**
	 * Test query for object string.
	 *
	 * @throws BbvaDataBaseException the bbva data base exception
	 */
	@Test
	public final void testQueryForObjectString() throws BbvaDataBaseException
		{
		final	BbvaUsuarioVO 
				bbvaUsuarioVO = bbvaIDataAccessObject.queryForObject( "MantenimientoCatalogoMapper|readBbvaUsuarioVO" );

		System.out.println( bbvaUsuarioVO );
		}
//	Ejecucion de JUnit 
//	log4j:WARN No appenders could be found for logger (mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject).
//	log4j:WARN Please initialize the log4j system properly.
//	log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
//	Entrada queryForObject -- OK
//	Datos de Entrada       -- MantenimientoCatalogoMapper|readBbvaUsuarioVO
//	Operacion read permitida -- OK
//		Entrada validateQueryStructure -- OK
//		Datos de Entrada               -- MantenimientoCatalogoMapper|readBbvaUsuarioVO
//		Operacion de Base de Datos -- OK
//		queryName -- OK
//		mx.com.bbva.bancomer.mapper.persistence.sqlmapping.BbvaMantenimientoCatalogoMapper -- Existe -- OK
//		readBbvaUsuarioVO -- Existe -- OK
//		Datos de Salida                            -- mx.com.bbva.bancomer.mapper.persistence.sqlmapping.BbvaMantenimientoCatalogoMapper.readBbvaUsuarioVO
//		Salida -- validateQueryStructure Ejecutado -- OK
//	mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException: 9954|queryForObject|BbvaMyBatisDAO
	/**
 * Test query for object string t.
 *
 * @throws BbvaDataBaseException the bbva data base exception
 */
@Test
	public final void testQueryForObjectStringT() throws BbvaDataBaseException
		{
		final	BbvaUsuarioVO 
				bbvaUsuarioVO = new BbvaUsuarioVO();
				bbvaUsuarioVO.setCdUsuario		( Integer.parseInt( "1" ) );
				bbvaUsuarioVO.setCdCveUsuario	( "prueba0123456789" );
				bbvaUsuarioVO.setNbUsuario		( "Usuario de Prueba - Insercion" );
				bbvaUsuarioVO.setTxPasswordUsr	( "qwerty" );
				bbvaUsuarioVO.setTmAlta			( new Date() );
				bbvaUsuarioVO.setTmModificacion	( new Date() );
				bbvaUsuarioVO.setFhUsuario		( new Date() );
				bbvaUsuarioVO.setTmCambioPws	( new Date() );
				bbvaUsuarioVO.setNuIntentos		( Integer.parseInt( "0" ) );
				bbvaUsuarioVO.setStUsuario		( Integer.parseInt( "0" ) );
				bbvaUsuarioVO.setCdPerfil		( Integer.parseInt( "0" ) );

		System.out.println( "Insercion - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
		final	BbvaUsuarioVO
				bbvaUsuario	= bbvaIDataAccessObject.queryForObject( "MantenimientoCatalogoMapper|createBbvaUsuarioVO", bbvaUsuarioVO );
		System.out.println( bbvaUsuario.toString() );

		System.out.println( "Consulta  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
		final	BbvaUsuarioVO
				bbvaVO		= bbvaIDataAccessObject.queryForObject( "MantenimientoCatalogoMapper|readByAllRequiredBbvaUsuarioVO", bbvaUsuario );
		System.out.println( bbvaVO.toString() );

		System.out.println( "Actualizacion - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
				bbvaVO.setNbUsuario	( "Usuario de Prueba - Actualizacion" );
				bbvaVO.setTmModificacion( new Date() );
				bbvaVO.setNuIntentos	( Integer.parseInt( "0" ) );
				bbvaVO.setStUsuario		( Integer.parseInt( "0" ) );
				bbvaVO.setCdPerfil		( Integer.parseInt( "0" ) );
		final	BbvaUsuarioVO
				usuario		= bbvaIDataAccessObject.queryForObject( "MantenimientoCatalogoMapper|updateBbvaUsuarioVO", bbvaVO );
		System.out.println( usuario.toString() );
		}
	}