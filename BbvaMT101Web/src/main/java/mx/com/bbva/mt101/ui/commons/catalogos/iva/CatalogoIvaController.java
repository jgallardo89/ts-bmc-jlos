package mx.com.bbva.mt101.ui.commons.catalogos.iva;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import mx.com.bbva.mt101.catalogos.iva.negocio.ICatalogoIva;
import mx.com.bbva.mt101.entities.Tgm041IvaMx;
import mx.com.bbva.mt101.ui.commons.dto.catalogos.iva.IvaDTO;

import org.apache.log4j.Logger;

public class CatalogoIvaController {

	@EJB
	private ICatalogoIva catalogoIvaBean;

	private static final Logger logger = Logger
			.getLogger(CatalogoIvaController.class);

	@SuppressWarnings("finally")
	public List<IvaDTO> getIvas() {
		logger.info("CatalogoIvaController: - Metodo: getIvas -- **inicio**");
		List<Tgm041IvaMx> tgm041IvaMxs;
		List<IvaDTO> ivaDTOs = new ArrayList<IvaDTO>();
		Tgm041IvaMx tgm041IvaMx;
		tgm041IvaMx = new Tgm041IvaMx();
		tgm041IvaMx.setCdIva(-1);
		try {
			// catalogoMonedaBean = new CatalogoMonedaBean();
			tgm041IvaMxs = catalogoIvaBean.obtenerTodosTgm041IvaMx(tgm041IvaMx);
			IvaDTO ivaDTO;
			for (Tgm041IvaMx tgm041IvaMxFE : tgm041IvaMxs) {
				ivaDTO = new IvaDTO();
				ivaDTO.setCdIva(tgm041IvaMxFE.getCdIva());
				ivaDTO.setNuPorcentaje(tgm041IvaMxFE.getNuPorcentaje());
				ivaDTOs.add(ivaDTO);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			return ivaDTOs;
		}
	}

	public void setCatalogoIvaBean(ICatalogoIva catalogoIvaBean) {
		this.catalogoIvaBean = catalogoIvaBean;
	}

}
