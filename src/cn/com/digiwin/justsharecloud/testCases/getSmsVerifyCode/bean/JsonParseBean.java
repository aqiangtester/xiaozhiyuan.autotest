package cn.com.digiwin.justsharecloud.testCases.getSmsVerifyCode.bean;

import com.alibaba.fastjson.JSON;

public class JsonParseBean {
	
	private String retCode;
	private String retMsg;
	
	public String getRetCode() {
		return retCode;
	}
	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}
	public String getRetMsg() {
		return retMsg;
	}
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	
	public static JsonParseBean httpResponseParse(String response) {
		
		//解析JSON响应
		JsonParseBean jpb = JSON.parseObject(response, JsonParseBean.class);
		return jpb;

	}
}
	