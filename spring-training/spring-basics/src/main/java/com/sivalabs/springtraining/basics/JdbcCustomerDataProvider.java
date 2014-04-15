/**
 * 
 */
package com.sivalabs.springtraining.basics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

/**
 * @author Siva
 *
 */
public class JdbcCustomerDataProvider implements CustomerDataProvider {
	
	private DataSource dataSource;
	
	public JdbcCustomerDataProvider(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void init() {
		Connection conn=null;
		try {
			conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			String sql = 
					"CREATE TABLE customers (                    "+
					"  cust_id int NOT NULL auto_increment,  	 "+
					"  name varchar(45) NOT NULL,                "+
					"  addr_street varchar(45) NOT NULL,         "+
					"  addr_city varchar(45) NOT NULL,           "+
					"  addr_state varchar(45) NOT NULL,          "+
					"  addr_country varchar(45) NOT NULL,        "+
					"  addr_zipcode varchar(45) NOT NULL,        "+
					"  addr_longitude varchar(45) default NULL,  "+
					"  addr_latitude varchar(45) default NULL,   "+
					"  PRIMARY KEY  (cust_id)                    "+
					")";
			stmt.executeUpdate(sql);
			sql = "insert into customers(name, addr_street, addr_city, addr_state, addr_country, addr_zipcode)"
					+ " values('Siva','KPHB','HYD','AP','IND','500072')";
			stmt.executeUpdate(sql);
			sql = "insert into customers(name, addr_street, addr_city, addr_state, addr_country, addr_zipcode)"
					+ " values('Siva1','KPHB','HYD','AP','IND','500082')";
			stmt.executeUpdate(sql);
			sql = "insert into customers(name, addr_street, addr_city, addr_state, addr_country, addr_zipcode)"
					+ " values('Siva2','KPHB','HYD','AP','IND','500092')";
			stmt.executeUpdate(sql);
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		
	}

	@Override
	public List<Customer> getCustomerData() {
		List<Customer> customers = new ArrayList<>();
		
		Connection conn=null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from customers");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				Customer customer = new Customer();
				customer.setId(rs.getInt("cust_id"));
				customer.setName(rs.getString("name"));
				
				Address address = new Address();
				address.setStreet(rs.getString("addr_street"));
				address.setCity(rs.getString("addr_city"));
				address.setState(rs.getString("addr_state"));
				address.setCountry(rs.getString("addr_country"));
				address.setZipCode(rs.getString("addr_zipcode"));
				address.setLongitude(rs.getString("addr_longitude"));
				address.setLatitude(rs.getString("addr_latitude"));
				customer.setAddress(address);
				
				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return customers;
	}

}
