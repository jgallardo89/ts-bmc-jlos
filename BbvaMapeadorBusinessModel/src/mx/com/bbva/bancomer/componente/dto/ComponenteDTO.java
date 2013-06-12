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
 * Nombre de clase: ComponenteDTO.java
 * Nombre de paquete: mx.com.bbva.bancomer.componente.dto
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.componente.dto;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ComponenteVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.PantallaVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.TipoComponenteVO;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

// TODO: Auto-generated Javadoc
/**
 * The Class ComponenteDTO.
 */
public class ComponenteDTO extends BbvaAbstractDataTransferObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3144516741620752172L;
	
	/** The componente pantalla perfil all v os. */
	private List<ComponenteVO> componentePantallaPerfilAllVOs;  
	
	/** The Componente pantalla perfil v os. */
	private List<ComponenteVO> ComponentePantallaPerfilVOs;
	
	/** The componente pantalla v os. */
	private List<ComponenteVO> componentePantallaVOs;
	
	/** The Componente vo. */
	private ComponenteVO ComponenteVO;
	
	/** The Componente v os. */
	private List<ComponenteVO> ComponenteVOs;
	
	/** The estatus objeto v os. */
	private List<EstatusObjetoVO> estatusObjetoVOs;
	
	/** The pantalla v os. */
	private List<PantallaVO> pantallaVOs;
	
	/** The tipo componente v os. */
	private List<TipoComponenteVO> tipoComponenteVOs;
	
	/**
	 * Gets the componente pantalla perfil all v os.
	 *
	 * @return the componentePantallaPerfilAllVOs
	 */
	public final List<ComponenteVO> getComponentePantallaPerfilAllVOs() {
		return componentePantallaPerfilAllVOs;
	}
	
	/**
	 * Gets the componente pantalla perfil v os.
	 *
	 * @return the componentePantallaPerfilVOs
	 */
	public final List<ComponenteVO> getComponentePantallaPerfilVOs() {
		return ComponentePantallaPerfilVOs;
	}
	
	/**
	 * Gets the componente pantalla v os.
	 *
	 * @return the componentePantallaVOs
	 */
	public final List<ComponenteVO> getComponentePantallaVOs() {
		return componentePantallaVOs;
	}
	
	/**
	 * Gets the componente vo.
	 *
	 * @return the componenteVO
	 */
	public ComponenteVO getComponenteVO() {
		return ComponenteVO;
	}
	
	/**
	 * Gets the componente v os.
	 *
	 * @return the componenteVOs
	 */
	public List<ComponenteVO> getComponenteVOs() {
		return ComponenteVOs;
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
	 * Gets the pantalla v os.
	 *
	 * @return the pantallaVOs
	 */
	public List<PantallaVO> getPantallaVOs() {
		return pantallaVOs;
	}
	
	/**
	 * Gets the tipo componente v os.
	 *
	 * @return the tipoComponenteVOs
	 */
	public final List<TipoComponenteVO> getTipoComponenteVOs() {
		return tipoComponenteVOs;
	}
	
	/**
	 * Sets the componente pantalla perfil all v os.
	 *
	 * @param componentePantallaPerfilAllVOs the componentePantallaPerfilAllVOs to set
	 */
	public final void setComponentePantallaPerfilAllVOs(
			List<ComponenteVO> componentePantallaPerfilAllVOs) {
		this.componentePantallaPerfilAllVOs = componentePantallaPerfilAllVOs;
	}
	
	/**
	 * Sets the componente pantalla perfil v os.
	 *
	 * @param componentePantallaPerfilVOs the componentePantallaPerfilVOs to set
	 */
	public final void setComponentePantallaPerfilVOs(
			List<ComponenteVO> componentePantallaPerfilVOs) {
		ComponentePantallaPerfilVOs = componentePantallaPerfilVOs;
	}
	
	/**
	 * Sets the componente pantalla v os.
	 *
	 * @param componentePantallaVOs the componentePantallaVOs to set
	 */
	public final void setComponentePantallaVOs(
			List<ComponenteVO> componentePantallaVOs) {
		this.componentePantallaVOs = componentePantallaVOs;
	}
	
	/**
	 * Sets the componente vo.
	 *
	 * @param componenteVO the componenteVO to set
	 */
	public void setComponenteVO(ComponenteVO componenteVO) {
		ComponenteVO = componenteVO;
	}
	
	/**
	 * Sets the componente v os.
	 *
	 * @param componenteVOs the componenteVOs to set
	 */
	public void setComponenteVOs(List<ComponenteVO> componenteVOs) {
		ComponenteVOs = componenteVOs;
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
	 * Sets the pantalla v os.
	 *
	 * @param pantallaVOs the pantallaVOs to set
	 */
	public void setPantallaVOs(List<PantallaVO> pantallaVOs) {
		this.pantallaVOs = pantallaVOs;
	}
	
	/**
	 * Sets the tipo componente v os.
	 *
	 * @param tipoComponenteVOs the tipoComponenteVOs to set
	 */
	public final void setTipoComponenteVOs(List<TipoComponenteVO> tipoComponenteVOs) {
		this.tipoComponenteVOs = tipoComponenteVOs;
	}
	
}
