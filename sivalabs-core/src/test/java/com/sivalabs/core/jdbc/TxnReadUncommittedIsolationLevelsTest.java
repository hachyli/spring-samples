package com.sivalabs.core.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sivalabs.core.utils.DataBaseUtil;

public class TxnReadUncommittedIsolationLevelsTest
{
	//Dirty read problem
	public static void main(String[] args) throws Exception
	{
		//final int txnIsolationLevel = Connection.TRANSACTION_NONE;
		final int txnIsolationLevel = Connection.TRANSACTION_READ_UNCOMMITTED;
		//final int txnIsolationLevel = Connection.TRANSACTION_READ_COMMITTED;
		
		JdbcStatementExecutor.initDatabase();
		
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
					System.out.println("Txn1 started...");
					PreparedStatement pstmt1 = conn1.prepareStatement("update employee set salary = salary + 500 where emp_id=1");
					pstmt1.executeUpdate();
					//step3 : update a employee table and set salary = salary +100000 for emp_id=1
					System.out.println("update a employee table and set salary = salary +100000 for emp_id=1");
					//Thread.yield();
					Thread.sleep(50000);
					conn1.rollback();					
					//step5 rollback txn1
					System.out.println("rollback txn1");
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
					System.out.println("Txn2 started ...");
					//step4: Read the salary for emp_id=1 and commit txn2
					//Thread.sleep(100);
					PreparedStatement pstmt1 = conn2.prepareStatement("select salary from employee where emp_id=1");
					ResultSet rs = pstmt1.executeQuery();
					if(rs.next()){
						System.out.println("Salary for emp_id=1 is :"+rs.getDouble(1));
					}
					conn2.commit();
					System.out.println("committed txn2");
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
