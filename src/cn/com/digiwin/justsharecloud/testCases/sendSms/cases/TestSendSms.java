package cn.com.digiwin.justsharecloud.testCases.sendSms.cases;

import org.testng.annotations.Test;
import cn.com.digiwin.justsharecloud.commonfunctions.HttpRequestMethod;
import cn.com.digiwin.justsharecloud.constants.Constants;
import cn.com.digiwin.justsharecloud.dataProvider.SendSmsDataProvider;
import cn.com.digiwin.justsharecloud.testCases.sendSms.bean.JsonParseBean;
import cn.com.digiwin.justsharecloud.testCases.sendSms.requestParams.RequestParams;

import org.apache.log4j.Logger;
import org.testng.Assert;

/**
 * @date 2016年6月30日下午3:26:31
 * @author 田亚强
 * @description 
 */
public class TestSendSms {
 
	private static Logger logger = Logger.getLogger(TestSendSms.class);
	private static String url = Constants.LOCAL_TEST_HOST + Constants.SENDSMS_LOCATION;


	/**
	 * @date 2016年7月1日上午11:51:48
	 * @param mobile
	 * @param expectedRetCode
	 * @return_type void
	 * @description 多用户接收短信
	 */
	
	/*@Test(dataProvider = "all", dataProviderClass = SendSmsDataProvider.class , priority=1)
	public void all(String mobile ,String requestParams , String[] content , String expectedRetCode) {

		String requestParams = RequestParams.requestParams(mobile, requestParams, null, requestParams);
		logger.info(requestParams);
		String response = HttpRequestMethod.sendPost(url, requestParams);
		logger.info(response);
		// 断言响应retCode和retMsg不为空
		JsonParseBean jpb = JsonParseBean.httpResponseParse(response);
		Assert.assertNotNull(jpb.getErrorCode());
		Assert.assertNotNull(jpb.getErrorMsg());

		// 断言响应retCode为01210
		Assert.assertEquals(jpb.getErrorCode(), expectedRetCode);
	}*/
}
