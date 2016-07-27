package cn.com.digiwin.justsharecloud.dataProvider;

import org.testng.annotations.DataProvider;

import cn.com.digiwin.justsharecloud.commonfunctions.ParamsParseInt;
import cn.com.digiwin.justsharecloud.initialization.JsonParseBean;
import cn.com.digiwin.justsharecloud.initialization.Login;

public class CompanyRegisterDataProvider extends Login {

	private static JsonParseBean jpb = login();
	private static String token = jpb.getToken();
	private static String secretNumber = jpb.getSecretNumber();
	private static String memberIdResponse = jpb.getMemberInfo().getMemberId();
	private static int memberId = ParamsParseInt.paramsParseInt(memberIdResponse);

	/**
	 * @date 2016年6月24日上午11:20:14
	 * @return
	 * @return_type Object[][]
	 * @description 注册完之后立刻调用getAccountStatus接口 , token与secretNumber使用体验账号的 ,
	 *              验证未激活
	 */
	@DataProvider(name = "success")
	public static Object[][] Success() {
		return new Object[][] { {"1","1","18520820075" , "CHINA" ,"TIANYAQIANG" , memberId ,token , secretNumber, "01160" , 1} };
	}
}
