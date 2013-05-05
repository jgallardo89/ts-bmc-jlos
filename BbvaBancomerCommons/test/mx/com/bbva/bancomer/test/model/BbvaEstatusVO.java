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
public	class 	BbvaEstatusVO 
		extends mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject 
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	private static final long serialVersionUID = -4809985381338507696L;

	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados
	private java.lang.Integer 	cdStObjeto;		//	Llave primaria[TGM534_ST_OBJETO] - 3 digitos [000 - 999 ]
	private java.lang.String	cdStClave;		//	Llave foranea [TGM509_ST_CLAVE] - 10 caracteres 
	private java.lang.String	nbStObjeto;		//	30 caracteres 
	private java.lang.String	txStObjeto;		//	200 caracteres 
	private java.lang.Integer 	nbTabla; 		//	30 caracteres

	//  Metodos       - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	
	public  java.lang.Integer getCdStObjeto() 							{	return cdStObjeto;				}
	public  void setCdStObjeto( final java.lang.Integer cdStObjeto )	{	this.cdStObjeto = cdStObjeto;	}

	public  java.lang.String getCdStClave() 							{	return cdStClave;				}
	public  void setCdStClave( final java.lang.String cdStClave ) 		{	this.cdStClave = cdStClave;		}

	public  java.lang.String getNbStObjeto() 							{	return nbStObjeto;				}
	public  void setNbStObjeto( final java.lang.String nbStObjeto ) 	{	this.nbStObjeto = nbStObjeto;	}

	public  java.lang.String getTxStObjeto() 							{	return txStObjeto;				}
	public  void setTxStObjeto( final java.lang.String txStObjeto ) 	{	this.txStObjeto = txStObjeto;	}

	public  java.lang.Integer getNbTabla() 								{	return nbTabla;					}
	public  void setNbTabla( final java.lang.Integer nbTabla ) 			{	this.nbTabla = nbTabla;			}
	}