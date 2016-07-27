package cn.com.digiwin.justsharecloud.dataProvider;

import org.testng.annotations.DataProvider;
import cn.com.digiwin.justsharecloud.initialization.Login;

public class GetLoginStatusDataProvider extends Login{
	
	/**
	 * @date 2016年6月24日上午11:20:14
	 * @return
	 * @return_type Object[][]
	 * @description 提供正确的登录账号数据 , 测试用例调用登录接口获取响应的token , 再去调用getTokenList接口
	 */
	@DataProvider(name = "testGetLoginStatusSuccess")
	public static Object[][] successData(){
		return new Object[][]{
			{login().getToken() ,login().getSecretNumber() , "01220"}
		};
	}
	
	
	
	/**
	 * @date 2016年6月24日上午11:56:07
	 * @return
	 * @return_type Object[][]
	 * @description 异常测试 , 1.传入空字符串		2.传入错误格式的token		
	 */
	@DataProvider(name = "testGetLoginStatusFail")
	public static Object[][] failData(){
		return new Object[][]{
			{"sudfhuhf2343" ,login().getSecretNumber() , "01221"},
			{login().getToken() , "34654gfdgdt" , "01221"},
			{"" , login().getSecretNumber(), "01223"},								//1.传入空字符串	retCode=01223 "参数为空"
			{login().getToken(), "" , "01223"},						//2.传入错误格式的token		retCode=01232 "该token失效"
		};
	}
}
