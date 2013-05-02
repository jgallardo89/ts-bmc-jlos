package com.bancomer.gis.monitorwebswift.dao;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Logger;

import com.bancomer.gis.monitorwebswift.db.DataBase;
import com.bancomer.gis.monitorwebswift.util.Cryptography;
import com.bancomer.gis.monitorwebswift.vo.AltaDesbloqueoVo;

public class AltaDesbloqueoDao extends GeneralDAO {
	
	private AltaDesbloqueoVo altaDesbloqueoVo;
	private Logger log = null;
	private CallableStatement cs;
	private Date dateKey;
	private long userId;
	
	
	/**
	 * CONSTRUCTICON
	 * @param switchConnection
	 * @throws Exception
	 */
	public AltaDesbloqueoDao(int switchConnection) throws Exception {
		super(switchConnection);
	}
		
	/**
	 * verificUsuario, método que verifica si el usuario recibido existe en BD.
	 * @return
	 * @throws Exception 
	 * @throws Exception
	 */
	public boolean existeUsuario(String usuario) throws Exception{
		boolean existeUsuario = false;
		try {
			ps = con.prepareStatement(DataBase.getQuery("getUser"));		
			ps.setString(1, usuario);
			rs = ps.executeQuery();
			if(rs.next()){
				existeUsuario = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(new Object[]{ps,cs,rs,con});
		}
		return existeUsuario;
	}
	
	
	/**
	 * insertarAlta, método que registra en la BD las respuestas encriptadas y las preguntas del usuario
	 * @throws Exception
	 */
	private void insertarAlta() throws Exception{
		
		try {
			con.setAutoCommit(false);
			cs = con.prepareCall(DataBase.getQuery("SP_GM026_INS_DESBLOQ_USER"));
			
			cs.setLong(1, userId);
			cs.setString(2, altaDesbloqueoVo.getPregunta1());
			cs.setString(3, altaDesbloqueoVo.getRespuesta1());
			cs.setString(4, altaDesbloqueoVo.getPregunta2());
			cs.setString(5, altaDesbloqueoVo.getRespuesta2());
			cs.setString(6, altaDesbloqueoVo.getPregunta3());
			cs.setString(7, altaDesbloqueoVo.getRespuesta3());
			cs.execute();
						
			ps = con.prepareStatement(DataBase.getQuery("getDesbloq"));
			ps.setLong(1, userId);
			rs = ps.executeQuery();
			if(rs.next()){
				dateKey = rs.getDate(2);
			}
			
			Cryptography crypter = new Cryptography();
			String checkResp1 		= crypter.encrypt(altaDesbloqueoVo.getRespuesta1());
			String checkResp2 		= crypter.encrypt(altaDesbloqueoVo.getRespuesta2());
			String checkResp3 		= crypter.encrypt(altaDesbloqueoVo.getRespuesta3());
			
			ps = con.prepareStatement(DataBase.getQuery("updateDesbloq"));
			ps.setString(1, checkResp1);
			ps.setString(2, checkResp2);
			ps.setString(3, checkResp3);
			ps.setLong(4, userId);
			ps.execute();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			throw new Exception(e.getMessage());
		} finally {
			con.setAutoCommit(true);
		}
		
	}
	
	

}
