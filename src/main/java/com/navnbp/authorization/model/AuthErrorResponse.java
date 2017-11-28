package com.navnbp.authorization.model;

public class AuthErrorResponse {

	private String functionAccess;
	private String errMsg;
	
	public AuthErrorResponse() {
		super();
	}
	public String getFunctionAccess() {
		return functionAccess;
	}
	public void setFunctionAccess(String functionAccess) {
		this.functionAccess = functionAccess;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	
}
