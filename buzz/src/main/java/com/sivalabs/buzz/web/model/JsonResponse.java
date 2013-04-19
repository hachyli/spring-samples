/**
 * 
 */
package com.sivalabs.buzz.web.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Siva
 *
 */
@XmlRootElement
public class JsonResponse {

	private String status;
	
	public JsonResponse() {
	}
	
	public JsonResponse(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
