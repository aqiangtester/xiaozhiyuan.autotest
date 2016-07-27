package cn.com.digiwin.justsharecloud.testCases.sendSms.requestParams;

import net.sf.json.JSONObject;

public class RequestParams {
		
	public static String requestParams(String interfaceVersion, String sourceSystem, String[] mobileArrays ,String content) {

		// 封装JSON请求参数
		JSONObject commonParam = new JSONObject();
		commonParam.put("interfaceVersion", interfaceVersion);					//可选
		commonParam.put("sourceSystem", sourceSystem);
		
		JSONObject params = new JSONObject();
		params.put("commonParam", commonParam);
		params.put("content", content);									//必须，字符长度大于0
		params.put("mobiles", mobileArrays);						//元素个数大于0，元素为字符串

		// 将JSON请求参数转为String
		String requestParams = params.toString();
		return requestParams;
	}
}
