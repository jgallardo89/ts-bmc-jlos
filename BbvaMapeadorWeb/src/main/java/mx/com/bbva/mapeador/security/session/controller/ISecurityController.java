package mx.com.bbva.mapeador.security.session.controller;

import java.lang.reflect.Field;
import java.util.HashMap;

import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

import org.zkoss.zk.ui.AbstractComponent;
import org.zkoss.zk.ui.Component;

public interface ISecurityController {

	public abstract boolean applyPermission(int idPantalla, HashMap<String, Component> componentes);
}
