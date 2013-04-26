/**
 * Proyecto: Monitor Web Swift.
 *
 * Archivo: H2HMonitoreoService_CGS.java.
 *
 * Creado: 05/10/2010.
 *
 * (c) Monitor Web Swift. Todos los derechos reservados - 2010.
 */
package com.bancomer.gis.monitorwebswift.logic;

import java.util.List;

/**
 * Servicio para el monitoreo H2H
 * @author XM07355
 */
public interface H2HMonitoreoService_CGS {
	/**
	 * Metodo que obtiene los archivos procesados y sus respectivos asociados para el monitoreo H2H X pagina
	 * @param fechaInicio fecha inicial
	 * @param fechaFin fecha final
	 * @param tamPagina tamaño de la pagina
	 * @return lista de archivos
	 */
	List obtenerArchivosProcesadosH2HXPagina(String fechaInicio, String fechaFin, int pagina, String bicRec, int tamPagina, 
			String columnName, boolean descending);
	
	/**
	 * Metodo que obtiene los archivos procesados y sus respectivos asociados para el monitoreo H2H
	 * @param fechaInicio fecha inicial
	 * @param fechaFin fecha final
	 * @return lista de archivos
	 */
	List obtenerArchivosProcesadosH2H(String fechaInicio, String fechaFin, String bicRec,
			String columnName, boolean descending);
	
	/**
	 * metodo que obtiene el numero total de registros para una consulta con los criterios dados
	 * @param fechaInicio fecha inicial
	 * @param fechaFin fecha final
	 * @return
	 */
	int obtenerNumArchivosProcesadosH2H(String fechaInicio, String fechaFin, String bicRec);

}
