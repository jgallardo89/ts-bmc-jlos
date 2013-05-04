package mx.com.bbva.mapeador.ui.commons.controller;

public interface IController {
	public Object read();
	public Object read(Object t);
	public void save();
	public void delete();	
	public void clean();
}
