package mx.com.bbva.mapeador.ui.commons.viewmodel.usuarioMapeador;

import java.util.List;
import javax.ejb.EJB;

import mx.com.bbva.bancomer.commons.command.BbvaAbstractCommandInvoker;
import mx.com.bbva.bancomer.commons.exception.BbvaBusinessException;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.commons.model.vo.BbvaAbstractValueObject;

import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;
import mx.com.bbva.mapeador.ui.commons.viewmodel.usuarioMapeador.UsuarioMapeadorController;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;

public class UsuarioMapeadorController extends ControllerSupport{

		private static final Logger logger = Logger
				.getLogger(UsuarioMapeadorController.class);		
		
		@Wire
		private Textbox identificadorUsuario;
		
		@Wire
		private Textbox nombreUsuario;
		
		@Wire
		private Combobox perfilesDisponibles;
		
		@Wire
		private Combobox status;
		
		@Wire
		private Combobox pantalla;
		
		private String strIdentificadorUsuario;
			
		private String strNombreUsuario;
		
		private String strPerfilesDisponibles;
		
		private String strStatus;		

		private int cantidadRegistros;	

		public String getStrIdentificadorUsuario() {
			return strIdentificadorUsuario;
		}

		public void setStrIdentificadorUsuario(String strIdentificadorUsuario) {
			this.strIdentificadorUsuario = strIdentificadorUsuario;
		}

		public String getStrNombreUsuario() {
			return strNombreUsuario;
		}

		public void setStrNombreUsuario(String strNombreUsuario) {
			this.strNombreUsuario = strNombreUsuario;
		}

		public String getStrPerfilesDisponibles() {
			return strPerfilesDisponibles;
		}

		public void setStrPerfilesDisponibles(String strPerfilesDisponibles) {
			this.strPerfilesDisponibles = strPerfilesDisponibles;
		}

		public String getStrStatus() {
			return strStatus;
		}

		public void setStrStatus(String strStatus) {
			this.strStatus = strStatus;
		}

		public int getCantidadRegistros() {
			return cantidadRegistros;
		}
//		
//		@SuppressWarnings("unchecked")
//		public List<> getPerfiles(){
//			UsuarioDTO usuarioDTO = new UsuarioDTO();
//			List<UsuarioDTO> listaUsuarios = null;
//			try {
//				listaUsuarios = (List<UsuarioDTO>) invoker.invoke(usuarioDTO);
//			} catch (BbvaBusinessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
//			return listaUsuarios;
//		}

		
		
}
