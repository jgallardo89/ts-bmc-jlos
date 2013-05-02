package com.bancomer.gis.monitorwebswift.dao;

import com.bancomer.gis.monitorwebswift.db.DataBase;
import com.bancomer.gis.monitorwebswift.util.Cryptography;
import com.bancomer.gis.monitorwebswift.vo.Usuario;

public class CambioContraseniaDao extends GeneralDAO {

	
	/**
	 * Constructicon
	 * @param switchConnection
	 * @throws Exception
	 */
	public CambioContraseniaDao(int switchConnection) throws Exception {
		super(switchConnection);
	}
	
	public void cambioPass(Usuario usuario) throws Exception{
		try {
			Cryptography crypter = new Cryptography();
			String checkPassword = crypter.encrypt(usuario.getCdContrasenia());
			
			//ps = con.prepareStatement(DataBase.getQuery("updatePass"));
			ps = con.prepareStatement(DataBase.getQuery("updateCambioPass"));
			ps.setString(1, checkPassword);
			ps.setString(2, usuario.getCdCveUsuario());
			int updSuccess = ps.executeUpdate();
			usuario.setCtConexActivas(updSuccess);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(new Object[]{ps,con});
		}
		
	}

}
