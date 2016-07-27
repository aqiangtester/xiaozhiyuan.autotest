package cn.com.digiwin.justsharecloud.testCases.companyRegister.bean;

import com.alibaba.fastjson.JSON;

public class JsonParseBean {
	
	private String retCode;
	private String retMsg;
	private int companyId;
	private String companyCode;
	
	
	
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



	public int getCompanyId() {
		return companyId;
	}



	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}



	public String getCompanyCode() {
		return companyCode;
	}



	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}



	public static JsonParseBean ResponseParse(String response) {
		//解析JSON响应
		JsonParseBean jpb = JSON.parseObject(response, JsonParseBean.class);
		return jpb;
	}
}
	