/**
 * 
 */
package com.sivalabs.springcart.web.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Siva
 *
 */
@XmlRootElement(name="response")
public class AjaxResponse 
{
	private boolean success = true;
	private String message;
	private List<String> errors = new ArrayList<String>();
	
	public AjaxResponse() {
	}
	public AjaxResponse(boolean success, String message) {
		this.success = success;
		this.message = message;
	}
	
	public AjaxResponse(boolean success, String message, List<String> errors) {
		this.success = success;
		this.message = message;
		this.errors = errors;
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
	
	@XmlElementWrapper(name="errors")
	@XmlElement(name="error")
	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
	
	
}
