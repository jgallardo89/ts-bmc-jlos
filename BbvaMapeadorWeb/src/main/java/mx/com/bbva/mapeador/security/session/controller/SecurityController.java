package mx.com.bbva.mapeador.security.session.controller;

import java.lang.reflect.Field;

import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

import org.zkoss.zk.ui.AbstractComponent;

public class SecurityController {

	public ControllerSupport applyPermission(ControllerSupport controllerSupport){
		
		Field[] fields = controllerSupport.getClass().getFields();
		
		return controllerSupport;
	}
}
