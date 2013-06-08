package mx.com.bbva.bancomer.commons.command;

public abstract interface CommandConstants {
	public static final int ESTATUS_OBJETO_COMBO_PANTALLAS = 31;
	public static final int ESTATUS_OBJETO = 2;
	public static final int ESTATUS_PRODUCTO_ACTIVO = 7;
	public static final int ESTATUS_OBJETO_ACTIVO = 1;
	public static final int ESTATUS_OBJETO_CONTRATACION_ACTIVO = 21;
	public static final int ESTATUS_OBJETO_CONTRATACION_BAJA = 23;
	public static final int ESTATUS_OBJETO_ACTIVO_CLIENTES = 4;	
	public static final int ESTATUS_OBJETO_PRODUCTO_BAJA = 9;
	public static final int ESTATUS_OBJETO_PRODUCTO_ACTIVO = 7;
	public static final int ESTATUS_OBJETO_MENSAJE_SALIDA_ACTIVO = 15;
	public static final int ESTATUS_OBJETO_MENSAJE_SALIDA_BAJA = 17;
	public static final int ESTATUS_OBJETO_PANTALLA_SALIDA_BAJA = 33;
	public static final int ESTATUS_OBJETO_FLUJO_BAJA = 12;
	public static final int ESTATUS_OBJETO_CANAL_BAJA = 3;
	public static final int ESTATUS_OBJETO_ACTIVO_CANAL = 1;	
	public static final int ESTATUS_OBJETO_CLIENTE_INACTIVO = 5;
	public static final int ESTATUS_OBJETO_CLIENTE_BAJA = 6;
	public static final int ESTATUS_OBJETO_FLUJO_ACTIVO = 10;
	public static final int COMPONENTE_PANTALLA = 1;
	public static final int COMPONENTE_PANTALLA_PERFIL = 3;
	public static final int COMPONENTE_PANTALLA_PERFIL_ALL = 4;
	public static final int COMPONENTE_PANTALLA_REFERENCE_PERFIL = 5;
	public static final int ESTADOS_ARCHIVOS = 3;
	public static final int ESTATUS_PERFIL = 24;
	public static final int ESTATUS_CLAVE = 3;
	public static final int NOMBRE_PANTALLA = 4;
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
	public static final String NOMBRE_TABLA_MENSAJE= "TGM516_MENSAJE_SAL";
	public static final String NOMBRE_TABLA_CONTRATACION = "TGM519_CNTRATACION";
	public static final String NOMBRE_TABLA_USUARIOS_NEGOCIO = "TGM510_USUA_NOTIFI";
	public static final String TIPO_NOTIFICACION_NEGOCIO = "N";
	public static final String TIPO_NOTIFICACION_SISTEMA = "S";
	public static final int CONSULTA_USUARIOS_NO_ASIGNADOS = 3;									
	public static final int CONSULTA_USUARIOS_ASIGNADOS = 4;
	public static final int ACCESO = 1;
	public static final int CONSULTAR = 2;
	public static final int ALTA = 3;
	public static final int MODIFICACION = 4;
	public static final int ELIMINACION = 5;
	public static final int BAJA = 6;
	public static final int INACTIVACION = 7;
	public static final int EXPORTAR_EXCEL = 8;
	public static final int EXPORTAR_TEXTO = 9;
	
	//Estatus del Catálogo de Flujos
	public static final int ID_FLUJO_ACTIVO = 10;
	public static final int ID_FLUJO_INACTIVO = 11;
	public static final int ID_FLUJO_BAJA = 12;
	public static final String NB_FLUJO_ACTIVO = "ACTIVO";
	public static final String NB_FLUJO_BAJA = "BAJA";
	
	//Estatus del Catálogo de Canales
	public static final int ID_CANAL_ACTIVO = 1;
	public static final int ID_CANAL_BAJA = 3;
	public static final String NB_CANAL_ACTIVO = "ACTIVO";
	public static final String NB_CANAL_BAJA = "BAJA";
	
	//Estatus del Catálogo de Clientes
	public static final int ID_CLIENTE_ACTIVO = 4;
	public static final int ID_CLIENTE_BAJA = 6;
	public static final String NB_CLIENTE_ACTIVO = "ACTIVO";
	public static final String NB_CLIENTE_BAJA = "BAJA";
	
	//Estatus del Catálogo de Producto
	public static final int ID_PRODUCTO_ACTIVO = 7;
	public static final int ID_PRODUCTO_BAJA = 9;
	public static final String NB_PRODUCTO_ACTIVO = "ACTIVO";
	public static final String NB_PRODUCTO_BAJA = "BAJA";
	
	//Estatus del Catálogo de Contratación
	public static final int ID_CONTRATACION_ACTIVO = 21;
	public static final int ID_CONTRATACION_BAJA = 23;
	public static final String NB_CONTRATACION_ACTIVO = "ACTIVO";
	public static final String NB_CONTRATACION_BAJA = "BAJA";
	
	//Estatus del Catálogo de Mensaje
	public static final int ID_MENSAJE_ACTIVO = 15;
	public static final int ID_MENSAJE_BAJA = 17;
	public static final String NB_MENSAJE_ACTIVO = "ACTIVO";
	public static final String NB_MENSAJE_BAJA = "BAJA";
	
	//Estatus del Catálogo de PERFIL
	public static final int ID_PERFIL_ACTIVO = 24;
	public static final int ID_PERFIL_INACTIVO = 25;
	public static final int ID_PERFIL_BAJA = 26;
	public static final String NB_PERFIL_ACTIVO = "ACTIVO";
	public static final String NB_PERFIL_BAJA = "BAJA";
}



