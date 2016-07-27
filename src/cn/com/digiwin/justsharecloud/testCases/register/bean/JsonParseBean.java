package cn.com.digiwin.justsharecloud.testCases.register.bean;

import com.alibaba.fastjson.JSON;

public class JsonParseBean {
	
	private String retCode;
	private String retMsg;
	private String nickName;
	private String memberId;
	
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
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	
	public static JsonParseBean ResponseParse(String response) {
		//解析JSON响应
		JsonParseBean jpb = JSON.parseObject(response, JsonParseBean.class);
		return jpb;
	}
}
	