package mx.com.bbva.bancomer.utils;

public abstract class StringUtil {
	public String validaLike(String elemento) {
		if(elemento == null)
			elemento = "%";
		else 
			elemento = "%" + elemento + "%";
		return elemento;
	}
}
