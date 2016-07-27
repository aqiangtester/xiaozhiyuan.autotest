package cn.com.digiwin.justsharecloud.testCases.login.bean;

import com.alibaba.fastjson.JSON;

public class JsonParseBean {
	
	private String retCode;
	private String retMsg;
	private String token;
	private String secretNumber;
	private String isDisplayVerifyCode;
	private MemberInfoBean memberInfo;
	
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getSecretNumber() {
		return secretNumber;
	}
	public void setSecretNumber(String secretNumber) {
		this.secretNumber = secretNumber;
	}
	public String getIsDisplayVerifyCode() {
		return isDisplayVerifyCode;
	}
	public void setIsDisplayVerifyCode(String isDisplayVerifyCode) {
		this.isDisplayVerifyCode = isDisplayVerifyCode;
	}
	public MemberInfoBean getMemberInfo() {
		return memberInfo;
	}
	public void setMemberInfo(MemberInfoBean memberInfo) {
		this.memberInfo = memberInfo;
	}

	
	public static class MemberInfoBean{
		
		private String memberId;
		private String nickName;
		private String employeeId;
		private String employeeCode;
		private String employeeName;
		private String companyId;
		private String companyCode;
		private String companyName;
		private String companyAbbr;
		private String hxAccount;
		
		public String getMemberId() {
			return memberId;
		}
		public void setMemberId(String memberId) {
			this.memberId = memberId;
		}
		public String getNickName() {
			return nickName;
		}
		public void setNickName(String nickName) {
			this.nickName = nickName;
		}
		public String getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(String employeeId) {
			this.employeeId = employeeId;
		}
		public String getEmployeeCode() {
			return employeeCode;
		}
		public void setEmployeeCode(String employeeCode) {
			this.employeeCode = employeeCode;
		}
		public String getEmployeeName() {
			return employeeName;
		}
		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}
		public String getCompanyId() {
			return companyId;
		}
		public void setCompanyId(String companyId) {
			this.companyId = companyId;
		}
		public String getCompanyCode() {
			return companyCode;
		}
		public void setCompanyCode(String companyCode) {
			this.companyCode = companyCode;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public String getCompanyAbbr() {
			return companyAbbr;
		}
		public void setCompanyAbbr(String companyAbbr) {
			this.companyAbbr = companyAbbr;
		}
		public String getHxAccount() {
			return hxAccount;
		}
		public void setHxAccount(String hxAccount) {
			this.hxAccount = hxAccount;
		}
	}
	
	public static JsonParseBean httpResponseParse(String response) {

		// 解析JSON响应
		JsonParseBean jpb = JSON.parseObject(response, JsonParseBean.class);
		return jpb;
	}
}
	