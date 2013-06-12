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
 * Nombre de clase: BbvaUsuarioVO.java
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
 * The Class BbvaUsuarioVO.
 */
public	class 	BbvaUsuarioVO 
		extends mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject 
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6760690120038374296L;

	/** The cd cve usuario. */
	private java.lang.String	cdCveUsuario;	//	20 caracteres 
	
	/** The cd perfil. */
	private java.lang.Integer 	cdPerfil;		//	Llave foranea [TGM504_PERFIL]    - 3 digitos [00000 - 99999 ]
	
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados
	/** The cd usuario. */
	private java.lang.Integer 	cdUsuario;		//	Llave primaria[TGM503_USUARIO] - 5 digitos [00000 - 99999 ]
	
	/** The fh usuario. */
	private java.util.Date		fhUsuario;		//	Formato - ???
	
	/** The nb usuario. */
	private java.lang.String	nbUsuario;		//	50 caracteres 
	
	/** The nu intentos. */
	private java.lang.Integer 	nuIntentos;		//	5 digitos [00000 - 99999 ]
	
	/** The st usuario. */
	private java.lang.Integer 	stUsuario; 		//	Llave foranea [TGM534_ST_OBJETO] - 5 digitos [00000 - 99999 ]
	
	/** The tm alta. */
	private java.util.Date		tmAlta;			//	Formato - ??? 
	
	/** The tm cambio pws. */
	private java.util.Date		tmCambioPws;	//	Formato - ???
	
	/** The tm modificacion. */
	private java.util.Date		tmModificacion;	//	Formato - ???
	
	/** The tx password usr. */
	private java.lang.String	txPasswordUsr;	//	35 caracteres 

	/**
	 * Gets the cd cve usuario.
	 *
	 * @return the cd cve usuario
	 */
	public  java.lang.String getCdCveUsuario() 								{	return cdCveUsuario;					}
	
	/**
	 * Gets the cd perfil.
	 *
	 * @return the cd perfil
	 */
	public  java.lang.Integer getCdPerfil() 								{	return cdPerfil;						}

	//  Metodos       - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	
	/**
	 * Gets the cd usuario.
	 *
	 * @return the cd usuario
	 */
	public  java.lang.Integer getCdUsuario() 								{	return cdUsuario;						}
	
	/**
	 * Gets the fh usuario.
	 *
	 * @return the fh usuario
	 */
	public  java.util.Date getFhUsuario() 									{	return fhUsuario;						}

	/**
	 * Gets the nb usuario.
	 *
	 * @return the nb usuario
	 */
	public  java.lang.String getNbUsuario() 								{	return nbUsuario;						}
	
	/**
	 * Gets the nu intentos.
	 *
	 * @return the nu intentos
	 */
	public  java.lang.Integer getNuIntentos() 								{	return nuIntentos;						}

	/**
	 * Gets the st usuario.
	 *
	 * @return the st usuario
	 */
	public  java.lang.Integer getStUsuario() 								{	return stUsuario;						}
	
	/**
	 * Gets the tm alta.
	 *
	 * @return the tm alta
	 */
	public  java.util.Date getTmAlta() 										{	return tmAlta;							}

	/**
	 * Gets the tm cambio pws.
	 *
	 * @return the tm cambio pws
	 */
	public  java.util.Date getTmCambioPws() 								{	return tmCambioPws;						}
	
	/**
	 * Gets the tm modificacion.
	 *
	 * @return the tm modificacion
	 */
	public  java.util.Date getTmModificacion() 								{	return tmModificacion;					}

	/**
	 * Gets the tx password usr.
	 *
	 * @return the tx password usr
	 */
	public  java.lang.String getTxPasswordUsr() 							{	return txPasswordUsr;					}
	
	/**
	 * Sets the cd cve usuario.
	 *
	 * @param cdCveUsuario the new cd cve usuario
	 */
	public  void setCdCveUsuario( final java.lang.String cdCveUsuario ) 	{	this.cdCveUsuario = cdCveUsuario;		}

	/**
	 * Sets the cd perfil.
	 *
	 * @param cdPerfil the new cd perfil
	 */
	public  void setCdPerfil( final java.lang.Integer cdPerfil ) 			{	this.cdPerfil = cdPerfil;				}
	
	/**
	 * Sets the cd usuario.
	 *
	 * @param cdUsuario the new cd usuario
	 */
	public  void setCdUsuario( final java.lang.Integer cdUsuario )			{	this.cdUsuario = cdUsuario;				}

	/**
	 * Sets the fh usuario.
	 *
	 * @param fhUsuario the new fh usuario
	 */
	public  void setFhUsuario( final java.util.Date fhUsuario ) 			{	this.fhUsuario = fhUsuario;				}
	
	/**
	 * Sets the nb usuario.
	 *
	 * @param nbUsuario the new nb usuario
	 */
	public  void setNbUsuario( final java.lang.String nbUsuario ) 			{	this.nbUsuario = nbUsuario;				}

	/**
	 * Sets the nu intentos.
	 *
	 * @param nuIntentos the new nu intentos
	 */
	public  void setNuIntentos( final java.lang.Integer nuIntentos ) 		{	this.nuIntentos = nuIntentos;			}
	
	/**
	 * Sets the st usuario.
	 *
	 * @param stUsuario the new st usuario
	 */
	public  void setStUsuario( final java.lang.Integer stUsuario ) 			{	this.stUsuario = stUsuario;				}

	/**
	 * Sets the tm alta.
	 *
	 * @param tmAlta the new tm alta
	 */
	public  void setTmAlta( final java.util.Date tmAlta )					{	this.tmAlta = tmAlta;					}
	
	/**
	 * Sets the tm cambio pws.
	 *
	 * @param tmCambioPws the new tm cambio pws
	 */
	public  void setTmCambioPws( final java.util.Date tmCambioPws ) 		{	this.tmCambioPws = tmCambioPws;			}

	/**
	 * Sets the tm modificacion.
	 *
	 * @param tmModificacion the new tm modificacion
	 */
	public  void setTmModificacion( final java.util.Date tmModificacion ) 	{	this.tmModificacion = tmModificacion;	}
	
	/**
	 * Sets the tx password usr.
	 *
	 * @param txPasswordUsr the new tx password usr
	 */
	public  void setTxPasswordUsr( final java.lang.String txPasswordUsr ) 	{	this.txPasswordUsr = txPasswordUsr;		}
	}