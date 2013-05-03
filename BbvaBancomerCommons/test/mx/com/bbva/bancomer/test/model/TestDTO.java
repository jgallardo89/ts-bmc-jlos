package mx.com.bbva.bancomer.test.model;

import java.util.ArrayList;

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
 * 02-MAY-2013  F. Emmanuel Chavarria Ortiz		Creacion        1.0.0
 *              femmanuel.chavarriao@gmail.com
 *              Consultoria
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
public class TestDTO extends BbvaAbstractDataTransferObject 
	{
	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados|estaticos
	private static final long serialVersionUID = 1959257512349667794L;

	//  Atributos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	Privados
	private java.lang.String										testText	= "Texto de Prueba -- DTO";
	private mx.com.bbva.bancomer.test.model.TestVO					testVO		= new TestVO();
	private java.util.List<mx.com.bbva.bancomer.test.model.TestVO> 	testVOList 	= new ArrayList<TestVO>();

	//	Propiedades
	public final java.lang.String getTestText() {
		return testText;
	}

	public final void setTestText(java.lang.String testText) {
		this.testText = testText;
	}

	public final mx.com.bbva.bancomer.test.model.TestVO getTestVO() {
		return testVO;
	}

	public final void setTestVO(mx.com.bbva.bancomer.test.model.TestVO testVO) {
		this.testVO = testVO;
	}

	public final java.util.List<mx.com.bbva.bancomer.test.model.TestVO> getTestVOList() {
		return testVOList;
	}

	public final void setTestVOList(
			java.util.List<mx.com.bbva.bancomer.test.model.TestVO> testVOList) {
		this.testVOList = testVOList;
	}

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
	}
