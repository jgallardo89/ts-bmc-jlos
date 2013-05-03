package mx.com.bbva.bancomer.commons.persistence.dao;

import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

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
public interface BbvaIMyBatisMapper 
	{
	/**
	 * <b>create</b>
	 * @param queryMapValues - Mapa de valores que se le pasan a la consulta.
	 * @return java.lang.Integer
	 * @throws mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException
	 */
	public < T extends BbvaAbstractValueObject > java.lang.Integer create ( final T bbvaAbstractValueObject );
	/**
	 * <b>read</b>
	 * @param <T> - BbvaAbstractValueObject - Contenedor de especifico para cada tabla de base de datos.
	 * @return java.util.List<mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject>
	 * @throws mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException
	 */
	public < T extends BbvaAbstractValueObject > java.util.List<T> read ( );
	/**
	 * <b>read</b>
	 * @param <T> - BbvaAbstractValueObject - Contenedor de especifico para cada tabla de base de datos.
	 * @param queryMapValues - Mapa de valores que se le pasan a la consulta.
	 * @return java.util.List<mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject>
	 * @throws mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException
	 */
	public < T extends BbvaAbstractValueObject > java.util.List<T> read ( final T bbvaAbstractValueObject );
	/**
	 * <b>update</b>
	 * @param <T> - BbvaAbstractValueObject - Contenedor de especifico para cada tabla de base de datos.
	 * @param queryMapValues - Mapa de valores que se le pasan a la consulta.
	 * @return java.util.List<mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject>
	 * @throws mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException
	 */
	public < T extends BbvaAbstractValueObject > java.lang.Integer update ( final T bbvaAbstractValueObject );
	/**
	 * <b>delete</b>
	 * @param <T> - BbvaAbstractValueObject - Contenedor de especifico para cada tabla de base de datos.
	 * @param queryMapValues - Mapa de valores que se le pasan a la consulta.
	 * @return java.util.List<mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject>
	 * @throws mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException
	 */
	public < T extends BbvaAbstractValueObject > java.lang.Integer delete ( final T bbvaAbstractValueObject );
	}