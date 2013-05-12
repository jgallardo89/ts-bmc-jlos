package mx.com.bbva.bancomer.test.business;

import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

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
public 	class 	BbvaCargarPantallaUsuarioDTO 
		extends	BbvaAbstractDataTransferObject
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	private static final long serialVersionUID = 5091295013578447185L;

	//	Privados
	private mx.com.bbva.bancomer.test.dao.BbvaUsuarioVO 				bbvaUsuarioVO;
	private java.util.List<mx.com.bbva.bancomer.test.dao.BbvaUsuarioVO> bbvaUsuarioVOList;

	//	Propiedades
	public mx.com.bbva.bancomer.test.dao.BbvaUsuarioVO getBbvaUsuarioVO()
		{	return bbvaUsuarioVO;												}
	public void setBbvaUsuarioVO( final mx.com.bbva.bancomer.test.dao.BbvaUsuarioVO bbvaUsuarioVO ) 
		{	this.bbvaUsuarioVO = bbvaUsuarioVO;									}

	public java.util.List<mx.com.bbva.bancomer.test.dao.BbvaUsuarioVO> getBbvaUsuarioVOList() 
		{	return bbvaUsuarioVOList;											}
	public void setBbvaUsuarioVOList( final java.util.List<mx.com.bbva.bancomer.test.dao.BbvaUsuarioVO> bbvaUsuarioVOList ) 
		{	this.bbvaUsuarioVOList = bbvaUsuarioVOList;							}
	}