package com.bancomer.gis.monitorwebswift.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bancomer.gis.monitorwebswift.vo.CteSwBicInternoVo;
import com.bancomer.gis.monitorwebswift.vo.H2HMonitoreoDetalleVo;

public interface H2HMonitoreoDetalleErrService {
	
	HashMap<String, Object> updateObjeto(H2HMonitoreoDetalleVo miObjeto);
	void actualizarArchivoFolioDesconocido(int idArchivo, String bic);
	ArrayList<CteSwBicInternoVo> listBics();
	List<H2HMonitoreoDetalleVo> obtenerArchivosFolioDesconocido(String fechaInicial, String fechaFinal);
}
