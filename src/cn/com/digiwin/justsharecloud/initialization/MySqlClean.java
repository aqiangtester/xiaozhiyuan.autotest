package cn.com.digiwin.justsharecloud.initialization;

import cn.com.digiwin.justsharecloud.commonfunctions.JDBCMySQL;
import cn.com.digiwin.justsharecloud.constants.Constants;

public class MySqlClean {
	public void mySqlDelete() {
		
		// 删除t_employee表内的数据
		String sql_employee = "delete from t_employee where member_id=(select member_id from t_authentication where account='"
				+ Constants.LOCAL_TEST_ACCOUNT_1 + "')";
		JDBCMySQL.delete(sql_employee);

		// 删除t_member表内的数据
		String sql_member = "delete from t_member WHERE id=(select member_id from t_authentication where account='"
				+ Constants.LOCAL_TEST_ACCOUNT_1 + "')";
		JDBCMySQL.delete(sql_member);

		// 删除t_authentication表内的数据
		String sql_authentication = "delete from t_authentication where account in ('" + Constants.LOCAL_TEST_ACCOUNT_1
				+ "' ,'" + Constants.LOCAL_TEST_ACCOUNT_2 + "')";
		JDBCMySQL.delete(sql_authentication);
	}
}
