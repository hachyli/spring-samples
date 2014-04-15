/**
 * 
 */
package com.sivalabs.springtraining;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author Siva
 *
 */
public class UserProfile {
	private int id;
	private String userName;
	private String password;
	private String email;
	private Date dob;
	private Phone phone = new Phone();
	
	private Properties preferences;
	private List<Address> addresses;
	private Map<String, Address> addressMap;
	
	
	public UserProfile(int id, String userName, String password, String email) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public void setPreferences(Properties preferences) {
		this.preferences = preferences;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public void setAddressMap(Map<String, Address> addressMap) {
		this.addressMap = addressMap;
	}
	
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	public Phone getPhone() {
		return phone;
	}

	public Date getDob() {
		return dob;
	}

	public Properties getPreferences() {
		return preferences;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public Map<String, Address> getAddressMap() {
		return addressMap;
	}
	
}
