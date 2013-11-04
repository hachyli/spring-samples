/**
 * 
 */
package com.sivalabs.springcart.rest.model;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Siva
 *
 */
@XmlRootElement(name="response")
public class GenericResponse 
{
	private boolean success = true;
	private String message;
	private List<String> errors = new ArrayList<String>();
	//private Map<String, Object> data = new HashMap<String, Object>();
	
	public GenericResponse() 
	{
	}
	public GenericResponse(boolean success, String message) {
		this.success = success;
		this.message = message;
	}
	public GenericResponse(boolean success, String message, String error) {
		this.success = success;
		this.message = message;
		this.errors.add(error);
	}
	
	public GenericResponse(boolean success, String message, List<String> errors) {
		this.success = success;
		this.message = message;
		this.errors = errors;
	}
	public GenericResponse(boolean success, String message, Map<String, Object> data) {
		this.success = success;
		this.message = message;
		//this.data = data;
	}
	public GenericResponse(boolean success, String message, List<String> errors, Map<String, Object> data) {
		this.success = success;
		this.message = message;
		this.errors = errors;
		//this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	public void addErrorr(String... errors) {
		this.errors.addAll(Arrays.asList(errors));
	}
	/*public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	public void addData(String key, Object object) {
		this.data.put(key, object);
	}
	public Object getData(String key) {
		return this.data.get(key);
	}
	*/
}
