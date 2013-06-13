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
 * Nombre de proyecto: BbvaBancomerCommons
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
 * Nombre de clase: CommandConstants.java
 * Nombre de paquete: mx.com.bbva.bancomer.commons.command
 *              
 *           
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package mx.com.bbva.bancomer.commons.command;

// TODO: Auto-generated Javadoc
/**
 * The Interface CommandConstants.
 */
public abstract interface CommandConstants {
	
	/** The Constant ACCESO. */
	public static final int ACCESO = 1;
	

	/** The Constant CONSULTAR. */
	public static final int CONSULTAR = 2;
	
	/** The Constant ALTA. */
	public static final int ALTA = 3;
	
	/** The Constant MODIFICACION. */
	public static final int MODIFICACION = 4;
	
	/** The Constant ELIMINACION. */
	public static final int ELIMINACION = 5;	
	
	/** The Constant BAJA. */
	public static final int BAJA = 6;

	/** The Constant INACTIVACION. */
	public static final int INACTIVACION = 7;
	
	/** The Constant EXPORTAR_EXCEL. */
	public static final int EXPORTAR_EXCEL = 8;
	
	/** The Constant EXPORTAR_TEXTO. */
	public static final int EXPORTAR_TEXTO = 9;
	
	/** The Constant ALTA. */
	public static final int ALTA_FALLIDA = 10;
	
	/** The Constant MODIFICACION. */
	public static final int MODIFICACION_FALLIDA = 11;
	
	/** The Constant ELIMINACION. */
	public static final int ELIMINACION_FALLIDA = 12;	
	
	/** The Constant BAJA. */
	public static final int BAJA_FALLIDA = 13;
	
	/** The Constant BAJA. */
	public static final int INACTIVACION_FALLIDA = 14;
	
	/** The Constant CANAL_CLIENTE_PRODUCTO. */
	public static final int CANAL_CLIENTE_PRODUCTO = 1;
	/** The Constant CLIENTE_CANAL_PRODUCTO. */
	public static final int CLIENTE_CANAL_PRODUCTO = 2;
	/** The Constant COMPONENTE_PANTALLA. */
	public static final int COMPONENTE_PANTALLA = 1;
	
	/** The Constant COMPONENTE_PANTALLA_PERFIL. */
	public static final int COMPONENTE_PANTALLA_PERFIL = 3;
	
	/** The Constant COMPONENTE_PANTALLA_PERFIL_ALL. */
	public static final int COMPONENTE_PANTALLA_PERFIL_ALL = 4;
	
	/** The Constant COMPONENTE_PANTALLA_REFERENCE_PERFIL. */
	public static final int COMPONENTE_PANTALLA_REFERENCE_PERFIL = 5;	
	
	/** The Constant CONSULTA_EXISTE_TIPO_COMPONENTE. */
	public static final int CONSULTA_EXISTE_TIPO_COMPONENTE = 3;
	
	/** The Constant CONSULTA_MENSAJES_USUARIOS. */
	public static final int CONSULTA_MENSAJES_USUARIOS = 3;
	
	/** The Constant CONSULTA_USUARIOS_ASIGNADOS. */
	public static final int CONSULTA_USUARIOS_ASIGNADOS = 4;
	
	/** The Constant CONSULTA_USUARIOS_NO_ASIGNADOS. */
	public static final int CONSULTA_USUARIOS_NO_ASIGNADOS = 3;
	

	/** The Constant ESTADO_ERROR_PROCESO. */
	public static final int ESTADO_ERROR_PROCESO = 9;
	
	/** The Constant ESTADO_ESPERA_PROCESO. */
	public static final int ESTADO_ESPERA_PROCESO = 11;	
	
	/** The Constant ESTADO_EXITO_PROCESO. */
	public static final int ESTADO_EXITO_PROCESO = 8;
	
	/** The Constant ESTADO_FINALIZA_USUARIO_PROCESO. */
	public static final int ESTADO_FINALIZA_USUARIO_PROCESO = 10;
	
	/** The Constant ESTADOS_ARCHIVOS. */
	public static final int ESTADOS_ARCHIVOS = 3;
	
	/** The Constant ESTATUS_CLAVE. */
	public static final int ESTATUS_CLAVE = 3;
	
	/** The Constant ESTATUS_OBJETO. */
	public static final int ESTATUS_OBJETO = 2;
	
	/** The Constant ESTATUS_OBJETO_ACTIVO. */
	public static final int ESTATUS_OBJETO_ACTIVO = 1;
	
	/** The Constant ESTATUS_OBJETO_ACTIVO_CANAL. */
	public static final int ESTATUS_OBJETO_ACTIVO_CANAL = 1;
	
