package cn.com.digiwin.justsharecloud.testCases.getLoginStatus.requestParams;

import net.sf.json.JSONObject;

public class RequestParams {
		
	public static String requestParams(String token , String secretNumber) {

		// 封装JSON请求参数
		JSONObject params = new JSONObject();
		params.put("token", token);
		params.put("secretNumber", secretNumber);

		// 将JSON请求参数转为String
		String requestParams = params.toString();
		return requestParams;
	}
}
