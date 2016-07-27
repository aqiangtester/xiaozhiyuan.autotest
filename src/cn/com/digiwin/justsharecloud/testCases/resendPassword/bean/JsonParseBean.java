package cn.com.digiwin.justsharecloud.testCases.resendPassword.bean;

import com.alibaba.fastjson.JSON;

public class JsonParseBean {
	
	private String errorCode;
	private String errorMsg;
	
	
	public String getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}


	public String getErrorMsg() {
		return errorMsg;
	}


	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}


	public static JsonParseBean httpResponseParse(String response) {
		
		//解析JSON响应
		JsonParseBean jpb = JSON.parseObject(response, JsonParseBean.class);
		return jpb;

	}
}
	