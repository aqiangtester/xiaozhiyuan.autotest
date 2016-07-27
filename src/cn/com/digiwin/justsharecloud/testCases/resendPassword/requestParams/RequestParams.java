package cn.com.digiwin.justsharecloud.testCases.resendPassword.requestParams;

import net.sf.json.JSONObject;

public class RequestParams {

	public static String requestParams(Object account, Object mobile, Object token, Object secretNumber,
			Object emplName, Object companyName) {

		// 封装JSON请求参数
		JSONObject params = new JSONObject();
		params.put("account", account);
		params.put("mobile", mobile);
		params.put("token", token);
		params.put("secretNumber", secretNumber);
		params.put("emplName", emplName);
		params.put("companyName", companyName);

		// 将JSON请求参数转为String
		String requestParams = params.toString();

		return requestParams;
	}
}
