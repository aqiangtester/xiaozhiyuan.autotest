package cn.com.digiwin.justsharecloud.testCases.companyRegister.requestParams;

import com.alibaba.fastjson.JSONArray;

import net.sf.json.JSONObject;

public class RequestParams {

	/*
	 * public static String requestParams(Map<String, String> data) { JSONObject
	 * jsparams = new JSONObject(); int a = -1; for (Map.Entry<String, String>
	 * aaa : data.entrySet()) { if(aaa.getKey().equals("dataSource")) { if(null
	 * != aaa.getValue() && !"".equals(aaa.getValue())) { a =
	 * ParamsParseInt.paramsParseInt(aaa.getValue()); jsparams.put(aaa.getKey(),
	 * a); continue; } } jsparams.put(aaa.getKey(), aaa.getValue()); } return
	 * jsparams.toString(); }
	 */

	/*
	 * public static String requestParams(Map<String, String> data){ JSONObject
	 * requestParams = new JSONObject(); for (Map.Entry<String, String> d :
	 * data.entrySet()) { if (d.getKey().equals("dataSource")) { int dataSource
	 * = ParamsParseInt.paramsParseInt(d.getValue());
	 * requestParams.put(d.getKey(), dataSource); }else if
	 * (d.getKey().equals("sourceSystem")) { int sourceSystem =
	 * ParamsParseInt.paramsParseInt(d.getValue());
	 * requestParams.put(d.getKey(), sourceSystem); }
	 * requestParams.put(d.getKey(), d.getValue()); } return
	 * requestParams.toString(); }
	 */

	public static String requestParams(String mobileSysVersion, String mobileModel, String sourcePage,
			String dataSource, String sourceSystem, String interfaceVersion, String fileUrl, String fileKey,
			String fileSize, String fileName, String lineNo1, String mCode, String sName, String sCode, String mName,
			String bCode, String bName, String lineNo2, String address, String countryCode, String districtName,
			String bankCardNo, String countryName, String cityName, String cityCode, String districtCode,
			String provinceName, String provinceCode, String tel, String mobile, int businessPattern, int businessRange,
			int capitalUnit, String email, int endBusinessDate, String legalPerson, String licenseNo, String logoFileId,
			String logoUrl, String mainProducts, String openAccountBank, String organizationCode, int parentId,
			int registeredCapital, int setUpDate, int startBusinessDate, String taxPayerNo, int turnover,
			String companyName, String contactPerson, String companyAbbr, int companyScale, int memberId,
			int companyType, int registeredModel, String token, String secretNumber) {

		JSONObject commonParam = new JSONObject();
		commonParam.put("mobileSysVersion", mobileSysVersion);
		commonParam.put("mobileModel", mobileModel);
		commonParam.put("sourcePage", sourcePage);
		commonParam.put("dataSource", dataSource); // 必填
		commonParam.put("sourceSystem", sourceSystem); // 必填
		commonParam.put("interfaceVersion", interfaceVersion);

		JSONObject fileListObject = new JSONObject();
		fileListObject.put("fileUrl", fileUrl);
		fileListObject.put("fileKey", fileKey);
		fileListObject.put("fileSize", fileSize);
		fileListObject.put("fileName", fileName);
		fileListObject.put("lineNo", lineNo1);

		JSONArray fileList = new JSONArray();
		fileList.add(0, fileListObject);

		JSONObject industryListObject = new JSONObject();
		industryListObject.put("mCode", mCode);
		industryListObject.put("sName", sName);
		industryListObject.put("sCode", sCode);
		industryListObject.put("mName", mName);
		industryListObject.put("bCode", bCode);
		industryListObject.put("bName", bName);
		industryListObject.put("lineNo", lineNo2);

		JSONArray industryList = new JSONArray();
		industryList.add(0, industryListObject);

		JSONObject compInfo = new JSONObject();
		compInfo.put("address", address);
		compInfo.put("countryCode", countryCode);
		compInfo.put("districtName", districtName);
		compInfo.put("bankCardNo", bankCardNo);
		compInfo.put("countryName", countryName);
		compInfo.put("cityName", cityName);
		compInfo.put("cityCode", cityCode);
		compInfo.put("districtCode", districtCode);
		compInfo.put("provinceName", provinceName);
		compInfo.put("provinceCode", provinceCode);
		compInfo.put("tel", tel);
		compInfo.put("mobile", mobile); // 必填
		compInfo.put("businessPattern", businessPattern); // number
		compInfo.put("businessRange", businessRange); // number
		// compInfo.put("capitalUnit", capitalUnit); // number
		compInfo.put("email", email);
		compInfo.put("endBusinessDate", endBusinessDate); // number
		compInfo.put("fileList", fileList);
		compInfo.put("industryList", industryList);
		compInfo.put("legalPerson", legalPerson);
		compInfo.put("licenseNo", licenseNo);
		compInfo.put("logoFileId", logoFileId);
		compInfo.put("logoUrl", logoUrl);
		compInfo.put("mainProducts", mainProducts);
		compInfo.put("openAccountBank", openAccountBank);
		compInfo.put("organizationCode", organizationCode);
		compInfo.put("registeredCapital", registeredCapital); // number
		compInfo.put("setUpDate", setUpDate); // number
		compInfo.put("startBusinessDate", startBusinessDate); // number
		compInfo.put("taxPayerNo", taxPayerNo);
		compInfo.put("turnover", turnover); // number
		compInfo.put("companyName", companyName); // 必填
		compInfo.put("contactPerson", contactPerson); // 必填
		compInfo.put("companyAbbr", companyAbbr);
		compInfo.put("companyScale", companyScale); // number
		compInfo.put("memberId", memberId); // number
		compInfo.put("companyType", companyType); // number
		compInfo.put("registeredModel", registeredModel); // number

		// 封装JSON请求参数
		JSONObject params = new JSONObject();
		params.put("compInfo", compInfo);
		params.put("commonParam", commonParam);
		params.put("token", token);
		params.put("secretNumber", secretNumber);

		// 将JSON请求参数转为String
		String requestParams = params.toString();

		return requestParams;
	}

	public static String requestParams(String dataSource, String sourceSystem, String mobile , String companyName, String contactPerson,
			int memberId, String token, String secretNumber) {

		JSONObject commonParam = new JSONObject();
		commonParam.put("dataSource", dataSource); // 必填
		commonParam.put("sourceSystem", sourceSystem); // 必填

		JSONObject compInfo = new JSONObject();
		compInfo.put("mobile", mobile); // 必填
		compInfo.put("companyName", companyName); // 必填
		compInfo.put("contactPerson", contactPerson); // 必填
		compInfo.put("memberId", memberId); // number

		// 封装JSON请求参数
		JSONObject params = new JSONObject();
		params.put("compInfo", compInfo);
		params.put("commonParam", commonParam);
		params.put("token", token);
		params.put("secretNumber", secretNumber);

		// 将JSON请求参数转为String
		String requestParams = params.toString();

		return requestParams;
	}
}