	/** The Constant ESTATUS_OBJETO_ACTIVO_CLIENTES. */
	public static final int ESTATUS_OBJETO_ACTIVO_CLIENTES = 4;
	
	/** The Constant ESTATUS_OBJETO_CANAL_BAJA. */
	public static final int ESTATUS_OBJETO_CANAL_BAJA = 3;
	
	/** The Constant ESTATUS_OBJETO_CLIENTE_BAJA. */
	public static final int ESTATUS_OBJETO_CLIENTE_BAJA = 6;
	
	/** The Constant ESTATUS_OBJETO_CLIENTE_INACTIVO. */
	public static final int ESTATUS_OBJETO_CLIENTE_INACTIVO = 5;
	
	/** The Constant ESTATUS_OBJETO_COMBO_PANTALLAS. */
	public static final int ESTATUS_OBJETO_COMBO_PANTALLAS = 31;
	
	/** The Constant ESTATUS_OBJETO_CONTRATACION_ACTIVO. */
	public static final int ESTATUS_OBJETO_CONTRATACION_ACTIVO = 21;
	
	/** The Constant ESTATUS_OBJETO_CONTRATACION_BAJA. */
	public static final int ESTATUS_OBJETO_CONTRATACION_BAJA = 23;
	
	/** The Constant ESTATUS_OBJETO_FLUJO_ACTIVO. */
	public static final int ESTATUS_OBJETO_FLUJO_ACTIVO = 10;
	
	/** The Constant ESTATUS_OBJETO_FLUJO_BAJA. */
	public static final int ESTATUS_OBJETO_FLUJO_BAJA = 12;	
	
	/** The Constant ESTATUS_OBJETO_MENSAJE_SALIDA_ACTIVO. */
	public static final int ESTATUS_OBJETO_MENSAJE_SALIDA_ACTIVO = 15;
	
	/** The Constant ESTATUS_OBJETO_MENSAJE_SALIDA_BAJA. */
	public static final int ESTATUS_OBJETO_MENSAJE_SALIDA_BAJA = 17;
	
	/** The Constant ESTATUS_OBJETO_PANTALLA_SALIDA_BAJA. */
	public static final int ESTATUS_OBJETO_PANTALLA_SALIDA_BAJA = 33;
	
	/** The Constant ESTATUS_OBJETO_PRODUCTO_ACTIVO. */
	public static final int ESTATUS_OBJETO_PRODUCTO_ACTIVO = 7;
	
	/** The Constant ESTATUS_OBJETO_PRODUCTO_BAJA. */
	public static final int ESTATUS_OBJETO_PRODUCTO_BAJA = 9;
	
	/** The Constant ESTATUS_PERFIL. */
	public static final int ESTATUS_PERFIL = 24;
	
	/** The Constant ESTATUS_PRODUCTO_ACTIVO. */
	public static final int ESTATUS_PRODUCTO_ACTIVO = 7;
	
	/** The Constant ESTATUS_USUARIO_ACTIVO. */
	public static final int ESTATUS_USUARIO_ACTIVO = 27;

	/** The Constant ESTATUS_USUARIO_ACTIVO. */
	public static final int ESTATUS_USUARIO_NOTIFICACION_ACTIVO = 18;
	

	
	//Estatus del Catálogo de Canales
	/** The Constant ID_CANAL_ACTIVO. */
	public static final int ID_CANAL_ACTIVO = 1;

	/** The Constant ID_CANAL_INACTIVO. */
	public static final int ID_CANAL_INACTIVO = 2;	
	
	/** The Constant ID_CANAL_BAJA. */
	public static final int ID_CANAL_BAJA = 3;
	
	//Estatus del Catálogo de Clientes
	/** The Constant ID_CLIENTE_ACTIVO. */
	public static final int ID_CLIENTE_ACTIVO = 4;									

	/** The Constant ID_CLIENTE_BAJA. */
	public static final int ID_CLIENTE_INACTIVO = 5;
	
	/** The Constant ID_CLIENTE_BAJA. */
	public static final int ID_CLIENTE_BAJA = 6;
	
	//Estatus del Catálogo de Contratación
	/** The Constant ID_CONTRATACION_ACTIVO. */
	public static final int ID_CONTRATACION_ACTIVO = 21;
	
	/** The Constant ID_CONTRATACION_BAJA. */
	public static final int ID_CONTRATACION_BAJA = 23;
	
	//Estatus del Catálogo de Flujos
	/** The Constant ID_FLUJO_ACTIVO. */
	public static final int ID_FLUJO_ACTIVO = 10;
	
