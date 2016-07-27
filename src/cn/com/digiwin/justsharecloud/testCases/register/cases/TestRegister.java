package cn.com.digiwin.justsharecloud.testCases.register.cases;

import java.util.Map;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import cn.com.digiwin.justsharecloud.commonfunctions.HttpRequestMethod;
import cn.com.digiwin.justsharecloud.commonfunctions.JDBCMySQL;
import cn.com.digiwin.justsharecloud.commonfunctions.ParamsParseInt;
import cn.com.digiwin.justsharecloud.commonfunctions.ReadExcel;
import cn.com.digiwin.justsharecloud.commonfunctions.RedisDelete;
import cn.com.digiwin.justsharecloud.constants.Constants;
import cn.com.digiwin.justsharecloud.dataProvider.RegisterDataProvider;
import cn.com.digiwin.justsharecloud.initialization.MySqlClean;
import cn.com.digiwin.justsharecloud.initialization.RedisClean;
import cn.com.digiwin.justsharecloud.testCases.register.bean.JsonParseBean;
import cn.com.digiwin.justsharecloud.testCases.register.requestParams.RequestParams;

/**
 * @date 2016年6月20日下午3:59:34
 * @author 田亚强
 * @description 测试注册接口 , 包括注册成功和注册失败的测试用例
 */
public class TestRegister {

	private static Logger logger = Logger.getLogger(TestRegister.class);
	private static String url = Constants.LOCAL_TEST_HOST + Constants.REGISTER_LOCATION;
	MySqlClean msc = new MySqlClean();
	RedisClean rdc = new RedisClean();

	@BeforeSuite
	public void beforeSuite() {

		// 测试Suite开始执行之前 , 先清除数据库内该账号的信息
		msc.mySqlDelete();

		// 测试Suite开始执行之前 , 先清除redis内该账号的信息
		rdc.redisClean();
	}

	/**
	 * @date 2016年6月20日下午3:58:39
	 * @param data
	 * @return_type void
	 * @description 注册成功的测试用例
	 */
	@Test(dataProvider = "testRegisterSuccess", dataProviderClass = RegisterDataProvider.class, priority = 1, groups = {
			"checkintest" }, enabled = true)
	public void testRegisterSuccess(Map<String, String> data) {

		// 读取Excel表测试数据
		ReadExcel.prmap(data);

		String requestParams = RequestParams.requestParams(data.get("mobile"), data.get("nickName"),
				data.get("smsVerifyKey"), data.get("password"), data.get("account"), data.get("verifyKey"),
				ParamsParseInt.paramsParseInt(data.get("sourceSystem")),
				ParamsParseInt.paramsParseInt(data.get("dataSource")), data.get("confirmPasswd"),
				data.get("verifyCode"), data.get("mobileSysVersion"), data.get("mobileModel"));
		logger.info(requestParams);

		// 发送请求,获得响应数据
		String response = HttpRequestMethod.sendPost(url, requestParams);
		logger.info(response);

		// 断言返回的数据不为Null
		JsonParseBean jpb = JsonParseBean.ResponseParse(response);
		Assert.assertNotNull(jpb.getRetMsg());
		Assert.assertNotNull(jpb.getRetCode());
		Assert.assertNotNull(jpb.getMemberId());
		Assert.assertNotNull(jpb.getNickName());
		logger.info("所有返回参数不为空");

		// 断言retCode的值为01130
		Assert.assertEquals(jpb.getRetCode(), data.get("expectRetCode"));
		logger.info("测试用例: " + data.get("测试用例") + " , 通过");

		// 删除t_authentication表内的数据
		String sql_authentication = "delete from t_authentication where member_id=" + jpb.getMemberId();
		JDBCMySQL.delete(sql_authentication);

		// 删除t_member表内的数据
		String sql_member = "delete from t_member where id=" + jpb.getMemberId();
		JDBCMySQL.delete(sql_member);

		// 删除redis内该账号的数据
		RedisDelete.redisDelete(data.get("account"));
		RedisDelete.redisDelete(data.get("mobile"));
		System.out.println("");
	}

	/**
	 * @date 2016年6月20日下午4:01:40
	 * @param data
	 * @return_type void
	 * @description 注册失败的测试用例 , 各入参的必填性校验,以及密码的2次校验 ,
	 *              其中未测试dataSource和sourceSystem的必填性
	 */
	@Test(dataProvider = "testRegisterFail", dataProviderClass = RegisterDataProvider.class, groups = {
			"functest" }, enabled = false)
	public void testRegisterFail(Map<String, String> data) {
		// 读取Excel表测试数据
		ReadExcel.prmap(data);

		String requestParams = RequestParams.requestParams(data.get("mobile"), data.get("nickName"),
				data.get("smsVerifyKey"), data.get("password"), data.get("account"), data.get("verifyKey"),
				ParamsParseInt.paramsParseInt(data.get("sourceSystem")),
				ParamsParseInt.paramsParseInt(data.get("dataSource")), data.get("confirmPasswd"),
				data.get("verifyCode"), data.get("mobileSysVersion"), data.get("mobileModel"));
		logger.info(requestParams);

		// 发送请求,获得响应数据
		String response = HttpRequestMethod.sendPost(url, requestParams);
		logger.info("响应 : " + response);

		// 断言返回的数据不为Null
		JsonParseBean jpb = JsonParseBean.ResponseParse(response);
		Assert.assertNotNull(jpb.getRetMsg());
		Assert.assertNotNull(jpb.getRetCode());

		// 断言retCode
		Assert.assertEquals(jpb.getRetCode(), data.get("expectRetCode"));
	}

