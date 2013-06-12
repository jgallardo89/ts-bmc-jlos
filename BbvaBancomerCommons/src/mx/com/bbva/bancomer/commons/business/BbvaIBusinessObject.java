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
 * Nombre de clase: BbvaIBusinessObject.java
 * Nombre de paquete: mx.com.bbva.bancomer.commons.business
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.commons.business;

import javax.ejb.Local;

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
 * 01-MAY-2013  F. Emmanuel Chavarria Ortiz		Creacion        1.0.0
 *              femmanuel.chavarriao@gmail.com
 *              Consultoria
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
/**
 * The Interface BbvaIBusinessObject.
 */
@Local
public interface BbvaIBusinessObject 
	{
	
	/**
	 * <b>createCommand</b>
	 * Ejecuta logica de negocio para registro en base de datos.
	 *
	 * @param <T> - bbvaAbstractDataTransferObject - Bean contenedor especifico para caso de uso Registrar X.
	 * @param bbvaAbstractDataTransferObject the bbva abstract data transfer object
	 * @return mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject.
	 */
	public < T extends BbvaAbstractDataTransferObject > T createCommand ( final T bbvaAbstractDataTransferObject );
	
	/**
	 * <b>deleteCommand</b>
	 * Ejecuta logica de negocio para eliminacion en base de datos.
	 * Normalmente la eliminación se da como borrado logico, es decir, solo se deshabilita una bandera de estatus.
	 *
	 * @param <T> - bbvaAbstractDataTransferObject - Bean contenedor especifico para caso de uso Eliminar X.
	 * @param bbvaAbstractDataTransferObject the bbva abstract data transfer object
	 * @return mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject.
	 */
	public < T extends BbvaAbstractDataTransferObject > T deleteCommand ( final T bbvaAbstractDataTransferObject );
	
	/**
	 * <b>readCommand</b>
	 * Ejecuta logica de negocio para consulta de base de datos.
	 *
	 * @param <T> - bbvaAbstractDataTransferObject - Bean contenedor especifico para caso de uso Consultar X.
	 * @param bbvaAbstractDataTransferObject the bbva abstract data transfer object
	 * @return mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject.
	 */
	public < T extends BbvaAbstractDataTransferObject > T readCommand   ( final T bbvaAbstractDataTransferObject );
	
	/**
	 * <b>updateCommand</b>
	 * Ejecuta logica de negocio para actualizacion en base de datos.
	 *
	 * @param <T> - bbvaAbstractDataTransferObject - Bean contenedor especifico para caso de uso Actualizar X.
	 * @param bbvaAbstractDataTransferObject the bbva abstract data transfer object
	 * @return mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject.
	 */
	public < T extends BbvaAbstractDataTransferObject > T updateCommand ( final T bbvaAbstractDataTransferObject );
	}