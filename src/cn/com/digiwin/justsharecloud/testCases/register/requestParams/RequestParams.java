package cn.com.digiwin.justsharecloud.testCases.register.requestParams;

import net.sf.json.JSONObject;

public class RequestParams {
	
	
	/*public static String requestParams(Map<String, String> data) {
		JSONObject jsparams = new JSONObject();
		int a = -1;
		for (Map.Entry<String, String> aaa : data.entrySet()) {
			if(aaa.getKey().equals("dataSource")) {
				if(null != aaa.getValue() && !"".equals(aaa.getValue())) {
					a = ParamsParseInt.paramsParseInt(aaa.getValue());
					jsparams.put(aaa.getKey(), a);
					continue;
				}
			}
			jsparams.put(aaa.getKey(), aaa.getValue());
		}
		return jsparams.toString();
	}*/
	
	/*public static String requestParams(Map<String, String> data){
		JSONObject requestParams = new JSONObject();
		for (Map.Entry<String, String> d : data.entrySet()) {
			if (d.getKey().equals("dataSource")) {
				int dataSource = ParamsParseInt.paramsParseInt(d.getValue());
				requestParams.put(d.getKey(), dataSource);
			}else if (d.getKey().equals("sourceSystem")) {
				int sourceSystem = ParamsParseInt.paramsParseInt(d.getValue());
				requestParams.put(d.getKey(), sourceSystem);
			}
			requestParams.put(d.getKey(), d.getValue());
		}
		return requestParams.toString();
	}*/
		
	public static String requestParams(String mobile, String nickName, String smsVerifyKey, String password,
			String account, String verifyKey, int sourceSystem, int dataSource, String confirmPasswd, String verifyCode,
			String mobileSysVersion, String mobileModel) {

		// 封装JSON请求参数
		JSONObject params = new JSONObject();
		params.put("mobile", mobile);
		params.put("nickName", nickName);
		params.put("smsVerifyKey", smsVerifyKey);
		params.put("password", password);
		params.put("account", account);
		params.put("verifyKey", verifyKey);
		params.put("sourceSystem", sourceSystem);
		params.put("dataSource", dataSource);
		params.put("confirmPasswd", confirmPasswd);
		params.put("verifyCode", verifyCode);
		params.put("mobileSysVersion", mobileSysVersion);
		params.put("mobileModel", mobileModel);

		// 将JSON请求参数转为String
		String requestParams = params.toString();

		return requestParams;
	}
	
	public static String requestParams(String mobile, String nickName, String smsVerifyKey, String password,
			String account, String verifyKey, int dataSource, String confirmPasswd, String verifyCode,
			String mobileSysVersion, String mobileModel) {

		// 封装JSON请求参数
		JSONObject params = new JSONObject();
		params.put("mobile", mobile);
		params.put("nickName", nickName);
		params.put("smsVerifyKey", smsVerifyKey);
		params.put("password", password);
		params.put("account", account);
		params.put("verifyKey", verifyKey);
		params.put("dataSource", dataSource);
		params.put("confirmPasswd", confirmPasswd);
		params.put("verifyCode", verifyCode);
		params.put("mobileSysVersion", mobileSysVersion);
		params.put("mobileModel", mobileModel);

		// 将JSON请求参数转为String
		String requestParams = params.toString();

		return requestParams;
	}
	
	public static String requestParam(String mobile, String nickName, String smsVerifyKey, String password,
			String account, String verifyKey, int sourceSystem , String confirmPasswd, String verifyCode,
			String mobileSysVersion, String mobileModel) {

		// 封装JSON请求参数
		JSONObject params = new JSONObject();
		params.put("mobile", mobile);
		params.put("nickName", nickName);
		params.put("smsVerifyKey", smsVerifyKey);
		params.put("password", password);
		params.put("account", account);
		params.put("verifyKey", verifyKey);
		params.put("sourceSystem", sourceSystem);
		params.put("confirmPasswd", confirmPasswd);
		params.put("verifyCode", verifyCode);
		params.put("mobileSysVersion", mobileSysVersion);
		params.put("mobileModel", mobileModel);

		// 将JSON请求参数转为String
		String requestParams = params.toString();

		return requestParams;
	}
}
