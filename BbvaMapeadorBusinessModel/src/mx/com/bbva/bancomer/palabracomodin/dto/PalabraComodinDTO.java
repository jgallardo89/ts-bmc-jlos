package mx.com.bbva.bancomer.palabracomodin.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.PalabraComodinVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

/**
 * @author Julio Morales
 *
 */
public class PalabraComodinDTO extends BbvaAbstractDataTransferObject {

	private static final long serialVersionUID = -6354964122078395339L;

	private List<PalabraComodinVO> palabraComodinVOs;
	private PalabraComodinVO palabraComodinVO;

	/**
	 * @return the palabraComodinVOs
	 */
	public List<PalabraComodinVO> getPalabraComodinVOs() {
		return palabraComodinVOs;
	}

	/**
	 * @param palabraComodinVOs the palabraComodinVOs to set
	 */
	public void setPalabraComodinVOs(List<PalabraComodinVO> palabraComodinVOs) {
		this.palabraComodinVOs = palabraComodinVOs;
	}

	/**
	 * @return the palabraComodinVO
	 */
	public PalabraComodinVO getPalabraComodinVO() {
		return palabraComodinVO;
	}

	/**
	 * @param palabraComodinVO the palabraComodinVO to set
	 */
	public void setPalabraComodinVO(PalabraComodinVO palabraComodinVO) {
		this.palabraComodinVO = palabraComodinVO;
	}

}
