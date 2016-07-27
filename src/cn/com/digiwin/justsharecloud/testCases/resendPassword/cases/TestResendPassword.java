package cn.com.digiwin.justsharecloud.testCases.resendPassword.cases;

import org.testng.annotations.Test;
import cn.com.digiwin.justsharecloud.commonfunctions.HttpRequestMethod;
import cn.com.digiwin.justsharecloud.constants.Constants;
import cn.com.digiwin.justsharecloud.dataProvider.ResendPasswordDataProvider;
import cn.com.digiwin.justsharecloud.testCases.resendPassword.bean.JsonParseBean;
import cn.com.digiwin.justsharecloud.testCases.resendPassword.requestParams.RequestParams;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class TestResendPassword {
	
	private static Logger logger = Logger.getLogger(TestResendPassword.class);
	private static String url = Constants.LOCAL_TEST_HOST + Constants.RESENDPASSWORD_LOCATION;
	
	/**
	 * @date 2016年6月24日下午12:00:01
	 * @param account
	 * @param password
	 * @param dataSource
	 * @param expectedRetCode
	 * @throws InterruptedException 
	 * @return_type void
	 * @description 
	 */
	@Test(dataProvider="resendPassword" , dataProviderClass=ResendPasswordDataProvider.class)
	public void testResendPassword(Object account, Object mobile, Object token, Object secretNumber,
			Object emplName, Object companyName ,String expectedRetCode) throws InterruptedException {
		Thread.sleep(1000);
		logger.info(emplName);
		logger.info(companyName);
		
		String requestParams = RequestParams.requestParams(account, mobile, token, secretNumber, emplName, companyName);
		logger.info(requestParams);
		String response = HttpRequestMethod.sendPost(url, requestParams);
		logger.info(response);
		//断言响应retCode和retMsg不为空
		JsonParseBean jpb = JsonParseBean.httpResponseParse(response);
		Assert.assertNotNull(jpb.getErrorCode());
		Assert.assertNotNull(jpb.getErrorMsg());
		
		//断言响应retCode为01210
		Assert.assertEquals(jpb.getErrorCode(), expectedRetCode);
	}
}
