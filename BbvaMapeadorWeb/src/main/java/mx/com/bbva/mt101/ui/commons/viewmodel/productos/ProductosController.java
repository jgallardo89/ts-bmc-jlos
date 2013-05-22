package mx.com.bbva.mt101.ui.commons.viewmodel.productos;

import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;

import mx.com.bbva.bancomer.bussinnes.model.vo.FlujoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.ProductoVO;
import mx.com.bbva.bancomer.bussinnes.model.vo.EstatusObjetoVO;
import mx.com.bbva.bancomer.commons.command.CommandConstants;
import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;
import mx.com.bbva.bancomer.estatusobjeto.dto.EstatusObjetoDTO;
import mx.com.bbva.bancomer.mapper.business.FlujoBO;
import mx.com.bbva.bancomer.mapper.business.ProductoBO;
import mx.com.bbva.bancomer.mapper.business.EstatusObjetoBO;
import mx.com.bbva.bancomer.producto.dto.ProductoDTO;
import mx.com.bbva.bancomer.utils.StringUtil;
import mx.com.bbva.mapeador.ui.commons.controller.IController;
import mx.com.bbva.mapeador.ui.commons.viewmodel.support.ControllerSupport;

public class ProductosController extends ControllerSupport implements IController  {

	private static final long serialVersionUID = 4844657161922105877L;
	@Wire
	private Textbox idProducto;
	@Wire
	private Textbox idFlujo;
	@Wire
	private Textbox idEstatusObjeto;
	@Wire
	private Textbox nombreProducto;
	@Wire
	private Textbox descripcionProducto;
	@Wire
	private Combobox estatusObjeto;
	@Wire
	private Combobox flujo;
	
	private ProductoDTO productoDTO;
	private List<ProductoVO> productoVOs;
	private List<FlujoVO> flujoVOs;
	
	public ProductosController() {
		this.read();
		this.productoVOs = productoDTO.getProductoVOs();
	}
	
	@Override
	public Object read() {
		productoDTO = new ProductoDTO();
		EstatusObjetoDTO estatusObjetoDTO = new EstatusObjetoDTO();
		estatusObjetoDTO.setCommandId(CommandConstants.ESTATUS_OBJETO);
		EstatusObjetoVO estatusObjetoVO = new EstatusObjetoVO();
		estatusObjetoVO.setNombreTabla(CommandConstants.NOMBRE_TABLA_PRODUCTOS);		
		EstatusObjetoBO estatusObjetoBO = new EstatusObjetoBO();
		estatusObjetoDTO.setEstatusObjetoVO(estatusObjetoVO);
		estatusObjetoDTO = estatusObjetoBO.readCommand(estatusObjetoDTO);
		productoDTO.setEstatusObjetoVOs(estatusObjetoDTO.getEstatusObjetoVOs());
	    
	    FlujoBO flujoBO = new FlujoBO();
	    flujoVOs = flujoBO.readCommand();
	    
		ProductoBO productoBO = new ProductoBO();
		productoBO.readCommand(productoDTO);
		return productoDTO;
	}
	
	@Command
	@NotifyChange({ "productoVOs" })
	public void readWithFilters() {
		productoDTO = new ProductoDTO();
		ProductoVO productoVO = new ProductoVO();
		productoVO.setIdFlujo(Integer.parseInt(idFlujo.getValue().isEmpty()?"0":idFlujo.getValue()));
		productoVO.setNombreProducto(StringUtil.validaLike(nombreProducto.getValue()));
		productoVO.setDescripcionProducto(StringUtil.validaLike(descripcionProducto.getValue()));
		productoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
		productoDTO.setProductoVO(productoVO);
		productoVO.toString();
	
		ProductoBO productoBO = new ProductoBO();
		productoVOs = productoBO.readCommand(productoDTO).getProductoVOs();
	}
	
