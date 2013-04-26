package com.bancomer.gis.monitorwebswift.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bancomer.gis.monitorwebswift.db.DataBase;

public class GeneralDAO {

	protected Connection con;
	protected PreparedStatement ps;
	protected ResultSet rs;
	protected CallableStatement cs;
	
	public GeneralDAO(int switchConnection) throws Exception {
		createConnection(switchConnection);
	}
	
	/**
	 * Metodo encargado de crear la conexion a la base de datos segun la aplicacion
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 *
	 */
	private void createConnection(int switchConnection) throws Exception{
		con = DataBase.getConnection(switchConnection);
	}
	
	/**
	 * Metodo encargado de cerrar cualquier objeto
	 * @throws Exception 
	 *
	 */
	protected void closeAll(Object[] objs) throws Exception{
		DataBase.closeAll(objs);
	}
	
	
	/**
	 * Metodo encargado de cerrar los objetos PrepareStatement y ResultSet
	 * que son usados para la ejecucion de queries
	 * @throws Exception 
	 *
	 */
	protected void closeObjects() throws Exception{
		try {
			if(rs != null){
				rs.close();
				rs = null;
			}
			if(ps != null){
				ps.close();
				ps = null;
			}
			if(cs != null){
				cs.close();
				cs = null;
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage(),e);
		}
	}
	
	/**
	 * Metodo encargado de cerrar la conexion a la base de datos
	 * @throws Exception 
	 * @throws Exception 
	 *
	 */
	public void closeConnection() throws Exception{
		try {
			con.close();
			con=null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage(),e);
		}
	}
}
