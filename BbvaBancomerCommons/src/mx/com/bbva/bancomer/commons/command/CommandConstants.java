package mx.com.bbva.bancomer.commons.command;

public abstract interface CommandConstants {
	public static final int ESTATUS_OBJETO_COMBO_PANTALLAS = 1;
	public static final int ESTATUS_OBJETO = 2;
	public static final int ESTATUS_OBJETO_ACTIVO = 1;
	public static final int ESTATUS_OBJETO_ACTIVO_CLIENTES = 21;
	public static final int ESTATUS_OBJETO_BAJA = 5;
	public static final int COMPONENTE_PANTALLA = 1;
	public static final int COMPONENTE_PANTALLA_PERFIL = 3;
	public static final int ESTATUS_PERFIL = 17;
	public static final int ESTATUS_CLAVE = 3;
	public static final int PERFIL_COMMAND_READ_ALL = 1;
	public static final int PERFIL_COMMAND_READ_PERMISSION = 3;
	public static final String NOMBRE_TABLA_USUARIO = "USUARIO";
	public static final String NOMBRE_TABLA_PERFIL = "PERFIL";
	public static final String NOMBRE_TABLA_CLIENTES = "CLIENTES";
	public static final String NOMBRE_TABLA_BITACORA_ARCHIVOS = "ARCHIVOS";
	public static final String NOMBRE_TABLA_PANTALLA = "PANTALLAS";
	public static final String NOMBRE_TABLA_MAPA = "MAPA";
	public static final String NOMBRE_TABLA_PRODUCTOS = "PRODUCTOS";
	public static final String NOMBRE_TABLA_FLUJOS = "FLUJOS";
	public static final String NOMBRE_TABLA_PROCESO = "TGM522_ST_PROCESO";
	
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