	/**
	 * @date 2016年6月20日下午4:43:50
	 * @param url
	 * @param mobile
	 * @param nickName
	 * @param smsVerifyKey
	 * @param password
	 * @param account
	 * @param verifyKey
	 * @param sourceSystem
	 * @param dataSource
	 * @param confirmPasswd
	 * @param verifyCode
	 * @param mobileSysVersion
	 * @param mobileModel
	 * @param expectRetCode
	 * @return_type void
	 * @description 补充注册失败的测试用例 , 测试sourceSystem的必填性
	 */
	@Test(dataProvider = "sourceSystemData", dataProviderClass = RegisterDataProvider.class, groups = {
			"functest" }, enabled = true)
	public void testSourceSystem(String mobile, String nickName, String smsVerifyKey, String password, String account,
			String verifyKey, int dataSource, String confirmPasswd, String verifyCode, String mobileSysVersion,
			String mobileModel, String expectRetCode) {
		// 传入params
		String requestParams = RequestParams.requestParams(mobile, nickName, smsVerifyKey, password, account, verifyKey,
				dataSource, confirmPasswd, verifyCode, mobileSysVersion, mobileModel);
		logger.info(requestParams);

		// 发送请求,获得响应数据
		String response = HttpRequestMethod.sendPost(url, requestParams);
		logger.info("响应 : " + response);

		// 断言返回的数据不为Null
		JsonParseBean jpb = JsonParseBean.ResponseParse(response);
		Assert.assertNotNull(jpb.getRetMsg());
		Assert.assertNotNull(jpb.getRetCode());

		// 断言retCode的值为01131
		Assert.assertEquals(jpb.getRetCode(), expectRetCode);
	}

	/**
	 * @date 2016年6月20日下午11:22:53
	 * @param url
	 * @param mobile
	 * @param nickName
	 * @param smsVerifyKey
	 * @param password
	 * @param account
	 * @param verifyKey
	 * @param sourceSystem
	 * @param confirmPasswd
	 * @param verifyCode
	 * @param mobileSysVersion
	 * @param mobileModel
	 * @param expectRetCode
	 * @return_type void
	 * @description 补充注册失败的测试用例 , 测试dataSource的必填性
	 */
	@Test(dataProvider = "dataSourceData", dataProviderClass = RegisterDataProvider.class, groups = {
			"functest" }, enabled = true)
	public void testDataSource(String mobile, String nickName, String smsVerifyKey, String password, String account,
			String verifyKey, int sourceSystem, String confirmPasswd, String verifyCode, String mobileSysVersion,
			String mobileModel, String expectRetCode) {

		// 传入params
		String requestParams = RequestParams.requestParams(mobile, nickName, smsVerifyKey, password, account, verifyKey,
				sourceSystem, confirmPasswd, verifyCode, mobileSysVersion, mobileModel);
		logger.info(requestParams);

		// 发送请求,获得响应数据
		String response = HttpRequestMethod.sendPost(url, requestParams);
		logger.info("响应 : " + response);

		// 断言返回的数据不为Null
		JsonParseBean jpb = JsonParseBean.ResponseParse(response);
		Assert.assertNotNull(jpb.getRetMsg());
		Assert.assertNotNull(jpb.getRetCode());

		// 断言retCode的值为01131
		Assert.assertEquals(jpb.getRetCode(), expectRetCode);
	}

	/**
	 * @date 2016年6月20日下午6:07:47
	 * @param url
	 * @param mobile
	 * @param nickName
	 * @param smsVerifyKey
	 * @param password
	 * @param account
	 * @param verifyKey
	 * @param sourceSystem
	 * @param dataSource
	 * @param confirmPasswd
	 * @param verifyCode
	 * @param mobileSysVersion
	 * @param mobileModel
	 * @param expectRetCode
	 * @return_type void
	 * @description 测试重复注册同一个账号
	 */
	@Test(dataProvider = "repeatRegisterData", dataProviderClass = RegisterDataProvider.class, priority = 2, enabled = true)
	public void testRepeatRegisterData(String mobile, String nickName, String smsVerifyKey, String password,
			String account, String verifyKey, int sourceSystem, int dataSource, String confirmPasswd, String verifyCode,
			String mobileSysVersion, String mobileModel, String expectRetCode) {

		String responseFirst = null;
		String responseTwice = null;

		// 连续请求2次
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				String requestParams = RequestParams.requestParams(mobile, nickName, smsVerifyKey, password, account,
						verifyKey, sourceSystem, dataSource, confirmPasswd, verifyCode, mobileSysVersion, mobileModel);
				logger.info(requestParams);
				responseFirst = HttpRequestMethod.sendPost(url, requestParams);
			}
			String requestParams = RequestParams.requestParams(mobile, nickName, smsVerifyKey, password, account,
					verifyKey, sourceSystem, dataSource, confirmPasswd, verifyCode, mobileSysVersion, mobileModel);
			logger.info(requestParams);
			responseTwice = HttpRequestMethod.sendPost(url, requestParams);
		}
		logger.info("第一次响应 : " + responseFirst);
		logger.info("第二次响应 : " + responseTwice);

		// JsonParseBean jpbFirst = JsonParseBean.ResponseParse(responseFirst);
		JsonParseBean jpbTwice = JsonParseBean.ResponseParse(responseTwice);

		// 断言返回的数据不为Null
		Assert.assertNotNull(jpbTwice.getRetCode());
		Assert.assertNotNull(jpbTwice.getRetMsg());

		// 断言retCode的值为01131
		Assert.assertEquals(jpbTwice.getRetCode(), expectRetCode);

		System.out.println("");
	}

	@AfterSuite
	public void afterSuite() {
		
		// 测试Suite执行完之后 , 清除数据库内该账号的信息
		msc.mySqlDelete();
                 
		// 测试Suite执行完之后 , 清除redis内该账号的信息
		rdc.redisClean();
	}
}
