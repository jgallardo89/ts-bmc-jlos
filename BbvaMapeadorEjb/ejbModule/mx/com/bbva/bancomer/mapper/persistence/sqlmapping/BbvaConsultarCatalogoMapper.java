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
 * 03-MAY-2013  F. Emmanuel Chavarria Ortiz		Creacion        1.0.0
 *              femmanuel.chavarriao@gmail.com
 *              Consultoria
 *              
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
public interface BbvaConsultarCatalogoMapper 
	{
	/**
	 * 
	 * @return
	 */
	@Select ( "select TGM501_PANTALLA.CD_PANTALLA cdPantalla,"        +
                     "TGM501_PANTALLA.CD_FK_PANTALLA cdFkPantalla,"   +
                     "TGM501_PANTALLA.NB_PANTALLA nbPantalla,"        +
                     "TGM501_PANTALLA.TX_URL_PANTALLA txUrlPantalla," +
                     "TGM501_PANTALLA.TX_URL_ICON txUrlCon,"          +
                     "TGM501_PANTALLA.NU_ORD_PANTALLA nuOrdPantalla," +
                     "TGM501_PANTALLA.ST_PANTALLA stPantalla,"        +
                     "TGM501_PANTALLA.CD_PERFIL cdPerfil "            +
                  "from MAPEADOR.TGM501_PANTALLA,  MAPEADOR.TGM534_ST_OBJETO, MAPEADOR.TGM509_ST_CLAVE " + 
                  "where TGM501_PANTALLA.ST_PANTALLA = TGM534_ST_OBJETO.CD_ST_OBJETO "                   +
                      "and TGM534_ST_OBJETO.CD_ST_CLAVE = TGM509_ST_CLAVE.CD_ST_CLAVE "                      +
                      "and TGM509_ST_CLAVE.CD_ST_CLAVE  = 1 "                                                +
                      "order by TGM501_PANTALLA.NB_PANTALLA" )
	public java.util.List<mx.com.bbva.bancomer.mapper.persistence.entity.BbvaEstatusVO> readBbvaPantallaVO( );
	/**
	 * 
	 * @return
	 */
	@Select ( "select TGM509_ST_CLAVE.CD_ST_CLAVE cdStClave," +
			         "TGM509_ST_CLAVE.NB_ST_CLAVE "           +
			      "from MAPEADOR.TGM509_ST_CLAVE"             +
			          "order by TGM509_ST_CLAVE.NB_ST_CLAVE" )
	public java.util.List<mx.com.bbva.bancomer.mapper.persistence.entity.BbvaEstatusVO> readBbvaEstatusClaveVO( );
	/**
	 * 
	 * @return
	 */
	@Select("select	TGM534_ST_OBJETO.CD_ST_OBJETO cdStObjeto," +
		           "TGM534_ST_OBJETO.CD_ST_CLAVE  cdStClave,"  +
			       "TGM534_ST_OBJETO.NB_ST_OBJETO nbStObjeto," +
		           "TGM534_ST_OBJETO.TX_ST_OBJETO txStObjeto," +
// FIXME:  java.sql.SQLException: Fallo al convertir a representación interna. SQL state [99999]; error code [17059].
//		   	       "TGM534_ST_OBJETO.NB_TABLA     nbTabla,"    +
	               "TGM509_ST_CLAVE.NB_ST_CLAVE   nbStClave "  +
	            "from MAPEADOR.TGM534_ST_OBJETO, MAPEADOR.TGM509_ST_CLAVE, MAPEADOR.TGM501_PANTALLA " +
                "where TGM534_ST_OBJETO.CD_ST_CLAVE = TGM509_ST_CLAVE.CD_ST_CLAVE "                   +
                    "and TGM501_PANTALLA.ST_PANTALLA    = TGM534_ST_OBJETO.CD_ST_OBJETO ")
//	            "order by BY TGM534_ST_OBJETO.NB_TABLA" )
	public java.util.List<mx.com.bbva.bancomer.mapper.persistence.entity.BbvaEstatusVO> readBbvaEstatusVO( );
	/**
	 * 
	 * @return
	 */
	@Select("select	TGM534_ST_OBJETO.CD_ST_OBJETO cdStObjeto," +
		           "TGM534_ST_OBJETO.CD_ST_CLAVE  cdStClave,"  +
			       "TGM534_ST_OBJETO.NB_ST_OBJETO nbStObjeto," +
		           "TGM534_ST_OBJETO.TX_ST_OBJETO txStObjeto," +
// FIXME:  java.sql.SQLException: Fallo al convertir a representación interna. SQL state [99999]; error code [17059].
//		   	       "TGM534_ST_OBJETO.NB_TABLA     nbTabla,"    +
	               "TGM509_ST_CLAVE.NB_ST_CLAVE   nbStClave "  +
	            "from MAPEADOR.TGM534_ST_OBJETO, MAPEADOR.TGM509_ST_CLAVE, MAPEADOR.TGM501_PANTALLA " +
                "where TGM534_ST_OBJETO.CD_ST_CLAVE     = TGM509_ST_CLAVE.CD_ST_CLAVE "                   +
                    "and TGM501_PANTALLA.ST_PANTALLA    = TGM534_ST_OBJETO.CD_ST_OBJETO "				  +
                    "and TGM501_PANTALLA.CD_PANTALLA    = #{bbvaEstatusVO.cdStObjeto} "                   +
                    "and TGM534_ST_OBJETO.NB_ST_OBJETO  like #{bbvaEstatusVO.nbStObjeto} "                +
                    "and TGM534_ST_OBJETO.TX_ST_OBJETO  like #{bbvaEstatusVO.txStObjeto} "                )
//	            "order by BY TGM534_ST_OBJETO.NB_TABLA" )
	public java.util.List<mx.com.bbva.bancomer.mapper.persistence.entity.BbvaEstatusVO> 
				readByEstatusPantallaBbvaEstatusVO( final mx.com.bbva.bancomer.mapper.persistence.entity.BbvaEstatusVO bbvaEstatusVO );
	/**
	 * 
	 * @return
	 */
	@Select("select	TGM534_ST_OBJETO.CD_ST_OBJETO cdStObjeto," +
		           "TGM534_ST_OBJETO.CD_ST_CLAVE  cdStClave,"  +
			       "TGM534_ST_OBJETO.NB_ST_OBJETO nbStObjeto," +
		           "TGM534_ST_OBJETO.TX_ST_OBJETO txStObjeto," +
// FIXME:  java.sql.SQLException: Fallo al convertir a representación interna. SQL state [99999]; error code [17059].
//		   	       "TGM534_ST_OBJETO.NB_TABLA     nbTabla,"    +
	               "TGM509_ST_CLAVE.NB_ST_CLAVE   nbStClave "  +
	            "from MAPEADOR.TGM534_ST_OBJETO, MAPEADOR.TGM509_ST_CLAVE, MAPEADOR.TGM501_PANTALLA " +
                "where TGM534_ST_OBJETO.CD_ST_CLAVE     = TGM509_ST_CLAVE.CD_ST_CLAVE "                   +
                    "and TGM501_PANTALLA.ST_PANTALLA    = TGM534_ST_OBJETO.CD_ST_OBJETO "				  +
                    "and TGM534_ST_OBJETO.NB_ST_OBJETO  like #{bbvaEstatusVO.nbStObjeto} "                +
                    "and TGM534_ST_OBJETO.TX_ST_OBJETO  like #{bbvaEstatusVO.txStObjeto} "                +
                    "and TGM534_ST_OBJETO.CD_ST_CLAVE   = #{bbvaEstatusVO.cdStClave} " )
//	            "order by BY TGM534_ST_OBJETO.NB_TABLA" )
	public java.util.List<mx.com.bbva.bancomer.mapper.persistence.entity.BbvaEstatusVO> 
				readByEstatusClaveBbvaEstatusVO( final mx.com.bbva.bancomer.mapper.persistence.entity.BbvaEstatusVO bbvaEstatusVO );
	/**
	 * 
	 * @return
	 */
	@Select("select	TGM534_ST_OBJETO.CD_ST_OBJETO cdStObjeto," +
		           "TGM534_ST_OBJETO.CD_ST_CLAVE  cdStClave,"  +
			       "TGM534_ST_OBJETO.NB_ST_OBJETO nbStObjeto," +
		           "TGM534_ST_OBJETO.TX_ST_OBJETO txStObjeto," +
// FIXME:  java.sql.SQLException: Fallo al convertir a representación interna. SQL state [99999]; error code [17059].
//		   	       "TGM534_ST_OBJETO.NB_TABLA     nbTabla,"    +
	               "TGM509_ST_CLAVE.NB_ST_CLAVE   nbStClave "  +
	            "from MAPEADOR.TGM534_ST_OBJETO, MAPEADOR.TGM509_ST_CLAVE, MAPEADOR.TGM501_PANTALLA " +
                "where TGM534_ST_OBJETO.CD_ST_CLAVE     = TGM509_ST_CLAVE.CD_ST_CLAVE "                   +
                    "and TGM501_PANTALLA.ST_PANTALLA    = TGM534_ST_OBJETO.CD_ST_OBJETO "				  +
                    "and TGM501_PANTALLA.CD_PANTALLA    = #{bbvaEstatusVO.cdStObjeto} "                   +
                    "and TGM534_ST_OBJETO.NB_ST_OBJETO  like #{bbvaEstatusVO.nbStObjeto} "                +
                    "and TGM534_ST_OBJETO.TX_ST_OBJETO  like #{bbvaEstatusVO.txStObjeto} "                +
                    "and TGM534_ST_OBJETO.CD_ST_CLAVE   = #{bbvaEstatusVO.cdStClave} " )
//	            "order by BY TGM534_ST_OBJETO.NB_TABLA" )
	public java.util.List<mx.com.bbva.bancomer.mapper.persistence.entity.BbvaEstatusVO> 
				readByEstatusPantallaClaveBbvaEstatusVO( final mx.com.bbva.bancomer.mapper.persistence.entity.BbvaEstatusVO bbvaEstatusVO );
	/**
	 * 
	 * @return
	 */
	@Select("select	TGM504_PERFIL.CD_PERFIL	cdPerfil," +
			       "TGM504_PERFIL.NB_PERFIL nbPerfil," 	+
				   "TGM504_PERFIL.TX_PERFIL txPerfil," +
			       "TGM504_PERFIL.ST_PERFIL stPerfil " +
			    "from MAPEADOR.TGM504_PERFIL order by TGM504_PERFIL.CD_PERFIL" )
	public java.util.List<mx.com.bbva.bancomer.mapper.persistence.entity.BbvaPerfilVO> readBbvaPerfilVO	( );
	/**
	 * 
	 * @return
	 */
	@Select("select	TGM503_USUARIO.CD_USUARIO 		cdUsuario," +
			       "TGM503_USUARIO.CD_CVE_USUARIO  	cdCveUsuario," 	+
				   "TGM503_USUARIO.NB_USUARIO 		nbUsuario," +
			       "TGM503_USUARIO.TX_PASSWORD_USR 	txPasswordUsr," +
			       "TGM503_USUARIO.TM_ALTA  		tmAlta," 	+
				   "TGM503_USUARIO.TM_MODIFICACION 	tmModificacion, " +
			       "TGM503_USUARIO.FH_USUARIO 		fhUsuario," +
			       "TGM503_USUARIO.TM_CAMBIO_PWS  	tmCambioPws," 	+
				   "TGM503_USUARIO.ST_USUARIO 		stUsuario, " +
			       "TGM503_USUARIO.CD_PERFIL 		cdPerfil " +
			    "from MAPEADOR.TGM503_USUARIO order by TGM503_USUARIO.CD_ST_OBJETO" )
	public java.util.List<mx.com.bbva.bancomer.mapper.persistence.entity.BbvaEstatusVO> readBbvaUsuarioVO( );
	}