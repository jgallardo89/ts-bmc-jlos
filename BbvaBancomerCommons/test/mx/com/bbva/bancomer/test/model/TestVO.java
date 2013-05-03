package mx.com.bbva.bancomer.test.model;

import java.util.Date;

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
public class TestVO extends BbvaAbstractValueObject 
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	private static final long serialVersionUID = 901127920990393269L;

	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados
	//	Primitivos
	private int		integerValue	= 1;
	private long	longValue		= 1;
	private double	doubleValue	 	= 1;
	private char	charValue		= 'a';
	private boolean	booleanValue	= false;
	//	Wrappers
	private java.lang.Integer 	integerWrapper 	 = new Integer 	( 1 );
	private java.lang.Long    	longWrapper 	 = new Long 	( 1 );
	private java.lang.Double  	doubleWrapper 	 = new Double 	( 1 );
	private java.lang.Character characterWrapper = new Character('a');
	private java.lang.Boolean   booleanWrapper   = Boolean.FALSE;
	//	Utilitarios
	private java.lang.String  	testText 	 	 = "Texto de Prueba -- VO";
	private java.util.Date		testDate		 = new Date();

	//	Propiedades
	public final int getIntegerValue() {
		return integerValue;
	}
	public final void setIntegerValue(int integerValue) {
		this.integerValue = integerValue;
	}
	public final long getLongValue() {
		return longValue;
	}
	public final void setLongValue(long longValue) {
		this.longValue = longValue;
	}
	public final double getDoubleValue() {
		return doubleValue;
	}
	public final void setDoubleValue(double doubleValue) {
		this.doubleValue = doubleValue;
	}
	public final char getCharValue() {
		return charValue;
	}
	public final void setCharValue(char charValue) {
		this.charValue = charValue;
	}
	public final boolean isBooleanValue() {
		return booleanValue;
	}
	public final void setBooleanValue(boolean booleanValue) {
		this.booleanValue = booleanValue;
	}
	public final java.lang.Integer getIntegerWrapper() {
		return integerWrapper;
	}
	public final void setIntegerWrapper(java.lang.Integer integerWrapper) {
		this.integerWrapper = integerWrapper;
	}
	public final java.lang.Long getLongWrapper() {
		return longWrapper;
	}
	public final void setLongWrapper(java.lang.Long longWrapper) {
		this.longWrapper = longWrapper;
	}
	public final java.lang.Double getDoubleWrapper() {
		return doubleWrapper;
	}
	public final void setDoubleWrapper(java.lang.Double doubleWrapper) {
		this.doubleWrapper = doubleWrapper;
	}
	public final java.lang.Character getCharacterWrapper() {
		return characterWrapper;
	}
	public final void setCharacterWrapper(java.lang.Character characterWrapper) {
		this.characterWrapper = characterWrapper;
	}
	public final java.lang.Boolean getBooleanWrapper() {
		return booleanWrapper;
	}
	public final void setBooleanWrapper(java.lang.Boolean booleanWrapper) {
		this.booleanWrapper = booleanWrapper;
	}
	public final java.lang.String getTestText() {
		return testText;
	}
	public final void setTestText(java.lang.String testText) {
		this.testText = testText;
	}
	public final java.util.Date getTestDate() {
		return testDate;
	}
	public final void setTestDate(java.util.Date testDate) {
		this.testDate = testDate;
	}
	}