	/** The Constant ID_FLUJO_BAJA. */
	public static final int ID_FLUJO_BAJA = 12;
	
	/** The Constant ID_FLUJO_INACTIVO. */
	public static final int ID_FLUJO_INACTIVO = 11;
	
	//Estatus del Catálogo de Mensaje
	/** The Constant ID_MENSAJE_ACTIVO. */
	public static final int ID_MENSAJE_ACTIVO = 15;

	/** The Constant ID_MENSAJE_INACTIVO. */
	public static final int ID_MENSAJE_INACTIVO = 16;
	
	/** The Constant ID_MENSAJE_BAJA. */
	public static final int ID_MENSAJE_BAJA = 17;
	
	//Estatus del Catálogo de PERFIL
	/** The Constant ID_PERFIL_ACTIVO. */
	public static final int ID_PERFIL_ACTIVO = 24;
	
	/** The Constant ID_PERFIL_BAJA. */
	public static final int ID_PERFIL_BAJA = 26;
	
	/** The Constant ID_PERFIL_INACTIVO. */
	public static final int ID_PERFIL_INACTIVO = 25;
	
	//Estatus del Catálogo de Producto
	/** The Constant ID_PRODUCTO_ACTIVO. */
	public static final int ID_PRODUCTO_ACTIVO = 7;

	/** The Constant ID_PRODUCTO_INACTIVO. */
	public static final int ID_PRODUCTO_INACTIVO = 8;
	
	/** The Constant ID_PRODUCTO_BAJA. */
	public static final int ID_PRODUCTO_BAJA = 9;
	
	
	/** The Constant ID_MAPA_ACTIVO. */
	public static final int ID_MAPA_ACTIVO = 13;
	
	/** The Constant ID_MAPA_INACTIVO. */
	public static final int ID_MAPA_INACTIVO = 14;
	
	
	//Monitoreo de Procesos
	/** The Constant IMG_AMARILLO_ESPERA_PNG. */
	public static final String IMG_AMARILLO_ESPERA_PNG = "/img/amarillo-espera.png";
	
	/** The Constant IMG_AZUL_FINALIZAUSUARIO_PNG. */
	public static final String IMG_AZUL_FINALIZAUSUARIO_PNG = "/img/azul-finalizausuario.png";
	
	/** The Constant IMG_ERROR_ROJO_PNG. */
	public static final String IMG_ERROR_ROJO_PNG = "/img/error-rojo.png";
	
	/** The Constant IMG_U276_NORMAL_PNG. */
	public static final String IMG_U276_NORMAL_PNG = "/img/u276_normal.png";
	
	/** The Constant IMG_VERDE_EXITO_PNG. */
	public static final String IMG_VERDE_EXITO_PNG = "/img/verde-exito.png";
	

	/** The Constant NB PANTALLA ACTIVO. */
	public static final String NB_PANTALLA_ACTIVO = "ACTIVO";
	
	/** The Constant NB USUARIO ACTIVO. */
	public static final String NB_USUARIO_ACTIVO = "ACTIVO";
	
	/** The Constant NB USUARIO NOTIFICACION ACTIVO. */
	public static final String NB_USUARIO_NOTIFICACION_ACTIVO = "ACTIVO";	
	
	/** The Constant NB ESTATUS ACTIVO. */
	public static final String NB_ESTATUS_ACTIVO = "ACTIVO";
	
	/** The Constant NB_CANAL_ACTIVO. */
	public static final String NB_CANAL_ACTIVO = "ACTIVO";
	
	/** The Constant NB_CANAL_BAJA. */
	public static final String NB_CANAL_BAJA = "BAJA";
	
	/** The Constant NB_CLIENTE_ACTIVO. */
	public static final String NB_CLIENTE_ACTIVO = "ACTIVO";
	
	/** The Constant NB_CLIENTE_BAJA. */
	public static final String NB_CLIENTE_BAJA = "BAJA";
	
	/** The Constant NB_CONTRATACION_ACTIVO. */
	public static final String NB_CONTRATACION_ACTIVO = "ACTIVO";
	
	/** The Constant NB_CONTRATACION_BAJA. */
	public static final String NB_CONTRATACION_BAJA = "BAJA";
	
	/** The Constant NB_FLUJO_ACTIVO. */
	public static final String NB_FLUJO_ACTIVO = "ACTIVO";
	
	/** The Constant NB_FLUJO_BAJA. */
	public static final String NB_FLUJO_BAJA = "BAJA";
	
	/** The Constant NB_MENSAJE_ACTIVO. */
	public static final String NB_MENSAJE_ACTIVO = "ACTIVO";
	
	/** The Constant NB_MENSAJE_BAJA. */
	public static final String NB_MENSAJE_BAJA = "BAJA";
	
