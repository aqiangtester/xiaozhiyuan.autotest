package cn.com.digiwin.justsharecloud.testCases.getSmsVerifyCode.requestParams;

import net.sf.json.JSONObject;

public class RequestParams {
		
	public static String requestParams(String mobile) {

		// 封装JSON请求参数
		JSONObject params = new JSONObject();
		params.put("mobile", mobile);

		// 将JSON请求参数转为String
		String requestParams = params.toString();
		return requestParams;
	}
}
