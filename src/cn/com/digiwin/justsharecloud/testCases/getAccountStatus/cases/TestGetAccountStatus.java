package cn.com.digiwin.justsharecloud.testCases.getAccountStatus.cases;

import org.testng.annotations.Test;
import cn.com.digiwin.justsharecloud.commonfunctions.HttpRequestMethod;
import cn.com.digiwin.justsharecloud.constants.Constants;
import cn.com.digiwin.justsharecloud.dataProvider.GetAccountStatusDataProvider;
import cn.com.digiwin.justsharecloud.testCases.getAccountStatus.bean.JsonParseBean;
import cn.com.digiwin.justsharecloud.testCases.getAccountStatus.requestParams.RequestParams;
import org.testng.annotations.BeforeTest;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

/**
 * @date 2016年6月30日下午3:26:31
 * @author 田亚强
 * @description 接口说明:注册完从未登录的账号 , 显示为"未激活" ;登录过一次之后显示为"已激活"
 */
public class TestGetAccountStatus {

	private static Logger logger = Logger.getLogger(TestGetAccountStatus.class);
	private static String url = Constants.LOCAL_TEST_HOST + Constants.GETACCOUNTSTATUS_LOCATION;

	/**
	 * @date 2016年6月24日下午12:00:01
	 * @param account
	 * @param password
	 * @param dataSource
	 * @param expectedRetCode
	 * @return_type void
	 * @description 注册完之后立刻调用getAccountStatus接口 , token与secretNumber使用体验账号的 , 验证未激活
	 */
	@Test(dataProvider = "Inactivated", dataProviderClass = GetAccountStatusDataProvider.class , priority=1)
	public void Inactivated(String token, String secretNumber, String account, String expectedRetCode) {

		String requestParams = RequestParams.requestParams(token, secretNumber, account);
		logger.info(requestParams);
		String response = HttpRequestMethod.sendPost(url, requestParams);
		logger.info(response);
		// 断言响应retCode和retMsg不为空
		JsonParseBean jpb = JsonParseBean.httpResponseParse(response);
		Assert.assertNotNull(jpb.getErrorMsg());
		Assert.assertNotNull(jpb.getErrorCode());

		// 断言响应retCode为01210
		Assert.assertEquals(jpb.getErrorCode(), expectedRetCode);
	}

	/**
	 * @date 2016年6月30日下午2:34:39
	 * @param token
	 * @param secretNumber
	 * @param account
	 * @param expectedRetCode
	 * @return_type void
	 * @description 先使用该账号登录一次 , 使用该账号的token与secretNumber , 验证已激活
	 */
	@Test(dataProvider = "Activated", dataProviderClass = GetAccountStatusDataProvider.class , priority=2)
	public void Activated(String token, String secretNumber, String account, String expectedRetCode) {

		String requestParams = RequestParams.requestParams(token, secretNumber, account);
		logger.info(requestParams);
		String response = HttpRequestMethod.sendPost(url, requestParams);
		logger.info(response);
		// 断言响应retCode和retMsg不为空
		JsonParseBean jpb = JsonParseBean.httpResponseParse(response);
		Assert.assertNotNull(jpb.getErrorMsg());
		Assert.assertNotNull(jpb.getErrorCode());

		// 断言响应retCode为01210
		Assert.assertEquals(jpb.getErrorCode(), expectedRetCode);
	}

	/**
	 * @date 2016年6月24日下午12:02:19
	 * @param token
	 * @param expectedRetCode
	 * @return_type void
	 * @description 失败的测试用例 
	 */
	@Test(dataProvider = "fail", dataProviderClass = GetAccountStatusDataProvider.class, enabled = true ,priority=3)
	public void testGetAccountStatusFail(String token, String secretNumber, String account, String expectedRetCode) {
		String requestParams = RequestParams.requestParams(token, secretNumber, account);
		logger.info(requestParams);
		String response = HttpRequestMethod.sendPost(url, requestParams);
		logger.info(response);
		// 断言响应retCode和retMsg不为空
		JsonParseBean jpb = JsonParseBean.httpResponseParse(response);
		Assert.assertNotNull(jpb.getErrorMsg());
		Assert.assertNotNull(jpb.getErrorCode());
		// 断言响应retCode为01233
		Assert.assertEquals(jpb.getErrorCode(), expectedRetCode);
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {

	}

}
