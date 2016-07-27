package cn.com.digiwin.justsharecloud.initialization;

import cn.com.digiwin.justsharecloud.commonfunctions.RedisDelete;
import cn.com.digiwin.justsharecloud.constants.Constants;

public class RedisClean {

	public void redisClean() {
		
		// 删除redis内该账号的数据
		RedisDelete.redisDelete(Constants.LOCAL_TEST_ACCOUNT_1);
		RedisDelete.redisDelete(Constants.LOCAL_TEST_ACCOUNT_2);
	}
}