	/** The Constant NB_PERFIL_ACTIVO. */
	public static final String NB_PERFIL_ACTIVO = "ACTIVO";
	
	/** The Constant NB_PERFIL_BAJA. */
	public static final String NB_PERFIL_BAJA = "BAJA";
	
	/** The Constant NB_PRODUCTO_ACTIVO. */
	public static final String NB_PRODUCTO_ACTIVO = "ACTIVO";
	
	/** The Constant NB_PRODUCTO_BAJA. */
	public static final String NB_PRODUCTO_BAJA = "BAJA";
	
	/** The Constant NOMBRE_PANTALLA. */
	public static final int NOMBRE_PANTALLA = 4;
	
	/** The Constant NOMBRE_TABLA_CANALES. */
	public static final String NOMBRE_TABLA_CANALES = "TGM511_CANAL";
	
	/** The Constant NOMBRE_TABLA_CLIENTES. */
	public static final String NOMBRE_TABLA_CLIENTES = "TGM512_CLIENTE";
	
	/** The Constant NOMBRE_TABLA_CONTRATACION. */
	public static final String NOMBRE_TABLA_CONTRATACION = "TGM519_CNTRATACION";
	
	/** The Constant NOMBRE_TABLA_FLUJOS. */
	public static final String NOMBRE_TABLA_FLUJOS = "TGM513_FLUJO";
	
	/** The Constant NOMBRE_TABLA_MAPA. */
	public static final String NOMBRE_TABLA_MAPA = "TGM514_MAPA_GMM";
	
	/** The Constant NOMBRE_TABLA_MENSAJE. */
	public static final String NOMBRE_TABLA_MENSAJE= "TGM516_MENSAJE_SAL";
	
	/** The Constant NOMBRE_TABLA_PANTALLA. */
	public static final String NOMBRE_TABLA_PANTALLA = "TGM501_PANTALLA";
	/** The Constant NOMBRE_TABLA_PERFIL. */
	public static final String NOMBRE_TABLA_PERFIL = "TGM504_PERFIL";
	
	/** The Constant NOMBRE_TABLA_PROCESO. */
	public static final String NOMBRE_TABLA_PROCESO = "TGM522_ST_PROCESO";
	
	/** The Constant NOMBRE_TABLA_PRODUCTOS. */
	public static final String NOMBRE_TABLA_PRODUCTOS = "TGM515_PRODUCTO";
	
	/** The Constant NOMBRE_TABLA_USUARIO. */
	public static final String NOMBRE_TABLA_USUARIO = "TGM503_USUARIO";
	
	/** The Constant NOMBRE_TABLA_USUARIOS_NEGOCIO. */
	public static final String NOMBRE_TABLA_USUARIOS_NEGOCIO = "TGM510_USUA_NOTIFI";
	
	/** The Constant PERFIL_COMMAND_READ_ALL. */
	public static final int PERFIL_COMMAND_READ_ALL = 1;
	
	/** The Constant PERFIL_COMMAND_READ_PERMISSION. */
	public static final int PERFIL_COMMAND_READ_PERMISSION = 3;
	
	/** The Constant PROCESO_ERROR_ROJO. */
	public static final int PROCESO_ERROR_ROJO = 35;
	
	/** The Constant PROCESO_ESPERA_AMARILLO. */
	public static final int PROCESO_ESPERA_AMARILLO = 37;
	
	/** The Constant PROCESO_EXITO_VERDE. */
	public static final int PROCESO_EXITO_VERDE = 34;
	
	/** The Constant PROCESO_FINALIZA_USUARIO_AZUL. */
	public static final int PROCESO_FINALIZA_USUARIO_AZUL = 36;
	
	/** The Constant PROCESOS_ARCHIVOS. */
	public static final int PROCESOS_ARCHIVOS = 4;
	
	/** The Constant PROCESOS_CANAL. */
	public static final int PROCESOS_CANAL = 3;
	
	/** The Constant PROCESOS_ESTATUS. */
	public static final int PROCESOS_ESTATUS = 5;
	
	/** The Constant PRODUCTO_CANAL_CLIENTE. */
	public static final int PRODUCTO_CANAL_CLIENTE= 3;
	
	/** The Constant TIPO_NOTIFICACION_NEGOCIO. */
	public static final String TIPO_NOTIFICACION_NEGOCIO = "N";
	
	/** The Constant TIPO_NOTIFICACION_SISTEMA. */
	public static final String TIPO_NOTIFICACION_SISTEMA = "S";
	
	/** The Constant TODOS. */
	public static final String TODOS = "TODOS";
	
	
	
}



