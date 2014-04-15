package com.sivalabs.core.json;

import java.util.ArrayList;
import java.util.List;


public class JSONResponse
{
	private boolean success = true;
	private String errorCode;
	private String errorMsg;
	private Object data;
	
	private List<FieldError> errors = new ArrayList<FieldError>();
	
	public JSONResponse(){ }
	public JSONResponse(Object data){this.data = data;}
	
	public boolean isSuccess() {return success; }
	public String getErrorCode(){return errorCode;}
	public void setErrorCode(String errorCode){this.errorCode = errorCode;}
	public String getErrorMsg(){return errorMsg;}
	public Object getData(){return data;}
	public void setSuccess(boolean success){this.success = success;}
	public void setErrorMsg(String errorMsg){this.errorMsg = errorMsg;}
	public void setData(Object data){this.data = data;}
	public List<FieldError> getErrors(){return errors;}
	public void addErrors(List<FieldError> errors){this.errors.addAll(errors);}
	public void addFieldError(FieldError error){this.errors.add(error);	}
	public void addFieldError(String fieldId, String fieldError)
	{this.errors.add(new FieldError(fieldId, fieldError));}
	
	
}
