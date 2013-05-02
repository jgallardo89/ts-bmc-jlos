package com.bancomer.gis.monitorwebswift.dao;

import static com.bancomer.gis.monitorwebswift.util.Constants.CONTRASENA_USER_INVALIDOS;
import static com.bancomer.gis.monitorwebswift.util.Constants.DIAS_LIMITE_CAMBIO;
import static com.bancomer.gis.monitorwebswift.util.Constants.LOGEO_EXITOSO;
import static com.bancomer.gis.monitorwebswift.util.Constants.PASSWORD_CADUCO;
import static com.bancomer.gis.monitorwebswift.util.Constants.SESIONES_EXCEDIDAS;
import static com.bancomer.gis.monitorwebswift.util.Constants.USUARIO_BLOQUEADO;
import static com.bancomer.gis.monitorwebswift.util.Constants.USUARIO_PAIS_INVALIDO;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.bancomer.gis.monitorwebswift.db.DataBase;
import com.bancomer.gis.monitorwebswift.util.Cryptography;
import com.bancomer.gis.monitorwebswift.vo.Usuario;

public class SecurityDao extends GeneralDAO{
	
	public SecurityDao(int switchConnection) throws Exception {
		super(switchConnection);
	}

	public int login(String userName, String password) throws Exception{
		int activeSessions = -1;
		int maxSessions = -1;
		int tryLogs = -1;
		String userNameDB = null;
		try {
			ps = con.prepareStatement(DataBase.getQuery("getUser"));
			ps.setString(1, userName);
			rs = ps.executeQuery();
			String currentPass = null;
			Date dateLastChange = null;
			if(rs.next()){
				 userNameDB = rs.getString(3);
				 currentPass = rs.getString(4);
				 maxSessions = rs.getInt(10);
				 tryLogs = rs.getInt(11);
				 dateLastChange = rs.getDate(13);
				 activeSessions = rs.getInt(12);
			}
			else{
				ps = con.prepareStatement(DataBase.getQuery("updateLoginTry"));
				ps.setString(1, userName);
				ps.setString(2, userName);
				ps.executeUpdate();
				closeAll(new Object[]{ps});
				 return CONTRASENA_USER_INVALIDOS;
			}
			closeAll(new Object[]{ps,rs});
			if(tryLogs>=3)
				return USUARIO_BLOQUEADO;
			
			if(activeSessions >= maxSessions)
				return SESIONES_EXCEDIDAS;
			
			Cryptography crypter = new Cryptography();
			String checkPassword = crypter.encrypt(password);
			
			if(currentPass.equals(checkPassword) && userName.equals(userNameDB)){
				//Se valida que no haya caducado el password despues de DIAS_LIMITE_CAMBIO en  milisegundos
				Date today = new Date();
				long diasTrancurridos = today.getTime() - dateLastChange.getTime();
				if (diasTrancurridos > DIAS_LIMITE_CAMBIO){
					return PASSWORD_CADUCO;
				}
				else {
					ps = con.prepareStatement(DataBase.getQuery("updateLoginAcces"));
					//ps.setString(1, crypter.encrypt(password));
					ps.setString(1, userName);
					ps.executeQuery();
					closeAll(new Object[]{ps});
									
					ps = con.prepareStatement(DataBase.getQuery("updateActiveConnections"));
					ps.setString(1, userName);
					ps.setString(2, userName);
					ps.executeUpdate();
					closeAll(new Object[]{ps});
					
					//Poner el intento de logeos a cero
					ps = con.prepareStatement(DataBase.getQuery("resetLogAcount"));
					ps.setString(1, userName);
					ps.executeUpdate();
					closeAll(new Object[]{ps});
					return LOGEO_EXITOSO;
				}				
			}
			else{
				ps = con.prepareStatement(DataBase.getQuery("updateLoginTry"));
				ps.setString(1, userName);
				ps.setString(2, userName);
				ps.executeUpdate();
				closeAll(new Object[]{ps});
				return CONTRASENA_USER_INVALIDOS;
				
			}
			
		} catch (Exception e) {
		    e.printStackTrace();
			throw new Exception("Usuario o contraseña inválidos: "+e.getMessage(),e);
		}finally{
			con.commit();
			closeAll(new Object[]{ps,rs,con});
		}
	}
	
	public int loginExterno(String userName, String pais) throws Exception{
		int activeSessions = -1;
		int maxSessions = -1;
		int tryLogs = -1;
		String userNameDB = null;
		String paisUser = null;
		try {
			ps = con.prepareStatement(DataBase.getQuery("getUserXPais"));
			ps.setString(1, userName);
			ps.setString(2, pais);
			rs = ps.executeQuery();
			String currentPass = null;
			Date dateLastChange = null;
			if(rs.next()){
				 userNameDB = rs.getString(3);
				 currentPass = rs.getString(4);
				 maxSessions = rs.getInt(10);
				 tryLogs = rs.getInt(11);
				 dateLastChange = rs.getDate(13);
				 activeSessions = rs.getInt(12);
				 paisUser = rs.getString(19);
			}
			else{
				ps = con.prepareStatement(DataBase.getQuery("updateLoginTry"));
				ps.setString(1, userName);
				ps.setString(2, userName);
				ps.executeUpdate();
				closeAll(new Object[]{ps});
				 return USUARIO_PAIS_INVALIDO;
			}
			closeAll(new Object[]{ps,rs});
			if(tryLogs>=3)
				return USUARIO_BLOQUEADO;
			
			if(activeSessions >= maxSessions)
				return SESIONES_EXCEDIDAS;
						
			
			if(paisUser.equalsIgnoreCase(pais)){
				//Se valida que corresponda el pais
				Date today = new Date();
				long diasTrancurridos = today.getTime() - dateLastChange.getTime();
				if (diasTrancurridos > DIAS_LIMITE_CAMBIO && !userName.toUpperCase().contains("INVITADO")){
					return PASSWORD_CADUCO;
				}
				else {
					ps = con.prepareStatement(DataBase.getQuery("updatePass"));
					ps.setString(1, currentPass);
					ps.setString(2, userName);
					ps.executeQuery();
					closeAll(new Object[]{ps});
									
					ps = con.prepareStatement(DataBase.getQuery("updateActiveConnections"));
					ps.setString(1, userName);
					ps.setString(2, userName);
					ps.executeUpdate();
					closeAll(new Object[]{ps});
					
					//Poner el intento de logeos a cero
					ps = con.prepareStatement(DataBase.getQuery("resetLogAcount"));
					ps.setString(1, userName);
					ps.executeUpdate();
					closeAll(new Object[]{ps});
					return LOGEO_EXITOSO;
				}				
			}
			else{
				ps = con.prepareStatement(DataBase.getQuery("updateLoginTry"));
				ps.setString(1, userName);
				ps.setString(2, userName);
				ps.executeUpdate();
				closeAll(new Object[]{ps});
				return USUARIO_PAIS_INVALIDO;
				
			}
			
		} catch (Exception e) {
			throw new Exception("Usuario o contraseña inválidos: "+e.getMessage(),e);
		}finally{
			con.commit();
			closeAll(new Object[]{ps,rs,con});
		}
	}
	
