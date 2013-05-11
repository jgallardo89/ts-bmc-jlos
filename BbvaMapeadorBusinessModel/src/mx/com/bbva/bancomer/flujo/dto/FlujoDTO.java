package mx.com.bbva.bancomer.flujo.dto;

import java.sql.Clob;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.FlujoVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

public class FlujoDTO extends BbvaAbstractDataTransferObject {

	private static final long serialVersionUID = 6382567537603629784L;
	private List<FlujoVO> flujoVOs;
	private Clob xml;
	private FlujoVO flujoVO;
	private List<EstatusObjetoVO> estatusObjetoVOs;
	/**
	 * @return the flujoVOs
	 */
	public List<FlujoVO> getFlujoVOs() {
		return flujoVOs;
	}
	/**
	 * @param flujoVOs the flujoVOs to set
	 */
	public void setFlujoVOs(List<FlujoVO> flujoVOs) {
		this.flujoVOs = flujoVOs;
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
	/**
	 * @return the flujoVO
	 */
	public FlujoVO getFlujoVO() {
		return flujoVO;
	}
	/**
	 * @param flujoVO the flujoVO to set
	 */
	public void setFlujoVO(FlujoVO flujoVO) {
		this.flujoVO = flujoVO;
	}
	/**
	 * @return the estatusObjetoVOs
	 */
	public List<EstatusObjetoVO> getEstatusObjetoVOs() {
		return estatusObjetoVOs;
	}
	/**
	 * @param estatusObjetoVOs the estatusObjetoVOs to set
	 */
	public void setEstatusObjetoVOs(List<EstatusObjetoVO> estatusObjetoVOs) {
		this.estatusObjetoVOs = estatusObjetoVOs;
	}
	
}