	@Override
	public Object read(Object t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@Command
	@NotifyChange({ "productoVOs" })
	public void save() {
		ProductoBO productoBO = new ProductoBO();
		boolean errorGuardar = false;
		if (estatusObjeto.getSelectedItem() == null
				|| estatusObjeto.getSelectedItem().getValue() == null
				|| estatusObjeto.getSelectedItem().getValue().toString().isEmpty()) {
			estatusObjeto.setErrorMessage("Favor de seleccionar el Estatus");
			errorGuardar = true;
		}
		if (flujo.getSelectedItem() == null
				|| flujo.getSelectedItem().getValue() == null
				|| flujo.getSelectedItem().getValue().toString().isEmpty()) {
			flujo.setErrorMessage("Favor de seleccionar el Flujo");
			errorGuardar = true;
		}
		if (nombreProducto.getValue().isEmpty()) {
			nombreProducto
					.setErrorMessage("Favor de introducir el nombre del Producto");
			errorGuardar = true;
		}
		if (descripcionProducto.getValue().isEmpty()) {
			descripcionProducto
					.setErrorMessage("Favor de introducir la descripción del Producto");
			errorGuardar = true;
		}
		if(!errorGuardar){
			if(idProducto.getValue().isEmpty()){
				ProductoDTO productoDTO = new ProductoDTO();
				ProductoVO productoVO = new ProductoVO();
				productoVO.setNombreProducto(nombreProducto.getValue().toUpperCase());
				productoVO.setDescripcionProducto(descripcionProducto.getValue().toUpperCase());
				productoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
				productoVO.setIdFlujo(Integer.parseInt(idFlujo.getValue()));
				productoDTO.setProductoVO(productoVO);
				productoBO.createCommand(productoDTO);
				productoDTO.toString(BbvaAbstractDataTransferObject.XML);
				clean();
				productoVO.setIdFlujo(Integer.parseInt(idFlujo.getValue().isEmpty()?"0":idFlujo.getValue()));
				productoVO.setNombreProducto(StringUtil.validaLike(nombreProducto.getValue()));
				productoVO.setDescripcionProducto(StringUtil.validaLike(descripcionProducto.getValue()));
				productoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
				productoVO.toString();
				productoDTO.setProductoVO(productoVO);
				productoVOs = productoBO.readCommand(productoDTO).getProductoVOs();
			} else {
				ProductoDTO productoDTO = new ProductoDTO();
				ProductoVO productoVO = new ProductoVO();
				productoVO.setNombreProducto(nombreProducto.getValue().toUpperCase());
				productoVO.setDescripcionProducto(descripcionProducto.getValue().toUpperCase());
				productoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue()));
				productoVO.setIdFlujo(Integer.parseInt(idFlujo.getValue()));
				productoVO.setIdProducto(Integer.parseInt(idProducto.getValue()));
				productoDTO.setProductoVO(productoVO);
				productoBO.updateCommand(productoDTO);
				productoDTO.toString(BbvaAbstractDataTransferObject.XML);
				clean();
				productoVO.setIdFlujo(Integer.parseInt(idFlujo.getValue().isEmpty()?"0":idFlujo.getValue()));
				productoVO.setNombreProducto(StringUtil.validaLike(nombreProducto.getValue()));
				productoVO.setDescripcionProducto(StringUtil.validaLike(descripcionProducto.getValue()));
				productoVO.setIdEstatusObjeto(Integer.parseInt(idEstatusObjeto.getValue().isEmpty()?"0":idEstatusObjeto.getValue()));
				productoVO.toString();
				productoDTO.setProductoVO(productoVO);
				productoVOs = productoBO.readCommand(productoDTO).getProductoVOs();
			}
		}
	}
	
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	@Override
	@Command
	public void clean() {
		nombreProducto.clearErrorMessage();
		descripcionProducto.clearErrorMessage();
		estatusObjeto.clearErrorMessage();
		flujo.clearErrorMessage();

		idProducto.setValue(null);
		idFlujo.setValue(null);
		idEstatusObjeto.setValue(null);
		nombreProducto.setValue(null);
		descripcionProducto.setValue(null);
		estatusObjeto.setValue(null);
		flujo.setValue(null);	
	}
	
	@Command
	public void readSelected(@BindingParam("idProducto") final ProductoVO productoVO){
		productoVO.toString();
		idProducto.setValue(Integer.toString(productoVO.getIdProducto()));
		idFlujo.setValue(Integer.toString(productoVO.getIdFlujo()));
		nombreProducto.setValue(productoVO.getNombreProducto());
		descripcionProducto.setValue(productoVO.getDescripcionProducto());
		idEstatusObjeto.setValue(Integer.toString(productoVO.getIdEstatusObjeto()));
		flujo.setValue(productoVO.getNombreFlujo());
		estatusObjeto.setValue(productoVO.getNombreEstatusObjeto());
	}

	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
    }

	/**
	 * @return the productoDTO
	 */
	public ProductoDTO getProductoDTO() {
		return productoDTO;
	}

	/**
	 * @param productoDTO the productoDTO to set
	 */
	public void setProductoDTO(ProductoDTO productoDTO) {
		this.productoDTO = productoDTO;
	}

	/**
	 * @return the productoVOs
	 */
	public List<ProductoVO> getProductoVOs() {
		return productoVOs;
	}

	/**
	 * @param productoVOs the productoVOs to set
	 */
	public void setProductoVOs(List<ProductoVO> productoVOs) {
		this.productoVOs = productoVOs;
	}

	/**
	 * @return the flujoVOs
	 */
	public List<FlujoVO> getFlujoVOs() {
		return flujoVOs;
	}

	/**
	 * @param flujoVOs the flujoVOs to set
	 */
	public void setFlujoVOs(List<FlujoVO> flujoVOs) {
		this.flujoVOs = flujoVOs;
	}
	
}
