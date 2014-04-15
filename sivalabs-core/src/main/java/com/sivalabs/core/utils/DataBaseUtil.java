/**
 * 
 */
package com.sivalabs.core.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author skatam
 *
 */
public class DataBaseUtil
{
	
	public static Connection getDefaultConnection(){
		return getConnection("org.hsqldb.jdbcDriver", "jdbc:hsqldb:TestDB", "sa", "");
	}
	public static Connection getConnection(String driverName, 
											String url, 
											String username, 
											String pwd){
		try {
			Class.forName(driverName);
			return DriverManager.getConnection(url, username, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
