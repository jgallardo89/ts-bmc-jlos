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
 * Nombre de proyecto: BbvaMapeadorBusinessModel
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
 * Nombre de clase: BitacoraDTO.java
 * Nombre de paquete: mx.com.bbva.bancomer.bitacora.dto
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.bitacora.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.BitacoraVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

// TODO: Auto-generated Javadoc
/**
 * The Class BitacoraDTO.
 *
 * @author Julio Morales
 */
public class BitacoraDTO extends BbvaAbstractDataTransferObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -9179692371793966962L;

	/** The bitacora vo. */
	private BitacoraVO bitacoraVO;
	
	/** The bitacora v os. */
	private List<BitacoraVO> bitacoraVOs;
	
	/** The campo. */
	private CampoDTO[] campo;
	
	/** The campo dto. */
	private CampoDTO campoDTO;
	
	/** The campo dt os. */
	private List<CampoDTO> campoDTOs;
	
	/** The xml. */
	private String xml;
	
	/**
	 * Gets the bitacora vo.
	 *
	 * @return the bitacoraVO
	 */
	public BitacoraVO getBitacoraVO() {
		return bitacoraVO;
	}
	
	/**
	 * Gets the bitacora v os.
	 *
	 * @return the bitacoraVOs
	 */
	public List<BitacoraVO> getBitacoraVOs() {
		return bitacoraVOs;
	}
	
	/**
	 * Gets the campo.
	 *
	 * @return the campo
	 */
	public CampoDTO[] getCampo() {
		return campo;
	}
	
	/**
	 * Gets the campo dto.
	 *
	 * @return the campoDTO
	 */
	public CampoDTO getCampoDTO() {
		return campoDTO;
	}
	
	/**
	 * Gets the campo dt os.
	 *
	 * @return the campoDTOs
	 */
	public List<CampoDTO> getCampoDTOs() {
		return campoDTOs;
	}
	
	/**
	 * Gets the xml.
	 *
	 * @return the xml
	 */
	public String getXml() {
		return xml;
	}
	
	/**
	 * Sets the bitacora vo.
	 *
	 * @param bitacoraVO the bitacoraVO to set
	 */
	public void setBitacoraVO(BitacoraVO bitacoraVO) {
		this.bitacoraVO = bitacoraVO;
	}
	
	/**
	 * Sets the bitacora v os.
	 *
	 * @param bitacoraVOs the bitacoraVOs to set
	 */
	public void setBitacoraVOs(List<BitacoraVO> bitacoraVOs) {
		this.bitacoraVOs = bitacoraVOs;
	}
	
	/**
	 * Sets the campo.
	 *
	 * @param campo the campo to set
	 */
	public void setCampo(CampoDTO[] campo) {
		this.campo = campo;
	}
	
	/**
	 * Sets the campo dto.
	 *
	 * @param campoDTO the campoDTO to set
	 */
	public void setCampoDTO(CampoDTO campoDTO) {
		this.campoDTO = campoDTO;
	}
	
	/**
	 * Sets the campo dt os.
	 *
	 * @param campoDTOs the campoDTOs to set
	 */
	public void setCampoDTOs(List<CampoDTO> campoDTOs) {
		this.campoDTOs = campoDTOs;
	}
	
	/**
	 * Sets the xml.
	 *
	 * @param xml the xml to set
	 */
	public void setXml(String xml) {
		this.xml = xml;
	}
	
}
