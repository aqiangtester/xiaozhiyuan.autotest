package cn.com.digiwin.justsharecloud.testCases.companyRegister.cases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import cn.com.digiwin.justsharecloud.commonfunctions.HttpRequestMethod;
import cn.com.digiwin.justsharecloud.commonfunctions.JDBCMySQL;
import cn.com.digiwin.justsharecloud.constants.Constants;
import cn.com.digiwin.justsharecloud.dataProvider.CompanyRegisterDataProvider;
import cn.com.digiwin.justsharecloud.initialization.Login;
import cn.com.digiwin.justsharecloud.testCases.companyRegister.bean.JsonParseBean;
import cn.com.digiwin.justsharecloud.testCases.companyRegister.requestParams.RequestParams;

/**
 * @date 2016年6月20日下午3:59:34
 * @author 田亚强
 * @description 测试注册接口 , 包括注册成功和注册失败的测试用例
 */
public class TestCompanyRegister {

	private static Logger logger = Logger.getLogger(TestCompanyRegister.class);
	private static String url = Constants.LOCAL_TEST_HOST + Constants.COMPANYREGISTER_LOCATION;

	/**
	 * @date 2016年6月20日下午3:58:39
	 * @param data
	 * @return_type void
	 * @description 注册成功的测试用例
	 */
	@Test(dataProvider = "success", dataProviderClass = CompanyRegisterDataProvider.class, enabled = true)
	public void testCompantRegisterSuccess(String dataSource, String sourceSystem, String mobile , String companyName, String contactPerson,
			int memberId, String token, String secretNumber , String expectRetCode ,int expectBusiness_type) {

		String requestParams = RequestParams.requestParams(dataSource, sourceSystem, mobile, companyName, contactPerson, memberId, token, secretNumber);
		logger.info(requestParams);

		// 发送请求,获得响应数据
		String response = HttpRequestMethod.sendPost(url, requestParams);
		logger.info(response);

		// 断言返回的数据不为Null
		JsonParseBean jpb = JsonParseBean.ResponseParse(response);
		Assert.assertNotNull(jpb.getRetMsg());
		Assert.assertNotNull(jpb.getRetCode());
		Assert.assertNotNull(jpb.getCompanyId());
		Assert.assertNotNull(jpb.getCompanyCode());
		logger.info("所有返回参数不为空");

		// 断言retCode的值为01130
		Assert.assertEquals(jpb.getRetCode(), expectRetCode);
		String sql = "select * from t_member where id=(select member_id from t_authentication where account='tonytian' limit 1)";
		Assert.assertEquals(JDBCMySQL.query(sql), expectBusiness_type);
		logger.info("测试用例: " + "测试用例" + " , 通过");

		System.out.println("");
	}
	
	@AfterMethod
	public void afterMethod(){
		logger.info(Login.login());
	}
}
