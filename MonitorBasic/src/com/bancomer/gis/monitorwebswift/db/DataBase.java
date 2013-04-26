package com.bancomer.gis.monitorwebswift.db;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.Logger;
import com.bancomer.gis.monitorwebswift.util.AppLog;

/**
 * @author MFRAGOSO
 */
public class DataBase {
	
	private static Properties queries;
	private static Properties DB;
	private static Connection con; 
	private static Logger log = null;
	static {
		queries = new Properties();
		DB = new Properties();
		log = AppLog.getLog("DataBase");
		try {
			queries.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/bancomer/gis/monitorwebswift/resources/queries.properties"));
			DB.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/bancomer/gis/monitorwebswift/resources/db.properties"));
		} catch (IOException e) {
			log.error("Error al cargar archivos properties: "+e.getMessage());
		}
	}
	
	
	public static Connection getConnection(int switchConnection) throws Exception{
		createConnection(switchConnection);
		return con;
	}
	
	
	private static void createConnection(int switchConnection) throws Exception{
		con=null;

		try {
			switch(switchConnection){
				case 1:
					Class.forName ("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection (DB.getProperty("URL") ,DB.getProperty("userName"), DB.getProperty("password"));
					break;
				case 2: 
					Class.forName ("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection (DB.getProperty("URL") ,DB.getProperty("userNameMonitor"), DB.getProperty("passwordMonitor"));
					break;
				case 3:
					Class.forName ("com.microsoft.jdbc.sqlserver.SQLServerDriver");
					con = DriverManager.getConnection(DB.getProperty("MSSQLSURL") ,DB.getProperty("userNameMSSQLS"), DB.getProperty("passwordMSSQLS"));
					break;
				case 4:
					Class.forName ("com.microsoft.jdbc.sqlserver.SQLServerDriver");
					con = DriverManager.getConnection(DB.getProperty("MSSQLSURLM") ,DB.getProperty("userNameMSSQLSM"), DB.getProperty("passwordMSSQLSM"));
					break;
				case 5:					
					Class.forName ("com.microsoft.jdbc.sqlserver.SQLServerDriver");
					con = DriverManager.getConnection(DB.getProperty("SQLSERVERMONITORWEB"), DB.getProperty("userNameMSSQLMONITORWEB"), DB.getProperty("passwordMSSQLMONITORWEB"));					
					break;										
			}
			
	    } catch (ClassNotFoundException e){
	    	throw new Exception(e.getMessage(),e);
	    } catch (SQLException e) {
	    	throw new Exception(e.getMessage(),e);
		}
	}
	
	public static String getQuery(String key){
		return queries.getProperty(key);
	}
	
	
	@SuppressWarnings("unchecked")
	public static void CloseObject(Object o) throws Exception{
		if(o == null)
			return;
		
			Class clazz = o.getClass();
			Method m;
		
		try {
			if(o instanceof ResultSet ){
				ResultSet oo = (ResultSet)o;
				oo.close();
				oo = null;
			}else if(o instanceof Connection){
				Connection oo = (Connection)o;
				oo.close();
				oo = null;
			}
			else if(o instanceof PreparedStatement){
                PreparedStatement oo = (PreparedStatement)o;
                oo.close();
                oo = null;
			}
			else{
				m = clazz.getMethod("close", new Class[0]);
				m.invoke(o, new Object[0]);
			}
		} catch (SecurityException e) {
			String msg = "SecurityException:" + e.getMessage();
			throw new Exception(msg,e);
		} catch (NoSuchMethodException e) {
			String msg = "NoSuchMethodException:" + e.getMessage();
			throw new Exception(msg,e);
		} catch (IllegalArgumentException e) {
			String msg = "IllegalArgumentException:" + e.getMessage();
			throw new Exception(msg,e);
		} catch (IllegalAccessException e) {
			String msg = "IllegalAccessException:" + e.getMessage();
			throw new Exception(msg,e);
		} catch (InvocationTargetException e) {
			String msg = "InvocationTargetException:" + e.getMessage();
			throw new Exception(msg,e);
		}
	}
	
	public static void closeAll(Object[] objs) throws Exception{
		for(int i = 0; i < objs.length; i++) {
			CloseObject(objs[i]);
		}
	}
	
	public static void closeConnection() throws Exception{
		if(con != null)
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				throw new Exception(e.getMessage(),e);
			}
	}
	
}
