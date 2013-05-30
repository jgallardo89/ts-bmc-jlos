package mx.com.bbva.bancomer.commons.command;

public abstract interface CommandConstants {
	public static final int ESTATUS_OBJETO_COMBO_PANTALLAS = 31;
	public static final int ESTATUS_OBJETO = 2;
	public static final int ESTATUS_PRODUCTO_ACTIVO = 7;
	public static final int ESTATUS_OBJETO_ACTIVO = 1;
	public static final int ESTATUS_OBJETO_CONTRATACION_ACTIVO = 21;
	public static final int ESTATUS_OBJETO_ACTIVO_CLIENTES = 4;	
	public static final int ESTATUS_OBJETO_PRODUCTO_BAJA = 9;
	public static final int ESTATUS_OBJETO__MENSAJE_SALIDA_BAJA = 17;
	public static final int ESTATUS_OBJETO_FLUJO_BAJA = 11;
	public static final int ESTATUS_OBJETO_CANAL_BAJA = 3;
	public static final int ESTATUS_OBJETO_CLIENTE_BAJA = 6;
	public static final int COMPONENTE_PANTALLA = 1;
	public static final int COMPONENTE_PANTALLA_PERFIL = 3;
	public static final int ESTATUS_PERFIL = 24;
	public static final int ESTATUS_CLAVE = 3;
	public static final int PERFIL_COMMAND_READ_ALL = 1;
	public static final int PERFIL_COMMAND_READ_PERMISSION = 3;
	public static final String NOMBRE_TABLA_USUARIO = "TGM503_USUARIO";
	public static final String NOMBRE_TABLA_PERFIL = "TGM504_PERFIL";
	public static final String NOMBRE_TABLA_CLIENTES = "TGM512_CLIENTE";	
	public static final String NOMBRE_TABLA_PANTALLA = "TGM501_PANTALLA";
	public static final String NOMBRE_TABLA_MAPA = "TGM514_MAPA_GMM";
	public static final String NOMBRE_TABLA_PRODUCTOS = "TGM515_PRODUCTO";
	public static final String NOMBRE_TABLA_FLUJOS = "TGM513_FLUJO";
	public static final String NOMBRE_TABLA_PROCESO = "TGM522_ST_PROCESO";
	public static final String NOMBRE_TABLA_CANALES = "TGM511_CANAL";
	
	public static final int ACCESO = 1;
	public static final int CONSULTAR = 2;
	public static final int ALTA = 3;
	public static final int MODIFICACION = 4;
	public static final int ELIMINACION = 5;
	public static final int BAJA = 6;
	public static final int INACTIVACION = 7;
	public static final int EXPORTAR_EXCEL = 8;
	public static final int EXPORTAR_TEXTO = 9;
}



