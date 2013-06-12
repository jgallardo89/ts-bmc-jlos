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
 * Nombre de clase: BbvaAbstractBusinessObject.java
 * Nombre de paquete: mx.com.bbva.bancomer.commons.business
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.commons.business;

import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject;

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
 * 08-MAY-2013  F. Emmanuel Chavarria Ortiz		Creacion        1.0.0
 *              femmanuel.chavarriao@gmail.com
 *              Consultoria
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
/**
 * The Class BbvaAbstractBusinessObject.
 */
public 	abstract class 			BbvaAbstractBusinessObject 
				 implements 	BbvaIBusinessObject 
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	/** The Constant logger. */
	private static final org.apache.log4j.Logger 	logger			 = Logger.getLogger( BbvaAbstractBusinessObject.class );

	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados
	/** The bbva i data access object. */
	protected BbvaIDataAccessObject bbvaIDataAccessObject;

	//  Constructores - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	
    /**
     * Default constructor. 
     */
    public BbvaAbstractBusinessObject( ) 
    	{
		logger.info ( "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
		logger.info ( "Constructor Business Object -- OK -- Sin parametros" );
		logger.info ( "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
    	}
	
	/**
     * Default constructor.
     *
     * @param bbvaIDataAccessObject the bbva i data access object
     */
    public BbvaAbstractBusinessObject( final BbvaIDataAccessObject bbvaIDataAccessObject ) 
    	{
		logger.info ( "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
		logger.info ( "Constructor Business Object -- OK -- " + bbvaIDataAccessObject.getClass() );
		if ( this.bbvaIDataAccessObject == null )	this.bbvaIDataAccessObject = bbvaIDataAccessObject;
		logger.info ( "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" );
    	}

	//  Metodos       - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Implementacion de la interfase. Adaptador que no hace nada.
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject#createCommand(mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject)
	 */
	@Override
	public <T extends BbvaAbstractDataTransferObject> T createCommand	( final T bbvaAbstractDataTransferObject )	{	return null;	}
    
    /* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject#readCommand(mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject)
	 */
	@Override
	public <T extends BbvaAbstractDataTransferObject> T deleteCommand	( final T bbvaAbstractDataTransferObject )	{	return null;	}
	//	Propiedades
	/**
	 * Gets the bbva i data access object.
	 *
	 * @return the bbva i data access object
	 */
	public final BbvaIDataAccessObject getBbvaIDataAccessObject() 
		{	return bbvaIDataAccessObject;																		}
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject#updateCommand(mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject)
	 */
	@Override
	public <T extends BbvaAbstractDataTransferObject> T readCommand		( final T bbvaAbstractDataTransferObject )	{	return null;	}
	/**
	 * Sets the bbva i data access object.
	 *
	 * @param bbvaIDataAccessObject the new bbva i data access object
	 */
	public final void setBbvaIDataAccessObject( final	BbvaIDataAccessObject bbvaIDataAccessObject )
		{	if ( this.bbvaIDataAccessObject == null )	this.bbvaIDataAccessObject = bbvaIDataAccessObject;		}
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject#deleteCommand(mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject)
	 */
	@Override
	public <T extends BbvaAbstractDataTransferObject> T updateCommand	( final	T bbvaAbstractDataTransferObject )	{	return null;	}
	}