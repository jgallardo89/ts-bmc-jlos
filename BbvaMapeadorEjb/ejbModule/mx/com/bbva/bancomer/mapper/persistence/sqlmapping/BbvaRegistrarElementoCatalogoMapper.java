package mx.com.bbva.bancomer.mapper.persistence.sqlmapping;

import org.apache.ibatis.annotations.Select;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Informacion Confidencial:
 * Este software contiene informacion totalmente confidencial propiedad de Grupo Financiero BBVA Bancomer. 
 * Queda totalmente prohibido su uso o divulgacion en forma parcial o total y solamente podra ser utilizada de acuerdo a los terminos y estatutos 
 * que determine el Grupo Financiero BBVA Bancomer.
 * 
 * Todos los derechos reservados, Mexico 2013.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * DESCRIPCION DEL PROGRAMA:
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * HISTORIAL DE CAMBIOS:
 * 
 * Fecha:		Por:							Razon:         	Version
 * 04-MAY-2013  F. Emmanuel Chavarria Ortiz		Creacion        1.0.0
 *              femmanuel.chavarriao@gmail.com
 *              Consultoria
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
public interface BbvaRegistrarElementoCatalogoMapper 
	{
	/**
	 * 
	 * @return
	 */
	@Select("insert into MAPEADOR.TGM534_ST_OBJETO ( TGM534_ST_OBJETO.CD_ST_OBJETO," +
		                                            "TGM534_ST_OBJETO.CD_ST_CLAVE,"  +
			                                        "TGM534_ST_OBJETO.NB_ST_OBJETO," +
		                                            "TGM534_ST_OBJETO.TX_ST_OBJETO," +
		   	                                        "TGM534_ST_OBJETO.NB_TABLA) "     +
	        "values ( #{bbvaEstatusVO.cdStObjeto}, #{bbvaEstatusVO.cdStClave}, #{bbvaEstatusVO.nbStObjeto}, #{bbvaEstatusVO.txStObjeto}, " +
	                 "#{bbvaEstatusVO.nbTabla})" )
	public java.util.List<mx.com.bbva.bancomer.mapper.persistence.entity.BbvaEstatusVO> createBbvaEstatusVO( );
	}