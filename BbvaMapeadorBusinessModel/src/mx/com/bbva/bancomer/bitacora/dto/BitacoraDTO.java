package mx.com.bbva.bancomer.bitacora.dto;

import java.sql.Clob;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.BitacoraVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

/**
 * @author Julio Morales
 *
 */
public class BitacoraDTO extends BbvaAbstractDataTransferObject   {

	private static final long serialVersionUID = -9179692371793966962L;

	private List<BitacoraVO> bitacoraVOs;
	private BitacoraVO bitacoraVO;
	private Clob xml;
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
	public Clob getXml() {
		return xml;
	}
	/**
	 * @param xml the xml to set
	 */
	public void setXml(Clob xml) {
		this.xml = xml;
	}
	
}
