package cn.com.digiwin.justsharecloud.commonfunctions;

import org.apache.log4j.Logger;
import cn.com.digiwin.justsharecloud.constants.Constants;

public class RedisDelete {
	
	private static Logger logger = Logger.getLogger(RedisDelete.class);
	private static String url = Constants.LOCAL_TEST_HOST + Constants.LOCAL_TEST_REDISDELETE_LOCATION;
	
	public static void redisDelete(String key){
		String param = "key=" + key;
		String response = HttpRequestMethod.sendGet(url, param);
		logger.info(response);
	}
}
