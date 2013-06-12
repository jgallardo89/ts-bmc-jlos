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
 * Nombre de clase: PerfilDTO.java
 * Nombre de paquete: mx.com.bbva.bancomer.perfil.dto
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.perfil.dto;

import java.util.HashMap;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ControlPermisoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusClaveVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PantallaVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PerfilVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

// TODO: Auto-generated Javadoc
/**
 * The Class PerfilDTO.
 */
public class PerfilDTO extends BbvaAbstractDataTransferObject {

	/** The control permiso vo. */
	private ControlPermisoVO controlPermisoVO;
	
	/** The control permiso v os. */
	private HashMap<String, Boolean> controlPermisoVOs;
	
	/** The control permiso vos. */
	private List<ControlPermisoVO> controlPermisoVOS;
	
	/** The estatus clave v os. */
	private List<EstatusClaveVO> estatusClaveVOs;
	
	/** The estatus objeto vo. */
	private EstatusObjetoVO estatusObjetoVO;
	
	/** The estatus objeto v os. */
	private List<EstatusObjetoVO> estatusObjetoVOs;
	
	/** The id estatus clave. */
	private String idEstatusClave;	
	
	/** The id pantalla. */
	private String idPantalla;
	
	/** The pantalla vo. */
	private PantallaVO pantallaVO;
	
	/** The pantalla v os. */
	private List<PantallaVO> pantallaVOs;
	
	/** The perfil vo. */
	private PerfilVO perfilVO;
	
	/** The perfil v os. */
	private List<PerfilVO> perfilVOs;
	
	/**
	 * Gets the control permiso vo.
	 *
	 * @return the controlPermisoVO
	 */
	public final ControlPermisoVO getControlPermisoVO() {
		return controlPermisoVO;
	}
	
	/**
	 * Gets the control permiso v os.
	 *
	 * @return the controlPermisoVOs
	 */
	public final HashMap<String, Boolean> getControlPermisoVOs() {
		return controlPermisoVOs;
	}
	
	/**
	 * Gets the control permiso vos.
	 *
	 * @return the controlPermisoVOS
	 */
	public final List<ControlPermisoVO> getControlPermisoVOS() {
		return controlPermisoVOS;
	}
	
	/**
	 * Gets the estatus clave v os.
	 *
	 * @return the estatusClaveVOs
	 */
	public List<EstatusClaveVO> getEstatusClaveVOs() {
		return estatusClaveVOs;
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
	 * Gets the id estatus clave.
	 *
	 * @return the idEstatusClave
	 */
	public String getIdEstatusClave() {
		return idEstatusClave;
	}
	
	/**
	 * Gets the id pantalla.
	 *
	 * @return the idPantalla
	 */
	public String getIdPantalla() {
		return idPantalla;
	}
	
	/**
	 * Gets the pantalla vo.
	 *
	 * @return the pantallaVO
	 */
	public PantallaVO getPantallaVO() {
		return pantallaVO;
	}
	
	/**
	 * Gets the pantalla v os.
	 *
	 * @return the pantallaVOs
	 */
	public List<PantallaVO> getPantallaVOs() {
		return pantallaVOs;
	}
	
	/**
	 * Gets the perfil vo.
	 *
	 * @return the perfilVO
	 */
	public final PerfilVO getPerfilVO() {
		return perfilVO;
	}
	
	/**
	 * Gets the perfil v os.
	 *
	 * @return the perfilVOs
	 */
	public final List<PerfilVO> getPerfilVOs() {
		return perfilVOs;
	}
	
	/**
	 * Sets the control permiso vo.
	 *
	 * @param controlPermisoVO the controlPermisoVO to set
	 */
	public final void setControlPermisoVO(ControlPermisoVO controlPermisoVO) {
		this.controlPermisoVO = controlPermisoVO;
	}
	
	/**
	 * Sets the control permiso v os.
	 *
	 * @param controlPermisoVOs the controlPermisoVOs to set
	 */
	public final void setControlPermisoVOs(
			HashMap<String, Boolean> controlPermisoVOs) {
		this.controlPermisoVOs = controlPermisoVOs;
	}
	
	/**
	 * Sets the control permiso vos.
	 *
	 * @param controlPermisoVOS the controlPermisoVOS to set
	 */
	public final void setControlPermisoVOS(List<ControlPermisoVO> controlPermisoVOS) {
		this.controlPermisoVOS = controlPermisoVOS;
	}
	
	/**
	 * Sets the estatus clave v os.
	 *
	 * @param estatusClaveVOs the estatusClaveVOs to set
	 */
	public void setEstatusClaveVOs(List<EstatusClaveVO> estatusClaveVOs) {
		this.estatusClaveVOs = estatusClaveVOs;
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
	 * Sets the id estatus clave.
	 *
	 * @param idEstatusClave the idEstatusClave to set
	 */
	public void setIdEstatusClave(String idEstatusClave) {
		this.idEstatusClave = idEstatusClave;
	}
	
	/**
	 * Sets the id pantalla.
	 *
	 * @param idPantalla the idPantalla to set
	 */
	public void setIdPantalla(String idPantalla) {
		this.idPantalla = idPantalla;
	}
	
	/**
	 * Sets the pantalla vo.
	 *
	 * @param pantallaVO the pantallaVO to set
	 */
	public void setPantallaVO(PantallaVO pantallaVO) {
		this.pantallaVO = pantallaVO;
	}
	
	/**
	 * Sets the pantalla v os.
	 *
	 * @param pantallaVOs the pantallaVOs to set
	 */
	public void setPantallaVOs(List<PantallaVO> pantallaVOs) {
		this.pantallaVOs = pantallaVOs;
	}
	
	/**
	 * Sets the perfil vo.
	 *
	 * @param perfilVO the perfilVO to set
	 */
	public final void setPerfilVO(PerfilVO perfilVO) {
		this.perfilVO = perfilVO;
	}
	
	/**
	 * Sets the perfil v os.
	 *
	 * @param perfilVOs the perfilVOs to set
	 */
	public final void setPerfilVOs(List<PerfilVO> perfilVOs) {
		this.perfilVOs = perfilVOs;
	}

	
}
