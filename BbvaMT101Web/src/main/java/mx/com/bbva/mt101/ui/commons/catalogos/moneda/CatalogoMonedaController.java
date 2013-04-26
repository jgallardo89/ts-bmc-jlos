package mx.com.bbva.mt101.ui.commons.catalogos.moneda;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import mx.com.bbva.mt101.catalogos.moneda.negocio.ICatalogoMoneda;
import mx.com.bbva.mt101.entities.Tgm042MonedaMx;
import mx.com.bbva.mt101.ui.commons.dto.catalogos.moneda.MonedaDTO;

import org.apache.log4j.Logger;

public class CatalogoMonedaController {
	

	@EJB
	private ICatalogoMoneda catalogoMonedaBean;

	private static final Logger logger = Logger
			.getLogger(CatalogoMonedaController.class);

	@SuppressWarnings("finally")
	public List<MonedaDTO> getMonedas() {
		logger.info("UICatalogoMonedaController: - Metodo: getMonedas -- **inicio**");
		List<Tgm042MonedaMx> tgm042MonedaMxs;
		List<MonedaDTO> monedaDTOs = new ArrayList<MonedaDTO>();
		Tgm042MonedaMx tgm042MonedaMx;
		tgm042MonedaMx = new Tgm042MonedaMx();
		tgm042MonedaMx.setCdMoneda(-1L);
		try {
			// catalogoMonedaBean = new CatalogoMonedaBean();
			tgm042MonedaMxs = catalogoMonedaBean
					.obtenerTodosTgm042MonedaMx(tgm042MonedaMx);
			MonedaDTO monedaDTO;
			for (Tgm042MonedaMx tgm042MonedaMxFE : tgm042MonedaMxs) {
				monedaDTO = new MonedaDTO();
				monedaDTO.setCdMoneda(tgm042MonedaMxFE.getCdMoneda());
				monedaDTO.setNbMoneda(tgm042MonedaMxFE.getNbMoneda());
				monedaDTOs.add(monedaDTO);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			return monedaDTOs;
		}
	}

	public void setCatalogoMonedaBean(ICatalogoMoneda catalogoMonedaBean) {
		this.catalogoMonedaBean = catalogoMonedaBean;
	}
}
