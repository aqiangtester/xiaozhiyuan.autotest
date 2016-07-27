package cn.com.digiwin.justsharecloud.constants;

public class Constants {
	
	
	 /**
	 *Description: 各环境主机地址 
	 */
	public static final String LOCAL_TEST_HOST = "http://172.31.10.168:8080/";
	public static final String AWS_TEST_HOST = "http://54.222.203.245:7200/";
	public static final String PRODUCT_HOST = "http://prod-usersystem-1406087679.cn-north-1.elb.amazonaws.com.cn/";
	
	
	/**
	 * Description: 各环境机器上MySQL信息
	 */
	public static final String LOCAL_TEST_MYSQL_URL = "jdbc:mysql://172.31.10.168:3306/usersystem";
	public static final String LOCAL_TEST_MYSQL_USERNAME = "root";
	public static final String LOCAL_TEST_MYSQL_PASSWORD = "admin";
	
	
	/**
	 *  Description: 本地测试(168机器)redis查询与删除 , 请求参数key
	 */
	public static final String LOCAL_TEST_REDISQUERY_LOCATION = "usersystem/redis/query/v1";					//GET请求
	public static final String LOCAL_TEST_REDISDELETE_LOCATION = "usersystem/redis/delete/v1";				//GET请求
	
	
	/**
	 * Description: 体验账号信息
	 */
	public static final String CONST_ACCOUT = "zhlb2b007";
	public static final String CONST_PASSWORD = "7363a0d0604902af7b70b271a0b96480";
	public static final String CONST_TOKEN = "94ab2ec1ac3c0d159ed8b3297a99b0";
	public static final String CONST_SECRETNUMBER = "c933f9cb96273829d524dcacd91201";
	
	
	
	
	/**
	 * Module：登入
	 * Description: 接口url路径
	 */
//	public static final String USER_REGISTER_LOCATION = "usersystem/register/registerMember/v1";
	public static final String LOGIN_LOCATION = "usersystem/login/memberLogin/v1";
	public static final String GERTOKENLIST_LOCATION = "usersystem/login/getTokenList/v1";
	public static final String GETLOGINSTATUS_LOCATION = "usersystem/login/getLoginStatus/v1";
	public static final String SUBSCRIBE_LOCATION = "usersystem/register/subscribe/v1";
	public static final String CHECKBINDERPCODE_LOCATION = "usersystem/login/checkBindErpCode/v1";
	public static final String CHECKMOBILEINEMPLOYEE_LOCATION = "usersystem/login/checkMobileInEmployee/v1";
	public static final String RESENDPASSWORD_LOCATION = "usersystem/login/resendPassword/v1";
	public static final String BINDERPCODE_LOCATION = "usersystem/login/bindErpCode/v1";
	public static final String BINDMOBILEFIRST_LOCATION = "usersystem/login/bindMobileFirst/v1";
	public static final String GETACCOUNTSTATUS_LOCATION = "usersystem/login/getAccountStatus/v1";
	public static final String GETSMSVERIFYCODE_LOCATION = "usersystem/login/getSmsVerifyCode/v1";
	public static final String SENDSMS_LOCATION = "usersystem/sms/sendSms/v1";
	public static final String GETVERIFYCODE_LOCATION = "usersystem/login/getVerifyCode/v1";
	
	
	/**
	 * Module: 注册企业,注册管理员
	 */
	public static final String COMPANYREGISTER_LOCATION = "usersystem/register/registerCompany/v1";
	
	
	/**
	 * Module: 个人注册
	 */
	public static final String REGISTER_LOCATION = "usersystem/register/registerMember/v1";
	
	
	
	/**
	 * Module：消息配置
	 * Description: 接口url路径
	 */
	public static final String GETMESSAGETYPEBYMEMBER_LOCATION = "usersystem/message_management/getMessageTypeByMember/v1";
	public static final String GETMESSAGETYPE_LOCATION = "usersystem/message_management/getMessageType/v1";
	public static final String SETUPMESSAGETYPE_LOCATION = "usersystem/message_management/setupMessageType/v1";
	
	
	//测试账号信息
	public static final String LOCAL_TEST_ACCOUNT_1 = "tonytian";		
	public static final String LOCAL_TEST_ACCOUNT_2 = "18520820075";		//手机号作为账号
}
