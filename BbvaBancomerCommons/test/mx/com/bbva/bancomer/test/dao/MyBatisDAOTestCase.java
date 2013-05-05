package mx.com.bbva.bancomer.test.dao;

import java.util.List;

import mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException;
import mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject;
import mx.com.bbva.bancomer.test.model.BbvaEstatusVO;
import mx.com.bbva.bancomer.test.model.BbvaPerfilVO;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MyBatisDAOTestCase 
	{
	private static final String
						 SPRINGFILEPATH		= "C:/workspace/BbvaBancomerCommons/test/mx/com/bbva/bancomer/test/dao/application-context.xml";

	private static final ApplicationContext 	
						 applicationContext = new FileSystemXmlApplicationContext( SPRINGFILEPATH );

	private static final BbvaIDataAccessObject	
						 bbvaIDataAccessObject = (BbvaIDataAccessObject)applicationContext.getBean( "bbvaMyBatisDAO" );

	@Test
	public final void testQueryForObjectString() 
		{
		try {
			final	BbvaEstatusVO
					bbvaEstatusVO = bbvaIDataAccessObject.queryForObject( "ConsultarCatalogoMapper|readBbvaEstatusVO" );

			System.out.println( bbvaEstatusVO.toString() );
			} 
		catch ( BbvaDataBaseException bbvaDataBaseException ) 
			{
			bbvaDataBaseException.printStackTrace();
			}
		}
//	Ejecucion de JUnit 
//	log4j:WARN No appenders could be found for logger (mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject).
//	log4j:WARN Please initialize the log4j system properly.
//	log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
//	Entrada queryForObject -- OK
//	Datos de Entrada       -- CatalogoMapper|readBbvaEstatusVO
//	Datos de Salida                    -- [BbvaEstatusVO:CdStObjeto=1,CdStClave=1         ,NbStObjeto=Activa,TxStObjeto=Indicador de pantalla activa,NbTabla=null]
//	Datos de Salida                    -- [BbvaEstatusVO:CdStObjeto=2,CdStClave=2         ,NbStObjeto=Activa,TxStObjeto=Indicador de perfil activo,NbTabla=null]
//	Datos de Salida                    -- [BbvaEstatusVO:CdStObjeto=3,CdStClave=3         ,NbStObjeto=Activo,TxStObjeto=Indicador de estatus usuario,NbTabla=null]
//	Datos de Salida                    -- [BbvaEstatusVO:CdStObjeto=4,CdStClave=4         ,NbStObjeto=Inactivo,TxStObjeto=Indicador de estatus usuario,NbTabla=null]
//	Datos de Salida                    -- [BbvaEstatusVO:CdStObjeto=5,CdStClave=5         ,NbStObjeto=Baja,TxStObjeto=Indicador de estatus usuario,NbTabla=null]
//	Datos de Salida                    -- [BbvaEstatusVO:CdStObjeto=6,CdStClave=6         ,NbStObjeto=Bloqueado,TxStObjeto=Indicador de estatus usuario,NbTabla=null]
//	Datos de Salida                    -- [BbvaEstatusVO:CdStObjeto=7,CdStClave=7         ,NbStObjeto=Vacaciones,TxStObjeto=Indicador de estatus usuario,NbTabla=null]
//	Salida -- queryForObject Ejecutado -- OK
//	[BbvaEstatusVO:CdStObjeto=1,CdStClave=1         ,NbStObjeto=Activa,TxStObjeto=Indicador de pantalla activa,NbTabla=null]
	@Test
	public final void testQueryForObjectStringT() 
		{
		}
	@Test
	public final void testQueryForListString() 
		{
		try {
			final	List<BbvaPerfilVO>
					list = bbvaIDataAccessObject.queryForList( "ConsultarCatalogoMapper|readBbvaPerfilVO" );

			System.out.println( list );
			} 
		catch ( BbvaDataBaseException bbvaDataBaseException ) 
			{
			bbvaDataBaseException.printStackTrace();
			}
		}
//	Ejecucion de JUnit 
//	Entrada queryForList -- OK
//	Datos de Entrada     -- CatalogoMapper|readBbvaPerfilVO
//	Datos de Salida                    -- [BbvaPerfilVO:CdPerfil=1,NbPerfil=Administración,TxPerfil=Perfil para la administración del sistema,StPerfil=2]
//	Datos de Salida                    -- [BbvaPerfilVO:CdPerfil=2,NbPerfil=Usuario,TxPerfil=Perfil para la administración del sistema,StPerfil=2]
//	Salida -- queryForObject Ejecutado -- OK
//	[[BbvaPerfilVO:CdPerfil=1,NbPerfil=Administración,TxPerfil=Perfil para la administración del sistema,StPerfil=2], [BbvaPerfilVO:CdPerfil=2,NbPerfil=Usuario,TxPerfil=Perfil para la administración del sistema,StPerfil=2]]
	@Test
	public final void testQueryForListStringT() 
		{
		}
	}