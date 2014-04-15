package com.sivalabs.core.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sivalabs.core.utils.DataBaseUtil;

public class TxnSerializableIsolationLevelsTest
{
	//Phantom read problem
	public static void main(String[] args) throws Exception
	{
		//final int txnIsolationLevel = Connection.TRANSACTION_NONE;
		//final int txnIsolationLevel = Connection.TRANSACTION_READ_UNCOMMITTED;
		//final int txnIsolationLevel = Connection.TRANSACTION_READ_COMMITTED;
		//final int txnIsolationLevel = Connection.TRANSACTION_REPEATABLE_READ;
		final int txnIsolationLevel = Connection.TRANSACTION_SERIALIZABLE;
		
		
		Thread t1 = new Thread(new Runnable() {
		
			@Override
			public void run()
			{
				try 
				{
					//step1: Start transaction txn1
					Connection conn1 = DataBaseUtil.getDefaultConnection();
					conn1.setAutoCommit(false);
					conn1.setTransactionIsolation(txnIsolationLevel);
					System.out.println("Started txn1...");
					//step4: Read the salary for emp_id=1 and commit txn2
					PreparedStatement pstmt1 = conn1.prepareStatement("select count(*) from employee where dept_id=1");
					ResultSet rs = pstmt1.executeQuery();
					if(rs.next()){
						System.out.println("No of Employees in dept_id=1 for first time is :"+rs.getInt(1));
					}
					Thread.sleep(1000);
					pstmt1 = conn1.prepareStatement("select count(*) from employee where dept_id=1");
					rs = pstmt1.executeQuery();
					if(rs.next()){
						System.out.println("No of Employees in dept_id=1 for second time is :"+rs.getInt(1));
					}
					conn1.commit();
					System.out.println("committed txn1");
				
					
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run()
			{				
				try 
				{
					//step2: Start transaction txn2
					Connection conn2 = DataBaseUtil.getDefaultConnection();
					conn2.setAutoCommit(false);
					conn2.setTransactionIsolation(txnIsolationLevel);
					System.out.println("Txn2 started...");
					Thread.sleep(100);
					PreparedStatement pstmt2 = conn2.prepareStatement("insert into employee(emp_id,name,salary,dept_id) values(2,'prasad',1000,1)");
					pstmt2.executeUpdate();
					//step3 : insert an employee for dept_id=1
					System.out.println("insert into employee(emp_id,name,salary,dept_id) values(2,'prasad',1000,1)");
					conn2.commit();
					//step5 commit txn2
					System.out.println("commit txn2");
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		t1.start();
		t2.start();
		
	}

}