	public boolean closeSession (String userName) throws Exception{
		boolean success = false;
		CallableStatement cs=null;
		try {
			cs = con.prepareCall("{call SP_GM023_CLOSE_SES(?)}");
			cs.setString(1, userName);
			cs.executeUpdate();
		}
		catch (SQLException e) {
			throw new Exception(e.getMessage()); 
		}finally{
			closeAll(new Object[]{cs,con});
		}
		return success;
	}
	
	public void fillUserData(Usuario user) throws Exception{
		try {
			ps = con.prepareStatement(DataBase.getQuery("getUser"));
			ps.setString(1, user.getCdCveUsuario());
			rs = ps.executeQuery();
			if(rs.next()){
				user.setNuUsuario(rs.getLong(1));
				user.setNuPais(rs.getLong(2));
				user.setCdCveUsuario(rs.getString(3));
				user.setCdContrasenia(rs.getString(4));
				user.setNbNombreUsr(rs.getString(5));
				user.setNbApellPat(rs.getString(6));
				user.setNbApellMat(rs.getString(7));
				user.setNuExtension(rs.getLong(8));
				user.setTxCorreoElectr(rs.getString(9));
				user.setCtConexLimite(rs.getLong(10));
				user.setCtLogeoErroneo(rs.getLong(11));
				user.setCtConexActivas(rs.getLong(12));
				user.setTmCambioContrasen(rs.getDate(13));
				user.setTmUltimoAcceso(rs.getDate(14));
			}
			closeAll(new Object[]{ps,rs});
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			closeAll(new Object[]{ps,rs,con});
		}
	}
	
	public void getLinksByGroups(Usuario user) throws Exception{
		//Recuperamos los grupos a los que pertenece
		ps = con.prepareStatement(DataBase.getQuery("countGroupsByIdUser"));
		ps.setLong(1, user.getNuUsuario());
		rs = ps.executeQuery();
		int countGroups  = -1;
		if(rs.next()){
			countGroups = rs.getInt(1);
		}
		closeAll(new Object[]{ps,rs});
		
		if(countGroups>-1){
			ps = con.prepareStatement(DataBase.getQuery("getGroupsByIdUser"));
			ps.setLong(1, user.getNuUsuario());
			rs = ps.executeQuery();
			String [] groups =new  String[countGroups];
			int i =0 ;
			while(rs.next()){
				groups[i] = rs.getString(1);
				i++;
			}
			closeAll(new Object[]{ps,rs});
			user.setGroups(groups);
		}
		Set set = new HashSet();
		//Despues obtenemos los id's de los links que tiene por grupo
		//Recorremos cada grupo y consultamos para ver a que ligas tiene permiso por grupo
		for(String group: user.getGroups()){
			ps = con.prepareStatement(DataBase.getQuery("getLinksByGroup"));
			ps.setString(1, group);
			rs = ps.executeQuery();
			while(rs.next()){
				set.add(rs.getInt(1));
			}
			closeAll(new Object[]{ps,rs});
		}
		Object [] links = set.toArray();
		int [] intLinks = new int[links.length];
		for(int i =0;i<links.length;i++) 
			intLinks[i] = (Integer)links[i];
		
		Arrays.sort(intLinks);
		user.setLinksByGroup(intLinks);
	}
	
	public int obtenerCdPaisCCR(String pais) throws Exception{
		int cdPaisCCR = 0;
		try {
			ps = con.prepareStatement(DataBase.getQuery("getPaisCdCCR"));
			ps.setString(1, pais);
			rs = ps.executeQuery();
			if(rs.next()){
				cdPaisCCR = rs.getInt(1);
			}
			closeAll(new Object[]{ps,rs});
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			closeAll(new Object[]{ps,rs,con});
		}
		return cdPaisCCR;
	}
	
	public boolean tieneServicioDesbloqueo(long idUser) throws Exception {
		boolean tieneServicio = false;
		try {
			ps = con.prepareStatement(DataBase.getQuery("tieneServicioDesbloqueo"));
			ps.setLong(1, idUser);
			rs = ps.executeQuery();
			if(rs.next()){
				tieneServicio = true;
			}
			closeAll(new Object[]{ps,rs});
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			closeAll(new Object[]{ps,rs,con});
		}
		return tieneServicio;
	}
}
