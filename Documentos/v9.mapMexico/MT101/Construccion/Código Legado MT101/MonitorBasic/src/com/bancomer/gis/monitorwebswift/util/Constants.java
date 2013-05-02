package com.bancomer.gis.monitorwebswift.util;

public class Constants {
	
	public static final String CO ="COLOMBIA";
	public static final String VE ="VENEZUELA";
	public static final String PE ="PERU";
	public static final String CL ="CHILE";
	public static final String AR ="ARGENTINA";
	public static final String MX ="MEXICO";
	public static final String PA ="PANAMA";
	public static final String PY ="PARAGUAY";
	public static final String US ="ESTADOS UNIDOS";
	public static final String PR ="PUERTO RICO";
	
	public static final int ACTIVO=1;
	public static final int INACTIVO=0;
	public static final int SWIFT =1;
	public static final int DOCUMENTS =2;
	
	public static final int SESIONES_EXCEDIDAS = -1;
	public static final int INTENTOS_LOGEO_FALLIDOS = -2;
	public static final int CONTRASENA_USER_INVALIDOS = -3;
	public static final int USUARIO_BLOQUEADO = -4;
	public static final int LOGEO_EXITOSO = 0;
	public static final int PASSWORD_CADUCO = -5;
	public static final int USUARIO_PAIS_INVALIDO = -6;
	//Dias limite de cambio en milisegundo (30 dias)
	public static final long DIAS_LIMITE_CAMBIO = 2592000000L;
	
	public static final int ORACLE 		= 1;
	public static final int SQLSERVER 	= 3;
	public static final int SQLSERVER2 	= 4;
	public static final int SQLSERVERMONITORWEB	= 5;
	
	public static final int RECAUDOS	= 1;
	public static final int RELAY		= 2;
	public static final int PAGOS		= 3;
	
	/*Constantes para los cambios de estatus de reeenvios*/
	public static final int LISTO_PARA_ENVIAR		= 1;
	public static final int POSIBLE_DUPLICADO		= 2;
	public static final int CANCELADO				= 3;
	public static final int ENVIADO_OK				= 4;
	public static final int ERROR_FORMATO			= 5;
	public static final int TEMPORAL				= 6;
	
	public static final String FIXED_IPS_FILE="com/bancomer/gis/monitorwebswift/resources/FixedIps.properties";
}
