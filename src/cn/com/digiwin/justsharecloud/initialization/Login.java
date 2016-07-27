package cn.com.digiwin.justsharecloud.initialization;

import org.apache.log4j.Logger;
import cn.com.digiwin.justsharecloud.commonfunctions.HttpRequestMethod;
import cn.com.digiwin.justsharecloud.constants.Constants;
import net.sf.json.JSONObject;

public class Login {

	private static Logger logger = Logger.getLogger(Login.class);
	private static String url = Constants.LOCAL_TEST_HOST + Constants.LOGIN_LOCATION;
	public static String account = "tonytian";
	private static String password = "tian123";
	private static int dataSource = 1;

	private static String requestParams() {

		JSONObject params = new JSONObject();
		params.put("password", password);
		params.put("account", account);
		params.put("dataSource", dataSource);

		// 将JSON请求参数转为String
		String requestParams = params.toString();
		return requestParams;
	}

	public static JsonParseBean login() {
		String response = HttpRequestMethod.sendPost(url, requestParams());
		logger.info("response : " + response);
		JsonParseBean jpb = JsonParseBean.httpResponseParse(response);
		return jpb;
	}
}
