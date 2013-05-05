package mx.com.bbva.bancomer.test.model;


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
public	class 	BbvaUsuarioVO 
		extends mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject 
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	private static final long serialVersionUID = 6760690120038374296L;

	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados
	private java.lang.Integer 	cdUsuario;		//	Llave primaria[TGM503_USUARIO] - 5 digitos [00000 - 99999 ]
	private java.lang.String	cdCveUsuario;	//	20 caracteres 
	private java.lang.String	nbUsuario;		//	50 caracteres 
	private java.lang.String	txPasswordUsr;	//	35 caracteres 
	private java.util.Date		tmAlta;			//	Formato - ??? 
	private java.util.Date		tmModificacion;	//	Formato - ???
	private java.util.Date		fhUsuario;		//	Formato - ???
	private java.util.Date		tmCambioPws;	//	Formato - ???
	private java.lang.Integer 	nuIntentos;		//	5 digitos [00000 - 99999 ]
	private java.lang.Integer 	stUsuario; 		//	Llave foranea [TGM534_ST_OBJETO] - 5 digitos [00000 - 99999 ]
	private java.lang.Integer 	cdPerfil;		//	Llave foranea [TGM504_PERFIL]    - 3 digitos [00000 - 99999 ]

	//  Metodos       - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	
	public  java.lang.Integer getCdUsuario() 								{	return cdUsuario;						}
	public  void setCdUsuario( final java.lang.Integer cdUsuario )			{	this.cdUsuario = cdUsuario;				}

	public  java.lang.String getCdCveUsuario() 								{	return cdCveUsuario;					}
	public  void setCdCveUsuario( final java.lang.String cdCveUsuario ) 	{	this.cdCveUsuario = cdCveUsuario;		}

	public  java.lang.String getNbUsuario() 								{	return nbUsuario;						}
	public  void setNbUsuario( final java.lang.String nbUsuario ) 			{	this.nbUsuario = nbUsuario;				}

	public  java.lang.String getTxPasswordUsr() 							{	return txPasswordUsr;					}
	public  void setTxPasswordUsr( final java.lang.String txPasswordUsr ) 	{	this.txPasswordUsr = txPasswordUsr;		}

	public  java.util.Date getTmAlta() 										{	return tmAlta;							}
	public  void setTmAlta( final java.util.Date tmAlta )					{	this.tmAlta = tmAlta;					}

	public  java.util.Date getTmModificacion() 								{	return tmModificacion;					}
	public  void setTmModificacion( final java.util.Date tmModificacion ) 	{	this.tmModificacion = tmModificacion;	}

	public  java.util.Date getFhUsuario() 									{	return fhUsuario;						}
	public  void setFhUsuario( final java.util.Date fhUsuario ) 			{	this.fhUsuario = fhUsuario;				}

	public  java.util.Date getTmCambioPws() 								{	return tmCambioPws;						}
	public  void setTmCambioPws( final java.util.Date tmCambioPws ) 		{	this.tmCambioPws = tmCambioPws;			}

	public  java.lang.Integer getNuIntentos() 								{	return nuIntentos;						}
	public  void setNuIntentos( final java.lang.Integer nuIntentos ) 		{	this.nuIntentos = nuIntentos;			}

	public  java.lang.Integer getStUsuario() 								{	return stUsuario;						}
	public  void setStUsuario( final java.lang.Integer stUsuario ) 			{	this.stUsuario = stUsuario;				}

	public  java.lang.Integer getCdPerfil() 								{	return cdPerfil;						}
	public  void setCdPerfil( final java.lang.Integer cdPerfil ) 			{	this.cdPerfil = cdPerfil;				}
	}