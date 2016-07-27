package cn.com.digiwin.justsharecloud.testCases.getLoginStatus.cases;

import org.testng.annotations.Test;
import cn.com.digiwin.justsharecloud.commonfunctions.HttpRequestMethod;
import cn.com.digiwin.justsharecloud.constants.Constants;
import cn.com.digiwin.justsharecloud.dataProvider.GetLoginStatusDataProvider;
import cn.com.digiwin.justsharecloud.testCases.getLoginStatus.bean.JsonParseBean;
import cn.com.digiwin.justsharecloud.testCases.getLoginStatus.requestParams.RequestParams;
import org.testng.annotations.BeforeTest;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestGetLoginStatus{
	
	private static Logger logger = Logger.getLogger(TestGetLoginStatus.class);
	private static String url = Constants.LOCAL_TEST_HOST + Constants.GETLOGINSTATUS_LOCATION;
	
	/**
	 * @date 2016年6月24日下午12:00:01
	 * @param account
	 * @param password
	 * @param dataSource
	 * @param expectedRetCode
	 * @return_type void
	 * @description 成功的测试用例 ,先调用Login接口获取token和secretNumber , 再调用getLoginStatus
	 */
	@Test(dataProvider="testGetLoginStatusSuccess" , dataProviderClass=GetLoginStatusDataProvider.class)
	public void testGetLoginStatusSuccess(String token , String secretNumber ,String expectedRetCode) {
		
		String requestParams = RequestParams.requestParams(token , secretNumber);
		logger.info(requestParams);
		String response = HttpRequestMethod.sendPost(url, requestParams);
		logger.info(response);
		//断言响应retCode和retMsg不为空
		JsonParseBean jpb = JsonParseBean.httpResponseParse(response);
		Assert.assertNotNull(jpb.getRetMsg());
		Assert.assertNotNull(jpb.getRetCode());
		
		//断言响应retCode为01210
		Assert.assertEquals(jpb.getRetCode(), expectedRetCode);
	}
	
	
	/**
	 * @date 2016年6月24日下午12:02:19
	 * @param token
	 * @param expectedRetCode
	 * @return_type void
	 * @description 失败的测试用例 , token入参传入空字符串
	 */
	@Test(dataProvider="testGetLoginStatusFail" , dataProviderClass=GetLoginStatusDataProvider.class)
	public void testGetLoginStatusFail (String token ,String secretNumber, String expectedRetCode){
		String requestParams = RequestParams.requestParams(token , secretNumber);
		logger.info(requestParams);
		String response = HttpRequestMethod.sendPost(url, requestParams);
		logger.info(response);
		//断言响应retCode和retMsg不为空		
		JsonParseBean jpb = JsonParseBean.httpResponseParse(response);
		Assert.assertNotNull(jpb.getRetMsg());
		Assert.assertNotNull(jpb.getRetCode());
		//断言响应retCode为01233
		Assert.assertEquals(jpb.getRetCode(), expectedRetCode);
	}
	

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
		
	}

}
