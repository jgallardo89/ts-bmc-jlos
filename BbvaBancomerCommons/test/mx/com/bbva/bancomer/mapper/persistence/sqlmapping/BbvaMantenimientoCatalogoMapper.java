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
public interface BbvaMantenimientoCatalogoMapper 
	{
	//	Consulta     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//
	/**
	 * 
	 * @return
	 */
	@Select("select	TGM503_USUARIO.CD_USUARIO cdUsuario," + "TGM503_USUARIO.CD_CVE_USUARIO  cdCveUsuario," 	  +
				   "TGM503_USUARIO.NB_USUARIO nbUsuario," + "TGM503_USUARIO.TX_PASSWORD_USR txPasswordUsr,"   +
			       "TGM503_USUARIO.TM_ALTA    tmAlta," 	  + "TGM503_USUARIO.TM_MODIFICACION tmModificacion, " +
			       "TGM503_USUARIO.FH_USUARIO fhUsuario," + "TGM503_USUARIO.TM_CAMBIO_PWS	  tmCambioPws,"   +
			       "TGM503_USUARIO.FH_USUARIO fhUsuario," + "TGM503_USUARIO.NU_INTENTOS 	  nuIntentos, "   + 
			       "TGM503_USUARIO.CD_PERFIL  cdPerfil "  +
			    "from MAPEADOR.TGM503_USUARIO where rownum = 1 order by TGM503_USUARIO.ST_USUARIO" )
	public	mx.com.bbva.bancomer.test.dao.BbvaUsuarioVO 
			readBbvaUsuarioVO( );//
	/**
	 * 
	 * @return
	 */
	@Select("select	TGM503_USUARIO.CD_USUARIO cdUsuario," + "TGM503_USUARIO.CD_CVE_USUARIO  cdCveUsuario," 	  +
				   "TGM503_USUARIO.NB_USUARIO nbUsuario," + "TGM503_USUARIO.TX_PASSWORD_USR txPasswordUsr,"   +
			       "TGM503_USUARIO.TM_ALTA    tmAlta," 	  + "TGM503_USUARIO.TM_MODIFICACION tmModificacion, " +
			       "TGM503_USUARIO.FH_USUARIO fhUsuario," + "TGM503_USUARIO.TM_CAMBIO_PWS	  tmCambioPws,"   +
			       "TGM503_USUARIO.FH_USUARIO fhUsuario," + "TGM503_USUARIO.NU_INTENTOS 	  nuIntentos, "   + 
			       "TGM503_USUARIO.CD_PERFIL  cdPerfil "  +
			    "from MAPEADOR.TGM503_USUARIO order by TGM503_USUARIO.ST_USUARIO" )
	public	java.util.List<mx.com.bbva.bancomer.test.dao.BbvaUsuarioVO> 
			readBbvaUsuarioVOList( );//
	/**
	 * 
	 * @return
	 */
	@Select("select	TGM503_USUARIO.CD_USUARIO cdUsuario," + "TGM503_USUARIO.CD_CVE_USUARIO  cdCveUsuario," 	  +
			       "TGM503_USUARIO.NB_USUARIO nbUsuario," + "TGM503_USUARIO.TX_PASSWORD_USR txPasswordUsr,"   +
		           "TGM503_USUARIO.TM_ALTA    tmAlta," 	  + "TGM503_USUARIO.TM_MODIFICACION tmModificacion, " +
		           "TGM503_USUARIO.FH_USUARIO fhUsuario," + "TGM503_USUARIO.TM_CAMBIO_PWS	tmCambioPws," 	  +
		           "TGM503_USUARIO.FH_USUARIO fhUsuario," + "TGM503_USUARIO.NU_INTENTOS 	nuIntentos, "     + 
		           "TGM503_USUARIO.CD_PERFIL  cdPerfil "  +
			    "from MAPEADOR.TGM503_USUARIO " +
			    "where TGM503_USUARIO.CD_USUARIO      = #{cdUsuario} "    +
			      "and TGM503_USUARIO.CD_CVE_USUARIO  = #{cdCveUsuario} " + "and TGM503_USUARIO.NB_USUARIO      = #{nbUsuario} "    +
			      "and TGM503_USUARIO.TX_PASSWORD_USR = #{txPasswordUsr} " +
			      "and rownum = 1 "+ 
			    "order by TGM503_USUARIO.ST_USUARIO" )
	public	mx.com.bbva.bancomer.test.dao.BbvaUsuarioVO 
			readByAllRequiredBbvaUsuarioVO( final mx.com.bbva.bancomer.test.dao.BbvaUsuarioVO bbvaUsuarioVO );//
	/**
	 * 
	 * @return
	 */
	@Select("select	TGM503_USUARIO.CD_USUARIO cdUsuario," + "TGM503_USUARIO.CD_CVE_USUARIO  cdCveUsuario," 	  +
		           "TGM503_USUARIO.NB_USUARIO nbUsuario," + "TGM503_USUARIO.TX_PASSWORD_USR txPasswordUsr,"   +
	               "TGM503_USUARIO.TM_ALTA    tmAlta," 	  + "TGM503_USUARIO.TM_MODIFICACION tmModificacion, " +
	               "TGM503_USUARIO.FH_USUARIO fhUsuario," + "TGM503_USUARIO.TM_CAMBIO_PWS	tmCambioPws," 	  +
	               "TGM503_USUARIO.FH_USUARIO fhUsuario," + "TGM503_USUARIO.NU_INTENTOS 	nuIntentos, "     + 
	               "TGM503_USUARIO.CD_PERFIL  cdPerfil "  +
		    "from MAPEADOR.TGM503_USUARIO " +
		    "where TGM503_USUARIO.CD_USUARIO      = #{cdUsuario} "    +
		      "or  TGM503_USUARIO.CD_CVE_USUARIO  = #{cdCveUsuario} " + "or  TGM503_USUARIO.NB_USUARIO      = #{nbUsuario} "    +
		      "or  TGM503_USUARIO.TX_PASSWORD_USR = #{txPasswordUsr} "+
		    "order by TGM503_USUARIO.ST_USUARIO" )
	public	java.util.List<mx.com.bbva.bancomer.test.dao.BbvaUsuarioVO> 
			readByAllOptionalBbvaUsuarioVO( final mx.com.bbva.bancomer.test.dao.BbvaUsuarioVO bbvaUsuarioVO );
	//	Registro     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//
	/**
	 * 
	 * @return
	 */
	@Select("insert into MAPEADOR.TGM503_USUARIO (TGM503_USUARIO.CD_USUARIO, " + "TGM503_USUARIO.CD_CVE_USUARIO, "  +
			                                     "TGM503_USUARIO.NB_USUARIO, " + "TGM503_USUARIO.TX_PASSWORD_USR, " +
			                                     "TGM503_USUARIO.TM_ALTA, "    + "TGM503_USUARIO.TM_MODIFICACION, " +
			                                     "TGM503_USUARIO.FH_USUARIO, " + "TGM503_USUARIO.TM_CAMBIO_PWS, "   +
			                                     "TGM503_USUARIO.NU_INTENTOS, "+ "TGM503_USUARIO.ST_USUARIO, "      +
			                                     "TGM503_USUARIO.CD_PERFIL) "  +
			"values( #{cdUsuario}, #{cdCveUsuario},   #{nbUsuario}, #{txPasswordUsr}, " +
			        "#{tmAlta},    #{tmModificacion}, #{fhUsuario}, #{tmCambioPws}, " +
			        "#{nuIntentos},#{stUsuario},      #{cdPerfil})" )
	public	java.lang.Integer 
			createBbvaUsuarioVO( final mx.com.bbva.bancomer.test.dao.BbvaUsuarioVO bbvaUsuarioVO );//
	//	Actualizacion  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//
	/**
	 * 
	 * @return
	 */
	@Select("update MAPEADOR.TGM503_USUARIO set TGM503_USUARIO.CD_CVE_USUARIO = #{cdCveUsuario}, "   +
                                               "TGM503_USUARIO.NB_USUARIO     = #{nbUsuario}, "      + 
                                               "TGM503_USUARIO.TX_PASSWORD_USR= #{txPasswordUsr}, "  +
                                               "TGM503_USUARIO.TM_ALTA        = #{tmAlta}, "         + 
                                               "TGM503_USUARIO.TM_MODIFICACION= #{tmModificacion}, " +
                                               "TGM503_USUARIO.FH_USUARIO     = #{fhUsuario}, "      + 
                                               "TGM503_USUARIO.TM_CAMBIO_PWS  = #{tmCambioPws}, "    +
                                               "TGM503_USUARIO.NU_INTENTOS    = #{nuIntentos}, "     + 
                                               "TGM503_USUARIO.ST_USUARIO     = #{stUsuario}, "      +
                                               "TGM503_USUARIO.CD_PERFIL      = #{cdPerfil} "        +
             "where TGM503_USUARIO.CD_USUARIO = #{cdUsuario}")
	public	java.lang.Integer 
			updateBbvaUsuarioVO( final mx.com.bbva.bancomer.test.dao.BbvaUsuarioVO bbvaUsuarioVO );//
	//	Eliminacion    - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//
	/**
	 * 
	 * @return
	 */
	@Select("delete from MAPEADOR.TGM503_USUARIO where TGM503_USUARIO.CD_USUARIO = #{cdUsuario}" )
	public	java.lang.Integer
			deleteBbvaUsuarioVO( final mx.com.bbva.bancomer.test.dao.BbvaUsuarioVO bbvaUsuarioVO );
	}