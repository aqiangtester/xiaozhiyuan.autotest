package cn.com.digiwin.justsharecloud.dataProvider;

import org.testng.annotations.DataProvider;

public class RegisterDataProvider {

	/**
	 * @return_type Iterator<Object[]>
	 * @description 注册成功的测试数据
	 */
	@DataProvider(name = "testRegisterSuccess")
	public static Object[][] data() {
		return new Object[][]{
			{"18520820075" , "tiantony" , "" , "tian123" , "tonytian" , "" , 1 , 1 , "tian123" , "" , "" , "" , "01130"},
			{"18520820075" , "tiantony" , "" , "tian123" , "tonytian" , "" , 2 , 1 , "tian123" , "" , "" , "" , "01130"},
			{"18520820075" , "tiantony" , "" , "tian123" , "tonytian" , "" , 3 , 1 , "tian123" , "" , "" , "" , "01130"},
			{"18520820075" , "tiantony" , "" , "tian123" , "tonytian" , "" , 1 , 2 , "tian123" , "" , "" , "" , "01130"},
			{"18520820075" , "tiantony" , "" , "tian123" , "tonytian" , "" , 1 , 3 , "tian123" , "" , "android" , "" , "01130"},
			{"18520820075" , "tiantony" , "" , "tian123" , "tonytian" , "" , 1 , 4 , "tian123" , "" , "ios" , "" , "01130"}
		};
	}

	/**
	 * @return_type Iterator<Object[]>
	 * @description 注册失败的测试用例 , 各入参的必填性校验,包括密码的2次确认 ,
	 *              其中未测试dataSource和sourceSystem的必填性
	 */
	@DataProvider(name = "testRegisterFail")
	public static Object[][] failData() {
		return new Object[][]{
			{"" , "tiantony" , "" , "tian123" , "tonytian" , "" , 1 , 1 , "tian123" , "" , "" , "" , "01131"},
			{"18520820075" , "" , "" , "tian123" , "tonytian" , "" , 1 , 1 , "tian123" , "" , "" , "" , "01131"},
			{"18520820075" , "tiantony" , "" , "" , "tonytian" , "" , 1 , 1 , "tian123" , "" , "" , "" , "01131"},
			{"18520820075" , "tiantony" , "" , "tian123" , "" , "" , 1 , 1 , "tian123" , "" , "" , "" , "01131"},
			{"18520820075" , "tiantony" , "" , "tian123" , "tonytian" , "" , 1 , 1 , "" , "" , "" , "" , "01131"},
			{"18520820075" , "tiantony" , "" , "tian123" , "tonytian" , "" , 1 , 1 , "tian321" , "" , "" , "" , "01134"}
		};
	}

	/**
	 * @return_type Object[][]
	 * @description TODO 补充注册失败的测试用例 , 测试dataSource和sourceSystem的必填性
	 */
	@DataProvider(name = "sourceSystemData")
	public static Object[][] sourceSystemData() {
		return new Object[][] {
				{ "18520820075", "tiantony", "", "tian123", "tonytian", "", 1, "tian123", "", "", "", "01131" } };
	}

	@DataProvider(name = "dataSourceData")
	public static Object[][] dataSourceData() {
		return new Object[][] {
				{ "18520820075", "tiantony", "", "tian123", "tonytian", "", 1, "tian123", "", "", "", "01131" } };
	}

	/**
	 * @return_type Object[][]
	 * @description 测试重复注册同一个account
	 */
	@DataProvider(name = "repeatRegisterData")
	public static Object[][] repeatRegisterData() {
		return new Object[][] {
				{ "18520820075", "tiantony", "", "tian123", "tonytian", "", 1, 1, "tian123", "", "", "", "01137" } };
	}
}
