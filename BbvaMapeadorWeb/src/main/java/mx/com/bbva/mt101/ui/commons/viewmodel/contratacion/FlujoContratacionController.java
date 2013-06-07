package mx.com.bbva.mt101.ui.commons.viewmodel.contratacion;

import java.util.ArrayList;
import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.ContratacionMapVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ContratacionVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MapaGmmVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MensajeSalidaVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioNotificacionVO;
import mx.com.bbva.bancomer.contratacion.dto.ContratacionDTO;
import mx.com.bbva.bancomer.contratacionmap.dto.ContratacionMapDTO;
import mx.com.bbva.bancomer.mapper.business.ContratacionMapeadorBO;
import mx.com.bbva.bancomer.mapper.business.MapaGmmBO;
import mx.com.bbva.bancomer.mapper.business.MensajeSalidaBO;
import mx.com.bbva.bancomer.mapper.business.UsuarioNotificacionBO;
import mx.com.bbva.bancomer.mappers.mapagmm.dto.MapaGmmDTO;
import mx.com.bbva.bancomer.mensajesalida.dto.MensajeSalidaDTO;
import mx.com.bbva.bancomer.usuarionotificacion.dto.UsuarioNotificacionDTO;
import mx.com.bbva.mapeador.ui.commons.controller.IController;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.IdSpace;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class FlujoContratacionController extends Div  implements IController, IdSpace {

	private static final long serialVersionUID = -7046754339941749911L;

	@Wire
	private Combobox mapaGMM;
	@Wire
	private Combobox nombreMensajeSalida;
	@Wire
	private Radiogroup notificacion;
	@Wire
	private Radio radioS;
	@Wire
	private Radio radioN;
    @Wire
    private Textbox descripcionMapaGmm;
    @Wire
    private Textbox descripcionMensajeSalida;
    @Wire
    private Textbox idEtapa;
    @Wire
    private Textbox idContratacion;
    @Wire
    private Textbox idFlujo;
    @Wire
    private Listbox usuariosNotificacion;
    @Wire
    private Listbox usuariosNotificacionActivo;
    @Wire
	private Textbox idMapaGmm;
	@Wire
	private Textbox idMensajeSalida;
	@Wire
	private Textbox idTransaccion;
	@Wire
    Window contratacionTabWindows;
    
    private String idStrContratacion;
    private String titulo;
    private String idStrFlujo;
    private String idStrMapaGmm;
    private String idStrEtapa;
    private String idStrTransaccion;
    private String idStrMensajeSalida;
    private String descripcionIdUsuarios = "";
    private String strDescripcionMensajeSalida;
    private String strNombreMensajeSalida;
    
	private boolean botonEditar;
	private boolean flagDisabled;
	private boolean botonLimpiar;
	private boolean guardarBtn;
	private ContratacionDTO contratacionDTO;
	private ContratacionMapDTO contratacionMapDTO;
	private ContratacionMapVO contratacionMapVO;
	private ContratacionDTO contratacionUsuariosDTO;
	private List<ContratacionVO> contratacionVOs;
	private ContratacionVO contratacionVO;
	
	
	public FlujoContratacionController() {
		guardarBtn = false;
		this.read();
	}

	@Override
	public Object read() {
		contratacionDTO = new ContratacionDTO();		
	    MapaGmmBO mapaGmmBO = new MapaGmmBO();
	    MapaGmmDTO mapaGmmDTO = new MapaGmmDTO();
	    MapaGmmVO mapaGmmVO = new MapaGmmVO();
	    mapaGmmDTO.setMapaGmmVO(mapaGmmVO);
	    mapaGmmDTO = mapaGmmBO.readCommand();
	    
	    MensajeSalidaBO mensajeSalidaBO = new MensajeSalidaBO();
	    MensajeSalidaDTO mensajeSalidaDTO = new MensajeSalidaDTO();
	    MensajeSalidaVO mensajeSalidaVO = new MensajeSalidaVO();
	    
	    mensajeSalidaDTO.setMensajeSalidaVO(mensajeSalidaVO);
	    mensajeSalidaDTO = mensajeSalidaBO.readCommand();
	  
	    contratacionDTO.setMapaGmmVOs(mapaGmmDTO.getMapaGmmVOs());
	    contratacionDTO.setMensajeSalidaVOs(mensajeSalidaDTO.getMensajeSalidaVOs());
	    
	    //Sessions.getCurrent().getAttribute("contratacionMapVO");
		return contratacionDTO;
	}
	
	@Override
	@Command
	@NotifyChange({"guardarBtn"})
	public void save() {
		System.out.println("*****************GUARDADO 1************");
		boolean errorGuardar = false;
		if (mapaGMM.getSelectedItem() == null
				|| mapaGMM.getSelectedItem().getValue() == null
				|| mapaGMM.getSelectedItem().getValue().toString().isEmpty()) {
			mapaGMM.setErrorMessage("Favor de seleccionar el Mapa");
			errorGuardar = true;
		}
		if(notificacion.getSelectedItem().getId().equals("radioS")) {
			if (nombreMensajeSalida.getSelectedItem() == null
					|| nombreMensajeSalida.getSelectedItem().getValue() == null
					|| nombreMensajeSalida.getSelectedItem().getValue().toString().isEmpty()) {
				nombreMensajeSalida.setErrorMessage("Favor de seleccionar el mensaje");
				errorGuardar = true;
			}
			else {
				errorGuardar = false;
			}
			if(contratacionUsuariosDTO.getUsuarioNotificacionContrataMapVOs().isEmpty()){
				usuariosNotificacionActivo.setEmptyMessage("Favor de seleccionar al menos un Usuario");
				errorGuardar = true;
			} else {
				errorGuardar = false;
			}
			System.out.println("*****************GUARDADO 2************" + errorGuardar + " " +usuariosNotificacionActivo.getSelectedCount());
		}
		
		if(!errorGuardar) {
			System.out.println("*****************GUARDADO 3************");
			contratacionMapVO = new ContratacionMapVO();
			ContratacionMapeadorBO contratacionMapeadorBO = new ContratacionMapeadorBO();
			
			contratacionMapVO.setIdMapaGmm(Integer.parseInt(idMapaGmm.getValue()));
			contratacionMapVO.setIdFlujo(Integer.parseInt(idFlujo.getValue()));
			contratacionMapVO.setIdEtapa(Integer.parseInt(idEtapa.getValue()));
			contratacionMapVO.setIdContratacion(Integer.parseInt(idContratacion.getValue()));
			if(notificacion.getSelectedItem().getId().equals("radioS")) {
				contratacionMapVO.setEstatusNotificacion("T".charAt(0));
				contratacionMapVO.setIdMensajeSalida(Integer.parseInt(idMensajeSalida.getValue()));
				List<UsuarioNotificacionVO> listaUsuarios = contratacionUsuariosDTO.getUsuarioNotificacionContrataMapVOs();
				
				if(listaUsuarios!=null) {
					for(int i = 0;i<listaUsuarios.size();i++) {
						if (i>0) {
							descripcionIdUsuarios +="-";
						}
						descripcionIdUsuarios +=  listaUsuarios.get(i).getIdUsuarioNotificado();
					}
				}
				
				contratacionMapVO.setDescripcionIdUsuarios(descripcionIdUsuarios);
				descripcionIdUsuarios = "";
			} else {
				contratacionMapVO.setEstatusNotificacion("F".charAt(0));
				contratacionMapVO.setIdMensajeSalida(null);
				contratacionMapVO.setDescripcionIdUsuarios(null);
			}
			if(Sessions.getCurrent().getAttribute("idContratacionReg") != null || idTransaccion.getValue().equals("0")) {
				contratacionMapDTO.setContratacionMapVO(contratacionMapVO);
				contratacionMapeadorBO.createCommand(contratacionMapDTO);
				Messagebox.show("!La Contratación fue guardada exitosamente!",
						"Información", Messagebox.OK,
						Messagebox.INFORMATION);
				guardarBtn = true;
			} else {
				contratacionMapVO.setIdContratacion(Integer.parseInt(idContratacion.getValue()));
				contratacionMapDTO.setContratacionMapVO(contratacionMapVO);
				contratacionMapeadorBO.updateCommand(contratacionMapDTO);
				Messagebox.show("!La Actualización de la Contratación fue exitosa!",
						"Información", Messagebox.OK,
						Messagebox.INFORMATION);
			}
		}
	}

	@AfterCompose
	@NotifyChange({"nombreMensajeSalida", "descripcionMensajeSalida", "strDescripcionMensajeSalida", "strNombreMensajeSalida","botonLimpiar"})
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
		contratacionMapDTO = new ContratacionMapDTO();
        Selectors.wireComponents(view, this, false);
        contratacionUsuariosDTO = new ContratacionDTO();
        int[] idUsuarios = null;
        if(Sessions.getCurrent().getAttribute("idProducto") == null) {
        	botonLimpiar = true;
	        mapaGMM.setValue(Executions.getCurrent().getParameter("nombreMapaGmm"));
	        descripcionMapaGmm.setValue(Executions.getCurrent().getParameter("descripcionMapaGmm"));
	        strNombreMensajeSalida = Executions.getCurrent().getParameter("nombreMensajeSalida");
	        
	        if(Executions.getCurrent().getParameter("descripcionMensajeSalida")!=null)
	        strDescripcionMensajeSalida = Executions.getCurrent().getParameter("descripcionMensajeSalida").replace("|", "%");
	        
	        idStrFlujo = Executions.getCurrent().getParameter("idFlujo");
	        idStrMapaGmm = Executions.getCurrent().getParameter("idMapaGmm");
	        idStrEtapa = Executions.getCurrent().getParameter("idEtapa");
	        idStrContratacion = Executions.getCurrent().getParameter("idContratacion");
	        idStrMensajeSalida = Executions.getCurrent().getParameter("idMensajeSalida");
	        idStrTransaccion = Executions.getCurrent().getParameter("idTransaccion");
	        titulo = Executions.getCurrent().getParameter("titulo");        
	        
	        if(Executions.getCurrent().getParameter("estatusNotificacion").equals("F")) {
	        	notificacion.setSelectedItem(radioN);
	        	flagDisabled = true;
	        } else {
	        	notificacion.setSelectedItem(radioS);
	        	flagDisabled = false;
	        }
	
	        if(Executions.getCurrent().getParameter("descripcionIdUsuarios") != null) {
	        	idUsuarios = generarUsuarios(Executions.getCurrent().getParameter("descripcionIdUsuarios"));
	        }
	        
	        UsuarioNotificacionDTO usuarios = new UsuarioNotificacionDTO();
	        UsuarioNotificacionVO usuarioNotificacionVO = new UsuarioNotificacionVO();
	        usuarioNotificacionVO.setIdUsuarios(idUsuarios);
	        usuarioNotificacionVO.setTipoNotificacion("N");
	        usuarios.setUsuarioNotificacionVO(usuarioNotificacionVO);
	        UsuarioNotificacionBO usuarioNotificacionBO  = new UsuarioNotificacionBO();
	        if(idUsuarios != null) {
	        	contratacionUsuariosDTO.setUsuarioNotificacionContrataMapVOs(((ContratacionDTO) usuarioNotificacionBO.readCommand(idUsuarios)).getUsuarioNotificacionVOs());
	        } else {
	        	contratacionUsuariosDTO.setUsuarioNotificacionContrataMapVOs(new ArrayList<UsuarioNotificacionVO>());
	        }
		    contratacionDTO.setUsuarioNotificacionVOs(((UsuarioNotificacionDTO) usuarioNotificacionBO.readCommand(usuarios)).getUsuarioNotificacionVOs());
		} else {
			botonLimpiar = false;
			idStrEtapa = Executions.getCurrent().getParameter("idEtapa");
			idStrFlujo = Executions.getCurrent().getParameter("idFlujo");
			idStrContratacion = Executions.getCurrent().getParameter("idContratacion");
			idStrTransaccion = Executions.getCurrent().getParameter("idTransaccion");
			notificacion.setSelectedItem(radioS);
        	flagDisabled = false;
        	
			UsuarioNotificacionDTO usuarios = new UsuarioNotificacionDTO();
	        UsuarioNotificacionVO usuarioNotificacionVO = new UsuarioNotificacionVO();
	        usuarioNotificacionVO.setIdUsuarios(null);
	        usuarioNotificacionVO.setTipoNotificacion("N");
	        usuarios.setUsuarioNotificacionVO(usuarioNotificacionVO);
	        UsuarioNotificacionBO usuarioNotificacionBO  = new UsuarioNotificacionBO();
	        contratacionUsuariosDTO.setUsuarioNotificacionContrataMapVOs(new ArrayList<UsuarioNotificacionVO>());
		    contratacionDTO.setUsuarioNotificacionVOs(((UsuarioNotificacionDTO) usuarioNotificacionBO.readCommand(usuarios)).getUsuarioNotificacionVOs());
		}
        
    }
	
	private int[] generarUsuarios(String descripcionIdUsuarios) {
		String[] items = descripcionIdUsuarios.replaceAll("\\[", "").replaceAll("\\]", "").split("-");

		int[] results = new int[items.length];

		for (int i = 0; i < items.length; i++) {
		    try {
		        results[i] = Integer.parseInt(items[i]);
		    } catch (NumberFormatException nfe) {};
		}
		return results;
	}

	@Command
	public void crean() {
		idMapaGmm.setValue(null);
		mapaGMM.setValue(null);
		idMensajeSalida.setValue(null);
		descripcionMapaGmm.setValue(null);
		descripcionMensajeSalida.setValue(null);
		nombreMensajeSalida.setValue(null);
		removeAll();
	}
	
	@Command
	@NotifyChange({ "nombreMensajeSalida", "descripcionMensajeSalida", "flagDisabled",
		"usuariosNotificacion", "usuariosNotificacionActivo", "guardaBtn", "limpiarBtn"})
    public void disabledNotificacion() {
		flagDisabled = true;
	}
	
	@Command
	@NotifyChange({ "nombreMensajeSalida", "descripcionMensajeSalida", "flagDisabled",
		"usuariosNotificacion", "usuariosNotificacionActivo", "guardaBtn", "limpiarBtn"})
    public void enabledNotificacion() {
		flagDisabled = false;
	}
	
	@Command
	@NotifyChange({ "descripcionMapaGmm" })
    public void readMapaGmm() {
		MapaGmmVO mapaGmmVO = contratacionDTO.getMapaGmmVOs().get(mapaGMM.getSelectedIndex());
		descripcionMapaGmm.setValue(mapaGmmVO.getDescripcionMapaGmm());
    }
	
	@Command
	@NotifyChange({ "descripcionMensajeSalida" })
    public void readMensajeSalida() {
		if(contratacionDTO.getMensajeSalidaVOs().size()!=0 && nombreMensajeSalida != null ) {
			System.out.println("***************" + nombreMensajeSalida.getSelectedIndex());
			MensajeSalidaVO mensajeSalidaVO =  contratacionDTO.getMensajeSalidaVOs().get(nombreMensajeSalida.getSelectedIndex());
			descripcionMensajeSalida.setValue(mensajeSalidaVO.getDescripcionMensajeSalida());
		}
    }
	
	@Command
	@NotifyChange({"contratacionDTO", "contratacionUsuariosDTO"})
	public void chooseOne(){		
		if(!flagDisabled) {
			if(usuariosNotificacion.getSelectedItem()!=null){
				contratacionUsuariosDTO.getUsuarioNotificacionContrataMapVOs().add(contratacionDTO.getUsuarioNotificacionVOs().get(usuariosNotificacion.getSelectedIndex()));
				contratacionDTO.getUsuarioNotificacionVOs().remove(usuariosNotificacion.getSelectedIndex());
			}
		}
	}
	@Command
	@NotifyChange({"contratacionDTO", "contratacionUsuariosDTO"})
	public void chooseAll(){
		if(!flagDisabled) {
			List<UsuarioNotificacionVO> usuarioNotificacionVOs = contratacionDTO.getUsuarioNotificacionVOs();
			for (UsuarioNotificacionVO notificacionVO : usuarioNotificacionVOs) {
				contratacionUsuariosDTO.getUsuarioNotificacionContrataMapVOs().add(notificacionVO);
			}
			contratacionDTO.getUsuarioNotificacionVOs().clear();
		}
	}
	
	@Command
	@NotifyChange({"contratacionDTO", "contratacionUsuariosDTO"})
	public void removeOne(){
		if(!flagDisabled) {
			if(usuariosNotificacionActivo.getSelectedIndex() != -1){
				contratacionDTO.getUsuarioNotificacionVOs().add(contratacionUsuariosDTO.getUsuarioNotificacionContrataMapVOs().get(usuariosNotificacionActivo.getSelectedIndex()));
				contratacionUsuariosDTO.getUsuarioNotificacionContrataMapVOs().remove(usuariosNotificacionActivo.getSelectedIndex());
			}
		}
	}
	
	@Command
	@NotifyChange({"contratacionDTO", "contratacionUsuariosDTO"})
	public void removeAll(){
		if(!flagDisabled) {
			List<UsuarioNotificacionVO> notificacionVOs = contratacionUsuariosDTO.getUsuarioNotificacionContrataMapVOs();
			for (UsuarioNotificacionVO notificacionVO : notificacionVOs) {
				contratacionDTO.getUsuarioNotificacionVOs().add(notificacionVO);
			}
			contratacionUsuariosDTO.getUsuarioNotificacionContrataMapVOs().clear();
		}
	}

	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void clean() {
		descripcionMapaGmm.setValue(null);
		descripcionMensajeSalida.setValue(null);
	}
	
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the contratacionMapDTO
	 */
	public ContratacionMapDTO getContratacionMapDTO() {
		return contratacionMapDTO;
	}

	/**
	 * @param contratacionMapDTO the contratacionMapDTO to set
	 */
	public void setContratacionMapDTO(ContratacionMapDTO contratacionMapDTO) {
		this.contratacionMapDTO = contratacionMapDTO;
	}

	/**
	 * @return the contratacionMapVO
	 */
	public ContratacionMapVO getContratacionMapVO() {
		return contratacionMapVO;
	}

	/**
	 * @param contratacionMapVO the contratacionMapVO to set
	 */
	public void setContratacionMapVO(ContratacionMapVO contratacionMapVO) {
		this.contratacionMapVO = contratacionMapVO;
	}

	/**
	 * @return the idStrFlujo
	 */
	public String getIdStrFlujo() {
		return idStrFlujo;
	}

	/**
	 * @param idStrFlujo the idStrFlujo to set
	 */
	public void setIdStrFlujo(String idStrFlujo) {
		this.idStrFlujo = idStrFlujo;
	}

	/**
	 * @return the idStrMapaGmm
	 */
	public String getIdStrMapaGmm() {
		return idStrMapaGmm;
	}

	/**
	 * @param idStrMapaGmm the idStrMapaGmm to set
	 */
	public void setIdStrMapaGmm(String idStrMapaGmm) {
		this.idStrMapaGmm = idStrMapaGmm;
	}

	/**
	 * @return the idStrEtapa
	 */
	public String getIdStrEtapa() {
		return idStrEtapa;
	}

	/**
	 * @param idStrEtapa the idStrEtapa to set
	 */
	public void setIdStrEtapa(String idStrEtapa) {
		this.idStrEtapa = idStrEtapa;
	}

	/**
	 * @return the idStrMensajeSalida
	 */
	public String getIdStrMensajeSalida() {
		return idStrMensajeSalida;
	}

	/**
	 * @param idStrMensajeSalida the idStrMensajeSalida to set
	 */
	public void setIdStrMensajeSalida(String idStrMensajeSalida) {
		this.idStrMensajeSalida = idStrMensajeSalida;
	}
	
	/**
	 * @return the contratacionDTO
	 */
	public ContratacionDTO getContratacionDTO() {
		return contratacionDTO;
	}

	/**
	 * @param contratacionDTO the contratacionDTO to set
	 */
	public void setContratacionDTO(ContratacionDTO contratacionDTO) {
		this.contratacionDTO = contratacionDTO;
	}

	/**
	 * @return the contratacionVOs
	 */
	public List<ContratacionVO> getContratacionVOs() {
		return contratacionVOs;
	}

	/**
	 * @param contratacionVOs the contratacionVOs to set
	 */
	public void setContratacionVOs(List<ContratacionVO> contratacionVOs) {
		this.contratacionVOs = contratacionVOs;
	}
	
	/**
	 * @return the contratacionVO
	 */
	public ContratacionVO getContratacionVO() {
		return contratacionVO;
	}

	/**
	 * @param contratacionVO the contratacionVO to set
	 */
	public void setContratacionVO(ContratacionVO contratacionVO) {
		this.contratacionVO = contratacionVO;
	}
	
	/**
	 * @return the botonEditar
	 */
	public boolean isBotonEditar() {
		return botonEditar;
	}

	/**
	 * @param botonEditar the botonEditar to set
	 */
	public void setBotonEditar(boolean botonEditar) {
		this.botonEditar = botonEditar;
	}

	/**
	 * @return the idStrContratacion
	 */
	public String getIdStrContratacion() {
		return idStrContratacion;
	}

	/**
	 * @param idStrContratacion the idStrContratacion to set
	 */
	public void setIdStrContratacion(String idStrContratacion) {
		this.idStrContratacion = idStrContratacion;
	}

	/**
	 * @return the contratacionUsuariosDTO
	 */
	public ContratacionDTO getContratacionUsuariosDTO() {
		return contratacionUsuariosDTO;
	}

	/**
	 * @param contratacionUsuariosDTO the contratacionUsuariosDTO to set
	 */
	public void setContratacionUsuariosDTO(ContratacionDTO contratacionUsuariosDTO) {
		this.contratacionUsuariosDTO = contratacionUsuariosDTO;
	}

	/**
	 * @return the flagDisabled
	 */
	public boolean isFlagDisabled() {
		return flagDisabled;
	}

	/**
	 * @param flagDisabled the flagDisabled to set
	 */
	public void setFlagDisabled(boolean flagDisabled) {
		this.flagDisabled = flagDisabled;
	}

	/**
	 * @return the strDescripcionMensajeSalida
	 */
	public String getStrDescripcionMensajeSalida() {
		return strDescripcionMensajeSalida;
	}

	/**
	 * @param strDescripcionMensajeSalida the strDescripcionMensajeSalida to set
	 */
	public void setStrDescripcionMensajeSalida(String strDescripcionMensajeSalida) {
		this.strDescripcionMensajeSalida = strDescripcionMensajeSalida;
	}

	/**
	 * @return the strNombreMensajeSalida
	 */
	public String getStrNombreMensajeSalida() {
		return strNombreMensajeSalida;
	}

	/**
	 * @param strNombreMensajeSalida the strNombreMensajeSalida to set
	 */
	public void setStrNombreMensajeSalida(String strNombreMensajeSalida) {
		this.strNombreMensajeSalida = strNombreMensajeSalida;
	}
	
	/**
	 * @return the botonLimpiar
	 */
	public boolean isBotonLimpiar() {
		return botonLimpiar;
	}

	/**
	 * @param botonLimpiar the botonLimpiar to set
	 */
	public void setBotonLimpiar(boolean botonLimpiar) {
		this.botonLimpiar = botonLimpiar;
	}

	/**
	 * @return the idStrTransaccion
	 */
	public String getIdStrTransaccion() {
		return idStrTransaccion;
	}

	/**
	 * @param idStrTransaccion the idStrTransaccion to set
	 */
	public void setIdStrTransaccion(String idStrTransaccion) {
		this.idStrTransaccion = idStrTransaccion;
	}

	/**
	 * @return the guardarBtn
	 */
	public boolean isGuardarBtn() {
		return guardarBtn;
	}

	/**
	 * @param guardarBtn the guardarBtn to set
	 */
	public void setGuardarBtn(boolean guardarBtn) {
		this.guardarBtn = guardarBtn;
	}

	@Override
	public boolean applyPermision() {
		// TODO Auto-generated method stub
		return false;
	}
}

