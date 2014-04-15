/**
 * 
 */
package com.sivalabs.core.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sivalabs.core.utils.DataBaseUtil;

/**
 * @author skatam
 *
 */
public class JdbcStatementExecutor
{
	public static void main(String[] args) throws Exception
	{
		Connection connection = null;
		initDatabase();
		connection = DataBaseUtil.getDefaultConnection();
		connection.close();
	}
	
	protected static void initDatabase() throws Exception 
	{
		Connection connection = DataBaseUtil.getDefaultConnection();
		System.out.println(connection.getCatalog());
		PreparedStatement pstmt = null;
		//String createEmpTblSql = "create table employee(id integer primary key, name varchar(30))";
		pstmt = connection.prepareStatement("drop table employee");
		pstmt.execute();
		
		pstmt = connection.prepareStatement("create table employee(emp_id integer primary key, name varchar(30), salary double, dept_id integer)");
		pstmt.execute();
		
		pstmt = connection.prepareStatement("insert into employee(emp_id,name,salary,dept_id) values(1,'siva',1000,1)");
		int count = pstmt.executeUpdate();
		System.out.println("inserted "+count+" records");
		
		connection.close();

	}
}
