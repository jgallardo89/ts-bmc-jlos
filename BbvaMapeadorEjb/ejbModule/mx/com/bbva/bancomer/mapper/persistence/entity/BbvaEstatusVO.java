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
 * Nombre de proyecto: BbvaMapeadorEjb
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
 * Nombre de clase: BbvaEstatusVO.java
 * Nombre de paquete: mx.com.bbva.bancomer.mapper.persistence.entity
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.mapper.persistence.entity;


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
 * 02-MAY-2013  F. Emmanuel Chavarria Ortiz		Creacion        1.0.0
 *              femmanuel.chavarriao@gmail.com
 *              Consultoria
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
/**
 * The Class BbvaEstatusVO.
 */
public	class 	BbvaEstatusVO 
		extends mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject 
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4809985381338507696L;

	/** The cd st clave. */
	private java.lang.String	cdStClave;		//	Llave foranea [TGM509_ST_CLAVE] - 10 caracteres 
	
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados
	/** The cd st objeto. */
	private java.lang.Integer 	cdStObjeto;		//	Llave primaria[TGM534_ST_OBJETO] - 3 digitos [000 - 999 ]
	
	/** The nb st objeto. */
	private java.lang.String	nbStObjeto;		//	30 caracteres 
	
	/** The nb tabla. */
	private java.lang.Integer 	nbTabla; 		//	30 caracteres
	
	/** The tx st objeto. */
	private java.lang.String	txStObjeto;		//	200 caracteres 

	/**
	 * Gets the cd st clave.
	 *
	 * @return the cd st clave
	 */
	public  java.lang.String getCdStClave() 							{	return cdStClave;				}
	
	//  Metodos       - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	
	/**
	 * Gets the cd st objeto.
	 *
	 * @return the cd st objeto
	 */
	public  java.lang.Integer getCdStObjeto() 							{	return cdStObjeto;				}

	/**
	 * Gets the nb st objeto.
	 *
	 * @return the nb st objeto
	 */
	public  java.lang.String getNbStObjeto() 							{	return nbStObjeto;				}
	
	/**
	 * Gets the nb tabla.
	 *
	 * @return the nb tabla
	 */
	public  java.lang.Integer getNbTabla() 								{	return nbTabla;					}

	/**
	 * Gets the tx st objeto.
	 *
	 * @return the tx st objeto
	 */
	public  java.lang.String getTxStObjeto() 							{	return txStObjeto;				}
	
	/**
	 * Sets the cd st clave.
	 *
	 * @param cdStClave the new cd st clave
	 */
	public  void setCdStClave( final java.lang.String cdStClave ) 		{	this.cdStClave = cdStClave;		}

	/**
	 * Sets the cd st objeto.
	 *
	 * @param cdStObjeto the new cd st objeto
	 */
	public  void setCdStObjeto( final java.lang.Integer cdStObjeto )	{	this.cdStObjeto = cdStObjeto;	}
	
	/**
	 * Sets the nb st objeto.
	 *
	 * @param nbStObjeto the new nb st objeto
	 */
	public  void setNbStObjeto( final java.lang.String nbStObjeto ) 	{	this.nbStObjeto = nbStObjeto;	}

	/**
	 * Sets the nb tabla.
	 *
	 * @param nbTabla the new nb tabla
	 */
	public  void setNbTabla( final java.lang.Integer nbTabla ) 			{	this.nbTabla = nbTabla;			}
	
	/**
	 * Sets the tx st objeto.
	 *
	 * @param txStObjeto the new tx st objeto
	 */
	public  void setTxStObjeto( final java.lang.String txStObjeto ) 	{	this.txStObjeto = txStObjeto;	}
	}