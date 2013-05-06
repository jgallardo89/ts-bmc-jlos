/**
 * 
 */
package mx.com.bbva.bancomer.estatusobjeto.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PerfilVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

/**
 * @author Miguel
 *
 */
public class UsuarioDTO extends BbvaAbstractDataTransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6194606592327867684L;
	
	private UsuarioVO usuarioVO;
	private PerfilVO perfilVO;
	private EstatusObjetoVO estatusObjetoVO;
	private List<UsuarioVO> usuarioVOs;
	private List<PerfilVO> perfilVOs; 
	private List<EstatusObjetoVO> estatusObjetoVOs;
	
	
	/**
	 * 
	 */
	public UsuarioDTO() {
		super();
	}
	/**
	 * @param usuarioVO
	 * @param perfilVO
	 * @param estatusObjetoVO
	 * @param usuarioVOs
	 * @param perfilVOs
	 * @param estatusObjetoVOs
	 */
	public UsuarioDTO(UsuarioVO usuarioVO, PerfilVO perfilVO,
			EstatusObjetoVO estatusObjetoVO, List<UsuarioVO> usuarioVOs,
			List<PerfilVO> perfilVOs, List<EstatusObjetoVO> estatusObjetoVOs) {
		super();
		this.usuarioVO = usuarioVO;
		this.perfilVO = perfilVO;
		this.estatusObjetoVO = estatusObjetoVO;
		this.usuarioVOs = usuarioVOs;
		this.perfilVOs = perfilVOs;
		this.estatusObjetoVOs = estatusObjetoVOs;
	}
	/**
	 * @return the usuarioVO
	 */
	public UsuarioVO getUsuarioVO() {
		return usuarioVO;
	}
	/**
	 * @param usuarioVO the usuarioVO to set
	 */
	public void setUsuarioVO(UsuarioVO usuarioVO) {
		this.usuarioVO = usuarioVO;
	}
	/**
	 * @return the perfilVO
	 */
	public PerfilVO getPerfilVO() {
		return perfilVO;
	}
	/**
	 * @param perfilVO the perfilVO to set
	 */
	public void setPerfilVO(PerfilVO perfilVO) {
		this.perfilVO = perfilVO;
	}
	/**
	 * @return the estatusObjetoVO
	 */
	public EstatusObjetoVO getEstatusObjetoVO() {
		return estatusObjetoVO;
	}
	/**
	 * @param estatusObjetoVO the estatusObjetoVO to set
	 */
	public void setEstatusObjetoVO(EstatusObjetoVO estatusObjetoVO) {
		this.estatusObjetoVO = estatusObjetoVO;
	}
	/**
	 * @return the usuarioVOs
	 */
	public List<UsuarioVO> getUsuarioVOs() {
		return usuarioVOs;
	}
	/**
	 * @param usuarioVOs the usuarioVOs to set
	 */
	public void setUsuarioVOs(List<UsuarioVO> usuarioVOs) {
		this.usuarioVOs = usuarioVOs;
	}
	/**
	 * @return the perfilVOs
	 */
	public List<PerfilVO> getPerfilVOs() {
		return perfilVOs;
	}
	/**
	 * @param perfilVOs the perfilVOs to set
	 */
	public void setPerfilVOs(List<PerfilVO> perfilVOs) {
		this.perfilVOs = perfilVOs;
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
