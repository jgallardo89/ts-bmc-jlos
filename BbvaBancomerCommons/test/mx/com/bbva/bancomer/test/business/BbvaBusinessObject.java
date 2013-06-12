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
 * Nombre de clase: BbvaBusinessObject.java
 * Nombre de paquete: mx.com.bbva.bancomer.test.business
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.test.business;

import java.util.List;

import mx.com.bbva.bancomer.commons.business.BbvaAbstractBusinessObject;
import mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException;
import mx.com.bbva.bancomer.test.dao.BbvaUsuarioVO;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Informacion Confidencial:
 * Este software contiene informacion totalmente confidencial propiedad de Grupo Financiero BBVA Bancomer. 
 * Queda totalmente prohibido su uso o divulgacion en forma parcial o total y solamente podra ser utilizada de acuerdo a los terminos y estatutos 
 * que determine el Grupo Financiero BBVA Bancomer.
 * 
 * Todos los derechos reservados, Mexico 2013.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * DESCRIPCION DEL PROGRAMA:
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * HISTORIAL DE CAMBIOS:
 * 
 * Fecha:		Por:							Razon:         	Version
 * 05-MAY-2013  F. Emmanuel Chavarria Ortiz		Creacion        1.0.0
 *              femmanuel.chavarriao@gmail.com
 *              Consultoria
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
/**
 * The Class BbvaBusinessObject.
 */
public 	class 		BbvaBusinessObject 
		extends		BbvaAbstractBusinessObject
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	/** The Constant logger. */
	private static final org.apache.log4j.Logger 	logger			 = Logger.getLogger( BbvaBusinessObject.class );

	//  Constructores - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	
    /**
     * Default constructor. 
     */
    public BbvaBusinessObject( ) 
    	{	super();						}
    
    /**
     * Default constructor.
     *
     * @param bbvaIDataAccessObject the bbva i data access object
     */
    public BbvaBusinessObject( final mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject bbvaIDataAccessObject ) 
    	{	super( bbvaIDataAccessObject );	}
   
	//  Metodos       - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Sobre escribimos la implementacion de la interfase. Estos metodos son los que se ejecutaran al final.
	/**
	 * <b>readCommand</b>.
	 *
	 * @param bbvaCargarPantallaUsuarioDTO the bbva cargar pantalla usuario dto
	 * @return the bbva cargar pantalla usuario dto
	 */
	public BbvaCargarPantallaUsuarioDTO readCommand	( final BbvaCargarPantallaUsuarioDTO bbvaCargarPantallaUsuarioDTO ) 
		{
		try {
			logger.info ( "Entrada readCommand -- OK" );
			logger.info ( "Datos de Entrada      -- " + bbvaCargarPantallaUsuarioDTO );
			
			final	List<BbvaUsuarioVO> list = this.bbvaIDataAccessObject
			                                       .queryForList( "MantenimientoCatalogoMapper|readBbvaUsuarioVOList" );

			bbvaCargarPantallaUsuarioDTO.setBbvaUsuarioVO		( new BbvaUsuarioVO() );
			bbvaCargarPantallaUsuarioDTO.setBbvaUsuarioVOList	( list );
			
			logger.info ( "Salida readCommand  -- OK" );
			logger.info ( "Datos de Salida       -- " + bbvaCargarPantallaUsuarioDTO );
			} 
		catch ( BbvaDataBaseException bbvaDataBaseException ) 
			{
			bbvaCargarPantallaUsuarioDTO.setErrorCode		( bbvaDataBaseException.getErrorCode		() );
			bbvaCargarPantallaUsuarioDTO.setErrorDescription( bbvaDataBaseException.getErrorDescription	() );
			}
		return bbvaCargarPantallaUsuarioDTO;
		}
	
	/**
	 * <b>readCommand</b>.
	 *
	 * @param bbvaCargarTablaUsuarioDTO the bbva cargar tabla usuario dto
	 * @return the bbva cargar tabla usuario dto
	 */
	public BbvaCargarTablaUsuarioDTO readCommand	( final BbvaCargarTablaUsuarioDTO bbvaCargarTablaUsuarioDTO ) 
		{
		try {
			logger.info ( "Entrada readCommand -- OK" );
			logger.info ( "Datos de Entrada      -- " + bbvaCargarTablaUsuarioDTO );
			
			final	List<BbvaUsuarioVO> list = this.bbvaIDataAccessObject
			                                       .queryForList( "MantenimientoCatalogoMapper|readBbvaUsuarioVOList" );

			bbvaCargarTablaUsuarioDTO.setBbvaUsuarioVOList	( list );
			
			logger.info ( "Salida readCommand  -- OK" );
			logger.info ( "Datos de Salida       -- " + bbvaCargarTablaUsuarioDTO );
			} 
		catch ( BbvaDataBaseException bbvaDataBaseException ) 
			{
			bbvaCargarTablaUsuarioDTO.setErrorCode		( bbvaDataBaseException.getErrorCode		() );
			bbvaCargarTablaUsuarioDTO.setErrorDescription( bbvaDataBaseException.getErrorDescription	() );
			}
		return bbvaCargarTablaUsuarioDTO;
		}
	}