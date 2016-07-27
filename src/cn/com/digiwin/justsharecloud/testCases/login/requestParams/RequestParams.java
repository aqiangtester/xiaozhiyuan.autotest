package cn.com.digiwin.justsharecloud.testCases.login.requestParams;

import net.sf.json.JSONObject;

public class RequestParams {
	
	public static String requestParams(String account, String password, int dataSource, String uniqueCode) {

		// 封装JSON请求参数
		JSONObject params = new JSONObject();
		params.put("dataSource", dataSource);
		params.put("password", password);
		params.put("account", account);
		params.put("uniqueCode", uniqueCode);

		// 将JSON请求参数转为String
		String requestParams = params.toString();
		return requestParams;
	}
	
	
	public static String requestParams(String account, String password) {

		// 封装JSON请求参数
		JSONObject params = new JSONObject();
		params.put("password", password);
		params.put("account", account);

		
		// 将JSON请求参数转为String
		String requestParams = params.toString();
		return requestParams;
	}
	
	public static String requestParams(String account, String password , int dataSource) {

		// 封装JSON请求参数
		JSONObject params = new JSONObject();
		params.put("password", password);
		params.put("account", account);
		params.put("dataSource", dataSource);

		
		// 将JSON请求参数转为String
		String requestParams = params.toString();
		return requestParams;
	}
}
