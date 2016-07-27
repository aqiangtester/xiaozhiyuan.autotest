package cn.com.digiwin.justsharecloud.testCases.getTokenList.requestParams;

import net.sf.json.JSONObject;

public class RequestParams {
		
	public static String requestParams(String token) {

		// 封装JSON请求参数
		JSONObject params = new JSONObject();
		params.put("token", token);

		// 将JSON请求参数转为String
		String requestParams = params.toString();

		return requestParams;
	}
}
