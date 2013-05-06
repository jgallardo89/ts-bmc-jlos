package mx.com.bbva.bancomer.utils;

public abstract class StringUtil {
	public static String validaLike(String elemento) {
		if(elemento == null || elemento.isEmpty())
			elemento = "%";
		else 
			elemento = "%" + elemento.toUpperCase() + "%";
		return elemento;
	}
}
