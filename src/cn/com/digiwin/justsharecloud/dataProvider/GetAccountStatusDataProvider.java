package cn.com.digiwin.justsharecloud.dataProvider;

import org.testng.annotations.DataProvider;
import cn.com.digiwin.justsharecloud.constants.Constants;
import cn.com.digiwin.justsharecloud.initialization.JsonParseBean;
import cn.com.digiwin.justsharecloud.initialization.Login;

public class GetAccountStatusDataProvider extends Login{
	
	
	private static String const_token = Constants.CONST_TOKEN;
	private static String const_secretNumber = Constants.CONST_SECRETNUMBER;
	
	/**
	 * @date 2016年6月24日上午11:20:14
	 * @return
	 * @return_type Object[][]
	 * @description 注册完之后立刻调用getAccountStatus接口 , token与secretNumber使用体验账号的 , 验证未激活
	 */
	@DataProvider(name = "Inactivated" )
	public static Object[][] Inactivated(){
		return new Object[][]{
			{const_token ,const_secretNumber ,account ,"0"},									//注册完之后直接调用该接口 , "0"代表未激活
		};
	}
	
	
	/**
	 * @date 2016年6月30日下午2:30:32
	 * @return
	 * @return_type Object[][]
	 * @description 测试之前先使用该账号登录一次 , 使用该账号的token与secretNumber , 验证已激活
	 */
	@DataProvider(name = "Activated" )
	public static Object[][] Activated(){
		JsonParseBean jpb = login();
		String token = jpb.getToken();
		String secretNumber = jpb.getSecretNumber();
		
		return new Object[][]{
			{token ,secretNumber ,account ,"01261"}					//注册完之后直接调用该接口 , "01261"代表已激活
		};
	}
	
	
	
	
	/**
	 * @date 2016年6月24日上午11:56:07
	 * @return
	 * @return_type Object[][]
	 * @description 异常测试 	
	 */
	@DataProvider(name = "fail")
	public static Object[][] failData(){
		JsonParseBean jpb = login();
		String token = jpb.getToken();
		String secretNumber = jpb.getSecretNumber();
		return new Object[][]{
			{token ,secretNumber ,"rertrdgf8443", "01262"},				//错误的account , 01262:该账号不存在
			{"5467rthftghfgh" , secretNumber ,account, "4"},			//错误的token
			{token , "dsgdrgr54654654",account, "4"},					//错误的secretNumber
			{"" , secretNumber,account, "1"},							//传入空的token
			{token , "",account, "1"},							//传入空的secretNumber
			{token , secretNumber,"", "1"},							//传入空的account
		};
	}
}
