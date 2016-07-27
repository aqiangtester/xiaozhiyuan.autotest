package cn.com.digiwin.justsharecloud.testCases.getTokenList.bean;

import com.alibaba.fastjson.JSON;

public class JsonParseBean {
	
	private String companyName;
	private int memberType;
	private String account;
	private String retCode;
	private int companyId;
	private int memberId;
	private int businessType;
	private String mobile;
	private String fullName;
	private String memberCode;
	private String email;
	private String companyCode;
	private String nickName;
	private String retMsg;
	private String employeeId;
	private String employeeName;
	private String employeeCode;
	private String privateCompList;
	private String publicCompList;
	
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getMemberType() {
		return memberType;
	}
	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getRetCode() {
		return retCode;
	}
	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getBusinessType() {
		return businessType;
	}
	public void setBusinessType(int businessType) {
		this.businessType = businessType;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRetMsg() {
		return retMsg;
	}
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getPrivateCompList() {
		return privateCompList;
	}
	public void setPrivateCompList(String privateCompList) {
		this.privateCompList = privateCompList;
	}
	public String getPublicCompList() {
		return publicCompList;
	}
	public void setPublicCompList(String publicCompList) {
		this.publicCompList = publicCompList;
	}
	
	public static JsonParseBean httpResponseParse(String response) {
		
		//解析JSON响应
		JsonParseBean jpb = JSON.parseObject(response, JsonParseBean.class);
		return jpb;

	}
}
	