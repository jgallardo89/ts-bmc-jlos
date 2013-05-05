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
public	class 	BbvaPerfilVO 
		extends mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject 
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	private static final long serialVersionUID = -4809985381338507696L;

	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados
	private java.lang.Integer 	cdPerfil;		//	Llave primaria[TGM504_PERFIL] - 3 digitos [000 - 999 ]
	private java.lang.String	nbPerfil;		//	30 caracteres 
	private java.lang.String	txPerfil;		//	300 caracteres 
	private java.lang.Integer 	stPerfil; 		//	Llave foranea [TGM534_ST_OBJETO] - 5 digitos [00000 - 99999 ]

	//  Metodos       - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	
	public  java.lang.Integer getCdPerfil() 								{	return cdPerfil;				}
	public  void setCdPerfil( final java.lang.Integer cdPerfil )			{	this.cdPerfil = cdPerfil;		}

	public  java.lang.String getNbPerfil() 									{	return nbPerfil;				}
	public  void setNbPerfil( final java.lang.String nbPerfil ) 			{	this.nbPerfil = nbPerfil;		}

	public  java.lang.String getTxPerfil() 									{	return txPerfil;				}
	public  void setTxPerfil( final java.lang.String txPerfil ) 			{	this.txPerfil = txPerfil;		}

	public  java.lang.Integer getStPerfil() 								{	return stPerfil;				}
	public  void setStPerfil( final java.lang.Integer stPerfil ) 			{	this.stPerfil = stPerfil;		}
	}