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
 * Nombre de clase: TestVO.java
 * Nombre de paquete: mx.com.bbva.bancomer.test.model
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.test.model;

import java.util.Date;

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
 * The Class TestVO.
 */
public class TestVO extends BbvaAbstractValueObject 
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 901127920990393269L;

	/** The boolean value. */
	private boolean	booleanValue	= false;
	
	/** The boolean wrapper. */
	private java.lang.Boolean   booleanWrapper   = Boolean.FALSE;
	
	/** The character wrapper. */
	private java.lang.Character characterWrapper = new Character('a');
	
	/** The char value. */
	private char	charValue		= 'a';
	
	/** The double value. */
	private double	doubleValue	 	= 1;
	/** The double wrapper. */
	private java.lang.Double  	doubleWrapper 	 = new Double 	( 1 );
	
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados
	//	Primitivos
	/** The integer value. */
	private int		integerValue	= 1;
	
	//	Wrappers
	/** The integer wrapper. */
	private java.lang.Integer 	integerWrapper 	 = new Integer 	( 1 );
	
	/** The long value. */
	private long	longValue		= 1;
	
	/** The long wrapper. */
	private java.lang.Long    	longWrapper 	 = new Long 	( 1 );
	/** The test date. */
	private java.util.Date		testDate		 = new Date();
	
	//	Utilitarios
	/** The test text. */
	private java.lang.String  	testText 	 	 = "Texto de Prueba -- VO";

	/**
	 * Gets the boolean wrapper.
	 *
	 * @return the boolean wrapper
	 */
	public final java.lang.Boolean getBooleanWrapper() {
		return booleanWrapper;
	}
	
	/**
	 * Gets the character wrapper.
	 *
	 * @return the character wrapper
	 */
	public final java.lang.Character getCharacterWrapper() {
		return characterWrapper;
	}
	
	/**
	 * Gets the char value.
	 *
	 * @return the char value
	 */
	public final char getCharValue() {
		return charValue;
	}
	
	/**
	 * Gets the double value.
	 *
	 * @return the double value
	 */
	public final double getDoubleValue() {
		return doubleValue;
	}
	
	/**
	 * Gets the double wrapper.
	 *
	 * @return the double wrapper
	 */
	public final java.lang.Double getDoubleWrapper() {
		return doubleWrapper;
	}
	
	//	Propiedades
	/**
	 * Gets the integer value.
	 *
	 * @return the integer value
	 */
	public final int getIntegerValue() {
		return integerValue;
	}
	
	/**
	 * Gets the integer wrapper.
	 *
	 * @return the integer wrapper
	 */
	public final java.lang.Integer getIntegerWrapper() {
		return integerWrapper;
	}
	
	/**
	 * Gets the long value.
	 *
	 * @return the long value
	 */
	public final long getLongValue() {
		return longValue;
	}
	
	/**
	 * Gets the long wrapper.
	 *
	 * @return the long wrapper
	 */
	public final java.lang.Long getLongWrapper() {
		return longWrapper;
	}
	
	/**
	 * Gets the test date.
	 *
	 * @return the test date
	 */
	public final java.util.Date getTestDate() {
		return testDate;
	}
	
	/**
	 * Gets the test text.
	 *
	 * @return the test text
	 */
	public final java.lang.String getTestText() {
		return testText;
	}
	
	/**
	 * Checks if is boolean value.
	 *
	 * @return true, if is boolean value
	 */
	public final boolean isBooleanValue() {
		return booleanValue;
	}
	
	/**
	 * Sets the boolean value.
	 *
	 * @param booleanValue the new boolean value
	 */
	public final void setBooleanValue(boolean booleanValue) {
		this.booleanValue = booleanValue;
	}
	
	/**
	 * Sets the boolean wrapper.
	 *
	 * @param booleanWrapper the new boolean wrapper
	 */
	public final void setBooleanWrapper(java.lang.Boolean booleanWrapper) {
		this.booleanWrapper = booleanWrapper;
	}
	
	/**
	 * Sets the character wrapper.
	 *
	 * @param characterWrapper the new character wrapper
	 */
	public final void setCharacterWrapper(java.lang.Character characterWrapper) {
		this.characterWrapper = characterWrapper;
	}
	
	/**
	 * Sets the char value.
	 *
	 * @param charValue the new char value
	 */
	public final void setCharValue(char charValue) {
		this.charValue = charValue;
	}
	
	/**
	 * Sets the double value.
	 *
	 * @param doubleValue the new double value
	 */
	public final void setDoubleValue(double doubleValue) {
		this.doubleValue = doubleValue;
	}
	
	/**
	 * Sets the double wrapper.
	 *
	 * @param doubleWrapper the new double wrapper
	 */
	public final void setDoubleWrapper(java.lang.Double doubleWrapper) {
		this.doubleWrapper = doubleWrapper;
	}
	
	/**
	 * Sets the integer value.
	 *
	 * @param integerValue the new integer value
	 */
	public final void setIntegerValue(int integerValue) {
		this.integerValue = integerValue;
	}
	
	/**
	 * Sets the integer wrapper.
	 *
	 * @param integerWrapper the new integer wrapper
	 */
	public final void setIntegerWrapper(java.lang.Integer integerWrapper) {
		this.integerWrapper = integerWrapper;
	}
	
	/**
	 * Sets the long value.
	 *
	 * @param longValue the new long value
	 */
	public final void setLongValue(long longValue) {
		this.longValue = longValue;
	}
	
	/**
	 * Sets the long wrapper.
	 *
	 * @param longWrapper the new long wrapper
	 */
	public final void setLongWrapper(java.lang.Long longWrapper) {
		this.longWrapper = longWrapper;
	}
	
	/**
	 * Sets the test date.
	 *
	 * @param testDate the new test date
	 */
	public final void setTestDate(java.util.Date testDate) {
		this.testDate = testDate;
	}
	
	/**
	 * Sets the test text.
	 *
	 * @param testText the new test text
	 */
	public final void setTestText(java.lang.String testText) {
		this.testText = testText;
	}
	}