package cn.com.digiwin.justsharecloud.dataProvider;

import java.util.Iterator;
import org.testng.annotations.DataProvider;
import cn.com.digiwin.justsharecloud.commonfunctions.ExcelDataProvider;

public class RegisterDataProvider {

	/**
	 * @return_type Iterator<Object[]>
	 * @description 注册成功的测试数据
	 */
	@DataProvider(name = "testRegisterSuccess")
	public static Iterator<Object[]> data() {
		return (Iterator<Object[]>) new ExcelDataProvider("testRegisterSuccess", "testRegisterSuccess");
	}

	/**
	 * @return_type Iterator<Object[]>
	 * @description 注册失败的测试用例 , 各入参的必填性校验,包括密码的2次确认 ,
	 *              其中未测试dataSource和sourceSystem的必填性
	 */
	@DataProvider(name = "testRegisterFail")
	public static Iterator<Object[]> failData() {
		return (Iterator<Object[]>) new ExcelDataProvider("testRegisterFail", "testRegisterFail");
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
