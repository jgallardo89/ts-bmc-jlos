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
 * Nombre de proyecto: BbvaMapeadorWeb
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
 * Nombre de clase: FlujoContratacionController.java
 * Nombre de paquete: mx.com.bbva.mapeador.ui.commons.viewmodel.contratacion
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.mapeador.ui.commons.viewmodel.contratacion;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import mx.com.bbva.bancomer.bitacora.dto.BitacoraDTO;
import mx.com.bbva.bancomer.bitacora.dto.CampoDTO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ContratacionMapVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ContratacionVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MapaGmmVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.MensajeSalidaVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.UsuarioNotificacionVO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
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
import mx.com.bbva.mapeador.ui.commons.viewmodel.reportes.ReportesController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.IdSpace;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.ibm.disthub2.impl.client.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class FlujoContratacionController.
 */
public class FlujoContratacionController extends Div implements IController, IdSpace {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7046754339941749911L;
	
	private boolean remove = false;
	
	/** The boton editar. */
	private boolean botonEditar;
	
	/** The boton limpiar. */
	private boolean botonLimpiar;
	
	/** The contratacion dto. */
	private ContratacionDTO contratacionDTO;
	
	/** The contratacion map dto. */
	private ContratacionMapDTO contratacionMapDTO;
	
	/** The contratacion map vo. */
	private ContratacionMapVO contratacionMapVO;
    
    /** The contratacion tab windows. */
	@Wire
    Window contratacionTabWindows;
    
    /** The contratacion usuarios dto. */
	private ContratacionDTO contratacionUsuariosDTO;
    
    /** The contratacion vo. */
	private ContratacionVO contratacionVO;
    
    /** The contratacion v os. */
	private List<ContratacionVO> contratacionVOs;
    
    /** The descripcion id usuarios. */
    private String descripcionIdUsuarios = "";
    
    /** The descripcion mapa gmm. */
    @Wire
    private Textbox descripcionMapaGmm;
    
    /** The descripcion mensaje salida. */
    @Wire
    private Textbox descripcionMensajeSalida;
    
    /** The flag disabled. */
	private boolean flagDisabled;
	
	/** The guardar btn. */
	private boolean guardarBtn;
	
	/** The id contratacion. */
    @Wire
    private Textbox idContratacion;
	
	/** The id etapa. */
    @Wire
    private Textbox idEtapa;
    
    /** The id flujo. */
    @Wire
    private Textbox idFlujo;
    
    /** The id mapa gmm. */
    @Wire
	private Textbox idMapaGmm;
    
    /** The id mensaje salida. */
	@Wire
	private Textbox idMensajeSalida;
    
    /** The id str contratacion. */
    private String idStrContratacion;
    
    /** The id str etapa. */
    private String idStrEtapa;
    
    /** The id str flujo. */
    private String idStrFlujo;
    
    /** The id str mapa gmm. */
    private String idStrMapaGmm;
    
    /** The id str mensaje salida. */
    private String idStrMensajeSalida;
    
    /** The id str transaccion. */
    private String idStrTransaccion;
    
    /** The id str transaccion. */
    private String idStrTab;
    
    /** The id transaccion. */
	@Wire
	private Textbox idTransaccion;
    
	/** The mapa gmm. */
	@Wire
	private Combobox mapaGMM;
	
	/** The nombre mensaje salida. */
	@Wire
	private Combobox nombreMensajeSalida;
	
	/** The notificacion. */
	@Wire
	private Radiogroup notificacion;
	
	/** The radio n. */
	@Wire
	private Radio radioN;
	
	/** The radio s. */
	@Wire
	private Radio radioS;
	
	/** The str descripcion mensaje salida. */
    private String strDescripcionMensajeSalida;
	
	/** The str nombre mensaje salida. */
    private String strNombreMensajeSalida;
	
	/** The titulo. */
    private String titulo;
	
	/** The usuarios notificacion. */
    @Wire
    private Listbox usuariosNotificacion;
	
	/** The usuarios notificacion activo. */
    @Wire
    private Listbox usuariosNotificacionActivo;
	
    private int initSize;
    
    private int size;
    
    private int contador;
    
    private Textbox idTab;
    
