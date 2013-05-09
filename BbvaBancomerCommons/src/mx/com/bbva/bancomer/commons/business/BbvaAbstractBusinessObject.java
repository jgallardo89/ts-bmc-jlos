package mx.com.bbva.bancomer.commons.business;

import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.commons.persistence.dao.BbvaIDataAccessObject;

import org.apache.log4j.Logger;

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
public 	abstract class 			BbvaAbstractBusinessObject 
				 implements 	BbvaIBusinessObject 
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	private static final org.apache.log4j.Logger 	logger			 = Logger.getLogger( BbvaAbstractBusinessObject.class );

	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados
	protected BbvaIDataAccessObject bbvaIDataAccessObject;

	//	Propiedades
	public final BbvaIDataAccessObject getBbvaIDataAccessObject() 
		{	return bbvaIDataAccessObject;																		}
	public final void setBbvaIDataAccessObject( final	BbvaIDataAccessObject bbvaIDataAccessObject )
		{	if ( this.bbvaIDataAccessObject == null )	this.bbvaIDataAccessObject = bbvaIDataAccessObject;		}

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
	public <T extends BbvaAbstractDataTransferObject> T createCommand	( final T bbvaAbstractDataTransferObject )	{	return null;	}
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject#updateCommand(mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject)
	 */
	public <T extends BbvaAbstractDataTransferObject> T readCommand		( final T bbvaAbstractDataTransferObject )	{	return null;	}
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject#deleteCommand(mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject)
	 */
	public <T extends BbvaAbstractDataTransferObject> T updateCommand	( final	T bbvaAbstractDataTransferObject )	{	return null;	}
	/* (non-Javadoc)
	 * @see mx.com.bbva.bancomer.commons.business.BbvaIBusinessObject#readCommand(mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject)
	 */
	public <T extends BbvaAbstractDataTransferObject> T deleteCommand	( final T bbvaAbstractDataTransferObject )	{	return null;	}
	}