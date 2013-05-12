package mx.com.bbva.bancomer.bitacora.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.BitacoraVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

/**
 * @author Julio Morales
 *
 */
public class BitacoraDTO extends BbvaAbstractDataTransferObject {

	private static final long serialVersionUID = -9179692371793966962L;

	private List<BitacoraVO> bitacoraVOs;
	private BitacoraVO bitacoraVO;
	private String xml;
	private CampoDTO[] campo;
	private CampoDTO campoDTO;
	private List<CampoDTO> campoDTOs;
	/**
	 * @return the bitacoraVOs
	 */
	public List<BitacoraVO> getBitacoraVOs() {
		return bitacoraVOs;
	}
	/**
	 * @param bitacoraVOs the bitacoraVOs to set
	 */
	public void setBitacoraVOs(List<BitacoraVO> bitacoraVOs) {
		this.bitacoraVOs = bitacoraVOs;
	}
	/**
	 * @return the bitacoraVO
	 */
	public BitacoraVO getBitacoraVO() {
		return bitacoraVO;
	}
	/**
	 * @param bitacoraVO the bitacoraVO to set
	 */
	public void setBitacoraVO(BitacoraVO bitacoraVO) {
		this.bitacoraVO = bitacoraVO;
	}
	/**
	 * @return the xml
	 */
	public String getXml() {
		return xml;
	}
	/**
	 * @param xml the xml to set
	 */
	public void setXml(String xml) {
		this.xml = xml;
	}
	/**
	 * @return the campo
	 */
	public CampoDTO[] getCampo() {
		return campo;
	}
	/**
	 * @param campo the campo to set
	 */
	public void setCampo(CampoDTO[] campo) {
		this.campo = campo;
	}
	/**
	 * @return the campoDTOs
	 */
	public List<CampoDTO> getCampoDTOs() {
		return campoDTOs;
	}
	/**
	 * @param campoDTOs the campoDTOs to set
	 */
	public void setCampoDTOs(List<CampoDTO> campoDTOs) {
		this.campoDTOs = campoDTOs;
	}
	/**
	 * @return the campoDTO
	 */
	public CampoDTO getCampoDTO() {
		return campoDTO;
	}
	/**
	 * @param campoDTO the campoDTO to set
	 */
	public void setCampoDTO(CampoDTO campoDTO) {
		this.campoDTO = campoDTO;
	}
	
}
