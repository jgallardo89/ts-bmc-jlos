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
 * Nombre de clase: UsuarioDTO.java
 * Nombre de paquete: mx.com.bbva.bancomer.estatusobjeto.dto
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.estatusobjeto.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PerfilVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioDTO.
 *
 * @author Miguel
 */
public class UsuarioDTO extends BbvaAbstractDataTransferObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6194606592327867684L;
	
	/** The estatus objeto vo. */
	private EstatusObjetoVO estatusObjetoVO;
	
	/** The estatus objeto v os. */
	private List<EstatusObjetoVO> estatusObjetoVOs;
	
	/** The perfil vo. */
	private PerfilVO perfilVO;
	
	/** The perfil v os. */
	private List<PerfilVO> perfilVOs;
	
	/** The usuario vo. */
	private UsuarioVO usuarioVO; 
	
	/** The usuario v os. */
	private List<UsuarioVO> usuarioVOs;
	
	
	/**
	 * Instantiates a new usuario dto.
	 */
	public UsuarioDTO() {
		super();
	}
	
	/**
	 * Instantiates a new usuario dto.
	 *
	 * @param usuarioVO the usuario vo
	 * @param perfilVO the perfil vo
	 * @param estatusObjetoVO the estatus objeto vo
	 * @param usuarioVOs the usuario v os
	 * @param perfilVOs the perfil v os
	 * @param estatusObjetoVOs the estatus objeto v os
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
	 * Gets the estatus objeto vo.
	 *
	 * @return the estatusObjetoVO
	 */
	public EstatusObjetoVO getEstatusObjetoVO() {
		return estatusObjetoVO;
	}
	
	/**
	 * Gets the estatus objeto v os.
	 *
	 * @return the estatusObjetoVOs
	 */
	public List<EstatusObjetoVO> getEstatusObjetoVOs() {
		return estatusObjetoVOs;
	}
	
	/**
	 * Gets the perfil vo.
	 *
	 * @return the perfilVO
	 */
	public PerfilVO getPerfilVO() {
		return perfilVO;
	}
	
	/**
	 * Gets the perfil v os.
	 *
	 * @return the perfilVOs
	 */
	public List<PerfilVO> getPerfilVOs() {
		return perfilVOs;
	}
	
	/**
	 * Gets the usuario vo.
	 *
	 * @return the usuarioVO
	 */
	public UsuarioVO getUsuarioVO() {
		return usuarioVO;
	}
	
	/**
	 * Gets the usuario v os.
	 *
	 * @return the usuarioVOs
	 */
	public List<UsuarioVO> getUsuarioVOs() {
		return usuarioVOs;
	}
	
	/**
	 * Sets the estatus objeto vo.
	 *
	 * @param estatusObjetoVO the estatusObjetoVO to set
	 */
	public void setEstatusObjetoVO(EstatusObjetoVO estatusObjetoVO) {
		this.estatusObjetoVO = estatusObjetoVO;
	}
	
	/**
	 * Sets the estatus objeto v os.
	 *
	 * @param estatusObjetoVOs the estatusObjetoVOs to set
	 */
	public void setEstatusObjetoVOs(List<EstatusObjetoVO> estatusObjetoVOs) {
		this.estatusObjetoVOs = estatusObjetoVOs;
	}
	
	/**
	 * Sets the perfil vo.
	 *
	 * @param perfilVO the perfilVO to set
	 */
	public void setPerfilVO(PerfilVO perfilVO) {
		this.perfilVO = perfilVO;
	}
	
	/**
	 * Sets the perfil v os.
	 *
	 * @param perfilVOs the perfilVOs to set
	 */
	public void setPerfilVOs(List<PerfilVO> perfilVOs) {
		this.perfilVOs = perfilVOs;
	}
	
	/**
	 * Sets the usuario vo.
	 *
	 * @param usuarioVO the usuarioVO to set
	 */
	public void setUsuarioVO(UsuarioVO usuarioVO) {
		this.usuarioVO = usuarioVO;
	}
	
	/**
	 * Sets the usuario v os.
	 *
	 * @param usuarioVOs the usuarioVOs to set
	 */
	public void setUsuarioVOs(List<UsuarioVO> usuarioVOs) {
		this.usuarioVOs = usuarioVOs;
	}
	
	
	
}
