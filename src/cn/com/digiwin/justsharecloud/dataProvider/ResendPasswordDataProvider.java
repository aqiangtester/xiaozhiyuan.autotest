package cn.com.digiwin.justsharecloud.dataProvider;

import org.testng.annotations.DataProvider;

import cn.com.digiwin.justsharecloud.constants.Constants;
import cn.com.digiwin.justsharecloud.initialization.Login;

public class ResendPasswordDataProvider extends Login{
	
	private static String token = Constants.CONST_TOKEN;
	private static String secretNumber = Constants.CONST_SECRETNUMBER;
	private static String emplName = "Beyond";
	private static String companyName = "maitian";
	
	
	
	/**
	 * @date 2016年6月24日上午11:20:14
	 * @return
	 * @return_type Object[][]
	 * @description 
	 */
	@DataProvider(name = "resendPassword" )
	public static Object[][] resendPassword(){
		return new Object[][]{
			
			//正确的测试用例
			{account ,"18520820075" ,token ,secretNumber, emplName, companyName, "0"},
			
			//验证各参数的必填性
			{"" ,"18520820075" ,token ,secretNumber, emplName, companyName, "1"},
			{account ,"" ,token ,secretNumber, emplName, companyName, "1"},
			{account ,"18520820075" ,"" ,secretNumber, emplName, companyName, "1"},
			{account ,"18520820075" ,token ,"", emplName, companyName, "1"},
			{account ,"18520820075" ,token ,secretNumber, "", companyName, "1"},
			{account ,"18520820075" ,token ,secretNumber, emplName, "", "1"},
			//验证错误的手机号格式
			{account ,"18520" ,token ,secretNumber, emplName, companyName, "5"},
			//不存在的账号
			{"dfuhu87" ,"18520820075" ,token ,secretNumber, emplName, companyName, "01271"},
			//错误的token
			{account ,"18520820075" ,"ty6r76hrehgthd" ,secretNumber, emplName, companyName, "4"},
			//错误的secretNumber
			{account ,"18520820075" ,token ,"46bhgry46y54ydfgds", emplName, companyName, "4"},
		};
	}
}
