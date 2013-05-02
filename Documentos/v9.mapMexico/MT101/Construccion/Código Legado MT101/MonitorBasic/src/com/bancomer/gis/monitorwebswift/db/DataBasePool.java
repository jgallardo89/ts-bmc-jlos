package com.bancomer.gis.monitorwebswift.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataBasePool {
	 private DataSource fuenteDatos = null;
	 String errorInicial = null;

	public Connection createConnection(){
		 Context contextoInicial;
		 Connection con = null;
		try {
			contextoInicial = new InitialContext();
			 Context contexto = (Context) contextoInicial.lookup("java:comp/env");
			 fuenteDatos = (DataSource) contexto.lookup( "jdbc/MonitorWebSwift");
			 con =  fuenteDatos.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return con;
	}
	
	public static void main(String... args){
			new DataBasePool().createConnection();
	}

}
