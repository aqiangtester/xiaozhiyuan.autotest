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
	public static Iterator<Object[]> successData() {
		return (Iterator<Object[]>) new ExcelDataProvider("testLoginSuccess", "testLoginSuccess");
	}

	/**
	 * @return_type Iterator<Object[]>
	 * @description 登录失败的测试数据
	 */
	@DataProvider(name = "testLoginFail")
	public static Iterator<Object[]> failData() {
		return (Iterator<Object[]>) new ExcelDataProvider("testLoginFail", "testLoginFail");
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
	
	
	
	
	@DataProvider(name = "pressureTestData")
	public static Iterator<Object[]> data() {
		return (Iterator<Object[]>) new ExcelDataProvider("pressureTestData", "pressureTestData");
	}
}
