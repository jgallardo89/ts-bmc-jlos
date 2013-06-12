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
 * Nombre de clase: BbvaCargarPantallaUsuarioDTO.java
 * Nombre de paquete: mx.com.bbva.bancomer.test.business
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.test.business;

import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

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
 * The Class BbvaCargarPantallaUsuarioDTO.
 */
public 	class 	BbvaCargarPantallaUsuarioDTO 
		extends	BbvaAbstractDataTransferObject
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5091295013578447185L;

	//	Privados
	/** The bbva usuario vo. */
	private mx.com.bbva.bancomer.test.dao.BbvaUsuarioVO 				bbvaUsuarioVO;
	
	/** The bbva usuario vo list. */
	private java.util.List<mx.com.bbva.bancomer.test.dao.BbvaUsuarioVO> bbvaUsuarioVOList;

	//	Propiedades
	/**
	 * Gets the bbva usuario vo.
	 *
	 * @return the bbva usuario vo
	 */
	public mx.com.bbva.bancomer.test.dao.BbvaUsuarioVO getBbvaUsuarioVO()
		{	return bbvaUsuarioVO;												}
	
	/**
	 * Gets the bbva usuario vo list.
	 *
	 * @return the bbva usuario vo list
	 */
	public java.util.List<mx.com.bbva.bancomer.test.dao.BbvaUsuarioVO> getBbvaUsuarioVOList() 
		{	return bbvaUsuarioVOList;											}

	/**
	 * Sets the bbva usuario vo.
	 *
	 * @param bbvaUsuarioVO the new bbva usuario vo
	 */
	public void setBbvaUsuarioVO( final mx.com.bbva.bancomer.test.dao.BbvaUsuarioVO bbvaUsuarioVO ) 
		{	this.bbvaUsuarioVO = bbvaUsuarioVO;									}
	
	/**
	 * Sets the bbva usuario vo list.
	 *
	 * @param bbvaUsuarioVOList the new bbva usuario vo list
	 */
	public void setBbvaUsuarioVOList( final java.util.List<mx.com.bbva.bancomer.test.dao.BbvaUsuarioVO> bbvaUsuarioVOList ) 
		{	this.bbvaUsuarioVOList = bbvaUsuarioVOList;							}
	}