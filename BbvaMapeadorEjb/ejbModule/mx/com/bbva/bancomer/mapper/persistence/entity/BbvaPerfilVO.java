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
 * Nombre de clase: BbvaPerfilVO.java
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
 * The Class BbvaPerfilVO.
 */
public	class 	BbvaPerfilVO 
		extends mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject 
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4809985381338507696L;

	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados
	/** The cd perfil. */
	private java.lang.Integer 	cdPerfil;		//	Llave primaria[TGM504_PERFIL] - 3 digitos [000 - 999 ]
	
	/** The nb perfil. */
	private java.lang.String	nbPerfil;		//	30 caracteres 
	
	/** The st perfil. */
	private java.lang.Integer 	stPerfil; 		//	Llave foranea [TGM534_ST_OBJETO] - 5 digitos [00000 - 99999 ]
	
	/** The tx perfil. */
	private java.lang.String	txPerfil;		//	300 caracteres 

	//  Metodos       - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	
	/**
	 * Gets the cd perfil.
	 *
	 * @return the cd perfil
	 */
	public  java.lang.Integer getCdPerfil() 								{	return cdPerfil;				}
	
	/**
	 * Gets the nb perfil.
	 *
	 * @return the nb perfil
	 */
	public  java.lang.String getNbPerfil() 									{	return nbPerfil;				}

	/**
	 * Gets the st perfil.
	 *
	 * @return the st perfil
	 */
	public  java.lang.Integer getStPerfil() 								{	return stPerfil;				}
	
	/**
	 * Gets the tx perfil.
	 *
	 * @return the tx perfil
	 */
	public  java.lang.String getTxPerfil() 									{	return txPerfil;				}

	/**
	 * Sets the cd perfil.
	 *
	 * @param cdPerfil the new cd perfil
	 */
	public  void setCdPerfil( final java.lang.Integer cdPerfil )			{	this.cdPerfil = cdPerfil;		}
	
	/**
	 * Sets the nb perfil.
	 *
	 * @param nbPerfil the new nb perfil
	 */
	public  void setNbPerfil( final java.lang.String nbPerfil ) 			{	this.nbPerfil = nbPerfil;		}

	/**
	 * Sets the st perfil.
	 *
	 * @param stPerfil the new st perfil
	 */
	public  void setStPerfil( final java.lang.Integer stPerfil ) 			{	this.stPerfil = stPerfil;		}
	
	/**
	 * Sets the tx perfil.
	 *
	 * @param txPerfil the new tx perfil
	 */
	public  void setTxPerfil( final java.lang.String txPerfil ) 			{	this.txPerfil = txPerfil;		}
	}