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
 * Nombre de clase: BbvaIDataAccessObject.java
 * Nombre de paquete: mx.com.bbva.bancomer.commons.persistence.dao
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.commons.persistence.dao;

import mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException;
import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

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
 * The Interface BbvaIDataAccessObject.
 */
public interface BbvaIDataAccessObject 
	{	
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	/** The Constant MYBATISSQLMAPPERPACKAGE. */
	public static final java.lang.String MYBATISSQLMAPPERPACKAGE = "mx.com.bbva.bancomer.mapper.persistence.sqlmapping.Bbva";

	/**
	 * <b>queryForList</b>
	 * Metodo de consulta a base de datos.
	 *
	 * @param <T> - BbvaAbstractValueObject - Contenedor de especifico para cada tabla de base de datos.
	 * @param queryName - String nombre de la consulta.
	 * @return java.util.List<mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject>
	 * @throws BbvaDataBaseException the bbva data base exception
	 */
	public < T extends BbvaAbstractValueObject > java.util.List<T> queryForList ( 	final java.lang.String queryName ) 
	throws mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException;
	
	/**
	 * <b>queryForList</b>
	 * Metodo de creacion, actualizacion y eliminacion en base de datos.
	 *
	 * @param <T> - BbvaAbstractValueObject - Contenedor de especifico para cada tabla de base de datos.
	 * @param queryName - String nombre de la consulta.
	 * @param bbvaAbstractValueObject the bbva abstract value object
	 * @return java.util.List<mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject>
	 * @throws BbvaDataBaseException the bbva data base exception
	 */
	public < T extends BbvaAbstractValueObject > java.util.List<T> queryForList ( 	final java.lang.String queryName, 
																					final java.util.List<T> bbvaAbstractValueObject )
	throws mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException;
	
	/**
	 * <b>queryForList</b>
	 * Metodo de consulta, actualizacion y eliminacion en base de datos.
	 *
	 * @param <T> - BbvaAbstractValueObject - Contenedor de especifico para cada tabla de base de datos.
	 * @param queryName - String nombre de la consulta.
	 * @param bbvaAbstractValueObject the bbva abstract value object
	 * @return java.util.List<mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject>
	 * @throws BbvaDataBaseException the bbva data base exception
	 */
	public < T extends BbvaAbstractValueObject > java.util.List<T> queryForList ( 	final java.lang.String queryName, 
																				  	final T bbvaAbstractValueObject )
	throws mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException;
	
	//  Comportamiento  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	
	/**
	 * <b>queryForObject</b>
	 * Metodo de consulta a base de datos.
	 *
	 * @param <T> - BbvaAbstractValueObject - Contenedor de especifico para cada tabla de base de datos.
	 * @param queryName - String nombre de la consulta.
	 * @return mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject
	 * @throws BbvaDataBaseException the bbva data base exception
	 */
	public < T extends BbvaAbstractValueObject > T queryForObject ( final java.lang.String queryName ) 
	throws mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException;
	
	/**
	 * <b>queryForObject</b>
	 * Metodo de creacion, actualizacion y eliminacion en base de datos.
	 *
	 * @param <T> - BbvaAbstractValueObject - Contenedor de especifico para cada tabla de base de datos.
	 * @param queryName - String nombre de la consulta.
	 * @param bbvaAbstractValueObject the bbva abstract value object
	 * @return mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject
	 * @throws BbvaDataBaseException the bbva data base exception
	 */
	public < T extends BbvaAbstractValueObject > T queryForObject ( final java.lang.String queryName, 
																	final T bbvaAbstractValueObject ) 
	throws mx.com.bbva.bancomer.commons.exception.BbvaDataBaseException;
	}