	/**
	 * Instantiates a new flujo contratacion controller.
	 */
	public FlujoContratacionController() {
		guardarBtn = false;
		this.read();
	}

	/**
	 * After compose.
	 *
	 * @param view the view
	 */
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
	        idStrTab = Executions.getCurrent().getParameter("idTab");
	        titulo = Executions.getCurrent().getParameter("titulo");
	        
	        ArrayList<ContratacionMapVO> contratacionMapVOs = (ArrayList<ContratacionMapVO>) Sessions.getCurrent().getAttribute("contratacionMapVOs");
     		ContratacionMapVO contratacionMapVO = (ContratacionMapVO) contratacionMapVOs.get(Integer.parseInt(idStrTab)-1);
     		contratacionMapVO.setEstatusNotificacion(Executions.getCurrent().getParameter("estatusNotificacion").charAt(0));
	        if(Executions.getCurrent().getParameter("estatusNotificacion").equals("F")) {
	        	notificacion.setSelectedItem(radioN);
	        	flagDisabled = true;
	     		contratacionMapVO.setValNotificacion(true);
	        } else {
	        	notificacion.setSelectedItem(radioS);
	        	flagDisabled = false;
	     		contratacionMapVO.setValNotificacion(false);
	        }
	        contratacionMapVOs.set(Integer.parseInt(idStrTab)-1, contratacionMapVO);
     		Sessions.getCurrent().setAttribute("contratacionMapVOs", contratacionMapVOs);
	
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
	        	initSize = ((ContratacionDTO)usuarioNotificacionBO.readCommand(idUsuarios)).getUsuarioNotificacionVOs().size();
	        } else {
	        	contratacionUsuariosDTO.setUsuarioNotificacionContrataMapVOs(new ArrayList<UsuarioNotificacionVO>());
	        	initSize = 0;
	        }
	        
	        Sessions.getCurrent().setAttribute("idDescripcionIdUsuarios"+idStrEtapa, Executions.getCurrent().getParameter("descripcionIdUsuarios"));
	        
		    contratacionDTO.setUsuarioNotificacionVOs(usuarioNotificacionBO.readCommand(usuarios).getUsuarioNotificacionVOs());
		} else {
			botonLimpiar = false;
			idStrFlujo = Executions.getCurrent().getParameter("idFlujo");
			idStrContratacion = Executions.getCurrent().getParameter("idContratacion");
			idStrTransaccion = Executions.getCurrent().getParameter("idTransaccion");
			idStrTab = Executions.getCurrent().getParameter("idTab");
			notificacion.setSelectedItem(radioS);
        	flagDisabled = false;
        	ArrayList<ContratacionMapVO> contratacionMapVOs = (ArrayList<ContratacionMapVO>) Sessions.getCurrent().getAttribute("contratacionMapVOs");
     		ContratacionMapVO contratacionMapVO = (ContratacionMapVO) contratacionMapVOs.get(Integer.parseInt(idStrTab)-1);
     		//System.out.println("******************** +++++ " + contratacionMapVO.getEstatusNotificacion());
     		contratacionMapVO.setEstatusNotificacion(contratacionMapVO.getEstatusNotificacion());
     		contratacionMapVO.setValNotificacion(false);
     		contratacionMapVOs.set(Integer.parseInt(idStrTab)-1, contratacionMapVO);
     		Sessions.getCurrent().setAttribute("contratacionMapVOs", contratacionMapVOs);
        	
			UsuarioNotificacionDTO usuarios = new UsuarioNotificacionDTO();
	        UsuarioNotificacionVO usuarioNotificacionVO = new UsuarioNotificacionVO();
	        usuarioNotificacionVO.setIdUsuarios(null);
	        usuarioNotificacionVO.setTipoNotificacion("N");
	        usuarios.setUsuarioNotificacionVO(usuarioNotificacionVO);
	        UsuarioNotificacionBO usuarioNotificacionBO  = new UsuarioNotificacionBO();
	        contratacionUsuariosDTO.setUsuarioNotificacionContrataMapVOs(new ArrayList<UsuarioNotificacionVO>());
	        initSize = 0;
		    contratacionDTO.setUsuarioNotificacionVOs(usuarioNotificacionBO.readCommand(usuarios).getUsuarioNotificacionVOs());
		}
        
    }
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#applyPermision()
	 */
	@Override
	public boolean applyPermision() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#clean()
	 */
	@Override
	public void clean() {
		descripcionMapaGmm.setValue(null);
		descripcionMensajeSalida.setValue(null);
	}
	
	/**
	 * Crean.
	 */
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
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#delete()
	 */
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Disabled notificacion.
	 */
	@Command
	@NotifyChange({ "nombreMensajeSalida", "descripcionMensajeSalida", "flagDisabled",
		"usuariosNotificacion", "usuariosNotificacionActivo", "guardaBtn", "limpiarBtn"})
    public void disabledNotificacion() {
		ArrayList<ContratacionMapVO> contratacionMapVOs = (ArrayList<ContratacionMapVO>) Sessions.getCurrent().getAttribute("contratacionMapVOs");
		ContratacionMapVO contratacionMapVO = (ContratacionMapVO) contratacionMapVOs.get(Integer.parseInt(idStrTab)-1);
		contratacionMapVO.setEstatusNotificacion('F');
		contratacionMapVO.setValNotificacion(true);
		contratacionMapVOs.set(Integer.parseInt(idStrTab)-1, contratacionMapVO);
		Sessions.getCurrent().setAttribute("contratacionMapVOs", contratacionMapVOs);
		Sessions.getCurrent().setAttribute("flgCambio",true);
		flagDisabled = true;
	}
	
	/**
	 * Enabled notificacion.
	 */
	@Command
	@NotifyChange({ "nombreMensajeSalida", "descripcionMensajeSalida", "flagDisabled",
		"usuariosNotificacion", "usuariosNotificacionActivo", "guardaBtn", "limpiarBtn"})
    public void enabledNotificacion() {
		ArrayList<ContratacionMapVO> contratacionMapVOs = (ArrayList<ContratacionMapVO>) Sessions.getCurrent().getAttribute("contratacionMapVOs");
		ContratacionMapVO contratacionMapVO = (ContratacionMapVO) contratacionMapVOs.get(Integer.parseInt(idStrTab)-1);
		contratacionMapVO.setEstatusNotificacion('T');
		contratacionMapVO.setValNotificacion(false);
		contratacionMapVOs.set(Integer.parseInt(idStrTab)-1, contratacionMapVO);
		Sessions.getCurrent().setAttribute("contratacionMapVOs", contratacionMapVOs);
		Sessions.getCurrent().setAttribute("flgCambio",true);
		flagDisabled = false;
	}
	
	/**
	 * Generar usuarios.
	 *
	 * @param descripcionIdUsuarios the descripcion id usuarios
	 * @return the int[]
	 */
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
	
	/**
	 * Gets the contratacion dto.
	 *
	 * @return the contratacionDTO
	 */
	public ContratacionDTO getContratacionDTO() {
		return contratacionDTO;
	}
	
	/**
	 * Gets the contratacion map dto.
	 *
	 * @return the contratacionMapDTO
	 */
	public ContratacionMapDTO getContratacionMapDTO() {
		return contratacionMapDTO;
	}
	
	/**
	 * Gets the contratacion map vo.
	 *
	 * @return the contratacionMapVO
	 */
	public ContratacionMapVO getContratacionMapVO() {
		return contratacionMapVO;
	}

	/**
	 * Gets the contratacion usuarios dto.
	 *
	 * @return the contratacionUsuariosDTO
	 */
	public ContratacionDTO getContratacionUsuariosDTO() {
		return contratacionUsuariosDTO;
	}
	
	/**
	 * Gets the contratacion vo.
	 *
	 * @return the contratacionVO
	 */
	public ContratacionVO getContratacionVO() {
		return contratacionVO;
	}
	
	/**
	 * Gets the contratacion v os.
	 *
	 * @return the contratacionVOs
	 */
	public List<ContratacionVO> getContratacionVOs() {
		return contratacionVOs;
	}
	
	/**
	 * Gets the id str contratacion.
	 *
	 * @return the idStrContratacion
	 */
	public String getIdStrContratacion() {
		return idStrContratacion;
	}

	/**
	 * Gets the id str etapa.
	 *
	 * @return the idStrEtapa
	 */
	public String getIdStrEtapa() {
		return idStrEtapa;
	}

	/**
	 * Gets the id str flujo.
	 *
	 * @return the idStrFlujo
	 */
	public String getIdStrFlujo() {
		return idStrFlujo;
	}

	/**
	 * Gets the id str mapa gmm.
	 *
	 * @return the idStrMapaGmm
	 */
	public String getIdStrMapaGmm() {
		return idStrMapaGmm;
	}

	/**
	 * Gets the id str mensaje salida.
	 *
	 * @return the idStrMensajeSalida
	 */
	public String getIdStrMensajeSalida() {
		return idStrMensajeSalida;
	}

	/**
	 * Gets the id str transaccion.
	 *
	 * @return the idStrTransaccion
	 */
	public String getIdStrTransaccion() {
		return idStrTransaccion;
	}

	/**
	 * Gets the str descripcion mensaje salida.
	 *
	 * @return the strDescripcionMensajeSalida
	 */
	public String getStrDescripcionMensajeSalida() {
		return strDescripcionMensajeSalida;
	}

	/**
	 * Gets the str nombre mensaje salida.
	 *
	 * @return the strNombreMensajeSalida
	 */
	public String getStrNombreMensajeSalida() {
		return strNombreMensajeSalida;
	}

	/**
	 * Gets the titulo.
	 *
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Checks if is boton editar.
	 *
	 * @return the botonEditar
	 */
	public boolean isBotonEditar() {
		return botonEditar;
	}

	/**
	 * Checks if is boton limpiar.
	 *
	 * @return the botonLimpiar
	 */
	public boolean isBotonLimpiar() {
		return botonLimpiar;
	}

	/**
	 * Checks if is flag disabled.
	 *
	 * @return the flagDisabled
	 */
	public boolean isFlagDisabled() {
		return flagDisabled;
	}

	/**
	 * Checks if is guardar btn.
	 *
	 * @return the guardarBtn
	 */
	public boolean isGuardarBtn() {
		return guardarBtn;
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read()
	 */
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
	
	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#read(java.lang.Object)
	 */
	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Read mapa gmm.
	 */
	@Command
	@NotifyChange({ "descripcionMapaGmm" })
    public void readMapaGmm() {
		MapaGmmVO mapaGmmVO = contratacionDTO.getMapaGmmVOs().get(mapaGMM.getSelectedIndex());
		descripcionMapaGmm.setValue(mapaGmmVO.getDescripcionMapaGmm());
    }

	/**
	 * Read mensaje salida.
	 */
	@Command
	@NotifyChange({ "descripcionMensajeSalida" })
    public void readMensajeSalida() {
		if(contratacionDTO.getMensajeSalidaVOs().size()!=0 && nombreMensajeSalida != null ) {
			MensajeSalidaVO mensajeSalidaVO =  contratacionDTO.getMensajeSalidaVOs().get(nombreMensajeSalida.getSelectedIndex());
			descripcionMensajeSalida.setValue(mensajeSalidaVO.getDescripcionMensajeSalida());
		}
    }
	
	private void agregarUsuarios() {
		ArrayList<ContratacionMapVO> contratacionMapVOs = (ArrayList<ContratacionMapVO>) Sessions.getCurrent().getAttribute("contratacionMapVOs");
		ContratacionMapVO contratacionMapVO = (ContratacionMapVO) contratacionMapVOs.get(Integer.parseInt(idStrTab)-1);
		contratacionMapVO.setDescripcionIdUsuarios(generaIdsUsuarios());
		contratacionMapVOs.set(Integer.parseInt(idStrTab)-1, contratacionMapVO);
		Sessions.getCurrent().setAttribute("contratacionMapVOs", contratacionMapVOs);
	}
	
	public String generaIdsUsuarios() {
		List<UsuarioNotificacionVO> listaUsuarios = contratacionUsuariosDTO.getUsuarioNotificacionContrataMapVOs();
		//System.out.println("Cantidad de usuarios:"+contratacionUsuariosDTO.getUsuarioNotificacionContrataMapVOs());
		
		if(!listaUsuarios.isEmpty()) {
			if(listaUsuarios!=null) {
				for(int i = 0;i<listaUsuarios.size();i++) {
					descripcionIdUsuarios = descripcionIdUsuarios==null?"":descripcionIdUsuarios;
					if(descripcionIdUsuarios.contains("-"+listaUsuarios.get(i).getIdUsuarioNotificado()+"-")||
							descripcionIdUsuarios.startsWith(listaUsuarios.get(i).getIdUsuarioNotificado()+"-")
							){
						//do nothing
					}else{
						//System.out.println("descripcionIdUsuarios::::"+descripcionIdUsuarios);						
						descripcionIdUsuarios +=  listaUsuarios.get(i).getIdUsuarioNotificado();
						descripcionIdUsuarios +="-";
					}
				}
			}
		} else {
			descripcionIdUsuarios = null;
		}
		return descripcionIdUsuarios;
	}
	
	private void validaTamanio() {
		if(initSize != size) {
			Sessions.getCurrent().setAttribute("user", true);
		} else {
			Sessions.getCurrent().setAttribute("user", false);
		}
	}
	
	/**
	 * Choose all.
	 */
	@Command
	@NotifyChange({"contratacionDTO", "contratacionUsuariosDTO","size"})
	public void chooseAll(){
		if(!flagDisabled) {
			List<UsuarioNotificacionVO> usuarioNotificacionVOs = contratacionDTO.getUsuarioNotificacionVOs();
			for (UsuarioNotificacionVO notificacionVO : usuarioNotificacionVOs) {
				contratacionUsuariosDTO.getUsuarioNotificacionContrataMapVOs().add(notificacionVO);
			}
			size = contratacionUsuariosDTO.getUsuarioNotificacionContrataMapVOs().size();
			validaTamanio();
			contratacionDTO.getUsuarioNotificacionVOs().clear();
			Sessions.getCurrent().setAttribute("flgCambio",true);
			agregarUsuarios();
		}
	}
	
	/**
	 * Choose one.
	 */
	@Command
	@NotifyChange({"contratacionDTO", "contratacionUsuariosDTO", "size"})
	public void chooseOne(){		
		if(!flagDisabled) {
			if(usuariosNotificacion.getSelectedItem()!=null){
				contratacionUsuariosDTO.getUsuarioNotificacionContrataMapVOs().add(contratacionDTO.getUsuarioNotificacionVOs().get(usuariosNotificacion.getSelectedIndex()));
				contratacionDTO.getUsuarioNotificacionVOs().remove(usuariosNotificacion.getSelectedIndex());
				size = contratacionUsuariosDTO.getUsuarioNotificacionContrataMapVOs().size();
				Sessions.getCurrent().setAttribute("flgCambio",true);
				validaTamanio();
				agregarUsuarios();
			}
		}
	}

	/**
	 * Removes the all.
	 */
	@Command
	@NotifyChange({"contratacionDTO", "contratacionUsuariosDTO", "size"})
	public void removeAll(){
		if(!flagDisabled) {
			List<UsuarioNotificacionVO> notificacionVOs = contratacionUsuariosDTO.getUsuarioNotificacionContrataMapVOs();
			for (UsuarioNotificacionVO notificacionVO : notificacionVOs) {
				contratacionDTO.getUsuarioNotificacionVOs().add(notificacionVO);
			}
			contratacionUsuariosDTO.getUsuarioNotificacionContrataMapVOs().clear();
			Sessions.getCurrent().setAttribute("flgCambio",true);
			size = 0;
			remove = true;
			validaTamanio();
			agregarUsuarios();
		}
	}
	
	/**
	 * Removes the one.
	 */
	@Command
	@NotifyChange({"contratacionDTO", "contratacionUsuariosDTO", "size"})
	public void removeOne(){
		if(!flagDisabled) {
			if(usuariosNotificacionActivo.getSelectedIndex() != -1){
				UsuarioNotificacionVO usuario = contratacionUsuariosDTO.getUsuarioNotificacionContrataMapVOs().get(usuariosNotificacionActivo.getSelectedIndex());
				contratacionDTO.getUsuarioNotificacionVOs().add(contratacionUsuariosDTO.getUsuarioNotificacionContrataMapVOs().get(usuariosNotificacionActivo.getSelectedIndex()));
				contratacionUsuariosDTO.getUsuarioNotificacionContrataMapVOs().remove(usuariosNotificacionActivo.getSelectedIndex());
				size = contratacionUsuariosDTO.getUsuarioNotificacionContrataMapVOs().size();				
				Sessions.getCurrent().setAttribute("flgCambio",true);				
				if(descripcionIdUsuarios.contains("-"+usuario.getIdUsuarioNotificado()+"-")){
					//System.out.println("descripcionIdUsuarios::::"+descripcionIdUsuarios);
					descripcionIdUsuarios = descripcionIdUsuarios.replace("-"+usuario.getIdUsuarioNotificado()+"-", "-");
					//System.out.println("descripcionIdUsuarios::::"+descripcionIdUsuarios);
				}else if(descripcionIdUsuarios.startsWith(usuario.getIdUsuarioNotificado()+"-")){
					//System.out.println("descripcionIdUsuarios::::"+descripcionIdUsuarios);
					descripcionIdUsuarios = descripcionIdUsuarios.replace(usuario.getIdUsuarioNotificado()+"-", "");
					//System.out.println("descripcionIdUsuarios::::"+descripcionIdUsuarios);
				}											
				validaTamanio();
				agregarUsuarios();
			}
		}
	}

	/* (non-Javadoc)
	 * @see mx.com.bbva.mapeador.ui.commons.controller.IController#save()
	 */
	@Override
	@Command
	@NotifyChange({"guardarBtn","idTransaccion"})
	public void save() {
		boolean errorGuardar = false;
		final ReportesController controller = new ReportesController();
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
			if(contratacionUsuariosDTO.getUsuarioNotificacionContrataMapVOs().isEmpty()){
				usuariosNotificacionActivo.setEmptyMessage("Favor de seleccionar al menos un Usuario");
				errorGuardar = true;
			} 
		}
		
		if(!errorGuardar) {
			Messagebox.show(
					"¿Está seguro que desea continuar con la operación?",
					"Pregunta", org.zkoss.zul.Messagebox.YES | org.zkoss.zul.Messagebox.NO,
			org.zkoss.zul.Messagebox.QUESTION, new EventListener<Event>() {
				@Override
				public void onEvent(Event event) throws Exception {
					if (event.getName().equals(org.zkoss.zul.Messagebox.ON_YES)) {
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
									descripcionIdUsuarios = descripcionIdUsuarios.equals("null")?"":descripcionIdUsuarios;
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
							contratacionMapDTO = contratacionMapeadorBO.createCommand(contratacionMapDTO);
							idTransaccion.setValue("1");
							Sessions.getCurrent().removeAttribute("user");
							Sessions.getCurrent().removeAttribute("idMensajeSalida");
							Sessions.getCurrent().removeAttribute("idMapaGmm");
							
							contador = Integer.parseInt(String.valueOf(Sessions.getCurrent().getAttribute("contadorFinal")==null?Sessions.getCurrent().getAttribute("contador"):Sessions.getCurrent().getAttribute("contadorFinal")));
							
							Sessions.getCurrent().setAttribute("contadorFinal", contador-1);
							
							if(contratacionMapDTO.getErrorCode().equals("SQL-001")){
						    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
						    					"\nError:"+contratacionMapDTO.getErrorCode()+
						    					"","Error de Sistema",Messagebox.OK,Messagebox.ERROR);
							}else{
								//registraBitacora(contratacionMapVO, CommandConstants.ALTA);
								ContratacionMapVO contratacionMapVONuevo = new ContratacionMapVO();
								contratacionMapVONuevo.setIdMapaGmm(-1);
								contratacionMapVONuevo.setIdFlujo(-1);
								contratacionMapVONuevo.setIdEtapa(-1);
								contratacionMapVONuevo.setIdContratacion(-1);
								contratacionMapVONuevo.setEstatusNotificacion(" ".charAt(0));
								contratacionMapVONuevo.setIdMensajeSalida(-1);
								contratacionMapVONuevo.setDescripcionIdUsuarios("");								
								controller.registrarEvento(contratacionMapVO, contratacionMapVONuevo, CommandConstants.ALTA,"CONTRATACIÓN");
								org.zkoss.zul.Messagebox.show("!La Contratación fue guardada exitosamente!",
										"Información", org.zkoss.zul.Messagebox.OK,
										org.zkoss.zul.Messagebox.INFORMATION);
								guardarBtn = true;
							}
						} else {
							contratacionMapVO.setIdContratacion(Integer.parseInt(idContratacion.getValue()));
							contratacionMapDTO.setContratacionMapVO(contratacionMapVO);
							contratacionMapDTO = contratacionMapeadorBO.updateCommand(contratacionMapDTO);
							Sessions.getCurrent().removeAttribute("user");
							Sessions.getCurrent().removeAttribute("idMensajeSalida");
							Sessions.getCurrent().removeAttribute("idMapaGmm");
							Sessions.getCurrent().removeAttribute("contadorFinal");
							Sessions.getCurrent().removeAttribute("contador");
							Sessions.getCurrent().removeAttribute("flag");
							Sessions.getCurrent().removeAttribute("flagDisabled");
							Sessions.getCurrent().removeAttribute("ultimoValor");
							if(contratacionMapDTO.getErrorCode().equals("SQL-001")){
						    	Messagebox.show("Hubo un error en base de datos, favor de reportarlo con el administrador del sistema:\n"+
						    					"\nError:"+contratacionMapDTO.getErrorCode()+
						    					"","Error de Sistema",Messagebox.OK,Messagebox.ERROR);
							}else{
								registraBitacora(contratacionMapVO, CommandConstants.MODIFICACION);
								//controller.registrarEvento(contratacionMapVO, contratacionMapVONuevo, CommandConstants.ALTA,"CONTRATACIÓN");
								org.zkoss.zul.Messagebox.show("!La Actualización de la Contratación fue exitosa!",
										"Información", org.zkoss.zul.Messagebox.OK,
										org.zkoss.zul.Messagebox.INFORMATION);
							}
						}
					}
				}
			});
		}
	}
	
	/**
	 * Registra bitacora.
	 *
	 * @param contratacionVO the contratacion vo
	 * @param evento the evento
	 */
	private void registraBitacora(ContratacionMapVO contratacionMapVO, int evento) {
		List<CampoDTO> campoDTOs = new ArrayList<CampoDTO>(); 
		BitacoraDTO dto = new BitacoraDTO();
		Field[] atributos = contratacionMapVO.getClass().getFields(); 
		for (int i = 0; i < atributos.length; i++) {
			CampoDTO campo = new CampoDTO();
			campo.setNombre_campo(atributos[i].getName()); 
			campoDTOs.add(campo);
		}		
		dto.setCampoDTOs(campoDTOs);
		ControllerSupport controllerSupport = new ControllerSupport();
		controllerSupport.registraEvento(dto, "Contratación", evento);
	}
	
	
	/**
	 * Sets the boton editar.
	 *
	 * @param botonEditar the botonEditar to set
	 */
	public void setBotonEditar(boolean botonEditar) {
		this.botonEditar = botonEditar;
	}

	/**
	 * Sets the boton limpiar.
	 *
	 * @param botonLimpiar the botonLimpiar to set
	 */
	public void setBotonLimpiar(boolean botonLimpiar) {
		this.botonLimpiar = botonLimpiar;
	}

	/**
	 * Sets the contratacion dto.
	 *
	 * @param contratacionDTO the contratacionDTO to set
	 */
	public void setContratacionDTO(ContratacionDTO contratacionDTO) {
		this.contratacionDTO = contratacionDTO;
	}

	/**
	 * Sets the contratacion map dto.
	 *
	 * @param contratacionMapDTO the contratacionMapDTO to set
	 */
	public void setContratacionMapDTO(ContratacionMapDTO contratacionMapDTO) {
		this.contratacionMapDTO = contratacionMapDTO;
	}

	/**
	 * Sets the contratacion map vo.
	 *
	 * @param contratacionMapVO the contratacionMapVO to set
	 */
	public void setContratacionMapVO(ContratacionMapVO contratacionMapVO) {
		this.contratacionMapVO = contratacionMapVO;
	}

	/**
	 * Sets the contratacion usuarios dto.
	 *
	 * @param contratacionUsuariosDTO the contratacionUsuariosDTO to set
	 */
	public void setContratacionUsuariosDTO(ContratacionDTO contratacionUsuariosDTO) {
		this.contratacionUsuariosDTO = contratacionUsuariosDTO;
	}

	/**
	 * Sets the contratacion vo.
	 *
	 * @param contratacionVO the contratacionVO to set
	 */
	public void setContratacionVO(ContratacionVO contratacionVO) {
		this.contratacionVO = contratacionVO;
	}

	/**
	 * Sets the contratacion v os.
	 *
	 * @param contratacionVOs the contratacionVOs to set
	 */
	public void setContratacionVOs(List<ContratacionVO> contratacionVOs) {
		this.contratacionVOs = contratacionVOs;
	}

	/**
	 * Sets the flag disabled.
	 *
	 * @param flagDisabled the flagDisabled to set
	 */
	public void setFlagDisabled(boolean flagDisabled) {
		this.flagDisabled = flagDisabled;
	}

	/**
	 * Sets the guardar btn.
	 *
	 * @param guardarBtn the guardarBtn to set
	 */
	public void setGuardarBtn(boolean guardarBtn) {
		this.guardarBtn = guardarBtn;
	}

	/**
	 * Sets the id str contratacion.
	 *
	 * @param idStrContratacion the idStrContratacion to set
	 */
	public void setIdStrContratacion(String idStrContratacion) {
		this.idStrContratacion = idStrContratacion;
	}

	/**
	 * Sets the id str etapa.
	 *
	 * @param idStrEtapa the idStrEtapa to set
	 */
	public void setIdStrEtapa(String idStrEtapa) {
		this.idStrEtapa = idStrEtapa;
	}
	
	/**
	 * Sets the id str flujo.
	 *
	 * @param idStrFlujo the idStrFlujo to set
	 */
	public void setIdStrFlujo(String idStrFlujo) {
		this.idStrFlujo = idStrFlujo;
	}

	/**
	 * Sets the id str mapa gmm.
	 *
	 * @param idStrMapaGmm the idStrMapaGmm to set
	 */
	public void setIdStrMapaGmm(String idStrMapaGmm) {
		this.idStrMapaGmm = idStrMapaGmm;
	}

	/**
	 * Sets the id str mensaje salida.
	 *
	 * @param idStrMensajeSalida the idStrMensajeSalida to set
	 */
	public void setIdStrMensajeSalida(String idStrMensajeSalida) {
		this.idStrMensajeSalida = idStrMensajeSalida;
	}

	/**
	 * Sets the id str transaccion.
	 *
	 * @param idStrTransaccion the idStrTransaccion to set
	 */
	public void setIdStrTransaccion(String idStrTransaccion) {
		this.idStrTransaccion = idStrTransaccion;
	}

	/**
	 * Sets the str descripcion mensaje salida.
	 *
	 * @param strDescripcionMensajeSalida the strDescripcionMensajeSalida to set
	 */
	public void setStrDescripcionMensajeSalida(String strDescripcionMensajeSalida) {
		this.strDescripcionMensajeSalida = strDescripcionMensajeSalida;
	}

	/**
	 * Sets the str nombre mensaje salida.
	 *
	 * @param strNombreMensajeSalida the strNombreMensajeSalida to set
	 */
	public void setStrNombreMensajeSalida(String strNombreMensajeSalida) {
		this.strNombreMensajeSalida = strNombreMensajeSalida;
	}

	/**
	 * Sets the titulo.
	 *
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the initSize
	 */
	public int getInitSize() {
		return initSize;
	}

	/**
	 * @param initSize the initSize to set
	 */
	public void setInitSize(int initSize) {
		this.initSize = initSize;
	}

	/**
	 * @return the idStrTab
	 */
	public String getIdStrTab() {
		return idStrTab;
	}

	/**
	 * @param idStrTab the idStrTab to set
	 */
	public void setIdStrTab(String idStrTab) {
		this.idStrTab = idStrTab;
	}
		
}

