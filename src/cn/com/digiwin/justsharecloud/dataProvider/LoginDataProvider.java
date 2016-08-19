package cn.com.digiwin.justsharecloud.dataProvider;

import java.util.Iterator;
import org.testng.annotations.DataProvider;
import cn.com.digiwin.justsharecloud.commonfunctions.ExcelDataProvider;

public class LoginDataProvider {

	/**
	 * @return_type Iterator<Object[]>
	 * @description 登录成功的测试数据
	 */
	@DataProvider(name = "testLoginSuccess")
	public static Object[][] successData() {
		return new Object[][]{
			{"tonytian" , "tian123" , 1 , "" , "01210"},
			{"tonytian" , "tian123" , 2 , "" , "01210"},
			{"tonytian" , "tian123" , 3 , "android" , "01210"},
			{"tonytian" , "tian123" , 4 , "ios" , "01210"}
		};
	}

	/**
	 * @return_type Iterator<Object[]>
	 * @description 登录失败的测试数据
	 */
	@DataProvider(name = "testLoginFail")
	public static Object[][] failData() {
		return new Object[][]{
			{"" , "tian123" , 1 , "" , "01213"},
			{"tonytian" , "" , 1 , "" , "01213"},
			{"tonytian" , "tian123" , 3 , "" , "01131"},
			{"tonytian" , "tian123" , 4 , "" , "01131"},
			{"yihj454try" , "tian123" , 1 , "" , "01211"},
			{"yihj454try" , "tian123" , 2 , "" , "01211"},
			{"yihj454try" , "tian123" , 3 , "android" , "01211"},
			{"yihj454try" , "tian123" , 3 , "ios" , "01211"},
			{"tonytian" , "yihj454try" , 1 , "" , "01211"},
			{"tonytian" , "yihj454try" , 2 , "" , "01211"},
			{"tonytian" , "yihj454try" , 3 , "android" , "01211"},
			{"tonytian" , "yihj454try" , 4 , "ios" , "01211"}
		};
	}
	
	
	/**
	 * @return_type Object[][]
	 * @description 补充登录失败的测试用例 , 验证dataSource的必填性
	 */
	@DataProvider(name = "dataSourceData")
	public static Object[][] dataSourceData() {
		return new Object[][]{
			{"tonytian" , "tian123" ,"01213"}
		};
	}
	
	@DataProvider(name = "needVerifyData")
	public static Object[][] needVerifyData(){
		return new Object[][]{
			{"tonytia" , "tian123" ,1 , "01211","01213" }
		};
	}
	
	
	@DataProvider(name = "pressureTestData")
	public static Iterator<Object[]> data() {
		return (Iterator<Object[]>) new ExcelDataProvider("pressureTestData", "pressureTestData");
	}
}
