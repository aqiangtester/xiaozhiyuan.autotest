package cn.com.digiwin.justsharecloud.testCases.login.cases;

import org.testng.annotations.Test;

import cn.com.digiwin.justsharecloud.commonfunctions.GetMyIp;
import cn.com.digiwin.justsharecloud.commonfunctions.HttpRequestMethod;
import cn.com.digiwin.justsharecloud.commonfunctions.ParamsParseInt;
import cn.com.digiwin.justsharecloud.commonfunctions.ReadExcel;
import cn.com.digiwin.justsharecloud.commonfunctions.RedisDelete;
import cn.com.digiwin.justsharecloud.constants.Constants;
import cn.com.digiwin.justsharecloud.dataProvider.LoginDataProvider;
import cn.com.digiwin.justsharecloud.testCases.login.bean.JsonParseBean;
import cn.com.digiwin.justsharecloud.testCases.login.requestParams.RequestParams;
import org.testng.annotations.BeforeTest;

import java.util.Map;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestLogin {

	private static Logger logger = Logger.getLogger(TestLogin.class);
	private static String url = Constants.LOCAL_TEST_HOST + Constants.LOGIN_LOCATION;
	// private static String url = Constants.AWS_TEST_HOST +
	// Constants.LOGIN_LOCATION;

	
	@BeforeTest
	public void beforeTest() {

	}

	/**
	 * @date 2016年6月21日下午3:57:02
	 * @param data
	 * @return_type void
	 * @description 测试登录成功
	 */
	@Test(dataProvider = "testLoginSuccess", dataProviderClass = LoginDataProvider.class, groups = {
			"checkintest" }, enabled = true , priority = 1)
	public void testLoginSuccess(String account, String password, int dataSource, String uniqueCode,
			String expectRetCode) {

		// 读取Excel表测试数据
		// ReadExcel.prmap(data);

		String requestParams = RequestParams.requestParams(account, password, dataSource, uniqueCode);
		logger.info(requestParams);

		// 发送请求,获得响应数据
		String response = HttpRequestMethod.sendPost(url, requestParams);
		logger.info(response);

		// 断言返回的数据不为Null
		JsonParseBean jpb = JsonParseBean.httpResponseParse(response);
		Assert.assertNotNull(jpb.getRetCode());
		Assert.assertNotNull(jpb.getRetMsg());
		Assert.assertNotNull(jpb.getToken());
		Assert.assertNotNull(jpb.getSecretNumber());
		Assert.assertNotNull(jpb.getMemberInfo().getMemberId());
		Assert.assertNotNull(jpb.getMemberInfo().getHxAccount());
		logger.info("断言通过 , 返回的数据不为空");
		Assert.assertEquals(jpb.getRetCode(), expectRetCode);
		logger.info("断言通过 , 返回的retCode与预期一致");
	}

	@Test(dataProvider = "testLoginFail", dataProviderClass = LoginDataProvider.class, priority = 4 , enabled = true)
	public void testLoginFail(String account, String password, int dataSource, String uniqueCode,
			String expectRetCode) {

		// 读取Excel表测试数据
//		ReadExcel.prmap(data);

		String requestParams = RequestParams.requestParams(account, password, dataSource, uniqueCode);
		logger.info(requestParams);

		// 发送请求,获得响应数据
		String response = HttpRequestMethod.sendPost(url, requestParams);
		logger.info(response);

		// 断言返回的数据不为Null
		JsonParseBean jpb = JsonParseBean.httpResponseParse(response);
		Assert.assertNotNull(jpb.getRetMsg());
		Assert.assertNotNull(jpb.getRetCode());
		logger.info("断言通过 , 返回的数据不为空");
		Assert.assertEquals(jpb.getRetCode(), expectRetCode);
		logger.info("断言通过 , 返回的retCode与预期一致");
		

		//删除redis内本机登录的ip
		RedisDelete.redisDelete(GetMyIp.getMyIp());
	}

	@Test(dataProvider = "dataSourceData", dataProviderClass = LoginDataProvider.class, priority = 3 , enabled = true)
	public void testDataSource(String account, String password, String expectRetCode) {

		String requestParams = RequestParams.requestParams(account, password);
		logger.info(requestParams);

		// 发送请求,获得响应数据
		String response = HttpRequestMethod.sendPost(url, requestParams);
		logger.info(response);

		// 断言返回的数据不为Null
		JsonParseBean jpb = JsonParseBean.httpResponseParse(response);
		Assert.assertNotNull(jpb.getRetMsg());
		Assert.assertNotNull(jpb.getRetCode());
		logger.info("断言通过 , 返回的数据不为空");
		Assert.assertEquals(jpb.getRetCode(), expectRetCode);
		logger.info("断言通过 , 返回的retCode与预期一致");
		

		//删除redis内本机登录的ip
		RedisDelete.redisDelete(GetMyIp.getMyIp());
	}
	
	@Test(dataProvider = "needVerifyData" , dataProviderClass = LoginDataProvider.class , priority = 2 , enabled = true)
	public void testNeedVerify(String account , String password , int dataSource , String expectRetCode1 , String expectRetCode2){
		
		String requestParams = null;
		String response = null;
		JsonParseBean jpb = null;
		for (int i = 0; i < 3; i++) {
			requestParams = RequestParams.requestParams(account, password , dataSource);
			logger.info(requestParams);
			// 发送请求,获得响应数据
			response = HttpRequestMethod.sendPost(url, requestParams);
			logger.info(response);
			if (i == 2) {
				jpb = JsonParseBean.httpResponseParse(response);
				Assert.assertEquals(jpb.getRetCode(), expectRetCode1);
			}
		}
		requestParams = RequestParams.requestParams(account, password , dataSource);
		logger.info(requestParams);
		// 发送请求,获得响应数据
		response = HttpRequestMethod.sendPost(url, requestParams);
		logger.info(response);
		jpb = JsonParseBean.httpResponseParse(response);
		
		Assert.assertEquals(jpb.getRetCode(), expectRetCode2);
		Assert.assertTrue(jpb.getRetMsg().contains("parameter is nil,verifyKey or verifyCode"));
		
		//删除redis内本机登录的ip
		RedisDelete.redisDelete(GetMyIp.getMyIp());
	}
	
	

	@Test(dataProvider = "pressureTestData", dataProviderClass = LoginDataProvider.class, invocationCount = 160, threadPoolSize = 20, enabled = false)
	public void pressureTest(Map<String, String> data) {

		ReadExcel.prmap(data);
		String requestParams = RequestParams.requestParams(data.get("account"), data.get("password"),
				ParamsParseInt.paramsParseInt(data.get("dataSource")));
		logger.info("requestParams : " + Thread.currentThread().getId() + requestParams);

		String response = HttpRequestMethod.sendPost(url, requestParams);
		logger.info("response :" + Thread.currentThread().getId() + response + data.get("account"));
		JsonParseBean jpb = JsonParseBean.httpResponseParse(response);
		Assert.assertTrue(!(jpb.getRetMsg().contains("DB operate err")));
	}

	@AfterTest
	public void afterTest() {

	}
}
