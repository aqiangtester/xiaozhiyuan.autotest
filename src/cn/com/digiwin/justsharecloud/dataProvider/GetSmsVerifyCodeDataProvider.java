package cn.com.digiwin.justsharecloud.dataProvider;

import org.testng.annotations.DataProvider;

public class GetSmsVerifyCodeDataProvider{
	
	
	/**
	 * @date 2016年6月24日上午11:20:14
	 * @return
	 * @return_type Object[][]
	 * @description 
	 */
	@DataProvider(name = "all" )
	public static Object[][] All(){
		return new Object[][]{
			{"18520820075"  ,"01250"},									
			{""  ,"01251"},									
			{"185"  ,"01254"}									
		};
	}
}
