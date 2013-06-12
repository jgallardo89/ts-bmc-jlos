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
 * Nombre de clase: TestDTO.java
 * Nombre de paquete: mx.com.bbva.bancomer.test.model
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.test.model;

import java.util.ArrayList;

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
 * 02-MAY-2013  F. Emmanuel Chavarria Ortiz		Creacion        1.0.0
 *              femmanuel.chavarriao@gmail.com
 *              Consultoria
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
/**
 * The Class TestDTO.
 */
public class TestDTO extends BbvaAbstractDataTransferObject 
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1959257512349667794L;

	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados
	/** The test text. */
	private java.lang.String										testText	= "Texto de Prueba -- DTO";
	
	/** The test vo. */
	private mx.com.bbva.bancomer.test.model.TestVO					testVO		= new TestVO();
	
	/** The test vo list. */
	private java.util.List<mx.com.bbva.bancomer.test.model.TestVO> 	testVOList 	= new ArrayList<TestVO>();

	//  Constructores - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	
    /**
     * Default constructor. 
     */
	public TestDTO() 
		{
		super();
		testVOList.add( new TestVO() );
		testVOList.add( new TestVO() );
		}

	//	Propiedades
	/**
	 * Gets the test text.
	 *
	 * @return the test text
	 */
	public final java.lang.String getTestText() {
		return testText;
	}

	/**
	 * Gets the test vo.
	 *
	 * @return the test vo
	 */
	public final mx.com.bbva.bancomer.test.model.TestVO getTestVO() {
		return testVO;
	}

	/**
	 * Gets the test vo list.
	 *
	 * @return the test vo list
	 */
	public final java.util.List<mx.com.bbva.bancomer.test.model.TestVO> getTestVOList() {
		return testVOList;
	}

	/**
	 * Sets the test text.
	 *
	 * @param testText the new test text
	 */
	public final void setTestText(java.lang.String testText) {
		this.testText = testText;
	}

	/**
	 * Sets the test vo.
	 *
	 * @param testVO the new test vo
	 */
	public final void setTestVO(mx.com.bbva.bancomer.test.model.TestVO testVO) {
		this.testVO = testVO;
	}

	/**
	 * Sets the test vo list.
	 *
	 * @param testVOList the new test vo list
	 */
	public final void setTestVOList(
			java.util.List<mx.com.bbva.bancomer.test.model.TestVO> testVOList) {
		this.testVOList = testVOList;
	}
	}
