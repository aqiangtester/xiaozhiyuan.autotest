package cn.com.digiwin.justsharecloud.dataProvider;

import org.testng.annotations.DataProvider;

public class SendSmsDataProvider {

	/**
	 * @date 2016年6月24日上午11:20:14
	 * @return
	 * @return_type Object[][]
	 * @description 注册完之后立刻调用getAccountStatus接口 , token与secretNumber使用体验账号的 ,
	 *              验证未激活
	 */
	@DataProvider(name = "all")
	public static Object[][] All() {
		String[] mobile = new String[] { "18520820075", "13691665946" };
		String[] mobile1 = new String[] { "18520820075", "13691" };
		String[] mobile2 = new String[] { "18520820075", "13691665946" };
		
		
		String[] content = new String[]{
				"【即享短信】田亞強，您好！您的夥伴夏睦軍在即享雲平臺上對您發起了邀約，請登錄即享雲平臺及時處理http://172.31.10.168:8080",
				"【即享短信】田亚强，您好！您的伙伴夏睦军在即享云平台上对您发起了邀约，请登录即享云平台及时处理http://172.31.10.168:8080",
				"【即享短信】田亞強，您好！您的夥伴夏睦軍邀請您開通即享賬號，請點擊下面的安全鏈接直接開通http://172.31.10.168:8080",
				"【即享短信】田亚强，您好！您的伙伴夏睦军邀请您开通即享账号，请点击下面的安全链接直接开通http://172.31.10.168:8080",
				"",
				"",
				"",
				"",
				"",
		};
		
		
		return new Object[][] {
			{ "","用户系统", "用户系统发送短信号码组测试", mobile, "0" },
			{"version-0.1","用户系统","用户系统发送短信号码组测试",mobile,"0"},
			{"","","用户系统发送短信号码组测试",mobile,"02611"},
			{"" , "用户系统","" ,mobile,"02611"},
			{"" , "用户系统","用户系统发送短信号码组测试" ,"","02611"},
			{"version-0.1","用户系统","用户系统发送短信号码组测试",mobile1,"0"},
		};
	}
}
